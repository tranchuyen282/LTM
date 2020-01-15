package controller;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DiaChi;
import model.HoVaTen;
import model.ThanhVien;

public class NhanVienDAO extends DAO{

    public NhanVienDAO() {
        getInstance();
    }
    
    public ThanhVien ktDangNhap(String user, String pass){
        ThanhVien thanhVien = null;
        try {     
            String query = "Select * FROM tblthanhvien WHERE username ='" + user
                    + "' AND password ='" + pass + "'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                thanhVien = new ThanhVien();
                thanhVien.setId(rs.getInt("id"));
                thanhVien.setUsername(user);
                thanhVien.setPassword(pass);
                thanhVien.setVaiTro(rs.getString(4));
                HoVaTen hoVaTen = getHoTen(rs.getInt("HoVaTenid"));
                DiaChi diaChi = getDiaChi(rs.getInt("DiaChiid"));
                thanhVien.setHoTen(hoVaTen);
                thanhVien.setDiaChi(diaChi);
            }
            
            //
            
            
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thanhVien;
    }
    
    public ThanhVien getTV(int id){
        ThanhVien thanhVien = null;
        try {     
            String query = "Select * FROM tblthanhvien WHERE id = "+id;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                thanhVien = new ThanhVien();
                thanhVien.setId(rs.getInt("id"));
                thanhVien.setUsername(rs.getString("username"));
                thanhVien.setPassword(rs.getString("password"));
                thanhVien.setVaiTro(rs.getString(4));
                HoVaTen hoVaTen = getHoTen(rs.getInt("HoVaTenid"));
                DiaChi diaChi = getDiaChi(rs.getInt("DiaChiid"));
                thanhVien.setHoTen(hoVaTen);
                thanhVien.setDiaChi(diaChi);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thanhVien;
    }

    private HoVaTen getHoTen(int id) {
        HoVaTen hoVaTen = null;
        try {     
            String query = "Select * FROM tblhovaten WHERE id ='" + id + "'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                hoVaTen = new HoVaTen();
                hoVaTen.setId(id);
                hoVaTen.setHo(rs.getString("ho"));
                hoVaTen.setTen(rs.getString("ten"));              
            }
            
            //
            
            
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hoVaTen;
    }

    private DiaChi getDiaChi(int id) {
        DiaChi diaChi = new DiaChi();
        try {     
            String query = "Select * FROM tbldiachi WHERE id ='" + id + "'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                diaChi.setId(id);
                diaChi.setSoNha(rs.getString("soNha"));
                diaChi.setPhuong(rs.getString("phuong"));
                diaChi.setQuan(rs.getString("quan"));
                diaChi.setThanhPho(rs.getString("thanhPho"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return diaChi;
    }
    
    
}
