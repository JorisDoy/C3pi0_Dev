/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.utils.ocst;

/**
 *
 * @author ramson
 */
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UserProfileClient {

    public int reqID, tranSN;
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(UserProfileClient.class.getName());

    public UserProfileClient() {
        int reqId = (int) (Math.random() * 100000);
        int tranSN = (int) (Math.random() * 10000);
        this.reqID = reqId;
        this.tranSN = tranSN;
    }

    public String request(String msisdn) {
        String status = "";
        try {
            //Balance main_balance = null;

            //List<Balance> main_balance = new ArrayList<>();
            ChildElements childElements = new ChildElements();
            MessageFactory factory = MessageFactory.newInstance(/*SOAPConstants.SOAP_1_2_PROTOCOL*/);
            SOAPMessage message = factory.createMessage();

            // Get the SOAP Part
            SOAPPart soapPart = message.getSOAPPart();

            // Get the envelope, header, body from the soapPart (This are the main parts of any SOAP)
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.removeAttributeNS("http://www.w3.org/2003/05/soap-envelope", "env");
            envelope.removeNamespaceDeclaration(envelope.getPrefix());
            envelope.addNamespaceDeclaration("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
            envelope.addNamespaceDeclaration("ocs", "http://ocs.ztesoft.com");
            // envelope.setEncodingStyle("http://www.w3.org/2001/12/soap-encoding/");
            envelope.setPrefix("soapenv");

            SOAPHeader header = envelope.getHeader();
            header.setPrefix("soapenv");
            SOAPBody soapBody = envelope.getBody();
            soapBody.setPrefix("soapenv");

            // SOAPHeader Part
            QName headerElementName = new QName("http://ZTEsoft.com/webservices/", "AuthHeader");
            SOAPHeaderElement authHeader = header.addHeaderElement(headerElementName);

            QName headerChild = new QName("Username");
            SOAPElement userName = authHeader.addChildElement(headerChild);
            userName.addTextNode("new@etopUp_comviva");

            headerChild = new QName("Password");
            SOAPElement passwd = authHeader.addChildElement(headerChild);
            passwd.addTextNode("new@pretups#topup@01");

            // Get the MIME Headers
            MimeHeaders mHeaders = message.getMimeHeaders();
            mHeaders.addHeader("SOAPAction", "\"\"");

            // SOAPBody Part
            QName doServiceName = new QName("doService");
            SOAPBodyElement doService = soapBody.addBodyElement(doServiceName);
            doService.setPrefix("ocs");

            // Child name element
            QName childName = new QName("http://ocs.ztesoft.com", "in0", "ocs");
            SOAPElement in0 = doService.addChildElement(childName);
            //in0.setPrefix("ocs");

            // Add cDATA[]
            String bundles = "<![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?><zsmart><Data><header><ACTION_ID>QueryBasicProfile</ACTION_ID><REQUEST_ID>003200" + reqID + "</REQUEST_ID></header><body><MSISDN>" + msisdn + "</MSISDN><TransactionSN>018111" + tranSN + "</TransactionSN><UserPwd></UserPwd></body></Data></zsmart>]]>";

            in0.addTextNode(bundles);

            // Create connection from SOAPConnectionFactory
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = soapConnectionFactory.createConnection();

            // send the message
            System.out.println("!!!!!!!!!!!!!!\nSending request to server\n!!!!!!!!!!!!!!");
            URL endPoint = new URL("http://192.168.19.18:8080/ocswebservices/services/WebServices");
            SOAPMessage response = connection.call(message, endPoint);
            connection.close();

            // Capture the response
            SOAPBody sBody = response.getSOAPBody();
            doServiceName = new QName("http://ocs.ztesoft.com", "doServiceResponse");
            //QName doServiceReturn = new QName("http://ocs.ztesoft.com", "doServiceResponse");
            //sBody.getElementQName();

            java.util.Iterator iterator = sBody.getChildElements(doServiceName);
            while (iterator.hasNext()) {
                SOAPBodyElement bElement = (SOAPBodyElement) iterator.next();

                String ocsResponse = bElement.getValue();
                //System.out.println(ocsResponse);

                NodeList nodeList = sBody.getElementsByTagName("doServiceReturn");
                Element element = (Element) nodeList.item(0);
                Node child = element.getFirstChild();
                String characterData;

                if (child instanceof CharacterData) {
                    characterData = ((CharacterData) child).getData();
                    //System.out.println(characterData);
                    status = childElements.printChildElements(characterData);
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n\n\n"
                            + characterData + "\n\n\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
            }

        } catch (SOAPException ex) {
            logger.fatal(ex.getMessage());
            //Logger.getLogger(UserProfileClient.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (XPathExpressionException ex) {
            logger.fatal(ex.getMessage());
            //Logger.getLogger(UserProfileClient.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (ParserConfigurationException ex) {
            logger.fatal(ex.getMessage());
            //Logger.getLogger(UserProfileClient.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (SAXException ex) {
            logger.fatal(ex.getMessage());
            //Logger.getLogger(UserProfileClient.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (IOException ex) {
            logger.fatal(ex.getMessage());
            //Logger.getLogger(UserProfileClient.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (ParseException ex) {
            logger.fatal(ex.getMessage());
            //Logger.getLogger(UserProfileClient.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return status;
    }
}
