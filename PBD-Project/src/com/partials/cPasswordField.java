package com.partials;

import javax.swing.JPasswordField;

public class cPasswordField extends JPasswordField {
    public cPasswordField(int x, int y, int width, boolean isCenterAlligned){
        super();

        setBounds(x, y, width, 35);

        if(isCenterAlligned){
            setHorizontalAlignment(JPasswordField.CENTER);
        }

        setFont(cFonts.TEXTFIELD_FONT);
        setForeground(cColors.BLACK);
        setBorder(new javax.swing.border.LineBorder(cColors.BLUE, 1));
    }
}