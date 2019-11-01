package ex1;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class runClient {
    public static void main(String[] args) {
        UDPClient client = new UDPClient();
        client.send("test nay");
        client.receive();
        client.send("gui tiep nay");
    }
}
