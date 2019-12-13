package rmi;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        try {
            Caculator caculator = (Caculator) Naming.lookup("rmi://localhost:6789/cal6");
            System.out.println(caculator.add(15, 20));
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
/*
private static final long serialVersionUID = 20151107;
    public int id;
    public String code;
    public String name;
    public float ImportPrice;
    public float ExportPrice;
    public String createdUser;
*/