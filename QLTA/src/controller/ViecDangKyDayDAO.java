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
import model.GiangVien;
import model.LopHoc;
import model.NhanVien;
import model.PhongHoc;
import model.ViecDangKyDay;

public class ViecDangKyDayDAO {
    private static Connection con;

    public ViecDangKyDayDAO() {
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
    
    public ArrayList<LopHoc> timLopTrong(String loaiLop){
        ArrayList<LopHoc> listLop = new ArrayList<>();
        String sql = "SELECT * FROM tbllophoc WHERE loai LIKE '%" + loaiLop +
                    "%' AND id NOT IN "
                + "(SELECT idLopHoc FROM tblviecdangkyday)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LopHoc lh= new LopHoc();
                lh.setId(rs.getInt("id"));
                lh.setLoai(rs.getString("loai"));
                lh.setHocPhi(rs.getDouble("hocPhi"));
                lh.setSoBuoi(rs.getInt("soBuoi"));
                lh.setNgayBD(rs.getDate("ngayBD"));
                lh.setNgayKT(rs.getDate("ngayKT"));
                lh.setGioVao(rs.getTime("gioVao"));
                lh.setGioRa(rs.getTime("gioRa"));
                lh.setThu(rs.getString("thu"));
                int idPhong = rs.getInt("idPhongHoc");
                PhongHocDAO phd = new PhongHocDAO();
                PhongHoc ph = phd.timPhongHocByID(idPhong);
                lh.setPhongHoc(ph);   
                listLop.add(lh);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listLop;
    }
    
    
    public int luuDangKyDay(ViecDangKyDay dkd){
        int maTraVe = 0;
        String sql = "INSERT INTO tblviecdangkyday (ngayDangKy,luong,idGiangVien,idLopHoc,idNhanVien) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            ps.setDouble(2,dkd.getLuong());
            ps.setInt(3,dkd.getGiangVien().getId());
            ps.setInt(4,dkd.getLopHoc().getId());
            ps.setInt(5,dkd.getNhanVien().getId());
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
    
    public ArrayList<ViecDangKyDay> timLopDD(String tenGV, String lop){
        ArrayList<ViecDangKyDay> listDD = new ArrayList<ViecDangKyDay>();
        String sql =    "SELECT tblviecdangkyday.id,tblviecdangkyday.ngayDangKy,tblviecdangkyday.luong,tblviecdangkyday.idGiangVien,tblviecdangkyday.idLopHoc,tblviecdangkyday.idNhanVien " +
                        "FROM tbllophoc, tblviecdangkyday, tblgiangvien " +
                        "WHERE tbllophoc.id = tblviecdangkyday.idLopHoc " +
                        "AND tblviecdangkyday.idGiangVien = tblgiangvien.id " +
                        "AND tbllophoc.loai LIKE '%" + lop + "%' " +
                        "AND tblgiangvien.ten LIKE '%"+tenGV +"%'";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ViecDangKyDay vd = new ViecDangKyDay();
                vd.setLuong(rs.getDouble("luong"));
                vd.setNgayDangKy(rs.getDate("ngayDangKy"));
                int idLop = rs.getInt("idLopHoc");
                int idGV = rs.getInt("idGiangVien");
                GiangVienDAO gvd = new GiangVienDAO();
                GiangVien gv = gvd.timGiangVienByID(idGV);
                vd.setGiangVien(gv);
                LopHocDAO lhd = new LopHocDAO();
                LopHoc lh = lhd.timLopByID(idLop);
                vd.setLopHoc(lh);
                listDD.add(vd);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listDD;
    }
    
    
    
}
