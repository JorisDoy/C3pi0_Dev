/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maexporter;

import java.beans.Statement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jdmwamburi
 */
class Activations 
{
    public void run() throws SQLException, IOException
            {
                        try 
                        {
                            Class.forName("org.postgresql.driver");//oracle.jdbc.driver.OracleDriver
                            Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.20.7:5432/tkl_market_activators", "mfstech","technical");
                                if (connection != null) 
                                {
                                    Statement stmt = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                            ResultSet.CONCUR_UPDATABLE);
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
