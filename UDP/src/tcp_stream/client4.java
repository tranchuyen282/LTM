package tcp_stream;
/*
 * @author Tran Chuyen
 */

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.lang.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class client4 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        byte[] b = new byte[1024];
        try {
            Socket client = new Socket("localhost", 1107);
            
            
            OutputStream out = client.getOutputStream();
            
            // send ma
            out.write("B16DCCN034;911".getBytes());
            out.flush();
            
            // nhan byte
            InputStream in = client.getInputStream();
            
            in.read(b);
            
            String s = new String(b).trim();
            System.out.println("server send: "+ new String(b).trim());
            
            out.write("1,2,3".getBytes());
            out.flush();
            
            
            client.close();
            
        } catch (IOException ex) {
            Logger.getLogger(client4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
