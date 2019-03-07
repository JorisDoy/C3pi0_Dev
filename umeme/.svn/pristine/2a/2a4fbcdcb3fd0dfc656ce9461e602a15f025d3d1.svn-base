package com.indra.iopen.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.indra.iopen.form.IOpenFile;
import com.indra.iopen.model.IopenApplicationDoc;

public interface FileService {

	IOpenFile getFile(Long codApplication, String fileName) throws FileNotFoundException;

	List<IOpenFile> getFilesByApplication(Long codApplication) throws FileNotFoundException;

	Boolean updateFile(IOpenFile file) throws Exception;

	Boolean deleteFile(Long codApplication, String fileName);

	Boolean existFile(Long codApplication, String fileName);

	IOpenFile saveFile(IopenApplicationDoc applicationDoc) throws Exception;

}
