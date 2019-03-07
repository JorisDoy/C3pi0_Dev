/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telkom.postpaid.mpesa.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jdmwamburi
 */

public class Inserts {
    
    
    public Connection con;
    public PreparedStatement ps;
    public ResultSet rs;
    public Statement st;  
    public ComboPooledDataSource cpds;
    
    
    
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Inserts.class.getName());
    
    // insert Verification data
    public synchronized void insertConfirmationData(String trans_type, String trans_id, String trans_time, String trans_amount, 
            String businessShortCode, String billRefNumber, String invoiceNumber, String orgAccountBalance, String thirdPartyTransID, 
            String msisdn, String kyc_info, String transact_status, String is_validate, String telkom_txn_id, 
            String message, String response, String receiptno, String receiptdate, String receiptamount,String mpesaid) throws ClassNotFoundException{
        
        try{
            
            String sql = "INSERT INTO confirmation (transtype, transid, transtime, transamount, "
                    + "businessshortcode, billrefnumber, invoicenumber, orgaccountbalance, "
                    + "thirdpartytransid, msisdn, kycinfo, transact_status, is_validate, "
                    + "telkom_txn_id, message, response, receiptno, receiptdate, receiptamount, mpesaid) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            //PG_DataSource conn = new PG_DataSource();
            //con = datasource.getConnection();
            PG_DataSource conn = new PG_DataSource();
            con = conn.getConnection();
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
            ps.setString(15, message);
            ps.setString(16, response);
            ps.setString(17, receiptno);
            ps.setString(18, receiptdate);
            ps.setString(19, receiptamount);
            ps.setString(20, mpesaid);
                       
            int count = ps.executeUpdate();
            
            logger.info("Executed 1 insert for Confirmation table. Transaction id: " + trans_id);
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
  
    public synchronized void insertValidationData(String transType, String transID, String transTime, 
            String transAmount, String businessShortCode, String billRefNumber, String invoiceNumber, String msisdn, 
            String kycInfo, String telkom_txn_id, String transact_time, String transact_status, String message, String mpesaid) throws ClassNotFoundException, PropertyVetoException{
        try{
           
           /*String sql = "Insert into validation (transtype, transid, transtime, transamount, businessshortcode, "
                   + "billrefnumber, invoicenumber, msisdn, kycinfo, telkom_txn_id, transact_time, transact_status, message, mpesaid) "
                   + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; */
           String sql = "Insert into validation (transtype, transid, transtime, transamount, businessshortcode,billrefnumber, invoicenumber, msisdn, kycinfo, telkom_txn_id, transact_time, transact_status, message, mpesaid)"
                   + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PG_DataSource conn = new PG_DataSource();
            con = conn.getConnection();
            //con = datasource.getConnection();//createConnection();
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
            ps.setString(14, mpesaid);
           
           int count = ps.executeUpdate();
           logger.info("Executed 1 insert for Validation table. Transaction id: " + transID);
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
