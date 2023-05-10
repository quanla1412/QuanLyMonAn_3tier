/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.repository;

import dal.HibernateUtils;

import dal.entity.TinhTrangNhanVien;
import java.util.ArrayList;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author dinhn
 */
public class TinhTrangNhanVienRepository {
    public ArrayList<TinhTrangNhanVien> getAll(){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TinhTrangNhanVien> query = builder.createQuery(TinhTrangNhanVien.class);
        Root<TinhTrangNhanVien> tinhTrangNhanVienEntry = query.from(TinhTrangNhanVien.class);
        query = query.select(tinhTrangNhanVienEntry);
        
        Query queryResult = session.createQuery(query);
        ArrayList<TinhTrangNhanVien> result = (ArrayList<TinhTrangNhanVien>) queryResult.getResultList();
        session.close();
        
        return result;
    }
    
    public TinhTrangNhanVien getById(int id){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        TinhTrangNhanVien tinhTrangNhanVien = session.get(TinhTrangNhanVien.class, id);
        
        session.close();
        return tinhTrangNhanVien;
    }
    
    
}
