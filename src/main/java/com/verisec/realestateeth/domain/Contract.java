/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import static org.web3j.tx.Contract.GAS_LIMIT;
import static org.web3j.tx.ManagedTransaction.GAS_PRICE;

/**
 *
 * @author Natasa Vatres
 */
public class Contract {

    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Contract.class);
    int cost = 100;

    ArrayList<String> contracts = new ArrayList<>();
    RealEstateContract contract = null;

    public void buyerContract(String buyerAddress, String sellerAddress) {
        try {
            HttpService httpService = new HttpService("http://localhost:8545");
            Web3j web3 = Web3j.build(httpService);

            EthGetBalance ethGetBalance3 = web3.ethGetBalance(buyerAddress, DefaultBlockParameterName.LATEST).sendAsync().get();
            BigInteger balance3 = ethGetBalance3.getBalance();

            logger.info("Buyer account balance is " + balance3);

            Credentials credentials = Credentials.create("df504d175ae63abf209bad9dda965310d99559620550e74521a6798a41215f46");

            if (contracts.isEmpty()) {
                contract = RealEstateContract.deploy(web3, credentials, GAS_PRICE, GAS_LIMIT).send();

                BigInteger costBig = BigInteger.valueOf(cost);

                contract.setSeller(sellerAddress);
                contract.setOffer(costBig).send();

                contracts.add(contract.getContractAddress());
                //DODAJ UGOVOR U BAZU

            } else {
                contract = RealEstateContract.load(contract.getContractAddress(), web3, credentials, GAS_PRICE, GAS_LIMIT);
                
//                contract.setNameCost();           
//                logger.info(contract.getRealEstateOwner());
            }

        } catch (Exception ex) {
            Logger.getLogger(Contract.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sellerContract(String sellerAddress) {
        try {
            HttpService httpService = new HttpService("http://localhost:8546");
            Web3j web3 = Web3j.build(httpService);

            EthGetBalance ethGetBalance3 = web3.ethGetBalance(sellerAddress, DefaultBlockParameterName.LATEST).sendAsync().get();
            BigInteger balance3 = ethGetBalance3.getBalance();

            logger.info("Seller account balance is " + balance3);

            Credentials credentials = Credentials.create("bc5b578e0dcb2dbf98dd6e5fe62cb5a28b84a55e15fc112d4ca88e1f62bd7c35");

            contract = RealEstateContract.load(contract.getContractAddress(), web3, credentials, GAS_PRICE, GAS_LIMIT);

            logger.info("Buyer's offer: " + contract.getOffer());

//            contract.agree();

        } catch (Exception ex) {
            Logger.getLogger(Contract.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
