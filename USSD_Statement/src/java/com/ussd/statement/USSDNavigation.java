package com.ussd.statement;


import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jdmwamburi
 */
public class USSDNavigation {
    public USSDNavigation(){
    }

    public PrintWriter ussdContinueSession(PrintWriter aPW, String contentString,String var_param){
        aPW.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
        aPW.append("<!DOCTYPE pages SYSTEM \"cellflash.dtd\">");
        aPW.append("<pages><page nav=\"stop\" hist=\"donthist\" volatile=\"true\" backtext=\"notext\" menutext=\"notext\">");
        aPW.append("<form action=\"/TkashStatement/service/tkashstatement\" keywords=\"disable\">");
        aPW.append("<entry var=\""+var_param+"\">");
        aPW.append("<prompt>");
        aPW.append(contentString);
        aPW.append("</prompt>");
        aPW.append("</entry>");
        aPW.append("</form>");
        aPW.append("</page>");
        aPW.append("</pages>");
        return aPW;
    }

    public PrintWriter ussdNavEnd(PrintWriter aPW, String banner){
        aPW.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        aPW.append("<!DOCTYPE pages SYSTEM \"cellflash-1.3.dtd\">");
        aPW.append("<pages descr=\"Thank you\">");
        aPW.append("<page nav=\"end\">");
        aPW.append(banner);
        aPW.append("</page>");
        aPW.append("</pages>");
        return aPW;
    }
    
}
