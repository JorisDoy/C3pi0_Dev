/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telkom.ejaze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

/**
 *
 * @author gaddafi
 */
public class EjazeBalance {
    
    private EjazePojo obj;       
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EjazeBalance.class.getName());
    private final String uri;
    
    public EjazeBalance(){
        /*ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        obj = (EjazePojo) context.getBean("ejazeP");*/
        //name="pretups_url" value="http://192.168.27.64:9898/pretups/C2SReceiver"
        
        uri = "http://192.168.27.64:9898/pretups/C2SReceiver?REQUEST_GATEWAY_CODE=EXTGW&REQUEST_GATEWAY_TYPE=EXTGW&LOGIN=pretups2&PASSWORD=pretups123&SOURCE_TYPE=EXTGW&SERVICE_PORT=190";
    }
    
    protected String payloadBuilder() {
        String refId = LocalDateTime.now().toString();
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\"?>");
        sb.append("<!DOCTYPE COMMAND PUBLIC \"-//Ocam//DTD XML Command 1.0//EN\" \"xml/command.dtd\">");
        sb.append("<COMMAND>");
        sb.append("<TYPE>OTHERBALANCE</TYPE>");
        sb.append("<DATE></DATE>");
        sb.append("<EXTNWCODE>TK</EXTNWCODE>");
        sb.append("<CATCODE>CCE</CATCODE>");
        sb.append("<EMPCODE></EMPCODE>");
        sb.append("<LOGINID>balance</LOGINID>");
        sb.append("<PASSWORD>baLancE1357</PASSWORD>");
        sb.append("<EXTREFNUM>").append(refId).append("</EXTREFNUM><DATA>");
        sb.append("<MSISDN>777777711</MSISDN><USERLOGINID>tklmpesa</USERLOGINID><USEREXTCODE></USEREXTCODE></DATA></COMMAND>");

        return sb.toString();
    }
    
    public Balance request(String pretups_url) {
        //boolean isTopUp = false;
        EjazeBalanceResponseHandler ebrh = new EjazeBalanceResponseHandler();
        Balance bal;

        //generate payload and post to Ejaze
        String payload = payloadBuilder();
        logger.info("Request Payload - " + payload); 
        String response = sendHttpRequest(uri, "", payload); 
        logger.info("Response Payload - " + response);
        
        bal = ebrh.responseResultStatus(response);

        return bal;
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
}
