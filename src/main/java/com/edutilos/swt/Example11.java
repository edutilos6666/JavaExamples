package com.edutilos.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by edutilos on 18.06.17.
 */
public class Example11 {
    public static void main(String[] args) {
        new Example11().runShell();
    }

    private Display display;
    private Shell shell;

    private Button btn1, btn2 , btn3;

    private void runShell() {
        //Display
        display = new Display();
        shell = new Shell(display);
        shell.setSize(new Point(500, 500));
        shell.setLocation(new Point(10, 10));

        //set layout
        RowLayout shellLayout = new RowLayout();
        shell.setLayout(shellLayout);
        //add buttons
        btn1 = new Button(shell, SWT.PUSH);
        btn1.setText("Button 1");
        btn2 = new Button(shell, SWT.PUSH);
        btn2.setText("Button 2");
        btn3 = new Button(shell, SWT.PUSH);
        btn3.setText("Button 3");
        registerEvents(btn1);
        registerEvents(btn2);
        registerEvents(btn3);

        //shell event loop
        shell.open();
        while(!shell.isDisposed()) {
            if(!display.readAndDispatch())
                display.sleep();
        }
        shell.dispose();
    }

    private void registerEvents(Button btn) {
        btn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button b = (Button) e.widget;
                System.out.println(b.getText()+  " was selected.");
            }
        });
    }
}
