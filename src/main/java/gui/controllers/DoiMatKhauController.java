/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.controllers;

import bll.services.INhanVienService;
import bll.services.impl.NhanVienServiceImpl;
import gui.models.NhanVien.NhanVienFullModel;
import gui.models.NhanVien.UpdateTaiKhoanNhanVienModel;
import gui.views.DoiMatKhau_GUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhn
 */
public class DoiMatKhauController {
     private final INhanVienService nhanVienService;
     private String maNhanVien;
     private DoiMatKhau_GUI view;
     
    public DoiMatKhauController(String maNhanVien){
        nhanVienService = new NhanVienServiceImpl();
       this.maNhanVien = maNhanVien;
        
        init();
    }
    
    public DoiMatKhau_GUI getView(){
        return view;
    } 
    
    public void init (){
        view = new DoiMatKhau_GUI();
        view.setVisible(true);
        
        view.btnSuccess.addActionListener(e -> doiMatKhau());
    }
    
    public void show(String maNhanVien){
        this.maNhanVien = maNhanVien;
        view.txtPassword.setText("");
        view.txtRetypePassword.setText("");
        
        view.setVisible(true);
        view.setState(JFrame.NORMAL);
        view.toFront();
    }
    
    private void doiMatKhau(){
        String password = new String(view.txtPassword.getPassword());
        String retypePassword = new String(view.txtRetypePassword.getPassword());
        if (password.isBlank())
        {
             JOptionPane.showMessageDialog(view, "Mật khẩu không được để trống","Error", JOptionPane.ERROR_MESSAGE);
             return;
        } 
        if (retypePassword.isBlank())
        {
             JOptionPane.showMessageDialog(view, "Nhập lại mật khẩu không được để trống","Error", JOptionPane.ERROR_MESSAGE);
             return;
        } 
        
        if(password.equals(retypePassword)){
          UpdateTaiKhoanNhanVienModel updateMatKhauNhanVienModel = new UpdateTaiKhoanNhanVienModel(maNhanVien, password);
          
                boolean result = nhanVienService.updateTaiKhoanNhanVien(updateMatKhauNhanVienModel);
                if(result){
                    JOptionPane.showMessageDialog(view, "Đổi mật khẩu thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    view.dispose();
                }            
                else
                    JOptionPane.showMessageDialog(view, "Đổi mật khẩu thất bại","Error", JOptionPane.ERROR_MESSAGE);
            } 
                else
                    JOptionPane.showMessageDialog(view, "Nhập lại mật khẩu không đúng","Error", JOptionPane.ERROR_MESSAGE);

    }
   
     
}
