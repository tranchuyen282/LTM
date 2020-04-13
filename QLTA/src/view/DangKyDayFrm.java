/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MonHocDAO;
import controller.ViecDangKyDayDAO;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import model.*;
class MyTableModel extends AbstractTableModel {
    private MonHoc monHoc;
    private  ArrayList<LopHocPhan> dsLopHocPhan;
    private String[] columnNames = {"Chọn",
                                    "Mã MH",
                                    "Tên MH",
                                    "Nhóm LHP",
                                    "Thứ",
                                    "Tiết BĐ",
                                    "Số Tiết",
                                    "Phòng",
                                    "Tuần"};
    private Object[][] data ;

    public MyTableModel(MonHoc monHoc) {
        this.monHoc = monHoc;
        this.dsLopHocPhan = monHoc.getDsLopHocPhan();
        if(dsLopHocPhan.size()>0){
            data = new Object[dsLopHocPhan.size()][9];
            int i = 0;
            for(LopHocPhan lopHocPhan: dsLopHocPhan){
                data[i] = new Object[]{new Boolean(false),monHoc.getMaMH(),monHoc.getTenMH(),lopHocPhan.getNhomLHP(),lopHocPhan.getThu(),lopHocPhan.getTietBD(),lopHocPhan.getSoTiet(),lopHocPhan.getPhong(),lopHocPhan.getTuan()};
                i++;
            }
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
//        if (col < 2) {
//            return false;
//        } else {
//            return true;
//        }
        return true;
    }

    
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

    }

public class DangKyDayFrm extends javax.swing.JFrame {
    private ArrayList<MonHoc> dsMonHoc;
    private ArrayList<LopHocPhan> dsLopHocPhan;
    private ArrayList<ViecDangKyDay> dsDaDKD;
    private ArrayList<ViecDangKyDay> dsDKDMoi ;
    private ViecDangKyDayDAO vdkDAO;
    private ViecDangKyDay vdkd;
    private MonHocDAO monHocDAO;
    private GiangVien giangVien;
    private ArrayList<Integer> dscheckDK = new ArrayList<Integer>();
    
    private DefaultTableModel model;
    private ArrayList<JTable> listTable = new ArrayList<JTable>();
    
    private int saveIndex = 0;
    
    public DangKyDayFrm(GiangVien giangVien) {
        initComponents();
        model = (DefaultTableModel) jTableDSDK.getModel();
        model.setNumRows(0);
        
        this.giangVien = giangVien;
        vdkDAO = new ViecDangKyDayDAO();
        vdkd = new ViecDangKyDay();
        
        monHocDAO = new MonHocDAO();
                
        // load nhung lop hoc phan da dang ky
        loadData();
        
         //fill comboBox Mon hoc
        fillCbMonHoc();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        SP = new javax.swing.JScrollPane();
        btnLuu = new javax.swing.JButton();
        jCbMonHoc = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDSDK = new javax.swing.JTable();

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
        jLabel1.setText("Đăng ký dạy");

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
        jLabel3.setText("Chọn môn học");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnLuu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(76, 175, 80));
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ok-icon.png"))); // NOI18N
        btnLuu.setText("Lưu đăng ký");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jCbMonHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đảm bảo chất lượng phần mềm", "Item 2", "Item 3", "Item 4" }));
        jCbMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbMonHocActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(76, 175, 80));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Danh sách LHP đã chọn");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        jTableDSDK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã MH", "Tên MH", "Nhóm LHP", "Mã LHP", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(jTableDSDK);
        if (jTableDSDK.getColumnModel().getColumnCount() > 0) {
            jTableDSDK.getColumnModel().getColumn(0).setPreferredWidth(3);
            jTableDSDK.getColumnModel().getColumn(1).setPreferredWidth(3);
            jTableDSDK.getColumnModel().getColumn(2).setResizable(false);
            jTableDSDK.getColumnModel().getColumn(2).setPreferredWidth(10);
            jTableDSDK.getColumnModel().getColumn(3).setPreferredWidth(5);
            jTableDSDK.getColumnModel().getColumn(4).setResizable(false);
            jTableDSDK.getColumnModel().getColumn(4).setPreferredWidth(3);
            jTableDSDK.getColumnModel().getColumn(5).setResizable(false);
            jTableDSDK.getColumnModel().getColumn(5).setPreferredWidth(4);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCbMonHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(280, 280, 280))
            .addComponent(SP)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(381, 381, 381)
                        .addComponent(btnLuu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCbMonHoc)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SP, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLuu))
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

    private void loadData(){
        dsMonHoc = monHocDAO.getMonHoc();
        dsDaDKD = vdkDAO.getDsDaDKD(dsMonHoc,giangVien);// load nhung lop hoc phan dang ky da dc luu trong DB cua tat ca cac mon
        int i = 0;
        for(MonHoc mh:dsMonHoc){
            dscheckDK.add(1);
            if(mh.getDsLopHocPhan().size() > 0)
                initTable(mh, i);// khoi tao table1 ung voi tung mon hoc
            i++;
        }
       
        // show những lHP đã đki ra table 2
        fillTblDSDK();
    }
    
    private void fillTblDSDK(){
        int i = 1;
        for(ViecDangKyDay vdk: dsDaDKD){
            MonHoc mh = vdk.getMonHoc();
            for(LopHocPhan lhp: vdk.getDslopHocPhan()){
                model.addRow(new Object[]{
                    i++,mh.getMaMH(),mh.getTenMH(),lhp.getNhomLHP(),lhp.getMaLHP(),"Đã lưu vào CSDL"
                });
            }
        }
    }
    private void initTable(MonHoc mh, int cs){
        // khoi tao table chua ds lop hoc phan ung voi tung mon hoc
        JTable tablei = new JTable(new MyTableModel(mh)); 
        listTable.add(tablei);
        
        // thêm những lớp học phần đã đki và lưu trong DB
        ViecDangKyDay vdkCu = dsDaDKD.get(cs);
        if(vdkCu.getDslopHocPhan().size() > 0){
            dscheckDK.set(cs, 0); // MH da co dki cu
            for(int i = 0; i < vdkCu.getDslopHocPhan().size(); i++){
                for(int j = 0; j < mh.getDsLopHocPhan().size();j++){
                   if(vdkCu.getDslopHocPhan().get(i).getId() == mh.getDsLopHocPhan().get(j).getId()){
                       tablei.setValueAt(new Boolean(true), j, 0);
                   }
                }
            }
        }
    }
    private void fillCbMonHoc(){
        jCbMonHoc.removeAllItems();
        for(MonHoc mh:dsMonHoc){
            jCbMonHoc.addItem(mh.getTenMH());
        }
    }
    private void fillTblLopHocPhan(int cs){
        // lưu lại những đki của selected index cb trc vao list
        //saveToList(saveIndex);
        
        
        // hiển thị danh sách các lớp học phần của môn học tương ứng
        MonHoc mh = dsMonHoc.get(cs);
        if(mh.getDsLopHocPhan().size()>0){
            // hien thi table neu co ds lop hoc phan
            JTable tablei = listTable.get(cs);
            SP.setViewportView(tablei);
            TableColumn column = null;
            
            // set width columm
            for (int i = 0; i < 9; i++) {
                column = tablei.getColumnModel().getColumn(i);
                if (i == 2) {
                    column.setPreferredWidth(200); //cột thứ 3 rộng hơn
                } else if(i == 8) {
                    column.setPreferredWidth(80);
                }else{
                    column.setPreferredWidth(40);
                }
            }
            saveIndex = cs;
        }else{
            // neu chua co ds lhp, hien thi lai danh sach gan nhat
            JOptionPane.showMessageDialog(this, "Môn học chưa có lớp học phần");
            jCbMonHoc.setSelectedIndex(saveIndex);
        }
        
        
    }
    
    private void saveToList(int cs){
        for(int i = 0; i < dsMonHoc.size(); i++){
            if(dscheckDK.get(i) == 1){ // hoan toan la dki moi => luu toan bo
                ViecDangKyDay vdk = new ViecDangKyDay();
                vdk.setMonHoc(dsMonHoc.get(i));
                vdk.setGiangVien(giangVien);
                ArrayList<LopHocPhan> dsLopDK = new ArrayList<LopHocPhan>();
                
                
            }
        }
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        xacNhanThoat();
    }//GEN-LAST:event_formWindowClosing

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        
    }//GEN-LAST:event_btnLuuActionPerformed

    private void jCbMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbMonHocActionPerformed
        // TODO add your handling code here:
        int cs = jCbMonHoc.getSelectedIndex();
        
        //System.out.println(cs);
        if(cs >= 0){
            fillTblLopHocPhan(cs);
        }
    }//GEN-LAST:event_jCbMonHocActionPerformed
    private void xacNhanThoat(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        int kQ = JOptionPane.showConfirmDialog(null,
                "Bạn có muốn thoát chương trình không ?","Confirm",JOptionPane.YES_NO_OPTION);
        if(kQ == 0){
            System.exit(0);
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DangKyDayFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKyDayFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKyDayFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKyDayFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new DangKyDayFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SP;
    private javax.swing.JButton btnLuu;
    private javax.swing.JComboBox<String> jCbMonHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDSDK;
    // End of variables declaration//GEN-END:variables
}
