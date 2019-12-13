package udp1;
/*
 * @author Tran Chuyen
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.lang.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import udp.SinhVien;

public class UDPServer {
    DatagramSocket server;
    DatagramPacket sendPacket, receivePacket;
    byte[] sendData, receiveData;
    int port;

    public UDPServer(int port) {
        this.port = port;
        try {
            server = new DatagramSocket(port);
        } catch (SocketException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void listening(){
        while(true){
            /*
                //nhan tu client  
                System.out.println("client gui len:" + receiveString());
                //gui thong diep xuong client
                String td = "123;4,18";
                sendString(td);
                // nhan kq
                System.out.println("ket qua tu client: " + receiveString());
             */
            
            SinhVien sv = receiveObject();
            sv.setGpa(8.0f);
            sendObject(sv);
            sv = receiveObject();
            
        }
    }
    
    public String receiveString(){
        String s = null;   
        try {  
            receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData,receiveData.length);
            server.receive(receivePacket);
            s = new String(receivePacket.getData()).trim();
            
        } catch (IOException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return s;
    }
    
    public void sendString(String td){
        
        try {
            sendData = td.getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length,receivePacket.getSocketAddress());
            server.send(sendPacket);
            System.out.println("done gui " + td);
        } catch (IOException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void sendObject(SinhVien sv){
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(b);
            out.writeObject(sv);
            out.flush();
            sendData = b.toByteArray();
            sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getSocketAddress());
            server.send(sendPacket);
            System.out.println("done send sv");
        } catch (IOException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public SinhVien receiveObject(){
        SinhVien sv = null;
        
        try {
            receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            server.receive(receivePacket);
            
            ByteArrayInputStream b = new ByteArrayInputStream(receiveData);
            ObjectInputStream in = new ObjectInputStream(b);
            sv = (SinhVien) in.readObject();
            System.out.println("Nhan ve 1 sv: "+ sv.toString());
            
        } catch (IOException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return sv;
    }
    
    public static void main(String[] args) {
        UDPServer server = new UDPServer(1107);
        server.listening();
    }
}
