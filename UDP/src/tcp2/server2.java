package tcp2;
/*
 * @author Tran Chuyen
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.lang.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class server2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        try {
            ServerSocket server = new ServerSocket(1107);
            while(true){
                Socket ms = server.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(ms.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(ms.getOutputStream()));
                
                String s = in.readLine();
                System.out.println("receive client: " + s);
                
                String send = "ad31njhj33232";
                out.write(send);
                out.newLine();
                out.flush();
                
                System.out.println(in.readLine());
                System.out.println(in.readLine());
                
                
                ms.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(server2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
    }
}
