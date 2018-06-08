/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.forms;

import com.verisec.realestateeth.domain.RealEstate;
import com.verisec.realestateeth.domain.User;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Milica Jelic
 */

public class FBuyerTest {
    User user = new User("0x3590aca93338b0721966a8d0c96ebf2c4c87c544", "mica", "mica", "Milica", "Jelic","bc5b578e0dcb2dbf98dd6e5fe62cb5a28b84a55e15fc112d4ca88e1f62bd7c35");
    FBuyer fBuyer = new FBuyer(user);
    
    @Test
    public void filterListForBuyerView (){
    List <RealEstate> expected = new ArrayList<>();
    List <RealEstate> realEstates = new ArrayList<>();
    
    RealEstate re1 = new RealEstate(1, "0x3590aca93338b0721966a8d0c96ebf2c4c87c544", "Francuska 5", 40, 1, 500);
    RealEstate re2 = new RealEstate(2, "0x8cc5a1a0802db41db826c2fcb72423744338dcb0", "Prvomajska 29", 70, 8, 350);
    realEstates.add(re1);
    realEstates.add(re2);
    
    expected.add(re2);
    
    List <RealEstate> actual = fBuyer.filterListForBuyerView(realEstates);
    
    Assert.assertEquals(expected, actual);
    
    }   
    
    @Test
    public void emptyListfilterListForBuyerView (){
    List <RealEstate> expected = new ArrayList<>();
    List <RealEstate> realEstates = new ArrayList<>();
    
    List <RealEstate> actual = fBuyer.filterListForBuyerView(realEstates);
    
    Assert.assertEquals(expected, actual);
    
    }
    
    @Test(expected = Exception.class)
    public void calculateExceptionFilterListForBuyerView() {

        List<RealEstate> realEstates = null;
        fBuyer.filterListForBuyerView(realEstates);
    }
}
