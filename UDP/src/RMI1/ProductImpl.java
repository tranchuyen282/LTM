package RMI1;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProductImpl extends UnicastRemoteObject implements IProduct{
    private static final long serialVersionUID = 20151107;

    public ProductImpl() throws RemoteException{
        super();
    }
    
    
    @Override
    public Product getProduct(String studentCode) throws RemoteException {
        Product pnew = new Product(1, studentCode, "", 0, 0, "");
        return pnew;
    }

    @Override
    public boolean insertProduct(Product product) throws RemoteException {
        boolean check = true;
        System.out.println(product.getName());
        return check;
    }
    
}
