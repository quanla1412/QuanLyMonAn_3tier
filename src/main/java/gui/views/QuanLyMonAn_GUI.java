
package gui.views;


import com.mycompany.quanlynhahang.Price;
import gui.models.MonAn.MonAnModel;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


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
    
    private void loadLoaiMonAnSearchBox(){
//        loaiMonAnSearchBox = loaiMonAn_BUS.getAllLoaiMonAn();        
//        
//        for(LoaiMonAn_DTO loaiBan : loaiMonAnSearchBox){
//            cmbLMASearchBox.addItem(loaiBan.getTen());
//        }      
//        
//        cmbLMASearchBox.setSelectedIndex(0);
//    }
//    
//    private void loadLoaiMonAnUpdate(){
//        loaiMonAnUpdate = loaiMonAn_BUS.getAllLoaiMonAn();        
//        
//        for(LoaiMonAn_DTO loaiBan : loaiMonAnUpdate){
//            cmbLMAForm.addItem(loaiBan.getTen());
//        }      
//        
//        cmbLMAForm.setSelectedIndex(-1);
//    }
    
//    private void loadTTMASearch(){      
//        listTTMA = monAn_BUS.getAllTinhTrangMA();
//        
//        cmbTTMASearch.addItem("Tất cả");
//        for(TinhTrangMonAn_DTO value : listTTMA){           
//            if (value.getId() != TinhTrangMonAnConstraints.DA_XOA) {
//                cmbTTMASearch.addItem(value.getTen());
//                cmbTTMAForm.addItem(value.getTen());                
//            }
//        } 
//        
//        cmbTTMASearch.setSelectedIndex(0);
//        cmbTTMAForm.setSelectedIndex(0);
//    }
//    
//    private void resetTable(){
//        loadTableMonAn();
//        txtSearchIdName.setText("");
//        cmbLMASearchBox.setSelectedIndex(0);
//        
//        sldMinPrice.setValue(sldMinPrice.getMinimum());
//        lblMinPrice.setText(Price.formatPrice(sldMinPrice.getValue()));
//        sldMaxPrice.setValue(sldMaxPrice.getMaximum());
//        lblMaxPrice.setText(Price.formatPrice(sldMaxPrice.getValue()));
//        
//        cmbTTMASearch.setSelectedIndex(0);
//    }
//    
//    private void resetForm(){
//        if(dangThemMonAn){
//            clearForm();
//        } else {
//            int idMonAn = Integer.parseInt(txtIdMonAn.getText());
//            loadFormWithMonAn(idMonAn);
//        }
//    }
//    
//    private void clearForm(){
//        txtIdMonAn.setText("");
//            txtTenMonAn.setText("");
//            cmbLMAForm.setSelectedIndex(-1);
//            linkHinhAnh = "";
//            lblTenHinhAnh.setText("Chưa chọn file");
//            txtGia.setText("");
//            txtGiaKhuyenMai.setText("");
//            cmbTTMAForm.setSelectedIndex(0);
//            txaNoiDung.setText("");
//    }
//    
//    private void loadFormWithMonAn(int idMonAn){
//        MonAnFull_DTO result = monAn_BUS.getMonAnFullById(idMonAn);
//        if (result == null) {
//            JOptionPane.showMessageDialog(this, "Lỗi hệ thống","Error", JOptionPane.ERROR_MESSAGE);
//        }
//        
//        txtIdMonAn.setText(Integer.toString(result.getId()));
//        txtTenMonAn.setText(result.getTen());
//        cmbLMAForm.setSelectedIndex(result.getLoaiMonAn().getId()-1);
//        if(result.getHinhAnh() != null && !result.getHinhAnh().isBlank()){
//            linkHinhAnh = result.getHinhAnh();
//            lblTenHinhAnh.setText(new File(linkHinhAnh).getName());
//        } else {
//            linkHinhAnh = "";
//            lblTenHinhAnh.setText("");
//        }
//        txtGia.setText(Integer.toString(result.getGia()));
//        if(result.getGiaKhuyenMai() != 0)
//            txtGiaKhuyenMai.setText(Integer.toString(result.getGiaKhuyenMai()));
//        else
//            txtGiaKhuyenMai.setText("");
//        if(result.getNoiDung()!= null)
//            txaNoiDung.setText(result.getNoiDung());
//        else 
//            txaNoiDung.setText("");
//        
//        cmbTTMAForm.setSelectedIndex(result.getTinhTrangMonAn().getId() - 1);
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
        cmbLMASearchBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        sldMinPrice = new javax.swing.JSlider();
        jLabel16 = new javax.swing.JLabel();
        sldMaxPrice = new javax.swing.JSlider();
        jLabel17 = new javax.swing.JLabel();
        cmbTTMASearch = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        lblMaxPrice = new javax.swing.JLabel();
        lblMinPrice = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        resetTableButton = new javax.swing.JButton();
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
        cmbLMAForm = new javax.swing.JComboBox<>();
        btnResetForm = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnHinhAnh = new javax.swing.JButton();
        lblTenHinhAnh = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtGiaKhuyenMai = new javax.swing.JTextField();
        cmbTTMAForm = new javax.swing.JComboBox<>();
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
        txtSearchIdName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchIdNameActionPerformed(evt);
            }
        });
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
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel4.add(btnTimKiem, gridBagConstraints);

        cmbLMASearchBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cmbLMASearchBox.setMinimumSize(new java.awt.Dimension(140, 24));
        cmbLMASearchBox.setPreferredSize(new java.awt.Dimension(140, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        jPanel4.add(cmbLMASearchBox, gridBagConstraints);

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
        sldMinPrice.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sldMinPriceMouseDragged(evt);
            }
        });
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
        sldMaxPrice.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sldMaxPriceMouseDragged(evt);
            }
        });
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

        cmbTTMASearch.setMaximumSize(new java.awt.Dimension(120, 24));
        cmbTTMASearch.setMinimumSize(new java.awt.Dimension(140, 24));
        cmbTTMASearch.setPreferredSize(new java.awt.Dimension(140, 24));
        cmbTTMASearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbTTMASearchMouseClicked(evt);
            }
        });
        cmbTTMASearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTTMASearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        jPanel4.add(cmbTTMASearch, gridBagConstraints);

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

        resetTableButton.setText("Reset bảng");
        resetTableButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetTableButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 10, 20);
        jPanel1.add(resetTableButton, gridBagConstraints);

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
        tblMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMonAnMouseClicked(evt);
            }
        });
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
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        jPanel6.add(btnThem, gridBagConstraints);

        btnSua.setText("Sửa");
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        jPanel6.add(btnSua, gridBagConstraints);

        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        jPanel6.add(btnXoa, gridBagConstraints);

        btnChuyenTinhTrang.setText("Chuyển tình trạng");
        btnChuyenTinhTrang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChuyenTinhTrangMouseClicked(evt);
            }
        });
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

        cmbLMAForm.setMaximumSize(null);
        cmbLMAForm.setMinimumSize(new java.awt.Dimension(100, 22));
        cmbLMAForm.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 20);
        pnlThemSuaMonAn.add(cmbLMAForm, gridBagConstraints);

        btnResetForm.setText("Reset");
        btnResetForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetFormMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 4);
        pnlThemSuaMonAn.add(btnResetForm, gridBagConstraints);

        btnLuu.setText("Lưu");
        btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuMouseClicked(evt);
            }
        });
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
        btnHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHinhAnhMouseClicked(evt);
            }
        });
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

        cmbTTMAForm.setMaximumSize(null);
        cmbTTMAForm.setMinimumSize(new java.awt.Dimension(100, 22));
        cmbTTMAForm.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 20);
        pnlThemSuaMonAn.add(cmbTTMAForm, gridBagConstraints);

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
        btnQuanLyLoaiMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyLoaiMonAnMouseClicked(evt);
            }
        });
        jPanel3.add(btnQuanLyLoaiMonAn);

        jPanel5.add(jPanel3);

        add(jPanel5);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
//        dangThemMonAn = true;
//        btnSua.setEnabled(true);
//        btnThem.setEnabled(false);
//        pnlThemSuaMonAn.setBorder(new TitledBorder("Thêm món ăn"));
//        clearForm();
//        btnLuu.setEnabled(true);
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        // TODO add your handling code here:
//        dangThemMonAn = false;
//        btnSua.setEnabled(false);
//        btnThem.setEnabled(true);
//        pnlThemSuaMonAn.setBorder(new TitledBorder("Sửa món ăn"));
//        btnLuu.setEnabled(false);
    }//GEN-LAST:event_btnSuaMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        // TODO add your handling code here:
//        int total = tblMonAn.getSelectedRowCount();
//        TableModel model = tblMonAn.getModel();
//        if(total < 0){
//            JOptionPane.showMessageDialog(this, "Chưa có món ăn nào được chọn","Error", JOptionPane.ERROR_MESSAGE);
//        } else if (total == 1){
//            int indexRow = tblMonAn.getSelectedRow();
//            int idMonAn =Integer.parseInt( model.getValueAt(indexRow, 0).toString());
//
//            boolean result = monAn_BUS.deleteMonAn(idMonAn);
//
//            if(result){
//                JOptionPane.showMessageDialog(this, "Xóa món ăn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                resetTable();
//                clearForm();
//            } else {
//                JOptionPane.showMessageDialog(this, "Xóa món ăn thất bại","Error", JOptionPane.ERROR_MESSAGE);
//            }
//        } else {
//            int[] listIndex = tblMonAn.getSelectedRows();
//            ArrayList<Integer> listID = new ArrayList<>();
//            for(int id : listIndex){
//                listID.add(Integer.valueOf(model.getValueAt(id, 0).toString()));
//            }
//            int result = monAn_BUS.deleteNhieuMonAn(listID);
//
//            if(result > 0){
//                JOptionPane.showMessageDialog(this, "Xóa " + result + " món ăn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                resetTable();
//                clearForm();
//            } else {
//                JOptionPane.showMessageDialog(this, "Xóa các món ăn thất bại","Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnChuyenTinhTrangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChuyenTinhTrangMouseClicked
        // TODO add your handling code here:int total = tblMonAn.getSelectedRowCount();
//        int total = tblMonAn.getSelectedRowCount();
//        TableModel model = tblMonAn.getModel();
//        if(total < 0){
//            JOptionPane.showMessageDialog(this, "Chưa có món ăn nào được chọn","Error", JOptionPane.ERROR_MESSAGE);
//        } else if (total == 1){
//            int indexRow = tblMonAn.getSelectedRow();
//            int idMonAn =Integer.parseInt( model.getValueAt(indexRow, 0).toString());
//
//            int tinhTrangMonAn = monAn_BUS.getMonAnFullById(idMonAn).getTinhTrangMonAn().getId();
//            if(tinhTrangMonAn == TinhTrangMonAnConstraints.CON_PHUC_VU)
//            tinhTrangMonAn = TinhTrangMonAnConstraints.HET;
//            else
//            tinhTrangMonAn = TinhTrangMonAnConstraints.CON_PHUC_VU;
//            boolean result = monAn_BUS.chuyenTinhTrangMonAn(idMonAn, tinhTrangMonAn);
//
//            if(result){
//                JOptionPane.showMessageDialog(this, "Chuyển tình trạng món ăn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                resetTable();
//                clearForm();
//            } else {
//                JOptionPane.showMessageDialog(this, "Chuyển tình trạng món ăn thất bại","Error", JOptionPane.ERROR_MESSAGE);
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Vui lòng chỉ chọn 1 món ăn 1 lần","Error", JOptionPane.ERROR_MESSAGE);
//        }

    }//GEN-LAST:event_btnChuyenTinhTrangMouseClicked

    private void btnResetFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetFormMouseClicked
        // TODO add your handling code here:
//        resetForm();
    }//GEN-LAST:event_btnResetFormMouseClicked

    private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseClicked
        // TODO add your handling code here:
//        if (dangThemMonAn) {
//            CreateMonAn_DTO createMonAn_DTO = new CreateMonAn_DTO();
//
//            int indexLoaiMonAn = cmbLMAForm.getSelectedIndex();
//            if(indexLoaiMonAn < 0){
//                JOptionPane.showMessageDialog(this, "Chưa chọn loại món ăn","Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            } else
//            createMonAn_DTO.setIdLoaiMonAn(loaiMonAnUpdate.get(indexLoaiMonAn).getId());
//
//            String tenMonAn = txtTenMonAn.getText().trim();
//            if(tenMonAn.isBlank()){
//                JOptionPane.showMessageDialog(this, "Chưa nhập tên món ăn","Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            } else
//            createMonAn_DTO.setTen(tenMonAn);
//
//            if (!linkHinhAnh.isEmpty()) {
//                createMonAn_DTO.setHinhAnh(linkHinhAnh);
//            }
//
//            String giaString = txtGia.getText();
//            if(giaString.isEmpty()){
//                JOptionPane.showMessageDialog(this, "Chưa nhập giá","Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            try {
//                int gia = Integer.parseInt(giaString);
//                if (gia < 1000 || gia % 100 != 0)
//                throw new NumberFormatException();
//                else
//                createMonAn_DTO.setGia(gia);
//            } catch (NumberFormatException ex){
//                JOptionPane.showMessageDialog(this, "Nhập giá không đúng định dạng, giá phải từ 1000đ trở lên và chia hết cho 100 ","Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//
//            String giaKhuyenMaiString = txtGiaKhuyenMai.getText();
//            if(!giaKhuyenMaiString.isEmpty()){
//                try {
//                    int giaKhuyenMai = Integer.parseInt(giaKhuyenMaiString);
//                    if (giaKhuyenMai < 1000 || giaKhuyenMai % 100 != 0 || giaKhuyenMai > createMonAn_DTO.getGia())
//                    throw new NumberFormatException();
//                    else
//                    createMonAn_DTO.setGiaKhuyenMai(giaKhuyenMai);
//                } catch (NumberFormatException ex){
//                    JOptionPane.showMessageDialog(this, "Nhập giá không đúng định dạng, giá phải từ 1000đ trở lên, nhỏ hơn giá gốc và chia hết cho 100 hoặc giá khuyến mãi phải nhỏ hơn giá mặc định","Error", JOptionPane.ERROR_MESSAGE);
//                    return;
//                }
//            }
//
//            int idTinhTrang = cmbTTMAForm.getSelectedIndex();
//            createMonAn_DTO.setIdTtinhTrangMonAn(listTTMA.get(idTinhTrang).getId());
//
//            String noidung = txaNoiDung.getText();
//            if(!noidung.isBlank())
//            createMonAn_DTO.setNoiDung(noidung);
//
//            boolean result = monAn_BUS.createMonAn(createMonAn_DTO);
//            if(result){
//                JOptionPane.showMessageDialog(this, "Thêm món ăn mới thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                loadTableMonAn();
//                resetTable();
//                resetForm();
//            }
//            else
//            JOptionPane.showMessageDialog(this, "Thêm món ăn mới thất bại","Error", JOptionPane.ERROR_MESSAGE);
//        } else {
//            UpdateMonAn_DTO updateMonAn_DTO = new UpdateMonAn_DTO();
//
//            updateMonAn_DTO.setId(Integer.parseInt(txtIdMonAn.getText()));
//            int indexLoaiMonAn = cmbLMAForm.getSelectedIndex();
//            if(indexLoaiMonAn < 0){
//                JOptionPane.showMessageDialog(this, "Chưa chọn loại món ăn","Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            } else
//            updateMonAn_DTO.setIdLoaiMonAn(loaiMonAnUpdate.get(indexLoaiMonAn).getId());
//
//            String tenMonAn = txtTenMonAn.getText().trim();
//            if(tenMonAn.isBlank()){
//                JOptionPane.showMessageDialog(this, "Chưa nhập tên món ăn","Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            } else
//            updateMonAn_DTO.setTen(tenMonAn);
//
//            if (!linkHinhAnh.isEmpty()) {
//                updateMonAn_DTO.setHinhAnh(linkHinhAnh);
//            }
//
//            String giaString = txtGia.getText();
//            if(giaString.isEmpty()){
//                JOptionPane.showMessageDialog(this, "Chưa nhập giá","Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            try {
//                int gia = Integer.parseInt(giaString);
//                if (gia < 1000 || gia % 100 != 0)
//                throw new NumberFormatException();
//                else
//                updateMonAn_DTO.setGia(gia);
//            } catch (NumberFormatException ex){
//                JOptionPane.showMessageDialog(this, "Nhập giá không đúng định dạng, giá phải từ 1000đ trở lên và chia hết cho 100","Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//
//            String giaKhuyenMaiString = txtGiaKhuyenMai.getText();
//            if(!giaKhuyenMaiString.isEmpty()){
//                try {
//                    int giaKhuyenMai = Integer.parseInt(giaKhuyenMaiString);
//                    if (giaKhuyenMai < 1000 || giaKhuyenMai % 100 != 0 || giaKhuyenMai > updateMonAn_DTO.getGia())
//                    throw new NumberFormatException();
//                    else
//                    updateMonAn_DTO.setGiaKhuyenMai(giaKhuyenMai);
//                } catch (NumberFormatException ex){
//                    JOptionPane.showMessageDialog(this, "Nhập giá không đúng định dạng, giá phải từ 1000đ trở lên, nhỏ hơn giá gốc và chia hết cho 100,  hoặc giá khuyến mãi phải nhỏ hơn giá mặc định","Error", JOptionPane.ERROR_MESSAGE);
//                    return;
//                }
//            }
//
//            int idTinhTrang = cmbTTMAForm.getSelectedIndex();
//            updateMonAn_DTO.setIdTtinhTrangMonAn(listTTMA.get(idTinhTrang).getId());
//
//            String noidung = txaNoiDung.getText();
//            if(!noidung.isBlank())
//            updateMonAn_DTO.setNoiDung(noidung);
//
//            boolean result = monAn_BUS.updateMonAn(updateMonAn_DTO);
//            if(result){
//                JOptionPane.showMessageDialog(this, "Sửa món ăn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                loadTableMonAn();
//                resetTable();
//                resetForm();
//            }
//            else
//            JOptionPane.showMessageDialog(this, "Sửa món ăn thất bại","Error", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_btnLuuMouseClicked

    private void btnHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHinhAnhMouseClicked
        // TODO add your handling code here:
//        JFileChooser fc = new JFileChooser("D:\\");
//            FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image", "jpg", "png");
//            fc.setFileFilter(imageFilter);
//            fc.setMultiSelectionEnabled(false);
//
//            int returnVal = fc.showOpenDialog(QuanLyMonAn_GUI.this);
//
//            if (returnVal == JFileChooser.APPROVE_OPTION) {
//                File file = fc.getSelectedFile();
//                //This is where a real application would open the file.
//                lblTenHinhAnh.setText(file.getName());
//                linkHinhAnh = file.getAbsolutePath();
//            } else {
//                lblTenHinhAnh.setText("Lỗi khi chọn file");
//            }
    }//GEN-LAST:event_btnHinhAnhMouseClicked

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        // TODO add your handling code here:
//        SearchMonAn_DTO searchMonAn_DTO = new SearchMonAn_DTO();
//
//        String idOrName = txtSearchIdName.getText();
//        if(!idOrName.isBlank()){
//            searchMonAn_DTO.setIdOrName(idOrName.trim());
//        }
//
//        int idLoaiMonAn = cmbLMASearchBox.getSelectedIndex();
//        if(idLoaiMonAn > 0){
//            searchMonAn_DTO.setIdLoaiMonAn(loaiMonAnSearchBox.get(idLoaiMonAn - 1).getId());
//        }
//
//        int minPrice = sldMinPrice.getValue();
//        int maxPrice = sldMaxPrice.getValue();
//        if(minPrice > maxPrice){
//            JOptionPane.showMessageDialog(this, "Giá tối thiểu phải nhỏ hơn giá tối đa","Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        } else {
//            searchMonAn_DTO.setMinPrice(minPrice);
//            searchMonAn_DTO.setMaxPrice(maxPrice);
//        }
//
//        int idTTMA = cmbTTMASearch.getSelectedIndex();
//        if(idTTMA > 0){
//            searchMonAn_DTO.setIdTTMA(listTTMA.get(idTTMA - 1).getId());
//        }
//
//        ArrayList<MonAn_DTO> result = monAn_BUS.searchMonAn(searchMonAn_DTO);
//        loadTableMonAn(result);
    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void sldMinPriceMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sldMinPriceMouseDragged
        // TODO add your handling code here:
        lblMinPrice.setText(Price.formatPrice(sldMinPrice.getValue()));
    }//GEN-LAST:event_sldMinPriceMouseDragged

    private void sldMaxPriceMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sldMaxPriceMouseDragged
        // TODO add your handling code here:
        lblMaxPrice.setText(Price.formatPrice(sldMaxPrice.getValue()));
    }//GEN-LAST:event_sldMaxPriceMouseDragged

    private void cmbTTMASearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbTTMASearchMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbTTMASearchMouseClicked

    private void cmbTTMASearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTTMASearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTTMASearchActionPerformed

    private void tblMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonAnMouseClicked
        // TODO add your handling code here:
//        if(dangThemMonAn)
//        return;
//
//        int indexRow = tblMonAn.getSelectedRow();
//        TableModel model = tblMonAn.getModel();
//
//        int idMonAn = Integer.parseInt(model.getValueAt(indexRow, 0).toString());
//        loadFormWithMonAn(idMonAn);
//        btnLuu.setEnabled(true);
    }//GEN-LAST:event_tblMonAnMouseClicked

    private void btnQuanLyLoaiMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyLoaiMonAnMouseClicked
        // TODO add your handling code here:
//        if(quanLyLoaiMonAn_GUI == null || !quanLyLoaiMonAn_GUI.isDisplayable()){
//            quanLyLoaiMonAn_GUI = new QuanLyLoaiMonAn_GUI();
//            quanLyLoaiMonAn_GUI.setVisible(true);
//        } else {
//            quanLyLoaiMonAn_GUI.setState(JFrame.NORMAL);
//            quanLyLoaiMonAn_GUI.toFront();
//        }
    }//GEN-LAST:event_btnQuanLyLoaiMonAnMouseClicked

    private void resetTableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetTableButtonMouseClicked
        // TODO add your handling code here:
//        resetTable();
    }//GEN-LAST:event_resetTableButtonMouseClicked

    private void txtSearchIdNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchIdNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchIdNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenTinhTrang;
    private javax.swing.JButton btnHinhAnh;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnQuanLyLoaiMonAn;
    private javax.swing.JButton btnResetForm;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cmbLMAForm;
    private javax.swing.JComboBox<String> cmbLMASearchBox;
    private javax.swing.JComboBox<String> cmbTTMAForm;
    private javax.swing.JComboBox<String> cmbTTMASearch;
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
    private javax.swing.JLabel lblMaxPrice;
    private javax.swing.JLabel lblMinPrice;
    private javax.swing.JLabel lblTenHinhAnh;
    private javax.swing.JPanel pnlThemSuaMonAn;
    private javax.swing.JButton resetTableButton;
    private javax.swing.JSlider sldMaxPrice;
    private javax.swing.JSlider sldMinPrice;
    private javax.swing.JTable tblMonAn;
    private javax.swing.JTextArea txaNoiDung;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtGiaKhuyenMai;
    private javax.swing.JTextField txtIdMonAn;
    private javax.swing.JTextField txtSearchIdName;
    private javax.swing.JTextField txtTenMonAn;
    // End of variables declaration//GEN-END:variables
}
