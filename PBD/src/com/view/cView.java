package com.view;
import com.config.cConfig;

public class cView {
    public static void getAll(){
        // pesan header
        System.out.println("\n::: Data Barang :::");
        
        // data semua barangnya
        System.out.println(cConfig.getAllData());
    }
}