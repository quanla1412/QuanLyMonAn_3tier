package bll.services;

import dal.entity.Ban;
import gui.models.Ban.BanFullModel;
import gui.models.Ban.CreateBanModel;
import gui.models.Ban.UpdateBanModel;
import gui.models.BanModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LeAnhQuan
 */
public interface IBanService {
    List<BanModel> getAll();
    
    BanModel getById(int id);
    
    BanFullModel getFullById(int id);
    
    List<BanFullModel> getAllFull();
    
    List<BanModel> getByTinhTrang(int idTinhTrangBan);
    
    List<BanModel> getByLoaiBan(int idLoaiBan);
    
    Map<String, Integer> countByLoaiBan();
    
    Map<String, Integer> countByTinhTrang();    
    
    boolean createBan(CreateBanModel createBanModel);

    boolean updateBan(UpdateBanModel updateBanModel);
    
    boolean changeTinhTrangBan(int idBan, int idTinhTrangBan);
    
    boolean delete(int id);
}
