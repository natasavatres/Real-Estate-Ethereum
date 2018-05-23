/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.controller;

import com.verisec.realestateeth.domain.User;
import com.verisec.realestateeth.db.DatabaseRepository;
import com.verisec.realestateeth.domain.RealEstate;
import java.util.List;

/**
 *
 * @author Natasa Vatres
 */
public class Controller {

    public static List<RealEstate> getAllRealEstates() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public User findUser(String un, String pass) throws Exception {
        DatabaseRepository dbr = new DatabaseRepository();
        return dbr.findUser(un, pass);
    }
    
}
