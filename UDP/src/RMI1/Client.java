package RMI1;
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
            IProduct product = (IProduct) Naming.lookup("rmi://localhost:678/product");
            Product sv = product.getProduct("B16DCCN034");
            sv.setName("chuyen");
            product.insertProduct(sv);
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
