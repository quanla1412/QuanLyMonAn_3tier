package gui.controllers;

import bll.services.IBanService;
import bll.services.ILoaiBanService;
import bll.services.ITinhTrangBanService;
import bll.services.impl.BanServiceImpl;
import bll.services.impl.LoaiBanServiceImpl;
import bll.services.impl.TinhTrangBanServiceImpl;
import gui.models.Ban.BanFullModel;
import gui.models.Ban.CreateBanModel;
import gui.models.Ban.TinhTrangBanModel;
import gui.models.Ban.UpdateBanModel;
import gui.models.BanModel;
import gui.models.CreateLoaiBanModel;
import gui.models.LoaiBanModel;
import gui.models.UpdateLoaiBanModel;
import gui.views.QuanLyLoaiBanVaBan_GUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author LeAnhQuan
 */
public class QuanLyLoaiBanVaBanController {
    private final IBanService banService;
    private final ILoaiBanService loaiBanService;
    private final ITinhTrangBanService tinhTrangBanService;
    
    private QuanLyLoaiBanVaBan_GUI view;
    
    private ArrayList<LoaiBanModel> listLoaiBanModel;
    private LoaiBanModel loaiBanSelected = null;
    private ArrayList<BanModel> listBanModel;
    private BanFullModel banSelected = null;
    public ArrayList<TinhTrangBanModel> listTinhTrangBanModel;
            
    private boolean dangThemLoaiBan = true;
    private boolean dangThemBan = true;

    public QuanLyLoaiBanVaBanController() {
        loaiBanService = new LoaiBanServiceImpl();
        banService = new BanServiceImpl();
        tinhTrangBanService = new TinhTrangBanServiceImpl();
        
        init();
    }

    public QuanLyLoaiBanVaBan_GUI getView() {
        return view;
    }
    
    private void init(){
        view = new QuanLyLoaiBanVaBan_GUI();
        view.setVisible(true);
        
        loadData();
        view.loadTableLoaiBan(listLoaiBanModel);
        
        view.btnThemLoaiBan.addActionListener(e -> changeModeLoaiBan(true));
        view.btnSuaLoaiBan.addActionListener(e -> changeModeLoaiBan(false));
        view.btnLuuLoaiBan.addActionListener(e -> saveLoaiBan());
        view.btnXoaLoaiBan.addActionListener(e -> deleteLoaiBan());
        view.btnResetLoaiBan.addActionListener(e -> resetLoaiBan());
        view.tblLoaiBan.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int selectedRow = view.tblLoaiBan.getSelectedRow();
                int selectedLoaiBanId = (int) view.tblLoaiBan.getValueAt(selectedRow, 0);
                
                loaiBanSelected = loaiBanService.getById(selectedLoaiBanId);

                if(!dangThemLoaiBan)
                    loadDetailLoaiBan();  
            }
        });
        
        view.loadTableBan(listBanModel);
        view.loadComboBoxLoaiBan(listLoaiBanModel);
        view.loadComboBoxTinhTrangBan(listTinhTrangBanModel);
        view.btnThemBan.addActionListener(e -> changeModeBan(true));
        view.btnSuaBan.addActionListener(e -> changeModeBan(false));
        view.btnLuuBan.addActionListener(e -> saveBan());
        view.btnResetBan.addActionListener(e -> resetBan());
        view.btnXoaBan.addActionListener(e -> deleteBan());
        view.tblBan.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int selectedRow = view.tblBan.getSelectedRow();
                int selectedBanId = (int) view.tblBan.getValueAt(selectedRow, 0);
                
                banSelected = banService.getFullById(selectedBanId);

                if(!dangThemBan)
                    loadDetailBan();  
            }
        });
    }
    
    private void loadData(){
        listLoaiBanModel = (ArrayList<LoaiBanModel>) loaiBanService.getAll();
        listBanModel = (ArrayList<BanModel>) banService.getAll();       
        listTinhTrangBanModel = (ArrayList<TinhTrangBanModel>) tinhTrangBanService.getAll();
    }
    
    private void saveLoaiBan(){
        String error = validateSaveLoaiBan();
        if(error.length()> 0){
            JOptionPane.showMessageDialog(view, error,"Error", JOptionPane.ERROR_MESSAGE);
            return;
        }       
        
        String tenLoaiBan = view.txtTenLoaiBan.getText().trim();
        int soChoNgoi = NumberUtils.toInt(view.txtSoChoNgoi.getText());
        if(dangThemLoaiBan){
            CreateLoaiBanModel createLoaiBanModel = new CreateLoaiBanModel(tenLoaiBan, soChoNgoi);

            boolean result = loaiBanService.createLoaiBan(createLoaiBanModel);
            if(result){
                JOptionPane.showMessageDialog(view, "Thêm loại bàn mới thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(view, "Thêm loại bàn mới thất bại","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } 
        else {
            UpdateLoaiBanModel updateLoaiBanModel = new UpdateLoaiBanModel(loaiBanSelected.getId(), tenLoaiBan, soChoNgoi);

            boolean result = loaiBanService.updateLoaiBan(updateLoaiBanModel);
            if(result){
                JOptionPane.showMessageDialog(view, "Sửa loại bàn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loaiBanSelected = loaiBanService.getById(loaiBanSelected.getId());
            }
            else{
                JOptionPane.showMessageDialog(view, "Sửa loại bàn thất bại","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        resetLoaiBan();      
    }
    
    private String validateSaveLoaiBan(){
        ArrayList<String> errorList = new ArrayList<>();
        
        if(view.txtTenLoaiBan.getText().isBlank())
            errorList.add("Tên bàn không được để trống");
            
        String soChoNgoi = view.txtSoChoNgoi.getText();
        if (soChoNgoi.isBlank()) {
            errorList.add("Số lượng chỗ ngồi không được để trống");            
        } else if(!NumberUtils.isCreatable(soChoNgoi)){
            errorList.add("Số lượng chỗ ngồi phải nhập đúng định dạng");
        } else if(NumberUtils.toInt(soChoNgoi) <= 0)
            errorList.add("Số lượng chỗ ngồi không được bé hơn 0");
        
        String error = String.join("\n", errorList);
        
        return error;
    }
    
    private void saveBan(){
        String error = validateSaveBan();
        if(error.length()> 0){
            JOptionPane.showMessageDialog(view, error, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }       
        
        int idLoaiBan = listLoaiBanModel.get(view.cmbLoaiBan.getSelectedIndex()).getId();
        int idTinhTrangBan = listTinhTrangBanModel.get(view.cmbTinhTrangBan.getSelectedIndex()).getId();
        if(dangThemBan){
            CreateBanModel createBanModel = new CreateBanModel(idLoaiBan, idTinhTrangBan);

            boolean result = banService.createBan(createBanModel);
            if(result){
                JOptionPane.showMessageDialog(view, "Thêm bàn mới thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(view, "Thêm bàn mới thất bại","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } 
        else {
            UpdateBanModel updateBanModel = new UpdateBanModel(banSelected.getId(), idLoaiBan, idTinhTrangBan);

            boolean result = banService.updateBan(updateBanModel);
            if(result){
                JOptionPane.showMessageDialog(view, "Sửa bàn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                banSelected = banService.getFullById(banSelected.getId());
            }
            else{
                JOptionPane.showMessageDialog(view, "Sửa bàn thất bại","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        resetBan();   
        
    }
    
    private String validateSaveBan(){
        ArrayList<String> errorList = new ArrayList<>();
        
        if(view.cmbLoaiBan.getSelectedIndex() < 0)
            errorList.add("Không được để trống loại bàn");
        if(view.cmbTinhTrangBan.getSelectedIndex() < 0)
            errorList.add("Không được để trống tình trạng bàn");
        
        String error = String.join("\n", errorList);        
        return error;
    }
    
    private void resetLoaiBan(){     
        loadData();
        view.loadTableLoaiBan(listLoaiBanModel);   
        view.loadComboBoxLoaiBan(listLoaiBanModel);
        loadDetailLoaiBan();
        
    }
    
    private void resetBan(){
        loadData();
        view.loadTableBan(listBanModel);
        loadDetailBan();        
    }
    
    private void loadDetailLoaiBan(){
        if(loaiBanSelected == null || dangThemLoaiBan){
            view.txtIDLoaiBan.setText("");
            view.txtTenLoaiBan.setText("");
            view.txtSoChoNgoi.setText("");                
        } else {
            view.txtIDLoaiBan.setText(Integer.toString(loaiBanSelected.getId()));
            view.txtTenLoaiBan.setText(loaiBanSelected.getTen());
            view.txtSoChoNgoi.setText(Integer.toString(loaiBanSelected.getSoLuongCho()));             
        }                  
    }
    
    private void loadDetailBan(){
        if(banSelected == null || dangThemBan){
            view.txtIdBan.setText("");
            view.cmbLoaiBan.setSelectedIndex(-1);
            view.cmbTinhTrangBan.setSelectedIndex(-1);
        } else {            
            view.txtIdBan.setText(Integer.toString(banSelected.getId()));
            
            LoaiBanModel loaiBanModel = banSelected.getLoaiBan();
            int indexLoaiBan = listLoaiBanModel.indexOf(loaiBanModel);
            view.cmbLoaiBan.setSelectedIndex(indexLoaiBan);
            
            TinhTrangBanModel tinhTrangBanModel = banSelected.getTinhTrangBan();
            int indexTinhTrangBan = listTinhTrangBanModel.indexOf(tinhTrangBanModel);
            view.cmbTinhTrangBan.setSelectedIndex(indexTinhTrangBan);
        }                     
    }
    
    private void changeModeLoaiBan(boolean dangThemLoaiBan){        
        this.dangThemLoaiBan = dangThemLoaiBan;
        
        view.btnThemLoaiBan.setEnabled(!dangThemLoaiBan);
        view.btnSuaLoaiBan.setEnabled(dangThemLoaiBan);
        
        String titlePanel = dangThemLoaiBan ? "Thêm loại bàn mới" : "Sửa loại bàn";
        view.pnlThemSuaLoaiBan.setBorder(BorderFactory.createTitledBorder(titlePanel));
        view.pnlThemSuaLoaiBan.repaint();
        resetLoaiBan();
    }
    
    private void changeModeBan(boolean dangThemBan){
        this.dangThemBan = dangThemBan;
        
        view.btnThemBan.setEnabled(!dangThemBan);
        view.btnSuaBan.setEnabled(dangThemBan);
        
        String titlePanel = dangThemBan ? "Thêm bàn mới" : "Sửa bàn";
        view.pnlThemSuaBan.setBorder(BorderFactory.createTitledBorder(titlePanel));
        view.pnlThemSuaBan.repaint();
        resetBan();
        view.btnLuuBan.setEnabled(true);
    }
    
    private void deleteLoaiBan(){
        if(loaiBanSelected == null)
            JOptionPane.showMessageDialog(view, "Bạn chưa chọn loại bàn muốn xóa","Error", JOptionPane.ERROR_MESSAGE);
        
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa loại bàn \"" + loaiBanSelected.getTen() + "\" không ?", "Xóa dữ liệu loại bàn!", JOptionPane.OK_CANCEL_OPTION);

        if(confirm == JOptionPane.CANCEL_OPTION)
            return;
        
        boolean result = loaiBanService.deleteLoaiBan(loaiBanSelected.getId());
        if(result){
                JOptionPane.showMessageDialog(view, "Xóa loại bàn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loaiBanSelected = null;
        } else
            JOptionPane.showMessageDialog(view, "Xóa thất bại","Error", JOptionPane.ERROR_MESSAGE);
        resetLoaiBan();
    }
    
    private void deleteBan(){
        if(banSelected == null)
            JOptionPane.showMessageDialog(view, "Bạn chưa chọn bàn muốn xóa","Error", JOptionPane.ERROR_MESSAGE);
        
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa bàn \"" + banSelected.getId()+ "\" không ?", "Xóa dữ liệu bàn!", JOptionPane.OK_CANCEL_OPTION);

        if(confirm == JOptionPane.CANCEL_OPTION)
            return;
        
        boolean result = banService.delete(banSelected.getId());
        if(result){
                JOptionPane.showMessageDialog(view, "Xóa bàn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                banSelected = null;
        } else
            JOptionPane.showMessageDialog(view, "Xóa thất bại","Error", JOptionPane.ERROR_MESSAGE);
        resetBan();
    }
}
