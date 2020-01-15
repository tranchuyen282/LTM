package controller;
/*
 * @author Tran Chuyen
 */

import static controller.DAO.con;
import java.util.*;
import java.lang.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CaLamViec;
import model.TuanLamViec;

public class CaLamViecDAO extends DAO{

    public CaLamViecDAO() {
        getInstance();
    }
    
    public ArrayList<CaLamViec> layDanhSachCaLam(TuanLamViec tuanLamViec){
        ArrayList<CaLamViec> dsCaLam = new ArrayList<CaLamViec>();
        try {     
            String query = "Select * FROM tblcalamviec WHERE tuanLamViecid = '" + tuanLamViec.getId() +"'";
            
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CaLamViec caLamViec = new CaLamViec();
                caLamViec.setId(rs.getInt("id"));
                caLamViec.setGioBatDau(rs.getTime("gioBatDau"));
                caLamViec.setGioKetThuc(rs.getTime("gioKetThuc"));
                caLamViec.setNgay(rs.getDate("ngay"));
                caLamViec.setThu(rs.getString("thu"));
                caLamViec.setLuongTrenCa(rs.getInt("luongTrenCa"));
                caLamViec.setSoLuongNhanVien(rs.getInt("soLuongNhanVien"));
                caLamViec.setSoLuongDaDangKy(rs.getInt("soLuongDaDangKy"));
                dsCaLam.add(caLamViec);
            }
            
            //
            
        } catch (SQLException ex) {
            Logger.getLogger(CaLamViecDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return dsCaLam;
    }
    
    public int capNhatSauThemDangKy(CaLamViec clv){
        int rep = 0;
        try {     
            String query = "UPDATE tblcalamviec SET soLuongDaDangKy = soLuongDaDangKy + 1 WHERE id = '"+clv.getId()+"'";
            Statement statement = con.createStatement();
            rep = statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CaLamViecDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rep;
    }
    
    public int capNhatSauXoaDangKy(CaLamViec clv){
        int rep = 0;
        try {     
            String query = "UPDATE tblcalamviec SET soLuongDaDangKy = soLuongDaDangKy - 1 WHERE id = '"+clv.getId()+"'";
            Statement statement = con.createStatement();
            rep = statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CaLamViecDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rep;
    }
    
    
    
    
}
