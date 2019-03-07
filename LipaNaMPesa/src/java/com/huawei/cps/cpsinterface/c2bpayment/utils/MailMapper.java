/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.utils;

import com.huawei.cps.cpsinterface.c2bpayment.utils.Mail.SendMail;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author gaddafi
 */
public class MailMapper implements Runnable {
    
    private String message;
    private HashMap<String, String> reciepients;
    private Props prop;
    
    public MailMapper(HashMap<String, String> reciepients, String message, Props prop){
        this.reciepients = reciepients;
        this.message = message;
        this.prop = prop;
    }

    @Override
    public void run() {
        SendMail sm = new SendMail(prop);
        sm.send(reciepients, message);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
