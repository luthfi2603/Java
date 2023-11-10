package com.config;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class cConfig {
    // ini untuk mendefinisikan koneksi database kita
    // private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbbarang";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // ini untuk instansiasi object dari class yang diimport
    private static Connection connect;
    private static Statement statement;
    private static ResultSet resultData;

    // ini adalah method statid connection
    private static void connection(){
        // method untuk melakukan koneksi ke database
        try {
            // registrasi driver yang akan dipakai
            // Class.forName(JDBC_DRIVER);
            // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // buat koneksi ke database
            connect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public static String getAllData(){
        cConfig.connection();

        // isi nilai default dari variabel data
        String data = "";

        try {
            // buat object statement yang diambil dari koneksi
            statement = connect.createStatement();

            // query select all data from database
            String query = "SELECT idBarang, namaBarang FROM tblbarang";

            // eksekusi query nya
            resultData = statement.executeQuery(query);

            // looping pengisian variabel data
            while(resultData.next()){
                data += "ID Barang : " + resultData.getInt("idBarang") + ", Nama barang : " + resultData.getString("namaBarang") + "\n";
            }

            if(data == ""){
                throw new Exception("Data tidak ditemukan!");
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (Exception e) {
            // tampilkan error kalo ada error
            System.out.println("Error : " + e.getMessage());
        }

        // pengembalian string dari method ini
        return data;
    }

    public static String detailData(int id){
        // memanggil static method connection
        cConfig.connection();
        // ini adalah nilai default yang dikembalikan
        String data = "";

        try {
            // siapin object statement
            statement = connect.createStatement();

            String query = "SELECT * FROM tblbarang WHERE idBarang = " + id;
            resultData = statement.executeQuery(query);

            while(resultData.next()){
                data += "- ID Barang : " + resultData.getInt("idBarang")
                    + "\n- Nama barang : " + resultData.getString("namaBarang")
                    + "\n- Stok barang : " + resultData.getInt("stokBarang")
                    + " buah\n- Harga barang : Rp" + resultData.getInt("hargaBarang");
            }

            if(data == ""){
                throw new Exception("Data tidak ditemukan!");
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (Exception e) {
            // tampilkan error kalo ada error
            System.out.println("Error : " + e.getMessage());
        }

        // pengembalian string dari method ini
        return data;
    }

    public static String cariData(String keyword){
        // memanggil static method connection
        cConfig.connection();
        // ini adalah nilai default yang dikembalikan
        String data = "";

        try {
            // siapin object statement
            statement = connect.createStatement();

            String query = "SELECT * FROM tblbarang WHERE idBarang LIKE '%" + keyword + "%' OR namaBarang LIKE '%" + keyword + "%' OR stokBarang LIKE '%" + keyword + "%' OR hargaBarang LIKE '%" + keyword + "%'";
            resultData = statement.executeQuery(query);

            while(resultData.next()){
                data += "- ID Barang : " + resultData.getInt("idBarang")
                    + "\n- Nama barang : " + resultData.getString("namaBarang")
                    + "\n- Stok barang : " + resultData.getInt("stokBarang")
                    + " buah\n- Harga barang : Rp" + resultData.getInt("hargaBarang");
                data += "\n--------------------------\n";
            }

            if(data == ""){
                throw new Exception("Data tidak ditemukan!");
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (Exception e) {
            // tampilkan error kalo ada error
            System.out.println("Error : " + e.getMessage());
        }

        // pengembalian string dari method ini
        return data;
    }

    public static boolean tambahData(String namaBarang, int stokBarang, int hargaBarang){
        cConfig.connection();
        boolean data = false;

        try {
            statement = connect.createStatement();
            String query = "INSERT INTO tblbarang VALUES (NULL, '" + namaBarang + "', " + stokBarang + ", " + hargaBarang + ")";
            if (statement.execute(query)) {
                data = false;
            } else {
                data = true;
            }

            statement.close();
            connect.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        return data;
    }
    
    public static boolean ubahData(int id, String namaBarang, String stokBarang, String hargaBarang){
        cConfig.connection();
        boolean data = false;

        try {
            statement = connect.createStatement();

            String queryCek = "SELECT * FROM tblbarang WHERE idBarang = " + id,
            namaCek = "";
            int stokCek = 0, hargaCek = 0;

            resultData = statement.executeQuery(queryCek);

            while(resultData.next()){
                namaCek = resultData.getString("namaBarang");
                stokCek = resultData.getInt("stokBarang");
                hargaCek = resultData.getInt("hargaBarang");
            }

            // validasi jika yang diisi di console kosong
            if(!namaBarang.equalsIgnoreCase("")){
                namaCek = namaBarang;
            }
            if(!stokBarang.equalsIgnoreCase("")){
                stokCek = Integer.parseInt(stokBarang);
            }
            if(!hargaBarang.equalsIgnoreCase("")){
                hargaCek = Integer.parseInt(hargaBarang);
            }

            // System.out.println(namaCek + " " + stokCek + " " + hargaCek);

            String query = "UPDATE tblbarang SET namaBarang = '" + namaCek + "', stokBarang = '" + stokCek + "', hargaBarang = '" + hargaCek + "' WHERE idBarang = " + id;


            if (statement.execute(query)) {
                data = false;
            } else {
                data = true;
            }

            statement.close();
            connect.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        return data;
    }
}