package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class TuanLamViec {
    private  int id;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String thang;
    private String nam;
    private ArrayList<CaLamViec> dsCaLamViec;

    public TuanLamViec() {
    }

    public TuanLamViec(int id, Date ngayBatDau, Date ngayKetThuc, String thang, String nam, ArrayList<CaLamViec> dsCaLamViec) {
        this.id = id;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.thang = thang;
        this.nam = nam;
        this.dsCaLamViec = dsCaLamViec;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public ArrayList<CaLamViec> getDsCaLamViec() {
        return dsCaLamViec;
    }

    public void setDsCaLamViec(ArrayList<CaLamViec> dsCaLamViec) {
        this.dsCaLamViec = dsCaLamViec;
    }
    
    

    

    
    
    
}
