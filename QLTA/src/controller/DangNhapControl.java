package controller;
/*
 * @author Tran Chuyen
 */

import java.sql.Connection;
import java.util.*;
import java.lang.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.LayoutStyle;
import model.NhanVien;
import view.DangNhapFrm;

public class DangNhapControl{
    private static Connection con;
    
    public DangNhapControl() {
        if(con == null){
            String dbUrl = "jdbc:mysql://localhost:3306/qlta";
            String dbClass = "com.mysql.jdbc.Driver";
            try{
                Class.forName(dbClass);
                con = DriverManager.getConnection(dbUrl, "root", "27281997");
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public int checkDangNhap(NhanVien taiKhoan){ 
        String query = "Select * FROM tblnhanvien WHERE tenDangNhap ='" + taiKhoan.getTenDangNhap()
                + "' AND matKhau ='" + taiKhoan.getMatKhau() + "' AND chucVu LIKE '%v%' ";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            if(rs.next()) 
                return rs.getInt("id");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return 0;
    }
    
    
    
    
    
    
}
