/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telkom.ocs.balance;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.xml.namespace.QName;
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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author jdmwamburi
 */
public class OcsBalanceAdjustmentClient 
{
    public static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(OcsBalanceAdjustmentClient.class.getName());
    private static SOAPMessage createSOAPRequest(String soapAction, String mpesaRefId, String msisdn, String amount) throws Exception 
    {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        createSoapEnvelope(soapMessage, mpesaRefId, msisdn , amount);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);
        soapMessage.saveChanges();
        // Log the SOAP Request to ejaze
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        soapMessage.writeTo(baos);
        logger.info("Logging the request to OCS");
        logger.info(baos);
        /* Print the request message, just for debugging purposes */
        //System.out.println("Request SOAP Message:");
        //soapMessage.writeTo(System.out);
        //System.out.println("\n");
        return soapMessage;
    }
    private static void createSoapEnvelope(SOAPMessage soapMessage, String mpesaRefId, String msisdn, String amount) throws SOAPException 
    {
            SOAPPart soapPart = soapMessage.getSOAPPart();
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            MessageFactory factory = MessageFactory.newInstance();
            SOAPMessage message = factory.createMessage();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.removeAttributeNS("http://www.w3.org/2003/05/soap-envelope", "env");
            envelope.removeNamespaceDeclaration(envelope.getPrefix());
            envelope.addNamespaceDeclaration("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
            envelope.addNamespaceDeclaration("ocs", "http://ocs.ztesoft.com");
            envelope.setPrefix("soapenv");
            SOAPHeader header = envelope.getHeader();
            header.setPrefix("soapenv");
            SOAPBody soapBody = envelope.getBody();
            soapBody.setPrefix("soapenv");
            QName headerElementName = new QName("http://ZTEsoft.com/webservices/", "AuthHeader");
            SOAPHeaderElement authHeader = header.addHeaderElement(headerElementName);  
            QName headerChild = new QName("Username");
            SOAPElement userName = authHeader.addChildElement(headerChild);
            userName.addTextNode("new@etopUp_comviva");
            headerChild = new QName("Password");
            SOAPElement passwd = authHeader.addChildElement(headerChild);
            passwd.addTextNode("new@pretups#topup@01");
            MimeHeaders mHeaders = message.getMimeHeaders();
            mHeaders.addHeader("SOAPAction", "\"\"");    
            QName doServiceName = new QName("doService");
            SOAPBodyElement doService = soapBody.addBodyElement(doServiceName);
            doService.setPrefix("ocs");	  
            QName childName = new QName("http://ocs.ztesoft.com", "in0", "ocs");
            SOAPElement in0 = doService.addChildElement(childName);	  
            String recharge ="<![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "   <zsmart>\n" +
                    "      <Data>\n" +
                    "       <header>\n" +
                    "       <ACTION_ID>ModifyAllBalReturnAllBal</ACTION_ID>\n" +
                    "       <REQUEST_ID>006"+ amount+"</REQUEST_ID>\n" +
                    "       </header>\n" +
                    "       <body>\n" +
                    "         <MSISDN>"+ mpesaRefId +"</MSISDN>\n" +
                    "         <AccountCode></AccountCode>\n" +
                    "         <TransactionSN>"+ timeStamp +"</TransactionSN>\n" +
                    "         <RechargingID></RechargingID>\n" +
                    "         <BalInputDtoList>\n" +
                    "            <AcctResCode>1</AcctResCode>\n" +
                    "            <AcctResName></AcctResName>\n" +
                    "            <Balance></Balance>\n" +
                    "            <AddBalance>-"+ msisdn +"00</AddBalance>\n" +
                    "            <ExpDate></ExpDate>\n" +
                    "            <AddDays>1</AddDays>\n" +
                    "            </BalInputDtoList>\n" +
                    "       </body>\n" +
                    "       </Data>\n" +
                    "     </zsmart>\n" +
                    "]]>";     
            in0.addTextNode(recharge);   
        }
     public static HashMap<String, String>  callSoapWebService(String soapEndpointUrl, String soapAction, String mpesaRefId, String msisdn, String amount) throws SOAPException, IOException, Exception 
    {
        HashMap<String, String> main_balance = new HashMap<>(); 
        OcsBAChildElements childElements = new OcsBAChildElements(msisdn);
        try 
        {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            // Send SOAP Message to OCS Server and get response
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction, mpesaRefId, msisdn , amount), soapEndpointUrl);
            soapConnection.close();
            // Log the SOAP Response from OCS
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            soapResponse.writeTo(baos);
            logger.info("Logging the response from OCS");
            logger.info(baos);
            // Print the SOAP Response
            //System.out.println("Response SOAP Message Response:");
            //soapResponse.writeTo(System.out);
            //System.out.println();
            //SOAPBody sBody = soapResponse.getSOAPBody();
            //System.out.println("SoapResponse Body ----->" + sBody);
            QName doServiceName = new QName("http://ocs.ztesoft.com","doServiceResponse");            
            java.util.Iterator iterator = soapResponse.getSOAPBody().getChildElements(doServiceName);  
            while(iterator.hasNext())
            {
                SOAPBodyElement bElement = (SOAPBodyElement) iterator.next();
                String ocsResponse = bElement.getNodeName();//getValue();
                NodeList nodeList = bElement.getElementsByTagName("doServiceReturn");
                Element element = (Element) nodeList.item(0);
                Node child = element.getFirstChild();
                String characterData = element.getTextContent();
                main_balance = OcsBAChildElements.printChildElements(characterData);
              }
            }
        catch (Exception e) 
        {
            System.out.println(e);
            //printStackTrace();
        }
        return main_balance;
    }
}
