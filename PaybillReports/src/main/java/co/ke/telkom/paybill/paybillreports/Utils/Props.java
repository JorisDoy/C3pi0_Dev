/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ke.telkom.paybill.paybillreports.Utils;

/**
 *
 * @author gaddafi
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class Props {
    
    private String report_to, report_cc, report_bcc, mail_host;
    
    private Logger logger = Logger.getLogger(Props.class.getSimpleName());
    
    private final String props_dir = "/etc/lnmp/topup.conf";
    
    private Properties props;
    
    private FileInputStream propsStream = null;
    
    public Props(){
        try{
            props = new Properties();
            
            propsStream = new FileInputStream(props_dir);
            
            props.load(propsStream);
            
            report_to = props.getProperty("report_to");
            
            report_cc = props.getProperty("report_cc");
            
            report_bcc = props.getProperty("report_bcc");
            
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

    public String getMail_host() {
        return mail_host;
    }

    public String getReport_to() {
        return report_to;
    }

    public String getReport_cc() {
        return report_cc;
    }

    public String getReport_bcc() {
        return report_bcc;
    }
    
}
