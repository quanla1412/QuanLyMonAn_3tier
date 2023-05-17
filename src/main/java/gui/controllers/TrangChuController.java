package gui.controllers;

import bll.services.INhanVienService;
import bll.services.impl.NhanVienServiceImpl;
import gui.models.NhanVien.NhanVienFullModel;
import gui.views.TrangChu_GUI;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 *
 * @author LeAnhQuan
 */
public class TrangChuController {
    private TrangChu_GUI view;
    
    private final INhanVienService nhanVienService;
    
    private QuanLyPhucVuController quanLyPhucVuController = null;
    private QuanLyLoaiBanVaBanController quanLyLoaiBanVaBanController = null;
    private QuanLyMonAnController quanLyMonAnController = null;
    private QuanLyHoaDonController quanLyHoaDonController = null;
    private QuanLyNhanVienController quanLyNhanVienController = null;
    private QuanLyKhachHangController quanLyKhachHangController = null;
    private BaoCaoThongKeController baoCaoThongKeController = null;
    
    NhanVienFullModel nhanVienFullModel = null;
    JButton btnSelected = null;
    
    Color choosesColor = new java.awt.Color(0,0,0,100);
    Color unChoosedColor =  new java.awt.Color(0,0,0,0);
    
    public TrangChuController(String maNhanVien){
        nhanVienService = new NhanVienServiceImpl();
        nhanVienFullModel = nhanVienService.getByMa(maNhanVien);
        
        init();
        showFormQuanLyPhucVu();
    }
    
    private void init(){
        view = new TrangChu_GUI();
        view.setVisible(true);
        
        view.btnQuanLyPhucVu.addActionListener(e -> showFormQuanLyPhucVu());
        view.btnQuanLyBan.addActionListener(e -> showFormQuanLyBan());
        view.btnQuanLyMonAn.addActionListener(e -> showFormQuanLyMonAn());
        view.btnQuanLyHoaDon.addActionListener(e -> showFormQuanLyHoaDon());
        view.btnQuanLyNhanVien.addActionListener(e -> showFormQuanLyNhanVien());
        view.btnQuanLyKhachHang.addActionListener(e -> showFormQuanLyKhachHang());
        view.btnBaoCaoThongKe.addActionListener(e -> showBaoCaoThongKe());
        
        view.lblTenNhanVien.setText(nhanVienFullModel.getHoTen());
        
        view.btnDangXuat.addActionListener(e -> logout());
    }
    
    private void showForm(JComponent com){
        view.pnlForm.removeAll();
        view.pnlForm.add(com);
        view.pnlForm.repaint();
        view.pnlForm.revalidate();
    }
    
    private void showFormQuanLyPhucVu(){
        if(quanLyPhucVuController == null)
            quanLyPhucVuController = new QuanLyPhucVuController(nhanVienFullModel.getMa()); 
        
        changeButtonChoosed(view.btnQuanLyPhucVu);
        showForm(quanLyPhucVuController.getView());
    }
    
    private void showFormQuanLyBan(){
        if(quanLyLoaiBanVaBanController == null){
            quanLyLoaiBanVaBanController = new QuanLyLoaiBanVaBanController();
            
            quanLyLoaiBanVaBanController.getBtnLuuBan()
                    .addActionListener(e -> {
                        quanLyLoaiBanVaBanController.saveBan();
                        quanLyPhucVuController.reset();
                    });
            
            quanLyLoaiBanVaBanController.getBtnXoaBan()
                    .addActionListener(e -> {
                        quanLyLoaiBanVaBanController.deleteBan();
                        quanLyPhucVuController.reset();                        
                    });
        }
        
        changeButtonChoosed(view.btnQuanLyBan);
        showForm(quanLyLoaiBanVaBanController.getView());
    }
    
    private void showFormQuanLyMonAn(){
        if(quanLyMonAnController == null)
            quanLyMonAnController = new QuanLyMonAnController();
        
        changeButtonChoosed(view.btnQuanLyMonAn);
        showForm(quanLyMonAnController.getView());
    }
    
    private void showFormQuanLyHoaDon(){
        if(quanLyHoaDonController == null){
            quanLyHoaDonController = new QuanLyHoaDonController();            
            quanLyHoaDonController.getBtnHuyHoaDon()
                .addActionListener(e -> {
                    quanLyHoaDonController.huyHoaDon();
                    if(quanLyKhachHangController != null)
                        quanLyKhachHangController.reset();
                });
        }
        
        changeButtonChoosed(view.btnQuanLyHoaDon);
        showForm(quanLyHoaDonController.getView());
    }
    
    private void showFormQuanLyNhanVien(){
        if(quanLyNhanVienController == null)
            quanLyNhanVienController = new QuanLyNhanVienController();
        
        changeButtonChoosed(view.btnQuanLyNhanVien);
        showForm(quanLyNhanVienController.getView());
    }
    
    private void showFormQuanLyKhachHang(){
        if(quanLyKhachHangController == null)
            quanLyKhachHangController = new QuanLyKhachHangController();
        
        changeButtonChoosed(view.btnQuanLyKhachHang);
        showForm(quanLyKhachHangController.getView());
    }
    
    private void showBaoCaoThongKe(){
        if(baoCaoThongKeController == null)
            baoCaoThongKeController = new BaoCaoThongKeController();
        
        changeButtonChoosed(view.btnBaoCaoThongKe);
        showForm(baoCaoThongKeController.getView());
    }
    
    private void changeButtonChoosed(JButton btnNew){
        if(btnSelected != null)
            btnSelected.setBackground(unChoosedColor);
        btnNew.setBackground(choosesColor);
        btnSelected = btnNew;
    }
    
    private void logout(){
        DangNhapController dangNhapController = new DangNhapController();
        view.dispose();
    }

    
}
