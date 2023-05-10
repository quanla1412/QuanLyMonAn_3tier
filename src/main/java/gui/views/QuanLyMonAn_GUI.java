
package gui.views;

import com.mycompany.quanlynhahang.Price;
import gui.constraints.TinhTrangMonAnConstraints;
import gui.models.LoaiMonAn.LoaiMonAnModel;
import gui.models.MonAn.MonAnModel;
import gui.models.MonAn.TinhTrangMonAnModel;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class QuanLyMonAn_GUI extends javax.swing.JPanel {
    
    public QuanLyMonAn_GUI() {
        initComponents();
    }

    public void loadTableMonAn(ArrayList<MonAnModel> listMonAn){
        String col[] = {"ID", "Tên món ăn", "Loại món ăn", "Giá", "Tình trạng món ăn"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        tblMonAn.setModel(tableModel);
        for(MonAnModel row : listMonAn){
            Object[] data = {row.getId(), row.getTen(), row.getLoaiMonAn(), Price.formatPrice(row.getGia()), row.getTinhTrangMonAn()};
            tableModel.addRow(data);
        }
        tblMonAn.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblMonAn.getColumnModel().getColumn(0).setPreferredWidth(15);
        tblMonAn.getColumnModel().getColumn(1).setCellRenderer(new MyRenderer());
    }
    
    class MyRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                        boolean hasFocus, int row, int column) {
            JTextArea textArea = new JTextArea();
            textArea.setText(value.toString());
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setFont(table.getFont());

            int height = table.getRowHeight(row);
            int width = table.getColumnModel().getColumn(column).getWidth();
            textArea.setSize(new Dimension(width, height));
            if (table.getRowHeight(row) != textArea.getPreferredSize().height) {
                table.setRowHeight(row, textArea.getPreferredSize().height);
            }

            return textArea;
        }
    }
    
    public void loadComboBoxLoaiMonAn(ArrayList<LoaiMonAnModel> listLoaiMonAnModel){
        cmbLoaiMonAnSearch.removeAllItems();
        cmbLoaiMonAnForm.removeAllItems();
        
        cmbLoaiMonAnSearch.addItem("Tất cả");
        
        for(LoaiMonAnModel loaiMonAnModel : listLoaiMonAnModel){
            cmbLoaiMonAnSearch.addItem(loaiMonAnModel.getTen());
            cmbLoaiMonAnForm.addItem(loaiMonAnModel.getTen());
        }      
        
        cmbLoaiMonAnSearch.setSelectedIndex(0);
        cmbLoaiMonAnForm.setSelectedIndex(-1);
    }
    
    public void loadComboBoxTinhTrangMonAn(ArrayList<TinhTrangMonAnModel> listTinhTrangMonAnModel){  
        cmbTinhTrangMonAnSearch.removeAllItems();
        cmbTinhTrangMonAnForm.removeAllItems();
        
        cmbTinhTrangMonAnSearch.addItem("Tất cả");
        
        for(TinhTrangMonAnModel tinhTrangMonAnModel : listTinhTrangMonAnModel){           
            if (tinhTrangMonAnModel.getId() != TinhTrangMonAnConstraints.DA_XOA) {
                cmbTinhTrangMonAnSearch.addItem(tinhTrangMonAnModel.getTen());
                cmbTinhTrangMonAnForm.addItem(tinhTrangMonAnModel.getTen());                
            }
        } 
        
        cmbTinhTrangMonAnSearch.setSelectedIndex(0);
        cmbTinhTrangMonAnForm.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearchIdName = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        cmbLoaiMonAnSearch = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        sldMinPrice = new javax.swing.JSlider();
        jLabel16 = new javax.swing.JLabel();
        sldMaxPrice = new javax.swing.JSlider();
        jLabel17 = new javax.swing.JLabel();
        cmbTinhTrangMonAnSearch = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        lblMaxPrice = new javax.swing.JLabel();
        lblMinPrice = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnResetTable = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMonAn = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnChuyenTinhTrang = new javax.swing.JButton();
        pnlThemSuaMonAn = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdMonAn = new javax.swing.JTextField();
        txtTenMonAn = new javax.swing.JTextField();
        cmbLoaiMonAnForm = new javax.swing.JComboBox<>();
        btnResetForm = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnHinhAnh = new javax.swing.JButton();
        lblTenHinhAnh = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtGiaKhuyenMai = new javax.swing.JTextField();
        cmbTinhTrangMonAnForm = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaNoiDung = new javax.swing.JTextArea();
        txtGia = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnQuanLyLoaiMonAn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(820, 533));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Bộ lọc tìm kiếm món ăn"));
        jPanel4.setMaximumSize(new java.awt.Dimension(2147483647, 160));
        jPanel4.setMinimumSize(new java.awt.Dimension(520, 160));
        jPanel4.setPreferredSize(new java.awt.Dimension(520, 160));
        jPanel4.setRequestFocusEnabled(false);
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Nhập id hoặc tên");
        jLabel1.setMaximumSize(new java.awt.Dimension(104, 24));
        jLabel1.setMinimumSize(new java.awt.Dimension(104, 24));
        jLabel1.setPreferredSize(new java.awt.Dimension(104, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        jPanel4.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Hiển thị theo loại");
        jLabel2.setMaximumSize(new java.awt.Dimension(104, 24));
        jLabel2.setMinimumSize(new java.awt.Dimension(104, 24));
        jLabel2.setPreferredSize(new java.awt.Dimension(104, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 12, 4, 0);
        jPanel4.add(jLabel2, gridBagConstraints);

        txtSearchIdName.setPreferredSize(new java.awt.Dimension(150, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        jPanel4.add(txtSearchIdName, gridBagConstraints);

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setMaximumSize(new java.awt.Dimension(88, 24));
        btnTimKiem.setMinimumSize(new java.awt.Dimension(88, 24));
        btnTimKiem.setPreferredSize(new java.awt.Dimension(88, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel4.add(btnTimKiem, gridBagConstraints);

        cmbLoaiMonAnSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cmbLoaiMonAnSearch.setMinimumSize(new java.awt.Dimension(140, 24));
        cmbLoaiMonAnSearch.setPreferredSize(new java.awt.Dimension(140, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        jPanel4.add(cmbLoaiMonAnSearch, gridBagConstraints);

        jLabel10.setText("Khoảng giá:");
        jLabel10.setMaximumSize(new java.awt.Dimension(88, 24));
        jLabel10.setMinimumSize(new java.awt.Dimension(88, 24));
        jLabel10.setPreferredSize(new java.awt.Dimension(88, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        jPanel4.add(jLabel10, gridBagConstraints);

        sldMinPrice.setMaximum(500000);
        sldMinPrice.setValue(0);
        sldMinPrice.setMinimumSize(new java.awt.Dimension(80, 24));
        sldMinPrice.setPreferredSize(new java.awt.Dimension(80, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel4.add(sldMinPrice, gridBagConstraints);

        jLabel16.setText("~");
        jLabel16.setMaximumSize(new java.awt.Dimension(20, 20));
        jLabel16.setMinimumSize(new java.awt.Dimension(20, 20));
        jLabel16.setPreferredSize(new java.awt.Dimension(12, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel4.add(jLabel16, gridBagConstraints);

        sldMaxPrice.setMaximum(500000);
        sldMaxPrice.setToolTipText("");
        sldMaxPrice.setValue(500000);
        sldMaxPrice.setMinimumSize(new java.awt.Dimension(80, 24));
        sldMaxPrice.setPreferredSize(new java.awt.Dimension(80, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel4.add(sldMaxPrice, gridBagConstraints);

        jLabel17.setText("Tình trạng món ăn");
        jLabel17.setMaximumSize(new java.awt.Dimension(104, 24));
        jLabel17.setMinimumSize(new java.awt.Dimension(104, 24));
        jLabel17.setPreferredSize(new java.awt.Dimension(104, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 12, 4, 0);
        jPanel4.add(jLabel17, gridBagConstraints);

        cmbTinhTrangMonAnSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cmbTinhTrangMonAnSearch.setMaximumSize(new java.awt.Dimension(120, 24));
        cmbTinhTrangMonAnSearch.setMinimumSize(new java.awt.Dimension(140, 24));
        cmbTinhTrangMonAnSearch.setPreferredSize(new java.awt.Dimension(140, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        jPanel4.add(cmbTinhTrangMonAnSearch, gridBagConstraints);

        jLabel18.setText("~");
        jLabel18.setMaximumSize(new java.awt.Dimension(20, 20));
        jLabel18.setMinimumSize(new java.awt.Dimension(20, 20));
        jLabel18.setPreferredSize(new java.awt.Dimension(12, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel4.add(jLabel18, gridBagConstraints);

        lblMaxPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaxPrice.setText("500.000 VNĐ");
        lblMaxPrice.setMinimumSize(new java.awt.Dimension(80, 24));
        lblMaxPrice.setPreferredSize(new java.awt.Dimension(80, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel4.add(lblMaxPrice, gridBagConstraints);

        lblMinPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinPrice.setText("0 VNĐ");
        lblMinPrice.setMinimumSize(new java.awt.Dimension(80, 24));
        lblMinPrice.setPreferredSize(new java.awt.Dimension(80, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel4.add(lblMinPrice, gridBagConstraints);

        jPanel2.add(jPanel4);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách món ăn"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnResetTable.setText("Reset bảng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 10, 20);
        jPanel1.add(btnResetTable, gridBagConstraints);

        jScrollPane1.setMaximumSize(new java.awt.Dimension(452, 300));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(452, 200));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 300));

        tblMonAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên món ăn", "Tên loại món ăn", "Giá", "Tình trạng món ăn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMonAn.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        tblMonAn.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblMonAn);
        if (tblMonAn.getColumnModel().getColumnCount() > 0) {
            tblMonAn.getColumnModel().getColumn(0).setMinWidth(0);
            tblMonAn.getColumnModel().getColumn(0).setMaxWidth(20);
            tblMonAn.getColumnModel().getColumn(1).setMinWidth(200);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jPanel2.add(jPanel1);

        add(jPanel2);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jPanel6.setMaximumSize(new java.awt.Dimension(2147483647, 160));
        jPanel6.setMinimumSize(new java.awt.Dimension(298, 160));
        jPanel6.setPreferredSize(new java.awt.Dimension(298, 160));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        btnThem.setText("Thêm");
        btnThem.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        jPanel6.add(btnThem, gridBagConstraints);

        btnSua.setText("Sửa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        jPanel6.add(btnSua, gridBagConstraints);

        btnXoa.setText("Xóa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        jPanel6.add(btnXoa, gridBagConstraints);

        btnChuyenTinhTrang.setText("Chuyển tình trạng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        jPanel6.add(btnChuyenTinhTrang, gridBagConstraints);

        jPanel5.add(jPanel6);

        pnlThemSuaMonAn.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm món ăn"));
        pnlThemSuaMonAn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlThemSuaMonAn.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("ID món ăn");
        jLabel3.setMaximumSize(new java.awt.Dimension(84, 20));
        jLabel3.setMinimumSize(new java.awt.Dimension(84, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        pnlThemSuaMonAn.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Loại món ăn");
        jLabel4.setMaximumSize(new java.awt.Dimension(84, 20));
        jLabel4.setMinimumSize(new java.awt.Dimension(84, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        pnlThemSuaMonAn.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Tên món ăn");
        jLabel5.setMaximumSize(new java.awt.Dimension(84, 20));
        jLabel5.setMinimumSize(new java.awt.Dimension(84, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        pnlThemSuaMonAn.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Hình ảnh");
        jLabel6.setMaximumSize(new java.awt.Dimension(84, 20));
        jLabel6.setMinimumSize(new java.awt.Dimension(84, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        pnlThemSuaMonAn.add(jLabel6, gridBagConstraints);

        txtIdMonAn.setEnabled(false);
        txtIdMonAn.setMinimumSize(new java.awt.Dimension(100, 22));
        txtIdMonAn.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 20);
        pnlThemSuaMonAn.add(txtIdMonAn, gridBagConstraints);

        txtTenMonAn.setMaximumSize(null);
        txtTenMonAn.setMinimumSize(new java.awt.Dimension(100, 22));
        txtTenMonAn.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 20);
        pnlThemSuaMonAn.add(txtTenMonAn, gridBagConstraints);

        cmbLoaiMonAnForm.setMaximumSize(null);
        cmbLoaiMonAnForm.setMinimumSize(new java.awt.Dimension(100, 22));
        cmbLoaiMonAnForm.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 20);
        pnlThemSuaMonAn.add(cmbLoaiMonAnForm, gridBagConstraints);

        btnResetForm.setText("Reset");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 4);
        pnlThemSuaMonAn.add(btnResetForm, gridBagConstraints);

        btnLuu.setText("Lưu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 20);
        pnlThemSuaMonAn.add(btnLuu, gridBagConstraints);

        btnHinhAnh.setText("Chọn file");
        btnHinhAnh.setMaximumSize(null);
        btnHinhAnh.setMinimumSize(new java.awt.Dimension(100, 22));
        btnHinhAnh.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 20);
        pnlThemSuaMonAn.add(btnHinhAnh, gridBagConstraints);

        lblTenHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenHinhAnh.setText("Chưa chọn file");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 20);
        pnlThemSuaMonAn.add(lblTenHinhAnh, gridBagConstraints);

        jLabel15.setText("Giá");
        jLabel15.setMaximumSize(new java.awt.Dimension(84, 20));
        jLabel15.setMinimumSize(new java.awt.Dimension(84, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        pnlThemSuaMonAn.add(jLabel15, gridBagConstraints);

        txtGiaKhuyenMai.setMaximumSize(null);
        txtGiaKhuyenMai.setMinimumSize(new java.awt.Dimension(100, 22));
        txtGiaKhuyenMai.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 20);
        pnlThemSuaMonAn.add(txtGiaKhuyenMai, gridBagConstraints);

        cmbTinhTrangMonAnForm.setMaximumSize(null);
        cmbTinhTrangMonAnForm.setMinimumSize(new java.awt.Dimension(100, 22));
        cmbTinhTrangMonAnForm.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 20);
        pnlThemSuaMonAn.add(cmbTinhTrangMonAnForm, gridBagConstraints);

        jLabel11.setText("Tình trạng");
        jLabel11.setMaximumSize(new java.awt.Dimension(84, 20));
        jLabel11.setMinimumSize(new java.awt.Dimension(84, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        pnlThemSuaMonAn.add(jLabel11, gridBagConstraints);

        jLabel7.setText("Giá khuyến mãi");
        jLabel7.setMaximumSize(new java.awt.Dimension(84, 20));
        jLabel7.setMinimumSize(new java.awt.Dimension(84, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        pnlThemSuaMonAn.add(jLabel7, gridBagConstraints);

        jLabel9.setText("Nội dung");
        jLabel9.setMaximumSize(new java.awt.Dimension(84, 20));
        jLabel9.setMinimumSize(new java.awt.Dimension(84, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        pnlThemSuaMonAn.add(jLabel9, gridBagConstraints);

        txaNoiDung.setColumns(20);
        txaNoiDung.setRows(5);
        txaNoiDung.setMinimumSize(new java.awt.Dimension(212, 84));
        jScrollPane2.setViewportView(txaNoiDung);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 20);
        pnlThemSuaMonAn.add(jScrollPane2, gridBagConstraints);

        txtGia.setMaximumSize(null);
        txtGia.setMinimumSize(new java.awt.Dimension(100, 22));
        txtGia.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 20);
        pnlThemSuaMonAn.add(txtGia, gridBagConstraints);

        jPanel5.add(pnlThemSuaMonAn);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng khác"));
        jPanel3.setMinimumSize(new java.awt.Dimension(157, 60));
        jPanel3.setPreferredSize(new java.awt.Dimension(157, 60));

        btnQuanLyLoaiMonAn.setText("Quản lý loại món ăn");
        jPanel3.add(btnQuanLyLoaiMonAn);

        jPanel5.add(jPanel3);

        add(jPanel5);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnChuyenTinhTrang;
    public javax.swing.JButton btnHinhAnh;
    public javax.swing.JButton btnLuu;
    public javax.swing.JButton btnQuanLyLoaiMonAn;
    public javax.swing.JButton btnResetForm;
    public javax.swing.JButton btnResetTable;
    public javax.swing.JButton btnSua;
    public javax.swing.JButton btnThem;
    public javax.swing.JButton btnTimKiem;
    public javax.swing.JButton btnXoa;
    public javax.swing.JComboBox<String> cmbLoaiMonAnForm;
    public javax.swing.JComboBox<String> cmbLoaiMonAnSearch;
    public javax.swing.JComboBox<String> cmbTinhTrangMonAnForm;
    public javax.swing.JComboBox<String> cmbTinhTrangMonAnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblMaxPrice;
    public javax.swing.JLabel lblMinPrice;
    public javax.swing.JLabel lblTenHinhAnh;
    public javax.swing.JPanel pnlThemSuaMonAn;
    public javax.swing.JSlider sldMaxPrice;
    public javax.swing.JSlider sldMinPrice;
    public javax.swing.JTable tblMonAn;
    public javax.swing.JTextArea txaNoiDung;
    public javax.swing.JTextField txtGia;
    public javax.swing.JTextField txtGiaKhuyenMai;
    public javax.swing.JTextField txtIdMonAn;
    public javax.swing.JTextField txtSearchIdName;
    public javax.swing.JTextField txtTenMonAn;
    // End of variables declaration//GEN-END:variables
}
