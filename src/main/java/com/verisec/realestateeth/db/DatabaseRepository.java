/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.db;

import com.verisec.realestateeth.domain.BuyingSelling;
import com.verisec.realestateeth.domain.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author Natasa
 */
public class DatabaseRepository {

    Connection connection;

    public User findUser(String un, String pass) throws Exception {
        connection = DatabaseConnection.getInstance().getConnection();
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, un);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String userAddress = rs.getString("address");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String role = rs.getString("role");
            String privateKey = rs.getString("private_key");

            User user = new User(userAddress, username, password, firstName, lastName, role, privateKey);

            rs.close();
            ps.close();

            return user;
        }
        throw new Exception("There is no user with these credentials!");
    }

    public String getPrivateKey(String user) throws Exception {
        connection = DatabaseConnection.getInstance().getConnection();
        String query = "SELECT private_key FROM user WHERE username=?";
        PreparedStatement ps = connection.prepareStatement(query);
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
        String query = "INSERT INTO contract (address_contract, address_buyer, address_seller, id_real_estate, date) VALUES (?,?,?,?,?)";

        try {
            connection = DatabaseConnection.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

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
            System.out.println("Error in generating keys");
        }
    }

    public String getContractAddress(String addressBuyer, String addressSeller) throws Exception {
        connection = DatabaseConnection.getInstance().getConnection();
        String query = "SELECT address_contract FROM contract WHERE address_buyer =? AND address_seller = ?";
        PreparedStatement ps = connection.prepareStatement(query);
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

}
