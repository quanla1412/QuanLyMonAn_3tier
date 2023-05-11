package gui.controllers;

import bll.services.IBanService;
import bll.services.IDonGoiService;
import bll.services.IKhachHangService;
import bll.services.impl.BanServiceImpl;
import bll.services.impl.DonGoiServiceImpl;
import bll.services.impl.KhachHangServiceImpl;
import com.mycompany.quanlynhahang.CheckHopLe;
import com.mycompany.quanlynhahang.Price;
import gui.models.BanModel;
import gui.models.DonGoi.DonGoiMasterModel;
import gui.models.DonGoi.DonGoiModel;
import gui.models.KhachHang.KhachHangFullModel;
import gui.models.KhachHang.KhachHangModel;
import gui.views.ThanhToan_GUI;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import bll.services.INhanVienService;
import bll.services.impl.NhanVienServiceImpl;
import gui.models.NhanVien.NhanVienFullModel;
import gui.models.NhanVien.NhanVienModel;

/**
 *
 * @author LeAnhQuan
 */
public class ThanhToanController {
    private ThanhToan_GUI view;
    
    private final IBanService banService;
    private final IDonGoiService donGoiService;
    private final IKhachHangService khachHangService;
    private final INhanVienService nhanVienService;
    
    private int idBan;
    private BanModel ban;
    private DonGoiMasterModel donGoiMasterModel;
    private int tongThanhToan;
    KhachHangFullModel khachHangFullModel = null;
    private String maNhanVien;
    NhanVienFullModel nhanVienFullModel;

    public ThanhToanController(int idBan, String maNhanVien) {
        banService = new BanServiceImpl();
        donGoiService = new DonGoiServiceImpl();
        khachHangService = new KhachHangServiceImpl();
        nhanVienService = new NhanVienServiceImpl();
        
        this.idBan = idBan;
        this.maNhanVien = maNhanVien;
        loadData();
        
        init();    
        tinhTongThanhToan();
    }
    
    private void loadData(){
        ban = banService.getById(idBan);
        donGoiMasterModel = donGoiService.getMasterByBan(idBan);
        nhanVienFullModel = nhanVienService.getByMa(maNhanVien);
    }
    
    private void init(){
        view = new ThanhToan_GUI();
        view.setVisible(true);

        view.lblTitleBan.setText("Bàn số " + ban.getId());
        view.loadTableDonGoi((ArrayList<DonGoiModel>) donGoiMasterModel.getListDonGoiModel());
        view.lblTongTien.setText(Price.formatPrice(donGoiMasterModel.getTotal()));
        view.btnSearch.addActionListener(e -> timKhachHang());
        view.lblNhanVien.setText("Nhân viên lập hóa đơn: " + nhanVienFullModel.getHoTen());
    }

    void show(int idBan) {    
        this.idBan = idBan;
        loadData();      
        
        view.setVisible(true);
        view.setState(JFrame.NORMAL);
        view.toFront();  
        tinhTongThanhToan();
    }
    
    private void timKhachHang(){
        String soDienThoai = view.txtSoDienThoai.getText();
        if(!CheckHopLe.checkSoDienThoai(soDienThoai)){
            JOptionPane.showMessageDialog(view, "Số điện thoại không hợp lệ","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        khachHangFullModel = khachHangService.getFullBySoDienThoai(soDienThoai);
        if (khachHangFullModel == null) {
            JOptionPane.showMessageDialog(view, "Không tìm thấy khách hàng","Error", JOptionPane.ERROR_MESSAGE);
            return;            
        }
        
        view.lblTenKhachHang.setText("Tên khách hàng: " + khachHangFullModel.getTen());
        view.lblSDTKhachHang.setText("Số điện thoại: " + khachHangFullModel.getSdt());
        view.lblMucUuDai.setText(Float.toString(khachHangFullModel.getLoaiKhachHang().getMucUuDai()) + " %");
        
        tinhTongThanhToan();
    }
    
    private void tinhTongThanhToan(){
        float mucUuDai = 0;
        if(khachHangFullModel != null)
            mucUuDai = khachHangFullModel.getLoaiKhachHang().getMucUuDai();
        
        tongThanhToan = Math.round(donGoiMasterModel.getTotal() - donGoiMasterModel.getTotal() * mucUuDai / 100);
        view.lblTongThanhToan.setText(Price.formatPrice(tongThanhToan));
    }
}
