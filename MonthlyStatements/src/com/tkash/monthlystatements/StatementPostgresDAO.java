/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tkash.monthlystatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jdmwamburi
 */
public class StatementPostgresDAO 
{
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(StatementPostgresDAO.class);
    static final String POSTGRES_JDBC_DRIVER ="org.postgresql.Driver";
    static final String POSTGRES_DB_NAME="TkashStatementDBV1";
    static final String POSTGRES_DB_URL ="jdbc:postgresql://10.22.28.188:5432/TkashStatementDBV1";
    static final String POSTGRES_USER="mfs";
    static final String SERVER_NAME ="10.22.28.188:5432";
    static final String POSTGRES_PASS="VFR$5tgb";
    public Connection con;
    public PreparedStatement ps;
    public ResultSet rs;
    public Statement st;
    
    public void updateprocesstooracleValue(String msisdn) {
        try
        {
            Class.forName(POSTGRES_JDBC_DRIVER); 
            String sql ="UPDATE tkash_statement_regs SET process_to_oracle = 0 WHERE msisdn =?";  
            PostgresConnector conn = new PostgresConnector();
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, msisdn);
            ps.executeUpdate();            
            //close the connections
            con.close();
            ps.close();
        }
        catch(ClassNotFoundException | SQLException e) 
        {  
            log.error(e);
        } 
    }
    public void updateprocesstooracleValue2(String msisdn) {
        try
        {
            Class.forName(POSTGRES_JDBC_DRIVER); 
            String sql ="UPDATE tkash_statement_regs SET process_to_oracle = 2, status = 0 WHERE msisdn =?";  
            PostgresConnector conn = new PostgresConnector();
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, msisdn);
            ps.executeUpdate();            
            //close the connections
            con.close();
            ps.close();
        }
        catch(ClassNotFoundException | SQLException e) 
        {  
            log.error(e);
        } 
    }
    public void updaterequestsprocesstooracleValue(String msisdn){
        try
        {
            Class.forName(POSTGRES_JDBC_DRIVER); 
            String sql ="UPDATE tkash_statement_requests SET process_to_oracle = 0 WHERE msisdn =?";  
            PostgresConnector conn = new PostgresConnector();
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, msisdn);
            ps.executeUpdate();            
            //close the connections
            con.close();
            ps.close();
        }
        catch(ClassNotFoundException | SQLException e) 
        {  
            log.error(e);
        }
    }
    public void updaterequestsprocesstooracleValue2(String msisdn){
        try
        {
            Class.forName(POSTGRES_JDBC_DRIVER); 
            String sql ="UPDATE tkash_statement_requests SET process_to_oracle = 2 WHERE msisdn =?";  
            PostgresConnector conn = new PostgresConnector();
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, msisdn);
            ps.executeUpdate();            
            //close the connections
            con.close();
            ps.close();
        }
        catch(ClassNotFoundException | SQLException e) 
        {  
            log.error(e);
        }
    }
    public synchronized String checkifReg(String msisdn)
    {
        String email="";
        try
        {
            Class.forName(POSTGRES_JDBC_DRIVER);             
            String sql ="SELECT email FROM tkash_statement_regs where msisdn =? and status =1";
            PostgresConnector conn = new PostgresConnector();
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, msisdn);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) 
            { 
                email = resultSet.getString("email");           
            } 
            con.close();
            ps.close();
            //rs.close(); 
            return email;
        }
        catch(ClassNotFoundException | SQLException e) 
        {  
            log.error(e);
        } 
        return email;
    }
}
