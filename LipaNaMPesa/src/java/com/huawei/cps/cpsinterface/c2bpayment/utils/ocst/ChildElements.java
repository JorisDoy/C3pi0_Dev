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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.text.ParseException;
import java.util.HashMap;
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

public class ChildElements {
    public String returnValue, returnMsg, requestId;
    
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ChildElements.class.getName());
    Connection con;


    public String printChildElements(String characterData) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, ParseException {

        String state = "", status = "";
        String returnCodeExpression = "/zsmart/Data/header";
        String subscriberInfo = "/zsmart/Data/body/UserProfileDto";
        //String validBalanceExpression = "/zsmart/Data/body/BalDtoList";
        HashMap<String, String> topUpState = new HashMap<>();
        
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            //System.out.println("\n Finished");

            dBuilder = dbFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(characterData.getBytes(StandardCharsets.UTF_8));
            Document doc = dBuilder.parse(stream);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();

            NodeList nodeList = (NodeList) xPath.compile(returnCodeExpression).evaluate(doc, XPathConstants.NODESET);

            //NodeList nodeList2 = (NodeList)xPath.compile(main_ballance).evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                //if(nNode.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) nNode;
                //System.out.println(eElement.getElementsByTagName("returnCode").item(0).getTextContent());
                returnValue = eElement.getElementsByTagName("returnCode").item(0).getTextContent();
                returnMsg = eElement.getElementsByTagName("returnMsg").item(0).getTextContent();
                requestId = eElement.getElementsByTagName("REQUEST_ID").item(0).getTextContent();
                //returnMsg = eElement.getLastChild().getLastChild().getTextContent();
                //System.out.println("\n Finished");
                //System.out.println(returnValue);
                //}
            }
            
            if (returnValue.equals("0")) {
                NodeList nodeList2 = (NodeList) xPath.compile(subscriberInfo).evaluate(doc, XPathConstants.NODESET);
                for (int i = 0; i < nodeList2.getLength(); i++) {
                    Node nNode = nodeList2.item(i);
                    Element eElement = (Element) nNode;
                    state = eElement.getElementsByTagName("State").item(0).getTextContent();
                }
            }             
             
        } catch (ParserConfigurationException ex) {
            //returnValue = pce.getMessage();
             logger.fatal(ex.getMessage());
        } catch (SAXException ex) {
            //returnValue += se.getMessage();
             logger.fatal(ex.getMessage());
        } catch (IOException ex) {
            //returnValue += ioe.getMessage();
            logger.fatal(ex.getMessage());
        } catch (XPathExpressionException ex) {
            //returnValue += xpe.getMessage();
            logger.fatal(ex.getMessage());
        }

        //ObjectReturned or = new ObjectReturned();
        // HashMap<String, String> or = new HashMap<>();
        // or.put("balance", balance);
//        Balance myBal = new Balance();
//        myBal.setBalanceName("MainBalance");
//        myBal.setBalanceValue(balance);
//
//        System.out.println("\n\n!!!!!!!!!!!!!!!!!!!!!!!!!\n" + balance + "\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        return state;
        //return balance;
    }
}