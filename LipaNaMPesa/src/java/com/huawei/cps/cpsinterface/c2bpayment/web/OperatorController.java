/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.web;

import com.huawei.cps.cpsinterface.c2bpayment.utils.db.Selects;
import com.huawei.cps.cpsinterface.c2bpayment.utils.ocs.balance.OcsClient;
import com.huawei.cps.cpsinterface.c2bpayment.web.pojos.AirtimePurchaseInfo;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;
import javax.xml.xpath.XPathExpressionException;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

/**
 *
 * @author gaddafi
 */
public class OperatorController extends HttpServlet {

    private final Logger logger = Logger.getLogger(OperatorController.class.getName());

    private DataSource datasource;
    private InitialContext ctx;

    @Override
    public void init() {
        try {
            this.ctx = new InitialContext();
            if (ctx == null) {
                throw new Exception("No Context");
            }
            datasource = (org.apache.tomcat.jdbc.pool.DataSource) ctx.lookup("java:/comp/env/jdbc/telkom_buy_airtime");
            if (datasource == null) {
                logger.fatal("No Context for Database Context!!!!!!!!");
            }
        } catch (NamingException ex) {
            logger.fatal(ex.getMessage());
        } catch (Exception ex) {
            logger.fatal(ex.getMessage());
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req, resp);
    }

    /**
     *
     * @param req
     * @param resp
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession aHttpSession = req.getSession(true);
        HashMap<String, String> userSessionData = (HashMap<String, String>) aHttpSession.getAttribute("userSession");
        if (userSessionData == null) {
            try {
                // redirect to login page
                resp.sendRedirect("../index.jsp");
            } catch (IOException ex) {
                logger.error(ex.getMessage(), ex);
            }
        }
        String command = req.getParameter("COMMAND");
        switch (command) {
            case "ABCD":
                useAll(req, resp);
                break;
            case "AB":
                getAB(req, resp);
                break;
            case "AC":
                getAC(req, resp);
                break;
            case "AD":
                getAD(req, resp);
                break;
            case "ABC":
                getABC(req, resp);
                break;
            case "ACD":
                getACD(req, resp);
                break;
            case "A":
                getA(req, resp);
                break;
            case "BCD":
                getBCD(req, resp);
                break;
            case "B":
                getB(req, resp);
                break;
            case "BC":
                getBC(req, resp);
                break;
            case "BD":
                getBD(req, resp);
                break;
            case "CD":
                getCD(req, resp);
                break;
            case "C":
                getC(req, resp);
                break;
            case "D":
                getD(req, resp);
                break;
            case "reverse":
                reverse(req, resp);
                break;
            default:
                break;
        }

    }

    public void useAll(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String receipt = req.getParameter("receipt").trim();
            String safno = req.getParameter("safno").trim();
            String tklno = req.getParameter("tklno").trim();
            String tdate = req.getParameter("tdate").trim();
            // get the paybill transaction
            Selects sel = new Selects();
            DateFormat df = new SimpleDateFormat("MM/dd/yy");
            Date ufDate = (Date) df.parse(tdate);
            df = new SimpleDateFormat("yyyyMMdd");
            String transaction_date = df.format(ufDate);
            // DataSource datasource, String receipt_number, String saf_num, String tkl_num, String trans_date
            List<AirtimePurchaseInfo> purchase_info = sel.getUsingAll(datasource, receipt, safno, tklno, transaction_date);
            req.setAttribute("purchase", purchase_info);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/operator/home.jsp");
            dispatcher.forward(req, resp);
        } catch (ParseException ex) {
            logger.error(ex.getMessage());
            //java.util.logging.Logger.getLogger(OperatorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            //java.util.logging.Logger.getLogger(OperatorController.class.getName()).log(Level.SEVERE, null, ex);
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            //java.util.logging.Logger.getLogger(OperatorController.class.getName()).log(Level.SEVERE, null, ex);
            logger.error(ex.getMessage());
        }
    }

    public void getAB(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String receipt = req.getParameter("receipt").trim();
            String safno = req.getParameter("safno").trim();
            Selects sel = new Selects();
            List<AirtimePurchaseInfo> purchase_info = sel.getAB(datasource, receipt, safno);
            req.setAttribute("purchase", purchase_info);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/operator/home.jsp");
            dispatcher.forward(req, resp);
        } catch (ServletException ex) {
            //java.util.logging.Logger.getLogger(OperatorController.class.getName()).log(Level.SEVERE, null, ex);
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            //java.util.logging.Logger.getLogger(OperatorController.class.getName()).log(Level.SEVERE, null, ex);
            logger.error(ex.getMessage());
        }
    }

    public void getAC(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String receipt = req.getParameter("receipt").trim();
            String tklno = req.getParameter("tklno").trim();
            Selects sel = new Selects();
            List<AirtimePurchaseInfo> purchase_info = sel.getAC(datasource, receipt, tklno);
            req.setAttribute("purchase", purchase_info);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/operator/home.jsp");
            dispatcher.forward(req, resp);
        } catch (ServletException ex) {
            //java.util.logging.Logger.getLogger(OperatorController.class.getName()).log(Level.SEVERE, null, ex);
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            //java.util.logging.Logger.getLogger(OperatorController.class.getName()).log(Level.SEVERE, null, ex);
            logger.error(ex.getMessage());
        }
    }

    public void getAD(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String receipt = req.getParameter("receipt").trim();
            String tdate = req.getParameter("tdate").trim();
            Selects sel = new Selects();

            //Selects sel = new Selects();
            DateFormat df = new SimpleDateFormat("MM/dd/yy");
            Date ufDate = (Date) df.parse(tdate);
            df = new SimpleDateFormat("yyyyMMdd");
            String transaction_date = df.format(ufDate);
            List<AirtimePurchaseInfo> purchase_info = sel.getAD(datasource, receipt, transaction_date);
            req.setAttribute("purchase", purchase_info);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/operator/home.jsp");
            dispatcher.forward(req, resp);
        } catch (ParseException ex) {
            //java.util.logging.Logger.getLogger(OperatorController.class.getName()).log(Level.SEVERE, null, ex);
            logger.error(ex.getMessage());
        } catch (ServletException ex) {
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void getABC(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String receipt = req.getParameter("receipt").trim();
            String safno = req.getParameter("safno").trim();
            String tklno = req.getParameter("tklno").trim();
            Selects sel = new Selects();
            List<AirtimePurchaseInfo> purchase_info = sel.getABC(datasource, receipt, safno, tklno);
            req.setAttribute("purchase", purchase_info);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/operator/home.jsp");
            dispatcher.forward(req, resp);
        } catch (ServletException ex) {
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void getACD(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String receipt = req.getParameter("receipt").trim();
            //String safno = req.getParameter("safno").trim();
            String tklno = req.getParameter("tklno").trim();
            String tdate = req.getParameter("tdate").trim();
            DateFormat df = new SimpleDateFormat("MM/dd/yy");
            Date ufDate = (Date) df.parse(tdate);
            df = new SimpleDateFormat("yyyyMMdd");
            String transaction_date = df.format(ufDate);
            Selects sel = new Selects();
            List<AirtimePurchaseInfo> purchase_info = sel.getACD(datasource, receipt, tklno, transaction_date);
            req.setAttribute("purchase", purchase_info);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/operator/home.jsp");
            dispatcher.forward(req, resp);
        } catch (ParseException ex) {
            logger.error(ex.getMessage());
        } catch (ServletException ex) {
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void getA(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String receipt = req.getParameter("receipt").trim();
            Selects sel = new Selects();
            List<AirtimePurchaseInfo> purchase_info = sel.getA(datasource, receipt);
            req.setAttribute("purchase", purchase_info);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/operator/home.jsp");
            dispatcher.forward(req, resp);
        } catch (ServletException ex) {
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void getBCD(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String safno = req.getParameter("safno").trim();
            String tklno = req.getParameter("tklno").trim();
            String tdate = req.getParameter("tdate").trim();
            DateFormat df = new SimpleDateFormat("MM/dd/yy");
            Date ufDate = (Date) df.parse(tdate);
            df = new SimpleDateFormat("yyyyMMdd");
            String transaction_date = df.format(ufDate);
            Selects sel = new Selects();
            List<AirtimePurchaseInfo> purchase_info = sel.getBCD(datasource, safno, tklno, transaction_date);
            req.setAttribute("purchase", purchase_info);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/operator/home.jsp");
            dispatcher.forward(req, resp);
        } catch (ParseException ex) {
            logger.error(ex.getMessage());
        } catch (ServletException ex) {
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void getB(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String safno = req.getParameter("safno").trim();
            Selects sel = new Selects();
            List<AirtimePurchaseInfo> purchase_info = sel.getB(datasource, safno);
            req.setAttribute("purchase", purchase_info);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/operator/home.jsp");
            dispatcher.forward(req, resp);
        } catch (ServletException ex) {
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void getBC(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String safno = req.getParameter("safno").trim();
            String tklno = req.getParameter("tklno").trim();
            Selects sel = new Selects();
            List<AirtimePurchaseInfo> purchase_info = sel.getBC(datasource, safno, tklno);
            req.setAttribute("purchase", purchase_info);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/operator/home.jsp");
            dispatcher.forward(req, resp);
        } catch (ServletException ex) {
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void getBD(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String safno = req.getParameter("safno").trim();
            String tdate = req.getParameter("tdate").trim();
            DateFormat df = new SimpleDateFormat("MM/dd/yy");
            Date ufDate = (Date) df.parse(tdate);
            df = new SimpleDateFormat("yyyyMMdd");
            String transaction_date = df.format(ufDate);
            Selects sel = new Selects();
            List<AirtimePurchaseInfo> purchase_info = sel.getBD(datasource, safno, transaction_date);
            req.setAttribute("purchase", purchase_info);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/operator/home.jsp");
            dispatcher.forward(req, resp);
        } catch (ParseException ex) {
            logger.error(ex.getMessage());
        } catch (ServletException ex) {
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void getCD(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String tklno = req.getParameter("tklno").trim();
            String tdate = req.getParameter("tdate").trim();
            DateFormat df = new SimpleDateFormat("MM/dd/yy");
            Date ufDate = (Date) df.parse(tdate);
            df = new SimpleDateFormat("yyyyMMdd");
            String transaction_date = df.format(ufDate);
            Selects sel = new Selects();
            List<AirtimePurchaseInfo> purchase_info = sel.getCD(datasource, tklno, transaction_date);
            req.setAttribute("purchase", purchase_info);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/operator/home.jsp");
            dispatcher.forward(req, resp);
        } catch (ParseException ex) {
            logger.error(ex.getMessage());
        } catch (ServletException ex) {
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void getC(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String tklno = req.getParameter("tklno").trim();
            Selects sel = new Selects();
            List<AirtimePurchaseInfo> purchase_info = sel.getC(datasource, tklno);
            req.setAttribute("purchase", purchase_info);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/operator/home.jsp");
            dispatcher.forward(req, resp);
        } catch (ServletException ex) {
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void getD(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String tdate = req.getParameter("tdate").trim();
            DateFormat df = new SimpleDateFormat("MM/dd/yy");
            Date ufDate = (Date) df.parse(tdate);
            df = new SimpleDateFormat("yyyyMMdd");
            String transaction_date = df.format(ufDate);
            Selects sel = new Selects();
            List<AirtimePurchaseInfo> purchase_info = sel.getD(datasource, transaction_date);
            req.setAttribute("purchase", purchase_info);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/operator/home.jsp");
            dispatcher.forward(req, resp);
        } catch (ParseException ex) {
            logger.error(ex.getMessage());
        } catch (ServletException ex) {
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void reverse(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String amount = req.getParameter("amount").trim();
            String msisdn = req.getParameter("tklno");
            // Check if customer has the right balance
            OcsClient oc = new OcsClient();
            HashMap<String, String> balance = oc.request(msisdn.replaceAll("^0", "254"));
            float customer_balance = Float.parseFloat(balance.get("balance"))/100;
            float purchased_amount = Float.parseFloat(amount);
            
            if(customer_balance >= purchased_amount){
                // reverse it
            } else {
                // failed reversal
            }
        } catch (SOAPException ex) {
            java.util.logging.Logger.getLogger(OperatorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            java.util.logging.Logger.getLogger(OperatorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            java.util.logging.Logger.getLogger(OperatorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            java.util.logging.Logger.getLogger(OperatorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(OperatorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(OperatorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
