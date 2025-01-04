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

public class DashboardAdminView extends cDashboardFrame {
    boolean statusLogin = false;
    Integer idSelected = null;

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
    private DefaultTableModel dmDataCustomer;
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
    private DefaultTableModel dmDataPaket;
    private cTable tblDataDataPaket;
    private cScrollPane spDataDataPaket;
    private cGreenButton btnUbahDataPaket = new cGreenButton("Ubah", 25, 410, 92);
    private cInfoLabel labelDeskripsiPaketDataPaket = new cInfoLabel("DeskripsiPaket", 600, 145);
    private cTextArea valueDeskripsiPaketDataPaket = new cTextArea("", 600, 186, false);
    
    // komponen di halaman tambah data paket
    private cInfoLabel labelTambahDataPaket = new cInfoLabel("Isi form data paket dengan lengkap", 25, 20);
    private cFormLabel labelNamaPaketTambahDataPaket = new cFormLabel("Nama Paket", 25, 65, 550, false);
    private cTextField txtNamaPaketTambahDataPaket = new cTextField(25, 90, 550, false);
    private cErrorLabel errorNamaPaketTambahDataPaket = new cErrorLabel("nama paket tidak boleh kosong!", 25, 125, 550, false);
    private cFormLabel labelKuotaPaketTambahDataPaket = new cFormLabel("Kuota Paket", 25, 150, 550, false);
    private cTextField txtKuotaPaketTambahDataPaket = new cTextField(25, 175, 550, false);
    private cErrorLabel errorKuotaPaketTambahDataPaket = new cErrorLabel("kuota paket tidak boleh kosong!", 25, 210, 550, false);
    private cFormLabel labelHargaPaketTambahDataPaket = new cFormLabel("Harga Paket", 25, 235, 550, false);
    private cTextField txtHargaPaketTambahDataPaket = new cTextField(25, 260, 550, false);
    private cErrorLabel errorHargaPaketTambahDataPaket = new cErrorLabel("harga paket tidak boleh kosong!", 25, 295, 550, false);
    private cCheckBox chAktifTambahDataPaket = new cCheckBox("Aktifkan", "1", 25, 316, 100);
    private cBlueButton btnTambahPaketTambahDataPaket = new cBlueButton("Tambah", 25, 348, 110);
    private cRedButton btnBatalTambahDataPaket = new cRedButton("Batal", 155, 348, 110);
    private cFormLabel labelDeskripsiPaketTambahDataPaket = new cFormLabel("Deskripsi Paket", 595, 65, 370, false);
    private cTextArea txtDeskripsiPaketTambahDataPaket = new cTextArea(true);
    private cScrollPane spTxtDeskripsiPaketTambahDataPaket = new cScrollPane(txtDeskripsiPaketTambahDataPaket, 595, 90, 370, 205);
    private cErrorLabel errorDeskripsiPaketTambahDataPaket = new cErrorLabel("deskripsi paket tidak boleh kosong!", 595, 295, 370, false);

    // komponen di halaman ubah data paket
    private cInfoLabel labelUbahDataPaket = new cInfoLabel("Isi form data paket dengan lengkap", 25, 20);
    private cFormLabel labelNamaPaketUbahDataPaket = new cFormLabel("Nama Paket", 25, 65, 550, false);
    private cTextField txtNamaPaketUbahDataPaket = new cTextField(25, 90, 550, false);
    private cErrorLabel errorNamaPaketUbahDataPaket = new cErrorLabel("nama paket tidak boleh kosong!", 25, 125, 550, false);
    private cFormLabel labelKuotaPaketUbahDataPaket = new cFormLabel("Kuota Paket", 25, 150, 550, false);
    private cTextField txtKuotaPaketUbahDataPaket = new cTextField(25, 175, 550, false);
    private cErrorLabel errorKuotaPaketUbahDataPaket = new cErrorLabel("kuota paket tidak boleh kosong!", 25, 210, 550, false);
    private cFormLabel labelHargaPaketUbahDataPaket = new cFormLabel("Harga Paket", 25, 235, 550, false);
    private cTextField txtHargaPaketUbahDataPaket = new cTextField(25, 260, 550, false);
    private cErrorLabel errorHargaPaketUbahDataPaket = new cErrorLabel("harga paket tidak boleh kosong!", 25, 295, 550, false);
    private cCheckBox chAktifUbahDataPaket = new cCheckBox("Aktifkan", "1", 25, 316, 100);
    private cBlueButton btnUbahPaketUbahDataPaket = new cBlueButton("Ubah", 25, 348, 110);
    private cRedButton btnBatalUbahDataPaket = new cRedButton("Batal", 155, 348, 110);
    private cFormLabel labelDeskripsiPaketUbahDataPaket = new cFormLabel("Deskripsi Paket", 595, 65, 370, false);
    private cTextArea txtDeskripsiPaketUbahDataPaket = new cTextArea(true);
    private cScrollPane spTxtDeskripsiPaketUbahDataPaket = new cScrollPane(txtDeskripsiPaketUbahDataPaket, 595, 90, 370, 205);
    private cErrorLabel errorDeskripsiPaketUbahDataPaket = new cErrorLabel("deskripsi paket tidak boleh kosong!", 595, 295, 370, false);
    
    // komponen di halaman request saldo
    private cInfoLabel labelRequestSaldo = new cInfoLabel("Data Request Request Saldo Pending", 25, 20);
    private cFormLabel labelCariRequestSaldo = new cFormLabel("Cari", 25, 75, 55, false);
    private cTextField txtCariRequestSaldo = new cTextField(83, 70, 317, false);
    private cBlueButton btnLihatBerhasilRequestSaldo = new cBlueButton("Lihat Berhasil", 418, 70, 162);
    private DefaultTableModel dmRequestSaldo;
    private cTable tblDataRequestSaldo;
    private cScrollPane spDataRequestSaldo;
    private cGreenButton btnApproveRequestSaldo = new cGreenButton("Setujui", 25, 446, 110);
    
    // komponen di halaman request saldo done
    private cInfoLabel labelRequestSaldoDone = new cInfoLabel("Data Request Request Saldo Berhasil", 25, 20);
    private cFormLabel labelCariRequestSaldoDone = new cFormLabel("Cari", 25, 75, 55, false);
    private cTextField txtCariRequestSaldoDone = new cTextField(83, 70, 317, false);
    private cBlueButton btnLihatPendingRequestSaldoDone = new cBlueButton("Lihat Pending", 418, 70, 162);
    private DefaultTableModel dmRequestSaldoDone;
    private cTable tblDataRequestSaldoDone;
    private cScrollPane spDataRequestSaldoDone;
    
    // komponen di halaman calon mitra
    private cInfoLabel labelCalonMitra = new cInfoLabel("Data Request Calon Mitra", 25, 20);
    private cFormLabel labelCariCalonMitra = new cFormLabel("Cari", 25, 75, 55, false);
    private cTextField txtCariCalonMitra = new cTextField(83, 70, 350, false);
    private DefaultTableModel dmCalonMitra;
    private cTable tblDataCalonMitra;
    private cScrollPane spDataCalonMitra;
    private cGreenButton btnApproveCalonMitra = new cGreenButton("Setujui", 25, 446, 110);
    
    // komponen di halaman transaksi pulsa
    private cInfoLabel labelTransaksiPulsa = new cInfoLabel("Semua Data Transaksi Pulsa", 25, 20);
    private cFormLabel labelCariTransaksiPulsa = new cFormLabel("Cari", 25, 75, 55, false);
    private cTextField txtCariTransaksiPulsa = new cTextField(83, 70, 350, false);
    private DefaultTableModel dmTransaksiPulsa;
    private cTable tblDataTransaksiPulsa;
    private cScrollPane spDataTransaksiPulsa;
    
    // komponen di halaman transaksi paket
    private cInfoLabel labelTransaksiPaket = new cInfoLabel("Semua Data Transaksi Paket", 25, 20);
    private cFormLabel labelCariTransaksiPaket = new cFormLabel("Cari", 25, 75, 55, false);
    private cTextField txtCariTransaksiPaket = new cTextField(83, 70, 350, false);
    private DefaultTableModel dmTransaksiPaket;
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
            // TODO: handle exception
        }
    }

    // method untuk menghilangkan semua komponen yang ada pada halaman sebelumnya
    private void refreshContent(){
        try {
            content.removeAll();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public DashboardAdminView(boolean statusLogin){
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
        idSelected = null;
        resetSidebar();
        menuBeranda.setBackground(cColors.BLUE);
        menuBeranda.setForeground(cColors.WHITE);
        refreshContent();
        menuBeranda.setSidebarAktif();
        menuTitle.setText("Beranda");

        valueJmlDataMitraBeranda.setText(String.valueOf(Model.getCountVerifiedMitra()));

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
  
    private void initsDataMitra(){
        idSelected = null;
        resetSidebar();
        menuDataMitra.setBackground(cColors.BLUE);
        menuDataMitra.setForeground(cColors.WHITE);
        refreshContent();
        menuDataMitra.setSidebarAktif();
        menuTitle.setText("Data Mitra");
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
        content.add(labelDataMitra);
        content.add(labelCariDataMitra);
        content.add(txtCariDataMitra);
        content.add(spDataDataMitra);
        content.add(btnHapusDataMitra);
        setVisible(true);
    }
  
    private void initsDataCustomer(){
        idSelected = null;
        resetSidebar();
        menuDataCustomer.setBackground(cColors.BLUE);
        menuDataCustomer.setForeground(cColors.WHITE);
        refreshContent();
        menuDataCustomer.setSidebarAktif();
        menuTitle.setText("Data Customer");
        String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
        String[][] dataUser = {
            {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
            {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
            {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
            {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
            {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
        };
        dmDataCustomer = new DefaultTableModel(dataUser, dataUserHeader);
        tblDataDataCustomer = new cTable(dmDataCustomer);
    
        spDataDataCustomer = new cScrollPane(tblDataDataCustomer, 25, 120, 925, 310);
        content.add(labelDataCustomer);
        content.add(labelCariDataCustomer);
        content.add(txtCariDataCustomer);
        content.add(spDataDataCustomer);
        content.add(btnHapusDataCustomer);
        setVisible(true);
    }
  
    private void initsDataPaket(){
        idSelected = null;
        resetSidebar();
        menuDataPaket.setBackground(cColors.BLUE);
        menuDataPaket.setForeground(cColors.WHITE);
        refreshContent();
        menuDataPaket.setSidebarAktif();
        menuTitle.setText("Data Paket");
        String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
        String[][] dataUser = {
            {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
            {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
            {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
            {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
            {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
        };
        dmDataPaket = new DefaultTableModel(dataUser, dataUserHeader);
        tblDataDataPaket = new cTable(dmDataPaket);
        spDataDataPaket = new cScrollPane(tblDataDataPaket, 25, 145, 555, 250);
        rdSemuaDataPaket.setSelected(true);
        groupActionDataPaket.add(rdSemuaDataPaket);
        groupActionDataPaket.add(rdAktifDataPaket);
        groupActionDataPaket.add(rdTidakAktifDataPaket);
    
        btnTambahDataPaket.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                initsTambahPaket();
            }
        });
    
        btnUbahDataPaket.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae)
            {
            initsUbahPaket();
            }
        });
    
        String textDeskripsiPaket = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam totam doloribus velit ipsa! Beatae tempore quod laborum porro optio aliquam voluptate commodi assumenda explicabo debitis accusamus obcaecati, quo nostrum esse!";
        valueDeskripsiPaketDataPaket.setText(textDeskripsiPaket);
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
  
    private void initsTambahPaket(){
        // setVisible(false);
        idSelected = null;
        resetSidebar();
        menuDataPaket.setBackground(cColors.BLUE);
        menuDataPaket.setForeground(cColors.WHITE);
        refreshContent();
        menuDataPaket.setSidebarAktif();
        menuTitle.setText("Tambah Data Paket");

        btnBatalTambahDataPaket.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae)
            {
            initsDataPaket();
            }
        });
        
        content.add(labelTambahDataPaket);
        content.add(labelNamaPaketTambahDataPaket);
        content.add(txtNamaPaketTambahDataPaket);
        content.add(errorNamaPaketTambahDataPaket);
        content.add(labelKuotaPaketTambahDataPaket);
        content.add(txtKuotaPaketTambahDataPaket);
        content.add(errorKuotaPaketTambahDataPaket);
        content.add(labelHargaPaketTambahDataPaket);
        content.add(txtHargaPaketTambahDataPaket);
        content.add(errorHargaPaketTambahDataPaket);
        content.add(chAktifTambahDataPaket);
        content.add(btnTambahPaketTambahDataPaket);
        content.add(btnBatalTambahDataPaket);
        content.add(labelDeskripsiPaketTambahDataPaket);
        content.add(spTxtDeskripsiPaketTambahDataPaket);
        content.add(errorDeskripsiPaketTambahDataPaket);
        setVisible(true);
    }
    private void initsUbahPaket(){
      // setVisible(false);
      idSelected = null;
      resetSidebar();
      menuDataPaket.setBackground(cColors.BLUE);
      menuDataPaket.setForeground(cColors.WHITE);
      refreshContent();
      menuDataPaket.setSidebarAktif();
      menuTitle.setText("Ubah Data Paket");
      btnBatalUbahDataPaket.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae)
        {
          initsDataPaket();
        }
      });
      content.add(labelUbahDataPaket);
      content.add(labelNamaPaketUbahDataPaket);
      content.add(txtNamaPaketUbahDataPaket);
      content.add(errorNamaPaketUbahDataPaket);
      content.add(labelKuotaPaketUbahDataPaket);
      content.add(txtKuotaPaketUbahDataPaket);
      content.add(errorKuotaPaketUbahDataPaket);
      content.add(labelHargaPaketUbahDataPaket);
      content.add(txtHargaPaketUbahDataPaket);
      content.add(errorHargaPaketUbahDataPaket);
      content.add(chAktifUbahDataPaket);
      content.add(btnUbahPaketUbahDataPaket);
      content.add(btnBatalUbahDataPaket);
      content.add(labelDeskripsiPaketUbahDataPaket);
      content.add(spTxtDeskripsiPaketUbahDataPaket);
      content.add(errorDeskripsiPaketUbahDataPaket);
      setVisible(true);
    }
  
    private void initsRequestSaldo(){
      idSelected = null;
      resetSidebar();
      menuRequestSaldo.setBackground(cColors.BLUE);
      menuRequestSaldo.setForeground(cColors.WHITE);
      refreshContent();
      menuRequestSaldo.setSidebarAktif();
      menuTitle.setText("Request Saldo Pending");
      String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
      String[][] dataUser = {
        {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
        {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
        {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
        {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
        {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
      };
      dmRequestSaldo = new DefaultTableModel(dataUser, dataUserHeader);
      tblDataRequestSaldo = new cTable(dmRequestSaldo);
      spDataRequestSaldo = new cScrollPane(tblDataRequestSaldo, 25, 120, 555, 310);
  
      btnLihatBerhasilRequestSaldo.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae)
        {
          initsRequestSaldoDone();
        }
      });
  
      content.add(labelRequestSaldo);
      content.add(labelCariRequestSaldo);
      content.add(txtCariRequestSaldo);
      content.add(btnLihatBerhasilRequestSaldo);
      content.add(spDataRequestSaldo);
      content.add(btnApproveRequestSaldo);
      setVisible(true);
    }
  
    private void initsRequestSaldoDone(){
      // setVisible(false);
      idSelected = null;
      resetSidebar();
      menuRequestSaldo.setBackground(cColors.BLUE);
      menuRequestSaldo.setForeground(cColors.WHITE);
      refreshContent();
      menuRequestSaldo.setSidebarAktif();
      menuTitle.setText("Permintaan Saldo Berhasil");
      String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
      String[][] dataUser = {
        {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
        {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
        {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
        {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
        {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
      };
      dmRequestSaldoDone = new DefaultTableModel(dataUser, dataUserHeader);
      tblDataRequestSaldoDone = new cTable(dmRequestSaldoDone);
      spDataRequestSaldoDone = new cScrollPane(tblDataRequestSaldoDone, 25, 120, 555, 310);
  
      btnLihatPendingRequestSaldoDone.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae)
        {
          initsRequestSaldo();
        }
      });
  
      content.add(labelRequestSaldoDone);
      content.add(labelCariRequestSaldoDone);
      content.add(txtCariRequestSaldoDone);
      content.add(btnLihatPendingRequestSaldoDone);
      content.add(spDataRequestSaldoDone);
      setVisible(true);
    }
  
    private void initsCalonMitra(){
      idSelected = null;
      resetSidebar();
      menuCalonMitra.setBackground(cColors.BLUE);
      menuCalonMitra.setForeground(cColors.WHITE);
      refreshContent();
      menuCalonMitra.setSidebarAktif();
      menuTitle.setText("Calon Mitra");
      String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
      String[][] dataUser = {
        {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
        {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
        {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
        {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
        {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
      };
      dmCalonMitra = new DefaultTableModel(dataUser, dataUserHeader);
      tblDataCalonMitra = new cTable(dmCalonMitra);
      spDataCalonMitra = new cScrollPane(tblDataCalonMitra, 25, 120, 555, 310);
      content.add(labelCalonMitra);
      content.add(labelCariCalonMitra);
      content.add(txtCariCalonMitra);
      content.add(spDataCalonMitra);
      content.add(btnApproveCalonMitra);
      setVisible(true);
    }
  
    private void initsTransaksiPulsa(){
      idSelected = null;
      resetSidebar();
      menuTransaksiPulsa.setBackground(cColors.BLUE);
      menuTransaksiPulsa.setForeground(cColors.WHITE);
      refreshContent();
      menuTransaksiPulsa.setSidebarAktif();
      menuTitle.setText("Transaksi Pulsa");
      String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
      String[][] dataUser = {
        {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
        {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
        {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
        {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
        {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
      };
      dmTransaksiPulsa = new DefaultTableModel(dataUser, dataUserHeader);
      tblDataTransaksiPulsa = new cTable(dmTransaksiPulsa);
      spDataTransaksiPulsa = new cScrollPane(tblDataTransaksiPulsa, 25, 120, 930, 310);
      content.add(labelTransaksiPulsa);
      content.add(labelCariTransaksiPulsa);
      content.add(txtCariTransaksiPulsa);
      content.add(spDataTransaksiPulsa);
      setVisible(true);
    }
  
    private void initsTransaksiPaket(){
      idSelected = null;
      resetSidebar();
      menuTransaksiPaket.setBackground(cColors.BLUE);
      menuTransaksiPaket.setForeground(cColors.WHITE);
      refreshContent();
      menuTransaksiPaket.setSidebarAktif();
      menuTitle.setText("Transaksi Paket");
      String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
      String[][] dataUser = {
        {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
        {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
        {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
        {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
        {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
      };
      dmTransaksiPaket = new DefaultTableModel(dataUser, dataUserHeader);
      tblDataTransaksiPaket = new cTable(dmTransaksiPaket);
      spDataTransaksiPaket = new cScrollPane(tblDataTransaksiPaket, 25, 120, 930, 310);
      content.add(labelTransaksiPaket);
      content.add(labelCariTransaksiPaket);
      content.add(txtCariTransaksiPaket);
      content.add(spDataTransaksiPaket);
      setVisible(true);
    }
  
    private void initsLogout(){
        Object[] options = {"YA", "BATAL"};
        int confirm = JOptionPane.showOptionDialog(null, "Yakin ingin logout?", "Logout", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if(confirm == 0){
            this.statusLogin = false;
            this.idSelected = null;
            Controller.showLoginAdmin();
        }
    }
}