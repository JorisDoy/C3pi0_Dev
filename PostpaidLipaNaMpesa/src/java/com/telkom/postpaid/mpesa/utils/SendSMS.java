/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telkom.postpaid.mpesa.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author jdmwamburi
 */
public class SendSMS {
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SendSMS.class.getName());
    private Props props = new Props();
    
    public SendSMS(Props props) {
        this.props = props;
    }
    
    public void sendSMS(String msisdn, String message) {
        try {
            String url = "http://" + this.props.getKannel_ip() + ":" + this.props.getKannel_port() + "/cgi-bin/sendsms?username=" + this.props.getKannel_user() + "&password=" + this.props.getKannel_password() + "&to=" + msisdn + "&from=" + this.props.getShortcode() + "&text=" + URLEncoder.encode(message, "UTF-8") + "";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            this.logger.info("SMS Sent to: " + msisdn + "|" + message);
            ValidateInput vi = new ValidateInput();
            if (!vi.isValidInput("" + responseCode, "20[0-9]")) {
                this.logger.error("Kannel responded with the following result code: " + responseCode + " send sms not successful");
            }
        } catch (MalformedURLException ex) {
            this.logger.error("Could not send SMS, error is: " + ex.getMessage());
        } catch (ProtocolException ex) {
            this.logger.error("Could not send SMS, error is: " + ex.getMessage());
        } catch (IOException ex) {
            this.logger.error("Could not send SMS, error is: " + ex.getMessage());
        }
    }
}
