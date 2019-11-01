package ex1;
/*
 * @author Tran Chuyen
 */

import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
