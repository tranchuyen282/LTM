package controller;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;
import java.sql.Timestamp;

public class NewClass {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        java.util.Date uDate = new java.util.Date();
		Timestamp timestamp = new Timestamp(uDate.getTime());
                System.out.println(timestamp.toString());
                System.out.println(uDate.getDate());
    }
}
