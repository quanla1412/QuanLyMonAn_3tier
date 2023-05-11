/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bll.services;

import gui.models.KhachHang.CreateKhachHangModel;
import gui.models.KhachHang.KhachHangFullModel;
import gui.models.KhachHang.KhachHangModel;
import gui.models.KhachHang.SearchKhachHangModel;
import gui.models.KhachHang.UpdateKhachHangModel;
import java.util.List;

/**
 *
 * @author tuant
 */
public interface IKhachHangService {
    List<KhachHangModel> getAll();
    
    KhachHangFullModel getById(int id);
    
    List<KhachHangModel> search(SearchKhachHangModel searchKhachHangModel);
    
    boolean createKhachHang(CreateKhachHangModel createKhachHangModel);
    
    boolean updateKhachHang(UpdateKhachHangModel updateKhachHangModel);
}
