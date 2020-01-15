/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ViecDangKyLamDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ThanhVien;
import model.TuanLamViec;
import model.ViecDangKyLam;


/**
 *
 * @author Tran Chuyen
 */
public class XacNhanFrm extends javax.swing.JFrame {

    private DefaultTableModel model;
    private ArrayList<ViecDangKyLam> dsVDK;
    private ThanhVien thanhVien;
    private TuanLamViec tlv;
    private ViecDangKyLamDAO viecDangKyLamDAO;
    private int check = 1;
    private ArrayList<ViecDangKyLam> xoaDK ;
    private ArrayList<ViecDangKyLam> themDK;
    
    
    public XacNhanFrm(ArrayList<ViecDangKyLam> dsVDK,ArrayList<ViecDangKyLam> xoaDK, ArrayList<ViecDangKyLam> themDK, ThanhVien thanhVien,TuanLamViec tlv ) {
        initComponents();
        this.dsVDK = dsVDK;
        this.thanhVien = thanhVien;
        this.tlv = tlv;
        this.xoaDK = xoaDK;
        this.themDK = themDK;
        if(xoaDK.size() > 0 || themDK.size() > 0) check = 0;
        viecDangKyLamDAO = new ViecDangKyLamDAO();
        lbTen.setText("Họ tên: " + thanhVien.getHoTen().getHo() + " " +thanhVien.getHoTen().getTen());
        lbSDT.setText("Chức vụ: " + thanhVien.getVaiTro());
        lbTenLop.setText("Thời gian: ");
        lbThoiGianHoc.setText(tlv.getNgayBatDau().toString() + "-" +tlv.getNgayKetThuc().toString());
        model = (DefaultTableModel) tbDD.getModel();
        fillTbDD();
        
    }
    private void fillTbDD(){
        model.setNumRows(0);
        int i = 1;
        for(ViecDangKyLam vdk : dsVDK){
            model.addRow(new Object[]{
                i++,vdk.getCaLamViec().getThu(),vdk.getCaLamViec().getNgay().toString(),vdk.getCaLamViec().getGioBatDau().toString() +" - " + vdk.getCaLamViec().getGioKetThuc().toString()
            });
            
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbSDT = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbTen = new javax.swing.JLabel();
        lbTenLop = new javax.swing.JLabel();
        lbNgayBD = new javax.swing.JLabel();
        lbThoiGianHoc = new javax.swing.JLabel();
        btnHuy = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDD = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(179, 217, 255));

        jPanel2.setBackground(new java.awt.Color(232, 64, 60));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Xác nhận đăng ký");

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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nhân viên");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbSDT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbSDT.setForeground(new java.awt.Color(76, 175, 80));
        lbSDT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tuần ");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbTen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbTen.setForeground(new java.awt.Color(76, 175, 80));
        lbTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbTenLop.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbTenLop.setForeground(new java.awt.Color(76, 175, 80));
        lbTenLop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbNgayBD.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbNgayBD.setForeground(new java.awt.Color(76, 175, 80));
        lbNgayBD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbThoiGianHoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbThoiGianHoc.setForeground(new java.awt.Color(76, 175, 80));
        lbThoiGianHoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbThoiGianHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lbThoiGianHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );

        btnHuy.setBackground(new java.awt.Color(255, 255, 255));
        btnHuy.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(76, 175, 80));
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cancel-icon.png"))); // NOI18N
        btnHuy.setText("Chọn lại");
        btnHuy.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnXacNhan.setBackground(new java.awt.Color(255, 255, 255));
        btnXacNhan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnXacNhan.setForeground(new java.awt.Color(76, 175, 80));
        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ok-icon.png"))); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        tbDD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Thứ", "Ngày", "Thời gian"
            }
        ));
        jScrollPane1.setViewportView(tbDD);
        if (tbDD.getColumnModel().getColumnCount() > 0) {
            tbDD.getColumnModel().getColumn(0).setResizable(false);
            tbDD.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbDD.getColumnModel().getColumn(1).setResizable(false);
            tbDD.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap(135, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ChonCaLamFrm caLamFrm = new ChonCaLamFrm(thanhVien, tlv);
        caLamFrm.setVisible(true);
        caLamFrm.setLocationRelativeTo(null);
        
        
       
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        if(check == 1){
            int rep = viecDangKyLamDAO.ktSoLuongDangKy(dsVDK);
            if(rep == -1){
                int rep2 = viecDangKyLamDAO.luuDangKyLam(dsVDK);
                if(rep2 != -1){
                    int kQ = JOptionPane.showConfirmDialog(null,"Đăng ký thành công","Thông báo", JOptionPane.YES_OPTION);
                    if(kQ == 0){
                        this.dispose();
                        HCNSFrm hcnsFrm = new HCNSFrm(thanhVien);
                        hcnsFrm.setVisible(true);
                        hcnsFrm.setLocationRelativeTo(null);
                    }
                }else 
                    JOptionPane.showMessageDialog(this, "Not OK");
            }else{
                JOptionPane.showMessageDialog(this, "Hết slot");
                this.dispose();
                ChonCaLamFrm caLamFrm = new ChonCaLamFrm(thanhVien, tlv);
                caLamFrm.setVisible(true);
                caLamFrm.setLocationRelativeTo(null);

            }
        }
        else{
            int checkThem = 1, checkXoa = 0;
            if(themDK.size() > 0){
                int rep = viecDangKyLamDAO.ktSoLuongDangKy(themDK);
                if(rep == -1){
                    int rep2 = viecDangKyLamDAO.luuDangKyLam(themDK);
                    if(rep2 != -1){
                        
                    }else 
                        JOptionPane.showMessageDialog(this, "Not OK");
                        checkThem = 0;
                }else{
                    checkThem = 0;
                    JOptionPane.showMessageDialog(this, "Hết slot");
                    this.dispose();
                    ChonCaLamFrm caLamFrm = new ChonCaLamFrm(thanhVien, tlv);
                    caLamFrm.setVisible(true);
                    caLamFrm.setLocationRelativeTo(null);

                }
                
            }
            if(xoaDK.size() > 0){
                if(checkThem == 1){
                    int xoa = viecDangKyLamDAO.xoaDKL(xoaDK);
                    if(xoa != -1){
                        checkXoa = 1;
                        int kQ = JOptionPane.showConfirmDialog(null,"Đăng ký thành công","Thông báo", JOptionPane.YES_OPTION);
                        if(kQ == 0){
                            this.dispose();
                            HCNSFrm hcnsFrm = new HCNSFrm(thanhVien);
                            hcnsFrm.setVisible(true);
                            hcnsFrm.setLocationRelativeTo(null);
                        }
                    }
                }
                
            }
            if(checkXoa == 0){
                int kQ = JOptionPane.showConfirmDialog(null,"Đăng ký thành công","Thông báo", JOptionPane.YES_OPTION);
                if(kQ == 0){
                    this.dispose();
                    HCNSFrm hcnsFrm = new HCNSFrm(thanhVien);
                    hcnsFrm.setVisible(true);
                    hcnsFrm.setLocationRelativeTo(null);
                }
            }
            
            
            
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void xacNhanThoat(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        int kQ = JOptionPane.showConfirmDialog(null,
                "Bạn có muốn thoát chương trình không ?","Confirm",JOptionPane.YES_NO_OPTION);
        if(kQ == 0){
            System.exit(0);
        }
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNgayBD;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbTen;
    private javax.swing.JLabel lbTenLop;
    private javax.swing.JLabel lbThoiGianHoc;
    private javax.swing.JTable tbDD;
    // End of variables declaration//GEN-END:variables
}
