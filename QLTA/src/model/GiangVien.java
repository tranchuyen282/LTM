package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class GiangVien {
    private int id;
    private String ten,diaChi,mail,sdt;

    public GiangVien() {
    }

    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getMail() {
        return mail;
    }

    public String getSdt() {
        return sdt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}
