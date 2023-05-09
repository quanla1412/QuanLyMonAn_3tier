package gui.controllers;

import bll.services.IMonAnService;
import bll.services.impl.MonAnServiceImpl;
import gui.models.MonAn.MonAnModel;
import gui.views.QuanLyMonAn_GUI;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author LeAnhQuan
 */
public class QuanLyMonAnController {
    private QuanLyMonAn_GUI view;
    
    private final IMonAnService monAnService;
    
    public ArrayList<MonAnModel> listMonAnModel;

    public QuanLyMonAnController() {
        monAnService = new MonAnServiceImpl();
        
        init();
    }
    
    public JComponent getView(){
        return view;
    }
    
    private void init(){
        view = new QuanLyMonAn_GUI();
        view.setVisible(true);
        
        loadData();
        view.loadTableMonAn(listMonAnModel);
    }
    
    private void loadData(){
        listMonAnModel = (ArrayList<MonAnModel>) monAnService.getAll();
    }
}
