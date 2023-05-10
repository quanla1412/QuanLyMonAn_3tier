/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.services.impl;

import bll.mappers.NhanVienMapper;
import bll.services.IChucVuService;
import bll.services.INhanVienSerivice;
import bll.services.ITinhTrangNhanVienService;
import dal.entity.NhanVien;
import dal.repository.ChucVuRepository;
import dal.repository.NhanVienRepository;
import dal.repository.TinhTrangNhanVienRepository;
import gui.models.NhanVien.CreateNhanVienModel;
import gui.models.NhanVien.NhanVienFullModel;
import gui.models.NhanVien.NhanVienModel;
import gui.models.NhanVien.UpdateNhanVienModel;
import java.util.List;

/**
 *
 * @author dinhn
 */
public class NhanVienServiceImpl implements INhanVienSerivice{
    private final NhanVienRepository nhanVienRepository;
 
    
    public NhanVienServiceImpl(){
        nhanVienRepository = new NhanVienRepository();
    }
            
    @Override
    public List<NhanVienModel> getAll() {
       List<NhanVien> listNhanVien = nhanVienRepository.getAll();
       List<NhanVienModel> listNhanVienModel = NhanVienMapper.toListNhanVienModel(listNhanVien);
       
       return listNhanVienModel;
    }


    @Override
    public NhanVienFullModel getByMa(String ma) {
        NhanVien nhanVien = nhanVienRepository.getByMa(ma);
        NhanVienFullModel nhanVienFullModel = NhanVienMapper.toNhanVienFullModel(nhanVien);
        
        return nhanVienFullModel;
    }

    @Override
    public boolean createNhanVien(CreateNhanVienModel createNhanVienModel) {
       NhanVien nhanVien = NhanVienMapper.toNhanVien(createNhanVienModel);
       NhanVien createNhanVien = nhanVienRepository.createNhanVien(nhanVien);
       
       return true;
    }

    @Override
    public boolean updateNhanVien(UpdateNhanVienModel updateNhanVienModel) {
       NhanVien nhanVien = NhanVienMapper.toNhanVien(updateNhanVienModel);
       
       NhanVien updateNhanVien = nhanVienRepository.updateNhanVien(nhanVien);
       
       return true;
    }


    @Override
    public boolean delete(String ma) {
       nhanVienRepository.delete(ma);
       
       return true;
    }
    
    
}
