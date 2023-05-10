package gui.controllers;

import bll.services.IBanService;
import bll.services.impl.BanServiceImpl;
import gui.constraints.TinhTrangBanConstraints;
import gui.models.Ban.BanFullModel;
import gui.models.BanModel;
import gui.views.QuanLyPhucVu_GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author LeAnhQuan
 */
public class QuanLyPhucVuController {
    private QuanLyPhucVu_GUI view;
    
    private IBanService banService;

    private ArrayList<BanFullModel> listBanFullModel;
    private BanFullModel banSelected = null;
    
    public QuanLyPhucVuController() {
        banService = new BanServiceImpl();
        
        init();
    }
    
    private void init(){
        view = new QuanLyPhucVu_GUI();
        
        loadData();
        loadDanhSachBan();
        
        view.btnSanSang.addActionListener(e -> chuyenTinhTrangBan(TinhTrangBanConstraints.SAN_SANG));
        view.btnPhucVu.addActionListener(e -> chuyenTinhTrangBan(TinhTrangBanConstraints.DANG_PHUC_VU));
        view.btnNgungPhucVu.addActionListener(e -> chuyenTinhTrangBan(TinhTrangBanConstraints.NGUNG_PHUC_VU));
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
    
    private void loadDanhSachBan() {
        view.pnlDanhSachBan.removeAll();
        for(BanFullModel ban : listBanFullModel){
            String title = "<html> "
                    + "<p style=\"text-align:center\">Bàn " + ban.getId() + "</p> "
                    + "<p  style=\"text-align:center\">" + ban.getLoaiBan().getTen() + "</p> "
                    + "<p  style=\"text-align:center\">" + ban.getTinhTrangBan().getTen() + "</p> "
                    + "</html>";
            JButton button = new JButton(title);
            button.setPreferredSize(new Dimension(120, 60));
            button.setMinimumSize(new Dimension(120, 60));
            button.setMaximumSize(new Dimension(120, 60));
            
            int idTinhTrangBan = ban.getTinhTrangBan().getId();
            switch (idTinhTrangBan) {
                case TinhTrangBanConstraints.SAN_SANG -> button.setBackground(new Color(95, 192, 102));
                case TinhTrangBanConstraints.DANG_PHUC_VU -> button.setBackground(new Color(231, 197, 76));
                case TinhTrangBanConstraints.DANG_CHUAN_BI -> button.setBackground(new Color(220, 60, 47));
                default -> button.setBackground(new Color(141, 141, 141));
            }
            
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    banSelected = ban;
                      loadDetailBan();
//                    loadDonGoi();
//                    if(banDangChon.getTinhTrangBan().getId() == TinhTrangBanConstraints.DANG_PHUC_VU)
//                        loadDonGoi();
                }
            });
            
            view.pnlDanhSachBan.add(button);
        }
    } 
    
    private void loadDetailBan(){
        loadThongTinBan();
        loadChucNang();
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
    
    private void loadComboBoxBanSanSang(){
        ArrayList<BanModel> listBanSanSang = (ArrayList<BanModel>) banService.getByTinhTrang(TinhTrangBanConstraints.SAN_SANG);
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
    
    private void reset(){
        loadData();
        loadDanhSachBan();
        loadDetailBan();        
    }
}
