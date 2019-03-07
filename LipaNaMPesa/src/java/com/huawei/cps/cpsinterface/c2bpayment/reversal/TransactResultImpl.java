/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.reversal;

import com.huawei.cps.cpsinterface.c2bpayment.client.reversal.TransactReverseResponse;

/**
 *
 * @author gaddafi
 */
public class TransactResultImpl implements ResultMgrPortType {
private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TransactResultImpl.class.getName());
    @Override
    public String genericAPIResult(String resultMsg) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return "0";
    }
    
}
