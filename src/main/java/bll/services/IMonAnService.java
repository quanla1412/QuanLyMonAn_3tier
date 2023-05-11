package bll.services;

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
public interface IMonAnService {
    public List<MonAnModel> getAll(boolean hienDaXoa);
    
    public MonAnFullModel getFullById(int id);
    
    public List<MonAnModel> search(SearchMonAnModel searchMonAnModel, boolean hienDaXoa);
    
    public boolean create(CreateMonAnModel createMonAnModel);
    
    public boolean update(UpdateMonAnModel updateMonAnModel);

    public boolean chuyenTinhTrangMonAn(MonAnFullModel monAnSelected);
    
    public boolean delete(int id);
}
