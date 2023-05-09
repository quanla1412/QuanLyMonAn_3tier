package bll.services.impl;

import bll.mappers.MonAnMapper;
import bll.services.IMonAnService;
import dal.entity.MonAn;
import dal.repository.MonAnRepository;
import gui.models.MonAn.MonAnModel;
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
    public List<MonAnModel> getAll() {
        List<MonAn> listMonAn = monAnRepository.getAll();
        List<MonAnModel> listMonAnModel = MonAnMapper.toListMonAnModel(listMonAn);
        
        return listMonAnModel;
    }
    
}
