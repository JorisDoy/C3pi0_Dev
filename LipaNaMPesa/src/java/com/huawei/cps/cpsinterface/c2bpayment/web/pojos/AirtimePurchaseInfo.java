/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.web.pojos;

/**
 *
 * @author gaddafi
 */
public class AirtimePurchaseInfo {
    private String transtime, transamount, billrefnumber, saf_msisdn, kycinfo, transact_status, mpesa_receipt, paybill_no, tkl_msisdn, rec_id;

    public String getRec_id() {
        return rec_id;
    }

    public void setRec_id(String rec_id) {
        this.rec_id = rec_id;
    }

    public String getTkl_msisdn() {
        return tkl_msisdn;
    }

    public void setTkl_msisdn(String tkl_msisdn) {
        this.tkl_msisdn = tkl_msisdn;
    }

    public String getPaybill_no() {
        return paybill_no;
    }

    public void setPaybill_no(String paybill_no) {
        this.paybill_no = paybill_no;
    }

    public String getMpesa_receipt() {
        return mpesa_receipt;
    }

    public void setMpesa_receipt(String mpesa_receipt) {
        this.mpesa_receipt = mpesa_receipt;
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

    public String getSaf_msisdn() {
        return saf_msisdn;
    }

    public void setSaf_msisdn(String saf_msisdn) {
        this.saf_msisdn = saf_msisdn;
    }

    public String getKycinfo() {
        return kycinfo;
    }

    public void setKycinfo(String kycinfo) {
        this.kycinfo = kycinfo;
    }

    public String getTransact_status() {
        return transact_status;
    }

    public void setTransact_status(String transact_status) {
        this.transact_status = transact_status;
    }
}
