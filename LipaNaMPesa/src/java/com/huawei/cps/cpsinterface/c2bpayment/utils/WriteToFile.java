/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.utils;

import com.huawei.cps.cpsinterface.c2bpayment.pojos.logging.LogPojo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;

/**
 *
 * @author gaddafi
 */
public class WriteToFile {

    private FileOutputStream fos = null;
    private File fout_info, fout_error;
    private String TAG;
    //Context context;

    public WriteToFile(LogPojo lp, String TAG) {
        this.TAG = TAG;
        fout_info = new File(lp.getDebug());
        fout_error = new File(lp.getError());
        try {

            if (!fout_info.exists()) {
                fout_info.createNewFile();
            }

            if (!fout_error.exists()) {
                fout_error.createNewFile();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(WriteToFile.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    /**
     *
     * @param mode 0 -> info.log, 1 -> error.log
     * @param message
     */
    public synchronized void write(int mode, String message) {
        
        GetDateTime gdt = new GetDateTime();
        
        try {
            if(mode == 0){
                fos = new FileOutputStream(fout_info, true);
            } else{
                fos = new FileOutputStream(fout_error, true);
            }            
            String log = "At " + gdt.getTimeStamp() + " " + TAG + " sayed --- " + message + "\n";
            byte[] contentInBytes = log.getBytes();
            fos.write(contentInBytes);
            
        } catch (IOException ex) {
            Logger.getLogger(WriteToFile.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
