/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.domain.beans;

import java.math.BigInteger;

/**
 *
 * @author Natasa Vatres
 */
public class Offer {

    private RealEstate realEstate;
    private BigInteger offer;
    private String contractAddress;
    private String buyerAddress;
    private String status;

    public Offer(RealEstate realEstate, BigInteger offer, String contractAddress, String buyerAddress, String status) {
        this.realEstate = realEstate;
        this.offer = offer;
        this.contractAddress = contractAddress;
        this.buyerAddress = buyerAddress;
        this.status = status;
    }
   
    public BigInteger getOffer() {
        return offer;
    }

    public void setOffer(BigInteger offer) {
        this.offer = offer;
    }

    public RealEstate getRealEstate() {
        return realEstate;
    }

    public void setRealEstate(RealEstate realEstate) {
        this.realEstate = realEstate;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }
    
    
    
}
