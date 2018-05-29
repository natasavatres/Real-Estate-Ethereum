/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.domain;

import java.math.BigInteger;

/**
 *
 * @author Natasa Vatres
 */
public class Offer {

    private RealEstate realEstate;
    private BigInteger offer;

    public Offer(RealEstate realEstate, BigInteger offer) {
        this.realEstate = realEstate;
        this.offer = offer;
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
    
    
    
}
