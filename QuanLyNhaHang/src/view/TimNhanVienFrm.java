package view;

import controller.TuanLamViecDAO;
import controller.ViecTinhLuongDAO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CaLamViec;
import model.ThanhVien;
import model.TuanLamViec;
import model.ViecCheckInCheckOut;
import model.ViecTinhLuong;


public class TimNhanVienFrm extends javax.swing.JFrame {

    private DefaultTableModel model;
    private ThanhVien thanhVien;
    private ArrayList<ViecTinhLuong> dsVTL = null;
    private ArrayList<ViecTinhLuong> dsChuaTinhLuong;
    private ViecTinhLuongDAO viecTinhLuongDAO;
    private int csthang;
    
    public TimNhanVienFrm(ThanhVien thanhVien, int csthang) {
        initComponents();
        this.thanhVien = thanhVien;
        this.csthang = csthang;
        model = (DefaultTableModel) tblNhanVien.getModel();
        viecTinhLuongDAO = new ViecTinhLuongDAO();
        fillCbThang();
        if(csthang != -1){
            jcbThang.setSelectedIndex(csthang-1);
            model.setNumRows(0);
            dsVTL = viecTinhLuongDAO.layDSDaTinh(String.valueOf(csthang));
            dsChuaTinhLuong = viecTinhLuongDAO.layDSChuaTinh(String.valueOf(csthang));
            if(dsVTL.size() > 0){
                tinhluong();
                filltblNhanVien(); 
            }else{
                JOptionPane.showMessageDialog(this, "Không có thông tin");
            }
        }
        
        
           
    }
    
    private void fillCbThang() {
        for(int i = 1; i <= 12; i++){
            jcbThang.addItem(Integer.toString(i));
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
        jcbThang = new javax.swing.JComboBox<>();
        jPTable = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        btnChon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(179, 217, 255));

        jPanel2.setBackground(new java.awt.Color(232, 64, 60));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tìm nhân viên");

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
                .addGap(145, 145, 145)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbThang, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(98, 98, 98))
        );

        jPTable.setBackground(new java.awt.Color(179, 217, 255));

        tblNhanVien.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên", "Chức vụ", "Tiền lương", "Trạng thái", "Thời gian tính"
            }
        ));
        tblNhanVien.setAutoscrolls(false);
        jScrollPane.setViewportView(tblNhanVien);
        if (tblNhanVien.getColumnModel().getColumnCount() > 0) {
            tblNhanVien.getColumnModel().getColumn(0).setResizable(false);
            tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblNhanVien.getColumnModel().getColumn(1).setResizable(false);
            tblNhanVien.getColumnModel().getColumn(1).setPreferredWidth(5);
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
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1184, Short.MAX_VALUE)
            .addGroup(jPTableLayout.createSequentialGroup()
                .addGap(498, 498, 498)
                .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPTableLayout.setVerticalGroup(
            jPTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnChon)
                .addContainerGap())
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        model.setNumRows(0);
        String thang = (String)jcbThang.getSelectedItem();
        csthang = Integer.parseInt(thang);
        dsVTL = viecTinhLuongDAO.layDSDaTinh(thang);
        dsChuaTinhLuong = viecTinhLuongDAO.layDSChuaTinh(thang);
        if(dsVTL.size() > 0){
            tinhluong();
            filltblNhanVien(); 
        }else{
            JOptionPane.showMessageDialog(this, "Không có thông tin");
        }

    }//GEN-LAST:event_btnTimActionPerformed
    private void filltblNhanVien(){
        int i = 1;
        for(ViecTinhLuong vtl : dsVTL){
            model.addRow(new Object[]{
                i++,vtl.getThanhVien().getHoTen().getHo()+" "+ vtl.getThanhVien().getHoTen().getTen(),vtl.getThanhVien().getVaiTro(),vtl.getTongLuong(),"Đã tính",vtl.getThoiGianTinh()
            });
        }
        for(ViecTinhLuong vtl : dsChuaTinhLuong){
            vtl.setThang(Integer.parseInt((String) jcbThang.getSelectedItem()));
            model.addRow(new Object[]{
                i++,vtl.getThanhVien().getHoTen().getHo()+" "+ vtl.getThanhVien().getHoTen().getTen(),vtl.getThanhVien().getVaiTro(),"","Chưa tính",""
            });
        }
    }
    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        int cs = tblNhanVien.getSelectedRow();
        if(cs == -1){
            JOptionPane.showMessageDialog(this, "Hãy chọn 1 nhân viên trong bảng");
        }else{
            //this.dispose();
            if(cs < dsVTL.size()){
                ChiTietLuongFrm chiTietLuongFrm = new ChiTietLuongFrm(thanhVien,dsVTL.get(cs), csthang, 1);
                this.dispose();
                chiTietLuongFrm.setVisible(true);
                chiTietLuongFrm.setLocationRelativeTo(null);
            }else{
                this.dispose();
                ChiTietCongFrm chiTietCongFrm = new ChiTietCongFrm(thanhVien, dsChuaTinhLuong.get(cs-dsVTL.size()),csthang,1);
                chiTietCongFrm.setVisible(true);
                chiTietCongFrm.setLocationRelativeTo(null);
            }
        }
    }//GEN-LAST:event_btnChonActionPerformed
    private void tinhluong() {
        for(int i = 0; i < dsVTL.size(); i++){
            ArrayList<ViecCheckInCheckOut> dsCIO = dsVTL.get(i).getDsCheckInOut();
            int luongTheoCong = 0, phatCICO = 0, tongCong = 0;
            int gioTangCa = 0;
            for(ViecCheckInCheckOut vcio:dsCIO){
                int luong = 0;
                CaLamViec clv = vcio.getVdkl().getCaLamViec();
                Date gioBatDau = clv.getGioBatDau();
                Date gioCI = vcio.getGioCheckIn();
                Date gioKetThuc = clv.getGioKetThuc();
                Date gioCO = vcio.getGioCheckOut();
                if(gioCI != null && gioCO != null){
                    if(gioBatDau.before(gioCI)){
                        phatCICO += 10;
                    }
                    if(gioCO.before(gioKetThuc)) {
                        phatCICO += 10;
                    }
                    else{
                        gioTangCa += gioCO.getHours() - gioKetThuc.getHours();
                    }
                    luongTheoCong += clv.getLuongTrenCa();
                    tongCong += 1;
                }
                
            }
            dsVTL.get(i).setHcns(thanhVien);
            dsVTL.get(i).setTienPhatCICO(phatCICO);
            dsVTL.get(i).setTongCong(tongCong);
            dsVTL.get(i).setGioTangCa(gioTangCa);
            dsVTL.get(i).setTienTangCa(gioTangCa*25);
            dsVTL.get(i).setLuongTheoCong(luongTheoCong);
            dsVTL.get(i).setTongLuong(luongTheoCong + gioTangCa*25 - phatCICO + dsVTL.get(i).getThuongThem() - dsVTL.get(i).getPhatThem() );
        }
        
    }
 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnTim;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JComboBox<String> jcbThang;
    private javax.swing.JTable tblNhanVien;
    // End of variables declaration//GEN-END:variables

    

    
}
