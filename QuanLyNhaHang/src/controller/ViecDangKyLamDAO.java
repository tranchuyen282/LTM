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
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CaLamViec;
import model.DiaChi;
import model.HoVaTen;
import model.ThanhVien;
import model.TuanLamViec;
import model.ViecDangKyLam;

public class ViecDangKyLamDAO extends DAO{

    public ViecDangKyLamDAO() {
        getInstance();
    }
    
    public int ktSoLuongDangKy(ArrayList<ViecDangKyLam> dsVDK){
        int res = -1;
        int tong, daDK;
        for(int i = 0; i < dsVDK.size(); i++){
            try {     
                String query = "Select soLuongDaDangKy, soLuongNhanVien FROM tblcalamviec WHERE id ='" + dsVDK.get(i).getCaLamViec().getId()+ "'";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    tong = rs.getInt("soLuongNhanVien");
                    daDK = rs.getInt("soLuongDaDangKy");
                    if(tong == daDK){
                        return i;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(TuanLamViecDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return res;
    }
    
    public int luuDangKyLam(ArrayList<ViecDangKyLam> dsVDK ){
        int rep = -1;
		java.util.Date uDate = new java.util.Date();
		Timestamp timestamp = new Timestamp(uDate.getTime());
        for(int i = 0; i < dsVDK.size(); i++){
            try {     
                String query = "INSERT INTO tblviecdangkylam_vieccheckinout (thoiGianDangKy, CaLamViecid, thanhVienid) VALUES (?,?,?)";
                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setTimestamp(1, timestamp );
                ps.setInt(2,dsVDK.get(i).getCaLamViec().getId());
                ps.setInt(3,dsVDK.get(i).getThanhVien().getId());          
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    rep = rs.getInt(1);
                    // update bang calamviec
                    CaLamViecDAO caLamViecDAO = new CaLamViecDAO();
                    rep = caLamViecDAO.capNhatSauThemDangKy(dsVDK.get(i).getCaLamViec());
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(TuanLamViecDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rep;
    }
    
    public ViecDangKyLam getVDKL(int id){
        ViecDangKyLam vdkl = null;
        try {     
            String query = "Select * FROM tblviecdangkylam_vieccheckinout, tblcalamviec WHERE tblviecdangkylam_vieccheckinout.id = "+id+" "
                    + "AND tblcalamviec.id = tblviecdangkylam_vieccheckinout.CaLamViecid";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                CaLamViec clv = new CaLamViec(rs.getInt("tblcalamviec.id"), rs.getTime("tblcalamviec.gioBatDau"),
                        rs.getTime("tblcalamviec.gioKetThuc"), rs.getString("tblcalamviec.thu"), rs.getDate("tblcalamviec.ngay"),
                        rs.getInt("tblcalamviec.luongtrenca"), rs.getInt("tblcalamviec.soLuongNhanVien"), rs.getInt("tblcalamviec.soLuongDaDangKy"));
                NhanVienDAO nhanVienDAO = new NhanVienDAO();
                ThanhVien thanhVien = nhanVienDAO.getTV(rs.getInt("tblviecdangkylam_vieccheckinout.thanhVienid"));
                vdkl = new ViecDangKyLam(id, thanhVien, clv);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vdkl;
        
    }
    
    
    public ArrayList<ViecDangKyLam> layDsVDKL(int tuanLamViecid, int thanhVienid){
        ArrayList<ViecDangKyLam> ds = new ArrayList<ViecDangKyLam>();
        ViecDangKyLam vdkl = null;
        try {     
            String query = "Select * FROM tblviecdangkylam_vieccheckinout, tblcalamviec "
                    + "WHERE tblviecdangkylam_vieccheckinout.thanhVienid = "+thanhVienid+" "
                    + "AND tblcalamviec.id = tblviecdangkylam_vieccheckinout.CaLamViecid "
                    + "AND tblcalamviec.tuanLamViecid = "+tuanLamViecid;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CaLamViec clv = new CaLamViec(rs.getInt("tblcalamviec.id"), rs.getTime("tblcalamviec.gioBatDau"),
                        rs.getTime("tblcalamviec.gioKetThuc"), rs.getString("tblcalamviec.thu"), rs.getDate("tblcalamviec.ngay"),
                        rs.getInt("tblcalamviec.luongtrenca"), rs.getInt("tblcalamviec.soLuongNhanVien"), rs.getInt("tblcalamviec.soLuongDaDangKy"));
                NhanVienDAO nhanVienDAO = new NhanVienDAO();
                ThanhVien thanhVien = nhanVienDAO.getTV(rs.getInt("tblviecdangkylam_vieccheckinout.thanhVienid"));
                vdkl = new ViecDangKyLam(rs.getInt("tblviecdangkylam_vieccheckinout.id"), thanhVien, clv);
                ds.add(vdkl);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    public int xoaDKL(ArrayList<ViecDangKyLam> dsVDK ){
        int rep = -1;
        for(int i = 0; i < dsVDK.size(); i++){
            try {     
                String query = "DELETE FROM tblviecdangkylam_vieccheckinout WHERE id = "+ dsVDK.get(i).getId();
                PreparedStatement ps = con.prepareStatement(query);       
                rep = ps.executeUpdate();
                 // update bang calamviec
                if(rep != -1){
                    CaLamViecDAO caLamViecDAO = new CaLamViecDAO();
                    rep = caLamViecDAO.capNhatSauXoaDangKy(dsVDK.get(i).getCaLamViec());
                }
                
                    
                
            } catch (SQLException ex) {
                Logger.getLogger(TuanLamViecDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rep;
    }
    
    
 
}
