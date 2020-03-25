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
import java.sql.Statement;
import model.ViecDiemDanh;

public class ViecDiemDanhDAO {
     private static Connection con;

    public ViecDiemDanhDAO() {
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
    
    public ArrayList<ViecDiemDanh> getDaDiemDanh(int idLopHoc){
        ArrayList<ViecDiemDanh> ds = new ArrayList<>();
        String sql = "SELECT * FROM tblviecdiemdanh WHERE idLopHoc = '" + Integer.toString(idLopHoc) + "'";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ViecDiemDanh vdd = new ViecDiemDanh();
                vdd.setBuoiSo(rs.getInt("buoiSo"));
                vdd.setCheckIn(rs.getString("checkIn"));
                vdd.setCheckOut(rs.getString("checkOut"));
                vdd.setNgayDD(rs.getDate("ngayDD"));
                byte tmp = rs.getByte("tinhTrang");
                if(tmp == 1)
                    vdd.setTinhTrang(1);
                else
                    vdd.setTinhTrang(0);
                ds.add(vdd);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ds;
    }
    
    public int luuDD(ViecDiemDanh d){
        int maTraVe = 0;
        String sql = "INSERT INTO tblviecdiemdanh (buoiSo,ngayDD,checkIn,checkOut,idLopHoc,tinhTrang) VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, d.getBuoiSo());
            long mil = d.getNgayDD().getTime();
            java.sql.Date date = new java.sql.Date(mil);
            ps.setDate(2, date);
            ps.setString(3,d.getCheckIn());
            ps.setString(4,d.getCheckOut());
            ps.setInt(5, d.getLopHoc().getId());
            ps.setInt(6, 1);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                maTraVe = rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return maTraVe;
    }
}
