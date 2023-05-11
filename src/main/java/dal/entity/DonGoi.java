package dal.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author LeAnhQuan
 */
@Entity
@Table(name = "DonGoi")
public class DonGoi {
    @EmbeddedId
    private DonGoiKey donGoiKey;
    
    @Column(name = "DG_SoLuong")
    private int soLuong;
    
    @Column(name = "DG_GhiChu")
    private String ghiChu;
    
    @ManyToOne
    @MapsId("idBan")
    @JoinColumn(name = "B_ID")
    private Ban ban;
    
    @ManyToOne
    @MapsId("idMonAn")
    @JoinColumn(name = "MA_ID")
    private MonAn monAn;

    public DonGoiKey getDonGoiKey() {
        return donGoiKey;
    }

    public void setDonGoiKey(DonGoiKey donGoiKey) {
        this.donGoiKey = donGoiKey;
    }

    public void setDonGoiKey(int idBan, int idMonAn) {
        this.donGoiKey = new DonGoiKey(idBan, idMonAn);
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Ban getBan() {
        return ban;
    }

    public void setBan(Ban ban) {
        this.ban = ban;
    }

    public MonAn getMonAn() {
        return monAn;
    }

    public void setMonAn(MonAn monAn) {
        this.monAn = monAn;
    }
    
    public void initDonGoiKey(){
        this.donGoiKey = new DonGoiKey(ban.getId(), monAn.getId());
    }
}

@Embeddable
class DonGoiKey implements Serializable {    
    @Column(name = "B_ID")
    private int idBan;
    @Column(name = "MA_ID")
    private int idMonAn;

    public DonGoiKey() {
    }

    public DonGoiKey(int idBan, int idMonAn) {
        this.idBan = idBan;
        this.idMonAn = idMonAn;
    }

    public int getIdBan() {
        return idBan;
    }

    public void setIdBan(int idBan) {
        this.idBan = idBan;
    }

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
    }
}
