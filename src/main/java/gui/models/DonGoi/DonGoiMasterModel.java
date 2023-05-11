package gui.models.DonGoi;

import java.util.List;
/**
 *
 * @author LeAnhQuan
 */
public class DonGoiMasterModel {
    private List<DonGoiModel> listDonGoiModel;
    private int total;

    public DonGoiMasterModel() {
    }

    public DonGoiMasterModel(List<DonGoiModel> listDonGoiModel, int total) {
        this.listDonGoiModel = listDonGoiModel;
        this.total = total;
    }

    public List<DonGoiModel> getListDonGoiModel() {
        return listDonGoiModel;
    }

    public void setListDonGoiModel(List<DonGoiModel> listDonGoiModel) {
        this.listDonGoiModel = listDonGoiModel;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
