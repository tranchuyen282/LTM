package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class ViecDiemDanh {
    private int id, buoiSo;
    private Date ngayDD;
    private String checkIn, checkOut;
    private int tinhTrang;
    private NhanVien vanHanh;
    private LopHoc lopHoc;

    public ViecDiemDanh() {
    }

    public ViecDiemDanh(int id, int buoiSo, String checkIn, String checkOut, NhanVien vanHanh, LopHoc lopHoc) {
        this.id = id;
        this.buoiSo = buoiSo;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.vanHanh = vanHanh;
        this.lopHoc = lopHoc;
    }

    public int getId() {
        return id;
    }

    public int getBuoiSo() {
        return buoiSo;
    }

    public Date getNgayDD() {
        return ngayDD;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public NhanVien getVanHanh() {
        return vanHanh;
    }

    public LopHoc getLopHoc() {
        return lopHoc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBuoiSo(int buoiSo) {
        this.buoiSo = buoiSo;
    }

    public void setNgayDD(Date ngayDD) {
        this.ngayDD = ngayDD;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public void setVanHanh(NhanVien vanHanh) {
        this.vanHanh = vanHanh;
    }

    public void setLopHoc(LopHoc lopHoc) {
        this.lopHoc = lopHoc;
    }
    
    
}
