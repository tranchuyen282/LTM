package ex1;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                System.out.println("client gui len: " + strTemp);
                String s = "100;15,20";
                sendData = s.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length
                        ,receivePacket.getSocketAddress());
                server.send(sendPacket);
                
            } catch (Exception ex) {
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
