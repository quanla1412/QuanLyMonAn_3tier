/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.services.impl;
import bll.mappers.LoaiKhachHangMapper;
import bll.services.ILoaiKhachHangService;
import dal.entity.LoaiKhachHang;
import dal.repository.LoaiKhachHangRepository;
import gui.models.LoaiKhachHang.CreateLoaiKhachHangModel;
import gui.models.LoaiKhachHang.LoaiKhachHangModel;
import gui.models.LoaiKhachHang.UpdateLoaiKhachHangModel;
import java.util.List;
/**
 *
 * @author tuant
 */
public class LoaiKhachHangServiceImpl implements ILoaiKhachHangService{
    private final LoaiKhachHangRepository loaiKhachHangRepository;

    public LoaiKhachHangServiceImpl() {
        loaiKhachHangRepository = new LoaiKhachHangRepository();
    }
    
    @Override
    public List<LoaiKhachHangModel> getAll() {
        List<LoaiKhachHang> listLoaiKhachHang = loaiKhachHangRepository.getAll();
        List<LoaiKhachHangModel> listLoaiKhachHangModel = LoaiKhachHangMapper.toListLoaiKhachHangModel(listLoaiKhachHang);
                
        return listLoaiKhachHangModel;        
    }
    
    public LoaiKhachHangModel getById(int id) {
        LoaiKhachHang loaiKhachHang = loaiKhachHangRepository.getById(id);
        LoaiKhachHangModel loaiKhachHangModel = LoaiKhachHangMapper.toLoaiKhachHangModel(loaiKhachHang);
        
        return loaiKhachHangModel;
    }
    
    public boolean createLoaiKhachHang(CreateLoaiKhachHangModel createLoaiKhachHangModel) {
        LoaiKhachHang loaiKhachHang = LoaiKhachHangMapper.toLoaiKhachHang(createLoaiKhachHangModel);
        
        if(!kiemTraCreate(loaiKhachHang))
            return false;
        
        LoaiKhachHang createdLoaiKhachHang = loaiKhachHangRepository.createLoaiKhachHang(loaiKhachHang);
        
        if(createdLoaiKhachHang.getId() > 0)
            return true;
        return false;
    }

    @Override
    public boolean updateLoaiKhachHang(UpdateLoaiKhachHangModel updateLoaiKhachHangModel) {
        LoaiKhachHang loaiKhachHang = LoaiKhachHangMapper.toLoaiKhachHang(updateLoaiKhachHangModel);
        
        if(!kiemTraUpdate(loaiKhachHang))
            return false;
        
        LoaiKhachHang updatedLoaiKhachHang = loaiKhachHangRepository.updateLoaiKhachHang(loaiKhachHang);
        
        return true;
    }
    public boolean kiemTraCreate(LoaiKhachHang loaiKhachHang){
        return loaiKhachHangRepository.getByName(loaiKhachHang.getTen()) == null;
    }
    
    public boolean kiemTraUpdate(LoaiKhachHang loaiKhachHang){
        LoaiKhachHang loaiKhachHangChecked = loaiKhachHangRepository.getByName(loaiKhachHang.getTen());
        return loaiKhachHangChecked == null || loaiKhachHangChecked.getId() == loaiKhachHang.getId();
    }
    public boolean delete(int id) {
        LoaiKhachHang loaiKhachHang = loaiKhachHangRepository.getById(id);
        if(!loaiKhachHang.getListKhachHang().isEmpty())
            return false;
        
        loaiKhachHangRepository.delete(id);
        return true;
    }
}
