/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bll.services;

import gui.models.HoaDon.HoaDonFullModel;
import gui.models.HoaDon.HoaDonModel;
import gui.models.HoaDon.SearchHoaDonModel;
import java.util.List;

/**
 *
 * @author tanph
 */
public interface IHoaDonService {
    public List<HoaDonModel> getAll();
    
    public HoaDonFullModel getHoaDonFullById(int id);
    
    public List<HoaDonModel> search(SearchHoaDonModel searchHoaDonModel);
    
    public boolean huyHoaDon(HoaDonFullModel hoaDonSelected);
}
