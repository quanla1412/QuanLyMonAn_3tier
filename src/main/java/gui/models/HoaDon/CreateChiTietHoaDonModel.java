package gui.models.HoaDon;

/**
 *
 * @author LeAnhQuan
 */
public class CreateChiTietHoaDonModel{
    private int idMonAn;
    private int soLuong;
    private int donGia;

    public CreateChiTietHoaDonModel() {
    }

    public CreateChiTietHoaDonModel(int idMonAn, int soLuong, int donGia) {
        this.idMonAn = idMonAn;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
}
