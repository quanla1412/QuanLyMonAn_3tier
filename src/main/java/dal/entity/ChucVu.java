/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author dinhn
 */
@Entity
@Table(name = "ChucVu")
public class ChucVu implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "CV_ID")
    private int id;
    @Column(name = "CV_Ten")
    private String ten;
    @OneToMany(mappedBy = "chucVu")
    private List<NhanVien> listNhanVien;

    public List<NhanVien> getListNhanVien() {
        return listNhanVien;
    }
    

    public void setListNhanVien(List<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    
    
    
}
