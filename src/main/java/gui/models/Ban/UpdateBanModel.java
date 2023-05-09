package gui.models.Ban;

/**
 *
 * @author LeAnhQuan
 */
public class UpdateBanModel {
    private int idBan;
    private int idTinhTrangBan;
    private int idLoaiBan;

    public UpdateBanModel() {
    }

    public UpdateBanModel(int idBan, int idLoaiBan, int idTinhTrangBan) {
        this.idBan = idBan;
        this.idLoaiBan = idLoaiBan;
        this.idTinhTrangBan = idTinhTrangBan;
    }

    public int getIdBan() {
        return idBan;
    }

    public void setIdBan(int idBan) {
        this.idBan = idBan;
    }
    
    public int getIdTinhTrangBan() {
        return idTinhTrangBan;
    }

    public void setIdTinhTrangBan(int idTinhTrangBan) {
        this.idTinhTrangBan = idTinhTrangBan;
    }

    public int getIdLoaiBan() {
        return idLoaiBan;
    }

    public void setIdLoaiBan(int idLoaiBan) {
        this.idLoaiBan = idLoaiBan;
    }
}
