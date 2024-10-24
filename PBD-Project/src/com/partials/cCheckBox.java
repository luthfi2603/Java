package com.partials;

import javax.swing.JCheckBox;

public class cCheckBox extends JCheckBox {
    public cCheckBox(String text, String value, int x, int y, int width){
        super();

        setBounds(x, y, width, 20);
        setFont(cFonts.RADIO_BUTTON_FONT);
        setForeground(cColors.RED);
        setBackground(cColors.WHITE);
        setHorizontalAlignment(JCheckBox.CENTER);
        setVerticalAlignment(JCheckBox.CENTER);
        setActionCommand(value);
        setText(text);
    }
}