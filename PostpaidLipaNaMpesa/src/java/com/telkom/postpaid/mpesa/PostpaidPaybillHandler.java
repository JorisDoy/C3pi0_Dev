/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telkom.postpaid.mpesa;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author jdmwamburi
 */
public class PostpaidPaybillHandler implements SOAPHandler<SOAPMessageContext> {
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PostpaidPaybill.class.getName());
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        logger.info(LocalDateTime.now() + "|SOAPHandler|handleMessage|" + context.get(MessageContext.WSDL_OPERATION) + "|" + context.get(MessageContext.WSDL_SERVICE));        
        SOAPMessage message = context.getMessage();
        
        try {
            out.reset();
            message.writeTo(out);
            logger.info(LocalDateTime.now() + "|SOAPHandler|handleMessage|" + out.toString());
        }
        catch (IOException | SOAPException ex) {
            logger.error(LocalDateTime.now() + "|SOAPHandler|handleMessage|" + ex.toString());
        }                
        return true;
    }
    
    @Override
    public Set<QName> getHeaders() {
        logger.info(LocalDateTime.now() + "|getHeaders|Retrieving headers...");        
        return null;
    }
    
    @Override
    public boolean handleFault(SOAPMessageContext context) {
        SOAPMessage message = context.getMessage();
        
        try {
            out.reset();
            message.writeTo(out);
            logger.info(LocalDateTime.now() + "|SOAPHandler|handleFault|" + out.toString());
        }
        catch (IOException | SOAPException ex) {
            logger.error(LocalDateTime.now() + "|SOAPHandler|handleFault|" + ex.toString());
        }                
        
        return true;
    }
    
    @Override
    public void close(MessageContext context) {
        logger.info(LocalDateTime.now() + "|SOAPHandler|close|Done preprocessing");
    }
    
}
