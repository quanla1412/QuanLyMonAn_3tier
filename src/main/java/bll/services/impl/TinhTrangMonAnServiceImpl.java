package bll.services.impl;

import bll.mappers.TinhTrangMonAnMapper;
import bll.services.ITinhTrangMonAnService;
import dal.entity.TinhTrangMonAn;
import dal.repository.TinhTrangMonAnRepository;
import gui.models.MonAn.TinhTrangMonAnModel;
import java.util.List;

/**
 *
 * @author LeAnhQuan
 */
public class TinhTrangMonAnServiceImpl implements ITinhTrangMonAnService {
    private final TinhTrangMonAnRepository tinhTrangMonAnRepository;

    public TinhTrangMonAnServiceImpl() {
        tinhTrangMonAnRepository = new TinhTrangMonAnRepository();
    }
    
    @Override
    public List<TinhTrangMonAnModel> getAll() {
        List<TinhTrangMonAn> listTinhTrangMonAn = tinhTrangMonAnRepository.getAll();
        List<TinhTrangMonAnModel> listTinhTrangMonAnModel = TinhTrangMonAnMapper.toListTinhTrangMonAnModel(listTinhTrangMonAn);
        
        return listTinhTrangMonAnModel;
    }

    @Override
    public TinhTrangMonAnModel getById(int id) {
        TinhTrangMonAn tinhTrangMonAn = tinhTrangMonAnRepository.getById(id);
        TinhTrangMonAnModel tinhTrangMonAnModel = TinhTrangMonAnMapper.toTinhTrangMonAnModel(tinhTrangMonAn);
        
        return tinhTrangMonAnModel;
    }
    
}
