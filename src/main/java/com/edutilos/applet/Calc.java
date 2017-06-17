package com.edutilos.applet;
/* Text from RGC */
/* Coverted to Java 1.1 October 199 by SBJ */

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Calc extends Applet
        implements ActionListener {

    private Button[] bdigit = new Button[10];
    private int number = 0, total = 0;
    private Button cl = new Button("Clear");
    private Button plus = new Button("+");

    public void init() {
        // Each button named by a digit
        for (int i = 0; i < 10; i++) {
            bdigit[i] = new Button(Integer.toString(i));
            bdigit[i].addActionListener(this);
            add(bdigit[i]);
        }
        add(cl); add(plus);
        cl.addActionListener(this);
        plus.addActionListener(this);
    }

    public void paint( Graphics g ) {
        g.drawString( "Total = " + total, 30, 100 );
        g.drawString( "Number = " + number, 30, 120 );
    }

    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == cl) {
            total = 0; number = 0;
        }
        else if (ev.getSource() == plus) {
            total += number;
            number = 0;
        }
        else
            // convert button label to digit
            number = 10 * number + Integer.parseInt(((Button)ev.getSource()).getLabel());
        repaint();
    }
}
