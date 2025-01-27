package com.partials;

import javax.swing.JTextArea;

public class cTextArea extends JTextArea {
    public cTextArea(boolean isEditAble){
        super();

        setFont(cFonts.TEXTFIELD_FONT);
        setBackground(cColors.WHITE);
        setLineWrap(true);
        setWrapStyleWord(true);

        if(isEditAble){
            setForeground(cColors.BLACK);
        }else{
            setForeground(cColors.RED);
            setEditable(false);
        }
    }

    public cTextArea(String text, int x, int y, boolean editable){
        this(editable);
        setBounds(x, y, 360, 200);
    }
}