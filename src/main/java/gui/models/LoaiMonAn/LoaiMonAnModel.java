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
    public String toString() {
        return "LoaiMonAn_DTO{" + "id=" + id + ", ten=" + ten + '}';
    }
}
