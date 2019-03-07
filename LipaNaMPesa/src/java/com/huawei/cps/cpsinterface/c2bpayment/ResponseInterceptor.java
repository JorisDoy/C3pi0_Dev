/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.service.model.MessageInfo;

/**
 *
 * @author gaddafi
 */
// Class to suppress response
// This is a test case for c2b integration
public class ResponseInterceptor extends AbstractSoapInterceptor {

    public ResponseInterceptor() {
        super(Phase.SETUP);
    }
    
    @Override
    public void handleMessage(final SoapMessage t) throws Fault {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        final boolean suppressResponse = this.suppressResponse(t);

        if (suppressResponse) {
            //log.debug("-> Suppressing response");
            t.getInterceptorChain().abort();
        }
    }

    private boolean suppressResponse(final Message message) {
        final Fault fault = (Fault) message.getContent(Exception.class);

        if (fault != null) {
            final String faultMessage = fault.getMessage();

            return faultMessage.indexOf("default") > 0;

        } else {
            final MessageInfo messageInfo = (MessageInfo) message.get("org.apache.cxf.service.model.MessageInfo");
            final String operation = messageInfo.getOperation().getOutputName();
            // Can be replaced with : -> https://github.com/apache/cxf/blob/master/core/src/test/java/org/apache/cxf/service/model/OperationInfoTest.java
            final String local_part = messageInfo.getName().getLocalPart();

            //return operation.indexOf("0") > 0;
            //return local_part.indexOf("ResultCode") > 0;
            return true;
        }
    }

    /**
     * <jaxws:endpoint ...>
     * <jaxws:outInterceptors>
     * <bean class="my.super.interceptor.Suppressor"/>
     * </jaxws:outInterceptors>
     * <jaxws:outFaultInterceptors>
     * <bean class="my.super.interceptor.Suppressor"/>
     * </jaxws:outFaultInterceptors>
     * </jaxws:endpoint>
     */
    
    //    @Override
//    public void handleMessage(final SoapMessage message) throws Fault {
//
//        final boolean suppressResponse = this.suppressResponse(message);
//
//        if (suppressResponse) {
//            log.debug("-> Suppressing response");
//            message.getInterceptorChain().abort();
//        }
//    }
//
//    private boolean suppressResponse(final Message message) {
//        final Fault fault = (Fault) message.getContent(Exception.class);
//
//        if (fault != null) {
//            final String faultMessage = fault.getMessage();
//
//            return faultMessage.indexOf("Something-you-want-to-match") > 0;
//
//        } else {
//            final MessageInfo messageInfo = (MessageInfo) message.get("org.apache.cxf.service.model.MessageInfo");
//            final String operation = messageInfo.getOperation().getOutputName();
//
//            return operation.indexOf("Something-you-want-to-match") > 0;
//        }
//    }

}