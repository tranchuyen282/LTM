package ex2;
/*
 * @author Tran Chuyen
 */

import ex1.*;
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
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import udp.SinhVien;

public class UDPClient {
    DatagramSocket client;
    DatagramPacket receivePacket, sendPacket;
    byte[] sendData, receiveData;
    int bufferSize = 1024;

    public UDPClient() {
        try {
            client = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void send(String s){
        
        try {
            sendData = s.getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("127.0.0.1"),1107);
            client.send(sendPacket);
            System.out.println("send: " + s);
        } catch (UnknownHostException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void sendObject(SinhVien s){
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(b);
            out.writeObject(s);
            out.flush();              
            sendData = b.toByteArray();

            sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("127.0.0.1"),1107);
                client.send(sendPacket);
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void receiveObject(){
        try {
            receiveData = new  byte[bufferSize];
            receivePacket = new DatagramPacket(receiveData, bufferSize);
            client.receive(receivePacket);
            
            ByteArrayInputStream b = new ByteArrayInputStream(receiveData);
            ObjectInputStream in = new ObjectInputStream(b);
            SinhVien s = (SinhVien) in.readObject();
            System.out.println("Nhan ve 1 sinh vien: "+ s.toString());
            s.setGpaLetter("A+");
            
            sendObject(s);
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void receive(){
        
        try {
            receiveData = new byte[bufferSize];
            receivePacket = new DatagramPacket(receiveData, bufferSize);
            client.receive(receivePacket);
            System.out.println(new String(receiveData).trim());
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
    
}
