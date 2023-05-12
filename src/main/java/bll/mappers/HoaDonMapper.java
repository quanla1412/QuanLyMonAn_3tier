/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.mappers;

import dal.entity.ChiTietHoaDon;
import dal.entity.HoaDon;
import dal.entity.KhachHang;
import dal.entity.MonAn;
import dal.entity.NhanVien;
import gui.models.HoaDon.ChiTietHoaDonModel;
import gui.models.HoaDon.CreateHoaDonModel;
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
        if(hoaDon.getKhachHang() != null )
            hoaDonModel.setIdKhachHang(hoaDon.getKhachHang().getId());
        hoaDonModel.setMaNhanVien(hoaDon.getNhanVien().getMa());
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
        hoaDonFullModel.setMaNhanVien(hoaDon.getNhanVien().getMa());
        hoaDonFullModel.setIdKhachHang(hoaDon.getKhachHang().getId());
        hoaDonFullModel.setNgayGio(hoaDon.getNgayGio());
        hoaDonFullModel.setDaHuy(hoaDon.isDaHuy());
        hoaDonFullModel.setListChiTietHoaDon(ChiTietHoaDonMapper.toListChiTietHoaDonModel(hoaDon.getListChiTietHoaDon()));
        hoaDonFullModel.setTongGia(hoaDon.getTongGia());
        hoaDonFullModel.setUuDai(hoaDon.getUuDai());
        
        return hoaDonFullModel;
    }
    
    public static HoaDon toHoaDon(CreateHoaDonModel createHoaDonModel){
        HoaDon hoaDon = new HoaDon();
        
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa(createHoaDonModel.getMaNhanVien());
        hoaDon.setNhanVien(nhanVien);
        
        if(createHoaDonModel.getIdKhachHang() > 0){
            KhachHang khachHang = new KhachHang();
            khachHang.setId(createHoaDonModel.getIdKhachHang());
            
            hoaDon.setKhachHang(khachHang);
        }
        
        hoaDon.setNgayGio(createHoaDonModel.getNgayGio());
        hoaDon.setTongGia(createHoaDonModel.getTongGia());
        hoaDon.setUuDai(createHoaDonModel.getUuDai());
        hoaDon.setDaHuy(false);
        
        List<ChiTietHoaDon> listChiTietHoaDon = new ArrayList<>();
        createHoaDonModel.getListChiTietHoaDonModel().forEach(chiTietHoaDonModel -> {
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
            
            MonAn monAn = new MonAn();
            monAn.setId(chiTietHoaDonModel.getIdMonAn());
            chiTietHoaDon.setMonAn(monAn);
            
            chiTietHoaDon.setSoLuong(chiTietHoaDonModel.getSoLuong());
            chiTietHoaDon.setDonGia(chiTietHoaDonModel.getDonGia());
            
            listChiTietHoaDon.add(chiTietHoaDon);
        });
        hoaDon.setListChiTietHoaDon(listChiTietHoaDon);
        
        return hoaDon;
    } 
}
