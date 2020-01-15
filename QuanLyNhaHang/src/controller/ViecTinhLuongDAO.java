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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CaLamViec;
import model.ThanhVien;
import model.ViecCheckInCheckOut;
import model.ViecTinhLuong;

public class ViecTinhLuongDAO extends DAO{

    public ViecTinhLuongDAO() {
        getInstance();
    }
    
    public ArrayList<ViecTinhLuong> layDSDaTinh(String thang){
        ArrayList<ViecTinhLuong> dsVTL = new ArrayList<ViecTinhLuong>();
        
        String query = "SELECT tblviectinh_traluong.* "
                + "FROM tblviectinh_traluong, tblthanhvien, tblhovaten "
                + "WHERE tblviectinh_traluong.thang = '"+thang+"' "
                + "AND tblviectinh_traluong.idThanhVien = tblthanhvien.id "
                + "AND tblthanhvien.HoVaTenid = tblhovaten.id";
            
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ViecCheckInCheckOutDAO checkInCheckOutDAO = new ViecCheckInCheckOutDAO();
                ArrayList<ViecCheckInCheckOut> dsCheckInCheckOut = checkInCheckOutDAO.layDsCIO(rs.getInt("id"));
                ViecTinhLuong vtl =  new ViecTinhLuong();
                vtl.setId(rs.getInt("id"));
                vtl.setDsCheckInOut(dsCheckInCheckOut);
                vtl.setThuongThem(rs.getInt("thuongThem"));
                vtl.setPhatThem(rs.getInt("phatThem"));
                vtl.setThang(rs.getInt("thang"));
                vtl.setThoiGianTinh(rs.getTimestamp("thoiGianTinh"));
                NhanVienDAO nhanVienDAO = new NhanVienDAO();
                ThanhVien thanhVien = nhanVienDAO.getTV(rs.getInt("idThanhVien"));
                vtl.setThanhVien(thanhVien);
                dsVTL.add(vtl);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ViecTinhLuongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
 
        
        return dsVTL;
        
    }
    
    
    public ArrayList<ViecTinhLuong> layDSChuaTinh(String thang){
        ArrayList<ViecTinhLuong> dsVTL = new ArrayList<ViecTinhLuong>();
        
        String query = "SELECT DISTINCT thanhVienid FROM tblviecdangkylam_vieccheckinout\n" +
                        "WHERE tblviecdangkylam_vieccheckinout.thanhVienid NOT IN\n" +
                        "(SELECT tblviectinh_traluong.idThanhVien FROM tblviectinh_traluong WHERE tblviectinh_traluong.thang = '"+thang+"')";
            
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ViecCheckInCheckOutDAO checkInCheckOutDAO = new ViecCheckInCheckOutDAO();
                ArrayList<ViecCheckInCheckOut> dsCheckInCheckOut = checkInCheckOutDAO.layDsCICOTheoThanhVien(rs.getInt("thanhVienid"));
                ViecTinhLuong vtl =  new ViecTinhLuong();
                vtl.setDsCheckInOut(dsCheckInCheckOut);
                NhanVienDAO nhanVienDAO = new NhanVienDAO();
                ThanhVien thanhVien = nhanVienDAO.getTV(rs.getInt("thanhVienid"));
                vtl.setThanhVien(thanhVien);
                dsVTL.add(vtl);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ViecTinhLuongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
 
        
        return dsVTL;
        
    }
    
    public int luuLuong(ViecTinhLuong vtl){
        int rep = 0;
        int maTraVe = 0;
        String sql = "INSERT INTO tblviectinh_traluong (thuongThem,phatThem,thoiGianTinh,thang,idHCNS, idThanhVien) VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, vtl.getThuongThem());
            ps.setInt(2, vtl.getPhatThem());
            ps.setTimestamp(3, vtl.getThoiGianTinh());
            ps.setInt(4, vtl.getThang());
            ps.setInt(5, vtl.getHcns().getId());
            ps.setInt(6, vtl.getThanhVien().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                maTraVe = rs.getInt(1);
                ViecCheckInCheckOutDAO checkInCheckOutDAO = new ViecCheckInCheckOutDAO();
                rep = checkInCheckOutDAO.updateIDLuong(maTraVe, vtl.getThanhVien().getId());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rep;
    }

}
