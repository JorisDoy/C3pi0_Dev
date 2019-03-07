/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.pojos.comfirmation;

/**
 *
 * @author gaddafi
 */
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "transType",
    "transID",
    "transTime",
    "transAmount",
    "businessShortCode",
    "billRefNumber",
    "invoiceNumber",
    "orgAccountBalance",
    "thirdPartyTransID",
    "msisdn",
    "kycInfo"
})
@XmlRootElement(name = "C2BPaymentConfirmationRequest")
public class C2BPaymentConfirmationRequest {

    @XmlElement(name = "TransType", required = true)
    protected String transType;
    @XmlElement(name = "TransID", required = true)
    protected String transID;
    @XmlElement(name = "TransTime", required = true)
    protected String transTime;
    @XmlElement(name = "TransAmount", required = true)
    protected String transAmount;
    @XmlElement(name = "BusinessShortCode", required = true)
    protected String businessShortCode;
    @XmlElement(name = "BillRefNumber")
    protected String billRefNumber;
    @XmlElement(name = "InvoiceNumber")
    protected String invoiceNumber;
    @XmlElement(name = "OrgAccountBalance", required = true)
    protected String orgAccountBalance;
    @XmlElement(name = "ThirdPartyTransID")
    protected String thirdPartyTransID;
    @XmlElement(name = "MSISDN", required = true)
    protected String msisdn;
    @XmlElement(name = "KYCInfo")
    protected List<C2BPaymentConfirmationRequest.KYCInfo> kycInfo;
    
    
    public String getTransType() {
        return transType;
    }
    
    public void setTransType(String value) {
        this.transType = value;
    }
    
    public String getTransID() {
        return transID;
    }
    
    public void setTransID(String value) {
        this.transID = value;
    }
    
    public String getTransTime() {
        return transTime;
    }
    
    public void setTransTime(String value) {
        this.transTime = value;
    }
    
    public String getTransAmount() {
        return transAmount;
    }
    
    public void setTransAmount(String value) {
        this.transAmount = value;
    }
    
    public String getBusinessShortCode() {
        return businessShortCode;
    }
    
    public void setBusinessShortCode(String value) {
        this.businessShortCode = value;
    }
    
    public String getBillRefNumber() {
        return billRefNumber;
    }
    
    public void setBillRefNumber(String value) {
        this.billRefNumber = value;
    }
    
    public String getInvoiceNumber() {
        return invoiceNumber;
    }
    
    public void setInvoiceNumber(String value) {
        this.invoiceNumber = value;
    }
    
    public String getOrgAccountBalance() {
        return orgAccountBalance;
    }
    
    public void setOrgAccountBalance(String value) {
        this.orgAccountBalance = value;
    }
    
    public String getThirdPartyTransID() {
        return thirdPartyTransID;
    }
    
    public void setThirdPartyTransID(String value) {
        this.thirdPartyTransID = value;
    }
    
    public String getMSISDN() {
        return msisdn;
    }
    
    public void setMSISDN(String value) {
        this.msisdn = value;
    }
    
    public List<C2BPaymentConfirmationRequest.KYCInfo> getKYCInfo() {
        if (kycInfo == null) {
            kycInfo = new ArrayList<C2BPaymentConfirmationRequest.KYCInfo>();
        }
        return this.kycInfo;
    }
    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "kycName",
        "kycValue"})
    public static class KYCInfo {
        @XmlElement(name = "KYCName", required = true)
        protected String kycName;
        @XmlElement(name = "KYCValue", required = true)
        protected String kycValue;
        
        public String getKYCName() {
            return kycName;
        }
        
        public void setKYCName(String value) {
            this.kycName = value;
        }
        
        public String getKYCValue() {
            return kycValue;
        }
        
        public void setKYCValue(String value) {
            this.kycValue = value;
        }
    }
}
