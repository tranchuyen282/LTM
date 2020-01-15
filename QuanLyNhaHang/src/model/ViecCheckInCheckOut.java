package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;
import java.sql.Time;

public class ViecCheckInCheckOut {
    private int id;
    private Date gioCheckIn;
    private Date gioCheckOut;
    private String trangThaiCheckIn;
    private String trangThaiCheckOut;
    private String ngay;
    private int soGioTangCa;
    private ThanhVien thanhVien;
    private ViecDangKyLam vdkl;

    public ViecCheckInCheckOut() {
    }

    public ViecCheckInCheckOut(int id, Date gioCheckIn, Date gioCheckOut, ThanhVien thanhVien, ViecDangKyLam vdkl) {
        this.id = id;
        this.gioCheckIn = gioCheckIn;
        this.gioCheckOut = gioCheckOut;
        this.ngay = ngay;
        this.thanhVien = thanhVien;
        this.vdkl = vdkl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getGioCheckIn() {
        return gioCheckIn;
    }

    public void setGioCheckIn(Time gioCheckIn) {
        this.gioCheckIn = gioCheckIn;
    }

    public Date getGioCheckOut() {
        return gioCheckOut;
    }

    public void setGioCheckOut(Time gioCheckOut) {
        this.gioCheckOut = gioCheckOut;
    }

    public String getTrangThaiCheckIn() {
        return trangThaiCheckIn;
    }

    public ViecDangKyLam getVdkl() {
        return vdkl;
    }

    public void setVdkl(ViecDangKyLam vdkl) {
        this.vdkl = vdkl;
    }

    public void setTrangThaiCheckIn(String trangThaiCheckIn) {
        this.trangThaiCheckIn = trangThaiCheckIn;
    }

    public String getTrangThaiCheckOut() {
        return trangThaiCheckOut;
    }

    public void setTrangThaiCheckOut(String trangThaiCheckOut) {
        this.trangThaiCheckOut = trangThaiCheckOut;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getSoGioTangCa() {
        return soGioTangCa;
    }

    public void setSoGioTangCa(int soGioTangCa) {
        this.soGioTangCa = soGioTangCa;
    }

    public ThanhVien getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(ThanhVien thanhVien) {
        this.thanhVien = thanhVien;
    }

    
    
    
    
}
