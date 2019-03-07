
package com.huawei.cps.cpsinterface.c2bpayment.reversal;

/**
 *
 * @author gaddafi
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
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

public final class ResultMgrPortType_ResultMgrServicePort_Client {

    private static final QName SERVICE_NAME = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/result", "ResultMgrService");

    private ResultMgrPortType_ResultMgrServicePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ResultMgrService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        ResultMgrService ss = new ResultMgrService(wsdlURL, SERVICE_NAME);
        ResultMgrPortType port = ss.getResultMgrServicePort();  
        
        {
        System.out.println("Invoking genericAPIResult...");
        java.lang.String _genericAPIResult_resultMsg = "";
        java.lang.String _genericAPIResult__return = port.genericAPIResult(_genericAPIResult_resultMsg);
        System.out.println("genericAPIResult.result=" + _genericAPIResult__return);


        }

        System.exit(0);
    }

}
