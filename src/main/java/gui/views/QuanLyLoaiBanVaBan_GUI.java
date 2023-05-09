
package gui.views;

import gui.models.Ban.TinhTrangBanModel;
import gui.models.BanModel;
import gui.models.LoaiBanModel;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class QuanLyLoaiBanVaBan_GUI extends javax.swing.JPanel {
    public QuanLyLoaiBanVaBan_GUI() {
        initComponents();
    }
    
    public void loadTableLoaiBan(ArrayList<LoaiBanModel> listLoaiBanModel){
        String col[] = {"ID", "Tên loại bàn", "Số chỗ ngồi"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        tblLoaiBan.setModel(tableModel);
        for(LoaiBanModel row : listLoaiBanModel){
            Object[] data = {row.getId(), row.getTen(), row.getSoLuongCho()};
            tableModel.addRow(data);
        }
    }
    
    public void loadTableBan(ArrayList<BanModel> listBan){
        String col[] = {"ID", "Tên loại bàn", "Tình trạng"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        tblBan.setModel(tableModel);
        for(BanModel ban : listBan){
            Object[] data = {ban.getId(), ban.getLoaiBan(), ban.getTinhTrangBan()};
            tableModel.addRow(data);
        }
    }
    
    public void loadComboBoxLoaiBan(ArrayList<LoaiBanModel> listLoaiBan){
        cmbLoaiBan.removeAllItems();
        for(LoaiBanModel loaiBan : listLoaiBan){            
            cmbLoaiBan.addItem(loaiBan.getTen());
        }      
        
        cmbLoaiBan.setSelectedIndex(-1);
    }
    
    public void loadComboBoxTinhTrangBan(ArrayList<TinhTrangBanModel> listTinhTrangBan){
        cmbTinhTrangBan.removeAllItems();
        for(TinhTrangBanModel ttb : listTinhTrangBan){
            cmbTinhTrangBan.addItem(ttb.getTen());
        }        
        
        cmbTinhTrangBan.setSelectedIndex(-1);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLoaiBan = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnThemLoaiBan = new javax.swing.JButton();
        btnSuaLoaiBan = new javax.swing.JButton();
        btnXoaLoaiBan = new javax.swing.JButton();
        pnlThemSuaLoaiBan = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtIDLoaiBan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTenLoaiBan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSoChoNgoi = new javax.swing.JTextField();
        btnResetLoaiBan = new javax.swing.JButton();
        btnLuuLoaiBan = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBan = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnThemBan = new javax.swing.JButton();
        btnSuaBan = new javax.swing.JButton();
        btnXoaBan = new javax.swing.JButton();
        pnlThemSuaBan = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtIdBan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnResetBan = new javax.swing.JButton();
        btnLuuBan = new javax.swing.JButton();
        cmbLoaiBan = new javax.swing.JComboBox<>();
        cmbTinhTrangBan = new javax.swing.JComboBox<>();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý loại bàn"));
        jPanel1.setMinimumSize(new java.awt.Dimension(685, 253));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách loại bàn"));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane2.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(387, 197));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(387, 197));

        tblLoaiBan.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        tblLoaiBan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblLoaiBan);

        jPanel2.add(jScrollPane2);

        jPanel1.add(jPanel2);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng cho loại bàn"));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 56));

        btnThemLoaiBan.setText("Thêm");
        btnThemLoaiBan.setEnabled(false);
        jPanel3.add(btnThemLoaiBan);

        btnSuaLoaiBan.setText("Sửa");
        jPanel3.add(btnSuaLoaiBan);

        btnXoaLoaiBan.setText("Xóa");
        jPanel3.add(btnXoaLoaiBan);

        jPanel4.add(jPanel3);

        pnlThemSuaLoaiBan.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm loại bàn mới"));
        pnlThemSuaLoaiBan.setToolTipText("");
        pnlThemSuaLoaiBan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlThemSuaLoaiBan.setName(""); // NOI18N
        pnlThemSuaLoaiBan.setLayout(new java.awt.GridBagLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("ID");
        jLabel4.setToolTipText("");
        jLabel4.setMaximumSize(new java.awt.Dimension(80, 24));
        jLabel4.setMinimumSize(new java.awt.Dimension(80, 24));
        jLabel4.setPreferredSize(new java.awt.Dimension(80, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlThemSuaLoaiBan.add(jLabel4, gridBagConstraints);

        txtIDLoaiBan.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIDLoaiBan.setToolTipText("");
        txtIDLoaiBan.setActionCommand("null");
        txtIDLoaiBan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtIDLoaiBan.setEnabled(false);
        txtIDLoaiBan.setMaximumSize(new java.awt.Dimension(160, 24));
        txtIDLoaiBan.setMinimumSize(new java.awt.Dimension(160, 24));
        txtIDLoaiBan.setPreferredSize(new java.awt.Dimension(160, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        pnlThemSuaLoaiBan.add(txtIDLoaiBan, gridBagConstraints);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Tên loại bàn");
        jLabel5.setMaximumSize(new java.awt.Dimension(80, 24));
        jLabel5.setMinimumSize(new java.awt.Dimension(80, 24));
        jLabel5.setPreferredSize(new java.awt.Dimension(80, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        pnlThemSuaLoaiBan.add(jLabel5, gridBagConstraints);

        txtTenLoaiBan.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTenLoaiBan.setToolTipText("");
        txtTenLoaiBan.setActionCommand("null");
        txtTenLoaiBan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtTenLoaiBan.setMaximumSize(new java.awt.Dimension(160, 24));
        txtTenLoaiBan.setMinimumSize(new java.awt.Dimension(160, 24));
        txtTenLoaiBan.setPreferredSize(new java.awt.Dimension(160, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        pnlThemSuaLoaiBan.add(txtTenLoaiBan, gridBagConstraints);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Số chỗ ngồi");
        jLabel6.setMaximumSize(new java.awt.Dimension(80, 24));
        jLabel6.setMinimumSize(new java.awt.Dimension(80, 24));
        jLabel6.setPreferredSize(new java.awt.Dimension(80, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        pnlThemSuaLoaiBan.add(jLabel6, gridBagConstraints);

        txtSoChoNgoi.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSoChoNgoi.setToolTipText("");
        txtSoChoNgoi.setActionCommand("null");
        txtSoChoNgoi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtSoChoNgoi.setMaximumSize(new java.awt.Dimension(160, 24));
        txtSoChoNgoi.setMinimumSize(new java.awt.Dimension(160, 24));
        txtSoChoNgoi.setPreferredSize(new java.awt.Dimension(160, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        pnlThemSuaLoaiBan.add(txtSoChoNgoi, gridBagConstraints);

        btnResetLoaiBan.setText("Reset");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        pnlThemSuaLoaiBan.add(btnResetLoaiBan, gridBagConstraints);

        btnLuuLoaiBan.setText("Lưu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        pnlThemSuaLoaiBan.add(btnLuuLoaiBan, gridBagConstraints);

        jPanel4.add(pnlThemSuaLoaiBan);

        jPanel1.add(jPanel4);

        add(jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý bàn\n"));
        jPanel5.setMinimumSize(new java.awt.Dimension(685, 253));
        jPanel5.setName(""); // NOI18N
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.X_AXIS));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách bàn\n"));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jScrollPane4.setMinimumSize(new java.awt.Dimension(387, 197));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(387, 197));

        tblBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên loại bàn", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        tblBan.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        tblBan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(tblBan);

        jPanel6.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel6);

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng cho bàn\n"));
        jPanel12.setMaximumSize(new java.awt.Dimension(32767, 56));

        btnThemBan.setText("Thêm");
        btnThemBan.setEnabled(false);
        jPanel12.add(btnThemBan);

        btnSuaBan.setText("Sửa");
        jPanel12.add(btnSuaBan);

        btnXoaBan.setText("Xóa");
        jPanel12.add(btnXoaBan);

        jPanel11.add(jPanel12);

        pnlThemSuaBan.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm bàn mới "));
        pnlThemSuaBan.setName(""); // NOI18N
        pnlThemSuaBan.setLayout(new java.awt.GridBagLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("ID");
        jLabel7.setMaximumSize(new java.awt.Dimension(80, 24));
        jLabel7.setMinimumSize(new java.awt.Dimension(80, 24));
        jLabel7.setPreferredSize(new java.awt.Dimension(80, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlThemSuaBan.add(jLabel7, gridBagConstraints);

        txtIdBan.setEnabled(false);
        txtIdBan.setMaximumSize(new java.awt.Dimension(160, 24));
        txtIdBan.setMinimumSize(new java.awt.Dimension(160, 24));
        txtIdBan.setPreferredSize(new java.awt.Dimension(160, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlThemSuaBan.add(txtIdBan, gridBagConstraints);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Tên loại bàn");
        jLabel8.setMaximumSize(new java.awt.Dimension(80, 24));
        jLabel8.setMinimumSize(new java.awt.Dimension(80, 24));
        jLabel8.setPreferredSize(new java.awt.Dimension(80, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        pnlThemSuaBan.add(jLabel8, gridBagConstraints);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Tình trạng bàn");
        jLabel9.setMaximumSize(new java.awt.Dimension(80, 24));
        jLabel9.setMinimumSize(new java.awt.Dimension(80, 24));
        jLabel9.setPreferredSize(new java.awt.Dimension(80, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        pnlThemSuaBan.add(jLabel9, gridBagConstraints);

        btnResetBan.setText("Reset");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlThemSuaBan.add(btnResetBan, gridBagConstraints);

        btnLuuBan.setText("Lưu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        pnlThemSuaBan.add(btnLuuBan, gridBagConstraints);

        cmbLoaiBan.setMaximumSize(new java.awt.Dimension(160, 24));
        cmbLoaiBan.setMinimumSize(new java.awt.Dimension(160, 24));
        cmbLoaiBan.setPreferredSize(new java.awt.Dimension(160, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlThemSuaBan.add(cmbLoaiBan, gridBagConstraints);

        cmbTinhTrangBan.setMaximumSize(new java.awt.Dimension(160, 24));
        cmbTinhTrangBan.setMinimumSize(new java.awt.Dimension(160, 24));
        cmbTinhTrangBan.setPreferredSize(new java.awt.Dimension(160, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlThemSuaBan.add(cmbTinhTrangBan, gridBagConstraints);

        jPanel11.add(pnlThemSuaBan);

        jPanel5.add(jPanel11);

        add(jPanel5);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnLuuBan;
    public javax.swing.JButton btnLuuLoaiBan;
    public javax.swing.JButton btnResetBan;
    public javax.swing.JButton btnResetLoaiBan;
    public javax.swing.JButton btnSuaBan;
    public javax.swing.JButton btnSuaLoaiBan;
    public javax.swing.JButton btnThemBan;
    public javax.swing.JButton btnThemLoaiBan;
    public javax.swing.JButton btnXoaBan;
    public javax.swing.JButton btnXoaLoaiBan;
    public javax.swing.JComboBox<String> cmbLoaiBan;
    public javax.swing.JComboBox<String> cmbTinhTrangBan;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JPanel pnlThemSuaBan;
    public javax.swing.JPanel pnlThemSuaLoaiBan;
    public javax.swing.JTable tblBan;
    public javax.swing.JTable tblLoaiBan;
    public javax.swing.JTextField txtIDLoaiBan;
    public javax.swing.JTextField txtIdBan;
    public javax.swing.JTextField txtSoChoNgoi;
    public javax.swing.JTextField txtTenLoaiBan;
    // End of variables declaration//GEN-END:variables
}
