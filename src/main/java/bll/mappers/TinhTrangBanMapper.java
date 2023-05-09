package bll.mappers;

import dal.entity.TinhTrangBan;
import gui.models.Ban.TinhTrangBanModel;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LeAnhQuan
 */
public class TinhTrangBanMapper {
    public static TinhTrangBanModel toTinhTrangBanModel(TinhTrangBan tinhTrangBan){
        TinhTrangBanModel tinhTrangBanModel = new TinhTrangBanModel(tinhTrangBan.getId(), tinhTrangBan.getTen());
        
        return tinhTrangBanModel;
    }
    
    public static List<TinhTrangBanModel> toListTinhTrangBanModel(List<TinhTrangBan> listTinhTrangBan){
        List<TinhTrangBanModel> listTinhTrangBanModel = new ArrayList<>();
        listTinhTrangBan.forEach(tinhTrangBan -> listTinhTrangBanModel.add(toTinhTrangBanModel(tinhTrangBan)));
        
        return listTinhTrangBanModel;
    }
}
