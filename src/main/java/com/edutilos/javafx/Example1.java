package com.edutilos.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;

/**
 * Created by edutilos on 14.06.17.
 */
public class Example1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        List<String> params = getParameters().getRaw();
        for(String param: params) {
            System.out.println(param);
        }

        Button btnHelloWorld = new Button();
        btnHelloWorld.setText("Hello World");
        btnHelloWorld.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("btnHelloWorld says 'Hello World'");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btnHelloWorld);
        Scene scene = new Scene(root , 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
