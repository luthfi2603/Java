package com.program;

import java.sql.Connection;
import java.sql.DriverManager;

public class Model {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/penjualan_pulsa";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    public static void connect() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}