package com.views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import com.partials.*;
import com.program.Controller;
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
    private cInfoLabel labelBeranda = new cInfoLabel("Label Informasi Beranda", 25, 20);
    
    // komponen di halaman info saldo
    private cInfoLabel labelInfoSaldo = new cInfoLabel("Label Informasi Info Saldo", 25, 20);
    
    // komponen di halaman request pulsa
    private cInfoLabel labelRequestPulsa = new cInfoLabel("Label Informasi Request Pulsa", 25, 20);
    
    // komponen di halaman request transaksi saya
    private cInfoLabel labelTransaksiSaya = new cInfoLabel("Label Informasi Transaksi Saya", 25, 20);

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

    public DashboardMitraView(Integer id){
        super("Dashboard Mitra");

        idMitra = id;

        roleText.setText("Mitra | Nama Mitra");

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

        sidebar.add(menuBeranda);
        sidebar.add(menuInfoSaldo);
        sidebar.add(menuRequestPulsa);
        sidebar.add(menuTransaksiSaya);
        sidebar.add(menuLogout);

        initsBeranda();
    }

    private void initsBeranda(){
        idSelected = null;
        resetSidebar();
        menuBeranda.setBackground(cColors.BLUE);
        menuBeranda.setForeground(cColors.WHITE);
        refreshContent();
        menuTitle.setText("Beranda");
        menuBeranda.setSidebarAktif();
        content.add(labelBeranda);
        setVisible(true);
    }
    
    private void initsInfoSaldo(){
        idSelected = null;
        resetSidebar();
        menuInfoSaldo.setBackground(cColors.BLUE);
        menuInfoSaldo.setForeground(cColors.WHITE);
        refreshContent();
        menuTitle.setText("Informasi Saldo");
        menuInfoSaldo.setSidebarAktif();
        content.add(labelInfoSaldo);
        setVisible(true);
    }
    
    private void initsRequestPulsa(){
        idSelected = null;
        resetSidebar();
        menuRequestPulsa.setBackground(cColors.BLUE);
        menuRequestPulsa.setForeground(cColors.WHITE);
        refreshContent();
        menuTitle.setText("Request Pulsa Customer");
        menuRequestPulsa.setSidebarAktif();
        content.add(labelRequestPulsa);
        setVisible(true);
    }
    
    private void initsTransaksiSaya(){
        idSelected = null;
        resetSidebar();
        menuTransaksiSaya.setBackground(cColors.BLUE);
        menuTransaksiSaya.setForeground(cColors.WHITE);
        refreshContent();
        menuTitle.setText("Transaksi Pulsa Anda");
        menuTransaksiSaya.setSidebarAktif();
        content.add(labelTransaksiSaya);
        setVisible(true);
    }
}