package dal.repository;

import dal.HibernateUtils;
import dal.entity.ChucNang;
import dal.entity.NhanVien;
import dal.entity.QuyenTaiKhoan;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author LeAnhQuan
 */
public class QuyenTaiKhoanRepository {
    NhanVienRepository nhanVienRepository;
    ChucNangRepository chucNangRepository;

    public QuyenTaiKhoanRepository() {
        nhanVienRepository = new NhanVienRepository();
        chucNangRepository = new ChucNangRepository();
    }
    
    public QuyenTaiKhoan getByKey(QuyenTaiKhoan quyenTaiKhoan){
        Session session = HibernateUtils.getFACTORY().openSession();
        quyenTaiKhoan.initQuyenTaiKhoanKey();
        
        quyenTaiKhoan = session.get(QuyenTaiKhoan.class, quyenTaiKhoan.getQuyenTaiKhoanKey());
        
        session.close();
        
        return quyenTaiKhoan;        
    }
    
    public QuyenTaiKhoan create(QuyenTaiKhoan quyenTaiKhoan){
        Session session = HibernateUtils.getFACTORY().openSession();
        session.getTransaction().begin();
        quyenTaiKhoan.initQuyenTaiKhoanKey();
        
        ChucNang chucNang = chucNangRepository.getById(quyenTaiKhoan.getChucNang().getId());
        quyenTaiKhoan.setChucNang(chucNang);
        
        NhanVien nhanVien = nhanVienRepository.getByMa(quyenTaiKhoan.getNhanVien().getMa());
        quyenTaiKhoan.setNhanVien(nhanVien);
        
        session.save(quyenTaiKhoan);
        
        session.getTransaction().commit();
        session.close();
        
        return quyenTaiKhoan;
    }
    
    public void delete(QuyenTaiKhoan data){
        Session session = HibernateUtils.getFACTORY().openSession();
        session.getTransaction().begin();
        data.initQuyenTaiKhoanKey();
        
        QuyenTaiKhoan quyenTaiKhoan = session.get(QuyenTaiKhoan.class, data.getQuyenTaiKhoanKey());
        session.delete(quyenTaiKhoan);
        
        session.getTransaction().commit();
        session.close();
    }
}
