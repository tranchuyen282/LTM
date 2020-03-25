package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class LopHoc {
    private int id;
    private String loai;
    private double hocPhi;
    private int soBuoi;
    private Date ngayBD, ngayKT;
    private Date gioVao;
    private Date gioRa;
    private String thu;
    private PhongHoc phongHoc;

    public LopHoc() {
    }

    public LopHoc(int id, String loai, double hocPhi, Date ngayBD, Date ngayKT, Date gioVao, Date gioRa, String thu, PhongHoc phongHoc) {
        this.id = id;
        this.loai = loai;
        this.hocPhi = hocPhi;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.thu = thu;
        this.phongHoc = phongHoc;
    }

    public int getId() {
        return id;
    }

    public String getLoai() {
        return loai;
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public int getSoBuoi() {
        return soBuoi;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public Date getGioVao() {
        return gioVao;
    }

    public Date getGioRa() {
        return gioRa;
    }

    public String getThu() {
        return thu;
    }

    public PhongHoc getPhongHoc() {
        return phongHoc;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public void setSoBuoi(int soBuoi) {
        this.soBuoi = soBuoi;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public void setGioVao(Date gioVao) {
        this.gioVao = gioVao;
    }

    public void setGioRa(Date gioRa) {
        this.gioRa = gioRa;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public void setPhongHoc(PhongHoc phongHoc) {
        this.phongHoc = phongHoc;
    }
    
    
    
}
