package bll.services.impl;

import bll.mappers.QuyenTaiKhoanMapper;
import bll.services.IQuyenTaiKhoanService;
import dal.entity.ChucNang;
import dal.entity.NhanVien;
import dal.entity.QuyenTaiKhoan;
import dal.repository.NhanVienRepository;
import dal.repository.QuyenTaiKhoanRepository;
import gui.models.TaiKhoan.QuyenTaiKhoanModel;
import gui.models.TaiKhoan.UpdateQuyenTaiKhoanModel;
import java.util.List;
import java.util.Set;

/**
 *
 * @author LeAnhQuan
 */
public class QuyenTaiKhoanServiceImpl implements IQuyenTaiKhoanService{
    NhanVienRepository nhanVienRepository;
    QuyenTaiKhoanRepository quyenTaiKhoanRepository;

    public QuyenTaiKhoanServiceImpl() {
        nhanVienRepository = new NhanVienRepository();
        quyenTaiKhoanRepository = new QuyenTaiKhoanRepository();
    }
    
    @Override
    public QuyenTaiKhoanModel getByUsername(String username) {
        NhanVien nhanVien = nhanVienRepository.getByMa(username);
        List<QuyenTaiKhoan> listQuyenTaiKhoan = nhanVien.getListQuyenTaiKhoan();
        QuyenTaiKhoanModel quyenTaiKhoanModel = QuyenTaiKhoanMapper.toQuyenTaiKhoanModel(listQuyenTaiKhoan);
        
        return quyenTaiKhoanModel;
    }

    @Override
    public boolean save(UpdateQuyenTaiKhoanModel updateQuyenTaiKhoanModel) {
        Set<Integer> listChucNang = updateQuyenTaiKhoanModel.getListChucNang().keySet();
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa(updateQuyenTaiKhoanModel.getUsername());
        
        listChucNang.forEach(chucNang -> {
            QuyenTaiKhoan quyenTaiKhoan = new QuyenTaiKhoan();
            quyenTaiKhoan.setNhanVien(nhanVien);
            
            ChucNang chucNangEntity = new ChucNang();
            chucNangEntity.setId(chucNang);
            quyenTaiKhoan.setChucNang(chucNangEntity);
            
            if(updateQuyenTaiKhoanModel.getListChucNang().get(chucNang) == true && quyenTaiKhoanRepository.getByKey(quyenTaiKhoan) == null)
                quyenTaiKhoanRepository.create(quyenTaiKhoan);
            else if(updateQuyenTaiKhoanModel.getListChucNang().get(chucNang) == false && quyenTaiKhoanRepository.getByKey(quyenTaiKhoan) != null)
                quyenTaiKhoanRepository.delete(quyenTaiKhoan);
        });
        
        return true;
    }
    
}
