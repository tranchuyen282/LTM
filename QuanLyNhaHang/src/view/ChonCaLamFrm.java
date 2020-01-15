/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CaLamViecDAO;
import controller.ViecDangKyLamDAO;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import model.CaLamViec;
import model.ThanhVien;
import model.TuanLamViec;
import model.ViecDangKyLam;

class MyTableModel extends AbstractTableModel {
    private  ArrayList<CaLamViec> dsCaLam;
    private String[] columnNames = {"STT",
                                    "Thứ",
                                    "Ngày",
                                    "Thời gian",
                                    "Tổng NV",
                                    "Còn lại",
                                    "Chọn"};
    private Object[][] data ;

    public MyTableModel(ArrayList<CaLamViec> dsCaLam) {
        data = new Object[dsCaLam.size()][7];
        this.dsCaLam = dsCaLam;
        int i = 0;
        for(CaLamViec caLam: dsCaLam){
            data[i] = new Object[]{i+1,caLam.getThu(),caLam.getNgay().toString(),caLam.getGioBatDau().toString() +" - " + caLam.getGioKetThuc().toString() ,caLam.getSoLuongNhanVien(),caLam.getSoLuongNhanVien()-caLam.getSoLuongDaDangKy(),new Boolean(false)};
            i++;
        }
    }



    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

    }

public class ChonCaLamFrm extends javax.swing.JFrame {
  
    private DefaultTableModel model;
    private ThanhVien thanhVien;
    private TuanLamViec tlv;
    private CaLamViecDAO caLamViecDAO;
    private ViecDangKyLamDAO dangKyLamDAO;
    private ArrayList<CaLamViec> dsCaLam = null;
    private ArrayList<ViecDangKyLam> dsDaDK = null;
    private ArrayList<ViecDangKyLam> xoaDK = new ArrayList<ViecDangKyLam>();
    private ArrayList<ViecDangKyLam> themDK = new ArrayList<ViecDangKyLam>();
    private ArrayList<ViecDangKyLam> dsVDK = new ArrayList<ViecDangKyLam>();
    private JTable table;
    private int check = 1;
    
    public ChonCaLamFrm(ThanhVien thanhVien, TuanLamViec tlv) {
        initComponents();
        this.thanhVien = thanhVien;
        this.tlv = tlv;
        caLamViecDAO = new CaLamViecDAO();
        dangKyLamDAO = new ViecDangKyLamDAO();
        dsCaLam = caLamViecDAO.layDanhSachCaLam(tlv);
        dsDaDK = dangKyLamDAO.layDsVDKL(tlv.getId(),thanhVien.getId());
        filltblCaLam();
    }
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        SP = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        lbTuan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(179, 217, 255));

        jPanel2.setBackground(new java.awt.Color(232, 64, 60));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHỌN CA LÀM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(76, 175, 80));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thông tin tuần");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        btnLuu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(76, 175, 80));
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ok-icon.png"))); // NOI18N
        btnLuu.setText("Lưu Đăng Ký");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SP, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SP, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(102, 255, 51));

        lbTuan.setBackground(new java.awt.Color(255, 0, 0));
        lbTuan.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbTuan.setForeground(new java.awt.Color(255, 0, 0));
        lbTuan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTuan.setText("Tuần");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTuan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTuan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(323, 323, 323)
                                .addComponent(btnLuu)))
                        .addGap(69, 69, 69))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btnLuu)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filltblCaLam(){
        lbTuan.setText(" Từ "+tlv.getNgayBatDau() + " đến " + tlv.getNgayKetThuc());
        table = new JTable(new MyTableModel(dsCaLam));
        SP.setViewportView(table);
        TableColumn column = null;
        for (int i = 0; i < 7; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 3) {
                column.setPreferredWidth(100); //cột thứ 4 rộng hơn
            } else {
                column.setPreferredWidth(50);
            }
        }
        if(dsDaDK.size() > 0){
            System.out.println(dsDaDK.size());
            //update tblcalam
            check = 0;
            for(int i = 0; i < dsDaDK.size(); i++){
                for(int j = 0; j < dsCaLam.size(); j++){
                    if(dsDaDK.get(i).getCaLamViec().getId() == dsCaLam.get(j).getId()){
                        table.setValueAt(new Boolean(true), j, 6);
                    }
                }
            }
        }
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        xacNhanThoat();
    }//GEN-LAST:event_formWindowClosing

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        if(check == 1){
            for(int i = 0; i < dsCaLam.size(); i++){
                Boolean check = (Boolean) table.getValueAt(i,6);
               // System.out.println(check);
                if(check == true){
                    ViecDangKyLam vdk = new ViecDangKyLam();
                    vdk.setCaLamViec(dsCaLam.get(i));
                    vdk.setThanhVien(thanhVien);
                    dsVDK.add(vdk);
                }
            }
            
        }else{
            for(int i = 0; i < dsCaLam.size(); i++){
                Boolean check = (Boolean) table.getValueAt(i,6);
               // System.out.println(check);
                if(check == true){
                    ViecDangKyLam vdk = new ViecDangKyLam();
                    vdk.setCaLamViec(dsCaLam.get(i));
                    vdk.setThanhVien(thanhVien);
                    dsVDK.add(vdk);
                }
            }
            //tim nhung dang ky cu ma ko co trong dang ky moi
            for(int i = 0; i < dsDaDK.size();i++){
                int cs = 0;
                for(int j = 0; j < dsVDK.size(); j++){
                    if(dsDaDK.get(i).getCaLamViec().getId() == dsVDK.get(j).getCaLamViec().getId()){
                        cs = 1; break;
                    }
                }
                if(cs == 0) xoaDK.add(dsDaDK.get(i));
            }
            //tim nhung dang ky moi ma ko co trong dang ky cu
            for(int i = 0; i < dsVDK.size();i++){
                int cs = 0;
                for(int j = 0; j < dsDaDK.size(); j++){
                    if(dsDaDK.get(j).getCaLamViec().getId() == dsVDK.get(i).getCaLamViec().getId()){
                        cs = 1; break;
                    }
                }
                if(cs == 0) themDK.add(dsVDK.get(i));
            }
        }
        this.dispose();
        XacNhanFrm xacNhanFrm = new XacNhanFrm(dsVDK, xoaDK, themDK,thanhVien, tlv);
        xacNhanFrm.setVisible(true);
        xacNhanFrm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnLuuActionPerformed
    private void xacNhanThoat(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        int kQ = JOptionPane.showConfirmDialog(null,
                "Bạn có muốn thoát chương trình không ?","Confirm",JOptionPane.YES_NO_OPTION);
        if(kQ == 0){
            System.exit(0);
        }
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SP;
    private javax.swing.JButton btnLuu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbTuan;
    // End of variables declaration//GEN-END:variables
}
