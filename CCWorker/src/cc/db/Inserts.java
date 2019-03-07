/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.db;

/**
 *
 * @author ramson
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Inserts {

    public Connection con;

    public PreparedStatement ps;

    public ResultSet rs;

    public Statement stmt;

    public void saveSentSMS(Timestamp time_called, String msisdn, String agent_id, int state, Timestamp time_sms_sent) {
        try {
            String sql = "insert into sent_sms (time_called, msisdn, agent_id, state, time_sms_sent, response_time) values(?,?,?,?,?,?)";
            Pg_Con conn = new Pg_Con();
            con = conn.createConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setTimestamp(1, time_called);
            pstmt.setString(2, msisdn);
            pstmt.setString(3, agent_id);
            pstmt.setInt(4, state);
            pstmt.setTimestamp(5, time_sms_sent);
            pstmt.setTimestamp(6, time_sms_sent);
            int count = pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
