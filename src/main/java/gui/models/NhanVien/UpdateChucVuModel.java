/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.models.NhanVien;

/**
 *
 * @author dinhn
 */
public class UpdateChucVuModel {
    private int id;
    private String ten;

    public UpdateChucVuModel(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }
    
    public UpdateChucVuModel()
    {
        
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
}
