/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bll.services;

import gui.models.LoaiKhachHang.CreateLoaiKhachHangModel;
import gui.models.LoaiKhachHang.LoaiKhachHangModel;
import gui.models.LoaiKhachHang.UpdateLoaiKhachHangModel;
import java.util.List;

/**
 *
 * @author tuant
 */
public interface ILoaiKhachHangService {
    List<LoaiKhachHangModel> getAll();
    
    LoaiKhachHangModel getById(int id);
    
    boolean createLoaiKhachHang(CreateLoaiKhachHangModel createLoaiKhachHangModel);
    
    boolean updateLoaiKhachHang(UpdateLoaiKhachHangModel updateLoaiKhachHangModel);
    
    boolean delete(int id);
}
