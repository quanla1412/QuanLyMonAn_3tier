/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author tanph
 */
@Entity
@Table( name = "ChiTietHoaDon")
public class ChiTietHoaDon implements Serializable {
    
    @EmbeddedId
    ChiTietHoaDonKey idChiTietHoaDon;
    
    @OneToOne
    @JoinColumn(name = "HD_ID")
    private HoaDon maHoaDon;
    @OneToOne
    @JoinColumn(name = "MA_ID")
    private MonAn maMonAn;
    @JoinColumn(name = "CTHD_SoLuong")
    private int soLuong;
    @JoinColumn(name = "CTHD_DonGia")
    private int donGia;

    public ChiTietHoaDonKey getIdChiTietHoaDon() {
        return idChiTietHoaDon;
    }

    public void setIdChiTietHoaDon(ChiTietHoaDonKey idChiTietHoaDon) {
        this.idChiTietHoaDon = idChiTietHoaDon;
    }

    public HoaDon getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(HoaDon maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public MonAn getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(MonAn maMonAn) {
        this.maMonAn = maMonAn;
    }



    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
}

@Embeddable
class ChiTietHoaDonKey implements Serializable{
    @Column(name = "HD_ID")
    private int idHoaDon;
    
    @Column(name = "MA_ID")
    private int idMonAn;
}