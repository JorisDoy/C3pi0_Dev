/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.client.reversal;

import com.huawei.cps.cpsinterface.c2bpayment.client.RegisterURL;
import static com.huawei.cps.cpsinterface.c2bpayment.client.RegisterURL.obj;
import com.huawei.cps.cpsinterface.c2bpayment.client.RegisterURLPojo;
import com.huawei.cps.cpsinterface.c2bpayment.utils.Base64SHA256;
import com.huawei.cps.cpsinterface.c2bpayment.utils.GetDateTime;
import com.huawei.cps.cpsinterface.c2bpayment.utils.KeystoreEncrypt;
import com.huawei.cps.cpsinterface.c2bpayment.utils.Util;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.namespace.QName;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
//import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author gaddafi
 */
public class TransactReversal {

    ReversalPOJO obj;
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TransactReversal.class.getName());

    public TransactReversal() {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
            obj = (ReversalPOJO) context.getBean("treversal");
            //ru.RegisterValidationConfirmationURLs();

        } catch (Exception ex) {
            Logger.getLogger(TransactReversal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void request() {
        try {
            GetDateTime gdt = new GetDateTime();
            
            String time = gdt.getTimeWithFormat();
            
            Base64SHA256 b64 = new Base64SHA256();
            
            MessageFactory factory = MessageFactory.newInstance(/*SOAPConstants.SOAP_1_2_PROTOCOL*/);
            SOAPMessage message = factory.createMessage();
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.removeAttributeNS("http://www.w3.org/2003/05/soap-envelope", "env");
            envelope.removeNamespaceDeclaration(envelope.getPrefix());
            envelope.addNamespaceDeclaration("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
            envelope.addNamespaceDeclaration("req", "http://api-v1.gen.mm.vodafone.com/mminterface/request");
            // envelope.setEncodingStyle("http://www.w3.org/2001/12/soap-encoding/");
            envelope.setPrefix("soapenv");
            
            //
            MimeHeaders mHeaders = message.getMimeHeaders();
            mHeaders.addHeader("SOAPAction", "\"\"");

            SOAPHeader header = envelope.getHeader();
            header.setPrefix("soapenv");
            SOAPBody soapBody = envelope.getBody();
            soapBody.setPrefix("soapenv");

            // SOAP Part header
            QName headerElementName = new QName("http://www.huawei.com/schema/osg/common/v2_1", "RequestSOAPHeader", "tns");
            SOAPHeaderElement authHeader = header.addHeaderElement(headerElementName);

            QName headerChild = new QName("spId");
            SOAPElement spid = authHeader.addChildElement(headerChild);
            spid.addTextNode(obj.getSpid());

            headerChild = new QName("spPassword");
            SOAPElement sp_password = authHeader.addChildElement(headerChild);
            sp_password.addTextNode(b64.encodePassword(obj.getSp_password(), time));

            headerChild = new QName("timeStamp");
            SOAPElement timestamp = authHeader.addChildElement(headerChild);
            timestamp.addTextNode(time);

            headerChild = new QName("serviceId");
            SOAPElement serviceid = authHeader.addChildElement(headerChild);
            serviceid.addTextNode(obj.getServiceid());

            

            // SOAPBody Part
            QName doServiceName = new QName("RequestMsg");
            SOAPBodyElement doService = soapBody.addBodyElement(doServiceName);
            doService.setPrefix("req");
            doService.addTextNode(buildCDATA(time, time, time, time, time, time, time, time));

            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = soapConnectionFactory.createConnection();
            //connection.wait(10000);
            // send the message
            System.out.println("!!!!!!!!!!!!!!\nSending request to server\n!!!!!!!!!!!!!!");
            //URL endpoint = new URL("http://192.168.20.7:8080/mminterface/registerURL");

        URL endpoint = new URL(new URL("http://196.201.214.136:8310"), "/mminterface/registerURL", new URLStreamHandler() {
                    @Override
                    protected URLConnection openConnection(URL url) throws IOException {
                        URL target = new URL(url.toString());
                        URLConnection connection = target.openConnection();
                        // Connection settings
                        connection.setConnectTimeout(10000); // 10 sec
                        connection.setReadTimeout(60000); // 1 min
                        return (connection);
                    }
                });
            SOAPMessage response = connection.call(message, endpoint);
            //SOAPMessage response = connection.call(message, endpoint);
            connection.close();

            // Capture the response
            SOAPBody sBody = response.getSOAPBody();
            //
            doServiceName = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/request", "ResponseMsg");
            java.util.Iterator iterator = sBody.getChildElements(doServiceName);
            HashMap<String, String> status;
            TransactReverseResponse rur = new TransactReverseResponse();
            while (iterator.hasNext()) {
                NodeList nodeList = sBody.getElementsByTagName("req:ResponseMsg");
                Element element = (Element) nodeList.item(0);
                Node child = element.getFirstChild();
                String characterData;
                if (child instanceof CharacterData) {
                    characterData = ((CharacterData) child).getData();
                    //System.out.println(characterData);
                    status = rur.printChildElements(characterData);
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n\n\n"
                            + characterData + "\n\n\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
            }
        } catch (SOAPException ex) {
            logger.fatal(ex.getMessage());
            //Logger.getLogger(TransactReversal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            logger.fatal(ex.getMessage());
            //Logger.getLogger(TransactReversal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param call_back_url
     * @param password
     * @param timeout_url
     * @param short_code
     * @param originator_conversation_id
     * @param original_transaction_id
     * @param server_ip
     * @param timestamp_with_special_format
     * @return
     */
    public String buildCDATA(String call_back_url, String password, String timeout_url, String short_code, String originator_conversation_id, String original_transaction_id, String server_ip, String timestamp_with_special_format) {
        StringBuilder sb = new StringBuilder();
        KeystoreEncrypt ke = new KeystoreEncrypt();
        sb.append("<![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<request xmlns=\"http://api-v1.gen.mm.vodafone.com/mminterface/request\">");
        sb.append("<Transaction>");
        sb.append("<CommandID>TransactionReversal</CommandID>");
        sb.append("<LanguageCode>0</LanguageCode>");
        sb.append("<OriginatorConversationID>").append(originator_conversation_id).append("</OriginatorConversationID>");
        sb.append("<ConversationID/>");
        sb.append("<Remark>0</Remark>");
        sb.append("<Parameters>");
        sb.append("<Parameter>");
        sb.append("<Key>OriginalTransactionID</Key>");
        sb.append("<Value>").append(original_transaction_id).append("</Value>");
        sb.append("</Parameter>");
        sb.append("</Parameters>");
        sb.append("<ReferenceData>");
        sb.append("<ReferenceItem>");
        sb.append("<Key>QueueTimeoutURL</Key>");
        sb.append("<Value>").append(timeout_url).append("</Value>");
        sb.append("</ReferenceItem>");
        sb.append("</ReferenceData>");
        sb.append("<Timestamp>").append(timestamp_with_special_format).append("</Timestamp>");
        sb.append("</Transaction>");
        sb.append("<Identity>");
        sb.append("<Caller>");
        sb.append("<CallerType>2</CallerType>");
        sb.append("<ThirdPartyID>broker_4</ThirdPartyID>");
        //sb.append("<Password>");
        //sb.append(obj.getSp_password());
        //sb.append("</Password>");
        sb.append("<ResultURL>").append(call_back_url).append("</ResultURL>");
        sb.append("</Caller>");
        sb.append("<Initiator>");
        sb.append("<IdentifierType>11</IdentifierType>");
        sb.append("<Identifier>C2BInit</Identifier>");
        sb.append("<SecurityCredential>");
        /*
        Intentianal error below, params for getSecurityCredential(*,*,*,*) 
        are NOT OK!
        PLEASE CORRECT
        */
        
        sb.append(ke.getSecurityCredential(password, password, server_ip, server_ip));
        sb.append("");
        sb.append("</SecurityCredential>");
        sb.append("<ShortCode>167178</ShortCode>");
        sb.append("</Initiator>");
        sb.append("<AccessDevice>");
        sb.append("<IdentifierType>1</IdentifierType>");
        sb.append("<Identifier>10.66.50.133</Identifier>");
        sb.append("</AccessDevice>");
        sb.append("</Identity>");
        sb.append("<KeyOwner>1</KeyOwner>");
        sb.append("</request>");
        sb.append("]]>");
        return sb.toString();
    }

    public static void setTrustKeyCert() {
        System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
        System.setProperty("javax.net.ssl.trustStore", "/usr/java/latest/jre/lib/security/cacerts");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        System.setProperty("javax.net.ssl.keyStore", "/usr/local/tomcat/LipaNaMpesa.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
        System.setProperty("javax.net.ssl.keyStoreType", "JKS");
    }

    public void doTrustToCertificates() throws Exception {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                    return;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                    return;
                }
            }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HostnameVerifier hv = new HostnameVerifier() {
            @Override
            public boolean verify(String urlHostName, SSLSession session) {
                if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                    logger.fatal("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                }
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }

//    public String encodePassword(String timestamp) throws NoSuchAlgorithmException {
//        //GetDateTime gdt = new GetDateTime();
//        //Util util = new Util();
//        /**
//         * Remember to un-comment encoding_string
//         */
//        String encoding_string = "spid" + "sp_password" + timestamp/*gdt.getTimeWithFormat()*/;
//        MessageDigest digest = MessageDigest.getInstance("SHA-256");
//        byte[] hash = digest.digest(encoding_string.getBytes(StandardCharsets.UTF_8));
//        String hashed = java.util.Base64.getEncoder().encodeToString(Util.toHex(hash).getBytes());
//        return hashed;
//    }

//    public static void main(String[] args) throws NoSuchAlgorithmException {
//        TransactReversal tr = new TransactReversal();
//        String pass_combination = "107031Safaricom123!201803291644";
//        //TransactReversal tr = new TransactReversal();
//        //System.out.println(tr.encodePassword(pass_combination));
//    }
}
