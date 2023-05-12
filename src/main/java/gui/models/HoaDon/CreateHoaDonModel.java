package gui.models.HoaDon;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author LeAnhQuan
 */
public class CreateHoaDonModel {
    private String maNhanVien;
    private int idKhachHang;
    private Date ngayGio;
    private long tongGia;
    private float uuDai;
    private int idBan;
    private ArrayList<CreateChiTietHoaDonModel> listChiTietHoaDonModel;

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Date getNgayGio() {
        return ngayGio;
    }

    public void setNgayGio(Date ngayGio) {
        this.ngayGio = ngayGio;
    }

    public long getTongGia() {
        return tongGia;
    }

    public void setTongGia(long tongGia) {
        this.tongGia = tongGia;
    }

    public float getUuDai() {
        return uuDai;
    }

    public void setUuDai(float uuDai) {
        this.uuDai = uuDai;
    }

    public ArrayList<CreateChiTietHoaDonModel> getListChiTietHoaDonModel() {
        return listChiTietHoaDonModel;
    }

    public void setListChiTietHoaDonModel(ArrayList<CreateChiTietHoaDonModel> listChiTietHoaDonModel) {
        this.listChiTietHoaDonModel = listChiTietHoaDonModel;
    }

    public int getIdBan() {
        return idBan;
    }

    public void setIdBan(int idBan) {
        this.idBan = idBan;
    }
}
