package com.indra.iopen.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.indra.iopen.facade.InspectionResultsFacade;
import com.indra.iopen.form.ReceivedInspectionResult;
import com.indra.iopen.model.CosteExp;
import com.indra.iopen.model.Expediente;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.PresupuestosExped;
import com.indra.iopen.pojo.Edited;
import com.indra.iopen.pojo.GISInspectionResult;
import com.indra.iopen.repositories.model.ActividadeRepository;
import com.indra.iopen.repositories.model.CosteExpRepository;
import com.indra.iopen.repositories.model.ExpedienteRepository;
import com.indra.iopen.repositories.model.IopenApplicationRepository;
import com.indra.iopen.repositories.model.PresupuestosExpedRepository;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.InspectionResultsService;
import com.indra.iopen.service.QuotationService;
import com.indra.iopen.util.ApplicationAdvanceType;
import com.indra.iopen.util.annotation.Facade;

//SMA/UMESCI-713
@Facade
public class InspectionResultsFacadeImpl implements InspectionResultsFacade {
	@Autowired
	private InspectionResultsService inspectionResultsService;
	@Value("${iopen.connection.type.domestic}")
	private String domesricConnectionType;
	@Value("${iopen.connection.type.commercial}")
	private String commercialConnectionType;
	@Autowired
	private CosteExpRepository costeExpRepository;
	@Value("${application.inspection.fee.tip_mov.value}")
	private String tipMovValue;
	@Value("${iopen.bill.status.billed}")
	private String billStatusBilled;
	@Autowired
	private PresupuestosExpedRepository presupuestosExpedRepository;
	@Autowired
	private CommonService commonService;
	@Autowired
	private IopenApplicationRepository iopenApplicationRepository;
	@Autowired
	private ExpedienteRepository expedienteRepository;
	@Value("${iopen.inspection.status.passed}")
	private String inspectionStatusPassed;
	@Value("${iopen.inspection.status.failed}")
	private String inspectionStatusFailed;
	@Autowired
	private ActividadeRepository actividadeRepository;
	@Autowired
	private QuotationService quotationService;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseEntity<Edited> recieveGISInspectionResults(GISInspectionResult gisInspectionResult)
			throws Exception {
		final ReceivedInspectionResult inspectionResult = inspectionResultsService
				.prepareReceivedInspectionResultsFromGISInspectionResults(gisInspectionResult);
		final Expediente expediente = inspectionResult.getIopenApplication().getExpediente();
		final long count = actividadeRepository.findCountByStatusAndApplicationNumber(inspectionStatusPassed,
				expediente.getNumExp());

		final Edited edited = new Edited();
		edited.setCreated(true);
		if (count > 0) {

			return new ResponseEntity<>(edited, HttpStatus.OK);
		}
		// resolve work request
		inspectionResultsService.resolveSiteInspectionServiceOrder(inspectionResult);
		// check status of inspection
		if (inspectionResult.getInspectionStatus() == Long.valueOf(inspectionStatusPassed)) {

			// check if existing tarrif in expediente (TIP_SOLIC) is the same as
			// the
			// one sent to IOPEN
			if (!expediente.getTipSolic().equalsIgnoreCase(inspectionResult.getTipSolic())) {
				// check if change is from domestic to commercial (This is the
				// requiremsnts for UMESCI-713)
				double balance;
				if (inspectionResult.getTipSolic().equalsIgnoreCase(commercialConnectionType)
						&& expediente.getTipSolic().equalsIgnoreCase(domesricConnectionType)) {
					double commercialCost = 0;
					final CosteExp costeExp = costeExpRepository.findCosteExpByTipMovAndTipTarrif(tipMovValue,
							inspectionResult.getTipSolic());
					if (costeExp != null) {
						commercialCost = costeExp.getCoste().doubleValue();
					}
					PresupuestosExped presupuestosExped = presupuestosExpedRepository
							.findPresupuestosExpedByIdNumExpAndTipMovAndEstado(expediente.getNumExp(), tipMovValue,
									billStatusBilled);
					balance = commercialCost
							- (presupuestosExped != null ? presupuestosExped.getCoste().longValue() : 0);
					presupuestosExped = inspectionResultsService.preparePresupuestosExped(expediente, tipMovValue,
							balance);
					expediente.setTipSolic(inspectionResult.getTipSolic());
					expediente.setTipObra(inspectionResult.getTipObra());
					expedienteRepository.save(expediente);

					presupuestosExpedRepository.save(presupuestosExped);
					inspectionResultsService.processToInspectionPassed(inspectionResult);

					// update iopenApplication for purpose of mail sending
					final IopenApplication iopenApplication = iopenApplicationRepository
							.findOne(inspectionResult.getIopenApplication().getCodApplication());

					// SMA/UMESCI-732 -20170506
					quotationService.processFromInspectionPassed(iopenApplication,presupuestosExped);

				} else {
					// fail inspection
					inspectionResultsService.processToInspectionFailed(inspectionResult);

					final List<IopenApplication> iopenApplications = new ArrayList<>();
					final IopenApplication iopenApplication = iopenApplicationRepository
							.findOne(inspectionResult.getIopenApplication().getCodApplication());
					iopenApplications.add(iopenApplication);
					commonService.sendMessagesClientsToInformOfAdvanceInApplicationStatus(iopenApplications,
							ApplicationAdvanceType.INSPECTION_FAILED, inspectionResult);
				}
			} else {
				inspectionResultsService.processToInspectionPassed(inspectionResult);

				// update iopenApplication for purpose of mail sending
				final IopenApplication iopenApplication = iopenApplicationRepository
						.findOne(inspectionResult.getIopenApplication().getCodApplication());

				// SMA/UMESCI-732 -20170506
				quotationService.processFromInspectionPassed(iopenApplication,null);

			}

		} else if (inspectionResult.getInspectionStatus() == Long.valueOf(inspectionStatusFailed)) {// inspection
			// failed
			inspectionResultsService.processToInspectionFailed(inspectionResult);

			final List<IopenApplication> iopenApplications = new ArrayList<>();
			final IopenApplication iopenApplication = iopenApplicationRepository
					.findOne(inspectionResult.getIopenApplication().getCodApplication());
			iopenApplications.add(iopenApplication);
			commonService.sendMessagesClientsToInformOfAdvanceInApplicationStatus(iopenApplications,
					ApplicationAdvanceType.INSPECTION_FAILED, inspectionResult);
		} else {
			// not implemented
			edited.setCreated(false);
			return new ResponseEntity<>(edited, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(edited, HttpStatus.OK);
	}
}
