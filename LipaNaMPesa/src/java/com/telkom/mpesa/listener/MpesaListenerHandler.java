/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telkom.mpesa.listener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author ericmox
 */
public class MpesaListenerHandler implements SOAPHandler<SOAPMessageContext> {
    private static final Logger logger = Logger.getLogger(MpesaListenerHandler.class.getName());
    private ByteArrayOutputStream out = new ByteArrayOutputStream();;
    
    @Override
    public Set<QName> getHeaders() {
        logger.log(Level.FINE, "{0}|getHeaders|Retrieving headers...", LocalDateTime.now());        
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        
        logger.log(Level.INFO, "{0}|handleMessage|{1}|{2}", new Object[]{LocalDateTime.now(), context.get(MessageContext.WSDL_OPERATION), context.get(MessageContext.WSDL_SERVICE)});        
        SOAPMessage message = context.getMessage();
        
        try {
            out.reset();
            message.writeTo(out);
            logger.log(Level.INFO, "{0}|handleMessage|{1}", new Object[]{LocalDateTime.now(), out.toString()});
        }
        catch (IOException | SOAPException ex) {
            logger.log(Level.SEVERE, "{0}|handleMessage|{1}", new Object[]{LocalDateTime.now(), ex.toString()});
        }                
        
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        logger.log(Level.WARNING, "{0}|handleFault|Encountered an error retrieving headers...", LocalDateTime.now());
        return true;
    }

    @Override
    public void close(MessageContext context) {
        logger.log(Level.FINE, "{0}|close|Done retrieving headers...", LocalDateTime.now());
    }
   
    
}
