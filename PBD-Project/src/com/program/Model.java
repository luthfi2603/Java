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

            statement.close();
            connection.close();
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

            statement.close();
            connection.close();
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

            statement.close();
            connection.close();
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

            statement.close();
            connection.close();
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

            statement.close();
            connection.close();
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

            statement.close();
            connection.close();
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

            statement.close();
            connection.close();
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

            statement.close();
            connection.close();
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

            statement.close();
            connection.close();
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

            statement.close();
            connection.close();
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

            statement.close();
            connection.close();
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

            statement.close();
            connection.close();
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

            statement.close();
            connection.close();
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

            statement.close();
            connection.close();
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

            statement.close();
            connection.close();
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

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static Object[] getDetailPaket(int idPaket) {
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
            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return rowData;
    }

    // semua method untuk logika search
    public static DefaultTableModel getSearchDataSaldoMitra(String keyword) {
        connect();

        String[] dataHeader = {"ID Saldo Mitra", "ID Mitra", "Nama Mitra", "Email Mitra", "Saldo Mitra"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_saldo_mitra WHERE nama_mitra LIKE '%" + keyword + "%' OR email_mitra LIKE '%" + keyword + "%' OR saldo_mitra LIKE '%" + keyword + "%'";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_saldo_mitra"), result.getInt("id_mitra"), result.getString("nama_mitra"), result.getString("email_mitra"), result.getInt("saldo_mitra")};

                tm.addRow(rowData);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getSearchPulsaKuotaCustomer(String keyword) {
        connect();

        String[] dataHeader = {"ID Pulsa Kuota", "ID Customer", "Nama Customer", "No. Hp", "Pulsa", "Kuota"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_pulsa_kuota_customer WHERE nama_customer LIKE '%" + keyword + "%' OR nomor_hp_customer LIKE '%" + keyword + "%' OR pulsa_customer LIKE '%" + keyword + "%' OR kuota_customer LIKE '%" + keyword + "%'";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_pulsa_kuota_customer"), result.getInt("id_customer"), result.getString("nama_customer"), result.getString("nomor_hp_customer"), result.getInt("pulsa_customer"), result.getInt("kuota_customer") + " GB"};

                tm.addRow(rowData);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getSearchPendingTransaksiSaldo(String keyword) {
        connect();

        String[] dataHeader = {"ID Transaksi Saldo", "Nama Mitra", "Jumlah Saldo", "Waktu", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_pending_transaksi_saldo WHERE nama_mitra LIKE '%" + keyword + "%' OR jumlah_saldo LIKE '%" + keyword + "%' OR waktu_transaksi LIKE '%" + keyword + "%' ORDER BY waktu_transaksi DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_transaksi_saldo"), result.getString("nama_mitra"), result.getInt("jumlah_saldo"), result.getString("waktu_transaksi"), result.getString("status_transaksi")};

                tm.addRow(rowData);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getSearchDoneTransaksiSaldo(String keyword) {
        connect();

        String[] dataHeader = {"ID Transaksi Saldo", "Nama Mitra", "Jumlah Saldo", "Waktu", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_done_transaksi_saldo WHERE nama_mitra LIKE '%" + keyword + "%' OR jumlah_saldo LIKE '%" + keyword + "%' OR waktu_transaksi LIKE '%" + keyword + "%' ORDER BY waktu_transaksi DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_transaksi_saldo"), result.getString("nama_mitra"), result.getInt("jumlah_saldo"), result.getString("waktu_transaksi"), result.getString("status_transaksi")};

                tm.addRow(rowData);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getSearchNotVerifiedMitra(String keyword) {
        connect();

        String[] dataHeader = {"ID Mitra", "Nama", "Email"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_mitra_nonverifikasi WHERE nama_mitra LIKE '%" + keyword + "%' OR email_mitra LIKE '%" + keyword + "%'";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = { result.getInt("id_mitra"), result.getString("nama_mitra"), result.getString("email_mitra") };

                tm.addRow(rowData);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getSearchTransaksiPulsa(String keyword) {
        connect();

        String[] dataHeader = {"ID Transaksi Pulsa", "Customer", "No HP", "Pulsa", "Mitra", "Waktu", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_all_transaksi_pulsa WHERE nama_customer LIKE '%" + keyword + "%' OR nomor_hp_customer LIKE '%" + keyword + "%' OR jumlah_pulsa LIKE '%" + keyword + "%' OR nama_mitra LIKE '%" + keyword + "%' OR waktu_transaksi LIKE '%" + keyword + "%' OR status_transaksi LIKE '%" + keyword + "%' ORDER BY waktu_transaksi DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_transaksi_pulsa"), result.getString("nama_customer"), result.getString("nomor_hp_customer"), result.getInt("jumlah_pulsa"), result.getString("nama_mitra"), result.getString("waktu_transaksi"), result.getString("status_transaksi")};

                tm.addRow(rowData);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getSearchTransaksiPaket(String keyword) {
        connect();

        String[] dataHeader = {"ID Transaksi Paket", "Customer", "No HP", "Paket", "Kuota", "Harga", "Waktu", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_all_transaksi_paket WHERE nama_customer LIKE '%" + keyword + "%' OR nomor_hp_customer LIKE '%" + keyword + "%' OR nama_paket LIKE '%" + keyword + "%' OR kuota LIKE '%" + keyword + "%' OR harga_paket LIKE '%" + keyword + "%' OR waktu_transaksi LIKE '%" + keyword + "%' OR status_transaksi LIKE '%" + keyword + "%' ORDER BY waktu_transaksi DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_transaksi_paket"), result.getString("nama_customer"), result.getString("nomor_hp_customer"), result.getString("nama_paket"), result.getInt("kuota") + " GB", "Rp" + result.getInt("harga_paket"), result.getString("waktu_transaksi"), result.getString("status_transaksi")};

                tm.addRow(rowData);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getSearchAllPaket(String keyword) {
        connect();

        String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM paket WHERE nama_paket LIKE '%" + keyword + "%' OR kuota LIKE '%" + keyword + "%' OR harga_paket LIKE '%" + keyword + "%' ORDER BY id_paket DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_paket"), result.getString("nama_paket"), result.getInt("kuota") + " GB", "Rp" + result.getInt("harga_paket"), (result.getString("status_aktif").toString().equalsIgnoreCase("1")) ? "Aktif" : "Tidak Aktif"};

                tm.addRow(rowData);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getSearchPaketAktif(String keyword) {
        connect();

        String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_paket_aktif WHERE nama_paket LIKE '%" + keyword + "%' OR kuota LIKE '%" + keyword + "%' OR harga_paket LIKE '%" + keyword + "%' ORDER BY id_paket DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_paket"), result.getString("nama_paket"), result.getInt("kuota") + " GB", "Rp" + result.getInt("harga_paket"), "Aktif"};

                tm.addRow(rowData);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getSearchPaketNonAktif(String keyword) {
        connect();

        String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_paket_nonaktif WHERE nama_paket LIKE '%" + keyword + "%' OR kuota LIKE '%" + keyword + "%' OR harga_paket LIKE '%" + keyword + "%' ORDER BY id_paket DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_paket"), result.getString("nama_paket"), result.getInt("kuota") + " GB", "Rp" + result.getInt("harga_paket"), "Tidak Aktif"};

                tm.addRow(rowData);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static boolean tambahDataPaket(String namaPaket, String deskripsiPaket, int kuota, int hargaPaket, String statusAktif) {
        connect();
        
        boolean resultState = false;

        try {
            statement = connection.createStatement();

            String query = "INSERT paket VALUES (" + null + ", '" + namaPaket + "', '" + deskripsiPaket + "', " + hargaPaket + ", " + kuota + ", '" + statusAktif + "')";

            if (statement.executeUpdate(query) > 0) {
                resultState = true;
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultState;
    }

    public static boolean ubahDataPaket(int idPaket, String namaPaket, String deskripsiPaket, int kuota, int hargaPaket, String statusAktif) {
        connect();
        
        boolean resultState = false;

        try {
            statement = connection.createStatement();

            String query = "UPDATE paket SET nama_paket = '" + namaPaket + "', deskripsi_paket = '" + deskripsiPaket + "', harga_paket = " + hargaPaket + ", kuota = " + kuota + ", status_aktif = '" + statusAktif + "' WHERE id_paket = " + idPaket;

            if (statement.executeUpdate(query) > 0) {
                resultState = true;
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultState;
    }

    public static Object[] getDetailMitra(int idMitra) {
        connect();

        Object[] rowData = new Object[4];

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_all_mitra WHERE id_mitra = " + idMitra;

            result = statement.executeQuery(query);
            
            result.next();
            rowData[0] = result.getInt("id_mitra");
            rowData[1] = result.getString("nama_mitra");
            rowData[2] = result.getString("email_mitra");
            rowData[3] = result.getString("status_verifikasi");
            
            // close statement dan connection
            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return rowData;
    }

    public static int getDetailSaldoMitra(int idMitra) {
        connect();

        int saldo = 0;

        try {
            statement = connection.createStatement();
            String query = "SELECT saldo_mitra FROM view_saldo_mitra WHERE id_mitra = " + idMitra;

            result = statement.executeQuery(query);
            
            result.next();
            saldo = result.getInt("saldo_mitra");
            
            // close statement dan connection
            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return saldo;
    }

    public static int getCountDoneTransaksiPulsaMitra(int idMitra) {
        connect();

        int count = 0;

        try {
            statement = connection.createStatement();
            String query = "SELECT COUNT(*) FROM view_done_transaksi_pulsa WHERE id_mitra = " + idMitra;

            result = statement.executeQuery(query);

            result.next();
            count = result.getInt(1);

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return count;
    }

    public static int getCountPendingTransaksiPulsa() {
        connect();

        int count = 0;

        try {
            statement = connection.createStatement();
            String query = "SELECT COUNT(*) FROM view_pending_transaksi_pulsa";

            result = statement.executeQuery(query);

            result.next();
            count = result.getInt(1);

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return count;
    }

    public static DefaultTableModel getAllTransaksiSaldoByMitra(int idMitra) {
        connect();

        String[] dataHeader = {"Jumlah Saldo", "Waktu", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_all_transaksi_saldo WHERE id_mitra = " + idMitra + " ORDER BY waktu_transaksi DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("jumlah_saldo"), result.getString("waktu_transaksi"), result.getString("status_transaksi")};

                tm.addRow(rowData);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getPendingTransaksiPulsa() {
        connect();

        String[] dataHeader = {"ID Transaksi Pulsa", "ID Customer", "Nama Customer", "No HP", "Jumlah Pulsa", "Waktu", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_pending_transaksi_pulsa ORDER BY waktu_transaksi DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("id_transaksi_pulsa"), result.getInt("id_customer"), result.getString("nama_customer"), result.getString("nomor_hp_customer"), result.getInt("jumlah_pulsa"), result.getString("waktu_transaksi"), result.getString("status_transaksi")};

                tm.addRow(rowData);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getDoneTransaksiPulsaByMitra(int idMitra) {
        connect();

        String[] dataHeader = {"Nama Customer", "No HP", "Jumlah Pulsa", "Waktu"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_done_transaksi_pulsa WHERE id_mitra = " + idMitra + " ORDER BY waktu_transaksi DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getString("nama_customer"), result.getString("nomor_hp_customer"), result.getInt("jumlah_pulsa"),result.getString("waktu_transaksi")};

                tm.addRow(rowData);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static Object[] getDetailCustomer(int idCustomer) {
        connect();

        Object[] rowData = new Object[4];

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_customer WHERE id_customer = " + idCustomer;

            result = statement.executeQuery(query);
            
            result.next();
            rowData[0] = result.getInt("id_customer");
            rowData[1] = result.getString("nama_customer");
            rowData[2] = result.getString("nomor_hp_customer");
            rowData[3] = result.getString("email_customer");
            
            // close statement dan connection
            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return rowData;
    }

    public static Object[] getDetailPulsaKuotaCustomer(int idCustomer) {
        connect();

        Object[] rowData = new Object[2];

        try {
            statement = connection.createStatement();
            String query = "SELECT pulsa_customer, kuota_customer FROM view_pulsa_kuota_customer WHERE id_customer = " + idCustomer;

            result = statement.executeQuery(query);
            
            result.next();
            rowData[0] = result.getInt("pulsa_customer");
            rowData[1] = result.getString("kuota_customer");
            
            // close statement dan connection
            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return rowData;
    }

    public static DefaultTableModel getAllTransaksiPulsaByCustomer(int idCustomer) {
        connect();

        String[] dataHeader = {"Jumlah Pulsa", "Mitra", "Waktu", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_all_transaksi_pulsa WHERE id_customer = " + idCustomer + " ORDER BY waktu_transaksi DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getInt("jumlah_pulsa"), result.getString("nama_mitra"), result.getString("waktu_transaksi"), result.getString("status_transaksi")};

                tm.addRow(rowData);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static DefaultTableModel getAllTransaksiPaketByCustomer(int idCustomer) {
        connect();

        String[] dataHeader = {"Nama Paket", "Kuota", "Harga", "Waktu Transaksi", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM view_all_transaksi_paket WHERE id_customer = " + idCustomer + " ORDER BY waktu_transaksi DESC";

            result = statement.executeQuery(query);

            while (result.next()) {
                Object[] rowData = {result.getString("nama_paket"), result.getInt("kuota") + " GB", "Rp" + result.getInt("harga_paket"), result.getString("waktu_transaksi"), result.getString("status_transaksi")};

                tm.addRow(rowData);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tm;
    }

    public static boolean tambahDataTransaksiPulsa(int idCustomer, int jumlahPulsa) {
        connect();
        
        boolean resultState = false;

        try {
            statement = connection.createStatement();

            String query = "INSERT INTO transaksi_pulsa VALUES (" + null + ", " + idCustomer + ", " + jumlahPulsa + ", 3, " + null + ", 'diproses', '1')";

            if (statement.executeUpdate(query) > 0) {
                resultState = true;
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultState;
    }

    public static int getCountCustomerByEmail(String email) {
        connect();

        int count = 0;

        try {
            statement = connection.createStatement();
            String query = "SELECT COUNT(*) FROM customer WHERE email_customer = '" + email + "'";

            result = statement.executeQuery(query);

            result.next();
            count = result.getInt(1);

            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return count;
    }

    public static boolean ubahProfileCustomer(int idCustomer, String namaCustomer, String emailCustomer) {
        connect();
        
        boolean resultState = false;

        try {
            statement = connection.createStatement();

            String query = "UPDATE customer SET nama_customer = '" + namaCustomer + "', email_customer = '" + emailCustomer + "' WHERE id_customer = " + idCustomer;

            if (statement.executeUpdate(query) > 0) {
                resultState = true;
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultState;
    }

    public static boolean isiPulsaCustomer(int idTransaksiPulsa, int idMitra) {
        connect();
        
        boolean resultState = false;

        try {
            statement = connection.createStatement();

            String query = "UPDATE transaksi_pulsa SET id_mitra = " + idMitra + ", status_transaksi = 'selesai' WHERE id_transaksi_pulsa = " + idTransaksiPulsa;

            if (statement.executeUpdate(query) > 0) {
                resultState = true;
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultState;
    }

    public static boolean requestSaldoMitra(int idMitra) {
        connect();
        
        boolean resultState = false;

        try {
            statement = connection.createStatement();

            String query = "INSERT INTO transaksi_saldo VALUES (" + null + ", " + idMitra + ", 200000, " + null + ", 'diproses', '1')";

            if (statement.executeUpdate(query) > 0) {
                resultState = true;
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultState;
    }
}