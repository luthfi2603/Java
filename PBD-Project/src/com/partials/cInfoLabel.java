package com.partials;

import javax.swing.JLabel;

public class cInfoLabel extends JLabel {
    public cInfoLabel(String text, int x, int y){
        super();

        setText(text);
        setBounds(x, y, 450, 40);
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.INFO_LABEL_FONT);
        setForeground(cColors.BLACK);
    }
}