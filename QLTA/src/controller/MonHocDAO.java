package controller;
/*
 * @author Tran Chuyen
 */

import java.util.*;
import java.lang.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

public class MonHocDAO extends DAO{

    public MonHocDAO() {
        getInstance();
    }
    
    public ArrayList<MonHoc> getMonHoc(){
        ArrayList<MonHoc> dsMonHoc = new ArrayList<MonHoc>();
        try {
            String query = "Select * FROM tblmonhoc";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MonHoc monHoc = new MonHoc();
                monHoc.setId(rs.getInt("id"));
                monHoc.setMaMH(rs.getString("maMH"));
                monHoc.setTenMH(rs.getString("tenMonHoc"));
                LopHocPhanDAO lhpDAO = new LopHocPhanDAO();
                monHoc.setDsLopHocPhan(lhpDAO.getLHP(monHoc.getId()));
               // System.out.println(monHoc.toString());
                dsMonHoc.add(monHoc);
            }
   
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsMonHoc;
    }
     
    
}
