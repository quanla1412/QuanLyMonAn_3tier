/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.mappers;

import dal.entity.KhachHang;
import gui.models.KhachHang.KhachHangFullModel;
import gui.models.KhachHang.KhachHangModel;
import gui.models.LoaiKhachHang.LoaiKhachHangModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuant
 */
public class KhachHangMapper {
    public static KhachHangModel toKhachHangModel(KhachHang khachHang){
        KhachHangModel khachHangModel = new KhachHangModel(khachHang.getId(), khachHang.getTen(), khachHang.getSdt(), khachHang.getDiemTichLuy(), khachHang.getLoaiKhachHang().getTen(), khachHang.getEmail(), khachHang.getNgaySinh(), khachHang.getGioiTinhNam());
        
        return khachHangModel;
    }
    public static KhachHangFullModel toKhachHangFullModel(KhachHang khachHang){
        KhachHangFullModel khachHangFullModel = new KhachHangFullModel();
        
        khachHangFullModel.setId(khachHang.getId());
        
        LoaiKhachHangModel loaiKhachHangModel = LoaiKhachHangMapper.toLoaiKhachHangModel(khachHang.getLoaiKhachHang());
        khachHangFullModel.setLoaiKhachHang(loaiKhachHangModel);
        
        khachHangFullModel.setTen(khachHang.getTen());
        khachHangFullModel.setSdt(khachHang.getSdt());
        khachHangFullModel.setDiemTichLuy(khachHang.getDiemTichLuy());
        khachHangFullModel.setEmail(khachHang.getEmail());
        khachHangFullModel.setNgaySinh(khachHang.getNgaySinh());
        khachHangFullModel.setGioiTinhNam(khachHang.getGioiTinhNam());
                
        
        return khachHangFullModel;
    }
    public static List<KhachHangModel> toListKhachHangModel(List<KhachHang> listKhachHang){
        List<KhachHangModel> listKhachHangModel = new ArrayList<>();
        listKhachHang.forEach(khachHang -> listKhachHangModel.add(toKhachHangModel(khachHang)));
        
        return listKhachHangModel;
    }
    public static KhachHang toKhachHang(CreateKhachHangModel createKhachHangModel){
        KhachHang khachHang = new KhachHang();
        
        khachHang.setTen(createKhachHangModel.getTen());
        khachHang.setDiemToiThieu(createKhachHangModel.getDiemToiThieu());
        khachHang.setMucUuDai(createKhachHangModel.getMucUuDai());
        
        return khachHang;
    }
    public static KhachHang toKhachHang(UpdateKhachHangModel updateKhachHangModel){
        KhachHang khachHang = new KhachHang();
        
        khachHang.setId(updateKhachHangModel.getId());
        khachHang.setTen(updateKhachHangModel.getTen());
        khachHang.setDiemToiThieu(updateKhachHangModel.getDiemToiThieu());
        khachHang.setMucUuDai(updateKhachHangModel.getMucUuDai());
        
        return khachHang;
    }
}
