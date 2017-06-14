package com.edutilos.javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by edutilos on 14.06.17.
 */
public class Example3PieChart extends Application {
    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PieChart pieChart = new PieChart();
        pieChart.setData(getPieChartData());

        StackPane root = new StackPane();
        root.getChildren().add(pieChart);

        primaryStage.setTitle("PieChart Example");
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ObservableList<PieChart.Data> getPieChartData() {
        List<String> labels = Arrays.asList("Opera", "Firefox", "Chrome", "Safari", "IE9", "Edge");
        ObservableList<PieChart.Data> ret = FXCollections.observableArrayList();
        for(String label : labels) {
            PieChart.Data data = new PieChart.Data(label, generateRandomNumber());
            ret.add(data);
        }
        return ret ;
    }

    private  Random rand = new Random();
    private double generateRandomNumber() {
      return rand.nextDouble()* 100 ;
    }
}
