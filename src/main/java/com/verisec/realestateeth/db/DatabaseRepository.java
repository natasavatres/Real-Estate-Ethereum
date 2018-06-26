/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.db;

import com.verisec.realestateeth.domain.generated.BuyingSelling;
import com.verisec.realestateeth.domain.beans.ContractEntity;
import com.verisec.realestateeth.domain.beans.RealEstate;
import com.verisec.realestateeth.domain.generated.TransferingFunds;
import com.verisec.realestateeth.domain.beans.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Natasa
 */
public class DatabaseRepository {

    Connection connection;

    final static Logger LOGGER = Logger.getLogger(DatabaseRepository.class);

    private final String FIND_USER_QUERY = "SELECT * FROM user WHERE username = ? AND password = ?";
    private final String GET_USER_PRIVATE_KEY_QUERY = "SELECT private_key FROM user WHERE username=?";
    private final String ADD_CONTRACT_QUERY = "INSERT INTO contract (address_contract, address_buyer, address_seller, id_real_estate, date) VALUES (?,?,?,?,?)";
    private final String GET_CONTRACT_ADDRESS_QUERY = "SELECT address_contract FROM contract WHERE address_buyer =? AND address_seller = ?";
    private final String GET_CONTRACTS_WITH_SELLER_QUERY = "SELECT * FROM contract WHERE address_seller = ?";
    private final String GET_ALL_BUYER_CONTRACTS_QUERY = "SELECT * FROM contract WHERE address_buyer = ?";
    private final String DELETE_CONTRACT_QUERY = "DELETE FROM contract WHERE address_contract = ?";
    private final String GET_BUYER_ADDRESS_FROM_CONTRACT_ADDRESS_QUERY = "SELECT address_buyer FROM contract WHERE address_contract=?";

    public User findUser(String un, String pass) throws Exception {
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(FIND_USER_QUERY);
        ps.setString(1, un);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String userAddress = rs.getString("address");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String privateKey = rs.getString("private_key");

            User user = new User(userAddress, username, password, firstName, lastName, privateKey);

            rs.close();
            ps.close();

            return user;
        }
        throw new Exception("There is no such user!");
    }

    public String getPrivateKey(String user) throws Exception {
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_USER_PRIVATE_KEY_QUERY);
        ps.setString(1, user);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String privateKey = rs.getString("private_key");

            rs.close();
            ps.close();

            return privateKey;
        }
        throw new Exception("There is no user with these credentials!");
    }

    public void addAdminContract(BuyingSelling contract) {
        try {
            connection = DatabaseConnection.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(ADD_CONTRACT_QUERY, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, contract.getContractAddress());
            ps.setString(2, "000");
            ps.setString(3, "000");
            ps.setInt(4, 000);

            LocalDate dateLocal = LocalDate.now();
            Date dateSql = Date.valueOf(dateLocal);
            ps.setDate(5, dateSql);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                ps.close();
            }

        } catch (Exception e) {
            LOGGER.error("Error in generating keys", e);
        }
    }

    public String getContractAddress(String addressBuyer, String addressSeller) throws Exception {
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_CONTRACT_ADDRESS_QUERY);
        ps.setString(1, addressBuyer);
        ps.setString(2, addressSeller);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String addressContract = rs.getString("address_contract");

            rs.close();
            ps.close();

            return addressContract;
        }
        throw new Exception("There is no contract between these users!");
    }

    public void addContract(User buyer, RealEstate realEstate, TransferingFunds contractTF) {
        try {
            connection = DatabaseConnection.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(ADD_CONTRACT_QUERY, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, contractTF.getContractAddress());
            ps.setString(2, buyer.getAddress());
            ps.setString(3, realEstate.getOwnerAddress());
            ps.setInt(4, realEstate.getId());

            LocalDate dateLocal = LocalDate.now();
            Date dateSql = Date.valueOf(dateLocal);
            ps.setDate(5, dateSql);

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                ps.close();
            }

        } catch (Exception e) {
            LOGGER.error("Error in saving contract to database", e);
        }
    }

    public List<ContractEntity> getContractsWithSeller(User seller) {

        List<ContractEntity> contractEntityList = new ArrayList<>();

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_CONTRACTS_WITH_SELLER_QUERY);
            ps.setString(1, seller.getAddress());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String addressContract = rs.getString(1);
                String addressBuyer = rs.getString(2);
                String addressSeller = rs.getString(3);
                int idRE = rs.getInt(4);

                java.sql.Date dateSql = rs.getDate(5);
                java.util.Date dateUtil = new java.util.Date(dateSql.getTime());

                contractEntityList.add(new ContractEntity(addressContract, addressBuyer, addressSeller, idRE, dateUtil));

            }

            rs.close();
            ps.close();
        } catch (Exception ex) {
            LOGGER.error("Error in getting offer buyer-seller", ex);
        }

        return contractEntityList;

    }

    public List<ContractEntity> getAllBuyerContracts(User buyer) {
        List<ContractEntity> contractEntityList = new ArrayList<>();

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_ALL_BUYER_CONTRACTS_QUERY);
            ps.setString(1, buyer.getAddress());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String addressContract = rs.getString(1);
                String addressBuyer = rs.getString(2);
                String addressSeller = rs.getString(3);
                int idRE = rs.getInt(4);

                java.sql.Date dateSql = rs.getDate(5);
                java.util.Date dateUtil = new java.util.Date(dateSql.getTime());

                contractEntityList.add(new ContractEntity(addressContract, addressBuyer, addressSeller, idRE, dateUtil));
            }

            rs.close();
            ps.close();
        } catch (Exception ex) {
            LOGGER.error("Error in getting buyer's offers", ex);
        }

        return contractEntityList;
    }

    public void deleteContract(String contractAddress) {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_CONTRACT_QUERY);
            ps.setString(1, contractAddress);
            ps.executeUpdate();

        } catch (Exception e) {
            LOGGER.error("Error in deleting contract from database", e);
        }
    }

    public String getBuyerAddressByContractAddress(String contractAddress) throws Exception {
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_BUYER_ADDRESS_FROM_CONTRACT_ADDRESS_QUERY);
        ps.setString(1, contractAddress);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String buyerAddress = rs.getString("address_buyer");

            rs.close();
            ps.close();

            return buyerAddress;
        }
        throw new Exception("There is no buyer in this contract!");
    }

}
