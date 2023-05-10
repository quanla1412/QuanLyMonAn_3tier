

package gui.views;



import com.mycompany.quanlynhahang.CheckHopLe;
import gui.models.KhachHang.KhachHangModel;
import gui.models.LoaiKhachHang.LoaiKhachHangModel;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class QuanLyKhachHang_GUI extends javax.swing.JPanel {
    
    public QuanLyKhachHang_GUI() {
        initComponents();
        
    }

    
    public void loadTableKhachHang(ArrayList<KhachHangModel> khachHangModel){
        
        String col[] = {"ID", "Tên khách hàng", "Số diện thoại ", "Điểm tích lũy ", "Loại khách hàng "};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        tblKhachHang.setModel(tableModel);
        for(KhachHangModel row : khachHangModel){
            Object[] data = {row.getId(), row.getTen(), row.getSdt(), row.getDiemTichLuy(), row.getLoaiKhachHang()};
            tableModel.addRow(data);
        }
    }
    
    public void loadComboBoxTimKiemLoaiKH(ArrayList<LoaiKhachHangModel> loaiKhachHang){
        for(LoaiKhachHangModel loaiKH : loaiKhachHang){
            cmbTimKiemLoaiKH.addItem(loaiKH.getTen());
        }
        cmbTimKiemLoaiKH.setSelectedIndex(0);

    }
    public void loadComboBoxThemSuaLoaiKH(ArrayList<LoaiKhachHangModel> loaiKhachHang){       
        cmbThemSuaLoaiKH.removeAllItems();
        for(LoaiKhachHangModel loaiKH : loaiKhachHang){
            cmbThemSuaLoaiKH.addItem(loaiKH.getTen());
        }     
        cmbThemSuaLoaiKH.setSelectedIndex(-1);
    }
//    
//    private void clearThemSuaKhachHang(){
//        txtIDKH.setText("");
//        cmbThemSuaLoaiKH.setSelectedIndex(0);
//        txtHoTen.setText("");
//        txtSDT.setText("");
//        txtDiemTichLuy.setText("0");
//        txtEmail.setText("");
//        jdcNgaySinh.setDate(new Date());
//    }
//    
//    private void clearSearchBox(){
//        txtSearchIdName.setText("");
//        cmbTimKiemGioiTinh.setSelectedIndex(0);
//        cmbTimKiemLoaiKH.setSelectedIndex(0);
//        txtTimKiemSDT.setText("");
//    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSearchIdName = new javax.swing.JTextField();
        cmbTimKiemLoaiKH = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbTimKiemGioiTinh = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtTimKiemSDT = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        btnResetTable = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        btnExportMauImport = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        pnlThemSuaKhachHang = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIDKH = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDiemTichLuy = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        cmbThemSuaLoaiKH = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cmbGioiTinhKH = new javax.swing.JComboBox<>();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        btnQLLKH = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bộ lọc danh sách khách hàng"));
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 140));
        jPanel2.setMinimumSize(new java.awt.Dimension(472, 140));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 140));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Nhập ID hoặc tên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 8);
        jPanel2.add(jLabel1, gridBagConstraints);

        jLabel3.setText("Loại khách");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel2.add(jLabel3, gridBagConstraints);

        txtSearchIdName.setMinimumSize(new java.awt.Dimension(250, 22));
        txtSearchIdName.setPreferredSize(new java.awt.Dimension(250, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 20);
        jPanel2.add(txtSearchIdName, gridBagConstraints);

        cmbTimKiemLoaiKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả" }));
        cmbTimKiemLoaiKH.setMinimumSize(new java.awt.Dimension(100, 22));
        cmbTimKiemLoaiKH.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 20);
        jPanel2.add(cmbTimKiemLoaiKH, gridBagConstraints);

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setMinimumSize(new java.awt.Dimension(100, 24));
        btnTimKiem.setPreferredSize(new java.awt.Dimension(100, 24));
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 20);
        jPanel2.add(btnTimKiem, gridBagConstraints);

        jLabel2.setText("Giới Tính");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 8);
        jPanel2.add(jLabel2, gridBagConstraints);

        cmbTimKiemGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Nam", "Nữ" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 20);
        jPanel2.add(cmbTimKiemGioiTinh, gridBagConstraints);

        jLabel12.setText("Số điện thoại");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 8);
        jPanel2.add(jLabel12, gridBagConstraints);

        txtTimKiemSDT.setMinimumSize(new java.awt.Dimension(250, 22));
        txtTimKiemSDT.setPreferredSize(new java.awt.Dimension(250, 22));
        txtTimKiemSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemSDTActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 20);
        jPanel2.add(txtTimKiemSDT, gridBagConstraints);

        jPanel1.add(jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách khách hàng"));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 402));

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        jPanel3.add(jScrollPane1, gridBagConstraints);

        btnResetTable.setText("Reset");
        btnResetTable.setMaximumSize(new java.awt.Dimension(80, 24));
        btnResetTable.setMinimumSize(new java.awt.Dimension(80, 24));
        btnResetTable.setPreferredSize(new java.awt.Dimension(80, 24));
        btnResetTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetTableMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 20);
        jPanel3.add(btnResetTable, gridBagConstraints);

        btnImport.setText("Import");
        btnImport.setMaximumSize(new java.awt.Dimension(80, 24));
        btnImport.setMinimumSize(new java.awt.Dimension(80, 24));
        btnImport.setPreferredSize(new java.awt.Dimension(80, 24));
        btnImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImportMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 12, 4);
        jPanel3.add(btnImport, gridBagConstraints);

        btnExportMauImport.setText("Export mẫu import");
        btnExportMauImport.setMaximumSize(new java.awt.Dimension(140, 24));
        btnExportMauImport.setMinimumSize(new java.awt.Dimension(140, 24));
        btnExportMauImport.setPreferredSize(new java.awt.Dimension(140, 24));
        btnExportMauImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportMauImportMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 4);
        jPanel3.add(btnExportMauImport, gridBagConstraints);

        btnExport.setText("Export");
        btnExport.setMaximumSize(new java.awt.Dimension(80, 24));
        btnExport.setMinimumSize(new java.awt.Dimension(80, 24));
        btnExport.setPreferredSize(new java.awt.Dimension(80, 24));
        btnExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 4);
        jPanel3.add(btnExport, gridBagConstraints);

        jPanel1.add(jPanel3);

        add(jPanel1);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jPanel5.setMaximumSize(new java.awt.Dimension(2147483647, 140));
        jPanel5.setMinimumSize(new java.awt.Dimension(286, 140));
        jPanel5.setPreferredSize(new java.awt.Dimension(286, 140));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        btnThem.setText("Thêm ");
        btnThem.setEnabled(false);
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(btnThem, gridBagConstraints);

        btnSua.setText("Sửa");
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(btnSua, gridBagConstraints);

        jPanel4.add(jPanel5);

        pnlThemSuaKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm khách hàng"));
        pnlThemSuaKhachHang.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemSuaKhachHang.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Loại KH");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemSuaKhachHang.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Họ Tên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemSuaKhachHang.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Điểm tích lũy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemSuaKhachHang.add(jLabel7, gridBagConstraints);

        jLabel8.setText("SDT");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemSuaKhachHang.add(jLabel8, gridBagConstraints);

        jLabel9.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemSuaKhachHang.add(jLabel9, gridBagConstraints);

        jLabel10.setText("Ngày sinh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemSuaKhachHang.add(jLabel10, gridBagConstraints);

        txtIDKH.setEnabled(false);
        txtIDKH.setPreferredSize(new java.awt.Dimension(150, 22));
        txtIDKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDKHActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
        pnlThemSuaKhachHang.add(txtIDKH, gridBagConstraints);

        txtHoTen.setPreferredSize(new java.awt.Dimension(150, 22));
        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
        pnlThemSuaKhachHang.add(txtHoTen, gridBagConstraints);

        txtSDT.setPreferredSize(new java.awt.Dimension(150, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
        pnlThemSuaKhachHang.add(txtSDT, gridBagConstraints);

        txtDiemTichLuy.setText("0");
        txtDiemTichLuy.setEnabled(false);
        txtDiemTichLuy.setPreferredSize(new java.awt.Dimension(150, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
        pnlThemSuaKhachHang.add(txtDiemTichLuy, gridBagConstraints);

        txtEmail.setPreferredSize(new java.awt.Dimension(150, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
        pnlThemSuaKhachHang.add(txtEmail, gridBagConstraints);

        cmbThemSuaLoaiKH.setEnabled(false);
        cmbThemSuaLoaiKH.setPreferredSize(new java.awt.Dimension(150, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
        pnlThemSuaKhachHang.add(cmbThemSuaLoaiKH, gridBagConstraints);

        btnReset.setText("Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 4);
        pnlThemSuaKhachHang.add(btnReset, gridBagConstraints);

        btnLuu.setText("Lưu");
        btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuMouseClicked(evt);
            }
        });
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 20);
        pnlThemSuaKhachHang.add(btnLuu, gridBagConstraints);

        jLabel11.setText("Giới Tính");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemSuaKhachHang.add(jLabel11, gridBagConstraints);

        cmbGioiTinhKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cmbGioiTinhKH.setPreferredSize(new java.awt.Dimension(150, 22));
        cmbGioiTinhKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGioiTinhKHActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
        pnlThemSuaKhachHang.add(cmbGioiTinhKH, gridBagConstraints);

        jdcNgaySinh.setPreferredSize(new java.awt.Dimension(150, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
        pnlThemSuaKhachHang.add(jdcNgaySinh, gridBagConstraints);

        jPanel4.add(pnlThemSuaKhachHang);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng khác"));
        jPanel7.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        jPanel7.setMinimumSize(new java.awt.Dimension(200, 60));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 60));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        btnQLLKH.setText("Quản lý loại khách hàng");
        btnQLLKH.setMinimumSize(new java.awt.Dimension(180, 23));
        btnQLLKH.setPreferredSize(new java.awt.Dimension(180, 40));
        btnQLLKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQLLKHMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 12, 4);
        jPanel7.add(btnQLLKH, gridBagConstraints);

        jPanel4.add(jPanel7);

        add(jPanel4);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
//        btnThem.setEnabled(false);
//        btnSua.setEnabled(true);
//        dangThemKhachHang = true;
//        pnlThemSuaKhachHang.setBorder(BorderFactory.createTitledBorder("Thêm khách hàng"));
//        pnlThemSuaKhachHang.repaint();
//        
//        clearThemSuaKhachHang();
//        btnLuu.setEnabled(true);
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
//        // TODO add your handling code here:
//        btnThem.setEnabled(true);
//        btnSua.setEnabled(false);
//        dangThemKhachHang = false;
//        pnlThemSuaKhachHang.setBorder(BorderFactory.createTitledBorder("Sửa khách hàng"));
//        pnlThemSuaKhachHang.repaint();
//        clearThemSuaKhachHang();
//        btnLuu.setEnabled(false);
    }//GEN-LAST:event_btnSuaMouseClicked

    private void txtIDKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDKHActionPerformed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
//        if(dangThemKhachHang)
//        clearThemSuaKhachHang();
//        else {
//            int id = Integer.parseInt(txtIDKH.getText());
//            KhachHangFull_DTO result = khachHang_BUS.getKhachHangFullById(id);
//
//            if(result == null){
//                JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu","Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//
//            txtIDKH.setText(Integer.toString(result.getId()));
//            txtHoTen.setText(result.getTen());
//            txtSDT.setText(result.getSdt());
//            txtDiemTichLuy.setText(Integer.toString(result.getDiemTichLuy()));
//            txtEmail.setText(result.getEmail().trim());
//            cmbThemSuaLoaiKH.setSelectedIndex(result.getLoaiKhachHang().getId()-1);
//            jdcNgaySinh.setDate(result.getNgaySinh());
//            if(result.isGioiTinhNam())
//            cmbGioiTinhKH.setSelectedIndex(0);
//            else
//            cmbGioiTinhKH.setSelectedIndex(1);
//        }
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseClicked
        // TODO add your handling code here:
//        String hoTen = txtHoTen.getText().trim();
//        if(hoTen.isBlank()){
//            JOptionPane.showMessageDialog(this, "Họ tên không được để trống","Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        String sdt = txtSDT.getText().trim();
//       if(!CheckHopLe.checkSoDienThoai(sdt)){
//            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ","Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        Timestamp ngaySinh;
//        ngaySinh = new Timestamp(jdcNgaySinh.getDate().getTime());
//        int tuoi = Period.between(ngaySinh.toLocalDateTime().toLocalDate(), LocalDate.now()).getYears();
//        if(tuoi < 18){
//            JOptionPane.showMessageDialog(this, "Khách hàng phải từ 18 tuổi trở lên","Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        boolean gioiTinhNam = true;
//        if(cmbTimKiemGioiTinh.getSelectedIndex() == 1){
//            gioiTinhNam = false;
//        }
//
//        String email = txtEmail.getText().trim();
//        if(!CheckHopLe.checkEmail(email)){
//            JOptionPane.showMessageDialog(this, "Email không hợp lệ","Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        if(dangThemKhachHang){
//            CreateKhachHang_DTO data = new CreateKhachHang_DTO( hoTen, sdt, email, ngaySinh, gioiTinhNam);
//            boolean result = khachHang_BUS.createKhachHang(data);
//            if(result){
//                JOptionPane.showMessageDialog(this, "Thêm khách hàng mới thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                clearThemSuaKhachHang();
//                loadTableKhachHang();
//            }
//            else
//            JOptionPane.showMessageDialog(this, "Thêm khách hàng mới thất bại","Error", JOptionPane.ERROR_MESSAGE);
//
//        } else {
//            int id = Integer.parseInt(txtIDKH.getText());
//
//            UpdateKhachHang_DTO data = new UpdateKhachHang_DTO(id, hoTen, sdt, email, ngaySinh, gioiTinhNam);
//            boolean result = khachHang_BUS.updateKhachHang(data);
//            if(result){
//                JOptionPane.showMessageDialog(this, "Sửa khách hàng thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                loadTableKhachHang();
//            }
//            else
//            JOptionPane.showMessageDialog(this, "Sửa khách hàng thất bại","Error", JOptionPane.ERROR_MESSAGE);
//        }
//        loadTableKhachHang();
    }//GEN-LAST:event_btnLuuMouseClicked

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLuuActionPerformed

    private void cmbGioiTinhKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGioiTinhKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGioiTinhKHActionPerformed

    private void btnQLLKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQLLKHMouseClicked
        // TODO add your handling code here:
//        if(quanLyLoaiKhachHang_GUI == null || !quanLyLoaiKhachHang_GUI.isDisplayable()){
//            quanLyLoaiKhachHang_GUI = new QuanLyLoaiKhachHang_GUI();
//            quanLyLoaiKhachHang_GUI.setVisible(true);
//        } else {
//            quanLyLoaiKhachHang_GUI.setState(JFrame.NORMAL);
//            quanLyLoaiKhachHang_GUI.toFront();
//        }
//        clearSearchBox();
//        loadTableKhachHang();
    }//GEN-LAST:event_btnQLLKHMouseClicked

    private void btnImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportMouseClicked
//        // TODO add your handling code here:
//        int totalSuccess = 0;
//
//        JFileChooser jFileChooser = new JFileChooser("D:");
//        if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//            totalSuccess = khachHang_BUS.importKhachHang(jFileChooser.getSelectedFile().getAbsolutePath());
//
//            JOptionPane.showMessageDialog(this, "Cập nhật " + totalSuccess + " khách hàng","Import danh sách nhân viên", JOptionPane.INFORMATION_MESSAGE);
//
//            loadTableKhachHang();
//        }else {
//            JOptionPane.showMessageDialog(this, "Import file excel thất bại","Error", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_btnImportMouseClicked

    private void btnExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMouseClicked
        // TODO add your handling code here:
//        boolean result = false;
//        JFileChooser jFileChooser = new JFileChooser("D:");
//        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//
//        if (jFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
//            result = khachHang_BUS.exportKhachHang(listKhachHang, jFileChooser.getSelectedFile().getAbsolutePath());
//        }
//
//        if (!result) {
//            JOptionPane.showMessageDialog(this, "Xuất file excel thất bại","Error", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_btnExportMouseClicked

    private void btnExportMauImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMauImportMouseClicked
        // TODO add your handling code here:
//        boolean result = false;
//
//        JFileChooser jFileChooser = new JFileChooser("D:");
//        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//
//        if (jFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
//            result = khachHang_BUS.exportAllKhachHangTheoMauImport(jFileChooser.getSelectedFile().getAbsolutePath());
//        }
//
//        if (!result) {
//            JOptionPane.showMessageDialog(this, "Export file excel thất bại","Error", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_btnExportMauImportMouseClicked

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        // TODO add your handling code here:
//        SearchKhachHang_DTO searchKhachHang_DTO = new SearchKhachHang_DTO();
//
//        String idOrName = txtSearchIdName.getText();
//        if(!idOrName.isBlank()){
//            searchKhachHang_DTO.setIdOrName(idOrName.trim());
//        }
//
//        int idLoaiKhach = cmbTimKiemLoaiKH.getSelectedIndex();
//        if(idLoaiKhach > 0){
//            searchKhachHang_DTO.setLoaiKhachHang(listLoaiKhach.get(idLoaiKhach -1).getId());
//        }
//
//        int gioiTinh = cmbTimKiemGioiTinh.getSelectedIndex();
//        switch (gioiTinh) {
//            case 1 -> searchKhachHang_DTO.setGioiTinh(GioiTinhConstraints.NAM);
//            case 2 -> searchKhachHang_DTO.setGioiTinh(GioiTinhConstraints.NU);
//            default -> searchKhachHang_DTO.setGioiTinh(-1);
//        }
//
//        String SDT = txtTimKiemSDT.getText().trim();
//        if(!SDT.isBlank()){
//            searchKhachHang_DTO.setSdt(SDT);
//        }
//
//        ArrayList<KhachHang_DTO> result = khachHang_BUS.searchKhachHang(searchKhachHang_DTO);
//        loadTableKhachHang(result);
    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void txtTimKiemSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemSDTActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
//        if(dangThemKhachHang)
//        return;
//
//        int index = tblKhachHang.getSelectedRow();
//        TableModel model = tblKhachHang.getModel();
//
//        int id = Integer.parseInt(model.getValueAt(index, 0).toString());
//        KhachHangFull_DTO result = khachHang_BUS.getKhachHangFullById(id);
//
//        if(result == null){
//            JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu","Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        txtIDKH.setText(Integer.toString(result.getId()));
//        txtHoTen.setText(result.getTen());
//        txtSDT.setText(result.getSdt());
//        txtDiemTichLuy.setText(Integer.toString(result.getDiemTichLuy()));
//        txtEmail.setText(result.getEmail().trim());
//        cmbThemSuaLoaiKH.setSelectedIndex(result.getLoaiKhachHang().getId()-1);
//        jdcNgaySinh.setDate(result.getNgaySinh());
//        if(result.isGioiTinhNam())
//        cmbGioiTinhKH.setSelectedIndex(0);
//        else
//        cmbGioiTinhKH.setSelectedIndex(1);
//        btnLuu.setEnabled(true);

    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnResetTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetTableMouseClicked
        // TODO add your handling code here:
//        khachHang_BUS.capNhatLoaiKhachHang();
//        loadTableKhachHang();
//        clearSearchBox();
    }//GEN-LAST:event_btnResetTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnExportMauImport;
    private javax.swing.JButton btnImport;
    public javax.swing.JButton btnLuu;
    public javax.swing.JButton btnQLLKH;
    public javax.swing.JButton btnReset;
    private javax.swing.JButton btnResetTable;
    public javax.swing.JButton btnSua;
    public javax.swing.JButton btnThem;
    public javax.swing.JButton btnTimKiem;
    public javax.swing.JComboBox<String> cmbGioiTinhKH;
    public javax.swing.JComboBox<String> cmbThemSuaLoaiKH;
    public javax.swing.JComboBox<String> cmbTimKiemGioiTinh;
    public javax.swing.JComboBox<String> cmbTimKiemLoaiKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    public com.toedter.calendar.JDateChooser jdcNgaySinh;
    public javax.swing.JPanel pnlThemSuaKhachHang;
    public javax.swing.JTable tblKhachHang;
    public javax.swing.JTextField txtDiemTichLuy;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtHoTen;
    public javax.swing.JTextField txtIDKH;
    public javax.swing.JTextField txtSDT;
    public javax.swing.JTextField txtSearchIdName;
    public javax.swing.JTextField txtTimKiemSDT;
    // End of variables declaration//GEN-END:variables

}
