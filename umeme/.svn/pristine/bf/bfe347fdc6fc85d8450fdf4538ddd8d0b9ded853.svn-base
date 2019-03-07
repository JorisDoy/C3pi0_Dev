package com.indra.iopen.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.iopen.form.IOpenFile;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.IopenApplicationDoc;
import com.indra.iopen.model.IopenApplicationDocPK;
import com.indra.iopen.repositories.model.IopenApplicationDocRepository;
import com.indra.iopen.repositories.model.IopenApplicationRepository;
import com.indra.iopen.util.ApplicationDefault;

@Service
@Transactional(rollbackFor = { Exception.class })
public class LocalStorageFileService implements FileService {

	private static final Logger logger = LoggerFactory.getLogger(LocalStorageFileService.class);

	@Autowired
	private IopenApplicationDocRepository iopenDocRepository;

	@Autowired
	private IopenApplicationRepository iopenApplicationRepository;

	@Value("${file.service.local.storage.path}")
	private String localStoragePath;

	@Value("${file.application.allowed.file.separator}")
	private String fileSeparator;

	@Value("${file.application.allowed.file.content.class.default}")
	private String defaultContentClass;

	private final Random random = new Random();

	@Override
	public IOpenFile getFile(final Long codApplication, final String filename) throws FileNotFoundException {
		logger.info("BEGIN - getFile");
		IOpenFile iOpenFile = null;

		final IopenApplicationDoc appDoc = iopenDocRepository
				.findById(new IopenApplicationDocPK(codApplication, filename));
		if (appDoc == null) {
			logger.error("The file " + codApplication + " - " + filename + " do not exist on the system.");
			throw new FileNotFoundException(
					"The file " + codApplication + " - " + filename + " do not exist on the system.");
		}
		try {
			final byte[] data = readFileFromFileSystem(appDoc.getId().getTipDoc());

			iOpenFile = convertIopenApplicationDoc2IOpenFile(appDoc, data);
		} catch (final IOException e) {
			logger.error("Error while getting file contents : " + e.getLocalizedMessage());
		}

		logger.info("END - getFile");

		return iOpenFile;
	}

	@Override
	public List<IOpenFile> getFilesByApplication(final Long codApplication) throws FileNotFoundException {
		logger.info("BEGIN - getFilesByApplication");
		final List<IOpenFile> iOpenFiles = new ArrayList<>();

		final List<IopenApplicationDoc> appDocs = iopenDocRepository.findByIdCodApplication(codApplication);

		for (final IopenApplicationDoc iopenApplicationDoc : appDocs) {
			iOpenFiles.add(
					getFile(iopenApplicationDoc.getId().getCodApplication(), iopenApplicationDoc.getId().getTipDoc()));
		}

		logger.info("END - getFilesByApplication");
		return iOpenFiles;
	}

	// SMA 20160407
	@Override
	@Transactional(rollbackFor = { Exception.class })
	public IOpenFile saveFile(IopenApplicationDoc applicationDoc) throws Exception {
		IOpenFile iOpenFile = null;
		// final IopenApplicationDoc applicationDoc = new IopenApplicationDoc();

		final String uniqueFilename = generateUniqueFileName(applicationDoc.getId().getTipDoc());
		applicationDoc.getId().setTipDoc(getPhysicalFileFullPath(uniqueFilename));
		String contentClass = defaultContentClass;
		try {
			final String[] type_parts = applicationDoc.getContentType().split(fileSeparator);
			contentClass = type_parts[0];

		} catch (final Exception ex) {
			System.out.println("Exception getting the content class from " + applicationDoc.getContentType() + " : "
					+ ex.getMessage());
		}
		applicationDoc.setContentClass(contentClass);

		// save to filesystem
		writeFileToFileSystem(applicationDoc.getDoc(), applicationDoc.getId().getTipDoc());

		// save to database
		iopenDocRepository.save(applicationDoc);

		iOpenFile = convertIopenApplicationDoc2IOpenFile(applicationDoc, applicationDoc.getDoc());

		return iOpenFile;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Boolean updateFile(final IOpenFile file) throws Exception {
		final Boolean result = Boolean.FALSE;

		if (existFile(file.getCodApplication(), file.getStorageFilename())) {
			final IopenApplicationDoc applicationDoc = iopenDocRepository
					.findById(new IopenApplicationDocPK(file.getCodApplication(), file.getOriginalFilename()));

			applicationDoc.setContentType(file.getContentType());
			applicationDoc.setDocDesc(file.getOriginalFilename());
			applicationDoc.setFActual(file.getCreationDate());

			iopenDocRepository.save(applicationDoc);

			try {
				writeFileToFileSystem(file.getFile(), applicationDoc.getId().getTipDoc());
			} catch (final Exception e) {
				logger.error("Failed to write file on update ", e);
				throw new Exception(e.getLocalizedMessage());
			}
		}

		return result;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Boolean deleteFile(final Long codApplication, final String filename) {

		Boolean result = Boolean.FALSE;

		final IopenApplicationDoc applicationDoc = iopenDocRepository
				.findById(new IopenApplicationDocPK(codApplication, filename));

		if (applicationDoc == null) {
			return false;
		}

		// SMA 20160407
		final boolean tac = applicationDoc.getTac().equalsIgnoreCase("1") ? true : false;
		if (deletePhyshicalFile(applicationDoc.getId().getTipDoc())) {
			iopenDocRepository.delete(applicationDoc);
			result = Boolean.TRUE;
			if (tac) {
				final IopenApplication iopenApplication = iopenApplicationRepository.findOne(codApplication);
				iopenApplication.setComplete(new BigDecimal(0));
				iopenApplicationRepository.save(iopenApplication);
			}
		}

		return result;
	}

	private Boolean deletePhyshicalFile(final String fileName) {
		// try to delete the physical file
		final File file = new File(fileName);

		if (file.exists()) {
			file.delete();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean existFile(final Long codApplication, final String filename) {
		Boolean result = Boolean.FALSE;

		final IopenApplicationDoc applicationDoc = iopenDocRepository
				.findById(new IopenApplicationDocPK(codApplication, filename));

		if (applicationDoc == null) {
			return false;
		}

		if (existsPhyshicalFile(applicationDoc.getId().getTipDoc())) {
			result = Boolean.TRUE;
		}

		return result;
	}

	private Boolean existsPhyshicalFile(final String fileName) {
		// try to delete the physical file
		final File file = new File(getPhysicalFileFullPath(fileName));

		return file.exists();
	}

	private byte[] readFileFromFileSystem(final String fileName) throws IOException {
		final Path path = Paths.get(fileName);
		final byte[] file = Files.readAllBytes(path);
		return file;
	}

	private String generateUniqueFileName(final String originalFilename) {

		String fileName = "";

		fileName += random.nextInt();
		fileName += "_";
		fileName += originalFilename;
		fileName = fileName.replace(" ", "_");
		fileName = fileName.replace(":", "_");
		fileName = fileName.replace("-", "_");

		return fileName;
	}

	private void writeFileToFileSystem(final byte[] bytes, final String fileName) throws Exception {
		logger.info("BEGIN - writeFileToFileSystem");
		logger.info("Writing binary file...");

		try {
			OutputStream output = null;
			final File file = new File(fileName);
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
			try {
				output = new BufferedOutputStream(new FileOutputStream(file));
				output.write(bytes);
			} finally {
				output.close();
			}
		} catch (final FileNotFoundException ex) {
			logger.error("File not found." + ex.getLocalizedMessage());
			throw ex;
		} catch (final IOException ex) {
			logger.error("Error" + ex.getLocalizedMessage());
			throw ex;
		}
		logger.info("END - writeFileToFileSystem");
	}

	private IOpenFile convertIopenApplicationDoc2IOpenFile(final IopenApplicationDoc applicationDoc,
			final byte[] data) {
		final IOpenFile file = new IOpenFile();

		file.setCodApplication(applicationDoc.getId().getCodApplication());
		file.setCreationDate(applicationDoc.getFActual());
		file.setOriginalFilename(applicationDoc.getDocDesc());
		file.setFile(data);
		file.setContentType(applicationDoc.getContentType());
		file.setStorageFilename(applicationDoc.getId().getTipDoc());
		file.setContentClass(applicationDoc.getContentClass());
		file.setTac(applicationDoc.getTac());

		return file;
	}

	private IopenApplicationDoc convertIOpenFile2IopenApplicationDoc(final IOpenFile file) {
		final IopenApplicationDoc applicationDoc = new IopenApplicationDoc();

		applicationDoc.setId(new IopenApplicationDocPK(file.getCodApplication(), file.getStorageFilename()));
		applicationDoc.setContentType(file.getContentType());
		applicationDoc.setDocDesc(file.getOriginalFilename());
		applicationDoc.setFActual(file.getCreationDate());
		applicationDoc.setPrograma(ApplicationDefault.getProgram());
		applicationDoc.setUsuario(ApplicationDefault.getDatabaseUser());
		applicationDoc.setIopenApplication(iopenApplicationRepository.findOne(file.getCodApplication()));

		return applicationDoc;
	}

	private String getPhysicalFileFullPath(final String filename) {
		return localStoragePath + File.separator + filename;
	}
}
