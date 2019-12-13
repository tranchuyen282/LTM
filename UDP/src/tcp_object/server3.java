package tcp_object;
/*
 * @author Tran Chuyen
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.lang.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class server3 {
    public static void main(String[] args) {
        try {
            Scanner cin = new Scanner(System.in);
            ServerSocket server = new ServerSocket(1107);
            System.out.println("start server");
            while(true){
                Socket se = server.accept();
                System.out.println("receive 1 socket");
                ObjectInputStream in = new ObjectInputStream(se.getInputStream());
                //
                
                String s = (String) in.readObject();
                System.out.println("receiv: "+ s);
                
                // send
                ObjectOutputStream out = new ObjectOutputStream(se.getOutputStream());
                Student s1 = new Student(1, "B16DCCN034", 8, "");
                out.writeObject(s1);
                
                // receive
                s1 = (Student) in.readObject();
                System.out.println(s1.getGpaletter());
                
                se.close();
                
            }
        } catch (IOException ex) {
            Logger.getLogger(server3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(server3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
