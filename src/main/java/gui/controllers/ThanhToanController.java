package gui.controllers;

import bll.services.IBanService;
import bll.services.IDonGoiService;
import bll.services.impl.BanServiceImpl;
import bll.services.impl.DonGoiServiceImpl;
import com.mycompany.quanlynhahang.Price;
import gui.models.BanModel;
import gui.models.DonGoi.DonGoiMasterModel;
import gui.models.DonGoi.DonGoiModel;
import gui.views.ThanhToan_GUI;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author LeAnhQuan
 */
public class ThanhToanController {
    private ThanhToan_GUI view;
    
    private IBanService banService;
    private IDonGoiService donGoiService;
    
    private int idBan;
    private BanModel ban;
    private DonGoiMasterModel donGoiMasterModel;

    public ThanhToanController(int idBan) {
        banService = new BanServiceImpl();
        donGoiService = new DonGoiServiceImpl();
        
        this.idBan = idBan;
        loadData();
        
        init();    
    }
    
    private void loadData(){
        ban = banService.getById(idBan);
        donGoiMasterModel = donGoiService.getMasterByBan(idBan);
    }
    
    private void init(){
        view = new ThanhToan_GUI();
        view.setVisible(true);

        view.lblTitleBan.setText("Bàn số " + ban.getId());
        view.loadTableDonGoi((ArrayList<DonGoiModel>) donGoiMasterModel.getListDonGoiModel());
        view.lblTongTien.setText(Price.formatPrice(donGoiMasterModel.getTotal()));
    }

    void show(int id) {      
        
        view.setVisible(true);
        view.setState(JFrame.NORMAL);
        view.toFront();  
    }
}
