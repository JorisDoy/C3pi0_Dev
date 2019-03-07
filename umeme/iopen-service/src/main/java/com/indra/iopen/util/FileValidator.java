package com.indra.iopen.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartFile;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.form.Application;
import com.indra.iopen.service.ApplicationService;

@Component
public class FileValidator{
	
	@Autowired
	private ConfigurableEnvironment env;
	
	@Autowired
	ApplicationService applicationService;
	
	@Value( "${file.application.input.max.files}" )
	private int maxFiles;
	@Value( "${file.application.input.min.files}" )
	private int minFiles;
	@Value( "${file.application.input.max.file.size}" )
	private int maxSize;
	@Value( "${file.application.allowed.file.extensions}" )
	private String extensions;
	@Autowired
	private MessageSource messageSource;
	
	
	public void validate(Object target, Errors errors) throws Exception {
		// TODO Auto-generated method stub
		Application application = (Application)target;
		
		
		@SuppressWarnings("unchecked")
		final List<String> allowedTypes = env.getProperty("file.application.allowed.file.extensions", List.class);
		
		List<MultipartFile> files = application.getFiles();
		int uploadedSize = 0;
		if(application.getCodApplication() != null)
		 uploadedSize = applicationService.findIopenApplicationByCodApplication(application.getCodApplication()).getIopenApplicationDocs().size();
		
		int size = files.size() + uploadedSize;

		if ( size > maxFiles) {

			//errors.rejectValue("files", "application.error.max.files", new Object[] { maxFiles }, null);
			 throw new DataIntegrityException(messageSource.getMessage("application.error.max.files",	new Object[] { maxFiles },null));
			
		}

		if (size < minFiles) {
			//errors.rejectValue("files", "application.error.min.files", new Object[] { minFiles }, null);
			throw new DataIntegrityException(messageSource.getMessage("application.error.min.files",	new Object[] { minFiles },null));
		}

		for (final MultipartFile multipartFile : files) {
			if (multipartFile.getSize() > maxSize) {
				//errors.rejectValue("files", "application.error.max.filesize",new Object[] { multipartFile.getOriginalFilename(), maxSize }, null);
				throw new DataIntegrityException(messageSource.getMessage("application.error.max.filesize",	new Object[] { multipartFile.getOriginalFilename(), maxSize },null));
			}
			if (!allowedTypes.contains(multipartFile.getContentType())) {
				//errors.rejectValue("files", "application.error.valid.type",new Object[] { multipartFile.getOriginalFilename(),env.getProperty("file.application.allowed.file.extensions") },null);
				throw new DataIntegrityException(messageSource.getMessage("application.error.valid.type",	new Object[] { multipartFile.getOriginalFilename(), extensions },null));
			}
		}
		
	}

}
