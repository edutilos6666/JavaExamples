package com.edutilos.applet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by edutilos on 17.06.17.
 */

/*
appletviewer -J-Djava.security.policy=applet.policy ChartAppletEmbed.html

cat applet.policy
grant {
  permission java.security.AllPermission;
};
 */
public class ChartApplet extends JApplet {
  //properties
    private JLabel lblTitle;
    //tabbedpane
    private JTabbedPane tabbedPane;

    private ChartPanel pieChartPanel,
    barChartPanel,
    lineChartPanel;

    private JButton btnLoadPieChart ,
    btnLoadBarChart ,
    btnLoadLineChart ;

    private final Random rand = new Random();
    @Override
    public void init() {
      addComponents() ;
      registerEvents();
    }


    private void addComponents() {
        //getContentPane().removeAll();
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        //title
       lblTitle = new JLabel("Chart Example");
       getContentPane().add(lblTitle);
       //tabbedPane
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        getContentPane().add(tabbedPane);
        //pieChartPanel
        pieChartPanel  = loadPieChart();
        tabbedPane.add("PieChart", pieChartPanel);
       // tabbedPane.setTitleAt(0, "PieChart");
        //barChartPanel
        barChartPanel = loadBarChart();
        tabbedPane.add("BarChart", barChartPanel);
        //lineChartPanel
        lineChartPanel = loadLineChart();
        tabbedPane.add("LineChart", lineChartPanel);

        //buttins
      /*  btnLoadPieChart = new JButton("Load Pie Chart");
        getContentPane().add(btnLoadPieChart);
        btnLoadBarChart = new JButton("Load Bar Chart");
        getContentPane().add(btnLoadBarChart);
        btnLoadLineChart = new JButton("Load Line Chart");
        getContentPane().add(btnLoadLineChart);*/
    }

    private void registerEvents() {
      /*  btnLoadPieChart.addActionListener(e-> {
            chartPanel = loadPieChart();
        });

        btnLoadBarChart.addActionListener(e-> {
        //    System.out.println("BarChart was");
            chartPanel = loadBarChart();
            addComponents();
            repaint();
        });

        btnLoadLineChart.addActionListener(e-> {
            chartPanel = loadLineChart();
        });*/
    }

    private double generateRandomNumber() {
       return rand.nextDouble()* 100 ;
    }

    private ChartPanel loadPieChart() {
        DefaultPieDataset ds = new DefaultPieDataset();
        String [] keys = {
                "Opera", "Mozilla Firefox", "Google Chrome", "IE9", "Microsoft Edge", "Apple Safari"
        };

        for(String key: keys) {
            ds.setValue(key, generateRandomNumber());
        }

        JFreeChart chart = ChartFactory.createPieChart("Browsers", ds,
                true, true, true);
        ChartPanel ret = new ChartPanel(chart);
        return ret ;
    }



    private ChartPanel loadBarChart() {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        String [] columnKeys = {
                "Opera", "Mozilla Firefox", "Google Chrome", "IE9", "Microsoft Edge", "Apple Safari"
        };
        String [] rowKeys = {
                "Performance", "Popularity", "Price"
        };

        for(String rowKey: rowKeys) {
            for(String colKey: columnKeys) {
              ds.addValue(generateRandomNumber(), rowKey, colKey);
            }
        }
        JFreeChart chart = ChartFactory.createBarChart("Comparison of Browsers",
                "Browsers", "PPP",ds ,  PlotOrientation.VERTICAL,
                true , true, true
                  );
        ChartPanel ret = new ChartPanel(chart);
        return ret ;
    }

    private ChartPanel loadLineChart() {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        List<String> colKeys = new LinkedList<>();
        for(int i=1990; i <= 2000; ++i) {
            colKeys.add(String.valueOf(i));
        }
        String rowKey = "Chrome Popularity from 1990 till 2000";
        for(String colKey: colKeys) {
            ds.addValue(generateRandomNumber(), rowKey, colKey);
        }
        JFreeChart chart = ChartFactory.createLineChart("Chrome Popularity",
                "Chrome", "Value",ds,  PlotOrientation.VERTICAL,
                true, true , true );

        return new ChartPanel(chart);
    }

}
