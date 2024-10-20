package com.program;

import javax.swing.JFrame;
import javax.swing.JPanel;
import com.partials.cColor;

public class App {
    public static void main(String[] args) throws Exception{
        JFrame myFrame = new JFrame();
        myFrame.setSize(600, 400);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 0, 600, 400);
        panel1.setBackground(cColor.GRAY);

        myFrame.add(panel1);
        myFrame.setVisible(true);
    }
}