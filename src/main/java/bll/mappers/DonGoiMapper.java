package bll.mappers;

import dal.entity.Ban;
import dal.entity.DonGoi;
import dal.entity.MonAn;
import gui.models.DonGoi.CreateDonGoiModel;
import gui.models.DonGoi.DonGoiModel;
import gui.models.DonGoi.UpdateDonGoiModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeAnhQuan
 */
public class DonGoiMapper {
    public static DonGoiModel toDonGoiModel(DonGoi donGoi){
        if(donGoi == null)
            return null;
        DonGoiModel donGoiModel = new DonGoiModel();
        
        donGoiModel.setIdBan(donGoi.getBan().getId());
        donGoiModel.setMonAn(MonAnMapper.toMonAnModel(donGoi.getMonAn()));
        donGoiModel.setSoLuong(donGoi.getSoLuong());
        donGoiModel.setGhiChu(donGoi.getGhiChu());
        
        return donGoiModel;
    }
    
    public static List<DonGoiModel> toListDonGoiModel(List<DonGoi> listDonGoi){
        List<DonGoiModel> listDonGoiModel = new ArrayList<>();
        listDonGoi.forEach(donGoi -> listDonGoiModel.add(toDonGoiModel(donGoi)));
        
        return listDonGoiModel;
    }
    
    public static DonGoi toDonGoi(CreateDonGoiModel createDonGoiModel){
        DonGoi donGoi = new DonGoi();
        
        Ban ban = new Ban();
        ban.setId(createDonGoiModel.getIdBan());
        donGoi.setBan(ban);
        
        MonAn monAn = new MonAn();
        monAn.setId(createDonGoiModel.getIdMA());
        donGoi.setMonAn(monAn);
        
        donGoi.setSoLuong(createDonGoiModel.getSoLuong());
        donGoi.setGhiChu(createDonGoiModel.getGhiChu());
        
        return donGoi;
    }
    
    public static DonGoi toDonGoi(UpdateDonGoiModel updateDonGoiModel){
        DonGoi donGoi = new DonGoi();
        
        Ban ban = new Ban();
        ban.setId(updateDonGoiModel.getIdBan());
        donGoi.setBan(ban);
        
        MonAn monAn = new MonAn();
        monAn.setId(updateDonGoiModel.getIdMA());
        donGoi.setMonAn(monAn);
        
        donGoi.setSoLuong(updateDonGoiModel.getSoLuong());
        donGoi.setGhiChu(updateDonGoiModel.getGhiChu());
        
        return donGoi;
    }
}
