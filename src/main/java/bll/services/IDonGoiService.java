package bll.services;

import dal.entity.DonGoi;
import gui.models.DonGoi.CreateDonGoiModel;
import gui.models.DonGoi.DonGoiMasterModel;
import gui.models.DonGoi.DonGoiModel;
import gui.models.DonGoi.UpdateDonGoiModel;
import java.util.List;

/**
 *
 * @author LeAnhQuan
 */
public interface IDonGoiService {
    public List<DonGoiModel> getByBan(int idBan);
    
    public DonGoiMasterModel getMasterByBan(int idBan);
    
    public boolean chuyenBan(int idBanCu, int idBanMoi);
    
    public DonGoiModel getByKey(int idBan, int idMonAn);

    public boolean create(CreateDonGoiModel createDonGoiModel);

    public boolean update(UpdateDonGoiModel updateDonGoiModel);
    
    public boolean delete(int idBan);
    
    public boolean delete(int idBan, int idMonAn);
    
    public boolean inBillTam(int idBan, int KhachHang, String maNhanVien, String filePath);
}
