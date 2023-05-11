
package gui.views;


import gui.controllers.QuanLyChucVuController;
import gui.models.NhanVien.ChucVuModel;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class QuanLyChucVu_GUI extends javax.swing.JFrame {
    

    public QuanLyChucVu_GUI() {
        initComponents();
    }
    
    public void loadTableChucVu (ArrayList<ChucVuModel> listChucVuModel){
        String col[] = {"ID", "Tên loại bàn"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        tblDanhSachChucVu.setModel(tableModel);
        for(ChucVuModel row : listChucVuModel){
            Object[] data = {row.getId(), row.getTen()};
            tableModel.addRow(data);
        }
    }
    
    
     public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuanLyChucVuController();
            }
        });
    }
    
   

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachChucVu = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        pnlQuanLyChucVu = new javax.swing.JPanel();
        btnThemChucVu = new javax.swing.JButton();
        btnSuaChucVu = new javax.swing.JButton();
        btnXoaChucVu = new javax.swing.JButton();
        pnlThemSuaChucVu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnResetChucVu = new javax.swing.JButton();
        btnLuuChucVu = new javax.swing.JButton();
        txtIDChucVu = new javax.swing.JTextField();
        txtChucVu = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý chức vụ");
        setMinimumSize(new java.awt.Dimension(520, 360));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách chức vụ"));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        tblDanhSachChucVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Chức vụ"
            }
        ));
        jScrollPane1.setViewportView(tblDanhSachChucVu);

        jPanel1.add(jScrollPane1);

        getContentPane().add(jPanel1);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.PAGE_AXIS));

        pnlQuanLyChucVu.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        pnlQuanLyChucVu.setMinimumSize(new java.awt.Dimension(300, 40));
        pnlQuanLyChucVu.setPreferredSize(new java.awt.Dimension(300, 40));
        pnlQuanLyChucVu.setLayout(new java.awt.GridBagLayout());

        btnThemChucVu.setText("Thêm");
        btnThemChucVu.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlQuanLyChucVu.add(btnThemChucVu, gridBagConstraints);

        btnSuaChucVu.setText("Sửa");
        btnSuaChucVu.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlQuanLyChucVu.add(btnSuaChucVu, gridBagConstraints);

        btnXoaChucVu.setText("Xoá");
        btnXoaChucVu.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlQuanLyChucVu.add(btnXoaChucVu, gridBagConstraints);

        jPanel3.add(pnlQuanLyChucVu);

        pnlThemSuaChucVu.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm Chức Vụ Mới"));
        pnlThemSuaChucVu.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemSuaChucVu.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Chức vụ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemSuaChucVu.add(jLabel2, gridBagConstraints);

        btnResetChucVu.setText("Reset");
        btnResetChucVu.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 2);
        pnlThemSuaChucVu.add(btnResetChucVu, gridBagConstraints);

        btnLuuChucVu.setText("Lưu");
        btnLuuChucVu.setFocusable(false);
        btnLuuChucVu.setMaximumSize(new java.awt.Dimension(90, 23));
        btnLuuChucVu.setMinimumSize(new java.awt.Dimension(90, 23));
        btnLuuChucVu.setPreferredSize(new java.awt.Dimension(90, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 2, 4, 20);
        pnlThemSuaChucVu.add(btnLuuChucVu, gridBagConstraints);

        txtIDChucVu.setEnabled(false);
        txtIDChucVu.setMinimumSize(new java.awt.Dimension(80, 22));
        txtIDChucVu.setPreferredSize(new java.awt.Dimension(80, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
        pnlThemSuaChucVu.add(txtIDChucVu, gridBagConstraints);
        txtIDChucVu.getAccessibleContext().setAccessibleParent(pnlQuanLyChucVu);

        txtChucVu.setMinimumSize(new java.awt.Dimension(100, 22));
        txtChucVu.setPreferredSize(new java.awt.Dimension(100, 22));
        txtChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChucVuActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
        pnlThemSuaChucVu.add(txtChucVu, gridBagConstraints);

        jPanel3.add(pnlThemSuaChucVu);

        getContentPane().add(jPanel3);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChucVuActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnLuuChucVu;
    public javax.swing.JButton btnResetChucVu;
    public javax.swing.JButton btnSuaChucVu;
    public javax.swing.JButton btnThemChucVu;
    public javax.swing.JButton btnXoaChucVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlQuanLyChucVu;
    public javax.swing.JPanel pnlThemSuaChucVu;
    public javax.swing.JTable tblDanhSachChucVu;
    public javax.swing.JTextField txtChucVu;
    public javax.swing.JTextField txtIDChucVu;
    // End of variables declaration//GEN-END:variables
}
