package com.edutilos.applet;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.*;

/**
 * Created by edutilos on 17.06.17.
 */
public class CalculatorApplet extends JApplet {

    /**
     *
     * properties
     */
    private JLabel lblTitle ;
    private  JTextArea display ;
    private JButton btn0, btn1, btn2, btn3,btn4 ,
    btn5, btn6, btn7, btn8, btn9 ,
    btnAdd, btnSubtract , btnMultiply, btnDivide ,
    btnModulo ,
    btnLeftParen, btnRightParent , btnEquals ,
    btnClear;

    ScriptEngineManager sem;
    ScriptEngine js;
    @Override
    public void init() {
        sem = new ScriptEngineManager();
        js = sem.getEngineByName("js");
        addComponents();
        registerEvents();
    }

    private void addComponents() {
        //layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        //title
        lblTitle = new JLabel("Simple Calculator");
        add(lblTitle);
        //display
        display = new JTextArea(10 , 10);
        add(display);
        //buttons
        JPanel panelControls = new JPanel(new GridLayout(4, 5));
        add(panelControls);
        btn0 = new JButton("0");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btnAdd = new JButton("+");
        btnSubtract = new JButton("-");
        btnMultiply = new JButton("*");
        btnDivide = new JButton("/");
        btnModulo = new JButton("%");
        btnLeftParen = new JButton("(");
        btnRightParent = new JButton(")");
        btnEquals = new JButton("=");
        btnClear = new JButton("C");
        JButton[] buttons = {
                btn0 , btn1, btn2, btn3, btn4,
                btn5, btn6, btn7, btn8, btn9 ,
                btnAdd , btnSubtract, btnMultiply, btnDivide, btnModulo,
                btnLeftParen, btnRightParent, btnEquals, btnClear
        };
        for(JButton btn: buttons) {
            panelControls.add(btn);
        }
    }

    private void registerEvents() {
        JButton[] buttons = {
                btn0 , btn1, btn2, btn3, btn4,
                btn5, btn6, btn7, btn8, btn9 ,
                btnAdd , btnSubtract, btnMultiply, btnDivide, btnModulo,
                btnLeftParen, btnRightParent
        };

        for(JButton btn: buttons) {
            btn.addActionListener(e-> {
                JButton src = (JButton)e.getSource();
                String txt = src.getText();
                switch(txt) {
                    case "0":
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                    case "9":
                        display.setText(display.getText()+ txt);
                        break;
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case "(":
                    case ")":
                        display.setText(display.getText()+" "+ txt+ " ");
                        break;
                }
            });
        }



        btnClear.addActionListener(e ->{
            display.setText("");
        });

        btnEquals.addActionListener(e-> {
            try {

                Object value = js.eval(display.getText()).toString();
                display.setText(display.getText() + " = "+ value.toString());
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(CalculatorApplet.this, ex.getMessage());
            }
        });

    }
}
