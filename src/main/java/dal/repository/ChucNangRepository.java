package dal.repository;

import dal.HibernateUtils;
import dal.entity.ChucNang;
import org.hibernate.Session;

/**
 *
 * @author LeAnhQuan
 */
public class ChucNangRepository {
    public ChucNang getById(int id){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        ChucNang chucNang = session.get(ChucNang.class, id);
        
        session.close();
        
        return chucNang;
    }
}
