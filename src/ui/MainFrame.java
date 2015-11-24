/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import world.model.Threat;

/**
 *
 * @author boluo
 */
public class MainFrame extends javax.swing.JFrame {


    DefaultListModel listModel;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() 
    {
        this.listModel = new DefaultListModel();
        initComponents();
        this.animationPanel1.start();
        initiateThreatsInList();
        this.jSplitPane1.setDividerLocation(.9);
    }

    private void initiateThreatsInList()
    {
        SimulationComponentsUIx.jList_threats.setModel(listModel);
        List<Threat> threats = animationPanel1.getWorld().getThreats();
        for(Threat threat : threats)
        {
            listModel.addElement(threat);
        }
        SimulationComponentsUIx.jList_threats.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(null, SimulationComponentsUIx.jList_threats.getSelectedValue().toString());
                    }
                }).start();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        rightControlPanel1 = new ui.RightControlPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new java.awt.Dimension(1000, 603));

        jSplitPane1.setDividerLocation(800);
        jSplitPane1.setDividerSize(1);
        jSplitPane1.setMaximumSize(null);
        jSplitPane1.setMinimumSize(new java.awt.Dimension(1300, 985));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(1300, 985));
        this.animationPanel1=new AnimationPanel();

        this.jSplitPane1.add(animationPanel1,  JSplitPane.LEFT);
        jSplitPane1.setRightComponent(rightControlPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void showMainFrame()
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        showMainFrame();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane jSplitPane1;
    private AnimationPanel animationPanel1;
    private ui.RightControlPanel rightControlPanel1;
    // End of variables declaration//GEN-END:variables
}
