package gui.models.Ban;

import gui.models.LoaiBanModel;

/**
 *
 * @author LeAnhQuan
 */
public class BanFullModel {
    private int id;
    private LoaiBanModel loaiBan;
    private TinhTrangBanModel tinhTrangBan;

    public BanFullModel() {
    }

    public BanFullModel(int id, LoaiBanModel loaiBan, TinhTrangBanModel tinhTrangBan) {
        this.id = id;
        this.loaiBan = loaiBan;
        this.tinhTrangBan = tinhTrangBan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LoaiBanModel getLoaiBan() {
        return loaiBan;
    }

    public void setLoaiBan(LoaiBanModel loaiBan) {
        this.loaiBan = loaiBan;
    }

    public TinhTrangBanModel getTinhTrangBan() {
        return tinhTrangBan;
    }

    public void setTinhTrangBan(TinhTrangBanModel tinhTrangBan) {
        this.tinhTrangBan = tinhTrangBan;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BanFullModel other = (BanFullModel) obj;
        return this.id == other.id;
    }
    
    
}
