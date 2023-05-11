/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui.views;

import java.awt.Font;
import java.text.DecimalFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

public class BaoCaoThongKe_GUI extends javax.swing.JPanel {
    
    public BaoCaoThongKe_GUI() {
        initComponents();        
    }
    public void showPieChartDoanhThuTheoNhanVienNamHienTai(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        listDoanhThuTheoNguoi = thongKe_BUS.getAllDoanhThuTheoNhanVien();        
        
        for(DoanhThuNguoi_DTO doanhThu : listDoanhThuTheoNguoi){
        dataset.setValue(doanhThu.getTongTien(), "Doanh thu", doanhThu.getHoTen());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createBarChart(
            "Thống kê Top 5 nhân viên có doanh thu cao nhất", // Tiêu đề biểu đồ
            "Tên nhân viên",                           // Tên trục x
            "Doanh thu (Triệu VNĐ)",                // Tên trục y
            dataset,                          // Dữ liệu
            PlotOrientation.HORIZONTAL,         // Hướng biểu đồ
            true,                             // Legend
            true,                             // Tooltips
            false                             // URLs
        );
        
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }
    public void showPieChartDoanhThuTheoKhachHangNamHienTai(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        listDoanhThuTheoNguoi = thongKe_BUS.getAllDoanhThuTheoKhachHang();        
        
        for(DoanhThuNguoi_DTO doanhThu : listDoanhThuTheoNguoi){
        dataset.setValue(doanhThu.getTongTien(), "Doanh thu", doanhThu.getHoTen());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createBarChart(
            "Thống kê Top 5 khách hàng thân thiết", // Tiêu đề biểu đồ
            "Tên khách hàng",                           // Tên trục x
            "Doanh thu (Triệu VNĐ)",                // Tên trục y
            dataset,                          // Dữ liệu
            PlotOrientation.HORIZONTAL,         // Hướng biểu đồ
            true,                             // Legend
            true,                             // Tooltips
            false                             // URLs
        );
        
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }
    public void showPieChartDoanhThuTheo7NgayGanNhat(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        listDoanhThuTheoNgay = thongKe_BUS.getAllDoanhThuTheo7NgayGanNhat();        
        
        for(DoanhThuNgay_DTO doanhThu : listDoanhThuTheoNgay){
        dataset.setValue(doanhThu.getTongTien(), "Doanh thu", doanhThu.getDate());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createBarChart(
            "Thống kê doanh thu theo 7 ngày gần nhất", // Tiêu đề biểu đồ
            "Ngày",                           // Tên trục x
            "Doanh thu (Triệu VNĐ)",                // Tên trục y
            dataset,                          // Dữ liệu
            PlotOrientation.HORIZONTAL,         // Hướng biểu đồ
            true,                             // Legend
            true,                             // Tooltips
            false                             // URLs
        );
        
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }
    public void showPieChartDoanhThuNamHienTai(){
         DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        listDoanhThuTheoThang = thongKe_BUS.getAllDoanhThuTheoThang();        
        
        
        for(DoanhThuThang_DTO doanhThu : listDoanhThuTheoThang){
            dataset.addValue(doanhThu.getTongTien(), "Sales",doanhThu.getThang());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createLineChart(
            "Thống kê doanh thu các tháng của năm hiện tại",  // Tiêu đề biểu đồ
            "Month",          // Tiêu đề trục hoành
            "% so với tháng đầu tiên ",      // Tiêu đề trục tung
            dataset           // Dataset
        );
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true);
        renderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator) new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0.00")));
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, 12));
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }
    public void showPieChartDoanhThuTheoLoaiMonAnNamHienTai(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        listDoanhThuTheoLMA = thongKe_BUS.getAllDoanhThuTheoLoaiMonAn();        
        
        for(DoanhThuTheoLoaiMonAn_DTO doanhThu : listDoanhThuTheoLMA){
        dataset.setValue(doanhThu.getTongTien(), "Doanh thu", doanhThu.getTenLMA());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createBarChart(
            "Thống kê doanh thu theo loại món ăn của năm hiện tại", // Tiêu đề biểu đồ
            "Tên loại món ăn",                           // Tên trục x
            "Doanh thu (Triệu VNĐ)",                // Tên trục y
            dataset,                          // Dữ liệu
            PlotOrientation.HORIZONTAL,         // Hướng biểu đồ
            true,                             // Legend
            true,                             // Tooltips
            false                             // URLs
        );
        
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }
    public void showPieChartTieuThuMonAnThangHienTai(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        listSoLuongTheoMonAn = thongKe_BUS.getAllSoLuongTheoMonAnTheoThang();        
        
        for(SoLuongTheoMonAn_DTO doanhThu : listSoLuongTheoMonAn){
        dataset.setValue(doanhThu.getSoLuong(), "Doanh thu", doanhThu.getTenMonAn());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createBarChart(
            "Top 5 món ăn bán chạy nhất tháng hiện tại", // Tiêu đề biểu đồ
            "Tên món ăn",                           // Tên trục x
            "Số lượng",                // Tên trục y
            dataset,                          // Dữ liệu
            PlotOrientation.HORIZONTAL,         // Hướng biểu đồ
            true,                             // Legend
            true,                             // Tooltips
            false                             // URLs
        );
        
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        cmbLoaiThongKe = new javax.swing.JComboBox<>();
        pnlBieuDo = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        cmbLoaiThongKe.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbLoaiThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống kê bàn theo số lượng", "Thống kê bàn theo tình trạng bàn", "Thống kê khách hàng theo bậc", "Thống kê khách hàng theo giới tính", "Thống kê khách hàng theo độ tuổi", "Thống kê nhân viên theo giới tính", "Thống kê nhân viên theo tình trạng", "Thống kê nhân viên theo độ tuổi", "Thống kê doanh thu theo nhân viên ( năm hiện tại )", "Thống kê khách hàng thân thiết ( năm hiện tại )", "Thống kê doanh thu 7 ngày gần nhất", "Thống kê doanh thu năm hiện tại", "Thống kê doanh thu theo loại món ăn", "Thống kê lượng tiêu thụ theo món ăn ( tháng hiện tại )" }));
        cmbLoaiThongKe.setMinimumSize(new java.awt.Dimension(322, 40));
        cmbLoaiThongKe.setPreferredSize(new java.awt.Dimension(322, 40));
        cmbLoaiThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbLoaiThongKeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmbLoaiThongKeMouseEntered(evt);
            }
        });
        cmbLoaiThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLoaiThongKeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(12, 20, 12, 20);
        add(cmbLoaiThongKe, gridBagConstraints);

        pnlBieuDo.setBackground(new java.awt.Color(102, 102, 255));
        pnlBieuDo.setMinimumSize(new java.awt.Dimension(800, 450));
        pnlBieuDo.setPreferredSize(new java.awt.Dimension(800, 450));
        pnlBieuDo.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        add(pnlBieuDo, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbLoaiThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbLoaiThongKeMouseClicked
        // TODO add your handling code here:
        //        int indexLoaiKH = cmbThongKe.getSelectedIndex();
        //        if(indexLoaiKH == 1){
            //            showPieChartBanTheoSoLuong();
            //        }
        //        if(indexLoaiKH == 0){
            //            showPieChartBanTheoTinhTrang();
            //        }
    }//GEN-LAST:event_cmbLoaiThongKeMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(BaoCaoThongKe_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(BaoCaoThongKe_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(BaoCaoThongKe_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(BaoCaoThongKe_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaoCaoThongKe_GUI().setVisible(true);
            }
        });
    }
    
    private void cmbLoaiThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbLoaiThongKeMouseEntered

    }//GEN-LAST:event_cmbLoaiThongKeMouseEntered

    private void cmbLoaiThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLoaiThongKeActionPerformed
        
    }//GEN-LAST:event_cmbLoaiThongKeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> cmbLoaiThongKe;
    public javax.swing.JPanel pnlBieuDo;
    // End of variables declaration//GEN-END:variables
}
