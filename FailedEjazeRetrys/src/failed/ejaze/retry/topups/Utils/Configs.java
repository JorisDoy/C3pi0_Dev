/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package failed.ejaze.retry.topups.Utils;

/**
 *
 * @author jdmwamburi
 */
public class Configs 
{
    public static final String CONTEXT_FACTORY_CLASS = "com.sun.jndi.ldap.LdapCtxFactory";
    public static String ldapServerUrls[] = {"ldap://10.20.1.32", "ldap://10.20.1.41"};
    public static final String DOMAIN_NAME = "telkom.co.ke";
    public static final String RC_SUCCESSFUL = "111";
    public static final String RC_FAILED = "000";
    public static final String MS_SUCCESSFUL = "Successful";
    public static final String MS_FAILED = "Failed";
    public static final String VALIDATIONURL = "http://196.202.219.252:8080/LipaNaMPesa/PaymentValidationAndComfirmation";
    public static final String COMFIRMATIONURL = "http://196.202.219.252:8080/LipaNaMPesa/PaymentValidationAndComfirmation";
    public static final String PAYBILLNUMBER = "";
    public static final String PRETUPSURL = "http://192.168.27.64:9898/pretups/C2SReceiver?REQUEST_GATEWAY_CODE=EXTGW&REQUEST_GATEWAY_TYPE=EXTGW&LOGIN=pretups2&PASSWORD=pretups123&SOURCE_TYPE=EXTGW&SERVICE_PORT=194";
    public static final String PRETUPSURLRECHARGE = "http://192.168.27.64:9898/pretups/C2SReceiver?REQUEST_GATEWAY_CODE=EXTGW&REQUEST_GATEWAY_TYPE=EXTGW&LOGIN=pretups2&PASSWORD=pretups123&SOURCE_TYPE=EXTGW&SERVICE_PORT=190";
    public static final String EJAZELOWFLOAT = "The Safaricom MPESA Pay bill account is running low on float airtime. Kindly load the 777777711 account with float airtime. Thank you";
    public static final String ISVALIDATEDFALSE = "False";
    public static final String ISVALIDATEDTRUE = "True";
    public static final String TRANSACTSTATUS_SUCCESSFUL = "successful";
    public static final String TRANSACTSTATUS_FAILED = "failed";
    public static final String TRANSACTSTATUS_REVERSED = "Reversed";
}
