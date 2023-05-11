package dal.repository;

import dal.HibernateUtils;
import dal.entity.Ban;
import dal.entity.DonGoi;
import dal.entity.MonAn;
import org.hibernate.Session;
import java.util.List;

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
        
        session.getTransaction().begin();
        DonGoi donGoi = session.get(DonGoi.class, data.getDonGoiKey());
        
        session.delete(donGoi);
        
        session.getTransaction().commit();        
        session.close();
        
        return donGoi;
    }
}
