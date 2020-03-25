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
import model.PhongHoc;

public class PhongHocDAO {
    private static Connection con;

    public PhongHocDAO() {
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
    public PhongHoc timPhongHocByID(int id){
        PhongHoc ph = new PhongHoc();
        String sql = "SELECT * FROM tblphonghoc WHERE id = "+ Integer.toString(id);
        try{
            PreparedStatement ps1 = con.prepareStatement(sql);
            ResultSet rs = ps1.executeQuery();
            if(rs.next()){
                ph.setId(rs.getInt("id"));
                ph.setSoCho(rs.getInt("soChoNgoi"));
                ph.setTen(rs.getString("ten"));
                ph.setMoTa(rs.getString("moTa"));  
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ph;
    }
}
