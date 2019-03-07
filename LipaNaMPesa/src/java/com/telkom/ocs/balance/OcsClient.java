// Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package com.telkom.ocs.balance;

/**
 *
 * @author mwangi
 */


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
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
import javax.xml.soap.MimeHeaders;
import javax.xml.xpath.XPathExpressionException;
//import mobile.savings.app.Service.Balance;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
//import mobile.savings.app.Service.Balance;

public class OcsClient {
    
    public int reqID, tranSN;
    //public ObjectReturned returnMessage;
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(OcsClient.class.getName());
    
    public OcsClient(){
        int reqId = (int) (Math.random() * 100000);
        int tranSN = (int) (Math.random() * 10000);
        this.reqID = reqId;
        this.tranSN = tranSN;
    }
    
    public HashMap<String, String> request(String msisdn) throws SOAPException, MalformedURLException, XPathExpressionException, ParserConfigurationException, SAXException, IOException, ParseException {
        //Balance main_balance = null;
        
        HashMap<String, String> main_balance = new HashMap<>(); 
        ChildElements childElements = new ChildElements(msisdn);
        MessageFactory factory = MessageFactory.newInstance(/*SOAPConstants.SOAP_1_2_PROTOCOL*/);
        SOAPMessage message = factory.createMessage();
        
        // Get the SOAP Part
        SOAPPart soapPart = message.getSOAPPart();
        
        // Get the envelope, header, body from the soapPart (This are the main parts of any SOAP)
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.removeAttributeNS("http://www.w3.org/2003/05/soap-envelope", "env");
        envelope.removeNamespaceDeclaration(envelope.getPrefix());
        envelope.addNamespaceDeclaration("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
        envelope.addNamespaceDeclaration("ocs","http://ocs.ztesoft.com");
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
        SOAPElement userName =  authHeader.addChildElement(headerChild);
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
        
        String bundles = "<![CDATA[\n" +
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<zsmart>\n" +
            "   <Data>\n" +
            "    <header>\n" +
            "      <ACTION_ID>QueryAcctBal</ACTION_ID>\n" +
            "      <REQUEST_ID>003QA20" + reqID + "</REQUEST_ID>\n" +
            "    </header>\n" +
            "    <body>\n" +
            "      <MSISDN>" + msisdn +"</MSISDN>\n" +
            "      <AccountCode></AccountCode>\n" +
            "      <VPNID></VPNID>\n" +
            "    </body>\n" +
            "  </Data>\n" +
            "</zsmart>\n" +
            "]]>";
        
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
        doServiceName = new QName("http://ocs.ztesoft.com","doServiceResponse");
        //QName doServiceReturn = new QName("http://ocs.ztesoft.com", "doServiceResponse");
        //sBody.getElementQName();
        
        java.util.Iterator iterator = sBody.getChildElements(doServiceName);
        while(iterator.hasNext()){
            SOAPBodyElement bElement = (SOAPBodyElement) iterator.next();
        
            String ocsResponse = bElement.getValue();
            //System.out.println(ocsResponse);
            
            NodeList nodeList = sBody.getElementsByTagName("doServiceReturn");
            Element element = (Element) nodeList.item(0);
            Node child = element.getFirstChild();
            String characterData;
            
            if(child instanceof CharacterData){
                characterData = ((CharacterData)child).getData();
                //System.out.println(characterData);
                main_balance = childElements.printChildElements(characterData);
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n\n\n"
                        + characterData + "\n\n\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
        }
        
        return main_balance;
    }
}
