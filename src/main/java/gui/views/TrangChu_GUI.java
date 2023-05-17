/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.views;

import gui.controllers.QuanLyKhachHangController;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

/**
 *
 * @author tanph
 */
public class TrangChu_GUI extends javax.swing.JFrame {
    QuanLyKhachHangController quanLyLoaiBanVaBanController;
    private String maNhanVien;
    boolean over;
    
    public TrangChu_GUI() {
        initComponents();
        prepareIcon();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    class jPanelGradient extends JPanel {
        @Override
        protected void paintComponent(Graphics grphcs) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint g = new GradientPaint(0,0,Color.decode("#26D0CE"),0, getHeight(),Color.decode("#1A2980"));
            g2.setPaint(g);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        }
    }
     private void resetColorButton(){
        btnQuanLyPhucVu.setBackground(new java.awt.Color(0,0,0,0));
        btnQuanLyBan.setBackground(new java.awt.Color(0,0,0,0));
        btnQuanLyMonAn.setBackground(new java.awt.Color(0,0,0,0));
        btnQuanLyHoaDon.setBackground(new java.awt.Color(0,0,0,0));
        btnQuanLyNhanVien.setBackground(new java.awt.Color(0,0,0,0));
        btnQuanLyKhachHang.setBackground(new java.awt.Color(0,0,0,0));
        btnBaoCaoThongKe.setBackground(new java.awt.Color(0,0,0,0));
        btnDangXuat.setBackground(new java.awt.Color(0,0,0,0));
    }
    
    
    private void prepareIcon() {
        FontIcon iconAvatarNhanVien = FontIcon.of(MaterialDesign.MDI_ACCOUNT_CIRCLE,32,Color.WHITE);
        FontIcon iconQuanLyPhucVu = FontIcon.of(MaterialDesign.MDI_FOOD_FORK_DRINK,40,Color.WHITE);
        FontIcon iconQuanLyBan = FontIcon.of(MaterialDesign.MDI_TABLE,40,Color.WHITE);
        FontIcon iconQuanLyMonAn = FontIcon.of(MaterialDesign.MDI_FOOD,40,Color.WHITE);
        FontIcon iconQuanLyHoaDon = FontIcon.of(MaterialDesign.MDI_LIBRARY_BOOKS,40,Color.WHITE);
        FontIcon iconQuanLyNhanVien = FontIcon.of(MaterialDesign.MDI_ACCOUNT,40,Color.WHITE);
        FontIcon iconQuanLyKhachHang = FontIcon.of(MaterialDesign.MDI_ACCOUNT_MULTIPLE,40,Color.WHITE);
        FontIcon iconBaoCaoThongKe = FontIcon.of(MaterialDesign.MDI_CHART_LINE,40,Color.WHITE);
        FontIcon iconDangXuat = FontIcon.of(MaterialDesign.MDI_LOGOUT,40,Color.WHITE);
        
        lblTenNhanVien.setIcon(iconAvatarNhanVien);
        btnQuanLyPhucVu.setIcon(iconQuanLyPhucVu);
        btnQuanLyBan.setIcon(iconQuanLyBan);
        btnQuanLyMonAn.setIcon(iconQuanLyMonAn);
        btnQuanLyHoaDon.setIcon(iconQuanLyHoaDon);
        btnQuanLyNhanVien.setIcon(iconQuanLyNhanVien);
        btnQuanLyKhachHang.setIcon(iconQuanLyKhachHang);
        btnBaoCaoThongKe.setIcon(iconBaoCaoThongKe);
        btnDangXuat.setIcon(iconDangXuat);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        pnlForm = new javax.swing.JPanel();
        pnlMenu = new jPanelGradient();
        lblLogo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTenNhanVien = new javax.swing.JLabel();
        btnQuanLyPhucVu = new javax.swing.JButton();
        btnQuanLyBan = new javax.swing.JButton();
        btnQuanLyMonAn = new javax.swing.JButton();
        btnQuanLyHoaDon = new javax.swing.JButton();
        btnQuanLyNhanVien = new javax.swing.JButton();
        btnQuanLyKhachHang = new javax.swing.JButton();
        btnBaoCaoThongKe = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nhà hàng\n");
        setMinimumSize(new java.awt.Dimension(1600, 800));

        pnlForm.setLayout(new java.awt.BorderLayout());

        pnlMenu.setPreferredSize(new java.awt.Dimension(320, 740));

        lblLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblLogo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setText("Borcelle Restaurant");
        lblLogo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setName(""); // NOI18N

        lblTenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblTenNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenNhanVien.setText("Phan Hoàng Nhật Tân");
        lblTenNhanVien.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblTenNhanVien.setIconTextGap(8);

        btnQuanLyPhucVu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnQuanLyPhucVu.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLyPhucVu.setText("Quản Lý Phục Vụ");
        btnQuanLyPhucVu.setToolTipText("");
        btnQuanLyPhucVu.setBorderPainted(false);
        btnQuanLyPhucVu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuanLyPhucVu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLyPhucVu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQuanLyPhucVu.setIconTextGap(12);
        //jButton1.setBorder(null);
        //jButton1.setBorder(new java.awt.Color(0,0,0,1));
        btnQuanLyPhucVu.setBackground(new java.awt.Color(0,0,0,1));
        //jButton1.setContentAreaFilled(false);

        btnQuanLyBan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnQuanLyBan.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLyBan.setText("Quản Lý Bàn");
        btnQuanLyBan.setToolTipText("");
        btnQuanLyBan.setBorderPainted(false);
        btnQuanLyBan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuanLyBan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLyBan.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQuanLyBan.setIconTextGap(12);
        btnQuanLyBan.setBackground(new java.awt.Color(0,0,0,1));

        btnQuanLyMonAn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnQuanLyMonAn.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLyMonAn.setText("Quản Lý Món Ăn");
        btnQuanLyMonAn.setToolTipText("");
        btnQuanLyMonAn.setBorderPainted(false);
        btnQuanLyMonAn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuanLyMonAn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLyMonAn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQuanLyMonAn.setIconTextGap(12);
        btnQuanLyMonAn.setBackground(new java.awt.Color(0,0,0,1));

        btnQuanLyHoaDon.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnQuanLyHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLyHoaDon.setText("Quản Lý Hoá Đơn");
        btnQuanLyHoaDon.setToolTipText("");
        btnQuanLyHoaDon.setBorderPainted(false);
        btnQuanLyHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuanLyHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLyHoaDon.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQuanLyHoaDon.setIconTextGap(12);
        btnQuanLyHoaDon.setBackground(new java.awt.Color(0,0,0,1));

        btnQuanLyNhanVien.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnQuanLyNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLyNhanVien.setText("Quản Lý Nhân Viên");
        btnQuanLyNhanVien.setToolTipText("");
        btnQuanLyNhanVien.setBorderPainted(false);
        btnQuanLyNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuanLyNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLyNhanVien.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQuanLyNhanVien.setIconTextGap(12);
        btnQuanLyNhanVien.setBackground(new java.awt.Color(0,0,0,1));

        btnQuanLyKhachHang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnQuanLyKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLyKhachHang.setText("Quản Lý Khách Hàng");
        btnQuanLyKhachHang.setToolTipText("");
        btnQuanLyKhachHang.setBorderPainted(false);
        btnQuanLyKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuanLyKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLyKhachHang.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQuanLyKhachHang.setIconTextGap(12);
        btnQuanLyKhachHang.setBackground(new java.awt.Color(0,0,0,1));

        btnBaoCaoThongKe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBaoCaoThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnBaoCaoThongKe.setText("Báo Cáo & Thống Kê");
        btnBaoCaoThongKe.setToolTipText("");
        btnBaoCaoThongKe.setBorderPainted(false);
        btnBaoCaoThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBaoCaoThongKe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBaoCaoThongKe.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBaoCaoThongKe.setIconTextGap(12);
        btnBaoCaoThongKe.setBackground(new java.awt.Color(0,0,0,1));

        btnDangXuat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnDangXuat.setText("Đăng Xuất");
        btnDangXuat.setToolTipText("");
        btnDangXuat.setBorderPainted(false);
        btnDangXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDangXuat.setIconTextGap(12);
        btnDangXuat.setBackground(new java.awt.Color(0,0,0,1));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuanLyPhucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(btnQuanLyBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyMonAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBaoCaoThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2))
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuanLyPhucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyBan, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBaoCaoThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(pnlForm, javax.swing.GroupLayout.DEFAULT_SIZE, 1194, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnlForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    public javax.swing.JButton btnBaoCaoThongKe;
    public javax.swing.JButton btnDangXuat;
    public javax.swing.JButton btnQuanLyBan;
    public javax.swing.JButton btnQuanLyHoaDon;
    public javax.swing.JButton btnQuanLyKhachHang;
    public javax.swing.JButton btnQuanLyMonAn;
    public javax.swing.JButton btnQuanLyNhanVien;
    public javax.swing.JButton btnQuanLyPhucVu;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblLogo;
    public javax.swing.JLabel lblTenNhanVien;
    public javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration                   
}
