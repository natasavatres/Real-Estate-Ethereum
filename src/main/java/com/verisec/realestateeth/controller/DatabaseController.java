/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.controller;

import com.verisec.realestateeth.db.DatabaseRepository;
import com.verisec.realestateeth.domain.beans.ContractEntity;
import com.verisec.realestateeth.domain.beans.RealEstate;
import com.verisec.realestateeth.domain.beans.User;
import com.verisec.realestateeth.domain.generated.BuyingSelling;
import com.verisec.realestateeth.domain.generated.TransferingFunds;
import java.security.MessageDigest;
import java.util.List;

/**
 *
 * @author Natasa Vatres
 */
public class DatabaseController {

    DatabaseRepository dbr = new DatabaseRepository();

    public User findUser(String un, String pass) throws Exception {
        return dbr.findUser(un, pass);
    }

    public String getPrivateKey(String username) throws Exception {
        return dbr.getPrivateKey(username);
    }

    public void addAdminContract(BuyingSelling contract) {
        dbr.addAdminContract(contract);
    }

    public void deleteContract(String contractAddress) {
        dbr.deleteContract(contractAddress);
    }

    public String encrypt(String password) throws Exception {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        return bytesToHex(md.digest());

    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

    public String getContractAddress(String addressBuyer, String addressSeller) throws Exception {
        return dbr.getContractAddress(addressBuyer, addressBuyer);
    }

    public void addContract(User buyer, RealEstate realEstate, TransferingFunds contractTF) {
        dbr.addContract(buyer, realEstate, contractTF);
    }

    public List<ContractEntity> getContractsWithSeller(User seller) {
        return dbr.getContractsWithSeller(seller);
    }

    public List<ContractEntity> getAllBuyerContracts(User buyer) {
        return dbr.getAllBuyerContracts(buyer);
    }
}
