/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import config.StaticInitConfig;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author boluo
 */
public class ScoutAndAttackerInitPanel extends javax.swing.JPanel {

    /**
     * Creates new form ScoutAndAttackerInitPanel
     */
    public ScoutAndAttackerInitPanel() {
        initComponents();
        initSpinnerValue();
    }

    private void initSpinnerValue() {
        this.jSpinner2.setModel(new SpinnerNumberModel(StaticInitConfig.SCOUT_NUM, StaticInitConfig.MIN_SPINNER_VALUE, StaticInitConfig.MAX_SPINNER_VALUE, StaticInitConfig.STEP_SIZE_OF_SPINNER));
        this.jSpinner3.setModel(new SpinnerNumberModel(StaticInitConfig.ATTACKER_NUM, StaticInitConfig.MIN_SPINNER_VALUE, StaticInitConfig.MAX_SPINNER_VALUE, StaticInitConfig.STEP_SIZE_OF_SPINNER));
    }

    /**
     *
     */
    public void disabled() {
        jSpinner2.setEnabled(false);
        jSpinner3.setEnabled(false);
    }

    public void enabled() {
        jSpinner2.setEnabled(true);
        jSpinner3.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jSplitPane1 = new javax.swing.JSplitPane();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel2 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();

        setMaximumSize(new java.awt.Dimension(148, 100));
        setMinimumSize(new java.awt.Dimension(148, 100));

        jSplitPane1.setDividerLocation(50);
        jSplitPane1.setDividerSize(1);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jToolBar1.setRollover(true);

        jLabel1.setText("侦察机数量");
        jToolBar1.add(jLabel1);

        jSpinner2.setMaximumSize(new java.awt.Dimension(82, 32767));
        jSpinner2.setMinimumSize(new java.awt.Dimension(82, 28));
        jSpinner2.setPreferredSize(new java.awt.Dimension(82, 28));
        jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner2StateChanged(evt);
            }
        });
        jToolBar1.add(jSpinner2);

        jSplitPane1.setTopComponent(jToolBar1);

        jToolBar2.setRollover(true);

        jLabel2.setText("歼击机数量");
        jToolBar2.add(jLabel2);

        jSpinner3.setMaximumSize(new java.awt.Dimension(82, 32767));
        jSpinner3.setMinimumSize(new java.awt.Dimension(82, 28));
        jSpinner3.setPreferredSize(new java.awt.Dimension(82, 28));
        jSpinner3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner3StateChanged(evt);
            }
        });
        jToolBar2.add(jSpinner3);

        jSplitPane1.setRightComponent(jToolBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner2StateChanged
        // TODO add your handling code here:
        JSpinner source = (JSpinner) evt.getSource();
        StaticInitConfig.SCOUT_NUM = (Integer) source.getValue();
    }//GEN-LAST:event_jSpinner2StateChanged

    private void jSpinner3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner3StateChanged
        // TODO add your handling code here:
        JSpinner source = (JSpinner) evt.getSource();
        StaticInitConfig.ATTACKER_NUM = (Integer) source.getValue();
    }//GEN-LAST:event_jSpinner3StateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
}
