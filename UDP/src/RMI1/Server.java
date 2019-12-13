package RMI1;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] args) {
        try {
            IProduct product = new ProductImpl();
            LocateRegistry.createRegistry(678);
            Naming.rebind("rmi://localhost:678/product", product);
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
