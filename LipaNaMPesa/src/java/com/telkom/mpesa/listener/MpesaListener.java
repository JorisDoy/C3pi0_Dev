/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telkom.mpesa.listener;

import com.huawei.cps.cpsinterface.c2bpayment.C2BPaymentConfirmationRequest;
import com.huawei.cps.cpsinterface.c2bpayment.C2BPaymentValidationRequest;
import com.huawei.cps.cpsinterface.c2bpayment.C2BPaymentValidationResult;
import com.telkom.ejaze.Balance;
import com.telkom.ejaze.EjazeBalance;
import com.telkom.ocs.userprofile.UserProfileClient;
import com.telkom.util.MailMapper;
import com.telkom.util.Props;
import com.telkom.util.SendSMS;
import com.telkom.util.ValidateInput;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.jws.HandlerChain;
import javax.jws.WebService;

/**
 *
 * @author ericmox
 */
@WebService(serviceName = "C2BPaymentValidationAndConfirmationService", portName = "C2BPaymentValidationAndConfirmationServicePort", endpointInterface = "com.huawei.cps.cpsinterface.c2bpayment.C2BPaymentValidationAndComfirmation", targetNamespace = "http://cps.huawei.com/cpsinterface/c2bpayment", wsdlLocation = "WEB-INF/wsdl/NewWebServiceFromWSDL/CBPInterface_C2BPaymentValidationAndConfirmation.wsdl")
@HandlerChain(file = "soaphandlerchain.xml")
public class MpesaListener {

    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MpesaListener.class.getName());
    private Runnable sm;
    private Thread mailer;
    public Props props = new Props();

    public C2BPaymentValidationResult validateC2BPayment(C2BPaymentValidationRequest c2BPaymentValidationRequest) {
        SendSMS notify = new SendSMS(props);
        C2BPaymentValidationResult result = new C2BPaymentValidationResult();
        ValidateInput vi = new ValidateInput();

        String tklmsisdn = c2BPaymentValidationRequest.getBillRefNumber().trim().replaceAll("[^0-9]", "").replace("+", "");
        String amount = c2BPaymentValidationRequest.getTransAmount();

        float transamount = 0.0F;
        try {
            transamount = Float.parseFloat(amount);
        } catch (NumberFormatException ex) {
            this.logger.error(ex.getMessage());
        }
        
        String transid = c2BPaymentValidationRequest.getTransID();
        String transtime = c2BPaymentValidationRequest.getTransTime();
        String safmsisdn = c2BPaymentValidationRequest.getMSISDN();
        List<C2BPaymentValidationRequest.KYCInfo> kyc_info = c2BPaymentValidationRequest.getKYCInfo();

        String fname = "";
        String mname = "";
        String lname = "";
        for (C2BPaymentValidationRequest.KYCInfo kyc : kyc_info) {
            if (kyc.getKYCName().toLowerCase().contains("first name")) {
                fname = kyc.getKYCValue();
            }
            if (kyc.getKYCName().toLowerCase().contains("middle name")) {
                mname = kyc.getKYCValue();
            }
            if (kyc.getKYCName().toLowerCase().contains("last name")) {
                lname = kyc.getKYCValue();
            }
        }
        
        this.logger.info("!!!!!!!!!!!!!!!!!!!!!!!!\nreceived request\n!!!!!!!!!!!!!!!!!!!!!!!!");
        this.logger.info("transtype:" + c2BPaymentValidationRequest.getTransType() + "transid: " + transid + "transtime: " + transtime +
            "|transamount: " + c2BPaymentValidationRequest.getTransAmount() + "|businesshortcode: " + c2BPaymentValidationRequest.getBusinessShortCode() +
            "|billrefnumber: " + tklmsisdn + "|invoicenumber: " + c2BPaymentValidationRequest.getInvoiceNumber() + 
            "|msisdn: " + safmsisdn +  "kycinfo: " + fname + ";" + mname + ";" + lname);

        EjazeBalance getbal = new EjazeBalance();
        Balance bal = getbal.request("http://192.168.27.64:9898/pretups/C2SReceiver?REQUEST_GATEWAY_CODE=XMLGW&REQUEST_GATEWAY_TYPE=XMLGW&LOGIN=pretups&PASSWORD=1357&SOURCE_TYPE=XMLGW&SERVICE_PORT=194");
        
        if (bal.isIsSuccessful()) {
            if (bal.getBALANCE() < transamount) {
                HashMap<String, String> receipients = new HashMap();
                receipients.put("to", this.props.getMail_to_sales() + ", " + this.props.getMail_to_marketing() + "," + this.props.getMail_to_finance());
                receipients.put("cc", this.props.getMail_to_invas() + ", " + this.props.getMail_to_om());
                this.sm = new MailMapper(receipients, "Following purchase failed due to lack of E-jaze float. <br/>Customer Number: " + tklmsisdn + "<br/> Aitime purchase amount: " + transamount + "<br/>Current Ejaze balance: " + bal.getBALANCE(), this.props);

                this.mailer = new Thread(this.sm);
                this.mailer.start();

                this.logger.error("Ejaze balance is less than requested amount, Transaction stop for: " + tklmsisdn + " MPesa receipt: " + transid + " MPesa MSISDN: " + safmsisdn);
                notify.sendSMS(safmsisdn, "Dear customer, our systems are currently down, please try again later.");

                result.setResultCode("5");
                result.setResultDesc("No E-jaze float");
            }
        } else {
            String message;
            if (bal.getTXNSTATUS() == null) {
                message = "Ejaze timed out during balance query (Validation step)";
            } else {
                message = "Ejaze returned an error with status: " + bal.getTXNSTATUS() + " during balance query. Transaction for following will fail <br/>Customer Number: " + tklmsisdn + "<br/> Aitime purchase amount: " + transamount + "<br/>Current Ejaze balance: " + bal.getBALANCE();
            }
            this.logger.error("Issue on E-jaze\n E-jaze status: " + bal.getTXNSTATUS());

            HashMap<String, String> receipients = new HashMap();
            receipients.put("cc", "mfstechnichal@telkom.co.ke");
            receipients.put("to", this.props.getMail_to_invas() + ", " + this.props.getMail_to_om());
            this.sm = new MailMapper(receipients, message, this.props);
            this.mailer = new Thread(this.sm);
            this.mailer.start();

            this.logger.error(message);

            result.setResultCode("6");
            result.setResultDesc("Ejaze problem");
        }
        
        if ((vi.isValidInput(tklmsisdn, "[0-9]*")) && (tklmsisdn.length() != 0) && ((tklmsisdn.length() == 10) || (tklmsisdn.length() == 12) || (tklmsisdn.length() == 9))) {
            String msisdn = "";
            if ((!tklmsisdn.startsWith("0")) && (!tklmsisdn.startsWith("254"))) {
                String holder = tklmsisdn.trim().replaceAll(" ", "");
                msisdn = "254" + holder;
            } else if ((tklmsisdn.startsWith("0")) && (!tklmsisdn.startsWith("254"))) {
                String holder = tklmsisdn.trim().replaceAll(" ", "");
                msisdn = holder.replaceAll("^0", "254");
            } else {
                msisdn = tklmsisdn.trim().replaceAll(" ", "");
            }
            
            //check customer's profile on OCS
            UserProfileClient upc = new UserProfileClient();
            HashMap<String, String> status = upc.request(msisdn);
            
            if (((String) status.get("flag")).equals("1")) {
                this.logger.warn("Number profile not on OCS. OCS return code: " + (String) status.get("rc") + " OCS returned message: " + (String) status.get("rm") + " request id was: " + (String) status.get("ri"));
                this.logger.error("Unable to determine OCS profile fo number " + tklmsisdn);

                notify.sendSMS(msisdn, this.props.getCustomer_number_format_invalid());

                result.setResultCode("9");
                result.setResultDesc("Failed to get OCS profile for MSISDN. Error related to OCS");
            }
            if (((String) status.get("pp")).equals("1")) {
                this.logger.error(tklmsisdn + " is postpaid, cannot top up. Validation fails!");
                notify.sendSMS(safmsisdn, this.props.getCustomer_number_postpaid());

                result.setResultCode("10");
                result.setResultDesc("Postpaid number provided. Offer not available for postpaid");
            }
            
            switch ((String) status.get("s")) {
                case "B":
                    notify.sendSMS(safmsisdn, this.props.getCustomer_in_state_b());

                    result.setResultCode("3");
                    result.setResultDesc("Terminated number");
                case "":
                    notify.sendSMS(safmsisdn, tklmsisdn + " is not provisioned");

                    result.setResultCode("4");
                    result.setResultDesc("Number not provisioned yet");
            }
            
            if (transamount < Integer.parseInt("5")) {
                notify.sendSMS(safmsisdn, this.props.getCustomer_purchase_invalid_amount());

                this.logger.warn("Amount " + transamount + " requested by " + tklmsisdn + " is bellow allowed min");

                result.setResultCode("7");
                result.setResultDesc("Amount below allowed min");
            }
            else if (transamount > Integer.parseInt("20000")) {
                notify.sendSMS(safmsisdn, this.props.getCustomer_purchase_invalid_amount());

                this.logger.warn("Amount " + transamount + " requested by " + tklmsisdn + " is above allowed max");

                result.setResultCode("8");
                result.setResultDesc("Amount above allowed max");
            }

            //if we get here and there's no error then success?
            if (result.getResultCode().equals("")) {
                result.setResultCode("0");
                result.setResultDesc("Success");
            }
        }
        else {
            result.setResultCode("1");
            result.setResultDesc("Invalid number");
            notify.sendSMS(safmsisdn, this.props.getCustomer_number_format_invalid());
        }

        //add the transaction id
        result.setThirdPartyTransID(generateTransactionId());

        return result;
    }

    public String confirmC2BPayment(C2BPaymentConfirmationRequest c2BPaymenConfirmationRequest) {
        String msisdn;
        
        //check if the confirmation has already been received
        /**
         * if (confirmation.already.processed {
         * this.logger.error("Error Transaction Id already exists: " + c2BPaymenConfirmationRequest.getTransID());
         * }
         * else {
         */
        
            if (c2BPaymenConfirmationRequest.getBillRefNumber().trim().replaceAll("[^0-9]", "").replace("+", "").startsWith("0")) {
                msisdn = c2BPaymenConfirmationRequest.getBillRefNumber().trim().replaceAll("[^0-9]", "").replaceAll(" ", "").replace("+", "").replaceAll("^0", "254");
            } else if (!c2BPaymenConfirmationRequest.getBillRefNumber().trim().replaceAll("[^0-9]", "").replace("+", "").replace("+", "").startsWith("254")) {
                String holder = c2BPaymenConfirmationRequest.getBillRefNumber().trim().replaceAll("[^0-9]", "").replaceAll(" ", "").replace("+", "");
                msisdn = "254" + holder;
            } else {
                msisdn = c2BPaymenConfirmationRequest.getBillRefNumber().trim().replaceAll("[^0-9]", "").replace("+", "").replaceAll(" ", "").replace("+", "");
            } 
        /*
        }
        */    
        
        return "success";
    }

    public String generateTransactionId() {
        Date date = new Date();
        long time = date.getTime();
        String trans_id = time + "" + (int) (Math.random() * 1.0E7D);
        return trans_id;
    }
}
