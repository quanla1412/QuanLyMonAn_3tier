/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.models.HoaDon;

import java.util.Date;

/**
 *
 * @author tanph
 */
public class SearchHoaDonModel {
    private String id;
    private Date ngayBatDau;
    private Date ngayCuoiCung;
    private int minPrice;
    private int maxPrice;
    private int idTTHD;

    public SearchHoaDonModel(String id, Date ngayBatDau, Date ngayCuoiCung, int minPrice, int maxPrice, int idTTHD) {
        this.id = id;
        this.ngayBatDau = ngayBatDau;
        this.ngayCuoiCung = ngayCuoiCung;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.idTTHD = idTTHD;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayCuoiCung() {
        return ngayCuoiCung;
    }

    public void setNgayCuoiCung(Date ngayCuoiCung) {
        this.ngayCuoiCung = ngayCuoiCung;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getIdTTHD() {
        return idTTHD;
    }

    public void setIdTTHD(int idTTHD) {
        this.idTTHD = idTTHD;
    }
}
