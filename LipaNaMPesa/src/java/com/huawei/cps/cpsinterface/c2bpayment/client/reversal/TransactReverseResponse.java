/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.client.reversal;

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


/**
 *
 * @author gaddafi
 */
public class TransactReverseResponse {
    private String response_code, response_desc, conversation_id, originator_conversation_id, service_status;
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TransactReverseResponse.class.getName());
    public HashMap<String, String> printChildElements(String character_data) {
        HashMap<String, String> service_res = new HashMap<>();
        String returnCodeExpression = "/response";
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(character_data.getBytes(StandardCharsets.UTF_8));
            Document doc = dBuilder.parse(stream);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();

            NodeList nodeList = (NodeList) xPath.compile(returnCodeExpression).evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                Element eElement = (Element) nNode;
                response_code = eElement.getElementsByTagName("ResponseCode").item(0).getTextContent();
                response_desc = eElement.getElementsByTagName("ResponseDesc").item(0).getTextContent();
                conversation_id = eElement.getElementsByTagName("ConversationID").item(0).getTextContent();
                originator_conversation_id = eElement.getElementsByTagName("OriginatorConversationID").item(0).getTextContent();
                service_status = eElement.getElementsByTagName("ServiceStatus").item(0).getTextContent();
                // set HashMap values
                service_res.put("is_success", "0");

            }
            if(!service_res.containsKey("is_success")){
                service_res.put("is_success", "1");
            }
            service_res.put("rc", response_code);
            service_res.put("rd", response_desc);
            service_res.put("ci", conversation_id);
            service_res.put("oci", originator_conversation_id);
            service_res.put("ss", service_status);
        } catch (Exception ex) {
            System.out.println("!!!!! An error occured!... error message: " + ex.getMessage());
            service_res.put("is_success", "1");
        }
        return service_res;
    }
}
