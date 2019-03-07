/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.client;

//import com.sun.net.ssl.KeyManagerFactory;
import com.huawei.cps.cpsinterface.c2bpayment.C2BPaymentValidationAndComfirmationImpl;
import com.huawei.cps.cpsinterface.c2bpayment.utils.GetDateTime;
import com.huawei.cps.cpsinterface.c2bpayment.utils.Util;
import com.huawei.cps.cpsinterface.c2bpayment.utils.ejaze.EjazePojo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
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
import javax.xml.xpath.XPathExpressionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author gaddafi
 */
public class RegisterURL {

    public static RegisterURLPojo obj;
    
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RegisterURL.class.getName());

    /**
     *
     * @throws SOAPException
     */
    public void RegisterValidationConfirmationURLs() throws SOAPException, MalformedURLException, Exception {
        // Set Key manenos
        setTrustKeyCert();
        GetDateTime gdt = new GetDateTime();
        String time = gdt.getTimeWithFormat();
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

        SOAPHeader header = envelope.getHeader();
        header.setPrefix("soapenv");
        SOAPBody soapBody = envelope.getBody();
        soapBody.setPrefix("soapenv");

        // SOAP Part header
        QName headerElementName = new QName("http://www.huawei.com/schema/osg/common/v2_1", "RequestSOAPHeader", "tns");
        SOAPHeaderElement authHeader = header.addHeaderElement(headerElementName);

        //
        QName headerChild = new QName("spId");
        SOAPElement spid = authHeader.addChildElement(headerChild);
        spid.addTextNode(obj.getSpid());

        headerChild = new QName("spPassword");
        SOAPElement sp_password = authHeader.addChildElement(headerChild);
        sp_password.addTextNode(encodePassword(time));

        headerChild = new QName("timeStamp");
        SOAPElement timestamp = authHeader.addChildElement(headerChild);
        timestamp.addTextNode(time);

        headerChild = new QName("serviceId");
        SOAPElement serviceid = authHeader.addChildElement(headerChild);
        serviceid.addTextNode(obj.getServiceid());

        //
        MimeHeaders mHeaders = message.getMimeHeaders();
        mHeaders.addHeader("SOAPAction", "\"\"");

        // SOAPBody Part
        QName doServiceName = new QName("RequestMsg");
        SOAPBodyElement doService = soapBody.addBodyElement(doServiceName);
        doService.setPrefix("req");
        doService.addTextNode(buildCDATA());

        // trust all keys from server
        doTrustToCertificates();
        // Create connection
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = soapConnectionFactory.createConnection();
        //connection.wait(10000);
        // send the message
        System.out.println("!!!!!!!!!!!!!!\nSending request to server\n!!!!!!!!!!!!!!");
        URL endpoint = new URL("https://196.201.214.137:18423/mminterface/registerURL");

//        URL endpoint = new URL(new URL("http://196.201.214.136:8310"), "/mminterface/registerURL",
//                        new URLStreamHandler() {
//                    @Override
//                    protected URLConnection openConnection(URL url) throws IOException {
//                        URL target = new URL(url.toString());
//                        URLConnection connection = target.openConnection();
//                        // Connection settings
//                        connection.setConnectTimeout(10000); // 10 sec
//                        connection.setReadTimeout(60000); // 1 min
//                        return (connection);
//                    }
//                });

        //SOAPMessage result = connection.call(soapMessage, endpoint);
        SOAPMessage response = connection.call(message, endpoint);
        connection.close();

        // Capture the response
        SOAPBody sBody = response.getSOAPBody();
        //
        doServiceName = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/request", "ResponseMsg");
        java.util.Iterator iterator = sBody.getChildElements(doServiceName);
        HashMap<String, String> status;
        RUResponse rur = new RUResponse();
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
        // handle the response status

    }

    public static void main(String[] args) throws SOAPException, MalformedURLException, Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beansv.xml");
        RegisterURL ru = new RegisterURL();
        ru.obj = (RegisterURLPojo) context.getBean("regurls");
        ru.RegisterValidationConfirmationURLs();
    }

    public static String buildCDATA(/*String validation_url, String confirmation_url*/) {

        StringBuilder cdata = new StringBuilder();
        cdata.append("<![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        cdata.append("<request xmlns=\"http://api-v1.gen.mm.vodafone.com/mminterface/request\">");
        cdata.append("<Transaction>");
        cdata.append("<CommandID>RegisterURL</CommandID>");
        cdata.append("<OriginatorConversationID>Reg-266-1126</OriginatorConversationID>");
        cdata.append("<Parameters>");
        cdata.append("<Parameter>");
        cdata.append("<Key>ResponseType</Key><Value>Cancelled</Value>");
        cdata.append("</Parameter>");
        cdata.append("</Parameters>");
        cdata.append("<ReferenceData>");
        cdata.append("<ReferenceItem>");
        cdata.append("<Key>ValidationURL</Key>");
        cdata.append("<Value>" + obj.getUrl() + "</Value>");
        cdata.append("</ReferenceItem>");
        cdata.append("<ReferenceItem>");
        cdata.append("<Key>ConfirmationURL</Key>");
        cdata.append("<Value>" + obj.getUrl() + "</Value>");
        cdata.append("</ReferenceItem>");
        cdata.append("</ReferenceData>");
        cdata.append("</Transaction>");
        cdata.append("<Identity>");
        cdata.append("<Caller>");
        cdata.append("<CallerType>0</CallerType>");
        cdata.append("<ThirdPartyID/>");
        cdata.append("<Password/>");
        cdata.append("<CheckSum/>");
        cdata.append("<ResultURL/>");
        cdata.append("</Caller>");
        cdata.append("<Initiator>");
        cdata.append("<IdentifierType>1</IdentifierType>");
        cdata.append("<Identifier/>");
        cdata.append("<SecurityCredential/>");
        cdata.append("<ShortCode>777711</ShortCode>");
        cdata.append("</Initiator>");
        cdata.append("<PrimaryParty>");
        cdata.append("<IdentifierType>1</IdentifierType>");
        cdata.append("<Identifier/>");
        cdata.append("<ShortCode>" + obj.getShortcode() + "</ShortCode>");
        cdata.append("</PrimaryParty>");
        cdata.append("</Identity>");
        cdata.append("<KeyOwner>1</KeyOwner>");
        cdata.append("</request>]]>");

        return cdata.toString();
    }

//    static public void doTrustToCertificates() throws Exception {
//
//        // Set truststore that contains root / intermediary certs
//        System.setProperty("javax.net.ssl.trustStore", "C:\\cert\\trusted.jks");
//        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
//
//        // Set keystore that contains private key
//        File pKeyFile = new File("C:\\cert\\privatekey.pfx");
//        String pKeyPassword = "Password01";
//        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
//        KeyStore keyStore = KeyStore.getInstance("PKCS12");
//        InputStream keyInput = new FileInputStream(pKeyFile);
//        keyStore.load(keyInput, pKeyPassword.toCharArray());
//        keyInput.close();
//        keyManagerFactory.init(keyStore, pKeyPassword.toCharArray());
//
//        // Set ssl context with private key and truststore details
//        SSLContext sc = SSLContext.getInstance("TLSv1");
//        sc.init(keyManagerFactory.getKeyManagers(), null, new SecureRandom());
//        SSLSocketFactory sockFact = sc.getSocketFactory();
//
//        // Add ssl context to https connection
//        HttpsURLConnection.setDefaultSSLSocketFactory(sockFact);
//
//    }
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
                    logger.error("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                }
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }

    public static String encodePassword(String timestamp) throws NoSuchAlgorithmException {
        //GetDateTime gdt = new GetDateTime();
        String encoding_string = obj.getSpid() + obj.getSp_password() + timestamp/*gdt.getTimeWithFormat()*/;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(encoding_string.getBytes(StandardCharsets.UTF_8));
        String hashed = java.util.Base64.getEncoder().encodeToString(Util.toHex(hash).getBytes());
        return hashed;
    }
}
