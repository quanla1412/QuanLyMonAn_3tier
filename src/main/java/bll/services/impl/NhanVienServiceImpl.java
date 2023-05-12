/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.services.impl;


import com.mycompany.quanlynhahang.AES;
import bll.mappers.NhanVienMapper;
import com.mycompany.quanlynhahang.OpenFile;
import dal.entity.NhanVien;
import dal.repository.NhanVienRepository;
import gui.models.NhanVien.ChucVuModel;
import gui.models.NhanVien.CreateNhanVienModel;
import gui.models.NhanVien.NhanVienFullModel;
import gui.models.NhanVien.NhanVienModel;
import gui.models.NhanVien.SearchNhanVienModel;
import gui.models.NhanVien.TinhTrangNhanVienModel;
import gui.models.NhanVien.UpdateTaiKhoanNhanVienModel;
import gui.models.NhanVien.UpdateNhanVienModel;
import gui.models.TaiKhoanModel;
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
import bll.services.INhanVienService;
import dal.entity.TinhTrangNhanVien;
import dal.repository.TinhTrangNhanVienRepository;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;




/**
 *
 * @author dinhn
 */
public class NhanVienServiceImpl implements INhanVienService{
    private final NhanVienRepository nhanVienRepository;
    private final TinhTrangNhanVienRepository tinhTrangNhanVienRepository;
    final String secretKey = "quanlynhahang!";
    
            
    public NhanVienServiceImpl(){
        nhanVienRepository = new NhanVienRepository();
        tinhTrangNhanVienRepository = new TinhTrangNhanVienRepository();
    }
            
    @Override
    public List<NhanVienModel> getAll() {
       List<NhanVien> listNhanVien = nhanVienRepository.getAll();
       List<NhanVienModel> listNhanVienModel = NhanVienMapper.toListNhanVienModel(listNhanVien);
       
       return listNhanVienModel;
    }


    @Override
    public NhanVienFullModel getByMa(String ma) {
        NhanVien nhanVien = nhanVienRepository.getByMa(ma);
        NhanVienFullModel nhanVienFullModel = NhanVienMapper.toNhanVienFullModel(nhanVien);
        
        return nhanVienFullModel;
    }
   
    @Override
    public boolean createNhanVien(CreateNhanVienModel createNhanVienModel) {
       NhanVien nhanVien = NhanVienMapper.toNhanVien(createNhanVienModel);
       String encryptedpassword = AES.encrypt(nhanVien.getMa(), secretKey);         
       nhanVien.setPassWord(encryptedpassword);
      
       NhanVien createNhanVien = nhanVienRepository.createNhanVien(nhanVien);
       
       return true;
    }

    @Override
    public boolean updateNhanVien(UpdateNhanVienModel updateNhanVienModel) {
       NhanVien nhanVien = NhanVienMapper.toNhanVien(updateNhanVienModel);
       
       NhanVien updateNhanVien = nhanVienRepository.updateNhanVien(nhanVien);
       
       return true;
    }


    @Override
    public boolean delete(String ma) {
       nhanVienRepository.delete(ma);
       
       return true;
    }

    @Override
    public List<NhanVienModel> search(SearchNhanVienModel searchNhanVienModel) {
       List<NhanVien> listNhanVien = nhanVienRepository.search(searchNhanVienModel);
       
       List<NhanVienModel> listNhanVienModel = NhanVienMapper.toListNhanVienModel(listNhanVien);
       
       return listNhanVienModel;
       
    }

    @Override
    public boolean exportNhanVien(ArrayList<NhanVienModel> listNhanVienModel, String filePath) {
        File saveFile = new File (filePath + "\\danhSachNhanVien.xlsx");

        Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheetNhanVien = wb.createSheet("Nhân Viên");
           
        
        int rowIndex = 1;        
        Row row = sheetNhanVien.createRow(rowIndex);   
        Cell titleCell = row.createCell(1);
        titleCell.setCellValue("Danh sách nhân viên");
        sheetNhanVien.addMergedRegion(CellRangeAddress.valueOf("$B$2:$H$2"));        
        CellStyle cellStyleTitle = wb.createCellStyle();
        cellStyleTitle.setAlignment(HorizontalAlignment.CENTER);
        titleCell.setCellStyle(cellStyleTitle);

        // tao hang tieu de   
        rowIndex += 2;
        row = sheetNhanVien.createRow(rowIndex);                
        Cell cell = row.createCell(0);
        cell.setCellValue("Mã nhân viên");    
        
        cell = row.createCell(1);
        cell.setCellValue("Họ tên");   
        
        cell = row.createCell(2);
        cell.setCellValue("Chức vụ");     
        
        cell = row.createCell(3);
        cell.setCellValue("Ngày sinh");          
        
        cell = row.createCell(4);
        cell.setCellValue("Giới tính");   
        
        cell = row.createCell(5);
        cell.setCellValue("Email");         
        
        cell = row.createCell(6);
        cell.setCellValue("Số điện thoại");     
        
        cell = row.createCell(7);
        cell.setCellValue("Địa chỉ");
        
        cell = row.createCell(8);
        cell.setCellValue("Căn cước công dân");
        
        cell = row.createCell(9);
        cell.setCellValue("Tình trạng");

        for (int i=0; i < listNhanVienModel.size(); i++) {
            NhanVienModel data = listNhanVienModel.get(i);
            
            rowIndex++;            
            row = sheetNhanVien.createRow(rowIndex);
            
            cell = row.createCell(0);
            cell.setCellValue(data.getMa());
            
            cell = row.createCell(1);
            cell.setCellValue(data.getHoTen());
            
            cell = row.createCell(2);
            cell.setCellValue(data.getHoTen());
            
            CellStyle cellStyleDate = wb.createCellStyle();
            cellStyleDate.setDataFormat(createHelper.createDataFormat().getFormat("d/m/yyyy"));
            cell = row.createCell(3);
            cell.setCellValue(data.getNgaySinh());
            cell.setCellStyle(cellStyleDate);
            
            cell = row.createCell(4);
            if (data.isGioiTinhNam() == true)
            {
                cell.setCellValue("Nam"); 
            }
            else cell.setCellValue("Nữ");
            
            
            cell = row.createCell(5);
            cell.setCellValue(data.getEmail());
            
            cell = row.createCell(6);
            cell.setCellValue(data.getSdt());
            
            cell = row.createCell(7);
            cell.setCellValue(data.getDiaChi());
            
            cell = row.createCell(8);
            cell.setCellValue(data.getCCCD());
            
            cell = row.createCell(9);
            cell.setCellValue(data.getTinhTrangNhanVien());
//            cell.setCellStyle(style); // set cell style with color
        }
        
         // Auto resize column witdth
        int numberOfColumn = sheetNhanVien.getRow(rowIndex).getPhysicalNumberOfCells();
        for (int columnIndex = 0; columnIndex < numberOfColumn; columnIndex++) {
            sheetNhanVien.autoSizeColumn(columnIndex);
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
    public boolean exportAllNhanVienTheoMauImport(String filePath) {
        NhanVienRepository nhanVienRepository1 = new NhanVienRepository();
        ChucVuServiceImpl chucVuServiceImpl = new ChucVuServiceImpl();
        TinhTrangNhanVienServiceImpl tinhTrangNhanVienServiceImpl = new TinhTrangNhanVienServiceImpl();
        
        List<NhanVien> listNhanVien = nhanVienRepository1.getAll();
        
        File saveFile = new File (filePath + "\\danhSachNhanVienImport.xlsx");

        Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheetNhanVien = wb.createSheet("Nhân Viên");

        int rowIndex = 0;       

        // tao hang tieu de           
        Row row = sheetNhanVien.createRow(rowIndex);                 
        Cell cell = row.createCell(0);
        cell.setCellValue("Mã nhân viên");     
        
        cell = row.createCell(1);
        cell.setCellValue("Tình trạng nhân viên");     
        
        cell = row.createCell(2);
        cell.setCellValue("Chức vụ");      
        
        cell = row.createCell(3);
        cell.setCellValue("Họ tên");         
        
        cell = row.createCell(4);
        cell.setCellValue("Ngày sinh");     
        
        cell = row.createCell(5);
        cell.setCellValue("Giới tính nam");
        
        cell = row.createCell(6);
        cell.setCellValue("Email");
        
        cell = row.createCell(7);
        cell.setCellValue("Số điện thoại");
        
        cell = row.createCell(8);
        cell.setCellValue("Căn cước công dân");
        
        cell = row.createCell(9);
        cell.setCellValue("Địa chỉ");


        for (int i=0; i < listNhanVien.size(); i++) {
            NhanVien data = listNhanVien.get(i);
            
            rowIndex++;            
            row = sheetNhanVien.createRow(rowIndex);
            
            cell = row.createCell(0);
            cell.setCellValue(data.getMa());
            
            cell = row.createCell(1);
            cell.setCellValue(data.getTinhTrangNhanVien().getId());
            
            cell = row.createCell(2);
            cell.setCellValue(data.getChucVu().getId());
            
            cell = row.createCell(3);
            cell.setCellValue(data.getHoTen());
            
            cell = row.createCell(4);
            CellStyle cellStyleDate = wb.createCellStyle();
            cellStyleDate.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yyyy"));
            cell.setCellValue(data.getNgaySinh());
            cell.setCellStyle(cellStyleDate);
            
            cell = row.createCell(5);
            cell.setCellValue(data.isGioiTinhNam());
            
            cell = row.createCell(6);
            cell.setCellValue(data.getEmail());
            
            cell = row.createCell(7);
            cell.setCellValue(data.getSdt());
            
            cell = row.createCell(8);
            cell.setCellValue(data.getCccd());
            
            cell = row.createCell(9);
            cell.setCellValue(data.getDiaChi());
//            cell.setCellStyle(style); // set cell style with color
        }
        
         // Auto resize column witdth
        int numberOfColumn = sheetNhanVien.getRow(rowIndex).getPhysicalNumberOfCells();
        for (int columnIndex = 0; columnIndex < numberOfColumn; columnIndex++) {
            sheetNhanVien.autoSizeColumn(columnIndex);
        }
        
        //Sheet thông tin chức vụ và tình trạng        
        List<ChucVuModel> listChucVu =  chucVuServiceImpl.getAll();
        List<TinhTrangNhanVienModel> listTinhTrang = tinhTrangNhanVienServiceImpl.getAll();
        Sheet sheetThongTin = wb.createSheet("Chức vụ và tình trạng");

        rowIndex = 0;               

        // tao hang tieu de 
        row = sheetThongTin.createRow(rowIndex++);                
        cell = row.createCell(0);
        cell.setCellValue("Danh sách chức vụ"); 
        sheetThongTin.addMergedRegion(CellRangeAddress.valueOf("$A$1:$B$1"));    
        
        row = sheetThongTin.createRow(rowIndex);                
        cell = row.createCell(0);
        cell.setCellValue("ID chức vụ");     
        
        cell = row.createCell(1);
        cell.setCellValue("Tên chức vụ");    


        for (int i=0; i < listChucVu.size(); i++) {
            ChucVuModel data = listChucVu.get(i);
            
            rowIndex++;            
            row = sheetThongTin.createRow(rowIndex);
            
            cell = row.createCell(0);
            cell.setCellValue(data.getId());
            
            cell = row.createCell(1);
            cell.setCellValue(data.getTen());
//            cell.setCellStyle(style); // set cell style with color
        }
        
        // tao hang tieu de 
        sheetThongTin.shiftRows(rowIndex, rowIndex+1, 1);
        rowIndex+=2;
        row = sheetThongTin.createRow(rowIndex);                
        cell = row.createCell(0);
        cell.setCellValue("Danh sách tình trạng");   
        sheetThongTin.addMergedRegion(CellRangeAddress.valueOf("$A$" + (rowIndex+1) + ":$B$" + (rowIndex + 1))); 
        
        rowIndex++;
        row = sheetThongTin.createRow(rowIndex);                
        cell = row.createCell(0);
        cell.setCellValue("ID tình trạng");     
        
        cell = row.createCell(1);
        cell.setCellValue("Tên tình trạng");    


        for (int i=0; i < listTinhTrang.size(); i++) {
            TinhTrangNhanVienModel data = listTinhTrang.get(i);
            
            rowIndex++;            
            row = sheetThongTin.createRow(rowIndex);
            
            cell = row.createCell(0);
            cell.setCellValue(data.getId());
            
            cell = row.createCell(1);
            cell.setCellValue(data.getTen());
//            cell.setCellStyle(style); // set cell style with color
        }
        
         // Auto resize column witdth
        numberOfColumn = sheetThongTin.getRow(rowIndex).getPhysicalNumberOfCells();
        for (int columnIndex = 0; columnIndex < numberOfColumn; columnIndex++) {
            sheetThongTin.autoSizeColumn(columnIndex);
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
    public int importNhanVien(String filePath) {
        NhanVienRepository nhanVienRepository1 = new NhanVienRepository();
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
                
                String ma = row.getCell(0).getStringCellValue();
                int idTinhTrang = (int) row.getCell(1).getNumericCellValue();
                int idChucVu = (int) row.getCell(2).getNumericCellValue();
                String hoTen = row.getCell(3).getStringCellValue();
                Date ngaySinh = row.getCell(4).getDateCellValue();
                boolean gioiTinhNam = row.getCell(5).getBooleanCellValue();
                String email = row.getCell(6).getStringCellValue();
                String SDT = row.getCell(7).getStringCellValue();
                String CCCD = row.getCell(8).getStringCellValue();
                String diaChi = row.getCell(9).getStringCellValue();
                
                if(nhanVienRepository1.hasMaNV(ma)){
                    UpdateNhanVienModel data = new UpdateNhanVienModel(
                            ma,
                            idTinhTrang,
                            idChucVu,
                            hoTen,
                            email, 
                            SDT,
                            diaChi
                        );
                    result = updateNhanVien(data);
                } else {
                    CreateNhanVienModel data = new CreateNhanVienModel(
                            ma,
                            idTinhTrang,
                            idChucVu,
                            hoTen, 
                            ngaySinh,
                            gioiTinhNam,
                            email,
                            SDT,
                            diaChi,
                            CCCD
                        );
                    result = createNhanVien(data);
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

    @Override
    public boolean updateTaiKhoanNhanVien(UpdateTaiKhoanNhanVienModel updateTaiKhoanNhanVienModel) {
       NhanVien nhanVien = NhanVienMapper.toNhanVien(updateTaiKhoanNhanVienModel);
       
       NhanVien updateTaiKhoanNhanVien = nhanVienRepository.updateTaiKhoanNhanVien(nhanVien);
       
       return true;
    }

    @Override
    public boolean dangNhap(TaiKhoanModel taiKhoanModel) {
        NhanVien nhanVien = nhanVienRepository.getByMa(taiKhoanModel.getUsername());
  
       if (nhanVien == null)
           return false;
       
        String password = taiKhoanModel.getPassword().trim();
        String passwordCheck = nhanVien.getPassWord().trim();
        
        if(password.equals(passwordCheck))
            return true;
        return false;
        
    }
    
    @Override
    public Map<String, Integer> countByTinhTrang() {
        Map<String, Integer> result = new HashMap<>();
        ArrayList<TinhTrangNhanVien> listTinhTrangNhanVien = tinhTrangNhanVienRepository.getAll();
        
        listTinhTrangNhanVien.forEach(tinhTrangNhanVien -> result.put(tinhTrangNhanVien.getTen(), tinhTrangNhanVien.getListNhanVien().size()));
        
        return result;
    }

    @Override
    public Map<String, Integer> countByGioiTinh() {
        Map<String, Integer> result = new HashMap<>();
        ArrayList<NhanVien> listNhanVien = (ArrayList<NhanVien>) nhanVienRepository.getAll();
        
        int nam = 0;
        int nu = 0;
        
        for(NhanVien nhanVien : listNhanVien) {
            if(nhanVien.isGioiTinhNam())
                nam++;
            else
                nu++;
        }
        
        result.put("Nam", nam);
        result.put("Nữ", nu);
        
        return result;
    }

    @Override
    public Map<String, Integer> countByTuoi() {
        Map<String, Integer> result = new HashMap<>();
        ArrayList<NhanVien> listNhanVien = (ArrayList<NhanVien>) nhanVienRepository.getAll();
        
        int u20=0;
        int u30=0;
        int u40=0;
        int conLai=0;
        for(NhanVien nhanVien : listNhanVien){
            Timestamp ngaySinh = new Timestamp(nhanVien.getNgaySinh().getTime());
            int tuoi = Period.between(ngaySinh.toLocalDateTime().toLocalDate(), LocalDate.now()).getYears();
            if (tuoi < 20) {
                u20++;
            }
            else if(tuoi < 30){
                u30++;
            }
            else if(tuoi < 40){
                u40++;
            }
            else 
                conLai++;               
        }
        if(u20>0) result.put("Dưới 20", u20);
        if(u30>0) result.put("Từ 20 - 29", u30);
        if(u40>0) result.put("Từ 30 - 39", u40);
        if(conLai>0) result.put("Từ 40 trở lên", conLai);
        
        return result;
    }
    
}
