package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class ViecDangKyDay {
    private Date ngayDangKy;
    private Double luong;
    private LopHoc lopHoc;
    private GiangVien giangVien;
    private NhanVien nhanVien;

    public ViecDangKyDay() {
    }

    public ViecDangKyDay(Date ngayDangKy, Double luong, LopHoc lopHoc, GiangVien giangVien, NhanVien nhanVien) {
        this.ngayDangKy = ngayDangKy;
        this.luong = luong;
        this.lopHoc = lopHoc;
        this.giangVien = giangVien;
        this.nhanVien = nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public Double getLuong() {
        return luong;
    }

    public LopHoc getLopHoc() {
        return lopHoc;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }

    public void setLopHoc(LopHoc lopHoc) {
        this.lopHoc = lopHoc;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }
    
    
}
