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
    private NhanVien nhanVien;
    @ManyToOne
    @JoinColumn(name = "KH_ID")
    private KhachHang khachHang;
    @Column (name = "HD_NgayGio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayGio;
    @Column (name = "HD_TongGia")
    private long tongGia;
    @Column (name = "HD_UuDai")
    private float uuDai;
    @Column (name = "HD_DaHuy")
    private boolean daHuy;
    @OneToMany(mappedBy = "hoaDon")
    List<ChiTietHoaDon> listChiTietHoaDon;

    public List<ChiTietHoaDon> getListChiTietHoaDon() {
        return listChiTietHoaDon;
    }

    public void setListChiTietHoaDon(List<ChiTietHoaDon> listChiTietHoaDon) {
        this.listChiTietHoaDon = listChiTietHoaDon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
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

    public long getTongGia() {
        return tongGia;
    }

    public void setTongGia(long tongGia) {
        this.tongGia = tongGia;
    }

    public float getUuDai() {
        return uuDai;
    }

    public void setUuDai(float uuDai) {
        this.uuDai = uuDai;
    }
}
