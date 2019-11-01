package server;
/*
 * @author Tran Chuyen
 */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class server {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        byte[] b = new byte[1024];
        try {
            ServerSocket server = new ServerSocket(1107);
            System.out.println("server started ...");
            while(true){
                Socket conn = server.accept();
                BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(conn.getOutputStream()));
               
                
                conn.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
