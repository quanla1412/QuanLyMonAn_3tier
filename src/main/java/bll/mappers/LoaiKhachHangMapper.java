/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.mappers;

import dal.entity.LoaiKhachHang;
import gui.models.LoaiKhachHang.CreateLoaiKhachHangModel;
import gui.models.LoaiKhachHang.LoaiKhachHangModel;
import gui.models.LoaiKhachHang.UpdateLoaiKhachHangModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuant
 */
public class LoaiKhachHangMapper {
    public static LoaiKhachHangModel toLoaiKhachHangModel(LoaiKhachHang loaiKhachHang){
        LoaiKhachHangModel loaiKhachHangModel = new LoaiKhachHangModel(loaiKhachHang.getId(), loaiKhachHang.getTen(), loaiKhachHang.getDiemToiThieu(), loaiKhachHang.getMucUuDai());
        
        return loaiKhachHangModel;
    }
    public static List<LoaiKhachHangModel> toListLoaiKhachHangModel(List<LoaiKhachHang> listLoaiKhachHang){
        List<LoaiKhachHangModel> listLoaiKhachHangModel = new ArrayList<>();
        listLoaiKhachHang.forEach(loaiKhachHang -> listLoaiKhachHangModel.add(toLoaiKhachHangModel(loaiKhachHang)));
        
        return listLoaiKhachHangModel;
    }
    public static LoaiKhachHang toLoaiKhachHang(CreateLoaiKhachHangModel createLoaiKhachHangModel){
        LoaiKhachHang loaiKhachHang = new LoaiKhachHang();
        
        loaiKhachHang.setTen(createLoaiKhachHangModel.getTen());
        loaiKhachHang.setDiemToiThieu(createLoaiKhachHangModel.getDiemToiThieu());
        loaiKhachHang.setMucUuDai(createLoaiKhachHangModel.getMucUuDai());
        
        return loaiKhachHang;
    }
    public static LoaiKhachHang toLoaiKhachHang(UpdateLoaiKhachHangModel updateLoaiKhachHangModel){
        LoaiKhachHang loaiKhachHang = new LoaiKhachHang();
        
        loaiKhachHang.setId(updateLoaiKhachHangModel.getId());
        loaiKhachHang.setTen(updateLoaiKhachHangModel.getTen());
        loaiKhachHang.setDiemToiThieu(updateLoaiKhachHangModel.getDiemToiThieu());
        loaiKhachHang.setMucUuDai(updateLoaiKhachHangModel.getMucUuDai());
        
        return loaiKhachHang;
    }
}
