/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.services.impl;

import bll.mappers.KhachHangMapper;
import bll.services.IKhachHangService;
import com.mycompany.quanlynhahang.OpenFile;
import dal.entity.KhachHang;
import dal.repository.KhachHangRepository;
import gui.models.KhachHang.KhachHangFullModel;
import gui.models.KhachHang.CreateKhachHangModel;
import gui.models.KhachHang.KhachHangModel;
import gui.models.KhachHang.SearchKhachHangModel;
import gui.models.KhachHang.UpdateKhachHangModel;
import gui.models.LoaiKhachHang.CreateLoaiKhachHangModel;
import gui.models.LoaiKhachHang.UpdateLoaiKhachHangModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author tuant
 */
public class KhachHangServiceImpl implements IKhachHangService {
    private final KhachHangRepository khachHangRepository;

    public KhachHangServiceImpl() {
        khachHangRepository = new KhachHangRepository();
    }
    
    public List<KhachHangModel> getAll() {
        List<KhachHang> listKhachHang = khachHangRepository.getAll();
        List<KhachHangModel> listKhachHangModel = KhachHangMapper.toListKhachHangModel(listKhachHang);
                
        return listKhachHangModel;        
    }
    
    public KhachHangFullModel getById(int id) {
        KhachHang khachHang = khachHangRepository.getById(id);
        KhachHangFullModel khachHangModel = KhachHangMapper.toKhachHangFullModel(khachHang);
        
        return khachHangModel;
    }

    @Override
    public List<KhachHangModel> search(SearchKhachHangModel searchKhachHangModel) {
        List<KhachHang> listKhachHang = khachHangRepository.search(searchKhachHangModel);
        List<KhachHangModel> listKhachHangModel = KhachHangMapper.toListKhachHangModel(listKhachHang);
                
        return listKhachHangModel; 
    }
    
    @Override
    public boolean createKhachHang(CreateKhachHangModel createKhachHangModel) {
        KhachHang khachHang = KhachHangMapper.toKhachHang(createKhachHangModel);
        KhachHang createdKhachHang = khachHangRepository.createKhachHang(khachHang);
        
        return createdKhachHang.getId() > 0;
    }
    @Override
    public boolean updateKhachHang(UpdateKhachHangModel updateKhachHangModel) {
        KhachHang khachHang = KhachHangMapper.toKhachHang(updateKhachHangModel);
        KhachHang updatedKhachHang = khachHangRepository.updateKhachHang(khachHang);
        
        return true;
    }

    @Override
    public boolean exportKhachHang(ArrayList<KhachHangModel> listKhachHangModels, String filePath) {
        File saveFile = new File (filePath + "\\danhSachKhachHang.xlsx");

        Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("Khách hàng");

        int rowIndex = 1;        
        Row row = sheet.createRow(rowIndex);   
        Cell titleCell = row.createCell(1);
        titleCell.setCellValue("Danh sách khách hàng");
        sheet.addMergedRegion(CellRangeAddress.valueOf("$B$2:$G$2"));        
        CellStyle cellStyleTitle = wb.createCellStyle();
        cellStyleTitle.setAlignment(HorizontalAlignment.CENTER);
        titleCell.setCellStyle(cellStyleTitle);
        

        // tao hang tieu de   
        rowIndex += 2;
        row = sheet.createRow(rowIndex);                
        Cell cell = row.createCell(0);
        cell.setCellValue("Mã khách hàng");    
        
        cell = row.createCell(1);
        cell.setCellValue("Loại khách hàng");   
        
        cell = row.createCell(2);
        cell.setCellValue("Họ và tên");     
        
        cell = row.createCell(3);
        cell.setCellValue("Số điện thoại");          
        
        cell = row.createCell(4);
        cell.setCellValue("Điểm tích lũy");   
        
        cell = row.createCell(5);
        cell.setCellValue("Email");         
        
        cell = row.createCell(6);
        cell.setCellValue("Ngày sinh");     
        
        cell = row.createCell(7);
        cell.setCellValue("Giới tính");


        for (int i=0; i < listKhachHangModels.size(); i++) {
            KhachHangModel data = listKhachHangModels.get(i);
            
            rowIndex++;            
            row = sheet.createRow(rowIndex);
            
            cell = row.createCell(0);
            cell.setCellValue(data.getId());
            
            cell = row.createCell(1);
            cell.setCellValue(data.getLoaiKhachHang());
            
            cell = row.createCell(2);
            cell.setCellValue(data.getTen());
            
            cell = row.createCell(3);
            cell.setCellValue(data.getSdt());
            
            cell = row.createCell(4);
            cell.setCellValue(data.getDiemTichLuy());
            
            cell = row.createCell(5);
            cell.setCellValue(data.getEmail());
            
            CellStyle cellStyleDate = wb.createCellStyle();
            cellStyleDate.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yyyy"));
            cell = row.createCell(6);
            cell.setCellValue(data.getNgaySinh());
            cell.setCellStyle(cellStyleDate);
            
            cell = row.createCell(7);
            if (data.isGioiTinhNam() == true)
            {
                cell.setCellValue("Nam"); 
            }
            else cell.setCellValue("Nữ");
//            cell.setCellStyle(style); // set cell style with color
        }
        
         // Auto resize column witdth
        int numberOfColumn = sheet.getRow(rowIndex).getPhysicalNumberOfCells();
        for (int columnIndex = 0; columnIndex < numberOfColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
        
        try (OutputStream os = new FileOutputStream(saveFile.getAbsoluteFile())) {
            wb.write(os);
            OpenFile.openFile(saveFile.toString());  
        } catch (IOException e) {
            System.out.println(e);    
            return false;
        }
        return true;
    }

    @Override
    public boolean exportAllKhachHangTheoMauImport(String filePath) {
        KhachHangRepository khachHangRepository1 = new KhachHangRepository();
        
        List<KhachHang> listKhachHang = khachHangRepository1.getAll();
        
        File saveFile = new File (filePath + "\\danhSachKhachHangImport.xlsx");

        Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("Khách hàng");

        int rowIndex = 1;        
        Row row = sheet.createRow(rowIndex);          

        // tao hang tieu de   
        row = sheet.createRow(rowIndex);                
        Cell cell = row.createCell(0);
        cell.setCellValue("ID khách hàng");     
        
        cell = row.createCell(1);
        cell.setCellValue("Họ và tên");     
        
        cell = row.createCell(2);
        cell.setCellValue("Số điện thoại");      
        
        cell = row.createCell(3);
        cell.setCellValue("Email");         
        
        cell = row.createCell(4);
        cell.setCellValue("Ngày sinh");     
        
        cell = row.createCell(5);
        cell.setCellValue("Giới tính nam");


        for (int i=0; i < listKhachHang.size(); i++) {
            KhachHang data = listKhachHang.get(i);
            
            rowIndex++;            
            row = sheet.createRow(rowIndex);
            
            cell = row.createCell(0);
            cell.setCellValue(data.getId());
            
            cell = row.createCell(1);
            cell.setCellValue(data.getTen());
            
            cell = row.createCell(2);
            cell.setCellValue(data.getSdt());
            
            cell = row.createCell(3);
            cell.setCellValue(data.getEmail());
            
            cell = row.createCell(4);
            CellStyle cellStyleDate = wb.createCellStyle();
            cellStyleDate.setDataFormat(createHelper.createDataFormat().getFormat("d/m/yyyy"));
            cell.setCellValue(data.getNgaySinh());
            cell.setCellStyle(cellStyleDate);
            
            cell = row.createCell(5);
            cell.setCellValue(data.isGioiTinhNam());
//            cell.setCellStyle(style); // set cell style with color
        }
        
         // Auto resize column witdth
        int numberOfColumn = sheet.getRow(rowIndex).getPhysicalNumberOfCells();
        for (int columnIndex = 0; columnIndex < numberOfColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
        
        
        try (OutputStream os = new FileOutputStream(saveFile.getAbsoluteFile())) {
            wb.write(os);
            OpenFile.openFile(saveFile.toString());  
        } catch (IOException e) {
            System.out.println(e);    
            return false;
        }
        return true;
    }

    @Override
    public int importKhachHang(String filePath) {
       KhachHangRepository khachHangRepository1 = new KhachHangRepository();
        int totalSuccess = 0;
        try {
            File file = new File(filePath);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
            
                // Đọc dữ liệu từ các hàng trong sheet
            boolean firstRow = true;
            for (Row row : sheet) {
                if (firstRow){
                    firstRow = false;
                    continue;
                }
                boolean result;
                
                int id = (int) row.getCell(0).getNumericCellValue();
                String hoTen = row.getCell(1).getStringCellValue();
                String SDT = row.getCell(2).getStringCellValue();
                String email = row.getCell(3).getStringCellValue();
                Date ngaySinh = row.getCell(4).getDateCellValue();
                boolean gioiTinhNam = row.getCell(5).getBooleanCellValue();
                
                if(khachHangRepository1.hasId(id)){
                    UpdateKhachHangModel data = new UpdateKhachHangModel(
                            id,
                            hoTen,
                            SDT,
                            email,
                            ngaySinh, 
                            gioiTinhNam
                        );
                    result = updateKhachHang(data);
                } else {
                    CreateKhachHangModel data = new CreateKhachHangModel(
                            hoTen,
                            SDT,
                            email,
                            ngaySinh, 
                            gioiTinhNam
                        );
                    result = createKhachHang(data);
                }
                
                if(result)
                    totalSuccess++;
            }

                workbook.close();
                
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return totalSuccess;
    }

    
    
}
