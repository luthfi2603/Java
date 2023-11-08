package com.view;
import com.config.cConfig;
import java.util.Scanner;

public class cView {
    private static Scanner input = new Scanner(System.in);
    private static int id, stokBarang, hargaBarang;
    private static String keyword, namaBarang;

    public static void getAll(){
        // pesan header
        System.out.println("\n::: Data Barang :::");

        // data semua barangnya
        System.out.println(cConfig.getAllData());
    }

    public static void detailBarang(){
        System.out.println("\n::: Detail Data Barang :::");
        
        System.out.print("Masukkan ID Barang : ");
        id = input.nextInt();
        input.nextLine();

        System.out.println("Hasil Data");
        System.out.println(cConfig.detailData(id));
    }

    public static void cariData(){
        System.out.println("\n::: Cari Data :::");
        
        System.out.print("Masukkan Keyword : ");
        keyword = input.nextLine();

        System.out.println("Hasil Data");
        System.out.println(cConfig.cariData(keyword));
    }

    public static void tambahData(){
        System.out.println("\n::: Tambah Data Barang :::");

        System.out.print("Masukkan nama barang : ");
        namaBarang = input.nextLine();
        
        System.out.print("Masukkan stok barang : ");
        stokBarang = input.nextInt();
        
        System.out.print("Masukkan harga barang : ");
        hargaBarang = input.nextInt();
        input.nextLine();

        // System.out.println("Nama barang : " + namaBarang + ", Stok barang : " + stokBarang + ", Harga barang : " + hargaBarang);

        if (cConfig.tambahData(namaBarang, stokBarang, hargaBarang)) {
            System.out.println("Data barang berhasil ditambahakan!");
            cView.getAll();
        } else {
            System.out.println("Data barang gagal ditambahakan!");
        }
    }
}