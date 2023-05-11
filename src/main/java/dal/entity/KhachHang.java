/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author tuant
 */
@Entity
@Table( name = "KhachHang" )
public class KhachHang implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "KH_ID")
    private int id;
    @Column(name="KH_Ten")
    private String ten;
    @Column(name="KH_SDT")
    private String sdt;
    @Column(name="KH_DiemTichLuy")
    private int diemTichLuy;
    @ManyToOne
    @JoinColumn(name="LKH_ID")
    private LoaiKhachHang loaiKhachHang;
    @Column(name="KH_Email")
    private String email;
    @Column(name="KH_NgaySinh")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySinh;
    @Column(name="KH_GioiTinhNam")
    private boolean gioiTinhNam;
    @OneToMany(mappedBy = "idKhachHang")
    private List<KhachHang> listKhachHang;

    public List<KhachHang> getListKhachHang() {
        return listKhachHang;
    }

    public void setListKhachHang(List<KhachHang> listKhachHang) {
        this.listKhachHang = listKhachHang;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public LoaiKhachHang getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(LoaiKhachHang loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinhNam() {
        return gioiTinhNam;
    }

    public void setGioiTinhNam(boolean gioiTinhNam) {
        this.gioiTinhNam = gioiTinhNam;
    }
    
    
}