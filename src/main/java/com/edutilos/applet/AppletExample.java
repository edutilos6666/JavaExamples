package com.edutilos.applet;

import javax.swing.*;
import java.awt.*;

/**
 * Created by edutilos on 17.06.17.
 */
public class AppletExample extends JApplet {

    @Override
    public void paint(Graphics g) {
        int radius = 25 ;
        int width = 150 ;
        int height = 150;
        g.setColor(Color.BLUE);
        g.fillRect(0 , 0, width , height);

        g.setColor(Color.WHITE);
        g.fillOval(width/2 - radius, height/2- radius ,
                2*radius , 2*radius);
    }
}
