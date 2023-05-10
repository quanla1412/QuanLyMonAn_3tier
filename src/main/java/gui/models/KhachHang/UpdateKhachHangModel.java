/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.models.KhachHang;

import dal.entity.LoaiKhachHang;
import java.util.Date;

/**
 *
 * @author tuant
 */
public class UpdateKhachHangModel {
    private int id;
    private String ten;
    private String sdt;
    private String email;
    private Date ngaySinh;
    private boolean gioiTinhNam;

    

    public UpdateKhachHangModel() {
    }

    public UpdateKhachHangModel(int id, String ten, String sdt, String email, Date ngaySinh, boolean gioiTinhNam) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
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
