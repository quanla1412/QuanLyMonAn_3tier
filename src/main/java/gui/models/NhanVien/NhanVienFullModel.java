/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.models.NhanVien;

import java.util.Date;

/**
 *
 * @author dinhn
 */
public class NhanVienFullModel {
    private String ma;
    private TinhTrangNhanVienModel tinhTrangNhanVien;
    private ChucVuModel chucVu;
    private String hoTen;
    private Date ngaySinh;
    private boolean gioiTinhNam;
    private String email;
    private String soDienThoai;
    private String diaChi;
    private String passWord;
    private String CCCD;

    public NhanVienFullModel(String ma, TinhTrangNhanVienModel tinhTrangNhanVien, ChucVuModel chucVu, String hoTen, Date ngaySinh, boolean gioiTinhNam, String email, String soDienThoai, String diaChi, String CCCD) {
        this.ma = ma;
        this.tinhTrangNhanVien = tinhTrangNhanVien;
        this.chucVu = chucVu;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinhNam = gioiTinhNam;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.CCCD = CCCD;
    }

    public NhanVienFullModel() {
     
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public TinhTrangNhanVienModel getTinhTrangNhanVien() {
        return tinhTrangNhanVien;
    }

    public void setTinhTrangNhanVien(TinhTrangNhanVienModel tinhTrangNhanVien) {
        this.tinhTrangNhanVien = tinhTrangNhanVien;
    }

    public ChucVuModel getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVuModel chucVu) {
        this.chucVu = chucVu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }
}
