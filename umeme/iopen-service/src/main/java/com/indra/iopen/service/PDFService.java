package com.indra.iopen.service;

import java.io.File;

import com.indra.iopen.form.Application;

public interface PDFService {
File createApplicationPDF(Long codApplication) throws Exception;
File createTAC() throws Exception;
}
