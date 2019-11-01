package testtcp;
/*
 * @author Tran Chuyen
 */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.Socket;

class SinhVien{
    
}

public class ex {
    public static void main(String[] args) {
        String s = "1,3,9,19,33,20";
        String[] ar = s.split(",");
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(String tmp: ar){
            a.add(Integer.parseInt(tmp));
        }
        Collections.sort(a);
        int mi,u,v;
        u = a.get(0);
        v = a.get(1);
        mi = v - u;
        for(int i = 2; i < a.size() - 1; i++){
            int x = a.get(i); 
            int y = a.get(i+1);
            if(y - x <= mi){
                mi = y - x;
                u = x; v = y;
            }
        }
        
    }
}
