/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ussd.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.log4j.Logger;
/**
 *
 * @author jdmwamburi
 */
public class StatementOracleDAO {
    
    static final String APP_SETTING_PATH = "/home/mfs/apps/tkashstatement/";   
    private static  ApplicationSetting applicationSetting = new ApplicationSetting(APP_SETTING_PATH+"app.properties");
  
    public static String DB_DRIVER=applicationSetting.appSetting().getProperty("ORA_DB_DRIVER");      
    public static String DB_CONNECTION =applicationSetting.appSetting().getProperty("ORA_DB_CONNECTION");  
    public static String DB_USER=applicationSetting.appSetting().getProperty("ORA_DB_USER");  
    public static String DB_PASSWORD =applicationSetting.appSetting().getProperty("ORA_DB_PASSWORD");  

/*
public static String DB_CONNECTION ="jdbc:oracle:thin:@10.22.26.111:1521:aml";
    public static String DB_USER="mfstech" ;
    public static String DB_PASSWORD ="loudB3an5!";*/

    
     static final String H2_JDBC_DRIVER = applicationSetting.appSetting().getProperty("H2_JDBC_DRIVER");      
   static final String H2_DB_URL=applicationSetting.appSetting().getProperty("H2_DB_URL");  
   static final String H2_USER =applicationSetting.appSetting().getProperty("H2_USER");   
   static final String H2_PASS =applicationSetting.appSetting().getProperty("H2_PASS");    
    
    static Logger log = Logger.getLogger(StatementOracleDAO.class.getName());
		
    public synchronized boolean validateIDNo(String msisdn, String id_no) {
	String sql ="select ap_account_identification from tkash_statement_profile where ap_account_msisdn = ? and ap_account_identification=?";
	Connection dbConnection = null;		
	dbConnection = getDBConnection();	
	String id="";
	try {
            PreparedStatement preparedvalidId = dbConnection.prepareStatement(sql);	      
	    preparedvalidId.setString (1, msisdn);
            preparedvalidId.setString (2, id_no);
            preparedvalidId.execute();
            ResultSet rschkreg=preparedvalidId.executeQuery(); 		            
            while(rschkreg.next())  {
		id=rschkreg.getString(1);
            }										
            dbConnection.close();  
            if(id.isEmpty()||id == null) 
		return false;
            else 
                return true;
        }catch(Exception e){ 
            e.printStackTrace();
            log.error(e);
            return false;
        }  			
    }
    public synchronized String getstatementLayer(String msisdn) {			
	String sql="select case " + 
                	"when REF_LYR_ID=41 then 'SUBSCRIBER' " + 
			"when REF_LYR_ID=42 AND ref_gn_id  IN(46,47,43)then 'AGENT' " + 
			"when REF_LYR_ID=42 AND ref_gn_id  IN(48,54,44) then 'MERCHANT'" + 
                        "else 'SUB_MERCHANT' end from ods.agg_ap_account_profile where AP_ACCOUNT_MSISDN =?";
	Connection dbConnection = null;		
	dbConnection = getDBConnection();	
	String lyr="";
	try {
	    PreparedStatement preparedchkReg = dbConnection.prepareStatement(sql);	      
	    preparedchkReg.setString (1, msisdn);				    
	    preparedchkReg.execute();
	    ResultSet rschkreg=preparedchkReg.executeQuery(); 		            
            while(rschkreg.next())  {
		lyr=rschkreg.getString(1);
            }										
            dbConnection.close();  
            return lyr;
	}catch(Exception e){ 
            e.printStackTrace();
            log.error(e);
            return "";
            }  			
    }	
		
    public synchronized void createStatementRequest(String msisdn,String mail, String request_type,int period_months ) {
	String startdate,enddate;
	String category =getstatementLayer(msisdn);
	int days = -1* (period_months * 30);
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
	enddate=  dateFormat.format(cal.getTime());
	cal.add(Calendar.DATE, days);
	startdate = dateFormat.format(cal.getTime());	
	String sql ="INSERT INTO tkash_statement_requests(MSISDN,request_type,request_date,period_months,start_date,end_date,process_status,process_date,email_to,category) "
					+ "VALUES(?,?,"
					+ "sysdate,?,"
					+ "to_char(Last_Day(ADD_MONTHS(trunc(sysdate),-?))+1,'yyyymmdd'),"
					+ "to_char(trunc(sysdate),'yyyymmdd'),"
					+ "0,'',?,?)";
	Connection dbConnection = null;		
	dbConnection = getDBConnection();				
	try {
            PreparedStatement preparedStmtReq = dbConnection.prepareStatement(sql);	      
            preparedStmtReq.setString (1, msisdn);
            preparedStmtReq.setString (2, request_type);
            preparedStmtReq.setInt (3, period_months);		
            preparedStmtReq.setInt (4, period_months+1);	
            preparedStmtReq.setString (5, mail);	
            preparedStmtReq.setString (6, category);	
            preparedStmtReq.execute();
	    dbConnection.close();  	
	}catch(Exception e){ 
            e.printStackTrace();
            log.error(e);
        }  
    } 
    
    public static Connection getDBConnection() {
	Connection dbConnection = null;
	try {
            Class.forName(DB_DRIVER);
	}catch (ClassNotFoundException e) {
            log.error(e);
	}
	try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;
	}catch (SQLException e) {
            log.error(e);
	}
	return dbConnection;
    }
}
