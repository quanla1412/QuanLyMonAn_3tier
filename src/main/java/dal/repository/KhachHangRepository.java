/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.repository;

import dal.HibernateUtils;
import dal.entity.KhachHang;
import dal.entity.LoaiKhachHang;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author tuant
 */
public class KhachHangRepository {
    private KhachHangRepository khachHangRepository;
    private LoaiKhachHangRepository loaiKhachHangRepository;
    
    public KhachHangRepository() {
        khachHangRepository = new KhachHangRepository();
        loaiKhachHangRepository = new LoaiKhachHangRepository();
    }
    
    public List<KhachHang> getAll(){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<KhachHang> query = builder.createQuery(KhachHang.class);
        Root<KhachHang> khachHangEntry = query.from(KhachHang.class);
        query = query.select(khachHangEntry);
        
        Query queryResult = session.createQuery(query);
        List<KhachHang> result = (List<KhachHang>) queryResult.getResultList();
        session.close();
        
        return result;
    }
    public KhachHang getById(int id){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        KhachHang khachHang = session.get(KhachHang.class, id);
        
        return khachHang;
    }
    public KhachHang createKhachHang(KhachHang khachHang){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        int idKhachHang = (int) session.save(khachHang);
        khachHang.setId(idKhachHang);
        
        session.close();
        
        return khachHang;
        
    }
    
    public KhachHang updateKhachHang (KhachHang khachHangUpdate){
        Session session = HibernateUtils.getFACTORY().openSession();
        KhachHang khachHang= session.get(KhachHang.class, khachHangUpdate.getId());
        LoaiKhachHang loaiKhachHang = loaiKhachHangRepository.getById(khachHangUpdate.getLoaiKhachHang().getId());
        session.getTransaction().begin();
        
        khachHang.setTen(khachHangUpdate.getTen());
        khachHang.setLoaiKhachHang(loaiKhachHang);
        khachHang.setTen(khachHang.getTen());
        khachHang.setSdt(khachHang.getSdt());
        khachHang.setDiemTichLuy(khachHang.getDiemTichLuy());
        khachHang.setEmail(khachHang.getEmail());
        khachHang.setNgaySinh(khachHang.getNgaySinh());
        khachHang.setGioiTinhNam(khachHang.getGioiTinhNam());
        
        session.save(khachHang);
        session.getTransaction().commit();
        
        session.close();
        
        return khachHang;
    }
}