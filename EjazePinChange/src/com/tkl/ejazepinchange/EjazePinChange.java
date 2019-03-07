/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tkl.ejazepinchange;

import com.tkl.ejazepinchange.DB.Selects;
import com.tkl.ejazepinchange.DB.Update;

/**
 *
 * @author jdmwamburi
 */
public class EjazePinChange {
    private final Selects sel = new Selects();
    private final Update upd = new Update();
    private String CurrPassword;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        //Get the current password and Date set from DB 
        //Check if the Date is almost 60 days from 
        //if true. send an email to mfs technical Detailing that the ejaze pin set is due to be reset.
        //Provide a URL where User can see the previous set pin, enter the new pin and confirmation pin then click submit
        //The user will then see the response
        //1. from Ejaze
        //2. Update of the DB
        //3. Send Mail to mfstechnical telling them that the ejaze pin has been update 
            //to what and when is the next date of update
        //Create a cronjob that sends email to mfstechnical that ejaze pin will elapse after:
            //1. 60 days 2. 30 days 3. >10 days
    }
    
}
