
package com.huawei.cps.cpsinterface.c2bpayment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.huawei.cps.cpsinterface.c2bpayment package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
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
     */
    public C2BPaymentValidationRequest.KYCInfo createC2BPaymentValidationRequestKYCInfo() {
        return new C2BPaymentValidationRequest.KYCInfo();
    }

    /**
     * Create an instance of {@link C2BPaymentValidationResult }
     * 
     */
    public C2BPaymentValidationResult createC2BPaymentValidationResult() {
        return new C2BPaymentValidationResult();
    }

    /**
     * Create an instance of {@link C2BPaymentConfirmationRequest.KYCInfo }
     * 
     */
    public C2BPaymentConfirmationRequest.KYCInfo createC2BPaymentConfirmationRequestKYCInfo() {
        return new C2BPaymentConfirmationRequest.KYCInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cps.huawei.com/cpsinterface/c2bpayment", name = "C2BPaymentConfirmationResult")
    public JAXBElement<String> createC2BPaymentConfirmationResult(String value) {
        return new JAXBElement<String>(_C2BPaymentConfirmationResult_QNAME, String.class, null, value);
    }

}
