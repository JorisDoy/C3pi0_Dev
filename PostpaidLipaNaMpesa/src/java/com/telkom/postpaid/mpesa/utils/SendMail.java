/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telkom.postpaid.mpesa.utils;

import java.util.HashMap;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author jdmwamburi
 */
public class SendMail {
    
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SendMail.class.getName());
    private Props props;
    
    public SendMail(Props prop){
        props = prop;
    }
    
    public void send(HashMap<String, String> receipients, String content) {
        // TODO code application logic here
        String mail_host = props.getMail_host();
        String mail_from = props.getEmail_sender();
        
        //String email_body = "\n";
        //String to = "eokanini@telkom.co.ke, rkmwangi@telkom.co.ke";
        
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", mail_host);
        
        Session session = Session.getDefaultInstance(properties);
        
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mail_from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receipients.get("to")));
            if(receipients.containsKey("cc")){
                message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(receipients.get("cc")));
            }
            if(receipients.containsKey("bcc")){
                message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(receipients.get("bcc")));
            }
	    
            message.setSubject("Telkom MPESA Pay bill");
            
            BodyPart message_body_part = new MimeBodyPart();
            //message_body_part.setText("Hi");
            message_body_part.setContent(content, "text/html");
            
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(message_body_part);
            
            message.setContent(multipart);
            Transport.send(message);
        } catch(MessagingException ex){
            logger.fatal(ex.getMessage());
        }
    }
    
    
    
    public static void sendMailWithAttachment(String text, String path){
        
    }
    /*Select count of failed validations
    SELECT * FROM validation WHERE transact_status= 'failed' 
    and transact_time LIKE '%20181004%' LIMIT 10;
    */
    /*
    SELECT COUNT OF FAILED VALIDATIONS OF PREVIOUS DAY
    SELECT count(*) FROM validation 
    WHERE transact_status= 'failed' and transact_time LIKE '%20181003%';
*/
    /*
    SELECT count(*) FROM validation WHERE 
   transact_status= 'successful' and message='Successful' 
   and transact_time LIKE '%20181003%';
*/
    /*
    Succesful count
     SELECT SUM(CAST(validation.transamount as double precision)) 
        AS TotalSuccessfulcount FROM validation WHERE transact_time LIKE '%20181003%';
    */
}
