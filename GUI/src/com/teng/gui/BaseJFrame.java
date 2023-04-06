package com.teng.gui;

import javax.swing.*;
import java.awt.*;

public class BaseJFrame {
    public JFrame jframe = null;
    public int screenWidth,screenHeight;

    public JFrame createJframe(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        screenWidth = dimension.width;
        screenHeight = dimension.height;
        jframe = new JFrame("我的第一个GUI");
        jframe.setSize(screenWidth/2,screenHeight/2);
        jframe.setLocation(screenHeight/4,screenHeight/4);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        return jframe;
    }
}
