package gui.controllers;

import bll.services.ILoaiMonAnService;
import bll.services.IMonAnService;
import bll.services.ITinhTrangMonAnService;
import bll.services.impl.LoaiMonAnServiceImpl;
import bll.services.impl.MonAnServiceImpl;
import bll.services.impl.TinhTrangMonAnServiceImpl;
import com.mycompany.quanlynhahang.Price;
import gui.models.LoaiMonAn.LoaiMonAnModel;
import gui.models.MonAn.CreateMonAnModel;
import gui.models.MonAn.MonAnFullModel;
import gui.models.MonAn.MonAnModel;
import gui.models.MonAn.SearchMonAnModel;
import gui.models.MonAn.TinhTrangMonAnModel;
import gui.models.MonAn.UpdateMonAnModel;
import gui.views.QuanLyMonAn_GUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author LeAnhQuan
 */
public class QuanLyMonAnController {
    private QuanLyMonAn_GUI view;
    private QuanLyLoaiMonAnController quanLyLoaiMonAnController;
    
    private final IMonAnService monAnService;
    private final ILoaiMonAnService loaiMonAnService;
    private final ITinhTrangMonAnService tinhTrangMonAnService;
    
    public ArrayList<MonAnModel> listMonAnModel;
    public ArrayList<LoaiMonAnModel> listLoaiMonAnModel;
    public ArrayList<TinhTrangMonAnModel> listTinhTrangMonAnModel;
    
    private boolean dangThemMonAn = true;
    private String linkHinhAnhForm = null;
    private MonAnFullModel monAnSelected = null;

    public QuanLyMonAnController() {
        monAnService = new MonAnServiceImpl();
        loaiMonAnService = new LoaiMonAnServiceImpl();
        tinhTrangMonAnService = new TinhTrangMonAnServiceImpl();
        
        init();
    }
    
    public JComponent getView(){
        return view;
    }
    
    private void init(){
        view = new QuanLyMonAn_GUI();
        view.setVisible(true);
        
        loadData();
        view.loadTableMonAn(listMonAnModel);        
        view.loadComboBoxLoaiMonAn(listLoaiMonAnModel);
        view.loadComboBoxTinhTrangMonAn(listTinhTrangMonAnModel);
        
        view.sldMinPrice.addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {                
                view.lblMinPrice.setText(Price.formatPrice(view.sldMinPrice.getValue()));
            }
            
        });        
        view.sldMaxPrice.addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {                
                view.lblMaxPrice.setText(Price.formatPrice(view.sldMaxPrice.getValue()));
            }
            
        });
        view.btnResetTable.addActionListener(e -> resetTable());
        view.btnTimKiem.addActionListener(e -> searchMonAn());
        
        view.btnThem.addActionListener(e -> changeModeMonAn(true));
        view.btnSua.addActionListener(e -> changeModeMonAn(false));
        view.btnChuyenTinhTrang.addActionListener(e -> chuyenTinhTrangMonAn());
        view.btnXoa.addActionListener(e -> deleteMonAn());
        view.btnHinhAnh.addActionListener(e -> selectHinhAnh());
        view.btnLuu.addActionListener(e -> saveMonAn());
        view.btnResetForm.addActionListener(e -> resetForm());
        
        view.tblMonAn.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = view.tblMonAn.getSelectedRow();
                if(row < 0)
                    return;
                int idMonAn = (int) view.tblMonAn.getValueAt(row, 0);
                monAnSelected = monAnService.getFullById(idMonAn);
                resetForm();
                
                view.btnLuu.setEnabled(true);
            }
        });
        
        view.btnQuanLyLoaiMonAn.addActionListener(e -> showQuanLyLoaiMonAn());
    }
    
    private void loadData(){
        listMonAnModel = (ArrayList<MonAnModel>) monAnService.getAll(false);
        listLoaiMonAnModel = (ArrayList<LoaiMonAnModel>) loaiMonAnService.getAll();
        listTinhTrangMonAnModel = (ArrayList<TinhTrangMonAnModel>) tinhTrangMonAnService.getAll();
    }
    
    private void searchMonAn(){        
        SearchMonAnModel searchMonAnModel = new SearchMonAnModel();

        String idOrName = view.txtSearchIdName.getText().trim();
        if(!idOrName.isBlank()){
            searchMonAnModel.setIdOrName(idOrName);
        }

        int idLoaiMonAn = view.cmbLoaiMonAnSearch.getSelectedIndex();
        if(idLoaiMonAn > 0){
            searchMonAnModel.setIdLoaiMonAn(listLoaiMonAnModel.get(idLoaiMonAn - 1).getId());
        }

        int minPrice = view.sldMinPrice.getValue();
        int maxPrice = view.sldMaxPrice.getValue();
        if(minPrice > maxPrice){
            JOptionPane.showMessageDialog(view, "Giá tối thiểu phải nhỏ hơn giá tối đa","Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            searchMonAnModel.setMinPrice(minPrice);
            searchMonAnModel.setMaxPrice(maxPrice);
        }

        int idTTMA = view.cmbTinhTrangMonAnSearch.getSelectedIndex();
        if(idTTMA > 0){
            searchMonAnModel.setIdTTMA(listTinhTrangMonAnModel.get(idTTMA - 1).getId());
        }

        listMonAnModel = (ArrayList<MonAnModel>) monAnService.search(searchMonAnModel, false);
        if(listMonAnModel.isEmpty())
            JOptionPane.showMessageDialog(view, "Không tìm thấy dữ liệu","Error", JOptionPane.ERROR_MESSAGE);
        view.loadTableMonAn(listMonAnModel);
    }
    
    private void resetTable(){
        loadData();
        view.loadTableMonAn(listMonAnModel);  
        view.txtSearchIdName.setText("");
        view.cmbLoaiMonAnSearch.setSelectedIndex(0);
        
        view.sldMinPrice.setValue(view.sldMinPrice.getMinimum());
        view.lblMinPrice.setText(Price.formatPrice(view.sldMinPrice.getValue()));
        view.sldMaxPrice.setValue(view.sldMaxPrice.getMaximum());
        view.lblMaxPrice.setText(Price.formatPrice(view.sldMaxPrice.getValue()));
        
        view.cmbTinhTrangMonAnSearch.setSelectedIndex(0);
    }
    
    private void resetForm(){
        if(dangThemMonAn || monAnSelected == null){
            view.txtIdMonAn.setText("");
            view.txtTenMonAn.setText("");
            view.cmbLoaiMonAnForm.setSelectedIndex(-1);
            linkHinhAnhForm = null;
            view.lblTenHinhAnh.setText("Chưa chọn file");
            view.txtGia.setText("");
            view.txtGiaKhuyenMai.setText("");
            view.cmbTinhTrangMonAnForm.setSelectedIndex(-1);
            view.txaNoiDung.setText("");
        } else {
            monAnSelected = monAnService.getFullById(monAnSelected.getId());
            
            view.txtIdMonAn.setText(Integer.toString(monAnSelected.getId()));
            view.txtTenMonAn.setText(monAnSelected.getTen());
            view.cmbLoaiMonAnForm.setSelectedIndex(listLoaiMonAnModel.indexOf(monAnSelected.getLoaiMonAnModel()));
            linkHinhAnhForm = monAnSelected.getHinhAnh();
            if(monAnSelected.getHinhAnh() == null)
                view.lblTenHinhAnh.setText("Chưa chọn file");
            else
                view.lblTenHinhAnh.setText(monAnSelected.getHinhAnh());
            view.txtGia.setText(Integer.toString(monAnSelected.getGia()));
            if(monAnSelected.getGiaKhuyenMai() >= 0)
                view.txtGiaKhuyenMai.setText(Integer.toString(monAnSelected.getGiaKhuyenMai()));
            else
                view.txtGiaKhuyenMai.setText("");
            view.cmbTinhTrangMonAnForm.setSelectedIndex(listTinhTrangMonAnModel.indexOf(monAnSelected.getTinhTrangMonAnModel()));
            view.txaNoiDung.setText(monAnSelected.getNoiDung());
        }
    }
    
    private void changeModeMonAn(boolean dangThemMonAn){        
        this.dangThemMonAn = dangThemMonAn;
        
        view.btnThem.setEnabled(!dangThemMonAn);
        view.btnSua.setEnabled(dangThemMonAn);
        
        String titlePanel = dangThemMonAn ? "Thêm món ăn mới" : "Sửa món ăn";
        view.pnlThemSuaMonAn.setBorder(new TitledBorder(titlePanel));
        view.btnLuu.setEnabled(dangThemMonAn);
        
        resetForm();
    }
    
    private void saveMonAn(){
        String errorList = validateSave();
        if(errorList.length() > 0){
            JOptionPane.showMessageDialog(view, errorList,"Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int indexLoaiMonAn = view.cmbLoaiMonAnForm.getSelectedIndex();
        int indexTinhTrang = view.cmbTinhTrangMonAnForm.getSelectedIndex();
        
        int idLoaiMonAn = listLoaiMonAnModel.get(indexLoaiMonAn).getId();
        String tenMonAn = view.txtTenMonAn.getText().trim();
        int gia = Integer.parseInt(view.txtGia.getText());
        int giaKhuyenMai = view.txtGiaKhuyenMai.getText().isBlank() ? 
                -1 : 
                Integer.parseInt(view.txtGiaKhuyenMai.getText());
        int idTinhTrangMonAn = listTinhTrangMonAnModel.get(indexTinhTrang).getId();
        String noidung = view.txaNoiDung.getText().trim();
        if (dangThemMonAn) {
            CreateMonAnModel createMonAnModel = new CreateMonAnModel();
            
            createMonAnModel.setIdLoaiMonAn(idLoaiMonAn);
            createMonAnModel.setTen(tenMonAn);
            createMonAnModel.setHinhAnh(linkHinhAnhForm);
            createMonAnModel.setGia(gia);
            createMonAnModel.setGiaKhuyenMai(giaKhuyenMai);
            createMonAnModel.setIdTtinhTrangMonAn(idTinhTrangMonAn);
            if(!noidung.isBlank())
                createMonAnModel.setNoiDung(noidung);

            boolean result = monAnService.create(createMonAnModel);
            if(result){
                JOptionPane.showMessageDialog(view, "Thêm món ăn mới thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                resetTable();
            }
            else
                JOptionPane.showMessageDialog(view, "Thêm món ăn mới thất bại","Error", JOptionPane.ERROR_MESSAGE);
        } else {
            UpdateMonAnModel updateMonAnModel = new UpdateMonAnModel();
            
            updateMonAnModel.setId(monAnSelected.getId());
            updateMonAnModel.setIdLoaiMonAn(idLoaiMonAn);
            updateMonAnModel.setTen(tenMonAn);
            updateMonAnModel.setHinhAnh(linkHinhAnhForm);
            updateMonAnModel.setGia(gia);
            updateMonAnModel.setGiaKhuyenMai(giaKhuyenMai);
            updateMonAnModel.setIdTtinhTrangMonAn(idTinhTrangMonAn);
            if(!noidung.isBlank())
                updateMonAnModel.setNoiDung(noidung);

            boolean result = monAnService.update(updateMonAnModel);
            if(result){
                JOptionPane.showMessageDialog(view, "Sửa món ăn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                resetTable();
                resetForm();
            }
            else
            JOptionPane.showMessageDialog(view, "Sửa món ăn thất bại","Error", JOptionPane.ERROR_MESSAGE);
        }
    }  
    
    
    
    private String validateSave(){
        ArrayList<String> errorList = new ArrayList<>();
        int indexLoaiMonAn = view.cmbLoaiMonAnForm.getSelectedIndex();
        if(indexLoaiMonAn < 0)
            errorList.add("Chưa chọn loại món ăn");

        String tenMonAn = view.txtTenMonAn.getText().trim();
        if(tenMonAn.isBlank())
            errorList.add("Chưa nhập tên món ăn");

        String giaString = view.txtGia.getText();
        int gia = 0;
        if(giaString.isBlank()){
            errorList.add("Chưa nhập giá");
        } else {
            if(!NumberUtils.isCreatable(giaString))
                errorList.add("Nhập giá không đúng định dạng");
            else{                    
                gia = Integer.parseInt(giaString);

                if (gia < 1000 || gia % 100 != 0)
                    errorList.add("Nhập giá phải từ 1000đ trở lên và chia hết cho 100");
            }                    
        }

        String giaKhuyenMaiString = view.txtGiaKhuyenMai.getText();
        if(!giaKhuyenMaiString.isBlank()){
            if(!NumberUtils.isCreatable(giaString))
                errorList.add("Nhập giá khuyến mãi không đúng định dạng");
            else{                    
                int giaKhuyenMai = Integer.parseInt(giaKhuyenMaiString);

                if (giaKhuyenMai < 0 || giaKhuyenMai  % 100 != 0)
                    errorList.add("Nhập giá khuyến mãi phải từ 0đ trở lên và chia hết cho 100");
                if (giaKhuyenMai >= gia)
                    errorList.add("Giá khuyến mãi phải nhỏ hơn giá gốc");
            }  
        }

        int idTinhTrang = view.cmbTinhTrangMonAnForm.getSelectedIndex();
        if(idTinhTrang < 0)
            errorList.add("Chưa chọn tình trạng món ăn");

        return String.join("\n", errorList);
    }
    
    private void selectHinhAnh(){        
        JFileChooser fc = new JFileChooser("D:\\");
            FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image", "jpg", "png");
            fc.setFileFilter(imageFilter);
            fc.setMultiSelectionEnabled(false);

            int returnVal = fc.showOpenDialog(view);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                view.lblTenHinhAnh.setText(file.getName());
                linkHinhAnhForm = file.getAbsolutePath();
            } else {
                view.lblTenHinhAnh.setText("Lỗi khi chọn file");
            }
    }
    
    private void chuyenTinhTrangMonAn(){        
        if(monAnSelected == null){
            JOptionPane.showMessageDialog(view, "Chưa có món ăn nào được chọn","Error", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean result = monAnService.chuyenTinhTrangMonAn(monAnSelected);

            if(result){
                JOptionPane.showMessageDialog(view, "Chuyển tình trạng món ăn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                resetTable();
                resetForm();
            } else 
                JOptionPane.showMessageDialog(view, "Chuyển tình trạng món ăn thất bại","Error", JOptionPane.ERROR_MESSAGE);
            
        } 
    }
    
    private void deleteMonAn(){        
        if(monAnSelected == null){
            JOptionPane.showMessageDialog(view, "Chưa có món ăn nào được chọn","Error", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean result = monAnService.delete(monAnSelected.getId());

            if(result){
                JOptionPane.showMessageDialog(view, "Xóa món ăn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                resetTable();
                monAnSelected = null;
                resetForm();
            } else 
                JOptionPane.showMessageDialog(view, "Xóa món ăn thất bại","Error", JOptionPane.ERROR_MESSAGE);
            
        } 
    }
    
    private void showQuanLyLoaiMonAn(){        
        if(quanLyLoaiMonAnController == null){
            quanLyLoaiMonAnController = new QuanLyLoaiMonAnController();
            quanLyLoaiMonAnController.getBtnThem().addActionListener(e -> {
                quanLyLoaiMonAnController.createLoaiMonAn();
                listLoaiMonAnModel = (ArrayList<LoaiMonAnModel>) loaiMonAnService.getAll();
                view.loadComboBoxLoaiMonAn(listLoaiMonAnModel);
                
            });            
            quanLyLoaiMonAnController.getBtnXoa().addActionListener(e -> {
                quanLyLoaiMonAnController.deleteLoaiMonAn();
                listLoaiMonAnModel = (ArrayList<LoaiMonAnModel>) loaiMonAnService.getAll();
                view.loadComboBoxLoaiMonAn(listLoaiMonAnModel);
                
            });
        } else {
            quanLyLoaiMonAnController.show();
        }
    }
}

