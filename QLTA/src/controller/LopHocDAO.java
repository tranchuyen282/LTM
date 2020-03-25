package controller;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.GiangVien;
import model.LopHoc;
import model.PhongHoc;

public class LopHocDAO {
   private static Connection con;

    public LopHocDAO() {
        if(con == null){
            String dbUrl = "jdbc:mysql://localhost:3306/qlta";
            String dbClass = "com.mysql.jdbc.Driver";
            try{
                Class.forName(dbClass);
                con = DriverManager.getConnection(dbUrl,"root","27281997");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public LopHoc timLopByID(int id){
        LopHoc ph = new LopHoc();
        String sql = "SELECT * FROM tbllophoc WHERE id = "+ Integer.toString(id);
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ph.setId(rs.getInt("id"));
                ph.setSoBuoi(rs.getInt("soBuoi"));
                ph.setLoai(rs.getString("loai"));
                ph.setThu(rs.getString("thu"));
                ph.setNgayBD(rs.getDate("ngayBD"));
                ph.setGioVao(rs.getTime("gioVao"));
                ph.setGioRa(rs.getTime("gioRa"));
                PhongHocDAO phd = new PhongHocDAO();
                PhongHoc p = phd.timPhongHocByID(rs.getInt("idPhongHoc"));
                ph.setPhongHoc(p);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ph;
    }
}
