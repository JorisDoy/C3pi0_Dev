/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketactivator;

import java.beans.Statement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jdmwamburi
 */
public class Marketactivator {

    /**
     * @param args the command line arguments
     */
    //static AppLogger appLogger= new AppLogger();
    public static void main(String[] args) throws SQLException, IOException {
        // TODO code application logic here
        Date currentDate = new Date( );
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MINUTE,0);
	Date calculatedTime = calendar.getTime();
        SimpleDateFormat simpleDateFormat =    new SimpleDateFormat ("dd-MMM-yyyy");        
        String issueDate = simpleDateFormat.format(calculatedTime);
        //appLogger.logInfo("************Starting MA_activations Engine..."+issueDate);
        generatecsvFiles();
    }

    private static void generatecsvFiles() throws SQLException, IOException 
	{
	//generate activations csv file
	Activations a = new Activations();
        a.run();	     
        //check if thread has finished then
        AuthorizedAagents b = new AuthorizedAagents();
        b.run();
	}
    private static class Activations {

      public void run() throws SQLException, IOException
            {
                        try 
                        {
                                Class.forName("org.postgresql.Driver");//oracle.jdbc.driver.OracleDriver
                            //Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.20.7:5432/tkl_market_activators", "mfstech","technical");
                            Connection connection = DriverManager.getConnection("jdbc:postgresql://10.22.28.180:5432/tkl_market_activators", "mfs","VFR$5tgb");
                                if (connection != null) 
                                {
                                   
                                            //stmt = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                            //ResultSet.CONCUR_UPDATABLE);
                                    String query ="select  activator_msisdn, customer_msisdn, to_char(activate_time,'yyyy-mm-dd hh24:mi:ss') activation_time ,agent_of_day from activations\n" + 
                                                        "where to_char(activate_time,'yyyy-mm-dd hh24:mi:ss') >='2018-07-01:00:00:00)'\n" + 
                                                        "";
                                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                                    preparedStatement.execute();
                                    ResultSet rs  = preparedStatement.executeQuery(query); 
                                    String csvFile = "/home/mfs/apps/ma_data/files/Activations.csv";
                                    FileWriter fstream = new FileWriter(csvFile);
                                    BufferedWriter out = new BufferedWriter(fstream);
                                    while (rs.next()) 
                                    {            
                                            out.write(rs.getString("Activator_msisdn") + ",");
                                            out.write(rs.getString("customer_msisdn") + ",");
                                            out.write(rs.getString("activation_time") + ",");
                                            out.write(rs.getString("agent_of_day"));
                                            out.newLine();
                                            /*out.write(System.getProperty("line.separator"));*/
                                    }
                                        System.out.println("Completed writing into text file");
                                    }
                                    else 
                                    {
                                            System.out.println("Failed to make connection!");
                                    }
                        }
                        catch (ClassNotFoundException e) 
                        {
                                System.out.println("Where is your PostgreSQL JDBC Driver? "
                                                + "Include in your library path!");
                                System.out.println("Jibambe");
                                //appLogger.logError(e.getMessage());
                                return;
                        } 
                        catch (SQLException e) 
                        {
                                e.printStackTrace();
                                //appLogger.logError(e.getMessage());
                        } 
                        catch (IOException e) 
                        {
                                e.printStackTrace();
                                //appLogger.logError(e.getMessage());
                        }

            }
    }

    private static class AuthorizedAagents 
    {
        	public void run()
                {
                            try 
                            {
                                    Class.forName("org.postgresql.Driver");
                                    Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.20.7:5432/tkl_market_activators", "mfstech","technical");
                                    if (connection != null) 
                                    {
                                            Statement stmt = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                ResultSet.CONCUR_UPDATABLE);
                                            String query = "select ma_msisdn,ma_fname,ma_lname,ma_region,ma_added_on, ma_added_by,added_via,location,issuspended from authorized_agents";
                                            PreparedStatement preparedStatement = connection.prepareStatement(query);
                                            preparedStatement.execute();
                                            ResultSet rs  =  preparedStatement.executeQuery(query); 
                                            String csvFile = "/home/mfs/apps/ma_data/files/Authorizedagents.csv";
                                            FileWriter fstream = new FileWriter(csvFile);
                                            BufferedWriter out = new BufferedWriter(fstream);
                                            while (rs.next()) 
                                            {            
                                                    fstream.write(rs.getString(1) + ",");
                                                    fstream.write(rs.getString(2) + ",");
                                                    fstream.write(rs.getString(3) + ",");
                                                    fstream.write(rs.getString(4) + ",");
                                                    fstream.write(rs.getString(5) + ",");
                                                    fstream.write(rs.getString(6) + ",");
                                                    fstream.write(rs.getString(7) + ",");
                                                    fstream.write(rs.getString(8) + ",");
                                                    fstream.write(rs.getString(9)+"\n");
                                                    //((BufferedWriter) fstream).newLine();
                                            /*out.write(System.getProperty("line.separator"));*/ 
                                            }
                                     //System.out.println("Completed writing into text file");
                                    }
                                    else 
                                    {
                                            System.out.println("Failed to make connection!");
                                    }
                            }
                            catch (ClassNotFoundException e) 
                            {
                                    System.out.println("Where is your PostgreSQL JDBC Driver? "
                                                    + "Include in your library path!");
                                    
                                    System.out.println("Ufala");
                                    e.printStackTrace();
                                    //appLogger.logError(e.getMessage());
                                    return;
                            } 
                            catch (SQLException e) 
                            {
                                    e.printStackTrace();
                                    //appLogger.logError(e.getMessage());
                            } 
                            catch (IOException e) 
                            {
                                    e.printStackTrace();
                                    //appLogger.logError(e.getMessage());
                            }

                }
    }
    
}
