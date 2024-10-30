package com.partials;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class cExitLink extends JLabel {
    public cExitLink(int x){
        super();

        setBounds(x, 0, 82, 70);
        setText("Keluar");
        setFont(cFonts.EXIT_LINK_FONT);
        setForeground(cColors.WHITE);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent e){
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
            public void mouseClicked(java.awt.event.MouseEvent e){
                Object[] options = {"Iya", "Batal"};
                int konfirmasi = JOptionPane.showOptionDialog(null, "Yakin ingin keluar aplikasi?", "Konfirmasi Keluar", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if(konfirmasi == 0){
                    System.exit(0);
                }
            }
        });
    }
}