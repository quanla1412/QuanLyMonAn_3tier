
package dal.entity;

import java.io.Serializable;
import java.util.Date;
<<<<<<< HEAD
import javax.persistence.Column;
=======
import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Entity;
>>>>>>> dev
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
<<<<<<< HEAD
=======
import javax.persistence.Table;
>>>>>>> dev
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dinhn
 */
<<<<<<< HEAD
=======
@Entity
@Table(name="NhanVien")
>>>>>>> dev
public class NhanVien implements Serializable{
    @Id
    @Column(name = "NV_Ma")
    private String ma;
    @ManyToOne
    @JoinColumn(name="TTNV_ID")
    private TinhTrangNhanVien tinhTrangNhanVien;
    @ManyToOne
    @JoinColumn(name = "CV_ID")
    private ChucVu chucVu;
    @Column(name = "NV_HoTen")
    private String hoTen;
    @Column(name = "NV_NgaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @Column(name = "NV_GioiTinhNam")
<<<<<<< HEAD
    private String gioiTinhNam;
=======
    private boolean gioiTinhNam;
>>>>>>> dev
    @Column(name = "NV_Email")
    private String email;
    @Column(name = "NV_SDT")
    private String sdt;
    @Column(name = "NV_DiaChi")
    private String diaChi;
    @Column(name = "NV_PassWord")
    private String passWord;
    @Column(name = "NV_CCCD")
    private String cccd;
<<<<<<< HEAD
    
    
=======
>>>>>>> dev

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public TinhTrangNhanVien getTinhTrangNhanVien() {
        return tinhTrangNhanVien;
    }

    public void setTinhTrangNhanVien(TinhTrangNhanVien tinhTrangNhanVien) {
        this.tinhTrangNhanVien = tinhTrangNhanVien;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
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

<<<<<<< HEAD
    public String getGioiTinhNam() {
        return gioiTinhNam;
    }

    public void setGioiTinhNam(String gioiTinhNam) {
=======
    public boolean isGioiTinhNam() {
        return gioiTinhNam;
    }
    
    public void setGioiTinhNam(boolean gioiTinhNam) {
>>>>>>> dev
        this.gioiTinhNam = gioiTinhNam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }
<<<<<<< HEAD
=======

     public boolean getGioiTinhNam() {
        return gioiTinhNam;
    }
>>>>>>> dev
    
    
    
  
}
