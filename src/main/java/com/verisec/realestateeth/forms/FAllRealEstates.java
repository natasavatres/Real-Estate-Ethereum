/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.forms;

import com.verisec.realestateeth.controller.Controller;
import com.verisec.realestateeth.domain.Contracts;
import com.verisec.realestateeth.domain.RealEstate;
import com.verisec.realestateeth.domain.User;
import com.verisec.realestateeth.table.model.RealEstateTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Natasa Vatres
 */
public class FAllRealEstates extends javax.swing.JFrame {

    /**
     * Creates new form FAllRealEstates
     */
    public FAllRealEstates() {
        initComponents();
    }

    User currentUser;

    public FAllRealEstates(User user) {
        initComponents();
        currentUser = user;
        centerForm();
        populateTableAllRealEstates();
        setUpRadioButtons();
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
        jTblAllRealEstates = new javax.swing.JTable();
        jRadioBuyer = new javax.swing.JRadioButton();
        jRadioSeller = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jBttnNext = new javax.swing.JButton();
        jBttnLogOut = new javax.swing.JButton();
        jBttnOwnership = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("All real estates");
        setPreferredSize(new java.awt.Dimension(810, 410));
        setSize(new java.awt.Dimension(810, 410));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("All Real Estates");

        jTblAllRealEstates.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTblAllRealEstates);

        jRadioBuyer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jRadioBuyer.setText("Buyer");

        jRadioSeller.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jRadioSeller.setText("Seller");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Continue as:");

        jBttnNext.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBttnNext.setText("Next");
        jBttnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnNextActionPerformed(evt);
            }
        });

        jBttnLogOut.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBttnLogOut.setText("Log Out");
        jBttnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnLogOutActionPerformed(evt);
            }
        });

        jBttnOwnership.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBttnOwnership.setText("Check ownership history");
        jBttnOwnership.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnOwnershipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioBuyer)
                                    .addComponent(jRadioSeller))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBttnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBttnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jBttnOwnership, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(342, 342, 342)
                            .addComponent(jLabel1))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jRadioBuyer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioSeller)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBttnNext)
                            .addComponent(jBttnLogOut)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jBttnOwnership)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBttnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnLogOutActionPerformed
        // TODO add your handling code here:
        FLogin fLogin = new FLogin();
        fLogin.setVisible(true);

        dispose();
        currentUser = null;
    }//GEN-LAST:event_jBttnLogOutActionPerformed

    private void jBttnOwnershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnOwnershipActionPerformed
        // TODO add your handling code here:
        try {
            int selectedRow = jTblAllRealEstates.getSelectedRow();
            String ownerAddress = (String) jTblAllRealEstates.getValueAt(selectedRow, 0);
            String reAddress = (String) jTblAllRealEstates.getValueAt(selectedRow, 1);

            int id = contracts.getIdByOwnerAndLocation(currentUser, ownerAddress, reAddress);

            FOwnershipHistory fOwnershipHistory = new FOwnershipHistory(currentUser, id);
            fOwnershipHistory.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please select real estate!");
        }
    }//GEN-LAST:event_jBttnOwnershipActionPerformed

    private void jBttnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnNextActionPerformed
        // TODO add your handling code here:
        if(jRadioBuyer.isSelected()){
           FBuyer fBuyer = new FBuyer(currentUser);
           fBuyer.setVisible(true);
           
           dispose();
        }
        
        if(jRadioSeller.isSelected()){
           FSeller fSeller = new FSeller(currentUser);
           fSeller.setVisible(true);
           
           dispose();
        }
    }//GEN-LAST:event_jBttnNextActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        RealEstateTableModel retm = (RealEstateTableModel) jTblAllRealEstates.getModel();
        retm.refreshTable();
    }//GEN-LAST:event_formWindowActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnLogOut;
    private javax.swing.JButton jBttnNext;
    private javax.swing.JButton jBttnOwnership;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioBuyer;
    private javax.swing.JRadioButton jRadioSeller;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblAllRealEstates;
    // End of variables declaration//GEN-END:variables

    private void centerForm() {
        setLocationRelativeTo(null);
    }

    Controller controller = new Controller();
    Contracts contracts = new Contracts();

    private void populateTableAllRealEstates() {
        try {
            List<RealEstate> realEstates = controller.getAllRealEstates(currentUser);

            List<RealEstate> filteredListAllRealEstates = filterListForAllRealEstates(realEstates);

            RealEstateTableModel realEstateTableModel = new RealEstateTableModel(filteredListAllRealEstates);
            jTblAllRealEstates.setModel(realEstateTableModel);

            realEstateTableModel.refreshTable();

        } catch (Exception ex) {
            System.out.println("Error in populating table with real estates");
        }
    }

    protected List<RealEstate> filterListForAllRealEstates(List<RealEstate> realEstates) {
        List<RealEstate> filtered = new ArrayList<>();

        int index;
        for (int i = 0; i < realEstates.size(); i++) {
            index = -1;
            for (int j = i + 1; j < realEstates.size(); j++) {
                if (realEstates.get(i).getRealEstateAddress().equals(realEstates.get(j).getRealEstateAddress())) {
                    index = i;
                }
            }
            if (index == -1) {
                filtered.add(realEstates.get(i));
            }
        }

        return filtered;
    }

    private void setUpRadioButtons() {
        jRadioBuyer.setText("Buyer");
        jRadioSeller.setText("Seller");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioBuyer);
        buttonGroup.add(jRadioSeller);
    }
}
