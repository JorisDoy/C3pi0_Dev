/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package failed.ejaze.retry.topups.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author jdmwamburi
 */
public class Updates 
{
    public Connection con;
    public PreparedStatement ps;
    public ResultSet rs;
    private static final Logger logger = Logger.getLogger(Updates.class.getName());
    public synchronized void updateFailedRetryStatus(String mpesaID,String status)
    {     
        try
        {
           Class.forName("org.postgresql.Driver"); 
           String sql="UPDATE public.confirmation SET retry_status_code=? WHERE transid=?";
           PG_DataSource conn = new PG_DataSource();
           con = conn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, status);
           ps.setString(2, mpesaID);
           ps.executeUpdate();           
           //close connections
           con.close();
           ps.close();
        }
        catch(SQLException e) 
        {  
           logger.error(e);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Updates.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
