/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.mappers;

import dal.entity.HoaDon;
import gui.models.HoaDon.ChiTietHoaDonModel;
import gui.models.HoaDon.HoaDonFullModel;
import gui.models.HoaDon.HoaDonModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tanph
 */
public class HoaDonMapper {
    public static HoaDonModel toHoaDonModel(HoaDon hoaDon){
        HoaDonModel hoaDonModel = new HoaDonModel();
        hoaDonModel.setId(hoaDon.getId());
        hoaDonModel.setIdKhachHang(hoaDon.getIdKhachHang().getId());
        hoaDonModel.setMaNhanVien(hoaDon.getMaNhanVien().getMa());
        hoaDonModel.setNgayGio(hoaDon.getNgayGio());
        hoaDonModel.setTongGia(hoaDon.getTongGia());
        
        return hoaDonModel;
    }
    
    public static List<HoaDonModel> toListHoaDonModel(List<HoaDon> listHoaDon){
        List<HoaDonModel> listHoaDonModel = new ArrayList<>();
        listHoaDon.forEach(hoaDon -> listHoaDonModel.add(toHoaDonModel(hoaDon)));
        
        return listHoaDonModel;
    }
    
    public static HoaDonFullModel toHoaDonFullModel(HoaDon hoaDon){
        HoaDonFullModel hoaDonFullModel = new HoaDonFullModel();
        
        hoaDonFullModel.setId(hoaDon.getId());
        hoaDonFullModel.setMaNhanVien(hoaDon.getMaNhanVien().getMa());
        hoaDonFullModel.setIdKhachHang(hoaDon.getIdKhachHang().getId());
        hoaDonFullModel.setNgayGio(hoaDon.getNgayGio());
        hoaDonFullModel.setDaHuy(hoaDon.isDaHuy());
        hoaDonFullModel.setListChiTietHoaDon(ChiTietHoaDonMapper.toListChiTietHoaDonModel(hoaDon.getListChiTietHoaDon()));
        hoaDonFullModel.setTongGia(hoaDon.getTongGia());
        hoaDonFullModel.setUuDai(hoaDon.getUuDai());
        
        return hoaDonFullModel;
    }
}
