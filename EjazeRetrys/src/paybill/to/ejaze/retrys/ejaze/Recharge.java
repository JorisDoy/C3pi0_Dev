/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paybill.to.ejaze.retrys.ejaze;

/**
 *
 * @author jdmwamburi
 */
public class Recharge {
    private String TXNSTATUS, TXNID, TXNMESSAGE;
    private boolean isSuccessful;

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

    public String getTXNMESSAGE() {
        return TXNMESSAGE;
    }

    public void setTXNMESSAGE(String TXNMESSAGE) {
        this.TXNMESSAGE = TXNMESSAGE;
    }

    public boolean isIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    
}
