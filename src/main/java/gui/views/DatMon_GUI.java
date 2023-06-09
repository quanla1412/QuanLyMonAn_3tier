/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.views;

import com.mycompany.quanlynhahang.Price;
import gui.models.MonAn.MonAnFullModel;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.materialdesign2.MaterialDesignI;
import org.kordamp.ikonli.swing.FontIcon;

/**
 *
 * @author dinhn
 */
public class DatMon_GUI extends javax.swing.JFrame {
    /**
     * Creates new form ThemMonAn_GUI
     */
    public DatMon_GUI() {
        initComponents();
        defaultInit();
    }
    
    private void defaultInit(){
        FontIcon iconNoImage = FontIcon.of(MaterialDesignI.IMAGE_OFF,320,Color.GRAY);
        lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhAnh.setIcon(iconNoImage);        
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

        lblHinhAnh = new javax.swing.JLabel();
        lblTenMonAn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblGia = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblGiaKhuyenMai = new javax.swing.JLabel();
        spnSoLuong = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        btnDatMon = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaGhiChu = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        lblTinhTrangMonAn = new javax.swing.JLabel();
        lblNoiDungMonAn = new javax.swing.JLabel();
        lblLoaiMonAn = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSoLuongHienTai = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm món ăn");
        setMaximumSize(new java.awt.Dimension(840, 500));
        setMinimumSize(new java.awt.Dimension(840, 500));
        setPreferredSize(new java.awt.Dimension(840, 500));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblHinhAnh.setBackground(new java.awt.Color(255, 102, 102));
        lblHinhAnh.setForeground(new java.awt.Color(153, 255, 255));
        lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhAnh.setMaximumSize(new java.awt.Dimension(400, 400));
        lblHinhAnh.setMinimumSize(new java.awt.Dimension(400, 400));
        lblHinhAnh.setPreferredSize(new java.awt.Dimension(400, 400));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(lblHinhAnh, gridBagConstraints);

        lblTenMonAn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenMonAn.setText("Tàu Hủ Nóng");
        lblTenMonAn.setMaximumSize(new java.awt.Dimension(288, 40));
        lblTenMonAn.setMinimumSize(new java.awt.Dimension(288, 40));
        lblTenMonAn.setPreferredSize(new java.awt.Dimension(288, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 8, 0, 20);
        getContentPane().add(lblTenMonAn, gridBagConstraints);

        jLabel3.setText("Giá");
        jLabel3.setMaximumSize(new java.awt.Dimension(120, 24));
        jLabel3.setMinimumSize(new java.awt.Dimension(120, 24));
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 4, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        lblGia.setText("90000VNĐ");
        lblGia.setMaximumSize(new java.awt.Dimension(120, 24));
        lblGia.setMinimumSize(new java.awt.Dimension(120, 24));
        lblGia.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 4, 20);
        getContentPane().add(lblGia, gridBagConstraints);

        jLabel5.setText("Giá khuyến mãi");
        jLabel5.setMaximumSize(new java.awt.Dimension(120, 24));
        jLabel5.setMinimumSize(new java.awt.Dimension(120, 24));
        jLabel5.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 4, 0);
        getContentPane().add(jLabel5, gridBagConstraints);

        lblGiaKhuyenMai.setText("75000VNĐ");
        lblGiaKhuyenMai.setMaximumSize(new java.awt.Dimension(120, 24));
        lblGiaKhuyenMai.setMinimumSize(new java.awt.Dimension(120, 24));
        lblGiaKhuyenMai.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 4, 20);
        getContentPane().add(lblGiaKhuyenMai, gridBagConstraints);

        spnSoLuong.setMaximumSize(new java.awt.Dimension(120, 24));
        spnSoLuong.setMinimumSize(new java.awt.Dimension(120, 24));
        spnSoLuong.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 4, 20);
        getContentPane().add(spnSoLuong, gridBagConstraints);

        jLabel7.setText("Số lượng");
        jLabel7.setMaximumSize(new java.awt.Dimension(120, 24));
        jLabel7.setMinimumSize(new java.awt.Dimension(120, 24));
        jLabel7.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 4, 0);
        getContentPane().add(jLabel7, gridBagConstraints);

        btnDatMon.setText("Đặt ngay");
        btnDatMon.setMaximumSize(new java.awt.Dimension(288, 40));
        btnDatMon.setMinimumSize(new java.awt.Dimension(288, 40));
        btnDatMon.setPreferredSize(new java.awt.Dimension(288, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 20, 20);
        getContentPane().add(btnDatMon, gridBagConstraints);

        jLabel8.setText("Ghi chú");
        jLabel8.setMaximumSize(new java.awt.Dimension(120, 24));
        jLabel8.setMinimumSize(new java.awt.Dimension(120, 24));
        jLabel8.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 4, 0);
        getContentPane().add(jLabel8, gridBagConstraints);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(234, 86));

        txaGhiChu.setColumns(20);
        txaGhiChu.setLineWrap(true);
        txaGhiChu.setRows(5);
        txaGhiChu.setMaximumSize(new java.awt.Dimension(160, 80));
        txaGhiChu.setMinimumSize(new java.awt.Dimension(160, 80));
        txaGhiChu.setPreferredSize(new java.awt.Dimension(160, 80));
        jScrollPane1.setViewportView(txaGhiChu);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 4, 20);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jLabel1.setText("Tình trạng món");
        jLabel1.setMaximumSize(new java.awt.Dimension(120, 24));
        jLabel1.setMinimumSize(new java.awt.Dimension(120, 24));
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 4, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        lblTinhTrangMonAn.setText("Sẵn sàng");
        lblTinhTrangMonAn.setMaximumSize(new java.awt.Dimension(120, 24));
        lblTinhTrangMonAn.setMinimumSize(new java.awt.Dimension(120, 24));
        lblTinhTrangMonAn.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 4, 20);
        getContentPane().add(lblTinhTrangMonAn, gridBagConstraints);

        lblNoiDungMonAn.setText("Nội dung món ăn");
        lblNoiDungMonAn.setMaximumSize(new java.awt.Dimension(288, 48));
        lblNoiDungMonAn.setMinimumSize(new java.awt.Dimension(288, 48));
        lblNoiDungMonAn.setPreferredSize(new java.awt.Dimension(288, 48));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 20);
        getContentPane().add(lblNoiDungMonAn, gridBagConstraints);

        lblLoaiMonAn.setText("Loại");
        lblLoaiMonAn.setMaximumSize(new java.awt.Dimension(120, 24));
        lblLoaiMonAn.setMinimumSize(new java.awt.Dimension(120, 24));
        lblLoaiMonAn.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 4, 20);
        getContentPane().add(lblLoaiMonAn, gridBagConstraints);

        jLabel12.setText("Loại món ăn");
        jLabel12.setMaximumSize(new java.awt.Dimension(120, 24));
        jLabel12.setMinimumSize(new java.awt.Dimension(120, 24));
        jLabel12.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 4, 0);
        getContentPane().add(jLabel12, gridBagConstraints);

        jLabel2.setText("Số lượng món hiện tại");
        jLabel2.setMaximumSize(new java.awt.Dimension(120, 24));
        jLabel2.setMinimumSize(new java.awt.Dimension(120, 24));
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 4, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        lblSoLuongHienTai.setText("0");
        lblSoLuongHienTai.setMaximumSize(new java.awt.Dimension(120, 24));
        lblSoLuongHienTai.setMinimumSize(new java.awt.Dimension(120, 24));
        lblSoLuongHienTai.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 4, 20);
        getContentPane().add(lblSoLuongHienTai, gridBagConstraints);

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDatMon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblGia;
    public javax.swing.JLabel lblGiaKhuyenMai;
    public javax.swing.JLabel lblHinhAnh;
    public javax.swing.JLabel lblLoaiMonAn;
    public javax.swing.JLabel lblNoiDungMonAn;
    public javax.swing.JLabel lblSoLuongHienTai;
    public javax.swing.JLabel lblTenMonAn;
    public javax.swing.JLabel lblTinhTrangMonAn;
    public javax.swing.JSpinner spnSoLuong;
    public javax.swing.JTextArea txaGhiChu;
    // End of variables declaration//GEN-END:variables
}
