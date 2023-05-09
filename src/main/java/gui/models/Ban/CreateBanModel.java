package gui.models.Ban;

/**
 *
 * @author LeAnhQuan
 */
public class CreateBanModel {
    private int idTinhTrangBan;
    private int idLoaiBan;

    public CreateBanModel() {
    }

    public CreateBanModel(int idTinhTrangBan, int idLoaiBan) {
        this.idTinhTrangBan = idTinhTrangBan;
        this.idLoaiBan = idLoaiBan;
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
