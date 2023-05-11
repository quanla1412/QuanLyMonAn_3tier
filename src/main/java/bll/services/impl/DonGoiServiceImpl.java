package bll.services.impl;

import bll.mappers.DonGoiMapper;
import bll.services.IDonGoiService;
import dal.entity.Ban;
import dal.entity.DonGoi;
import dal.repository.BanRepository;
import dal.repository.DonGoiRepository;
import gui.models.DonGoi.CreateDonGoiModel;
import gui.models.DonGoi.DonGoiMasterModel;
import gui.models.DonGoi.DonGoiModel;
import gui.models.DonGoi.UpdateDonGoiModel;
import java.util.List;

/**
 *
 * @author LeAnhQuan
 */
public class DonGoiServiceImpl implements IDonGoiService {
    BanRepository banRepository;
    DonGoiRepository donGoiRepository;

    public DonGoiServiceImpl() {
        banRepository = new BanRepository();
        donGoiRepository = new DonGoiRepository();
    }
    

    @Override
    public List<DonGoiModel> getByBan(int idBan) {
        Ban ban = banRepository.getById(idBan);
        List<DonGoi> listDonGoi = ban.getListDonGoi();
        List<DonGoiModel> listDonGoiModel = DonGoiMapper.toListDonGoiModel(listDonGoi);
        for(DonGoiModel donGoiModel : listDonGoiModel) {
            if(donGoiModel.getMonAn().getGiaKhuyenMai() >= 0){
                donGoiModel.setGia(donGoiModel.getMonAn().getGiaKhuyenMai());
            }
            else {
                donGoiModel.setGia(donGoiModel.getMonAn().getGia());           
            }
            donGoiModel.setThanhTien(donGoiModel.getGia() * donGoiModel.getSoLuong());
        }
        
        return listDonGoiModel;
    }
    
    @Override
    public DonGoiMasterModel getMasterByBan(int idBan){
        Ban ban = banRepository.getById(idBan);
        List<DonGoi> listDonGoi = ban.getListDonGoi();
        List<DonGoiModel> listDonGoiModel = DonGoiMapper.toListDonGoiModel(listDonGoi);
        
        DonGoiMasterModel donGoiMaster = new DonGoiMasterModel();
        donGoiMaster.setListDonGoiModel(listDonGoiModel);
        
        int total = 0;
        for(DonGoiModel donGoiModel : listDonGoiModel) {
            if(donGoiModel.getMonAn().getGiaKhuyenMai() >= 0){
                donGoiModel.setGia(donGoiModel.getMonAn().getGiaKhuyenMai());
                total += donGoiModel.getMonAn().getGiaKhuyenMai() * donGoiModel.getSoLuong();
            }
            else {
                donGoiModel.setGia(donGoiModel.getMonAn().getGia());
                total += donGoiModel.getMonAn().getGia() * donGoiModel.getSoLuong();                
            }
            donGoiModel.setThanhTien(donGoiModel.getGia() * donGoiModel.getSoLuong());
        }
        donGoiMaster.setTotal(total);
        
        return donGoiMaster;        
    }

    @Override
    public boolean chuyenBan(int idBanCu, int idBanMoi) {
        Ban banCu = banRepository.getById(idBanCu);
        Ban banMoi = banRepository.getById(idBanMoi);
        
        if(!banMoi.getListDonGoi().isEmpty())
            return false;
        
        banCu.getListDonGoi().forEach(donGoi -> {
            donGoi.setBan(banMoi);
            donGoiRepository.delete(donGoi);
            donGoiRepository.create(donGoi);
        });
        
        return true;
    }

    @Override
    public DonGoiModel getByKey(int idBan, int idMonAn) {
        DonGoi donGoi = donGoiRepository.getByKey(idBan, idMonAn);
        DonGoiModel donGoiModel = DonGoiMapper.toDonGoiModel(donGoi);
        
        return donGoiModel;
    }

    @Override
    public boolean create(CreateDonGoiModel createDonGoiModel) {
        DonGoi donGoi = DonGoiMapper.toDonGoi(createDonGoiModel);
        if(!validateCreate(donGoi))
            return false;
        
        DonGoi createdDonGoi = donGoiRepository.create(donGoi);
        
        return true;
    }
    
    public boolean validateCreate(DonGoi data){
        DonGoi donGoi = donGoiRepository.getByKey(data.getBan().getId(), data.getMonAn().getId());
        
        return donGoi == null;
    }  
    
    @Override
    public boolean update(UpdateDonGoiModel updateDonGoiModel) {
        DonGoi donGoi = DonGoiMapper.toDonGoi(updateDonGoiModel);
        DonGoi updatedDonGoi = donGoiRepository.update(donGoi);
        
        return true;
    }

    @Override
    public boolean delete(int idBan, int idMonAn) {
        DonGoi donGoi = donGoiRepository.getByKey(idBan, idMonAn);
        if(donGoi == null)
            return false;
        donGoiRepository.delete(donGoi);
        
        DonGoi check = donGoiRepository.getByKey(idBan, idMonAn);
        return check == null; 
    }
}
