package bll.services.impl;

import bll.mappers.LoaiMonAnMapper;
import bll.services.ILoaiMonAnService;
import dal.entity.LoaiMonAn;
import dal.repository.LoaiMonAnRepository;
import gui.models.LoaiMonAn.CreateLoaiMonAnModel;
import gui.models.LoaiMonAn.LoaiMonAnModel;
import java.util.List;

/**
 *
 * @author LeAnhQuan
 */
public class LoaiMonAnServiceImpl implements ILoaiMonAnService{
    private final LoaiMonAnRepository loaiMonAnRepository;

    public LoaiMonAnServiceImpl() {
        loaiMonAnRepository = new LoaiMonAnRepository();
    }
    
    @Override
    public List<LoaiMonAnModel> getAll() {
        List<LoaiMonAn> listLoaiMonAn = loaiMonAnRepository.getAll();
        List<LoaiMonAnModel> listLoaiMonAnModel = LoaiMonAnMapper.toListLoaiMonAnModel(listLoaiMonAn);
        
        return listLoaiMonAnModel;
    }

    @Override
    public LoaiMonAnModel getById(int id) {
        LoaiMonAn loaiMonAn = loaiMonAnRepository.getById(id);
        LoaiMonAnModel loaiMonAnModel = LoaiMonAnMapper.toLoaiMonAnModel(loaiMonAn);
        
        return loaiMonAnModel;
    }

    @Override
    public boolean create(CreateLoaiMonAnModel createLoaiMonAnModel){ 
        if(!validateCreate(createLoaiMonAnModel))
            return false;
        LoaiMonAn loaiMonAn = LoaiMonAnMapper.toLoaiMonAn(createLoaiMonAnModel);
        
        LoaiMonAn createdLoaiMonAn = loaiMonAnRepository.create(loaiMonAn);
        
        if(createdLoaiMonAn.getId() > 0)
            return true;
        
        return false;
    }

    @Override
    public LoaiMonAn update(LoaiMonAn loaiMonAn) {
        LoaiMonAn updatedLoaiMonAn = loaiMonAnRepository.update(loaiMonAn);
        
        return updatedLoaiMonAn;        
    }

    @Override
    public boolean delete(int id) {     
        LoaiMonAn loaiMonAn = loaiMonAnRepository.getById(id);
        if(loaiMonAn == null)
            return false;
        
        if (!loaiMonAn.getListMonAn().isEmpty()) {
            return false;
        }
        
        loaiMonAnRepository.delete(id);
        return true;
    }
    
    private boolean validateCreate(CreateLoaiMonAnModel createLoaiMonAnModel){
        LoaiMonAn loaiMonAn = loaiMonAnRepository.getByName(createLoaiMonAnModel.getTen());
        
        return loaiMonAn == null;
    }
}
