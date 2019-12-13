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

public class UDPClient {
    DatagramSocket client;
    DatagramPacket sendPacket, receivePacket;
    byte[] sendData, receiveData;
    int port;

    public UDPClient(int port) {
        this.port = port;
        try {
            client = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendString(String s){
        
        try {
            sendData = s.getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("127.0.0.1"), port);
            client.send(sendPacket);
            System.out.println("done send: " + s);
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String receiveString(){
        String s = null;
        try {
            receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            client.receive(receivePacket);
            s = new String(receivePacket.getData()).trim();
            System.out.println("nhan string: " + s);
            
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    public void sendObject(SinhVien sv){
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(b);
            out.writeObject(sv);
            out.flush();
            sendData = b.toByteArray();
            sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("localhost"), port);
            client.send(sendPacket);
            System.out.println("done send sv");
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public SinhVien receiveObject(){
        SinhVien sv = null;
        
        try {
            receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            client.receive(receivePacket);
            
            ByteArrayInputStream b = new ByteArrayInputStream(receiveData);
            ObjectInputStream in = new ObjectInputStream(b);
            sv = (SinhVien) in.readObject();
            System.out.println("Nhan ve 1 sv: " + sv.getGpa());
            
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return sv;
    }
    
    
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        UDPClient client = new UDPClient(1107);
//        client.sendString(";B16DCCN034;123");
//        String s = client.receiveString();
//        client.sendString("1;2;3");
          SinhVien sv = new SinhVien(0, "B16DCCN034", 0, "");
          client.sendObject(sv);
          sv = client.receiveObject();
          sv.setGpaLetter("A");
          client.sendObject(sv);
        
    }
}
