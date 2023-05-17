package bll.services.impl;

import bll.mappers.MonAnMapper;
import bll.services.IMonAnService;
import dal.entity.MonAn;
import dal.repository.MonAnRepository;
import gui.constraints.TinhTrangMonAnConstraints;
import gui.models.MonAn.CreateMonAnModel;
import gui.models.MonAn.MonAnFullModel;
import gui.models.MonAn.MonAnModel;
import gui.models.MonAn.SearchMonAnModel;
import gui.models.MonAn.UpdateMonAnModel;
import java.util.List;
/**
 *
 * @author LeAnhQuan
 */
public class MonAnServiceImpl implements IMonAnService{
    MonAnRepository monAnRepository;

    public MonAnServiceImpl() {
        monAnRepository = new MonAnRepository();
    }    
    
    @Override
    public List<MonAnModel> getAll(boolean hienDaXoa) {
        List<MonAn> listMonAn = monAnRepository.getAll();       
        
        if (!hienDaXoa) {
            listMonAn.removeIf(monAn -> 
                    monAn.getTinhTrangMonAn().getId() == TinhTrangMonAnConstraints.DA_XOA
            );
        }
        
        List<MonAnModel> listMonAnModel = MonAnMapper.toListMonAnModel(listMonAn);
        
        
        return listMonAnModel;
    }

    @Override
    public MonAnFullModel getFullById(int id) {
        MonAn monAn = monAnRepository.getById(id);
        MonAnFullModel monAnFullModel = MonAnMapper.toMonAnFullModel(monAn);
        
        return monAnFullModel;
    }

    @Override
    public List<MonAnModel> search(SearchMonAnModel searchMonAnModel, boolean hienDaXoa) {
        List<MonAn> listMonAn = monAnRepository.search(searchMonAnModel);        
        
        if (!hienDaXoa) {
            listMonAn.removeIf(monAn -> 
                    monAn.getTinhTrangMonAn().getId() == TinhTrangMonAnConstraints.DA_XOA
            );
        }
        
        List<MonAnModel> listMonAnModel = MonAnMapper.toListMonAnModel(listMonAn);
        
        return listMonAnModel;
    }
    
    @Override
    public boolean create(CreateMonAnModel createMonAnModel){
        if(!validateCreate(createMonAnModel))
            return false;
        
        MonAn monAn = MonAnMapper.toMonAn(createMonAnModel);
        MonAn createdMonAn = monAnRepository.create(monAn);
        
        return createdMonAn.getId() > 0;
    }
    
    private boolean validateCreate(CreateMonAnModel createMonAnModel){
        MonAn monAn = monAnRepository.getByName(createMonAnModel.getTen());
        
        return monAn == null;
    }

    @Override
    public boolean update(UpdateMonAnModel updateMonAnModel) {
        if(!validateUpdate(updateMonAnModel))
            return false;
        
        MonAn monAn = MonAnMapper.toMonAn(updateMonAnModel);
        MonAn updatedMonAn = monAnRepository.update(monAn);
        
        return updatedMonAn.getId() > 0;
    }
    
    private boolean validateUpdate(UpdateMonAnModel updateMonAnModel){
        MonAn monAn = monAnRepository.getByName(updateMonAnModel.getTen());
        
        return monAn == null || monAn.getId() == updateMonAnModel.getId();
    }

    @Override
    public boolean chuyenTinhTrangMonAn(MonAnFullModel monAnSelected) {
        int idTinhTrang = monAnSelected.getTinhTrangMonAnModel().getId() == TinhTrangMonAnConstraints.CON_PHUC_VU ?
                TinhTrangMonAnConstraints.HET :
                TinhTrangMonAnConstraints.CON_PHUC_VU;
                
        
        MonAn monAn = monAnRepository.updateTinhTrang(monAnSelected.getId(), idTinhTrang);
        
        return monAn.getTinhTrangMonAn().getId() == idTinhTrang;
    }

    @Override
    public boolean delete(int id) {
        MonAn monAn = monAnRepository.getById(id);
        if(!monAn.getListDonGoi().isEmpty())
            return false;
        
        monAnRepository.delete(id);
        
        return true;
    }
}
