/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.pojos.validation;

/**
 *
 * @author gaddafi
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resultCode",
    "resultDesc",
    "thirdPartyTransID"
})
@XmlRootElement(name = "C2BPaymentValidationResult")
public class C2BPaymentValidationResult {
    @XmlElement(name = "ResultCode", required = true)
    protected String resultCode;
    @XmlElement(name = "ResultDesc")
    protected String resultDesc;
    @XmlElement(name = "ThirdPartyTransID")
    protected String thirdPartyTransID;
    
    public String getResultCode() {
        return resultCode;
    }
    
    public void setResultCode(String value) {
        this.resultCode = value;
    }
    
    public String getResultDesc() {
        return resultDesc;
    }
    
    public void setResultDesc(String value) {
        this.resultDesc = value;
    }
    
    public String getThirdPartyTransID() {
        return thirdPartyTransID;
    }
    
    public void setThirdPartyTransID(String value) {
        this.thirdPartyTransID = value;
    }
}
