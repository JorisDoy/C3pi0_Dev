/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package failed.ejaze.retry.topups;

import failed.ejaze.retry.topups.DB.Selects;
import failed.ejaze.retry.topups.Utils.FailedConfirmationsInfo;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author jdmwamburi
 */
public class FailedEjazeRetrys {

    /**
     * @param args the command line arguments
     */
    private static final Logger logger = Logger.getLogger(FailedEjazeRetrys.class.getName());
    public static void main(String[] args) throws InterruptedException 
    {
        // TODO code application logic here
        logger.info("********8Starting the Failed Ejaze confirmations retries*********");
        SimpleDateFormat ldtime = new SimpleDateFormat("yyyyMMddhhmmss");
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String loggingTime = ldtime.format(ts);
        Selects sel = new Selects();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String query_date_pattern = sdf.format(ts);
        DataSource ds = null;
        Runnable r0;
        Thread t0;
        // Adding the txn_status_code to look for for the failed 
        /*Map map = new HashMap();
        map.put("","");*/
        String txnCodeTimeout ="251";
        String txnCodeRefused ="23070";
        String txnCodeRetry ="3006202";
        String txnCodeWrongINResponse ="17007";
        String txnCodeNull = "null";
        logger.info("Starting Query to get all Failed Confirmations that are not of txn_status_code = 200");
        List<FailedConfirmationsInfo> api_list = sel.getUsingAll(query_date_pattern,txnCodeTimeout, txnCodeRefused, txnCodeNull, txnCodeRetry, txnCodeWrongINResponse );
        logger.info("Finished Querying Failed Confirmations Data");
        logger.info("Started processing the Data. Checking the size of the Data");
        if(api_list.size() > 0)
        {
            for(FailedConfirmationsInfo api : api_list)
            {
                r0 = new Mapper(api, ds);
                t0 = new Thread(r0);
                t0.start();
                Thread.sleep(100);
            }
         logger.info("Finished Proccessing Failed Confirmations Data");
        }
        else
        {
            logger.fatal("LOG Time | "+ loggingTime + " | No failed confirmations data  found |" + loggingTime);
        }
    }
    
}
