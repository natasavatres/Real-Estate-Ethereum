/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.db;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.log4j.Logger;
/**
 *
 * @author FON
 */
public class DatabaseConnection {
    private final Connection connection;
    private static DatabaseConnection instance;
    
    final static Logger LOGGER = Logger.getLogger(DatabaseConnection.class);
    
    private DatabaseConnection() throws Exception{

        DatabaseResources dbr = new DatabaseResources();
        connection = DriverManager.getConnection(dbr.getUrl(), dbr.getUsername(), dbr.getPassword());
        LOGGER.info("Successfully connected!");
    }

    public Connection getConnection() {
        return connection;
    }
    
    public static DatabaseConnection getInstance() throws Exception{
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
