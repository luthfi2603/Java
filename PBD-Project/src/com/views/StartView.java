package com.views;

import com.templates.cStartFrame;
import com.partials.*;

public class StartView extends cStartFrame {
    // komponen di halaman login customer
    private cFormLabel labelNoHpLoginCustomer = new cFormLabel("Nomor HP", 0, 84, 450, true);
    private cTextField txtNoHpLoginCustomer = new cTextField(65, 114, 320, true);
    private cErrorLabel errorNoHpLoginCustomer = new cErrorLabel("Nomor HP kosong/salah!", 0, 149, 450, true);
    private cFormLabel labelPasswordLoginCustomer = new cFormLabel("Password", 0, 183, 450, true);
    private cPasswordField txtPasswordLoginCustomer = new cPasswordField(65, 213, 320, true);
    private cErrorLabel errorPasswordLoginCustomer = new cErrorLabel("Password kosong/salah!", 0, 248, 450, true);
    private cBlueButton btnLoginLoginCustomer = new cBlueButton("Login", 65, 282, 320);
    private cStartLink toLoginMitraLoginCustomer = new cStartLink("Sudah punya akun mitra?", 322);
    private cStartLink toDaftarMitraLoginCustomer = new cStartLink("Daftar sebagai mitra", 342);
    private cStartLink toDaftarCustomerLoginCustomer = new cStartLink("Belum punya akun customer?", 362);
    private cStartLink toLoginAdminLoginCustomer = new cStartLink("Login admin", 382);

    // komponen di halaman daftar customer
    private cFormLabel labelNamaDaftarCustomer = new cFormLabel("Nama", 0, 84, 450, true);
    private cTextField txtNamaDaftarCustomer = new cTextField(65, 114, 320, true);
    private cErrorLabel errorNamaDaftarCustomer = new cErrorLabel("Nama kosong/salah!", 0, 149, 450, true);
    private cFormLabel labelNoHpDaftarCustomer = new cFormLabel("Nomor HP", 0, 183, 450, true);
    private cTextField txtNoHpDaftarCustomer = new cTextField(65, 213, 320, true);
    private cErrorLabel errorNoHpDaftarCustomer = new cErrorLabel("Nomor HP kosong/salah!", 0, 248, 450, true);
    private cFormLabel labelPasswordDaftarCustomer = new cFormLabel("Password", 0, 282, 450, true);
    private cPasswordField txtPasswordDaftarCustomer = new cPasswordField(65, 312, 320, true);
    private cErrorLabel errorPasswordDaftarCustomer = new cErrorLabel("Password kosong/salah!", 0, 347, 450, true);
    private cBlueButton btnDaftarDaftarCustomer = new cBlueButton("Daftar", 65, 381, 320);
    private cStartLink toLoginMitraDaftarCustomer = new cStartLink("Sudah punya akun mitra?", 421);
    private cStartLink toDaftarMitraDaftarCustomer = new cStartLink("Daftar sebagai mitra", 441);
    private cStartLink toLoginCustomerDaftarCustomer = new cStartLink("Sudah punya akun customer?", 461);
    private cStartLink toLoginAdminDaftarCustomer = new cStartLink("Login admin", 481);

    // komponen di halaman login mitra
    private cFormLabel labelEmailLoginMitra = new cFormLabel("Email", 0, 84, 450, true);
    private cTextField txtEmailLoginMitra = new cTextField(65, 114, 320, true);
    private cErrorLabel errorEmailLoginMitra = new cErrorLabel("Email kosong/salah!", 0, 149, 450, true);
    private cFormLabel labelPasswordLoginMitra = new cFormLabel("Password", 0, 183, 450, true);
    private cPasswordField txtPasswordLoginMitra = new cPasswordField(65, 213, 320, true);
    private cErrorLabel errorPasswordLoginMitra = new cErrorLabel("Password kosong/salah!", 0, 248, 450, true);
    private cBlueButton btnLoginLoginMitra = new cBlueButton("Login", 65, 282, 320);
    private cStartLink toDaftarMitraLoginMitra = new cStartLink("Belum punya akun mitra?", 322);
    private cStartLink toDaftarCustomerLoginMitra = new cStartLink("Daftar sebagai customer", 342);
    private cStartLink toLoginCustomerLoginMitra = new cStartLink("Sudah punya akun customer?", 362);
    private cStartLink toLoginAdminLoginMitra = new cStartLink("Login admin", 382);

    // komponen di halaman daftar mitra
    private cFormLabel labelNamaDaftarMitra = new cFormLabel("Nama", 0, 84, 450, true);
    private cTextField txtNamaDaftarMitra = new cTextField(65, 114, 320, true);
    private cErrorLabel errorNamaDaftarMitra = new cErrorLabel("Nama kosong/salah!", 0, 149, 450, true);
    private cFormLabel labelEmailDaftarMitra = new cFormLabel("Email", 0, 183, 450, true);
    private cTextField txtEmailDaftarMitra = new cTextField(65, 213, 320, true);
    private cErrorLabel errorEmailDaftarMitra = new cErrorLabel("Email kosong/salah!", 0, 248, 450, true);
    private cFormLabel labelPasswordDaftarMitra = new cFormLabel("Password", 0, 282, 450, true);
    private cPasswordField txtPasswordDaftarMitra = new cPasswordField(65, 312, 320, true);
    private cErrorLabel errorPasswordDaftarMitra = new cErrorLabel("Password kosong/salah!", 0, 347, 450, true);
    private cBlueButton btnDaftarDaftarMitra = new cBlueButton("Daftar", 65, 381, 320);
    private cStartLink toLoginMitraDaftarMitra = new cStartLink("Sudah punya akun mitra?", 421);
    private cStartLink toDaftarCustomerDaftarMitra = new cStartLink("Daftar sebagai customer", 441);
    private cStartLink toLoginCustomerDaftarMitra = new cStartLink("Sudah punya akun customer?", 461);
    private cStartLink toLoginAdminDaftarMitra = new cStartLink("Login admin", 481);

    // komponen di halaman login admin
    private cFormLabel labelUsernameLoginAdmin = new cFormLabel("Username", 0, 84, 450, true);
    private cTextField txtUsernameLoginAdmin = new cTextField(65, 114, 320, true);
    private cErrorLabel errorUsernameLoginAdmin = new cErrorLabel("Username kosong/salah!", 0, 149, 450, true);
    private cFormLabel labelPasswordLoginAdmin = new cFormLabel("Password", 0, 183, 450, true);
    private cPasswordField txtPasswordLoginAdmin = new cPasswordField(65, 213, 320, true);
    private cErrorLabel errorPasswordLoginAdmin = new cErrorLabel("Password kosong/salah!", 0, 248, 450, true);
    private cBlueButton btnLoginLoginAdmin = new cBlueButton("Login", 65, 282, 320);
    private cStartLink toDaftarMitraLoginAdmin = new cStartLink("Belum punya akun mitra?", 322);
    private cStartLink toLoginMitraLoginAdmin = new cStartLink("Sudah punya akun mitra?", 342);
    private cStartLink toDaftarCustomerLoginAdmin = new cStartLink("Daftar sebagai customer", 362);
    private cStartLink toLoginCustomerLoginAdmin = new cStartLink("Sudah punya akun customer?", 382);

    public StartView(){
        super();
    }

    public void initsLoginCustomer(){
        this.setTitle("Login Customer");
        cardStart.removeAll();
        titleStart.setText("Login Customer");
        cardStart.add(titleStart);
        cardStart.add(labelNoHpLoginCustomer);
        cardStart.add(txtNoHpLoginCustomer);
        // cardStart.add(errorNoHpLoginCustomer);
        cardStart.add(labelPasswordLoginCustomer);
        cardStart.add(txtPasswordLoginCustomer);
        // cardStart.add(errorPasswordLoginCustomer);
        cardStart.add(btnLoginLoginCustomer);
        cardStart.add(toLoginMitraLoginCustomer);
        cardStart.add(toDaftarMitraLoginCustomer);
        cardStart.add(toDaftarCustomerLoginCustomer);
        cardStart.add(toLoginAdminLoginCustomer);
    }

    public void initsDaftarCustomer(){
        this.setTitle("Daftar Customer");
        cardStart.removeAll();
        titleStart.setText("Daftar Customer");
        cardStart.add(titleStart);
        cardStart.add(labelNamaDaftarCustomer);
        cardStart.add(txtNamaDaftarCustomer);
        // cardStart.add(errorNamaDaftarCustomer);
        cardStart.add(labelNoHpDaftarCustomer);
        cardStart.add(txtNoHpDaftarCustomer);
        // cardStart.add(errorNoHpDaftarCustomer);
        cardStart.add(labelPasswordDaftarCustomer);
        cardStart.add(txtPasswordDaftarCustomer);
        // cardStart.add(errorPasswordDaftarCustomer);
        cardStart.add(btnDaftarDaftarCustomer);
        cardStart.add(toLoginMitraDaftarCustomer);
        cardStart.add(toDaftarMitraDaftarCustomer);
        cardStart.add(toLoginCustomerDaftarCustomer);
        cardStart.add(toLoginAdminDaftarCustomer);
    }

    public void initsLoginMitra(){
        this.setTitle("Login Mitra");
        cardStart.removeAll();
        titleStart.setText("Login Mitra");
        cardStart.add(titleStart);
        cardStart.add(labelEmailLoginMitra);
        cardStart.add(txtEmailLoginMitra);
        // cardStart.add(errorEmailLoginMitra);
        cardStart.add(labelPasswordLoginMitra);
        cardStart.add(txtPasswordLoginMitra);
        // cardStart.add(errorPasswordLoginMitra);
        cardStart.add(btnLoginLoginMitra);
        cardStart.add(toDaftarMitraLoginMitra);
        cardStart.add(toDaftarCustomerLoginMitra);
        cardStart.add(toLoginCustomerLoginMitra);
        cardStart.add(toLoginAdminLoginMitra);
    }

    public void initsDaftarMitra(){
        this.setTitle("Daftar Mitra");
        cardStart.removeAll();
        titleStart.setText("Daftar Mitra");
        cardStart.add(titleStart);
        cardStart.add(labelNamaDaftarMitra);
        cardStart.add(txtNamaDaftarMitra);
        // cardStart.add(errorNamaDaftarMitra);
        cardStart.add(labelEmailDaftarMitra);
        cardStart.add(txtEmailDaftarMitra);
        // cardStart.add(errorEmailDaftarMitra);
        cardStart.add(labelPasswordDaftarMitra);
        cardStart.add(txtPasswordDaftarMitra);
        // cardStart.add(errorPasswordDaftarMitra);
        cardStart.add(btnDaftarDaftarMitra);
        cardStart.add(toLoginMitraDaftarMitra);
        cardStart.add(toDaftarCustomerDaftarMitra);
        cardStart.add(toLoginCustomerDaftarMitra);
        cardStart.add(toLoginAdminDaftarMitra);
    }

    public void initsLoginAdmin(){
        this.setTitle("Login Admin");
        cardStart.removeAll();
        titleStart.setText("Login Admin");
        cardStart.add(titleStart);
        cardStart.add(labelUsernameLoginAdmin);
        cardStart.add(txtUsernameLoginAdmin);
        // cardStart.add(errorUsernameLoginAdmin);
        cardStart.add(labelPasswordLoginAdmin);
        cardStart.add(txtPasswordLoginAdmin);
        // cardStart.add(errorPasswordLoginAdmin);
        cardStart.add(btnLoginLoginAdmin);
        cardStart.add(toDaftarMitraLoginAdmin);
        cardStart.add(toLoginMitraLoginAdmin);
        cardStart.add(toDaftarCustomerLoginAdmin);
        cardStart.add(toLoginCustomerLoginAdmin);
    }
}