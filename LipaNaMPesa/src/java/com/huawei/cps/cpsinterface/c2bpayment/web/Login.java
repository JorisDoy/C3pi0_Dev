/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.web;


import com.huawei.cps.cpsinterface.c2bpayment.utils.DomainLogin;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
//import com.mchange.v2.c3p0.PooledDataSource;

/**
 *
 * @author gaddafi
 */
@WebServlet
public class Login extends HttpServlet {

    private InitialContext ctx;
    private DataSource datasource;
    
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Login.class.getName());

    @Override
    public void init() {
        try {
            this.ctx = new InitialContext();
            if (ctx == null) {
                throw new Exception("No Context");
            }
            datasource = (org.apache.tomcat.jdbc.pool.DataSource) ctx.lookup("java:/comp/env/jdbc/reversal");
            if (datasource == null) {
                throw new Exception("No Context");
            }
        } catch (NamingException ex) {
            logger.fatal(ex.getMessage());
        } catch (Exception ex) {
            logger.fatal(ex.getMessage());
        }
    }

    // all gets will be treated as posts
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // enable session

        String command = req.getParameter("COMMAND");
        switch (command) {
            case "Login":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                // Check whether the credentials are accurate
                DomainLogin dl = new DomainLogin();
                RequestDispatcher dispatcher;
                if (dl.authenticate(username, password)) {
                    // send redirect to home                    
                    resp.sendRedirect("/pages/operator/home.jsp");
                } else {
                    req.setAttribute("message", "Domain credentials provided are not valid");
                    dispatcher = req.getRequestDispatcher("/index.jsp");
                    dispatcher.forward(req, resp);
                }
                break;
            default:
                resp.sendRedirect("/index.jsp");
        }
    }

    public synchronized void setSessionAttribute(HttpSession session, Map<String, String> userObject, String ussdSession) {
        session.setAttribute(ussdSession, userObject);
    }

    public synchronized Map<String, String> getSessionObject(HttpSession session, String ussdSession) {
        Map<String, String> sessionData = (Map<String, String>) session.getAttribute(ussdSession);

        return sessionData;
    }

    public synchronized void setGivenName(HttpSession session, String attribute_name, String attribute_value) {

    }

    public synchronized void removeSessionAttribute(HttpSession session, String ussdSession) {
        // Important mainly because there are only two ussd IPs which will not be unique for all MAs accessing the service
        session.removeAttribute(ussdSession);
    }
}
