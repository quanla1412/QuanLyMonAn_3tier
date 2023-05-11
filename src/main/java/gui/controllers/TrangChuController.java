package gui.controllers;

import gui.views.TrangChu_GUI;

/**
 *
 * @author LeAnhQuan
 */
public class TrangChuController {
    private TrangChu_GUI view;
    
    public TrangChuController(){
        init();
    }
    
    private void init(){
        view = new TrangChu_GUI();
        view.setVisible(true);
    }
}
