package dal.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
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
@Table( name = "TinhTrangBan")
public class TinhTrangBan implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    @Column (name="TTB_ID")
    private int id;
    @Column (name="TTB_Ten")
    private String ten;
    @OneToMany(mappedBy = "tinhTrangBan")
    private List<Ban> listBan;

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

    public List<Ban> getListBan() {
        return listBan;
    }

    public void setListBan(List<Ban> listBan) {
        this.listBan = listBan;
    }
}
