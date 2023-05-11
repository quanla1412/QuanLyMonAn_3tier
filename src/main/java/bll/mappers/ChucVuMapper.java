/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll.mappers;

import dal.entity.ChucVu;
import gui.models.NhanVien.ChucVuModel;
import gui.models.NhanVien.CreateChucVuModel;
import gui.models.NhanVien.UpdateChucVuModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dinhn
 */
public class ChucVuMapper {
    public static ChucVuModel toChucVuModel (ChucVu chucVu){
        ChucVuModel chucVuModel = new ChucVuModel(
                chucVu.getId(),
                chucVu.getTen()

        );
        return chucVuModel;
    }
    
    
    public static List<ChucVuModel> toListChucVuModel (List<ChucVu> listChucVu){
        List<ChucVuModel> result = new ArrayList<>();        
        
        listChucVu.forEach(chucVu -> {
            result.add(new ChucVuModel (
            chucVu.getId(),
            chucVu.getTen()
            ));
        });
        
        
        return result;
    }
    
    public static ChucVu toChucVu (CreateChucVuModel createChucVuModel) {
        ChucVu chucVu = new ChucVu();
        
        chucVu.setTen(createChucVuModel.getTen());
        
        return chucVu;
    }
            
    public static ChucVu toChucVu (UpdateChucVuModel updateChucVuModel){
        ChucVu chucVu = new ChucVu();
        
        chucVu.setId((updateChucVuModel.getId()));
        chucVu.setTen(updateChucVuModel.getTen());
        
        return chucVu;
    }
    
            
            
}
