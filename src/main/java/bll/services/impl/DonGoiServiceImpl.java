package bll.services.impl;

import bll.mappers.DonGoiMapper;
import bll.services.IDonGoiService;
import bll.services.IKhachHangService;
import bll.services.IMonAnService;
import bll.services.INhanVienService;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.TabStop;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TabAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.mycompany.quanlynhahang.OpenFile;
import com.mycompany.quanlynhahang.Price;
import dal.entity.Ban;
import dal.entity.DonGoi;
import dal.repository.BanRepository;
import dal.repository.DonGoiRepository;
import dal.repository.MonAnRepository;
import dal.repository.NhanVienRepository;
import gui.constraints.TinhTrangMonAnConstraints;
import gui.models.DonGoi.CreateDonGoiModel;
import gui.models.DonGoi.DonGoiMasterModel;
import gui.models.DonGoi.DonGoiModel;
import gui.models.DonGoi.UpdateDonGoiModel;
import gui.models.KhachHang.KhachHangFullModel;
import gui.models.NhanVien.NhanVienFullModel;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeAnhQuan
 */
public class DonGoiServiceImpl implements IDonGoiService {
    private BanRepository banRepository;
    private DonGoiRepository donGoiRepository;
    private INhanVienService nhanVienService;
    private IKhachHangService khachHangService;
    private MonAnRepository monAnRepository;

    public DonGoiServiceImpl() {
        banRepository = new BanRepository();
        donGoiRepository = new DonGoiRepository();
        nhanVienService = new NhanVienServiceImpl();
        khachHangService = new KhachHangServiceImpl();
        monAnRepository = new MonAnRepository();
    }
    

    @Override
    public List<DonGoiModel> getByBan(int idBan) {
        Ban ban = banRepository.getById(idBan);
        List<DonGoi> listDonGoi = ban.getListDonGoi();
        List<DonGoiModel> listDonGoiModel = DonGoiMapper.toListDonGoiModel(listDonGoi);
        for(DonGoiModel donGoiModel : listDonGoiModel) {
            if(donGoiModel.getMonAn().getGiaKhuyenMai() >= 0){
                donGoiModel.setGia(donGoiModel.getMonAn().getGiaKhuyenMai());
            }
            else {
                donGoiModel.setGia(donGoiModel.getMonAn().getGia());           
            }
            donGoiModel.setThanhTien(donGoiModel.getGia() * donGoiModel.getSoLuong());
        }
        
        return listDonGoiModel;
    }
    
    @Override
    public DonGoiMasterModel getMasterByBan(int idBan){
        Ban ban = banRepository.getById(idBan);
        List<DonGoi> listDonGoi = ban.getListDonGoi();
        List<DonGoiModel> listDonGoiModel = DonGoiMapper.toListDonGoiModel(listDonGoi);
        
        DonGoiMasterModel donGoiMaster = new DonGoiMasterModel();
        donGoiMaster.setListDonGoiModel(listDonGoiModel);
        
        int total = 0;
        for(DonGoiModel donGoiModel : listDonGoiModel) {
            if(donGoiModel.getMonAn().getGiaKhuyenMai() >= 0){
                donGoiModel.setGia(donGoiModel.getMonAn().getGiaKhuyenMai());
                total += donGoiModel.getMonAn().getGiaKhuyenMai() * donGoiModel.getSoLuong();
            }
            else {
                donGoiModel.setGia(donGoiModel.getMonAn().getGia());
                total += donGoiModel.getMonAn().getGia() * donGoiModel.getSoLuong();                
            }
            donGoiModel.setThanhTien(donGoiModel.getGia() * donGoiModel.getSoLuong());
        }
        donGoiMaster.setTotal(total);
        
        return donGoiMaster;        
    }

    @Override
    public boolean chuyenBan(int idBanCu, int idBanMoi) {
        Ban banCu = banRepository.getById(idBanCu);
        Ban banMoi = banRepository.getById(idBanMoi);
        
        if(!banMoi.getListDonGoi().isEmpty())
            return false;
        
        banCu.getListDonGoi().forEach(donGoi -> {
            donGoiRepository.delete(donGoi);
            donGoi.setBan(banMoi);
            donGoiRepository.create(donGoi);
        });
        
        return true;
    }

    @Override
    public DonGoiModel getByKey(int idBan, int idMonAn) {
        DonGoi donGoi = donGoiRepository.getByKey(idBan, idMonAn);
        DonGoiModel donGoiModel = DonGoiMapper.toDonGoiModel(donGoi);
        
        return donGoiModel;
    }

    @Override
    public boolean create(CreateDonGoiModel createDonGoiModel) {
        DonGoi donGoi = DonGoiMapper.toDonGoi(createDonGoiModel);
        if(!validateCreate(donGoi))
            return false;
        
        DonGoi createdDonGoi = donGoiRepository.create(donGoi);
        
        return true;
    }
    
    public boolean validateCreate(DonGoi data){
        DonGoi donGoi = donGoiRepository.getByKey(data.getBan().getId(), data.getMonAn().getId());
        
        return donGoi == null;
    }  
    
    @Override
    public boolean update(UpdateDonGoiModel updateDonGoiModel) {
        DonGoi donGoiOld = donGoiRepository.getByKey(updateDonGoiModel.getIdBan(), updateDonGoiModel.getIdMA());
        if(updateDonGoiModel.getSoLuong() > donGoiOld.getSoLuong() && donGoiOld.getMonAn().getTinhTrangMonAn().getId() == TinhTrangMonAnConstraints.HET){
            return false;
        }
        DonGoi donGoi = DonGoiMapper.toDonGoi(updateDonGoiModel);
        DonGoi updatedDonGoi = donGoiRepository.update(donGoi);
        
        
        monAnRepository.updateTinhTrang(updateDonGoiModel.getIdMA(), TinhTrangMonAnConstraints.CON_PHUC_VU);
        
        return true;
    }

    @Override
    public boolean delete(int idBan, int idMonAn) {
        DonGoi donGoi = donGoiRepository.getByKey(idBan, idMonAn);
        if(donGoi == null)
            return false;
        donGoiRepository.delete(donGoi);
        
        DonGoi check = donGoiRepository.getByKey(idBan, idMonAn);
        return check == null; 
    }

    @Override
    public boolean delete(int idBan) {
        ArrayList<DonGoi> listDonGoi = (ArrayList<DonGoi>) donGoiRepository.getByBan(idBan);
        if(listDonGoi.isEmpty())
            return false;
        listDonGoi.forEach(donGoi -> donGoiRepository.delete(donGoi));        
        
        ArrayList<DonGoi> listDonGoiCheck = (ArrayList<DonGoi>) donGoiRepository.getByBan(idBan);
        return listDonGoiCheck.isEmpty(); 
    }

    @Override
    public boolean inBillTam(int idBan, int idKhachHang, String maNhanVien, String filePath) {
        NhanVienFullModel nhanVienFullModel = nhanVienService.getByMa(maNhanVien);
        KhachHangFullModel khachHangFullModel = null;
        if(idKhachHang > 0)
            khachHangFullModel = khachHangService.getById(idKhachHang);
        DonGoiMasterModel donGoiMasterModel = getMasterByBan(idBan);
        
        // tạo một document
        String dest = filePath + "\\billTam.pdf";
        try {
            // Creating a PdfDocument object     
            
            PdfWriter writer = new PdfWriter(dest);       

            // Creating a PdfDocument object      
            PdfDocument pdf = new PdfDocument(writer); 
            
            //Set font
            String FONT = "D:\\QuanLyNhaHang\\Font\\Roboto-Light.ttf";
            PdfFont font = PdfFontFactory.createFont(FONT);                 

            // Creating a Document object       
            Document doc = new Document(pdf);        
            doc.setTextAlignment(TextAlignment.CENTER);
            doc.setFont(font);            
            
            //Create a title
            Paragraph title = new Paragraph("QUẢN LÝ NHÀ HÀNG");
            title.setFontSize(20);
            doc.add(title);
            
            Paragraph name = new Paragraph("In bill tạm");
            name.setFontSize(16);
            doc.add(name);
            
            // Customer and staff information
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formatDateTimeNow = now.format(formatter);
            
            String hoTenKH = khachHangFullModel != null ? khachHangFullModel.getTen(): "";
            String sdtKH = khachHangFullModel != null ? khachHangFullModel.getSdt(): "";
            
            String infoString = "Bàn " + idBan + "\n"
                    + "Mã nhân viên: " + maNhanVien + "\n"
                    + "Tên nhân viên: " +  nhanVienFullModel.getHoTen() + "\n"
                    + "Tên khách hàng: " + hoTenKH + "\n"
                    + "Số điện thoại khách hàng: " + sdtKH;
            Paragraph info = new Paragraph(infoString);
            info.setTextAlignment(TextAlignment.LEFT);
            info.add(new Tab());
            info.addTabStops(new TabStop(1000, TabAlignment.RIGHT));
            info.add("Ngày giờ: " + formatDateTimeNow);
            doc.add(info);

            // Creating a table       
            float [] pointColumnWidths = {150F, 150F, 150F, 150F, 150F};   
            Table table = new Table(pointColumnWidths); 

            // Adding Table to document      
            table.addCell("STT");      
            table.addCell("Tên món ăn");       
            table.addCell("Đơn giá");       
            table.addCell("Số lượng");       
            table.addCell("Thành tiền");  
            
            for(int i = 0; i < donGoiMasterModel.getListDonGoiModel().size(); i++){
                DonGoiModel donGoi = donGoiMasterModel.getListDonGoiModel().get(i);
                
                table.addCell(Integer.toString(i + 1));
                table.addCell(donGoi.getMonAn().getTen());
                table.addCell(Price.formatPrice(donGoi.getGia()));
                table.addCell(Integer.toString(donGoi.getSoLuong()));
                table.addCell(Price.formatPrice(donGoi.getThanhTien()));
            }    
                    
            doc.add(table);    
        
            int total = donGoiMasterModel.getTotal();
            double mucUuDai = khachHangFullModel != null ? khachHangFullModel.getLoaiKhachHang().getMucUuDai() : 0;
            double tongThanhToanDouble = Math.round(total - total * mucUuDai/100);
            int tongThanhToanInt = (int) tongThanhToanDouble;
            
            String tongThanhToanString = "Tổng tiền: " + Price.formatPrice(total) + "\n"
                    + "Ưu đãi khách hàng: " + mucUuDai + "%\n"
                    + "Tổng thanh toán " + Price.formatPrice(tongThanhToanInt); 
            Paragraph tongThanhToan = new Paragraph(tongThanhToanString);
            tongThanhToan.setTextAlignment(TextAlignment.RIGHT);
            doc.add(tongThanhToan);        

            // Closing the document       
            doc.close();
            
            OpenFile.openFile(dest); 
            
        } catch (IOException e){
            System.out.println(e);
            return false;
        }
        return true;
    }
}
