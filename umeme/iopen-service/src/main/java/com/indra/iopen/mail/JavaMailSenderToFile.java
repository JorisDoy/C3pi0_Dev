package com.indra.iopen.mail;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class JavaMailSenderToFile implements JavaMailSender {

	private static final Logger logger = LoggerFactory.getLogger(JavaMailSenderToFile.class);

	private String mailDestinationFolder;

	private Random random = new Random(54654132);

	public String getMailDestinationFolder() {
		return mailDestinationFolder;
	}

	public void setMailDestinationFolder(String mailDestinationFolder) {
		this.mailDestinationFolder = mailDestinationFolder;
	}

	private String getUniqueFilename(SimpleMailMessage mail) {
		String filename = "";

		filename += mail.getTo()[0];
		filename += "_";
		filename += mail.getSentDate().toString();
		filename += "_";
		filename += random.nextInt();

		filename = filename.replace(" ", "_");
		filename = filename.replace(":", "_");
		filename = filename.replace("-", "_");
		filename = filename.replace(".", "_");
		filename = filename.replace("@", "_at_");

		filename += ".html";

		return filename.toString();
	}

	private String getUniqueFilename(MimeMessage mail) throws MessagingException {
		String filename = "";

		filename += mail.getAllRecipients()[0].toString();
		filename += "_";
		filename += mail.getSentDate().toString();
		filename += "_";
		filename += random.nextInt();

		filename = filename.replace(" ", "_");
		filename = filename.replace(":", "_");
		filename = filename.replace("-", "_");
		filename = filename.replace(".", "_");
		filename = filename.replace("@", "_at_");

		filename += ".html";

		return filename.toString();
	}

	@Override
	public void send(SimpleMailMessage mail) throws MailException {
		try {

			String content = mail.getText();

			File file = new File(
					this.mailDestinationFolder
							+ File.separator
							+ this.getUniqueFilename(mail));

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

		} catch (IOException e) {
			logger.error(e.getMessage());
		}

	}

	@Override
	public void send(SimpleMailMessage... mails) throws MailException {
		for (SimpleMailMessage simpleMailMessage : mails) {
			this.send(simpleMailMessage);
		}

	}

	@Override
	public MimeMessage createMimeMessage() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.example.com");
		properties.put("mail.smtp.port", "25");
		Session session = Session.getDefaultInstance(properties);
		return new MimeMessage(session);
	}

	@Override
	public MimeMessage createMimeMessage(InputStream arg0) throws MailException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void send(MimeMessage mimeMail) throws MailException {
		try {

			String content = (String) mimeMail.getContent();

			File file = new File(
					this.mailDestinationFolder
							+ File.separator
							+ this.getUniqueFilename(mimeMail));

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void send(MimeMessage... arg0) throws MailException {
		for (MimeMessage mimeMessage : arg0) {
			this.send(mimeMessage);
		}

	}

	@Override
	public void send(MimeMessagePreparator arg0) throws MailException {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(MimeMessagePreparator... arg0) throws MailException {
		// TODO Auto-generated method stub

	}

}