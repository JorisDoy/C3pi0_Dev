/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tkash.monthlystatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jdmwamburi
 */
public class MonthlyStatements {

    private static final StatementOracleDAO oracleDb = new StatementOracleDAO() ;
    private static final String POSTGRES_DB_URL ="jdbc:postgresql://10.22.28.180:5432/TkashStatementDBV1";
    private static final String POSTGRES_USER="mfs";
    private static final String POSTGRES_PASS="VFR$5tgb";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //GET all the guys who have registered 
        //and send their one month statementon the 5th of every month
        //Connect to postgres server
            Connection postgresConn;
        try 
        {
            postgresConn = DriverManager.getConnection(POSTGRES_DB_URL, POSTGRES_USER, POSTGRES_PASS);
            Statement selData = postgresConn.createStatement();
            ResultSet rs;
            String sql ="SELECT msisdn, id_no, email, request_type FROM tkash_statement_regs WHERE process_to_oracle = 0 and status =1";
            //String sql ="SELECT msisdn, id_no, email, request_type FROM tkash_statement_regs WHERE msisdn ='254771166540' and process_to_oracle = 0 and status =1";
            rs = selData.executeQuery(sql);
            while ( rs.next() )
            {
                String msisdn = rs.getString("msisdn");
                String v_id_no = rs.getString("id_no");
                String v_mail = rs.getString("email");
                String v_req_type = rs.getString("request_type");
                
                oracleDb.createStatementRequest(msisdn, v_mail, v_req_type , 1); //Log monthly 1 Months request
            }
            postgresConn.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(MonthlyStatements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
