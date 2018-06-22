/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.controller;

import com.verisec.realestateeth.domain.beans.User;
import com.verisec.realestateeth.domain.Contracts;
import com.verisec.realestateeth.domain.beans.Offer;
import com.verisec.realestateeth.domain.beans.RealEstate;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Natasa Vatres
 */
public class ContractsController {

    Contracts contract = new Contracts();

    public List<RealEstate> getAllRealEstates(User buyer) throws Exception {
        return contract.getAllRealEstates(buyer);
    }

    public List<RealEstate> getAllRealEstatesFromSeller(User seller) throws Exception {
        return contract.getAllRealEstatesFromSeller(seller);
    }

    public void createBuyerContract(User currentUser, RealEstate currentRealEstate, BigInteger offer) throws Exception {
        contract.createBuyerContract(currentUser, currentRealEstate, offer);
    }

    public List<Offer> getOffersSeller(User seller) throws Exception {
        return contract.getOffersSeller(seller);
    }

    public void acceptOffer(String contractAddress, User seller) throws Exception {
        contract.acceptOffer(contractAddress, seller);
    }

    public void declineOffer(String contractAddress, User seller) throws Exception {
        contract.declineOffer(contractAddress, seller);
    }

    public List<Offer> getAllBuyerOffers(User buyer) throws Exception {
        return contract.getAllBuyerOffers(buyer);
    }

    public void payRealEstate(Offer offer, User buyer) throws Exception {
        contract.payRealEstate(offer, buyer);
    }

    public int getIdForNewRealEstate(User admin) throws Exception {
        return contract.getIdForNewRealEstate(admin);
    }

    public void addRealEstate(RealEstate re) throws Exception {
        contract.addRealEstate(re);
    }

    public void createAdminContract() throws Exception {
        contract.createAdminContract();
    }

    public int getIdByOwnerAndLocation(User currentUser, String ownerAddress, String reAddress) throws Exception {
        return contract.getIdByOwnerAndLocation(currentUser, ownerAddress, reAddress);
    }
}
