/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.crypto.Cipher;
import org.apache.log4j.Logger;

/**
 *
 * @author gaddafi
 */
public class KeystoreEncrypt {
    
    
    private final Logger logger = Logger.getLogger(KeystoreEncrypt.class.getSimpleName());

    /**
     * @param security_password
     * @param keytool_password
     * @param keytool_path
     * @param cipher_suit
     * @return 
     */
    public String getSecurityCredential(String security_password, String keytool_password, String keytool_path, String cipher_suit)  {
        String security_credential = "";
        try{
            // TODO code application logic here
            String xform = cipher_suit/*"RSA/ECB/PKCS1PADDING"*/;
            KeyStore ks = KeyStore.getInstance("JKS");
            char[] password = keytool_password.toCharArray();
            File file = new File(keytool_path);
            FileInputStream fis = null;
            
            try{
                fis = new FileInputStream(file);
                ks.load(fis, password);
            } catch (FileNotFoundException ex) {
                logger.fatal(ex.getMessage(), ex);
            } catch (IOException ex) {
                logger.fatal(ex.getMessage(), ex);
            } catch (NoSuchAlgorithmException ex) {
                logger.fatal(ex.getMessage(), ex);
            } catch (CertificateException ex) {
                logger.fatal(ex.getMessage(), ex);
            } finally{
                if(fis != null){
                    try {
                        fis.close();
                    } catch (IOException ex) {
                        logger.fatal(ex.getMessage(), ex);
                    }
                }
            }
            
            KeyStore.TrustedCertificateEntry pkEntry = (KeyStore.TrustedCertificateEntry) ks.getEntry("safSecurityCredential", null);
            PublicKey pub = pkEntry.getTrustedCertificate().getPublicKey();
            logger.info(pub.toString());
            byte[] result = encrypt(security_password.getBytes(), pub, xform);
            // get the hex
            String hex_value = Util.toHex(result);
            logger.info("Hex Value: " + hex_value);
            // Get Base64 Value
            String hashed = java.util.Base64.getEncoder().encodeToString(/*result*/hex_value.getBytes());
            logger.info("Base64 Value: " + hashed);
        } catch (Exception ex) {
            logger.fatal(ex.getMessage(), ex);
        }
        
        return security_credential;
    }
    
    private byte[] encrypt(byte[] inpBytes, PublicKey key, String xform) throws Exception {
        Cipher cipher = Cipher.getInstance(xform);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(inpBytes);
    }
}
