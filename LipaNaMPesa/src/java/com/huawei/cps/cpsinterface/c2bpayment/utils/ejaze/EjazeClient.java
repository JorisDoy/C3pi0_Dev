/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.utils.ejaze;

import com.huawei.cps.cpsinterface.c2bpayment.utils.Configs;
import com.huawei.cps.cpsinterface.c2bpayment.utils.GetDateTime;
import com.huawei.cps.cpsinterface.c2bpayment.utils.db.Selects;
import com.huawei.cps.cpsinterface.c2bpayment.utils.ejaze.ResponsePojos.Recharge;
//import com.sun.org.apache.bcel.internal.generic.Select;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/**
 *
 * @author gaddafi
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EjazeClient {
    
    private EjazePojo ep;
    
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EjazeClient.class.getName());
    
    public DataSource datasource;
    
    public EjazeClient(DataSource datasource){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        this.ep = (EjazePojo) context.getBean("ejazeP");
        this.datasource = datasource;
    }

    public Recharge request(String pretups_url, String cnum, String amount) {
        Recharge isTopUp = new Recharge();
        Selects sel = new Selects();
        // Get E-jaze Pin
        String e_pin = sel.getKeyValue(datasource, Configs.EJAZE_PIN_KEYNAME);
        try {
            HttpParams httpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
            // 50,000 e-mail sent to product persons
            HttpClient client = new DefaultHttpClient(httpParams);
            HttpPost post = new HttpPost(pretups_url);
            post.addHeader("Content-Type", "text/xml");
            GetDateTime gdt = new GetDateTime();
            String date = gdt.getTimeWithFormat();
            String payload = payloadBuilder(cnum, amount, e_pin);
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
            
            EjazeRechargeResponseHandler erh = new EjazeRechargeResponseHandler();
            
            isTopUp = erh.responseResultStatus(rlt.toString());
            
        } catch (UnsupportedEncodingException ex) {
            logger.fatal(ex.getMessage());
        } catch (IOException ex) {
            logger.fatal(ex.getMessage());
        }

        return isTopUp;
    }

    protected String payloadBuilder(String customer_msisdn, String amount, String e_pin) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\"?>");
        sb.append("<!DOCTYPE COMMAND PUBLIC \"-//Ocam//DTD XML Command 1.0//EN\" \"xml/command.dtd\">");
        sb.append("<COMMAND>");
        sb.append("<TYPE>EXRCTRFREQ</TYPE>");
        sb.append("<DATE>09/02/2018</DATE>");
        sb.append("<EXTNWCODE>TK</EXTNWCODE>");
        sb.append("<MSISDN>777777711</MSISDN>");
        //sb.append("<PIN>2031</PIN>");
        sb.append("<PIN>").append(e_pin).append("</PIN>");
        sb.append("<LOGINID>").append(ep.getLogin_id()).append("</LOGINID>");
        sb.append("<PASSWORD>tklmpesA101</PASSWORD>");
        sb.append("<EXTCODE></EXTCODE>");
        sb.append("<EXTREFNUM>217973452346</EXTREFNUM>");
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
