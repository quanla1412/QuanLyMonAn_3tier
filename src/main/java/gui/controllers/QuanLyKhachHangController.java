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
import gui.constraints.GioiTinhConstraints;
import gui.models.KhachHang.KhachHangFullModel;
import gui.models.KhachHang.KhachHangModel;
import gui.models.KhachHang.SearchKhachHangModel;
import gui.models.KhachHang.UpdateKhachHangModel;
import gui.models.LoaiKhachHang.LoaiKhachHangModel;
import gui.views.QuanLyKhachHang_GUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import gui.controllers.QuanLyLoaiKhachHangController;

/**
 *
 * @author tuant
 */
public class QuanLyKhachHangController {
    private final IKhachHangService khachHangService;
    private final ILoaiKhachHangService loaiKhachHangService;
    
    private QuanLyLoaiKhachHangController quanLyLoaiKhachHangController;
    
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
    
    public QuanLyKhachHang_GUI getView(){
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
        view.btnReset.addActionListener(e -> resetKhachHangForm());
        view.btnResetTable.addActionListener(e -> resetTable());
        view.btnTimKiem.addActionListener(e -> searchKhachHang());
        
        view.btnExport.addActionListener(e -> exportKhachHang());
        view.btnExportMauImport.addActionListener(e -> exportAllKhachHangTheoMauImport());
        view.btnImport.addActionListener(e -> importNhanVien());
        view.btnQLLKH.addActionListener(e -> loadLoaiKhachHang());
        
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
    
    private void exportKhachHang(){
         boolean result = false;
        JFileChooser jFileChooser = new JFileChooser("D:");
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (jFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            result = khachHangService.exportKhachHang(listKhachHangModel, jFileChooser.getSelectedFile().getAbsolutePath());
        }

        if (!result) {
            JOptionPane.showMessageDialog(view, "Xuất file excel thất bại","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void exportAllKhachHangTheoMauImport(){
          boolean result = false;

        JFileChooser jFileChooser = new JFileChooser("D:");
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (jFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            result = khachHangService.exportAllKhachHangTheoMauImport(jFileChooser.getSelectedFile().getAbsolutePath());
        }

        if (!result) {
            JOptionPane.showMessageDialog(view, "Export file excel thất bại","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void importNhanVien (){
         int totalSuccess = 0;

        JFileChooser jFileChooser = new JFileChooser("D:");
        if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            totalSuccess = khachHangService.importKhachHang(jFileChooser.getSelectedFile().getAbsolutePath());

            JOptionPane.showMessageDialog(view, "Cập nhật " + totalSuccess + " khách hàng","Import danh sách nhân viên", JOptionPane.INFORMATION_MESSAGE);

            loadData();
        }else {
            JOptionPane.showMessageDialog(view, "Import file excel thất bại","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    private void loadData(){
        listKhachHangModel = (ArrayList<KhachHangModel>) khachHangService.getAll();
        listLoaiKhachHangModel = (ArrayList<LoaiKhachHangModel>) loaiKhachHangService.getAll();
        
    }
    private void changeModeKhachHang(boolean dangThemKhachHang){        
        this.dangThemKhachHang = dangThemKhachHang;
        view.txtHoTen.setEnabled(dangThemKhachHang);
        view.jdcNgaySinh.setEnabled(dangThemKhachHang);
        view.btnThem.setEnabled(!dangThemKhachHang);
        view.btnSua.setEnabled(dangThemKhachHang);
        
        String titlePanel = dangThemKhachHang ? "Thêm loại khách hàng mới" : "Sửa loại khách hàng";
        view.pnlThemSuaKhachHang.setBorder(BorderFactory.createTitledBorder(titlePanel));
        view.pnlThemSuaKhachHang.repaint();
        resetKhachHangForm();
    }
    private void resetKhachHangForm(){
        loadData();
        view.loadTableKhachHang(listKhachHangModel);
        view.loadComboBoxTimKiemLoaiKH(listLoaiKhachHangModel);
        view.loadComboBoxThemSuaLoaiKH(listLoaiKhachHangModel);
        loadDetailKhachHang();  
    }
    
    public void reset(){
        resetTable();
        resetKhachHangForm();
    }
    
    private void resetTable(){
        loadData();
        view.loadTableKhachHang(listKhachHangModel);
        
        view.txtSearchIdName.setText("");
        view.cmbTimKiemGioiTinh.setSelectedIndex(0);
        view.cmbTimKiemGioiTinh.setSelectedIndex(0);
        view.txtTimKiemSDT.setText("");
    }
    
    private void loadDetailKhachHang(){
        if(khachHangSelected == null || dangThemKhachHang){
            view.txtIDKH.setText("");
            view.txtHoTen.setText("");
            view.txtSDT.setText("");
            view.txtEmail.setText("");
            view.txtDiemTichLuy.setText("0");
            view.cmbGioiTinhKH.setSelectedIndex(-1);
            view.cmbThemSuaLoaiKH.setSelectedIndex(-1);
            Date now = new Date();
            view.jdcNgaySinh.setDate(now);
        } else {
            view.txtIDKH.setText(Integer.toString(khachHangSelected.getId()));
            LoaiKhachHangModel loaiKhachHangModel = khachHangSelected.getLoaiKhachHang();
            int indexKhachHang = listLoaiKhachHangModel.indexOf(loaiKhachHangModel);
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
            
            view.cmbThemSuaLoaiKH.setSelectedIndex(indexKhachHang);
        }                  
    }
    private void luuKhachHang(){
        String error = kiemtraLuuKhachHang();
        if(error.length()> 0){
            JOptionPane.showMessageDialog(view, error,"Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String tenKhachHang = view.txtHoTen.getText().trim();
        String soDienThoai  =  view.txtSDT.getText().trim();
        String email  =  view.txtEmail.getText().trim();
        boolean gioiTinhNam = true;
        if(view.cmbGioiTinhKH.getSelectedIndex()==1){
            gioiTinhNam = false;
        }
        Timestamp ngaySinh;
        ngaySinh = new Timestamp(view.jdcNgaySinh.getDate().getTime());
        
        if(dangThemKhachHang){
            CreateKhachHangModel createKhachHangModel = new CreateKhachHangModel(tenKhachHang, soDienThoai, email, ngaySinh, gioiTinhNam);

            boolean result = khachHangService.createKhachHang(createKhachHangModel);
            if(result){
                JOptionPane.showMessageDialog(view, "Thêm khách hàng mới thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loadData();
            }
            else{
                JOptionPane.showMessageDialog(view, "Thêm khách hàng mới thất bại","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } 
        else {
            UpdateKhachHangModel updateKhachHangModel = new UpdateKhachHangModel(khachHangSelected.getId(), tenKhachHang, soDienThoai, email, ngaySinh, gioiTinhNam);

            boolean result = khachHangService.updateKhachHang(updateKhachHangModel);
            if(result){
                JOptionPane.showMessageDialog(view, "Sửa khách hàng thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                khachHangSelected = khachHangService.getById(khachHangSelected.getId());
                loadData();
            }
            else{
                JOptionPane.showMessageDialog(view, "Sửa khách hàng thất bại","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        resetKhachHangForm();      
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
    
    private void searchKhachHang(){
        SearchKhachHangModel searchKhachHangModel = new SearchKhachHangModel();
        
        String idOrName = view.txtSearchIdName.getText().trim();
        if(!idOrName.isBlank()){
            searchKhachHangModel.setIdOrName(idOrName);
        }
        String sdt = view.txtTimKiemSDT.getText().trim();
        if(!sdt.isBlank()){
            searchKhachHangModel.setSdt(sdt);
        }
        int idKhachHang = view.cmbTimKiemLoaiKH.getSelectedIndex();
        if(idKhachHang > 0){
            searchKhachHangModel.setIdLoaiKhachHang(listLoaiKhachHangModel.get(idKhachHang - 1).getId());
        }
        int gioiTinh;
        gioiTinh = switch (view.cmbTimKiemGioiTinh.getSelectedIndex()) {
            case 1 -> GioiTinhConstraints.NAM;
            case 2 -> GioiTinhConstraints.NU;
            default -> GioiTinhConstraints.TAT_CA;
        };
        searchKhachHangModel.setGioiTinh(gioiTinh);
        
        listKhachHangModel = (ArrayList<KhachHangModel>) khachHangService.search(searchKhachHangModel);
        view.loadTableKhachHang(listKhachHangModel);
    }
    
    private void loadLoaiKhachHang(){
        if(quanLyLoaiKhachHangController == null){
            quanLyLoaiKhachHangController = new QuanLyLoaiKhachHangController();
        } else {
            quanLyLoaiKhachHangController.show();
        }
        
    }
}
