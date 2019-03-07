/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tkash.monthlystatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author jdmwamburi
 */
public class StatementOracleDAO 
{
    private final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(StatementOracleDAO.class.getName());
   
    public static String DB_DRIVER="oracle.jdbc.driver.OracleDriver";
    public static String DB_CONNECTION ="jdbc:oracle:thin:@10.22.26.110:1521:aml";
    public static String DB_USER="mfstech" ;
    public static String DB_PASSWORD ="loudB3an5!";

  
    public static synchronized boolean validateIDNo(String msisdn, String id_no) {
	String sql ="select ap_account_identification from tkash_statement_profile where ap_account_msisdn = ? and ap_account_identification=?";
	Connection dbConnection;		
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
            return !(id.isEmpty()||id == null);
        }catch(SQLException e){ 
            //e.printStackTrace();
            logger.error(e);
            return false;
        }  			
    }
    public synchronized String getstatementLayer(String msisdn) {			
	String sql="select case " + 
                	"when REF_LYR_ID=41 then 'SUBSCRIBER' " + 
			"when REF_LYR_ID=42 AND ref_gn_id  IN(46,47,43)then 'AGENT' " + 
			"when REF_LYR_ID=42 AND ref_gn_id  IN(48,54,44) then 'MERCHANT'" + 
                        "else 'SUB_MERCHANT' end from ods.agg_ap_account_profile where AP_ACCOUNT_MSISDN =?";
	Connection dbConnection;		
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
	}catch(SQLException e){ 
            //e.printStackTrace();
            logger.error(e);
            return "";
            }  			
    }	
		
    public synchronized void createStatementRequest(String msisdn,String mail, String request_type,int period_months ) {
	String startdate,enddate;
	String category = getstatementLayer(msisdn);
	int days = -1 * (period_months * 30);
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
	enddate =  dateFormat.format(cal.getTime());
	cal.add(Calendar.DATE, days);
	startdate = dateFormat.format(cal.getTime());	
        String sql ="INSERT INTO tkash_statement_requests\n" +
            "(MSISDN,request_type,request_date,period_months,start_date,end_date,process_status,process_date,email_to,category) \n" +
            "VALUES\n" +
            "(?,?, sysdate,?,\n" +
            "to_char(Last_Day(ADD_MONTHS(trunc(sysdate),- ?))+1,'yyyymmdd'),\n" +
            "to_char(trunc(sysdate),'yyyymmdd'),\n" +
            "0,'',?,?)";
	Connection dbConnection;		
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
	}catch(SQLException e){ 
            //e.printStackTrace();
            //logger.error(e);
        }  
    } 
    
    public static Connection getDBConnection() {
	Connection dbConnection=null;
	try {
            Class.forName(DB_DRIVER);
            //logger.info("Oracle DB Driver Established: " + DB_DRIVER);
	}catch (ClassNotFoundException e) {
            //logger.error(e);
	}
	try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
            //logger.info("Oracle DB connection Established: ");
            return dbConnection;
	}catch (SQLException e) {
            //logger.error(e);
	}
	return dbConnection;
    }
}
