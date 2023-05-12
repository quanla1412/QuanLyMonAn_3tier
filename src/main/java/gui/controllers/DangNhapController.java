/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.controllers;

import bll.services.INhanVienService;
import bll.services.impl.NhanVienServiceImpl;
import gui.models.TaiKhoanModel;
import gui.views.DangNhap_GUI;
import gui.views.TrangChu_GUI;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhn
 */
public class DangNhapController {
    private final INhanVienService nhanVienService;
    private DangNhap_GUI view;
    

    public DangNhapController(){
    nhanVienService = new NhanVienServiceImpl();
     init();
    }

     public DangNhap_GUI getView(){
        return view;
    } 
     
    public void init (){
        view = new DangNhap_GUI();
        view.setVisible(true);
        
        view.btnDangNhap.addActionListener(e -> logIn());
    }
    
    
    private void logIn (){
        String username = view.txtTaiKhoan.getText().trim();
        String password = new String(view.txtMatKhau.getPassword());
        
        TaiKhoanModel taiKhoanModel = new TaiKhoanModel(username, password);
        
        if(nhanVienService.dangNhap(taiKhoanModel)){
            TrangChuController trangChu_GUI = new TrangChuController(username);
            view.dispose();
        } else {
            JOptionPane.showMessageDialog(view, "Đăng nhập thất bại","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
}
