/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketactivator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author jdmwamburi
 */
public class ApplicationSetting {

       
    private String appProperty;
    private String appPath;
    public static final String APP_REL_PATH = System.getProperty("user.dir")+"/" ;
    private static AppLogger appLogger= new AppLogger();
     
   public ApplicationSetting() {
       
    }
   public ApplicationSetting(String appPath) {
        this.appPath = appPath;
    }
    
    public String getAppProperty() {
        return appProperty;
    }

    public void setAppProperty(String appProperty) {
        this.appProperty = appProperty;
    }

    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

   
    public  Properties appSetting() {               
                Properties properties = new Properties();
                InputStream input = null;      		
        try {
            input = new FileInputStream(APP_REL_PATH+getAppPath());
        } catch (FileNotFoundException ex) {
            appLogger.logError(ex.getMessage());
        }
        try {   
            properties.load(input);
        } catch (IOException ex) {
              appLogger.logError(ex.getMessage());
        }
                 return properties;                  
               
	} 
    
   
       
   
    
}