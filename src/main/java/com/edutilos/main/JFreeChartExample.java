package com.edutilos.main;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JFreeChartExample {
    public static void main(String[] args) {
     // showChart(createPieChart(), "PieChartExample");
    //   showChart(createBarChart(), "BarChartExample");
       showChart(createLineChart(), "LineChartExample");
    }

    private static void showChart(ChartPanel panel, String title) {
        JFrame mainFrame = new JFrame(title);
        mainFrame.setSize(new Dimension(500, 500));
        mainFrame.setLocation(new Point(10, 10));
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setContentPane(panel);
        mainFrame.setVisible(true);
    }




    private static ChartPanel createLineChart() {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        int beginYear = 1990;
        String rowKey = "Employment Rate";
        for(int i= beginYear; i< 2000; ++i) {
            ds.addValue(generateRandomNumber(), rowKey, String.valueOf(i));
        }

        JFreeChart chart =ChartFactory.createLineChart("Employment in the USA",
                "Years", "Employment Rate", ds, PlotOrientation.VERTICAL, true, true, true);


        ChartPanel ret = new ChartPanel(chart);
        return ret ;
    }

    private static ChartPanel createBarChart() {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        String [] columnKeys = {
                "Chrome", "Firefox", "Opera", "IE", "Edge"
        };
        String [] rowKeys = {
           "Performance", "Price" , "Popularity"
        };

        for(String rowKey:rowKeys) {
            for(String columnKey: columnKeys) {
                ds.addValue(generateRandomNumber(), rowKey, columnKey);
            }
        }

        JFreeChart chart = ChartFactory.createBarChart("Browsers", "Browsers", "Criterion", ds, PlotOrientation.HORIZONTAL, true, true, true);
        ChartPanel ret = new ChartPanel(chart);
        return ret ;
    }


    private static ChartPanel createPieChart() {
        DefaultPieDataset ds = new DefaultPieDataset();
        List<String> keys = Arrays.asList(
                "Chrome", "Firefox", "Opera", "IE", "Edge"
        );
        for(String key: keys) {
            ds.setValue(key, generateRandomNumber());
        }
        JFreeChart chart = ChartFactory.createPieChart("Browsers",
                ds , true, true, true);
        ChartPanel ret = new ChartPanel(chart);
        return ret ;
    }

    private static Random rand = new Random();
    private static double generateRandomNumber() {
        return rand.nextDouble()* 100 ;
    }
}
