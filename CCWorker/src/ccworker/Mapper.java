/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccworker;

import cc.db.Inserts;
import cc.db.Selects;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author ramson
 */
public class Mapper {

    private String date, time, duration, calling_number, agent;
    private Selects sel = null;

    public void map() throws ParseException {
        GetDateTime datetime = new GetDateTime();
        File root = new File("/home/avaya/cdr_landing/");
        String[] extentions = {"txt"};
        boolean recursive = true;

        double count = 0, countBuffer = 0, countLine = 0;
        String lineNumber = "";
        String filePath;

        BufferedReader br;
        //String inputSearch = number;
        String line = "";

        Collection files = FileUtils.listFiles(root, extentions, recursive);
        for (Iterator iterator = files.iterator(); iterator.hasNext();) {
            File file = (File) iterator.next();
            //try {
            filePath = file.getAbsolutePath();

            Timestamp calling_time;
            try {
                br = new BufferedReader(new FileReader(filePath));
                while ((line = br.readLine()) != null) {
                    count++;
                    String[] words = line.split("\\|");
                    System.out.println("---------------------------------------------------------------------------------------------");
                    // check if line length is ok
                    if (words.length >= 5) {
                        // Check if agent
                        date = words[0];
                        time = words[1];
                        duration = words[2];
                        calling_number = words[3];
                        agent = words[4];
                        System.out.println(date + "!!!!!!!!!!!!!!!");
                        // Check if it is the right agent
                        if (agent.startsWith("57") && agent.length() == 5 && Integer.parseInt(duration) >= 120 && !isValidText(agent, "[57150|57151|57152|57153|57154|57155|57157|57158|57160|57161|57162|57163]")) {
                            sel = new Selects();
                            // Check if the customer had already received an SMS
                            if (!sel.hasAlreadyReceivedSMS(calling_number.replaceAll("^", "254"))) {
                                DateFormat df = new SimpleDateFormat("MMddyyhhmm");
                                Date ufDate = (Date) df.parse(date + time);
                                calling_time = new java.sql.Timestamp(ufDate.getTime());
                                //System.out.println(calling_time.toString());
                                //System.out.println(duration);
                                //System.out.println(calling_number);
                                //System.out.println(agent);

                                /* Send SMS to customer
                                 =========================
                                 */
                                // Select level 1 SMS message
                                //------------------------------
                                // ********** Please Complete first thing on Monday************
                                String level1Message = sel.getMessageAt(1);

                                // Call the SMS function
                                sendSMS(calling_number.replaceAll("^", "254"), level1Message.replaceAll(" ", "+"));

                                // Save the customer details and message level in DB
                                //----------------------------------------------------
                                // ********** Please Complete first thing on Monday************
                                // public void saveSentSMS(Timestamp time_called, String msisdn, String agent_id, int state, Timestamp time_sms_sent) {
                                Inserts ins = new Inserts();
                                ins.saveSentSMS(calling_time, calling_number.replaceAll("^", "254"), agent, 1, datetime.getTimeNow());
                            }

                        }

                    } else {
                        // report to Info.log
                        System.out.println("Problems");
                    }
                    System.out.println(count);
                }
                System.out.println("1");
                br.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.out.println(ex.getCause());
                ex.printStackTrace();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            //} catch (FileNotFoundException e) {
            //JOptionPane.showMessageDialog(null, e);
            //}
        }
    }

    public static boolean isValidText(String text, String expression) {
        CharSequence inputStr = text;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }

    public void sendSMS(String msisdn, String message) throws MalformedURLException, ProtocolException, IOException {
        String url = "http://localhost:13013/cgi-bin/sendsms?username=tester&password=foobar&to=" + msisdn + "&from=25470012&text=" + message + "";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        // For later use (Logging)
        int responseCode = con.getResponseCode();
    }

    public void map(String pathUrl) throws ParseException {

    }
}
