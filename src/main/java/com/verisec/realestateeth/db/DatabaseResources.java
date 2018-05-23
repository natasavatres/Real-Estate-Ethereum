/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.db;

import java.io.FileInputStream;
import java.util.Properties;
/**
 *
 * @author FON
 */
public class DatabaseResources {
    Properties properties;

    public DatabaseResources() throws Exception {
        properties = new Properties();
        FileInputStream fis = new FileInputStream("db.config");
        properties.load(fis);
    }
    
    
    
    public String getUrl(){
        return properties.getProperty("url");
    }
    
    public String getUsername(){
        return properties.getProperty("username");
    }
    
    public String getPassword(){
        return properties.getProperty("password");
    }
}
