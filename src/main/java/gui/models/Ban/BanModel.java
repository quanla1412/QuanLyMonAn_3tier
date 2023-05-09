package gui.models;

/**
 *
 * @author LeAnhQuan
 */
public class BanModel {
    private int id;
    private String tinhTrangBan;
    private String loaiBan;

    public BanModel() {
    }

    public BanModel(int id, String tinhTrangBan, String loaiBan) {
        this.id = id;
        this.tinhTrangBan = tinhTrangBan;
        this.loaiBan = loaiBan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTinhTrangBan() {
        return tinhTrangBan;
    }

    public void setTinhTrangBan(String tinhTrangBan) {
        this.tinhTrangBan = tinhTrangBan;
    }

    public String getLoaiBan() {
        return loaiBan;
    }

    public void setLoaiBan(String loaiBan) {
        this.loaiBan = loaiBan;
    }
}
