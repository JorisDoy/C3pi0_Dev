/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ke.telkom.paybill.paybillreports.Utils;

import java.io.File;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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
 * @author gaddafi
 */
public class SendMail {
    
    public Props props;
    
    public SendMail(Props props){
        this.props = props;
    }
    
    public void send(String all_validation_req, String failed_validations, String successful_validations, String total_confirmation_req, String total_amount, String success_count, String failed_count, String total_failed, String total_success, String total_amount_failed_validation, String file_name){
        String mail_host = props.getMail_host();
        String mail_from = "tklmpesapaybill@telkom.co.ke";
        
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", mail_host);
        
        String email_body = buildMailContentValidation(all_validation_req, failed_validations, successful_validations, total_amount_failed_validation) + buildMailContentConfirmation(total_confirmation_req, total_amount, success_count, failed_count, total_failed, total_success);
        String to = props.getReport_to(), cc = props.getReport_cc(), bcc = props.getReport_bcc();
        
        Session session = Session.getDefaultInstance(properties);
        
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mail_from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            if(!cc.equals("") || cc != null){
                message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
            }
	    if(!bcc.equals("") || bcc != null){
                message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc));
            }            
            message.setSubject("Paybill Daily Report");            
            BodyPart message_body_part = new MimeBodyPart();
            //message_body_part.setText("Hi");
            message_body_part.setContent(email_body, "text/html");
            
            MimeBodyPart message_body_part2 = new MimeBodyPart();
            DataSource source = new FileDataSource(file_name);
            message_body_part2.setDataHandler(new DataHandler(source));
            message_body_part2.setFileName(new File(file_name).getName());
            
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(message_body_part);
            multipart.addBodyPart(message_body_part2);
            
            message.setContent(multipart);
            Transport.send(message);
        } catch(MessagingException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public String buildMailContentValidation(String all_validation_req, String failed_validations, String successful_validations, String total_amount_failed_validation){
        StringBuilder sb = new StringBuilder();
        sb.append("Validation Report<br/>"); 
        sb.append("<table>");
        sb.append("<tr bgcolor=\"#C0C0C0\"; color=\"FFFFFF\">");
        sb.append("<th><b>Total Validations</b></th>");
        sb.append("<th><b>Failed Validations</b></th>");
        sb.append("<th><b>Failed Validation amount</b></th>");
        sb.append("<th><b>Successful Validations</b></th>");
        sb.append("</tr>");
        sb.append("<tr>");
        sb.append("<td>");
        sb.append(all_validation_req);
        sb.append("</td>");
        sb.append("<td>");
        sb.append(failed_validations);
        sb.append("</td>");
        sb.append("<td>");
        sb.append(total_amount_failed_validation);
        sb.append("</td>");
        sb.append("<td>");
        sb.append(successful_validations);
        sb.append("</td>");
        sb.append("</tr>");
        sb.append("</table><br/>");
        
        return sb.toString();
    }
    
    public String buildMailContentConfirmation(String total_confirmation_req, String total_amount, String success_count, String failed_count, String total_failed, String total_success){
        StringBuilder sb = new StringBuilder();
        sb.append("Confirmation Report<br/>");
        sb.append("<table>");
        sb.append("<tr bgcolor=\"#C0C0C0\"; color=\"FFFFFF\">");
        sb.append("<th><b>Total Confirmation count</b></th>");
        sb.append("<th><b>Total Revenue</b></th>");
        sb.append("<th><b>Total Successful count</b></th>");
        sb.append("<th><b>Total Successful amount</b></th>");
        sb.append("<th><b>Total Failed count</b></th>");
        sb.append("<th><b>Total Failed Amount</b></th>");
        sb.append("</tr>");
        sb.append("<tr>");
        sb.append("<td>");
        sb.append(total_confirmation_req);
        sb.append("</td>");
        sb.append("<td>");
        sb.append(total_amount);
        sb.append("</td>");
        sb.append("<td>");
        sb.append(success_count);
        sb.append("</td>");
        sb.append("</td>");
        sb.append("<td>");
        sb.append(total_success);
        sb.append("</td>");
        sb.append("<td>");
        sb.append(failed_count);
        sb.append("</td>");
        sb.append("<td>");
        sb.append(total_failed);
        sb.append("</td>");
        sb.append("</tr>");
        sb.append("</table><br/>");
        
        return sb.toString();
    }
}

