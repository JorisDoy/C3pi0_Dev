// Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package com.huawei.cps.cpsinterface.c2bpayment.utils.ocst.BalTransfer;

/**
 *
 * @author mwangi
 */
//import com.ModUserIndiPricePlan.service.DB.DbConnection;
//import mobile.savings.app.ocs.Ballance.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
//import mobile.savings.app.Service.Balance;
//import mobile.savings.app.Service.Balances;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.joda.time.DateTime;
import org.joda.time.Days;
//import mobile.savings.app.Service.Balance;

public class ChildElements {

    public String returnValue, returnMsg, requestId;
    
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ChildElements.class.getName());
    
    Connection con;

//    public ChildElements(String msisdn) {
//        this.msisdn = msisdn;
//        //this.iuc = iuc;
//    }

    public HashMap<String, String> printChildElements(String characterData) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, ParseException {

        String successStatus = "";
        String returnCodeExpression = "/zsmart/Data/header";
        //String main_ballance = "/zsmart/Data/body/BalDtoList";
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
             
             
        } catch (ParserConfigurationException ex) {
            logger.fatal(ex.getMessage());
            //returnValue = pce.getMessage();
            topUpState.put("rc", "1");
             topUpState.put("rm", ex.getMessage());
             topUpState.put("ri", "");
        } catch (SAXException ex) {
            logger.fatal(ex.getMessage());
            //returnValue += se.getMessage();
            topUpState.put("rc", "1");
             topUpState.put("rm", ex.getMessage());
             topUpState.put("ri", "");
        } catch (IOException ex) {
            logger.fatal(ex.getMessage());
            //returnValue += ioe.getMessage();
            topUpState.put("rc", "1");
             topUpState.put("rm", ex.getMessage());
             topUpState.put("ri", "");
        } catch (XPathExpressionException ex) {
            logger.fatal(ex.getMessage());
            //returnValue += xpe.getMessage();
            topUpState.put("rc", "1");
             topUpState.put("rm", ex.getMessage());
             topUpState.put("ri", "");
        }

        //ObjectReturned or = new ObjectReturned();
        // HashMap<String, String> or = new HashMap<>();
        // or.put("balance", balance);
//        Balance myBal = new Balance();
//        myBal.setBalanceName("MainBalance");
//        myBal.setBalanceValue(balance);
//
//        System.out.println("\n\n!!!!!!!!!!!!!!!!!!!!!!!!!\n" + balance + "\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        return topUpState;
        //return balance;
    }
}
