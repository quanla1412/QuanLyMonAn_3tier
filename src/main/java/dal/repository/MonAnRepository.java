package dal.repository;

import dal.HibernateUtils;
import dal.entity.LoaiMonAn;
import dal.entity.MonAn;
import gui.models.MonAn.SearchMonAnModel;
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
    
    public List<MonAn> getByIds(List<Integer> ids){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MonAn> query = builder.createQuery(MonAn.class);
        Root<MonAn> monAnEntry = query.from(MonAn.class);
        query = query.select(monAnEntry).where(monAnEntry.get("id").in(ids));
        
        Query<MonAn> queryResult = session.createQuery(query);
        List<MonAn> listMonAn = queryResult.getResultList();       
        
        session.close();
        
        return listMonAn;
    }
    
    public MonAn getByName(String ten){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MonAn> query = builder.createQuery(MonAn.class);
        Root<MonAn> monAnEntry = query.from(MonAn.class);
        query = query.select(monAnEntry);
        
        Predicate predicate = builder.equal(monAnEntry.get("ten").as(String.class), ten);
        query = query.where(predicate);        
        
        Query<MonAn> queryResult = session.createQuery(query);
        MonAn result = null;
        try{
            result = queryResult.getSingleResult();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            session.close();            
        }
        
        return result;
    }

    public List<MonAn> search(SearchMonAnModel searchMonAnModel) {
        Session session = HibernateUtils.getFACTORY().openSession();
        
        String sql = "SELECT MA.id "
                + "FROM MonAn MA LEFT JOIN MA.loaiMonAn LMA LEFT JOIN MA.tinhTrangMonAn TTMA ";
                                                    
        ArrayList<String> conditions = new ArrayList<>();
        
        if(searchMonAnModel.getIdOrName() != null && !searchMonAnModel.getIdOrName().isBlank())
                conditions.add("(MA.id LIKE N'%" + searchMonAnModel.getIdOrName() + "%' OR MA.ten LIKE '%" + searchMonAnModel.getIdOrName() + "%')");
            
        if(searchMonAnModel.getIdLoaiMonAn() > 0)
            conditions.add("LMA.id = "+ searchMonAnModel.getIdLoaiMonAn());
            
        if (searchMonAnModel.getMinPrice() > 0) 
            conditions.add("MA.gia > " + searchMonAnModel.getMinPrice()); 
        
        if (searchMonAnModel.getMaxPrice() > 0) 
            conditions.add("MA.gia < " + searchMonAnModel.getMaxPrice());

        if(searchMonAnModel.getIdTTMA()> 0)
            conditions.add("TTMA.id = " + searchMonAnModel.getIdTTMA());
        
        String whereSql = "";
        if(!conditions.isEmpty())
            whereSql = " WHERE ";
        String finalSql = sql + whereSql + String.join(" AND ", conditions);
        
        javax.persistence.Query query = session.createQuery(finalSql);
        List<Integer> ids = query.getResultList();
        
        session.close();           
        
        return getByIds(ids);
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
