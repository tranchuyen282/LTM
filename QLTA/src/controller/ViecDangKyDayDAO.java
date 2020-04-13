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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GiangVien;
import model.LopHocPhan;
import model.MonHoc;
import model.ViecDangKyDay;

public class ViecDangKyDayDAO extends DAO{
    

    public ViecDangKyDayDAO() {
        getInstance();
    }
    
    public ArrayList<ViecDangKyDay> getDsDaDKD(ArrayList<MonHoc> dsMonHoc, GiangVien giangVien){
        ArrayList<ViecDangKyDay> dsDaDKD= new ArrayList<ViecDangKyDay>();
        for(MonHoc monHoc: dsMonHoc){
            try {
                String sql = "SELECT * FROM tblmonhoc,tblviecdangkyday,tbllophocphan\n" +
                        "WHERE tblmonhoc.id = " + monHoc.getId()+
                        " AND tbllophocphan.idMonHoc = " +monHoc.getId()+
                        " AND tblviecdangkyday.idGiangVien = " +giangVien.getId()+
                        " AND tblviecdangkyday.idLopHocPhan = tbllophocphan.id" ;
            
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                ViecDangKyDay vdk = new ViecDangKyDay();
                vdk.setGiangVien(giangVien);
                vdk.setMonHoc(monHoc);
                ArrayList<LopHocPhan> dsLHP = new ArrayList<LopHocPhan>();
                while(rs.next()){
                   LopHocPhan lhp = new LopHocPhan();
                   lhp.setId(rs.getInt("tblviecdangkyday.idLopHocPhan"));
                   lhp.setMaLHP(rs.getString("tbllophocphan.maLHP"));
                   lhp.setNhomLHP(rs.getString("tbllophocphan.nhomLHP"));
                   dsLHP.add(lhp);
                   //System.out.println(lhp);
                }
                vdk.setDslopHocPhan(dsLHP);
                dsDaDKD.add(vdk);
            } catch (SQLException ex) {
                Logger.getLogger(ViecDangKyDayDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return dsDaDKD;
    }
    
    
    
}
