/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telkom.postpaid.mpesa;

import com.huawei.cps.cpsinterface.c2bpayment.C2BPaymentConfirmationRequest;
import com.huawei.cps.cpsinterface.c2bpayment.C2BPaymentValidationRequest;
import com.huawei.cps.cpsinterface.c2bpayment.C2BPaymentValidationResult;
import com.telkom.postpaid.mpesa.db.Inserts;
import com.telkom.postpaid.mpesa.db.PG_DataSource;
import com.telkom.postpaid.mpesa.utils.MailMapper;
import com.telkom.postpaid.mpesa.utils.Props;
import com.telkom.postpaid.mpesa.utils.SendSMS;
import com.telkom.postpaid.mpesa.utils.ValidateInput;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jdmwamburi
 */
@WebService(serviceName = "C2BPaymentValidationAndConfirmationService", portName = "C2BPaymentValidationAndConfirmationServicePort", endpointInterface = "com.huawei.cps.cpsinterface.c2bpayment.C2BPaymentValidationAndComfirmation", targetNamespace = "http://cps.huawei.com/cpsinterface/c2bpayment", wsdlLocation = "WEB-INF/wsdl/PostpaidPaybill/CBPInterface_C2BPaymentValidationAndConfirmation.wsdl")
@HandlerChain(file = "soaphandlerchain.xml")
public class PostpaidPaybill {
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PostpaidPaybill.class.getName());
    private Runnable sm;
    private Thread mailer;
    public  Props props = new Props();
    private Connection conn;
    
    public com.huawei.cps.cpsinterface.c2bpayment.C2BPaymentValidationResult validateC2BPayment(com.huawei.cps.cpsinterface.c2bpayment.C2BPaymentValidationRequest c2BPaymentValidationRequest) throws SQLException, ClassNotFoundException, PropertyVetoException {
        PG_DataSource ds = new PG_DataSource();
        conn = ds.getConnection();
        SendSMS notify = new SendSMS(props);
        C2BPaymentValidationResult result = new C2BPaymentValidationResult();
        ValidateInput vi = new ValidateInput();
        Inserts ins = new Inserts();
        String transationTimestamp = generateTransactionId();
        String tklmsisdn = c2BPaymentValidationRequest.getBillRefNumber().trim().replaceAll("[^0-9]", "").replace("+", "");
        String amount = c2BPaymentValidationRequest.getTransAmount();
        String logHeader;
        float transamount = 0.0F;
        try {
            transamount = Float.parseFloat(amount);
        } catch (NumberFormatException ex) {
            this.logger.info(ex.getMessage());
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
        this.logger.info("!!!!!!!!!!!!!!!!!!!!!!!! received Validation request !!!!!!!!!!!!!!!!!!!!!!!!");
        this.logger.info("transtype:" + c2BPaymentValidationRequest.getTransType() + "|transid: " + transid + "|transtime: " + transtime +
            "|transamount: " + c2BPaymentValidationRequest.getTransAmount() + "|businesshortcode: " + c2BPaymentValidationRequest.getBusinessShortCode() +
            "|billrefnumber: " + tklmsisdn + "|invoicenumber: " + c2BPaymentValidationRequest.getInvoiceNumber() + 
            "|msisdn: " + safmsisdn +  "|kycinfo: " + fname + ";" + mname + ";" + lname);
        logHeader = transid + "|" + transtime + "|" + transamount + "|" + tklmsisdn + "|" + safmsisdn + "|";
        //Disable SSL
        disableSslVerification();
        //Validate the TKL number input
        if ((vi.isValidInput(tklmsisdn, "[0-9]*")) && (tklmsisdn.length() != 0) && ((tklmsisdn.length() == 10) || (tklmsisdn.length() == 12) || (tklmsisdn.length() == 9))) 
        {
            //MAKE A CALL TO GPTO to query if MSISDN EXISTS
            //MAKE A GET CALL TO GETACC API on Gpto
            String msisdn;
            if ((!tklmsisdn.startsWith("0")) && (!tklmsisdn.startsWith("254"))) 
            {
                String holder = tklmsisdn.trim().replaceAll(" ", "");
                msisdn = "" + holder;
            } 
            else if (tklmsisdn.startsWith("254")){
                String holder = tklmsisdn.trim().replaceAll(" ", "");
                msisdn = holder.replaceAll("^254", "");
            }
            else if ((tklmsisdn.startsWith("0")) && (!tklmsisdn.startsWith("254"))) 
            {
                String holder = tklmsisdn.trim().replaceAll(" ", "");
                msisdn = holder.replaceAll("^0", "");
            }
            else 
            {
                msisdn = tklmsisdn.trim().replaceAll(" ", "");
            }
  
            String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0";
            //String GET_URL_TEST ="https://10.22.25.18:8085/pos/payment/getacc?lineNumber=" + msisdn;
            //String GET_URL_PROD ="https://10.22.25.10:8085/pos/payment/getacc?lineNumber=" + msisdn;
            String GET_URL ="https://10.22.25.10:8085/pos/payment/getacc?lineNumber=" + msisdn;
            try 
                {
                    URL obj = new URL(GET_URL);
                    HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
                    con.setRequestProperty("Content-Type", "application/json; charset=\"UTF-8\"");
                    con.setRequestProperty("User-Agent", USER_AGENT);
                    con.setRequestMethod("GET");
                    int responseCode = con.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) 
                    {
                        //Success
                        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                                String inputLine;
                                StringBuilder response = new StringBuilder();
                                while ((inputLine = in.readLine()) != null) 
                                {
                                        response.append(inputLine);
                                }
                                in.close();
                                // print result
                                //System.out.println(response.toString());
                                logger.info("GET Request API response | " +response.toString());
                           //Get the response value
                           String responseValue;
                           JSONObject getAccResp = new JSONObject(response.toString());
                           responseValue = getAccResp.getString("response");
                           if(responseValue != null)
                           {
                            switch (responseValue) 
                                {
                                    case "Success":
                                        ins.insertValidationData(c2BPaymentValidationRequest.getTransType(), c2BPaymentValidationRequest.getTransID(),
                                        c2BPaymentValidationRequest.getTransTime(), c2BPaymentValidationRequest.getTransAmount(),
                                        c2BPaymentValidationRequest.getBusinessShortCode(), msisdn, c2BPaymentValidationRequest.getInvoiceNumber(),
                                        c2BPaymentValidationRequest.getMSISDN(), fname + " " + lname + " " + mname, transationTimestamp,
                                        c2BPaymentValidationRequest.getTransTime(), "successful", "Successful",transid);
                                        result.setResultCode("0");
                                        result.setResultDesc("Success");
                                        this.logger.info(logHeader + " Successful Validation!");
                                        break;
                                    // response = "Error fetching records" //number not postpaid
                                    case "Error fetching records":
                                        //Send SMS To Subscriber to their Safaricom number to let them know that the mobile number they entered is not prepaid
                                        notify.sendSMS(msisdn, "The mobile number entered is a prepaid number and is not allowed to use this service");
                                        //Send Email 
                                        HashMap<String, String> receipients = new HashMap();
                                        receipients.put("to", this.props.getMail_to_sales() + ", " + this.props.getMail_to_marketing() + "," + this.props.getMail_to_finance());
                                        receipients.put("cc", this.props.getMail_to_invas() + ", " + this.props.getMail_to_om());
                                        this.sm = new MailMapper(receipients, "Following postpaid validation from postpaid paybill 766600 failed because "
                                                + "POS / GPTO returned an error: "+ responseValue +" <br/> Customer Number: " + tklmsisdn 
                                                + "<br/> Payment amount: " + transamount + "<br/>" 
                                                + "<br/> Failure reason sent to mpesa: Prepaid number provided. Offer not available for prepaid <br/>", this.props);

                                        this.mailer = new Thread(this.sm);
                                        this.mailer.start();
                                        
                                        this.logger.error(logHeader + " is prepaid, cannot top up. Validation fails!");
                                        
                                        //Insert into DB
                                        ins.insertValidationData(
                                                c2BPaymentValidationRequest.getTransType(), c2BPaymentValidationRequest.getTransID(),
                                                c2BPaymentValidationRequest.getTransTime(), c2BPaymentValidationRequest.getTransAmount(),
                                                c2BPaymentValidationRequest.getBusinessShortCode(), msisdn, 
                                                " ", c2BPaymentValidationRequest.getMSISDN(), 
                                                fname.trim() + " " + lname.trim() + " " + mname.trim(), transationTimestamp,
                                                "", "failed", 
                                                "Prepaid number provided. Offer not available for prepaid", transid);
                                        result.setResultCode("2");
                                        result.setResultDesc("Prepaid number provided. Offer not available for prepaid");
                                        this.logger.info(logHeader + " Error Validation! Prepaid number provided. Offer not available for prepaid");
                                        break;
                                }
                           }
                           else //IF CRM/GPTO DOES NOT RETRUN A RESPONSE
                           {
                                //Send email Notification with the error message recieved 
                                String message ="Error Validation! CRM / GPTO Did not return a response";
                                HashMap<String, String> receipients = new HashMap();
                                        receipients.put("to", this.props.getMail_to_sales() + ", " + this.props.getMail_to_marketing() + "," + this.props.getMail_to_finance());
                                        receipients.put("cc", this.props.getMail_to_invas() + ", " + this.props.getMail_to_om());
                                        this.sm = new MailMapper(receipients, "Following postpaid validation from postpaid paybill 766600 failed because "
                                                + "POS / GPTO returned an error: "+ message +" <br/> Customer Number: " + tklmsisdn 
                                                + "<br/> Payment amount: " + transamount + "<br/>", this.props);

                                        this.mailer = new Thread(this.sm);
                                        this.mailer.start();
                                ins.insertValidationData(c2BPaymentValidationRequest.getTransType(),
                                c2BPaymentValidationRequest.getTransID(), c2BPaymentValidationRequest.getTransTime(),
                                c2BPaymentValidationRequest.getTransAmount(), c2BPaymentValidationRequest.getBusinessShortCode(),
                                c2BPaymentValidationRequest.getBillRefNumber(), "",
                                c2BPaymentValidationRequest.getMSISDN(), fname + " " + lname + " " + mname, transationTimestamp,
                                "", "failed", "Error Validation! CRM / GPTO Didnot retrun a response", transid);
                                //Send SMS
                                result.setResultCode("3");
                                result.setResultDesc("CRM Problem");
                                this.logger.info(logHeader + " Error Validation! CRM / GPTO Problem");
                           }
                    }
                    else
                    {
                        //System.out.println("GET request not worked");
                        String failure = "GET request  for GET ACC API to POS failed";
                        HashMap<String, String> receipients = new HashMap();
                        receipients.put("to", "mfstechnical@telkom.co.ke");
                        receipients.put("cc", this.props.getMail_to_invas() + ", " + this.props.getMail_to_om());
                        this.sm = new MailMapper(receipients, "Following postpaid validation from postpaid paybill 766600 failed because "
                                + "POS / GPTO returned an error: "+ failure +" <br/> Customer Number: " + tklmsisdn 
                                + "<br/> Payment amount: " + transamount + "<br/>", this.props);

                        this.mailer = new Thread(this.sm);
                        this.mailer.start();
                        this.logger.info(logHeader + " GET request did not work");
                    }
                } 
                catch (MalformedURLException ex) 
                {
                    logger.error(ex);
                }  
                catch (ProtocolException | JSONException  ex) 
                {
                    logger.error(ex);
                }catch (IOException ex) 
                {
                   logger.error(ex);
                }
            //Logger.getLogger(PostpaidPaybill.class.getName()).log(Level.SEVERE, null, ex);     
        }
        else 
        {
            ins.insertValidationData(c2BPaymentValidationRequest.getTransType(), c2BPaymentValidationRequest.getTransID(),
                c2BPaymentValidationRequest.getTransTime(), c2BPaymentValidationRequest.getTransAmount(),
                c2BPaymentValidationRequest.getBusinessShortCode(), c2BPaymentValidationRequest.getBillRefNumber(),
                c2BPaymentValidationRequest.getInvoiceNumber(), c2BPaymentValidationRequest.getMSISDN(),
                fname + " " + lname + " " + mname, transationTimestamp, c2BPaymentValidationRequest.getTransTime(),
                "failed", "Invalid number", transid);
            result.setResultCode("1");
            result.setResultDesc("Invalid number");
            notify.sendSMS(safmsisdn, "The Telekom mobile number you have entered is incorrect. Please try again with the correct mobile number.");
        }
        //add the transaction id
        result.setThirdPartyTransID(transationTimestamp);
        return result;
    }

    public java.lang.String confirmC2BPayment(com.huawei.cps.cpsinterface.c2bpayment.C2BPaymentConfirmationRequest c2BPaymenConfirmationRequest) throws ClassNotFoundException {
        String respTOBroker = null;
        String receiptNo = null, receiptDate = null, recieptAmount = null;
        String msisdntkl;
        String transationTimestamp = generateTransactionId();
        String tklmsisdn = c2BPaymenConfirmationRequest.getBillRefNumber().trim().replaceAll("[^0-9]", "").replace("+", "");
        String amount = c2BPaymenConfirmationRequest.getTransAmount();
        String logHeader;
        Inserts ins = new Inserts();
        SendSMS notify = new SendSMS(props);
        float transamount = 0.0F;
        try 
        {
            transamount = Float.parseFloat(amount);
        } 
        catch (NumberFormatException ex) 
        {
            this.logger.error(ex.getMessage());
        }
        String transid = c2BPaymenConfirmationRequest.getTransID();
        String transtime = c2BPaymenConfirmationRequest.getTransTime();
        String safmsisdn = c2BPaymenConfirmationRequest.getMSISDN();
        List<C2BPaymentConfirmationRequest.KYCInfo> kyc_info = c2BPaymenConfirmationRequest.getKYCInfo();
        String fname = "";
        String mname = "";
        String lname = "";
        for (C2BPaymentConfirmationRequest.KYCInfo kyc : kyc_info) {
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
        this.logger.info("!!!!!!!!!!!!!!!!!!!!!!!!\n received confimation request\n!!!!!!!!!!!!!!!!!!!!!!!!");
        this.logger.info("transtype:" + c2BPaymenConfirmationRequest.getTransType() + "|transid: " + transid + "|transtime: " + transtime +
            "|transamount: " + c2BPaymenConfirmationRequest.getTransAmount() + "|businesshortcode: " + c2BPaymenConfirmationRequest.getBusinessShortCode() +
            "|billrefnumber: " + tklmsisdn + "|invoicenumber: " + c2BPaymenConfirmationRequest.getInvoiceNumber() + 
            "|msisdn: " + safmsisdn +  "|kycinfo: " + fname + ";" + mname + ";" + lname);
        logHeader = transid + "|" + transtime + "|" + transamount + "|" + tklmsisdn + "|" + safmsisdn + "|";
        //check if the confirmation has already been received
        if (c2BPaymenConfirmationRequest.getBillRefNumber().trim().replaceAll("[^0-9]", "").replace("+", "").startsWith("0")) {
                msisdntkl = c2BPaymenConfirmationRequest.getBillRefNumber().trim().replaceAll("[^0-9]", "").replaceAll(" ", "").replace("+", "").replaceAll("^0", "254");
            } else if (!c2BPaymenConfirmationRequest.getBillRefNumber().trim().replaceAll("[^0-9]", "").replace("+", "").replace("+", "").startsWith("254")) {
                String holder = c2BPaymenConfirmationRequest.getBillRefNumber().trim().replaceAll("[^0-9]", "").replaceAll(" ", "").replace("+", "");
                msisdntkl = "254" + holder;
            } else {
                msisdntkl = c2BPaymenConfirmationRequest.getBillRefNumber().trim().replaceAll("[^0-9]", "").replace("+", "").replaceAll(" ", "").replace("+", "");
            }
            String mpesaRefId = c2BPaymenConfirmationRequest.getTransID();
            //Disable SSL
            disableSslVerification();
            //Make the get call to Save the POST PAYMENT Data
            //MAKE A CALL TO GPTO to query if MSISDN EXISTS
            //MAKE A GET CALL TO GETACC API on Gpto
            String msisdn;
            if ((!tklmsisdn.startsWith("0")) && (!tklmsisdn.startsWith("254"))) 
            {
                String holder = tklmsisdn.trim().replaceAll(" ", "");
                msisdn = "" + holder;
            }
            else if (tklmsisdn.startsWith("254")){
                String holder = tklmsisdn.trim().replaceAll(" ", "");
                msisdn = holder.replaceAll("^254", "");
            }
            else if ((tklmsisdn.startsWith("0")) && (!tklmsisdn.startsWith("254"))) 
            {
                String holder = tklmsisdn.trim().replaceAll(" ", "");
                msisdn = holder.replaceAll("^0", "");
            } 
            else 
            {
                msisdn = tklmsisdn.trim().replaceAll(" ", "");
            }
            String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0";
            //String GET_URL_TEST ="https://10.22.25.18:8085/pos/payment/getacc?lineNumber=" + msisdn;
            //String GET_URL_PROD ="https://10.22.25.10:8085/pos/payment/getacc?lineNumber=" + msisdn;
            String GET_URL ="https://10.22.25.10:8085/pos/payment/getacc?lineNumber=" + msisdn;
            //System.out.println("GET RURL :: " + GET_URL);
            logger.info("GET RURL :: " + GET_URL);
            try 
                {
                    URL obj = new URL(GET_URL);
                    HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
                    con.setRequestProperty("Content-Type", "application/json; charset=\"UTF-8\"");
                    con.setRequestProperty("User-Agent", USER_AGENT);
                    con.setRequestMethod("GET");
                    int responseCode = con.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) 
                    {   
                        //Success
                        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                                String inputLine;
                                StringBuilder getAccresponse = new StringBuilder();
                                while ((inputLine = in.readLine()) != null) 
                                {
                                        getAccresponse.append(inputLine);
                                }
                                in.close();
                                // print result
                                //System.out.println(response.toString());
                                logger.info("Logging response from POS for GETACC in Confirmation| " + getAccresponse.toString());
                           //Get the response value
                           String responseValue, inLine;
                           String product,amountPaid,customerCode,payerCode,currency,lineSequence,channel;
                           JSONObject getAccRespo = new JSONObject(getAccresponse.toString());
                           responseValue = getAccRespo.getString("response");

                           if(responseValue != null)
                           {
                               if("Success".equals(responseValue))
                               {
                                   JSONArray results = (JSONArray) getAccRespo.get("billDetails");
                                   JSONObject resultObject = (JSONObject) results.get(0);
                                    product = resultObject.get("product").toString();
                                    amountPaid = amount;
                                    customerCode = resultObject.get("custCode").toString();
                                    payerCode = resultObject.get("payerCode").toString();
                                    currency = resultObject.get("currency").toString();
                                    lineSequence = resultObject.get("lineSequence").toString();
                                    channel = "mpesapaybill";
                                    //MAKE A POST PAYMENT TO POS PAYMENT POST CALL
                                    String urlParameters  = "lineNumber="+ msisdn + "&amount="+ amount +"&product="+ product +"&customerCode="+ customerCode +"&payerCode="+ payerCode +"&currency="+ currency +"&lineSequence="+ lineSequence +"&channel="+ channel;
                                    //String POST_URL_TEST ="https://10.22.25.18:8085/pos/payment/post?" + urlParameters;
                                    //String POST_URL_PROD ="https://10.22.25.10:8085/pos/payment/post?" + urlParameters;
                                    String POST_URL ="https://10.22.25.10:8085/pos/payment/post?" + urlParameters;
                                    //System.out.println("POST RURL :: " + POST_URL);
                                    logger.info("POST RURL :: " + POST_URL);
                                    byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
                                    int    postDataLength = postData.length;
                                    URL url = new URL(POST_URL);
                                    HttpURLConnection conn= (HttpURLConnection) url.openConnection();
                                    conn.setRequestMethod("POST");
                                    conn.setRequestProperty("Content-Type", "application/json; charset=\"UTF-8\"");
                                    //TEST_TOKEN 
                                    //conn.setRequestProperty("X-AUTH-TOKEN", "eyJ1c2VySWQiOiJpcGFjcyIsInVzZXJEZXNjIjoiaXBhY3MiLCJ1c2VyUGFyZW50SWQiOiJrYXJlYW0iLCJ1c2VyUGFyZW50TmFtZSI6IktBcmVhTWFuYWdlciIsInVzZXJUeXBlSWQiOjEwLCJ1c2VyVHlwZSI6IlNob3AgTWFuYWdlciIsInVzZXJTdGF0dXNJZCI6MywidXNlclN0YXR1cyI6IkFjdGl2ZSIsInVzZXJab25pbmdEZXRhaWwiOnsiem9uZUlkIjoxLCJ6b25lQ29kZSI6bnVsbCwiem9uZSI6IktFTllBIiwiaHViSWQiOjEsImh1YkNvZGUiOiIiLCJodWIiOiJDRU5UUkFMIiwiYXJlYUlkIjowLCJhcmVhQ29kZSI6IkFMTCIsImFyZWEiOiJBTEwifSwidXNlckFkZHJlc3MiOnsiYWRkcmVzczEiOiJhYmN4eXoiLCJhZGRyZXNzMiI6Imxtbm9wcSIsImFkZHJlc3MzIjoiIiwiY29udGFjdE51bWJlciI6IjcwODA4ODE3MSIsInNlY29uZGFyeUNvbnRhY3RObyI6IiIsImVtYWlsSWQiOiJoYXJzaC5zcml2YXN0YXZhQG1haGluZHJhY29tdml2YS5jb20iLCJwb3N0YWxDb2RlIjpudWxsfSwidXNlckNyZWRlbnRpYWxzIjp7InVzZXJuYW1lIjoiaXBhY3MiLCJwYXNzd29yZCI6IiQyYSQxMCREYXpXT095aFd1N2FMd0wuMUdEVGZlRjQ1eDF1R1JWSjVqanRwa3c4enlpRE9xQi9rZzhjMiIsInVzZXJEZXNjIjoiaXBhY3MiLCJvbGRQYXNzd29yZCI6bnVsbCwibm9PZkRheXNTaW5jZUxhc3RQYXNzd29yZENoYW5nZSI6NCwibGFzdExvZ2luRGF0ZSI6IjIwMTgtMTEtMjIiLCJleHBpcmVzIjoxNTQ0MDg3Nzg5NzAyLCJmaXJzdExvZ2luIjpmYWxzZSwidXNlck5hbWUiOiJpcGFjcyJ9LCJwaW5ObyI6Ijc4OTQ1NjQiLCJ2YXRObyI6IjE1NDU2OCIsInBvc3RhbENvZGUiOiI1MDQxMyIsIm5hdGlvbmFsSWQiOiIxMjU0Njg2OTU3IiwiY2hhbm5lbE5hbWUiOiJURUxLT00gUExBWkEiLCJtZnNSaWdodCI6bnVsbCwidXNlckFjdGlvbnMiOm51bGwsInVzZXJBZ2VuY3kiOm51bGwsInVzZXJMYXRpdHVkZSI6IjEuMjkyMSIsInVzZXJMb25naXR1ZGUiOiIgMzYuODIxOSIsImJsb2NrVXNlckNvdW50IjowLCJjb21tZW50cyI6bnVsbCwiY3JlYXRpb25EYXRlIjoiMjAxOC0wMi0yMSIsInN1c3BlbmRJZCI6bnVsbCwic3RhcnREYXRlIjoxNTE3NDQzMjAwMDAwLCJlbmREYXRlIjoxNTkyMTc5MjAwMDAwLCJzdXNwZW5kRGVzYyI6bnVsbCwidXNlclBhcmVudHNEVE9zIjpbXSwiYWRkQnkiOiJrQXJlYU0iLCJ1c2VyU3RhZmYiOiJ0cnVlIiwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfRElTVFJJQlVUT1IifSx7ImF1dGhvcml0eSI6IlJPTEVfVVNFUiJ9XX0=.XxruOwfBXHzRIkEK+HjuYm1vRhzVOrA/GM25ilLHJbs=");
                                    //PROD_TOKEN 
                                    //conn.setRequestProperty("X-AUTH-TOKEN", "eyJ1c2VySWQiOiJzaG9wdGVzdCIsInVzZXJEZXNjIjoiU2hvcCBUZXN0aW5nIiwidXNlclBhcmVudElkIjoic2hvcHRlc3QiLCJ1c2VyUGFyZW50TmFtZSI6IlNob3AgVGVzdGluZyIsInVzZXJUeXBlSWQiOjEwLCJ1c2VyVHlwZSI6IlNob3AgTWFuYWdlciIsInVzZXJTdGF0dXNJZCI6MywidXNlclN0YXR1cyI6IkFjdGl2ZSIsInVzZXJab25pbmdEZXRhaWwiOnsiem9uZUlkIjoyMSwiem9uZUNvZGUiOm51bGwsInpvbmUiOiJOQUlST0JJIiwiaHViSWQiOjIxLCJodWJDb2RlIjoiIiwiaHViIjoiTkFJUk9CSSIsImFyZWFJZCI6MjEsImFyZWFDb2RlIjoiIiwiYXJlYSI6Ik5BSVJPQkkifSwidXNlckFkZHJlc3MiOnsiYWRkcmVzczEiOiJhMS81YiIsImFkZHJlc3MyIjoiIiwiYWRkcmVzczMiOiJub3QgcHJlc2VudCIsImNvbnRhY3ROdW1iZXIiOiI5ODE4MDk1OTMiLCJzZWNvbmRhcnlDb250YWN0Tm8iOiIiLCJlbWFpbElkIjoiU2hvcFRlc3RAdGVsa29tLmNvLmtlIiwicG9zdGFsQ29kZSI6bnVsbH0sInVzZXJDcmVkZW50aWFscyI6eyJ1c2VybmFtZSI6InNob3B0ZXN0IiwicGFzc3dvcmQiOiIkMmEkMTAkeDBCTURYazA4M05uSi9QUW1PS2J0dTNlRkdrTnpWLjlCekFYaEtuc3RwblNUSkJuZ0xERS4iLCJ1c2VyRGVzYyI6IlNob3AgVGVzdGluZyIsIm9sZFBhc3N3b3JkIjpudWxsLCJub09mRGF5c1NpbmNlTGFzdFBhc3N3b3JkQ2hhbmdlIjo0MywibGFzdExvZ2luRGF0ZSI6IjIwMTgtMTItMTMiLCJleHBpcmVzIjoxNTQ5MjgwMDAyOTY3LCJmaXJzdExvZ2luIjpmYWxzZSwidXNlck5hbWUiOiJzaG9wdGVzdCJ9LCJwaW5ObyI6IlAwNTExMjgxNzZHIiwidmF0Tm8iOm51bGwsInBvc3RhbENvZGUiOiIwMDEwMCIsIm5hdGlvbmFsSWQiOiIxMTExIiwiY2hhbm5lbE5hbWUiOiJTaG9wIFRlc3RpbmciLCJjcmVhdGVkQnkiOm51bGwsInRhbk5vIjpudWxsLCJtZnNSaWdodCI6bnVsbCwidXNlckFjdGlvbnMiOm51bGwsInVzZXJBZ2VuY3kiOm51bGwsInVzZXJMYXRpdHVkZSI6IjEuMjkyMSIsInVzZXJMb25naXR1ZGUiOiIgMzYuODIxOSIsImJsb2NrVXNlckNvdW50IjowLCJjb21tZW50cyI6bnVsbCwiY3JlYXRpb25EYXRlIjoiMjAxNy0wNS0yOCIsInN1c3BlbmRJZCI6bnVsbCwic3RhcnREYXRlIjoxMjYyMjkzMjAwMDAwLCJlbmREYXRlIjoyNTI0NTk3MjAwMDAwLCJzdXNwZW5kRGVzYyI6bnVsbCwidXNlclBhcmVudHNEVE9zIjpbXSwiYWRkQnkiOiJLQXJlYU0iLCJ1c2VyU3RhZmYiOiJmYWxzZSIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0RJU1RSSUJVVE9SIn0seyJhdXRob3JpdHkiOiJST0xFX1VTRVIifV19.DPxAMr4WUU7Zu/wtVgVEnH9Weus/CZhXGV/6uwwDcsw=");
                                    //conn.setRequestProperty("X-AUTH-TOKEN", "eyJ1c2VySWQiOiJzaG9wdGVzdCIsInVzZXJEZXNjIjoiU2hvcCBUZXN0aW5nIiwidXNlclBhcmVudElkIjoic2hvcHRlc3QiLCJ1c2VyUGFyZW50TmFtZSI6IlNob3AgVGVzdGluZyIsInVzZXJUeXBlSWQiOjEwLCJ1c2VyVHlwZSI6IlNob3AgTWFuYWdlciIsInVzZXJTdGF0dXNJZCI6MywidXNlclN0YXR1cyI6IkFjdGl2ZSIsInVzZXJab25pbmdEZXRhaWwiOnsiem9uZUlkIjoyMSwiem9uZUNvZGUiOm51bGwsInpvbmUiOiJOQUlST0JJIiwiaHViSWQiOjIxLCJodWJDb2RlIjoiIiwiaHViIjoiTkFJUk9CSSIsImFyZWFJZCI6MjEsImFyZWFDb2RlIjoiIiwiYXJlYSI6Ik5BSVJPQkkifSwidXNlckFkZHJlc3MiOnsiYWRkcmVzczEiOiJhMS81YiIsImFkZHJlc3MyIjoiIiwiYWRkcmVzczMiOiJub3QgcHJlc2VudCIsImNvbnRhY3ROdW1iZXIiOiI5ODE4MDk1OTMiLCJzZWNvbmRhcnlDb250YWN0Tm8iOiIiLCJlbWFpbElkIjoiU2hvcFRlc3RAdGVsa29tLmNvLmtlIiwicG9zdGFsQ29kZSI6bnVsbH0sInVzZXJDcmVkZW50aWFscyI6eyJ1c2VybmFtZSI6InNob3B0ZXN0IiwicGFzc3dvcmQiOiIkMmEkMTAkeDBCTURYazA4M05uSi9QUW1PS2J0dTNlRkdrTnpWLjlCekFYaEtuc3RwblNUSkJuZ0xERS4iLCJ1c2VyRGVzYyI6IlNob3AgVGVzdGluZyIsIm9sZFBhc3N3b3JkIjpudWxsLCJub09mRGF5c1NpbmNlTGFzdFBhc3N3b3JkQ2hhbmdlIjoyLCJsYXN0TG9naW5EYXRlIjoiMjAxOC0xMi0xMyIsImV4cGlyZXMiOjE1NTA5OTgwNjQ3MTMsImZpcnN0TG9naW4iOmZhbHNlLCJ1c2VyTmFtZSI6InNob3B0ZXN0In0sInBpbk5vIjoiUDA1MTEyODE3NkciLCJ2YXRObyI6bnVsbCwicG9zdGFsQ29kZSI6IjAwMTAwIiwibmF0aW9uYWxJZCI6IjExMTEiLCJjaGFubmVsTmFtZSI6IlNob3AgVGVzdGluZyIsImNyZWF0ZWRCeSI6bnVsbCwidGFuTm8iOm51bGwsIm1mc1JpZ2h0IjpudWxsLCJ1c2VyQWN0aW9ucyI6bnVsbCwidXNlckFnZW5jeSI6bnVsbCwidXNlckxhdGl0dWRlIjoiMS4yOTIxIiwidXNlckxvbmdpdHVkZSI6IiAzNi44MjE5IiwiYmxvY2tVc2VyQ291bnQiOjAsImNvbW1lbnRzIjpudWxsLCJjcmVhdGlvbkRhdGUiOiIyMDE3LTA1LTI4Iiwic3VzcGVuZElkIjpudWxsLCJzdGFydERhdGUiOjEyNjIyOTMyMDAwMDAsImVuZERhdGUiOjI1MjQ1OTcyMDAwMDAsInN1c3BlbmREZXNjIjpudWxsLCJ1c2VyUGFyZW50c0RUT3MiOltdLCJhZGRCeSI6IktBcmVhTSIsInVzZXJTdGFmZiI6ImZhbHNlIiwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfRElTVFJJQlVUT1IifSx7ImF1dGhvcml0eSI6IlJPTEVfVVNFUiJ9XX0=.AGhrgzNzAMKVfYJOvGHCtl/z1HvkK/FqOicgKeoJCg0=");
                                    //conn.setRequestProperty("X-AUTH-TOKEN", "eyJ1c2VySWQiOiJzaG9wdGVzdCIsInVzZXJEZXNjIjoiU2hvcCBUZXN0aW5nIiwidXNlclBhcmVudElkIjoic2hvcHRlc3QiLCJ1c2VyUGFyZW50TmFtZSI6IlNob3AgVGVzdGluZyIsInVzZXJUeXBlSWQiOjEwLCJ1c2VyVHlwZSI6IlNob3AgTWFuYWdlciIsInVzZXJTdGF0dXNJZCI6MywidXNlclN0YXR1cyI6IkFjdGl2ZSIsInVzZXJab25pbmdEZXRhaWwiOnsiem9uZUlkIjoyMSwiem9uZUNvZGUiOm51bGwsInpvbmUiOiJOQUlST0JJIiwiaHViSWQiOjIxLCJodWJDb2RlIjoiIiwiaHViIjoiTkFJUk9CSSIsImFyZWFJZCI6MjEsImFyZWFDb2RlIjoiIiwiYXJlYSI6Ik5BSVJPQkkifSwidXNlckFkZHJlc3MiOnsiYWRkcmVzczEiOiJhMS81YiIsImFkZHJlc3MyIjoiIiwiYWRkcmVzczMiOiJub3QgcHJlc2VudCIsImNvbnRhY3ROdW1iZXIiOiI5ODE4MDk1OTMiLCJzZWNvbmRhcnlDb250YWN0Tm8iOiIiLCJlbWFpbElkIjoiU2hvcFRlc3RAdGVsa29tLmNvLmtlIiwicG9zdGFsQ29kZSI6bnVsbH0sInVzZXJDcmVkZW50aWFscyI6eyJ1c2VybmFtZSI6InNob3B0ZXN0IiwicGFzc3dvcmQiOiIkMmEkMTAkeDBCTURYazA4M05uSi9QUW1PS2J0dTNlRkdrTnpWLjlCekFYaEtuc3RwblNUSkJuZ0xERS4iLCJ1c2VyRGVzYyI6IlNob3AgVGVzdGluZyIsIm9sZFBhc3N3b3JkIjpudWxsLCJub09mRGF5c1NpbmNlTGFzdFBhc3N3b3JkQ2hhbmdlIjoyLCJsYXN0TG9naW5EYXRlIjoiMjAxOC0xMi0xMyIsImV4cGlyZXMiOjE1NTEwMTAzMTEyODQsImZpcnN0TG9naW4iOmZhbHNlLCJ1c2VyTmFtZSI6InNob3B0ZXN0In0sInBpbk5vIjoiUDA1MTEyODE3NkciLCJ2YXRObyI6bnVsbCwicG9zdGFsQ29kZSI6IjAwMTAwIiwibmF0aW9uYWxJZCI6IjExMTEiLCJjaGFubmVsTmFtZSI6IlNob3AgVGVzdGluZyIsImNyZWF0ZWRCeSI6bnVsbCwidGFuTm8iOm51bGwsIm1mc1JpZ2h0IjpudWxsLCJ1c2VyQWN0aW9ucyI6bnVsbCwidXNlckFnZW5jeSI6bnVsbCwidXNlckxhdGl0dWRlIjoiMS4yOTIxIiwidXNlckxvbmdpdHVkZSI6IiAzNi44MjE5IiwiYmxvY2tVc2VyQ291bnQiOjAsImNvbW1lbnRzIjpudWxsLCJjcmVhdGlvbkRhdGUiOiIyMDE3LTA1LTI4Iiwic3VzcGVuZElkIjpudWxsLCJzdGFydERhdGUiOjEyNjIyOTMyMDAwMDAsImVuZERhdGUiOjI1MjQ1OTcyMDAwMDAsInN1c3BlbmREZXNjIjpudWxsLCJ1c2VyUGFyZW50c0RUT3MiOltdLCJhZGRCeSI6IktBcmVhTSIsInVzZXJTdGFmZiI6ImZhbHNlIiwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfRElTVFJJQlVUT1IifSx7ImF1dGhvcml0eSI6IlJPTEVfVVNFUiJ9XX0=.X8OxhvdHwW9WCztm4g28Kpsmq94pnqCzbrAu39MVkAQ=");
                                    conn.setRequestProperty("X-AUTH-TOKEN", "eyJ1c2VySWQiOiJzaG9wdGVzdCIsInVzZXJEZXNjIjoiU2hvcCBUZXN0aW5nIiwidXNlclBhcmVudElkIjoic2hvcHRlc3QiLCJ1c2VyUGFyZW50TmFtZSI6IlNob3AgVGVzdGluZyIsInVzZXJUeXBlSWQiOjEwLCJ1c2VyVHlwZSI6IlNob3AgTWFuYWdlciIsInVzZXJTdGF0dXNJZCI6MywidXNlclN0YXR1cyI6IkFjdGl2ZSIsInVzZXJab25pbmdEZXRhaWwiOnsiem9uZUlkIjoyMSwiem9uZUNvZGUiOm51bGwsInpvbmUiOiJOQUlST0JJIiwiaHViSWQiOjIxLCJodWJDb2RlIjoiIiwiaHViIjoiTkFJUk9CSSIsImFyZWFJZCI6MjEsImFyZWFDb2RlIjoiIiwiYXJlYSI6Ik5BSVJPQkkifSwidXNlckFkZHJlc3MiOnsiYWRkcmVzczEiOiJhMS81YiIsImFkZHJlc3MyIjoiIiwiYWRkcmVzczMiOiJub3QgcHJlc2VudCIsImNvbnRhY3ROdW1iZXIiOiI5ODE4MDk1OTMiLCJzZWNvbmRhcnlDb250YWN0Tm8iOiIiLCJlbWFpbElkIjoiU2hvcFRlc3RAdGVsa29tLmNvLmtlIiwicG9zdGFsQ29kZSI6bnVsbH0sInVzZXJDcmVkZW50aWFscyI6eyJ1c2VybmFtZSI6InNob3B0ZXN0IiwicGFzc3dvcmQiOiIkMmEkMTAkeDBCTURYazA4M05uSi9QUW1PS2J0dTNlRkdrTnpWLjlCekFYaEtuc3RwblNUSkJuZ0xERS4iLCJ1c2VyRGVzYyI6IlNob3AgVGVzdGluZyIsIm9sZFBhc3N3b3JkIjpudWxsLCJub09mRGF5c1NpbmNlTGFzdFBhc3N3b3JkQ2hhbmdlIjoxLCJsYXN0TG9naW5EYXRlIjoiMjAxOS0wMi0yMiIsImV4cGlyZXMiOjE1NTIwNDg1MjcwOTgsImZpcnN0TG9naW4iOmZhbHNlLCJ1c2VyTmFtZSI6InNob3B0ZXN0In0sInBpbk5vIjoiUDA1MTEyODE3NkciLCJ2YXRObyI6bnVsbCwicG9zdGFsQ29kZSI6IjAwMTAwIiwibmF0aW9uYWxJZCI6IjExMTEiLCJjaGFubmVsTmFtZSI6IlNob3AgVGVzdGluZyIsImNyZWF0ZWRCeSI6bnVsbCwidGFuTm8iOm51bGwsIm1mc1JpZ2h0IjpudWxsLCJ1c2VyQWN0aW9ucyI6bnVsbCwidXNlckFnZW5jeSI6bnVsbCwidXNlckxhdGl0dWRlIjoiMS4yOTIxIiwidXNlckxvbmdpdHVkZSI6IiAzNi44MjE5IiwiYmxvY2tVc2VyQ291bnQiOjAsImNvbW1lbnRzIjpudWxsLCJjcmVhdGlvbkRhdGUiOiIyMDE3LTA1LTI4Iiwic3VzcGVuZElkIjpudWxsLCJzdGFydERhdGUiOjEyNjIyOTMyMDAwMDAsImVuZERhdGUiOjI1MjQ1OTcyMDAwMDAsInN1c3BlbmREZXNjIjpudWxsLCJ1c2VyUGFyZW50c0RUT3MiOltdLCJhZGRCeSI6IktBcmVhTSIsInVzZXJTdGFmZiI6ImZhbHNlIiwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfRElTVFJJQlVUT1IifSx7ImF1dGhvcml0eSI6IlJPTEVfVVNFUiJ9XX0=.HgeU7IV+OR6w7f74asQMB9IdKUlzs3wgzSXsBjR+N+E=");
                                    conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength));
                                    conn.setDoOutput(true);
                                    
                                    int respCode = conn.getResponseCode();
                                    //System.out.println("POST Response Code :: " + respCode);
                                    logger.info("POST Payment API Response Code :: " + respCode);
                                    if (respCode == HttpURLConnection.HTTP_OK) 
                                    {
                                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                                        StringBuilder sb = new StringBuilder();
                                        while ((inLine = br.readLine()) != null) 
                                        {
                                                sb.append(inLine);
                                        }
                                        in.close();
                                        //System.out.println(sb.toString());
                                        logger.info("Logging response from POS for Payment Posting in Confirmation| " + sb.toString());
                                        //IF THE RESPONSE IS NOT Successfull, log the 
                                        // print result
                                        String respValue;
                                        JSONObject postPaymentResp = new JSONObject(sb.toString());
                                        respValue = postPaymentResp.getString("response");
                                        //CHECK IF the response is success
                                        if(respValue != null)
                                        { 
                                            if("Success".equals(respValue))
                                            {
                                                //Recipt was made.
                                                //Get the following values from the response receiptNo, receiptDate, receiptAmount
                                                //and save in confirmation table
                                                
                                                receiptNo = postPaymentResp.getString("receiptNo");
                                                receiptDate = postPaymentResp.getString("receiptDate");
                                                recieptAmount = postPaymentResp.getString("receiptAmount");
                                                //Save all data of KYC and reciept no, and send sms to customer
                                                ins.insertConfirmationData(c2BPaymenConfirmationRequest.getTransType(), c2BPaymenConfirmationRequest.getTransID(), c2BPaymenConfirmationRequest
                                                .getTransTime(), c2BPaymenConfirmationRequest.getTransAmount(), c2BPaymenConfirmationRequest.getBusinessShortCode(), msisdn, c2BPaymenConfirmationRequest
                                                .getInvoiceNumber(), c2BPaymenConfirmationRequest.getOrgAccountBalance(), c2BPaymenConfirmationRequest
                                                .getThirdPartyTransID(), c2BPaymenConfirmationRequest.getMSISDN(), fname +" "+ mname + " " + lname, "successful", 
                                                "True",c2BPaymenConfirmationRequest.getThirdPartyTransID(),"Confirmation Successful", 
                                                respValue, receiptNo, receiptDate, recieptAmount, mpesaRefId);                                    
                                                this.logger.info(logHeader + "Confirmation Successful");
                                                //SMS DATA “Dear customer, we are in receipt of Ksh XXXXXX for account number 077XXXXXXX. Thank you for Moving with us”    
                                               notify.sendSMS(c2BPaymenConfirmationRequest.getMSISDN(), "Dear customer, we are in receipt of Ksh " 
                                                       + c2BPaymenConfirmationRequest.getTransAmount() + " for account number "
                                                       + c2BPaymenConfirmationRequest.getBillRefNumber() + ". Thank you for Moving with us");
                                                respTOBroker = "Success";
                                            }
                                            else
                                            {
                                                //Send Email 
                                                HashMap<String, String> receipients = new HashMap();
                                                receipients.put("to", this.props.getMail_to_sales() + ", " + this.props.getMail_to_marketing() + "," + this.props.getMail_to_finance());
                                                receipients.put("cc", this.props.getMail_to_invas() + ", " + this.props.getMail_to_om());
                                                this.sm = new MailMapper(receipients, "Following postpaid confirmation from postpaid paybill 766600 failed because "
                                                        + "POS / GPTO returned an error: "+ respValue +" <br/> Customer Number: " + tklmsisdn 
                                                        + "<br/> Payment amount: " + transamount + "<br/>", this.props);

                                                this.mailer = new Thread(this.sm);
                                                this.mailer.start();
                                                
                                                ins.insertConfirmationData(c2BPaymenConfirmationRequest.getTransType(), c2BPaymenConfirmationRequest.getTransID(), c2BPaymenConfirmationRequest
                                                .getTransTime(), c2BPaymenConfirmationRequest.getTransAmount(), c2BPaymenConfirmationRequest.getBusinessShortCode(), msisdn, c2BPaymenConfirmationRequest
                                                .getInvoiceNumber(), c2BPaymenConfirmationRequest.getOrgAccountBalance(), c2BPaymenConfirmationRequest
                                                .getThirdPartyTransID(), c2BPaymenConfirmationRequest.getMSISDN(), fname +" "+ mname + " " + lname, "Failed", 
                                                "True",c2BPaymenConfirmationRequest.getThirdPartyTransID(),"Error occured during payment posting", 
                                                respValue, receiptNo, receiptDate, recieptAmount, mpesaRefId);
                                                
                                                notify.sendSMS(c2BPaymenConfirmationRequest.getMSISDN(), "The mobile number entered is a prepaid number and is not allowed to use this service");
                                                logger.info(logHeader + " Error occured during payment");
                                                respTOBroker = "Error occured during payment";
                                            }
                                        }
                                        else //
                                        {
                                                //Send Email 
                                                HashMap<String, String> receipients = new HashMap();
                                                receipients.put("to", this.props.getMail_to_sales() + ", " + this.props.getMail_to_marketing() + "," + this.props.getMail_to_finance());
                                                receipients.put("cc", this.props.getMail_to_invas() + ", " + this.props.getMail_to_om());
                                                this.sm = new MailMapper(receipients, "Following postpaid confirmation from postpaid paybill 766600 failed because "
                                                        + "POS / GPTO returned an error: "+ respValue +" <br/> Customer Number: " + tklmsisdn 
                                                        + "<br/> Payment amount: " + transamount + "<br/>", this.props);

                                                this.mailer = new Thread(this.sm);
                                                this.mailer.start();
                                                
                                                ins.insertConfirmationData(c2BPaymenConfirmationRequest.getTransType(), c2BPaymenConfirmationRequest.getTransID(), c2BPaymenConfirmationRequest
                                                .getTransTime(), c2BPaymenConfirmationRequest.getTransAmount(), c2BPaymenConfirmationRequest.getBusinessShortCode(), msisdn, c2BPaymenConfirmationRequest
                                                .getInvoiceNumber(), c2BPaymenConfirmationRequest.getOrgAccountBalance(), c2BPaymenConfirmationRequest
                                                .getThirdPartyTransID(), c2BPaymenConfirmationRequest.getMSISDN(), fname +" "+ mname + " " + lname, "Failed", 
                                                "True",c2BPaymenConfirmationRequest.getThirdPartyTransID(),"Error fetching records", 
                                                respValue, receiptNo, receiptDate, recieptAmount, mpesaRefId);
                                                
                                                notify.sendSMS(c2BPaymenConfirmationRequest.getMSISDN(), "We are unable to process this service right now. Please try again later");
                                                logger.info(logHeader + " Error fetching records");
                                            respTOBroker = "Error fetching records";
                                        }
                                    }
                                    else 
                                    {
                                        //Send Email, Send Sms
                                        //Send Email 
                                        HashMap<String, String> receipients = new HashMap();
                                        receipients.put("to", this.props.getMail_to_sales() + ", " + this.props.getMail_to_marketing() + "," + this.props.getMail_to_finance());
                                        receipients.put("cc", this.props.getMail_to_invas() + ", " + this.props.getMail_to_om());
                                        this.sm = new MailMapper(receipients, "Following postpaid confirmation from postpaid paybill 766600 failed because "
                                                + "POS / GPTO returned an error: "+ "Error fetching records" +" <br/> Customer Number: " + tklmsisdn 
                                                + "<br/> Payment amount: " + transamount + "<br/>", this.props);

                                        this.mailer = new Thread(this.sm);
                                        this.mailer.start();
                                        ins.insertConfirmationData(c2BPaymenConfirmationRequest.getTransType(), c2BPaymenConfirmationRequest.getTransID(), c2BPaymenConfirmationRequest
                                        .getTransTime(), c2BPaymenConfirmationRequest.getTransAmount(), c2BPaymenConfirmationRequest.getBusinessShortCode(), msisdn, c2BPaymenConfirmationRequest
                                        .getInvoiceNumber(), c2BPaymenConfirmationRequest.getOrgAccountBalance(), c2BPaymenConfirmationRequest
                                        .getThirdPartyTransID(), c2BPaymenConfirmationRequest.getMSISDN(), fname +" "+ mname + " " + lname, "Failed", 
                                        "True",c2BPaymenConfirmationRequest.getThirdPartyTransID(),"Error fetching records", 
                                        "", receiptNo, receiptDate, recieptAmount, mpesaRefId);
                                        
                                        notify.sendSMS(c2BPaymenConfirmationRequest.getMSISDN(), "We are unable to process this service right now. Please try again later");
                                            
                                        //System.out.println("POST request not worked");
                                        logger.info(logHeader + " POST request for post payment did not worked");
                                        respTOBroker = "Error fetching records";
                                    }
                               }
                               else // response = "Error fetching records" //number not postpaid
                               {
                                   //Send email the error found from POS for POST PAYMENT API
                                   //Send Email 
                                    HashMap<String, String> receipients = new HashMap();
                                    receipients.put("to", this.props.getMail_to_sales() + ", " + this.props.getMail_to_marketing() + "," + this.props.getMail_to_finance());
                                    receipients.put("cc", this.props.getMail_to_invas() + ", " + this.props.getMail_to_om());
                                    this.sm = new MailMapper(receipients, "Following postpaid confirmation from postpaid paybill 766600 failed because "
                                            + "POS / GPTO returned an error: "+ "Error fetching records" +" <br/> Customer Number: " + tklmsisdn 
                                            + "<br/> Payment amount: " + transamount + "<br/>", this.props);

                                    this.mailer = new Thread(this.sm);
                                    this.mailer.start();
                                    notify.sendSMS(c2BPaymenConfirmationRequest.getMSISDN(), "We are unable to process this service right now. Please try again later");
                                                logger.info(logHeader + " Error fetching records");
                                    this.logger.info(logHeader + " Error in Confirmation! Post Payment API Returned an error: " + responseValue);
                                    respTOBroker = "Error fetching records";
                               }
                           }
                           else
                           {
                               //Send email Notification with the error message recieved 
                               //Send Email 
                                HashMap<String, String> receipients = new HashMap();
                                receipients.put("to", this.props.getMail_to_sales() + ", " + this.props.getMail_to_marketing() + "," + this.props.getMail_to_finance());
                                receipients.put("cc", this.props.getMail_to_invas() + ", " + this.props.getMail_to_om());
                                this.sm = new MailMapper(receipients, "Following postpaid confirmation from postpaid paybill 766600 failed because "
                                        + "POS / GPTO returned an error: "+ "Error fetching records" +" <br/> Customer Number: " + tklmsisdn 
                                        + "<br/> Payment amount: " + transamount + "<br/>", this.props);

                                this.mailer = new Thread(this.sm);
                                this.mailer.start();
                               respTOBroker = "Error fetching records";
                               this.logger.info(logHeader + " Error Validation! CRM / GPTO Problem");
                           }
                    }
                    else
                    {
                        //Send Email 
                        HashMap<String, String> receipients = new HashMap();
                        receipients.put("to", this.props.getMail_to_sales() + ", " + this.props.getMail_to_marketing() + "," + this.props.getMail_to_finance());
                        receipients.put("cc", this.props.getMail_to_invas() + ", " + this.props.getMail_to_om());
                        this.sm = new MailMapper(receipients, "Following postpaid confirmation from postpaid paybill 766600 failed because "
                                + "POS / GPTO returned an error: "+ "Error fetching records" +" <br/> Customer Number: " + tklmsisdn 
                                + "<br/> Payment amount: " + transamount + "<br/>", this.props);

                        this.mailer = new Thread(this.sm);
                        this.mailer.start();
                        //System.out.println("GET request not worked");
                        respTOBroker = "Error fetching records";
                        this.logger.info(logHeader + " GET request did not work");
                    }
                } 
                catch (MalformedURLException ex) 
                {
                    logger.error(ex);
                    //System.out.println(ex);
                }  
                catch (ProtocolException | JSONException  ex) 
                {
                    logger.error(ex);
                    //System.out.println(ex);
                }
                catch (IOException ex) 
                {
                   logger.error(ex);
                   //System.out.println(ex);
                }
        //throw new UnsupportedOperationException("Not implemented yet.");
        this.logger.info("Comfirmation received and processed for: " + c2BPaymenConfirmationRequest.getMSISDN() + " transaction id: " + c2BPaymenConfirmationRequest.getTransID());
        return respTOBroker;
    }
    
    public String generateTransactionId() {
        Date date = new Date();
        long time = date.getTime();
        String trans_id = time + "" + (int) (Math.random() * 1.0E7D);
        return trans_id;
    }

    private void disableSslVerification() 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try
        {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts;
                trustAllCerts = new TrustManager[] {new X509TrustManager() {
                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    @Override
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }
                    @Override
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }  
                }
                };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() 
            {
                public boolean verify(String hostname, SSLSession session) 
                {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } 
        catch (NoSuchAlgorithmException | KeyManagementException e) 
        {
            //e.printStackTrace();
            this.logger.error(e);
        }
     }
}
