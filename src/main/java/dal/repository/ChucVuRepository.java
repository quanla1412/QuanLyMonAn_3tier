
package dal.repository;

import dal.HibernateUtils;
import dal.entity.ChucVu;
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
 * @author dinhn
 */
public class ChucVuRepository {
   public ArrayList<ChucVu> getAll(){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ChucVu> query = builder.createQuery(ChucVu.class);
        Root<ChucVu> loaiBanEntry = query.from(ChucVu.class);
        query = query.select(loaiBanEntry);
        
        Query queryResult = session.createQuery(query);
        ArrayList<ChucVu> result = (ArrayList<ChucVu>) queryResult.getResultList();
        session.close();
        
        return result;
    }
    
    public ChucVu getById(int id){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        ChucVu chucVu = session.get(ChucVu.class, id);
        //Hibernate.initialize(chucVu.getListNhanVien());
        
        return chucVu;
    }
    
    public ChucVu getByName(String name){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ChucVu> query = builder.createQuery(ChucVu.class);
        Root<ChucVu> banEntry = query.from(ChucVu.class);
        query = query.select(banEntry);
        
        Predicate predicate = builder.equal(banEntry.get("ten").as(String.class), name);
        query = query.where(predicate);
         
        Query queryResult = session.createQuery(query);
        ChucVu result;
        try {
            ArrayList<ChucVu> resultList = (ArrayList<ChucVu>) queryResult.getResultList();            
            result = (ChucVu) queryResult.getSingleResult();            
        } catch (Exception e) {
            return null;
        }
        session.close();
        
        return result;
        
    }

    
    public ChucVu createChucVu (ChucVu chucVu){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        int id = (int) session.save(chucVu);
        chucVu.setId(id);
        
        session.close();
        
        return chucVu;
    }
    
   public ChucVu updateChucVu (ChucVu chucVuUpdate){
        Session session = HibernateUtils.getFACTORY().openSession();
        ChucVu chucVu= session.get(ChucVu.class, chucVuUpdate.getId());
        
        session.getTransaction().begin();
        
        chucVu.setTen(chucVuUpdate.getTen());
        
        session.save(chucVu);
        session.getTransaction().commit();
        
        session.close();
        
        return chucVu;
    }
    
    public void deleteChucVu(int id){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        
        ChucVu chucVu = session.get(ChucVu.class, id);
        session.getTransaction().begin();
        session.delete(chucVu);
        session.getTransaction().commit();
        
        session.close();
    }
    
    
    
}
