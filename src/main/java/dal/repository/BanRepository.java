package dal.repository;

import dal.HibernateUtils;
import dal.entity.Ban;
import dal.entity.LoaiBan;
import dal.entity.TinhTrangBan;
import java.util.ArrayList;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 *
 * @author LeAnhQuan
 */
public class BanRepository {    
    private LoaiBanRepository loaiBanRepository;
    private TinhTrangBanRepository tinhTrangBanRepository;

    public BanRepository() {
        loaiBanRepository = new LoaiBanRepository();
        tinhTrangBanRepository = new TinhTrangBanRepository();
    }
    
    public List<Ban> getAll(){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Ban> query = builder.createQuery(Ban.class);
        Root<Ban> banEntry = query.from(Ban.class);
        query = query.select(banEntry);
        
        Query queryResult = session.createQuery(query);
        ArrayList<Ban> result = (ArrayList<Ban>) queryResult.getResultList();
        session.close();
        
        return result;
    }
    
    public Ban getById(int id){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        Ban ban= session.get(Ban.class, id);
        
        session.close();
        
        return ban;
    }
    
    public ArrayList<Ban> getListBanByTinhTrang(int idTinhTrangBan){
        Session session = HibernateUtils.getFACTORY().openSession();
        TinhTrangBan tinhTrangBan = session.get(TinhTrangBan.class, idTinhTrangBan);
        
        ArrayList<Ban> listBan = (ArrayList<Ban>) tinhTrangBan.getListBan();
                
        session.close();
        
        return listBan;
    }
    
    public Ban createBan(Ban ban){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        int idBan = (int) session.save(ban);
        ban.setId(idBan);
        
        session.close();
        
        return ban;
    }
    
    public Ban updateBan(Ban data){
        Session session = HibernateUtils.getFACTORY().openSession();
        Ban ban = session.get(Ban.class, data.getId());
        LoaiBan loaiBan = loaiBanRepository.getById(data.getLoaiBan().getId());
        TinhTrangBan tinhTrangBan = tinhTrangBanRepository.getById(data.getTinhTrangBan().getId());
        
        session.getTransaction().begin();
        
        ban.setLoaiBan(loaiBan);
        ban.setTinhTrangBan(tinhTrangBan);
        
        session.save(ban);
        session.getTransaction().commit();
        
        session.close();
        
        return ban;
    }
    
    public void delete(int id){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        Ban ban = session.get(Ban.class, id);
        
        session.getTransaction().begin();
        session.delete(ban);
        session.getTransaction().commit();
        
        session.close();
    }
}
