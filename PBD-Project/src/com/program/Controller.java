package com.program;

import com.views.StartView;

public class Controller {
    private static StartView frameLoginAndRegister = new StartView();

    public static void showLoginCustomer(){
        frameLoginAndRegister.setVisible(false);
        frameLoginAndRegister.initsLoginCustomer();
        frameLoginAndRegister.setVisible(true);
    }
    
    public static void showDaftarCustomer(){
        frameLoginAndRegister.setVisible(false);
        frameLoginAndRegister.initsDaftarCustomer();
        frameLoginAndRegister.setVisible(true);
    }
    
    public static void showLoginMitra(){
        frameLoginAndRegister.setVisible(false);
        frameLoginAndRegister.initsLoginMitra();
        frameLoginAndRegister.setVisible(true);
    }
    
    public static void showDaftarMitra(){
        frameLoginAndRegister.setVisible(false);
        frameLoginAndRegister.initsDaftarMitra();
        frameLoginAndRegister.setVisible(true);
    }
    
    public static void showLoginAdmin(){
        
    }
    
    public static void showDashboardCustomer(Integer id){
        
    }
    
    public static void showDashboardMitra(Integer id){
        
    }
    
    public static void showDashboardAdmin(boolean statusLogin){
        
    }
}