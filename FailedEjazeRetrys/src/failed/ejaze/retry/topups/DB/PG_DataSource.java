/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package failed.ejaze.retry.topups.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;

/**
 *
 * @author jdmwamburi
 */
public class PG_DataSource {
    
    private static PG_DataSource datasource;
    public  String dbState = "";
    SimpleDateFormat ldtime = new SimpleDateFormat("yyyyMMddhhmmss");
    Timestamp ts = new Timestamp(System.currentTimeMillis());
    String loggingTime = ldtime.format(ts);
    private static final Logger logger = Logger.getLogger(PG_DataSource.class.getName());
    public Connection getConnection() 
    { 
        dbState += "------Connecting to PostgreSQL------\n";
        try 
        {
            Class.forName("org.postgresql.Driver");
        } 
        catch (ClassNotFoundException e) 
        {
            dbState += "Postgres Driver not found" + e.getMessage() + "\n";
            logger.info("LOG Time | "+ loggingTime + " | " + dbState);
        }        
        Connection connection = null;
        try 
        {
            //connection = DriverManager.getConnection("jdbc:postgresql://10.22.38.14:5432/telkom_buy_airtime", "postgres", "");
            connection = DriverManager.getConnection("jdbc:postgresql://10.22.28.192:5432/telkom_buy_airtime", "mfs", "VFR$5tgb");
            //connection = DriverManager.getConnection("jdbc:postgresql://10.22.28.188:5432/telkom_buy_airtime", "mfs", "VFR$5tgb");
        } 
        catch (SQLException e) 
        {
            dbState += "Connection Failed: " + e.getMessage() + "\n";
            logger.info("LOG Time | "+ loggingTime + " | " + dbState);
        }
        if (connection != null) 
        {
            dbState += "CONNECTION ESTABLISHED\n";
            logger.info("LOG Time | "+ loggingTime + " | " + dbState);
        } 
        else 
        {
            dbState += "Failed to make connection!\n";
            logger.info("LOG Time | "+ loggingTime + " | " + dbState);
        }
        return connection;
    }

    public String getDbState() {
        return dbState;
    }
}
