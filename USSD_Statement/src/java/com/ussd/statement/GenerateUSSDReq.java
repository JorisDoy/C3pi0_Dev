/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ussd.statement;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ProtocolException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
/**
 *
 * @author jdmwamburi
 */
/**
 * Servlet implementation class Hello
 */
@WebServlet("/statement")
public class GenerateUSSDReq extends HttpServlet {	
    private static final long serialVersionUID = 1L;
    static Logger log = Logger.getLogger(GenerateUSSDReq.class.getName());
    private String msisdn =null;
    public GenerateUSSDReq() {
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        int NTHREDS=10;
        PrintWriter aPW = response.getWriter();
        USSDNavigation usNav = new USSDNavigation();
        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        //usNav.ussdNavEnd(aPW, "This service is currently under maintenance . Please try again later");
        
        try {
            StatementH2DAO h2db = new StatementH2DAO();
            h2db.createH2DB();
            StatementOracleDAO oracleDb=new StatementOracleDAO() ;
            USSDSessionManager sm= new USSDSessionManager();            
            SendSMS _sms = new SendSMS();            
            response.setContentType("text/xml");	
            HttpSession aHttpSession = request.getSession(true);
            aHttpSession.setMaxInactiveInterval(300000);
            msisdn = request.getHeader("User-MSISDN");
            String UssdSessionID= sm.CreateSession(msisdn,request.getHeader("http_gateway-session_ID"));
            Enumeration<String> parameterNames = request.getParameterNames();
            String inputParam="";
            while (parameterNames.hasMoreElements()) {
                inputParam = parameterNames.nextElement();
            }
        /*if(msisdn.equals("254770233442")||msisdn.equals("254770224574")||msisdn.equals("254771200000")) { */
        //Check if registered and start registration process
            if(h2db.checkifReg(msisdn)==null||h2db.checkifReg(msisdn).isEmpty()) {
                if(!h2db.isSessionActive(UssdSessionID,msisdn)){
                    h2db.updateSessionStatus(msisdn,UssdSessionID);
                    h2db.createSession(msisdn,UssdSessionID);
                    usNav.ussdContinueSession(aPW, "To register to T-kash statements,please enter your National ID or Document of Registration Number","id_no");
                    log.info(msisdn+":NOT Registered, Starting Registration Proccess" );
                }
                else{
                    switch(inputParam){
                        case "id_no":
                            String id_no = request.getParameter("id_no");
                            if(UssdSessionID.equals(h2db.getCurrentSession(msisdn))){ 
                                h2db.saveUSSDParams(msisdn,UssdSessionID,inputParam,id_no);
                                log.info(msisdn+":ID No entered:"+id_no);
                                usNav.ussdContinueSession(aPW, "Enter E-Mail Address(example: xyz@abc.com)","email");
                                break;                                               
                            }
                        case "email":
                            String email = request.getParameter("email");
                            log.info(msisdn+":Email entered:"+email);
                            if(isValidEmailAddress(email)!=true) {
                                usNav.ussdContinueSession(aPW, "Invalid Email address. <br />Enter E-Mail Address(example: xyz@abc.com)","email");
                                log.warn(msisdn+":Invalid Email entered");
                                break;
                            }else {
                                h2db.saveUSSDParams(msisdn,UssdSessionID,inputParam,email);
                                usNav.ussdContinueSession(aPW, "Confirm E-mail address","retype_email");
                                log.info(msisdn+":Re-entering Email");
                                break;
                            }
                        case "retype_email":
                                String v_mail = h2db.getUSSDParams(UssdSessionID,msisdn,"email");
                                String retype_email = request.getParameter("retype_email");
                                log.info(msisdn+":Email Confirmation:"+v_mail);
                                if(v_mail.equals(retype_email)) {
                                    h2db.saveUSSDParams(msisdn,UssdSessionID,inputParam,retype_email);
                                    String notify = "Your details have been successfully captured. Please wait for SMS confirmation";
                                    
                                   
                                   
                                    Callable ussdNotifyWorker = new Callable(){
                                        @Override
                                        public  Object call() throws Exception {
                                            usNav.ussdNavEnd(aPW, notify);
                                            return msisdn+":[Worker] USSD Notification Done ....";
                                        }
                                    };                
                                Future<Integer> ussdNotifyFuture = executor.submit(ussdNotifyWorker); 
                                    
                                    
                                    Callable accountValidationWorker = new Callable(){
                                        @Override
                                        public   Object call() throws Exception {
                                            String callableMessage=null;
                                            String sms;
                                            String v_id_no = h2db.getUSSDParams(UssdSessionID,msisdn,"id_no");
                                            String v_mail = h2db.getUSSDParams(UssdSessionID,msisdn,"retype_email");
                                            if(oracleDb.validateIDNo(msisdn,v_id_no)){
                                                sms="You have successfully registered to receive your T-kash statement by the 5th day of every month. "
                                                        + "Your 6 months statement will be sent to you shortly.";
                                                h2db.createStatementReg(msisdn, v_id_no, v_mail);
                                                oracleDb.createStatementRequest(msisdn, v_mail, "USSD", 6); //Log 6 Months request
                                                log.info(msisdn+":SUCCESS!! Registration Completed!!");
                                            }else{
                                                sms="Sorry.Your registration for T-kash statement failed. The ID details entered do not match our records. Please try again with the correct ID Number";
                                                log.warn(msisdn+":WARNING!! Invalid ID Number entered!!");
                                            }
                                            _sms.sendSMS(msisdn, sms);
                                            callableMessage=msisdn+":[Worker]Done Account Validation ...";
                                            return callableMessage;
                                        }
                                    }; 
                                    Future<Integer> accountValidationFuture = executor.submit(accountValidationWorker); 
                                    
                                    log.info(ussdNotifyFuture.get());
                                    log.info(accountValidationFuture.get());                                
                                    break;
                                }
                                else {
                                    usNav.ussdContinueSession(aPW, "Failed. The e-mail addresses you provided did not match.Press 1 to enter your e-mail address or 0 to exit","correct_email");
                                    log.warn(msisdn+":Email enterd not Matching");
                                    break;
                                }
                        case "correct_email":
                            if(request.getParameter("correct_email").equals("1")) {
                                usNav.ussdContinueSession(aPW, "Enter E-Mail Address(example: xyz@abc.com)","email");
                                break;
                                }else if(request.getParameter("correct_email").equals("0")) {
                                    usNav.ussdNavEnd(aPW, "Thank you for staying connected to Telkom");
                                    break;
                                }else{
                                    usNav.ussdContinueSession(aPW, "Invalid response.Try again.<br />Failed. The e-mail addresses you provided did not match.Press 1 to enter "
                                                                        + "your e-mail address or 0 to exit","correct_email");
                                    log.warn(msisdn+":Email enterd not Matching");
                                    break;
                                }
                        default:   
                    }
                }                     
            }
            else {       
                //If Already registered, start Statement request process
                if(!h2db.isSessionActive(UssdSessionID,msisdn)){
                    log.info(msisdn+":Aready Registered, starting Statement request Process");
                    h2db.updateSessionStatus(msisdn,UssdSessionID);
                    h2db.createSession(msisdn,UssdSessionID);
                    usNav.ussdContinueSession(aPW, "T-KASH STATEMENTS"
                                            + "<br />1: Full statement"
                                            + "<br />2: Change Email"
                                            + "<br />3: Opt Out","stm_type_exist");
                }
                else{
                    switch(inputParam) {
                        case "stm_type_exist":
                            if(request.getParameter("stm_type_exist").equals("1")) {
                                usNav.ussdContinueSession(aPW,"Select from statement periods below:"
                                                        + "<br />1: Last 3 Months"
                                                        + "<br />2: Last 6 Months"
                                                        + "<br />3: Last 12 Months","stm_period");
                                        
                                log.info(msisdn+":Selecting Statement Period..");
                                break;
                            }else if(request.getParameter("stm_type_exist").equals("2")) {   
                                usNav.ussdContinueSession(aPW,"Enter your new E-mail address","new_email");
                                log.info(msisdn+":Changing email");
                                break;
                            }
                            else if(request.getParameter("stm_type_exist").equals("3")) {
                                usNav.ussdContinueSession(aPW,"Are you sure you want to Opt Out of T-kash Statement Service?"
                                                        + "<br />1: Yes"
                                                        + "<br />2: No"
                                                        ,"opt_out");
                                log.info(msisdn+":Opting Out");
                                break;
                            }else {
                            usNav.ussdContinueSession(aPW,"Invalid response.Try again.<br />T-KASH STATEMENTS"
                                                        + "<br />1: Full statement"
                                                        + "<br />2: Change Email"
                                                     + "<br />3: Opt Out","stm_type_exist");	 
                                break;
                            }
                        case "stm_period":
                            String confirmation="Your request for T-kash Statement has been received and being processed. Please wait for an SMS Confirmation";
                            if(request.getParameter("stm_period").equals("1")) {
                                Callable ussdNotifyWorker3Months = new Callable(){
                                        @Override
                                        public synchronized Object call() throws Exception {
                                            usNav.ussdNavEnd(aPW, confirmation);
                                            return msisdn+":[Worker] USSD Notification Done ....";
                                        }
                                    }; 
                                
                                Callable logRequestWorker3Months = new Callable(){
                                        @Override
                                        public synchronized Object call() throws Exception {
                                            String callableMessage="";
                                            oracleDb.createStatementRequest(msisdn, h2db.checkifReg(msisdn), "USSD", 3);
                                            callableMessage=msisdn+":[Worker] Statement Request for  3 Months  Logged  ....";
                                                return callableMessage;
                                            }
                                    }; 
                                
                                
                                Future<Integer> ussdNotifyFuture3Months = executor.submit(ussdNotifyWorker3Months);    
                                Future<Integer> logRequestsFuture3Months = executor.submit(logRequestWorker3Months); 
                                
                                log.info(ussdNotifyFuture3Months.get());
                                log.info(logRequestsFuture3Months.get());   
                                break;
                            }
                            else if(request.getParameter("stm_period").equals("2")) {
                                Callable ussdNotifyWorker6Months = new Callable(){
                                        @Override
                                        public synchronized Object call() throws Exception {
                                            usNav.ussdNavEnd(aPW, confirmation);
                                            return msisdn+":[Worker] USSD Notification Done ....";
                                        }
                                    }; 
                                
                                Callable logRequestWorker6Months = new Callable(){
                                        @Override
                                        public synchronized Object call() throws Exception {
                                            String callableMessage="";
                                            oracleDb.createStatementRequest(msisdn, h2db.checkifReg(msisdn), "USSD", 6);
                                            callableMessage=msisdn+":[Worker] Statement Request for 6 Months Logged  ....";
                                                return callableMessage;
                                            }
                                    }; 
                                
                                
                                Future<Integer> ussdNotifyFuture6Months = executor.submit(ussdNotifyWorker6Months);    
                                Future<Integer> logRequestsFuture6Months = executor.submit(logRequestWorker6Months);                                 
                                log.info(ussdNotifyFuture6Months.get());
                                log.info(logRequestsFuture6Months.get());  
                                break;
                            }
                            else if(request.getParameter("stm_period").equals("3")) {
                                Callable ussdNotifyWorker12Months = new Callable(){
                                        @Override
                                        public synchronized Object call() throws Exception {
                                            usNav.ussdNavEnd(aPW, confirmation);
                                            return msisdn+":[Worker] USSD Notification Done ....";
                                        }
                                    }; 
                                
                                Callable logRequestWorker12Months = new Callable(){
                                        @Override
                                        public synchronized Object call() throws Exception {
                                            String callableMessage="";
                                            oracleDb.createStatementRequest(msisdn, h2db.checkifReg(msisdn), "USSD", 12);
                                            callableMessage=msisdn+":[Worker] Statement Request for 12 Months Logged  ....";
                                                return callableMessage;
                                            }
                                    }; 
                                Future<Integer> ussdNotifyFuture12Months = executor.submit(ussdNotifyWorker12Months);    
                                Future<Integer> logRequestsFuture12Months = executor.submit(logRequestWorker12Months); 
                                
                                log.info(ussdNotifyFuture12Months.get());
                                log.info(logRequestsFuture12Months.get());     
                                break;
                            }else{
                                usNav.ussdContinueSession(aPW,"Invalid response.Try again.<br /> Select from statement periods below:"
                                                + "<br />1: Last 3 Months"
                                                + "<br />2: Last 6 Months"
                                                + "<br />3: Last 12 Months","stm_period");	 break;
                                    }
                                case "new_email":
                                    String email = request.getParameter("new_email");
                                    if(isValidEmailAddress(email)!=true) {
                                        usNav.ussdContinueSession(aPW,"Invalid Email address. <br />Enter E-Mail Address(example: xyz@abc.com)","new_email");
                                        log.warn(msisdn+":Changing email -Invalid Email "+email);
                                        break;
                                    }else {
                                        h2db.saveUSSDParams(msisdn,UssdSessionID,inputParam,email);
                                        usNav.ussdContinueSession(aPW,"Confirm your new E-mail address","confirm_new_email");
                                        log.info(msisdn+":Changing email -Correct Email entered "+email);
                                        break;
                                    }
                                    
                                case "confirm_new_email":
                                    String v_mail = h2db.getUSSDParams(UssdSessionID, msisdn,"new_email");
                                    String retype_email = request.getParameter("confirm_new_email");
                                    if(v_mail.equals(retype_email)) {
                                        h2db.saveUSSDParams(msisdn,UssdSessionID,inputParam,retype_email);
                                        String notify="You have successfully updated your E-mail for T-kash Statement Service.";
                                        usNav.ussdNavEnd(aPW, notify);
                                        h2db.changeEmailReg(msisdn, retype_email);
                                        _sms.sendSMS(msisdn, notify);
                                        log.info(msisdn+":SUCCESS!! Email Updated ");
                                        break;
                                    }
                                    else {
                                        usNav.ussdContinueSession(aPW,"Failed. The e-mail addresses you provided did not match.Press 1 to enter your e-mail address or 0 to exit","correct_new_email");
                                        log.warn(msisdn+":Changing email -Email Not matching  ");
                                        break;
                                    }
                                    
                                case "correct_new_email":
                                    if(request.getParameter("correct_new_email").equals("1")) {
                                        usNav.ussdContinueSession(aPW,"Enter your new E-mail address","new_email"); 	break;
                                    }else if(request.getParameter("correct_new_email").equals("0")) {
                                        usNav.ussdNavEnd(aPW,"Thank you for staying connected to Telkom");  break;
                                    }else {
                                        usNav.ussdContinueSession(aPW,"Invalid response.Try again.<br />Failed. The e-mail addresses you provided did not match.Press 1 to enter "
                                                + "your e-mail address or 0 to exit","correct_email"); break;
                                    }
                                    
                                case "opt_out":
                                    msisdn= request.getHeader("user-msisdn");
                                    if(request.getParameter("opt_out").equals("1")) {
                                        String notify ="You have successfully opted out of the T-kash Statements Service";
                                        usNav.ussdNavEnd(aPW,notify);
                                        h2db.optOutReg(msisdn);
                                        _sms.sendSMS(msisdn, notify);
                                        log.info(msisdn+":SUCCESS!! -Opted Out  ");
                                        break;
                                    }
                                    if(request.getParameter("opt_out").equals("2")) {
                                        usNav.ussdNavEnd(aPW,"Thank you for staying connected to Telkom"); break;
                                    }
                                    else {
                                        usNav.ussdContinueSession(aPW,"Invalid response.Try again.<br />T-KASH STATEMENTS"
                                                + "<br />1: Full statement"
                                                + "<br />2: Change Email"
                                                + "<br />3: Opt Out","stm_type_exist");	 break;
                                    }
                                default:
                                    usNav.ussdContinueSession(aPW,"Invalid response.Try again.<br />T-KASH STATEMENTS"
                                                + "<br />1: Full statement"
                                                + "<br />2: Change Email"
                                                + "<br />3: Opt Out","stm_type_exist");	 break;
                            }
                            
                        }
                    }
           /*}else {
                usNav.ussdNavEnd(aPW,"This service is currently undergoing maintenance. Please try again later");
            } */
        } catch (InterruptedException ex) {
                log.error(ex);
        } catch (ExecutionException ex) {
                log.error(ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(GenerateUSSDReq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
    }
    
    public static boolean isValidEmailAddress(String email) {
	boolean result = true;
	try {
	    InternetAddress emailAddr = new InternetAddress(email);
	    emailAddr.validate();
        } catch (AddressException ex) {
	    result = false;
              }
	   return result;
    }   
}
