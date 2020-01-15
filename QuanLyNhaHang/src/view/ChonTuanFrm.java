package view;

import controller.TuanLamViecDAO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ThanhVien;
import model.TuanLamViec;


public class ChonTuanFrm extends javax.swing.JFrame {

    private DefaultTableModel model;
    private ThanhVien thanhVien;
    private TuanLamViecDAO tuanLamViecDAO;
    private ArrayList<TuanLamViec> dsTuan = null;
    
    public ChonTuanFrm(ThanhVien thanhVien) {
        initComponents();
        this.thanhVien = thanhVien;
        tuanLamViecDAO = new TuanLamViecDAO();
        model = (DefaultTableModel) tblTuan.getModel();
        fillCbThang();
           
    }
    
    private void fillCbThang() {
        for(int i = 1; i <= 12; i++){
            cbThang.addItem(Integer.toString(i));
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new java.awt.Canvas();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnTim = new javax.swing.JButton();
        cbThang = new javax.swing.JComboBox<>();
        jPTable = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        tblTuan = new javax.swing.JTable();
        btnChon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(179, 217, 255));

        jPanel2.setBackground(new java.awt.Color(232, 64, 60));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chọn tuần đăng ký");

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
        jLabel3.setText("Chọn tháng");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        btnTim.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnTim.setForeground(new java.awt.Color(76, 175, 80));
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/timkiem.png"))); // NOI18N
        btnTim.setText("Tìm Kiếm");
        btnTim.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbThang, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jPTable.setBackground(new java.awt.Color(179, 217, 255));

        tblTuan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tblTuan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên", "Thời gian"
            }
        ));
        tblTuan.setAutoscrolls(false);
        jScrollPane.setViewportView(tblTuan);
        if (tblTuan.getColumnModel().getColumnCount() > 0) {
            tblTuan.getColumnModel().getColumn(0).setResizable(false);
            tblTuan.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblTuan.getColumnModel().getColumn(1).setResizable(false);
            tblTuan.getColumnModel().getColumn(1).setPreferredWidth(5);
        }

        btnChon.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnChon.setForeground(new java.awt.Color(76, 175, 80));
        btnChon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ok-icon.png"))); // NOI18N
        btnChon.setText("Chọn");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPTableLayout = new javax.swing.GroupLayout(jPTable);
        jPTable.setLayout(jPTableLayout);
        jPTableLayout.setHorizontalGroup(
            jPTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTableLayout.createSequentialGroup()
                .addGap(357, 357, 357)
                .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(359, Short.MAX_VALUE))
            .addComponent(jScrollPane)
        );
        jPTableLayout.setVerticalGroup(
            jPTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        model.setNumRows(0);
        String thang = (String)cbThang.getSelectedItem();
        dsTuan = tuanLamViecDAO.timTuanTheoThang(thang);
        if(dsTuan.size() > 0){
            filltblTuan(); 
        }else{
            JOptionPane.showMessageDialog(this, "Nhập đầy đủ thông tin");
        }

    }//GEN-LAST:event_btnTimActionPerformed
    private void filltblTuan(){
        int i = 1;
        for(TuanLamViec tuan : dsTuan){
            model.addRow(new Object[]{
                i, "Tuần " + i,tuan.getNgayBatDau().toString() + " - " + tuan.getNgayKetThuc().toString()
            });
            i++;
        }
    }
    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        int cs = tblTuan.getSelectedRow();
        if(cs == -1){
            JOptionPane.showMessageDialog(this, "Hãy chọn 1 tuần trong bảng");
        }else{
            int chot = dsTuan.get(cs).getNgayBatDau().getDate() - 2;
            int ht = new Date().getDate();
            //ht > chot
            if(ht>chot){
                JOptionPane.showMessageDialog(this, "Quá thời gian đăng ký");
            }else{
                this.dispose();
                ChonCaLamFrm caLamFrm = new ChonCaLamFrm(thanhVien, dsTuan.get(cs));
                caLamFrm.setVisible(true);
                caLamFrm.setLocationRelativeTo(null);
            }
            
        }
    }//GEN-LAST:event_btnChonActionPerformed

 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnTim;
    private java.awt.Canvas canvas1;
    private javax.swing.JComboBox<String> cbThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable tblTuan;
    // End of variables declaration//GEN-END:variables

    
}
