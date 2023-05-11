package dal.repository;

import dal.HibernateUtils;
import dal.entity.LoaiMonAn;
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
 * @author LeAnhQuan
 */
public class LoaiMonAnRepository {
    public ArrayList<LoaiMonAn> getAll(){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LoaiMonAn> query = builder.createQuery(LoaiMonAn.class);
        Root<LoaiMonAn> loaiMonAnEntry = query.from(LoaiMonAn.class);
        query = query.select(loaiMonAnEntry);
        
        Query queryResult = session.createQuery(query);
        ArrayList<LoaiMonAn> result = (ArrayList<LoaiMonAn>) queryResult.getResultList();
        result.forEach(item -> Hibernate.initialize(item.getListMonAn()));
        session.close();       
        
        return result;
    }
    
    public LoaiMonAn getById(int id){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        LoaiMonAn loaiMonAn = session.get(LoaiMonAn.class, id);
        
        return loaiMonAn;
    }
    
    public LoaiMonAn getByName(String ten){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LoaiMonAn> query = builder.createQuery(LoaiMonAn.class);
        Root<LoaiMonAn> loaiMonAnEntry = query.from(LoaiMonAn.class);
        query = query.select(loaiMonAnEntry);
        
        Predicate predicate = builder.equal(loaiMonAnEntry.get("ten").as(String.class), ten);
        query = query.where(predicate);
        
        Query queryResult = session.createQuery(query);
        LoaiMonAn result = null;
        try {
            result = (LoaiMonAn) queryResult.getSingleResult();
        } catch(Exception ex){
            System.out.println(ex);
        } finally {
            session.close();
        }     
        
        return result;
    }
    
    public LoaiMonAn create(LoaiMonAn loaiMonAn){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        int id = (int) session.save(loaiMonAn);
        loaiMonAn.setId(id);
        
        session.close();        
        return loaiMonAn;
    }
    
    public LoaiMonAn update(LoaiMonAn loaiMonAn){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        session.getTransaction().begin();
        session.save(loaiMonAn);
        session.getTransaction().commit();
        
        session.close();
        return loaiMonAn;
    }
    
    public void delete(int id){
        Session session = HibernateUtils.getFACTORY().openSession();
        LoaiMonAn loaiMonAn = session.get(LoaiMonAn.class, id);
        
        session.getTransaction().begin();
        session.delete(loaiMonAn);
        session.getTransaction().commit();
        
        session.close();
    }
}
