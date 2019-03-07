/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telkom.postpaid.mpesa.db;


import com.telkom.postpaid.mpesa.utils.MailMapper;
import com.telkom.postpaid.mpesa.utils.Props;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.HashMap;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

/**
 *
 * @author jdmwamburi
 */
public class PG_DataSource {

    private BasicDataSource cpds;
    private Runnable sm;
    private Thread mailer;
    public  Props props = new Props();
    public  String dbState = "";
    public String message;
    
    Connection connection = null;

    public String getDbState() {
        return dbState;
    }

    public PG_DataSource() /*throws PropertyVetoException */ {
        /*cpds = new ComboPooledDataSource();
        cpds.setDriverClass("org.postgresql.Driver");
        cpds.setJdbcUrl("jdbc:postgresql://10.22.38.14:5432/telkom_buy_airtime");
        cpds.setUser("postgres");
        cpds.setPassword("");
        cpds.setInitialPoolSize(5);
        cpds.setMinPoolSize(5);
        cpds.setMaxPoolSize(200);
        cpds.setAcquireIncrement(1);
        //Optional
        //cpds.setMaxStatements(100);*/

        connection = null;
    }

    /*public ComboPooledDataSource getInstance() throws PropertyVetoException {
        if (cpds == null) {
            return new PG_DataSource().getInstance();
        }

        return cpds;
    }*/
    public Connection getConnection() throws SQLException {
        //return this.cpds.getConnection();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            dbState += "Postgres Driver not found" + e.getMessage() + "\n";
            //e.printStackTrace();        
            // Send Fail to notify if DB has an issue
            message ="Postpaid Paybill Can not connect to DB";
            HashMap<String, String> receipients = new HashMap();
            receipients.put("cc", "mfstechnichal@telkom.co.ke");
            receipients.put("to", this.props.getMail_to_invas() + ", " + this.props.getMail_to_om());
            this.sm = new MailMapper(receipients, message, this.props);
            this.mailer = new Thread(this.sm);
            this.mailer.start();
        }     
        try {
            //connection = DriverManager.getConnection("jdbc:postgresql://10.22.38.14:5432/telkom_postpaid_payments", "postgres", "");
            connection = DriverManager.getConnection("jdbc:postgresql://10.22.28.192:5432/telkom_postpaid_payments", "mfs", "VFR$5tgb");
        } catch (SQLException e) {
            dbState += "Connection Failed: " + e.getMessage() + "\n";
            //e.printStackTrace();
        }
        return connection;
    }

}
