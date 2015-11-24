/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author BRIGHTER AGYEMANG
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import chart.ChartDatastore;
import config.StaticInitConfig;
import java.util.Collections;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AnalysisBarChart extends JFrame
{        
    Lock lock = new ReentrantLock();
    private final int inforSharingAlg;
    private final String algStr;
    
    public AnalysisBarChart(int inforSharingAlg, String algStr) 
    {
        super("Messages Chart - "+algStr);
        this.inforSharingAlg = inforSharingAlg;
        this.algStr = algStr;
        // This method is invoked on the EDT thread
        final JFXPanel fxPanel = new JFXPanel();
        JPanel jpanel = new JPanel();
        jpanel.add(fxPanel);
        this.add(jpanel);
        this.setSize(820, 650);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() 
        {
            @Override
            public void run() 
            {
                SwingUtilities.invokeLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    {
                        Platform.runLater(new Runnable() 
                        {
                            @Override
                            public void run() 
                            {
                                initFX(fxPanel);
                            }
                        });
                    }
                });
            }
        }, 500, 5000);
    }

    private void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private Scene createScene() 
    {
        lock.lock();
        try 
        {
            final CategoryAxis xAxis = new CategoryAxis();
            final NumberAxis yAxis = new NumberAxis();
//            yAxis.setUpperBound(500);
//            yAxis.setAutoRanging(false);
            final BarChart<String,Number> bc =  new BarChart<>(xAxis,yAxis);
            bc.setTitle("Communication - "+this.algStr);
            xAxis.setLabel("Time (t)");
            yAxis.setLabel("Messages (m)");
            
            XYChart.Series series1 = new XYChart.Series();
            series1.setName("Messages sent to UAVs at time t of simulation");
            
            ChartDatastore chartDatastore = new ChartDatastore();
            Map<Integer, Integer> gData = (inforSharingAlg==StaticInitConfig.BROADCAST_INFOSHARE)?
                    chartDatastore.getMessagesPerSecondData_broadcast():
                    chartDatastore.getMessagesPerSecondData_register();
            Map<Integer, Integer> gDataSync = Collections.synchronizedMap(gData);
            for(Integer t : gDataSync.keySet())
            {
                series1.getData().add(new XYChart.Data(String.valueOf(t), gData.get(t)));
            }
            
            bc.getData().addAll(series1);
            bc.setAnimated(false);
            Scene scene  = new Scene(bc,800,600);
            return scene;
        } finally {
            lock.unlock();
        }
    }
}
