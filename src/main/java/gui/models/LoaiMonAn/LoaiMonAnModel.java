package gui.models.LoaiMonAn;

/**
 *
 * @author LeAnhQuan
 */
public class LoaiMonAnModel {
    private int id;
    private String ten;

    public LoaiMonAnModel() {
    }

    public LoaiMonAnModel(int id, String ten) {
        this.id = id;
        this.ten = ten;
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

    @Override
    public int hashCode() {
        int hash = 5;
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
        final LoaiMonAnModel other = (LoaiMonAnModel) obj;
        return this.id == other.id;
    }
}
