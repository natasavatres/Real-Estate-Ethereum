/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.forms;

import com.verisec.realestateeth.controller.Controller;
import com.verisec.realestateeth.domain.RealEstate;
import com.verisec.realestateeth.domain.User;
import com.verisec.realestateeth.table.model.RealEstateTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.TableModel;

/**
 *
 * @author Natasa Vatres
 */
public class FSeller extends javax.swing.JFrame {

    /**
     * Creates new form FSeller
     */
    public FSeller() {
        initComponents();
    }

    User currentUser;

    public FSeller(User user) {
        initComponents();
        centerForm();
        currentUser = user;
        populateTableRealEstatesSeller(user);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblRealEstatesSeller = new javax.swing.JTable();
        jBttnRecOffers = new javax.swing.JButton();
        jBttnLogOut = new javax.swing.JButton();
        jBttnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sell real estate");
        setSize(new java.awt.Dimension(810, 410));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Your real estates");

        jTblRealEstatesSeller.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTblRealEstatesSeller);

        jBttnRecOffers.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBttnRecOffers.setText("Check received offers");
        jBttnRecOffers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnRecOffersActionPerformed(evt);
            }
        });

        jBttnLogOut.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBttnLogOut.setText("Log Out");
        jBttnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnLogOutActionPerformed(evt);
            }
        });

        jBttnBack.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBttnBack.setText("Back");
        jBttnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(240, 240, 240)
                .addComponent(jBttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBttnRecOffers, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBttnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jBttnBack))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBttnRecOffers)
                    .addComponent(jBttnLogOut))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBttnRecOffersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnRecOffersActionPerformed
        // TODO add your handling code here:
        JFrame fAcceptOffer = new FAcceptOffer(currentUser);
        fAcceptOffer.setVisible(true);
    }//GEN-LAST:event_jBttnRecOffersActionPerformed

    private void jBttnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnLogOutActionPerformed
        // TODO add your handling code here:
        FLogin fLogin = new FLogin();
        fLogin.setVisible(true);
        currentUser = null;

        this.dispose();
    }//GEN-LAST:event_jBttnLogOutActionPerformed

    private void jBttnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnBackActionPerformed
        // TODO add your handling code here:
        FAllRealEstates fAllRealEstates = new FAllRealEstates(currentUser);
        fAllRealEstates.setVisible(true);

        dispose();
    }//GEN-LAST:event_jBttnBackActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        RealEstateTableModel retm = (RealEstateTableModel) jTblRealEstatesSeller.getModel();
        retm.refreshTable();
    }//GEN-LAST:event_formWindowActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnBack;
    private javax.swing.JButton jBttnLogOut;
    private javax.swing.JButton jBttnRecOffers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblRealEstatesSeller;
    // End of variables declaration//GEN-END:variables
    private void centerForm() {
        setLocationRelativeTo(null);
    }

    Controller controller = new Controller();

    private void populateTableRealEstatesSeller(User seller) {
        try {
            List<RealEstate> realEstates = controller.getAllRealEstates(seller);

            List<RealEstate> filteredListRealEstates = filterListForSellerView(realEstates);

            TableModel tm = new RealEstateTableModel(filteredListRealEstates);
            jTblRealEstatesSeller.setModel(tm);

        } catch (Exception ex) {
            System.out.println("Error in populating table with real estates from seller");
        }
        jTblRealEstatesSeller.disable();
    }

    public List<RealEstate> filterListForSellerView(List<RealEstate> realEstates) {
        List<RealEstate> filtered = new ArrayList<>();

        int index;
        for (int i = 0; i < realEstates.size(); i++) {

            index = -1;
            for (int j = i + 1; j < realEstates.size(); j++) {
                if (realEstates.get(i).getRealEstateAddress().equals(realEstates.get(j).getRealEstateAddress())) {
                    index = i;
                }
            }

            if (index == -1 && realEstates.get(i).getOwnerAddress().equals(currentUser.getAddress())) {
                filtered.add(realEstates.get(i));
            }

        }

        return filtered;
    }
}
