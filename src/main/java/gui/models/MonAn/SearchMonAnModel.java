package gui.models.MonAn;

/**
 *
 * @author LeAnhQuan
 */
public class SearchMonAnModel {
    private String idOrName;
    private int idLoaiMonAn;
    private int minPrice;
    private int maxPrice;
    private int idTTMA;

    public SearchMonAnModel(String idOrName, int idLoaiMonAn, int minPrice, int maxPrice, int idTTMA) {
        this.idOrName = idOrName;
        this.idLoaiMonAn = idLoaiMonAn;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.idTTMA = idTTMA;
    }

    public SearchMonAnModel() {
    }

    public String getIdOrName() {
        return idOrName;
    }

    public void setIdOrName(String idOrName) {
        this.idOrName = idOrName;
    }

    public int getIdLoaiMonAn() {
        return idLoaiMonAn;
    }

    public void setIdLoaiMonAn(int idLoaiMonAn) {
        this.idLoaiMonAn = idLoaiMonAn;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getIdTTMA() {
        return idTTMA;
    }

    public void setIdTTMA(int idTTMA) {
        this.idTTMA = idTTMA;
    }
    
    
    
}
