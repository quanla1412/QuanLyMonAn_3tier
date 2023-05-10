/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.repository;

import dal.HibernateUtils;
import dal.entity.HoaDon;
import dal.entity.LoaiBan;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author tanph
 */
public class HoaDonRepository {

    public List<HoaDon> getAllHoaDon(){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HoaDon> query = builder.createQuery(HoaDon.class);
        Root<HoaDon> hoaDonEntry = query.from(HoaDon.class);
        query = query.select(hoaDonEntry);
        
        Query queryResult = session.createQuery(query);
        ArrayList<HoaDon> result = (ArrayList<HoaDon>) queryResult.getResultList();
        session.close();
        
        return result;
    }
    
    public List<HoaDon> getChiTietHoaDonById(int IdHoaDon){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HoaDon> query = builder.createQuery(HoaDon.class);
        Root<HoaDon> hoaDonEntry = query.from(HoaDon.class);
        query = query.select(hoaDonEntry).where(builder.like(hoaDonEntry.get("id"), IdHoaDon));
    }
    
    
}
