/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.controllers;

import bll.services.IChiTietHoaDonService;
import bll.services.IHoaDonService;
import bll.services.IKhachHangService;
import bll.services.INhanVienService;
import bll.services.impl.ChiTietHoaDonServiceImpl;
import bll.services.impl.HoaDonServiceImpl;
import bll.services.impl.KhachHangServiceImpl;
import bll.services.impl.NhanVienServiceImpl;
import com.mycompany.quanlynhahang.Price;
import gui.constraints.TinhTrangHoaDonConstraints;
import gui.models.HoaDon.ChiTietHoaDonModel;
import gui.models.HoaDon.HoaDonFullModel;
import gui.models.HoaDon.HoaDonModel;
import gui.models.HoaDon.SearchHoaDonModel;
import gui.models.KhachHang.KhachHangModel;
import gui.models.NhanVien.NhanVienModel;
import gui.views.QuanLyHoaDon_GUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author tanph
 */
public class QuanLyHoaDonController {
    private QuanLyHoaDon_GUI view;
    private QuanLyHoaDonController quanLyHoaDonController;
    
    private final IHoaDonService hoaDonService;
    private final IKhachHangService khachHangService;
    private final INhanVienService nhanVienService;
   
    private final IChiTietHoaDonService chiTietHoaDonService;
    
    public ArrayList<HoaDonModel> listHoaDonModel;
    public ArrayList<KhachHangModel> listKhachHangModel;
    public ArrayList<NhanVienModel> listNhanVienModel;
    
    private HoaDonFullModel hoaDonSelected = null;
    
    public QuanLyHoaDonController(){
        hoaDonService = new HoaDonServiceImpl();
        khachHangService = new KhachHangServiceImpl();
        nhanVienService = new NhanVienServiceImpl();
        
        chiTietHoaDonService = new ChiTietHoaDonServiceImpl();
        
        init();
    }
    
     public JComponent getView(){
        return view;
    }
    
    private void init(){
        view = new QuanLyHoaDon_GUI();
        view.setVisible(true);
        
        loadData();
        view.loadTableHoaDon(listHoaDonModel);
        loadFromDateToDate();
//        loadTTHDSearch();
        loadDoanhThu();
        
        view.sldMinPrice.addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {                
                view.lblMinPrice.setText(Price.formatPrice(view.sldMinPrice.getValue()));
            }
        });        
        view.sldMaxPrice.addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {                
                view.lblMaxPrice.setText(Price.formatPrice(view.sldMaxPrice.getValue()));
            }
        });
        
        view.btnTimKiem.addActionListener(e -> searchHoaDon());
        view.btnReset.addActionListener(e -> resetTable());
        view.btnHuyHoaDon.addActionListener(e -> huyHoaDon());
        
        view.tblDanhSachHoaDon.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                int row = view.tblDanhSachHoaDon.getSelectedRow();
                if(row < 0)
                    return;
                int idHoaDon = (int) view.tblDanhSachHoaDon.getValueAt(row, 0);
                hoaDonSelected = hoaDonService.getHoaDonFullById(idHoaDon);
                loadForm();
            }
        }); 
    }
    
    private void loadData(){
        listHoaDonModel = (ArrayList<HoaDonModel>) hoaDonService.getAll(false);
        listKhachHangModel = (ArrayList<KhachHangModel>) khachHangService.getAll();
        listNhanVienModel = (ArrayList<NhanVienModel>) nhanVienService.getAll();
    }
    
    private void searchHoaDon(){
        SearchHoaDonModel searchHoaDonModel = new SearchHoaDonModel();

        String id = view.txtSearchID.getText();
        if(!id.isBlank()){
            searchHoaDonModel.setId(id.trim());
        }

        Timestamp ngayBatDau;
        ngayBatDau = new Timestamp(view.dtcNgayBatDau.getDate().getTime());
        java.util.Date ngayCuoiCung = view.dtcNgayCuoiCung.getDate();
        ngayCuoiCung.setHours(23);
        ngayCuoiCung.setMinutes(59);
        ngayCuoiCung.setSeconds(59);
        Timestamp ngayCuoiCungTS = new Timestamp(ngayCuoiCung.getTime());

        if((ngayBatDau.compareTo(ngayCuoiCung)) > 0){
            JOptionPane.showMessageDialog(view,"Ngày bắt đầu không được lớn hơn ngày kết thúc","Error",JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            searchHoaDonModel.setNgayBatDau(ngayBatDau);
            searchHoaDonModel.setNgayCuoiCung(ngayCuoiCungTS);
        }

        int minPrice = view.sldMinPrice.getValue();
        int maxPrice = view.sldMaxPrice.getValue();
        if(minPrice > maxPrice){
            JOptionPane.showMessageDialog(view,"Giá tối thiểu phải nhỏ hơn giá tối đa","Error",JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            searchHoaDonModel.setMinPrice(minPrice);
            searchHoaDonModel.setMaxPrice(maxPrice);
        }

        int idTTHD = view.cmbTTMASearch.getSelectedIndex();
        
        if(idTTHD == 0){
            searchHoaDonModel.setIdTTHD(0);
        } else {
            searchHoaDonModel.setIdTTHD(1);
        }
        
        
        listHoaDonModel = (ArrayList<HoaDonModel>) hoaDonService.search(searchHoaDonModel);
        if(listHoaDonModel.isEmpty())
            JOptionPane.showMessageDialog(view, "Không tìm thấy dữ liệu","Error", JOptionPane.ERROR_MESSAGE);
        view.loadTableHoaDon(listHoaDonModel);
    }
    
    private void huyHoaDon(){
        if(view.btnHuyHoaDon.isEnabled()){
            int indexRow = view.tblDanhSachHoaDon.getSelectedRow();
            TableModel model = view.tblDanhSachHoaDon.getModel();
            
            int idHoaDon = Integer.parseInt(model.getValueAt(indexRow, 0).toString());
            HoaDonFullModel hoaDonFullModel = hoaDonService.getHoaDonFullById(idHoaDon);
            
            boolean result = hoaDonService.huyHoaDon(hoaDonFullModel);

            if(result){
                JOptionPane.showMessageDialog(view, "Huỷ hoá đơn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                resetTable();
                loadForm();
                loadDoanhThu();
            } else{
                JOptionPane.showMessageDialog(view, "Huỷ hoá đơn không thành công","Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void resetTable(){
        listHoaDonModel = (ArrayList<HoaDonModel>) hoaDonService.getAll(false);
        view.loadTableHoaDon(listHoaDonModel);
        view.txtSearchID.setText("");
        
        LocalDate fromDate = LocalDate.now().minusDays(30);
        LocalDate toDate = LocalDate.now();
        view.dtcNgayBatDau.setDate(java.sql.Date.valueOf(fromDate));
        view.dtcNgayCuoiCung.setDate(java.sql.Date.valueOf(toDate));
        
        view.sldMinPrice.setValue(view.sldMinPrice.getMinimum());
        view.lblMinPrice.setText(Price.formatPrice(view.sldMinPrice.getValue()));
        view.sldMaxPrice.setValue(view.sldMaxPrice.getMaximum());
        view.lblMaxPrice.setText(Price.formatPrice(view.sldMaxPrice.getValue()));
        
        view.cmbTTMASearch.setSelectedIndex(0);
        hoaDonSelected = null;
        loadForm();
    }
    
    private void loadForm(){
        if(hoaDonSelected == null){
            view.txtMaHoaDon.setText("");
            view.txtIdNhanVien.setText("");
            view.txtIdKhachHang.setText("");
            view.dtcNgayGio.setDate(new Date());
            view.txtTinhTrangHoaDon.setText("");
            view.resetTableDonGoi();
            view.txtTongTien.setText("");
            view.txtUuDai.setText("");
            view.txtThanhTien.setText("");
            return;
        }
        
        List<ChiTietHoaDonModel> listChiTietHoaDonModel = chiTietHoaDonService.getAllChiTietHoaDonByIdHoaDon(hoaDonSelected.getId());
        long totalPrice = 0;
        
        view.txtMaHoaDon.setText(Integer.toString(hoaDonSelected.getId()));
        view.txtIdNhanVien.setText(hoaDonSelected.getMaNhanVien());
        view.txtIdKhachHang.setText(Integer.toString(hoaDonSelected.getIdKhachHang()));
        view.dtcNgayGio.setDate(hoaDonSelected.getNgayGio());
        
        if(hoaDonSelected.isDaHuy() == TinhTrangHoaDonConstraints.DA_HUY){
            view.txtTinhTrangHoaDon.setText("Đã huỷ");
            view.btnHuyHoaDon.setEnabled(false);
        } else {
            view.txtTinhTrangHoaDon.setText("Hợp lệ");
            view.btnHuyHoaDon.setEnabled(true);
        }
        
        
        for(ChiTietHoaDonModel chiTietHoaDonModel : listChiTietHoaDonModel){
            totalPrice += chiTietHoaDonModel.getThanhTien();
        }
        
        view.loadTableChiTietHoaDonById((ArrayList<ChiTietHoaDonModel>) listChiTietHoaDonModel,totalPrice);
        view.txtUuDai.setText(Float.toString(hoaDonSelected.getUuDai()));
        view.txtThanhTien.setText(Price.formatPrice(hoaDonSelected.getTongGia()));
    }
    
    private void loadFromDateToDate(){  
        LocalDate fromDate = LocalDate.now().minusDays(30);
        LocalDate toDate = LocalDate.now();
        
        view.dtcNgayBatDau.setDate(java.sql.Date.valueOf(fromDate));
        view.dtcNgayCuoiCung.setDate(java.sql.Date.valueOf(toDate));
    }
    
    private void loadDoanhThu(){
        LocalDate fromDate = LocalDate.now().minusDays(7);
        LocalDate toDate = LocalDate.now();
        Date ngayBatDau = java.sql.Date.valueOf(fromDate);
        Date ngayKetThuc = java.sql.Date.valueOf(toDate);
        
        view.lblDoanhThuTrongNgay.setText("Trong ngày: " + Price.formatPrice(hoaDonService.getDoanhThuTrongNgay(ngayKetThuc)));
        view.lblDoanhThu7NgayGanNhat.setText("7 ngày gần nhất: " + Price.formatPrice(hoaDonService.getDoanhThuTrong7NgayGanNhat(ngayBatDau,ngayKetThuc)));
    }
    
//    private void loadTTHDSearch(){
//        view.cmbTTMASearch.addItem("Tất cả");
//        view.cmbTTMASearch.addItem("Hợp lệ");
//        view.cmbTTMASearch.addItem("Đã Huỷ");  
//    }
    

}
