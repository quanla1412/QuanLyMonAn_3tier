/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.services.impl;

import bll.mappers.HoaDonMapper;
import bll.services.IBanService;
import bll.services.IDonGoiService;
import bll.services.IHoaDonService;
import dal.entity.HoaDon;
import dal.repository.HoaDonRepository;
import gui.constraint.TinhTrangHoaDonConstraints;
import gui.constraints.TinhTrangBanConstraints;
import gui.models.HoaDon.CreateHoaDonModel;
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
    IDonGoiService donGoiService;
    IBanService banService;

    public HoaDonServiceImpl(){
        hoaDonRepository = new HoaDonRepository();
        donGoiService = new DonGoiServiceImpl();
        banService = new BanServiceImpl();
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

    @Override
    public boolean create(CreateHoaDonModel createHoaDonModel) {
        HoaDon hoaDon = HoaDonMapper.toHoaDon(createHoaDonModel);
        HoaDon createdHoaDon = hoaDonRepository.create(hoaDon);
        
        boolean result = createdHoaDon.getId() > 0;
        if(!result)
            return false;
        
        result = donGoiService.delete(createHoaDonModel.getIdBan());        
        if(!result)
            return false;
        
        result = banService.changeTinhTrangBan(createHoaDonModel.getIdBan(), TinhTrangBanConstraints.DANG_CHUAN_BI);
        
        return result;
    }
}
