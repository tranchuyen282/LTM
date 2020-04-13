package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class ViecDangKyDay {
    private int id;
    private GiangVien giangVien;
    private MonHoc monHoc;
    private ArrayList<LopHocPhan> dslopHocPhan;
    private Date thoiGianDK;

    public ViecDangKyDay() {
    }

    public ViecDangKyDay(int id, GiangVien giangVien, MonHoc monHoc, ArrayList<LopHocPhan> dslopHocPhan, Date thoiGianDK) {
        this.id = id;
        this.giangVien = giangVien;
        this.monHoc = monHoc;
        this.dslopHocPhan = dslopHocPhan;
        this.thoiGianDK = thoiGianDK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public ArrayList<LopHocPhan> getDslopHocPhan() {
        return dslopHocPhan;
    }

    public void setDslopHocPhan(ArrayList<LopHocPhan> dslopHocPhan) {
        this.dslopHocPhan = dslopHocPhan;
    }

    public Date getThoiGianDK() {
        return thoiGianDK;
    }

    public void setThoiGianDK(Date thoiGianDK) {
        this.thoiGianDK = thoiGianDK;
    }

    @Override
    public String toString() {
        return "ViecDangKyDay{" + "id=" + id + ", giangVien=" + giangVien + ", monHoc=" + monHoc + ", dslopHocPhan=" + dslopHocPhan + ", thoiGianDK=" + thoiGianDK + '}';
    }
       
    
}
