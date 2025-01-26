package com.program;

import com.views.*;

public class Controller {
    private static StartView frameLoginAndRegister = new StartView();

    public static void showLoginCustomer() {
        frameLoginAndRegister.setVisible(false);
        frameLoginAndRegister.initsLoginCustomer();
        frameLoginAndRegister.setVisible(true);
    }
    
    public static void showDaftarCustomer() {
        frameLoginAndRegister.setVisible(false);
        frameLoginAndRegister.initsDaftarCustomer();
        frameLoginAndRegister.setVisible(true);
    }
    
    public static void showLoginMitra() {
        frameLoginAndRegister.setVisible(false);
        frameLoginAndRegister.initsLoginMitra();
        frameLoginAndRegister.setVisible(true);
    }
    
    public static void showDaftarMitra() {
        frameLoginAndRegister.setVisible(false);
        frameLoginAndRegister.initsDaftarMitra();
        frameLoginAndRegister.setVisible(true);
    }
    
    public static void showLoginAdmin() {
        frameLoginAndRegister.setVisible(false);
        frameLoginAndRegister.initsLoginAdmin();
        frameLoginAndRegister.setVisible(true);
    }
    
    public static void showDashboardCustomer(Integer id) {
        frameLoginAndRegister.setVisible(false);

        DashboardCustomerView dashboardCustomer = new DashboardCustomerView(id);
        dashboardCustomer.setVisible(true);
    }
    
    public static void showDashboardMitra(Integer id) {
        frameLoginAndRegister.setVisible(false);

        DashboardMitraView dashboardMitra = new DashboardMitraView(id);
        dashboardMitra.setVisible(true);
    }
    
    public static void showDashboardAdmin(boolean statusLogin) {
        frameLoginAndRegister.setVisible(false);

        DashboardAdminView dashboardAdmin = new DashboardAdminView(statusLogin);
        dashboardAdmin.setVisible(true);
    }
}