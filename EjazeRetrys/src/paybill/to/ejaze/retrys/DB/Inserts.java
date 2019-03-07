/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paybill.to.ejaze.retrys.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author jdmwamburi
 */
public class Inserts 
{
    public Connection con;
    public PreparedStatement ps;
    public ResultSet rs;
    public Statement st;
    
    SimpleDateFormat ldtime = new SimpleDateFormat("yyyyMMddhhmmss");
    Timestamp ts = new Timestamp(System.currentTimeMillis());
    String loggingTime = ldtime.format(ts);
    
    private static final Logger logger = Logger.getLogger(Selects.class.getName());
    
    //insert direct topup data into confirmations
    public synchronized void insertDirectTopups(DataSource ds, String Trans_type, String Transtime, String Transamount,
            String Billrefnumber, String SafaricomLine, String mpesaId)
    {
        String sql ="INSERT INTO confirmation (transType, transID, transTime, transAmount,  billRefNumber, "
                + "msisdn, transact_status, is_validate, "
                + "telkom_txn_id) values(?, ?, ?, ?, ?, ?, ?, ?)";
        try 
        {
            PG_DataSource conn = new PG_DataSource();
            con = conn.getConnection();
            //con = ds.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, Trans_type);
            ps.setString(2, mpesaId);
            ps.setString(3, Transtime);
            ps.setString(4, Transamount);
            ps.setString(5, Billrefnumber);
            ps.setString(6, SafaricomLine);
            ps.setString(7, "successful");
            ps.setString(8, "True");
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(Inserts.class.getName()).log(Level.SEVERE, null, ex);
            logger.info("LOG Time | "+ loggingTime + " |  \n "+ex);
        }
        //Logger.getLogger(Inserts.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    
     // insert Confirmation data
    public synchronized void insertConfirmationData(String trans_type, String trans_id, String trans_time, String trans_amount, 
            String businessShortCode, String billRefNumber, String invoiceNumber, String orgAccountBalance, String thirdPartyTransID, 
            String msisdn, String kyc_info, String transact_status, String is_validate, String telkom_txn_id, 
            String txn_status_code, String txn_status_id, String ocs_topups) throws ClassNotFoundException
    {
        
        try{
            
            String sql = "INSERT INTO confirmation (transType, transID, transTime, transAmount, "
                    + "businessShortCode, billRefNumber, invoiceNumber, orgAccountBalance, "
                    + "thirdPartyTransID, msisdn, kycInfo, transact_status, is_validate, "
                    + "telkom_txn_id, txn_status_code, txn_status_id, ocs_topups) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            PG_DataSource conn = new PG_DataSource();
            con = conn.getConnection();
            //con = datasource.getConnection();
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
            ps.setString(15, txn_status_code);
            ps.setString(16, txn_status_id);
            ps.setString(17, ocs_topups);
                       
            int count = ps.executeUpdate();
            con.close();
            ps.close();
            logger.info("LOG Time | "+ loggingTime + "Executed " + count + " insert for Confirm Validation. Transaction id: " + trans_id);
        } 
        catch(SQLException ex)
        {
           logger.info("LOG Time | "+ loggingTime + "Failed to insert confirmation data. SQLException message: " + ex.getMessage());
        }finally 
        {
            try 
            {
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    con.close();
                }
            } 
            catch (SQLException ex) 
            {
                logger.fatal("LOG Time | "+ loggingTime + "!!!!!!!!!! SQL error while attempting to close connection. SQLException: " + ex.getMessage());
            }
        }
    }
}
