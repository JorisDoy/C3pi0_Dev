/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ussd.statement;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.sql.ConnectionPoolDataSource;
import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.jdbcx.JdbcDataSource;

/**
 *
 * @author jdmwamburi
 */
public class StatementH2DAO {
       static final String APP_SETTING_PATH = "/home/mfs/apps/tkashstatement/";   
   static Logger log = Logger.getLogger(StatementH2DAO.class.getName());
   private static  ApplicationSetting applicationSetting = new ApplicationSetting(APP_SETTING_PATH+"app.properties");
   //static final String H2_JDBC_DRIVER = "org.h2.Driver";      
  // static final String H2_DB_URL="jdbc:h2:/home/mfs/apps/tkashstatement/H2DB/TkashStatementDBV1";
   static final String H2_JDBC_DRIVER = applicationSetting.appSetting().getProperty("H2_JDBC_DRIVER");      
   static final String H2_DB_URL="jdbc:h2:"+APP_SETTING_PATH+applicationSetting.appSetting().getProperty("H2_DB_URL");  
   static final String H2_USER =applicationSetting.appSetting().getProperty("H2_USER");   
   static final String H2_PASS =applicationSetting.appSetting().getProperty("H2_PASS");    
   //static final String DB_URL="jdbc:h2:/var/lib/tomcat/webapps/TkashStatementDBV1";
    public static void createH2DB() throws SQLException  { 
       JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
       Connection conn = jdbcConnectionPool.getConnection(); 
       Statement stmt = null; 
       boolean exists;
        try{          
            conn = DriverManager.getConnection(H2_DB_URL+";IFEXISTS=TRUE",H2_USER,H2_PASS);           
            exists=true;
            conn.close();
        }
        catch(Exception e){         
           exists=false;         
        }
          
        if(!exists){
        try { 
            Class.forName(H2_JDBC_DRIVER); 
            log.info("Connecting to H2 database...Create Database");                       
            log.info("CREATING TABLE: tkash_statement_regs "); 
            stmt = conn.createStatement(); 
            String sql =  "CREATE TABLE   IF NOT EXISTS tkash_statement_regs " + 
                                                    "(MSISDN VARCHAR(255) not NULL, " + 
                                                    " ID_NO VARCHAR(255), " +  
                                                    " EMAIL VARCHAR(255), " +  
                                                    " REG_DATE TIMESTAMP, " +  
                                                    " STATUS INTEGER    ," +
                                                    " DEREG_DATE TIMESTAMP, " +  
                                                    " UPDATED_DATE TIMESTAMP, " +  
                                                    " REQUEST_TYPE VARCHAR(255) )";  
            stmt.executeUpdate(sql);
            log.info("Table tkash_statement_regs Created:");   
         
         
            log.info("CREATING TABLE: TKASH_USSD_SESSION_PARAMS "); 
            stmt = conn.createStatement(); 
            String sql1 =  "CREATE TABLE  IF NOT EXISTS  TKASH_USSD_SESSION_PARAMS " + 
                                                        "(MSISDN VARCHAR(255) not NULL, " + 
                                                        " SESSION_ID VARCHAR(255), " +  
                                                        " PARAM VARCHAR(255), " +  
                                                        " PARAM_VALUE VARCHAR(255), " +  
                                                        " DATE_TIME TIMESTAMP )";  
            stmt.executeUpdate(sql1);
             log.info("Table TKASH_USSD_SESSION_PARAMS Created:");    
          
            log.info("CREATING TABLE: STATEMENT_SESSIONS "); 
            stmt = conn.createStatement(); 
            String sql2 =  "CREATE TABLE  IF NOT EXISTS  STATEMENT_SESSIONS " + 
                                                        "(SUBS_MSISDN VARCHAR(255) not NULL, " + 
                                                        "SESSION_ID VARCHAR(255), " +  
                                                        "C_STATE INTEGER, " +              
                                                        "DATE_TIME TIMESTAMP )";  
            stmt.executeUpdate(sql2);
            log.info("Table STATEMENT_SESSIONS Created:"); 
         
            stmt.close(); 
            conn.close(); 
        }catch(SQLException se) { 
            log.error(""+se);
            se.printStackTrace(); 
        }catch(Exception e) { 
            log.error(""+e); 
            e.printStackTrace(); 
        }finally { 
        try{ 
            if(stmt!=null) stmt.close(); 
        } catch(SQLException se2) {
            log.error(se2);
        } 
         try { 
            if(conn!=null) conn.close(); 
        }catch(SQLException se){ 
            se.printStackTrace(); 
            log.error(""+se);
        } 
        }   
        }
   }  

    public synchronized void createStatementReg(String msisdn,String idno,String email) throws SQLException{
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection conn = jdbcConnectionPool.getConnection(); 
        PreparedStatement  preparedStatement  =null;
        try{
            Class.forName(H2_JDBC_DRIVER); 
            String sql ="INSERT INTO tkash_statement_regs(MSISDN,ID_NO,EMAIL,REG_DATE,STATUS) VALUES(?,?,?,CURRENT_TIMESTAMP,1)";        
            preparedStatement = conn.prepareStatement(sql);  
            preparedStatement.setString(1, msisdn);
            preparedStatement.setString(2, idno);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();          
            preparedStatement.close(); 
            conn.close(); 
        }catch(SQLException se) { 
            se.printStackTrace(); 
            log.error(se);
        }catch(Exception e) {  
            e.printStackTrace(); 
            log.error(e);
        }finally {  
        try{
            if(preparedStatement!=null) preparedStatement.close();  
        } catch(SQLException se2) { 
            log.error(""+se2);
        } 
        try { 
            if(conn!=null) conn.close(); 
        }catch(SQLException se) { 
            se.printStackTrace(); 
            log.error(se);
        } 
        }
    }

  

    public synchronized String checkifReg(String msisdn) throws SQLException {    
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection conn = jdbcConnectionPool.getConnection(); 
        PreparedStatement  preparedStatement  =null;			
	String email="";
        try{
             Class.forName(H2_JDBC_DRIVER);             
            String sql ="SELECT email FROM tkash_statement_regs where msisdn =? and status =1";   
            preparedStatement = conn.prepareStatement(sql);  
            preparedStatement.setString(1, msisdn);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) { 
                email = resultSet.getString("email");           
            } 
        preparedStatement.close(); 
        return email;
        }catch(Exception e) {  
            log.error(e);
            e.printStackTrace();     
        } 
        return email;
    }

    public synchronized void changeEmailReg(String msisdn, String email) throws SQLException {		
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection conn = jdbcConnectionPool.getConnection(); 
        PreparedStatement  preparedStatement  =null;			
	try{
            Class.forName(H2_JDBC_DRIVER); 
            String sql ="UPDATE tkash_statement_regs SET email=?,updated_date =sysdate WHERE msisdn =? and status = 1";   
            preparedStatement = conn.prepareStatement(sql);  
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, msisdn);
            preparedStatement.executeUpdate();     
            preparedStatement.close();
        }catch(Exception e) {  
            e.printStackTrace();  
            log.error(e);
        } 
    }
  
    public synchronized void optOutReg(String msisdn) throws SQLException {
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection conn = jdbcConnectionPool.getConnection(); 
        PreparedStatement  preparedStatement  =null;			
	try{
           Class.forName(H2_JDBC_DRIVER); 
           String sql="UPDATE tkash_statement_regs SET status=0,dereg_date =sysdate WHERE msisdn =?";
           preparedStatement = conn.prepareStatement(sql);  
           preparedStatement.setString(1, msisdn);
           preparedStatement.executeUpdate();  
           preparedStatement.close();
        }catch(Exception e) {  
           e.printStackTrace();
           log.error(e);} 			
    }
		  
  
  
    public synchronized void saveUSSDParams(String msisdn,String sessionUserID ,String param,String param_value) throws SQLException {
	JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection conn = jdbcConnectionPool.getConnection(); 
	PreparedStatement  preparedStatement  =null;
	try {
            Class.forName(H2_JDBC_DRIVER); 
            String sql ="INSERT INTO TKASH_USSD_SESSION_PARAMS(MSISDN,session_id,param,param_value,date_time) VALUES(?,?,?,?,sysdate)";
            preparedStatement = conn.prepareStatement(sql);  
            preparedStatement.setString (1, msisdn);
            preparedStatement.setString (2, sessionUserID);
            preparedStatement.setString (3, param);
            preparedStatement.setString (4, param_value);                           
            preparedStatement.executeUpdate();  
            preparedStatement.close();
        }catch(Exception e){ 
            e.printStackTrace();
            log.error(e);
            }  
    }

    public synchronized String getUSSDParams(String sessionId, String msisdn,String param) throws SQLException {
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection conn = jdbcConnectionPool.getConnection(); 
        PreparedStatement  preparedStatement  =null;
	String v_param="";
        try{
            Class.forName(H2_JDBC_DRIVER); 
            String sql="select PARAM_VALUE from TKASH_USSD_SESSION_PARAMS a,  STATEMENT_SESSIONS B " +
                                                    "where a.SESSION_ID =B.SESSION_ID " +
                                                    "and C_STATE=1 " +
                                                    "and     param =? " +
                                                    "and MSISDN =? and a.SESSION_ID=?";
            preparedStatement = conn.prepareStatement(sql);  
            preparedStatement.setString (1, param);		
            preparedStatement.setString (2, msisdn);	
            preparedStatement.setString (3, sessionId);	
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) { 
                v_param = resultSet.getString("PARAM_VALUE");           
            } 
            preparedStatement.close(); 
            return v_param;
            }catch(Exception e) {  
            e.printStackTrace();     
            log.error(e);} 
            return v_param;    
    }
    public synchronized String getNextNav(String msisdn,String param) throws SQLException {	
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection conn = jdbcConnectionPool.getConnection(); 
        PreparedStatement  preparedStatement  =null;
	String v_param="";
        try{
            Class.forName(H2_JDBC_DRIVER); 
            String sql="select param_value from   TKASH_USSD_SESSION_PARAMS where msisdn =? and param =?" + 
                                                    " and date_time =(select max(date_time) from  TKASH_USSD_SESSION_PARAMS where msisdn =?" + 
                                                    " and param = ?)";
            preparedStatement = conn.prepareStatement(sql);  
            preparedStatement.setString (1, msisdn);		
            preparedStatement.setString (2, param);	
            preparedStatement.setString (3, msisdn);		
            preparedStatement.setString (4, param);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) { 
              v_param = resultSet.getString("param_value");           
            } 
            preparedStatement.close(); 
            return v_param;
            }catch(Exception e) {  
            e.printStackTrace();
            log.error(e);
            } 
            return v_param;
    }
    public synchronized void createSession(String msisdn,String sessionId) throws SQLException {
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection conn = jdbcConnectionPool.getConnection(); 
        PreparedStatement  preparedStatement  =null;
	try {
            Class.forName(H2_JDBC_DRIVER); 
            String sql ="INSERT INTO STATEMENT_SESSIONS(subs_msisdn,session_id,c_state,date_time) VALUES(?,?,'1',sysdate)";
            preparedStatement = conn.prepareStatement(sql);  
            preparedStatement.setString (1, msisdn);
            preparedStatement.setString (2, sessionId);
            preparedStatement.executeUpdate();  
            preparedStatement.close();
	}catch(Exception e){ 
            e.printStackTrace();
            log.error(e);
        }  
    }	
    public synchronized void updateSessionStatus(String msisdn,String sessionID) throws SQLException {
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection conn = jdbcConnectionPool.getConnection(); 
        PreparedStatement  preparedStatement  =null;			
	try{
           Class.forName(H2_JDBC_DRIVER); 
            String sql="update STATEMENT_SESSIONS set c_state =0 where subs_msisdn = ? and session_id not in(?)";
            preparedStatement = conn.prepareStatement(sql);  
            preparedStatement.setString(1, msisdn);
            preparedStatement.setString(2, sessionID);
            preparedStatement.executeUpdate();  
            preparedStatement.close();
        }catch(Exception e) {  
            e.printStackTrace();   
            log.error(e);
        } 
    }
 
    public synchronized String getCurrentSession(String msisdn) throws SQLException {
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection conn = jdbcConnectionPool.getConnection(); 
        PreparedStatement  preparedStatement  =null;
	String v_param="";
        try{
            Class.forName(H2_JDBC_DRIVER); 
            String sql="SELECT session_id FROM STATEMENT_SESSIONS where c_state=1 and subs_msisdn = ?";
            preparedStatement = conn.prepareStatement(sql);  
            preparedStatement.setString(1, msisdn);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) { 
                v_param = resultSet.getString("session_id");           
            } 
            preparedStatement.close(); 
            return v_param;
        }catch(Exception e) {  
            e.printStackTrace(); 
            log.error(e);
        } 
            return v_param;
    }
    public synchronized boolean isSessionActive(String sessionId,String msisdn) throws SQLException{
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection conn = jdbcConnectionPool.getConnection(); 
        PreparedStatement  preparedStatement  =null;
	boolean isActive= false;
        String v_param="";
        try{
            Class.forName(H2_JDBC_DRIVER); 
            String sql="SELECT c_state FROM STATEMENT_SESSIONS where session_id=? and subs_msisdn = ?";
            preparedStatement = conn.prepareStatement(sql); 
            preparedStatement.setString(1, sessionId);
            preparedStatement.setString(2, msisdn);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) { 
                v_param = resultSet.getString("c_state");           
            } 
            preparedStatement.close(); 
            if(v_param.equals("1")){ isActive=true;} else{isActive=false;}
            return isActive;
        }catch(Exception e) {  
            e.printStackTrace();      
            log.error(e);
        } 
        return isActive;
    }
    
    private static JdbcConnectionPool getConnectionPool() {
        JdbcConnectionPool cp = null;
        try {
          Class.forName(H2_JDBC_DRIVER); 
        } catch (ClassNotFoundException e) {
          log.error(e);
        }
        JdbcDataSource Dpds = new JdbcDataSource();
        Dpds.setURL(H2_DB_URL);
        Dpds.setUser(H2_USER);
        Dpds.setPassword(H2_PASS);
        //cp = JdbcConnectionPool.create(H2_DB_URL, H2_USER, H2_PASS);
        cp = JdbcConnectionPool.create(Dpds);
        return cp;
    }
}
