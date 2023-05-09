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
@Table(name = "LoaiBan")
public class LoaiBan implements Serializable{    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "LB_ID")
    private int id;
    @Column (name = "LB_Ten")
    private String ten;
    @Column (name = "LB_SoLuongCho")
    private int soLuongCho;
    @OneToMany(mappedBy = "loaiBan")
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

    public int getSoLuongCho() {
        return soLuongCho;
    }

    public void setSoLuongCho(int soLuongCho) {
        this.soLuongCho = soLuongCho;
    }

    public List<Ban> getListBan() {
        return listBan;
    }

    public void setSetBan(List<Ban> listBan) {
        this.listBan = listBan;
    }
}
