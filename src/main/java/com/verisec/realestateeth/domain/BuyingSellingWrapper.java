package com.verisec.realestateeth.domain;
import com.verisec.realestateeth.domain.BuyingSelling;
import java.math.BigInteger;
import java.util.List;
import org.web3j.tuples.generated.Tuple6;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natasa Vatres
 */
public class BuyingSellingWrapper {

    BuyingSelling contractBS;
    
    public BuyingSellingWrapper(BuyingSelling buyingSelling) {
        contractBS = buyingSelling;
    }
        
    public Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger> getRealEstateWrapper(BigInteger id) throws Exception{
        return contractBS.getRealEstate(id).send();
    }
    
    public List<BigInteger> getAllRealEstatesWrapper() throws Exception{
        return contractBS.getAllRealEstates().send();
    }
}
