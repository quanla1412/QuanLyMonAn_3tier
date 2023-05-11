/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.services.impl;

import bll.mappers.KhachHangMapper;
import bll.services.IKhachHangService;
import dal.entity.KhachHang;
import dal.repository.KhachHangRepository;
import gui.models.KhachHang.KhachHangFullModel;
import gui.models.KhachHang.CreateKhachHangModel;
import gui.models.KhachHang.KhachHangModel;
import gui.models.KhachHang.SearchKhachHangModel;
import gui.models.KhachHang.UpdateKhachHangModel;
import gui.models.LoaiKhachHang.CreateLoaiKhachHangModel;
import gui.models.LoaiKhachHang.UpdateLoaiKhachHangModel;
import java.util.List;

/**
 *
 * @author tuant
 */
public class KhachHangServiceImpl implements IKhachHangService {
    private final KhachHangRepository khachHangRepository;

    public KhachHangServiceImpl() {
        khachHangRepository = new KhachHangRepository();
    }
    
    public List<KhachHangModel> getAll() {
        List<KhachHang> listKhachHang = khachHangRepository.getAll();
        List<KhachHangModel> listKhachHangModel = KhachHangMapper.toListKhachHangModel(listKhachHang);
                
        return listKhachHangModel;        
    }
    
    public KhachHangFullModel getById(int id) {
        KhachHang khachHang = khachHangRepository.getById(id);
        KhachHangFullModel khachHangModel = KhachHangMapper.toKhachHangFullModel(khachHang);
        
        return khachHangModel;
    }

    @Override
    public List<KhachHangModel> search(SearchKhachHangModel searchKhachHangModel) {
        List<KhachHang> listKhachHang = khachHangRepository.search(searchKhachHangModel);
        List<KhachHangModel> listKhachHangModel = KhachHangMapper.toListKhachHangModel(listKhachHang);
                
        return listKhachHangModel; 
    }
    
    @Override
    public boolean createKhachHang(CreateKhachHangModel createKhachHangModel) {
        KhachHang khachHang = KhachHangMapper.toKhachHang(createKhachHangModel);
        KhachHang createdKhachHang = khachHangRepository.createKhachHang(khachHang);
        
        return createdKhachHang.getId() > 0;
    }
    @Override
    public boolean updateKhachHang(UpdateKhachHangModel updateKhachHangModel) {
        KhachHang khachHang = KhachHangMapper.toKhachHang(updateKhachHangModel);
        KhachHang updatedKhachHang = khachHangRepository.updateKhachHang(khachHang);
        
        return true;
    }

    
}
