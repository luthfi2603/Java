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
    
    public static int getCountCustomer() {
        connect();

        int count = 0;

        try {
            statement = connection.createStatement();
            String query = "SELECT COUNT(*) FROM view_customer";

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
    
    public static int getCountDoneTransaksiPulsa() {
        connect();

        int count = 0;

        try {
            statement = connection.createStatement();
            String query = "SELECT COUNT(*) FROM view_done_transaksi_pulsa";

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
    
    public static int getCountDoneTransaksiPaket() {
        connect();

        int count = 0;

        try {
            statement = connection.createStatement();
            String query = "SELECT COUNT(*) FROM view_done_transaksi_paket";

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
    
    public static int getCountNotVerifiedMitra() {
        connect();

        int count = 0;

        try {
            statement = connection.createStatement();
            String query = "SELECT COUNT(*) FROM view_mitra_nonverifikasi";

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
    
    public static int getCountPendingTransaksiSaldo() {
        connect();

        int count = 0;

        try {
            statement = connection.createStatement();
            String query = "SELECT COUNT(*) FROM view_pending_transaksi_saldo";

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

    public static DefaultTableModel getPulsaKuotaCustomer() {
        connect();

        String[] dataHeader = {"ID Pulsa Kuota", "ID Customer", "Nama Customer", "No. Hp", "Pulsa", "Kuota"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_pulsa_kuota_customer";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_pulsa_kuota_customer"), result.getInt("id_customer"), result.getString("nama_customer"), result.getString("nomor_hp_customer"), result.getInt("pulsa_customer"), result.getInt("kuota_customer") + " GB"};

                tm.addRow(rowData);
            }

            connection.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getAllPaket() {
        connect();

        String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM paket ORDER BY id_paket DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_paket"), result.getString("nama_paket"), result.getInt("kuota") + " GB", "Rp" + result.getInt("harga_paket"), (result.getString("status_aktif").toString().equalsIgnoreCase("1")) ? "Aktif" : "Tidak Aktif"};

                tm.addRow(rowData);
            }

            connection.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getPendingTransaksiSaldo() {
        connect();

        String[] dataHeader = {"ID Transaksi Saldo", "Nama Mitra", "Jumlah Saldo", "Waktu", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_pending_transaksi_saldo ORDER BY waktu_transaksi DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_transaksi_saldo"), result.getString("nama_mitra"), result.getInt("jumlah_saldo"), result.getString("waktu_transaksi"), result.getString("status_transaksi")};

                tm.addRow(rowData);
            }

            connection.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getDoneTransaksiSaldo() {
        connect();

        String[] dataHeader = {"ID Transaksi Saldo", "Nama Mitra", "Jumlah Saldo", "Waktu", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_done_transaksi_saldo ORDER BY waktu_transaksi DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_transaksi_saldo"), result.getString("nama_mitra"), result.getInt("jumlah_saldo"), result.getString("waktu_transaksi"), result.getString("status_transaksi")};

                tm.addRow(rowData);
            }

            connection.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }
    
    public static DefaultTableModel getNotVerifiedMitra() {
        connect();

        String[] dataHeader = {"ID Mitra", "Nama", "Email"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_mitra_nonverifikasi";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = { result.getInt("id_mitra"), result.getString("nama_mitra"), result.getString("email_mitra") };

                tm.addRow(rowData);
            }

            connection.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }
    
    public static DefaultTableModel getAllTransaksiPulsa() {
        connect();

        String[] dataHeader = {"ID Transaksi Pulsa", "Customer", "No HP", "Pulsa", "Mitra", "Waktu", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_all_transaksi_pulsa ORDER BY waktu_transaksi DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_transaksi_pulsa"), result.getString("nama_customer"), result.getString("nomor_hp_customer"), result.getInt("jumlah_pulsa"), result.getString("nama_mitra"), result.getString("waktu_transaksi"), result.getString("status_transaksi")};

                tm.addRow(rowData);
            }

            connection.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }
    
    public static DefaultTableModel getAllTransaksiPaket() {
        connect();

        String[] dataHeader = {"ID Transaksi Paket", "Customer", "No HP", "Paket", "Kuota", "Harga", "Waktu", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_all_transaksi_paket ORDER BY waktu_transaksi DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_transaksi_paket"), result.getString("nama_customer"), result.getString("nomor_hp_customer"), result.getString("nama_paket"), result.getInt("kuota") + " GB", "Rp" + result.getInt("harga_paket"), result.getString("waktu_transaksi"), result.getString("status_transaksi")};

                tm.addRow(rowData);
            }

            connection.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getPaketAktif() {
        connect();

        String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_paket_aktif ORDER BY id_paket DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_paket"), result.getString("nama_paket"), result.getInt("kuota") + " GB", "Rp" + result.getInt("harga_paket"), "Aktif"};

                tm.addRow(rowData);
            }

            connection.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getPaketNonAktif() {
        connect();

        String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_paket_nonaktif ORDER BY id_paket DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_paket"), result.getString("nama_paket"), result.getInt("kuota") + " GB", "Rp" + result.getInt("harga_paket"), "Tidak Aktif"};

                tm.addRow(rowData);
            }

            connection.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static Object[] getDetailPaket( int idPaket ) {
        connect();

        Object[] rowData = new Object[6];

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM paket WHERE id_paket = " + idPaket;

            result = statement.executeQuery(query);
            
            result.next();
            rowData[0] = result.getInt("id_paket");
            rowData[1] = result.getString("nama_paket");
            rowData[2] = result.getString("deskripsi_paket");
            rowData[3] = result.getInt("kuota");
            rowData[4] = result.getInt("harga_paket");
            rowData[5] = result.getString("status_aktif");
            
            // close statement dan connection
            connection.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return rowData;
    }
}