/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.services.impl;

import bll.mappers.KhachHangMapper;
import bll.services.IKhachHangService;
import dal.entity.KhachHang;
import dal.entity.LoaiKhachHang;
import dal.repository.KhachHangRepository;
import dal.repository.LoaiKhachHangRepository;
import gui.models.KhachHang.KhachHangFullModel;
import gui.models.KhachHang.CreateKhachHangModel;
import gui.models.KhachHang.KhachHangModel;
import gui.models.KhachHang.SearchKhachHangModel;
import gui.models.KhachHang.UpdateKhachHangModel;
import gui.models.LoaiKhachHang.CreateLoaiKhachHangModel;
import gui.models.LoaiKhachHang.UpdateLoaiKhachHangModel;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tuant
 */
public class KhachHangServiceImpl implements IKhachHangService {
    private final KhachHangRepository khachHangRepository;
    private final LoaiKhachHangRepository loaiKhachHangRepository;

    public KhachHangServiceImpl() {
        khachHangRepository = new KhachHangRepository();
        loaiKhachHangRepository = new LoaiKhachHangRepository();
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

    @Override
    public KhachHangModel getBySoDienThoai(String soDienThoai) {
        KhachHang khachHang = khachHangRepository.getBySoDienThoai(soDienThoai);
        KhachHangModel khachHangModel = KhachHangMapper.toKhachHangModel(khachHang);
        
        return khachHangModel;
    }

    @Override
    public KhachHangFullModel getFullBySoDienThoai(String soDienThoai) {
        KhachHang khachHang = khachHangRepository.getBySoDienThoai(soDienThoai);
        KhachHangFullModel khachHangFullModel = KhachHangMapper.toKhachHangFullModel(khachHang);
        
        return khachHangFullModel;
    }

    @Override
    public Map<String, Integer> countByLoaiKhachHang() {
        Map<String, Integer> result = new HashMap<>();
        ArrayList<LoaiKhachHang> listLoaiKhachHang = loaiKhachHangRepository.getAll();
        
        listLoaiKhachHang.forEach(loaiKhachHang -> result.put(loaiKhachHang.getTen(), loaiKhachHang.getListKhachHang().size()));
        
        return result;
    }

    @Override
    public Map<String, Integer> countByGioiTinh() {
        Map<String, Integer> result = new HashMap<>();
        ArrayList<KhachHang> listKhachHang = (ArrayList<KhachHang>) khachHangRepository.getAll();
        
        int nam = 0;
        int nu = 0;
        
        for(KhachHang khachHang : listKhachHang) {
            if(khachHang.isGioiTinhNam())
                nam++;
            else
                nu++;
        }
        
        result.put("Nam", nam);
        result.put("Nữ", nu);
        
        return result;
    }

    @Override
    public Map<String, Integer> countByTuoi() {
        Map<String, Integer> result = new HashMap<>();
        ArrayList<KhachHang> listKhachHang = (ArrayList<KhachHang>) khachHangRepository.getAll();
        
        int u20=0;
        int u30=0;
        int u40=0;
        int conLai=0;
        for(KhachHang khachHang : listKhachHang){
            Timestamp ngaySinh = new Timestamp(khachHang.getNgaySinh().getTime());
            int tuoi = Period.between(ngaySinh.toLocalDateTime().toLocalDate(), LocalDate.now()).getYears();
            if (tuoi < 20) {
                u20++;
            }
            else if(tuoi < 30){
                u30++;
            }
            else if(tuoi < 40){
                u40++;
            }
            else 
                conLai++;               
        }
        if(u20>0) result.put("Dưới 20", u20);
        if(u30>0) result.put("Từ 20 - 29", u30);
        if(u40>0) result.put("Từ 30 - 39", u40);
        if(conLai>0) result.put("Từ 40 trở lên", conLai);
        
        return result;
    }

    
}
