package gui.controllers;

import bll.services.ILoaiMonAnService;
import bll.services.impl.LoaiMonAnServiceImpl;
import gui.models.MonAn.LoaiMonAnFullModel;
import gui.models.MonAn.MonAnModel;
import gui.views.Menu_GUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author LeAnhQuan
 */
public class MenuController {
    private Menu_GUI view;
    
    private ILoaiMonAnService loaiMonAnService;
    
    private ArrayList<LoaiMonAnFullModel> listLoaiMonAnFullModel;
    private int idBan;
    private DatMonController datMonController = null;

    public MenuController(int idBan) {
        loaiMonAnService = new LoaiMonAnServiceImpl();
        
        this.idBan = idBan;
        loadData();
        
        init();
    }
    
    private void init(){
        view = new Menu_GUI();
        view.setVisible(true);
        datMonController = new DatMonController();
        
        view.loadMonAn(listLoaiMonAnFullModel);
        view.listBtnDatMon.forEach(btnDatMon -> btnDatMon.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int idMonAn = Integer.parseInt(btnDatMon.getName());
                showDatMon(idMonAn);
            }
            
        }));
    }

    public void show(){
        view.setVisible(true);
        view.setState(JFrame.NORMAL);
        view.toFront();
    }
    
    private void loadData(){
        listLoaiMonAnFullModel = (ArrayList<LoaiMonAnFullModel>) loaiMonAnService.getAllFull();
    }
    
    private void showDatMon(int idMonAn){
        datMonController.show(idBan, idMonAn);
    }
    
    public void datMon(){    
        datMonController.datMon();
    }
    
    public JButton getBtnDatMon(){
        return datMonController.getBtnDatMon();
    }
}
