/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.mappers;

import dal.entity.ChucVu;
import dal.entity.NhanVien;
import dal.entity.TinhTrangNhanVien;
import gui.models.NhanVien.ChucVuModel;
import gui.models.NhanVien.CreateNhanVienModel;
import gui.models.NhanVien.NhanVienFullModel;
import gui.models.NhanVien.NhanVienModel;
import gui.models.NhanVien.TinhTrangNhanVienModel;
import gui.models.NhanVien.UpdateTaiKhoanNhanVienModel;
import gui.models.NhanVien.UpdateNhanVienModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dinhn
 */
public class NhanVienMapper {
    public static NhanVienModel toNhanVienModel (NhanVien nhanVien) {
        NhanVienModel nhanVienModel = new NhanVienModel();
        nhanVienModel.setMa(nhanVien.getMa());
        nhanVienModel.setTenChucVu(nhanVien.getChucVu().getTen());
        nhanVienModel.setTinhTrangNhanVien(nhanVien.getTinhTrangNhanVien().getTen());
        nhanVienModel.setHoTen(nhanVien.getHoTen());
        nhanVienModel.setNgaySinh(nhanVien.getNgaySinh());
        nhanVienModel.setGioiTinhNam(nhanVien.getGioiTinhNam());
        nhanVienModel.setEmail(nhanVien.getEmail());
        nhanVienModel.setSdt(nhanVien.getSdt());
        nhanVienModel.setDiaChi(nhanVien.getDiaChi());
        nhanVienModel.setPassWord(nhanVien.getPassWord());
        nhanVienModel.setCCCD(nhanVien.getCccd());

        return nhanVienModel;
    }
    
    public static List<NhanVienModel> toListNhanVienModel (List<NhanVien> listNhanVien){
        List<NhanVienModel> listNhanVienModel = new ArrayList<>();
        listNhanVien.forEach(nhanVien -> listNhanVienModel.add(toNhanVienModel(nhanVien)));
        
        return listNhanVienModel;
    }
    
    
    
    public static NhanVien toNhanVien(CreateNhanVienModel createNhanVienModel){
        NhanVien nhanVien = new NhanVien();
        
        nhanVien.setMa(createNhanVienModel.getMa());
        nhanVien.setHoTen(createNhanVienModel.getHoTen());
        nhanVien.setDiaChi(createNhanVienModel.getDiaChi());
        nhanVien.setGioiTinhNam(createNhanVienModel.getGioiTinhNam());
        nhanVien.setEmail(createNhanVienModel.getEmail());
        nhanVien.setSdt(createNhanVienModel.getSoDienThoai());
        nhanVien.setCccd(createNhanVienModel.getCCCD());
        nhanVien.setNgaySinh(createNhanVienModel.getNgaySinh());
        
        
        ChucVu chucVu = new ChucVu();
        chucVu.setId(createNhanVienModel.getIdChucVu());
        nhanVien.setChucVu(chucVu);
        
        TinhTrangNhanVien tinhTrangNhanVien = new TinhTrangNhanVien();
        tinhTrangNhanVien.setId(createNhanVienModel.getIdTinhTrangNhanVien());
        nhanVien.setTinhTrangNhanVien(tinhTrangNhanVien);
        
        return nhanVien;        
    }
    
    public static NhanVien toNhanVien(UpdateNhanVienModel updateNhanVienModel){
        NhanVien nhanVien = new NhanVien();
        
        nhanVien.setMa(updateNhanVienModel.getMa());
        nhanVien.setHoTen(updateNhanVienModel.getHoTen());
        nhanVien.setDiaChi(updateNhanVienModel.getDiaChi());
        nhanVien.setEmail(updateNhanVienModel.getEmail());
        nhanVien.setSdt(updateNhanVienModel.getSoDienThoai());
   
        
        ChucVu chucVu = new ChucVu();
        chucVu.setId(updateNhanVienModel.getIdChucVu());
        nhanVien.setChucVu(chucVu);
        
        TinhTrangNhanVien tinhTrangNhanVien = new TinhTrangNhanVien();
        tinhTrangNhanVien.setId(updateNhanVienModel.getIdTinhTrangNhanVien());
        nhanVien.setTinhTrangNhanVien(tinhTrangNhanVien);
        
        return nhanVien;        
    }
    
      public static NhanVien toNhanVien(UpdateTaiKhoanNhanVienModel updateMatKhauNhanVienModel){
        NhanVien nhanVien = new NhanVien();
        
        nhanVien.setMa(updateMatKhauNhanVienModel.getMa());
        
        nhanVien.setPassWord(updateMatKhauNhanVienModel.getPassword());

        return nhanVien;        
    }
    
  
    
    public static NhanVienFullModel toNhanVienFullModel(NhanVien nhanVien){
        NhanVienFullModel nhanVienFullModel = new NhanVienFullModel();
        
        nhanVienFullModel.setMa(nhanVien.getMa());
     
        nhanVienFullModel.setHoTen(nhanVien.getHoTen());
        nhanVienFullModel.setNgaySinh(nhanVien.getNgaySinh());
        nhanVienFullModel.setGioiTinhNam(nhanVien.getGioiTinhNam());
        nhanVienFullModel.setEmail(nhanVien.getEmail());
        nhanVienFullModel.setSoDienThoai(nhanVien.getSdt());
        nhanVienFullModel.setDiaChi(nhanVien.getDiaChi());
        nhanVienFullModel.setPassWord(nhanVien.getPassWord());
        nhanVienFullModel.setCCCD(nhanVien.getCccd());
        
        
        TinhTrangNhanVienModel tinhTrangNhanVienModel = TinhTrangNhanVienMapper.toTinhTrangNhanVienModel(nhanVien.getTinhTrangNhanVien());
        nhanVienFullModel.setTinhTrangNhanVien(tinhTrangNhanVienModel);
        
        ChucVuModel chucVuModel = ChucVuMapper.toChucVuModel(nhanVien.getChucVu());
        nhanVienFullModel.setChucVu(chucVuModel);
        
        return nhanVienFullModel;
    }
    
    
}
