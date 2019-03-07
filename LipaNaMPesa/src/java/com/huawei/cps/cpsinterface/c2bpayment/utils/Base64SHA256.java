/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.utils;

//import com.sun.xml.messaging.saaj.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.apache.tomcat.util.codec.binary.Base64;
//import org.bouncycastle.util.encoders.Base64;
//import org.apache.commons.codec.binary.Base64;
//import java.util.Base64;

/**
 *
 * @author gaddafi
 */
public class Base64SHA256 {
    
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Base64SHA256.class.getName());

    public String encodePassword(String password, String timestamp) {
        String hashed = "";
        try {
            //GetDateTime gdt = new GetDateTime();
            String encoding_string = password + timestamp/*gdt.getTimeWithFormat()*/;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(encoding_string.getBytes(StandardCharsets.UTF_8));
            String hex = Util.toHex(hash);
            hashed = java.util.Base64.getEncoder().encodeToString(hex.getBytes());
            //hashed = java.util.Base64.code
            //hashed = Base64.encodeBase64String(hash);
            System.out.println("Hex: " + hex);
            System.out.println(hashed);
            //System.out.println(java.util.Base64.getEncoder().(Util.toHex(hash));
            
        } catch (NoSuchAlgorithmException ex) {
            logger.fatal(ex.getMessage());
            //Logger.getLogger(EncodePassword.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return hashed;
    }

    public String encode() {
        String out = "";
        return out;
    }
}
