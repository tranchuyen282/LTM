package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class DiaChi {
    private  int id;
    private String soNha;
    private String phuong;
    private String quan;
    private String thanhPho;

    public DiaChi() {
    }

    public DiaChi(int id, String soNha, String phuong, String quan, String thanhPho) {
        this.id = id;
        this.soNha = soNha;
        this.phuong = phuong;
        this.quan = quan;
        this.thanhPho = thanhPho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    
    
    
}
