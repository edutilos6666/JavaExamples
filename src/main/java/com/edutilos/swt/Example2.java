package com.edutilos.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by edutilos on 18.06.17.
 */
public class Example2 {
    public static void main(String[] args) {
        new Example2().runShell();
    }

    //properties
    private Display display ;
    private Shell shell;
    //title
    private Label lblTitle ;
    //id
    private Label lblId ;
    private Text txtId ;
    //name
    private Label lblName;
    private Text txtName;
    //age
    private Label lblAge;
    private Text txtAge;
    //wage
    private Label lblWage;
    private Text txtWage;
    //active
    private Label lblActive;
    private Text txtActive;
    //buttons
    private Button btnSubmit ,
    btnClear;

    private void runShell() {
      //display & shell
        display = Display.getDefault();
        shell = new Shell(display);
        shell.setSize(new Point(500, 500));
        shell.setLocation(new Point(10, 10));

        //layout
        FormLayout shellLayout = new FormLayout();
        shell.setLayout(shellLayout);

        //title
        lblTitle = new Label(shell, SWT.NONE);
        lblTitle.setText("Worker Details");
        FormData formData = new FormData();
        formData.left = new FormAttachment(100);
        //id
        lblId  = new Label(shell, SWT.NONE);
        lblId.setText("Id: ");
        formData = new FormData();
        formData.top = new FormAttachment(lblTitle, 10, SWT.BOTTOM);
        lblId.setLayoutData(formData);

        txtId = new Text(shell, SWT.BORDER);
        formData = new FormData();
        formData.top = new FormAttachment(lblTitle, 10, SWT.BOTTOM);
        formData.left = new FormAttachment(lblId, 10, SWT.RIGHT);
        txtId.setLayoutData(formData);


        //name
        lblName = new Label(shell, SWT.NONE);
        lblName.setText("Name: ");
        formData = new FormData();
        formData.top = new FormAttachment(lblId, 10 , SWT.BOTTOM);
        lblName.setLayoutData(formData);

        txtName = new Text(shell, SWT.BORDER);
        txtName.setSize(200, 20);
        formData = new FormData();
        formData.top = new FormAttachment(lblId, 10 , SWT.BOTTOM);
        formData.left = new FormAttachment(lblName, 10 , SWT.RIGHT);
        txtName.setLayoutData(formData);


        //age
        lblAge = new Label(shell, SWT.NONE);
        lblAge.setText("Age: ");
        formData = new FormData();
        formData.top = new FormAttachment(lblName, 10 , SWT.BOTTOM);
        lblAge.setLayoutData(formData);

        txtAge = new Text(shell, SWT.BORDER);
        formData = new FormData();
        formData.top = new FormAttachment(lblName , 10 ,  SWT.BOTTOM);
        formData.left = new FormAttachment(lblAge, 10 , SWT.RIGHT);
        txtAge.setLayoutData(formData);

        //wage
        lblWage = new Label(shell, SWT.NONE);
        lblWage.setText("Wage: ");
        formData = new FormData();
        formData.top = new FormAttachment(lblAge, 10 , SWT.BOTTOM);
        lblWage.setLayoutData(formData);

        txtWage  = new Text(shell, SWT.BORDER);
        formData = new FormData();
        formData.top = new FormAttachment(lblAge, 10 , SWT.BOTTOM);
        formData.left = new FormAttachment(lblWage, 10 , SWT.RIGHT);
        txtWage.setLayoutData(formData);


        //active
        lblActive = new Label(shell, SWT.NONE);
        lblActive.setText("Active: ");
        formData = new FormData();
        formData.top = new FormAttachment(lblWage, 10, SWT.BOTTOM);
        lblActive.setLayoutData(formData);

        txtActive = new Text(shell, SWT.BORDER);
        formData = new FormData();
        formData.top = new FormAttachment(lblWage, 10 , SWT.BOTTOM);
        formData.left = new FormAttachment(lblActive, 10 , SWT.RIGHT);
        txtActive.setLayoutData(formData);

        //buttons
        btnSubmit = new Button(shell , SWT.PUSH);
        btnSubmit.setText("Submit");
        formData = new FormData();
        formData.top = new FormAttachment(lblActive, 10 , SWT.BOTTOM);
        btnSubmit.setLayoutData(formData);

        btnClear = new Button(shell, SWT.PUSH);
        btnClear.setText("Clear");
        formData = new FormData();
        formData.top = new FormAttachment(lblActive, 10 , SWT.BOTTOM);
        formData.left = new FormAttachment(btnSubmit, 10 , SWT.RIGHT);
        btnClear.setLayoutData(formData);



        registerEvents();

        shell.open();
        //event loop
        while(!shell.isDisposed()) {
            if(display.readAndDispatch()) display.sleep();
        }
        shell.dispose();



    }

    private final String newline = "\r\n";
    private void registerEvents() {
        btnSubmit.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    long id = Long.parseLong(txtId.getText());
                    String name = txtName.getText();
                    int age = Integer.parseInt(txtAge.getText());
                    double wage = Double.parseDouble(txtWage.getText());
                    boolean active = txtActive.getText().equalsIgnoreCase("true")?true:false;
                    StringBuilder sb = new StringBuilder();
                    sb.append("id = ").append(id).append(newline)
                            .append("name = ").append(name).append(newline)
                            .append("age = ").append(age).append(newline)
                            .append("wage = ").append(wage).append(newline)
                            .append("active = ").append(active).append(newline);
                    MessageBox messageBox = new MessageBox(shell);
                    messageBox.setText("Worker Details");
                    messageBox.setMessage(sb.toString());
                    messageBox.open();
                } catch(Exception ex) {
                    MessageBox messageBox = new MessageBox(shell);
                    messageBox.setText("Exception");
                    messageBox.setMessage(ex.getMessage());
                    messageBox.open();
                }
            }
        });



        btnClear.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                txtId.setText("");
                txtName.setText("");
                txtAge.setText("");
                txtWage.setText("");
                txtActive.setText("");
            }
        });
    }

}
