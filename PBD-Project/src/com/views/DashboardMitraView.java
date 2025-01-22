package com.views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
// import javax.swing.table.DefaultTableModel;

import com.partials.*;
import com.program.Controller;
import com.program.Model;
import com.templates.cDashboardFrame;

public class DashboardMitraView extends cDashboardFrame {
    Integer idMitra = null;
    Integer idSelected = null;

    // sidebar menu
    private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
    private cSidebarMenu menuInfoSaldo = new cSidebarMenu("Info Saldo", 70 + 50);
    private cSidebarMenu menuRequestPulsa = new cSidebarMenu("Request Pulsa", 70 + (50 * 2));
    private cSidebarMenu menuTransaksiSaya = new cSidebarMenu("Transaksi Saya", 70 + (50 * 3));
    private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 70 + (50 * 4));

    // komponen di halaman beranda
    private cInfoLabel labelSisaSaldoBeranda = new cInfoLabel("Sisa Saldo Anda", 25, 20);
    private cBigFont valueSisaSaldoBeranda = new cBigFont("0", 25, 60);
    private cInfoLabel labelPelayananBeranda = new cInfoLabel("Pelayanan Pulsa Customer", 25, 150);
    private cBigFont valuePelayananBeranda = new cBigFont("0", 25, 190);
    private cInfoLabel labelRequestPulsaBeranda = new cInfoLabel("Request Pulsa Customer Saat Ini", 25, 280);
    private cBigFont valueRequestPulsaBeranda = new cBigFont("0", 25, 320);
    
    // komponen di halaman sisa saldo
    private cInfoLabel labelSisaSaldoInfoSaldo = new cInfoLabel("Sisa Saldo Anda", 25, 20);
    private cBigFont valueSisaSaldoInfoSaldo = new cBigFont("0", 25, 60);
    private cInfoLabel labelRequestSaldoInfoSaldo = new cInfoLabel("Data Request", 25, 150);
    // private DefaultTableModel dmRequestSaldo;
    private cTable tblDataRequestSaldo;
    private cScrollPane spDataRequestSaldo;
    private cInfoLabel labelDoRequestSaldoInfoSaldo = new cInfoLabel("Sisa Saldo Anda", 490, 20);
    private cErrorLabel errorDoRequestSaldoInfoSaldo = new cErrorLabel("Tidak bisa melakukan request jika saldo masih diatas 100K", 490, 60, 400, false);
    private cBlueButton btnRequestSaldo = new cBlueButton("Request", 490, 90, 155);
    
    // komponen di halaman request pulsa
    private cInfoLabel labelDataRequestPulsa = new cInfoLabel("Sisa Saldo Anda", 25, 20);
    // private DefaultTableModel dmRequestPulsa;
    private cTable tblDataRequestPulsa;
    private cScrollPane spDataRequestPulsa;
    private cBlueButton btnIsiPulsa = new cBlueButton("Isi Pulsa", 25, 280, 155);

    // komponen di halaman transaksi saya
    private cInfoLabel labelDataTransaksiSaya = new cInfoLabel("Data Pelayanan Pulsa Berhasil Anda", 25, 20);
    // private DefaultTableModel dmTransaksiSaya;
    private cTable tblDataTransaksiSaya;
    private cScrollPane spDataTransaksiSaya;

    // method untuk menonaktifkan semua sidebar
    private void resetSidebar(){
        try {
            setVisible(false);

            menuBeranda.setBackground(cColors.WHITE);
            menuBeranda.setForeground(cColors.GRAY);
            menuBeranda.setSidebarNonAktif();
            
            menuInfoSaldo.setBackground(cColors.WHITE);
            menuInfoSaldo.setForeground(cColors.GRAY);
            menuInfoSaldo.setSidebarNonAktif();
            
            menuRequestPulsa.setBackground(cColors.WHITE);
            menuRequestPulsa.setForeground(cColors.GRAY);
            menuRequestPulsa.setSidebarNonAktif();
            
            menuTransaksiSaya.setBackground(cColors.WHITE);
            menuTransaksiSaya.setForeground(cColors.GRAY);
            menuTransaksiSaya.setSidebarNonAktif();

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

    public DashboardMitraView(Integer id) {
        super("Dashboard Mitra");

        idMitra = id;

        roleText.setText("Mitra | " + Model.getDetailMitra(idMitra)[1].toString());

        menuBeranda.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsBeranda();
            }
        });

        menuInfoSaldo.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsInfoSaldo();
            }
        });
        
        menuRequestPulsa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsRequestPulsa();
            }
        });
        
        menuTransaksiSaya.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                initsTransaksiSaya();
            }
        });
        
        menuLogout.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Object[] options = {"Iya", "Batal"};
                int konfirmasi = JOptionPane.showOptionDialog(null, "Yakin ingin logout?", "Logout", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if(konfirmasi == 0){
                    idMitra = null;
                    idSelected = null;
    
                    Controller.showLoginMitra();
                }
            }
        });

        // cek status verifikasi mitra yang login
        if (Model.getDetailMitra(idMitra)[3].toString().equalsIgnoreCase("1")) {
            sidebar.add(menuBeranda);
            sidebar.add(menuInfoSaldo);
            sidebar.add(menuRequestPulsa);
            sidebar.add(menuTransaksiSaya);
            sidebar.add(menuLogout);
        } else {
            sidebar.add(menuBeranda);

            menuLogout.setLocation(0, menuBeranda.getLocation().y + 50);
            sidebar.add(menuLogout);
        }

        initsBeranda();
    }

    private void initsBeranda() {
        idSelected = null;
        resetSidebar();
        menuBeranda.setBackground(cColors.BLUE);
        menuBeranda.setForeground(cColors.WHITE);
        refreshContent();
        menuBeranda.setSidebarAktif();
        menuTitle.setText("Beranda");

        // cek status verifikasi mitra yang login
        if (Model.getDetailMitra(idMitra)[3].toString().equalsIgnoreCase("1")) {
            valueSisaSaldoBeranda.setText(String.valueOf(Model.getDetailSaldoMitra(idMitra)));
            valuePelayananBeranda.setText(String.valueOf(Model.getCountDoneTransaksiPulsaMitra(idMitra)));
            valueRequestPulsaBeranda.setText(String.valueOf(Model.getCountPendingTransaksiPulsa()));
    
            content.add(valueSisaSaldoBeranda);
            content.add(labelPelayananBeranda);
            content.add(valuePelayananBeranda);
            content.add(labelRequestPulsaBeranda);
            content.add(valueRequestPulsaBeranda);
        } else {
            labelSisaSaldoBeranda.setText("Anda belum terverifikasi! Silahkan tunggu respon dari admin.");
            labelSisaSaldoBeranda.setSize(labelSisaSaldoBeranda.getWidth() + 300, labelSisaSaldoBeranda.getHeight());
        }

        content.add(labelSisaSaldoBeranda);
        setVisible(true);
    }
    
    private void initsInfoSaldo() {
        idSelected = null;
        resetSidebar();
        menuInfoSaldo.setBackground(cColors.BLUE);
        menuInfoSaldo.setForeground(cColors.WHITE);
        refreshContent();
        menuInfoSaldo.setSidebarAktif();
        menuTitle.setText("Informasi Saldo");

        /* String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
        String[][] dataUser = {
            {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
            {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
            {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
            {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
            {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
        };

        dmRequestSaldo = new DefaultTableModel(dataUser, dataUserHeader); */

        tblDataRequestSaldo = new cTable(Model.getAllTransaksiSaldoByMitra(idMitra));
        spDataRequestSaldo = new cScrollPane(tblDataRequestSaldo, 25, 190, 400, 220);

        valueSisaSaldoInfoSaldo.setText(String.valueOf(Model.getDetailSaldoMitra(idMitra)));

        content.add(labelSisaSaldoInfoSaldo);
        content.add(valueSisaSaldoInfoSaldo);
        content.add(labelRequestSaldoInfoSaldo);
        content.add(spDataRequestSaldo);
        content.add(labelDoRequestSaldoInfoSaldo);
        content.add(errorDoRequestSaldoInfoSaldo);
        content.add(btnRequestSaldo);
        setVisible(true);
    }
  
    private void initsRequestPulsa() {
        idSelected = null;
        resetSidebar();
        menuRequestPulsa.setBackground(cColors.BLUE);
        menuRequestPulsa.setForeground(cColors.WHITE);
        refreshContent();
        menuRequestPulsa.setSidebarAktif();
        menuTitle.setText("Request Pulsa Customer");

        /* String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
        String[][] dataUser = {
            {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
            {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
            {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
            {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
            {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
        };

        dmRequestPulsa = new DefaultTableModel(dataUser, dataUserHeader); */

        tblDataRequestPulsa = new cTable(Model.getPendingTransaksiPulsa());

        tblDataRequestPulsa.getColumnModel().getColumn(0).setWidth(0);
        tblDataRequestPulsa.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataRequestPulsa.getColumnModel().getColumn(0).setMaxWidth(0);
        
        tblDataRequestPulsa.getColumnModel().getColumn(1).setWidth(0);
        tblDataRequestPulsa.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataRequestPulsa.getColumnModel().getColumn(1).setMaxWidth(0);

        spDataRequestPulsa = new cScrollPane(tblDataRequestPulsa, 25, 76, 740, 190);

        content.add(labelDataRequestPulsa);
        content.add(spDataRequestPulsa);
        content.add(btnIsiPulsa);
        setVisible(true);
    }
  
    private void initsTransaksiSaya() {
        idSelected = null;
        resetSidebar();
        menuTransaksiSaya.setBackground(cColors.BLUE);
        menuTransaksiSaya.setForeground(cColors.WHITE);
        refreshContent();
        menuTransaksiSaya.setSidebarAktif();
        menuTitle.setText("Transaksi Pulsa Anda");

        /* String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
        String[][] dataUser = {
            {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
            {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
            {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
            {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
            {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
        };

        dmTransaksiSaya = new DefaultTableModel(dataUser, dataUserHeader); */

        tblDataTransaksiSaya = new cTable(Model.getDoneTransaksiPulsaByMitra(idMitra));
        spDataTransaksiSaya = new cScrollPane(tblDataTransaksiSaya, 25, 76, 740, 310);

        content.add(labelDataTransaksiSaya);
        content.add(spDataTransaksiSaya);
        setVisible(true);
    }
}