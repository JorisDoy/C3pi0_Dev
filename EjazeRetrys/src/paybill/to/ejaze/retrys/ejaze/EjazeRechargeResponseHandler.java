/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paybill.to.ejaze.retrys.ejaze;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author jdmwamburi
 */
public class EjazeRechargeResponseHandler {
    private static final Logger logger = Logger.getLogger(EjazeRechargeResponseHandler.class.getName());
    public Recharge responseResultStatus(String response_payload){
    Recharge recharge = new Recharge();
        String txn_status = "", txn_id = "", message = "";
        String xpath_expression = "/COMMAND";
        
        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setAttribute("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder;
            
            dBuilder = dbFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(response_payload.getBytes(StandardCharsets.UTF_8));
            Document doc = dBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            
            XPath xPath = XPathFactory.newInstance().newXPath();
            
            NodeList nodeList = (NodeList) xPath.compile(xpath_expression).evaluate(doc, XPathConstants.NODESET);
            
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                Element eElement = (Element) nNode;
                txn_status = eElement.getElementsByTagName("TXNSTATUS").item(0).getTextContent();
                txn_id = eElement.getElementsByTagName("TXNID").item(0).getTextContent();
                message = eElement.getElementsByTagName("MESSAGE").item(0).getTextContent();
                
            }
            
            if(txn_status.equals("200")){
                // Successful topup
                //is_successful = true;
                recharge.setIsSuccessful(true);
                recharge.setTXNID(txn_id);
                recharge.setTXNSTATUS(txn_status);
                recharge.setTXNMESSAGE(message);
            } else{
                recharge.setIsSuccessful(false);
                recharge.setTXNSTATUS(txn_status);
                recharge.setTXNID(txn_id);
                recharge.setTXNMESSAGE(message);
            }
            
        } 
        catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException ex) 
        {
             logger.fatal(ex.getMessage());
             recharge.setIsSuccessful(false);             
        }
        return recharge;
    }
}
