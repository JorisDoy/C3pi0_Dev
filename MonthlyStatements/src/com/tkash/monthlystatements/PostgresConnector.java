/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tkash.monthlystatements;

/**
 *
 * @author jdmwamburi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnector {
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PostgresConnector.class.getName());
    public static String dbState = "";

    public Connection getConnection() {
        // 
        dbState += "------Connecting to PostgreSQL------\n";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            dbState += "Postgres Driver not found" + e.getMessage() + "\n";
            //e.printStackTrace();
            //        
            //logger.error(dbState);
        }
        //System.out.println("PostgreSQL Driver Registered!");        
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://10.22.28.180:5432/TkashStatementDBV1", "mfs", "VFR$5tgb");
        } catch (SQLException e) {
            dbState += "Connection Failed: " + e.getMessage() + "\n";
            //e.printStackTrace();
            //logger.error(dbState);
        }
        //
        if (connection != null) {
            //dbState += "CONNECTION ESTABLISHED\n";
            logger.info("POSTGRES DB CONNECTION ESTABLISHED");
        } else {
            //dbState += "Failed to make connection!\n";
            logger.error("Postgres DB Connection Failed to make connection! ---> Connection is null");
        }
        //logger.error("\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n\n" + dbState + "\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n\n");
        return connection;
    }

    public String getDbState() {
        return dbState;
    }
}
