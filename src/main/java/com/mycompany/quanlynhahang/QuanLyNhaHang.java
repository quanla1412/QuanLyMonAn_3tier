
package com.mycompany.quanlynhahang;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import dal.HibernateUtils;
import dal.entity.LoaiBan;
import dal.repository.LoaiBanRepository;
import gui.controllers.DangNhapController;
import gui.controllers.QuanLyLoaiMonAnController;
import gui.controllers.QuanLyMonAnController;
import gui.controllers.TrangChuController;
import gui.views.QuanLyLoaiMonAn_GUI;
import gui.views.TrangChu_GUI;
import java.util.ArrayList;
import javax.swing.UIManager;

/**
 *
 * @author LeAnhQuan
 */
public class QuanLyNhaHang {
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch(Exception ex){
            System.out.println(ex);
        }
        DangNhapController dangNhapController = new DangNhapController();
    }
}
