/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.services;


import gui.models.NhanVien.CreateNhanVienModel;
import gui.models.NhanVien.NhanVienFullModel;
import gui.models.NhanVien.NhanVienModel;
import gui.models.NhanVien.SearchNhanVienModel;
import gui.models.NhanVien.UpdateTaiKhoanNhanVienModel;
import gui.models.NhanVien.UpdateNhanVienModel;
import gui.models.TaiKhoanModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dinhn
 */
public interface INhanVienService {
     List<NhanVienModel> getAll();
    
    
    NhanVienFullModel getByMa(String ma);
    
    List<NhanVienModel> search(SearchNhanVienModel searchNhanVienModel);
    
    boolean createNhanVien(CreateNhanVienModel createNhanVienModel);

    boolean updateNhanVien(UpdateNhanVienModel updateNhanVienModel);
    
    boolean delete(String ma);
    
    boolean exportNhanVien(ArrayList<NhanVienModel> listNhanVienModels, String filePath);
    
    boolean exportAllNhanVienTheoMauImport(String filePath);
    
    int importNhanVien(String filePath);  
    
    Map<String, Integer> countByGioiTinh(); 
    
    Map<String, Integer> countByTinhTrang();
    
    Map<String, Integer> countByTuoi();
    
    Map<String, Long> getDoanhThuTheoThangHienTai();
    
    boolean dangNhap (TaiKhoanModel taiKhoanModel);
    
    boolean updateTaiKhoanNhanVien(UpdateTaiKhoanNhanVienModel updateMatKhauNhanVienModel);
}
