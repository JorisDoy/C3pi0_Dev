/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paybill.to.ejaze.retrys;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import paybill.to.ejaze.retrys.DB.Inserts;
import paybill.to.ejaze.retrys.DB.Selects;
import paybill.to.ejaze.retrys.DB.Updates;
import paybill.to.ejaze.retrys.uitils.AirtimePurchaseInfo;
import paybill.to.ejaze.retrys.ejaze.EjazeClient;
import paybill.to.ejaze.retrys.ejaze.Recharge;
import paybill.to.ejaze.retrys.uitils.Configs;
import paybill.to.ejaze.retrys.uitils.MailMapper;
import paybill.to.ejaze.retrys.uitils.Props;
import paybill.to.ejaze.retrys.uitils.SendMail;

/**
 *
 * @author jdmwamburi
 */
public class Mapper  implements Runnable {
  public AirtimePurchaseInfo api;
  public DataSource ds; 
  public EjazeClient ec = new EjazeClient();
  public Selects sel  = new Selects();
  public Inserts ins = new Inserts();
  public Updates upd = new Updates();
  public Props props = new Props();
  public String message = null;
  String transact_status, confirmation_message, txn_status_code, txn_status_id,ocs_topups, retry_status_code ;
  private Runnable sm;
  private Thread mailer;
  HashMap<String, String> receipients = new HashMap();
  
  private static final Logger logger = Logger.getLogger(EjazeRetrys.class.getName());
  
  public Mapper(AirtimePurchaseInfo api, DataSource ds)
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
      //chec if the transid already exists in confirmation table
      //if it exists don't do a direct topup
      //if it doesn't exist do a direct top up
      Recharge recharge = ec.request(Configs.PRETUPSURLRECHARGE, api.getBillrefnumber().replaceAll("^254", "0"), api.getTransamount(), api.getTransid());
      SendMail mail = new SendMail(this.props);
      receipients.put("cc", "mfstechnichal@telkom.co.ke");
      receipients.put("to", this.props.getMail_to_invas() + ", " + this.props.getMail_to_om());
      if(recharge.getTXNID() == null) //Ejaze Topup has timed out send notification email that ejaze has timed out in confirmation
      {
          
          message = "Ejaze timed out during Subscriber "+ api.getBillrefnumber().replaceAll("^254", "0" ) + " top up, "
                  + " of Amount " + api.getTransamount() +" during (Ejaze retry)";
          logger.info("LOG Time | "+ loggingTime +  " | Issue on E-jaze during customer top up | status: "
                  + recharge.getTXNID() + "MSISDN | " + api.getBillrefnumber().replaceAll("^254", "0" ) );
          
          this.sm = new MailMapper(receipients, message, this.props);
          this.mailer = new Thread(this.sm);
          this.mailer.start();
          
          if (recharge.getTXNSTATUS() == null)
          {
              //update the transact_status, confirmation_message, txn_status_code, txn_status_id,ocs_topups, retry_status_code in DB for each transid 
              message = recharge.getTXNMESSAGE();
              ocs_topups ="0";
              txn_status_code = recharge.getTXNSTATUS();
              txn_status_id = recharge.getTXNID();
              retry_status_code = "2";
              upd.updateConfirmationData(api.getTransid(), message, txn_status_code, txn_status_id, ocs_topups, retry_status_code);
             message = "Ejaze <strong><b>FAILED</b></strong> to respond. Following topup will fail:<br/><b>MSISDN </b>"
                      + api.getBillrefnumber().replaceAll("^254", "0") + "<br/><b>Amount </b>" + api.getTransamount();
              logger.info("Ejaze failed to respond during recharge for subscriber " 
                      + api.getBillrefnumber().replaceAll("^254", "0" ) 
                      + " of amount " + api.getTransamount());
          }
          else
          {
              //update the transact_status, confirmation_message, txn_status_code, txn_status_id,ocs_topups, retry_status_code in DB for each transid
              message = recharge.getTXNMESSAGE();
              ocs_topups ="0";
              txn_status_code = recharge.getTXNSTATUS();
              txn_status_id = recharge.getTXNID();
              retry_status_code = "2";
              upd.updateConfirmationData(api.getTransid(), message, txn_status_code, txn_status_id, ocs_topups, retry_status_code);
              message = "Ejaze returned an error with status: " + recharge.getTXNSTATUS() + " message: " + recharge.getTXNMESSAGE() +
                      " during recharge. Transaction for following will fail <br/>Customer Number: "
                      + api.getBillrefnumber().replaceAll("^254", "0") + "<br/> Aitime purchase amount: " + api.getTransamount() + "<br/>";
              logger.info("Ejaze failed to respond or there was an error during recharge"
                      + "| " + recharge.toString().replaceAll("\\s", ""));
          }
          this.sm = new MailMapper(receipients, confirmation_message, this.props); 
          this.mailer = new Thread(this.sm);
          this.mailer.start();
      }
      if (!recharge.isIsSuccessful())
      {
            message = recharge.getTXNMESSAGE();
            ocs_topups ="0";
            txn_status_code = recharge.getTXNSTATUS();
            txn_status_id = recharge.getTXNID();
            retry_status_code = "2";
          //update the transact_status, confirmation_message, txn_status_code, txn_status_id,ocs_topups, retry_status_code in DB for each transid
          upd.updateConfirmationData(api.getTransid(), message, txn_status_code, txn_status_id, ocs_topups, retry_status_code);
          logger.info("Logging unsuccessful Ejaze payload " + "|" + recharge.toString());
          receipients.put("cc", this.props.getMail_to_sales() + ", " + this.props.getMail_to_marketing() + "," + this.props.getMail_to_finance());
          receipients.put("to", this.props.getMail_to_invas() + ", " + this.props.getMail_to_om());
      }
      logger.info("LOG Time | "+ loggingTime + " | Processed Ejaze topup for Mpesa id | "+ api.getTransid() +" |" + "Mobile number | "+ api.getBillrefnumber());
      // update the status to successful using rec_id
      if(recharge.isIsSuccessful())
      {
          message = recharge.getTXNMESSAGE();
          ocs_topups ="0";
          txn_status_code = recharge.getTXNSTATUS();
          txn_status_id = recharge.getTXNID();
          retry_status_code = "1";
          //update the transact_status, confirmation_message, txn_status_code, txn_status_id,ocs_topups, retry_status_code in DB for each transid
          upd.updateConfirmationData(api.getTransid(), message, txn_status_code, txn_status_id, ocs_topups, retry_status_code);
      }else
      {
          
          message = recharge.getTXNMESSAGE();
          ocs_topups ="0";
          txn_status_code = recharge.getTXNSTATUS();
          txn_status_id = recharge.getTXNID();
          retry_status_code = "2";
          //update the transact_status, confirmation_message, txn_status_code, txn_status_id,ocs_topups, retry_status_code in DB for each transid
          upd.updateConfirmationData(api.getTransid(), message, txn_status_code, txn_status_id, ocs_topups, retry_status_code);
          logger.info("LOG Time | " + loggingTime + "Direct topup failed for Mpesa_id: " + api.getTransid());
      }
    }
}
