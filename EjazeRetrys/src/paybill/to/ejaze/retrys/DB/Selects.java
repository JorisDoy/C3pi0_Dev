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
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import paybill.to.ejaze.retrys.uitils.AirtimePurchaseInfo;

/**
 *
 * @author jdmwamburi
 */
public class Selects 
{
    private Connection con = null;
    private ResultSet rs = null;
    private Statement st = null;
    private PreparedStatement ps = null;
    static final String POSTGRES_JDBC_DRIVER ="org.postgresql.Driver";
    private static final Logger logger = Logger.getLogger(Selects.class.getName());
    
    public synchronized List<AirtimePurchaseInfo> getUsingAll(String trans_date, String partition)
    {
        SimpleDateFormat ldtime = new SimpleDateFormat("yyyyMMddhhmmss");
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String loggingTime = ldtime.format(ts);
        List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        //String sqlQuery ="SELECT A.rec_id, A.transtime, A.transamount, A.billrefnumber, A.transid, A.msisdn FROM validation A where not exists(select transid from confirmation B where A.transid = B.transid) and A.transact_status ='successful' and A.transtime BETWEEN SYMMETRIC to_char(now()- interval '5 minutes', 'YYYYMMDDHHMMSS') AND  to_char(now() - interval '9 hours', 'YYYYMMDDHHMMSS')";
        //String sqlQuery ="select A.rec_id, A.transtime, A.transamount, A.billrefnumber, A.transid, A.msisdn, A.kycinfo, A.telkom_txn_id FROM validation"+partition+" A where not exists(select transid from confirmation B where A.transid = B.transid) and A.transact_status ='successful' and A.transtime BETWEEN SYMMETRIC to_char(now()- interval '5 minutes', 'YYYYMMDDHHMMSS') AND  to_char(now() - interval '30 minutes', 'YYYYMMDDHHMMSS')";
        String sqlQuery ="select A.rec_id, A.transtime, A.transamount, A.billrefnumber, A.transid, A.msisdn, A.kycinfo, A.telkom_txn_id \n" +
        "FROM validation A where not exists(select transid from confirmation B where A.transid = B.transid) and A.transdate = '"+partition+"' and A.transact_status ='successful'\n" +
        "and A.transtime BETWEEN SYMMETRIC to_char(now()- interval '5 minutes', 'YYYYMMDDHHMMSS') AND  to_char(now() - interval '30 minutes', 'YYYYMMDDHHMMSS')";
        try
        {
            Class.forName(POSTGRES_JDBC_DRIVER);
            PG_DataSource pgConnector = new PG_DataSource();
            con = pgConnector.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sqlQuery);
            if(rs == null)
            {
                logger.info("\n LOG Time | "+ loggingTime + " | No data! No Data!! No Validation data Found |" );
            }
            else{
                while(rs.next()){
                    logger.info("\n LOG Time | "+ loggingTime + "| Validation data found |" );
                    AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                    int recid = rs.getInt("rec_id");
                    api.setRec_id(recid);
                    String transtime = rs.getString("transtime");
                    api.setTranstime(transtime);
                    String transamount = rs.getString("transamount");
                    api.setTransamount(transamount);
                    String billrefnumber = rs.getString("billrefnumber");
                    api.setBillrefnumber(billrefnumber);
                    String mpesarefid = rs.getString("transid");
                    api.setTransid(mpesarefid);
                    String safaricomNum = rs.getString("msisdn");
                    api.setMsisdn(safaricomNum);
                    String subName = rs.getString("kycinfo");
                    api.setMsisdn(subName);
                    String tklTxnid = rs.getString("telkom_txn_id");
                    api.setMsisdn(tklTxnid);
                    logger.info("LOG Time | "+ loggingTime + "| Validation data for Mpesa id | "+ mpesarefid +" found |" + " for mobile number | "+ billrefnumber);
                    is_valid.add(api);
                }
            }
        } 
        catch (SQLException | ClassNotFoundException ex) 
        {
            //Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
            logger.fatal("\n |"+ ex + "| LOG Time | " + loggingTime);
        }  
        finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                logger.fatal("| LOG Time | " + loggingTime +"\n | SQLError while closing connections: | \n " + ex.getMessage());
            }
        }
        
        return is_valid;
    }
    public synchronized boolean checkTransaction(String transaction_id) throws ClassNotFoundException{
        boolean is_exists = false;
        SimpleDateFormat ldtime = new SimpleDateFormat("yyyyMMddhhmmss");
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String loggingTime = ldtime.format(ts);
        try
        {
            String sql = "select count(*)::int from confirmation where transid = ?";
            PG_DataSource pgConnector = new PG_DataSource();            
            con = pgConnector.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, transaction_id);
            rs = ps.executeQuery();    
            while(rs.next())
            {
                int count = rs.getInt("count");
                if(count > 0)
                {
                    is_exists = true;
                }
            }
            con.close();
            ps.close();
        } catch(SQLException ex)
        {
           logger.fatal("| LOG Time | " + loggingTime +"\n | SQLError while getting the transid: |" + transaction_id +" | Error : \n " + ex.getMessage());
        } 
        finally
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } catch (SQLException ex) 
            {
                logger.fatal("| LOG Time | " + loggingTime +"\n | SQLError while closing connections: | \n " + ex.getMessage());
            }
        }
        return is_exists;
    }
}
