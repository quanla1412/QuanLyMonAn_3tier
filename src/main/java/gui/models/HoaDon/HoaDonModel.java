/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.models.HoaDon;

import java.util.Date;


public class HoaDonModel {
    private int id;
    private String maNhanVien;
    private Integer idKhachHang;
    private Date ngayGio;
    private long tongGia;
    
    public HoaDonModel() {
    }

    public HoaDonModel(int id, String maNhanVien, int idKhachHang, Date ngayGio, long tongGia) {
        this.id = id;
        this.maNhanVien = maNhanVien;
        this.idKhachHang = idKhachHang;
        this.ngayGio = ngayGio;
        this.tongGia = tongGia;
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

    public long getTongGia() {
        return tongGia;
    }

    public void setTongGia(long tongGia) {
        this.tongGia = tongGia;
    }

    
}
