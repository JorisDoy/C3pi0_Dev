/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ke.telkom.paybill.paybillreports;

import co.ke.telkom.paybill.paybillreports.Utils.DB.PG_DataSource;
import co.ke.telkom.paybill.paybillreports.Utils.DB.Selects;
import co.ke.telkom.paybill.paybillreports.Utils.Props;
import co.ke.telkom.paybill.paybillreports.Utils.SendMail;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.sql.DataSource;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author jdmwamburi
 */
public class PaybilReports {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
        // TODO code application logic here
        PaybilReports pr = new PaybilReports();
        DataSource pg_datasource = PG_DataSource.getInstance().getDataSource();
        Selects sel = new Selects();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        
        // get previous date
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Calendar c = Calendar.getInstance();
        c.setTime(ts);
        c.add(Calendar.DATE, -1);
        
        // get props
        //Props props = new Props();
        
        Timestamp prev_day = new Timestamp(c.getTimeInMillis());
        String day = sdf.format(prev_day);
        
        String transaction_status = "successful";
        
        //System.out.println(query_string);
        // String all_validation_req, String failed_validations, String successful_validations, String total_confirmation_req, String total_amount, String success_count, String failed_count, String total_failed, String total_success
        String all_validation_req = sel.getTotalValidationsOn(pg_datasource, day);
        String failed_validations = sel.getTotalFailedValidationsOn(pg_datasource, day, transaction_status);
        String successful_validations = sel.getTotalSuccessfulValidationsOn(pg_datasource, day, transaction_status);
        String total_confirmation_req = sel.getTotalConfirmationsOn(pg_datasource, day);
        String total_amount = sel.getSumTotalTopupConfirmationsOn(pg_datasource, day);
        String success_count = sel.getTotalSuccessfulConfirmationsOn(pg_datasource, day, transaction_status);
        String failed_count = sel.getTotalFailedConfirmationsOn(pg_datasource, day, transaction_status);
        String total_failed = sel.getSumFailedTopupConfirmationsOn(pg_datasource, day, transaction_status);
        String total_success = sel.getSumSuccessfulTopupConfirmationsOn(pg_datasource, day, transaction_status);
        String total_amount_failed_validation = sel.getTotalAmountFailedValidationsOn(pg_datasource, day, transaction_status);
        Map<String, Object[]> validation_report = sel.getValidationReport(pg_datasource, day, transaction_status);
        String file_path = pr.genReport(validation_report);
        
        //SendMail sm = new SendMail(props);
        //sm.send(all_validation_req, failed_validations, successful_validations, total_confirmation_req, total_amount, success_count, failed_count, total_failed, total_success, total_amount_failed_validation, file_path);
    }
    
    public String genReport(Map<String, Object[]> data){
        java.util.Date date = new java.util.Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        String file_path = "";
        
        try {
            //GetDateTime gdt = new GetDateTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String report_name = "Paybill_report" + sdf.format(ts) + ".xlsx";
            file_path = "/home/app/reports/" + report_name;
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Paybill Failed Validation Report");
            sheet.setColumnWidth(0, 8000);

            XSSFCellStyle style6 = workbook.createCellStyle();
            Color col = new HSSFColor();
            style6.setFillBackgroundColor(HSSFColor.LEMON_CHIFFON.index);
            style6.setAlignment(HorizontalAlignment.CENTER);
            sheet.setColumnWidth(1, 8000);
            XSSFRow row;

            Map<String, Object[]> emp_info = new TreeMap<>();
            emp_info.put("1", new Object[]{"777711 Report"});
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
            String generation_time = sdf2.format(ts.getTime());
            emp_info.put("2", new Object[]{"Report Generated on", generation_time});

            // iterate over data and write to sheet
            Set<String> keyid = emp_info.keySet();

            int rowid = 0;

            for (String key : keyid) {
                row = sheet.createRow(rowid++);
                Object[] objarr = emp_info.get(key);
                int cellid = 0;

                for (Object obj : objarr) {
                    Cell cell = row.createCell(cellid++);
                    sheet.setColumnWidth(cellid, 8000);
                    cell.setCellValue((String) obj);
                }
            }

            emp_info.clear();
            emp_info.put("1", new Object[]{"Total Ocurences", "Failure message", "Total Amount"});
            rowid = 1 + rowid;

            row = sheet.createRow(rowid);
            Object[] objarr = emp_info.get("1");
            int cellid = 0;

            for (Object obj : objarr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellStyle(style6);
                sheet.setColumnWidth(cellid, 8000);
                cell.setCellValue((String) obj);
            }
            
            emp_info.clear();
            Selects sel = new Selects();
            PG_DataSource pg_ds = PG_DataSource.getInstance();
            //Map<String, Object[]> emp_info2 = sel.getIncidenses(pg_ds.getDataSource());
            rowid = 1 + rowid;
            
            if(data.isEmpty()){
                //sm.sendMailContent(Configs.MAIL_EMPTY_CONTENT);
            } else {
                Set<String> keyid2 = data.keySet();
            
            for (String key : keyid2) {
                row = sheet.createRow(rowid++);
                Object[] objarr2 = data.get(key);
                cellid = 0;

                for (Object obj : objarr2) {
                    Cell cell = row.createCell(cellid++);
                    sheet.setColumnWidth(cellid, 8000);
                    cell.setCellValue((String) obj);
                }
            }

            // write the workbook in filesystem
            FileOutputStream out = new FileOutputStream(new File(file_path), true);
            workbook.write(out);
            out.close();
            System.out.println("File Writen successfully");            
            // Send e-mail
            //sm.send(Configs.MAIL_CONTENT, file_path);
            }
            
            
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        
        return file_path;
    }
}
