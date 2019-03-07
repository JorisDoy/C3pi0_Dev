/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment;

/**
 *
 * @author gaddafi
 */
import com.huawei.cps.cpsinterface.c2bpayment.pojos.comfirmation.C2BPaymentConfirmationRequest;
import com.huawei.cps.cpsinterface.c2bpayment.pojos.validation.C2BPaymentValidationRequest;
import com.huawei.cps.cpsinterface.c2bpayment.pojos.validation.C2BPaymentValidationResult;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _C2BPaymentConfirmationResult_QNAME = new QName("http://cps.huawei.com/cpsinterface/c2bpayment", "C2BPaymentConfirmationResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.huawei.cps.cpsinterface.c2bpayment
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link C2BPaymentValidationRequest }
     *
     */
    public C2BPaymentValidationRequest createC2BPaymentValidationRequest() {
        return new C2BPaymentValidationRequest();
    }

    /**
     * Create an instance of {@link C2BPaymentConfirmationRequest }
     *
     */
    public C2BPaymentConfirmationRequest createC2BPaymentConfirmationRequest() {
        return new C2BPaymentConfirmationRequest();
    }

    /**
     * Create an instance of {@link C2BPaymentValidationRequest.KYCInfo }
     *
     * @return 
     */
    public C2BPaymentValidationRequest.KYCInfo createC2BPaymentValidationRequestKYCInfo() {
        return new C2BPaymentValidationRequest.KYCInfo();
    }

    /**
     * Create an instance of {@link C2BPaymentValidationResult }
     *
     * @return 
     */
    public C2BPaymentValidationResult createC2BPaymentValidationResult() {
        return new C2BPaymentValidationResult();
    }

    /**
     * Create an instance of {@link C2BPaymentConfirmationRequest.KYCInfo }
     *
     * @return 
     */
    public C2BPaymentConfirmationRequest.KYCInfo createC2BPaymentConfirmationRequestKYCInfo() {
        return new C2BPaymentConfirmationRequest.KYCInfo();
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://cps.huawei.com/cpsinterface/c2bpayment", name = "C2BPaymentConfirmationResult")
    public JAXBElement<String> createC2BPaymentConfirmationResult(String value) {
        return new JAXBElement<String>(_C2BPaymentConfirmationResult_QNAME, String.class, null, value);
    }
}
