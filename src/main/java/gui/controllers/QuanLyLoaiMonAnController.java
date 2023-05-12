package gui.controllers;

import bll.services.ILoaiMonAnService;
import bll.services.impl.LoaiMonAnServiceImpl;
import dal.entity.LoaiMonAn;
import gui.models.LoaiMonAn.CreateLoaiMonAnModel;
import gui.models.LoaiMonAn.LoaiMonAnModel;
import gui.views.QuanLyLoaiMonAn_GUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author LeAnhQuan
 */
public class QuanLyLoaiMonAnController {
    QuanLyLoaiMonAn_GUI view;
    
    ILoaiMonAnService loaiMonAnService;
    
    ArrayList<LoaiMonAnModel> listLoaiMonAnModel;
    LoaiMonAnModel loaiMonAnModelSelected = null;

    public QuanLyLoaiMonAnController() {
        loaiMonAnService = new LoaiMonAnServiceImpl();
        
        init();
    }
    
    private void init(){        
        view = new QuanLyLoaiMonAn_GUI();
        view.setVisible(true);
        
        loadData();
        view.loadTableLoaiMonAn(listLoaiMonAnModel);
        view.tblLoaiMonAn.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowIndex = view.tblLoaiMonAn.getSelectedRow();
                int loaiMonAnId = (int) view.tblLoaiMonAn.getValueAt(rowIndex, 0);
                
                loaiMonAnModelSelected = loaiMonAnService.getById(loaiMonAnId);
            }            
        });
    }
    
    public void show(){
        view.setVisible(true);
        view.setState(JFrame.NORMAL);
        view.toFront();
    }
    
    private void loadData(){
        listLoaiMonAnModel = (ArrayList<LoaiMonAnModel>) loaiMonAnService.getAll();
    }
    
    public void createLoaiMonAn(){
        String tenLoaiMonAn = view.txtTenLoaiMonAn.getText().trim();
        if(tenLoaiMonAn.isBlank()){
            JOptionPane.showMessageDialog(view, "Tên loại món ăn không được để trống","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        CreateLoaiMonAnModel createLoaiMonAnModel = new CreateLoaiMonAnModel(tenLoaiMonAn);
        boolean result = loaiMonAnService.create(createLoaiMonAnModel);        
        if(result){
            JOptionPane.showMessageDialog(view, "Thêm loại món ăn mới thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadData();  
            view.loadTableLoaiMonAn(listLoaiMonAnModel);
        }            
        else
            JOptionPane.showMessageDialog(view, "Thêm loại món ăn mới thất bại","Error", JOptionPane.ERROR_MESSAGE);        
    }
    
    public void deleteLoaiMonAn(){
        if(loaiMonAnModelSelected == null)
            JOptionPane.showMessageDialog(view, "Bạn chưa chọn loại món ăn muốn xóa","Error", JOptionPane.ERROR_MESSAGE);
        
        int confirm = JOptionPane.showConfirmDialog(null, 
                "Bạn có chắc chắn muốn xóa loại món ăn " + loaiMonAnModelSelected.getTen() + "  không ?", "Xóa dữ liệu món ăn!", JOptionPane.OK_CANCEL_OPTION);
        
        if(confirm == JOptionPane.CANCEL_OPTION)
            return;
        
        boolean result = loaiMonAnService.delete(loaiMonAnModelSelected.getId()); 
        if(result){
            JOptionPane.showMessageDialog(view, "Xóa loại món ăn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadData();
            view.loadTableLoaiMonAn(listLoaiMonAnModel);            
        }            
        else
            JOptionPane.showMessageDialog(view, "Xóa thất bại","Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public JButton getBtnThem(){
        return view.btnThemLoaiMonAn;
    }
    
    public JButton getBtnXoa(){
        return view.btnXoa;
    }
}
