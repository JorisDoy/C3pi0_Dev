// Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package com.huawei.cps.cpsinterface.c2bpayment.utils.ocs.balance;

/**
 *
 * @author mwangi
 */
//import com.ModUserIndiPricePlan.service.DB.DbConnection;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
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

    public String returnValue, msisdn;
    public String returnMsg = "";
    public String balance = "";
    private String exp_date;
    //Connection con;
    
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ChildElements.class.getName());

    public ChildElements(String msisdn) {
        this.msisdn = msisdn;
        //this.iuc = iuc;
    }

    public HashMap<String, String> printChildElements(String characterData) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, ParseException {

        String successStatus = "";
        String returnCodeExpression = "/zsmart/Data/header";
        String main_ballance = "/zsmart/Data/body/BalDtoList";
        //String validBalanceExpression = "/zsmart/Data/body/BalDtoList";
        HashMap<String, String> wallets = new HashMap<>();
        
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
                //returnMsg = eElement.getLastChild().getLastChild().getTextContent();
            }
            
            if (returnValue.equals("0")) {
                
                NodeList nodeList2 = (NodeList) xPath.compile(main_ballance).evaluate(doc, XPathConstants.NODESET);
                for (int i = 0; i < nodeList2.getLength(); i++) {
                    //Balance mybal = new Balance();
                    //HashMap<String, String> balances = new HashMap<>();
                    Node nNode = nodeList2.item(i);
                    Element eElement = (Element) nNode;
                    //String acctName = eElement.getElementsByTagName("AcctResName").item(0).getTextContent();
                    String acct_res_id = eElement.getElementsByTagName("AcctResID").item(0).getTextContent();
                    // check if AcctResName is 1 (Main balance)
                    if(acct_res_id.equals("1")){
                        exp_date = eElement.getElementsByTagName("ExpDate").item(0).getTextContent();
                        balance = eElement.getElementsByTagName("Balance").item(0).getTextContent();
                    } 
                   
                }
                wallets.put("balance", balance);
            } 
        } catch (ParserConfigurationException pce) {
            logger.fatal(pce.getMessage());
            //returnValue = pce.getMessage();
        } catch (SAXException se) {
            logger.fatal(se.getMessage());
            //returnValue += se.getMessage();
        } catch (IOException ioe) {
            logger.fatal(ioe.getMessage());
            //returnValue += ioe.getMessage();
        } catch (XPathExpressionException xpe) {
            logger.fatal(xpe.getMessage());
            //returnValue += xpe.getMessage();
        }

        return wallets;
        //return balance;
    }
}
