/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.mappers;

import dal.entity.ChiTietHoaDon;
import gui.models.HoaDon.ChiTietHoaDonModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tanph
 */
public class ChiTietHoaDonMapper {
    public static ChiTietHoaDonModel toChiTietHoaDonModel(ChiTietHoaDon chiTietHoaDon){
        ChiTietHoaDonModel chiTietHoaDonModel = new ChiTietHoaDonModel();
        chiTietHoaDonModel.setTenMonAn(chiTietHoaDon.getMaMonAn().getTen());
        chiTietHoaDonModel.setSoLuong(chiTietHoaDon.getSoLuong());
        chiTietHoaDonModel.setGia(chiTietHoaDon.getDonGia());
        
        return chiTietHoaDonModel;
    }
    
    public static List<ChiTietHoaDonModel> toListChiTietHoaDonModel(List<ChiTietHoaDon> listChiTietHoaDon){
        List<ChiTietHoaDonModel> listChiTietHoaDonModel = new ArrayList<>();
        listChiTietHoaDon.forEach(chiTietHoaDon -> listChiTietHoaDonModel.add(toChiTietHoaDonModel(chiTietHoaDon)));
        
        return listChiTietHoaDonModel;
    }
}
