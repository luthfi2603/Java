package com.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.partials.*;
import com.program.Controller;
import com.program.Model;
import com.templates.cDashboardFrame;

class Filter {
    static String filter = "semua";
    static String keyword = "";
  
    static DefaultTableModel search() {
        DefaultTableModel tm = new DefaultTableModel();
    
        if (filter.equalsIgnoreCase("semua")) {
            tm = Model.getSearchAllPaket(keyword);
        } else if (filter.equalsIgnoreCase("aktif")) {
            tm = Model.getSearchPaketAktif(keyword);
        } else if (filter.equalsIgnoreCase("tidak aktif")) {
            tm = Model.getSearchPaketNonAktif(keyword);
        }
    
        return tm;
    }
}

public class DashboardAdminView extends cDashboardFrame {
    boolean statusLogin = false;

    // sidebar menu
    private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
    private cSidebarMenu menuDataMitra = new cSidebarMenu("Data Mitra", 70 + 50);
    private cSidebarMenu menuDataCustomer = new cSidebarMenu("Data Customer", 70 + (50 * 2));
    private cSidebarMenu menuDataPaket = new cSidebarMenu("Data Paket", 70 + (50 * 3));
    private cSidebarMenu menuRequestSaldo = new cSidebarMenu("Request Saldo", 70 + (50 * 4));
    private cSidebarMenu menuCalonMitra = new cSidebarMenu("Calon Mitra", 70 + (50 * 5));
    private cSidebarMenu menuTransaksiPulsa = new cSidebarMenu("Transaksi Pulsa", 70 + (50 * 6));
    private cSidebarMenu menuTransaksiPaket = new cSidebarMenu("Transaksi Paket", 70 + (50 * 7));
    private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 70 + (50 * 8));

    // komponen di halaman beranda
    private cInfoLabel labelJmlDataMitraBeranda = new cInfoLabel("Jumlah Data Mitra Terverifikasi", 25, 20);
    private cBigFont valueJmlDataMitraBeranda = new cBigFont("0", 25, 60);
    private cInfoLabel labelJmlDataCustomerBeranda = new cInfoLabel("Jumlah Data Customer Aktif", 25, 150);
    private cBigFont valueJmlDataCustomerBeranda = new cBigFont("0", 25, 190);
    private cInfoLabel labelJmlTransaksiPulsaBeranda = new cInfoLabel("Jumlah Transaksi Pulsa Berhasil", 25, 280);
    private cBigFont valueJmlTransaksiPulsaBeranda = new cBigFont("0", 25, 320);
    private cInfoLabel labelJmlTransaksiPaketBeranda = new cInfoLabel("Jumlah Transaksi Paket Berhasil", 495, 20);
    private cBigFont valueJmlTransaksiPaketBeranda = new cBigFont("0", 495, 60);
    private cInfoLabel labelJmlCalonMitraBeranda = new cInfoLabel("Jumlah Data Calon Mitra", 495, 150);
    private cBigFont valueJmlCalonMitraBeranda = new cBigFont("0", 495, 190);
    private cInfoLabel labelJmlRequestSaldoBeranda = new cInfoLabel("Jumlah Request Saldo Pending", 495, 280);
    private cBigFont valueJmlRequestSaldoBeranda = new cBigFont("0", 495, 320);

    // komponen di halaman data mitra
    private cInfoLabel labelDataMitra = new cInfoLabel("Data Mitra Terverifikasi", 25, 20);
    private cFormLabel labelCariDataMitra = new cFormLabel("Cari", 25, 75, 55, false);
    private cTextField txtCariDataMitra = new cTextField(83, 70, 350, false);
    // private DefaultTableModel dmDataMitra;
    private cTable tblDataDataMitra;
    private cScrollPane spDataDataMitra;
    private cRedButton btnHapusDataMitra = new cRedButton("Hapus", 25, 446, 110);
    
    // komponen di halaman data data customer
    private cInfoLabel labelDataCustomer = new cInfoLabel("Data Customer Aktif", 25, 20);
    private cFormLabel labelCariDataCustomer = new cFormLabel("Cari", 25, 75, 55, false);
    private cTextField txtCariDataCustomer = new cTextField(83, 70, 350, false);
    // private DefaultTableModel dmDataCustomer;
    private cTable tblDataDataCustomer;
    private cScrollPane spDataDataCustomer;
    private cRedButton btnHapusDataCustomer = new cRedButton("Hapus", 25, 446, 110);

    // komponen di halaman data paket
    private cInfoLabel labelDataPaket = new cInfoLabel("Data Request Request Saldo Pending", 25, 20);
    private cFormLabel labelCariDataPaket = new cFormLabel("Cari", 25, 75, 55, false);
    private cTextField txtCariDataPaket = new cTextField(83, 70, 317, false);
    private cBlueButton btnTambahDataPaket = new cBlueButton("Tambah Paket", 418, 70, 162);
    private cRadioButton rdSemuaDataPaket = new cRadioButton("Semua", "all", 25, 115, 97);
    private cRadioButton rdAktifDataPaket = new cRadioButton("Aktif", "active", 132, 115, 72);
    private cRadioButton rdTidakAktifDataPaket = new cRadioButton("Tidak Aktif", "nonactive", 214, 115, 112);
    private ButtonGroup groupActionDataPaket = new ButtonGroup();
    // private DefaultTableModel dmDataPaket;
    private cTable tblDataDataPaket;
    private cScrollPane spDataDataPaket;
    private cGreenButton btnUbahDataPaket = new cGreenButton("Ubah", 25, 410, 92);
    private cInfoLabel labelDeskripsiPaketDataPaket = new cInfoLabel("Deskripsi Paket", 600, 145);
    private cTextArea valueDeskripsiPaketDataPaket = new cTextArea("", 600, 186, false);
    
    // komponen di halaman tambah data paket
    private cInfoLabel labelTambahDataPaket = new cInfoLabel("Isi form data paket dengan lengkap", 25, 20);
    private cFormLabel labelNamaPaketTambahDataPaket = new cFormLabel("Nama Paket", 25, 65, 550, false);
    private cTextField txtNamaPaketTambahDataPaket = new cTextField(25, 90, 550, false);
    private cErrorLabel errorNamaPaketTambahDataPaket = new cErrorLabel("Nama paket tidak boleh kosong!", 25, 125, 550, false);
    private cFormLabel labelKuotaPaketTambahDataPaket = new cFormLabel("Kuota Paket", 25, 150, 550, false);
    private cTextField txtKuotaPaketTambahDataPaket = new cTextField(25, 175, 550, false);
    private cErrorLabel errorKuotaPaketTambahDataPaket = new cErrorLabel("Kuota paket tidak boleh kosong!", 25, 210, 550, false);
    private cFormLabel labelHargaPaketTambahDataPaket = new cFormLabel("Harga Paket", 25, 235, 550, false);
    private cTextField txtHargaPaketTambahDataPaket = new cTextField(25, 260, 550, false);
    private cErrorLabel errorHargaPaketTambahDataPaket = new cErrorLabel("Harga paket tidak boleh kosong!", 25, 295, 550, false);
    private cCheckBox chAktifTambahDataPaket = new cCheckBox("Aktifkan", "1", 25, 316, 100);
    private cBlueButton btnTambahPaketTambahDataPaket = new cBlueButton("Tambah", 25, 348, 110);
    private cRedButton btnBatalTambahDataPaket = new cRedButton("Batal", 155, 348, 110);
    private cFormLabel labelDeskripsiPaketTambahDataPaket = new cFormLabel("Deskripsi Paket", 595, 65, 370, false);
    private cTextArea txtDeskripsiPaketTambahDataPaket = new cTextArea(true);
    private cScrollPane spTxtDeskripsiPaketTambahDataPaket = new cScrollPane(txtDeskripsiPaketTambahDataPaket, 595, 90, 370, 205);
    private cErrorLabel errorDeskripsiPaketTambahDataPaket = new cErrorLabel("Deskripsi paket tidak boleh kosong!", 595, 295, 370, false);

    // komponen di halaman ubah data paket
    private cInfoLabel labelUbahDataPaket = new cInfoLabel("Isi form data paket dengan lengkap", 25, 20);
    private cFormLabel labelNamaPaketUbahDataPaket = new cFormLabel("Nama Paket", 25, 65, 550, false);
    private cTextField txtNamaPaketUbahDataPaket = new cTextField(25, 90, 550, false);
    private cErrorLabel errorNamaPaketUbahDataPaket = new cErrorLabel("Nama paket tidak boleh kosong!", 25, 125, 550, false);
    private cFormLabel labelKuotaPaketUbahDataPaket = new cFormLabel("Kuota Paket", 25, 150, 550, false);
    private cTextField txtKuotaPaketUbahDataPaket = new cTextField(25, 175, 550, false);
    private cErrorLabel errorKuotaPaketUbahDataPaket = new cErrorLabel("Kuota paket tidak boleh kosong!", 25, 210, 550, false);
    private cFormLabel labelHargaPaketUbahDataPaket = new cFormLabel("Harga Paket", 25, 235, 550, false);
    private cTextField txtHargaPaketUbahDataPaket = new cTextField(25, 260, 550, false);
    private cErrorLabel errorHargaPaketUbahDataPaket = new cErrorLabel("Harga paket tidak boleh kosong!", 25, 295, 550, false);
    private cCheckBox chAktifUbahDataPaket = new cCheckBox("Aktifkan", "1", 25, 316, 100);
    private cBlueButton btnUbahPaketUbahDataPaket = new cBlueButton("Ubah", 25, 348, 110);
    private cRedButton btnBatalUbahDataPaket = new cRedButton("Batal", 155, 348, 110);
    private cFormLabel labelDeskripsiPaketUbahDataPaket = new cFormLabel("Deskripsi Paket", 595, 65, 370, false);
    private cTextArea txtDeskripsiPaketUbahDataPaket = new cTextArea(true);
    private cScrollPane spTxtDeskripsiPaketUbahDataPaket = new cScrollPane(txtDeskripsiPaketUbahDataPaket, 595, 90, 370, 205);
    private cErrorLabel errorDeskripsiPaketUbahDataPaket = new cErrorLabel("Deskripsi paket tidak boleh kosong!", 595, 295, 370, false);
    
    // komponen di halaman request saldo
    private cInfoLabel labelRequestSaldo = new cInfoLabel("Data Request Request Saldo Pending", 25, 20);
    private cFormLabel labelCariRequestSaldo = new cFormLabel("Cari", 25, 75, 55, false);
    private cTextField txtCariRequestSaldo = new cTextField(83, 70, 317, false);
    private cBlueButton btnLihatBerhasilRequestSaldo = new cBlueButton("Lihat Berhasil", 418, 70, 162);
    // private DefaultTableModel dmRequestSaldo;
    private cTable tblDataRequestSaldo;
    private cScrollPane spDataRequestSaldo;
    private cGreenButton btnApproveRequestSaldo = new cGreenButton("Setujui", 25, 446, 110);
    
    // komponen di halaman request saldo done
    private cInfoLabel labelRequestSaldoDone = new cInfoLabel("Data Request Request Saldo Berhasil", 25, 20);
    private cFormLabel labelCariRequestSaldoDone = new cFormLabel("Cari", 25, 75, 55, false);
    private cTextField txtCariRequestSaldoDone = new cTextField(83, 70, 317, false);
    private cBlueButton btnLihatPendingRequestSaldoDone = new cBlueButton("Lihat Pending", 418, 70, 162);
    // private DefaultTableModel dmRequestSaldoDone;
    private cTable tblDataRequestSaldoDone;
    private cScrollPane spDataRequestSaldoDone;
    
    // komponen di halaman calon mitra
    private cInfoLabel labelCalonMitra = new cInfoLabel("Data Request Calon Mitra", 25, 20);
    private cFormLabel labelCariCalonMitra = new cFormLabel("Cari", 25, 75, 55, false);
    private cTextField txtCariCalonMitra = new cTextField(83, 70, 350, false);
    // private DefaultTableModel dmCalonMitra;
    private cTable tblDataCalonMitra;
    private cScrollPane spDataCalonMitra;
    private cGreenButton btnApproveCalonMitra = new cGreenButton("Setujui", 25, 446, 110);
    
    // komponen di halaman transaksi pulsa
    private cInfoLabel labelTransaksiPulsa = new cInfoLabel("Semua Data Transaksi Pulsa", 25, 20);
    private cFormLabel labelCariTransaksiPulsa = new cFormLabel("Cari", 25, 75, 55, false);
    private cTextField txtCariTransaksiPulsa = new cTextField(83, 70, 350, false);
    // private DefaultTableModel dmTransaksiPulsa;
    private cTable tblDataTransaksiPulsa;
    private cScrollPane spDataTransaksiPulsa;
    
    // komponen di halaman transaksi paket
    private cInfoLabel labelTransaksiPaket = new cInfoLabel("Semua Data Transaksi Paket", 25, 20);
    private cFormLabel labelCariTransaksiPaket = new cFormLabel("Cari", 25, 75, 55, false);
    private cTextField txtCariTransaksiPaket = new cTextField(83, 70, 350, false);
    // private DefaultTableModel dmTransaksiPaket;
    private cTable tblDataTransaksiPaket;
    private cScrollPane spDataTransaksiPaket;

    // method untuk menonaktifkan semua sidebar
    private void resetSidebar(){
        try {
            setVisible(false);

            menuBeranda.setBackground(cColors.WHITE);
            menuBeranda.setForeground(cColors.GRAY);
            menuBeranda.setSidebarNonAktif();
            
            menuDataMitra.setBackground(cColors.WHITE);
            menuDataMitra.setForeground(cColors.GRAY);
            menuDataMitra.setSidebarNonAktif();
            
            menuDataCustomer.setBackground(cColors.WHITE);
            menuDataCustomer.setForeground(cColors.GRAY);
            menuDataCustomer.setSidebarNonAktif();
            
            menuDataPaket.setBackground(cColors.WHITE);
            menuDataPaket.setForeground(cColors.GRAY);
            menuDataPaket.setSidebarNonAktif();
            
            menuRequestSaldo.setBackground(cColors.WHITE);
            menuRequestSaldo.setForeground(cColors.GRAY);
            menuRequestSaldo.setSidebarNonAktif();
            
            menuCalonMitra.setBackground(cColors.WHITE);
            menuCalonMitra.setForeground(cColors.GRAY);
            menuCalonMitra.setSidebarNonAktif();
            
            menuTransaksiPulsa.setBackground(cColors.WHITE);
            menuTransaksiPulsa.setForeground(cColors.GRAY);
            menuTransaksiPulsa.setSidebarNonAktif();
            
            menuTransaksiPaket.setBackground(cColors.WHITE);
            menuTransaksiPaket.setForeground(cColors.GRAY);
            menuTransaksiPaket.setSidebarNonAktif();

            menuLogout.setSidebarNonAktif();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // method untuk menghilangkan semua komponen yang ada pada halaman sebelumnya
    private void refreshContent(){
        try {
            content.removeAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DashboardAdminView(boolean statusLogin) {
        super("Dashboard Admin");

        this.statusLogin = statusLogin;

        roleText.setText("Admin");

        menuBeranda.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsBeranda();
            }
        });

        menuDataMitra.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsDataMitra();
            }
        });
        
        menuDataCustomer.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsDataCustomer();
            }
        });
        
        menuDataPaket.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsDataPaket();
            }
        });
        
        menuRequestSaldo.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsRequestSaldo();
            }
        });
        
        menuCalonMitra.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsCalonMitra();
            }
        });
        
        menuTransaksiPulsa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsTransaksiPulsa();
            }
        });
        
        menuTransaksiPaket.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsTransaksiPaket();
            }
        });
        
        menuLogout.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsLogout();
            }
        });

        sidebar.add(menuBeranda);
        sidebar.add(menuDataMitra);
        sidebar.add(menuDataCustomer);
        sidebar.add(menuDataPaket);
        sidebar.add(menuRequestSaldo);
        sidebar.add(menuCalonMitra);
        sidebar.add(menuTransaksiPulsa);
        sidebar.add(menuTransaksiPaket);
        sidebar.add(menuLogout);

        initsBeranda();
    }

    private void initsBeranda(){
        resetSidebar();
        menuBeranda.setBackground(cColors.BLUE);
        menuBeranda.setForeground(cColors.WHITE);
        refreshContent();
        menuBeranda.setSidebarAktif();
        menuTitle.setText("Beranda");

        valueJmlDataMitraBeranda.setText(String.valueOf(Model.getCountVerifiedMitra()));
        valueJmlDataCustomerBeranda.setText(String.valueOf(Model.getCountCustomer()));
        valueJmlTransaksiPulsaBeranda.setText(String.valueOf(Model.getCountDoneTransaksiPulsa()));
        valueJmlTransaksiPaketBeranda.setText(String.valueOf(Model.getCountDoneTransaksiPaket()));
        valueJmlCalonMitraBeranda.setText(String.valueOf(Model.getCountNotVerifiedMitra()));
        valueJmlRequestSaldoBeranda.setText(String.valueOf(Model.getCountPendingTransaksiSaldo()));

        content.add(labelJmlDataMitraBeranda);
        content.add(valueJmlDataMitraBeranda);
        content.add(labelJmlDataCustomerBeranda);
        content.add(valueJmlDataCustomerBeranda);
        content.add(labelJmlTransaksiPulsaBeranda);
        content.add(valueJmlTransaksiPulsaBeranda);
        content.add(labelJmlTransaksiPaketBeranda);
        content.add(valueJmlTransaksiPaketBeranda);
        content.add(labelJmlCalonMitraBeranda);
        content.add(valueJmlCalonMitraBeranda);
        content.add(labelJmlRequestSaldoBeranda);
        content.add(valueJmlRequestSaldoBeranda);
        setVisible(true);
    }
  
    private void initsDataMitra() {
        resetSidebar();
        menuDataMitra.setBackground(cColors.BLUE);
        menuDataMitra.setForeground(cColors.WHITE);
        refreshContent();
        menuDataMitra.setSidebarAktif();
        menuTitle.setText("Data Mitra");

        txtCariDataMitra.setText(null);

        /* String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
        String[][] dataUser = {
            {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
            {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
            {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
            {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
            {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
        };

        dmDataMitra = new DefaultTableModel(dataUser, dataUserHeader); */

        tblDataDataMitra = new cTable(Model.getAllDataSaldoMitra());

        tblDataDataMitra.getColumnModel().getColumn(0).setWidth(0);
        tblDataDataMitra.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataMitra.getColumnModel().getColumn(0).setMaxWidth(0);
        
        tblDataDataMitra.getColumnModel().getColumn(1).setWidth(0);
        tblDataDataMitra.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataDataMitra.getColumnModel().getColumn(1).setMaxWidth(0);

        spDataDataMitra = new cScrollPane(tblDataDataMitra, 25, 120, 555, 310);

        txtCariDataMitra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String keyword = txtCariDataMitra.getText();
                
                tblDataDataMitra.setModel(Model.getSearchDataSaldoMitra(keyword));

                tblDataDataMitra.getColumnModel().getColumn(0).setWidth(0);
                tblDataDataMitra.getColumnModel().getColumn(0).setMinWidth(0);
                tblDataDataMitra.getColumnModel().getColumn(0).setMaxWidth(0);
                
                tblDataDataMitra.getColumnModel().getColumn(1).setWidth(0);
                tblDataDataMitra.getColumnModel().getColumn(1).setMinWidth(0);
                tblDataDataMitra.getColumnModel().getColumn(1).setMaxWidth(0);
            }
        });

        if (btnHapusDataMitra.getActionListeners().length == 0) {
            btnHapusDataMitra.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int selectedIndex = tblDataDataMitra.getSelectedRow();

                    if (selectedIndex == -1) {
                        JOptionPane.showMessageDialog(DashboardAdminView.this, "Silahkan pilih data terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int idMitra = Integer.parseInt(tblDataDataMitra.getValueAt(selectedIndex, 1).toString());

                        if (Model.hapusMitra(idMitra)) {
                            JOptionPane.showMessageDialog(DashboardAdminView.this, "Mitra berhasil dihapus", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

                            initsDataMitra();
                        } else {
                            JOptionPane.showMessageDialog(DashboardAdminView.this, "Mitra gagal dihapus", "Gagal", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });
        }

        content.add(labelDataMitra);
        content.add(labelCariDataMitra);
        content.add(txtCariDataMitra);
        content.add(spDataDataMitra);
        content.add(btnHapusDataMitra);
        setVisible(true);
    }
  
    private void initsDataCustomer() {
        resetSidebar();
        menuDataCustomer.setBackground(cColors.BLUE);
        menuDataCustomer.setForeground(cColors.WHITE);
        refreshContent();
        menuDataCustomer.setSidebarAktif();
        menuTitle.setText("Data Customer");

        txtCariDataCustomer.setText(null);

        /* String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
        String[][] dataUser = {
            {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
            {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
            {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
            {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
            {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
        };

        dmDataCustomer = new DefaultTableModel(dataUser, dataUserHeader); */

        tblDataDataCustomer = new cTable(Model.getPulsaKuotaCustomer());

        tblDataDataCustomer.getColumnModel().getColumn(0).setWidth(0);
        tblDataDataCustomer.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataCustomer.getColumnModel().getColumn(0).setMaxWidth(0);

        tblDataDataCustomer.getColumnModel().getColumn(1).setWidth(0);
        tblDataDataCustomer.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataDataCustomer.getColumnModel().getColumn(1).setMaxWidth(0);
    
        spDataDataCustomer = new cScrollPane(tblDataDataCustomer, 25, 120, 925, 310);

        txtCariDataCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String keyword = txtCariDataCustomer.getText();
                
                tblDataDataCustomer.setModel(Model.getSearchPulsaKuotaCustomer(keyword));

                tblDataDataCustomer.getColumnModel().getColumn(0).setWidth(0);
                tblDataDataCustomer.getColumnModel().getColumn(0).setMinWidth(0);
                tblDataDataCustomer.getColumnModel().getColumn(0).setMaxWidth(0);
                
                tblDataDataCustomer.getColumnModel().getColumn(1).setWidth(0);
                tblDataDataCustomer.getColumnModel().getColumn(1).setMinWidth(0);
                tblDataDataCustomer.getColumnModel().getColumn(1).setMaxWidth(0);
            }
        });

        if (btnHapusDataCustomer.getActionListeners().length == 0) {
            btnHapusDataCustomer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int selectedIndex = tblDataDataCustomer.getSelectedRow();

                    if (selectedIndex == -1) {
                        JOptionPane.showMessageDialog(DashboardAdminView.this, "Silahkan pilih data terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int idCustomer = Integer.parseInt(tblDataDataCustomer.getValueAt(selectedIndex, 1).toString());

                        if (Model.hapusCustomer(idCustomer)) {
                            JOptionPane.showMessageDialog(DashboardAdminView.this, "Customer berhasil dihapus", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

                            initsDataCustomer();
                        } else {
                            JOptionPane.showMessageDialog(DashboardAdminView.this, "Customer gagal dihapus", "Gagal", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });
        }

        content.add(labelDataCustomer);
        content.add(labelCariDataCustomer);
        content.add(txtCariDataCustomer);
        content.add(spDataDataCustomer);
        content.add(btnHapusDataCustomer);
        setVisible(true);
    }
  
    private void initsDataPaket() {
        resetSidebar();
        menuDataPaket.setBackground(cColors.BLUE);
        menuDataPaket.setForeground(cColors.WHITE);
        refreshContent();
        menuDataPaket.setSidebarAktif();
        menuTitle.setText("Data Paket");

        valueDeskripsiPaketDataPaket.setText(null);
        txtCariDataPaket.setText(null);

        /* String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
        String[][] dataUser = {
            {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
            {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
            {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
            {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
            {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
        };
        dmDataPaket = new DefaultTableModel(dataUser, dataUserHeader); */
        tblDataDataPaket = new cTable(Model.getAllPaket());

        tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);

        tblDataDataPaket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int selectedIndex = tblDataDataPaket.getSelectedRow();
                int idPaket = Integer.parseInt(tblDataDataPaket.getValueAt(selectedIndex, 0).toString());

                String textDeskripsiPaket = Model.getDetailPaket(idPaket)[2].toString();

                valueDeskripsiPaketDataPaket.setText(textDeskripsiPaket);
            }
        });

        spDataDataPaket = new cScrollPane(tblDataDataPaket, 25, 145, 555, 250);
        rdSemuaDataPaket.setSelected(true);
        groupActionDataPaket.add(rdSemuaDataPaket);
        groupActionDataPaket.add(rdAktifDataPaket);
        groupActionDataPaket.add(rdTidakAktifDataPaket);

        rdSemuaDataPaket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Filter.filter = "semua";
                tblDataDataPaket.setModel(Filter.search());
                tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
                tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
                tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
                valueDeskripsiPaketDataPaket.setText(null);
            }
        });

        rdAktifDataPaket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Filter.filter = "aktif";
                tblDataDataPaket.setModel(Filter.search());
                tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
                tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
                tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
                valueDeskripsiPaketDataPaket.setText(null);
            }
        });

        rdTidakAktifDataPaket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Filter.filter = "tidak aktif";
                tblDataDataPaket.setModel(Filter.search());
                tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
                tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
                tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
                valueDeskripsiPaketDataPaket.setText(null);
            }
        });

        txtCariDataPaket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Filter.keyword = txtCariDataPaket.getText();
                
                tblDataDataPaket.setModel(Filter.search());

                tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
                tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
                tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
            }
        });
    
        if (btnTambahDataPaket.getActionListeners().length == 0) {
            btnTambahDataPaket.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    initsTambahPaket();
                }
            });
        }
    
        if (btnUbahDataPaket.getActionListeners().length == 0) {
            btnUbahDataPaket.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int selectedIndex = tblDataDataPaket.getSelectedRow();

                    if (selectedIndex == -1) {
                        JOptionPane.showMessageDialog(DashboardAdminView.this, "Silahkan pilih paket terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int idPaket = Integer.parseInt(tblDataDataPaket.getValueAt(selectedIndex, 0).toString());

                        initsUbahPaket(idPaket);
                    }
                }
            });
        }

        content.add(labelDataPaket);
        content.add(labelCariDataPaket);
        content.add(txtCariDataPaket);
        content.add(btnTambahDataPaket);
        content.add(rdSemuaDataPaket);
        content.add(rdAktifDataPaket);
        content.add(rdTidakAktifDataPaket);
        content.add(spDataDataPaket);
        content.add(btnUbahDataPaket);
        content.add(labelDeskripsiPaketDataPaket);
        content.add(valueDeskripsiPaketDataPaket);
        setVisible(true);
    }
  
    private void initsTambahPaket() {
        // setVisible(false);
        resetSidebar();
        menuDataPaket.setBackground(cColors.BLUE);
        menuDataPaket.setForeground(cColors.WHITE);
        refreshContent();
        menuDataPaket.setSidebarAktif();
        menuTitle.setText("Tambah Data Paket");

        txtNamaPaketTambahDataPaket.setText(null);
        txtKuotaPaketTambahDataPaket.setText(null);
        txtHargaPaketTambahDataPaket.setText(null);
        txtDeskripsiPaketTambahDataPaket.setText(null);
        chAktifTambahDataPaket.setSelected(false);

        if (btnBatalTambahDataPaket.getActionListeners().length == 0) {
            btnBatalTambahDataPaket.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    initsDataPaket();
                }
            });
        }
        
        if (btnTambahPaketTambahDataPaket.getActionListeners().length == 0) {
            btnTambahPaketTambahDataPaket.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (txtNamaPaketTambahDataPaket.getText().trim().isEmpty() || txtKuotaPaketTambahDataPaket.getText().trim().isEmpty() || txtHargaPaketTambahDataPaket.getText().trim().isEmpty() || txtDeskripsiPaketTambahDataPaket.getText().trim().isEmpty()) {
                        // DashboardAdminView.this.setVisible(false);

                        if (txtNamaPaketTambahDataPaket.getText().trim().isEmpty()) content.add(errorNamaPaketTambahDataPaket);
                        else content.remove(errorNamaPaketTambahDataPaket);
                        
                        if (txtKuotaPaketTambahDataPaket.getText().trim().isEmpty()) content.add(errorKuotaPaketTambahDataPaket);
                        else content.remove(errorKuotaPaketTambahDataPaket);

                        if (txtHargaPaketTambahDataPaket.getText().trim().isEmpty()) content.add(errorHargaPaketTambahDataPaket);
                        else content.remove(errorHargaPaketTambahDataPaket);

                        if (txtDeskripsiPaketTambahDataPaket.getText().trim().isEmpty()) content.add(errorDeskripsiPaketTambahDataPaket);
                        else content.remove(errorDeskripsiPaketTambahDataPaket);

                        // DashboardAdminView.this.setVisible(true);
                        content.revalidate();
                        content.repaint();
                    } else {
                        String nama = txtNamaPaketTambahDataPaket.getText();
                        int harga = Integer.parseInt(txtHargaPaketTambahDataPaket.getText());
                        int kuota = Integer.parseInt(txtKuotaPaketTambahDataPaket.getText());
                        String deskripsi = txtDeskripsiPaketTambahDataPaket.getText();
                        String statusAktif = chAktifTambahDataPaket.isSelected() ? chAktifTambahDataPaket.getActionCommand() : "0";

                        if (Model.tambahDataPaket(nama, deskripsi, kuota, harga, statusAktif)) {
                            JOptionPane.showMessageDialog(DashboardAdminView.this, "Tambah data paket berhasil", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

                            initsDataPaket();
                        } else {
                            JOptionPane.showMessageDialog(DashboardAdminView.this, "Tambah data paket gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });
        }
        
        content.add(labelTambahDataPaket);
        content.add(labelNamaPaketTambahDataPaket);
        content.add(txtNamaPaketTambahDataPaket);
        content.add(labelKuotaPaketTambahDataPaket);
        content.add(txtKuotaPaketTambahDataPaket);
        content.add(labelHargaPaketTambahDataPaket);
        content.add(txtHargaPaketTambahDataPaket);
        content.add(chAktifTambahDataPaket);
        content.add(btnTambahPaketTambahDataPaket);
        content.add(btnBatalTambahDataPaket);
        content.add(labelDeskripsiPaketTambahDataPaket);
        content.add(spTxtDeskripsiPaketTambahDataPaket);
        setVisible(true);
    }

    private void initsUbahPaket(int idPaket) {
        // setVisible(false);
        resetSidebar();
        menuDataPaket.setBackground(cColors.BLUE);
        menuDataPaket.setForeground(cColors.WHITE);
        refreshContent();
        menuDataPaket.setSidebarAktif();
        menuTitle.setText("Ubah Data Paket");

        Object[] detailPaket = Model.getDetailPaket(idPaket);

        txtNamaPaketUbahDataPaket.setText(detailPaket[1].toString());
        txtKuotaPaketUbahDataPaket.setText(detailPaket[3].toString());
        txtHargaPaketUbahDataPaket.setText(detailPaket[4].toString());
        txtDeskripsiPaketUbahDataPaket.setText(detailPaket[2].toString());
        if (detailPaket[5].toString().equalsIgnoreCase("1"))
            chAktifUbahDataPaket.setSelected(true);
        else
            chAktifUbahDataPaket.setSelected(false);

        if (btnBatalUbahDataPaket.getActionListeners().length == 0) {
            btnBatalUbahDataPaket.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    initsDataPaket();
                }
            });
        }

        if (btnUbahPaketUbahDataPaket.getActionListeners().length == 0) {
            btnUbahPaketUbahDataPaket.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (txtNamaPaketUbahDataPaket.getText().trim().isEmpty() || txtKuotaPaketUbahDataPaket.getText().trim().isEmpty() || txtHargaPaketUbahDataPaket.getText().trim().isEmpty() || txtDeskripsiPaketUbahDataPaket.getText().trim().isEmpty()) {
                        // DashboardAdminView.this.setVisible(false);

                        if (txtNamaPaketUbahDataPaket.getText().trim().isEmpty()) content.add(errorNamaPaketUbahDataPaket);
                        else content.remove(errorNamaPaketUbahDataPaket);
                        
                        if (txtKuotaPaketUbahDataPaket.getText().trim().isEmpty()) content.add(errorKuotaPaketUbahDataPaket);
                        else content.remove(errorKuotaPaketUbahDataPaket);

                        if (txtHargaPaketUbahDataPaket.getText().trim().isEmpty()) content.add(errorHargaPaketUbahDataPaket);
                        else content.remove(errorHargaPaketUbahDataPaket);

                        if (txtDeskripsiPaketUbahDataPaket.getText().trim().isEmpty()) content.add(errorDeskripsiPaketUbahDataPaket);
                        else content.remove(errorDeskripsiPaketUbahDataPaket);

                        // DashboardAdminView.this.setVisible(true);
                        content.revalidate();
                        content.repaint();
                    } else {
                        String nama = txtNamaPaketUbahDataPaket.getText();
                        int harga = Integer.parseInt(txtHargaPaketUbahDataPaket.getText());
                        int kuota = Integer.parseInt(txtKuotaPaketUbahDataPaket.getText());
                        String deskripsi = txtDeskripsiPaketUbahDataPaket.getText();
                        String statusAktif = chAktifUbahDataPaket.isSelected() ? chAktifUbahDataPaket.getActionCommand() : "0";

                        if (Model.ubahDataPaket(idPaket, nama, deskripsi, kuota, harga, statusAktif)) {
                            JOptionPane.showMessageDialog(DashboardAdminView.this, "Ubah data paket berhasil", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

                            initsDataPaket();
                        } else {
                            JOptionPane.showMessageDialog(DashboardAdminView.this, "Ubah data paket gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });
        }
        
        content.add(labelUbahDataPaket);
        content.add(labelNamaPaketUbahDataPaket);
        content.add(txtNamaPaketUbahDataPaket);
        content.add(labelKuotaPaketUbahDataPaket);
        content.add(txtKuotaPaketUbahDataPaket);
        content.add(labelHargaPaketUbahDataPaket);
        content.add(txtHargaPaketUbahDataPaket);
        content.add(chAktifUbahDataPaket);
        content.add(btnUbahPaketUbahDataPaket);
        content.add(btnBatalUbahDataPaket);
        content.add(labelDeskripsiPaketUbahDataPaket);
        content.add(spTxtDeskripsiPaketUbahDataPaket);
        setVisible(true);
    }
  
    private void initsRequestSaldo() {
        resetSidebar();
        menuRequestSaldo.setBackground(cColors.BLUE);
        menuRequestSaldo.setForeground(cColors.WHITE);
        refreshContent();
        menuRequestSaldo.setSidebarAktif();
        menuTitle.setText("Request Saldo Pending");

        txtCariRequestSaldo.setText(null);

        /* String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
        String[][] dataUser = {
            {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
            {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
            {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
            {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
            {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
        };

        dmRequestSaldo = new DefaultTableModel(dataUser, dataUserHeader); */

        tblDataRequestSaldo = new cTable(Model.getPendingTransaksiSaldo());

        tblDataRequestSaldo.getColumnModel().getColumn(0).setWidth(0);
        tblDataRequestSaldo.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataRequestSaldo.getColumnModel().getColumn(0).setMaxWidth(0);

        spDataRequestSaldo = new cScrollPane(tblDataRequestSaldo, 25, 120, 555, 310);

        txtCariRequestSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String keyword = txtCariRequestSaldo.getText();
                
                tblDataRequestSaldo.setModel(Model.getSearchPendingTransaksiSaldo(keyword));

                tblDataRequestSaldo.getColumnModel().getColumn(0).setWidth(0);
                tblDataRequestSaldo.getColumnModel().getColumn(0).setMinWidth(0);
                tblDataRequestSaldo.getColumnModel().getColumn(0).setMaxWidth(0);
            }
        });

        if (btnLihatBerhasilRequestSaldo.getActionListeners().length == 0) {
            btnLihatBerhasilRequestSaldo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    initsRequestSaldoDone();
                }
            });
        }

        if (btnApproveRequestSaldo.getActionListeners().length == 0) {
            btnApproveRequestSaldo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int selectedIndex = tblDataRequestSaldo.getSelectedRow();

                    if (selectedIndex == -1) {
                        JOptionPane.showMessageDialog(DashboardAdminView.this, "Silahkan pilih data terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int idRequestSaldo = Integer.parseInt(tblDataRequestSaldo.getValueAt(selectedIndex, 0).toString());

                        if (Model.verifikasiRequestSaldo(idRequestSaldo)) {
                            JOptionPane.showMessageDialog(DashboardAdminView.this, "Request saldo berhasil disetujui", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

                            initsRequestSaldoDone();
                        } else {
                            JOptionPane.showMessageDialog(DashboardAdminView.this, "Request saldo gagal disetujui", "Gagal", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });
        }

        content.add(labelRequestSaldo);
        content.add(labelCariRequestSaldo);
        content.add(txtCariRequestSaldo);
        content.add(btnLihatBerhasilRequestSaldo);
        content.add(spDataRequestSaldo);
        content.add(btnApproveRequestSaldo);
        setVisible(true);
    }
  
    private void initsRequestSaldoDone() {
        // setVisible(false);
        resetSidebar();
        menuRequestSaldo.setBackground(cColors.BLUE);
        menuRequestSaldo.setForeground(cColors.WHITE);
        refreshContent();
        menuRequestSaldo.setSidebarAktif();
        menuTitle.setText("Permintaan Saldo Berhasil");
        /* String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
        String[][] dataUser = {
            {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
            {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
            {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
            {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
            {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
        };
        dmRequestSaldoDone = new DefaultTableModel(dataUser, dataUserHeader); */
        tblDataRequestSaldoDone = new cTable(Model.getDoneTransaksiSaldo());

        tblDataRequestSaldoDone.getColumnModel().getColumn(0).setWidth(0);
        tblDataRequestSaldoDone.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataRequestSaldoDone.getColumnModel().getColumn(0).setMaxWidth(0);

        spDataRequestSaldoDone = new cScrollPane(tblDataRequestSaldoDone, 25, 120, 555, 310);

        txtCariRequestSaldoDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String keyword = txtCariRequestSaldoDone.getText();
                
                tblDataRequestSaldoDone.setModel(Model.getSearchDoneTransaksiSaldo(keyword));

                tblDataRequestSaldoDone.getColumnModel().getColumn(0).setWidth(0);
                tblDataRequestSaldoDone.getColumnModel().getColumn(0).setMinWidth(0);
                tblDataRequestSaldoDone.getColumnModel().getColumn(0).setMaxWidth(0);
            }
        });
    
        if (btnLihatPendingRequestSaldoDone.getActionListeners().length == 0) {
            btnLihatPendingRequestSaldoDone.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    initsRequestSaldo();
                }
            });
        }
    
        content.add(labelRequestSaldoDone);
        content.add(labelCariRequestSaldoDone);
        content.add(txtCariRequestSaldoDone);
        content.add(btnLihatPendingRequestSaldoDone);
        content.add(spDataRequestSaldoDone);
        setVisible(true);
    }
  
    private void initsCalonMitra() {
        resetSidebar();
        menuCalonMitra.setBackground(cColors.BLUE);
        menuCalonMitra.setForeground(cColors.WHITE);
        refreshContent();
        menuCalonMitra.setSidebarAktif();
        menuTitle.setText("Calon Mitra");

        txtCariCalonMitra.setText(null);

        /* String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
        String[][] dataUser = {
            {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
            {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
            {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
            {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
            {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
        };
        
        dmCalonMitra = new DefaultTableModel(dataUser, dataUserHeader); */

        tblDataCalonMitra = new cTable(Model.getNotVerifiedMitra());

        tblDataCalonMitra.getColumnModel().getColumn(0).setWidth(0);
        tblDataCalonMitra.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataCalonMitra.getColumnModel().getColumn(0).setMaxWidth(0);

        spDataCalonMitra = new cScrollPane(tblDataCalonMitra, 25, 120, 555, 310);

        txtCariCalonMitra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String keyword = txtCariCalonMitra.getText();
                
                tblDataCalonMitra.setModel(Model.getSearchNotVerifiedMitra(keyword));

                tblDataCalonMitra.getColumnModel().getColumn(0).setWidth(0);
                tblDataCalonMitra.getColumnModel().getColumn(0).setMinWidth(0);
                tblDataCalonMitra.getColumnModel().getColumn(0).setMaxWidth(0);
            }
        });

        if (btnApproveCalonMitra.getActionListeners().length == 0) {
            btnApproveCalonMitra.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int selectedIndex = tblDataCalonMitra.getSelectedRow();

                    if (selectedIndex == -1) {
                        JOptionPane.showMessageDialog(DashboardAdminView.this, "Silahkan pilih data terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int idMitra = Integer.parseInt(tblDataCalonMitra.getValueAt(selectedIndex, 0).toString());

                        if (Model.verifikasiMitra(idMitra)) {
                            JOptionPane.showMessageDialog(DashboardAdminView.this, "Mitra berhasil disetujui", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

                            initsDataMitra();
                        } else {
                            JOptionPane.showMessageDialog(DashboardAdminView.this, "Mitra gagal disetujui", "Gagal", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });
        }

        content.add(labelCalonMitra);
        content.add(labelCariCalonMitra);
        content.add(txtCariCalonMitra);
        content.add(spDataCalonMitra);
        content.add(btnApproveCalonMitra);
        setVisible(true);
    }
  
    private void initsTransaksiPulsa() {
        resetSidebar();
        menuTransaksiPulsa.setBackground(cColors.BLUE);
        menuTransaksiPulsa.setForeground(cColors.WHITE);
        refreshContent();
        menuTransaksiPulsa.setSidebarAktif();
        menuTitle.setText("Transaksi Pulsa");

        txtCariTransaksiPulsa.setText(null);

        /* String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
        String[][] dataUser = {
            {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
            {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
            {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
            {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
            {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
        };

        dmTransaksiPulsa = new DefaultTableModel(dataUser, dataUserHeader); */

        tblDataTransaksiPulsa = new cTable(Model.getAllTransaksiPulsa());

        tblDataTransaksiPulsa.getColumnModel().getColumn(0).setWidth(0);
        tblDataTransaksiPulsa.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataTransaksiPulsa.getColumnModel().getColumn(0).setMaxWidth(0);

        spDataTransaksiPulsa = new cScrollPane(tblDataTransaksiPulsa, 25, 120, 930, 310);

        txtCariTransaksiPulsa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String keyword = txtCariTransaksiPulsa.getText();
                
                tblDataTransaksiPulsa.setModel(Model.getSearchTransaksiPulsa(keyword));

                tblDataTransaksiPulsa.getColumnModel().getColumn(0).setWidth(0);
                tblDataTransaksiPulsa.getColumnModel().getColumn(0).setMinWidth(0);
                tblDataTransaksiPulsa.getColumnModel().getColumn(0).setMaxWidth(0);
            }
        });

        content.add(labelTransaksiPulsa);
        content.add(labelCariTransaksiPulsa);
        content.add(txtCariTransaksiPulsa);
        content.add(spDataTransaksiPulsa);
        setVisible(true);
    }
  
    private void initsTransaksiPaket() {
        resetSidebar();
        menuTransaksiPaket.setBackground(cColors.BLUE);
        menuTransaksiPaket.setForeground(cColors.WHITE);
        refreshContent();
        menuTransaksiPaket.setSidebarAktif();
        menuTitle.setText("Transaksi Paket");

        txtCariTransaksiPaket.setText(null);

        /* String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
        String[][] dataUser = {
            {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
            {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
            {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
            {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
            {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
        };

        dmTransaksiPaket = new DefaultTableModel(dataUser, dataUserHeader); */

        tblDataTransaksiPaket = new cTable(Model.getAllTransaksiPaket());

        tblDataTransaksiPaket.getColumnModel().getColumn(0).setWidth(0);
        tblDataTransaksiPaket.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataTransaksiPaket.getColumnModel().getColumn(0).setMaxWidth(0);

        spDataTransaksiPaket = new cScrollPane(tblDataTransaksiPaket, 25, 120, 930, 310);

        txtCariTransaksiPaket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String keyword = txtCariTransaksiPaket.getText();
                
                tblDataTransaksiPaket.setModel(Model.getSearchTransaksiPaket(keyword));

                tblDataTransaksiPaket.getColumnModel().getColumn(0).setWidth(0);
                tblDataTransaksiPaket.getColumnModel().getColumn(0).setMinWidth(0);
                tblDataTransaksiPaket.getColumnModel().getColumn(0).setMaxWidth(0);
            }
        });

        content.add(labelTransaksiPaket);
        content.add(labelCariTransaksiPaket);
        content.add(txtCariTransaksiPaket);
        content.add(spDataTransaksiPaket);
        setVisible(true);
    }
  
    private void initsLogout() {
        Object[] options = {"Iya", "Batal"};
        int confirm = JOptionPane.showOptionDialog(null, "Yakin ingin logout?", "Logout", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (confirm == 0) {
            this.statusLogin = false;
            
            DashboardAdminView.this.setVisible(false);
            Controller.showLoginAdmin();
        }
    }
}