package com.mycompany.quanlynhahang;

import java.awt.Desktop;
import java.io.IOException;

/**
 *
 * @author LeAnhQuan
 */
public class OpenFile {
    public static void openFile (String filePath) {
        try {
            java.io.File path = new java.io.File(filePath);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
}
