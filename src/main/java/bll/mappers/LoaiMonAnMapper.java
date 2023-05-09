package bll.mappers;

import dal.entity.LoaiMonAn;
import gui.models.LoaiMonAn.CreateLoaiMonAnModel;
import gui.models.LoaiMonAn.LoaiMonAnModel;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LeAnhQuan
 */
public class LoaiMonAnMapper {
    public static LoaiMonAnModel toLoaiMonAnModel(LoaiMonAn loaiMonAn){
        LoaiMonAnModel loaiMonAnModel = new LoaiMonAnModel();
        loaiMonAnModel.setId(loaiMonAn.getId());
        loaiMonAnModel.setTen(loaiMonAn.getTen());
        
        return loaiMonAnModel;
    }
    
    public static List<LoaiMonAnModel> toListLoaiMonAnModel(List<LoaiMonAn> listLoaiMonAn){
        List<LoaiMonAnModel> listLoaiMonAnModel = new ArrayList<>();
        listLoaiMonAn.forEach(loaiMonAn -> listLoaiMonAnModel.add(toLoaiMonAnModel(loaiMonAn)));
        
        return listLoaiMonAnModel;
    }
    
    public static LoaiMonAn toLoaiMonAn(CreateLoaiMonAnModel createLoaiMonAnModel){
        LoaiMonAn loaiMonAn = new LoaiMonAn();
        loaiMonAn.setTen(createLoaiMonAnModel.getTen());
        
        return loaiMonAn;
    }
}
