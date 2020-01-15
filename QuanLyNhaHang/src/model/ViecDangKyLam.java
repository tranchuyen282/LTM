package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class ViecDangKyLam {
    private  int id;  
    private ThanhVien thanhVien;
    private CaLamViec caLamViec;
    private Date thoiGianDangKy;

    public ViecDangKyLam() {
    }

    public ViecDangKyLam(int id, ThanhVien thanhVien, CaLamViec caLamViec, Date thoiGianDangKy) {
        this.id = id;
        this.thanhVien = thanhVien;
        this.caLamViec = caLamViec;
        this.thoiGianDangKy = thoiGianDangKy;
    }
    public ViecDangKyLam(int id, ThanhVien thanhVien, CaLamViec caLamViec) {
        this.id = id;
        this.thanhVien = thanhVien;
        this.caLamViec = caLamViec;
        //this.thoiGianDangKy = thoiGianDangKy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ThanhVien getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(ThanhVien thanhVien) {
        this.thanhVien = thanhVien;
    }

    public CaLamViec getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(CaLamViec caLamViec) {
        this.caLamViec = caLamViec;
    }

    public Date getThoiGianDangKy() {
        return thoiGianDangKy;
    }

    public void setThoiGianDangKy(Date thoiGianDangKy) {
        this.thoiGianDangKy = thoiGianDangKy;
    }

    

    
    
    
}
