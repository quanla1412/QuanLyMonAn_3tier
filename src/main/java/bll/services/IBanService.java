package bll.services;

import dal.entity.Ban;
import gui.models.Ban.BanFullModel;
import gui.models.Ban.CreateBanModel;
import gui.models.Ban.UpdateBanModel;
import gui.models.BanModel;
import java.util.List;

/**
 *
 * @author LeAnhQuan
 */
public interface IBanService {
    List<BanModel> getAll();
    
    BanModel getById(int id);
    
    BanFullModel getFullById(int id);
    
    boolean createBan(CreateBanModel createBanModel);

    boolean updateBan(UpdateBanModel updateBanModel);
    
    Ban changeTinhTrangBan(int idBan, int idTinhTrangBan);
    
    boolean delete(int id);
}
