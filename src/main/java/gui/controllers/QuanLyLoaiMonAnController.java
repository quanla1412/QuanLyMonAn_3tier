package gui.controllers;

import bll.services.ILoaiMonAnService;
import bll.services.impl.LoaiMonAnServiceImpl;
import gui.models.LoaiMonAn.CreateLoaiMonAnModel;
import gui.models.LoaiMonAn.LoaiMonAnModel;
import gui.views.QuanLyLoaiMonAn_GUI;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author LeAnhQuan
 */
public class QuanLyLoaiMonAnController {
    QuanLyLoaiMonAn_GUI view;
    
    ILoaiMonAnService loaiMonAnService;
    
    ArrayList<LoaiMonAnModel> listLoaiMonAnModel;

    public QuanLyLoaiMonAnController() {
        loaiMonAnService = new LoaiMonAnServiceImpl();
        
        init();
    }
    
    private void init(){        
        view = new QuanLyLoaiMonAn_GUI();
        view.setVisible(true);
        
        loadData();
        view.loadTableLoaiMonAn(listLoaiMonAnModel);
    }
    
    private void loadData(){
        listLoaiMonAnModel = (ArrayList<LoaiMonAnModel>) loaiMonAnService.getAll();
    }
    
    private void createLoaiMonAn(){
        String tenLoaiMonAn = view.txtTenLoaiMonAn.getText().trim();
        if(tenLoaiMonAn.isBlank()){
            JOptionPane.showMessageDialog(view, "Tên loại món ăn không được để trống","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        CreateLoaiMonAnModel createLoaiMonAnModel = new CreateLoaiMonAnModel(tenLoaiMonAn);
        boolean result = loaiMonAnService.createLoaiMonAn(createLoaiMonAnModel);        
        if(result){
            JOptionPane.showMessageDialog(this, "Thêm loại món ăn mới thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadTableLoaiMonAn();  
            txtTenLoaiMonAn.setText("");
        }            
        else
            JOptionPane.showMessageDialog(this, "Thêm loại món ăn mới thất bại","Error", JOptionPane.ERROR_MESSAGE);        
    }
}
