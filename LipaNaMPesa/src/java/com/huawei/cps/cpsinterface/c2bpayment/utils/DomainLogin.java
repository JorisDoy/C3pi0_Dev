/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.utils;

//import com.reversal.utils.Configs.Conf;
import java.util.Hashtable;
import java.util.concurrent.ThreadLocalRandom;
import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.security.auth.login.AccountException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

/**
 *
 * @author gaddafi
 */
public class DomainLogin {
    
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DomainLogin.class.getName());

    public boolean authenticate(String username, String password){
        
        String ldapServerUrl = Configs.ldapServerUrls[ThreadLocalRandom.current().nextInt(0, 1 + 1)];

        int retryCount = 0;
        //int currentLdapUrlIndex = lastLdapUrlIndex;
        do {
            retryCount++;
            try {
                Hashtable<Object, Object> env = new Hashtable<Object, Object>();
                env.put(Context.INITIAL_CONTEXT_FACTORY, Configs.CONTEXT_FACTORY_CLASS);
                env.put(Context.PROVIDER_URL, ldapServerUrl);
                env.put(Context.SECURITY_PRINCIPAL, username + "@" + Configs.DOMAIN_NAME);
                env.put(Context.SECURITY_CREDENTIALS, password);
                DirContext ctx = new InitialDirContext(env);
                ctx.close();
                //lastLdapUrlIndex = currentLdapUrlIndex;
                return true;
            } catch (CommunicationException exp) {
                logger.fatal(exp.getMessage());
                System.out.println(exp.getMessage()); // TODO you can replace with log4j or slf4j API
                return false;
            } catch (Throwable throwable) {
                logger.fatal(throwable.getMessage());
                System.out.println(throwable.getMessage());
                return false;
            }
        } while (retryCount < 1);
    }
}
