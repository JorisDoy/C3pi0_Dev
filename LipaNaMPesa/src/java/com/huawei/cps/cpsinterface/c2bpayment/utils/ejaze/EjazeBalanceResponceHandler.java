/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.utils.ejaze;

import com.huawei.cps.cpsinterface.c2bpayment.utils.ejaze.ResponsePojos.Balance;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author gaddafi
 */
public class EjazeBalanceResponceHandler {
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EjazeBalanceResponceHandler.class.getName());

    public Balance responseResultStatus(String response_payload) {
        Balance bal = new Balance();
        //boolean is_successful = false;

        String txn_status = "", balance = "";
        String xpath_root = "/COMMAND";
        String xpath_balance = "/COMMAND/DATA/RECORD";

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setAttribute("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder;

            dBuilder = dbFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(response_payload.getBytes(StandardCharsets.UTF_8));
            Document doc = dBuilder.parse(stream);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();

            NodeList nodeList = (NodeList) xPath.compile(xpath_root).evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                Element eElement = (Element) nNode;
                txn_status = eElement.getElementsByTagName("TXNSTATUS").item(0).getTextContent();
                
                //txn_status = eElement.getElementsByTagName("TXNID").item(0).getTextContent();
                //balance = eElement.getElementsByTagName("MESSAGE").item(0).getTextContent();
            }
            bal.setTXNSTATUS(txn_status);

            if (txn_status.equals("200")) {
                // Successful topup
                bal.setIsSuccessful(true);
                // get the balance
                NodeList nodeList2 = (NodeList) xPath.compile(xpath_balance).evaluate(doc, XPathConstants.NODESET);
                for (int i = 0; i < nodeList2.getLength(); i++) {
                    Node nNode = nodeList.item(i);
                    Element eElement = (Element) nNode;
                    balance = eElement.getElementsByTagName("BALANCE").item(0).getTextContent();                    
                }
                bal.setBALANCE(Float.parseFloat(balance));
            } else {
                bal.setIsSuccessful(false);
                bal.setTXNSTATUS(txn_status);
            }
            
            

//            System.out.println(txn_status);
//            System.out.println(txn_id);
//            System.out.println(message);
        } catch (ParserConfigurationException ex) {
            logger.fatal(ex.getMessage());
            //returnValue = pce.getMessage();
            //System.out.println(ex.getMessage());
            bal.setIsSuccessful(false);
        } catch (SAXException ex) {
            //returnValue += se.getMessage();
            logger.fatal(ex.getMessage());
            //System.out.println(ex.getMessage());
            bal.setIsSuccessful(false);
        } catch (IOException ex) {
            logger.fatal(ex.getMessage());
            //returnValue += ioe.getMessage();
            //System.out.println(ex.getMessage());
            bal.setIsSuccessful(false);
        } catch (XPathExpressionException ex) {
            logger.fatal(ex.getMessage());
            //returnValue += xpe.getMessage();
            //System.out.println(ex.getMessage());
            bal.setIsSuccessful(false);
        }

        return bal;
    }
}
