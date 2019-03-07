/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.utils.db;

/**
 *
 * @author gaddafi
 */

import com.huawei.cps.cpsinterface.c2bpayment.C2BPaymentValidationAndComfirmationImpl;
import com.huawei.cps.cpsinterface.c2bpayment.web.pojos.AirtimePurchaseInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

public class Selects {
    
    private Connection con;

    private PreparedStatement ps;

    private ResultSet rs;

    private Statement st;
    
    private final Logger logger = Logger.getLogger(Selects.class.getName());
    
    public synchronized boolean isTransactionIdValid(DataSource datasource, String transactionId){
        boolean is_valid = false;
        try{
            String sql = "SELECT * FROM validation where transid = ? and transact_status = 'successful'";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, transactionId);
            rs = ps.executeQuery();
            
            if(rs.next()){
                is_valid = true;
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
        return is_valid;
    }
    
    public synchronized List<AirtimePurchaseInfo> getUsingAll(DataSource datasource, String receipt_number, String saf_num, String tkl_num, String trans_date){
        List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        try{
            String sql = "SELECT * FROM confirmation where transid = ? and msisdn = ? and billrefnumber = ? and transtime like ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, receipt_number);
            ps.setString(2, saf_num);
            ps.setString(3, tkl_num);
            ps.setString(4, "%" + trans_date + "%");
            rs = ps.executeQuery();
            
            while(rs.next()){
                AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                String recid = rs.getInt("rec_id") + "";
                api.setRec_id(recid);
                String transid = rs.getString("transid");
                api.setMpesa_receipt(transid);
                String transtime = rs.getString("transtime");
                api.setTranstime(transtime);
                String transamount = rs.getString("transamount");
                api.setTransamount(transamount);
                String business_shortcode = rs.getString("businessshortcode");
                api.setPaybill_no(business_shortcode);
                String billrefnumber = rs.getString("billrefnumber");
                api.setTkl_msisdn(billrefnumber);
                String saf_msisdn = rs.getString("msisdn");
                api.setSaf_msisdn(saf_msisdn);
                String kycinfo = rs.getString("kycinfo");
                api.setKycinfo(kycinfo);
                is_valid.add(api);
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
        return is_valid;
    }
    
    public synchronized List<AirtimePurchaseInfo> getAB(DataSource datasource, String receipt_number, String saf_num){
        List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        try{
            String sql = "SELECT * FROM confirmation where transid = ? and msisdn = ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, receipt_number);
            ps.setString(2, saf_num);
            //ps.setString(3, tkl_num);
            //ps.setString(4, trans_date);
            rs = ps.executeQuery();
            
            while(rs.next()){
                AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                String recid = rs.getInt("rec_id") + "";
                api.setRec_id(recid);
                String transid = rs.getString("transid");
                api.setMpesa_receipt(transid);
                String transtime = rs.getString("transtime");
                api.setTranstime(transtime);
                String transamount = rs.getString("transamount");
                api.setTransamount(transamount);
                String business_shortcode = rs.getString("businessshortcode");
                api.setPaybill_no(business_shortcode);
                String billrefnumber = rs.getString("billrefnumber");
                api.setTkl_msisdn(billrefnumber);
                String saf_msisdn = rs.getString("msisdn");
                api.setSaf_msisdn(saf_msisdn);
                String kycinfo = rs.getString("kycinfo");
                api.setKycinfo(kycinfo);
                is_valid.add(api);
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
        return is_valid;
    }
    
    public synchronized List<AirtimePurchaseInfo> getAC(DataSource datasource, String receipt_number, String tkl_num){
        List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        try{
            String sql = "SELECT * FROM confirmation where transid = ? and billrefnumber = ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, receipt_number);
            //ps.setString(2, saf_num);
            ps.setString(2, tkl_num);
            //ps.setString(4, trans_date);
            rs = ps.executeQuery();
            
            while(rs.next()){
                AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                String recid = rs.getInt("rec_id") + "";
                api.setRec_id(recid);
                String transid = rs.getString("transid");
                api.setMpesa_receipt(transid);
                String transtime = rs.getString("transtime");
                api.setTranstime(transtime);
                String transamount = rs.getString("transamount");
                api.setTransamount(transamount);
                String business_shortcode = rs.getString("businessshortcode");
                api.setPaybill_no(business_shortcode);
                String billrefnumber = rs.getString("billrefnumber");
                api.setTkl_msisdn(billrefnumber);
                String saf_msisdn = rs.getString("msisdn");
                api.setSaf_msisdn(saf_msisdn);
                String kycinfo = rs.getString("kycinfo");
                api.setKycinfo(kycinfo);
                is_valid.add(api);
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
        return is_valid;
    }
    
    public synchronized List<AirtimePurchaseInfo> getAD(DataSource datasource, String receipt_number, String trans_date){
        List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        try{
            String sql = "SELECT * FROM confirmation where transid = ? and transtime = ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, receipt_number);
            //ps.setString(2, saf_num);
            //ps.setString(3, tkl_num);
            ps.setString(2, trans_date);
            rs = ps.executeQuery();
            
            while(rs.next()){
                AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                String recid = rs.getInt("rec_id") + "";
                api.setRec_id(recid);
                String transid = rs.getString("transid");
                api.setMpesa_receipt(transid);
                String transtime = rs.getString("transtime");
                api.setTranstime(transtime);
                String transamount = rs.getString("transamount");
                api.setTransamount(transamount);
                String business_shortcode = rs.getString("businessshortcode");
                api.setPaybill_no(business_shortcode);
                String billrefnumber = rs.getString("billrefnumber");
                api.setTkl_msisdn(billrefnumber);
                String saf_msisdn = rs.getString("msisdn");
                api.setSaf_msisdn(saf_msisdn);
                String kycinfo = rs.getString("kycinfo");
                api.setKycinfo(kycinfo);
                is_valid.add(api);
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
        return is_valid;
    }
    
    public synchronized List<AirtimePurchaseInfo> getABC(DataSource datasource, String receipt_number, String saf_num, String tkl_num){
        List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        try{
            String sql = "SELECT * FROM confirmation where transid = ? and msisdn = ? and billrefnumber = ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, receipt_number);
            ps.setString(2, saf_num);
            ps.setString(3, tkl_num);
            //ps.setString(4, trans_date);
            rs = ps.executeQuery();
            
            while(rs.next()){
                AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                String recid = rs.getInt("rec_id") + "";
                api.setRec_id(recid);
                String transid = rs.getString("transid");
                api.setMpesa_receipt(transid);
                String transtime = rs.getString("transtime");
                api.setTranstime(transtime);
                String transamount = rs.getString("transamount");
                api.setTransamount(transamount);
                String business_shortcode = rs.getString("businessshortcode");
                api.setPaybill_no(business_shortcode);
                String billrefnumber = rs.getString("billrefnumber");
                api.setTkl_msisdn(billrefnumber);
                String saf_msisdn = rs.getString("msisdn");
                api.setSaf_msisdn(saf_msisdn);
                String kycinfo = rs.getString("kycinfo");
                api.setKycinfo(kycinfo);
                is_valid.add(api);
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
        return is_valid;
    }
    
    public synchronized List<AirtimePurchaseInfo> getACD(DataSource datasource, String receipt_number, String tkl_num, String trans_date){
        List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        try{
            String sql = "SELECT * FROM confirmation where transid = ? and billrefnumber = ? and transtime = ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, receipt_number);
            //ps.setString(2, saf_num);
            ps.setString(2, tkl_num);
            ps.setString(3, trans_date);
            rs = ps.executeQuery();
            
            while(rs.next()){
                AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                String recid = rs.getInt("rec_id") + "";
                api.setRec_id(recid);
                String transid = rs.getString("transid");
                api.setMpesa_receipt(transid);
                String transtime = rs.getString("transtime");
                api.setTranstime(transtime);
                String transamount = rs.getString("transamount");
                api.setTransamount(transamount);
                String business_shortcode = rs.getString("businessshortcode");
                api.setPaybill_no(business_shortcode);
                String billrefnumber = rs.getString("billrefnumber");
                api.setTkl_msisdn(billrefnumber);
                String saf_msisdn = rs.getString("msisdn");
                api.setSaf_msisdn(saf_msisdn);
                String kycinfo = rs.getString("kycinfo");
                api.setKycinfo(kycinfo);
                is_valid.add(api);
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
        return is_valid;
    }
    
    public synchronized List<AirtimePurchaseInfo> geA(DataSource datasource, String receipt_number){
        List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        try{
            String sql = "SELECT * FROM confirmation where transid = ? and msisdn = ? and billrefnumber = ? and transtime = ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, receipt_number);
            //ps.setString(2, saf_num);
            //ps.setString(3, tkl_num);
            //ps.setString(4, trans_date);
            rs = ps.executeQuery();
            
            while(rs.next()){
                AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                String recid = rs.getInt("rec_id") + "";
                api.setRec_id(recid);
                String transid = rs.getString("transid");
                api.setMpesa_receipt(transid);
                String transtime = rs.getString("transtime");
                api.setTranstime(transtime);
                String transamount = rs.getString("transamount");
                api.setTransamount(transamount);
                String business_shortcode = rs.getString("businessshortcode");
                api.setPaybill_no(business_shortcode);
                String billrefnumber = rs.getString("billrefnumber");
                api.setTkl_msisdn(billrefnumber);
                String saf_msisdn = rs.getString("msisdn");
                api.setSaf_msisdn(saf_msisdn);
                String kycinfo = rs.getString("kycinfo");
                api.setKycinfo(kycinfo);
                is_valid.add(api);
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
        return is_valid;
    }
    
    public synchronized List<AirtimePurchaseInfo> getBCD(DataSource datasource, String saf_num, String tkl_num, String trans_date){
        List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        try{
            String sql = "SELECT * FROM confirmation where msisdn = ? and billrefnumber = ? and transtime = ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            //ps.setString(1, receipt_number);
            ps.setString(1, saf_num);
            ps.setString(2, tkl_num);
            ps.setString(3, trans_date);
            rs = ps.executeQuery();
            
            while(rs.next()){
                AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                String recid = rs.getInt("rec_id") + "";
                api.setRec_id(recid);
                String transid = rs.getString("transid");
                api.setMpesa_receipt(transid);
                String transtime = rs.getString("transtime");
                api.setTranstime(transtime);
                String transamount = rs.getString("transamount");
                api.setTransamount(transamount);
                String business_shortcode = rs.getString("businessshortcode");
                api.setPaybill_no(business_shortcode);
                String billrefnumber = rs.getString("billrefnumber");
                api.setTkl_msisdn(billrefnumber);
                String saf_msisdn = rs.getString("msisdn");
                api.setSaf_msisdn(saf_msisdn);
                String kycinfo = rs.getString("kycinfo");
                api.setKycinfo(kycinfo);
                is_valid.add(api);
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
        return is_valid;
    }
    
    public synchronized List<AirtimePurchaseInfo> getB(DataSource datasource, String saf_num){
        List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        try{
            String sql = "SELECT * FROM confirmation where billrefnumber = ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            //ps.setString(1, receipt_number);
            ps.setString(1, saf_num);
            //ps.setString(3, tkl_num);
            //ps.setString(4, trans_date);
            rs = ps.executeQuery();
            
            while(rs.next()){
                AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                String recid = rs.getInt("rec_id") + "";
                api.setRec_id(recid);
                String transid = rs.getString("transid");
                api.setMpesa_receipt(transid);
                String transtime = rs.getString("transtime");
                api.setTranstime(transtime);
                String transamount = rs.getString("transamount");
                api.setTransamount(transamount);
                String business_shortcode = rs.getString("businessshortcode");
                api.setPaybill_no(business_shortcode);
                String billrefnumber = rs.getString("billrefnumber");
                api.setTkl_msisdn(billrefnumber);
                String saf_msisdn = rs.getString("msisdn");
                api.setSaf_msisdn(saf_msisdn);
                String kycinfo = rs.getString("kycinfo");
                api.setKycinfo(kycinfo);
                is_valid.add(api);
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
        return is_valid;
    }
    
    public synchronized List<AirtimePurchaseInfo> getBC(DataSource datasource, String saf_num, String tkl_num){
        List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        try{
            String sql = "SELECT * FROM confirmation where msisdn = ? and billrefnumber = ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            //ps.setString(1, receipt_number);
            ps.setString(1, saf_num);
            ps.setString(2, tkl_num);
            //ps.setString(4, trans_date);
            rs = ps.executeQuery();
            
            while(rs.next()){
                AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                String recid = rs.getInt("rec_id") + "";
                api.setRec_id(recid);
                String transid = rs.getString("transid");
                api.setMpesa_receipt(transid);
                String transtime = rs.getString("transtime");
                api.setTranstime(transtime);
                String transamount = rs.getString("transamount");
                api.setTransamount(transamount);
                String business_shortcode = rs.getString("businessshortcode");
                api.setPaybill_no(business_shortcode);
                String billrefnumber = rs.getString("billrefnumber");
                api.setTkl_msisdn(billrefnumber);
                String saf_msisdn = rs.getString("msisdn");
                api.setSaf_msisdn(saf_msisdn);
                String kycinfo = rs.getString("kycinfo");
                api.setKycinfo(kycinfo);
                is_valid.add(api);
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
        return is_valid;
    }
    
    public synchronized List<AirtimePurchaseInfo> getBD(DataSource datasource, String saf_num, String trans_date){
        List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        try{
            String sql = "SELECT * FROM confirmation where msisdn = ? and transtime = ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            //ps.setString(1, receipt_number);
            ps.setString(1, saf_num);
            //ps.setString(3, tkl_num);
            ps.setString(2, trans_date);
            rs = ps.executeQuery();
            
            while(rs.next()){
                AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                String recid = rs.getInt("rec_id") + "";
                api.setRec_id(recid);
                String transid = rs.getString("transid");
                api.setMpesa_receipt(transid);
                String transtime = rs.getString("transtime");
                api.setTranstime(transtime);
                String transamount = rs.getString("transamount");
                api.setTransamount(transamount);
                String business_shortcode = rs.getString("businessshortcode");
                api.setPaybill_no(business_shortcode);
                String billrefnumber = rs.getString("billrefnumber");
                api.setTkl_msisdn(billrefnumber);
                String saf_msisdn = rs.getString("msisdn");
                api.setSaf_msisdn(saf_msisdn);
                String kycinfo = rs.getString("kycinfo");
                api.setKycinfo(kycinfo);
                is_valid.add(api);
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
        return is_valid;
    }
    
    public synchronized List<AirtimePurchaseInfo> getCD(DataSource datasource, String tkl_num, String trans_date){
        List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        try{
            String sql = "SELECT * FROM confirmation where billrefnumber = ? and transtime = ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            //ps.setString(1, receipt_number);
            //ps.setString(2, saf_num);
            ps.setString(1, tkl_num);
            ps.setString(2, trans_date);
            rs = ps.executeQuery();
            
            while(rs.next()){
                AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                String recid = rs.getInt("rec_id") + "";
                api.setRec_id(recid);
                String transid = rs.getString("transid");
                api.setMpesa_receipt(transid);
                String transtime = rs.getString("transtime");
                api.setTranstime(transtime);
                String transamount = rs.getString("transamount");
                api.setTransamount(transamount);
                String business_shortcode = rs.getString("businessshortcode");
                api.setPaybill_no(business_shortcode);
                String billrefnumber = rs.getString("billrefnumber");
                api.setTkl_msisdn(billrefnumber);
                String saf_msisdn = rs.getString("msisdn");
                api.setSaf_msisdn(saf_msisdn);
                String kycinfo = rs.getString("kycinfo");
                api.setKycinfo(kycinfo);
                is_valid.add(api);
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
        return is_valid;
    }
    
    public synchronized List<AirtimePurchaseInfo> getC(DataSource datasource, String tkl_num){
        List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        try{
            String sql = "SELECT * FROM confirmation where billrefnumber = ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            //ps.setString(1, receipt_number);
            //ps.setString(2, saf_num);
            ps.setString(1, tkl_num);
            //ps.setString(4, trans_date);
            rs = ps.executeQuery();
            
            while(rs.next()){
                AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                String recid = rs.getInt("rec_id") + "";
                api.setRec_id(recid);
                String transid = rs.getString("transid");
                api.setMpesa_receipt(transid);
                String transtime = rs.getString("transtime");
                api.setTranstime(transtime);
                String transamount = rs.getString("transamount");
                api.setTransamount(transamount);
                String business_shortcode = rs.getString("businessshortcode");
                api.setPaybill_no(business_shortcode);
                String billrefnumber = rs.getString("billrefnumber");
                api.setTkl_msisdn(billrefnumber);
                String saf_msisdn = rs.getString("msisdn");
                api.setSaf_msisdn(saf_msisdn);
                String kycinfo = rs.getString("kycinfo");
                api.setKycinfo(kycinfo);
                is_valid.add(api);
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
        return is_valid;
    }
    
    public synchronized List<AirtimePurchaseInfo> getD(DataSource datasource, String trans_date){
        List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        try{
            String sql = "SELECT * FROM confirmation where transtime = ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            //ps.setString(1, receipt_number);
            //ps.setString(2, saf_num);
            //ps.setString(3, tkl_num);
            ps.setString(1, trans_date);
            rs = ps.executeQuery();
            
            while(rs.next()){
                AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                String recid = rs.getInt("rec_id") + "";
                api.setRec_id(recid);
                String transid = rs.getString("transid");
                api.setMpesa_receipt(transid);
                String transtime = rs.getString("transtime");
                api.setTranstime(transtime);
                String transamount = rs.getString("transamount");
                api.setTransamount(transamount);
                String business_shortcode = rs.getString("businessshortcode");
                api.setPaybill_no(business_shortcode);
                String billrefnumber = rs.getString("billrefnumber");
                api.setTkl_msisdn(billrefnumber);
                String saf_msisdn = rs.getString("msisdn");
                api.setSaf_msisdn(saf_msisdn);
                String kycinfo = rs.getString("kycinfo");
                api.setKycinfo(kycinfo);
                is_valid.add(api);
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
        return is_valid;
    }
    
    public synchronized List<AirtimePurchaseInfo> getA(DataSource datasource, String receipt_number){
        List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        try{
            String sql = "SELECT * FROM confirmation where transid = ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, receipt_number);
            //ps.setString(2, saf_num);
            //ps.setString(3, tkl_num);
            //ps.setString(4, trans_date);
            rs = ps.executeQuery();
            
            while(rs.next()){
                AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                String recid = rs.getInt("rec_id") + "";
                api.setRec_id(recid);
                String transid = rs.getString("transid");
                api.setMpesa_receipt(transid);
                String transtime = rs.getString("transtime");
                api.setTranstime(transtime);
                String transamount = rs.getString("transamount");
                api.setTransamount(transamount);
                String business_shortcode = rs.getString("businessshortcode");
                api.setPaybill_no(business_shortcode);
                String billrefnumber = rs.getString("billrefnumber");
                api.setTkl_msisdn(billrefnumber);
                String saf_msisdn = rs.getString("msisdn");
                api.setSaf_msisdn(saf_msisdn);
                String kycinfo = rs.getString("kycinfo");
                api.setKycinfo(kycinfo);
                is_valid.add(api);
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
        return is_valid;
    }
    
    public synchronized AirtimePurchaseInfo getPurchaseInfo(DataSource datasource, int rec_id){
         AirtimePurchaseInfo api = new AirtimePurchaseInfo();
         
         try{
            String sql = "SELECT * FROM confirmation where rec_id = ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, rec_id);
            //ps.setString(2, saf_num);
            //ps.setString(3, tkl_num);
            //ps.setString(4, trans_date);
            rs = ps.executeQuery();
            
            while(rs.next()){
                //AirtimePurchaseInfo api = new AirtimePurchaseInfo();
                String recid = rs.getInt("rec_id") + "";
                api.setRec_id(recid);
                String transid = rs.getString("transid");
                api.setMpesa_receipt(transid);
                String transtime = rs.getString("transtime");
                api.setTranstime(transtime);
                String transamount = rs.getString("transamount");
                api.setTransamount(transamount);
                String business_shortcode = rs.getString("businessshortcode");
                api.setPaybill_no(business_shortcode);
                String billrefnumber = rs.getString("billrefnumber");
                api.setTkl_msisdn(billrefnumber);
                String saf_msisdn = rs.getString("msisdn");
                api.setSaf_msisdn(saf_msisdn);
                String kycinfo = rs.getString("kycinfo");
                api.setKycinfo(kycinfo);
                //is_valid.add(api);
            }
        } catch(SQLException ex){
           logger.fatal("SQLError while checking transaction ID " + ex.getMessage());
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
         
         return api;
    }
    
    public String getKeyValue(DataSource datasource, String key_name){
        String value = "";
        //List<AirtimePurchaseInfo> is_valid = new ArrayList<>();
        try{
            String sql = "select value from key_value_pairs where name = ?";
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, key_name);
            rs = ps.executeQuery();
            
            while(rs.next()){
                value = rs.getString("value");
            }
        } catch(SQLException ex){
           logger.fatal("Error while getting E-Jaze pin! " + ex.getMessage());
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
        return value;
    }
}
