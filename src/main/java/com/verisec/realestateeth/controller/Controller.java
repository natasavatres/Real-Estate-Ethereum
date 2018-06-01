/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.controller;

import com.verisec.realestateeth.domain.User;
import com.verisec.realestateeth.db.DatabaseRepository;
import com.verisec.realestateeth.domain.BuyingSelling;
import com.verisec.realestateeth.domain.Contracts;
import com.verisec.realestateeth.domain.Offer;
import com.verisec.realestateeth.domain.RealEstate;
import com.verisec.realestateeth.domain.TransferingFunds;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple6;

/**
 *
 * @author Natasa Vatres
 */
public class Controller {

    public List<RealEstate> getAllRealEstates(User buyer) throws Exception {
        Contracts contract = new Contracts();
        return contract.getAllRealEstates(buyer);
    }

    public List<RealEstate> getAllRealEstatesFromSeller(User seller) throws Exception {
        Contracts contract = new Contracts();
        return contract.getAllRealEstatesFromSeller(seller);
    }

    public User findUser(String un, String pass) throws Exception {
        DatabaseRepository dbr = new DatabaseRepository();
        return dbr.findUser(un, pass);
    }

    public String getPrivateKey(String username) throws Exception {
        DatabaseRepository dbr = new DatabaseRepository();
        return dbr.getPrivateKey(username);
    }

    public void addAdminContract(BuyingSelling contract) {
        DatabaseRepository dbr = new DatabaseRepository();
        dbr.addAdminContract(contract);
    }

    public void createBuyerContract(User currentUser, RealEstate currentRealEstate, BigInteger offer) throws Exception {
        Contracts contract = new Contracts();
        contract.createBuyerContract(currentUser, currentRealEstate, offer);
    }

    public List<Offer> getOffersSeller(User seller) throws Exception {
        Contracts contract = new Contracts();
        return contract.getOffersSeller(seller);
    }

    public void acceptOffer(String contractAddress, User seller) throws Exception {
        Contracts contract = new Contracts();
        contract.acceptOffer(contractAddress, seller);
    }

    public void declineOffer(String contractAddress, User seller) throws Exception {
        Contracts contract = new Contracts();
        contract.declineOffer(contractAddress, seller);
    }

    public List<Offer> getAllBuyerOffers(User buyer) throws Exception {
        Contracts contract = new Contracts();
        return contract.getAllBuyerOffers(buyer);
    }

    public void deleteContract(String contractAddress) {
        DatabaseRepository dbr = new DatabaseRepository();
        dbr.deleteContract(contractAddress);
    }

    public void payRealEstate(Offer offer, User buyer) throws Exception {
        Contracts contract = new Contracts();
        contract.payRealEstate(offer, buyer);
    }

}
