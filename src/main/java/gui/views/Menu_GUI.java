/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.views;

import com.mycompany.quanlynhahang.Price;
import gui.models.MonAn.LoaiMonAnFullModel;
import gui.models.MonAn.MonAnModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import org.kordamp.ikonli.materialdesign2.MaterialDesignI;
import org.kordamp.ikonli.swing.FontIcon;

/**
 *
 * @author tanph
 */
public class Menu_GUI extends javax.swing.JFrame {
    public ArrayList<JButton> listBtnDatMon;
    /**
     * Creates new form Menu_GUI
     */
    public Menu_GUI() {
        listBtnDatMon = new ArrayList<>();
        
        initComponents();
    }
    
    class jPanelWhite extends JPanel {

        @Override
        protected void paintComponent(Graphics grphcs) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        }
    }
    
    public void loadMonAn(ArrayList<LoaiMonAnFullModel> listLoaiMonAnFullModel){
        tabMenu.removeAll();
        for(LoaiMonAnFullModel loaiMonAn : listLoaiMonAnFullModel){
            JScrollPane scrMenu = new JScrollPane();
            JPanel pnlCategory = new JPanel(new FlowLayout(FlowLayout.CENTER,12,12));
            
            scrMenu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            
            pnlCategory.setPreferredSize(new Dimension(820, 600));
            pnlCategory.setMaximumSize(new Dimension(820, 600));
            pnlCategory.setMinimumSize(new Dimension(820, 600));
            
            ArrayList<MonAnModel> listMonAn = loaiMonAn.getListMonAn();
            for(MonAnModel monAn : listMonAn){
                JPanel pnlItem = new JPanel(new GridBagLayout());
                
                GridBagConstraints c = new GridBagConstraints();
                
                pnlItem.setPreferredSize(new Dimension(240, 360));
                pnlItem.setMinimumSize(new Dimension(240, 360));
                pnlItem.setBackground(Color.WHITE);
//                pnlItem.setBorder(BorderFactory.createRaisedBevelBorder());

                JLabel lblHinhAnh = new JLabel();
                if (monAn.getHinhAnh() == null){
                    FontIcon iconNoImage = FontIcon.of(MaterialDesignI.IMAGE_OFF,160,Color.GRAY);
                    lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    lblHinhAnh.setIcon(iconNoImage);
                } else {
                    ImageIcon yourImage = new ImageIcon(monAn.getHinhAnh());
                    Image newImage = yourImage.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
                    lblHinhAnh.setIcon(new ImageIcon(newImage));
                }
                lblHinhAnh.setPreferredSize(new Dimension(200, 200));
                c.anchor = GridBagConstraints.CENTER;
                c.gridx = 0;
                c.gridy = 0;
                c.gridwidth = 2;
                c.insets = new Insets(8, 8, 8, 8);
                pnlItem.add(lblHinhAnh, c);         
                
                JLabel lblTenMonAn = new JLabel(monAn.getTen());
                lblTenMonAn.setFont(new java.awt.Font("Segoe UI", 1, 12));
                c.anchor = GridBagConstraints.CENTER;
                c.gridx = 0;
                c.gridy = 1;
                c.gridwidth = 2;
                c.insets = new Insets(6, 2, 6, 2);
                pnlItem.add(lblTenMonAn, c);              
                
                JLabel lblTitleGia = new JLabel("Giá");
                c.anchor = GridBagConstraints.WEST;
                c.gridx = 0;
                c.gridy = 2;
                c.insets = new Insets(10, 8, 4, 8);
                pnlItem.add(lblTitleGia, c);
                
                JLabel lblGia = new JLabel(Price.formatPrice(monAn.getGia()));
                c.anchor = GridBagConstraints.EAST;
                c.gridx = 1;
                c.gridy = 2;
                c.insets = new Insets(10, 8, 4, 8);
                pnlItem.add(lblGia, c);       
                
                JLabel lblTitleGiaKhuyenMai = new JLabel("Giá khuyến mãi");
                c.anchor = GridBagConstraints.WEST;
                c.gridx = 0;
                c.gridy = 3;
                c.insets = new Insets(4, 8, 10, 8);
                pnlItem.add(lblTitleGiaKhuyenMai, c);
                
                if(monAn.getGiaKhuyenMai() > 0){
                    JLabel lblGiaKhuyenMai = new JLabel(Price.formatPrice(monAn.getGiaKhuyenMai()));
                    c.anchor = GridBagConstraints.EAST;
                    c.gridx = 1;
                    c.gridy = 3;
                    c.insets = new Insets(4, 8, 10, 8);
                    pnlItem.add(lblGiaKhuyenMai, c);                    
                }
 
                JButton btnDatMon = new JButton("Đặt ngay");
                c.anchor = GridBagConstraints.CENTER;
                c.gridx = 0;
                c.gridy = 4;
                c.gridwidth = 2;
                c.fill = java.awt.GridBagConstraints.HORIZONTAL;
                c.insets = new Insets(4, 4, 4, 4);
                
                btnDatMon.setName(Integer.toString(monAn.getId()));
                
                pnlItem.add(btnDatMon, c);  
                listBtnDatMon.add(btnDatMon);
                
                pnlCategory.add(pnlItem);
            }
            scrMenu.setViewportView(pnlCategory);
            tabMenu.add(loaiMonAn.getTen(), scrMenu);
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

        tabMenu = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu");
        setMinimumSize(new java.awt.Dimension(1042, 440));

        tabMenu.setMinimumSize(new java.awt.Dimension(822, 420));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(822, 32767));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(822, 600));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(822, 900));

        jPanel1.setMaximumSize(new java.awt.Dimension(822, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(822, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(822, 600));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 12, 12));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setMinimumSize(new java.awt.Dimension(240, 360));
        jPanel3.setPreferredSize(new java.awt.Dimension(240, 360));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel2.setBackground(new java.awt.Color(204, 153, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setMaximumSize(new java.awt.Dimension(200, 200));
        jLabel2.setMinimumSize(new java.awt.Dimension(200, 200));
        jLabel2.setPreferredSize(new java.awt.Dimension(200, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel3.add(jLabel2, gridBagConstraints);

        jButton1.setText("Đặt ngay");
        jButton1.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton1.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel3.add(jButton1, gridBagConstraints);

        jLabel1.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel3.add(jLabel1, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel3.add(jLabel3, gridBagConstraints);

        jLabel4.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel3.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel3.add(jLabel5, gridBagConstraints);

        jLabel6.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel3.add(jLabel6, gridBagConstraints);

        jPanel1.add(jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setMinimumSize(new java.awt.Dimension(240, 360));
        jPanel4.setPreferredSize(new java.awt.Dimension(240, 360));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel7.setBackground(new java.awt.Color(204, 153, 255));
        jLabel7.setMaximumSize(new java.awt.Dimension(200, 200));
        jLabel7.setMinimumSize(new java.awt.Dimension(200, 200));
        jLabel7.setPreferredSize(new java.awt.Dimension(200, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel4.add(jLabel7, gridBagConstraints);

        jButton2.setText("Đặt ngay");
        jButton2.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton2.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton2.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel4.add(jButton2, gridBagConstraints);

        jLabel8.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel4.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel4.add(jLabel9, gridBagConstraints);

        jLabel10.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel4.add(jLabel10, gridBagConstraints);

        jLabel11.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel4.add(jLabel11, gridBagConstraints);

        jLabel12.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel4.add(jLabel12, gridBagConstraints);

        jPanel1.add(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setMinimumSize(new java.awt.Dimension(240, 360));
        jPanel5.setPreferredSize(new java.awt.Dimension(240, 360));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel13.setBackground(new java.awt.Color(204, 153, 255));
        jLabel13.setMaximumSize(new java.awt.Dimension(200, 200));
        jLabel13.setMinimumSize(new java.awt.Dimension(200, 200));
        jLabel13.setPreferredSize(new java.awt.Dimension(200, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel5.add(jLabel13, gridBagConstraints);

        jButton3.setText("Đặt ngay");
        jButton3.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton3.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton3.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel5.add(jButton3, gridBagConstraints);

        jLabel14.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel5.add(jLabel14, gridBagConstraints);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel5.add(jLabel15, gridBagConstraints);

        jLabel16.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel5.add(jLabel16, gridBagConstraints);

        jLabel17.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel5.add(jLabel17, gridBagConstraints);

        jLabel18.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel5.add(jLabel18, gridBagConstraints);

        jPanel1.add(jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setMinimumSize(new java.awt.Dimension(240, 360));
        jPanel6.setPreferredSize(new java.awt.Dimension(240, 360));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel19.setBackground(new java.awt.Color(204, 153, 255));
        jLabel19.setMaximumSize(new java.awt.Dimension(200, 200));
        jLabel19.setMinimumSize(new java.awt.Dimension(200, 200));
        jLabel19.setPreferredSize(new java.awt.Dimension(200, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel6.add(jLabel19, gridBagConstraints);

        jButton4.setText("Đặt ngay");
        jButton4.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton4.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton4.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel6.add(jButton4, gridBagConstraints);

        jLabel20.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel6.add(jLabel20, gridBagConstraints);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel6.add(jLabel21, gridBagConstraints);

        jLabel22.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel6.add(jLabel22, gridBagConstraints);

        jLabel23.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel6.add(jLabel23, gridBagConstraints);

        jLabel24.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel6.add(jLabel24, gridBagConstraints);

        jPanel1.add(jPanel6);

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setMinimumSize(new java.awt.Dimension(240, 360));
        jPanel7.setPreferredSize(new java.awt.Dimension(240, 360));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel25.setBackground(new java.awt.Color(204, 153, 255));
        jLabel25.setMaximumSize(new java.awt.Dimension(200, 200));
        jLabel25.setMinimumSize(new java.awt.Dimension(200, 200));
        jLabel25.setPreferredSize(new java.awt.Dimension(200, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel7.add(jLabel25, gridBagConstraints);

        jButton5.setText("Đặt ngay");
        jButton5.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton5.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton5.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel7.add(jButton5, gridBagConstraints);

        jLabel26.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel7.add(jLabel26, gridBagConstraints);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel7.add(jLabel27, gridBagConstraints);

        jLabel28.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel7.add(jLabel28, gridBagConstraints);

        jLabel29.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel7.add(jLabel29, gridBagConstraints);

        jLabel30.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel7.add(jLabel30, gridBagConstraints);

        jPanel1.add(jPanel7);

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setMinimumSize(new java.awt.Dimension(240, 360));
        jPanel8.setPreferredSize(new java.awt.Dimension(240, 360));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel31.setBackground(new java.awt.Color(204, 153, 255));
        jLabel31.setMaximumSize(new java.awt.Dimension(200, 200));
        jLabel31.setMinimumSize(new java.awt.Dimension(200, 200));
        jLabel31.setPreferredSize(new java.awt.Dimension(200, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel8.add(jLabel31, gridBagConstraints);

        jButton6.setText("Đặt ngay");
        jButton6.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton6.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton6.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel8.add(jButton6, gridBagConstraints);

        jLabel32.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel8.add(jLabel32, gridBagConstraints);

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel8.add(jLabel33, gridBagConstraints);

        jLabel34.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel8.add(jLabel34, gridBagConstraints);

        jLabel35.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel8.add(jLabel35, gridBagConstraints);

        jLabel36.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel8.add(jLabel36, gridBagConstraints);

        jPanel1.add(jPanel8);

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setMinimumSize(new java.awt.Dimension(240, 360));
        jPanel9.setPreferredSize(new java.awt.Dimension(240, 360));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel37.setBackground(new java.awt.Color(204, 153, 255));
        jLabel37.setMaximumSize(new java.awt.Dimension(200, 200));
        jLabel37.setMinimumSize(new java.awt.Dimension(200, 200));
        jLabel37.setPreferredSize(new java.awt.Dimension(200, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel9.add(jLabel37, gridBagConstraints);

        jButton7.setText("Đặt ngay");
        jButton7.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton7.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton7.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel9.add(jButton7, gridBagConstraints);

        jLabel38.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel9.add(jLabel38, gridBagConstraints);

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel9.add(jLabel39, gridBagConstraints);

        jLabel40.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel9.add(jLabel40, gridBagConstraints);

        jLabel41.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel9.add(jLabel41, gridBagConstraints);

        jLabel42.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel9.add(jLabel42, gridBagConstraints);

        jPanel1.add(jPanel9);

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setMinimumSize(new java.awt.Dimension(240, 360));
        jPanel10.setPreferredSize(new java.awt.Dimension(240, 360));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jLabel43.setBackground(new java.awt.Color(204, 153, 255));
        jLabel43.setMaximumSize(new java.awt.Dimension(200, 200));
        jLabel43.setMinimumSize(new java.awt.Dimension(200, 200));
        jLabel43.setPreferredSize(new java.awt.Dimension(200, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel10.add(jLabel43, gridBagConstraints);

        jButton8.setText("Đặt ngay");
        jButton8.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton8.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton8.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel10.add(jButton8, gridBagConstraints);

        jLabel44.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel10.add(jLabel44, gridBagConstraints);

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel10.add(jLabel45, gridBagConstraints);

        jLabel46.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel10.add(jLabel46, gridBagConstraints);

        jLabel47.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel10.add(jLabel47, gridBagConstraints);

        jLabel48.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel10.add(jLabel48, gridBagConstraints);

        jPanel1.add(jPanel10);

        jScrollPane1.setViewportView(jPanel1);

        tabMenu.addTab("Món Nóng", jScrollPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1065, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 774, Short.MAX_VALUE)
        );

        tabMenu.addTab("Xôi lạc", jPanel2);

        getContentPane().add(tabMenu, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane tabMenu;
    // End of variables declaration//GEN-END:variables
}
