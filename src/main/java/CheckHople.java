
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tuant
 */
public class CheckHople {
    public static boolean checkSoDienThoai(String sdt){
        Pattern pattern = Pattern.compile("^0[0-9]{9}$");
        Matcher matcher = pattern.matcher(sdt);
        
        return matcher.find();
    }
     public static boolean checkCCCD(String cccd){
        Pattern pattern = Pattern.compile("^0[0-9]{11}$");
        Matcher matcher = pattern.matcher(cccd);
        
        return matcher.find();
    }
    
    public static boolean checkEmail(String email){
        Pattern pattern = Pattern.compile("^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$");
        Matcher matcher = pattern.matcher(email);
        
        return matcher.find();
    }
}
