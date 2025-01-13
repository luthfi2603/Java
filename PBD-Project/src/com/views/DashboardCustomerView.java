package com.views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.partials.*;
import com.program.Controller;
import com.templates.cDashboardFrame;

public class DashboardCustomerView extends cDashboardFrame {
    Integer idCustomer = null;
    Integer idSelected = null;

    // sidebar menu
    private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
    private cSidebarMenu menuBeliPulsa = new cSidebarMenu("Beli Pulsa", 70 + 50);
    private cSidebarMenu menuBeliPaket = new cSidebarMenu("Beli Paket", 70 + (50 * 2));
    private cSidebarMenu menuHistoryBeliPulsa = new cSidebarMenu("History Beli Pulsa", 70 + (50 * 3));
    private cSidebarMenu menuHistoryBeliPaket = new cSidebarMenu("History Beli Paket", 70 + (50 * 4));
    private cSidebarMenu menuAkun = new cSidebarMenu("Akun", 70 + (50 * 5));
    private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 70 + (50 * 6));

    // komponen di halaman beranda
    private cInfoLabel labelSisaPulsaBeranda = new cInfoLabel("Sisa Pulsa Anda", 25, 20);
    private cBigFont valueSisaPulsaBeranda = new cBigFont("55.000", 25, 60);
    private cInfoLabel labelSisaKuotaBeranda = new cInfoLabel("Sisa Kuota Anda", 25, 150);
    private cBigFont valueSisaKuotaBeranda = new cBigFont("11GB", 25, 190);

    // komponen di halaman beli pulsa
    private cInfoLabel labelSisaPulsaBeliPulsa = new cInfoLabel("Sisa Pulsa Anda", 25, 20);
    private cBigFont valueSisaPulsaBeliPulsa = new cBigFont("55.000", 25, 60);
    private cInfoLabel labelPilihanBeliPulsa = new cInfoLabel("Pilihan Beli Pulsa", 25, 150);
    private cRadioButton rd5k = new cRadioButton("5K", "5000", 25, 190, 72);
    private cRadioButton rd10k = new cRadioButton("10K", "10000", 102, 190, 72);
    private cRadioButton rd25k = new cRadioButton("25K", "25000", 179, 190, 72);
    private cRadioButton rd50k = new cRadioButton("50K", "50000", 256, 190, 72);
    private cRadioButton rd100k = new cRadioButton("100K", "10000", 333, 190, 72);
    private cBlueButton btnBeliPulsa = new cBlueButton("Beli Pulsa", 25, 220, 155);
    private ButtonGroup rdPilihaPulsa = new ButtonGroup();

    // komponen di halaman beli paket
    private cInfoLabel labelSisaKuotaBeliPaket = new cInfoLabel("Sisa Kuota Anda", 25, 20);
    private cBigFont valueSisaKuotaBeliPaket = new cBigFont("11GB", 25, 60);
    private cInfoLabel labelPilihanBeliPaket = new cInfoLabel("Pilihan Beli Paket Kuota", 25, 150);
    private DefaultTableModel dmPaket;
    private cTable dataPaket;
    private cScrollPane spDataPaket;
    private cBlueButton btnBeliPaket = new cBlueButton("Beli Paket", 25, 390, 155);
    private cInfoLabel labelDeskripsiPaket = new cInfoLabel("Deskripsi Paket", 473, 190);
    private cTextArea valueDeskripsiPaket = new cTextArea("", 473, 231, false);

    // komponen di halaman histori beli pulsa
    private cInfoLabel labelHistoryPulsa = new cInfoLabel("Semua Pembelian Pulsa Saya", 25, 20);
    private DefaultTableModel dmHistoryPulsa;
    private cTable tblDataHistoryPulsa;
    private cScrollPane spDataHistoryPulsa;

    // komponen di halaman histori beli paket
    private cInfoLabel labelHistoryPaket = new cInfoLabel("Semua Pembelian Paket Saya", 25, 20);
    private DefaultTableModel dmHistoryPaket;
    private cTable tblDataHistoryPaket;
    private cScrollPane spDataHistoryPaket;
    
    // komponen di halaman akun customer
    private cInfoLabel labelAkun = new cInfoLabel("Data Akun Saya", 25, 20);
    private cFormLabel labelNama = new cFormLabel("Nama", 25, 65, 360, false);
    private cTextField txtNama = new cTextField(25, 90, 360, false);
    private cErrorLabel errorNama = new cErrorLabel("nama tidak boleh kosong!", 25, 125, 360, false);
    private cFormLabel labelNoHp = new cFormLabel("No Hp", 25, 150, 360, false);
    private cFormLabel valueNoHp;
    private cFormLabel labelEmail = new cFormLabel("Email", 25, 202, 360, false);
    private cTextField txtEmail = new cTextField(25, 227, 360, false);
    private cErrorLabel errorEmail = new cErrorLabel("email tidak boleh kosong!", 25, 262, 360, false);
    private cBlueButton btnUbahAkun = new cBlueButton("Ubah Data Akun", 25, 292, 155);

    // method untuk menonaktifkan semua sidebar
    private void resetSidebar(){
        try {
            setVisible(false);

            menuBeranda.setBackground(cColors.WHITE);
            menuBeranda.setForeground(cColors.GRAY);
            menuBeranda.setSidebarNonAktif();
            
            menuBeliPulsa.setBackground(cColors.WHITE);
            menuBeliPulsa.setForeground(cColors.GRAY);
            menuBeliPulsa.setSidebarNonAktif();
            
            menuBeliPaket.setBackground(cColors.WHITE);
            menuBeliPaket.setForeground(cColors.GRAY);
            menuBeliPaket.setSidebarNonAktif();
            
            menuHistoryBeliPulsa.setBackground(cColors.WHITE);
            menuHistoryBeliPulsa.setForeground(cColors.GRAY);
            menuHistoryBeliPulsa.setSidebarNonAktif();
            
            menuHistoryBeliPaket.setBackground(cColors.WHITE);
            menuHistoryBeliPaket.setForeground(cColors.GRAY);
            menuHistoryBeliPaket.setSidebarNonAktif();
            
            menuAkun.setBackground(cColors.WHITE);
            menuAkun.setForeground(cColors.GRAY);
            menuAkun.setSidebarNonAktif();

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

    public DashboardCustomerView(Integer id){
        super("Dashboard Customer");

        idCustomer = id;

        roleText.setText("Customer | Nama Customer");

        menuBeranda.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsBeranda();
            }
        });

        menuBeliPulsa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsBeliPulsa();
            }
        });

        menuBeliPaket.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsBeliPaket();
            }
        });

        menuHistoryBeliPulsa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsHistoryBeliPulsa();
            }
        });

        menuHistoryBeliPaket.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsHistoryBeliPaket();
            }
        });

        menuAkun.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsAkun();
            }
        });
        
        menuLogout.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Object[] options = {"Iya", "Batal"};
                int konfirmasi = JOptionPane.showOptionDialog(null, "Yakin ingin logout?", "Logout", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if(konfirmasi == 0){
                    idCustomer = null;
                    idSelected = null;
    
                    Controller.showLoginCustomer();
                }
            }
        });

        sidebar.add(menuBeranda);
        sidebar.add(menuBeliPulsa);
        sidebar.add(menuBeliPaket);
        sidebar.add(menuHistoryBeliPulsa);
        sidebar.add(menuHistoryBeliPaket);
        sidebar.add(menuAkun);
        sidebar.add(menuLogout);

        rdPilihaPulsa.add(rd5k);
        rdPilihaPulsa.add(rd10k);
        rdPilihaPulsa.add(rd25k);
        rdPilihaPulsa.add(rd50k);
        rdPilihaPulsa.add(rd100k);

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
        content.add(labelSisaPulsaBeranda);
        content.add(valueSisaPulsaBeranda);
        content.add(labelSisaKuotaBeranda);
        content.add(valueSisaKuotaBeranda);
        setVisible(true);
    }

    private void initsBeliPulsa(){
        idSelected = null;
        resetSidebar();
        menuBeliPulsa.setBackground(cColors.BLUE);
        menuBeliPulsa.setForeground(cColors.WHITE);
        refreshContent();
        menuBeliPulsa.setSidebarAktif();
        menuTitle.setText("Beli Pulsa");
        content.add(labelSisaPulsaBeliPulsa);
        content.add(valueSisaPulsaBeliPulsa);
        content.add(labelPilihanBeliPulsa);
        content.add(rd5k);
        content.add(rd10k);
        content.add(rd25k);
        content.add(rd50k);
        content.add(rd100k);
        content.add(btnBeliPulsa);
        setVisible(true);
    }

    private void initsBeliPaket(){
        idSelected = null;
        resetSidebar();
        menuBeliPaket.setBackground(cColors.BLUE);
        menuBeliPaket.setForeground(cColors.WHITE);
        refreshContent();
        menuBeliPaket.setSidebarAktif();
        menuTitle.setText("Beli Paket");
        String[] dataUserHeader = {"Nama", "Kuota", "Harga"};
        String[][] dataUser = {
        {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
        {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
        {"Hemat Mantap", "11GB", "76.000"},
        {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
        {"Row5 Col1", "Row5 Col2", "Row5 Col3"},
        {"Row6 Col1", "Row6 Col2", "Row6 Col3"}
        };
        dmPaket = new DefaultTableModel(dataUser, dataUserHeader);
        dataPaket = new cTable(dmPaket);
        spDataPaket = new cScrollPane(dataPaket, 25, 190, 428, 190);
        String textDeskripsiPaket = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam totam doloribus velit ipsa! Beatae tempore quod laborum porro optio aliquam voluptate commodi assumenda explicabo debitis accusamus obcaecati, quo nostrum esse!";
        valueDeskripsiPaket.setText(textDeskripsiPaket);
        content.add(labelSisaKuotaBeliPaket);
        content.add(valueSisaKuotaBeliPaket);
        content.add(labelPilihanBeliPaket);
        content.add(spDataPaket);
        content.add(btnBeliPaket);
        content.add(labelDeskripsiPaket);
        content.add(valueDeskripsiPaket);
        setVisible(true);
    }

    private void initsHistoryBeliPulsa(){
        idSelected = null;
        resetSidebar();
        menuHistoryBeliPulsa.setBackground(cColors.BLUE);
        menuHistoryBeliPulsa.setForeground(cColors.WHITE);
        refreshContent();
        menuHistoryBeliPulsa.setSidebarAktif();
        menuTitle.setText("Transaksi Pulsa Saya");
        String[] dataHistoryPulsaHeader = {"Pulsa", "Mitra", "Waktu", "Status"};
        String[][] dataHistoryPulsa = {
        {"Row1 Col1", "Row1 Col2", "Row1 Col3", "Row1 Col4"},
        {"5.000", "-", "2021-08-19 15:30:21", "diproses"},
        {"25.000", "Yudi Cell", "2021-08-19 15:21:20", "selesai"},
        {"Row4 Col1", "Row4 Col2", "Row4 Col3", "Row4 Col4"},
        {"Row5 Col1", "Row5 Col2", "Row5 Col3", "Row5 Col4"},
        {"Row6 Col1", "Row6 Col2", "Row6 Col3", "Row6 Col4"},
        {"Row7 Col1", "Row7 Col2", "Row7 Col3", "Row7 Col4"},
        {"Row8 Col1", "Row8 Col2", "Row8 Col3", "Row8 Col4"},
        {"Row9 Col1", "Row9 Col2", "Row9 Col3", "Row9 Col4"},
        {"Row10 Col1", "Row10 Col2", "Row10 Col3", "Row10 Col4"}
        };
        dmHistoryPulsa = new DefaultTableModel(dataHistoryPulsa, dataHistoryPulsaHeader);
        tblDataHistoryPulsa = new cTable(dmHistoryPulsa);
        spDataHistoryPulsa = new cScrollPane(tblDataHistoryPulsa, 25, 65, 740, 310);
        content.add(labelHistoryPulsa);
        content.add(spDataHistoryPulsa);
        setVisible(true);
    }

    private void initsHistoryBeliPaket(){
        idSelected = null;
        resetSidebar();
        menuHistoryBeliPaket.setBackground(cColors.BLUE);
        menuHistoryBeliPaket.setForeground(cColors.WHITE);
        refreshContent();
        menuHistoryBeliPaket.setSidebarAktif();
        menuTitle.setText("Transaksi Paket Saya");
        String[] dataHistoryPaketHeader = {"Paket", "Kuota", "Harga", "Waktu", "Status"};
        String[][] dataHistoryPaket = {
        {"Row1 Col1", "Row1 Col2", "Row1 Col3", "Row1 Col4", "Row1 Col5"},
        {"Hemat Mantap", "11GB", "76.000", "2021-08-19 15:21:20", "selesai"},
        {"Row3 Col1", "Row3 Col2", "Row3 Col3", "Row3 Col4", "Row3 Col5"},
        {"Row4 Col1", "Row4 Col2", "Row4 Col3", "Row4 Col4", "Row4 Col5"},
        {"Row5 Col1", "Row5 Col2", "Row5 Col3", "Row5 Col4", "Row5 Col5"},
        {"Row6 Col1", "Row6 Col2", "Row6 Col3", "Row6 Col4", "Row6 Col5"},
        {"Row7 Col1", "Row7 Col2", "Row7 Col3", "Row7 Col4", "Row7 Col5"},
        {"Row8 Col1", "Row8 Col2", "Row8 Col3", "Row8 Col4", "Row8 Col5"},
        {"Row9 Col1", "Row9 Col2", "Row9 Col3", "Row9 Col4", "Row9 Col5"},
        {"Row10 Col1", "Row10 Col2", "Row10 Col3", "Row10 Col4", "Row10 Col5"}
        };
        dmHistoryPaket = new DefaultTableModel(dataHistoryPaket, dataHistoryPaketHeader);
        tblDataHistoryPaket = new cTable(dmHistoryPaket);
        spDataHistoryPaket = new cScrollPane(tblDataHistoryPaket, 25, 65, 924, 310);
        content.add(labelHistoryPaket);
        content.add(spDataHistoryPaket);
        setVisible(true);
    }

    private void initsAkun(){
        idSelected = null;
        resetSidebar();
        menuAkun.setBackground(cColors.BLUE);
        menuAkun.setForeground(cColors.WHITE);
        refreshContent();
        menuAkun.setSidebarAktif();
        menuTitle.setText("Akun Saya");
        valueNoHp = new cFormLabel("08123xxx", 25, 174, 360, false);
        valueNoHp.setFont(com.partials.cFonts.RADIO_BUTTON_FONT);
        valueNoHp.setForeground(com.partials.cColors.RED);
        content.add(labelAkun);
        content.add(labelNama);
        content.add(txtNama);
        content.add(errorNama);
        content.add(labelNoHp);
        content.add(valueNoHp);
        content.add(labelEmail);
        content.add(txtEmail);
        content.add(errorEmail);
        content.add(btnUbahAkun);
        setVisible(true);
    }
}