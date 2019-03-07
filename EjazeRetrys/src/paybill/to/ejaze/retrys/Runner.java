/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paybill.to.ejaze.retrys;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import paybill.to.ejaze.retrys.DB.Inserts;
import paybill.to.ejaze.retrys.uitils.AirtimePurchaseInfo;

/**
 *
 * @author jdmwamburi
 */
public class Runner implements Runnable
{
    public AirtimePurchaseInfo api;
    public DataSource ds; 
    public Inserts ins = new Inserts();
    private static final Logger logger = Logger.getLogger(Runner.class.getName());
    
    public Runner(AirtimePurchaseInfo api, DataSource ds)
  {
        this.api = api;
        this.ds = ds;
  }
    @Override
    public void run() 
    {
        SimpleDateFormat ldtime = new SimpleDateFormat("yyyyMMddhhmmss");
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String loggingTime = ldtime.format(ts);
        logger.info("LOG Time | "+ loggingTime + " | Started inserting into confirmation for Mpesa id | "+ api.getTransid() +" |" + "Mobile number | "+ api.getBillrefnumber());
        try 
        {
            ins.insertConfirmationData("Delayed Confirmations", api.getTransid(), api.getTranstime(), 
                    api.getTransamount(), "777711", api.getBillrefnumber(), "", "", 
                    "",api.getMsisdn(), api.getKycinfo(),"", "True", api.getTelkom_txn_id(), "", "", "");
        } 
        catch (ClassNotFoundException ex) 
        {
            logger.fatal(ex);
        }
    }
    
}
