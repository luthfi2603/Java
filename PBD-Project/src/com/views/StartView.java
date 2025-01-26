package com.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.partials.*;
import com.program.Controller;
import com.program.Model;
import com.templates.cStartFrame;

public class StartView extends cStartFrame {
    // komponen di halaman login customer
    private cFormLabel labelNoHpLoginCustomer = new cFormLabel("Nomor HP", 0, 84, 450, true);
    private cTextField txtNoHpLoginCustomer = new cTextField(65, 114, 320, true);
    private cErrorLabel errorNoHpLoginCustomer = new cErrorLabel("Nomor HP kosong!", 0, 149, 450, true);
    private cFormLabel labelPasswordLoginCustomer = new cFormLabel("Password", 0, 183, 450, true);
    private cPasswordField txtPasswordLoginCustomer = new cPasswordField(65, 213, 320, true);
    private cErrorLabel errorPasswordLoginCustomer = new cErrorLabel("Password kosong!", 0, 248, 450, true);
    private cBlueButton btnLoginLoginCustomer = new cBlueButton("Login", 65, 282, 320);
    private cStartLink toLoginMitraLoginCustomer = new cStartLink("Sudah punya akun mitra?", 322);
    private cStartLink toDaftarMitraLoginCustomer = new cStartLink("Daftar sebagai mitra", 342);
    private cStartLink toDaftarCustomerLoginCustomer = new cStartLink("Belum punya akun customer?", 362);
    private cStartLink toLoginAdminLoginCustomer = new cStartLink("Login admin", 382);

    // komponen di halaman daftar customer
    private cFormLabel labelNamaDaftarCustomer = new cFormLabel("Nama", 0, 84, 450, true);
    private cTextField txtNamaDaftarCustomer = new cTextField(65, 114, 320, true);
    private cErrorLabel errorNamaDaftarCustomer = new cErrorLabel("Nama kosong!", 0, 149, 450, true);
    private cFormLabel labelNoHpDaftarCustomer = new cFormLabel("Nomor HP", 0, 183, 450, true);
    private cTextField txtNoHpDaftarCustomer = new cTextField(65, 213, 320, true);
    private cErrorLabel errorNoHpDaftarCustomer = new cErrorLabel("Nomor HP kosong!", 0, 248, 450, true);
    private cFormLabel labelPasswordDaftarCustomer = new cFormLabel("Password", 0, 282, 450, true);
    private cPasswordField txtPasswordDaftarCustomer = new cPasswordField(65, 312, 320, true);
    private cErrorLabel errorPasswordDaftarCustomer = new cErrorLabel("Password kosong!", 0, 347, 450, true);
    private cBlueButton btnDaftarDaftarCustomer = new cBlueButton("Daftar", 65, 381, 320);
    private cStartLink toLoginMitraDaftarCustomer = new cStartLink("Sudah punya akun mitra?", 421);
    private cStartLink toDaftarMitraDaftarCustomer = new cStartLink("Daftar sebagai mitra", 441);
    private cStartLink toLoginCustomerDaftarCustomer = new cStartLink("Sudah punya akun customer?", 461);
    private cStartLink toLoginAdminDaftarCustomer = new cStartLink("Login admin", 481);

    // komponen di halaman login mitra
    private cFormLabel labelEmailLoginMitra = new cFormLabel("Email", 0, 84, 450, true);
    private cTextField txtEmailLoginMitra = new cTextField(65, 114, 320, true);
    private cErrorLabel errorEmailLoginMitra = new cErrorLabel("Email kosong!", 0, 149, 450, true);
    private cFormLabel labelPasswordLoginMitra = new cFormLabel("Password", 0, 183, 450, true);
    private cPasswordField txtPasswordLoginMitra = new cPasswordField(65, 213, 320, true);
    private cErrorLabel errorPasswordLoginMitra = new cErrorLabel("Password kosong!", 0, 248, 450, true);
    private cBlueButton btnLoginLoginMitra = new cBlueButton("Login", 65, 282, 320);
    private cStartLink toDaftarMitraLoginMitra = new cStartLink("Belum punya akun mitra?", 322);
    private cStartLink toDaftarCustomerLoginMitra = new cStartLink("Daftar sebagai customer", 342);
    private cStartLink toLoginCustomerLoginMitra = new cStartLink("Sudah punya akun customer?", 362);
    private cStartLink toLoginAdminLoginMitra = new cStartLink("Login admin", 382);

    // komponen di halaman daftar mitra
    private cFormLabel labelNamaDaftarMitra = new cFormLabel("Nama", 0, 84, 450, true);
    private cTextField txtNamaDaftarMitra = new cTextField(65, 114, 320, true);
    private cErrorLabel errorNamaDaftarMitra = new cErrorLabel("Nama kosong!", 0, 149, 450, true);
    private cFormLabel labelEmailDaftarMitra = new cFormLabel("Email", 0, 183, 450, true);
    private cTextField txtEmailDaftarMitra = new cTextField(65, 213, 320, true);
    private cErrorLabel errorEmailDaftarMitra = new cErrorLabel("Email kosong!", 0, 248, 450, true);
    private cFormLabel labelPasswordDaftarMitra = new cFormLabel("Password", 0, 282, 450, true);
    private cPasswordField txtPasswordDaftarMitra = new cPasswordField(65, 312, 320, true);
    private cErrorLabel errorPasswordDaftarMitra = new cErrorLabel("Password kosong!", 0, 347, 450, true);
    private cBlueButton btnDaftarDaftarMitra = new cBlueButton("Daftar", 65, 381, 320);
    private cStartLink toLoginMitraDaftarMitra = new cStartLink("Sudah punya akun mitra?", 421);
    private cStartLink toDaftarCustomerDaftarMitra = new cStartLink("Daftar sebagai customer", 441);
    private cStartLink toLoginCustomerDaftarMitra = new cStartLink("Sudah punya akun customer?", 461);
    private cStartLink toLoginAdminDaftarMitra = new cStartLink("Login admin", 481);

    // komponen di halaman login admin
    private cFormLabel labelUsernameLoginAdmin = new cFormLabel("Username", 0, 84, 450, true);
    private cTextField txtUsernameLoginAdmin = new cTextField(65, 114, 320, true);
    private cErrorLabel errorUsernameLoginAdmin = new cErrorLabel("Username kosong!", 0, 149, 450, true);
    private cFormLabel labelPasswordLoginAdmin = new cFormLabel("Password", 0, 183, 450, true);
    private cPasswordField txtPasswordLoginAdmin = new cPasswordField(65, 213, 320, true);
    private cErrorLabel errorPasswordLoginAdmin = new cErrorLabel("Password kosong!", 0, 248, 450, true);
    private cBlueButton btnLoginLoginAdmin = new cBlueButton("Login", 65, 282, 320);
    private cStartLink toDaftarMitraLoginAdmin = new cStartLink("Belum punya akun mitra?", 322);
    private cStartLink toLoginMitraLoginAdmin = new cStartLink("Sudah punya akun mitra?", 342);
    private cStartLink toDaftarCustomerLoginAdmin = new cStartLink("Daftar sebagai customer", 362);
    private cStartLink toLoginCustomerLoginAdmin = new cStartLink("Sudah punya akun customer?", 382);

    public StartView() {
        super();

        // link di frame login customer
        toLoginMitraLoginCustomer.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showLoginMitra();
            }
        });
        toDaftarMitraLoginCustomer.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showDaftarMitra();
            }
        });
        toDaftarCustomerLoginCustomer.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showDaftarCustomer();
            }
        });
        toLoginAdminLoginCustomer.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showLoginAdmin();
            }
        });
        
        // link di frame daftar customer
        toLoginMitraDaftarCustomer.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showLoginMitra();
            }
        });
        toDaftarMitraDaftarCustomer.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showDaftarMitra();
            }
        });
        toLoginCustomerDaftarCustomer.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showLoginCustomer();
            }
        });
        toLoginAdminDaftarCustomer.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showLoginAdmin();
            }
        });
        
        // link di frame login mitra
        toDaftarMitraLoginMitra.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showDaftarMitra();
            }
        });
        toDaftarCustomerLoginMitra.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showDaftarCustomer();
            }
        });
        toLoginCustomerLoginMitra.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showLoginCustomer();
            }
        });
        toLoginAdminLoginMitra.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showLoginAdmin();
            }
        });
        
        // link di frame daftar mitra
        toLoginMitraDaftarMitra.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showLoginMitra();
            }
        });
        toDaftarCustomerDaftarMitra.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showDaftarCustomer();
            }
        });
        toLoginCustomerDaftarMitra.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showLoginCustomer();
            }
        });
        toLoginAdminDaftarMitra.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showLoginAdmin();
            }
        });
        
        // link di frame login admin
        toDaftarMitraLoginAdmin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showDaftarMitra();
            }
        });
        toLoginMitraLoginAdmin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showLoginMitra();
            }
        });
        toDaftarCustomerLoginAdmin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showDaftarCustomer();
            }
        });
        toLoginCustomerLoginAdmin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showLoginCustomer();
            }
        });
    }

    public void initsLoginCustomer() {
        if (btnLoginLoginCustomer.getActionListeners().length == 0) {
            btnLoginLoginCustomer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    String noHp = txtNoHpLoginCustomer.getText();
                    String password = String.valueOf(txtPasswordLoginCustomer.getPassword());

                    if (noHp.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                        Controller.showLoginCustomer();

                        if (noHp.equalsIgnoreCase("")) {
                            cardStart.add(errorNoHpLoginCustomer);
                        }

                        if (password.equalsIgnoreCase("")) {
                            cardStart.add(errorPasswordLoginCustomer);
                        }
                    } else {
                        if (Model.verifikasiAkunCustomer(noHp, password)) {
                            txtNoHpLoginCustomer.setText(null);
                            txtPasswordLoginCustomer.setText(null);

                            Controller.showDashboardCustomer(Integer.parseInt(Model.getDetailCustomerByNoHp(noHp)[0].toString()));
                        } else {
                            JOptionPane.showMessageDialog(StartView.this, "Silahkan periksa nomor hp dan password", "Login Gagal", JOptionPane.ERROR_MESSAGE);

                            Controller.showLoginCustomer();
                        }
                    }
                }
            });
        }

        this.setTitle("Login Customer");
        cardStart.removeAll();
        titleStart.setText("Login Customer");
        cardStart.add(titleStart);
        cardStart.add(labelNoHpLoginCustomer);
        cardStart.add(txtNoHpLoginCustomer);
        cardStart.add(labelPasswordLoginCustomer);
        cardStart.add(txtPasswordLoginCustomer);
        cardStart.add(btnLoginLoginCustomer);
        cardStart.add(toLoginMitraLoginCustomer);
        cardStart.add(toDaftarMitraLoginCustomer);
        cardStart.add(toDaftarCustomerLoginCustomer);
        cardStart.add(toLoginAdminLoginCustomer);
    }

    public void initsDaftarCustomer() {
        if (btnDaftarDaftarCustomer.getActionListeners().length == 0) {
            btnDaftarDaftarCustomer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    String nama = txtNamaDaftarCustomer.getText();
                    String noHp = txtNoHpDaftarCustomer.getText();
                    String password = String.valueOf(txtPasswordDaftarCustomer.getPassword());

                    if (nama.equalsIgnoreCase("") || noHp.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                        Controller.showDaftarCustomer();

                        if (nama.equalsIgnoreCase("")) {
                            cardStart.add(errorNamaDaftarCustomer);
                        }

                        if (noHp.equalsIgnoreCase("")) {
                            cardStart.add(errorNoHpDaftarCustomer);
                        }

                        if (password.equalsIgnoreCase("")) {
                            cardStart.add(errorPasswordDaftarCustomer);
                        }
                    } else {
                        if (Model.verifikasiNoHpCustomer(noHp)) {
                            if (Model.daftarCustomer(nama, noHp, password)) {
                                txtNamaDaftarCustomer.setText(null);
                                txtNoHpDaftarCustomer.setText(null);
                                txtPasswordDaftarCustomer.setText(null);

                                JOptionPane.showMessageDialog(StartView.this, "Daftar customer berhasil", "Daftar Berhasil", JOptionPane.INFORMATION_MESSAGE);

                                Controller.showLoginCustomer();
                            } else {
                                JOptionPane.showMessageDialog(StartView.this, "Daftar customer gagal", "Daftar Gagal", JOptionPane.ERROR_MESSAGE);
                                
                                Controller.showDaftarCustomer();
                            }
                        } else {
                            JOptionPane.showMessageDialog(StartView.this, "Nomor hp sudah digunakan", "Daftar Gagal", JOptionPane.ERROR_MESSAGE);

                            Controller.showDaftarCustomer();
                        }
                    }
                }
            });
        }

        this.setTitle("Daftar Customer");
        cardStart.removeAll();
        titleStart.setText("Daftar Customer");
        cardStart.add(titleStart);
        cardStart.add(labelNamaDaftarCustomer);
        cardStart.add(txtNamaDaftarCustomer);
        cardStart.add(labelNoHpDaftarCustomer);
        cardStart.add(txtNoHpDaftarCustomer);
        cardStart.add(labelPasswordDaftarCustomer);
        cardStart.add(txtPasswordDaftarCustomer);
        cardStart.add(btnDaftarDaftarCustomer);
        cardStart.add(toLoginMitraDaftarCustomer);
        cardStart.add(toDaftarMitraDaftarCustomer);
        cardStart.add(toLoginCustomerDaftarCustomer);
        cardStart.add(toLoginAdminDaftarCustomer);
    }

    public void initsLoginMitra() {
        if (btnLoginLoginMitra.getActionListeners().length == 0) {
            btnLoginLoginMitra.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    String email = txtEmailLoginMitra.getText();
                    String password = String.valueOf(txtPasswordLoginMitra.getPassword());

                    if (email.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                        Controller.showLoginMitra();

                        if (email.equalsIgnoreCase("")) {
                            cardStart.add(errorEmailLoginMitra);
                        }

                        if (password.equalsIgnoreCase("")) {
                            cardStart.add(errorPasswordLoginMitra);
                        }
                    } else {
                        if (Model.verifikasiAkunMitra(email, password)) {
                            txtEmailLoginMitra.setText(null);
                            txtPasswordLoginMitra.setText(null);

                            Controller.showDashboardMitra(Integer.parseInt(Model.getDetailMitraByEmail(email)[0].toString()));
                        } else {
                            JOptionPane.showMessageDialog(StartView.this, "Silahkan periksa email dan password", "Login Gagal", JOptionPane.ERROR_MESSAGE);

                            Controller.showLoginMitra();
                        }
                    }
                }
            });
        }

        this.setTitle("Login Mitra");
        cardStart.removeAll();
        titleStart.setText("Login Mitra");
        cardStart.add(titleStart);
        cardStart.add(labelEmailLoginMitra);
        cardStart.add(txtEmailLoginMitra);
        cardStart.add(labelPasswordLoginMitra);
        cardStart.add(txtPasswordLoginMitra);
        cardStart.add(btnLoginLoginMitra);
        cardStart.add(toDaftarMitraLoginMitra);
        cardStart.add(toDaftarCustomerLoginMitra);
        cardStart.add(toLoginCustomerLoginMitra);
        cardStart.add(toLoginAdminLoginMitra);
    }

    public void initsDaftarMitra() {
        if (btnDaftarDaftarMitra.getActionListeners().length == 0) {
            btnDaftarDaftarMitra.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    String nama = txtNamaDaftarMitra.getText();
                    String email = txtEmailDaftarMitra.getText();
                    String password = String.valueOf(txtPasswordDaftarMitra.getPassword());

                    if (nama.equalsIgnoreCase("") || email.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                        Controller.showDaftarMitra();

                        if (nama.equalsIgnoreCase("")) {
                            cardStart.add(errorNamaDaftarMitra);
                        }

                        if (email.equalsIgnoreCase("")) {
                            cardStart.add(errorEmailDaftarMitra);
                        }

                        if (password.equalsIgnoreCase("")) {
                            cardStart.add(errorPasswordDaftarMitra);
                        }
                    } else {
                        if (Model.verifikasiEmailMitra(email)) {
                            if (Model.daftarMitra(nama, email, password)) {
                                txtNamaDaftarMitra.setText(null);
                                txtEmailDaftarMitra.setText(null);
                                txtPasswordDaftarMitra.setText(null);

                                JOptionPane.showMessageDialog(StartView.this, "Daftar mitra berhasil", "Daftar Berhasil", JOptionPane.INFORMATION_MESSAGE);

                                Controller.showLoginMitra();
                            } else {
                                JOptionPane.showMessageDialog(StartView.this, "Daftar mitra gagal", "Daftar Gagal", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(StartView.this, "Email sudah digunakan", "Daftar Gagal", JOptionPane.ERROR_MESSAGE);

                            Controller.showDaftarMitra();
                        }
                    }
                }
            });
        }

        this.setTitle("Daftar Mitra");
        cardStart.removeAll();
        titleStart.setText("Daftar Mitra");
        cardStart.add(titleStart);
        cardStart.add(labelNamaDaftarMitra);
        cardStart.add(txtNamaDaftarMitra);
        cardStart.add(labelEmailDaftarMitra);
        cardStart.add(txtEmailDaftarMitra);
        cardStart.add(labelPasswordDaftarMitra);
        cardStart.add(txtPasswordDaftarMitra);
        cardStart.add(btnDaftarDaftarMitra);
        cardStart.add(toLoginMitraDaftarMitra);
        cardStart.add(toDaftarCustomerDaftarMitra);
        cardStart.add(toLoginCustomerDaftarMitra);
        cardStart.add(toLoginAdminDaftarMitra);
    }

    public void initsLoginAdmin() {
        if (btnLoginLoginAdmin.getActionListeners().length == 0) {
            btnLoginLoginAdmin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    String username = txtUsernameLoginAdmin.getText();
                    String password = String.valueOf(txtPasswordLoginAdmin.getPassword());

                    if (username.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                        Controller.showLoginAdmin();

                        if (username.equalsIgnoreCase("")) {
                            cardStart.add(errorUsernameLoginAdmin);
                        }

                        if (password.equalsIgnoreCase("")) {
                            cardStart.add(errorPasswordLoginAdmin);
                        }
                    } else {
                        if (username.equals("admin") && password.equals("password")) {
                            txtUsernameLoginAdmin.setText(null);
                            txtPasswordLoginAdmin.setText(null);

                            Controller.showDashboardAdmin(true);
                        } else {
                            JOptionPane.showMessageDialog(StartView.this, "Silahkan periksa username dan password", "Login Gagal", JOptionPane.ERROR_MESSAGE);

                            Controller.showLoginAdmin();
                        }
                    }
                }
            });
        }

        this.setTitle("Login Admin");
        cardStart.removeAll();
        titleStart.setText("Login Admin");
        cardStart.add(titleStart);
        cardStart.add(labelUsernameLoginAdmin);
        cardStart.add(txtUsernameLoginAdmin);
        cardStart.add(labelPasswordLoginAdmin);
        cardStart.add(txtPasswordLoginAdmin);
        cardStart.add(btnLoginLoginAdmin);
        cardStart.add(toDaftarMitraLoginAdmin);
        cardStart.add(toLoginMitraLoginAdmin);
        cardStart.add(toDaftarCustomerLoginAdmin);
        cardStart.add(toLoginCustomerLoginAdmin);
    }
}