package com.edutilos.applet;

import javax.swing.*;
import java.awt.*;

/**
 * Created by edutilos on 17.06.17.
 */
public class AppletExample2 extends JApplet {
    //properties
    private JLabel lblTitle,
    lblId ,
    lblName,
    lblAge,
    lblWage ,
    lblActive ;
    private JTextField fieldId ,
    fieldName,
    fieldAge ,
    fieldWage,
    fieldActive ;

    private JButton btnSubmit ,
    btnClear ;

    private JTextArea areaDisplay;

    @Override
    public void init() {
        addComponent();
        registerEvents();
    }


    private void addComponent() {
        setLayout(new GridLayout(8, 2));
        //title
        lblTitle = new JLabel("Simple Applet");
        add(lblTitle);
        add(new JLabel());
        //id
        lblId = new JLabel("Id: ");
        add(lblId);
        fieldId = new JTextField();
        fieldId.setToolTipText("Insert your id");
        add(fieldId);
        //name
        lblName = new JLabel("Name: ");
        add(lblName);
        fieldName = new JTextField();
        fieldName.setToolTipText("Insert your name");
        add(fieldName);
        //age
        lblAge = new JLabel("Age: ");
        add(lblAge);
        fieldAge = new JTextField();
        fieldAge.setToolTipText("Insert your age");
        add(fieldAge);
        //wage
        lblWage = new JLabel("Wage: ");
        add(lblWage);
        fieldWage = new JTextField();
        fieldWage.setToolTipText("Insert your wage");
        add(fieldWage);
        //active
        lblActive = new JLabel("Active: ");
        add(lblActive);
        fieldActive = new JTextField();
        fieldActive.setToolTipText("Insert your active");
        add(fieldActive);
        //buttons
        btnSubmit = new JButton("Submit");
        add(btnSubmit);
        btnClear = new JButton("Clear");
        add(btnClear);
        //display
        areaDisplay = new JTextArea(10 , 10);
        add(areaDisplay);
    }


    private final String newline = "\r\n";
    private void registerEvents() {
      btnSubmit.addActionListener(e-> {
          try {
              long id = Long.parseLong(fieldId.getText());
              String name = fieldName.getText();
              int age = Integer.parseInt(fieldAge.getText());
              double wage = Double.parseDouble(fieldWage.getText());
              boolean active = fieldActive.getText().equalsIgnoreCase("true")?true: false;
              StringBuilder sb = new StringBuilder();
              sb.append("id = ").append(id).append(newline)
                      .append("name = ").append(name).append(newline)
                      .append("age = ").append(age).append(newline)
                      .append("wage = ").append(wage).append(newline)
                      .append("active = ").append(active).append(newline);
              areaDisplay.setText(sb.toString());
              JOptionPane.showMessageDialog(AppletExample2.this , sb.toString());
          } catch(Exception ex) {
              areaDisplay.setText(ex.getMessage());
              JOptionPane.showMessageDialog(AppletExample2.this , ex.getMessage());
          }
      });

      btnClear.addActionListener(e-> {
          fieldId.setText("");
          fieldName.setText("");
          fieldAge.setText("");
          fieldWage.setText("");
          fieldActive.setText("");
          areaDisplay.setText("");
      });
    }
}
