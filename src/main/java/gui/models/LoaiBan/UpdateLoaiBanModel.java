package gui.models;

/**
 *
 * @author LeAnhQuan
 */
public class UpdateLoaiBanModel {
    private int id;
    private String ten;
    private int soLuongCho;

    public UpdateLoaiBanModel() {
    }

    public UpdateLoaiBanModel(int id, String ten, int soLuongCho) {
        this.id = id;
        this.ten = ten;
        this.soLuongCho = soLuongCho;
    }

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
}
