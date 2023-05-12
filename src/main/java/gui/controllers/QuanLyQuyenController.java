package gui.controllers;

import bll.services.INhanVienService;
import bll.services.IQuyenTaiKhoanService;
import bll.services.impl.NhanVienServiceImpl;
import bll.services.impl.QuyenTaiKhoanServiceImpl;
import gui.constraints.ChucNangConstraints;
import gui.models.NhanVien.NhanVienFullModel;
import gui.models.NhanVien.NhanVienModel;
import gui.models.TaiKhoan.QuyenTaiKhoanModel;
import gui.models.TaiKhoan.UpdateQuyenTaiKhoanModel;
import gui.views.QuanLyQuyen_GUI;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author LeAnhQuan
 */
public class QuanLyQuyenController {
    private QuanLyQuyen_GUI view;
    
    private INhanVienService nhanVienService;
    private IQuyenTaiKhoanService quyenTaiKhoanService;
    
    private String maNhanVien;
    private NhanVienFullModel nhanVienFullModel;
    private QuyenTaiKhoanModel quyenTaiKhoanModel;

    public QuanLyQuyenController(String maNhanVien) {
        this.maNhanVien = maNhanVien;
        nhanVienService = new NhanVienServiceImpl();
        quyenTaiKhoanService = new QuyenTaiKhoanServiceImpl();
        
        init();
    }
    
    private void init(){
        view = new QuanLyQuyen_GUI();
        view.setVisible(true);
        
        loadThongTin();
        
        view.btnReset.addActionListener(e -> loadThongTin());
        view.btnSave.addActionListener(e -> save());
    }

    void show(String maNhanVien) {
        this.maNhanVien = maNhanVien;
        
        view.setVisible(true);
        view.setState(JFrame.NORMAL);
        view.toFront();
        
        loadThongTin();
    }
    
    private void loadData(){
        nhanVienFullModel = nhanVienService.getByMa(maNhanVien);
        quyenTaiKhoanModel = quyenTaiKhoanService.getByUsername(nhanVienFullModel.getMa());
    }
    
    private void loadThongTin(){
        loadData();
        
        view.txtMa.setText(nhanVienFullModel.getMa());
        view.txtTen.setText(nhanVienFullModel.getHoTen());
        view.txtChucVu.setText(nhanVienFullModel.getChucVu().getTen());
        
        view.chkQuanLyPhucVu.setSelected(false);
        view.chkQuanLyBan.setSelected(false);
        view.chkQuanLyMonAn.setSelected(false);
        view.chkQuanLyHoaDon.setSelected(false);
        view.chkQuanLyNhanVien.setSelected(false);
        view.chkQuanLyKhachHang.setSelected(false);
        view.chkQuanLyTaiKhoan.setSelected(false);
        view.chkBaoCaoThongKe.setSelected(false);
        
        if (quyenTaiKhoanModel != null)  
            for(int chucNang : quyenTaiKhoanModel.getListChucNang()){
                switch (chucNang) {
                    case ChucNangConstraints.QUAN_LY_PHUC_VU -> view.chkQuanLyPhucVu.setSelected(true);
                    case ChucNangConstraints.QUAN_LY_BAN -> view.chkQuanLyBan.setSelected(true);
                    case ChucNangConstraints.QUAN_LY_MON_AN -> view.chkQuanLyMonAn.setSelected(true);
                    case ChucNangConstraints.QUAN_LY_HOA_DON -> view.chkQuanLyHoaDon.setSelected(true);
                    case ChucNangConstraints.QUAN_LY_NHAN_VIEN -> view.chkQuanLyNhanVien.setSelected(true);
                    case ChucNangConstraints.QUAN_LY_KHACH_HANG -> view.chkQuanLyKhachHang.setSelected(true);
                    case ChucNangConstraints.QUAN_LY_TAI_KHOAN -> view.chkQuanLyTaiKhoan.setSelected(true);
                    case ChucNangConstraints.QUAN_LY_THONG_KE -> view.chkBaoCaoThongKe.setSelected(true);
                }
            }
    }
    
    private void save(){
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(ChucNangConstraints.QUAN_LY_PHUC_VU, view.chkQuanLyPhucVu.isSelected());
        map.put(ChucNangConstraints.QUAN_LY_BAN, view.chkQuanLyBan.isSelected());
        map.put(ChucNangConstraints.QUAN_LY_MON_AN, view.chkQuanLyMonAn.isSelected());
        map.put(ChucNangConstraints.QUAN_LY_HOA_DON, view.chkQuanLyHoaDon.isSelected());
        map.put(ChucNangConstraints.QUAN_LY_NHAN_VIEN, view.chkQuanLyNhanVien.isSelected());
        map.put(ChucNangConstraints.QUAN_LY_KHACH_HANG, view.chkQuanLyKhachHang.isSelected());
        map.put(ChucNangConstraints.QUAN_LY_TAI_KHOAN, view.chkQuanLyTaiKhoan.isSelected());
        map.put(ChucNangConstraints.QUAN_LY_THONG_KE, view.chkBaoCaoThongKe.isSelected());
        
        UpdateQuyenTaiKhoanModel updateQuyenTaiKhoanModel = new UpdateQuyenTaiKhoanModel(nhanVienFullModel.getMa(), map);
        boolean result = quyenTaiKhoanService.save(updateQuyenTaiKhoanModel);
        if(result){
            JOptionPane.showMessageDialog(view, "Sửa quyền thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }            
        else
            JOptionPane.showMessageDialog(view, "Sửa quyền thất bại","Error", JOptionPane.ERROR_MESSAGE);
    }
}
