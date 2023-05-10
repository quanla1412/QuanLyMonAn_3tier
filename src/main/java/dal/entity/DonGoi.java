package dal.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
    
    @ManyToOne
    @Column(name = "B_ID")
    private Ban ban;
}

@Embeddable
class DonGoiKey implements Serializable {    
    @Column(name = "B_ID")
    private int idBan;
    @Column(name = "MA_ID")
    private int idMonAn;
}
