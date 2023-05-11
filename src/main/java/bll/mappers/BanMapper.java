package bll.mappers;

import dal.entity.Ban;
import dal.entity.LoaiBan;
import dal.entity.TinhTrangBan;
import gui.models.Ban.BanFullModel;
import gui.models.Ban.CreateBanModel;
import gui.models.Ban.TinhTrangBanModel;
import gui.models.Ban.UpdateBanModel;
import gui.models.BanModel;
import gui.models.LoaiBanModel;
import java.util.ArrayList;

import java.util.List;
/**
 *
 * @author LeAnhQuan
 */
public class BanMapper {
    public static BanModel toBanModel(Ban ban){
        BanModel banModel = new BanModel();
        banModel.setId(ban.getId());
        banModel.setLoaiBan(ban.getLoaiBan().getTen());
        banModel.setTinhTrangBan(ban.getTinhTrangBan().getTen());
        
        return banModel;
    }
    
    public static List<BanModel> toListBanModel(List<Ban> listBan){
        List<BanModel> listBanModel = new ArrayList<>();
        listBan.forEach(ban -> listBanModel.add(toBanModel(ban)) );
        
        return listBanModel;
    }
    
    public static Ban toBan(CreateBanModel createBanModel){
        Ban ban = new Ban();
        
        LoaiBan loaiBan = new LoaiBan();
        loaiBan.setId(createBanModel.getIdLoaiBan());
        ban.setLoaiBan(loaiBan);
        
        TinhTrangBan tinhTrangBan = new TinhTrangBan();
        tinhTrangBan.setId(createBanModel.getIdTinhTrangBan());
        ban.setTinhTrangBan(tinhTrangBan);
        
        return ban;        
    }
    
    public static Ban toBan(UpdateBanModel updateBanModel){
        Ban ban = new Ban();
        
        ban.setId(updateBanModel.getIdBan());
        
        LoaiBan loaiBan = new LoaiBan();
        loaiBan.setId(updateBanModel.getIdLoaiBan());
        ban.setLoaiBan(loaiBan);
        
        TinhTrangBan tinhTrangBan = new TinhTrangBan();
        tinhTrangBan.setId(updateBanModel.getIdTinhTrangBan());
        ban.setTinhTrangBan(tinhTrangBan);
        
        return ban;        
    }
    
    public static BanFullModel toBanFullModel(Ban ban){
        BanFullModel banFullModel = new BanFullModel();
        
        banFullModel.setId(ban.getId());
        
        LoaiBanModel loaiBanModel = LoaiBanMapper.toLoaiBanModel(ban.getLoaiBan());
        banFullModel.setLoaiBan(loaiBanModel);
        
        TinhTrangBanModel tinhTrangBanModel = TinhTrangBanMapper.toTinhTrangBanModel(ban.getTinhTrangBan());
        banFullModel.setTinhTrangBan(tinhTrangBanModel);
        
        return banFullModel;
    }

    public static List<BanFullModel> toListBanFullModel(List<Ban> listBan) {
        List<BanFullModel> listBanFullModel = new ArrayList<>();
        listBan.forEach(ban -> listBanFullModel.add(toBanFullModel(ban)) );
        
        return listBanFullModel;
    }
}
