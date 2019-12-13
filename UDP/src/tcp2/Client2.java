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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        try {
            Socket client = new Socket("localhost", 1107);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            
            out.write("B16DCCN034;911");
            out.newLine();
            out.flush();
            System.out.println("send server");
            
            String s = in.readLine();
            System.out.println(s);
            
            // xu ly xau
            String so = "", chu ="";
            for(int i = 0; i < s.length();i++){
                char x = s.charAt(i);
                if(x >= '0' && x <= '9'){
                    so += String.valueOf(x);
                }else{
                    chu += String.valueOf(x);
                }
            }
            System.out.println(chu + " " + so);
            out.write(so);
            out.newLine();
            out.flush();
            
            out.write(chu);
            out.newLine();
            out.flush();
            
            client.close();
                
        } catch (IOException ex) {
            Logger.getLogger(Client2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
