package gui.controllers;

import bll.services.IDonGoiService;
import bll.services.IMonAnService;
import bll.services.impl.DonGoiServiceImpl;
import bll.services.impl.MonAnServiceImpl;
import com.mycompany.quanlynhahang.Price;
import gui.constraints.TinhTrangMonAnConstraints;
import gui.models.DonGoi.CreateDonGoiModel;
import gui.models.DonGoi.DonGoiModel;
import gui.models.DonGoi.UpdateDonGoiModel;
import gui.models.MonAn.MonAnFullModel;
import gui.views.DatMon_GUI;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author LeAnhQuan
 */
public class DatMonController {
    private DatMon_GUI view;
    
    private IMonAnService monAnService;
    private IDonGoiService donGoiService;
    
    private MonAnFullModel monAn;
    private int idBan;
    DonGoiModel donGoiModel = null;  

    public DatMonController() {
        monAnService = new MonAnServiceImpl();
        donGoiService = new DonGoiServiceImpl();
        
        init();
    }
    
    

    public DatMonController(int idBan, int idMonAn) {
        monAnService = new MonAnServiceImpl();
        donGoiService = new DonGoiServiceImpl();
        
        show(idBan, idMonAn);
    }
    
    public JButton getBtnDatMon(){
        return view.btnDatMon;
    }
    
    private void init(){
        view = new DatMon_GUI();
    }
    
    private void loadMonAn(){
        if (monAn.getHinhAnh() != null){
            ImageIcon yourImage = new ImageIcon(monAn.getHinhAnh());
            Image newImage = yourImage.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            view.lblHinhAnh.setIcon(new ImageIcon(newImage));
        }
        view.lblTenMonAn.setText(monAn.getTen());
        view.lblNoiDungMonAn.setText(monAn.getNoiDung());
        view.lblLoaiMonAn.setText(monAn.getLoaiMonAnModel().getTen());
        view.lblGia.setText(Price.formatPrice(monAn.getGia()));
        if(monAn.getGiaKhuyenMai() >= 0)
            view.lblGiaKhuyenMai.setText(Price.formatPrice(monAn.getGiaKhuyenMai()));
        else
            view.lblGiaKhuyenMai.setText("");
        
        donGoiModel = donGoiService.getByKey(idBan, monAn.getId());
        
        if(donGoiModel != null){
            view.setTitle("Sửa đơn gọi");
            view.lblSoLuongHienTai.setText(Integer.toString(donGoiModel.getSoLuong()));
            view.spnSoLuong.setValue(donGoiModel.getSoLuong());
            if(donGoiModel.getGhiChu() != null && !donGoiModel.getGhiChu().isBlank())
                view.txaGhiChu.setText(donGoiModel.getGhiChu());
        }
        
        view.lblTinhTrangMonAn.setText(monAn.getTinhTrangMonAnModel().getTen());
        if(monAn.getTinhTrangMonAnModel().getId() == TinhTrangMonAnConstraints.HET)
            view.btnDatMon.setEnabled(false);
        else
            view.btnDatMon.setEnabled(true);
    }
    
    void show(int idBan, int idMonAn){        
        monAn = monAnService.getFullById(idMonAn);
        this.idBan = idBan;
        
        if(view == null)
            view = new DatMon_GUI();            
        
        view.setVisible(true);
        view.setState(JFrame.NORMAL);
        view.toFront();    
        
        loadMonAn();    
    }
    
    public void datMon(){
        if(!NumberUtils.isCreatable(view.spnSoLuong.getValue().toString())){
            JOptionPane.showMessageDialog(view, "Số lượng món ăn không hợp lệ","Error", JOptionPane.ERROR_MESSAGE);    
            return;
        }
        
        int soLuong = Integer.parseInt(view.spnSoLuong.getValue().toString());
        if(soLuong < 1){
            JOptionPane.showMessageDialog(view, "Số lượng món phải lớn hơn 0","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String ghiChu = view.txaGhiChu.getText().isBlank() ? null : view.txaGhiChu.getText().trim();
        if(donGoiModel == null){
            CreateDonGoiModel createDonGoiModel = new CreateDonGoiModel();  

            createDonGoiModel.setIdMA(monAn.getId());
            createDonGoiModel.setIdBan(idBan);
            createDonGoiModel.setSoLuong(soLuong);
            createDonGoiModel.setGhiChu(ghiChu);

            boolean result = donGoiService.create(createDonGoiModel);

            if(result){
                JOptionPane.showMessageDialog(view, "Thêm món ăn mới thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                view.dispose();
            } else {            
                JOptionPane.showMessageDialog(view, "Thêm món ăn mới thất bại","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            UpdateDonGoiModel updateDonGoiModel = new UpdateDonGoiModel(idBan, monAn.getId(), soLuong, ghiChu);

            boolean result = donGoiService.update(updateDonGoiModel);

            if(result){
                JOptionPane.showMessageDialog(view, "Sửa món ăn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                view.dispose();
            } else {            
                JOptionPane.showMessageDialog(view, "Sửa món ăn thất bại","Thông báo", JOptionPane.INFORMATION_MESSAGE);

            }
        }
        
    }
}
