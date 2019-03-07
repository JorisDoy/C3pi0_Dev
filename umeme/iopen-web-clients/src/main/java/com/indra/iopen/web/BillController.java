package com.indra.iopen.web;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.service.BillService;

@Controller
@RequestMapping("/client/bill/download")
public class BillController {

	@Autowired
	private BillService billService;

	@RequestMapping(value = "/{id}", method = { RequestMethod.GET })
	public String billDownload(@PathVariable(value = "id") final Long billId, final HttpServletRequest request,
			final HttpServletResponse response) {

		try {
			// get output stream of the response
			final OutputStream outStream = response.getOutputStream();
			final ByteArrayOutputStream outputStream = billService.generateBill(billId);

			// set content attributes for the response
			response.setContentType("application/pdf");
			response.setContentLength(outputStream.size());

			// set headers for the response
			final String headerKey = "Content-Disposition";
			final String headerValue = String.format("attachment; filename=\"%s\"", "billing.pdf");
			response.setHeader(headerKey, headerValue);

			outStream.write(outputStream.toByteArray());

			outStream.close();
			outputStream.close();
		} catch (final DataIntegrityException de) {

			// ErrorInfo errorInfo = new ErrorInfo(de.getMessage(),
			// HttpStatus.CONFLICT);
			de.printStackTrace();
			// SMA 20160412
			try {
				return "redirect:/client/contract/bills?errorInfo=" + URLEncoder.encode(de.getMessage(), "UTF-8");
			} catch (final UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "redirect:/client/contract/bills";
			}
		} catch (final Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping(value = "/view", method = { RequestMethod.GET })
	public String viewBill(@RequestParam(value = "billNumber", required = true) Long billNumber,
			final HttpServletRequest request, final HttpServletResponse response) {

		try {
			// get output stream of the response
			final OutputStream outStream = response.getOutputStream();
			final ByteArrayOutputStream outputStream = billService.generateViewBill(billNumber);

			// set content attributes for the response
			response.setContentType("application/pdf");
			response.setContentLength(outputStream.size());

			// set headers for the response
			final String headerKey = "Content-Disposition";
			final String headerValue = String.format("attachment; filename=\"%s\"", "billing.pdf");
			response.setHeader(headerKey, headerValue);

			outStream.write(outputStream.toByteArray());

			outStream.close();
			outputStream.close();
		} catch (final DataIntegrityException de) {

			// ErrorInfo errorInfo = new ErrorInfo(de.getMessage(),
			// HttpStatus.CONFLICT);
			de.printStackTrace();

			return "redirect:/client/contract/bills?errorInfo=" + de.getMessage();
		} catch (final Exception e) {

			e.printStackTrace();
		}

		return null;
	}

}
