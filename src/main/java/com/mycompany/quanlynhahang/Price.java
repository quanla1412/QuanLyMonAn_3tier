package com.mycompany.quanlynhahang;

/**
 *
 * @author LeAnhQuan
 */
public class Price {
    public static String formatPrice(long price){
        String str = Long.toString(price);
        
        StringBuilder result = new StringBuilder();
        
        int count = 0;
        for(int i = str.length() - 1; i >= 0; i--){
            if(count % 3 == 0 && count > 0)
                result.append('.');
            result.append(str.charAt(i));
            count++;
        }
        
        result.reverse();
        result.append(" VNĐ");
        
        return result.toString();
    }
}
