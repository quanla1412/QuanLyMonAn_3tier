/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.services.impl;

import bll.mappers.HoaDonMapper;
import bll.services.IBanService;
import bll.services.IDonGoiService;
import bll.services.IHoaDonService;
import bll.services.IKhachHangService;
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
import dal.entity.ChiTietHoaDon;
import dal.entity.HoaDon;
import dal.entity.KhachHang;
import dal.repository.HoaDonRepository;
import gui.constraints.TinhTrangBanConstraints;
import gui.constraints.TinhTrangHoaDonConstraints;
import gui.models.HoaDon.CreateHoaDonModel;
import gui.models.HoaDon.HoaDonFullModel;
import gui.models.HoaDon.HoaDonModel;
import gui.models.HoaDon.SearchHoaDonModel;
import java.util.Date;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tanph
 */
public class HoaDonServiceImpl implements IHoaDonService{
    HoaDonRepository hoaDonRepository;
    IDonGoiService donGoiService;
    IBanService banService;
    IKhachHangService khachHangService;

    public HoaDonServiceImpl(){
        hoaDonRepository = new HoaDonRepository();
        donGoiService = new DonGoiServiceImpl();
        banService = new BanServiceImpl();
        khachHangService = new KhachHangServiceImpl();
    }
    
    @Override
    public List<HoaDonModel> getAll(boolean daHuy) {
        List<HoaDon> listHoaDon = hoaDonRepository.getAllHoaDon();
        listHoaDon.removeIf(hoaDon -> hoaDon.isDaHuy() != daHuy);
        List<HoaDonModel> listHoaDonModel = HoaDonMapper.toListHoaDonModel(listHoaDon);
    
        return listHoaDonModel;
    }

    @Override
    public HoaDonFullModel getHoaDonFullById(int id) {
        HoaDon hoaDon = hoaDonRepository.getById(id);
        HoaDonFullModel hoaDonFullModel = HoaDonMapper.toHoaDonFullModel(hoaDon);
        
        return hoaDonFullModel;
    }

    @Override
    public List<HoaDonModel> search(SearchHoaDonModel searchHoaDonModel) {
        List<HoaDon> listHoaDon = hoaDonRepository.search(searchHoaDonModel);
        List<HoaDonModel> listHoaDonModel = HoaDonMapper.toListHoaDonModel(listHoaDon);
    
        return listHoaDonModel;
    }

    @Override
    public boolean huyHoaDon(HoaDonFullModel hoaDonSelected) {
        if(hoaDonSelected.isDaHuy() == TinhTrangHoaDonConstraints.HOP_LE){
            HoaDon hoaDon = hoaDonRepository.huyHoaDon(hoaDonSelected.getId());
            
            if(hoaDon.isDaHuy()){
                if(hoaDon.getKhachHang() != null){
                    int diemTichLuy = Price.getDiemTichLuy(hoaDon.getTongGia());
                    khachHangService.updateDiemTichLuy(hoaDon.getKhachHang().getId(), -diemTichLuy);
                }
                return true;
            }            
        }
        return false;
    }

    @Override
    public HoaDonModel create(CreateHoaDonModel createHoaDonModel) {
        HoaDon hoaDon = HoaDonMapper.toHoaDon(createHoaDonModel);
        HoaDon createdHoaDon = hoaDonRepository.create(hoaDon);
        
        boolean result = createdHoaDon.getId() > 0;
        if(!result)
            return null;
        
        result = donGoiService.delete(createHoaDonModel.getIdBan());        
        if(!result)
            return null;
        
        result = banService.changeTinhTrangBan(createHoaDonModel.getIdBan(), TinhTrangBanConstraints.DANG_CHUAN_BI);
        if(hoaDon.getKhachHang() != null)
            khachHangService.updateDiemTichLuy(hoaDon.getKhachHang().getId(), (int) hoaDon.getTongGia() / 10000);
        
        HoaDonModel hoaDonModel = HoaDonMapper.toHoaDonModel(createdHoaDon);
        return hoaDonModel;
    }
    
    public boolean inBill(int idHoaDon, String filePath){
        HoaDon hoaDon = hoaDonRepository.getById(idHoaDon);
        KhachHang khachHang = hoaDon.getKhachHang();
        
        // tạo một document
        String dest = filePath + "\\bill.pdf";
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
            
            Paragraph name = new Paragraph("In bill");
            name.setFontSize(16);
            doc.add(name);
            
            // Customer and staff information
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formatDateTimeNow = now.format(formatter);
            
            String hoTenKH = khachHang != null ? khachHang.getTen(): "";
            String sdtKH = khachHang != null ? khachHang.getSdt(): "";
            
            String infoString = 
                    "Mã nhân viên: " + hoaDon.getNhanVien().getMa()+ "\n"
                    + "Tên nhân viên: " +  hoaDon.getNhanVien().getHoTen() + "\n"
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
            
            int total = 0;
            for(int i = 0; i < hoaDon.getListChiTietHoaDon().size(); i++){
                ChiTietHoaDon cthd = hoaDon.getListChiTietHoaDon().get(i);
                int gia = cthd.getDonGia();
                int thanhTien = cthd.getSoLuong() * gia;
                total += thanhTien;
                
                table.addCell(Integer.toString(i + 1));
                table.addCell(cthd.getMonAn().getTen());
                table.addCell(Price.formatPrice(gia));
                table.addCell(Integer.toString(cthd.getSoLuong()));
                table.addCell(Price.formatPrice(thanhTien));
            }    
                    
            doc.add(table);    
            
            String tongThanhToanString = "Tổng tiền: " + Price.formatPrice(total) + "\n"
                    + "Ưu đãi khách hàng: " + hoaDon.getUuDai() + "%\n"
                    + "Tổng thanh toán " + Price.formatPrice(hoaDon.getTongGia()); 
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

    @Override
    public long getDoanhThuTrongNgay(Date ngay) {
        List<HoaDon> listHoaDon = hoaDonRepository.getListHoaDonTrongNgay(ngay);
        long doanhThuTrongNgay = 0;
        
        for(HoaDon hoaDon : listHoaDon) {
            if(hoaDon.isDaHuy() == TinhTrangHoaDonConstraints.HOP_LE)
                doanhThuTrongNgay += hoaDon.getTongGia();
        }
        return doanhThuTrongNgay;
    }

    @Override
    public long getDoanhThuTrong7NgayGanNhat(Date ngayBatDau, Date ngayKetThuc) {
        List<HoaDon> listHoaDon = hoaDonRepository.getListHoaDonTrong7NgayGanNhat(ngayBatDau, ngayKetThuc);
        long doanhThuTrong7NgayGanNhat = 0;
        
        for(HoaDon hoaDon : listHoaDon) {
            if(hoaDon.isDaHuy() == TinhTrangHoaDonConstraints.HOP_LE)
                doanhThuTrong7NgayGanNhat += hoaDon.getTongGia();
        }
        return doanhThuTrong7NgayGanNhat;
    }
}
