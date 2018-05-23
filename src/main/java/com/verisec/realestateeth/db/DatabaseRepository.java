/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.db;

import com.verisec.realestateeth.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Natasa
 */
public class DatabaseRepository {

    Connection connection;

    public User findUser(String un, String pass) throws Exception {
        connection = DatabaseConnection.getInstance().getConnection();
        String query = "SELECT * FROM user WHERE username=? AND password=?";
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

    public String getAdminPrivateKey() throws Exception{
        connection = DatabaseConnection.getInstance().getConnection();
        String query = "SELECT private_key FROM user WHERE username=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, "admin");
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String admin_pk = rs.getString("private_key");

            rs.close();
            ps.close();

            return admin_pk;
        }
        throw new Exception("There is no user with these credentials!");
    }

    
    
}
