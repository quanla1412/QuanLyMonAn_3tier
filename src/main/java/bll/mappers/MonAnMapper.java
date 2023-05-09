package bll.mappers;

import dal.entity.MonAn;
import gui.models.MonAn.MonAnModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeAnhQuan
 */
public class MonAnMapper {
    public static MonAnModel toMonAnModel(MonAn monAn){
        MonAnModel monAnModel = new MonAnModel();
        
        monAnModel.setId(monAn.getId());
        monAnModel.setTen(monAn.getTen());
        monAnModel.setHinhAnh(monAn.getHinhAnh());
        monAnModel.setLoaiMonAn(monAn.getLoaiMonAn().getTen());
        monAnModel.setGia(monAn.getGia());
        monAnModel.setGiaKhuyenMai(monAn.getGiaKhuyenMai());
        monAnModel.setTinhTrangMonAn(monAn.getTinhTrangMonAn().getTen());
        
        return monAnModel;
    }
    
    public static List<MonAnModel> toListMonAnModel(List<MonAn> listMonAn){
        ArrayList<MonAnModel> listMonAnModel = new ArrayList<>();
        listMonAn.forEach(monAn -> listMonAnModel.add(toMonAnModel(monAn)));
        
        return listMonAnModel;
    }
}
