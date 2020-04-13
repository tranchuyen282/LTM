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
import model.LopHocPhan;


public class LopHocPhanDAO extends DAO{

    public LopHocPhanDAO() {
        getInstance();
    }
    
    public ArrayList<LopHocPhan> getLHP(int idMH){
        ArrayList<LopHocPhan> dsLHP = new ArrayList<LopHocPhan>();
        String sql = "SELECT * FROM tbllophocphan WHERE idMonHoc = "+ idMH;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               LopHocPhan lhp = new LopHocPhan();
               lhp.setId(rs.getInt("id"));
               lhp.setMaLHP(rs.getString("maLHP"));
               lhp.setNhomLHP(rs.getString("nhomLHP"));
               lhp.setPhong(rs.getString("phong"));
               lhp.setSoTiet(rs.getString("soTiet"));
               lhp.setTietBD(rs.getString("tietBD"));
               lhp.setTuan(rs.getString("tuan"));
               lhp.setIdMH(rs.getInt("idMonHoc"));
               lhp.setThu(rs.getString("thu"));
                //System.out.println(lhp.toString());
               dsLHP.add(lhp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dsLHP;
    }
}
