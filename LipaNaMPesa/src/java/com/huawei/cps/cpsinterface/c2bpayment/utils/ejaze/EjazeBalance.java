/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.utils.ejaze;

import com.huawei.cps.cpsinterface.c2bpayment.utils.GetDateTime;
import com.huawei.cps.cpsinterface.c2bpayment.utils.ejaze.ResponsePojos.Balance;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author gaddafi
 */
public class EjazeBalance {
    
    private EjazePojo obj;
    
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EjazeBalance.class.getName());
    
    public EjazeBalance(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        obj = (EjazePojo) context.getBean("ejazeP");
    }
    
    protected String payloadBuilder() {
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
        sb.append("<EXTREFNUM>217973452346</EXTREFNUM><DATA>");
        sb.append("<MSISDN>777777711</MSISDN><USERLOGINID>tklmpesa</USERLOGINID><USEREXTCODE></USEREXTCODE></DATA></COMMAND>");

        return sb.toString();
    }
    
    public Balance request(String pretups_url) {
        //boolean isTopUp = false;
        EjazeBalanceResponceHandler ebrh = new EjazeBalanceResponceHandler();
        Balance bal = null;
        try {
            HttpParams httpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
            // 50,000 e-mail sent to product persons
            HttpClient client = new DefaultHttpClient(httpParams);
            HttpPost post = new HttpPost(pretups_url);
            post.addHeader("Content-Type", "text/xml");
            GetDateTime gdt = new GetDateTime();
            String date = gdt.getTimeWithFormat();
            String payload = payloadBuilder();
            HttpEntity entity = new ByteArrayEntity(payload.toString().getBytes("UTF-8"));
            post.setEntity(entity);
            
            HttpResponse response = client.execute(post);

            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            StringBuffer rlt = new StringBuffer();
            while ((line = br.readLine()) != null) {
                rlt.append(line);
            }
            
            System.out.println(rlt.toString());
            
            bal = ebrh.responseResultStatus(rlt.toString());
            
            //EjazeResponseHandler erh = new EjazeResponseHandler();
            
            //isTopUp = erh.responseResultStatus(rlt.toString());
            
        } catch (UnsupportedEncodingException ex) {
            logger.fatal(ex.getMessage());
        } catch (IOException ex) {
            logger.fatal(ex.getMessage());
        }

        return bal;
    }
    
//    public static void main(String[] args){
//        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//        EjazePojo obj = (EjazePojo) context.getBean("ejazeP");
//        System.out.println(obj.getExt_code());
//        EjazeBalance ec = new EjazeBalance();
//        Balance is_reacharge = ec.request("http://192.168.27.64:9898/pretups/C2SReceiver?REQUEST_GATEWAY_CODE=XMLGW&REQUEST_GATEWAY_TYPE=XMLGW&LOGIN=pretups&PASSWORD=1357&SOURCE_TYPE=XMLGW&SERVICE_PORT=194");
//        
//        if(is_reacharge.isIsSuccessful()){
//            System.out.println("Reacharge was successful");
//        } else{
//            System.out.println("Reacharge was not successful");
//        }
//    }
    
}
