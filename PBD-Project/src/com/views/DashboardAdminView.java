package com.views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import com.partials.*;
import com.program.Controller;
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
    private cInfoLabel labelBeranda = new cInfoLabel("Informasi Konten Beranda", 25, 20);
    
    // komponen di halaman data mitra
    private cInfoLabel labelDataMitra = new cInfoLabel("Informasi Konten Data Mitra", 25, 20);
    
    // komponen di halaman data customer
    private cInfoLabel labelDataCustomer = new cInfoLabel("Informasi Konten Data Customer", 25, 20);
    
    // komponen di halaman data paket
    private cInfoLabel labelDataPaket = new cInfoLabel("Informasi Konten Data Paket", 25, 20);
    
    // komponen di halaman request saldo
    private cInfoLabel labelRequestSaldo = new cInfoLabel("Informasi Konten Request Saldo", 25, 20);
    
    // komponen di halaman calon mitra
    private cInfoLabel labelCalonMitra = new cInfoLabel("Informasi Konten Calon Mitra", 25, 20);
    
    // komponen di halaman transaksi pulsa
    private cInfoLabel labelTransaksiPulsa = new cInfoLabel("Informasi Konten Transaksi Pulsa", 25, 20);
    
    // komponen di halaman transaksi paket
    private cInfoLabel labelTransaksiPaket = new cInfoLabel("Informasi Konten Transaksi Paket", 25, 20);

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
        menuTitle.setText("Beranda");
        menuBeranda.setSidebarAktif();
        content.add(labelBeranda);
        setVisible(true);
    }
    
    private void initsDataMitra(){
        idSelected = null;
        resetSidebar();
        menuDataMitra.setBackground(cColors.BLUE);
        menuDataMitra.setForeground(cColors.WHITE);
        refreshContent();
        menuTitle.setText("Data Mitra");
        menuDataMitra.setSidebarAktif();
        content.add(labelDataMitra);
        setVisible(true);
    }
    
    private void initsDataCustomer(){
        idSelected = null;
        resetSidebar();
        menuDataCustomer.setBackground(cColors.BLUE);
        menuDataCustomer.setForeground(cColors.WHITE);
        refreshContent();
        menuTitle.setText("Data Customer");
        menuDataCustomer.setSidebarAktif();
        content.add(labelDataCustomer);
        setVisible(true);
    }
    
    private void initsDataPaket(){
        idSelected = null;
        resetSidebar();
        menuDataPaket.setBackground(cColors.BLUE);
        menuDataPaket.setForeground(cColors.WHITE);
        refreshContent();
        menuTitle.setText("Data Paket");
        menuDataPaket.setSidebarAktif();
        content.add(labelDataPaket);
        setVisible(true);
    }
    
    private void initsRequestSaldo(){
        idSelected = null;
        resetSidebar();
        menuRequestSaldo.setBackground(cColors.BLUE);
        menuRequestSaldo.setForeground(cColors.WHITE);
        refreshContent();
        menuTitle.setText("Request Saldo");
        menuRequestSaldo.setSidebarAktif();
        content.add(labelRequestSaldo);
        setVisible(true);
    }
    
    private void initsCalonMitra(){
        idSelected = null;
        resetSidebar();
        menuCalonMitra.setBackground(cColors.BLUE);
        menuCalonMitra.setForeground(cColors.WHITE);
        refreshContent();
        menuTitle.setText("Calon Mitra");
        menuCalonMitra.setSidebarAktif();
        content.add(labelCalonMitra);
        setVisible(true);
    }
    
    private void initsTransaksiPulsa(){
        idSelected = null;
        resetSidebar();
        menuTransaksiPulsa.setBackground(cColors.BLUE);
        menuTransaksiPulsa.setForeground(cColors.WHITE);
        refreshContent();
        menuTitle.setText("Transaksi Pulsa");
        menuTransaksiPulsa.setSidebarAktif();
        content.add(labelTransaksiPulsa);
        setVisible(true);
    }
    
    private void initsTransaksiPaket(){
        idSelected = null;
        resetSidebar();
        menuTransaksiPaket.setBackground(cColors.BLUE);
        menuTransaksiPaket.setForeground(cColors.WHITE);
        refreshContent();
        menuTitle.setText("Transaksi Paket");
        menuTransaksiPaket.setSidebarAktif();
        content.add(labelTransaksiPaket);
        setVisible(true);
    }

    private void initsLogout(){
        Object[] options = {"Iya", "Batal"};
        int konfirmasi = JOptionPane.showOptionDialog(null, "Yakin ingin logout?", "Logout", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if(konfirmasi == 0){
            statusLogin = false;
            idSelected = null;

            Controller.showLoginAdmin();
        }
    }
}