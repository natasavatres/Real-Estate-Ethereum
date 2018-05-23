/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.domain;

import com.verisec.realestateeth.forms.FLogin;
import javax.swing.JFrame;

/**
 *
 * @author Natasa Vatres
 */
public class Login {

    public static void main(String[] args) {

//        String username = args[0];
//        String password = args[1];
//
//        ArrayList<User> users = new UserCollection().getUsers();
//        User loggedUser = null;
//        Contract contract = new Contract();
//
//        for (User user : users) {
//            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
//                loggedUser = user;
//                System.out.println("Ulogovan je korisnik sa adresom: " + loggedUser.getAddress());
//            }
//        }
//
//        if (loggedUser.getRole().equals(Role.BUYER)) {
//            contract.buyerContract(loggedUser.getAddress(), "0x3590aca93338b0721966a8d0c96ebf2c4c87c544");
//        }
//        
//        if(loggedUser.getRole().equals(Role.SELLER)){
//            contract.sellerContract(loggedUser.getAddress());
//        }

        JFrame fLogin = new FLogin();
        fLogin.setVisible(true);

    }
}
