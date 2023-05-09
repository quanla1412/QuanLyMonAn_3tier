package bll.services;


import dal.entity.LoaiBan;
import gui.models.CreateLoaiBanModel;
import gui.models.LoaiBanModel;
import gui.models.UpdateLoaiBanModel;

import java.util.List;

/**
 *
 * @author LeAnhQuan
 */
public interface ILoaiBanService {
    List<LoaiBanModel> getAll();
    
    LoaiBanModel getById(int id);
    
    boolean createLoaiBan(CreateLoaiBanModel createLoaiBanModel);
    
    boolean updateLoaiBan(UpdateLoaiBanModel updateLoaiBanModel);
    
    boolean deleteLoaiBan(int idLoaiBan);
}

