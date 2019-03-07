/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telkom.ocs.balance;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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

/**
 *
 * @author jdmwamburi
 */
public class OcsBAChildElements {
    public static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(OcsBAChildElements.class.getName());
    public static String returnValue, msisdn;
    public static String returnMsg = "";
    public static String balance = "";
    private static String exp_date;
    
    public OcsBAChildElements(String msisdn) 
    {
        this.msisdn = msisdn;
    }
    
    public static HashMap<String, String> printChildElements(String characterData) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, ParseException 
    {
        String returnCodeExpression = "/zsmart/Data/header";
        HashMap<String, String> wallets = new HashMap<>();
        try 
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(characterData.getBytes(StandardCharsets.UTF_8));
            Document doc = dBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList nodeList = (NodeList) xPath.compile(returnCodeExpression).evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node nNode = nodeList.item(i);
                Element eElement = (Element) nNode;
                returnValue = eElement.getElementsByTagName("returnCode").item(0).getTextContent();
                returnMsg = eElement.getElementsByTagName("returnMsg").item(0).getTextContent();
            }
            wallets.put("returnValue", returnValue);
            wallets.put("returnMsg", returnMsg);
        } 
        catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException pce) 
        {
            System.out.println(pce.getMessage());
            logger.error(pce.getMessage());
        }
        return wallets;
    } 
}
