/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketactivator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author jdmwamburi
 */
public class AppLogger {
   private final Logger logger = Logger.getLogger("TkashStatements");
   private FileHandler fileHandler = null;
   private  static ApplicationSetting applicationSetting = new ApplicationSetting();

  

    public void appLogger() throws IOException {
        
        System.out.print(this);
        String logFormat=applicationSetting.appSetting().getProperty("LOGSFORMAT");
        SimpleDateFormat format = new SimpleDateFormat(logFormat);
        try {
            String logFile="app-logs/tkash_statement_"+format.format(Calendar.getInstance().getTime())+".log";
            applicationSetting.setAppPath(logFile); 
            fileHandler = new FileHandler("app-logs/test.log");
        } catch (Exception e) {
            e.printStackTrace();
        }
        fileHandler.setFormatter(new SimpleFormatter());       
        logger.addHandler(fileHandler);       
       
    }
  public void logInfo(String msg){
   
      logger.info(msg);
  }
  public void logError(String msg){
      logger.severe(msg);
       }
   
}  