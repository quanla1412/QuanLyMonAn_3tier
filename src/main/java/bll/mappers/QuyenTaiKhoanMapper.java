package bll.mappers;

import dal.entity.QuyenTaiKhoan;
import gui.models.TaiKhoan.QuyenTaiKhoanModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeAnhQuan
 */
public class QuyenTaiKhoanMapper {
    public static QuyenTaiKhoanModel toQuyenTaiKhoanModel(List<QuyenTaiKhoan> listQuyenTaiKhoan){
        QuyenTaiKhoanModel quyenTaiKhoanModel = new QuyenTaiKhoanModel();
        
        if (listQuyenTaiKhoan == null || listQuyenTaiKhoan.isEmpty()) 
            return null;
        
        quyenTaiKhoanModel.setUsername(listQuyenTaiKhoan.get(0).getNhanVien().getMa());
        
        List<Integer> listChucNang = new ArrayList<>();
        listQuyenTaiKhoan.forEach(quyenTaiKhoan -> {
            listChucNang.add(quyenTaiKhoan.getChucNang().getId());
        });
        quyenTaiKhoanModel.setListChucNang(listChucNang);
        return quyenTaiKhoanModel;
    }
}
