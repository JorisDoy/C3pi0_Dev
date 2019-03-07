/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ussd.statement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
/**
 *
 * @author jdmwamburi
 */
public class USSDSessionManager {
    static Logger log = Logger.getLogger(USSDSessionManager.class.getName());
    public synchronized String CreateSession(String msisdn, String session_stamp) {         
        try {
            Date sdate = new SimpleDateFormat("yy/MM/dd HH:mm:ss").parse(session_stamp);
            DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
            String session =  dateFormat.format(sdate);
            return msisdn+session_stamp;
        } 
        catch (ParseException ex) {
            log.error(ex);
         return null;
         }  
    }
}
