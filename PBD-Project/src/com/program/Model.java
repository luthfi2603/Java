package com.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Model {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/penjualan_pulsa";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connection;
    private static Statement statement;
    private static ResultSet result;

    private static void connect() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public static DefaultTableModel getAllDataSaldoMitra() {
        connect();

        String[] dataHeader = {"ID Saldo Mitra", "ID Mitra", "Nama Mitra", "Email Mitra", "Saldo Mitra"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_saldo_mitra";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_saldo_mitra"), result.getInt("id_mitra"), result.getString("nama_mitra"), result.getString("email_mitra"), result.getInt("saldo_mitra")};

                tm.addRow(rowData);
            }

            connection.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static int getCountVerifiedMitra() {
        connect();

        int count = 0;

        try {
            statement = connection.createStatement();
            String query = "SELECT COUNT(*) FROM view_mitra_terverifikasi";

            result = statement.executeQuery(query);

            result.next();
            count = result.getInt(1);

            connection.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return count;
    }
}