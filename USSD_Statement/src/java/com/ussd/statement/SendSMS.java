/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ussd.statement;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
/**
 *
 * @author jdmwamburi
 */
public class SendSMS {
    
public synchronized void sendSMS(String msisdn, String message) throws MalformedURLException, ProtocolException, IOException{
	String smscaccount="tkinternal";
	String smscpass="1234";
	String smscscode="25470052";
	String smscurl="http://192.168.20.8:13013/cgi-bin/sendsms";
	message =message.replaceAll(" ", "+");
	String url = smscurl+"?username="+smscaccount+"&password="+smscpass+"&to=" + msisdn + "&from="+smscscode+"&text=" + message + "";
	String _4CCmd="curl -vv \""+url+"\"";
	try{ 
            String _4CUSER="tk_med_all";
            String _4CPASSWORD="HsX9@Y&~R5*5";
            String _4CPORT="22";
            String _4CHOST="10.22.26.112";
            JSch jsch = new JSch();        
	    com.jcraft.jsch.Session session = jsch.getSession(_4CUSER, _4CHOST,Integer.parseInt(_4CPORT));
	    session.setPassword(_4CPASSWORD);
	    session.setConfig("StrictHostKeyChecking", "no");
	    session.setConfig("PreferredAuthentications","publickey,keyboard-interactive,password");       
            session.connect();          
	    ChannelExec channelExec = (ChannelExec)session.openChannel("exec");        
	    InputStream in = channelExec.getInputStream();
	    channelExec.setCommand(_4CCmd);
	    channelExec.connect();
            int exitStatus = channelExec.getExitStatus();
            channelExec.disconnect();
	    session.disconnect();  
        }catch(Exception e){
            e.printStackTrace();
	}
    }
}
