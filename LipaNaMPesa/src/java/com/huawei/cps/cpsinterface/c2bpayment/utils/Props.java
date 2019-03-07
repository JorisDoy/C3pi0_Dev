/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author gaddafi
 */
public class Props {
    private String ejaze_low_balance, customer_number_format_invalid, customer_number_postpaid, 
            customer_in_state_b, customer_purchase_invalid_amount, email_sender, domain_name, 
            mail_to_sales, mail_to_om, mail_to_invas, mail_to_marketing, mail_to_IT, 
            mail_to_finance, mail_to_customercare, shortcode, kannel_ip, kannel_port, kannel_user, kannel_password, mail_host;

    public String getMail_host() {
        return mail_host;
    }
    
    
    private final String props_dir = "/etc/lnmp/topup.conf";
    public Properties props;
    private FileInputStream propsStream = null;
    
    private Logger logger = Logger.getLogger(Props.class.getSimpleName());
    
    @SuppressWarnings({"UseOfSystemOutOrSystemErr", "unchecked"})
    public Props(){
        try{
            props = new Properties();
            
            propsStream = new FileInputStream(props_dir);
            
            props.load(propsStream);
            
            ejaze_low_balance = props.getProperty("ejaze_low_balance");
            
            customer_number_format_invalid = props.getProperty("customer_number_format_invalid");
            
            customer_number_postpaid = props.getProperty("customer_number_postpaid");
            
            customer_in_state_b = props.getProperty("customer_in_state_b");
            
            customer_purchase_invalid_amount = props.getProperty("customer_purchase_invalid_amount");
            
            email_sender = props.getProperty("email_sender");
            
            domain_name = props.getProperty("domain_name");
            
            mail_to_sales = props.getProperty("mail_to_sales");
            
            mail_to_om = props.getProperty("mail_to_om");
            
            mail_to_invas = props.getProperty("mail_to_invas");
            
            mail_to_marketing = props.getProperty("mail_to_marketing");
            
            mail_to_IT = props.getProperty("mail_to_IT");
            
            mail_to_finance = props.getProperty("mail_to_finance");
            
            mail_to_customercare = props.getProperty("mail_to_customercare");
            
            shortcode = props.getProperty("shortcode");
            
            kannel_ip = props.getProperty("kannel_ip");
            
            kannel_port = props.getProperty("kannel_port");
            
            kannel_user = props.getProperty("kannel_user");
            
            kannel_password = props.getProperty("kannel_password");
            
            mail_host = props.getProperty("mail_host");
            
        } catch (IOException ioe) {
            logger.error("Exiting. Failed to load system properties: "
                    + ioe.getMessage());
            
            try {
                propsStream.close();
            } catch (IOException ex) {
                logger.error("Failed to close the properties file: "
                        + ex.getMessage());
            }

            //System.exit(1);
        }
    }

    public String getEjaze_low_balance() {
        return ejaze_low_balance;
    }


    public String getCustomer_number_format_invalid() {
        return customer_number_format_invalid;
    }

    public String getCustomer_number_postpaid() {
        return customer_number_postpaid;
    }

    public String getCustomer_in_state_b() {
        return customer_in_state_b;
    }

public String getCustomer_purchase_invalid_amount() {
        return customer_purchase_invalid_amount;
    }

    public String getEmail_sender() {
        return email_sender;
    }

    public String getDomain_name() {
        return domain_name;
    }

    public String getMail_to_sales() {
        return mail_to_sales;
    }

    public String getMail_to_om() {
        return mail_to_om;
    }

    public String getMail_to_invas() {
        return mail_to_invas;
    }

    public String getMail_to_marketing() {
        return mail_to_marketing;
    }

    public String getMail_to_IT() {
        return mail_to_IT;
    }

    public String getMail_to_finance() {
        return mail_to_finance;
    }

    public String getMail_to_customercare() {
        return mail_to_customercare;
    }

    public String getShortcode() {
        return shortcode;
    }

    public String getKannel_ip() {
        return kannel_ip;
    }

    public String getKannel_port() {
        return kannel_port;
    }

    public String getKannel_user() {
        return kannel_user;
    }

    public String getKannel_password() {
        return kannel_password;
    }
    
}
