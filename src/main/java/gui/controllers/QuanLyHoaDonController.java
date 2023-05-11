/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.controllers;

import bll.services.IHoaDonService;
import bll.services.impl.HoaDonServiceImpl;
import com.mycompany.quanlynhahang.Price;
import gui.models.HoaDon.HoaDonFullModel;
import gui.models.HoaDon.HoaDonModel;
import gui.models.HoaDon.SearchHoaDonModel;
import gui.views.QuanLyHoaDon_GUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JOptionPane;


/**
 *
 * @author tanph
 */
public class QuanLyHoaDonController {
    private QuanLyHoaDon_GUI view;
    private QuanLyHoaDonController quanLyHoaDonController;
    
    private final IHoaDonService hoaDonService;
    
    public ArrayList<HoaDonModel> listHoaDonModel;
    
    private HoaDonFullModel hoaDonSelected = null;
    
    public QuanLyHoaDonController(){
        hoaDonService = new HoaDonServiceImpl();
        
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
        view.loadFromDateToDate();
        view.loadTTHDSearch();
        
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
                resetForm();
                
                
            }
        });
        
    }
    
    private void loadData(){
        listHoaDonModel = (ArrayList<HoaDonModel>) hoaDonService.getAll();
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
        if(idTTHD > 0){
            if(idTTHD == 1){
                searchHoaDonModel.setIdTTHD(0);
            } else {
                searchHoaDonModel.setIdTTHD(1);
            }
        } else{
            searchHoaDonModel.setIdTTHD(2);
        }
        
        listHoaDonModel = (ArrayList<HoaDonModel>) hoaDonService.search(searchHoaDonModel);
        if(listHoaDonModel.isEmpty())
            JOptionPane.showMessageDialog(view, "Không tìm thấy dữ liệu","Error", JOptionPane.ERROR_MESSAGE);
        view.loadTableHoaDon(listHoaDonModel);
    }
    
    private void huyHoaDon(){
        
    }
    
    private void resetTable(){
        view.loadTableHoaDon(listHoaDonModel);
        view.txtSearchID.setText("");
        
        LocalDate fromDate = LocalDate.now().minusDays(30);
        LocalDate toDate = LocalDate.now();
        view.dtcNgayBatDau.setDate(Date.valueOf(fromDate));
        view.dtcNgayCuoiCung.setDate(Date.valueOf(toDate));
        
        view.sldMinPrice.setValue(view.sldMinPrice.getMinimum());
        view.lblMinPrice.setText(Price.formatPrice(view.sldMinPrice.getValue()));
        view.sldMaxPrice.setValue(view.sldMaxPrice.getMaximum());
        view.lblMaxPrice.setText(Price.formatPrice(view.sldMaxPrice.getValue()));
        
        view.cmbTTMASearch.setSelectedIndex(0);
    }
    

}
