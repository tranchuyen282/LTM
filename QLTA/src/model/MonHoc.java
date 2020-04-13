package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class MonHoc {
    private int id;
    private String tenMH;
    private String maMH;
    private String soTinChi;
    private ArrayList<LopHocPhan> dsLopHocPhan;

    public MonHoc() {
    }

    public MonHoc(int id, String tenMH, String maMH, String soTinChi, ArrayList<LopHocPhan> dsLopHocPhan) {
        this.id = id;
        this.tenMH = tenMH;
        this.maMH = maMH;
        this.soTinChi = soTinChi;
        this.dsLopHocPhan = dsLopHocPhan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(String soTinChi) {
        this.soTinChi = soTinChi;
    }

    public ArrayList<LopHocPhan> getDsLopHocPhan() {
        return dsLopHocPhan;
    }

    public void setDsLopHocPhan(ArrayList<LopHocPhan> dsLopHocPhan) {
        this.dsLopHocPhan = dsLopHocPhan;
    }
     
    
    @Override
    public String toString() {
        return "MonHoc{" + "tenMH=" + tenMH + ", maMH=" + maMH + ", soTinChi=" + soTinChi + ", dsLopHocPhan=" + dsLopHocPhan + '}';
    }
    
    
}
