/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.repository;

import dal.HibernateUtils;
import dal.entity.DonGoi;
import dal.entity.HoaDon;
import dal.entity.KhachHang;
import dal.entity.LoaiBan;
import dal.entity.MonAn;
import dal.entity.NhanVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import gui.models.HoaDon.SearchHoaDonModel;

/**
 *
 * @author tanph
 */
public class HoaDonRepository {
    private NhanVienRepository nhanVienRepository;
    private KhachHangRepository khachHangRepository;
    private MonAnRepository monAnRepository;
    private DonGoiRepository donGoiRepository;

    public HoaDonRepository() {
        nhanVienRepository = new NhanVienRepository();
        khachHangRepository = new KhachHangRepository();
        monAnRepository = new MonAnRepository();
        donGoiRepository = new DonGoiRepository();
    }
    
    

    public List<HoaDon> getAllHoaDon(){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HoaDon> query = builder.createQuery(HoaDon.class);
        Root<HoaDon> hoaDonEntry = query.from(HoaDon.class);
        query = query.select(hoaDonEntry);
     
        
        Query queryResult = session.createQuery(query);
        List<HoaDon> listHoaDon = queryResult.getResultList();
        
        session.close();
        
        return listHoaDon;
    }
    
    public HoaDon getById(int idHoaDon){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        HoaDon hoaDon = session.get(HoaDon.class, idHoaDon);
        
        session.close();
        
        return hoaDon;
    }
    
    public List<HoaDon> getByIds(List<Integer> ids){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HoaDon> query = builder.createQuery(HoaDon.class);
        Root<HoaDon> hoaDonEntry = query.from(HoaDon.class);
        query = query.select(hoaDonEntry).where(hoaDonEntry.get("id").in(ids));
        
        Query queryResult = session.createQuery(query);
        List<HoaDon> listHoaDon = queryResult.getResultList();
        
        session.close();
        
        return listHoaDon;
    }
    
    public List<HoaDon> search(SearchHoaDonModel searchHoaDonModel ){
        Session session = HibernateUtils.getFACTORY().openSession();

        String sql = "SELECT HD.id FROM HoaDon HD";
            
        ArrayList<String> conditions = new ArrayList<>();
        
        if(searchHoaDonModel.getId() != null && !searchHoaDonModel.getId().isBlank())
            conditions.add("HD.id LIKE '%" + searchHoaDonModel.getId() + "%'");
          
        if(searchHoaDonModel.getNgayBatDau() != null)
            conditions.add("HD.ngayGio BETWEEN '" + searchHoaDonModel.getNgayBatDau() + "' AND '" + searchHoaDonModel.getNgayCuoiCung() + "'");
        
        if (searchHoaDonModel.getMinPrice() > 0)
            conditions.add("HD.tongGia > " + searchHoaDonModel.getMinPrice());
            
        if (searchHoaDonModel.getMaxPrice() > 0)
            conditions.add("HD.tongGia < " + searchHoaDonModel.getMaxPrice());
          
        if(searchHoaDonModel.getIdTTHD() >= 0)
            conditions.add("HD.daHuy = " + searchHoaDonModel.getIdTTHD());
        
        String whereSql = "";
        if(!conditions.isEmpty())
            whereSql = " WHERE ";
        String finalSql = sql + whereSql + String.join(" AND ", conditions);
        
        javax.persistence.Query query = session.createQuery(finalSql);
        List<Integer> ids = query.getResultList();
        
        session.close();           
        
        return getByIds(ids);
    }
    
    
    public HoaDon huyHoaDon(int idHoaDon){
        Session session = HibernateUtils.getFACTORY().openSession();
        HoaDon hoaDon = session.get(HoaDon.class, idHoaDon);
        
        session.getTransaction().begin();
        hoaDon.setDaHuy(true);
        session.save(hoaDon);
        
        session.getTransaction().commit();
        session.close();
        return hoaDon;
    }
    
    public HoaDon create(HoaDon hoaDon){
        Session session = HibernateUtils.getFACTORY().openSession();
        session.getTransaction().begin();
        
        NhanVien nhanVien = nhanVienRepository.getByMa(hoaDon.getNhanVien().getMa());
        hoaDon.setNhanVien(nhanVien);
        
        if(hoaDon.getKhachHang() != null){
            KhachHang khachHang = khachHangRepository.getById(hoaDon.getKhachHang().getId());
            hoaDon.setKhachHang(khachHang);
        }
        
        int idHoaDon = (int) session.save(hoaDon);
        hoaDon.setId(idHoaDon);
        hoaDon.getListChiTietHoaDon().forEach(chiTietHoaDon -> {
            chiTietHoaDon.setHoaDon(hoaDon);
            chiTietHoaDon.initChiTietHoaDonKey();
            
            MonAn monAn = monAnRepository.getById(chiTietHoaDon.getMonAn().getId());
            chiTietHoaDon.setMonAn(monAn);
            
            session.save(chiTietHoaDon);
        });
        
        session.getTransaction().commit();
        
        return hoaDon;
    }
}
