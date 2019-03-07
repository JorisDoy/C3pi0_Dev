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
import ccworker.GetDateTime;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;
import org.joda.time.Days;

public class Selects {

    public Connection con;

    public PreparedStatement ps;

    public ResultSet rs;

    public Statement st;

    // Check whether the customer had received any sms previously
    public boolean hasAlreadyReceivedSMS(String msisdn) {
        boolean hasReceived = true;
        try {
            String sql = "select time_sms_sent from sent_sms where msisdn = ? order by rec_id desc limit 1";
            Pg_Con conn = new Pg_Con();
            con = conn.createConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, msisdn);
            rs = ps.executeQuery();

            if (rs.next()) {
                // get the time the sms was sent previously (within 24 hrs)
                Timestamp time_sms_was_sent = rs.getTimestamp("time_sms_sent");
                // get the time now
                GetDateTime dt = new GetDateTime();

                DateTime dtSmsSent = new DateTime(time_sms_was_sent);
                DateTime timeNow = new DateTime(dt.getTimeNow());

                int check = Days.daysBetween(dtSmsSent, timeNow).getDays();

                if (check > 0) {
                    hasReceived = false;
                }
            } else {
                hasReceived = false;
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        

        return hasReceived;
    }

    public String getMessageAt(int state) {
        String message = "";
        try {
            String sql = "select message from messages where state_id = ?";
            Pg_Con conn = new Pg_Con();
            con = conn.createConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, state);
            rs = ps.executeQuery();

            while (rs.next()) {
                message = rs.getString("message");
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return message.replaceAll(" ", "+");
    }
}
