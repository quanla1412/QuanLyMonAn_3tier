/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author tanph
 */
@Entity
@Table( name = "HoaDon")
public class HoaDon implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "HD_ID")
    private int id;
    @ManyToOne
    @JoinColumn(name = "NV_Ma")
    private NhanVien maNhanVien;
    @ManyToOne
    @JoinColumn(name = "KH_ID")
    private KhachHang idKhachHang;
    @Column (name = "HD_NgayGio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayGio;
    @Column (name = "HD_TongGia")
    private int tongGia;
    @Column (name = "HD_UuDai")
    private float uuDai;
    @Column (name = "HD_DaHuy")
    private boolean daHuy;
    
    @OneToMany(mappedBy = "maHoaDon")
    List<ChiTietHoaDon> soLuong;
    @OneToMany(mappedBy = "maHoaDon")
    List<ChiTietHoaDon> donGia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NhanVien getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(NhanVien maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public KhachHang getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(KhachHang idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Date getNgayGio() {
        return ngayGio;
    }

    public void setNgayGio(Date ngayGio) {
        this.ngayGio = ngayGio;
    }

    public boolean isDaHuy() {
        return daHuy;
    }

    public void setDaHuy(boolean daHuy) {
        this.daHuy = daHuy;
    }

    public List<ChiTietHoaDon> getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(List<ChiTietHoaDon> soLuong) {
        this.soLuong = soLuong;
    }

    public List<ChiTietHoaDon> getDonGia() {
        return donGia;
    }

    public void setDonGia(List<ChiTietHoaDon> donGia) {
        this.donGia = donGia;
    }

    public int getTongGia() {
        return tongGia;
    }

    public void setTongGia(int tongGia) {
        this.tongGia = tongGia;
    }

    public float getUuDai() {
        return uuDai;
    }

    public void setUuDai(float uuDai) {
        this.uuDai = uuDai;
    }


}
