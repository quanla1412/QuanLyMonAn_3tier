/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.repository;

import com.mycompany.quanlynhahang.AES;
import dal.HibernateUtils;
import dal.entity.ChucVu;
import dal.entity.NhanVien;
import dal.entity.TinhTrangNhanVien;
import gui.models.NhanVien.SearchNhanVienModel;
import gui.models.TaiKhoanModel;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author dinhn
 */
public class NhanVienRepository {
    private ChucVuRepository chucVuRepository;
    private TinhTrangNhanVienRepository tinhTrangNhanVienRepository;
    final String secretKey = "quanlynhahang!";
    
    
    public NhanVienRepository(){
        chucVuRepository = new ChucVuRepository();
        tinhTrangNhanVienRepository = new TinhTrangNhanVienRepository();
    }
    
    public List<NhanVien> getAll(){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<NhanVien> query = builder.createQuery(NhanVien.class);
        Root<NhanVien> nhanVienEntry = query.from(NhanVien.class);
        query = query.select(nhanVienEntry);
        
        Query queryResult = session.createQuery(query);
        ArrayList<NhanVien> result = (ArrayList<NhanVien>) queryResult.getResultList();
        result.forEach(item -> Hibernate.initialize(item.getListHoaDon()));
        session.close();
        
        return result;
    }
    
    public NhanVien getByMa(String ma){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        NhanVien nhanVien= session.get(NhanVien.class, ma);
        Hibernate.initialize(nhanVien.getListQuyenTaiKhoan());
        
        session.close();
        
        return nhanVien;
    }
    
    
    
     public NhanVien createNhanVien(NhanVien nhanVien){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        
        ChucVu chucVu = chucVuRepository.getById(nhanVien.getChucVu().getId());
        TinhTrangNhanVien tinhTrangNhanVien = tinhTrangNhanVienRepository.getById(nhanVien.getTinhTrangNhanVien().getId());
  
         session.getTransaction().begin();
        
        nhanVien.setChucVu(chucVu);
        nhanVien.setTinhTrangNhanVien(tinhTrangNhanVien);
        
        String ma = (String) session.save(nhanVien);
        nhanVien.setMa(ma);
        
        session.getTransaction().commit();
        session.close();
        
        return nhanVien;
    }
    
    public NhanVien updateNhanVien(NhanVien data){
        Session session = HibernateUtils.getFACTORY().openSession();
        NhanVien nhanVien = session.get(NhanVien.class, data.getMa());
        ChucVu chucVu = chucVuRepository.getById(data.getChucVu().getId());
        TinhTrangNhanVien tinhTrangNhanVien = tinhTrangNhanVienRepository.getById(data.getTinhTrangNhanVien().getId());
        
        session.getTransaction().begin();
        
        nhanVien.setChucVu(chucVu);
        nhanVien.setTinhTrangNhanVien(tinhTrangNhanVien);
        nhanVien.setDiaChi(data.getDiaChi());
        nhanVien.setHoTen(data.getHoTen());
        nhanVien.setEmail(data.getEmail());
        nhanVien.setSdt(data.getSdt());

        session.save(nhanVien);
        session.getTransaction().commit();
        
        session.close();
        
        return nhanVien;
    }
    
    public void delete(String ma){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        NhanVien nhanVien = session.get(NhanVien.class, ma);
        
        session.getTransaction().begin();
        session.delete(nhanVien);
        session.getTransaction().commit();
        
        session.close();
    }
    
     public List<NhanVien> getByNhieuMa (List<String> nma){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<NhanVien> query = builder.createQuery(NhanVien.class);
        Root<NhanVien> nhanVienEntry = query.from(NhanVien.class);
        query = query.select(nhanVienEntry).where(nhanVienEntry.get("ma").in(nma));
        
        Query<NhanVien> queryResult = session.createQuery(query);
        List<NhanVien> listNhanVien = queryResult.getResultList();       
        
        session.close();
        
        return listNhanVien;
    }
    
    public List<NhanVien> search(SearchNhanVienModel searchNhanVienModel) {
        Session session = HibernateUtils.getFACTORY().openSession();
        
        String sql = "SELECT NV.ma "
                + "FROM NhanVien NV LEFT JOIN NV.chucVu CV LEFT JOIN NV.tinhTrangNhanVien TTNV ";
                                                    
        ArrayList<String> conditions = new ArrayList<>();
        
        if(searchNhanVienModel.getMaOrhoTen() != null && !searchNhanVienModel.getMaOrhoTen().isBlank())
                conditions.add("(NV.ma LIKE '%" + searchNhanVienModel.getMaOrhoTen()+ "%' OR NV.hoTen LIKE '%" + searchNhanVienModel.getMaOrhoTen()+ "%')");
            
        if(searchNhanVienModel.getChucVu()> 0)
            conditions.add("CV.id = "+ searchNhanVienModel.getChucVu());
            
        if(searchNhanVienModel.isGioiTinh() >= 0)
            conditions.add("NV_gioiTinhNam = "+ searchNhanVienModel.isGioiTinh());
        
        ArrayList<String> listTinhTrangNhanVien = new ArrayList<>();
        for (int tinhTrang:searchNhanVienModel.getTinhTrang())
            listTinhTrangNhanVien.add(Integer.toString(tinhTrang));
        
        if(searchNhanVienModel.getTinhTrang() != null)
            conditions.add("TTNV.id IN ( " + String.join(",", listTinhTrangNhanVien ) +  " ) ");
        
        String whereSql = "";
        if(!conditions.isEmpty())
            whereSql = " WHERE ";
        String finalSql = sql + whereSql + String.join(" AND ", conditions);
        
        javax.persistence.Query query = session.createQuery(finalSql);
        List<String> nma = query.getResultList();
        
        session.close();           
        
        return getByNhieuMa(nma);
    }
    
    
    
    public boolean hasMaNV(String ma) {
        Session session = HibernateUtils.getFACTORY().openSession();
        NhanVien nhanVien = null;
       
            String hql = "FROM NhanVien NV WHERE NV.ma = :ma";
            Query query = session.createQuery(hql);
            query.setParameter("ma", ma);
            nhanVien = (NhanVien) query.uniqueResult();
       
            session.close();
        
        return nhanVien != null;
    }
    
 
    
    
    public NhanVien updateTaiKhoanNhanVien (NhanVien data){
        Session session = HibernateUtils.getFACTORY().openSession();
        NhanVien nhanVien = session.get(NhanVien.class, data.getMa());
        
        session.getTransaction().begin();
        String encryptedpassword = AES.encrypt(data.getPassWord(), secretKey);      
        
        nhanVien.setPassWord(encryptedpassword);
         
        session.save(nhanVien);
        session.getTransaction().commit();
        
        session.close();
        
        return nhanVien;
    } 
    
    
}
