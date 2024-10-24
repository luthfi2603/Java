package com.templates;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.partials.cBigFont;
import com.partials.cCheckBox;
import com.partials.cColors;
import com.partials.cExitLink;
import com.partials.cFonts;
import com.partials.cInfoLabel;
import com.partials.cRadioButton;
import com.partials.cScrollPane;
import com.partials.cSidebarMenu;
import com.partials.cTable;
import com.partials.cTextArea;

public abstract class cDashboardFrame extends JFrame {
    public JPanel sidebar = new JPanel();
    public JPanel header = new JPanel();
    public JPanel main = new JPanel();
    public JPanel content = new JPanel();

    private JLabel appText = new JLabel("PulsaKu");
    public JLabel roleText = new JLabel("Role | Nama User");
    public JLabel menuTitle = new JLabel("Menu Title");
    public JLabel copyrightText = new JLabel("Copyright 2024, Muhammad Luthfi");

    public cExitLink exitLink = new cExitLink(938);

    public cInfoLabel infoPulsa = new cInfoLabel("Sisa pulsa anda", 25, 25);

    public cBigFont valuePulsa = new cBigFont("15.000", 25, 60);

    public cRadioButton rd1 = new cRadioButton("Pilihan 1", "pilihan1", 25, 150, 100);
    
    public cCheckBox ch1 = new cCheckBox("Checkbox 1", "checkbox", 200, 150, 100);
    
    public cSidebarMenu berandaMenu = new cSidebarMenu("Beranda", 70);
    
    public cTextArea txtArea = new cTextArea(false);

    public cScrollPane sp = new cScrollPane(txtArea, 25, (int) ch1.getLocation().getY() + 44, 300, 100);
    
    public cTable tableUser;
    public cScrollPane spTable;

    public cDashboardFrame(){
        super();

        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);

        sidebar.setBackground(cColors.WHITE);
        sidebar.setBounds(0, 0, 230, 720);
        sidebar.setLayout(null);
        
        header.setBackground(cColors.BLUE);
        header.setBounds(230, 0, 1050, 70);
        header.setLayout(null);
        
        main.setBackground(cColors.WHITE_GRAY);
        main.setBounds(230, 70, 1050, 650);
        main.setLayout(null);
        
        content.setBackground(cColors.WHITE);
        content.setBounds(30, 70, 990, 520);
        content.setLayout(null);

        appText.setFont(cFonts.APP_FONT);
        appText.setBounds(0, 0, 230, 70);
        appText.setForeground(cColors.BLUE);
        appText.setHorizontalAlignment(JLabel.CENTER);
        appText.setVerticalAlignment(JLabel.CENTER);
        
        roleText.setFont(cFonts.ROLE_FONT);
        roleText.setBounds(30, 0, 400, 70);
        roleText.setForeground(cColors.WHITE);
        roleText.setVerticalAlignment(JLabel.CENTER);
        
        menuTitle.setFont(cFonts.MENU_TITLE_FONT);
        menuTitle.setBounds(30, 10, 600, 50);
        menuTitle.setForeground(cColors.BLACK_GRAY);
        menuTitle.setVerticalAlignment(JLabel.CENTER);
        
        copyrightText.setFont(cFonts.TEXTFIELD_FONT);
        copyrightText.setBounds(0, 610, 1050, 20);
        copyrightText.setForeground(cColors.GRAY);
        copyrightText.setHorizontalAlignment(JLabel.CENTER);
        copyrightText.setVerticalAlignment(JLabel.CENTER);

        txtArea.setText("Deserunt elit amet minim incididunt consequat veniam laborum est. Ut non laboris exercitation duis. Ea esse minim elit consectetur nulla. Ipsum aliquip commodo sunt sint nulla elit. Voluptate labore consequat exercitation do in et laboris. Nisi id non elit mollit anim ex commodo. Voluptate nostrud ea labore magna deserunt ad sint eu anim duis cupidatat aliquip.");

        String[] dataUserHeader = {"Nama", "Username", "Umur"};
        String[][] dataUser = {
            {"Muhammad Luthfi", "ZeeroXc", "19"},
            {"Rifqi Jabrah Rhae", "fortyche", "19"}
        };

        javax.swing.table.DefaultTableModel dmUser = new javax.swing.table.DefaultTableModel(dataUser, dataUserHeader);

        tableUser = new cTable(dmUser);
        spTable = new cScrollPane(tableUser, 348, (int) ch1.getLocation().getY() + 44, 500, 100);

        content.add(infoPulsa);
        content.add(valuePulsa);
        content.add(rd1);
        content.add(ch1);
        content.add(sp);
        content.add(spTable);

        sidebar.add(appText);
        sidebar.add(berandaMenu);
        
        header.add(roleText);
        header.add(exitLink);
        
        main.add(content);
        main.add(menuTitle);
        main.add(copyrightText);

        add(sidebar);
        add(header);
        add(main);
    }

    public cDashboardFrame(String title){
        this();

        setTitle(title);
    }
}