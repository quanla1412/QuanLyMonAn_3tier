package gui.models.TaiKhoan;

import java.util.Map;

/**
 *
 * @author LeAnhQuan
 */
public class UpdateQuyenTaiKhoanModel {
    String username;
    Map<Integer, Boolean> listChucNang;

    public UpdateQuyenTaiKhoanModel() {
    }

    public UpdateQuyenTaiKhoanModel(String username, Map<Integer, Boolean> listChucNang) {
        this.username = username;
        this.listChucNang = listChucNang;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<Integer, Boolean> getListChucNang() {
        return listChucNang;
    }

    public void setListChucNang(Map<Integer, Boolean> listChucNang) {
        this.listChucNang = listChucNang;
    }
}
