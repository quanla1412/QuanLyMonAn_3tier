/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.controllers;

import gui.models.KhachHang.CreateKhachHangModel;
import bll.services.IKhachHangService;
import bll.services.ILoaiKhachHangService;
import bll.services.impl.KhachHangServiceImpl;
import bll.services.impl.LoaiKhachHangServiceImpl;
import com.mycompany.quanlynhahang.CheckHopLe;
import gui.models.KhachHang.KhachHangFullModel;
import gui.models.KhachHang.KhachHangModel;
import gui.models.LoaiKhachHang.LoaiKhachHangModel;
import gui.views.QuanLyKhachHang_GUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.time.Period;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author tuant
 */
public class QuanLyKhachHangController {
    private final IKhachHangService khachHangService;
    private final ILoaiKhachHangService loaiKhachHangService;
    
    private QuanLyKhachHang_GUI view;
    private boolean dangThemKhachHang = true;
    private KhachHangFullModel khachHangSelected = null;
    public ArrayList<KhachHangModel> listKhachHangModel;
    public ArrayList<LoaiKhachHangModel> listLoaiKhachHangModel;

    public QuanLyKhachHangController() {
        khachHangService = new KhachHangServiceImpl();
        loaiKhachHangService = new LoaiKhachHangServiceImpl();
        
        init();
    }
    
    public JComponent getView(){
        return view;
    }
    
    private void init(){
        view = new QuanLyKhachHang_GUI();
        view.setVisible(true);
        
        loadData();
        view.loadTableKhachHang(listKhachHangModel);
        view.loadComboBoxTimKiemLoaiKH(listLoaiKhachHangModel);
        view.loadComboBoxThemSuaLoaiKH(listLoaiKhachHangModel);
        view.btnThem.addActionListener(e -> changeModeKhachHang(true));
        view.btnSua.addActionListener(e -> changeModeKhachHang(false));
        view.btnLuu.addActionListener(e -> luuKhachHang());
        view.btnReset.addActionListener(e -> resetKhachHang());
        view.tblKhachHang.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int selectedRow = view.tblKhachHang.getSelectedRow();
                int selectedLoaiKHId = (int) view.tblKhachHang.getValueAt(selectedRow, 0);
                
                khachHangSelected = khachHangService.getById(selectedLoaiKHId);

                if(!dangThemKhachHang)
                    loadDetailKhachHang();  
            }
        });
    }
    
    private void loadData(){
        listKhachHangModel = (ArrayList<KhachHangModel>) khachHangService.getAll();
        listLoaiKhachHangModel = (ArrayList<LoaiKhachHangModel>) loaiKhachHangService.getAll();
    }
    private void changeModeKhachHang(boolean dangThemKhachHang){        
        this.dangThemKhachHang = dangThemKhachHang;
        
        view.btnThem.setEnabled(!dangThemKhachHang);
        view.btnSua.setEnabled(dangThemKhachHang);
        
        String titlePanel = dangThemKhachHang ? "Thêm loại khách hàng mới" : "Sửa loại khách hàng";
        view.pnlThemSuaKhachHang.setBorder(BorderFactory.createTitledBorder(titlePanel));
        view.pnlThemSuaKhachHang.repaint();
        resetKhachHang();
    }
    private void resetKhachHang(){     
        loadData();
        view.loadTableKhachHang(listKhachHangModel);
        loadDetailKhachHang();  
    }
    private void loadDetailKhachHang(){
        if(khachHangSelected == null || dangThemKhachHang){
            view.txtIDKH.setText("");
            view.cmbThemSuaLoaiKH.setSelectedIndex(-1);
            view.txtHoTen.setText("");
            view.txtSDT.setText("");
            view.txtDiemTichLuy.setText("");
            view.txtEmail.setText("");
            view.cmbGioiTinhKH.setSelectedIndex(-1);
        } else {
            view.txtIDKH.setText(Integer.toString(khachHangSelected.getId()));
            LoaiKhachHangModel loaiKhachHangModel = khachHangSelected.getLoaiKhachHang();
            int indexKhachHang = listLoaiKhachHangModel.indexOf(loaiKhachHangModel);
            view.cmbThemSuaLoaiKH.setSelectedIndex(indexKhachHang);
            view.txtHoTen.setText(khachHangSelected.getTen());
            view.txtSDT.setText(khachHangSelected.getSdt());
            view.txtDiemTichLuy.setText(Integer.toString(khachHangSelected.getDiemTichLuy()));
            view.txtEmail.setText(khachHangSelected.getEmail());
            view.jdcNgaySinh.setDate(khachHangSelected.getNgaySinh());
            if(khachHangSelected.isGioiTinhNam()){
                view.cmbGioiTinhKH.setSelectedIndex(0);
            }
            else
                view.cmbGioiTinhKH.setSelectedIndex(1);
            
        }                  
    }
    private void luuKhachHang(){
        String error = kiemtraLuuKhachHang();
        if(error.length()> 0){
            JOptionPane.showMessageDialog(view, error,"Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String tenKhachHang = view.txtHoTen.getText().trim();
        int idLoaiKhachHang = listLoaiKhachHangModel.get(view.cmbThemSuaLoaiKH.getSelectedIndex()).getId();
        String soDienThoai  =  view.txtSDT.getText().trim();
        String email  =  view.txtEmail.getText().trim();
        int diemTichLuy = Integer.parseInt( view.txtDiemTichLuy.getText());
        boolean gioiTinhNam = false;
        if(view.cmbGioiTinhKH.getSelectedIndex()==1){
            gioiTinhNam = true;
        }
        
        if(dangThemKhachHang){
            CreateKhachHangModel createKhachHangModel = new CreateKhachHangModel(tenLoaiKhachHang, diemToiThieu, mucUuDai);

            boolean result = loaiKhachHangService.createLoaiKhachHang(createLoaiKhachHangModel);
            if(result){
                JOptionPane.showMessageDialog(view, "Thêm loại khách hàng mới thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(view, "Thêm loại khách hàng mới thất bại","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } 
        else {
            UpdateLoaiKhachHangModel updateLoaiKhachHangModel = new UpdateLoaiKhachHangModel(loaiKhachHangSelected.getId(), tenLoaiKhachHang, diemToiThieu, mucUuDai);

            boolean result = loaiKhachHangService.updateLoaiKhachHang(updateLoaiKhachHangModel);
            if(result){
                JOptionPane.showMessageDialog(view, "Sửa loại khách hàng thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loaiKhachHangSelected = loaiKhachHangService.getById(loaiKhachHangSelected.getId());
            }
            else{
                JOptionPane.showMessageDialog(view, "Sửa loại khách hàng thất bại","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        resetKhachHang();      
    }
    private String kiemtraLuuKhachHang(){
        ArrayList<String> errorList = new ArrayList<>();
        
        if(view.txtHoTen.getText().isBlank())
            errorList.add("Họ tên không được để trống");
        String sdt = view.txtSDT.getText().trim();
        if(!CheckHopLe.checkSoDienThoai(sdt)){
            errorList.add("Số điện thoại không hợp lệ");
        }
        Timestamp ngaySinh;
        ngaySinh = new Timestamp(view.jdcNgaySinh.getDate().getTime());
        int tuoi = Period.between(ngaySinh.toLocalDateTime().toLocalDate(), LocalDate.now()).getYears();
        if(tuoi < 18){
            errorList.add("Khách hàng phải từ 18 tuổi trở lên");
        }
        String email = view.txtEmail.getText().trim();
        if(!CheckHopLe.checkEmail(email)){
            errorList.add("Email không hợp lệ");
        }
        String error = String.join("\n", errorList);
        
        return error;
    }
}