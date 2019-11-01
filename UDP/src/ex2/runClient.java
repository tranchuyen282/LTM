package ex2;
/*
 * @author Tran Chuyen
 */

import ex1.*;
import java.util.*;
import java.lang.*;
import udp.SinhVien;

public class runClient {
    public static void main(String[] args) {
        UDPClient client = new UDPClient();
        SinhVien s = new SinhVien("B16DCCN034");
        client.sendObject(s);
        client.receiveObject();
    }
}
