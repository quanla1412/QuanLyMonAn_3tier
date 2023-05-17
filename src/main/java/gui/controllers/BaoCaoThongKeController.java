package gui.controllers;

import bll.services.IBanService;
import bll.services.IHoaDonService;
import bll.services.IKhachHangService;
import bll.services.ILoaiBanService;
import bll.services.INhanVienService;
import bll.services.ITinhTrangBanService;
import bll.services.impl.BanServiceImpl;
import bll.services.impl.HoaDonServiceImpl;
import bll.services.impl.KhachHangServiceImpl;
import bll.services.impl.LoaiBanServiceImpl;
import bll.services.impl.NhanVienServiceImpl;
import bll.services.impl.TinhTrangBanServiceImpl;
import dal.entity.LoaiBan;
import gui.models.Ban.TinhTrangBanModel;
import gui.models.BanModel;
import gui.models.KhachHang.KhachHangModel;
import gui.models.LoaiBanModel;
import gui.views.BaoCaoThongKe_GUI;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author LeAnhQuan
 */
public class BaoCaoThongKeController {
    private BaoCaoThongKe_GUI view;
    
    private ILoaiBanService loaiBanService;
    private IBanService banService;
    private ITinhTrangBanService tinhTrangBanService;
    private IKhachHangService khachHangService;
    private INhanVienService nhanVienService;
    private IHoaDonService hoaDonService;

    public BaoCaoThongKeController() {
        loaiBanService = new LoaiBanServiceImpl();
        banService = new BanServiceImpl();
        tinhTrangBanService = new TinhTrangBanServiceImpl();
        khachHangService = new KhachHangServiceImpl();
        nhanVienService = new NhanVienServiceImpl();
        hoaDonService = new HoaDonServiceImpl();
        init();
    }
    
    private void init(){
        view = new BaoCaoThongKe_GUI();
        view.setVisible(true);
        
        view.cmbLoaiThongKe.addItemListener((ItemEvent event) -> {
            int indexLoaiKH = view.cmbLoaiThongKe.getSelectedIndex();
            switch(indexLoaiKH){
                case (0) -> showPieChartLoaiBanTheoSoLuongBan();
                case (1) -> showPieChartBanTheoTinhTrang();
                case (2) -> showPieChartKhachHangTheoLoaiKhachHang();
                case (3) -> showPieChartKhachHangTheoGioiTinh();
                case (4) -> showPieChartKhachHangTheoDoTuoi();
                case (5) -> showPieChartNhanVienTheoGioiTinh();
                case (6) -> showPieChartNhanVienTheoTinhTrang();
                case (7) -> showPieChartNhanVienTheoDoTuoi();
                case (8) -> showBarChartDoanhThuNhanVienTheoThangHienTai();
                case (9) -> showBarChartDoanhThuKhachHangTheoThangHienTai();
//                case (10) -> showBarChartDoanhThuTheo7NgayGanNhat();
//                case (11) -> showPieChartDoanhThuNamHienTai();
//                case (12) -> showPieChartDoanhThuTheoLoaiMonAnNamHienTai();
//                case (13) -> showPieChartTieuThuMonAnThangHienTai();
            }
        });
        showPieChartLoaiBanTheoSoLuongBan();
    }
    
    public JPanel getView(){
        return view;
    }
    
    private void showPieChart(String title, HashMap<String, Integer> data){
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        for(String key : data.keySet()){
            dataset.setValue(key, data.get(key));
        }
        
        // Create the chart
        JFreeChart chart = ChartFactory.createPieChart(
            title,
            dataset,
            true,
            true,
            false
        );
        
        PiePlot plot = (PiePlot) chart.getPlot();
        
        // Định dạng chuỗi giá trị hiển thị trên biểu đồ tròn
        StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", // "{0}" là tên section, "{1}" là giá trị, "{2}" là tỷ lệ phần trăm
                new java.text.DecimalFormat("0"), // định dạng cho giá trị
                new java.text.DecimalFormat("0.00%") // định dạng cho tỷ lệ phần trăm
                );
        plot.setLabelGenerator(labelGenerator);
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        view.pnlBieuDo.removeAll();
        view.pnlBieuDo.add(chartPanel);
        view.pnlBieuDo.validate();
        view.pnlBieuDo.repaint();
    }
    
    private void showPieChartLoaiBanTheoSoLuongBan(){
        HashMap<String, Integer> data = (HashMap<String, Integer>) banService.countByLoaiBan();
        String title = "Thống kê loại bàn theo số lượng bàn";
        
        showPieChart(title, data);
     }
    
    private void showPieChartBanTheoTinhTrang(){
        HashMap<String, Integer> data = (HashMap<String, Integer>) banService.countByTinhTrang();
        String title = "Thống kê số lượng bàn theo tình trạng";
        
        showPieChart(title, data);
    }   
    
    private void showPieChartKhachHangTheoLoaiKhachHang(){
        HashMap<String, Integer> data = (HashMap<String, Integer>) khachHangService.countByLoaiKhachHang();
        String title = "Thống kê số lượng khách hàng theo loại";
        
        showPieChart(title, data);
    }
    
    private void showPieChartKhachHangTheoGioiTinh(){
        HashMap<String, Integer> data = (HashMap<String, Integer>) khachHangService.countByGioiTinh();
        String title = "Thống kê số lượng khách hàng theo giới tính";
        
        showPieChart(title, data);
    }
    
    public void showPieChartKhachHangTheoDoTuoi(){
        HashMap<String, Integer> data = (HashMap<String, Integer>) khachHangService.countByTuoi();
        String title = "Thống kê số lượng khách hàng theo độ tuổi";
        
        showPieChart(title, data);
     }  

    private void showPieChartNhanVienTheoGioiTinh() {
        HashMap<String, Integer> data = (HashMap<String, Integer>) nhanVienService.countByGioiTinh();
        String title = "Thống kê số lượng nhân viên theo giới tính";
        
        showPieChart(title, data);
    }

    private void showPieChartNhanVienTheoTinhTrang() {
        HashMap<String, Integer> data = (HashMap<String, Integer>) nhanVienService.countByTinhTrang();
        String title = "Thống kê số lượng nhân viên theo tình trạng";
        
        showPieChart(title, data);
    }

    private void showPieChartNhanVienTheoDoTuoi() {
        HashMap<String, Integer> data = (HashMap<String, Integer>) nhanVienService.countByTuoi();
        String title = "Thống kê số lượng nhân viên theo độ tuổi";
        
        showPieChart(title, data);
    }
    
    private void showBarChartDoanhThuNhanVienTheoThangHienTai(){
        HashMap<String, Long> data = (HashMap<String, Long>) nhanVienService.getDoanhThuTheoThangHienTai();
        String title = "Thống kê doanh thu nhân viên theo tháng hiện tại";
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         
        
         for(String key : data.keySet()){
            dataset.setValue(data.get(key),"Doanh thu",key);
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createBarChart(
            "Thống kê doanh thu nhân viên theo tháng hiện tại", // Tiêu đề biểu đồ
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
        view.pnlBieuDo.removeAll();
        view.pnlBieuDo.add(chartPanel);
        view.pnlBieuDo.validate();
        view.pnlBieuDo.repaint();
        
    }
    
     private void showBarChartDoanhThuKhachHangTheoThangHienTai(){
        HashMap<String, Long> data = (HashMap<String, Long>) khachHangService.getDoanhThuTheoThangHienTai();
        String title = "Thống kê doanh thu nhân viên theo tháng hiện tại";
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         
        
         for(String key : data.keySet()){
            dataset.setValue(data.get(key),"Doanh thu",key);
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createBarChart(
            "Thống kê doanh thu khách hàng theo tháng hiện tại", // Tiêu đề biểu đồ
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
        view.pnlBieuDo.removeAll();
        view.pnlBieuDo.add(chartPanel);
        view.pnlBieuDo.validate();
        view.pnlBieuDo.repaint();
 
    }
//     
//     private void showBarChartDoanhThuTheo7NgayGanNhat (){
//        LocalDate fromDate = LocalDate.now().minusDays(7);
//        LocalDate toDate = LocalDate.now();
//        Date ngayBatDau = java.sql.Date.valueOf(fromDate);
//        Date ngayKetThuc = java.sql.Date.valueOf(toDate);
//        HashMap<String, Long> data = (HashMap<String, Long>) hoaDonService.getDoanhThuTheoThang7NgayGanNhat(ngayBatDau, ngayKetThuc);
//        String title = "Thống kê doanh thu theo 7 ngày gần nhất";
//         
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//                   
//        
//        for(String key : data.keySet()){
//            dataset.setValue(data.get(key),"Doanh thu",key);
//        }
//        // Create the chart
//        JFreeChart chart = ChartFactory.createBarChart(
//            "Thống kê doanh thu theo 7 ngày gần nhất", // Tiêu đề biểu đồ
//            "Ngày",                           // Tên trục x
//            "Doanh thu (Triệu VNĐ)",                // Tên trục y
//            dataset,                          // Dữ liệu
//            PlotOrientation.HORIZONTAL,         // Hướng biểu đồ
//            true,                             // Legend
//            true,                             // Tooltips
//            false                             // URLs
//        );
//        
//        // Create the chart panel and add it to the main panel
//        ChartPanel chartPanel = new ChartPanel(chart);
//        view.pnlBieuDo.removeAll();
//        view.pnlBieuDo.add(chartPanel);
//        view.pnlBieuDo.validate();
//        view.pnlBieuDo.repaint();
//     }
//    
}
