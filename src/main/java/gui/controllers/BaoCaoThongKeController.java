package gui.controllers;

import bll.services.IBanService;
import bll.services.IKhachHangService;
import bll.services.ILoaiBanService;
import bll.services.INhanVienService;
import bll.services.ITinhTrangBanService;
import bll.services.impl.BanServiceImpl;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
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

    public BaoCaoThongKeController() {
        loaiBanService = new LoaiBanServiceImpl();
        banService = new BanServiceImpl();
        tinhTrangBanService = new TinhTrangBanServiceImpl();
        khachHangService = new KhachHangServiceImpl();
        nhanVienService = new NhanVienServiceImpl();
        
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
//                case (8) -> showPieChartDoanhThuTheoNhanVienNamHienTai();
//                case (9) -> showPieChartDoanhThuTheoKhachHangNamHienTai();
//                case (10) -> showPieChartDoanhThuTheo7NgayGanNhat();
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
}
