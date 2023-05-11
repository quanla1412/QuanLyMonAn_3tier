package bll.services.impl;

import bll.mappers.BanMapper;
import dal.entity.Ban;
import java.util.List;
import bll.services.IBanService;
import dal.entity.TinhTrangBan;
import dal.repository.BanRepository;
import dal.repository.TinhTrangBanRepository;
import gui.models.Ban.BanFullModel;
import gui.models.Ban.CreateBanModel;
import gui.models.Ban.UpdateBanModel;
import gui.models.BanModel;

/**
 *
 * @author LeAnhQuan
 */
public class BanServiceImpl implements IBanService{
    private final BanRepository banRepository;
    private final TinhTrangBanRepository tinhTrangBanRepository;

    public BanServiceImpl() {
        banRepository = new BanRepository();
        tinhTrangBanRepository = new TinhTrangBanRepository();
    }
    
    @Override
    public List<BanModel> getAll() {
        List<Ban> listBan = banRepository.getAll();
        List<BanModel> listBanModel = BanMapper.toListBanModel(listBan);        
        
        return listBanModel;
    }

    @Override
    public BanModel getById(int id) {
        Ban ban = banRepository.getById(id);
        BanModel banModel = BanMapper.toBanModel(ban);
        
        return banModel;
    }

    @Override
    public BanFullModel getFullById(int id) {
        Ban ban = banRepository.getById(id);
        BanFullModel banFullModel = BanMapper.toBanFullModel(ban);
        
        return banFullModel;
    }
        
    @Override
    public List<BanFullModel> getAllFull(){
        List<Ban> listBan = banRepository.getAll();
        List<BanFullModel> listBanModel = BanMapper.toListBanFullModel(listBan);        
        
        return listBanModel;        
    }

    @Override
    public List<BanModel> getByTinhTrang(int idTinhTrangBan) {
        TinhTrangBan tinhTrangBan = tinhTrangBanRepository.getById(idTinhTrangBan);
        List<Ban> listBan = tinhTrangBan.getListBan();
        List<BanModel> listBanModel = BanMapper.toListBanModel(listBan);        
        
        return listBanModel;  
    }

    @Override
    public boolean createBan(CreateBanModel createBanModel) {
        Ban ban = BanMapper.toBan(createBanModel);
        Ban createdBan = banRepository.createBan(ban);
        
        return createdBan.getId() > 0;
    }

    @Override
    public boolean updateBan(UpdateBanModel updateBanModel) {
        Ban ban = BanMapper.toBan(updateBanModel);
        Ban updatedBan = banRepository.updateBan(ban);
        
        return true;
    }

    @Override
    public boolean changeTinhTrangBan(int idBan, int idTinhTrangBan) {        
        Ban ban = banRepository.getById(idBan);
        TinhTrangBan tinhTrangBan = tinhTrangBanRepository.getById(idTinhTrangBan);
        ban.setTinhTrangBan(tinhTrangBan);
        banRepository.updateBan(ban);
        
        return ban.getTinhTrangBan().getId() == idTinhTrangBan;
    }

    @Override
    public boolean delete(int id) {
        banRepository.delete(id);
        
        return true;
    }
}
