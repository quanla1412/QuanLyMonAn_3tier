package dal.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author LeAnhQuan
 */
@Entity
@Table(name="LoaiMonAn")
public class LoaiMonAn implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LMA_ID")
    private int id;
    @Column(name = "LMA_Ten")
    private String ten;
    @OneToMany(mappedBy = "loaiMonAn")
    private List<MonAn> listMonAn;

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

    public List<MonAn> getListMonAn() {
        return listMonAn;
    }

    public void setListMonAn(List<MonAn> listMonAn) {
        this.listMonAn = listMonAn;
    }
}
