
package dal.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import java.lang.String;
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
import javax.persistence.TemporalType;

/**
 *
 * @author dinhn
 */
@Entity
@Table(name="NhanVien")
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
    private boolean gioiTinhNam;
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
    @OneToMany(mappedBy = "nhanVien")
    private List<HoaDon> listHoaDon;
    @OneToMany(mappedBy = "nhanVien")
    private List<QuyenTaiKhoan> listQuyenTaiKhoan;

    public List<HoaDon> getListHoaDon() {
        return listHoaDon;
    }

    public void setListHoaDon(List<HoaDon> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }

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
     public boolean getGioiTinhNam() {
        return gioiTinhNam;
    }

    public List<QuyenTaiKhoan> getListQuyenTaiKhoan() {
        return listQuyenTaiKhoan;
    }

    public void setListQuyenTaiKhoan(List<QuyenTaiKhoan> listQuyenTaiKhoan) {
        this.listQuyenTaiKhoan = listQuyenTaiKhoan;
    }

    public void setTinhTrangNhanVien(int DA_NGHI) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
