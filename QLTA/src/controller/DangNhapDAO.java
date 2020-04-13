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
import model.GiangVien;
import view.DangNhapFrm;

public class DangNhapDAO extends DAO{
    
    public DangNhapDAO() {
        getInstance();
    }
    
    public int checkDangNhap(GiangVien giangVien){ 
        String query = "Select * FROM tblgiangvien WHERE user ='" + giangVien.getUser()
                + "' AND pass ='" + giangVien.getPass() + "'";
        //System.out.println(query);
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
