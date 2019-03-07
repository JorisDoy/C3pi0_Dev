package com.indra.iopen.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.iopen.form.ReceivedInspectionResult;
import com.indra.iopen.model.Callejero;
import com.indra.iopen.model.ClienteProfile;
import com.indra.iopen.model.Codigo;
import com.indra.iopen.model.Estado;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.IopenApplicationMessage;
import com.indra.iopen.model.IopenApplicationMessagePK;
import com.indra.iopen.model.IopenUnicomContact;
import com.indra.iopen.model.Mtarifa;
import com.indra.iopen.model.Municipio;
import com.indra.iopen.model.Tipo;
import com.indra.iopen.model.ims.GiTTipAviso;
import com.indra.iopen.model.ims.SgdValor;
import com.indra.iopen.pojo.MailApplication;
import com.indra.iopen.pojo.MailApplicationAdvanceStatus;
import com.indra.iopen.pojo.QuotationAmount;
import com.indra.iopen.repositories.model.CallejeroRepository;
import com.indra.iopen.repositories.model.ClienteProfileRepository;
import com.indra.iopen.repositories.model.CodigoRepository;
import com.indra.iopen.repositories.model.EstadoRepository;
import com.indra.iopen.repositories.model.IopenApplicationMessageRepository;
import com.indra.iopen.repositories.model.IopenApplicationStageRepository;
import com.indra.iopen.repositories.model.IopenUnicomContactRepository;
import com.indra.iopen.repositories.model.MtarifaRepository;
import com.indra.iopen.repositories.model.MunicipioRepository;
import com.indra.iopen.repositories.model.TipoRepository;
import com.indra.iopen.repositories.model.ims.GiTTipAvisoRepository;
import com.indra.iopen.repositories.model.ims.SgdValorRepository;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.MailService;
import com.indra.iopen.service.phone.PhoneService;
import com.indra.iopen.util.ApplicationAdvanceType;
import com.indra.iopen.util.MailApplicationType;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CodigoRepository codigoRepository;

	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private IopenUnicomContactRepository iopenUnicomContactRepository;

	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private MtarifaRepository mtarifaRepository;
	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private IopenApplicationStageRepository iopenApplicationStageRepository;

	@Autowired
	@Lazy
	private MailService mailService;
	@Autowired
	private PhoneService phoneService;

	@Autowired
	private ClienteProfileRepository clienteProfileRepository;
	@Autowired
	private IopenApplicationMessageRepository iopenApplicationMessageRepository;
	@Autowired
	private SgdValorRepository sgdValorRepository;
	@Autowired
	private GiTTipAvisoRepository giTTipAvisoRepository;

	@Autowired
	private Environment env;
	@Autowired
	private CallejeroRepository callejeroRepository;
	// SMA 20160314
	private String estado;

	// @Value("${application.message.inspectionpaid}")
	// private String inspectionPaidMessage;
	//
	// @Value("${application.message.connectionpending}")
	// private String connectionPendingMessage;
	//
	// @Value("${application.message.quotation.pending}")
	// private String quotationPendingMessage;
	//
	// @Value("${application.message.quotation.sent}")
	// private String quotationSentMessage;
	//
	// @Value("${application.message.inspectionscheduled}")
	// private String inspectionScheduled;
	//
	// @Value("${application.message.connectionscheduled}")
	// private String connectionScheduledMessage;

	private String stageComments = null;
	private String currentStage = null;

	private static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

	@Override
	/**
	 * Sends an email to all the clients to inform of advance in application
	 * status
	 *
	 * @param clients
	 */
	@Transactional(rollbackFor = { Exception.class })
	public void sendMessagesClientsToInformOfAdvanceInApplicationStatus(List<IopenApplication> iopenApplications,
			ApplicationAdvanceType applicationAdvanceType, Object... objects) {
		logger.info("BEGIN - sendMailClientsToInformOfAdvanceInApplicationStatus");
		for (final IopenApplication iopenApplication : iopenApplications) {
			if (iopenApplication != null) {
				ClienteProfile clienteProfile = null;
				try {
					clienteProfile = clienteProfileRepository
							.findClienteProfileByUsername(iopenApplication.getClientUsername());
					if (clienteProfile != null && clienteProfile.getActive()) {
						String smsMessage = null;
						final MailApplication mailApplication = new MailApplication();
						// SMA 20160316 start
						String fullName = iopenApplication.getFirstName() + " " + iopenApplication.getMiddleName() + " "
								+ iopenApplication.getSurname();
						if (fullName == null || fullName.trim().isEmpty()) {
							fullName = clienteProfile.getFullName();
						}
						mailApplication.setCustomerName(fullName);
						// SMA 20160316 start
						mailApplication
						.setConnectionType(getApplicationTypesName(iopenApplication.getApplicationType()));
						mailApplication.setTrackingNumber(String.valueOf(iopenApplication.getCodApplication()));
						final Municipio municipio = municipioRepository.findOne(iopenApplication.getDistrict());
						final Callejero callejero = callejeroRepository.findOne(iopenApplication.getStreet());
						mailApplication.setDistrict(municipio.getNomMunic());

						final MailApplicationAdvanceStatus mailApplicationAdvanceStatus = new MailApplicationAdvanceStatus(
								mailApplication);
						// SMA 20160219 UMESC-444 start
						if (iopenApplication.getExpediente() != null) {
							mailApplicationAdvanceStatus
							.setApplicationNumber(iopenApplication.getExpediente().getNumExp());

							currentStage = estadoRepository.findById(iopenApplication.getExpediente().getEstado())
									.getDescEst();
							stageComments = iopenApplicationStageRepository
									.findOne(iopenApplication.getExpediente().getEstado()).getStageComments();
							mailApplicationAdvanceStatus.setCurrentStage(currentStage);
						}
						// SMA 20160219 UMESC-444 end
						mailApplicationAdvanceStatus.setCallCentreNumber(env.getProperty("umeme.callcenter"));
						final IopenUnicomContact iopenUnicomContact = iopenUnicomContactRepository
								.findOne(String.valueOf(callejero.getCodUnicom()));
						mailApplicationAdvanceStatus.setDistrictEmailAddress(iopenUnicomContact.getEmail());
						mailApplicationAdvanceStatus.setDistrictPhoneNumber(iopenUnicomContact.getPhoneContact());
						switch (applicationAdvanceType) {
						case INSPECTION_PASSED:
							// SMA 20160314
							estado = env.getProperty("application.stage.inspection.passed.value");
							smsMessage = env.getProperty("application.sms.inspection.passed");
							mailApplicationAdvanceStatus
							.setSpecificMessage(env.getProperty("application.email.inspection.passed"));

							break;
						case INSPECTION_FAILED:
							// SMA 20160314
							estado = env.getProperty("application.stage.inspection.passed.value");
							smsMessage = env.getProperty("application.sms.inspection.failed");
							mailApplicationAdvanceStatus.setSpecificMessage(
									env.getProperty("application.email.inspection.failed") + " Comments : "
											+ ((ReceivedInspectionResult) objects[0]).getInspectionComment());

							break;
						case INSPECTION_PAID:
							// SMA 20160314
							estado = env.getProperty("application.stage.inspection.paid.value");
							mailApplicationAdvanceStatus.setSpecificMessage(stageComments);
							break;
							// SMA 20160316
						case REINSPECTION_PAID:
							// SMA 20160314
							estado = env.getProperty("application.stage.reinspection.paid.value");
							mailApplicationAdvanceStatus.setSpecificMessage(stageComments);
							break;
						case INSPECTION_SCHEDULED:
							// SMA 20160316
							estado = env.getProperty("application.stage.inspection.pending.approval.value");
							smsMessage = env.getProperty("application.sms.inspectionscheduled");
							mailApplicationAdvanceStatus
							.setSpecificMessage(env.getProperty("application.email.inspectionscheduled"));
							mailApplicationAdvanceStatus
							.setInspectionScheduledDate(iopenApplication.getInspectionScheduledDate());

							break;
						case COMMISIONED:

							break;
						case CONNECTION_IN_PROGRESS:
							// SMA 20160314
							estado = env.getProperty("application.stage.connection.in.progress.value");
							mailApplicationAdvanceStatus.setSpecificMessage(stageComments);
							break;
						case CONNECTION_PENDING:
							// SMA 20160314
							estado = env.getProperty("application.stage.connection.pending.value");
							mailApplicationAdvanceStatus.setSpecificMessage(stageComments);
							break;
						case IN_CONSTRUCTION:

							break;
						case PAID:
							// SMA 20160314
							estado = env.getProperty("application.stage.quotation.paid.value");
							mailApplicationAdvanceStatus.setSpecificMessage(stageComments);
							break;
						case QUOTAION_PREPARED:

							// SMA 20160314
							estado = env.getProperty("application.stage.quotation.prepared.value");
							mailApplicationAdvanceStatus.setSpecificMessage(stageComments);
							break;
							// current CMS does not use this option, left in code
							// just incase they return this function in the future
							// SMA 201618003
						case QUOTATION_PENDING:
							// SMA 20160314
							estado = env.getProperty("application.stage.quotation.pending.value");
							mailApplicationAdvanceStatus.setSpecificMessage(stageComments);
							break;
						case QUOTATION_SENT:
							// SMA 20160314
							estado = env.getProperty("application.stage.quotation.sent.value");
							mailApplicationAdvanceStatus.setSpecificMessage(stageComments);
							mailApplicationAdvanceStatus.setQuotationAmount((QuotationAmount) objects[0]);
							break;
						case CONNECTION_SCHEDULED:
							// SMA 20160314
							estado = env.getProperty("application.stage.connection.in.progress.value");
							smsMessage = env.getProperty("application.sms.connectionscheduled");
							mailApplicationAdvanceStatus
							.setSpecificMessage(env.getProperty("application.email.connectionscheduled"));
							mailApplicationAdvanceStatus
							.setConnectionScheduledDate(iopenApplication.getConnectionScheduledDate());

							break;
						case SERVICE_POINT_CREATED:
							// SMA 20160314
							estado = env.getProperty("application.stage.service.point.created.value");
							smsMessage = env.getProperty("application.sms.servicepoint.created");
							mailApplicationAdvanceStatus
							.setSpecificMessage(env.getProperty("application.email.servicepoint.created"));

							break;
						case SITE_INSPECTION:

							break;

						default:
							break;
						}

						mailService.sendApplicationStatus(mailApplicationAdvanceStatus, MailApplicationType.ADVANCE,
								clienteProfile.getUsername());
						// save to IOPEN_APPLICATION_MESSAGES
						final IopenApplicationMessagePK iopenApplicationMessagePK = new IopenApplicationMessagePK();
						iopenApplicationMessagePK.setCodApplication(iopenApplication.getCodApplication());
						Long secId = null;
						if (iopenApplication.getCodApplication() != null
								&& iopenApplication.getCodApplication() != 0l) {
							secId = iopenApplicationMessageRepository
									.findMaxIdSecIdByIdCodApplication(iopenApplication.getCodApplication());
						}
						if (secId == null) {
							secId = Long.valueOf(0);
						}
						iopenApplicationMessagePK.setSecId(secId + 1);
						final IopenApplicationMessage iopenApplicationMessage = new IopenApplicationMessage();
						iopenApplicationMessage.setExpedienteEstado(estado);
						iopenApplicationMessage.setFActual(new Date());
						iopenApplicationMessage.setId(iopenApplicationMessagePK);
						iopenApplicationMessage.setMessageSent(Boolean.TRUE);
						iopenApplicationMessage.setUsuario(clienteProfile.getUsername());

						iopenApplicationMessageRepository.save(iopenApplicationMessage);
						if (smsMessage == null) {

							phoneService.sendMessage(stageComments, iopenApplication.getContactNumber());
						} else {
							phoneService.sendMessage(smsMessage, iopenApplication.getContactNumber());

						}

						logger.debug("Adding " + clienteProfile.getCodCli() + " for notifing him.");
					} else {
						logger.warn("Client " + iopenApplication.getClientUsername() + " its not valid.");
					}

				} catch (final Exception e) {
					logger.error("Send remainder email failed for client " + clienteProfile.getUsername(), e);
				}
			}
		}
		logger.info("END - sendMailClientsToInformOfAdvanceInApplicationStatus");
	}

	@Override
	public List<Codigo> getCodigos(String filter) {
		return codigoRepository.findCodigoLike(filter);
	}

	@Override
	public List<Tipo> getTipos(String filter) {
		return tipoRepository.findTipoLike(filter);
	}

	@Override
	public List<Estado> getEstados(String filter) {
		return estadoRepository.findEstadoLike(filter);
	}

	@Override
	public List<Mtarifa> getAllMtarifas() {
		return (List<Mtarifa>) mtarifaRepository.findAll();
	}

	@Override
	public List<SgdValor> getScopes() {
		final List<SgdValor> sgdValors = sgdValorRepository.findSgdValorByIdCodif(
				env.getProperty("application.sgdvalor.codif.scope.value"), new Sort(Sort.Direction.DESC, "id.codif"));
		return sgdValors;
	}

	@Override
	public List<GiTTipAviso> getComplaintNatures() {
		final List<GiTTipAviso> giTTipAvisos = (List<GiTTipAviso>) giTTipAvisoRepository.findAll();
		return giTTipAvisos;
	}

	@Override
	public List<SgdValor> getComplaintTypes() {
		final List<SgdValor> sgdValors = sgdValorRepository.findSgdValorByIdCodif(
				env.getProperty("application.sgdvalor.codif.complainttype.value"),
				new Sort(Sort.Direction.DESC, "id.codif"));
		return sgdValors;
	}

	@Override
	public List<SgdValor> getSgdValors(String filter) {
		final List<SgdValor> sgdValors = sgdValorRepository.findSgdValorByIdCodif(filter,
				new Sort(Sort.Direction.DESC, "id.codif"));
		return sgdValors;
	}

	@Override
	public String getApplicationTypesName(String applicationTypeCode) {
		final Map<String, String> applicationTypeName = new HashMap<String, String>();
		applicationTypeName.put("32110", env.getProperty("applicationtype.32110.value"));
		applicationTypeName.put("32322", env.getProperty("applicationtype.32322.value"));
		applicationTypeName.put("32222", env.getProperty("applicationtype.32222.value"));
		applicationTypeName.put("32410", env.getProperty("applicationtype.32410.value"));
		applicationTypeName.put("32310", env.getProperty("applicationtype.32310.value"));
		applicationTypeName.put("32210", env.getProperty("applicationtype.32210.value"));
		return applicationTypeName.get(applicationTypeCode);
	}
}
