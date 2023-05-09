package bll.services.impl;

import bll.mappers.LoaiBanMapper;
import bll.services.ILoaiBanService;
import dal.entity.Ban;
import dal.entity.LoaiBan;
import dal.repository.LoaiBanRepository;
import gui.models.CreateLoaiBanModel;
import gui.models.LoaiBanModel;
import gui.models.UpdateLoaiBanModel;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;

/**
 *
 * @author LeAnhQuan
 */
public class LoaiBanServiceImpl implements ILoaiBanService{
    private final LoaiBanRepository loaiBanRepository;
    
    public LoaiBanServiceImpl(){
        loaiBanRepository = new LoaiBanRepository();
    }
    
    @Override
    public List<LoaiBanModel> getAll() {
        List<LoaiBan> listLoaiBan = loaiBanRepository.getAll();
        List<LoaiBanModel> listLoaiBanModel = LoaiBanMapper.toLoaiBanModelList(listLoaiBan);
        
        return listLoaiBanModel;
    }

    @Override
    public LoaiBanModel getById(int id) {
        LoaiBan loaiBan = loaiBanRepository.getById(id);
        LoaiBanModel loaiBanModel = LoaiBanMapper.toLoaiBanModel(loaiBan);
        
        return loaiBanModel;
    }

    @Override
    public boolean createLoaiBan(CreateLoaiBanModel createLoaiBanModel) {
        LoaiBan loaiBan = LoaiBanMapper.toLoaiBan(createLoaiBanModel);
        
        if(!validateCreate(loaiBan))
            return false;
        
        LoaiBan createdLoaiBan = loaiBanRepository.createLoaiBan(loaiBan);
        
        if(createdLoaiBan.getId() > 0)
            return true;
        return false;
    }

    @Override
    public boolean updateLoaiBan(UpdateLoaiBanModel updateLoaiBanModel) {
        LoaiBan loaiBan = LoaiBanMapper.toLoaiBan(updateLoaiBanModel);
        
        if(!validateUpdate(loaiBan))
            return false;
        
        LoaiBan updatedLoaiBan = loaiBanRepository.updateLoaiBan(loaiBan);
        
        return true;
    }

    @Override
    public boolean deleteLoaiBan(int id) {
        LoaiBan loaiBan = loaiBanRepository.getById(id);
        if(!loaiBan.getListBan().isEmpty())
            return false;
        
        loaiBanRepository.deleteLoaiBan(id);
        return true;
    }
    
    public boolean validateCreate(LoaiBan loaiBan){
        return loaiBanRepository.getByName(loaiBan.getTen()) == null;
    }
    
    public boolean validateUpdate(LoaiBan loaiBan){
        LoaiBan loaiBanChecked = loaiBanRepository.getByName(loaiBan.getTen());
        return loaiBanChecked == null || loaiBanChecked.getId() == loaiBan.getId();
    }
}
