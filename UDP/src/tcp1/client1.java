package tcp1;
/*
 * @author Tran Chuyen
 */

import java.io.*;
import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class client1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        try {
            Socket client = new Socket("localhost", 1107);
            DataInputStream datain = new DataInputStream(client.getInputStream());
            DataOutputStream dataout = new DataOutputStream(client.getOutputStream());
            dataout.writeUTF("B16DCCN034;911");
            System.out.println("send server");
            int a = datain.readInt();
            int b = datain.readInt();
            System.out.println(a +" " + b);
            int ucln = gcd(a,b);
            int bcnn = a*b/ucln;
            dataout.writeInt(ucln);
            dataout.writeInt(bcnn);
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(client1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int gcd(int a, int b){
        if(b == 0) return a;
        else
            return gcd(b, a%b);
    }
}
