/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.models.HoaDon;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author tanph
 */
public class HoaDonFullModel {
    private int id;
    private String maNhanVien;
    private Integer idKhachHang;
    private Date ngayGio;
    private boolean daHuy;
    private List<ChiTietHoaDonModel> listChiTietHoaDon;
    private long tongGia;
    private float uuDai;

    public HoaDonFullModel() {
    }

    public HoaDonFullModel(int id, String maNhanVien, int idKhachHang, Date ngayGio, boolean daHuy, List<ChiTietHoaDonModel> listChiTietHoaDon, long tongGia, float uuDai) {
        this.id = id;
        this.maNhanVien = maNhanVien;
        this.idKhachHang = idKhachHang;
        this.ngayGio = ngayGio;
        this.daHuy = daHuy;
        this.listChiTietHoaDon = listChiTietHoaDon;
        this.tongGia = tongGia;
        this.uuDai = uuDai;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
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

    public List<ChiTietHoaDonModel> getListChiTietHoaDon() {
        return listChiTietHoaDon;
    }

    public void setListChiTietHoaDon(List<ChiTietHoaDonModel> listChiTietHoaDon) {
        this.listChiTietHoaDon = listChiTietHoaDon;
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
