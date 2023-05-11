/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.repository;

import dal.HibernateUtils;
import dal.entity.ChiTietHoaDon;
import dal.entity.HoaDon;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author tanph
 */
public class ChiTietHoaDonRepository {
    public List<ChiTietHoaDon> getAllChiTietHoaDonById(int idHoaDon){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ChiTietHoaDon> query = builder.createQuery(ChiTietHoaDon.class);
        Root<ChiTietHoaDon> chiTietHoaDonEntry = query.from(ChiTietHoaDon.class);
        query = query.select(chiTietHoaDonEntry);
        
        Predicate predicate = builder.equal(chiTietHoaDonEntry.get("maHoaDon"), idHoaDon);
        query = query.where(predicate);
        
        Query queryResult = session.createQuery(query);
        List<ChiTietHoaDon> result = queryResult.getResultList();

        session.close();
        
        return result;
    }
}
