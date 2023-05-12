package gui.models.TaiKhoan;

import java.util.List;
/**
 *
 * @author LeAnhQuan
 */
public class QuyenTaiKhoanModel {
    private String username;
    private List<Integer> listChucNang;

    public QuyenTaiKhoanModel() {
    }

    public QuyenTaiKhoanModel(String username, List<Integer> listChucNang) {
        this.username = username;
        this.listChucNang = listChucNang;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getListChucNang() {
        return listChucNang;
    }

    public void setListChucNang(List<Integer> listChucNang) {
        this.listChucNang = listChucNang;
    }
}
