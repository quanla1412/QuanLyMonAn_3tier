/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.services;

import gui.models.NhanVien.ChucVuModel;
import gui.models.NhanVien.CreateChucVuModel;
import gui.models.NhanVien.UpdateChucVuModel;
import java.util.List;

/**
 *
 * @author dinhn
 */
public interface IChucVuService {
    List<ChucVuModel> getAll();
    
    ChucVuModel getById(int id);
    
    boolean createChucVu(CreateChucVuModel createChucVuModel);
   
    boolean updateChucVu(UpdateChucVuModel updateChucVuModel);
    
    boolean deleteChucVu(int idChucVu);
   
}
