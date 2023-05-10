/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.models.KhachHang;

import gui.models.LoaiKhachHang.LoaiKhachHangModel;
import java.util.Date;

/**
 *
 * @author tuant
 */
public class KhachHangFullModel {
    private int id;
    private String ten;
    private String sdt;
    private int diemTichLuy;
    private LoaiKhachHangModel loaiKhachHang;
    private String email;
    private Date ngaySinh;
    private boolean gioiTinhNam;

    public KhachHangFullModel() {
    }

    public KhachHangFullModel(int id, String ten, String sdt, int diemTichLuy, LoaiKhachHangModel loaiKhachHang, String email, Date ngaySinh, boolean gioiTinhNam) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.diemTichLuy = diemTichLuy;
        this.loaiKhachHang = loaiKhachHang;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.gioiTinhNam = gioiTinhNam;
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

    public LoaiKhachHangModel getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(LoaiKhachHangModel loaiKhachHang) {
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
