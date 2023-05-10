/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.services.impl;

import gui.models.KhachHang.UpdateKhachHangModel;
import bll.mappers.KhachHangMapper;
import bll.services.IKhachHangService;
import dal.entity.KhachHang;
import dal.repository.KhachHangRepository;
import gui.models.KhachHang.KhachHangFullModel;
import gui.models.KhachHang.KhachHangModel;
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
    @Override
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
    public boolean createKhachHang(CreateKhachHangModel createKhachHangModel) {
        KhachHang khachHang = KhachHangMapper.toKhachHang(createKhachHangModel);
        
        if(!kiemTraCreate(khachHang))
            return false;
        
        KhachHang createdKhachHang = khachHangRepository.createKhachHang(khachHang);
        
        if(createdKhachHang.getId() > 0)
            return true;
        return false;
    }
 
    public boolean updateKhachHang(UpdateKhachHangModel updateKhachHangModel) {
        KhachHang khachHang = KhachHangMapper.toKhachHang(updateKhachHangModel);
        
        if(!kiemTraUpdate(khachHang))
            return false;
        
        KhachHang updatedKhachHang = khachHangRepository.updateKhachHang(khachHang);
        
        return true;
    }
}
