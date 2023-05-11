package dal.entity;

import java.io.Serializable;
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
import java.util.List;

/**
 *
 * @author LeAnhQuan
 */
@Entity
@Table(name = "MonAn")
public class MonAn implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MA_ID")
    private int id;
    @Column(name = "MA_Ten")
    private String ten;
    @Column(name = "MA_HinhAnh", nullable = true)
    private String hinhAnh;
    @Column(name = "MA_Gia")
    private int gia;
    @Column(name = "Ma_GiaKhuyenMai", nullable = true)
    private Integer giaKhuyenMai;
    @Column(name = "MA_NoiDung", nullable = true)
    private String noiDung;
    @ManyToOne
    @JoinColumn(name="LMA_ID")
    private LoaiMonAn loaiMonAn;
    @ManyToOne
    @JoinColumn(name = "TTMA_ID")
    private TinhTrangMonAn tinhTrangMonAn;
    @OneToMany(mappedBy = "maHoaDon")
    List<ChiTietHoaDon> listChiTietHoaDon;
    @OneToMany(mappedBy = "monAn")
    private List<DonGoi> listDonGoi;

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

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getGiaKhuyenMai() {
        if(giaKhuyenMai == null)
            return 0;
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

    public LoaiMonAn getLoaiMonAn() {
        return loaiMonAn;
    }

    public void setLoaiMonAn(LoaiMonAn loaiMonAn) {
        this.loaiMonAn = loaiMonAn;
    }

    public TinhTrangMonAn getTinhTrangMonAn() {
        return tinhTrangMonAn;
    }

    public void setTinhTrangMonAn(TinhTrangMonAn tinhTrangMonAn) {
        this.tinhTrangMonAn = tinhTrangMonAn;
    }

    public List<DonGoi> getListDonGoi() {
        return listDonGoi;
    }

    public void setListDonGoi(List<DonGoi> listDonGoi) {
        this.listDonGoi = listDonGoi;
    }
}
