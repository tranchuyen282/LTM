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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CaLamViec;
import model.DiaChi;
import model.HoVaTen;
import model.TuanLamViec;

public class TuanLamViecDAO extends DAO{

    public TuanLamViecDAO() {
        getInstance();
    }
    
    public ArrayList<TuanLamViec> timTuanTheoThang(String thang){
        ArrayList<TuanLamViec> dsTuan = new ArrayList<TuanLamViec>();
        
        try {     
            String query = "Select * FROM tbltuanlamviec WHERE thang ='" + thang
                    + "'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TuanLamViec tuan = new TuanLamViec();
                tuan.setId(rs.getInt("id"));
                tuan.setNgayBatDau(rs.getDate("ngayBatDau"));
                tuan.setNgayKetThuc(rs.getDate("ngayKetThuc"));
                tuan.setThang(rs.getString("thang"));
                tuan.setNam(rs.getString("nam"));
                ArrayList<CaLamViec> dsCaLam = null;
                tuan.setDsCaLamViec(dsCaLam);
                dsTuan.add(tuan);
            }
  
            
        } catch (SQLException ex) {
            Logger.getLogger(TuanLamViecDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dsTuan;
    }
    
}
