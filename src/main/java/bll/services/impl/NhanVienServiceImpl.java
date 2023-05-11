/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.services.impl;

import bll.mappers.NhanVienMapper;
import bll.services.INhanVienSerivice;
import com.mycompany.quanlynhahang.OpenFile;
import dal.entity.NhanVien;
import dal.repository.NhanVienRepository;
import gui.models.NhanVien.CreateNhanVienModel;
import gui.models.NhanVien.NhanVienFullModel;
import gui.models.NhanVien.NhanVienModel;
import gui.models.NhanVien.SearchNhanVienModel;
import gui.models.NhanVien.UpdateNhanVienModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.ui.HorizontalAlignment;

/**
 *
 * @author dinhn
 */
public class NhanVienServiceImpl implements INhanVienSerivice{
    private final NhanVienRepository nhanVienRepository;
 
    
    public NhanVienServiceImpl(){
        nhanVienRepository = new NhanVienRepository();
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
       nhanVien.setPassWord(nhanVien.getMa());
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

    
    
    
   
    
    
 
    
    
    
    
}
