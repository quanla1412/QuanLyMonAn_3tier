/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.controllers;

import bll.services.IChucVuService;
import bll.services.impl.ChucVuServiceImpl;
import gui.models.NhanVien.ChucVuModel;
import gui.models.NhanVien.CreateChucVuModel;
import gui.models.NhanVien.UpdateChucVuModel;
import gui.views.QuanLyChucVu_GUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhn
 */
public class QuanLyChucVuController {
    private final IChucVuService chucVuService;
    
    private QuanLyChucVu_GUI view;
    
    private ChucVuModel chucVuSelected = null;
    public ArrayList<ChucVuModel> listChucVuModel; 
    private boolean dangThemChucVu = true;
    
    
    public QuanLyChucVuController(){
        chucVuService = new ChucVuServiceImpl();
        
        init();
    }
    
    public QuanLyChucVu_GUI getView() {
        return view;
    }
 
    public void init(){
        view = new QuanLyChucVu_GUI();
        view.setVisible(true);
        loadData();
        view.loadTableChucVu(listChucVuModel);
        
        view.btnThemChucVu.addActionListener(e -> changeModeChucVu(true));
        view.btnSuaChucVu.addActionListener(e -> changeModeChucVu(false));
        view.btnLuuChucVu.addActionListener(e -> saveChucVu());
        view.btnXoaChucVu.addActionListener(e -> deleteChucVu());
        view.btnResetChucVu.addActionListener(e ->resetChucVu());
        view.tblDanhSachChucVu.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int selectedRow = view.tblDanhSachChucVu.getSelectedRow();
                int selectedChucVuId = (int) view.tblDanhSachChucVu.getValueAt(selectedRow, 0);
                
                chucVuSelected = chucVuService.getById(selectedChucVuId);

                if(!dangThemChucVu)
                    loadDetailChucVu();  
            }
        });
        
    }
    
    private void loadData(){
        listChucVuModel = (ArrayList<ChucVuModel>) chucVuService.getAll();
    }

    private void saveChucVu(){
        String error = validateSaveChucVu();
        if(error.length()> 0){
            JOptionPane.showMessageDialog(view, error,"Error", JOptionPane.ERROR_MESSAGE);
            return;
        }       
        
        String tenChucVu = view.txtChucVu.getText().trim();
        if(dangThemChucVu){
            CreateChucVuModel createChucVuModel = new CreateChucVuModel(tenChucVu);

            boolean result = chucVuService.createChucVu(createChucVuModel);
            if(result){
                JOptionPane.showMessageDialog(view, "Thêm chức vụ mới thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(view, "Thêm chức vụ mới thất bại","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } 
        else {
            UpdateChucVuModel updateChucVuModel = new UpdateChucVuModel(chucVuSelected.getId(), tenChucVu);

            boolean result = chucVuService.updateChucVu(updateChucVuModel);
            if(result){
                JOptionPane.showMessageDialog(view, "Sửa chức vụ thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                chucVuSelected = chucVuService.getById(chucVuSelected.getId());
            }
            else{
                JOptionPane.showMessageDialog(view, "Sửa chức vụ thất bại","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        resetChucVu();      
    }
    
   
     private String validateSaveChucVu(){
        ArrayList<String> errorList = new ArrayList<>();
        
        if(view.txtChucVu.getText().isBlank())
            errorList.add("Tên chức vụ không được để trống");
           
        String error = String.join("\n", errorList);
        
        return error;
    }
    
  
     private void resetChucVu(){     
        loadData();
        view.loadTableChucVu(listChucVuModel);   
        loadDetailChucVu();
    }
    
    private void loadDetailChucVu(){
        if(chucVuSelected == null || dangThemChucVu){
            view.txtIDChucVu.setText("");
            view.txtChucVu.setText("");             
        } else {
            view.txtIDChucVu.setText(Integer.toString(chucVuSelected.getId()));
            view.txtChucVu.setText(chucVuSelected.getTen());             
        }                  
    }
 
     private void changeModeChucVu(boolean dangThemChucVu){        
        this.dangThemChucVu = dangThemChucVu;
        
        view.btnThemChucVu.setEnabled(!dangThemChucVu);
        view.btnSuaChucVu.setEnabled(dangThemChucVu);
        
        String titlePanel = dangThemChucVu ? "Thêm chức vụ mới" : "Sửa chức vụ";
        view.pnlThemSuaChucVu.setBorder(BorderFactory.createTitledBorder(titlePanel));
        view.pnlThemSuaChucVu.repaint();
        resetChucVu();
    }
    
     
     private void deleteChucVu(){
        if(chucVuSelected == null)
            JOptionPane.showMessageDialog(view, "Bạn chưa chọn chức vụ muốn xóa","Error", JOptionPane.ERROR_MESSAGE);
        
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa chức vụ \"" + chucVuSelected.getTen() + "\" không ?", "Xóa dữ liệu chức vụ!", JOptionPane.OK_CANCEL_OPTION);

        if(confirm == JOptionPane.CANCEL_OPTION)
            return;
        
        boolean result = chucVuService.deleteChucVu(chucVuSelected.getId());
        if(result){
                JOptionPane.showMessageDialog(view, "Xóa chức vụ thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                chucVuSelected = null;
        } else
            JOptionPane.showMessageDialog(view, "Xóa thất bại","Error", JOptionPane.ERROR_MESSAGE);
        resetChucVu();
    }
}
