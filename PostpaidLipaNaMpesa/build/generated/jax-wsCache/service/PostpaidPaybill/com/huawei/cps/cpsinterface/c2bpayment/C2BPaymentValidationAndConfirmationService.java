
package com.huawei.cps.cpsinterface.c2bpayment;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "C2BPaymentValidationAndConfirmationService", targetNamespace = "http://cps.huawei.com/cpsinterface/c2bpayment", wsdlLocation = "file:/C:/Users/jdmwamburi/Documents/NetBeansProjects/PostpaidLipaNaMpesa/src/conf/xml-resources/web-services/PostpaidPaybill/wsdl/CBPInterface_C2BPaymentValidationAndConfirmation.wsdl")
public class C2BPaymentValidationAndConfirmationService
    extends Service
{

    private final static URL C2BPAYMENTVALIDATIONANDCONFIRMATIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException C2BPAYMENTVALIDATIONANDCONFIRMATIONSERVICE_EXCEPTION;
    private final static QName C2BPAYMENTVALIDATIONANDCONFIRMATIONSERVICE_QNAME = new QName("http://cps.huawei.com/cpsinterface/c2bpayment", "C2BPaymentValidationAndConfirmationService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/jdmwamburi/Documents/NetBeansProjects/PostpaidLipaNaMpesa/src/conf/xml-resources/web-services/PostpaidPaybill/wsdl/CBPInterface_C2BPaymentValidationAndConfirmation.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        C2BPAYMENTVALIDATIONANDCONFIRMATIONSERVICE_WSDL_LOCATION = url;
        C2BPAYMENTVALIDATIONANDCONFIRMATIONSERVICE_EXCEPTION = e;
    }

    public C2BPaymentValidationAndConfirmationService() {
        super(__getWsdlLocation(), C2BPAYMENTVALIDATIONANDCONFIRMATIONSERVICE_QNAME);
    }

    public C2BPaymentValidationAndConfirmationService(WebServiceFeature... features) {
        super(__getWsdlLocation(), C2BPAYMENTVALIDATIONANDCONFIRMATIONSERVICE_QNAME, features);
    }

    public C2BPaymentValidationAndConfirmationService(URL wsdlLocation) {
        super(wsdlLocation, C2BPAYMENTVALIDATIONANDCONFIRMATIONSERVICE_QNAME);
    }

    public C2BPaymentValidationAndConfirmationService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, C2BPAYMENTVALIDATIONANDCONFIRMATIONSERVICE_QNAME, features);
    }

    public C2BPaymentValidationAndConfirmationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public C2BPaymentValidationAndConfirmationService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns C2BPaymentValidationAndComfirmation
     */
    @WebEndpoint(name = "C2BPaymentValidationAndConfirmationServicePort")
    public C2BPaymentValidationAndComfirmation getC2BPaymentValidationAndConfirmationServicePort() {
        return super.getPort(new QName("http://cps.huawei.com/cpsinterface/c2bpayment", "C2BPaymentValidationAndConfirmationServicePort"), C2BPaymentValidationAndComfirmation.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns C2BPaymentValidationAndComfirmation
     */
    @WebEndpoint(name = "C2BPaymentValidationAndConfirmationServicePort")
    public C2BPaymentValidationAndComfirmation getC2BPaymentValidationAndConfirmationServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://cps.huawei.com/cpsinterface/c2bpayment", "C2BPaymentValidationAndConfirmationServicePort"), C2BPaymentValidationAndComfirmation.class, features);
    }

    private static URL __getWsdlLocation() {
        if (C2BPAYMENTVALIDATIONANDCONFIRMATIONSERVICE_EXCEPTION!= null) {
            throw C2BPAYMENTVALIDATIONANDCONFIRMATIONSERVICE_EXCEPTION;
        }
        return C2BPAYMENTVALIDATIONANDCONFIRMATIONSERVICE_WSDL_LOCATION;
    }

}