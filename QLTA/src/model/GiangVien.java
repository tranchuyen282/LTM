package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class GiangVien {
    private int id;
    private String user, pass, ten, mail;

    public GiangVien() {
    }

    public GiangVien(int id, String user, String pass, String ten, String mail) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.ten = ten;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
}
