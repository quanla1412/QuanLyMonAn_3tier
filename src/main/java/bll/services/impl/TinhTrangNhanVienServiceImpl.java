/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.services.impl;

import bll.mappers.TinhTrangNhanVienMapper;
import bll.services.ITinhTrangNhanVienService;
import dal.entity.TinhTrangNhanVien;
import dal.repository.TinhTrangNhanVienRepository;
import gui.models.NhanVien.TinhTrangNhanVienModel;
import java.util.List;

/**
 *
 * @author dinhn
 */
public class TinhTrangNhanVienServiceImpl implements ITinhTrangNhanVienService{
    
    TinhTrangNhanVienRepository tinhTrangNhanVienRepository;
    
    public TinhTrangNhanVienServiceImpl(){
        tinhTrangNhanVienRepository = new TinhTrangNhanVienRepository();
    }

    @Override
    public List<TinhTrangNhanVienModel> getAll() {
        List<TinhTrangNhanVien> listTinhTrangNhanVien = tinhTrangNhanVienRepository.getAll();
        List<TinhTrangNhanVienModel> listTinhTrangNhanVienModels = TinhTrangNhanVienMapper.toListTinhTrangNhanVienModel(listTinhTrangNhanVien);
        
        return listTinhTrangNhanVienModels;
    }

    @Override
    public TinhTrangNhanVienModel getById(int id) {
       TinhTrangNhanVien tinhTrangNhanVien = tinhTrangNhanVienRepository.getById(id);
       TinhTrangNhanVienModel tinhTrangNhanVienModel = TinhTrangNhanVienMapper.toTinhTrangNhanVienModel(tinhTrangNhanVien);
        
      return tinhTrangNhanVienModel;
    }
    
    
    
}
