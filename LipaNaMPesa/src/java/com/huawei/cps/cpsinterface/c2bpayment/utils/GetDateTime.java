/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 *
 * @author ramson
 */
public class GetDateTime {
    public Timestamp ts;
    
    public GetDateTime(){
        //java.util.Date date = new java.util.Date();
        long time = System.currentTimeMillis();//date.getTime();
        Timestamp ts = new Timestamp(time);
        this.ts = ts;
    }
    
    public Timestamp getTimeNow(){
        return ts;
    }
    
    public String getTimeStamp(){
        return ts.toString().replaceAll(" ", "_");
    }
    
    public String getTimeWithFormat(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        //LocalDateTime now = LocalDateTime.now();
        //return dateFormat.format(now);
        return dateFormat.format(ts.getTime());
    }
}
