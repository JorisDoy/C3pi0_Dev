/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.client.reversal;

/**
 *
 * @author gaddafi
 */

import com.huawei.cps.cpsinterface.c2bpayment.utils.Util;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;

public class Crypt {
    
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Crypt.class.getName());
    
    public Crypt(){
        super();
    }
    
    public byte[] encrypt(String text) throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException, Exception{
        byte[] encrypted = null;
        String xfrom = "RSA/ECB/PKCS1PADDING";
        KeyStore ks = null;
        
        try{
            ks = KeyStore.getInstance("JKS");
        }catch(KeyStoreException ex){
            logger.fatal(ex.getMessage());
        }
        char[] password = "changeit".toCharArray();
        File file = new File("/home/gaddafi/Documents/LipaNaMpesa/pub/security_credential.jks");
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(file);
            ks.load(fis, password);
        } catch (FileNotFoundException ex) {
            logger.fatal(ex.getMessage());
            //Logger.getLogger(Crypt.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (IOException ex) {
            logger.fatal(ex.getMessage());
            //Logger.getLogger(Crypt.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (NoSuchAlgorithmException ex) {
            logger.fatal(ex.getMessage());
            //Logger.getLogger(Crypt.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (CertificateException ex) {
            logger.fatal(ex.getMessage());
            //Logger.getLogger(Crypt.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException ex) {
                    logger.fatal(ex.getMessage());
                    //Logger.getLogger(Crypt.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        
        KeyStore.TrustedCertificateEntry pkEntry = (KeyStore.TrustedCertificateEntry) ks.getEntry("safSecurityCredential", null);
        PublicKey pub = pkEntry.getTrustedCertificate().getPublicKey();
        logger.info(pub.toString());
        
        byte[] result = encrypt(text.getBytes(), pub, xfrom);
        // get the hex
        String hex_value = Util.toHex(result);
        logger.info("Hex Value: " + hex_value);
        // Get Base64 Value
        String hashed = java.util.Base64.getEncoder().encodeToString(/*result*/hex_value.getBytes());
        logger.info("Base64 Value: " + hashed);
        
        return encrypted;
    }
    
    private byte[] encrypt(byte[] inpBytes, PublicKey key, String xform) throws Exception {
        Cipher cipher = Cipher.getInstance(xform);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(inpBytes);
    }
}
