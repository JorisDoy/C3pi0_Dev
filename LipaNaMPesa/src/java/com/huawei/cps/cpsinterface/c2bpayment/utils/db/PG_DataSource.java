/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.utils.db;

import java.sql.Connection;
import java.sql.SQLException;
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
        ds.setUsername("postgres");
        ds.setPassword("");
        ds.setUrl("jdbc:postgresql://10.22.38.14:5432/telkom_buy_airtime");
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
    
    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }
}
