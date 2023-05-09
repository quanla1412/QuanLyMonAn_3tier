package bll.services;

import dal.entity.TinhTrangMonAn;
import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public interface ITinhTrangMonAnService {
    ArrayList<TinhTrangMonAn> getAll();
    
    TinhTrangMonAn getById(int id);
}
