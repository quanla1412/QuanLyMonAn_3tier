package gui.models.MonAn;

/**
 *
 * @author LeAnhQuan
 */
public class TinhTrangMonAnModel {
    private int id;
    private String ten;

    public TinhTrangMonAnModel() {
    }

    public TinhTrangMonAnModel(int id, String ten) {
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
        final TinhTrangMonAnModel other = (TinhTrangMonAnModel) obj;
        return this.id == other.id;
    }
}
