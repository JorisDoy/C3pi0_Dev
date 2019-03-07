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
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace = "http://cps.huawei.com/cpsinterface/c2bpayment", name = "C2BPaymentValidationAndComfirmation")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface C2BPaymentValidationAndComfirmation {

    /**
     *
     * @param c2BPaymenConfirmationRequest
     * @return
     */
    @WebMethod(operationName = "ConfirmC2BPayment", action = "ConfirmC2BPayment")
    @WebResult(name = "C2BPaymentConfirmationResult", targetNamespace = "http://cps.huawei.com/cpsinterface/c2bpayment", partName
            = "C2BPaymentConfirmationResult")
    public java.lang.String confirmC2BPayment(
            @WebParam(partName = "C2BPaymenConfirmationRequest", name = "C2BPaymentConfirmationRequest", targetNamespace = "http://cps.huawei.com/cpsinterface/c2bpayment") C2BPaymentConfirmationRequest c2BPaymenConfirmationRequest);

    /**
     *
     * @param c2BPaymentValidationRequest
     * @return
     */
    @WebMethod(operationName = "ValidateC2BPayment", action = "ValidateC2BPayment")
    @WebResult(name = "C2BPaymentValidationResult", targetNamespace = "http://cps.huawei.com/cpsinterface/c2bpayment", partName = "C2BPaymentValidationResult")
    public C2BPaymentValidationResult validateC2BPayment(
            @WebParam(partName = "C2BPaymentValidationRequest", name = "C2BPaymentValidationRequest", targetNamespace = "http://cps.huawei.com/cpsinterface/c2bpayment") C2BPaymentValidationRequest c2BPaymentValidationRequest);
}
