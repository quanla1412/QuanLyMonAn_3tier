/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui.views;

import com.mycompany.quanlynhahang.Price;
import gui.models.HoaDon.ChiTietHoaDonModel;
import gui.models.HoaDon.HoaDonModel;
import gui.models.MonAn.MonAnModel;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tanph
 */
public class QuanLyHoaDon_GUI extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyHoaDon_GUI
     */
    public QuanLyHoaDon_GUI() {
        initComponents();
    }
    
    public void loadTableHoaDon(ArrayList<HoaDonModel> listHoaDon){
        String col[] = {"ID","Mã nhân viên","Mã khách hàng","Ngày giờ","Tổng giá"};
        DefaultTableModel tableModel = new DefaultTableModel(col,0);
        tblDanhSachHoaDon.setModel(tableModel);
        for(HoaDonModel row: listHoaDon){
            Object[] data = {row.getId(), row.getMaNhanVien(),row.getIdKhachHang(),row.getNgayGio(),Price.formatPrice(row.getTongGia())};
            tableModel.addRow(data);
        }
    }
    
    public void loadTableChiTietHoaDonById(ArrayList<ChiTietHoaDonModel> listChiTietHoaDon, long totalPrice){
        int count = 1;

        String col[] = {"ID","Tên món ăn","Giá","Số Lượng","Thành Tiền"};
        DefaultTableModel tableModel = new DefaultTableModel(col,0);
        tblDonGoi.setModel(tableModel);
        for(ChiTietHoaDonModel row : listChiTietHoaDon){
            Object[] data = {count,row.getTenMonAn(),Price.formatPrice(row.getGia()),row.getSoLuong(),Price.formatPrice(row.getThanhTien())};
            tableModel.addRow(data);
            count++;
        }
        txtTongTien.setText(Price.formatPrice(totalPrice));
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
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel10 = new javax.swing.JPanel();
        pnlBoLocTimKiem = new javax.swing.JPanel();
        lblNhapID = new javax.swing.JLabel();
        lblLocQuyen = new javax.swing.JLabel();
        dtcNgayCuoiCung = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        dtcNgayBatDau = new com.toedter.calendar.JDateChooser();
        txtSearchID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lblMinPrice = new javax.swing.JLabel();
        lblMaxPrice = new javax.swing.JLabel();
        sldMinPrice = new javax.swing.JSlider();
        sldMaxPrice = new javax.swing.JSlider();
        jLabel17 = new javax.swing.JLabel();
        cmbTTMASearch = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pnlBangDanhSachTaiKhoan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachHoaDon = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        lblDoanhThuTrongNgay = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDoanhThu7NgayGanNhat = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        pnlThemTaiKhoanMoi = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblQuyen = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        txtIdNhanVien = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDonGoi = new javax.swing.JTable();
        lblID1 = new javax.swing.JLabel();
        lblID2 = new javax.swing.JLabel();
        lblID3 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        txtIdKhachHang = new javax.swing.JTextField();
        txtUuDai = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        dtcNgayGio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        btnHuyHoaDon = new javax.swing.JButton();
        lblQuyen1 = new javax.swing.JLabel();
        txtTinhTrangHoaDon = new javax.swing.JTextField();
        lblID4 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.Y_AXIS));

        pnlBoLocTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder("Bộ lọc tìm kiếm"));
        pnlBoLocTimKiem.setMinimumSize(new java.awt.Dimension(520, 200));
        pnlBoLocTimKiem.setPreferredSize(new java.awt.Dimension(520, 200));
        pnlBoLocTimKiem.setLayout(new java.awt.GridBagLayout());

        lblNhapID.setText("Nhập ID");
        lblNhapID.setMaximumSize(new java.awt.Dimension(112, 24));
        lblNhapID.setMinimumSize(new java.awt.Dimension(112, 24));
        lblNhapID.setPreferredSize(new java.awt.Dimension(112, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        pnlBoLocTimKiem.add(lblNhapID, gridBagConstraints);

        lblLocQuyen.setText("Từ ngày");
        lblLocQuyen.setMaximumSize(new java.awt.Dimension(112, 24));
        lblLocQuyen.setMinimumSize(new java.awt.Dimension(112, 24));
        lblLocQuyen.setPreferredSize(new java.awt.Dimension(112, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        pnlBoLocTimKiem.add(lblLocQuyen, gridBagConstraints);

        dtcNgayCuoiCung.setMinimumSize(new java.awt.Dimension(120, 24));
        dtcNgayCuoiCung.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 20);
        pnlBoLocTimKiem.add(dtcNgayCuoiCung, gridBagConstraints);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đến ngày");
        jLabel1.setMaximumSize(new java.awt.Dimension(42, 16));
        jLabel1.setMinimumSize(new java.awt.Dimension(42, 16));
        jLabel1.setPreferredSize(new java.awt.Dimension(42, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        pnlBoLocTimKiem.add(jLabel1, gridBagConstraints);

        dtcNgayBatDau.setMinSelectableDate(new java.util.Date(-62135791113000L));
        dtcNgayBatDau.setMinimumSize(new java.awt.Dimension(120, 24));
        dtcNgayBatDau.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        pnlBoLocTimKiem.add(dtcNgayBatDau, gridBagConstraints);

        txtSearchID.setMinimumSize(new java.awt.Dimension(310, 24));
        txtSearchID.setPreferredSize(new java.awt.Dimension(310, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.03;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 20);
        pnlBoLocTimKiem.add(txtSearchID, gridBagConstraints);

        jLabel10.setText("Khoảng giá:");
        jLabel10.setMaximumSize(new java.awt.Dimension(112, 24));
        jLabel10.setMinimumSize(new java.awt.Dimension(112, 24));
        jLabel10.setPreferredSize(new java.awt.Dimension(112, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        pnlBoLocTimKiem.add(jLabel10, gridBagConstraints);

        lblMinPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinPrice.setText("0 VNĐ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        pnlBoLocTimKiem.add(lblMinPrice, gridBagConstraints);

        lblMaxPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaxPrice.setText("100.000.000 VNĐ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 20);
        pnlBoLocTimKiem.add(lblMaxPrice, gridBagConstraints);

        sldMinPrice.setMaximum(100000000);
        sldMinPrice.setValue(0);
        sldMinPrice.setMinimumSize(new java.awt.Dimension(120, 24));
        sldMinPrice.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        pnlBoLocTimKiem.add(sldMinPrice, gridBagConstraints);

        sldMaxPrice.setMaximum(100000000);
        sldMaxPrice.setToolTipText("");
        sldMaxPrice.setValue(100000000);
        sldMaxPrice.setMinimumSize(new java.awt.Dimension(120, 24));
        sldMaxPrice.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 20);
        pnlBoLocTimKiem.add(sldMaxPrice, gridBagConstraints);

        jLabel17.setText("Tình trạng hoá đơn");
        jLabel17.setMaximumSize(new java.awt.Dimension(112, 24));
        jLabel17.setMinimumSize(new java.awt.Dimension(112, 24));
        jLabel17.setPreferredSize(new java.awt.Dimension(112, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        pnlBoLocTimKiem.add(jLabel17, gridBagConstraints);

        cmbTTMASearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hợp lệ", "Đã huỷ" }));
        cmbTTMASearch.setMinimumSize(new java.awt.Dimension(120, 24));
        cmbTTMASearch.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        pnlBoLocTimKiem.add(cmbTTMASearch, gridBagConstraints);

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setMaximumSize(new java.awt.Dimension(80, 24));
        btnTimKiem.setMinimumSize(new java.awt.Dimension(80, 24));
        btnTimKiem.setPreferredSize(new java.awt.Dimension(80, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 20);
        pnlBoLocTimKiem.add(btnTimKiem, gridBagConstraints);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("~");
        jLabel18.setMaximumSize(new java.awt.Dimension(20, 20));
        jLabel18.setMinimumSize(new java.awt.Dimension(20, 20));
        jLabel18.setPreferredSize(new java.awt.Dimension(12, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        pnlBoLocTimKiem.add(jLabel18, gridBagConstraints);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("~");
        jLabel16.setMaximumSize(new java.awt.Dimension(20, 20));
        jLabel16.setMinimumSize(new java.awt.Dimension(20, 20));
        jLabel16.setPreferredSize(new java.awt.Dimension(12, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        pnlBoLocTimKiem.add(jLabel16, gridBagConstraints);

        jPanel10.add(pnlBoLocTimKiem);

        pnlBangDanhSachTaiKhoan.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách hoá đơn"));
        pnlBangDanhSachTaiKhoan.setLayout(new java.awt.GridBagLayout());

        tblDanhSachHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDanhSachHoaDon);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        pnlBangDanhSachTaiKhoan.add(jScrollPane1, gridBagConstraints);

        btnReset.setText("Reset");
        btnReset.setMaximumSize(new java.awt.Dimension(80, 24));
        btnReset.setMinimumSize(new java.awt.Dimension(80, 24));
        btnReset.setPreferredSize(new java.awt.Dimension(80, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 8, 20);
        pnlBangDanhSachTaiKhoan.add(btnReset, gridBagConstraints);

        lblDoanhThuTrongNgay.setText("Trong ngày: 20.000.000 VNĐ");
        lblDoanhThuTrongNgay.setMaximumSize(new java.awt.Dimension(160, 24));
        lblDoanhThuTrongNgay.setMinimumSize(new java.awt.Dimension(160, 24));
        lblDoanhThuTrongNgay.setPreferredSize(new java.awt.Dimension(160, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 20);
        pnlBangDanhSachTaiKhoan.add(lblDoanhThuTrongNgay, gridBagConstraints);

        jLabel4.setText("Doanh thu");
        jLabel4.setMaximumSize(new java.awt.Dimension(60, 24));
        jLabel4.setMinimumSize(new java.awt.Dimension(60, 24));
        jLabel4.setPreferredSize(new java.awt.Dimension(60, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 8, 20);
        pnlBangDanhSachTaiKhoan.add(jLabel4, gridBagConstraints);

        lblDoanhThu7NgayGanNhat.setText("7 ngày gần nhất: 160.000.000 VNĐ");
        lblDoanhThu7NgayGanNhat.setMaximumSize(new java.awt.Dimension(200, 24));
        lblDoanhThu7NgayGanNhat.setMinimumSize(new java.awt.Dimension(200, 24));
        lblDoanhThu7NgayGanNhat.setPreferredSize(new java.awt.Dimension(200, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 20);
        pnlBangDanhSachTaiKhoan.add(lblDoanhThu7NgayGanNhat, gridBagConstraints);

        jPanel10.add(pnlBangDanhSachTaiKhoan);

        add(jPanel10);

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.Y_AXIS));

        pnlThemTaiKhoanMoi.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết hoá đơn"));
        pnlThemTaiKhoanMoi.setMinimumSize(new java.awt.Dimension(400, 220));
        pnlThemTaiKhoanMoi.setPreferredSize(new java.awt.Dimension(400, 220));
        pnlThemTaiKhoanMoi.setLayout(new java.awt.GridBagLayout());

        lblID.setText("Mã nhân viên");
        lblID.setMaximumSize(new java.awt.Dimension(120, 24));
        lblID.setMinimumSize(new java.awt.Dimension(120, 24));
        lblID.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemTaiKhoanMoi.add(lblID, gridBagConstraints);

        lblQuyen.setText("Mã khách hàng");
        lblQuyen.setMaximumSize(new java.awt.Dimension(120, 24));
        lblQuyen.setMinimumSize(new java.awt.Dimension(120, 24));
        lblQuyen.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemTaiKhoanMoi.add(lblQuyen, gridBagConstraints);

        lblMatKhau.setText("Ngày giờ");
        lblMatKhau.setMaximumSize(new java.awt.Dimension(120, 24));
        lblMatKhau.setMinimumSize(new java.awt.Dimension(120, 24));
        lblMatKhau.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemTaiKhoanMoi.add(lblMatKhau, gridBagConstraints);

        txtIdNhanVien.setEnabled(false);
        txtIdNhanVien.setMaximumSize(new java.awt.Dimension(172, 24));
        txtIdNhanVien.setMinimumSize(new java.awt.Dimension(172, 24));
        txtIdNhanVien.setPreferredSize(new java.awt.Dimension(172, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        pnlThemTaiKhoanMoi.add(txtIdNhanVien, gridBagConstraints);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setMinimumSize(new java.awt.Dimension(300, 180));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(300, 180));

        tblDonGoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên món ăn", "Giá", "Số lượng", "Thành tiền"
            }
        ));
        tblDonGoi.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblDonGoi.setEnabled(false);
        jScrollPane3.setViewportView(tblDonGoi);

        jPanel1.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
        pnlThemTaiKhoanMoi.add(jPanel1, gridBagConstraints);

        lblID1.setText("Thành tiền");
        lblID1.setMaximumSize(new java.awt.Dimension(120, 24));
        lblID1.setMinimumSize(new java.awt.Dimension(120, 24));
        lblID1.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemTaiKhoanMoi.add(lblID1, gridBagConstraints);

        lblID2.setText("Tổng tiền");
        lblID2.setMaximumSize(new java.awt.Dimension(120, 24));
        lblID2.setMinimumSize(new java.awt.Dimension(120, 24));
        lblID2.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemTaiKhoanMoi.add(lblID2, gridBagConstraints);

        lblID3.setText("Ưu đãi");
        lblID3.setMaximumSize(new java.awt.Dimension(120, 24));
        lblID3.setMinimumSize(new java.awt.Dimension(120, 24));
        lblID3.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemTaiKhoanMoi.add(lblID3, gridBagConstraints);

        txtTongTien.setEnabled(false);
        txtTongTien.setMinimumSize(new java.awt.Dimension(172, 24));
        txtTongTien.setPreferredSize(new java.awt.Dimension(172, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        pnlThemTaiKhoanMoi.add(txtTongTien, gridBagConstraints);

        txtIdKhachHang.setEnabled(false);
        txtIdKhachHang.setMinimumSize(new java.awt.Dimension(172, 24));
        txtIdKhachHang.setPreferredSize(new java.awt.Dimension(172, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        pnlThemTaiKhoanMoi.add(txtIdKhachHang, gridBagConstraints);

        txtUuDai.setEnabled(false);
        txtUuDai.setMinimumSize(new java.awt.Dimension(172, 24));
        txtUuDai.setPreferredSize(new java.awt.Dimension(172, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        pnlThemTaiKhoanMoi.add(txtUuDai, gridBagConstraints);

        txtThanhTien.setEnabled(false);
        txtThanhTien.setMinimumSize(new java.awt.Dimension(172, 24));
        txtThanhTien.setPreferredSize(new java.awt.Dimension(172, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        pnlThemTaiKhoanMoi.add(txtThanhTien, gridBagConstraints);

        dtcNgayGio.setEnabled(false);
        dtcNgayGio.setMinimumSize(new java.awt.Dimension(172, 24));
        dtcNgayGio.setPreferredSize(new java.awt.Dimension(172, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        pnlThemTaiKhoanMoi.add(dtcNgayGio, gridBagConstraints);

        jLabel3.setText("Đơn gọi");
        jLabel3.setMaximumSize(new java.awt.Dimension(120, 24));
        jLabel3.setMinimumSize(new java.awt.Dimension(120, 24));
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemTaiKhoanMoi.add(jLabel3, gridBagConstraints);

        btnHuyHoaDon.setText("Huỷ hoá đơn");
        btnHuyHoaDon.setMaximumSize(new java.awt.Dimension(172, 24));
        btnHuyHoaDon.setMinimumSize(new java.awt.Dimension(172, 24));
        btnHuyHoaDon.setPreferredSize(new java.awt.Dimension(172, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 8, 20);
        pnlThemTaiKhoanMoi.add(btnHuyHoaDon, gridBagConstraints);

        lblQuyen1.setText("Tình trạng hoá đơn");
        lblQuyen1.setMaximumSize(new java.awt.Dimension(120, 24));
        lblQuyen1.setMinimumSize(new java.awt.Dimension(120, 24));
        lblQuyen1.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemTaiKhoanMoi.add(lblQuyen1, gridBagConstraints);

        txtTinhTrangHoaDon.setEnabled(false);
        txtTinhTrangHoaDon.setMinimumSize(new java.awt.Dimension(172, 24));
        txtTinhTrangHoaDon.setPreferredSize(new java.awt.Dimension(172, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        pnlThemTaiKhoanMoi.add(txtTinhTrangHoaDon, gridBagConstraints);

        lblID4.setText("Mã hoá đơn");
        lblID4.setMaximumSize(new java.awt.Dimension(120, 24));
        lblID4.setMinimumSize(new java.awt.Dimension(120, 24));
        lblID4.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
        pnlThemTaiKhoanMoi.add(lblID4, gridBagConstraints);

        txtMaHoaDon.setEnabled(false);
        txtMaHoaDon.setMaximumSize(new java.awt.Dimension(172, 24));
        txtMaHoaDon.setMinimumSize(new java.awt.Dimension(172, 24));
        txtMaHoaDon.setPreferredSize(new java.awt.Dimension(172, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        pnlThemTaiKhoanMoi.add(txtMaHoaDon, gridBagConstraints);

        jPanel9.add(pnlThemTaiKhoanMoi);

        add(jPanel9);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnHuyHoaDon;
    public javax.swing.JButton btnReset;
    public javax.swing.JButton btnTimKiem;
    public javax.swing.JComboBox<String> cmbTTMASearch;
    public com.toedter.calendar.JDateChooser dtcNgayBatDau;
    public com.toedter.calendar.JDateChooser dtcNgayCuoiCung;
    public com.toedter.calendar.JDateChooser dtcNgayGio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JLabel lblDoanhThu7NgayGanNhat;
    public javax.swing.JLabel lblDoanhThuTrongNgay;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblID1;
    private javax.swing.JLabel lblID2;
    private javax.swing.JLabel lblID3;
    private javax.swing.JLabel lblID4;
    private javax.swing.JLabel lblLocQuyen;
    private javax.swing.JLabel lblMatKhau;
    public javax.swing.JLabel lblMaxPrice;
    public javax.swing.JLabel lblMinPrice;
    private javax.swing.JLabel lblNhapID;
    private javax.swing.JLabel lblQuyen;
    private javax.swing.JLabel lblQuyen1;
    private javax.swing.JPanel pnlBangDanhSachTaiKhoan;
    private javax.swing.JPanel pnlBoLocTimKiem;
    private javax.swing.JPanel pnlThemTaiKhoanMoi;
    public javax.swing.JSlider sldMaxPrice;
    public javax.swing.JSlider sldMinPrice;
    public javax.swing.JTable tblDanhSachHoaDon;
    public javax.swing.JTable tblDonGoi;
    public javax.swing.JTextField txtIdKhachHang;
    public javax.swing.JTextField txtIdNhanVien;
    public javax.swing.JTextField txtMaHoaDon;
    public javax.swing.JTextField txtSearchID;
    public javax.swing.JTextField txtThanhTien;
    public javax.swing.JTextField txtTinhTrangHoaDon;
    public javax.swing.JTextField txtTongTien;
    public javax.swing.JTextField txtUuDai;
    // End of variables declaration//GEN-END:variables
}
