/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.repository;

import dal.HibernateUtils;
import dal.entity.LoaiKhachHang;
import java.util.ArrayList;
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
public class LoaiKhachHangRepository {
    public ArrayList<LoaiKhachHang> getAll(){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LoaiKhachHang> query = builder.createQuery(LoaiKhachHang.class);
        Root<LoaiKhachHang> loaiKhachHangEntry = query.from(LoaiKhachHang.class);
        query = query.select(loaiKhachHangEntry);
        
        Query queryResult = session.createQuery(query);
        ArrayList<LoaiKhachHang> result = (ArrayList<LoaiKhachHang>) queryResult.getResultList();
        result.forEach(item -> Hibernate.initialize(item.getListKhachHang()));
        session.close();
        
        return result;
    }
    
    public LoaiKhachHang getById(int id){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        LoaiKhachHang loaiKhachhang = session.get(LoaiKhachHang.class, id);
        
        return loaiKhachhang;
    }
    public void delete(int id){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        LoaiKhachHang loaiKhachHang = session.get(LoaiKhachHang.class, id);
        session.getTransaction().begin();
        session.delete(loaiKhachHang);
        session.getTransaction().commit();
        
        session.close();
    }
    public LoaiKhachHang createLoaiKhachHang(LoaiKhachHang loaiKhachHang){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        int idLoaiKhachHang = (int) session.save(loaiKhachHang);
        loaiKhachHang.setId(idLoaiKhachHang);
        
        session.close();
        
        return loaiKhachHang;
        
    }
    
    public LoaiKhachHang updateLoaiKhachHang (LoaiKhachHang loaiKhachHangUpdate){
        Session session = HibernateUtils.getFACTORY().openSession();
        LoaiKhachHang loaiKhachHang= session.get(LoaiKhachHang.class, loaiKhachHangUpdate.getId());
        
        session.getTransaction().begin();
        
        loaiKhachHang.setTen(loaiKhachHangUpdate.getTen());
        loaiKhachHang.setDiemToiThieu(loaiKhachHangUpdate.getDiemToiThieu());
        loaiKhachHang.setMucUuDai(loaiKhachHangUpdate.getMucUuDai());
        
        session.save(loaiKhachHang);
        session.getTransaction().commit();
        
        session.close();
        
        return loaiKhachHang;
    }
    
    public LoaiKhachHang getByName(String name){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LoaiKhachHang> query = builder.createQuery(LoaiKhachHang.class);
        Root<LoaiKhachHang> khachHangEntry = query.from(LoaiKhachHang.class);
        query = query.select(khachHangEntry);
        
        Predicate predicate = builder.equal(khachHangEntry.get("ten").as(String.class), name);
        query = query.where(predicate);
         
        Query queryResult = session.createQuery(query);
        LoaiKhachHang result;
        try {
            ArrayList<LoaiKhachHang> resultList = (ArrayList<LoaiKhachHang>) queryResult.getResultList();            
            result = (LoaiKhachHang) queryResult.getSingleResult();            
        } catch (Exception e) {
            return null;
        }
        session.close();
        
        return result;
        
    }
}
