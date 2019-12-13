package wss;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;
import ws.Testws;
import ws.Testws_Service;

public class NewClass {
    public static void main(String[] args) {
        Testws_Service servive = new Testws_Service();
        Testws port = servive.getTestwsPort();
        System.out.println(port.hello("CP"));
    }
}
