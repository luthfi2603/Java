package com.config;
import java.sql.DriverManager;
import java.sql.Connection;

public class cConfig {
    // ini untuk mendefinisikan koneksi database kita
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbbarang";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // ini untuk instansiasi object dari class DriverManager dan Connection
    private static Connection connect;

    // ini adalah method statid connection
    public static void connection(){
        // method untuk melakukan koneksi ke database
        try {
            // registrasi driver yang akan dipakai
            Class.forName(JDBC_DRIVER);

            // buat koneksi ke database
            connect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
