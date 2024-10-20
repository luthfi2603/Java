package com.partials;

import javax.swing.JTextField;

public class cTextField extends JTextField {
    public cTextField(int x, int y, int width, boolean isCenterAlligned){
        super();

        setBounds(x, y, width, 35);

        if(isCenterAlligned){
            setHorizontalAlignment(JTextField.CENTER);
        }

        setFont(cFonts.TEXTFIELD_FONT);
        setForeground(cColors.BLACK);
        setBorder(new javax.swing.border.LineBorder(cColors.BLUE, 1));
    }
}