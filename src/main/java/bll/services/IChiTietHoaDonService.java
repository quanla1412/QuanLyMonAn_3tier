/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bll.services;

import gui.models.HoaDon.ChiTietHoaDonModel;
import java.util.List;

/**
 *
 * @author tanph
 */
public interface IChiTietHoaDonService  {
    public List<ChiTietHoaDonModel> getAllChiTietHoaDonByIdHoaDon(int idHoaDon);
}
