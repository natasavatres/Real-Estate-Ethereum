/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tuples.generated.Tuple6;

/**
 *
 * @author Natasa Vatres
 */
public class ContractsTest {

    private User user = new User("0x3590aca93338b0721966a8d0c96ebf2c4c87c544", "mica", "mica", "Milica", "Jelic", "bc5b578e0dcb2dbf98dd6e5fe62cb5a28b84a55e15fc112d4ca88e1f62bd7c35");
    private Contracts contracts = new Contracts();

    @Test
    public void testCreateRealEstatesList() throws Exception {

        BuyingSelling contract = Mockito.mock(BuyingSelling.class);
        List<BigInteger> realEstateIds = new ArrayList<>();
        realEstateIds.add(BigInteger.ONE);
        RemoteCall<List> remoteCalls = Mockito.mock(RemoteCall.class);
        Mockito.when(contract.getAllRealEstates()).thenReturn(remoteCalls);
        Mockito.when(remoteCalls.send()).thenReturn(realEstateIds);
        Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger> realEstate
                = new Tuple6<>(BigInteger.valueOf(1), "address", "realEs", BigInteger.valueOf(2), BigInteger.valueOf(2), BigInteger.valueOf(2));

        RemoteCall<Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger>> remoteCallTuple = Mockito.mock(RemoteCall.class);
        Mockito.when(contract.getRealEstate(BigInteger.ONE)).thenReturn(remoteCallTuple);
        Mockito.when(remoteCallTuple.send()).thenReturn(realEstate);
        List<RealEstate> actual = contracts.createRealEstatesList(contract);
        List<RealEstate> expected = new ArrayList<>();
        expected.add(new RealEstate(1, "address", "realEs", 2, 2, 2));
        Assert.assertEquals(expected, actual);

    }
}
