package gui.controllers;

import bll.services.IBanService;
import bll.services.IDonGoiService;
import bll.services.IHoaDonService;
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
import bll.services.impl.HoaDonServiceImpl;
import bll.services.impl.NhanVienServiceImpl;
import gui.constraints.TinhTrangBanConstraints;
import gui.models.HoaDon.CreateChiTietHoaDonModel;
import gui.models.HoaDon.CreateHoaDonModel;
import gui.models.HoaDon.HoaDonModel;
import gui.models.NhanVien.NhanVienFullModel;
import gui.models.NhanVien.NhanVienModel;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFileChooser;

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
    private final IHoaDonService hoaDonService;
    
    private int idBan;
    private BanModel ban;
    private DonGoiMasterModel donGoiMasterModel;
    private int tongThanhToan;
    KhachHangFullModel khachHangFullModel = null;
    private final String maNhanVien;
    NhanVienFullModel nhanVienFullModel;

    public ThanhToanController(int idBan, String maNhanVien) {
        banService = new BanServiceImpl();
        donGoiService = new DonGoiServiceImpl();
        khachHangService = new KhachHangServiceImpl();
        nhanVienService = new NhanVienServiceImpl();
        hoaDonService = new HoaDonServiceImpl();
        
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

        loadThongTin();
        view.btnInBillTam.addActionListener(e -> inBillTam());
    }

    void show(int idBan) {    
        this.idBan = idBan;
        loadData();      
        
        view.setVisible(true);
        view.setState(JFrame.NORMAL);
        view.toFront();  
        loadThongTin();
        tinhTongThanhToan();
    }
    
    public JButton getBtnThanhToan(){
        return view.btnThanhToan;
    }
    
    private void loadThongTin(){
        view.lblTitleBan.setText("Bàn số " + ban.getId());
        view.loadTableDonGoi((ArrayList<DonGoiModel>) donGoiMasterModel.getListDonGoiModel());
        view.lblTongTien.setText(Price.formatPrice(donGoiMasterModel.getTotal()));
        view.btnSearch.addActionListener(e -> timKhachHang());
        view.lblNhanVien.setText("Nhân viên lập hóa đơn: " + nhanVienFullModel.getHoTen());
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
    
    public void thanhToan(){
        CreateHoaDonModel createHoaDonModel = new CreateHoaDonModel();
        
        if(khachHangFullModel != null){
            createHoaDonModel.setIdKhachHang(khachHangFullModel.getId());
            createHoaDonModel.setUuDai(khachHangFullModel.getLoaiKhachHang().getMucUuDai());
        }
        createHoaDonModel.setMaNhanVien(maNhanVien);
        createHoaDonModel.setNgayGio(new Date());
        createHoaDonModel.setTongGia(tongThanhToan);   
        createHoaDonModel.setIdBan(idBan);
        
        ArrayList<CreateChiTietHoaDonModel> listChiTietHoaDonModel = new ArrayList<>();
        donGoiMasterModel.getListDonGoiModel().forEach(donGoiModel -> {
            CreateChiTietHoaDonModel createChiTietHoaDonModel = new CreateChiTietHoaDonModel();
            
            createChiTietHoaDonModel.setIdMonAn(donGoiModel.getMonAn().getId());
            createChiTietHoaDonModel.setSoLuong(donGoiModel.getSoLuong());
            createChiTietHoaDonModel.setDonGia(donGoiModel.getThanhTien());
            
            listChiTietHoaDonModel.add(createChiTietHoaDonModel);
        });
        createHoaDonModel.setListChiTietHoaDonModel(listChiTietHoaDonModel);
        
        HoaDonModel result = hoaDonService.create(createHoaDonModel);
        if(result != null){
            JOptionPane.showMessageDialog(view, "Thanh toán thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            JFileChooser jFileChooser= new JFileChooser("D:");
            jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            boolean resultInBill = false; 

            if (jFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                resultInBill = hoaDonService.inBill(result.getId(), jFileChooser.getSelectedFile().getAbsolutePath());
            }  
            if (resultInBill)
                view.dispose();
            else
                JOptionPane.showMessageDialog(view, "In bill thất bại","Error", JOptionPane.ERROR_MESSAGE);
                       
        } else 
            JOptionPane.showMessageDialog(view, "Thanh toán thất bại","Thông báo", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    private void inBillTam(){
        JFileChooser jFileChooser= new JFileChooser("D:\\");
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        boolean result = false; 
       
        int idKhachHang = khachHangFullModel == null ? 0 : khachHangFullModel.getId();
        if (jFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            result = donGoiService.inBillTam(idBan, idKhachHang, maNhanVien, jFileChooser.getSelectedFile().getAbsolutePath());
        }
        
        if (!result) {
            JOptionPane.showMessageDialog(view, "In bill tạm thất bại","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
