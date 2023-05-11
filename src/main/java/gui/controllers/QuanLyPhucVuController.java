package gui.controllers;

import bll.services.IBanService;
import bll.services.IDonGoiService;
import bll.services.impl.BanServiceImpl;
import bll.services.impl.DonGoiServiceImpl;
import gui.constraints.TinhTrangBanConstraints;
import gui.models.Ban.BanFullModel;
import gui.models.BanModel;
import gui.models.DonGoi.DonGoiMasterModel;
import gui.models.DonGoi.DonGoiModel;
import gui.views.DatMon_GUI;
import gui.views.QuanLyPhucVu_GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author LeAnhQuan
 */
public class QuanLyPhucVuController {
    private QuanLyPhucVu_GUI view;
    
    private MenuController menuController = null;
    private DatMonController datMonController = null;
    private ThanhToanController thanhToanController = null;
    
    private IBanService banService;
    private IDonGoiService donGoiService;

    private ArrayList<BanFullModel> listBanFullModel;
    private BanFullModel banSelected = null;
    private DonGoiMasterModel donGoiMasterModel = null;
    private ArrayList<BanModel> listBanSanSang;
    private int idDonGoiItemSelected = -1;
    private String maNhanVien;
    
    public QuanLyPhucVuController(String maNhanVien) {
        banService = new BanServiceImpl();
        donGoiService = new DonGoiServiceImpl();
        
        this.maNhanVien = maNhanVien;
        
        init();
    }
    
    private void init(){
        view = new QuanLyPhucVu_GUI();
        
        loadData();
        loadDanhSachBan();
        loadDetailBan();
        
        view.btnSanSang.addActionListener(e -> chuyenTinhTrangBan(TinhTrangBanConstraints.SAN_SANG));
        view.btnPhucVu.addActionListener(e -> chuyenTinhTrangBan(TinhTrangBanConstraints.DANG_PHUC_VU));
        view.btnNgungPhucVu.addActionListener(e -> chuyenTinhTrangBan(TinhTrangBanConstraints.NGUNG_PHUC_VU));
        view.btnResetDonGoi.addActionListener(e -> reset());
        view.btnChuyenBan.addActionListener(e -> chuyenBan());
        view.tblDonGoi.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowSelected = view.tblDonGoi.getSelectedRow();
                idDonGoiItemSelected = (int) view.tblDonGoi.getValueAt(rowSelected, 0);
            }
            
        });
        
        view.btnThemMonMoi.addActionListener(e -> showMenu());
        view.btnSuaDonGoi.addActionListener(e -> suaDonGoi());
        view.btnXoa.addActionListener(e -> xoaDonGoi());
        view.btnThanhToan.addActionListener(e -> showThanhToan());
    }
    
    public JComponent getView(){
        return view;
    }
    
    private void loadData(){
        listBanFullModel = (ArrayList<BanFullModel>) banService.getAllFull();        
        if (banSelected == null) {
            banSelected = listBanFullModel.get(0);            
        } else {
            banSelected = banService.getFullById(banSelected.getId());
        }
    }
    
    private void loadDanhSachBan(){
        view.loadDanhSachBan(listBanFullModel);
        view.listBtnBan.forEach(button -> {
            button.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    BanFullModel banFullModel = new BanFullModel();
                    banFullModel.setId(Integer.parseInt(button.getName()));
                    banSelected = listBanFullModel.get(listBanFullModel.indexOf(banFullModel));
                    loadDetailBan();
                    idDonGoiItemSelected = -1;
                }                
            });
        });
    }
    
    private void loadDetailBan(){
        loadThongTinBan();
        loadChucNang();
        loadDonGoi();
    }
    
    private void loadThongTinBan(){
        view.lblIdBan.setText(banSelected.getId() + "");
        view.lblLoaiBan.setText(banSelected.getLoaiBan().getTen());
        view.lblTinhTrangBan.setText(banSelected.getTinhTrangBan().getTen());
    }    
    
    private void loadChucNang(){
        int idTinhTrangBan = banSelected.getTinhTrangBan().getId();
        
        switch (idTinhTrangBan) {
            case TinhTrangBanConstraints.SAN_SANG:
                view.btnSanSang.setEnabled(false);
                view.btnPhucVu.setEnabled(true);
                view.btnNgungPhucVu.setEnabled(true);
                view.btnThemMonMoi.setEnabled(false);
                view.btnSuaDonGoi.setEnabled(false);
                view.btnXoa.setEnabled(false);
                view.btnThanhToan.setEnabled(false);
                view.btnResetDonGoi.setEnabled(false);
                
                view.cmbBanSanSang.setSelectedIndex(-1);
                view.cmbBanSanSang.setEnabled(false);
                view.btnChuyenBan.setEnabled(false);
                break;
            case TinhTrangBanConstraints.DANG_PHUC_VU:
                view.btnSanSang.setEnabled(false);
                view.btnPhucVu.setEnabled(false);
                view.btnNgungPhucVu.setEnabled(false);
                view.btnThemMonMoi.setEnabled(true);
                view.btnSuaDonGoi.setEnabled(true);
                view.btnXoa.setEnabled(true);
                view.btnThanhToan.setEnabled(true);
                view.btnResetDonGoi.setEnabled(true);
                
                view.cmbBanSanSang.setSelectedIndex(-1);
                view.cmbBanSanSang.setEnabled(true);
                view.btnChuyenBan.setEnabled(true);
                loadComboBoxBanSanSang();
                break;
            case TinhTrangBanConstraints.DANG_CHUAN_BI:
                view.btnSanSang.setEnabled(true);
                view.btnPhucVu.setEnabled(false);
                view.btnNgungPhucVu.setEnabled(true);
                view.btnThemMonMoi.setEnabled(false);
                view.btnSuaDonGoi.setEnabled(false);
                view.btnXoa.setEnabled(false);
                view.btnThanhToan.setEnabled(false);
                view.btnResetDonGoi.setEnabled(false);
                
                view.cmbBanSanSang.setSelectedIndex(-1);
                view.cmbBanSanSang.setEnabled(false);
                view.btnChuyenBan.setEnabled(false);
                break;
            default:
                view.btnSanSang.setEnabled(true);
                view.btnPhucVu.setEnabled(false);
                view.btnNgungPhucVu.setEnabled(false);
                view.btnThemMonMoi.setEnabled(false);
                view.btnSuaDonGoi.setEnabled(false);
                view.btnXoa.setEnabled(false);
                view.btnThanhToan.setEnabled(false);  
                view.btnResetDonGoi.setEnabled(false);
                
                view.cmbBanSanSang.setSelectedIndex(-1);
                view.cmbBanSanSang.setEnabled(false);
                view.btnChuyenBan.setEnabled(false);
                break;
        }
    }
    
    private void loadDonGoi(){
        donGoiMasterModel = donGoiService.getMasterByBan(banSelected.getId());
        view.loadTableDonGoi(donGoiMasterModel);
    }
    
    private void loadComboBoxBanSanSang(){
        listBanSanSang = (ArrayList<BanModel>) banService.getByTinhTrang(TinhTrangBanConstraints.SAN_SANG);
        view.cmbBanSanSang.removeAllItems();
        view.loadComboBoxBanSanSang(listBanSanSang);
    }
    
    private void chuyenTinhTrangBan(int idTinhTrangBan){
        boolean result = banService.changeTinhTrangBan(banSelected.getId(), idTinhTrangBan);
        
        if(!result)
            JOptionPane.showMessageDialog(view, "Chuyển thất bại","Error", JOptionPane.ERROR_MESSAGE);
        else {
            reset();
        }
    }
    
    private void chuyenTinhTrangBan(int idBan, int idTinhTrangBan){
        boolean result = banService.changeTinhTrangBan(idBan, idTinhTrangBan);
        
        if(!result)
            JOptionPane.showMessageDialog(view, "Chuyển thất bại","Error", JOptionPane.ERROR_MESSAGE);
        else {
            reset();
        }
    }
    
    private void reset(){
        loadData();
        loadDanhSachBan();
        loadDetailBan();        
    }
    
    private void chuyenBan(){
        int indexBan = view.cmbBanSanSang.getSelectedIndex();
        if(indexBan < 0){
            JOptionPane.showMessageDialog(view, "Vui lòng chọn bàn muốn chuyển","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idBanMoi = listBanSanSang.get(indexBan).getId();
        boolean result = donGoiService.chuyenBan(banSelected.getId(), idBanMoi);
        if(result){
            JOptionPane.showMessageDialog(view, "Chuyển bàn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            chuyenTinhTrangBan(TinhTrangBanConstraints.DANG_CHUAN_BI);
            chuyenTinhTrangBan(idBanMoi, TinhTrangBanConstraints.DANG_PHUC_VU);
            banSelected = banService.getFullById(idBanMoi);
            reset();
        } else {
            JOptionPane.showMessageDialog(view, "Chuyển bàn thất bại","Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    private void showMenu(){        
        if(menuController == null)
            menuController = new MenuController(banSelected.getId());
        else
            menuController.show();
        
        menuController.getBtnDatMon().addActionListener(e -> {
            menuController.datMon();
            reset();
        });
    }
    
    private void suaDonGoi(){
        if(idDonGoiItemSelected < 0){
            JOptionPane.showMessageDialog(view, "Chưa chọn món ăn","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(datMonController == null)
            datMonController = new DatMonController(banSelected.getId(), idDonGoiItemSelected);
        else
            datMonController.show(banSelected.getId(), idDonGoiItemSelected);
        
        datMonController.getBtnDatMon().addActionListener(e -> {
            datMonController.datMon();
            reset();
        });
    }  
    
    
    private void xoaDonGoi(){
        if(idDonGoiItemSelected < 0){
            JOptionPane.showMessageDialog(view, "Chưa chọn món ăn","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean result = donGoiService.delete(banSelected.getId(), idDonGoiItemSelected);
        if(result){
            JOptionPane.showMessageDialog(view, "Xóa món ăn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            idDonGoiItemSelected = -1;
            reset();
        } else {
            JOptionPane.showMessageDialog(view, "Xóa món ăn thất bại","Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    private void showThanhToan(){
        if(donGoiMasterModel.getListDonGoiModel().isEmpty()){
            JOptionPane.showMessageDialog(view, "Đơn gọi không có món ăn","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;            
        }
        if (thanhToanController == null) {
            thanhToanController = new ThanhToanController(banSelected.getId(), maNhanVien);
        } else {
            thanhToanController.show(banSelected.getId());
        }
    }
}
