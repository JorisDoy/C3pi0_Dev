package com.indra.iopen.form.export;

import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.indra.iopen.form.ApplicationList;

public class ApplicationListExport {
	private List<ApplicationList> applicationList = null;

	public ApplicationListExport(List<ApplicationList> applicationList) {
		this.applicationList = applicationList;
	}

	public void export(HttpServletResponse response) {
		try (OutputStream out = response.getOutputStream();) {
			Workbook workbook = new HSSFWorkbook();

			// create a new Excel sheet
			Sheet sheet = workbook.createSheet("Applications");
			sheet.setDefaultColumnWidth(30);

			// create style for header cells
			CellStyle style = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setFontName("Arial");
			style.setFillForegroundColor(HSSFColor.BLUE.index);
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font.setColor(HSSFColor.WHITE.index);
			style.setFont(font);

			// create header row
			Row header = sheet.createRow(0);

			header.createCell(0).setCellValue("Application Number");
			header.getCell(0).setCellStyle(style);

			header.createCell(1).setCellValue("Application Type");
			header.getCell(1).setCellStyle(style);

			header.createCell(2).setCellValue("Application Date");
			header.getCell(2).setCellStyle(style);

			header.createCell(3).setCellValue("Application Status");
			header.getCell(3).setCellStyle(style);

			header.createCell(4).setCellValue("Application Current Stage");
			header.getCell(4).setCellStyle(style);

			header.createCell(5).setCellValue("Application Comment");
			header.getCell(5).setCellStyle(style);

			// create data rows
			int rowCount = 1;

			for (ApplicationList applicationList2 : applicationList) {
				Row aRow = sheet.createRow(rowCount++);
				aRow.createCell(0).setCellValue(applicationList2.getApplicationNumber());
				aRow.createCell(1).setCellValue(applicationList2.getApplicationType());
				aRow.createCell(2).setCellValue(applicationList2.getApplicationDate());
				aRow.createCell(3).setCellValue(applicationList2.getApplicationStatus());
				aRow.createCell(4).setCellValue(applicationList2.getApplicationCurrentStage());
				aRow.createCell(5).setCellValue(applicationList2.getApplicationComment());
			}

			response.setHeader("Content-Disposition", "inline; filename=applicationList-" + new Date() + " .xls");
			// Make sure to set the correct content type
			response.setContentType("application/vnd.ms-excel");
			sheet.getWorkbook().write(out);
			response.flushBuffer();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
