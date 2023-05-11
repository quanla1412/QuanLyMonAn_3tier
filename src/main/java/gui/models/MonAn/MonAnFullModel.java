package gui.models.MonAn;

import gui.models.LoaiMonAn.LoaiMonAnModel;

/**
 *
 * @author LeAnhQuan
 */
public class MonAnFullModel {
    private int id;
    private String ten;
    private String hinhAnh;
    private LoaiMonAnModel loaiMonAnModel;
    private int gia;
    private int giaKhuyenMai;
    private TinhTrangMonAnModel tinhTrangMonAnModel;
    private String noiDung;

    public MonAnFullModel() {
    }

    public MonAnFullModel(int id, String ten, String hinhAnh, LoaiMonAnModel loaiMonAnModel, int gia, int giaKhuyenMai, TinhTrangMonAnModel tinhTrangMonAnModel, String noiDung) {
        this.id = id;
        this.ten = ten;
        this.hinhAnh = hinhAnh;
        this.loaiMonAnModel = loaiMonAnModel;
        this.gia = gia;
        this.giaKhuyenMai = giaKhuyenMai;
        this.tinhTrangMonAnModel = tinhTrangMonAnModel;
        this.noiDung = noiDung;
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

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public LoaiMonAnModel getLoaiMonAnModel() {
        return loaiMonAnModel;
    }

    public void setLoaiMonAnModel(LoaiMonAnModel loaiMonAnModel) {
        this.loaiMonAnModel = loaiMonAnModel;
    }

    public TinhTrangMonAnModel getTinhTrangMonAnModel() {
        return tinhTrangMonAnModel;
    }

    public void setTinhTrangMonAnModel(TinhTrangMonAnModel tinhTrangMonAnModel) {
        this.tinhTrangMonAnModel = tinhTrangMonAnModel;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getGiaKhuyenMai() {
        return giaKhuyenMai;
    }

    public void setGiaKhuyenMai(int giaKhuyenMai) {
        this.giaKhuyenMai = giaKhuyenMai;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}