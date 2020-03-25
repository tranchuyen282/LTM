package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class PhongHoc {
    private int id, soCho;
    private String ten, moTa;

    public PhongHoc() {
    }

    public PhongHoc(int id, int soCho, String ten, String moTa) {
        this.id = id;
        this.soCho = soCho;
        this.ten = ten;
        this.moTa = moTa;
    }

    public int getId() {
        return id;
    }

    public int getSoCho() {
        return soCho;
    }

    public String getTen() {
        return ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSoCho(int soCho) {
        this.soCho = soCho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
}
