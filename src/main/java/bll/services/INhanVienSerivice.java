/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.services;

import dal.entity.NhanVien;
import gui.models.NhanVien.CreateNhanVienModel;
import gui.models.NhanVien.NhanVienFullModel;
import gui.models.NhanVien.NhanVienModel;
import gui.models.NhanVien.SearchNhanVienModel;
import gui.models.NhanVien.UpdateNhanVienModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dinhn
 */
public interface INhanVienSerivice {
     List<NhanVienModel> getAll();
    
    
    NhanVienFullModel getByMa(String ma);
    
    List<NhanVienModel> search(SearchNhanVienModel searchNhanVienModel);
    
    boolean createNhanVien(CreateNhanVienModel createNhanVienModel);

    boolean updateNhanVien(UpdateNhanVienModel updateNhanVienModel);
    
    boolean delete(String ma);
    
    
    
    
}
