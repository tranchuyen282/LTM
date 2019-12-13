package ex2;
/*
 * @author Tran Chuyen
 */

import ex1.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.lang.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import udp.SinhVien;

public class UDPServer {
    DatagramSocket server;
    DatagramPacket receivePacket, sendPacket;
    int port;
    int bufferSize;
    byte[] receiveData, sendData;
    
    public UDPServer(){
        try {
            bufferSize = 1024;
            port = 1107;
            server = new DatagramSocket(port);
        } catch (SocketException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void listening(){
        while(true){
            try {
                receiveData = new byte[bufferSize];
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                server.receive(receivePacket); 
                String strTemp = new String(receivePacket.getData()).trim();
                System.out.println("client gui len: ");
                
                SinhVien s = new SinhVien(34,"B16DCCN034",new Float(9.5),"");
                ByteArrayOutputStream b = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(b);
                out.writeObject(s);
                out.flush();  
                
                sendData = b.toByteArray();
                sendPacket = new DatagramPacket(sendData, sendData.length
                        ,receivePacket.getSocketAddress());
                server.send(sendPacket);
                System.out.println("Da gui sinh vien");
                
                //nhan lai kq sinh vien tu client
                receiveData = new  byte[bufferSize];
                receivePacket = new DatagramPacket(receiveData, bufferSize);
                server.receive(receivePacket);

                ByteArrayInputStream bin = new ByteArrayInputStream(receiveData);
                ObjectInputStream in = new ObjectInputStream(bin);
                SinhVien s_new = (SinhVien) in.readObject();
                System.out.println("Nhan ve 1 sinh vien: "+ s_new.toString());
                
            } catch (Exception ex) {
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
