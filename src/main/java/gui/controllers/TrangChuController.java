package gui.controllers;

import gui.views.TrangChu_GUI;
import javax.swing.JComponent;

/**
 *
 * @author LeAnhQuan
 */
public class TrangChuController {
    private TrangChu_GUI view;
    
    private QuanLyPhucVuController quanLyPhucVuController = null;
    private QuanLyLoaiBanVaBanController quanLyLoaiBanVaBanController = null;
    private QuanLyMonAnController quanLyMonAnController = null;
    
    
    String maNhanVien;
    
    public TrangChuController(String maNhanVien){
        this.maNhanVien = maNhanVien;
        
        init();
        showForm(new BaoCaoThongKeController().getView());
    }
    
    private void init(){
        view = new TrangChu_GUI();
        view.setVisible(true);
        
        view.btnQuanLyPhucVu.addActionListener(e -> showFormQuanLyPhucVu());
        view.btnQuanLyBan.addActionListener(e -> showFormQuanLyBan());
        view.btnQuanLyMonAn.addActionListener(e -> showFormQuanLyMonAn());
    }
    
    private void showForm(JComponent com){
        view.pnlForm.removeAll();
        view.pnlForm.add(com);
        view.pnlForm.repaint();
        view.pnlForm.revalidate();
    }
    
    private void showFormQuanLyPhucVu(){
        if(quanLyPhucVuController == null){
            quanLyPhucVuController = new QuanLyPhucVuController("maittt"); 
        }
        showForm(quanLyPhucVuController.getView());
    }
    
    private void showFormQuanLyBan(){
        if(quanLyLoaiBanVaBanController == null)
            quanLyLoaiBanVaBanController = new QuanLyLoaiBanVaBanController();
        
        showForm(quanLyLoaiBanVaBanController.getView());
    }
    
    private void showFormQuanLyMonAn(){
        if (quanLyMonAnController == null)
        
            quanLyMonAnController = new QuanLyMonAnController();
        showForm(quanLyMonAnController.getView());
    }
}
