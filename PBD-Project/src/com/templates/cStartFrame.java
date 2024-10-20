package com.templates;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.partials.cBlueButton;
import com.partials.cColors;
import com.partials.cErrorLabel;
import com.partials.cExitLink;
import com.partials.cFonts;
import com.partials.cFormLabel;
import com.partials.cGreenButton;
import com.partials.cRedButton;
import com.partials.cStartLink;
import com.partials.cTextField;

public class cStartFrame extends JFrame {
    public JPanel bg = new JPanel();
    public JPanel cardStart = new JPanel();
    public cExitLink exitLink = new cExitLink(1168);
    public JLabel titleStart = new JLabel("Title Start");
    public cFormLabel labelUsername = new cFormLabel("Username", 0, 84, 450, true);
    public cTextField txtUsernmae = new cTextField(65, 114, 320, true);
    public cErrorLabel errorUsername = new cErrorLabel("Username tidak boleh kosong!", 0, 149, 450, true);
    public cStartLink link1 = new cStartLink("Menuju ke mana?", 200);
    public cRedButton btnMerah = new cRedButton("Merah", 65, 282, 320);
    public cGreenButton btnHijau = new cGreenButton("Hijau", 65, 341, 320);
    public cBlueButton btnSubmit = new cBlueButton("Submit", 65, 400, 320);

    public cStartFrame(){
        super();

        setSize(1280, 720);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(cStartFrame.EXIT_ON_CLOSE);

        bg.setBackground(cColors.BLUE);
        bg.setBounds(0, 0, 1280, 720);
        bg.setLayout(null);

        cardStart.setBackground(cColors.WHITE90);
        cardStart.setBounds(415, 90, 450, 540);
        cardStart.setLayout(null);

        titleStart.setFont(cFonts.TITLE_START_FONT);
        titleStart.setForeground(cColors.BLACK);
        titleStart.setBounds(0, 30, 450, 40);
        titleStart.setHorizontalAlignment(JLabel.CENTER);
        titleStart.setVerticalAlignment(JLabel.CENTER);

        cardStart.add(titleStart);
        cardStart.add(labelUsername);
        cardStart.add(txtUsernmae);
        cardStart.add(errorUsername);
        cardStart.add(btnMerah);
        cardStart.add(btnHijau);
        cardStart.add(btnSubmit);
        cardStart.add(link1);
        bg.add(exitLink);
        bg.add(cardStart);
        add(bg);
    }

    public cStartFrame(String title){
        this();

        setTitle(title);
    }
}