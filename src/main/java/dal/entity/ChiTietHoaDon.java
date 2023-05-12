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
import javax.persistence.MapsId;
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
    ChiTietHoaDonKey chiTietHoaDonKey;
    
    @ManyToOne
    @MapsId("idHoaDon")
    @JoinColumn(name = "HD_ID")
    private HoaDon hoaDon;
    @ManyToOne  
    @MapsId("idMonAn")
    @JoinColumn(name = "MA_ID")
    private MonAn monAn;
    @Column(name = "CTHD_SoLuong")
    private int soLuong;
    @Column(name = "CTHD_DonGia")
    private int donGia;

    public ChiTietHoaDonKey getChiTietHoaDonKey() {
        return chiTietHoaDonKey;
    }

    public void setChiTietHoaDonKey(ChiTietHoaDonKey chiTietHoaDonKey) {
        this.chiTietHoaDonKey = chiTietHoaDonKey;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public MonAn getMonAn() {
        return monAn;
    }

    public void setMonAn(MonAn monAn) {
        this.monAn = monAn;
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
    
    public void initChiTietHoaDonKey(){
        chiTietHoaDonKey = new ChiTietHoaDonKey(this.hoaDon.getId(), this.monAn.getId());
    }
}

@Embeddable
class ChiTietHoaDonKey implements Serializable{
    @Column(name = "HD_ID")
    private int idHoaDon;
    
    @Column(name = "MA_ID")
    private int idMonAn;

    public ChiTietHoaDonKey() {
    }

    public ChiTietHoaDonKey(int idHoaDon, int idMonAn) {
        this.idHoaDon = idHoaDon;
        this.idMonAn = idMonAn;
    }
}