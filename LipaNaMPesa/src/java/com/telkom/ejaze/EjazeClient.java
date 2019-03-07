/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telkom.ejaze;

//import com.sun.org.apache.bcel.internal.generic.Select;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import javax.sql.DataSource;

/**
 *
 * @author gaddafi
 */


public class EjazeClient {
    
    private EjazePojo ep;
    
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EjazeClient.class.getName());
    private final String uri;
    //public DataSource datasource;
        
    public EjazeClient() {
        uri = "http://192.168.27.64:9898/pretups/C2SReceiver?REQUEST_GATEWAY_CODE=EXTGW&REQUEST_GATEWAY_TYPE=EXTGW&LOGIN=pretups2&PASSWORD=pretups123&SOURCE_TYPE=EXTGW&SERVICE_PORT=190";
    }    
    
    public EjazeClient(DataSource datasource){
        //ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        //this.ep = (EjazePojo) context.getBean("ejazeP");
        //this.datasource = datasource;
        
        uri = "http://192.168.27.64:9898/pretups/C2SReceiver?REQUEST_GATEWAY_CODE=EXTGW&REQUEST_GATEWAY_TYPE=EXTGW&LOGIN=pretups2&PASSWORD=pretups123&SOURCE_TYPE=EXTGW&SERVICE_PORT=190";
    }

    
    /** sends the request to the specified URL
     * 
     * @param uri
     * @param soapAction The soap action for web services
     * @param requestBody The actual requestBody message
     * @return The response from our request
     */
    public String sendHttpRequest(String uri,String soapAction, String requestBody) {
        HttpURLConnection urlConnection;
        URL url;
        String responseLine, response = "";
        
        try {
            url = new URL(uri);            
            
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(30000);
            urlConnection.setReadTimeout(30000);            
            urlConnection.setRequestMethod("POST");            
            urlConnection.setRequestProperty("SOAPAction", "\"" + soapAction + "\"");
            urlConnection.setRequestProperty("Content-Type", "text/xml; charset=utf-8; action=\"" + soapAction + "\"");
            urlConnection.setRequestProperty("Accept", "application/soap+xml, application/dime, multipart/related, text/*");             
            
            logger.info(LocalDateTime.now() + "|sendHttpRequest|Sending request to: " + uri + "|" + requestBody);
            try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(urlConnection.getOutputStream())) {                
                outputStreamWriter.write(requestBody);                
                outputStreamWriter.flush();
            }
            
            int statusCode = urlConnection.getResponseCode();
            //System.out.println("Status code is: "+statusCode);
            //System.out.println("Status message is: "+httpsUrlConnection.getResponseMessage());
            
            if(statusCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                    while((responseLine = bufferedReader.readLine()) != null) {
                        response += responseLine;
                    }
                }
            }
            else {
                logger.info(LocalDateTime.now() + "|sendHttpRequest|" + statusCode + "|" + urlConnection.getResponseMessage());
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()))) {
                    while((responseLine = bufferedReader.readLine()) != null) {
                        response += responseLine;
                    }
                }       
            }
        }
        catch(Exception e) {
            
            logger.fatal(LocalDateTime.now() + "|sendHttpRequest|Error sending request to: " + uri + "|" + e);
            //e.printStackTrace();
            
            response = "Error";
        }
               
        return response;
    }

    public Recharge request(String pretups_url, String cnum, String amount, String mpesaRefId) {
            String e_pin ="1234";
            String payload = payloadBuilder(cnum, amount, e_pin, mpesaRefId);
            logger.info("String Payload - " + payload);
            
            String response = sendHttpRequest(uri, "", payload);
            
            logger.info("Payload Response - "+response);
            EjazeRechargeResponseHandler erh = new EjazeRechargeResponseHandler();     
            Recharge isTopUp = erh.responseResultStatus(response);

        return isTopUp;
    }

    protected String payloadBuilder(String customer_msisdn, String amount, String e_pin, String mpesaReference) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\"?>");
        sb.append("<!DOCTYPE COMMAND PUBLIC \"-//Ocam//DTD XML Command 1.0//EN\" \"xml/command.dtd\">");
        sb.append("<COMMAND>");
        sb.append("<TYPE>EXRCTRFREQ</TYPE>");
        sb.append("<DATE>09/02/2018</DATE>");
        sb.append("<EXTNWCODE>TK</EXTNWCODE>");
        sb.append("<MSISDN>777777711</MSISDN>");
        sb.append("<PIN>2697</PIN>");
        //sb.append("<PIN>").append(e_pin).append("</PIN>");
        sb.append("<LOGINID>tklmpesa</LOGINID>");
        sb.append("<PASSWORD>tklmpesA101</PASSWORD>");
        sb.append("<EXTCODE></EXTCODE>");
//        sb.append("<EXTREFNUM>"+refId+"</EXTREFNUM>");
        sb.append("<EXTREFNUM>").append(mpesaReference).append("</EXTREFNUM>");
        sb.append("<MSISDN2>").append(customer_msisdn).append("</MSISDN2>");
        sb.append("<AMOUNT>").append(amount).append("</AMOUNT>");
        sb.append("<LANGUAGE1>0</LANGUAGE1>");
        sb.append("<LANGUAGE2>0</LANGUAGE2>");
        sb.append("<SELECTOR>1</SELECTOR>");
        sb.append("</COMMAND>");

        return sb.toString();
    }
    
//    public static void main(String[] args){
//        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//        EjazePojo obj = (EjazePojo) context.getBean("ejazeP");
//        System.out.println(obj.getExt_code());
//        EjazeClient ec = new EjazeClient();
//        Recharge is_reacharge = ec.request("http://192.168.27.64:9898/pretups/C2SReceiver?REQUEST_GATEWAY_CODE=EXTGW&REQUEST_GATEWAY_TYPE=EXTGW&LOGIN=pretups2&PASSWORD=pretups123&SOURCE_TYPE=EXTGW&SERVICE_PORT=190", "0770168633", "10");
//        
//        if(is_reacharge.isIsSuccessful()){
//            System.out.println("Reacharge was successful");
//        } else{
//            System.out.println("Reacharge was not successful");
//        }
//    }
}
