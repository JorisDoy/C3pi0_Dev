package com.indra.iopen.service;

import java.util.List;
import java.util.Map;

import com.indra.iopen.form.ReceivedInspectionResult;
import com.indra.iopen.model.Expediente;
import com.indra.iopen.model.Personal;
import com.indra.iopen.model.PresupuestosExped;
import com.indra.iopen.model.Tipo;
import com.indra.iopen.pojo.GISInspectionResult;

public interface InspectionResultsService {

	void processInspectionResults(ReceivedInspectionResult inspectionResult) throws Exception;

	List<Personal> findPersonalToWorkOnServiceOrder(long numOs);

	Map<Long, String> findMeterReadingDivision(Long codApplicaion);

	List<Tipo> getValidProjectTypes();

	ReceivedInspectionResult prepareReceivedInspectionResultsFromGISInspectionResults(
			GISInspectionResult gISInspectionResult) throws Exception;

	/**
	 * SMA/UMESCI-713 method is used to resolve the Service Order
	 *
	 * @param inspectionResult
	 * @throws Exception
	 */
	void resolveSiteInspectionServiceOrder(ReceivedInspectionResult inspectionResult) throws Exception;

	/**
	 * SMA/UMESCI-713 get inspection fee
	 *
	 * @param tariff
	 * @return
	 */
	double getInspectionFee(String tariff);

	/**
	 * SMA/UMESCI-713 process application to inspection Passed
	 *
	 * @param inspectionResult
	 */
	void processToInspectionPassed(ReceivedInspectionResult inspectionResult);

	/**
	 * SMA/UMESCI-713 process to inspection failed
	 *
	 * @param inspectionResult
	 */
	void processToInspectionFailed(ReceivedInspectionResult inspectionResult);

	/**
	 * SMA/UMESCI-713 prepare PresupuestosExped
	 *
	 * @param expediente
	 * @param tipMov
	 * @param amount
	 * @return
	 */
	PresupuestosExped preparePresupuestosExped(Expediente expediente, String tipMov, double amount);

}
