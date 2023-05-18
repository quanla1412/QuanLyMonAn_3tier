/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.repository;

import dal.HibernateUtils;
import dal.entity.KhachHang;
import dal.entity.LoaiKhachHang;
import gui.constraints.GioiTinhConstraints;
import gui.models.KhachHang.SearchKhachHangModel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author tuant
 */
public class KhachHangRepository {
    private LoaiKhachHangRepository loaiKhachHangRepository;
    
    public KhachHangRepository() {
        loaiKhachHangRepository = new LoaiKhachHangRepository();
    }
    
    public List<KhachHang> getAll(){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<KhachHang> query = builder.createQuery(KhachHang.class);
        Root<KhachHang> khachHangEntry = query.from(KhachHang.class);
        query = query.select(khachHangEntry);
        
        Query queryResult = session.createQuery(query);
        List<KhachHang> result = queryResult.getResultList();
        result.forEach(item -> Hibernate.initialize(item.getListHoaDon()));
        session.close();
        
        return result;
    }
    public KhachHang getById(int id){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        KhachHang khachHang = session.get(KhachHang.class, id);
        
        return khachHang;
    }
    
    public KhachHang getBySoDienThoai(String soDienThoai){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<KhachHang> query = builder.createQuery(KhachHang.class);
        Root<KhachHang> khachHangEntry = query.from(KhachHang.class);
        query = query.select(khachHangEntry);
        Predicate predicate = builder.equal(khachHangEntry.get("sdt").as(String.class), soDienThoai);
        query = query.where(predicate);
        
        Query queryResult = session.createQuery(query);
        KhachHang result = null;
        try {            
            result = (KhachHang) queryResult.getSingleResult();
        } catch (NoResultException ex){
            System.out.println(ex);
        } finally {
            session.close();
        }
        
        return result;
    }
    public KhachHang createKhachHang(KhachHang khachHang){
        Session session = HibernateUtils.getFACTORY().openSession();
        LoaiKhachHang loaiKhachHang = loaiKhachHangRepository.getById(1);
        khachHang.setLoaiKhachHang(loaiKhachHang);
        khachHang.setDiemTichLuy(0);
        
        int idKhachHang = (int) session.save(khachHang);
        khachHang.setId(idKhachHang);
        
        
        session.close();
        
        return khachHang;
        
    }
    
    public KhachHang updateKhachHang (KhachHang khachHangUpdate){
        Session session = HibernateUtils.getFACTORY().openSession();
        KhachHang khachHang= session.get(KhachHang.class, khachHangUpdate.getId());
        session.getTransaction().begin();
        
        khachHang.setTen(khachHangUpdate.getTen());
        khachHang.setSdt(khachHangUpdate.getSdt());
        khachHang.setEmail(khachHangUpdate.getEmail());
        khachHang.setNgaySinh(khachHangUpdate.getNgaySinh());
        khachHang.setGioiTinhNam(khachHangUpdate.isGioiTinhNam());
        
        session.save(khachHang);
        session.getTransaction().commit();
        
        session.close();
        
        return khachHang;
    }
    public List<KhachHang> getByIds(List<Integer> ids){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<KhachHang> query = builder.createQuery(KhachHang.class);
        Root<KhachHang> khachHangEntry = query.from(KhachHang.class);
        query = query.select(khachHangEntry).where(khachHangEntry.get("id").in(ids));
        
        Query<KhachHang> queryResult = session.createQuery(query);
        List<KhachHang> listKhachHang = queryResult.getResultList();       
        
        session.close();
        
        return listKhachHang;
    }
    
    public List<KhachHang> search(SearchKhachHangModel searchKhachHangModel){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        String sql = "SELECT KH.id FROM KhachHang KH LEFT JOIN KH.loaiKhachHang LKH ";
        
        ArrayList<String> conditions = new ArrayList<>();
        
        if(searchKhachHangModel.getIdOrName()!= null && !searchKhachHangModel.getIdOrName().isBlank())
            conditions.add("(KH.id LIKE '%" + searchKhachHangModel.getIdOrName() + "%' OR KH.ten LIKE :ten)");
        if(searchKhachHangModel.getIdLoaiKhachHang()>0)
            conditions.add("LKH.id = "+ searchKhachHangModel.getIdLoaiKhachHang());
        if(searchKhachHangModel.getSdt()!= null &&!searchKhachHangModel.getSdt().isBlank())
            conditions.add("KH.sdt LIKE '%" + searchKhachHangModel.getSdt() + "%'");
        if(searchKhachHangModel.getGioiTinh() != GioiTinhConstraints.TAT_CA){
            String isGioiTinhNam =  searchKhachHangModel.getGioiTinh() == GioiTinhConstraints.NAM ? "1" : "0";
            conditions.add("KH.gioiTinhNam = " + isGioiTinhNam);
        }
        
        String whereSql = "";
        if(!conditions.isEmpty())
            whereSql = " WHERE ";
        String finalSql = sql + whereSql + String.join(" AND ", conditions);
        
        
        javax.persistence.Query query;
                
        if(searchKhachHangModel.getIdOrName() == null)
            query = session.createQuery(finalSql);
        else 
            query = session.createQuery(finalSql).setParameter("ten", "%" + searchKhachHangModel.getIdOrName() + "%");
        List<Integer> ids = query.getResultList();
        
       session.close();
       
       return getByIds(ids);
    }
    
    public boolean hasId(int id) {
        Session session = HibernateUtils.getFACTORY().openSession();
        KhachHang khachHang = null;
      
            String hql = "FROM KhachHang KH WHERE KH.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            khachHang = (KhachHang) query.uniqueResult();
       
        
            session.close();
        
        return khachHang != null;
    }
    
    public void updateLoaiKhachHang(KhachHang data){
        Session session = HibernateUtils.getFACTORY().openSession();
        KhachHang khachHang = session.get(KhachHang.class, data.getId());
        session.getTransaction().begin();
        
        khachHang.setLoaiKhachHang(data.getLoaiKhachHang());
        
        session.save(khachHang);
        session.getTransaction().commit();
        
        session.close();
    }
    
    public void updateDiemTichLuy(KhachHang data){
        Session session = HibernateUtils.getFACTORY().openSession();
        KhachHang khachHang = session.get(KhachHang.class, data.getId());
        session.getTransaction().begin();
        
        khachHang.setDiemTichLuy(data.getDiemTichLuy());
        
        session.save(khachHang);
        session.getTransaction().commit();
        
        session.close();
    }
}
