/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telkom.ocs.userprofile;

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
//import mobile.savings.app.Service.Balances;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ChildElements {

    public String returnValue, returnMsg, requestId, brandIndex;

    Connection con;

    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ChildElements.class.getName());

    public HashMap<String, String> printChildElements(String characterData) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, ParseException {

        String successStatus = "";
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

            topUpState.put("rc", returnValue);
            topUpState.put("rm", returnMsg);
            topUpState.put("ri", requestId);
            System.out.println(returnValue + "!!!!!!!!!!!!!!\n!!!!!!!!!!!!!!" + requestId);

            if (returnValue.equals("0")) {
                topUpState.put("flag", "0");
                NodeList nodeList2 = (NodeList) xPath.compile(subscriberInfo).evaluate(doc, XPathConstants.NODESET);
                for (int i = 0; i < nodeList2.getLength(); i++) {
                    //topUpState.put("bi", returnValue);
                    Node nNode = nodeList2.item(i);
                    Element eElement = (Element) nNode;
                    brandIndex = eElement.getElementsByTagName("BrandIndex").item(0).getTextContent();
                    //topUpState.put("bi", eElement.getElementsByTagName("BrandIndex").item(0).getTextContent());
                    topUpState.put("s", eElement.getElementsByTagName("State").item(0).getTextContent());
                }

                if (brandIndex.equals("9900")) {
                    topUpState.put("pp", "1");
                } else {
                    topUpState.put("pp", "0");
                }
            } else {
                // means failed
                topUpState.put("flag", "1");
            }

        } catch (ParserConfigurationException ex) {
            topUpState.put("flag", "1");
            logger.fatal("Could not reliably determine user profile. Error " + ex.getMessage());
        } catch (SAXException ex) {
            topUpState.put("flag", "1");
            logger.fatal("Could not reliably determine user profile. Error " + ex.getMessage());
        } catch (IOException ex) {
            topUpState.put("flag", "1");
            logger.fatal("Could not reliably determine user profile. Error " + ex.getMessage());
        } catch (XPathExpressionException ex) {
            topUpState.put("flag", "1");
            logger.fatal("Could not reliably determine user profile. Error " + ex.getMessage());
        }
        return topUpState;
    }
}
