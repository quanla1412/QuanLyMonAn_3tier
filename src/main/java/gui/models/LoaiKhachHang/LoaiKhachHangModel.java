/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.models.LoaiKhachHang;

import java.util.Objects;

/**
 *
 * @author tuant
 */
public class LoaiKhachHangModel {
    private int id;
    private String ten;
    private int diemToiThieu;
    private float mucUuDai;

    public LoaiKhachHangModel() {
    }

    public LoaiKhachHangModel(int id, String ten, int diemToiThieu, float mucUuDai) {
        this.id = id;
        this.ten = ten;
        this.diemToiThieu = diemToiThieu;
        this.mucUuDai = mucUuDai;
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

    public int getDiemToiThieu() {
        return diemToiThieu;
    }

    public void setDiemToiThieu(int diemToiThieu) {
        this.diemToiThieu = diemToiThieu;
    }

    public float getMucUuDai() {
        return mucUuDai;
    }

    public void setMucUuDai(float mucUuDai) {
        this.mucUuDai = mucUuDai;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.ten);
        hash = 13 * hash + this.diemToiThieu;
        hash = 13 * hash + Float.floatToIntBits(this.mucUuDai);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoaiKhachHangModel other = (LoaiKhachHangModel) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.diemToiThieu != other.diemToiThieu) {
            return false;
        }
        if (Float.floatToIntBits(this.mucUuDai) != Float.floatToIntBits(other.mucUuDai)) {
            return false;
        }
        return Objects.equals(this.ten, other.ten);
    }
    
}
