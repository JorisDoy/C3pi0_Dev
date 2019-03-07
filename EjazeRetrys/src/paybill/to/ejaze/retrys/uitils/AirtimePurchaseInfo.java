/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paybill.to.ejaze.retrys.uitils;

/**
 *
 * @author jdmwamburi
 */
public class AirtimePurchaseInfo 
{
    private String transtime, transamount, billrefnumber, extrefnum, transid, msisdn, kycinfo, telkom_txn_id;    
    private int rec_id;   

    public String getTelkom_txn_id() {
        return telkom_txn_id;
    }

    public void setTelkom_txn_id(String telkom_txn_id) {
        this.telkom_txn_id = telkom_txn_id;
    }

    public String getKycinfo() {
        return kycinfo;
    }

    public void setKycinfo(String kycinfo) {
        this.kycinfo = kycinfo;
    }
    
    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getTranstime() {
        return transtime;
    }

    public void setTranstime(String transtime) {
        this.transtime = transtime;
    }

    public String getTransamount() {
        return transamount;
    }

    public void setTransamount(String transamount) {
        this.transamount = transamount;
    }

    public String getBillrefnumber() {
        return billrefnumber;
    }

    public void setBillrefnumber(String billrefnumber) {
        this.billrefnumber = billrefnumber;
    }

    public String getExtrefnum() {
        return extrefnum;
    }

    public void setExtrefnum(String extrefnum) {
        this.extrefnum = extrefnum;
    }

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public int getRec_id() {
        return rec_id;
    }

    public void setRec_id(int rec_id) {
        this.rec_id = rec_id;
    }
    
}
