/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.models.NhanVien;

/**
 *
 * @author dinhn
 */
public class UpdateNhanVienModel {
     private String ma;
    private int idTinhTrangNhanVien;
    private int idChucVu;
    private String hoTen;
    private String email;
    private String soDienThoai ;
    private String diaChi ;

    public UpdateNhanVienModel(String ma, int idTinhTrangNhanVien, int idChucVu, String hoTen, String email, String soDienThoai, String diaChi) {
        this.ma = ma;
        this.idTinhTrangNhanVien = idTinhTrangNhanVien;
        this.idChucVu = idChucVu;
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getIdTinhTrangNhanVien() {
        return idTinhTrangNhanVien;
    }

    public void setIdTinhTrangNhanVien(int idTinhTrangNhanVien) {
        this.idTinhTrangNhanVien = idTinhTrangNhanVien;
    }

    public int getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(int idChucVu) {
        this.idChucVu = idChucVu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
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
    
}
