/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paybill.to.ejaze.retrys.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import paybill.to.ejaze.retrys.EjazeRetrys;

/**
 *
 * @author jdmwamburi
 */
public class Updates 
{
    public Connection con;
    public PreparedStatement ps;
    public ResultSet rs;
    private static final Logger logger = Logger.getLogger(EjazeRetrys.class.getName());
    //Update the confirmation table with message, txn_status_id, txn_status_code, ocs_topups, retry_status_code
    public void updateConfirmationData(String mpesaid, String message_confirmation, 
            String txn_status_code, String txn_status_id, String ocs_topups, String retry_status_code)
    {
        String sql ="update confirmation SET message = ?, txn_status_code=?, txn_status_id =?, ocs_topups =?, retry_status_code=? where  transid = ?";
        try 
        {
            PG_DataSource datasource = new PG_DataSource();
            con = datasource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, message_confirmation);
            ps.setString(2, txn_status_code);
            ps.setString(3, txn_status_id);
            ps.setString(4, ocs_topups);
            ps.setString(5, retry_status_code);
            ps.setString(6, mpesaid);
            int v = ps.executeUpdate();

            con.close();
            ps.close();
        } 
        catch (SQLException ex) 
        {
            logger.info(ex);
        }
        finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) 
            {
                logger.fatal("SQLError while closing connections: " + ex.getMessage());
            }
        }
    }
}
