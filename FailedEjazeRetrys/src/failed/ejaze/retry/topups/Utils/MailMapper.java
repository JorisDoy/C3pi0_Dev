/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package failed.ejaze.retry.topups.Utils;

import failed.ejaze.retry.topups.DB.Selects;
import java.util.HashMap;
import org.apache.log4j.Logger;

/**
 *
 * @author jdmwamburi
 */
public class MailMapper implements Runnable 
{
    private final String message;
    private final HashMap<String, String> reciepients;
    private final Props prop;
    private static final Logger logger = Logger.getLogger(MailMapper.class.getName());
    
    public MailMapper(HashMap<String, String> reciepients, String message, Props prop)
    {
        this.reciepients = reciepients;
        this.message = message;
        this.prop = prop;
    }
    
    @Override
    public void run() 
    {
        SendMail sm = new SendMail(prop);
        sm.send(reciepients, message);
    }
}
