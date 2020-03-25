package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class NhanVien {
    private int id;
    private String tenDayDu;
    private String tenDangNhap;
    private String matKhau;
    private String chucVu;

    public NhanVien() {
    }

    public NhanVien(int id, String tenDayDu, String tenDangNhap, String matKhau, String chucVu) {
        this.id = id;
        this.tenDayDu = tenDayDu;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
    }

    public int getId() {
        return id;
    }

    public String getTenDayDu() {
        return tenDayDu;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTenDayDu(String tenDayDu) {
        this.tenDayDu = tenDayDu;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    
    
}
