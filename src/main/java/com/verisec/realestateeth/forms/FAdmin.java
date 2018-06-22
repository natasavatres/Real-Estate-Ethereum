/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.forms;

import com.verisec.realestateeth.controller.ContractsController;
import com.verisec.realestateeth.controller.DatabaseController;
import com.verisec.realestateeth.db.DatabaseRepository;
import com.verisec.realestateeth.domain.Contracts;
import com.verisec.realestateeth.domain.beans.User;
import static com.verisec.realestateeth.forms.FAdmin.logger;

/**
 *
 * @author Natasa Vatres
 */
public class FAdmin extends javax.swing.JFrame {

    /**
     * Creates new form FAdmin
     */
    User admin;
    ContractsController contractsController = new ContractsController();
    DatabaseController databaseController = new DatabaseController();

    public FAdmin(User user) {
        initComponents();
        centerForm();
        admin = user;
        firstFormView();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblMessage = new javax.swing.JLabel();
        jBttnAddRealEstate = new javax.swing.JButton();
        jBttnLogOut = new javax.swing.JButton();
        jBttnStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLblMessage.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jBttnAddRealEstate.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBttnAddRealEstate.setText("Add real estate");
        jBttnAddRealEstate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnAddRealEstateActionPerformed(evt);
            }
        });

        jBttnLogOut.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBttnLogOut.setText("Log Out");
        jBttnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnLogOutActionPerformed(evt);
            }
        });

        jBttnStart.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBttnStart.setText("Start application");
        jBttnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(93, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBttnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBttnAddRealEstate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBttnLogOut)))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jBttnStart)
                .addGap(18, 18, 18)
                .addComponent(jLblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBttnAddRealEstate)
                    .addComponent(jBttnLogOut))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBttnAddRealEstateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnAddRealEstateActionPerformed
        // TODO add your handling code here:
        FAddRealEstate fAddRealEstate = new FAddRealEstate(admin);
        fAddRealEstate.setVisible(true);
    }//GEN-LAST:event_jBttnAddRealEstateActionPerformed

    private void jBttnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnStartActionPerformed
        // TODO add your handling code here:
        try {
            contractsController.createAdminContract();

            jLblMessage.setText("Application successfully started!");
            jBttnAddRealEstate.setEnabled(true);
            jBttnStart.setEnabled(false);
        } catch (Exception e) {
            logger.error("Error in Real Estate Contract deploy!", e);
            jLblMessage.setText("Error in Real Estate Contract deploy!");
        }

    }//GEN-LAST:event_jBttnStartActionPerformed

    private void jBttnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnLogOutActionPerformed
        // TODO add your handling code here:
        FLogin fLogin = new FLogin();
        fLogin.setVisible(true);
        admin = null;

        dispose();
    }//GEN-LAST:event_jBttnLogOutActionPerformed

    private void centerForm() {
        setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnAddRealEstate;
    private javax.swing.JButton jBttnLogOut;
    private javax.swing.JButton jBttnStart;
    private javax.swing.JLabel jLblMessage;
    // End of variables declaration//GEN-END:variables
final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(FAdmin.class);

    private void firstFormView() {
        jBttnStart.setEnabled(false);
        jBttnAddRealEstate.setEnabled(false);

        try {
            String adminContractAddress = databaseController.getContractAddress("000", "000");
            
            jLblMessage.setText("Application successfully started!");
            jBttnAddRealEstate.setEnabled(true);

        } catch (Exception ex) {
            jBttnStart.setEnabled(true);
        }

    }

}
