/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telkom.ejaze;

/**
 *
 * @author gaddafi
 */
public class Balance {
    private String TXNSTATUS, TXNMESSAGE;

    public String getTXNMESSAGE() {
        return TXNMESSAGE;
    }

    public void setTXNMESSAGE(String TXNMESSAGE) {
        this.TXNMESSAGE = TXNMESSAGE;
    }
    private float BALANCE;
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

    public float getBALANCE() {
        return BALANCE;
    }

    public void setBALANCE(float BALANCE) {
        this.BALANCE = BALANCE;
    }
}
