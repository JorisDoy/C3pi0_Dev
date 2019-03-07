/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.utils.db;

/**
 *
 * @author gaddafi
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

public class Inserts {
    
    public Connection con;

    public PreparedStatement ps;

    public ResultSet rs;

    public Statement st;
    
    private final Logger logger = Logger.getLogger(Inserts.class.getName());
    
    // insert Verification data
    public synchronized void insertConfirmationData(DataSource datasource, String trans_type, String trans_id, String trans_time, String trans_amount, String businessShortCode, String billRefNumber, String invoiceNumber, String orgAccountBalance, String thirdPartyTransID, String msisdn, String kyc_info, String transact_status, String is_validate, String telkom_txn_id){
        try{
            String sql = "INSERT INTO confirmation (transType, transID, transTime, transAmount, businessShortCode, billRefNumber, invoiceNumber, orgAccountBalance, thirdPartyTransID, msisdn, kycInfo, transact_status, is_validate, telkom_txn_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, trans_type);
            ps.setString(2, trans_id);
            ps.setString(3, trans_time);
            ps.setString(4, trans_amount);
            ps.setString(5, businessShortCode);
            ps.setString(6, billRefNumber);
            ps.setString(7, invoiceNumber);
            ps.setString(8, orgAccountBalance);
            ps.setString(9, thirdPartyTransID);
            ps.setString(10, msisdn);
            ps.setString(11, kyc_info);
            ps.setString(12, transact_status);
            ps.setString(13, is_validate);
            ps.setString(14, telkom_txn_id);
            
            
            int count = ps.executeUpdate();
            
            logger.info("Executed " + count + " insert for Confirm Validation. Transaction id: " + trans_id);
        } catch(SQLException ex){
            logger.fatal("Failed to insert confirmation data. SQLException message: " + ex.getMessage());
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                logger.fatal("!!!!!!!!!! SQL error while attempting to close connection. SQLException: " + ex.getMessage());
            }
        }
    }
    
    public synchronized void insertValidationData(DataSource datasource, String transType, String transID, String transTime, String transAmount, String businessShortCode, String billRefNumber, String invoiceNumber, String msisdn, String kycInfo, String telkom_txn_id, String transact_time, String transact_status, String message){
        try{
           String sql = "Insert into validation (transType, transID, transTime, transAmount, businessShortCode, billRefNumber, invoiceNumber, msisdn, kycInfo, telkom_txn_id, transact_time, transact_status, message) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
           con = datasource.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, transType);
            ps.setString(2, transID);
            ps.setString(3, transTime);
            ps.setString(4, transAmount);
            ps.setString(5, businessShortCode);
            ps.setString(6, billRefNumber);
            ps.setString(7, invoiceNumber);
            ps.setString(8, msisdn);
            ps.setString(9, kycInfo);
            ps.setString(10, telkom_txn_id);
            ps.setString(11, transact_time);
            ps.setString(12, transact_status);
            ps.setString(13, message);
           
           int count = ps.executeUpdate();
           logger.info("Executed " + count + " insert for Confirm Validation. Transaction id: " + transID);
        } catch(SQLException ex){
            logger.fatal("Failed to insert validation data. SQLException message: " + ex.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                logger.fatal("!!!!!!!!!! SQL error while attempting to close connection. SQLException: " + ex.getMessage());
            }
        }
    }
    
}
