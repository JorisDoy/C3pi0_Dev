/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccworker;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author ramson
 */
public class CCWorker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
//        String isdn = "771340645";
//        System.out.println(isdn.replaceAll("^", "254"));
//        String call_time = "0514171223";
//        DateFormat df = new SimpleDateFormat("MMddyyhhmm");
//        Date ufDate = (Date) df.parse(call_time);
//        System.out.println(df.parse(call_time).toString());
//        DateFormat pdf = new SimpleDateFormat("yyyy-MM-ddhhmm");
//        Date fDate = (Date) pdf.parse(pdf.format(ufDate));
//        System.out.println(pdf.parse(pdf.format(df.parse(call_time))).toString());
//        System.out.println(fDate.toString());
//        Timestamp timestamp = new java.sql.Timestamp(ufDate.getTime());
//        System.out.println(timestamp.toString());
//        String agent = "57999";
//        if(agent.startsWith("57") && agent.length() == 5){
//            System.out.println("Hell yeah!");
//        }
//        Mapper ccw = new Mapper();
//        ccw.map();
//        
//        DateTime dt1 = new DateTime(timestamp);
//        GetDateTime gdt = new GetDateTime();
//        DateTime dt2 = new DateTime(gdt.getTimeNow());
//        
//        int check = Days.daysBetween(dt1, dt2).getDays();
//        System.out.println("Days btwn " + check);
        
        Mapper mapper = new Mapper();
        mapper.map();
        
    }
    
}
