package com.partials;

import javax.swing.JLabel;

public class cFormLabel extends JLabel {
    public cFormLabel(String text, int x, int y, int width, boolean isCenterAlligned){
        super();

        setText(text);
        setBounds(x, y, width, 30);

        if(isCenterAlligned){
            setHorizontalAlignment(JLabel.CENTER);
        }

        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.FORM_LABEL_FONT);
        setForeground(cColors.BLACK);
    }
}