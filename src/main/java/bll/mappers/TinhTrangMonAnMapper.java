package bll.mappers;

import dal.entity.TinhTrangMonAn;
import gui.models.MonAn.TinhTrangMonAnModel;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LeAnhQuan
 */
public class TinhTrangMonAnMapper {
    public static TinhTrangMonAnModel toTinhTrangMonAnModel(TinhTrangMonAn tinhTrangMonAn){
        TinhTrangMonAnModel tinhTrangMonAnModel = new TinhTrangMonAnModel(
                tinhTrangMonAn.getId(), 
                tinhTrangMonAn.getTen()
        );
        
        return tinhTrangMonAnModel;
    }
    
    public static List<TinhTrangMonAnModel> toListTinhTrangMonAnModel(List<TinhTrangMonAn> listTinhTrangMonAn){
        List<TinhTrangMonAnModel> listTinhTrangMonAnModel = new ArrayList<>();
        listTinhTrangMonAn.forEach(tinhTrangMonAn -> listTinhTrangMonAnModel.add(toTinhTrangMonAnModel(tinhTrangMonAn)));
        
        return listTinhTrangMonAnModel;
    }
}
