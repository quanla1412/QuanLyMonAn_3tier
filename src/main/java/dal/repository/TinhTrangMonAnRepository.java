package dal.repository;

import dal.HibernateUtils;
import dal.entity.TinhTrangMonAn;
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
public class TinhTrangMonAnRepository {
    public List<TinhTrangMonAn> getAll() {
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TinhTrangMonAn> query = builder.createQuery(TinhTrangMonAn.class);
        Root<TinhTrangMonAn> tinhTrangMonAnEntry = query.from(TinhTrangMonAn.class);
        query = query.select(tinhTrangMonAnEntry);
        
        Query queryResult = session.createQuery(query);
        List<TinhTrangMonAn> result = queryResult.getResultList();
        session.close();
        
        return result;
    }
    
    public TinhTrangMonAn getById(int id){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        TinhTrangMonAn tinhTrangMonAn = session.get(TinhTrangMonAn.class, id);
        
        return tinhTrangMonAn;
    }
}
