package com.edutilos.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by edutilos on 14.06.17.
 */
public class Example2GridPane extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        root.setHgap(5);
        root.setVgap(5);
        root.setPadding(new Insets(5));
        //title
        Label lblTitle = new Label("Person Details");
        root.add(lblTitle, 0 , 0);
        //id
        Label lblId = new Label("Id: ");
        TextField fieldId = new TextField();
        root.add(lblId , 0, 1);
        root.add(fieldId, 1, 1);
        //name
        Label lblName = new Label("Name: ");
        TextField fieldName = new TextField();
        root.add(lblName, 0, 2);
        root.add(fieldName, 1, 2);
        //age
        Label lblAge = new Label("Age: ");
        TextField fieldAge = new TextField();
        root.add(lblAge , 0, 3);
        root.add(fieldAge, 1,3);
        //wage
        Label lblWage = new Label("Wage: ");
        TextField fieldWage = new TextField();
        root.add(lblWage, 0, 4);
        root.add(fieldWage, 1, 4);
        //active
        Label lblActive = new Label("Active: ");
        TextField fieldActive = new TextField();
        root.add(lblActive , 0 , 5);
        root.add(fieldActive, 1, 5);
        //Buttons
        Button btnSubmit = new Button("Submit");
        Button btnCancel = new Button("Cancel");
        root.add(btnSubmit, 0 , 6);
        root.add(btnCancel , 1, 6);

        String newline = "\r\n";
        //events
        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("btnSubmit was clicked.");
                alert.setHeaderText("btnSubmit header");
                StringBuilder builder = new StringBuilder();
                try {
                    String activeStr = fieldActive.getText();
                    boolean active = false ;
                    if(activeStr.equalsIgnoreCase("true")) active = true ;
                    builder.append("Id: ").append(Long.parseLong(fieldId.getText())).append(newline)
                            .append("Name: ").append(fieldName.getText()).append(newline)
                            .append("Age: ").append(Integer.parseInt(fieldAge.getText())).append(newline)
                            .append("Wage: ").append(Double.parseDouble(fieldWage.getText())).append(newline)
                            .append("Active: ").append(active).append(newline);
                    alert.setContentText(builder.toString());
                } catch(Exception ex) {
                    alert.setContentText(ex.getMessage());
                }

                alert.showAndWait();

            }
        });

        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               fieldId.clear();
               fieldName.clear();
               fieldAge.clear();
               fieldWage.clear();
               fieldActive.clear();
            }
        });

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
