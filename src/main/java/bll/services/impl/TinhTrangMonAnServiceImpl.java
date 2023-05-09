package bll.services.impl;

import bll.services.ITinhTrangMonAnService;
import dal.entity.TinhTrangMonAn;
import dal.repository.TinhTrangMonAnRepository;
import java.util.ArrayList;

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
    public ArrayList<TinhTrangMonAn> getAll() {
        ArrayList<TinhTrangMonAn> listTinhTrangMonAn = tinhTrangMonAnRepository.getAll();
        
        return listTinhTrangMonAn;
    }

    @Override
    public TinhTrangMonAn getById(int id) {
        TinhTrangMonAn tinhTrangMonAn = tinhTrangMonAnRepository.getById(id);
        
        return tinhTrangMonAn;
    }
    
}
