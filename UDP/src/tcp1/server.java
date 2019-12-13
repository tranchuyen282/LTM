package tcp1;
/*
 * @author Tran Chuyen
 */

import java.io.DataInputStream;
import java.io.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.lang.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class server {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        try {
            ServerSocket server = new ServerSocket(1107);
            System.out.println("Start server...");
            while(true){
                Socket conn = server.accept();
                DataInputStream datain = new DataInputStream(conn.getInputStream());
                DataOutputStream dataout = new java.io.DataOutputStream(conn.getOutputStream());
                System.out.println(datain.readUTF());
                dataout.writeInt(15);
                dataout.writeInt(20);
                System.out.println(datain.readInt());
                System.out.println(datain.readInt());
                conn.close();
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
