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

public class GiangVienDAO {
    private static Connection con;

    public GiangVienDAO() {
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
    
    public ArrayList<GiangVien> timGiangVien(String key){
        ArrayList<GiangVien> dsGV = new ArrayList<>();
        String sql = "SELECT * FROM tblgiangvien WHERE ten LIKE '%"+ key + "%' ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                GiangVien gv = new GiangVien();
                gv.setId(rs.getInt("id"));
                gv.setTen(rs.getString("ten"));
                gv.setSdt(rs.getString("sdt"));
                gv.setDiaChi(rs.getString("diaChi"));
                gv.setMail(rs.getString("mail"));
                dsGV.add(gv);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dsGV;
    }
    
    public GiangVien timGiangVienByID(int id){
        GiangVien ph = new GiangVien();
        String sql = "SELECT * FROM tblgiangvien WHERE id = "+ Integer.toString(id);
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ph.setId(rs.getInt("id"));
                ph.setTen(rs.getString("ten"));
                ph.setSdt(rs.getString("sdt"));
                ph.setDiaChi(rs.getString("diaChi"));  
                ph.setMail(rs.getString("mail"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ph;
    }
}
