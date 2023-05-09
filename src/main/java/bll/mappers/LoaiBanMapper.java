package bll.mappers;

import dal.entity.LoaiBan;
import gui.models.CreateLoaiBanModel;
import gui.models.LoaiBanModel;
import gui.models.UpdateLoaiBanModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeAnhQuan
 */
public class LoaiBanMapper {
    public static LoaiBanModel toLoaiBanModel(LoaiBan loaiBan){
        LoaiBanModel loaiBanModel = new LoaiBanModel(
                loaiBan.getId(),
                loaiBan.getTen(),
                loaiBan.getSoLuongCho()
        );
       
        return loaiBanModel;
    }
    
    public static List<LoaiBanModel> toLoaiBanModelList(List<LoaiBan> loaiBanList){
        List<LoaiBanModel> result = new ArrayList<>();
        
        loaiBanList.forEach(loaiBan -> {
            result.add(new LoaiBanModel(
                loaiBan.getId(),
                loaiBan.getTen(),
                loaiBan.getSoLuongCho()
            ));
        });
        
        return result;
    }
    
    public static LoaiBan toLoaiBan(CreateLoaiBanModel createLoaiBanModel){
        LoaiBan loaiBan = new LoaiBan();
        
        loaiBan.setTen(createLoaiBanModel.getTen());
        loaiBan.setSoLuongCho(createLoaiBanModel.getSoLuongCho());
        
        return loaiBan;
    }
    
    public static LoaiBan toLoaiBan(UpdateLoaiBanModel updateLoaiBanModel){
        LoaiBan loaiBan = new LoaiBan();
        
        loaiBan.setId(updateLoaiBanModel.getId());
        loaiBan.setTen(updateLoaiBanModel.getTen());
        loaiBan.setSoLuongCho(updateLoaiBanModel.getSoLuongCho());
        
        return loaiBan;
    }
}
