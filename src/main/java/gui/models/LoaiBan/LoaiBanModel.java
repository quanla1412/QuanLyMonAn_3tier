package gui.models;

/**
 *
 * @author LeAnhQuan
 */
public class LoaiBanModel {
    private int id;
    private String ten;
    private int soLuongCho;

    public LoaiBanModel() {
    }

    public LoaiBanModel(int id, String ten, int soLuongCho) {
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

    @Override
    public int hashCode() {
        int hash = 3;
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
        final LoaiBanModel other = (LoaiBanModel) obj;
        return this.id == other.id;
    }
    
    
}
