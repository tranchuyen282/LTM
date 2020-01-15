package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class CaLamViec {
    private  int id;
    private Date gioBatDau;
    private Date gioKetThuc;
    private String thu;
    private Date ngay;
    private int luongTrenCa;
    private int soLuongNhanVien;
    private int soLuongDaDangKy;

    public CaLamViec() {
    }

    public CaLamViec(int id, Date gioBatDau, Date gioKetThuc, String thu, Date ngay, int luongTrenCa, int soLuongNhanVien, int soLuongDaDangKy) {
        this.id = id;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.thu = thu;
        this.ngay = ngay;
        this.luongTrenCa = luongTrenCa;
        this.soLuongNhanVien = soLuongNhanVien;
        this.soLuongDaDangKy = soLuongDaDangKy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(Date gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public Date getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(Date gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public int getLuongTrenCa() {
        return luongTrenCa;
    }

    public void setLuongTrenCa(int luongTrenCa) {
        this.luongTrenCa = luongTrenCa;
    }

    public int getSoLuongNhanVien() {
        return soLuongNhanVien;
    }

    public void setSoLuongNhanVien(int soLuongNhanVien) {
        this.soLuongNhanVien = soLuongNhanVien;
    }

    public int getSoLuongDaDangKy() {
        return soLuongDaDangKy;
    }

    public void setSoLuongDaDangKy(int soLuongDaDangKy) {
        this.soLuongDaDangKy = soLuongDaDangKy;
    }
    
    
    
    
    

   

   
    
    
}
