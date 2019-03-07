/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package failed.ejaze.retry.topups;

import failed.ejaze.retry.topups.DB.Selects;
import failed.ejaze.retry.topups.DB.Updates;
import failed.ejaze.retry.topups.Utils.Configs;
import failed.ejaze.retry.topups.Utils.FailedConfirmationsInfo;
import failed.ejaze.retry.topups.Utils.MailMapper;
import failed.ejaze.retry.topups.Utils.Props;
import failed.ejaze.retry.topups.Utils.SendMail;
import failed.ejaze.retry.topups.ejaze.EjazeClient;
import failed.ejaze.retry.topups.ejaze.Recharge;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author jdmwamburi
 */
public class Mapper implements Runnable
{
  public FailedConfirmationsInfo api;
  public DataSource ds; 
  public EjazeClient ec = new EjazeClient();
  public Selects sel  = new Selects();
  public Updates upd = new Updates();
  public Props props = new Props();
  public String message = null;
  private Runnable sm;
  private Thread mailer;
  HashMap<String, String> receipients = new HashMap();
  private static final Logger logger = Logger.getLogger(Mapper.class.getName());
  String retry_status_code;
  
  public Mapper(FailedConfirmationsInfo api, DataSource ds)
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
        
        logger.info("LOG Time | "+ loggingTime + " | Started processing Ejaze topup for Mpesa id | "+ api.getTransid() +" |" + "Mobile number | "+ api.getBillrefnumber());
        
        Recharge recharge = ec.request(Configs.PRETUPSURLRECHARGE, api.getBillrefnumber().replaceAll("^254", "0"), api.getTransamount(), api.getTransid());
        
        if (!recharge.isIsSuccessful()) 
        {
            String ejaze_message = recharge.getTXNMESSAGE();
            logger.info("Logging unsuccessful Ejaze payload " + "|" + recharge.toString());
            SendMail mail = new SendMail(this.props);
            HashMap<String, String> receipients1 = new HashMap();
            receipients1.put("to", "mfstechnical@telkom.co.ke");
            receipients1.put("cc", "mfstechnical@telkom.co.ke");
            //receipients1.put("cc", this.props.getMail_to_sales() + ", " + this.props.getMail_to_marketing() + "," + this.props.getMail_to_finance());
            //receipients1.put("to", this.props.getMail_to_invas() + ", " + this.props.getMail_to_om());
            
            if (recharge.getTXNSTATUS() == null) 
            {
                message = "Ejaze <strong><b>FAILED</b></strong> to respond. "
                        + "<br/>The following topup will fail:"
                        + "<br/><b>MSISDN </b>" + api.getBillrefnumber().replaceAll("^254", "0") + 
                        "<br/><b>Amount </b>" + api.getTransamount();
            } 
            else 
            {
                message = "Ejaze returned an error with status: " + recharge.getTXNSTATUS() + " message: " + recharge.getTXNMESSAGE() 
                        + " during recharge. Transaction for following will fail <br/>Customer Number: " + api.getBillrefnumber().replaceAll("^254", "0")
                        + "<br/> Aitime purchase amount: " + api.getTransamount() + "<br/>";
                this.logger.info("Ejaze failed to respond or there was an error during recharge" 
                            + "| " + recharge.toString().replaceAll("\\s", ""));
            }
            this.sm = new MailMapper(receipients1, message, this.props);
            this.mailer = new Thread(this.sm);
            this.mailer.start();
            // update the status code in the confirmation table to 2
            retry_status_code = "2";
            //Make an update into the confirmation table into the following columns
            //message,txn_status_code,txn_status_id,retry_status_code =2 
            upd.updateFailedRetryStatus(api.getTransid(), retry_status_code);
            logger.info("1 update done for transid | " + api.getTransid());
        }
        this.logger.info("Logging Successful Ejaze payload " + "|mpesaid|"
                + api.getTransid() +"|amount|"+ api.getTransamount() +"|MSISDN|"+ api.getBillrefnumber().replaceAll("^254", "0") +"|"+ recharge);
        //Make an update into the confirmation table into the following columns
        //message,txn_status_code,txn_status_id,retry_status_code =2 
        retry_status_code ="1";
        upd.updateFailedRetryStatus(api.getTransid(),retry_status_code);
        logger.info("1 update done for transid | " + api.getTransid());
    }
}
