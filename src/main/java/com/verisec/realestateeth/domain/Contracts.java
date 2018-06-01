/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.domain;

import com.verisec.realestateeth.controller.Controller;
import com.verisec.realestateeth.db.DatabaseRepository;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple6;
import static org.web3j.tx.Contract.GAS_LIMIT;
import static org.web3j.tx.ManagedTransaction.GAS_PRICE;

/**
 *
 * @author Natasa Vatres
 */
public class Contracts {

    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Contracts.class);
    int cost = 100;

    DatabaseRepository databaseRepository;
    Controller controller;
    BuyingSelling contractBS;
    TransferingFunds contractTF;

    public Contracts() {
        databaseRepository = new DatabaseRepository();
        controller = new Controller();
    }

    public void createBuyerContract(User buyer, RealEstate realEstate, BigInteger offer) throws Exception {

            HttpService httpService = new HttpService("http://localhost:8545");
            Web3j web3 = Web3j.build(httpService);

            EthGetBalance ethGetBalance3 = web3.ethGetBalance(buyer.getAddress(), DefaultBlockParameterName.LATEST).sendAsync().get();
            BigInteger balance3 = ethGetBalance3.getBalance();
            logger.info("Buyer account balance is " + balance3);

            String buyerPK = buyer.getPrivateKey();
            Credentials credentials = Credentials.create(buyerPK);

            String adminContractAddress = databaseRepository.getContractAddress("000", "000");

            contractTF = TransferingFunds.deploy(web3, credentials, GAS_PRICE, GAS_LIMIT, adminContractAddress).send();

            databaseRepository.addContract(buyer, realEstate, contractTF);

            contractTF.setSeller(realEstate.getOwnerAddress()).send();
            contractTF.setOffer(offer).send();

    }

    public void sellerContract(String sellerAddress) {
        try {
            HttpService httpService = new HttpService("http://localhost:8546");
            Web3j web3 = Web3j.build(httpService);

            EthGetBalance ethGetBalance3 = web3.ethGetBalance(sellerAddress, DefaultBlockParameterName.LATEST).sendAsync().get();
            BigInteger balance3 = ethGetBalance3.getBalance();

            logger.info("Seller account balance is " + balance3);

//            String privateKey = controller.getPrivateKey("admin");
            Credentials credentials = Credentials.create("bc5b578e0dcb2dbf98dd6e5fe62cb5a28b84a55e15fc112d4ca88e1f62bd7c35");

            contractBS = BuyingSelling.load(contractBS.getContractAddress(), web3, credentials, GAS_PRICE, GAS_LIMIT);

//            logger.info("Buyer's offer: " + contract.getOffer());
//            contract.agree();
        } catch (Exception ex) {
            Logger.getLogger(Contracts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createAdminContract() throws Exception {
        HttpService httpService = new HttpService("http://localhost:8546");
        Web3j web3 = Web3j.build(httpService);

        String adminPK = controller.getPrivateKey("admin");
        Credentials credentials = Credentials.create(adminPK);
        contractBS = BuyingSelling.deploy(web3, credentials, BigInteger.valueOf(240000), BigInteger.valueOf(4712386)).send();

        controller.addAdminContract(contractBS);

        contractBS.setRealEstate(BigInteger.valueOf(1), "0x3590aca93338b0721966a8d0c96ebf2c4c87c544", "Francuska 5", BigInteger.valueOf(40), BigInteger.valueOf(1), BigInteger.valueOf(500)).send();
        contractBS.setRealEstate(BigInteger.valueOf(2), "0x3590aca93338b0721966a8d0c96ebf2c4c87c544", "Marka Celebonovica 27", BigInteger.valueOf(45), BigInteger.valueOf(10), BigInteger.valueOf(300)).send();
    }

    public List<RealEstate> getAllRealEstates(User buyer) throws Exception {
        List<RealEstate> realEstates = new ArrayList<>();

        HttpService httpService = new HttpService("http://localhost:8545");
        Web3j web3j = Web3j.build(httpService);

        DatabaseRepository dbr = new DatabaseRepository();
        String adminContractAddress = dbr.getContractAddress("000", "000");

        String buyerPK = controller.getPrivateKey(buyer.getUsername());
        Credentials credentials = Credentials.create(buyerPK);

        contractBS = BuyingSelling.load(adminContractAddress, web3j, credentials, BigInteger.valueOf(240000), BigInteger.valueOf(4712386));

        List<BigInteger> realEstateIDs = (List<BigInteger>) contractBS.getAllRealEstates().send();

        Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger> returnVal;

        for (BigInteger realEstateID : realEstateIDs) {
            returnVal = contractBS.getRealEstate(realEstateID).send();
            BigInteger idRE = returnVal.getValue1();
            String ownerAddr = returnVal.getValue2();
            String reAddr = returnVal.getValue3();
            BigInteger area = returnVal.getValue4();
            BigInteger dist = returnVal.getValue5();
            BigInteger price = returnVal.getValue6();

            realEstates.add(new RealEstate(idRE.intValue(), ownerAddr, reAddr, area.intValue(), dist.intValue(), price.intValue()));
        }

        return realEstates;
    }

    public List<RealEstate> getAllRealEstatesFromSeller(User seller) throws Exception {
        List<RealEstate> realEstates = new ArrayList<>();

        HttpService httpService = new HttpService("http://localhost:8546");
        Web3j web3j = Web3j.build(httpService);

        DatabaseRepository dbr = new DatabaseRepository();
        String adminContractAddress = dbr.getContractAddress("000", "000");

        String sellerPK = controller.getPrivateKey(seller.getUsername());
        Credentials credentials = Credentials.create(sellerPK);

        contractBS = BuyingSelling.load(adminContractAddress, web3j, credentials, BigInteger.valueOf(240000), BigInteger.valueOf(4712386));

        List<BigInteger> realEstateIDs = (List<BigInteger>) contractBS.getAllRealEstates().send();

        Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger> returnVal;

        for (BigInteger realEstateID : realEstateIDs) {
            returnVal = contractBS.getRealEstate(realEstateID).send();
            BigInteger idRE = returnVal.getValue1();
            String ownerAddr = returnVal.getValue2();
            String reAddr = returnVal.getValue3();
            BigInteger area = returnVal.getValue4();
            BigInteger dist = returnVal.getValue5();
            BigInteger price = returnVal.getValue6();

            if (ownerAddr.equals(seller.getAddress())) {
                realEstates.add(new RealEstate(idRE.intValue(), ownerAddr, reAddr, area.intValue(), dist.intValue(), price.intValue()));
            }
        }

        return realEstates;
    }

    public List<Offer> getOffers(User seller) throws Exception {
        List<RealEstate> realEstatesFromSeller = getAllRealEstatesFromSeller(seller);

        List<Offer> offerList = new ArrayList<>();

        HttpService httpService = new HttpService("http://localhost:8546");
        Web3j web3j = Web3j.build(httpService);

        DatabaseRepository dbr = new DatabaseRepository();
        String adminContractAddress = dbr.getContractAddress("000", "000");

        String sellerPK = controller.getPrivateKey(seller.getUsername());
        Credentials credentials = Credentials.create(sellerPK);

        List<ContractEntity> contractEntityList = databaseRepository.getContractsWithSeller(seller);

        BigInteger offeredPrice;
        String offerState;
        String offerSet = "OfferSet";
        for (int i = 0; i < realEstatesFromSeller.size(); i++) {
            for (int j = 0; j < contractEntityList.size(); j++) {
                if (realEstatesFromSeller.get(i).getId() == contractEntityList.get(j).getIdRealEstate()) {
                    String contractAddress = contractEntityList.get(j).getAddressContract();
                    contractTF = TransferingFunds.load(contractAddress, web3j, credentials, GAS_PRICE, GAS_LIMIT);

                    offerState = contractTF.getState().send();  
                    System.out.println(offerState);
                    
                    if (offerSet.equals(offerState)) {
                        offeredPrice = (BigInteger) contractTF.getOffer().send();
                        offerList.add(new Offer(realEstatesFromSeller.get(i), offeredPrice, contractAddress));
                    }
                    
                }
            }
        }

        return offerList;
    }

    public void acceptOffer(String contractAddress, User seller) throws Exception {
        HttpService httpService = new HttpService("http://localhost:8546");
        Web3j web3j = Web3j.build(httpService);

        String sellerPK = controller.getPrivateKey(seller.getUsername());
        Credentials credentials = Credentials.create(sellerPK);

        contractTF = TransferingFunds.load(contractAddress, web3j, credentials, GAS_PRICE, GAS_LIMIT);

        contractTF.accept().send();
    }

    public void declineOffer(String contractAddress, User seller) throws Exception {
        HttpService httpService = new HttpService("http://localhost:8546");
        Web3j web3j = Web3j.build(httpService);

        String sellerPK = controller.getPrivateKey(seller.getUsername());
        Credentials credentials = Credentials.create(sellerPK);

        contractTF = TransferingFunds.load(contractAddress, web3j, credentials, GAS_PRICE, GAS_LIMIT);

        contractTF.decline().send();
    }

}
