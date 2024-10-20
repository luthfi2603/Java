package com.partials;

import javax.swing.JLabel;

public class cErrorLabel extends JLabel {
    public cErrorLabel(String text, int x, int y, int width, boolean isCenterAlligned){
        super();

        setText(text);
        setBounds(x, y, width, 20);

        if(isCenterAlligned){
            setHorizontalAlignment(JLabel.CENTER);
        }

        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.ERROR_LABEL_FONT);
        setForeground(cColors.RED);
    }
}