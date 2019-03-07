/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.telkom.gateway.encryption;

import java.io.File;
import java.io.FileInputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.crypto.Cipher;

/**
 *
 * @author jdmwamburi
 */
public class Encryption {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
   /* public static void main(String[] args) throws Exception {

            String keyName = "telepinuatrsa";
            String inputStr = "Bonf!VntQyLFU2Xp.KVx";
            byte[] input = inputStr.getBytes();

            X509Certificate cert;
        try ( //InputStream inStream = new FileInputStream(keyName + ".cer");
            FileInputStream inStream = new FileInputStream(new File("C:\\Users\\jdmwamburi\\Documents\\NetBeansProjects\\TelepinPasswordEncryption\\utils\\T_kash_stg.cer"))) 
        {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            cert = (X509Certificate)cf.generateCertificate(inStream);
        }

            PublicKey publicKey = (PublicKey)cert.getPublicKey();
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedBytes = cipher.doFinal(input);

            String encryptedString;
            encryptedString = new String(org.bouncycastle.util.encoders.Base64.encode(encryptedBytes)).trim();
            System.out.println("encrypted: " + encryptedString);

    }*/
    public static void main(String[] args) throws Exception{
		//String password = "Bonf!VntQyLFU2Xp.KVx";
                //String password = "K2Wq@2oI7";
                String password ="48xDwmL#m=XNcmQ7#kJ";
		byte[] input = password.getBytes();
		FileInputStream inStream = new FileInputStream(new File("C:\\Users\\jdmwamburi\\Documents\\NetBeansProjects\\TelepinPasswordEncryption\\utils\\T_kash_stg.cer"));
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		X509Certificate cert = (X509Certificate)cf.generateCertificate(inStream);
		inStream.close();
		PublicKey publickey = (PublicKey)cert.getPublicKey();
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publickey);
		byte[] encryptedBytes = cipher.doFinal(input);
		String encryptedString = new String(org.bouncycastle.util.encoders.Base64.encode(encryptedBytes)).trim();
		System.out.println("encrypted: " + encryptedString);
	}

}
