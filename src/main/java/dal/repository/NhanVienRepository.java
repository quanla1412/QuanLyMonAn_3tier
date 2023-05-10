/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.repository;

import dal.HibernateUtils;
import dal.entity.ChucVu;
import dal.entity.NhanVien;
import dal.entity.TinhTrangNhanVien;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author dinhn
 */
public class NhanVienRepository {
    private ChucVuRepository chucVuRepository;
    private TinhTrangNhanVienRepository tinhTrangNhanVienRepository;
    
    
    
    public NhanVienRepository(){
        chucVuRepository = new ChucVuRepository();
        tinhTrangNhanVienRepository = new TinhTrangNhanVienRepository();
    }
    
    public List<NhanVien> getAll(){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<NhanVien> query = builder.createQuery(NhanVien.class);
        Root<NhanVien> nhanVienEntry = query.from(NhanVien.class);
        query = query.select(nhanVienEntry);
        
        Query queryResult = session.createQuery(query);
        ArrayList<NhanVien> result = (ArrayList<NhanVien>) queryResult.getResultList();
        session.close();
        
        return result;
    }
    
    public NhanVien getByMa(String ma){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        NhanVien nhanVien= session.get(NhanVien.class, ma);
        
        session.close();
        
        return nhanVien;
    }
    
     public NhanVien createNhanVien(NhanVien nhanVien){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        String maNhanVien = (String) session.save(nhanVien);
        nhanVien.setMa(maNhanVien);
        
        session.close();
        
        return nhanVien;
    }
    
    public NhanVien updateNhanVien(NhanVien data){
        Session session = HibernateUtils.getFACTORY().openSession();
        NhanVien nhanVien = session.get(NhanVien.class, data.getMa());
        ChucVu chucVu = chucVuRepository.getById(data.getChucVu().getId());
        TinhTrangNhanVien tinhTrangNhanVien = tinhTrangNhanVienRepository.getById(data.getTinhTrangNhanVien().getId());
        
        session.getTransaction().begin();
        
        nhanVien.setChucVu(chucVu);
        nhanVien.setTinhTrangNhanVien(tinhTrangNhanVien);
        
        session.save(nhanVien);
        session.getTransaction().commit();
        
        session.close();
        
        return nhanVien;
    }
    
    public void delete(String ma){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        NhanVien nhanVien = session.get(NhanVien.class, ma);
        
        session.getTransaction().begin();
        session.delete(nhanVien);
        session.getTransaction().commit();
        
        session.close();
    }
    
}
