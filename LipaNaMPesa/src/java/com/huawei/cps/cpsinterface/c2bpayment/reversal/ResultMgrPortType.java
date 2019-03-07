package com.huawei.cps.cpsinterface.c2bpayment.reversal;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author gaddafi
 */

@WebService(targetNamespace = "http://api-v1.gen.mm.vodafone.com/mminterface/result", name = "ResultMgrPortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ResultMgrPortType {

    @WebMethod(operationName = "GenericAPIResult")
    @WebResult(name = "ResponseMsg", targetNamespace = "http://api-v1.gen.mm.vodafone.com/mminterface/result", partName = "ResponseMsg")
    public java.lang.String genericAPIResult(
        @WebParam(partName = "ResultMsg", name = "ResultMsg", targetNamespace = "http://api-v1.gen.mm.vodafone.com/mminterface/result")
        java.lang.String resultMsg
    );
}
