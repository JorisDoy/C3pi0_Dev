/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccworker;

import java.sql.Timestamp;

/**
 *
 * @author ramson
 */
public class GetDateTime {
    public Timestamp ts;
    
    public GetDateTime(){
        java.util.Date date = new java.util.Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        
        this.ts = ts;
    }
    
    public Timestamp getTimeNow(){
        return ts;
    }
}
