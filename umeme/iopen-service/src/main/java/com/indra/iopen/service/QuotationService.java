package com.indra.iopen.service;

import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.PresupuestosExped;

public interface QuotationService {

	void processAllToGenerateQuotation() throws Exception;

	// SMA/UMESCI-732 -20170506 start
	/**
	 * process to quotation sent from quotation prepared
	 *
	 * @throws Exception
	 */
	void processToQuotationSentFromQuotationPrepared() throws Exception;

	/**
	 * send quotation
	 *
	 * @param iopenApplication
	 * @throws Exception
	 */
	void sendQuotation(IopenApplication iopenApplication) throws Exception;

	/**
	 * process to inspection passed
	 *
	 * @param iopenApplication
	 * @param inspectionBalanceEx
	 * @throws Exception
	 */
	void processFromInspectionPassed(IopenApplication iopenApplication, PresupuestosExped inspectionBalanceEx) throws Exception;
	// SMA/UMESCI-732 -20170506 end
}
