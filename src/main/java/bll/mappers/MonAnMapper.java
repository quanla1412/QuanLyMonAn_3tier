package bll.mappers;

import dal.entity.LoaiMonAn;
import dal.entity.MonAn;
import dal.entity.TinhTrangMonAn;
import gui.models.LoaiMonAn.LoaiMonAnModel;
import gui.models.MonAn.CreateMonAnModel;
import gui.models.MonAn.MonAnFullModel;
import gui.models.MonAn.MonAnModel;
import gui.models.MonAn.UpdateMonAnModel;
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
    
    public static MonAnFullModel toMonAnFullModel(MonAn monAn){
        MonAnFullModel monAnFullModel = new MonAnFullModel();
        
        monAnFullModel.setId(monAn.getId());
        monAnFullModel.setTen(monAn.getTen());
        monAnFullModel.setGia(monAn.getGia());
        monAnFullModel.setGiaKhuyenMai(monAn.getGiaKhuyenMai());
        monAnFullModel.setHinhAnh(monAn.getHinhAnh());
        monAnFullModel.setNoiDung(monAn.getNoiDung());
        monAnFullModel.setLoaiMonAnModel(LoaiMonAnMapper.toLoaiMonAnModel(monAn.getLoaiMonAn()));
        monAnFullModel.setTinhTrangMonAnModel(TinhTrangMonAnMapper.toTinhTrangMonAnModel(monAn.getTinhTrangMonAn()));
        
        return monAnFullModel;
    }
    
    public static MonAn toMonAn(CreateMonAnModel createMonAnModel){
        MonAn monAn = new MonAn();
        
        monAn.setTen(createMonAnModel.getTen());
        monAn.setHinhAnh(createMonAnModel.getHinhAnh());
        monAn.setGia(createMonAnModel.getGia());
        monAn.setGiaKhuyenMai(createMonAnModel.getGiaKhuyenMai());
        monAn.setNoiDung(createMonAnModel.getNoiDung());
        
        LoaiMonAn loaiMonAn = new LoaiMonAn();
        loaiMonAn.setId(createMonAnModel.getIdLoaiMonAn());
        monAn.setLoaiMonAn(loaiMonAn);
        
        TinhTrangMonAn tinhTrangMonAn = new TinhTrangMonAn();
        tinhTrangMonAn.setId(createMonAnModel.getIdTtinhTrangMonAn()
        );
        monAn.setTinhTrangMonAn(tinhTrangMonAn);
        
        return monAn;
    }
    
    
    
    public static MonAn toMonAn(UpdateMonAnModel updateMonAnModel){
        MonAn monAn = new MonAn();
        
        monAn.setId(updateMonAnModel.getId());
        monAn.setTen(updateMonAnModel.getTen());
        monAn.setHinhAnh(updateMonAnModel.getHinhAnh());
        monAn.setGia(updateMonAnModel.getGia());
        monAn.setGiaKhuyenMai(updateMonAnModel.getGiaKhuyenMai());
        monAn.setNoiDung(updateMonAnModel.getNoiDung());
        
        LoaiMonAn loaiMonAn = new LoaiMonAn();
        loaiMonAn.setId(updateMonAnModel.getIdLoaiMonAn());
        monAn.setLoaiMonAn(loaiMonAn);
        
        TinhTrangMonAn tinhTrangMonAn = new TinhTrangMonAn();
        tinhTrangMonAn.setId(updateMonAnModel.getIdTtinhTrangMonAn()
        );
        monAn.setTinhTrangMonAn(tinhTrangMonAn);
        
        return monAn;
    }
}
