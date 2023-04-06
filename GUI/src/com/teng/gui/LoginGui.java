package com.teng.gui;

import javax.swing.*;
import java.awt.*;

public class LoginGui extends BaseJFrame{
    private JPanel jpl = new JPanel();

    public LoginGui(){
        JLabel jLabel = new JLabel("欢迎使用我的第一个Lable",SwingConstants.LEFT);
//        jLabel.setLocation(0,0);
//        jLabel.;
        jpl.add(jLabel);
    }

    public void startLoading(){
//        createJframe();
        Container container = createJframe().getContentPane();
        container.add(jpl);
    }


}
