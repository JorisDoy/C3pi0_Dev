package com.huawei.cps.cpsinterface.c2bpayment.reversal;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 *
 * @author gaddafi
 */

@WebServiceClient(name = "ResultMgrService", 
                  wsdlLocation = "file:CBPInterface_Result.wsdl",
                  targetNamespace = "http://api-v1.gen.mm.vodafone.com/mminterface/result") 
public class ResultMgrService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/result", "ResultMgrService");
    public final static QName ResultMgrServicePort = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/result", "ResultMgrServicePort");
    static {
        URL url = null;
        try {
            url = new URL("CBPInterface_Result.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ResultMgrService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:CBPInterface_Result.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ResultMgrService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ResultMgrService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ResultMgrService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public ResultMgrService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ResultMgrService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ResultMgrService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns ResultMgrPortType
     */
    @WebEndpoint(name = "ResultMgrServicePort")
    public ResultMgrPortType getResultMgrServicePort() {
        return super.getPort(ResultMgrServicePort, ResultMgrPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ResultMgrPortType
     */
    @WebEndpoint(name = "ResultMgrServicePort")
    public ResultMgrPortType getResultMgrServicePort(WebServiceFeature... features) {
        return super.getPort(ResultMgrServicePort, ResultMgrPortType.class, features);
    }

}
