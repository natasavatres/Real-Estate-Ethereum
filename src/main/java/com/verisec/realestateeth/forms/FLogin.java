/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.forms;

import com.verisec.realestateeth.domain.User;
import com.verisec.realestateeth.controller.Controller;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Natasa Vatres
 */
public class FLogin extends javax.swing.JFrame {

    /**
     * Creates new form FLogin
     */
    public FLogin() {
        initComponents();
        centerForm();
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
        jTxtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jBttnLogIn = new javax.swing.JButton();
        jTxtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        jLabel1.setText("Username: ");

        jLabel2.setText("Password:");

        jBttnLogIn.setText("Log In");
        jBttnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnLogInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtUsername)
                            .addComponent(jTxtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)))
                    .addComponent(jBttnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jBttnLogIn)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jBttnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnLogInActionPerformed
        try {
            // TODO add your handling code here:
            String username = jTxtUsername.getText().trim();
            String password = jTxtPassword.getText().trim();

            Controller controller = new Controller();
            User user = controller.findUser(username, password);

            if (user == null) {
                JOptionPane.showMessageDialog(this, "There is no user with these credentials!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Welcome " + user.getFirstName() + "!");
                dispose();

                if (user.getRole().equals("admin")) {
                    JFrame fAdmin = new FAdmin();
                    fAdmin.setVisible(true);
                }
                //ne radi ako ne udje admin prvi

                if (user.getRole().equals("buyer")) {
                    JFrame fBuyer = new FBuyer(user);
                    fBuyer.setVisible(true);
                }

                if (user.getRole().equals("seller")) {
                    JFrame fSeller = new FSeller(user);
                    fSeller.setVisible(true);
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "There is no user with these credentials!");
        }
    }//GEN-LAST:event_jBttnLogInActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnLogIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jTxtPassword;
    private javax.swing.JTextField jTxtUsername;
    // End of variables declaration//GEN-END:variables

    private void centerForm() {
        setLocationRelativeTo(null);
    }

}
