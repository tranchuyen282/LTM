package testtcp;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class tachchuoi {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String s = "12ab&^(*9,adsa";
        String s1="",s2="";
        for(int i = 0; i < s.length(); i++){
            if((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ){
                s1 += String.valueOf(s.charAt(i));
            }else{
                s2 += String.valueOf(s.charAt(i));
            }
        }
        System.out.println(s1);
        System.out.println(s2);
    }
}
