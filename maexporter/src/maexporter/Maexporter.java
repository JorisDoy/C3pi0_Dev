/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maexporter;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author jdmwamburi
 */
public class Maexporter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException 
    {
        // TODO code application logic here
        generatecsvFiles();
    }

    private static void generatecsvFiles() throws SQLException, IOException 
    {
         //generate activations csv file
	Activations a = new Activations();
        a.run();
    }
    
}
