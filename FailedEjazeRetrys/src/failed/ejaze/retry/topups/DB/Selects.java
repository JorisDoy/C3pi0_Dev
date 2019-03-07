/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package failed.ejaze.retry.topups.DB;

import failed.ejaze.retry.topups.Utils.FailedConfirmationsInfo;
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

/**
 *
 * @author jdmwamburi
 */
public class Selects 
{
    private Connection con = null;
    private ResultSet rs = null;
    private Statement st = null;
    private final PreparedStatement ps = null;
    static final String POSTGRES_JDBC_DRIVER ="org.postgresql.Driver";
    private static final Logger logger = Logger.getLogger(Selects.class.getName());
    
    public synchronized List<FailedConfirmationsInfo> getUsingAll(String trans_date, String txnCodeTimedOut, String txnCodeRefused, String txnCodeNull, String txnCodeRetry, String txnCodeWrongINResponse)
    {
      SimpleDateFormat ldtime = new SimpleDateFormat("yyyyMMddhhmmss");
      Timestamp ts = new Timestamp(System.currentTimeMillis());
      String loggingTime = ldtime.format(ts);
      List<FailedConfirmationsInfo> is_valid = new ArrayList<>();  
      //String sqlQuery = "select transtime, transamount, billrefnumber, transid, msisdn from confirmation where txn_status_code IN ('"+ txnCodeTimedOut + "','"+ txnCodeRefused +"', '"+ txnCodeNull +"', '"+ txnCodeRetry +"', '"+ txnCodeWrongINResponse+"') and retry_status_code IN ('0','2') and transtime BETWEEN SYMMETRIC to_char(now()- interval '5 minutes', 'YYYYMMDDHHMMSS') AND  to_char(now() - interval '30 minutes', 'YYYYMMDDHHMMSS')";
      String sqlQuery = "Select * from confirmation WHERE transdate = '2019-01-02' and txn_status_code = '17007' and retry_status_code IN ('0','2') limit 2";
        try
        {
            Class.forName(POSTGRES_JDBC_DRIVER);
            PG_DataSource pgConnector = new PG_DataSource();
            con = pgConnector.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sqlQuery);
            if(rs == null)
            {
                logger.info("LOG Time | "+ loggingTime + " | No data! No Data!! No Failed Confirmations data Found |" );
            }
            else
            {
                while(rs.next())
                {
                    logger.info("LOG Time | "+ loggingTime + "| Failed Confirmations data found |" );
                    FailedConfirmationsInfo api = new FailedConfirmationsInfo();
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
                    logger.info("LOG Time | "+ loggingTime + "| Validation data for Mpesa id | "+ mpesarefid +" found |" + " for mobile number | "+ billrefnumber + " | of Amount:  |" + transamount );
                    is_valid.add(api);
                }
            }
        } 
        catch (SQLException | ClassNotFoundException ex) 
        {
            logger.info("\n |"+ ex + "| LOG Time | " + loggingTime);
        }  
        finally
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (st != null) 
                {
                    st.close();
                }
                if (con != null)
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                logger.info("| LOG Time | " + loggingTime +"\n | SQLError while closing connections: | \n " + ex.getMessage());
            }
        }
        return is_valid;
    }
}
