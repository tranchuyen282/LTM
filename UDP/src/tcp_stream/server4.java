package tcp_stream;
/*
 * @author Tran Chuyen
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.lang.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class server4 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        byte[] a = new byte[1024];
        InputStream in;
        OutputStream out;
        try {
            ServerSocket server = new ServerSocket(1107);
            
            while(true){
                Socket ss = server.accept();
                in = ss.getInputStream();
                in.read(a);
                System.out.println(new String(a).trim());
                
                out = ss.getOutputStream();
                out.write("1,3,9,19,33,20".getBytes());
                out.flush();
                
                a = new byte[1024];
                in.read(a);
                System.out.println(new String(a).trim());
                
                ss.close();
                
            }
        } catch (IOException ex) {
            Logger.getLogger(server4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
