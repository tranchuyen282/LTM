package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;
public class LopHocPhan {
    private int id;
    private String maLHP;
    private String nhomLHP;
    private String thu;
    private String tietBD;
    private String soTiet;
    private String phong;
    private String tuan;
    private int idMH;

    public LopHocPhan() {
    }

    public LopHocPhan(int id, String maLHP, String nhomLHP, String thu, String tietBD, String soTiet, String phong, String tuan) {
        this.id = id;
        this.maLHP = maLHP;
        this.nhomLHP = nhomLHP;
        this.thu = thu;
        this.tietBD = tietBD;
        this.soTiet = soTiet;
        this.phong = phong;
        this.tuan = tuan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaLHP() {
        return maLHP;
    }

    public void setMaLHP(String maLHP) {
        this.maLHP = maLHP;
    }

    public String getNhomLHP() {
        return nhomLHP;
    }

    public void setNhomLHP(String nhomLHP) {
        this.nhomLHP = nhomLHP;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getTietBD() {
        return tietBD;
    }

    public void setTietBD(String tietBD) {
        this.tietBD = tietBD;
    }

    public String getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(String soTiet) {
        this.soTiet = soTiet;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getTuan() {
        return tuan;
    }

    public void setTuan(String tuan) {
        this.tuan = tuan;
    }

    public int getIdMH() {
        return idMH;
    }

    public void setIdMH(int idMH) {
        this.idMH = idMH;
    }

    @Override
    public String toString() {
        return "LopHocPhan{" + "id=" + id + ", maLHP=" + maLHP + ", nhomLHP=" + nhomLHP + ", thu=" + thu + ", tietBD=" + tietBD + ", soTiet=" + soTiet + ", phong=" + phong + ", tuan=" + tuan + '}';
    }

    

    
}
