package com.indra.iopen.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.zip.Inflater;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyHtmlSerializer;
import org.htmlcleaner.TagNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.model.ImagenesXml;
import com.indra.iopen.model.Recibo;
import com.indra.iopen.repositories.model.ImagenesXmlRepository;
import com.indra.iopen.repositories.model.ReciboRepository;
import com.indra.iopen.service.BillService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class BillServiceImpl implements BillService {

	private static final Logger logger = LoggerFactory.getLogger(BillServiceImpl.class);

	// Declaration of RegExp used to clean the generated HTML

	private static String REGEXP_REMOVE_META = "<META[\\sa-z-=\"A-Z\\/;0-9]*>";
	private static String REGEXP_REMOVE_EMPTY_TABLES = "<table[a-zA-Z0-9=\" ]*>[ \\r\\t\\n]*</table>";
	private static String REGEXP_REMOVE_EMPTY_ROWS = "<tr[a-zA-Z0-9=\" ]*>[ \\r\\t\\n]*</tr>";

	private Transformer xformer;

	private final HtmlCleaner cleaner;

	private final PrettyHtmlSerializer htmlSerializer;

	@Autowired
	private ImagenesXmlRepository imagenesXmlRepository;

	@Autowired
	private ReciboRepository reciboRepository;

	@Value("${billing.service.xsl.template.filename}")
	private String xslTemplateFileName;

	@Autowired
	private Environment env;

	public BillServiceImpl() throws TransformerConfigurationException, FileNotFoundException {
		super();

		// create an instance of HtmlCleaner
		cleaner = new HtmlCleaner();

		final CleanerProperties props = cleaner.getProperties();
		// set some properties to non-default values
		props.setTranslateSpecialEntities(true);
		props.setTransResCharsToNCR(true);
		props.setOmitComments(true);

		htmlSerializer = new PrettyHtmlSerializer(props);
	}

	// This method applies the xslFilename to inFilename and writes
	// the output to outFilename.
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.indra.exampleapp.service.BillService#generateBill(java.lang.String)
	 */
	@Override
	public ByteArrayOutputStream generateBill(final Long billId) throws Exception {
		ByteArrayOutputStream output = null;
		// try {
		final TransformerFactory transformerFactory = TransformerFactory.newInstance();
		final URL url = this.getClass().getResource("/" + env.getProperty("billing.service.xsl.template.filename"));
		final File file = new File(url.getPath());
		final Templates xslTemplate = transformerFactory.newTemplates(new StreamSource(new FileInputStream(file)));

		// Use the template to create a transformer
		xformer = xslTemplate.newTransformer();

		// get de xml data from the imagenes_xml entity
		final ImagenesXml xmlBillcontent = imagenesXmlRepository.findImagenesXmlByStatementId(billId);

		if (xmlBillcontent == null) {
			throw new DataIntegrityException("Bill " + billId + " not yet generated");
		}
		final String xmlContentS = new String(xmlBillcontent.getXmlData());

		final byte[] uncompressedBytes = extractBytes(xmlBillcontent.getXmlData());
		final String xmlContentB = new String(uncompressedBytes);
		logger.debug("BEGIN OF XML BILL TO BE PARSED");
		logger.debug(xmlContentS);

		logger.debug("---------------------------------------");

		logger.debug(xmlContentB);

		logger.debug("END OF XML BILL TO BE PARSED");
		// Prepare the input and output files
		// final Source source = new StreamSource(new
		// ByteArrayInputStream(xmlBillcontent.getXmlData()));
		final Source source = new StreamSource(new ByteArrayInputStream(uncompressedBytes));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		final Result result = new StreamResult(outputStream);

		// Apply the xsl file to the source file and write the result to the
		// output file
		xformer.transform(source, result);

		final String outputHtml = new String(outputStream.toByteArray(), StandardCharsets.UTF_8);
		outputStream = new ByteArrayOutputStream();
		outputStream.write(outputHtml.getBytes(StandardCharsets.ISO_8859_1));

		output = this.pdf(outputHtml);

		// } catch (final TransformerConfigurationException e) {
		// e.printStackTrace();
		// } catch (final TransformerException e) {
		// e.printStackTrace();
		// } catch (final IOException e) {
		// e.printStackTrace();
		// }

		return output;
	}

	private static byte[] extractBytes(byte[] input) {

		byte[] output = new byte[65536];
		try {
			Inflater ifl = new Inflater(); // mainly generate the extraction

			ifl.setInput(input);

			ByteArrayOutputStream baos = new ByteArrayOutputStream(input.length - 1);
			byte[] buff = new byte[65536];
			while (!ifl.finished()) {
				int count = ifl.inflate(buff);
				baos.write(buff, 0, count - 1);
			}
			baos.close();
			output = baos.toByteArray();
			System.out.println("Original: " + input.length);
			System.out.println("Extracted: " + output.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;// new String(output);
	}

	private String cleanHTML(final String html) {
		TagNode tagNode;
		String cleanedHtml = "";

		// do parsing
		tagNode = cleaner.clean(html);

		cleanedHtml = htmlSerializer.getAsString(tagNode);
		cleanedHtml = cleanedHtml.replaceAll(REGEXP_REMOVE_META, "");
		cleanedHtml = cleanedHtml.replaceAll(REGEXP_REMOVE_EMPTY_TABLES, "");
		cleanedHtml = cleanedHtml.replaceAll(REGEXP_REMOVE_EMPTY_ROWS, "");

		return cleanedHtml;
	}

	@SuppressWarnings("deprecation")
	private ByteArrayOutputStream pdf(String outputStream) {
		final ByteArrayOutputStream generatedPdf = new ByteArrayOutputStream();
		try {
			final Document document = new Document(PageSize.A4.rotate());
			outputStream = this.cleanHTML(outputStream);

			PdfWriter.getInstance(document, generatedPdf);
			document.open();
			document.addCreationDate();

			final HTMLWorker htmlWorker = new HTMLWorker(document);
			htmlWorker.parse(new StringReader(outputStream));
			document.close();

		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (final DocumentException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return generatedPdf;
	}

	@Override
	public ByteArrayOutputStream generateViewBill(Long billNumber) throws Exception {
		ByteArrayOutputStream output = null;
		Long statementId;
		String tariff;
		Long grConcepto;

		Recibo recibo = reciboRepository.findOne(billNumber);
		statementId = recibo.getIdStatement().longValue();
		tariff = recibo.getCodTar();
		grConcepto = recibo.getGrConcepto().longValue();

		// get xml from db
		final ImagenesXml xmlBillcontent = imagenesXmlRepository.findImagenesXmlByStatementId(statementId);

		if (xmlBillcontent == null) {
			throw new DataIntegrityException("Bill " + billNumber + " not yet generated");
		}

		// get the uncompressed xml
		final byte[] uncompressedBytes = extractBytes(xmlBillcontent.getXmlData());

		// transform the xml to pdf
		output = transform2PDF(new String(uncompressedBytes), tariff, grConcepto);

		return output;
	}

	public ByteArrayOutputStream transform2PDF(String xmlData, String sTariff, Long grConcepto) throws Exception {

		ByteArrayOutputStream generatedPdf = new ByteArrayOutputStream();

		// Setup directories
		File baseDir = new File(".");

		// Setup input and output files
		File xmlfile = new File(baseDir, "projectteam.xml");
		File xsltfile = null;

		if (sTariff.equals("110")) {
			xsltfile = new File(this.getClass().getResource("/xsldomestic.xsl").getFile());
		} else if ((sTariff.equals("410")) && (grConcepto != 3)) {
			xsltfile = new File(this.getClass().getResource("/xslsmallcom.xsl").getFile());
		} else {
			xsltfile = new File(this.getClass().getResource("/xslothers.xsl").getFile());
		}

		System.out.println(xsltfile.getAbsolutePath());

		// configure fopFactory as desired

		FileWriter outXml = new FileWriter(xmlfile);
		PrintWriter ou = new PrintWriter(outXml);
		ou.write(xmlData);
		ou.close();

		FopFactory fopFactory = FopFactory.newInstance(new File("F://temp//fop.xconf"));

		// Construct fop with desired output format
		Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, generatedPdf);

		// Setup XSLT
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(new StreamSource(xsltfile));

		// Set the value of a <param> in the stylesheet
		transformer.setParameter("versionParam", "2.0");

		// Setup input for XSLT transformation
		Source src = new StreamSource(xmlfile);

		// Resulting SAX events (the generated FO) must be piped through to
		// FOP
		Result res = new SAXResult(fop.getDefaultHandler());

		// Start XSLT transformation and FOP processing
		transformer.transform(src, res);

		return generatedPdf;
	}
}
