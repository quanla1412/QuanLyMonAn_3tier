
package gui.views;


import gui.controllers.QuanLyChucVuController;
import gui.models.NhanVien.ChucVuModel;
import gui.models.NhanVien.NhanVienModel;
import gui.models.NhanVien.TinhTrangNhanVienModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class QuanLyNhanVien_GUI extends javax.swing.JPanel {
    private QuanLyChucVuController quanLyChucVuController;
   
    
    public QuanLyNhanVien_GUI() {
        initComponents();
       
  
    }

   public void loadTableNhanVien (List<NhanVienModel> listNhanVienModel){
        String col[] = {"Mã nhân viên", "Tên nhân viên", "SDT", "Chức Vụ", "Tình trạng"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        tblDanhSachNV.setModel(tableModel);
        for(NhanVienModel row : listNhanVienModel){
            Object[] data = {row.getMa(), row.getHoTen(), row.getSdt(), row.getTenChucVu(), row.getTinhTrangNhanVien()};
            tableModel.addRow(data);
        }
    }
    
  
    
    public void loadComboBoxChucVu(ArrayList<ChucVuModel> listChucVu){
        cmbThemChucVu.removeAllItems();
        cmbTimKiemChucVu.removeAllItems();
    
        for (ChucVuModel cv : listChucVu)
        {
            cmbThemChucVu.addItem(cv.getTen());
            cmbTimKiemChucVu.addItem(cv.getTen());
           
        }
        cmbThemChucVu.setSelectedIndex(-1);
        cmbTimKiemChucVu.setSelectedIndex(0);
    }
    
    public void loadComboBoxTinhTrangNhanVien(ArrayList<TinhTrangNhanVienModel> listTinhTrangNhanVien){
        cmbTinhTrangNV.removeAllItems();
            
        for(TinhTrangNhanVienModel ttnv : listTinhTrangNhanVien){
            cmbTinhTrangNV.addItem(ttnv.getTen());
        }        
        cmbTinhTrangNV.setSelectedIndex(-1);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaOrTen = new javax.swing.JTextField();
        cmbTimKiemGioiTinhNhanVien = new javax.swing.JComboBox<>();
        cmbTimKiemChucVu = new javax.swing.JComboBox<>();
        btnTimKiemNhanVien = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cmbTinhTrangNhanVienSearch = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachNV = new javax.swing.JTable();
        btnResetTable = new javax.swing.JButton();
        btnImportNV = new javax.swing.JButton();
        btnExportMauImport = new javax.swing.JButton();
        btnExportNV = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnThemNV = new javax.swing.JButton();
        btnSuaNV = new javax.swing.JButton();
        btnXoaNV = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();
        btnPhanQuyen = new javax.swing.JButton();
        pnlThemNhanVien = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtSDTNV = new javax.swing.JTextField();
        txtHoTenNV = new javax.swing.JTextField();
        txtEmailNV = new javax.swing.JTextField();
        txtDiaChiNV = new javax.swing.JTextField();
        cmbTinhTrangNV = new javax.swing.JComboBox<>();
        btnResetThemNV = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbThemChucVu = new javax.swing.JComboBox<>();
        cmbGioiTinhNVThemSua = new javax.swing.JComboBox<>();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnQuanLyChucVu = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setPreferredSize(new java.awt.Dimension(514, 231));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bộ lọc danh sách nhân viên"));
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 160));
        jPanel2.setMinimumSize(new java.awt.Dimension(604, 160));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 160));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Nhập Mã hoặc Tên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 4);
        jPanel2.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Giới tính");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 4);
        jPanel2.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Chức Vụ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel2.add(jLabel3, gridBagConstraints);

        txtMaOrTen.setMinimumSize(new java.awt.Dimension(200, 22));
        txtMaOrTen.setPreferredSize(new java.awt.Dimension(250, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        jPanel2.add(txtMaOrTen, gridBagConstraints);

        cmbTimKiemGioiTinhNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Nam", "Nữ" }));
        cmbTimKiemGioiTinhNhanVien.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel2.add(cmbTimKiemGioiTinhNhanVien, gridBagConstraints);

        cmbTimKiemChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cmbTimKiemChucVu.setMinimumSize(new java.awt.Dimension(120, 22));
        cmbTimKiemChucVu.setPreferredSize(new java.awt.Dimension(120, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        jPanel2.add(cmbTimKiemChucVu, gridBagConstraints);

        btnTimKiemNhanVien.setText("Tìm kiếm");
        btnTimKiemNhanVien.setMaximumSize(new java.awt.Dimension(120, 22));
        btnTimKiemNhanVien.setMinimumSize(new java.awt.Dimension(120, 22));
        btnTimKiemNhanVien.setPreferredSize(new java.awt.Dimension(120, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        jPanel2.add(btnTimKiemNhanVien, gridBagConstraints);

        jLabel13.setText("Tình trạng nhân viên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 4);
        jPanel2.add(jLabel13, gridBagConstraints);

        cmbTinhTrangNhanVienSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang hoạt động", "Tạm nghỉ ", "Đã nghỉ" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel2.add(cmbTinhTrangNhanVienSearch, gridBagConstraints);

        jPanel1.add(jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách nhân viên"));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        tblDanhSachNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên nhân viên", "Số diện thoại", "Chức vụ", "Tình trạng"
            }
        )

    );
    tblDanhSachNV.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jScrollPane1.setViewportView(tblDanhSachNV);

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

    btnResetTable.setText("Reset bảng");
    btnResetTable.setMaximumSize(new java.awt.Dimension(100, 24));
    btnResetTable.setMinimumSize(new java.awt.Dimension(100, 24));
    btnResetTable.setPreferredSize(new java.awt.Dimension(100, 24));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 20);
    jPanel3.add(btnResetTable, gridBagConstraints);

    btnImportNV.setText("Import");
    btnImportNV.setMaximumSize(new java.awt.Dimension(80, 24));
    btnImportNV.setMinimumSize(new java.awt.Dimension(80, 24));
    btnImportNV.setPreferredSize(new java.awt.Dimension(80, 24));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 12, 4);
    jPanel3.add(btnImportNV, gridBagConstraints);

    btnExportMauImport.setText("Export mẫu import");
    btnExportMauImport.setMaximumSize(new java.awt.Dimension(140, 24));
    btnExportMauImport.setMinimumSize(new java.awt.Dimension(140, 24));
    btnExportMauImport.setPreferredSize(new java.awt.Dimension(140, 24));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 4, 12, 4);
    jPanel3.add(btnExportMauImport, gridBagConstraints);

    btnExportNV.setText("Export");
    btnExportNV.setMaximumSize(new java.awt.Dimension(80, 24));
    btnExportNV.setMinimumSize(new java.awt.Dimension(80, 24));
    btnExportNV.setPreferredSize(new java.awt.Dimension(80, 24));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 4, 12, 4);
    jPanel3.add(btnExportNV, gridBagConstraints);

    jPanel1.add(jPanel3);

    add(jPanel1);

    jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.PAGE_AXIS));

    jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
    jPanel5.setMaximumSize(new java.awt.Dimension(2147483647, 160));
    jPanel5.setMinimumSize(new java.awt.Dimension(380, 160));
    jPanel5.setPreferredSize(new java.awt.Dimension(380, 160));
    jPanel5.setLayout(new java.awt.GridBagLayout());

    btnThemNV.setText("Thêm ");
    btnThemNV.setEnabled(false);
    btnThemNV.setMaximumSize(new java.awt.Dimension(120, 24));
    btnThemNV.setMinimumSize(new java.awt.Dimension(120, 24));
    btnThemNV.setPreferredSize(new java.awt.Dimension(120, 24));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
    jPanel5.add(btnThemNV, gridBagConstraints);

    btnSuaNV.setText("Sửa");
    btnSuaNV.setMaximumSize(new java.awt.Dimension(120, 24));
    btnSuaNV.setMinimumSize(new java.awt.Dimension(120, 24));
    btnSuaNV.setPreferredSize(new java.awt.Dimension(120, 24));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
    jPanel5.add(btnSuaNV, gridBagConstraints);

    btnXoaNV.setText("Xóa");
    btnXoaNV.setMaximumSize(new java.awt.Dimension(120, 24));
    btnXoaNV.setMinimumSize(new java.awt.Dimension(120, 24));
    btnXoaNV.setPreferredSize(new java.awt.Dimension(120, 24));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    jPanel5.add(btnXoaNV, gridBagConstraints);

    btnDoiMatKhau.setText("Đổi mật khẩu");
    btnDoiMatKhau.setMaximumSize(new java.awt.Dimension(120, 24));
    btnDoiMatKhau.setMinimumSize(new java.awt.Dimension(120, 24));
    btnDoiMatKhau.setPreferredSize(new java.awt.Dimension(120, 24));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
    jPanel5.add(btnDoiMatKhau, gridBagConstraints);

    btnPhanQuyen.setText("Phân quyền tài khoản");
    btnPhanQuyen.setMinimumSize(new java.awt.Dimension(140, 24));
    btnPhanQuyen.setPreferredSize(new java.awt.Dimension(140, 24));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
    jPanel5.add(btnPhanQuyen, gridBagConstraints);

    jPanel4.add(jPanel5);

    pnlThemNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm nhân viên"));
    pnlThemNhanVien.setLayout(new java.awt.GridBagLayout());

    jLabel4.setText("Mã nhân viên");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel4, gridBagConstraints);

    jLabel5.setText("Tình trạng");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel5, gridBagConstraints);

    jLabel6.setText("Chức vụ");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel6, gridBagConstraints);

    jLabel7.setText("Ngày sinh");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel7, gridBagConstraints);

    jLabel8.setText("Họ tên");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel8, gridBagConstraints);

    jLabel9.setText("Giới tính");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel9, gridBagConstraints);

    jLabel10.setText("Email");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel10, gridBagConstraints);

    txtMaNV.setPreferredSize(new java.awt.Dimension(150, 22));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(txtMaNV, gridBagConstraints);

    txtSDTNV.setPreferredSize(new java.awt.Dimension(150, 22));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 7;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(txtSDTNV, gridBagConstraints);

    txtHoTenNV.setMinimumSize(new java.awt.Dimension(72, 22));
    txtHoTenNV.setPreferredSize(new java.awt.Dimension(150, 22));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(txtHoTenNV, gridBagConstraints);

    txtEmailNV.setPreferredSize(new java.awt.Dimension(150, 22));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(txtEmailNV, gridBagConstraints);

    txtDiaChiNV.setPreferredSize(new java.awt.Dimension(150, 22));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(txtDiaChiNV, gridBagConstraints);

    cmbTinhTrangNV.setPreferredSize(new java.awt.Dimension(150, 22));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(cmbTinhTrangNV, gridBagConstraints);

    btnResetThemNV.setText("Reset");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(btnResetThemNV, gridBagConstraints);

    btnLuu.setText("Lưu");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(btnLuu, gridBagConstraints);

    jLabel11.setText("Địa chỉ");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel11, gridBagConstraints);

    jLabel12.setText("SDT");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 7;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel12, gridBagConstraints);

    cmbThemChucVu.setPreferredSize(new java.awt.Dimension(150, 22));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(cmbThemChucVu, gridBagConstraints);

    cmbGioiTinhNVThemSua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam ", "Nữ" }));
    cmbGioiTinhNVThemSua.setPreferredSize(new java.awt.Dimension(150, 22));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(cmbGioiTinhNVThemSua, gridBagConstraints);

    jdcNgaySinh.setPreferredSize(new java.awt.Dimension(150, 22));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(jdcNgaySinh, gridBagConstraints);

    jLabel14.setText("CCCD");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 9;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel14, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 9;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(txtCCCD, gridBagConstraints);

    jPanel4.add(pnlThemNhanVien);

    jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng khác"));
    jPanel7.setMaximumSize(new java.awt.Dimension(2147483647, 60));
    jPanel7.setMinimumSize(new java.awt.Dimension(157, 60));
    jPanel7.setPreferredSize(new java.awt.Dimension(157, 60));
    jPanel7.setLayout(new java.awt.GridBagLayout());

    btnQuanLyChucVu.setText("Quản lý chức vụ");
    btnQuanLyChucVu.setMaximumSize(new java.awt.Dimension(140, 24));
    btnQuanLyChucVu.setMinimumSize(new java.awt.Dimension(140, 24));
    btnQuanLyChucVu.setPreferredSize(new java.awt.Dimension(140, 24));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(4, 4, 12, 4);
    jPanel7.add(btnQuanLyChucVu, gridBagConstraints);

    jPanel4.add(jPanel7);

    add(jPanel4);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDoiMatKhau;
    public javax.swing.JButton btnExportMauImport;
    public javax.swing.JButton btnExportNV;
    public javax.swing.JButton btnImportNV;
    public javax.swing.JButton btnLuu;
    public javax.swing.JButton btnPhanQuyen;
    public javax.swing.JButton btnQuanLyChucVu;
    public javax.swing.JButton btnResetTable;
    public javax.swing.JButton btnResetThemNV;
    public javax.swing.JButton btnSuaNV;
    public javax.swing.JButton btnThemNV;
    public javax.swing.JButton btnTimKiemNhanVien;
    public javax.swing.JButton btnXoaNV;
    public javax.swing.JComboBox<String> cmbGioiTinhNVThemSua;
    public javax.swing.JComboBox<String> cmbThemChucVu;
    public javax.swing.JComboBox<String> cmbTimKiemChucVu;
    public javax.swing.JComboBox<String> cmbTimKiemGioiTinhNhanVien;
    public javax.swing.JComboBox<String> cmbTinhTrangNV;
    public javax.swing.JComboBox<String> cmbTinhTrangNhanVienSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    public javax.swing.JPanel pnlThemNhanVien;
    public javax.swing.JTable tblDanhSachNV;
    public javax.swing.JTextField txtCCCD;
    public javax.swing.JTextField txtDiaChiNV;
    public javax.swing.JTextField txtEmailNV;
    public javax.swing.JTextField txtHoTenNV;
    public javax.swing.JTextField txtMaNV;
    public javax.swing.JTextField txtMaOrTen;
    public javax.swing.JTextField txtSDTNV;
    // End of variables declaration//GEN-END:variables
}
