package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class HoVaTen {
    private  int id;
    private String ho;
    private String ten;

    public HoVaTen() {
    }

    public HoVaTen(int id, String ho, String ten) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    
    
    
    
    
    
}
