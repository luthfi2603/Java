package com.partials;

import javax.swing.JRadioButton;

public class cRadioButton extends JRadioButton {
    public cRadioButton(String text, String value, int x, int y, int width){
        super();

        setBounds(x, y, width, 20);
        setFont(cFonts.RADIO_BUTTON_FONT);
        setForeground(cColors.RED);
        setBackground(cColors.WHITE);
        setHorizontalAlignment(JRadioButton.CENTER);
        setVerticalAlignment(JRadioButton.CENTER);
        setActionCommand(value);
        setText(text);
    }
}