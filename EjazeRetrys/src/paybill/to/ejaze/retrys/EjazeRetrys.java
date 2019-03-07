/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paybill.to.ejaze.retrys;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import paybill.to.ejaze.retrys.DB.Selects;
import paybill.to.ejaze.retrys.uitils.AirtimePurchaseInfo;

/**
 *
 * @author jdmwamburi
 */
public class EjazeRetrys {

    private static final Logger logger = Logger.getLogger(EjazeRetrys.class.getName());
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        SimpleDateFormat ldtime = new SimpleDateFormat("yyyyMMddhhmmss");
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String loggingTime = ldtime.format(ts);
        
        logger.info("\n LOG Time | "+ loggingTime + "Started Ejaze retry application |" );
        DataSource ds = null; //= PG_DataSource.getInstance().getDataSource();
        Selects sel = new Selects();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String query_date_pattern = sdf.format(ts);
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy_MM_dd");
        String partition = sdFormat.format(ts);
        Runnable r0, r1;
        Thread t0, t1;
        logger.info("\n LOG Time | "+ loggingTime + " | Started Querrying for delayed validations data |");
        List<AirtimePurchaseInfo> api_list = sel.getUsingAll(query_date_pattern, partition);
       logger.info("\n LOG Time | "+ loggingTime + " | Finished Querrying for delayed validations data |");
        if(api_list.size() > 0)
        {
            //Do an insert into the confirmations table first
            for(AirtimePurchaseInfo inConfirmation : api_list)
            {
                r1 = new Runner(inConfirmation, ds);
                t1 = new Thread(r1);
                t1.start();
                Thread.sleep(100);
            }
            //Get the same Data and retry to Ejaze
            for(AirtimePurchaseInfo api : api_list)
            {
                // String start_time, String end_time, AirtimePurchaseInfo api, DataSource ds
                r0 = new Mapper(api, ds);
                t0 = new Thread(r0);
                t0.start();

                Thread.sleep(100);
            }
        }
        else
        {
            logger.info("\n LOG Time | "+ loggingTime + " | No validation data  found |" + loggingTime);
        }
    }
    
}
