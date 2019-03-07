
package com.huawei.cps.cpsinterface.c2bpayment.reversal;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 *
 * @author gaddafi
 */


@XmlRegistry
public class ObjectFactory {

    private final static QName ResultMsg_QNAME = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/result", "ResultMsg");
    private final static QName ResponseMsg_QNAME = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/result", "ResponseMsg");

    public ObjectFactory() {
    }

    @XmlElementDecl(namespace = "http://api-v1.gen.mm.vodafone.com/mminterface/result", name = "ResultMsg")
    public JAXBElement<String> createResultMsg(String value) {
        return new JAXBElement<String>(ResultMsg_QNAME, String.class, null, value);
    }

    
    @XmlElementDecl(namespace = "http://api-v1.gen.mm.vodafone.com/mminterface/result", name = "ResponseMsg")
    public JAXBElement<String> createResponseMsg(String value) {
        return new JAXBElement<String>(ResponseMsg_QNAME, String.class, null, value);
    }

}
