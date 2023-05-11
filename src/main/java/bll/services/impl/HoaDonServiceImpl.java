/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.services.impl;

import bll.mappers.HoaDonMapper;
import bll.services.IHoaDonService;
import dal.entity.HoaDon;
import dal.repository.HoaDonRepository;
import gui.constraint.TinhTrangHoaDonConstraints;
import gui.models.HoaDon.HoaDonFullModel;
import gui.models.HoaDon.HoaDonModel;
import gui.models.HoaDon.SearchHoaDonModel;
import java.util.List;

/**
 *
 * @author tanph
 */
public class HoaDonServiceImpl implements IHoaDonService{
    HoaDonRepository hoaDonRepository;

    public HoaDonServiceImpl(){
        hoaDonRepository = new HoaDonRepository();
    }
    
    @Override
    public List<HoaDonModel> getAll() {
        List<HoaDon> listHoaDon = hoaDonRepository.getAllHoaDon();
        List<HoaDonModel> listHoaDonModel = HoaDonMapper.toListHoaDonModel(listHoaDon);
    
        return listHoaDonModel;
    }

    @Override
    public HoaDonFullModel getHoaDonFullById(int id) {
        HoaDon hoaDon = hoaDonRepository.getById(id);
        HoaDonFullModel hoaDonFullModel = HoaDonMapper.toHoaDonFullModel(hoaDon);
        
        return hoaDonFullModel;
    }

    @Override
    public List<HoaDonModel> search(SearchHoaDonModel searchHoaDonModel) {
        List<HoaDon> listHoaDon = hoaDonRepository.search(searchHoaDonModel);
        List<HoaDonModel> listHoaDonModel = HoaDonMapper.toListHoaDonModel(listHoaDon);
    
        return listHoaDonModel;
    }

    @Override
    public boolean huyHoaDon(HoaDonFullModel hoaDonSelected) {
        if(hoaDonSelected.isDaHuy() ==  TinhTrangHoaDonConstraints.HOP_LE){
            HoaDon hoaDon = hoaDonRepository.huyHoaDon(hoaDonSelected.getId());
            return true;
        } else {
            return false;
        }
    }
}
