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
}