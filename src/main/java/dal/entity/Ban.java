package dal.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author LeAnhQuan
 */
@Entity
@Table( name = "Ban" )
public class Ban implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "B_ID")    
    private int id;
    @ManyToOne
    @JoinColumn(name="LB_ID")
    private LoaiBan loaiBan; 
    @ManyToOne
    @JoinColumn(name="TTB_ID")
    private TinhTrangBan tinhTrangBan; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LoaiBan getLoaiBan() {
        return loaiBan;
    }

    public void setLoaiBan(LoaiBan loaiBan) {
        this.loaiBan = loaiBan;
    }

    public TinhTrangBan getTinhTrangBan() {
        return tinhTrangBan;
    }

    public void setTinhTrangBan(TinhTrangBan tinhTrangBan) {
        this.tinhTrangBan = tinhTrangBan;
    }
    
    
}
