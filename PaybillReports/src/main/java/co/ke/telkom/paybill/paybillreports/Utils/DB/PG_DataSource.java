/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ke.telkom.paybill.paybillreports.Utils.DB;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author gaddafi
 */
public class PG_DataSource {
    
    private static PG_DataSource datasource;
    private BasicDataSource ds;
    
    private PG_DataSource(){
        ds = new BasicDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUsername("mfs");
        ds.setPassword("VFR$5tgb");
        ds.setUrl("jdbc:postgresql://10.22.28.192:5432/telkom_buy_airtime");//telkom_postpaid_payments
        ds.setMinIdle(5);
        ds.setMaxIdle(20);
        ds.setMaxOpenPreparedStatements(180);
    }
    
    public static PG_DataSource getInstance(){
        if(datasource == null){
            datasource = new PG_DataSource();
        }
        
        return datasource;
    }
    
    public DataSource getDataSource(){
        return (DataSource) this.ds;    
    }
    
    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }
}