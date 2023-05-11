/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.services;

import gui.models.NhanVien.TinhTrangNhanVienModel;
import java.util.List;

/**
 *
 * @author dinhn
 */
public interface ITinhTrangNhanVienService {
    List<TinhTrangNhanVienModel> getAll();
    
    TinhTrangNhanVienModel getById(int id);
    
}
