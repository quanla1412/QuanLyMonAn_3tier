package bll.services;

import dal.entity.LoaiMonAn;
import gui.models.LoaiMonAn.CreateLoaiMonAnModel;
import gui.models.LoaiMonAn.LoaiMonAnModel;
import gui.models.MonAn.LoaiMonAnFullModel;
import java.util.List;

/**
 *
 * @author LeAnhQuan
 */
public interface ILoaiMonAnService {
    List<LoaiMonAnModel> getAll();
    
    LoaiMonAnModel getById(int id);
    
    List<LoaiMonAnFullModel> getAllFull();
    
    boolean create(CreateLoaiMonAnModel createLoaiMonAnModel);
    
    LoaiMonAn update(LoaiMonAn loaiMonAn);
    
    boolean delete(int id);
}
