package model;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;

public class ThanhVien {
    private  int id;
    private String username;
    private String password;
    private String vaiTro;
    private HoVaTen hoTen;
    private DiaChi diaChi;

    public ThanhVien() {
    }

    public ThanhVien(int id, String username, String password, String vaiTro, HoVaTen hoTen, DiaChi diaChi) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.vaiTro = vaiTro;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public HoVaTen getHoTen() {
        return hoTen;
    }

    public void setHoTen(HoVaTen hoTen) {
        this.hoTen = hoTen;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }

    
    
    
}
