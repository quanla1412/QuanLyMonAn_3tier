
package com.mycompany.quanlynhahang;

import bll.services.IBanService;
import bll.services.ILoaiBanService;
import bll.services.impl.BanServiceImpl;
import bll.services.impl.LoaiBanServiceImpl;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import dal.HibernateUtils;
import dal.entity.LoaiBan;
import dal.repository.LoaiBanRepository;
import gui.controllers.QuanLyLoaiMonAnController;
import gui.controllers.QuanLyMonAnController;
import gui.views.QuanLyLoaiMonAn_GUI;
import gui.views.TrangChuNew_GUI;
import java.util.ArrayList;
import javax.swing.UIManager;
import org.hibernate.Session;

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
        TrangChuNew_GUI trangChuNew_GUI = new TrangChuNew_GUI();
        trangChuNew_GUI.setVisible(true);
    }
}
