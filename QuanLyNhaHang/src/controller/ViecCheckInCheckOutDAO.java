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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ThanhVien;
import model.ViecCheckInCheckOut;
import model.ViecDangKyLam;
import model.ViecTinhLuong;

public class ViecCheckInCheckOutDAO extends DAO{

    public ViecCheckInCheckOutDAO() {
        getInstance();
    }
    
    public ArrayList<ViecCheckInCheckOut> layDsCIO(int id){
        ArrayList<ViecCheckInCheckOut> ds = new ArrayList<ViecCheckInCheckOut>();
        String query = "SELECT * FROM tblviecdangkylam_vieccheckinout "
                + "WHERE ViecTinhTraLuongid = "+ id;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVienDAO nhanVienDAO = new NhanVienDAO();
                ThanhVien thanhVien = nhanVienDAO.getTV(rs.getInt("thanhVienid"));
                ViecDangKyLamDAO dangKyLamDAO = new ViecDangKyLamDAO();
                ViecDangKyLam vdkl = dangKyLamDAO.getVDKL(rs.getInt("id"));
                ViecCheckInCheckOut vcio = new ViecCheckInCheckOut(rs.getInt("id"), rs.getTime("gioCheckIn"), rs.getTime("gioCheckOut"),thanhVien,vdkl);
                ds.add(vcio);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ViecCheckInCheckOutDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ds;
    }
    
    public ArrayList<ViecCheckInCheckOut> layDsCICOTheoThanhVien(int thanhVienid){
        ArrayList<ViecCheckInCheckOut> ds = new ArrayList<ViecCheckInCheckOut>();
        String query = "SELECT * FROM tblviecdangkylam_vieccheckinout "
                +       "WHERE thanhVienid = "+ thanhVienid;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVienDAO nhanVienDAO = new NhanVienDAO();
                ThanhVien thanhVien = nhanVienDAO.getTV(rs.getInt("thanhVienid"));
                ViecDangKyLamDAO dangKyLamDAO = new ViecDangKyLamDAO();
                ViecDangKyLam vdkl = dangKyLamDAO.getVDKL(rs.getInt("id"));
                ViecCheckInCheckOut vcio = new ViecCheckInCheckOut(rs.getInt("id"), rs.getTime("gioCheckIn"), rs.getTime("gioCheckOut"),thanhVien,vdkl);
                ds.add(vcio);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ViecCheckInCheckOutDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ds;
    }
    
    
    public int updateIDLuong(int viecTinhTraLuongid, int thanhVienid){
        int rep = -1;
        String sql = "UPDATE tblviecdangkylam_vieccheckinout SET ViecTinhTraLuongid = '"+viecTinhTraLuongid
                    + "' WHERE thanhVienid = '"+thanhVienid+"'";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            rep = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
        
    }
    
}
