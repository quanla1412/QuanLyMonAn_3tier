package gui.models.MonAn;

import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class LoaiMonAnFullModel {
    private int id;
    private String ten;
    private ArrayList<MonAnModel> listMonAn;

    public LoaiMonAnFullModel() {
    }
    

    public LoaiMonAnFullModel(int id, String ten, ArrayList<MonAnModel> listMonAn) {
        this.id = id;
        this.ten = ten;
        this.listMonAn = listMonAn;
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

    public ArrayList<MonAnModel> getListMonAn() {
        return listMonAn;
    }

    public void setListMonAn(ArrayList<MonAnModel> listMonAn) {
        this.listMonAn = listMonAn;
    }
    
    
}
