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
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
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

        Web3j web3 = createWeb3j();

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
        contractTF.setState("OfferSet").send();

    }

    private Web3j createWeb3j() {
        HttpService httpService = new HttpService("http://localhost:8545");
        Web3j web3 = Web3j.build(httpService);
        return web3;
    }

    public void createAdminContract() throws Exception {

        Web3j web3 = createWeb3j();
        String adminPK = controller.getPrivateKey("admin");
        Credentials credentials = Credentials.create(adminPK);
        contractBS = BuyingSelling.deploy(web3, credentials, BigInteger.valueOf(240000), BigInteger.valueOf(4712386)).send();

        controller.addAdminContract(contractBS);

        contractBS.setRealEstate(BigInteger.valueOf(1), "0x3590aca93338b0721966a8d0c96ebf2c4c87c544", "Francuska 5", BigInteger.valueOf(40), BigInteger.valueOf(1), BigInteger.valueOf(500)).send();
        contractBS.setRealEstate(BigInteger.valueOf(2), "0x3590aca93338b0721966a8d0c96ebf2c4c87c544", "Marka Celebonovica 27", BigInteger.valueOf(45), BigInteger.valueOf(10), BigInteger.valueOf(300)).send();
    }

    protected List<RealEstate> createRealEstatesList(BuyingSelling contract) throws Exception {

        List<RealEstate> result = new ArrayList<>();
        List<BigInteger> realEstateIDs = (List<BigInteger>) contract.getAllRealEstates().send();
        Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger> returnVal;

        for (BigInteger realEstateID : realEstateIDs) {
            returnVal = contract.getRealEstate(realEstateID).send();
            BigInteger idRE = returnVal.getValue1();
            String ownerAddr = returnVal.getValue2();
            String reAddr = returnVal.getValue3();
            BigInteger area = returnVal.getValue4();
            BigInteger dist = returnVal.getValue5();
            BigInteger price = returnVal.getValue6();

            result.add(new RealEstate(idRE.intValue(), ownerAddr, reAddr, area.intValue(), dist.intValue(), price.intValue()));
        }

        return result;
    }

    public List<RealEstate> getAllRealEstates(User buyer) throws Exception {

        Web3j web3 = createWeb3j();
        DatabaseRepository dbr = new DatabaseRepository();
        String adminContractAddress = dbr.getContractAddress("000", "000");

        String buyerPK = controller.getPrivateKey(buyer.getUsername());
        Credentials credentials = Credentials.create(buyerPK);

        contractBS = BuyingSelling.load(adminContractAddress, web3, credentials, BigInteger.valueOf(240000), BigInteger.valueOf(4712386));

        return createRealEstatesList(contractBS);

    }

    public List<RealEstate> getAllRealEstatesFromSeller(User seller) throws Exception {
        List<RealEstate> realEstates = new ArrayList<>();

        Web3j web3 = createWeb3j();
        DatabaseRepository dbr = new DatabaseRepository();
        String adminContractAddress = dbr.getContractAddress("000", "000");

        String sellerPK = controller.getPrivateKey(seller.getUsername());
        Credentials credentials = Credentials.create(sellerPK);

        contractBS = BuyingSelling.load(adminContractAddress, web3, credentials, BigInteger.valueOf(240000), BigInteger.valueOf(4712386));

        List<RealEstate> allRealEstates = createRealEstatesList(contractBS);
        for (RealEstate realEstate : allRealEstates) {
            if (realEstate.getOwnerAddress().equals(seller.getAddress())) {
                realEstates.add(realEstate);
            }
        }

        return realEstates;
    }

    public List<Offer> getOffersSeller(User seller) throws Exception {
        List<RealEstate> realEstatesFromSeller = getAllRealEstatesFromSeller(seller);

        List<Offer> offerList = new ArrayList<>();

        Web3j web3 = createWeb3j();

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
                    contractTF = TransferingFunds.load(contractAddress, web3, credentials, GAS_PRICE, GAS_LIMIT);

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
        Web3j web3 = createWeb3j();

        String sellerPK = controller.getPrivateKey(seller.getUsername());
        Credentials credentials = Credentials.create(sellerPK);

        contractTF = TransferingFunds.load(contractAddress, web3, credentials, GAS_PRICE, GAS_LIMIT);

        contractTF.accept().send();
        contractTF.setState("OfferAccepted").send();
    }

    public void declineOffer(String contractAddress, User seller) throws Exception {
        Web3j web3 = createWeb3j();
        String sellerPK = controller.getPrivateKey(seller.getUsername());
        Credentials credentials = Credentials.create(sellerPK);

        contractTF = TransferingFunds.load(contractAddress, web3, credentials, GAS_PRICE, GAS_LIMIT);

        contractTF.decline().send();
        contractTF.setState("OfferDeclined").send();
    }

    private RealEstate createRealEstateEntity(BuyingSelling contract, int idRealEstate) throws Exception {
        Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger> returnVal = contract.getRealEstate(BigInteger.valueOf(idRealEstate)).send();

        BigInteger idRE = returnVal.getValue1();
        String ownerAddr = returnVal.getValue2();
        String reAddr = returnVal.getValue3();
        BigInteger area = returnVal.getValue4();
        BigInteger dist = returnVal.getValue5();
        BigInteger price = returnVal.getValue6();

        return new RealEstate(idRE.intValue(), ownerAddr, reAddr, area.intValue(), dist.intValue(), price.intValue());
    }

    public List<Offer> getAllBuyerOffers(User buyer) throws Exception {
        List<Offer> offerList = new ArrayList<>();

        Web3j web3 = createWeb3j();

        DatabaseRepository dbr = new DatabaseRepository();
        String adminContractAddress = dbr.getContractAddress("000", "000");

        String buyerPK = controller.getPrivateKey(buyer.getUsername());
        Credentials credentials = Credentials.create(buyerPK);

        List<ContractEntity> buyerContracts = databaseRepository.getAllBuyerContracts(buyer);

        contractBS = BuyingSelling.load(adminContractAddress, web3, credentials, GAS_PRICE, GAS_LIMIT);

        for (ContractEntity buyerContract : buyerContracts) {
            contractTF = TransferingFunds.load(buyerContract.getAddressContract(), web3, credentials, GAS_PRICE, GAS_LIMIT);
            BigInteger offeredPrice = contractTF.getOffer().send();
            String offerState = contractTF.getState().send();

            RealEstate re = createRealEstateEntity(contractBS, buyerContract.getIdRealEstate());
            offerList.add(new Offer(re, offeredPrice, buyerContract.getAddressContract(), offerState));
        }

        return offerList;
    }

    public void payRealEstate(Offer offer, User buyer) throws Exception {
        
        Web3j web3 = createWeb3j();
        String buyerPK = controller.getPrivateKey(buyer.getUsername());
        Credentials credentials = Credentials.create(buyerPK);

        DatabaseRepository dbr = new DatabaseRepository();
        String adminContractAddress = dbr.getContractAddress("000", "000");
        contractBS = BuyingSelling.load(adminContractAddress, web3, credentials, BigInteger.valueOf(240000), BigInteger.valueOf(4712386));

        List<BigInteger> realEstateIDs = (List<BigInteger>) contractBS.getAllRealEstates().send();
        int listSize = realEstateIDs.size();
        contractTF = TransferingFunds.load(offer.getContractAddress(), web3, credentials, GAS_PRICE, GAS_LIMIT);

        contractTF.changeOwner(BigInteger.valueOf(listSize + 1),
                offer.getRealEstate().getRealEstateAddress(),
                BigInteger.valueOf(offer.getRealEstate().getArea()),
                BigInteger.valueOf(offer.getRealEstate().getCenterDistance()),
                BigInteger.valueOf(offer.getRealEstate().getPrice())).send();

        contractTF.pay(GAS_PRICE).send();

    }

    public int getIdForNewRealEstate(User admin) throws Exception {
        Web3j web3 = createWeb3j();

        String adminPK = controller.getPrivateKey(admin.getUsername());
        Credentials credentials = Credentials.create(adminPK);

        DatabaseRepository dbr = new DatabaseRepository();
        String adminContractAddress = dbr.getContractAddress("000", "000");
        contractBS = BuyingSelling.load(adminContractAddress, web3, credentials, BigInteger.valueOf(240000), BigInteger.valueOf(4712386));

        List<BigInteger> realEstateIDs = (List<BigInteger>) contractBS.getAllRealEstates().send();

        return realEstateIDs.size() + 1;
    }

    public void addRealEstate(RealEstate re) throws Exception {
        Web3j web3 = createWeb3j();

        String adminPK = controller.getPrivateKey("admin");
        Credentials credentials = Credentials.create(adminPK);

        DatabaseRepository dbr = new DatabaseRepository();
        String adminContractAddress = dbr.getContractAddress("000", "000");

        contractBS = BuyingSelling.load(adminContractAddress, web3, credentials, GAS_PRICE, GAS_LIMIT);

        contractBS.setRealEstate(BigInteger.valueOf(re.getId()), re.getOwnerAddress(), re.getRealEstateAddress(),
                BigInteger.valueOf(re.getArea()), BigInteger.valueOf(re.getCenterDistance()),
                BigInteger.valueOf(re.getPrice())).send();

    }

    public int getIdByOwnerAndLocation(User buyer, String ownerAddress, String reAddress) throws Exception {
        
        Web3j web3 = createWeb3j();
        String buyerPK = controller.getPrivateKey(buyer.getUsername());
        Credentials credentials = Credentials.create(buyerPK);

        DatabaseRepository dbr = new DatabaseRepository();
        String adminContractAddress = dbr.getContractAddress("000", "000");

        contractBS = BuyingSelling.load(adminContractAddress, web3, credentials, GAS_PRICE, GAS_LIMIT);

        List<RealEstate> realEstates = createRealEstatesList(contractBS);
        
        for (RealEstate re : realEstates) {
            if(re.getOwnerAddress().equals(ownerAddress) && re.getRealEstateAddress().equals(reAddress)){
                return re.getId();
            }
        }

        return -1;
    }

}
