package gui.models.MonAn;

/**
 *
 * @author LeAnhQuan
 */
public class MonAnModel {
    private int id;
    private String ten;
    private String hinhAnh;
    private String loaiMonAn;
    private int gia;
    private int giaKhuyenMai;
    private String tinhTrangMonAn;

    public MonAnModel(int id, String ten, String hinhAnh, String loaiMonAn, int gia, int giaKhuyenMai, String tinhTrangMonAn) {
        this.id = id;
        this.ten = ten;
        this.hinhAnh = hinhAnh;
        this.loaiMonAn = loaiMonAn;
        this.gia = gia;
        this.giaKhuyenMai = giaKhuyenMai;
        this.tinhTrangMonAn = tinhTrangMonAn;
    }    

    public MonAnModel() {
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

    public String getLoaiMonAn() {
        return loaiMonAn;
    }

    public void setLoaiMonAn(String loaiMonAn) {
        this.loaiMonAn = loaiMonAn;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public long getGiaKhuyenMai() {
        return giaKhuyenMai;
    }

    public void setGiaKhuyenMai(int giaKhuyenMai) {
        this.giaKhuyenMai = giaKhuyenMai;
    }

    public String getTinhTrangMonAn() {
        return tinhTrangMonAn;
    }

    public void setTinhTrangMonAn(String tinhTrangMonAn) {
        this.tinhTrangMonAn = tinhTrangMonAn;
    }
}
