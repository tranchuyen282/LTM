package ex1;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class runServer {
    public static void main(String[] args) {
        UDPServer server = new UDPServer();
        server.listening();
    }
}
