package com.templates;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.partials.cColors;
import com.partials.cExitLink;
import com.partials.cFonts;

public abstract class cStartFrame extends JFrame {
    public JPanel bg = new JPanel();
    public JPanel cardStart = new JPanel();
    public cExitLink exitLink = new cExitLink(1168);
    public JLabel titleStart = new JLabel();

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
        bg.add(exitLink);
        bg.add(cardStart);
        add(bg);
    }

    public cStartFrame(String title){
        this();

        setTitle(title);
    }
}