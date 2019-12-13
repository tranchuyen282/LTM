package tcp_object;
/*
 * @author Tran Chuyen
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.lang.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class client3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        try {
            Socket ss = new Socket("localhost", 1107);
            
            ObjectOutputStream out = new ObjectOutputStream(ss.getOutputStream());
            
            // send ma
            String ma = "B16DCN034;911";
            out.writeObject(ma);
            out.flush();
            System.out.println("send server");
            
            // nhan sv
            ObjectInputStream in = new ObjectInputStream(ss.getInputStream());
            Student s = (Student) in.readObject();
            System.out.println(s.getCode());
            s.setGpaletter("A");
            
            // send sv
            out.writeObject(s);
            
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(client3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(client3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
