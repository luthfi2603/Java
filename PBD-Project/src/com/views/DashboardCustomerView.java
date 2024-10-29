package com.views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.partials.*;
import com.program.Controller;
import com.templates.cDashboardFrame;

public class DashboardCustomerView extends cDashboardFrame {
    Integer idUser = null;
    Integer idSelected = null;

    // sidebar menu
    private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
    private cSidebarMenu menuBeliPulsa = new cSidebarMenu("Beli Pulsa", 70 + 50);
    private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 70 + 50 + 50);

    // komopnen di halaman beranda
    private cInfoLabel labelBeranda = new cInfoLabel("Label Informasi Beranda", 25, 20);
    
    // komopnen di halaman beli pulsa
    private cInfoLabel labelBeliPulsa = new cInfoLabel("Label Informasi Beli Pulsa", 25, 20);

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

            menuLogout.setSidebarNonAktif();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // method 
    private void refreshContent(){
        try {
            content.removeAll();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public DashboardCustomerView(Integer id){
        super("Dashboard Customer");

        idUser = id;

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
        
        menuLogout.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                idUser = null;

                Controller.showLoginCustomer();
            }
        });

        sidebar.add(menuBeranda);
        sidebar.add(menuBeliPulsa);
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
    
    private void initsBeliPulsa(){
        idSelected = null;
        resetSidebar();
        menuBeliPulsa.setBackground(cColors.BLUE);
        menuBeliPulsa.setForeground(cColors.WHITE);
        refreshContent();
        menuTitle.setText("Beli Pulsa");
        menuBeliPulsa.setSidebarAktif();
        content.add(labelBeliPulsa);
        setVisible(true);
    }
}