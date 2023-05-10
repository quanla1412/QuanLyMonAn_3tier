/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.controllers;

import bll.services.IChucVuService;
import bll.services.INhanVienSerivice;
import bll.services.ITinhTrangNhanVienService;
import bll.services.impl.ChucVuServiceImpl;
import bll.services.impl.NhanVienServiceImpl;
import bll.services.impl.TinhTrangNhanVienServiceImpl;
import com.mycompany.quanlynhahang.CheckHopLe;
import gui.models.NhanVien.ChucVuModel;
import gui.models.NhanVien.CreateNhanVienModel;
import gui.models.NhanVien.NhanVienFullModel;
import gui.models.NhanVien.NhanVienModel;
import gui.models.NhanVien.TinhTrangNhanVienModel;
import gui.models.NhanVien.UpdateNhanVienModel;
import gui.views.QuanLyNhanVien_GUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhn
 */
public class QuanLyNhanVienController {
    private final INhanVienSerivice nhanVienSerivice;
    private final IChucVuService chucVuService;
    private final ITinhTrangNhanVienService tinhTrangNhanVienService;
    
    private QuanLyNhanVien_GUI view;
    
    private ArrayList<NhanVienModel> listNhanVienModel;
    private NhanVienFullModel nhanVienSelected = null;
    
    private ArrayList<TinhTrangNhanVienModel> listTinhTrangNhanVienModel;
    private TinhTrangNhanVienModel tinhTrangNhanVienSelected = null;
    
    private ArrayList<ChucVuModel> listChucVuModel;
    private ChucVuModel chucVuSelected = null;
    
    
    private boolean dangThemNhanVien = true;
    
    public QuanLyNhanVienController(){
        nhanVienSerivice = new NhanVienServiceImpl();
        chucVuService = new ChucVuServiceImpl();
        tinhTrangNhanVienService = new TinhTrangNhanVienServiceImpl();
        
        init();
    }
    
    public QuanLyNhanVien_GUI getView(){
        return view;
    }
    
    private void init(){
        view = new QuanLyNhanVien_GUI();
        view.setVisible(true);
        
        loadData();
        view.loadTableNhanVien(listNhanVienModel);
        view.loadComboBoxChucVu(listChucVuModel);
        view.loadComboBoxTinhTrangNhanVien(listTinhTrangNhanVienModel);
        
        view.btnThemNV.addActionListener(e -> changeModeNhanVien(true));
        view.btnSuaNV.addActionListener(e -> changeModeNhanVien(false));
        view.btnLuu.addActionListener(e -> saveNhanVien());
        view.btnXoaNV.addActionListener(e -> deleteNhanVien());
        view.btnResetThemNV.addActionListener(e -> resetNhanVien());
        view.btnResetTable.addActionListener(e -> resetTable());
        
        
        view.tblDanhSachNV.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int selectedRow = view.tblDanhSachNV.getSelectedRow();
                String selectedNhanVienMa = view.tblDanhSachNV.getValueAt(selectedRow, 0).toString();
                
                nhanVienSelected = nhanVienSerivice.getByMa(selectedNhanVienMa);

                if(!dangThemNhanVien)
                    loadDetailNhanVien();  
            }
        });
        
    }
    
    private void loadData(){
        listChucVuModel = (ArrayList<ChucVuModel>) chucVuService.getAll();
        listNhanVienModel = (ArrayList<NhanVienModel>) nhanVienSerivice.getAll();       
        listTinhTrangNhanVienModel = (ArrayList<TinhTrangNhanVienModel>) tinhTrangNhanVienService.getAll();
    }
    
    private void resetNhanVien(){     
        loadData();
        view.loadTableNhanVien(listNhanVienModel);   
        view.loadComboBoxChucVu(listChucVuModel);
        view.loadComboBoxTinhTrangNhanVien(listTinhTrangNhanVienModel);
        loadDetailNhanVien();
    }
    
    private void loadDetailNhanVien(){
        if(nhanVienSelected == null || dangThemNhanVien){
            view.txtMaNV.setText("");
            view.cmbThemChucVu.setSelectedIndex(-1);
            view.cmbTinhTrangNV.setSelectedIndex(-1);
            view.txtHoTenNV.setText("");
            view.txtCCCD.setText("");
            view.txtDiaChiNV.setText("");
            view.txtEmailNV.setText("");
            view.cmbGioiTinhNVThemSua.setSelectedIndex(-1);
            view.txtSDTNV.setText("");
        } else 
        {
            view.txtMaNV.setText((nhanVienSelected.getMa()));
            
            ChucVuModel chucVuModel = nhanVienSelected.getChucVu();
            int indexChucVu = listChucVuModel.indexOf(chucVuModel);
            view.cmbThemChucVu.setSelectedIndex(indexChucVu);
            
            TinhTrangNhanVienModel tinhTrangNhanVienModel = nhanVienSelected.getTinhTrangNhanVien();
            int indexTinhTrang = listTinhTrangNhanVienModel.indexOf(tinhTrangNhanVienModel);
            view.cmbTinhTrangNV.setSelectedIndex(indexTinhTrang);
            
            view.txtHoTenNV.setText(nhanVienSelected.getHoTen());
            view.txtSDTNV.setText(nhanVienSelected.getSoDienThoai());
            view.txtCCCD.setText(nhanVienSelected.getCCCD());
            view.txtEmailNV.setText(nhanVienSelected.getEmail());
            view.jdcNgaySinh.setDate(nhanVienSelected.getNgaySinh());
            view.txtDiaChiNV.setText(nhanVienSelected.getDiaChi());
            if(nhanVienSelected.isGioiTinhNam()){
                view.cmbGioiTinhNVThemSua.setSelectedIndex(0);
            }
            else
                view.cmbGioiTinhNVThemSua.setSelectedIndex(1);
        }
        
    }


    
    private void changeModeNhanVien(boolean dangThemNhanVien){
        this.dangThemNhanVien = dangThemNhanVien;
        
        view.btnThemNV.setEnabled(!dangThemNhanVien);
        view.btnSuaNV.setEnabled(dangThemNhanVien);
        
        String titlePanel = dangThemNhanVien ? "Thêm nhân viên mới" : "Sửa nhân viên";
        view.pnlThemNhanVien.setBorder(BorderFactory.createTitledBorder(titlePanel));
        view.pnlThemNhanVien.repaint();
        resetNhanVien();
        view.btnLuu.setEnabled(true);
    }
    
    private void saveNhanVien(){
        String error = validateSaveNhanVien();
        if(error.length()> 0){
            JOptionPane.showMessageDialog(view, error, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }       
        String ma = view.txtMaNV.getText().trim();
        String hoTen = view.txtHoTenNV.getText().trim();
        String diaChi = view.txtDiaChiNV.getText().trim();
        String email = view.txtEmailNV.getText().trim();
        String sdt = view.txtSDTNV.getText().trim();
        boolean gioiTinhNam = false;
        Date ngaySinh = view.jdcNgaySinh.getDate();
        String CCCD = view.txtCCCD.getText();
        
        int idChucVu = listChucVuModel.get(view.cmbThemChucVu.getSelectedIndex()).getId();
        int idTinhTrangNhanVien = listTinhTrangNhanVienModel.get(view.cmbTinhTrangNV.getSelectedIndex()).getId();
        if(dangThemNhanVien){
            CreateNhanVienModel createNhanVienModel = new CreateNhanVienModel(ma, idTinhTrangNhanVien, idChucVu, hoTen, ngaySinh, gioiTinhNam, email, sdt, diaChi, CCCD);

            boolean result = nhanVienSerivice.createNhanVien(createNhanVienModel);
            if(result){
                JOptionPane.showMessageDialog(view, "Thêm nhân viên mới thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(view, "Thêm nhân viên mới thất bại","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } 
        else {
            UpdateNhanVienModel updateNhanVienModel = new UpdateNhanVienModel (nhanVienSelected.getMa(), idTinhTrangNhanVien, idChucVu, hoTen, email, sdt, diaChi);

            boolean result = nhanVienSerivice.updateNhanVien(updateNhanVienModel);
            if(result){
                JOptionPane.showMessageDialog(view, "Sửa nhân viên thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                nhanVienSelected = nhanVienSerivice.getByMa(nhanVienSelected.getMa());
            }
            else{
                JOptionPane.showMessageDialog(view, "Sửa nhân viên thất bại","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        resetNhanVien();   
        
    }
    
    
    private String validateSaveNhanVien(){
        ArrayList<String> errorList = new ArrayList<>();
        
        if(view.cmbThemChucVu.getSelectedIndex() < 0)
            errorList.add("Không được để trống chức vụ");
        if(view.cmbTinhTrangNV.getSelectedIndex() < 0)
            errorList.add("Không được để trống tình trạng nhân viên");
        
        String ma = view.txtMaNV.getText().trim();
        if(ma.isBlank())
            errorList.add("Mã nhân viên không được để trống");

        String hoTen = view.txtHoTenNV.getText().trim();
        if(hoTen.isBlank())
        errorList.add("Họ tên nhân viên không được để trống");


        String diaChi = view.txtDiaChiNV.getText().trim();
        if(diaChi.isBlank())
         errorList.add("Địa chỉ nhân viên không được để trống");


        String email = view.txtEmailNV.getText().trim();
        if(!CheckHopLe.checkEmail(email)){
            errorList.add("Email không hợp lệ");
        }

        String sdt = view.txtSDTNV.getText().trim();
        if(!CheckHopLe.checkSoDienThoai(sdt)){
            errorList.add("Số điện thoại không hợp lệ");
        }

        boolean gioiTinhNam = false;
        if (view.cmbGioiTinhNVThemSua.getSelectedIndex() == 0){
            gioiTinhNam = true;
        }

        Date ngaySinh = view.jdcNgaySinh.getDate();
        int tuoi = Period.between(ngaySinh.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
        if(tuoi < 18){
           errorList.add("Nhân viên phải từ 18 tuổi trở lên");
        }

        String CCCD = view.txtCCCD.getText();
        if(!CheckHopLe.checkCCCD(CCCD)){
           errorList.add( "CCCD sai định dạng");

        }
        
        String error = String.join("\n", errorList);        
        return error;
    }
    
    private void deleteNhanVien(){
        if(nhanVienSelected == null)
            JOptionPane.showMessageDialog(view, "Bạn chưa chọn nhân viên muốn xóa","Error", JOptionPane.ERROR_MESSAGE);
        
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên \"" + nhanVienSelected.getMa()+ "\" không ?", "Xóa dữ liệu nhân viên!", JOptionPane.OK_CANCEL_OPTION);

        if(confirm == JOptionPane.CANCEL_OPTION)
            return;
        
        boolean result = nhanVienSerivice.delete(nhanVienSelected.getMa());
        if(result){
                JOptionPane.showMessageDialog(view, "Xóa nhân viên thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                nhanVienSelected = null;
        } else
            JOptionPane.showMessageDialog(view, "Xóa thất bại","Error", JOptionPane.ERROR_MESSAGE);
        resetNhanVien();
    }
    
    private void resetTable(){
        view.loadTableNhanVien(listNhanVienModel);
    }
    
}
