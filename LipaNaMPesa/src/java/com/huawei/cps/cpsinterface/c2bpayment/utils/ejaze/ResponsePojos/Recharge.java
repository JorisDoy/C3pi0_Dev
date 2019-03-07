/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.utils.ejaze.ResponsePojos;

/**
 *
 * @author gaddafi
 */
public class Recharge {
    private String TXNSTATUS, TXNID, TXNMESSAGE;

    public String getTXNMESSAGE() {
        return TXNMESSAGE;
    }

    public void setTXNMESSAGE(String TXNMESSAGE) {
        this.TXNMESSAGE = TXNMESSAGE;
    }
    private boolean isSuccessful;

    public boolean isIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }
    

    public String getTXNSTATUS() {
        return TXNSTATUS;
    }

    public void setTXNSTATUS(String TXNSTATUS) {
        this.TXNSTATUS = TXNSTATUS;
    }

    public String getTXNID() {
        return TXNID;
    }

    public void setTXNID(String TXNID) {
        this.TXNID = TXNID;
    }
}
