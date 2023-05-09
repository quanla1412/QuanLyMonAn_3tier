package dal.repository;

import dal.HibernateUtils;
import dal.entity.MonAn;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author LeAnhQuan
 */
public class MonAnRepository {
    public List<MonAn> getAll(){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MonAn> query = builder.createQuery(MonAn.class);
        Root<MonAn> monAnEntry = query.from(MonAn.class);
        query = query.select(monAnEntry);
        
        Query<MonAn> queryResult = session.createQuery(query);
        List<MonAn> listMonAn = queryResult.getResultList();       
        
        session.close();
        
        return listMonAn;
    }
    
    public MonAn getById(int id){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        MonAn monAn = session.get(MonAn.class, id);
        
        session.close();
        return monAn;
    }
    
    public MonAn create(MonAn monAn){
        Session session = HibernateUtils.getFACTORY().openSession();
        session.getTransaction().begin();
        
        int id = (int) session.save(monAn);
        monAn.setId(id);
        
        session.getTransaction().commit();
        session.close();
        return monAn;
    }
    
    public MonAn update(MonAn monAn){
        Session session = HibernateUtils.getFACTORY().openSession();
        session.getTransaction().begin();
        
        session.save(monAn);
        
        session.getTransaction().commit();
        session.close();
        return monAn;
    }
    
    public void delete(int id){
        Session session = HibernateUtils.getFACTORY().openSession();
        session.getTransaction().begin();
        
        MonAn monAn = session.get(MonAn.class, id);
        session.delete(monAn);
        
        session.getTransaction().commit();
        session.close();
    }
}
