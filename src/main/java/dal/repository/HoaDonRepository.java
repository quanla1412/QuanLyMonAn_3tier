/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.repository;

import dal.HibernateUtils;
import dal.entity.HoaDon;
import dal.entity.LoaiBan;
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

/**
 *
 * @author tanph
 */
public class HoaDonRepository {

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
    
    public List<HoaDon> search(SearchHoaDonModel searchHoaDonModel){
        Session session = HibernateUtils.getFACTORY().openSession();
        
        
        StringBuilder sql = new StringBuilder("SELECT HD_ID, NV_Ma, KH_ID , HD_NgayGio, HD_TongGia"
                                                + " FROM HoaDon"
                                                + " WHERE ");
            
        ArrayList<String> conditions = new ArrayList<>();
        
        if(searchHoaDonModel.getId() != null && !searchHoaDonModel.getId().isBlank())
            conditions.add("HD_ID LIKE '%" + searchHoaDonModel.getId() + "%'");
          
        if(searchHoaDonModel.getNgayBatDau() != null)
            conditions.add("HD_NgayGio BETWEEN '" + searchHoaDonModel.getNgayBatDau() + "' AND '" + searchHoaDonModel.getNgayCuoiCung() + "'");
        
        if (searchHoaDonModel.getMinPrice() > 0)
            conditions.add("HD_TongGia > " + searchHoaDonModel.getMinPrice());
            
        if (searchHoaDonModel.getMaxPrice() > 0)
            conditions.add("HD_TongGia < " + searchHoaDonModel.getMaxPrice());
          
        if(searchHoaDonModel.getIdTTHD() >= 0)
            conditions.add("HD_DaHuy = " + searchHoaDonModel.getIdTTHD());
                
            
            sql.append(String.join(" AND ", listSQL));
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql.toString());
            
            while(rs.next()){
                HoaDon_DTO hoaDon = new HoaDon_DTO();
                
                hoaDon.setId(rs.getInt("HD_ID"));
                hoaDon.setMaNhanVien(rs.getString("NV_Ma"));
                hoaDon.setIdKhachHang(rs.getInt("KH_ID"));
                hoaDon.setNgayGio(rs.getTimestamp("HD_NgayGio"));
                hoaDon.setTongGia(rs.getInt("HD_TongGia"));
                
                result.add(hoaDon);
            }        
      
        return result;
    }
    

    
}
