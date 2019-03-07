/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ke.telkom.paybill.paybillreports.Utils.DB;

/**
 *
 * @author gaddafi
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

public class Selects {
    private Connection con;

    private PreparedStatement ps;

    private ResultSet rs;

    private Statement st;
    
    private final Logger logger = Logger.getLogger(Selects.class.getName());
    
    
    /*
    ==========================
    = Selects for Validation
    ==========================
    */
    
    // Get the total validations in a day    
    public synchronized String getTotalValidationsOn(DataSource datasource, String day){
        String total_validations = "";
        
        try{
            String sql = "select count(*)::int from validation where transtime like ?;";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, day + "%");
            rs = ps.executeQuery();
            
            while(rs.next()){
                total_validations += rs.getInt("count");
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while getting the total validations: " + ex.getMessage() + ". Error cause: " + ex.getCause().toString());
        } finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                // Logger object to replace the manual out
                // on default catalina log file
                logger.fatal("SQLError while closing connections: " + ex.getMessage());
            }
        }
        
        return total_validations;
    }
    
    // Get total failed validations
    public synchronized String getTotalFailedValidationsOn(DataSource datasource, String day, String transaction_status){
        String total_validations = "";
        
        try{
            String sql = "select count(*)::int from validation where transtime like ? and transact_status != ?;";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, day + "%");
            ps.setString(2, transaction_status);
            rs = ps.executeQuery();
            
            while(rs.next()){
                total_validations += rs.getInt("count");
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while getting the total failed validations: " + ex.getMessage() + ". Error cause: " + ex.getCause().toString());
        } finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                // Logger object to replace the manual out
                // on default catalina log file
                logger.fatal("SQLError while closing connections: " + ex.getMessage());
            }
        }
        
        return total_validations;
    }
    
    // The total successful validations
    public synchronized String getTotalSuccessfulValidationsOn(DataSource datasource, String day, String transaction_status){
        String total_validations = "";
        
        try{
            String sql = "select count(*)::int from validation where transtime like ? and transact_status = ?;";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, day + "%");
            ps.setString(2, transaction_status);
            rs = ps.executeQuery();
            
            while(rs.next()){
                total_validations += rs.getInt("count");
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while getting the total failed validations: " + ex.getMessage() + ". Error cause: " + ex.getCause().toString());
        } finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                // Logger object to replace the manual out
                // on default catalina log file
                logger.fatal("SQLError while closing connections: " + ex.getMessage());
            }
        }
        
        return total_validations;
    }
    
    // Get the failure reason
    public synchronized Map<String, Object[]> getAllFailureReasons(DataSource datasource, String day, String transaction_status){
        Map<String, Object[]> total_validations = new TreeMap<>();
        
        try{
            String sql = "select message as error_message, count(message)::int as total_ocurrences from validation where transact_time like ? and transact_status != ? group by message;";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, day + "%");
            ps.setString(2, transaction_status);
            rs = ps.executeQuery();
            
            int count = 1;
            
            while(rs.next()){
                String message = rs.getString("message");
                int total_occurences = rs.getInt("total_ocurrences");
                //total_validations += rs.getInt("count");
                total_validations.put("" + count, new Object[]{message, "" + total_occurences});
                count ++;
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while getting the total failed validations: " + ex.getMessage() + ". Error cause: " + ex.getCause().toString());
        } finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                // Logger object to replace the manual out
                // on default catalina log file
                logger.fatal("SQLError while closing connections: " + ex.getMessage());
            }
        }
        
        return total_validations;
    }
    
    public synchronized String getTotalAmountFailedValidationsOn(DataSource datasource, String day, String transaction_status){
        String total_validations = "";
        
        try{
            String sql = "select sum(transamount::float)::float from validation where transtime like ? and transact_status != ?;";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, day + "%");
            ps.setString(2, transaction_status);
            rs = ps.executeQuery();
            
            while(rs.next()){
                total_validations += rs.getInt("sum");
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while getting the total failed validations: " + ex.getMessage() + ". Error cause: " + ex.getCause().toString());
        } finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                // Logger object to replace the manual out
                // on default catalina log file
                logger.fatal("SQLError while closing connections: " + ex.getMessage());
            }
        }
        
        return total_validations;
    }
    
    // Reports on validation
    public synchronized Map<String, Object[]> getValidationReport(DataSource datasource, String day, String transaction_status){
        Map<String, Object[]> val_report = new HashMap<>();
        try{
            String sql = "select count(message)::text, message, sum(transamount::float)::text from validation where transtime like ? and transact_status != ? group by message;";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, day + "%");
            ps.setString(2, transaction_status);
            rs = ps.executeQuery();
            
            int prefix = 1;
            while(rs.next()){
                String count = rs.getString("count");
                String message = rs.getString("message");
                String sum = rs.getString("sum");
                val_report.put(prefix + "", new Object[]{count, message, sum});
		prefix ++;
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while getting the total failed validations: " + ex.getMessage() + ". Error cause: " + ex.getCause().toString());
        } finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                // Logger object to replace the manual out
                // on default catalina log file
                logger.fatal("SQLError while closing connections: " + ex.getMessage());
            }
        }
        return val_report;
    }
    
    
    
    
    /*
    ===========================
    = Selects for Confirmation
    ===========================
    */
    
    // Total Confirmation requests on a specific date
    public synchronized String getTotalConfirmationsOn(DataSource datasource, String day){
        String total_confirmation = "";
        
        try{
            String sql = "select count(*)::int from confirmation where transtime like ?;";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, day + "%");
            rs = ps.executeQuery();
            
            while(rs.next()){
                total_confirmation += rs.getInt("count");
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while getting the total Confirmation: " + ex.getMessage() + ". Error cause: " + ex.getCause().toString());
        } finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                // Logger object to replace the manual out
                // on default catalina log file
                logger.fatal("SQLError while closing connections: " + ex.getMessage());
            }
        }
        
        return total_confirmation;
    }
    
    // Get total revenue
    public synchronized String getSumTotalTopupConfirmationsOn(DataSource datasource, String day){
        String total_confirmation = "";
        
        try{
            String sql = "select sum(transamount::float)::float from confirmation where transtime like ?;";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, day + "%");
            rs = ps.executeQuery();
            
            while(rs.next()){
                total_confirmation += rs.getFloat("sum");
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while getting the total Confirmation: " + ex.getMessage() + ". Error cause: " + ex.getCause().toString());
        } finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                // Logger object to replace the manual out
                // on default catalina log file
                logger.fatal("SQLError while closing connections: " + ex.getMessage());
            }
        }
        
        return total_confirmation;
    }
    
    // Get the successful topups
    public synchronized String getTotalSuccessfulConfirmationsOn(DataSource datasource, String day, String transaction_status){
        String total_confirmation = "";
        
        try{
            String sql = "select count(*)::int from confirmation where transtime like ? and transact_status = ?;";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, day + "%");
            ps.setString(2, transaction_status);
            rs = ps.executeQuery();
            
            while(rs.next()){
                total_confirmation += rs.getInt("count");
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while getting the total Confirmation: " + ex.getMessage() + ". Error cause: " + ex.getCause().toString());
        } finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                // Logger object to replace the manual out
                // on default catalina log file
                logger.fatal("SQLError while closing connections: " + ex.getMessage());
            }
        }
        
        return total_confirmation;
    }
    
    // Get the failed topups/confirmations
    public synchronized String getTotalFailedConfirmationsOn(DataSource datasource, String day, String transaction_status){
        String total_confirmation = "";
        
        try{
            String sql = "select count(*)::int from confirmation where transtime like ? and transact_status != ?;";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, day + "%");
            ps.setString(2, transaction_status);
            rs = ps.executeQuery();
            
            while(rs.next()){
                total_confirmation += rs.getInt("count");
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while getting the total Confirmation: " + ex.getMessage() + ". Error cause: " + ex.getCause().toString());
        } finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                // Logger object to replace the manual out
                // on default catalina log file
                logger.fatal("SQLError while closing connections: " + ex.getMessage());
            }
        }
        
        return total_confirmation;
    }
    
    // Get total amount for failed topup
    public synchronized String getSumFailedTopupConfirmationsOn(DataSource datasource, String day, String transaction_status){
        String total_confirmation = "";
        
        try{
            String sql = "select sum(transamount::float)::float from confirmation where transtime like ? and transact_status != ?;";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, day + "%");
            ps.setString(2, transaction_status);
            rs = ps.executeQuery();
            
            while(rs.next()){
                total_confirmation += rs.getFloat("sum");
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while getting the total Confirmation: " + ex.getMessage() + ". Error cause: " + ex.getCause().toString());
        } finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                // Logger object to replace the manual out
                // on default catalina log file
                logger.fatal("SQLError while closing connections: " + ex.getMessage());
            }
        }
        
        return total_confirmation;
    }
        
    // Get total amount for successful topups
    public synchronized String getSumSuccessfulTopupConfirmationsOn(DataSource datasource, String day, String transaction_status){
        String total_confirmation = "";
        
        try{
            String sql = "select sum(transamount::float)::float from confirmation where transtime like ? and transact_status = ?;";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, day + "%");
            ps.setString(2, transaction_status);
            rs = ps.executeQuery();
            
            while(rs.next()){
                total_confirmation += rs.getFloat("sum");
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while getting the total Confirmation: " + ex.getMessage() + ". Error cause: " + ex.getCause().toString());
        } finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                // Logger object to replace the manual out
                // on default catalina log file
                logger.fatal("SQLError while closing connections: " + ex.getMessage());
            }
        }
        
        return total_confirmation;
    }
    
    
    // Get total revenue
    /*public synchronized String getSumTotalTopupConfirmationsOn(DataSource datasource, String day){
        String total_confirmation = "";
        
        try{
            String sql = "select sum(transamount::float)::float from confirmation where transtime like ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, day + "%");
            //ps.setString(2, transaction_status);
            rs = ps.executeQuery();
            
            while(rs.next()){
                total_confirmation += rs.getFloat("sum");
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while getting the total Confirmation: " + ex.getMessage() + ". Error cause: " + ex.getCause().toString());
        } finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                // Logger object to replace the manual out
                // on default catalina log file
                logger.fatal("SQLError while closing connections: " + ex.getMessage());
            }
        }
        
        return total_confirmation;
    }*/
}

