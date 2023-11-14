package com.view;
import com.config.cConfig;
import java.util.Scanner;

public class cView {
    private static Scanner input = new Scanner(System.in);
    private static int id, stokBarang, hargaBarang;
    private static String keyword, namaBarang, stokBarangS, hargaBarangS, pilihan;

    public static void index(){
        while(true){
            System.out.print("\n========== MENU ==========\n"
            + "1. Lihat Semua Data Barang\n"
            + "2. Detail Data Barang\n"
            + "3. Cari Data Barang\n"
            + "4. Tambah Data Barang\n"
            + "5. Update Data Barang\n"
            + "6. Delete Data Barang\n"
            + "0. Exit\n"
            + "Pilih [1/2/3/4/5/0] : ");
            pilihan = input.nextLine();

            switch(pilihan){
                case "1":
                    getAll();
                    break;
                case "2":
                    detailBarang();
                    break;
                case "3":
                    cariData();
                    break;
                case "4":
                    tambahData();
                    break;
                case "5":
                    updateData();
                    break;
                case "6":
                    deleteData();
                    break;
                case "0":
                    System.out.println("\nExit");
                    break;
                default:
                    System.out.println("Pilihan anda salah!");
                    break;
            }

            if(pilihan.equalsIgnoreCase("0")){
                break;
            }
        }
    }

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
            System.out.println("\nData barang berhasil ditambahakan!");
            getAll();
        } else {
            System.out.println("\nData barang gagal ditambahakan!");
        }
    }

    public static void updateData(){
        System.out.print("\n::: Update Data Barang :::\n"
        + "Masukkan ID Barang : ");
        id = input.nextInt();
        input.nextLine();

        System.out.print("\nGanti Data Barang\n(Kosongkan jika tidak ingin merubah data)\n"
        + "Nama barang : ");
        namaBarang = input.nextLine();

        System.out.print("Stok barang : ");
        stokBarangS = input.nextLine();
        
        System.out.print("Harga barang : ");
        hargaBarangS = input.nextLine();

        // System.out.println("ID Barang : " + id + ", Nama barang : " + namaBarang + ", Stok barang : " + stokBarang + ", Harga barang : " + hargaBarang);

        if (cConfig.ubahData(id, namaBarang, stokBarangS, hargaBarangS)) {
            System.out.println("\nData barang berhasil diubah!");
            getAll();
        } else {
            System.out.println("\nData barang gagal diubah!");
        }
    }
    
    public static void deleteData(){
        System.out.print("\n::: Delete Data Barang :::\n"
        + "Masukkan ID Barang : ");
        id = input.nextInt();
        input.nextLine();

        if (cConfig.deleteData(id)) {
            System.out.println("\nData barang berhasil dihapus!");
            getAll();
        } else {
            System.out.println("\nData barang gagal dihapus!");
        }
    }
}