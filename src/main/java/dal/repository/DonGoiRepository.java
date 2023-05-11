package dal.repository;

import dal.HibernateUtils;
import dal.entity.Ban;
import dal.entity.DonGoi;
import dal.entity.MonAn;
import org.hibernate.Session;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;

/**
 *
 * @author LeAnhQuan
 */
public class DonGoiRepository {
    BanRepository banRepository;
    MonAnRepository monAnRepository;

    public DonGoiRepository() {
        banRepository = new BanRepository();
        monAnRepository = new MonAnRepository();
    }
    
    public DonGoi getByKey(int idBan, int idMonAn){
        Session session = HibernateUtils.getFACTORY().openSession();
        DonGoi donGoi = new DonGoi();
        donGoi.setDonGoiKey(idBan, idMonAn);
        
        donGoi = session.get(DonGoi.class, donGoi.getDonGoiKey());
        
        session.close();
        
        return donGoi;
    }
    
    public List<DonGoi> getByBan(int idBan){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<DonGoi> query = builder.createQuery(DonGoi.class);
        Root<DonGoi> donGoiEntry = query.from(DonGoi.class);
        query = query.select(donGoiEntry);
        Predicate predicate = builder.equal(donGoiEntry.get("ban").get("id").as(Integer.class), idBan);
        query = query.where(predicate);
        
        Query queryResult = session.createQuery(query);
        List<DonGoi> listDonGoi = queryResult.getResultList();
        
        session.close();
        
        return listDonGoi;
    }
    
    public DonGoi create(DonGoi donGoi){
        Session session = HibernateUtils.getFACTORY().openSession();
        Ban ban = banRepository.getById(donGoi.getBan().getId());
        MonAn monAn = monAnRepository.getById(donGoi.getMonAn().getId());
        donGoi.initDonGoiKey();
        donGoi.setBan(ban);
        donGoi.setMonAn(monAn);
        
        session.getTransaction().begin();
        
        session.save(donGoi);
        
        session.getTransaction().commit();        
        session.close();
        
        return donGoi;
    }
    
    public DonGoi update(DonGoi data){
        Session session = HibernateUtils.getFACTORY().openSession();
        data.initDonGoiKey();
        
        session.getTransaction().begin();
        
        DonGoi donGoi = session.get(DonGoi.class, data.getDonGoiKey());
        donGoi.setSoLuong(data.getSoLuong());
        donGoi.setGhiChu(data.getGhiChu());
        session.save(donGoi);
        
        session.getTransaction().commit();        
        session.close();
        
        return donGoi;
    }
    
    public DonGoi delete(DonGoi data){
        Session session = HibernateUtils.getFACTORY().openSession();
        data.initDonGoiKey();
        
        session.getTransaction().begin();
        DonGoi donGoi = session.get(DonGoi.class, data.getDonGoiKey());
        
        session.delete(donGoi);
        
        session.getTransaction().commit();        
        session.close();
        
        return donGoi;
    }
}
