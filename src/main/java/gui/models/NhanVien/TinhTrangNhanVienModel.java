/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.models.NhanVien;


/**
 *
 * @author dinhn
 */
public class TinhTrangNhanVienModel {
    private int id;
    private String ten;

    public TinhTrangNhanVienModel(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public TinhTrangNhanVienModel() {
      
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

    @Override
    public int hashCode() {
        int hash = 3;
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
        final TinhTrangNhanVienModel other = (TinhTrangNhanVienModel) obj;
        return this.id == other.id;
    }
    
}
