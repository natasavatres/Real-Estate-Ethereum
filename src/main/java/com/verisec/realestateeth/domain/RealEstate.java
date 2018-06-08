/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.domain;

import java.util.Objects;

/**
 *
 * @author Natasa Vatres
 */
public class RealEstate {
    private int id;
    private String ownerAddress;
    private String realEstateAddress;
    private int area;
    private int centerDistance;
    private int price;

    public RealEstate() {
    }

    public RealEstate(int id, String ownerAddress, String realEstateAddress, int area, int centerDistance, int price) {
        this.id = id;
        this.ownerAddress = ownerAddress;
        this.realEstateAddress = realEstateAddress;
        this.area = area;
        this.centerDistance = centerDistance;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getRealEstateAddress() {
        return realEstateAddress;
    }

    public void setRealEstateAddress(String realEstateAddress) {
        this.realEstateAddress = realEstateAddress;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getCenterDistance() {
        return centerDistance;
    }

    public void setCenterDistance(int centerDistance) {
        this.centerDistance = centerDistance;
    }

    @Override
    public String toString() {
        return "\n Owner address: " + ownerAddress + "\n Location: " + realEstateAddress + "\n Area: " + area + "\n Distance form center:  " + centerDistance + "\n Price: " + price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RealEstate other = (RealEstate) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.area != other.area) {
            return false;
        }
        if (this.centerDistance != other.centerDistance) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (!Objects.equals(this.ownerAddress, other.ownerAddress)) {
            return false;
        }
        if (!Objects.equals(this.realEstateAddress, other.realEstateAddress)) {
            return false;
        }
        return true;
    }
    
    
}
