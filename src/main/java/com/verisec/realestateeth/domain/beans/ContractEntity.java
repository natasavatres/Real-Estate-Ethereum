/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.domain.beans;

import java.util.Date;

/**
 *
 * @author Natasa Vatres
 */
public class ContractEntity {
    private String addressContract;
    private String addressBuyer;
    private String addressSeller;
    private int idRealEstate;
    private Date date;

    public ContractEntity(String addressContract, String addressBuyer, String addressSeller, int idRealEstate, Date date) {
        this.addressContract = addressContract;
        this.addressBuyer = addressBuyer;
        this.addressSeller = addressSeller;
        this.idRealEstate = idRealEstate;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddressContract() {
        return addressContract;
    }

    public void setAddressContract(String addressContract) {
        this.addressContract = addressContract;
    }

    public String getAddressBuyer() {
        return addressBuyer;
    }

    public void setAddressBuyer(String addressBuyer) {
        this.addressBuyer = addressBuyer;
    }

    public String getAddressSeller() {
        return addressSeller;
    }

    public void setAddressSeller(String addressSeller) {
        this.addressSeller = addressSeller;
    }

    public int getIdRealEstate() {
        return idRealEstate;
    }

    public void setIdRealEstate(int idRealEstate) {
        this.idRealEstate = idRealEstate;
    }
    
    
}
