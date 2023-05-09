package bll.services.impl;

import bll.mappers.TinhTrangBanMapper;
import bll.services.ITinhTrangBanService;
import dal.HibernateUtils;
import dal.entity.TinhTrangBan;
import dal.repository.TinhTrangBanRepository;
import gui.models.Ban.TinhTrangBanModel;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import org.hibernate.Session;

/**
 *
 * @author LeAnhQuan
 */
public class TinhTrangBanServiceImpl implements ITinhTrangBanService{
    
    TinhTrangBanRepository tinhTrangBanRepository;

    public TinhTrangBanServiceImpl() {
        tinhTrangBanRepository = new TinhTrangBanRepository();
    }
    
    @Override
    public List<TinhTrangBanModel> getAll() {
        List<TinhTrangBan> listTinhTrangBan = tinhTrangBanRepository.getAll();
        List<TinhTrangBanModel> listTinhTrangBanModel = TinhTrangBanMapper.toListTinhTrangBanModel(listTinhTrangBan);
                
        return listTinhTrangBanModel;        
    }

    @Override
    public TinhTrangBanModel getById(int idTinhTrangBan) {
        TinhTrangBan tinhTrangBan = tinhTrangBanRepository.getById(idTinhTrangBan);
        TinhTrangBanModel tinhTrangBanModel = TinhTrangBanMapper.toTinhTrangBanModel(tinhTrangBan);
        
        return tinhTrangBanModel;
    }
    
}
