package bll.services;

import gui.models.TaiKhoan.QuyenTaiKhoanModel;
import gui.models.TaiKhoan.UpdateQuyenTaiKhoanModel;

/**
 *
 * @author LeAnhQuan
 */
public interface IQuyenTaiKhoanService {
    QuyenTaiKhoanModel getByUsername(String username); 
    
    boolean save(UpdateQuyenTaiKhoanModel updateQuyenTaiKhoanModel);
}
