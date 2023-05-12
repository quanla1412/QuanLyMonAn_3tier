package dal.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author LeAnhQuan
 */
@Entity
@Table(name = "QuyenTaiKhoan")
public class QuyenTaiKhoan {
    @EmbeddedId
    private QuyenTaiKhoanKey quyenTaiKhoanKey;
    
    @OneToOne
    @MapsId("maNhanVien")
    @JoinColumn(name = "NV_Ma")
    private NhanVien nhanVien;
    
    @OneToOne
    @MapsId("idChucNang")
    @JoinColumn(name = "CN_ID")
    private ChucNang chucNang;

    public QuyenTaiKhoanKey getQuyenTaiKhoanKey() {
        return quyenTaiKhoanKey;
    }

    public void setQuyenTaiKhoanKey(QuyenTaiKhoanKey quyenTaiKhoanKey) {
        this.quyenTaiKhoanKey = quyenTaiKhoanKey;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public ChucNang getChucNang() {
        return chucNang;
    }

    public void setChucNang(ChucNang chucNang) {
        this.chucNang = chucNang;
    }
    
    public void initQuyenTaiKhoanKey(){
        quyenTaiKhoanKey = new QuyenTaiKhoanKey(nhanVien.getMa(), chucNang.getId());
    }
}

@Embeddable
class QuyenTaiKhoanKey implements Serializable{
    @Column(name = "NV_Ma")
    private String maNhanVien;
    @Column(name = "CN_ID")
    private int idChucNang;

    public QuyenTaiKhoanKey() {
    }

    public QuyenTaiKhoanKey(String maNhanVien, int idChucNang) {
        this.maNhanVien = maNhanVien;
        this.idChucNang = idChucNang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getIdChucNang() {
        return idChucNang;
    }

    public void setIdChucNang(int idChucNang) {
        this.idChucNang = idChucNang;
    }
}
