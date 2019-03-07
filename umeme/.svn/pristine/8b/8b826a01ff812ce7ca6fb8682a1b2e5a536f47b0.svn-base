package com.indra.iopen.service.impl;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.indra.iopen.form.Application;
import com.indra.iopen.model.Callejero;
import com.indra.iopen.model.Localidade;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.repositories.model.CallejeroRepository;
import com.indra.iopen.repositories.model.LocalidadeRepository;
import com.indra.iopen.repositories.model.MunicipioRepository;
import com.indra.iopen.service.ApplicationService;
import com.indra.iopen.service.PDFService;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

@Service
public class PDFServiceImpl implements PDFService {
	@Autowired
	private Environment env;
	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private LocalidadeRepository localidadeRepository;
	@Autowired
	private CallejeroRepository callejeroRepository;
	@Autowired
	private ApplicationService applicationService;

	@Override
	public File createApplicationPDF(Long applicationNumber) throws Exception {
		String templateFilename = "/" + env.getProperty("application.service.pdf.template.filename");
		String sep = System.getProperty("file.separator");
		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String pdfFilename = System.getProperty("java.io.tmpdir") + sep + clientUser.getClienteProfile().getFullName()
				+ "-" + System.currentTimeMillis() + ".pdf";

		try (FileOutputStream fileOutputStream = new FileOutputStream(pdfFilename);) {
			PdfReader pdfTemplate = new PdfReader(getClass().getResource(templateFilename));
			PdfStamper stamper = new PdfStamper(pdfTemplate, fileOutputStream);

			stamper.setFormFlattening(true);
			Application application = applicationService.getIncompleteApplication(applicationNumber);
			AcroFields acroFields = stamper.getAcroFields();
			acroFields.setField("firstName", application.getFirstName());
			acroFields.setField("middleName", application.getMiddleName());
			acroFields.setField("surname", application.getSurname());
			acroFields.setField("idNumber", application.getIdNumber());
			acroFields.setField("tinNumber", application.getTinNumber());
			acroFields.setField("mobileNumber", application.getMobileNumber());
			acroFields.setField("officeNumber", application.getOfficeNumber());
			acroFields.setField("contactName", application.getContactName());
			acroFields.setField("contactNumber", application.getContactNumber());
			acroFields.setField("district", municipioRepository.findOne(application.getDistrict()).getNomMunic());
			Callejero callejero = callejeroRepository.findOne(application.getStreet().longValue());
			Localidade locality = localidadeRepository.findOne(application.getVillage());
			acroFields.setField("village", locality.getNomLocal());
			acroFields.setField("street", callejero.getNomCalle());
			acroFields.setField("housePlot", application.getHousePlot());
			acroFields.setField("emailAddress", application.getEmailAddress());
			acroFields.setField(application.getApplicationType(), "true");
			if (application.getCustomerContactPerson() != null && !application.getCustomerContactPerson().isEmpty()) {
				acroFields.setField(application.getCustomerContactPerson().toLowerCase(), "true");
			}

			stamper.close();

			pdfTemplate.close();
		}

		return new File(pdfFilename);
	}

	@Override
	public File createTAC() throws Exception {

		String templateFilename = "/" + env.getProperty("application.service.pdf.template.filename");
		String sep = System.getProperty("file.separator");
		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String pdfFilename = System.getProperty("java.io.tmpdir") + sep + clientUser.getClienteProfile().getFullName()
				+ "-" + System.currentTimeMillis() + ".pdf";

		try (FileOutputStream fileOutputStream = new FileOutputStream(pdfFilename);) {
			PdfReader pdfTemplate = new PdfReader(getClass().getResource(templateFilename));
			PdfStamper stamper = new PdfStamper(pdfTemplate, fileOutputStream);

			stamper.setFormFlattening(true);
			stamper.close();

			pdfTemplate.close();
		}

		return new File(pdfFilename);

	}

}
