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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tuant
 */
public interface IKhachHangService {
    List<KhachHangModel> getAll();
    
    KhachHangFullModel getById(int id);
    
    KhachHangModel getBySoDienThoai(String soDienThoai);
    
    KhachHangFullModel getFullBySoDienThoai(String soDienThoai);
    
    List<KhachHangModel> search(SearchKhachHangModel searchKhachHangModel);
    
    boolean createKhachHang(CreateKhachHangModel createKhachHangModel);
    
    boolean updateKhachHang(UpdateKhachHangModel updateKhachHangModel);
    
    Map<String, Integer> countByLoaiKhachHang();
    
    Map<String, Integer> countByGioiTinh();
    
    Map<String, Integer> countByTuoi();
    
    boolean exportKhachHang(ArrayList<KhachHangModel> listKhachHangModels, String filePath);
    
    boolean exportAllKhachHangTheoMauImport(String filePath);
    
    int importKhachHang(String filePath);
    
    void updateLoaiKhachHang();
    
    void updateLoaiKhachHang(int idKhachHang);
    
    void updateDiemTichLuy(int idKhachHang, int diemTichLuyCongThem);
}
