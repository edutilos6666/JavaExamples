package com.edutilos.main;


import javax.swing.*;
import java.awt.*;

public class SimpleSwingExample extends JFrame {
    public static void main(String[] args) {
         SimpleSwingExample sse = new SimpleSwingExample();
         sse.init();
    }

    /*
    * properties
     */
    private JPanel mainPanel;
    private GridLayout mainLayout ;
    private JLabel lblTitle , lblId , lblName, lblAge, lblWage, lblActive;
    private JTextField fieldId, fieldName, fieldAge, fieldWage, fieldActive;
    private JButton btnSubmit , btnCancel ;

    public void init() {
      this.setTitle("Simple Swing Example");
      this.setSize(new Dimension(500, 500));
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      this.setLocation(new Point(10, 10));
      this.setResizable(false);
      addComponents();
      registerEvents();
      this.setVisible(true);
    }

    private void addComponents() {
      mainPanel = new JPanel();
      mainLayout = new GridLayout(7, 2);
      mainPanel.setLayout(mainLayout);
      this.getContentPane().add(mainPanel);
      //title
        lblTitle = new JLabel("Person Details");
        mainPanel.add(lblTitle);
        mainPanel.add(new JLabel());
        //id
        lblId = new JLabel("Id: ");
        fieldId = new JTextField();
        fieldId.setToolTipText("Insert your id");
        mainPanel.add(lblId);
        mainPanel.add(fieldId);

        //name
        lblName = new JLabel("Name: ");
        fieldName = new JTextField();
        fieldName.setToolTipText("Insert your name");
        mainPanel.add(lblName);
        mainPanel.add(fieldName);

        //age
        lblAge = new JLabel("Age: ");
        fieldAge = new JTextField();
        fieldAge.setToolTipText("Insert your age");
        mainPanel.add(lblAge);
        mainPanel.add(fieldAge);

        //wage
        lblWage = new JLabel("Wage: ");
        fieldWage = new JTextField();
        fieldWage.setToolTipText("Insert your wage");
        mainPanel.add(lblWage);
        mainPanel.add(fieldWage);

        //active
        lblActive = new JLabel("Active: ");
        fieldActive = new JTextField();
        fieldActive.setToolTipText("Insert if you are active or not");
        mainPanel.add(lblActive);
        mainPanel.add(fieldActive);

        //buttons
        btnSubmit = new JButton("Submit");
        btnCancel = new JButton("Cancel");
        mainPanel.add(btnSubmit);
        mainPanel.add(btnCancel);
    }

    private static final String newline = "\r\n";
    private void registerEvents() {
       btnSubmit.addActionListener(e -> {
           try {
              long id = Long.parseLong(fieldId.getText());
              String name = fieldName.getText();
              int age = Integer.parseInt(fieldAge.getText());
              double wage = Double.parseDouble(fieldWage.getText());
              String activeStr = fieldActive.getText();
              boolean active = false ;
              if(activeStr.equalsIgnoreCase("true")) active = true ;
              StringBuilder builder = new StringBuilder();
              builder.append("Id = ").append(id).append(newline)
                      .append("Name = ").append(name).append(newline)
                      .append("Age = ").append(age).append(newline)
                      .append("Wage = ").append(wage).append(newline)
                      .append("Active = ").append(active).append(newline);
              JOptionPane.showMessageDialog(SimpleSwingExample.this, builder.toString());
           } catch(Exception ex) {
               JOptionPane.showMessageDialog(SimpleSwingExample.this , ex.getMessage());
           }
       });


       btnCancel.addActionListener(e -> {
           fieldId.setText("");
           fieldName.setText("");
           fieldAge.setText("");
           fieldWage.setText("");
           fieldActive.setText("");
       });
    }

}
