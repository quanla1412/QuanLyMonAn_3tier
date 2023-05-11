package dal.repository;

import dal.HibernateUtils;
import dal.entity.Ban;
import dal.entity.LoaiBan;
import java.util.ArrayList;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.lang.String;
import org.hibernate.Hibernate;
import org.hibernate.type.StringNVarcharType;
/**
 *
 * @author LeAnhQuan
 */
public class LoaiBanRepository {
    public ArrayList<LoaiBan> getAll(){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LoaiBan> query = builder.createQuery(LoaiBan.class);
        Root<LoaiBan> loaiBanEntry = query.from(LoaiBan.class);
        query = query.select(loaiBanEntry);
        
        Query queryResult = session.createQuery(query);
        ArrayList<LoaiBan> result = (ArrayList<LoaiBan>) queryResult.getResultList();
        session.close();
        
        return result;
    }
    
    public LoaiBan getById(int id){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        LoaiBan loaiBan= session.get(LoaiBan.class, id);
        Hibernate.initialize(loaiBan.getListBan());
        session.close();
        
        return loaiBan;
    }
    
    public LoaiBan getByName(String name){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LoaiBan> query = builder.createQuery(LoaiBan.class);
        Root<LoaiBan> banEntry = query.from(LoaiBan.class);
        query = query.select(banEntry);
        
        Predicate predicate = builder.equal(banEntry.get("ten").as(String.class), name);
        query = query.where(predicate);
         
//        String queryString = "FROM LoaiBan WHERE LB_Ten =:name";
        Query queryResult = session.createQuery(query);
//        queryResult.setParameter("name", name, StringNVarcharType.INSTANCE);
        LoaiBan result;
        try {
            //Dòng dưới này hình như dư nè Quân Anh Lê
            ArrayList<LoaiBan> resultList = (ArrayList<LoaiBan>) queryResult.getResultList();            
            result = (LoaiBan) queryResult.getSingleResult();            
        } catch (Exception e) {
            return null;
        }
        session.close();
        
        return result;
        
    }
    
    public LoaiBan createLoaiBan(LoaiBan loaiBan){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        int idLoaiBan = (int) session.save(loaiBan);
        loaiBan.setId(idLoaiBan);
        
        session.close();
        
        return loaiBan;
        
    }
    
    public LoaiBan updateLoaiBan (LoaiBan loaiBanUpdate){
        Session session = HibernateUtils.getFACTORY().openSession();
        LoaiBan loaiBan= session.get(LoaiBan.class, loaiBanUpdate.getId());
        
        session.getTransaction().begin();
        
        loaiBan.setTen(loaiBanUpdate.getTen());
        loaiBan.setSoLuongCho(loaiBanUpdate.getSoLuongCho());
        
        session.save(loaiBan);
        session.getTransaction().commit();
        
        session.close();
        
        return loaiBan;
    }
    
    public void deleteLoaiBan (int idLoaiBan){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        session.getTransaction().begin();
        LoaiBan loaiBan = session.get(LoaiBan.class, idLoaiBan);
        session.delete(loaiBan);
        session.getTransaction().commit();
        
        session.close();
    }
}
