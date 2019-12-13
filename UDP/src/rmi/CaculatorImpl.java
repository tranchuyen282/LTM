package rmi;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CaculatorImpl extends UnicastRemoteObject implements Caculator{

    public CaculatorImpl() throws RemoteException{
        super();
    }
    
    @Override
    public int add(int a, int b) throws RemoteException {
        return (a + b);
    }
}
