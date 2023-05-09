package gui.models;

/**
 *
 * @author LeAnhQuan
 */
public class CreateLoaiBanModel {
    private String ten;
    private int soLuongCho;

    public CreateLoaiBanModel() {
    }

    public CreateLoaiBanModel(String ten, int soLuongCho) {
        this.ten = ten;
        this.soLuongCho = soLuongCho;
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
