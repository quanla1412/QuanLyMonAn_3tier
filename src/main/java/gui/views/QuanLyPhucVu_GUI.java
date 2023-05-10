

package gui.views;

import com.mycompany.quanlynhahang.Price;
import gui.constraints.TinhTrangBanConstraints;
import gui.models.Ban.BanFullModel;
import gui.models.BanModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class QuanLyPhucVu_GUI extends javax.swing.JPanel {  
    
    private BanFullModel banSelected = null;
    
    public QuanLyPhucVu_GUI() {
        initComponents();
    }
    
    public void loadComboBoxBanSanSang(ArrayList<BanModel> listBanModel){
        cmbBanSanSang.removeAllItems();
        for(BanModel banSanSang : listBanModel){
            cmbBanSanSang.addItem("Bàn " + banSanSang.getId());
        }        
        cmbBanSanSang.setSelectedIndex(-1);
    }

    private void loadDonGoi(){
        listDonGoi = donGoi_BUS.getAllDonGoiByIdBan(banDangChon.getId());
        
        long total = 0;
        
        String[] col = {"ID Món ăn","Tên món ăn", "Đơn giá", "Số lượng", "Thành tiền"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        tblDonGoi.setModel(model);
        for(DonGoi_DTO donGoi : listDonGoi){
            long gia = donGoi.getMonAn().getGiaKhuyenMai() > 0 ? donGoi.getMonAn().getGiaKhuyenMai() : donGoi.getMonAn().getGia();
            long thanhTien = gia * donGoi.getSoLuong();
            Object[] data = {
                donGoi.getMonAn().getId(),
                donGoi.getMonAn().getTen(), 
                Price.formatPrice(gia),
                donGoi.getSoLuong(),
                Price.formatPrice(thanhTien)
            };
            total += thanhTien;
            
            model.addRow(data);
        }  
        
        lblTongGia.setText(Price.formatPrice(total));
    }
    
    private void chuyenTinhTrangBan(int tinhTrangMoi){
        ban_BUS.changeTinhTrangBan(banDangChon.getId(), tinhTrangMoi);
        banDangChon = ban_BUS.getBanFullById(banDangChon.getId());
        
        loadChucNang();
        loadDonGoi();
        loadComboBoxBanSanSang();
        loadDanhSachBan();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pnlDanhSachBan = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblIdBan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTinhTrangBan = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblLoaiBan = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnThemMonMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSuaDonGoi = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cmbBanSanSang = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnChuyenBan = new javax.swing.JButton();
        btnSanSang = new javax.swing.JButton();
        btnPhucVu = new javax.swing.JButton();
        btnNgungPhucVu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDonGoi = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnThanhToan = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblTongGia = new javax.swing.JLabel();
        btnResetDonGoi = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setMaximumSize(new java.awt.Dimension(520, 2147483647));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách bàn"));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setToolTipText("");
        jScrollPane3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setMaximumSize(new java.awt.Dimension(520, 32767));
        jScrollPane3.setMinimumSize(new java.awt.Dimension(520, 600));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(520, 600));
        jScrollPane3.setWheelScrollingEnabled(false);

        pnlDanhSachBan.setMaximumSize(new java.awt.Dimension(500, 6000));
        pnlDanhSachBan.setMinimumSize(new java.awt.Dimension(260, 600));
        pnlDanhSachBan.setName(""); // NOI18N
        pnlDanhSachBan.setPreferredSize(new java.awt.Dimension(500, 600));
        pnlDanhSachBan.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 4));

        jButton2.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton2.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton2.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton2);

        jButton3.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton3.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton3.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton3);

        jButton5.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton5.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton5.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton5);

        jButton4.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton4.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton4.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton4);

        jButton6.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton6.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton6.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton6);

        jButton7.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton7.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton7.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton7);

        jButton8.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton8.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton8.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton8);

        jButton9.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton9.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton9.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton9);

        jButton10.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton10.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton10.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton10);

        jButton11.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton11.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton11.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton11);

        jButton12.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton12.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton12.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton12);

        jButton13.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton13.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton13.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton13);

        jButton14.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton14.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton14.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton14);

        jButton15.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton15.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton15.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton15);

        jButton16.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton16.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton16.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton16);

        jButton17.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton17.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton17.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton17);

        jScrollPane3.setViewportView(pnlDanhSachBan);

        jPanel2.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        add(jPanel2);

        jPanel3.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel3.setMinimumSize(new java.awt.Dimension(480, 120));
        jPanel3.setPreferredSize(new java.awt.Dimension(480, 120));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin bàn"));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        jPanel4.setMinimumSize(new java.awt.Dimension(480, 60));
        jPanel4.setPreferredSize(new java.awt.Dimension(480, 60));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Bàn số:");
        jLabel1.setMaximumSize(new java.awt.Dimension(52, 24));
        jLabel1.setMinimumSize(new java.awt.Dimension(52, 24));
        jLabel1.setPreferredSize(new java.awt.Dimension(52, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 8, 2, 0);
        jPanel4.add(jLabel1, gridBagConstraints);

        lblIdBan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIdBan.setMaximumSize(new java.awt.Dimension(24, 24));
        lblIdBan.setMinimumSize(new java.awt.Dimension(24, 24));
        lblIdBan.setPreferredSize(new java.awt.Dimension(24, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 8);
        jPanel4.add(lblIdBan, gridBagConstraints);

        jLabel3.setText("Loại bàn:");
        jLabel3.setMaximumSize(new java.awt.Dimension(60, 24));
        jLabel3.setMinimumSize(new java.awt.Dimension(60, 24));
        jLabel3.setPreferredSize(new java.awt.Dimension(60, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 8, 2, 0);
        jPanel4.add(jLabel3, gridBagConstraints);

        lblTinhTrangBan.setMaximumSize(new java.awt.Dimension(88, 24));
        lblTinhTrangBan.setMinimumSize(new java.awt.Dimension(88, 24));
        lblTinhTrangBan.setPreferredSize(new java.awt.Dimension(88, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 8);
        jPanel4.add(lblTinhTrangBan, gridBagConstraints);

        jLabel5.setText("Tình trạng bàn:");
        jLabel5.setMaximumSize(new java.awt.Dimension(100, 24));
        jLabel5.setMinimumSize(new java.awt.Dimension(100, 24));
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 8, 2, 0);
        jPanel4.add(jLabel5, gridBagConstraints);

        lblLoaiBan.setMaximumSize(new java.awt.Dimension(60, 24));
        lblLoaiBan.setMinimumSize(new java.awt.Dimension(60, 24));
        lblLoaiBan.setPreferredSize(new java.awt.Dimension(60, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 8);
        jPanel4.add(lblLoaiBan, gridBagConstraints);

        jPanel3.add(jPanel4);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng bàn"));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 140));
        jPanel1.setMinimumSize(new java.awt.Dimension(480, 140));
        jPanel1.setPreferredSize(new java.awt.Dimension(480, 140));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel7.setText("Chức năng");
        jLabel7.setMaximumSize(new java.awt.Dimension(100, 24));
        jLabel7.setMinimumSize(new java.awt.Dimension(100, 24));
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 4, 4);
        jPanel1.add(jLabel7, gridBagConstraints);

        btnThemMonMoi.setText("Thêm món mới");
        btnThemMonMoi.setEnabled(false);
        btnThemMonMoi.setMaximumSize(new java.awt.Dimension(132, 28));
        btnThemMonMoi.setMinimumSize(new java.awt.Dimension(132, 28));
        btnThemMonMoi.setName(""); // NOI18N
        btnThemMonMoi.setPreferredSize(new java.awt.Dimension(132, 28));
        btnThemMonMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMonMoiMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(btnThemMonMoi, gridBagConstraints);

        btnXoa.setText("Xóa món ăn");
        btnXoa.setEnabled(false);
        btnXoa.setMaximumSize(new java.awt.Dimension(132, 28));
        btnXoa.setMinimumSize(new java.awt.Dimension(132, 28));
        btnXoa.setPreferredSize(new java.awt.Dimension(132, 28));
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 8);
        jPanel1.add(btnXoa, gridBagConstraints);

        btnSuaDonGoi.setText("Sửa đơn gọi");
        btnSuaDonGoi.setEnabled(false);
        btnSuaDonGoi.setMaximumSize(new java.awt.Dimension(132, 28));
        btnSuaDonGoi.setMinimumSize(new java.awt.Dimension(132, 28));
        btnSuaDonGoi.setPreferredSize(new java.awt.Dimension(132, 28));
        btnSuaDonGoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaDonGoiMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(btnSuaDonGoi, gridBagConstraints);

        jLabel8.setText("Chuyển bàn");
        jLabel8.setMaximumSize(new java.awt.Dimension(100, 24));
        jLabel8.setMinimumSize(new java.awt.Dimension(100, 24));
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 4);
        jPanel1.add(jLabel8, gridBagConstraints);

        cmbBanSanSang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbBanSanSang.setEnabled(false);
        cmbBanSanSang.setMaximumSize(new java.awt.Dimension(132, 28));
        cmbBanSanSang.setMinimumSize(new java.awt.Dimension(132, 28));
        cmbBanSanSang.setPreferredSize(new java.awt.Dimension(132, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        jPanel1.add(cmbBanSanSang, gridBagConstraints);

        jLabel9.setText("Tình trạng bàn");
        jLabel9.setMaximumSize(new java.awt.Dimension(100, 24));
        jLabel9.setMinimumSize(new java.awt.Dimension(100, 24));
        jLabel9.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 4, 4);
        jPanel1.add(jLabel9, gridBagConstraints);

        btnChuyenBan.setText("Đổi");
        btnChuyenBan.setEnabled(false);
        btnChuyenBan.setMaximumSize(new java.awt.Dimension(132, 28));
        btnChuyenBan.setMinimumSize(new java.awt.Dimension(132, 28));
        btnChuyenBan.setPreferredSize(new java.awt.Dimension(132, 28));
        btnChuyenBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChuyenBanMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        jPanel1.add(btnChuyenBan, gridBagConstraints);

        btnSanSang.setText("Sẵn sàng");
        btnSanSang.setEnabled(false);
        btnSanSang.setMaximumSize(new java.awt.Dimension(132, 28));
        btnSanSang.setMinimumSize(new java.awt.Dimension(132, 28));
        btnSanSang.setPreferredSize(new java.awt.Dimension(132, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(btnSanSang, gridBagConstraints);

        btnPhucVu.setText("Phục vụ");
        btnPhucVu.setEnabled(false);
        btnPhucVu.setMaximumSize(new java.awt.Dimension(132, 28));
        btnPhucVu.setMinimumSize(new java.awt.Dimension(132, 28));
        btnPhucVu.setPreferredSize(new java.awt.Dimension(132, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(btnPhucVu, gridBagConstraints);

        btnNgungPhucVu.setText("Ngừng phục vụ");
        btnNgungPhucVu.setEnabled(false);
        btnNgungPhucVu.setMaximumSize(new java.awt.Dimension(132, 28));
        btnNgungPhucVu.setMinimumSize(new java.awt.Dimension(132, 28));
        btnNgungPhucVu.setName(""); // NOI18N
        btnNgungPhucVu.setPreferredSize(new java.awt.Dimension(132, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 8);
        jPanel1.add(btnNgungPhucVu, gridBagConstraints);

        jPanel3.add(jPanel1);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Đơn gọi"));

        tblDonGoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Món ăn", "Tên món ăn", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(tblDonGoi);

        jPanel3.add(jScrollPane1);

        jPanel5.setMaximumSize(new java.awt.Dimension(2147483647, 80));
        jPanel5.setMinimumSize(new java.awt.Dimension(480, 80));
        jPanel5.setPreferredSize(new java.awt.Dimension(480, 80));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setEnabled(false);
        btnThanhToan.setMaximumSize(new java.awt.Dimension(120, 28));
        btnThanhToan.setMinimumSize(new java.awt.Dimension(120, 28));
        btnThanhToan.setPreferredSize(new java.awt.Dimension(120, 28));
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel5.add(btnThanhToan, gridBagConstraints);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Tổng tiền");
        jLabel10.setMaximumSize(new java.awt.Dimension(60, 24));
        jLabel10.setMinimumSize(new java.awt.Dimension(60, 24));
        jLabel10.setPreferredSize(new java.awt.Dimension(60, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel5.add(jLabel10, gridBagConstraints);

        lblTongGia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongGia.setText("0 VNĐ");
        lblTongGia.setMaximumSize(new java.awt.Dimension(150, 40));
        lblTongGia.setMinimumSize(new java.awt.Dimension(150, 40));
        lblTongGia.setPreferredSize(new java.awt.Dimension(150, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel5.add(lblTongGia, gridBagConstraints);

        btnResetDonGoi.setText("Reset");
        btnResetDonGoi.setEnabled(false);
        btnResetDonGoi.setMaximumSize(new java.awt.Dimension(120, 28));
        btnResetDonGoi.setMinimumSize(new java.awt.Dimension(120, 28));
        btnResetDonGoi.setPreferredSize(new java.awt.Dimension(120, 28));
        btnResetDonGoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetDonGoiMouseClicked(evt);
            }
        });
        btnResetDonGoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetDonGoiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel5.add(btnResetDonGoi, gridBagConstraints);

        jPanel3.add(jPanel5);

        add(jPanel3);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));
        add(jPanel6);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMonMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMonMoiMouseClicked
        // TODO add your handling code here:
        if(btnThemMonMoi.isEnabled()){
            if(menu_GUI == null || !menu_GUI.isDisplayable()){
                menu_GUI = new Menu_GUI(banDangChon.getId());
                menu_GUI.setVisible(true);
            } else {
                menu_GUI.setState(JFrame.NORMAL);
                menu_GUI.toFront();
            }
        }
    }//GEN-LAST:event_btnThemMonMoiMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        // TODO add your handling code here:
        if(btnXoa.isEnabled()){
            int count = tblDonGoi.getSelectedRowCount();
            if(count < 1)
            JOptionPane.showMessageDialog(this, "Chưa chọn món ăn","Error", JOptionPane.ERROR_MESSAGE);
            else if(count > 1)
            JOptionPane.showMessageDialog(this, "Chỉ chọn 1 món ăn","Error", JOptionPane.ERROR_MESSAGE);

            int indexRow = tblDonGoi.getSelectedRow();
            TableModel model = tblDonGoi.getModel();

            int idMonAn = Integer.parseInt(model.getValueAt(indexRow, 0).toString());
            boolean result = donGoi_BUS.deleteDonGoi(banDangChon.getId(), idMonAn);
            if(result){
                JOptionPane.showMessageDialog(this, "Xóa món ăn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loadDonGoi();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa món ăn thất bại","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnSuaDonGoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaDonGoiMouseClicked
        // TODO add your handling code here:
        if(btnSuaDonGoi.isEnabled()){
            int count = tblDonGoi.getSelectedRowCount();
            if(count < 1){
                JOptionPane.showMessageDialog(this, "Chưa chọn món ăn","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int indexRow = tblDonGoi.getSelectedRow();
            TableModel model = tblDonGoi.getModel();

            int idMonAn = Integer.parseInt(model.getValueAt(indexRow, 0).toString());
            if(datMon_GUI == null || !datMon_GUI.isDisplayable()){
                datMon_GUI = new DatMon_GUI(banDangChon.getId(), idMonAn);
                datMon_GUI.setVisible(true);
            } else {
                datMon_GUI.setState(JFrame.NORMAL);
                datMon_GUI.toFront();
            }
        }
    }//GEN-LAST:event_btnSuaDonGoiMouseClicked

    private void btnChuyenBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChuyenBanMouseClicked
        // TODO add your handling code here:
        if(btnChuyenBan.isEnabled()){
            int indexBan = cmbBanSanSang.getSelectedIndex();
            if(indexBan < 0){
                JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn muốn chuyển","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean result = donGoi_BUS.chuyenBan(banDangChon.getId(), listBanSanSang.get(indexBan).getId());
            if(result){
                JOptionPane.showMessageDialog(this, "Chuyển bàn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                chuyenTinhTrangBan(TinhTrangBanConstraints.DANG_CHUAN_BI);
            } else {
                JOptionPane.showMessageDialog(this, "Chuyển bàn thất bại","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnChuyenBanMouseClicked

    private void btnResetDonGoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetDonGoiMouseClicked
        // TODO add your handling code here:
        if(btnResetDonGoi.isEnabled()){
            loadDonGoi();
            loadDanhSachBan();
        }
        
    }//GEN-LAST:event_btnResetDonGoiMouseClicked

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        // TODO add your handling code here:
        if(btnThanhToan.isEnabled()){
            if(donGoi_BUS.getAllDonGoiByIdBan(banDangChon.getId()).size() <= 0){
                JOptionPane.showMessageDialog(this, "Đơn gọi không có món ăn","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(thanhToan_GUI == null || !thanhToan_GUI.isDisplayable()){
                thanhToan_GUI = new ThanhToan_GUI(banDangChon.getId(), maNhanVien);
                thanhToan_GUI.setVisible(true);
            } else {
                thanhToan_GUI.setState(JFrame.NORMAL);
                thanhToan_GUI.toFront();
            }
        }
    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnResetDonGoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetDonGoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetDonGoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnChuyenBan;
    public javax.swing.JButton btnNgungPhucVu;
    public javax.swing.JButton btnPhucVu;
    public javax.swing.JButton btnResetDonGoi;
    public javax.swing.JButton btnSanSang;
    public javax.swing.JButton btnSuaDonGoi;
    public javax.swing.JButton btnThanhToan;
    public javax.swing.JButton btnThemMonMoi;
    public javax.swing.JButton btnXoa;
    public javax.swing.JComboBox<String> cmbBanSanSang;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JLabel lblIdBan;
    public javax.swing.JLabel lblLoaiBan;
    public javax.swing.JLabel lblTinhTrangBan;
    private javax.swing.JLabel lblTongGia;
    public javax.swing.JPanel pnlDanhSachBan;
    private javax.swing.JTable tblDonGoi;
    // End of variables declaration//GEN-END:variables

}
