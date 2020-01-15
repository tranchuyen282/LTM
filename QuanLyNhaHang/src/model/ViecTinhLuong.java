package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;
import java.sql.Time;
import java.sql.Timestamp;

public class ViecTinhLuong {
    private int id;
    private ArrayList<ViecCheckInCheckOut> dsCheckInOut;
    private int tongCong;
    private int luongTheoCong;
    private int tienPhatCICO;
    private int thuongThem;
    private int phatThem;
    private int tongLuong;
    private Timestamp thoiGianTinh;
    private ThanhVien thanhVien;
    private String ghiChu;
    private ThanhVien hcns;
    private int gioTangCa;
    private int tienTangCa;
    private int thang;

    

    public ViecTinhLuong() {
    }

    public ViecTinhLuong(int id, ArrayList<ViecCheckInCheckOut> dsCheckInOut, int tongCong, int tienPhatCICO, int thuongThem, int phatThem, int phuCap, int tongLuong, Timestamp thoiGianTinh, ThanhVien thanhVien, String ghiChu) {
        this.id = id;
        this.dsCheckInOut = dsCheckInOut;
        this.tongCong = tongCong;
        this.tienPhatCICO = tienPhatCICO;
        this.thuongThem = thuongThem;
        this.phatThem = phatThem;
        this.tongLuong = tongLuong;
        this.thoiGianTinh = thoiGianTinh;
        this.thanhVien = thanhVien;
        this.ghiChu = ghiChu;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<ViecCheckInCheckOut> getDsCheckInOut() {
        return dsCheckInOut;
    }

    public void setDsCheckInOut(ArrayList<ViecCheckInCheckOut> dsCheckInOut) {
        this.dsCheckInOut = dsCheckInOut;
    }

    public int getTongCong() {
        return tongCong;
    }

    public void setTongCong(int tongCong) {
        this.tongCong = tongCong;
    }

    public int getTienPhatCICO() {
        return tienPhatCICO;
    }

    public void setTienPhatCICO(int tienPhatCICO) {
        this.tienPhatCICO = tienPhatCICO;
    }

    public int getThuongThem() {
        return thuongThem;
    }

    public void setThuongThem(int thuongThem) {
        this.thuongThem = thuongThem;
    }

    public int getPhatThem() {
        return phatThem;
    }

    public void setPhatThem(int phatThem) {
        this.phatThem = phatThem;
    }

    public int getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(int tongLuong) {
        this.tongLuong = tongLuong;
    }

    public Timestamp getThoiGianTinh() {
        return thoiGianTinh;
    }

    public void setThoiGianTinh(Timestamp thoiGianTinh) {
        this.thoiGianTinh = thoiGianTinh;
    }

    public ThanhVien getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(ThanhVien thanhVien) {
        this.thanhVien = thanhVien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    public ThanhVien getHcns() {
        return hcns;
    }

    public void setHcns(ThanhVien hcns) {
        this.hcns = hcns;
    }

    public int getGioTangCa() {
        return gioTangCa;
    }

    public void setGioTangCa(int gioTangCa) {
        this.gioTangCa = gioTangCa;
    }

    public int getTienTangCa() {
        return tienTangCa;
    }

    public void setTienTangCa(int tienTangCa) {
        this.tienTangCa = tienTangCa;
    }

    public int getLuongTheoCong() {
        return luongTheoCong;
    }

    public void setLuongTheoCong(int luongTheoCong) {
        this.luongTheoCong = luongTheoCong;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }
    
    
    
    
    
}
