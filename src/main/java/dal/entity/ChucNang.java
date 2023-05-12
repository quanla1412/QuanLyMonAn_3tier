package dal.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 *
 * @author LeAnhQuan
 */
@Entity
@Table(name = "ChucNang")
public class ChucNang implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CN_ID")
    private int id;
    @Column(name = "CN_Ten")
    private String ten;
    @OneToMany(mappedBy = "chucNang")
    private List<QuyenTaiKhoan> listQuyenTaiKhoan;

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

    public List<QuyenTaiKhoan> getListQuyenTaiKhoan() {
        return listQuyenTaiKhoan;
    }

    public void setListQuyenTaiKhoan(List<QuyenTaiKhoan> listQuyenTaiKhoan) {
        this.listQuyenTaiKhoan = listQuyenTaiKhoan;
    }
}