package com.indra.iopen.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.indra.iopen.form.Application;
import com.indra.iopen.model.Actividade;
import com.indra.iopen.model.ActividadePK;
import com.indra.iopen.model.Callejero;
import com.indra.iopen.model.Cliente;
import com.indra.iopen.model.ClienteIdentificador;
import com.indra.iopen.model.ClienteIdentificadorPK;
import com.indra.iopen.model.ClienteProfile;
import com.indra.iopen.model.CosteExp;
import com.indra.iopen.model.CuentasCu;
import com.indra.iopen.model.DireccionCta;
import com.indra.iopen.model.DistrictDepto;
import com.indra.iopen.model.Expediente;
import com.indra.iopen.model.Fincas;
import com.indra.iopen.model.FincasExp;
import com.indra.iopen.model.FincasExpPK;
import com.indra.iopen.model.InvGroup;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.IopenApplicationDoc;
import com.indra.iopen.model.IopenApplicationDocPK;
import com.indra.iopen.model.IopenUnicomContact;
import com.indra.iopen.model.Municipio;
import com.indra.iopen.model.PresupuestosExped;
import com.indra.iopen.model.PresupuestosExpedPK;
import com.indra.iopen.model.Puntomed;
import com.indra.iopen.model.PuntomedPK;
import com.indra.iopen.model.SumExp;
import com.indra.iopen.model.SumExpPK;
import com.indra.iopen.model.TipCliTipSolicMapping;
import com.indra.iopen.model.TipCliTipSolicMappingPK;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.model.security.util.SecurityUtil;
import com.indra.iopen.pojo.MailApplication;
import com.indra.iopen.pojo.MailApplicationApproval;
import com.indra.iopen.repositories.model.ActividadeRepository;
import com.indra.iopen.repositories.model.CallejeroRepository;
import com.indra.iopen.repositories.model.ClienteIdentificadorRepository;
import com.indra.iopen.repositories.model.ClienteProfileRepository;
import com.indra.iopen.repositories.model.ClienteRepository;
import com.indra.iopen.repositories.model.CosteExpRepository;
import com.indra.iopen.repositories.model.CuentasCuRepository;
import com.indra.iopen.repositories.model.DireccionCtaRepository;
import com.indra.iopen.repositories.model.DistrictDeptoRepository;
import com.indra.iopen.repositories.model.ExpedienteRepository;
import com.indra.iopen.repositories.model.FincasExpRepository;
import com.indra.iopen.repositories.model.FincasRepository;
import com.indra.iopen.repositories.model.InvGroupRepository;
import com.indra.iopen.repositories.model.IopenApplicationRepository;
import com.indra.iopen.repositories.model.IopenUnicomContactRepository;
import com.indra.iopen.repositories.model.MunicipioRepository;
import com.indra.iopen.repositories.model.PresupuestosExpedRepository;
import com.indra.iopen.repositories.model.PuntomedRepository;
import com.indra.iopen.repositories.model.SumExpRepository;
import com.indra.iopen.repositories.model.TipCliTipSolicMappingRepository;
import com.indra.iopen.repositories.model.TipoRepository;
import com.indra.iopen.service.ApplicationListService;
import com.indra.iopen.service.ApplicationService;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.FileService;
import com.indra.iopen.service.MailService;
import com.indra.iopen.service.phone.PhoneService;
import com.indra.iopen.util.ApplicationDefault;
import com.indra.iopen.util.MailApplicationType;

@Component
@PropertySource("classpath:application.properties")
public class ApplicationServiceImpl implements ApplicationService {

	/*
	 * @Autowired private ApplicationRepository applicationRepository;
	 */

	/* Repositories */
	@Autowired
	private ActividadeRepository actividadeRepository;
	@Autowired
	private ClienteIdentificadorRepository clienteIdentificadorRepository;
	@Autowired
	private ClienteProfileRepository clienteProfileRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private CuentasCuRepository cuentasCuRepository;
	@Autowired
	private CosteExpRepository costeExpRepository;
	@Autowired
	private DireccionCtaRepository direccionCtaRepository;
	@Autowired
	private DistrictDeptoRepository districtDeptoRepository;
	@Autowired
	private ExpedienteRepository expedienteRepository;
	@Autowired
	private FincasRepository fincasRepository;
	@Autowired
	private FincasExpRepository fincasExpRepository;
	@Autowired
	private InvGroupRepository invGroupRepository;
	@Autowired
	private CallejeroRepository callejeroRepository;
	/*
	 * @Autowired private IopenApplicationDocRepository
	 * iopenApplicationDocRepository;
	 */
	@Autowired
	private FileService fileService;
	@Autowired
	private IopenApplicationRepository iopenApplicationRepository;
	@Autowired
	private PresupuestosExpedRepository presupuestosExpedRepository;
	@Autowired
	private SumExpRepository sumExpRepository;
	@Autowired
	private TipCliTipSolicMappingRepository tipCliTipSolicMappingRepository;
	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private PuntomedRepository puntomedRepository;
	@Autowired
	private MunicipioRepository municipioRepository;

	/* Repositories end */

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private MailService mailService;

	@Autowired
	private PhoneService phoneService;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	ApplicationListService applicationListService;

	@Autowired
	private Environment env;
	// SMA 20160303
	@Autowired
	private IopenUnicomContactRepository iopenUnicomContactRepository;

	@Autowired
	private CommonService commonService;
	// private ApplicationDefault ApplicationDefault = new ApplicationDefault();

	private Cliente cliente = null;

	private ClienteIdentificador clienteIdentificador = null;
	private ClienteIdentificadorPK clienteIdentificadorPK = null;
	private CuentasCu cuentasCu = null;
	private DireccionCta direccionCta = null;
	private InvGroup invGroup = null;
	// private BdgActOfiAux bdgActOfiAux = null;
	private Expediente expediente = null;
	private PresupuestosExped presupuestosExped = null;
	private PresupuestosExpedPK presupuestosExpedPK = null;
	private SumExp sumExp = null;
	private SumExpPK sumExpPK = null;
	private Actividade actividade = null;
	private ActividadePK actividadePK = null;
	private FincasExp fincasExp = null;
	private FincasExpPK fincasExpPK = null;
	private Fincas fincas = null;
	private Municipio municipio = null;
	private Callejero callejero = null;
	private Application application = null;
	private TipCliTipSolicMapping tipCliTipSolicMapping = null;
	private TipCliTipSolicMappingPK tipCliTipSolicMappingPK = null;
	private ClienteProfile clienteProfile = null;
	private IopenApplication iopenApplication = null;
	private Puntomed puntomed = null;
	private PuntomedPK puntomedPK = null;
	// TODO Marcos is dealing with the uploads
	private List<IopenApplicationDoc> iopenApplicationDoc = new ArrayList<IopenApplicationDoc>();
	private CosteExp costeExp = null;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public List<DistrictDepto> findAllDistricts() {
		return districtDeptoRepository.findAllDistricts();
	}

	@Override
	public Application mapIopenapplicationToApplication(IopenApplication iopenApplication) {
		final Application application = new Application();
		application.setAgreeTermsConditions(iopenApplication.getTermsAgree());
		application.setAgreeWayleaves(iopenApplication.getAgreeWayleaves());
		application.setApplicationType(iopenApplication.getApplicationType());
		application.setCodApplication(iopenApplication.getCodApplication());
		application.setContactName(iopenApplication.getContactName());
		application.setContactNumber(iopenApplication.getContactNumber());
		application.setCountyDesc(iopenApplication.getCountyDesc());
		application.setCustomerContactPerson(iopenApplication.getCustomerContactPerson());
		application.setDirectionsDesc(iopenApplication.getDirectionsDesc());
		application.setDistrict(iopenApplication.getDistrict());
		// SMA 20160301
		application.setDocumentType(iopenApplication.getIdType());
		application.setDistrictDesc(iopenApplication.getDirectionsDesc());
		application.setEmailAddress(iopenApplication.getEmailAddress());
		application.setFirstName(iopenApplication.getFirstName());
		application.setHousePlot(iopenApplication.getHousePlot());
		application.setIdNumber(iopenApplication.getIdNumber());
		application.setIopenApplication(iopenApplication);
		// application.setLandmark(iopenApplication.getLandmark());
		application.setLocality(iopenApplication.getLocality());
		application.setMiddleName(iopenApplication.getMiddleName());
		application.setMobileNumber(iopenApplication.getMobileNumber());
		application.setOfficeNumber(iopenApplication.getOfficeNumber());
		application.setStreet(new BigDecimal(iopenApplication.getStreet()));
		application.setStreetDesc(iopenApplication.getStreetDesc());
		application.setSubCountyDesc(iopenApplication.getSubCountyDesc());
		application.setSurname(iopenApplication.getSurname());
		application.setTinNumber(iopenApplication.getTinNumber());
		application.setTownDesc(iopenApplication.getTownDesc());
		application.setVillage(iopenApplication.getVillage());
		application.setVillageDesc(iopenApplication.getVillageDesc());

		return application;
	}

	@Override
	public Application getApplicationForLoggedInUser(ClientUser clientUser) throws Exception {
		final long codCli = clientUser.getClienteProfile().getCodCli();

		application = new Application();

		if (codCli > 0) {
			final Cliente cliente = clienteRepository.findById(codCli);
			final ClienteIdentificador clienteIdentificador = clienteIdentificadorRepository
					.findById(new ClienteIdentificadorPK(codCli,
							Long.valueOf(ApplicationDefault.getClienteIdentificadorPKSecId())));
			application.setSurname(cliente.getApe1Cli());
			application.setFirstName(cliente.getNomCli());
			application.setMiddleName(cliente.getApe2Cli());
			application.setMobileNumber(cliente.getTfno3Cli());
			application.setOfficeNumber(cliente.getTfno1Cli());
			application.setEmailAddress(cliente.getEMail());
			// application.setEmail(clientUser.getClienteProfile().getId().getUsername());
			// application.setContactName(cliente.getPersContacto());
			// application.setContactNumber(cliente.getNombrePadre());
			// application.setCustomerContactPerson(customerContactPerson);
			application.setIdNumber(clienteIdentificador.getDocId());
			application.setDocumentType(clienteIdentificador.getTipDoc());
			application.setCodCli(cliente.getCodCli());
		}

		return application;
	}

	@Override
	public Application getIncompleteApplication(Long codApplication) throws Exception {

		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		// SMA 20160302
		final ClienteProfile clienteProfile = clientUser.getClienteProfile();
		application = new Application();

		final IopenApplication iopenApplication = iopenApplicationRepository.findOne(codApplication);

		if (clientUser.getClienteProfile().getCodCli() > 0) {
			application = getApplicationForLoggedInUser(clientUser);
		} else {
			application.setContactName(iopenApplication.getContactName().trim());
			application.setContactNumber(iopenApplication.getContactNumber().trim());
			application.setSurname(iopenApplication.getSurname().trim());
			application.setFirstName(iopenApplication.getFirstName().trim());
			application.setMiddleName(iopenApplication.getMiddleName().trim());
			application.setOfficeNumber(iopenApplication.getOfficeNumber().trim());
			application.setCustomerContactPerson(iopenApplication.getCustomerContactPerson());
			application.setIdNumber(iopenApplication.getIdNumber().trim());
			application.setDocumentType(iopenApplication.getIdType().trim());
			// SMA 20160302 start
			if (clienteProfile != null) {
				application.setEmailAddress(clienteProfile.getUsername().trim());
				application.setMobileNumber(clienteProfile.getPhoneNumber().trim());
			} else {
				application.setEmailAddress(iopenApplication.getEmailAddress().trim());
				application.setMobileNumber(iopenApplication.getMobileNumber().trim());
			}
			// SMA 20160302 end

		}

		application.setCodApplication(iopenApplication.getCodApplication());
		application.setApplicationType(iopenApplication.getApplicationType().trim());

		// application.setDistrict(iopenApplication.getDistrict());
		// application.setVillage(iopenApplication.getVillage());
		// application.setStreet(new BigDecimal(iopenApplication.getStreet()));
		// application.setLocality(iopenApplication.getLocality());
		// application.setLandmark(iopenApplication.getLandmark());

		application.setDistrictDesc(iopenApplication.getDistrictDesc().trim());
		application.setVillageDesc(iopenApplication.getVillageDesc().trim());
		application.setTownDesc(iopenApplication.getTownDesc().trim());
		application.setCountyDesc(iopenApplication.getCountyDesc().trim());
		application.setSubCountyDesc(iopenApplication.getSubCountyDesc().trim());
		application.setStreetDesc(iopenApplication.getStreetDesc().trim());
		application.setDirectionsDesc(iopenApplication.getDirectionsDesc().trim());

		application.setHousePlot(iopenApplication.getHousePlot().trim());
		application.setTinNumber(iopenApplication.getTinNumber().trim());
		application.setAgreeTermsConditions(iopenApplication.getTermsAgree());
		application.setAgreeWayleaves(iopenApplication.getAgreeWayleaves());

		application.setIopenApplication(iopenApplication);
		return application;
	}

	private void initialize() throws ParseException {
		cliente = new Cliente();
		clienteIdentificador = new ClienteIdentificador();
		clienteIdentificadorPK = new ClienteIdentificadorPK();
		cuentasCu = new CuentasCu();
		direccionCta = new DireccionCta();
		invGroup = new InvGroup();
		// this.bdgActOfiAux = new BdgActOfiAux();
		expediente = new Expediente();
		presupuestosExped = new PresupuestosExped();
		presupuestosExpedPK = new PresupuestosExpedPK();
		sumExp = new SumExp();
		sumExpPK = new SumExpPK();
		actividade = new Actividade();
		actividadePK = new ActividadePK();
		fincasExp = new FincasExp();
		fincasExpPK = new FincasExpPK();
		fincas = new Fincas();
		puntomed = new Puntomed();
		puntomedPK = new PuntomedPK();
		System.out.println("tipMov= " + ApplicationDefault.getPresupestosExpedtipMov());

		costeExp = costeExpRepository.findCoste(application.getApplicationType(),
				ApplicationDefault.getPresupestosExpedtipMov());

		if (application.getDistrict() != null && application.getDistrict() != 0) {
			municipio = municipioRepository.findOne(application.getDistrict());
		}

		if (application.getStreet() != null && application.getStreet().longValue() != 0) {
			callejero = callejeroRepository.findOne(application.getStreet().longValue());
		}

		clienteProfile = new ClienteProfile();
		tipCliTipSolicMapping = tipCliTipSolicMappingRepository
				.findTipCliTipSolicMapping(application.getApplicationType());
		tipCliTipSolicMappingPK = tipCliTipSolicMapping.getId();

		/* Non Mandatory fields are set to space if not entered */
		// SMA 20160314 start
		if (application.getSurname() == null || application.getSurname().isEmpty()) {
			application.setSurname(" ");
		}
		if (application.getFirstName() == null || application.getFirstName().isEmpty()) {
			application.setFirstName(" ");
		}
		if (application.getIdNumber() == null || application.getIdNumber().isEmpty()) {
			application.setIdNumber(" ");
		}
		if (application.getMiddleName() == null || application.getMiddleName().isEmpty()) {
			application.setMiddleName(" ");
		}
		if (application.getTinNumber() == null || application.getTinNumber().isEmpty()) {
			application.setTinNumber(" ");
		}
		if (application.getMobileNumber() == null || application.getMobileNumber().isEmpty()) {

			application.setMobileNumber(" ");
		}
		if (application.getOfficeNumber() == null || application.getOfficeNumber().isEmpty()) {
			application.setOfficeNumber(" ");
		}
		if (application.getEmailAddress() == null || application.getEmailAddress().isEmpty()) {
			application.setEmailAddress(" ");
		}
		if (application.getContactName() == null || application.getContactName().isEmpty()) {
			application.setContactName(" ");
		}
		if (application.getContactNumber() == null || application.getContactNumber().isEmpty()) {
			application.setContactNumber(" ");
		}
		if (application.getAgreeWayleaves() == null || application.getAgreeWayleaves().isEmpty()) {
			application.setAgreeWayleaves(" ");
		}

		// if (application.getStreet().isEmpty()) {
		// application.setStreet(" ");
		// }
		if (application.getHousePlot() == null || application.getHousePlot().isEmpty()) {
			application.setHousePlot(" ");
		}
		if (application.getAgreeTermsConditions() == null || application.getAgreeTermsConditions().isEmpty()) {
			application.setAgreeTermsConditions(" ");
		}
		// SMA 20160314 end

	}

	@Override
	public HashMap<String, String> retrieveDefaultValues() {

		final HashMap<String, String> defaultsHashMap = new HashMap<String, String>();

		defaultsHashMap.put("application_domestic_value", env.getProperty("application_domestic_value"));

		defaultsHashMap.put("application_mediumindustrial_value",
				env.getProperty("application_mediumindustrial_value"));

		defaultsHashMap.put("application_tou_value", env.getProperty("application_tou_value"));

		defaultsHashMap.put("application_commercial_value", env.getProperty("application_commercial_value"));

		defaultsHashMap.put("application_largeindustrial_value", env.getProperty("application_largeindustrial_value"));

		defaultsHashMap.put("application_streetlight_value", env.getProperty("application_streetlight_value"));

		defaultsHashMap.put("application_passport_value", env.getProperty("application_passport_value"));

		defaultsHashMap.put("application_idnumber_value", env.getProperty("application_idnumber_value"));

		defaultsHashMap.put("application_customercontactperson_self_value",
				env.getProperty("application_customercontactperson_self_value"));

		defaultsHashMap.put("application_customercontactperson_other_value",
				env.getProperty("application_customercontactperson_other_value"));

		defaultsHashMap.put("application_inspection_approve_value",
				env.getProperty("application_inspection_approve_value"));

		defaultsHashMap.put("application_inspection_reject_value",
				env.getProperty("application_inspection_reject_value"));

		return defaultsHashMap;
	}

	@Override
	public HashMap<String, String> retrieveDefaultKeys() {

		final HashMap<String, String> defaultsHashMap = new HashMap<String, String>();

		defaultsHashMap.put(env.getProperty("application_domestic_value"),
				env.getProperty("application.domestic.label"));

		defaultsHashMap.put(env.getProperty("application_mediumindustrial_value"),
				env.getProperty("application.mediumindustrial.label"));

		defaultsHashMap.put(env.getProperty("application_tou_value"), env.getProperty("application.tou.label"));

		defaultsHashMap.put(env.getProperty("application_commercial_value"),
				env.getProperty("application.commercial.label"));

		defaultsHashMap.put(env.getProperty("application_largeindustrial_value"),
				env.getProperty("application.largeindustrial.label"));
		defaultsHashMap.put("32210", env.getProperty("application.streetlight.label"));

		defaultsHashMap.put(env.getProperty("application_streetlight_value"),
				env.getProperty("application.streetlight.label"));

		return defaultsHashMap;
	}

	@Override
	@Transactional(rollbackFor = { IllegalArgumentException.class, ParseException.class, HibernateException.class,
			NullPointerException.class, PersistenceException.class, Exception.class })
	public IopenApplication saveApplcationWhenLoggedIn(Application application, ClientUser clientUser)
			throws Exception {

		// initalize
		this.application = application;
		initialize();

		clienteProfile = clienteProfileRepository
				.findClienteProfileByUsername(SecurityUtil.getLoggedClientProfile().getUsername());

		cliente = clienteRepository.findById(clientUser.getClienteProfile().getCodCli());

		// save to IOPEN_APPLICATIONS
		saveToIopenApplication(false);

		// save attached documents
		saveIopenApplicationDocs(application);

		if (application.getCodApplication() == null) {
			final MailApplication mailApplication = new MailApplication();
			mailApplication.setTrackingNumber(String.valueOf(iopenApplication.getCodApplication()));

			// mailApplication.setCustomerName(iopenApplication.getFirstName() +
			// " " + iopenApplication.getMiddleName()
			// + " " + iopenApplication.getSurname());
			// it will be set by employee
			// if (iopenApplication.getDistrict() > 0) {
			// mailApplication.setDistrict(municipioRepository.findOne(iopenApplication.getDistrict()).getNomMunic());
			// }
			if (iopenApplication.getDistrictDesc() != null && !iopenApplication.getDistrictDesc().isEmpty()) {
				mailApplication.setDistrict(iopenApplication.getDistrictDesc());
			}

			// SMA 20160316 start
			String fullName = iopenApplication.getFirstName() + " " + iopenApplication.getMiddleName() + " "
					+ iopenApplication.getSurname();
			if (fullName == null || fullName.trim().isEmpty()) {
				fullName = clienteProfile.getFullName();
			}
			mailApplication.setCustomerName(fullName);
			// SMA 20160316 end

			mailApplication
			.setConnectionType(commonService.getApplicationTypesName(iopenApplication.getApplicationType()));

			mailService.sendIncompleteAppFirstSave(mailApplication.getCustomerName(),
					mailApplication.getConnectionType(), mailApplication.getDistrict(),
					mailApplication.getTrackingNumber(), env.getProperty("umeme.district.phone"),
					env.getProperty("umeme.callcenter"), env.getProperty("umeme.district.email"),
					iopenApplication.getEmailAddress());
			// SMA 20160229 start
			String smsMessage = env.getProperty("application.sms.first.save");
			smsMessage = smsMessage.replace("#customerName", clienteProfile.getFullName());
			smsMessage = smsMessage.replace("#trackingNumber", String.valueOf(iopenApplication.getCodApplication()));
			smsMessage = smsMessage.replace("#connectionType",
					commonService.getApplicationTypesName(iopenApplication.getApplicationType()));
			if (iopenApplication.getDistrictDesc() != null && !iopenApplication.getDistrictDesc().trim().isEmpty()) {
				smsMessage = smsMessage.replace("#district", env.getProperty("application.message2.district.text") + " "
						+ iopenApplication.getDistrictDesc());
			} else {
				smsMessage = smsMessage.replace("#district", "");
			}
			phoneService.sendMessage(smsMessage, clienteProfile.getPhoneNumber());
			// SMA 20160301
			if (Boolean.valueOf(env.getProperty("laxcon.test"))) {
				mailService.sendLaxxconSMStestMessage(smsMessage, iopenApplication.getEmailAddress());
			}
			// SMA 20160229 end
		}

		return iopenApplication;
	}

	private void saveIopenApplicationDocs(Application application) throws IOException, Exception {
		iopenApplicationDoc = new ArrayList<>();
		for (final MultipartFile multipartFile : application.getFiles()) {
			final IopenApplicationDoc iopenApplicationDoc = new IopenApplicationDoc();
			iopenApplicationDoc.setDoc(multipartFile.getBytes());
			iopenApplicationDoc.setDocDesc(multipartFile.getOriginalFilename());
			iopenApplicationDoc.setContentType(multipartFile.getContentType());
			iopenApplicationDoc.setFActual(new Date());
			iopenApplicationDoc.setId(new IopenApplicationDocPK());
			iopenApplicationDoc.getId().setCodApplication(iopenApplication.getCodApplication());
			// iopenApplicationDoc.getId().setTipDoc(multipartFile.getContentType());
			iopenApplicationDoc.getId().setTipDoc(multipartFile.getOriginalFilename());
			iopenApplicationDoc.setIopenApplication(iopenApplication);
			iopenApplicationDoc.setUsuario(ApplicationDefault.getDatabaseUser());
			iopenApplicationDoc.setPrograma(ApplicationDefault.getProgram());
			iopenApplicationDoc.setTac("0");
			/* iopenApplicationDocRepository.save(iopenApplicationDoc); */
			fileService.saveFile(iopenApplicationDoc);

			this.iopenApplicationDoc.add(iopenApplicationDoc);
		}
		// SMA 20160407
		if (iopenApplication.getIopenApplicationDocs() == null) {
			iopenApplication.setIopenApplicationDocs(new ArrayList<IopenApplicationDoc>());
		}
		iopenApplication.getIopenApplicationDocs().addAll(iopenApplicationDoc);
	}

	// SMA 20160407 start
	private void saveIopenApplicationDocsTaC(Application application) throws IOException, Exception {
		iopenApplicationDoc = new ArrayList<IopenApplicationDoc>();
		for (final MultipartFile multipartFile : application.getFiles()) {
			final IopenApplicationDoc iopenApplicationDoc = new IopenApplicationDoc();
			iopenApplicationDoc.setDoc(multipartFile.getBytes());
			iopenApplicationDoc.setDocDesc(multipartFile.getOriginalFilename());
			iopenApplicationDoc.setContentType(multipartFile.getContentType());
			iopenApplicationDoc.setFActual(new Date());
			iopenApplicationDoc.setId(new IopenApplicationDocPK());
			iopenApplicationDoc.getId().setCodApplication(iopenApplication.getCodApplication());
			// iopenApplicationDoc.getId().setTipDoc(multipartFile.getContentType());
			iopenApplicationDoc.getId().setTipDoc(multipartFile.getOriginalFilename());
			iopenApplicationDoc.setIopenApplication(iopenApplication);
			iopenApplicationDoc.setUsuario(ApplicationDefault.getDatabaseUser());
			iopenApplicationDoc.setPrograma(ApplicationDefault.getProgram());
			iopenApplicationDoc.setTac("1");
			/* iopenApplicationDocRepository.save(iopenApplicationDoc); */
			fileService.saveFile(iopenApplicationDoc);

			this.iopenApplicationDoc.add(iopenApplicationDoc);
		}
		if (iopenApplication.getIopenApplicationDocs() == null) {
			iopenApplication.setIopenApplicationDocs(new ArrayList<IopenApplicationDoc>());
		}
		iopenApplication.getIopenApplicationDocs().addAll(iopenApplicationDoc);
	}

	// SMA 20160407 end
	private void saveToActividades() {
		if (actividade == null || actividadePK == null) {
			throw new NullPointerException("actividade or some part of it is null. ");
		}
		actividadePK.setNumExp(expediente.getNumExp());
		actividadePK.setNumAct(Long.valueOf(ApplicationDefault.getActividadesnumAct()));
		actividade.setId(actividadePK);
		actividade.setPrograma(ApplicationDefault.getProgram());
		actividade.setUsuario(ApplicationDefault.getDatabaseUser());
		actividade.setEstAct(ApplicationDefault.getActividadesestAct());
		actividadeRepository.save(actividade);
	}

	private void saveToClienteIdentificador() {
		if (clienteIdentificador == null || clienteIdentificadorPK == null) {
			throw new NullPointerException("clienteIdentificador or some part of it is null. ");
		}
		clienteIdentificador.setDocId(application.getIdNumber());
		clienteIdentificador.setTipDoc(application.getDocumentType());
		clienteIdentificador.setPrograma(ApplicationDefault.getProgram());
		clienteIdentificador.setUsuario(ApplicationDefault.getDatabaseUser());
		clienteIdentificadorPK.setCodCli(cliente.getCodCli());
		clienteIdentificador.setCodProv(new BigDecimal(ApplicationDefault.getClienteIdentificadorCodProv()));
		clienteIdentificador.setCodDepto(municipio.getCodDepto());
		clienteIdentificadorPK.setSecId(Long.valueOf(ApplicationDefault.getClienteIdentificadorPKSecId()));
		clienteIdentificador.setId(clienteIdentificadorPK);
		clienteIdentificador.setIndPrimario(new BigDecimal(ApplicationDefault.getClienteIdentificadorIndPrimario()));
		clienteIdentificadorRepository.save(clienteIdentificador);

	}

	private Application prepareApplicationFromClienteIdentificador(Application application,
			ClienteIdentificador clienteIdentificador) throws Exception {
		if (application == null) {
			application = new Application();
		}
		application.setIdNumber(clienteIdentificador.getDocId());
		application.setDocumentType(clienteIdentificador.getTipDoc());
		application.setAgreeTermsConditions("T");
		application.setAgreeWayleaves("T");
		return application;
	}

	private void saveToClienteProfile() throws Exception {
		clienteProfile.setCodCli(cliente.getCodCli());
		clienteProfileRepository.save(clienteProfile);

	}

	private void saveToClientes() {
		if (cliente == null) {
			throw new NullPointerException("cliente or some part of it is null. ");
		}

		// Due to error on the automated on sequence
		cliente.setCodCli(clienteRepository.getCodCliNextVal());

		cliente.setTipCli(tipCliTipSolicMappingPK.getTipCli());
		cliente.setApe1Cli(application.getSurname());
		cliente.setNomCli(application.getFirstName());
		cliente.setApe2Cli(application.getMiddleName());
		cliente.setTfno3Cli(application.getMobileNumber());
		cliente.setTfno1Cli(application.getOfficeNumber());
		cliente.setEMail(application.getEmailAddress());
		cliente.setNif(new BigDecimal(fincas.getNif()));
		cliente.setRefDir(fincas.getRefDir());
		cliente.setPersContacto(application.getContactName());
		cliente.setNombrePadre(application.getContactNumber());
		clienteRepository.save(cliente);

	}

	private Application prepareApplicationFromCliente(Application application, Cliente cliente) throws Exception {
		application.setSurname(cliente.getApe1Cli());
		application.setFirstName(cliente.getNomCli());
		application.setMiddleName(cliente.getApe2Cli());
		application.setMobileNumber(cliente.getTfno3Cli());
		application.setOfficeNumber(cliente.getTfno1Cli());
		application.setEmailAddress(cliente.getEMail());
		application.setContactName(cliente.getPersContacto());
		application.setContactNumber(cliente.getNombrePadre());
		return application;
	}

	private void saveToFincas(Application application) {
		// Callejero callejero =
		// callejeroRepository.findOne(application.getStreet().longValue());

		// SMA 20160224 UMESCI-444 start
		long duplicador = 0;
		if (application.getHousePlot() != null && !application.getHousePlot().trim().isEmpty()) {
			duplicador = fincasRepository.findCountFincasByCodCalleAndNumPuerta(application.getStreet(),
					new BigDecimal(application.getHousePlot()));
		}
		// SMA 20160224 UMESCI-444 end

		final long nif = fincasRepository.getNifNextVal();
		fincas.setNif(nif);

		// access description
		fincas.setAccFinca(env.getProperty("application.default.fincas.accfinca.accessdescription.value"));
		// site
		fincas.setCodAgrupFincas(
				new BigDecimal(env.getProperty("application.default.fincas.codagrupfincas.site.value")));

		fincas.setCodCalle(application.getStreet());
		fincas.setRefDir(application.getDirectionsDesc());
		fincas.setNumPuerta(new BigDecimal(application.getHousePlot()));

		// fincas.setNumPuerta(new
		// BigDecimal(env.getProperty("application.default.fincas.numpuerta.door.value")));

		fincas.setCodPost(" ");
		fincas.setCodPostExt(" ");
		fincas.setDuplicador(String.valueOf(duplicador + 1));

		// setrviceArea
		fincas.setCodArea(callejero.getCodArea());
		// reading area
		fincas.setAreaLect(callejero.getAreaLect());
		// premise condition
		fincas.setEstFin(env.getProperty("application.default.fincas.estfin.registered.value"));

		// installation condition
		fincas.setEstInst(env.getProperty("application.default.fincas.estinst.normal.value"));
		// premise type
		fincas.setTipFin(env.getProperty("application.default.fincas.tipfin.residentialhouse.value"));

		fincas.setFActual(new Date());
		final Calendar calendar = Calendar.getInstance();
		calendar.set(2999, 11, 31);
		fincas.setFBaja(calendar.getTime());
		fincas.setFInst(new Date());
		fincas.setFRev(new Date());
		fincas.setIndRev(new BigDecimal(env.getProperty("application.default.fincas.ind_rev")));
		fincas.setNumPadron(" ");

		fincas.setPrograma(ApplicationDefault.getProgram());
		fincas.setUsrDatetime1(calendar.getTime());
		fincas.setUsrDatetime2(calendar.getTime());
		fincas.setUsrNumber1(new BigDecimal(env.getProperty("application.default.fincas.usr_number1")));
		fincas.setUsrNumber2(new BigDecimal(env.getProperty("application.default.fincas.usr_number2")));
		fincas.setUsrNumber3(new BigDecimal(env.getProperty("application.default.fincas.usr_number3")));
		fincas.setUsrVarchar1(" ");
		fincas.setUsrVarchar2(" ");
		fincas.setUsrVarchar3(" ");
		fincas.setUsuario(ApplicationDefault.getDatabaseUser());
		fincasRepository.save(fincas);

	}

	@Override
	public IopenApplication prepareIopenApplication(String numExp) throws Exception {
		Application application = new Application();
		final Expediente expediente = expedienteRepository.findById(numExp);
		application = prepareApplicationFromExpediente(application, expediente);
		final ClienteIdentificadorPK clienteIdentificadorPK = new ClienteIdentificadorPK();
		clienteIdentificadorPK.setSecId(Long.valueOf(ApplicationDefault.getClienteIdentificadorPKSecId()));
		clienteIdentificadorPK.setCodCli(expediente.getCodCliS().longValue());
		final ClienteIdentificador clienteIdentificador = clienteIdentificadorRepository
				.findById(clienteIdentificadorPK);
		application = prepareApplicationFromClienteIdentificador(application, clienteIdentificador);
		cliente = clienteRepository.findById(expediente.getCodCliS().longValue());
		application = prepareApplicationFromCliente(application, cliente);
		// fincas is not necessary

		this.application = application;
		saveToIopenApplication(true);
		iopenApplication.setExpediente(expediente);
		iopenApplicationRepository.save(iopenApplication);

		return iopenApplication;

	}

	private Application prepareApplicationFromFincas(Application application, Fincas fincas) throws Exception {
		application.setStreet(fincas.getCodCalle());
		application.setDirectionsDesc(fincas.getRefDir());
		application.setHousePlot(String.valueOf(fincas.getNumPuerta()));
		return application;
	}

	private void saveToPuntoMed() {
		puntomedPK.setNif(fincas.getNif());
		puntomed.setId(puntomedPK);
		puntomed.setFActual(new Date());
		puntomed.setUsuario(ApplicationDefault.getDatabaseUser());
		puntomed.setPrograma(ApplicationDefault.getProgram());
		puntomedRepository.save(puntomed);

	}

	private void saveToCuentasCu() {
		if (cuentasCu == null) {
			throw new NullPointerException("cuentasCu or some part of it is null. ");
		}
		cuentasCu.setPrograma(ApplicationDefault.getProgram());
		cuentasCu.setUsuario(ApplicationDefault.getDatabaseUser());
		cuentasCu.setTipCta(ApplicationDefault.getCuentasCuTipCta());
		cuentasCu.setDescriptCta(application.getSurname() + " " + application.getFirstName());
		cuentasCu.setCodCli(new BigDecimal(cliente.getCodCli()));
		cuentasCu.setTipEnv(ApplicationDefault.getCuentasCuTipEnv());
		cuentasCu.setCoModEnv(ApplicationDefault.getCuentasCucoModEnv());
		cuentasCu.setNumCopias(new BigDecimal(ApplicationDefault.getCuentasCuNomCopias()));
		cuentasCuRepository.save(cuentasCu);

	}

	private void saveToDirreccionCta() {
		if (direccionCta == null) {
			throw new NullPointerException("direccionCta or some part of it is null. ");
		}
		direccionCta.setPrograma(ApplicationDefault.getProgram());
		direccionCta.setUsuario(ApplicationDefault.getDatabaseUser());
		direccionCta.setTipDireccion(ApplicationDefault.getDirecciontipDirecion());
		direccionCta.setCodCta(new BigDecimal(cuentasCu.getCodCta()));
		direccionCta.setDescripcion(application.getSurname());
		direccionCta.setPrioridad(new BigDecimal(ApplicationDefault.getDireccionprioridad()));
		// TODO confirm actual value
		direccionCta.setDatos(application.getEmailAddress());
		direccionCta.setNif(new BigDecimal(fincas.getNif()));
		direccionCtaRepository.save(direccionCta);

	}

	private void saveToExpediente() {
		if (expediente == null) {
			throw new NullPointerException("expediente or some part of it is null. ");
		}
		final String numExp = expedienteRepository.getNumExpNextVal();
		expediente.setNumExp(numExp);
		expediente.setPrograma(ApplicationDefault.getProgram());
		expediente.setUsuario(ApplicationDefault.getDatabaseUser());
		expediente.setFSol(new Date());
		expediente.setCodCliS(new BigDecimal(cliente.getCodCli()));
		// TODO create mapping table
		expediente.setTipSolic(application.getApplicationType());
		expediente.setTipObra(ApplicationDefault.getExpedientestipObra());
		expediente.setPotTotLine(new BigDecimal(ApplicationDefault.getExpedientespotTotLine()));
		expediente.setEstado(ApplicationDefault.getExpedientesestado());
		expediente.setTipServ(ApplicationDefault.getExpedientestipServ());
		expediente.setFirstName(application.getFirstName());
		expediente.setMiddleName(application.getMiddleName());
		expediente.setSurname(application.getSurname());
		expediente.setFModif(new Date());
		expediente.setSolicitante(ApplicationDefault.getDatabaseUser());
		expediente.setIdCoNumber(application.getIdNumber());
		expediente.setTipConexion(ApplicationDefault.getExpedientestipConexion());

		expediente.setCodUnicomCompet(callejero.getCodUnicom());
		// entityManager.merge(expediente);
		expedienteRepository.save(expediente);

	}

	private Application prepareApplicationFromExpediente(Application application, Expediente expediente)
			throws Exception {
		application.setApplicationType(expediente.getTipSolic());
		application.setIdNumber(expediente.getIdCoNumber());
		return application;
	}

	private void saveToFincasExp() {
		if (fincasExp == null || fincasExpPK == null) {
			throw new NullPointerException("fincasExp or some part of it is null. ");
		}
		fincasExp.setPrograma(ApplicationDefault.getProgram());
		fincasExp.setUsuario(ApplicationDefault.getDatabaseUser());
		fincasExpPK.setNumExp(expediente.getNumExp());
		fincasExpPK.setNif(fincas.getNif());
		fincasExp.setId(fincasExpPK);
		fincasExp.setCodCalle(fincas.getCodCalle());
		fincasExp.setNumPuerta(fincas.getNumPuerta());
		fincasExp.setDuplicador(fincas.getDuplicador());
		fincasExp.setAccFinca(fincas.getAccFinca());
		fincasExp.setRefDir(fincas.getRefDir());
		fincasExpRepository.save(fincasExp);

	}

	private void saveToInvGroup() {
		invGroup.setPrograma(ApplicationDefault.getProgram());
		invGroup.setUsuario(ApplicationDefault.getDatabaseUser());
		invGroup.setIdTipImagen(new BigDecimal(ApplicationDefault.getInvGroupidTipImagen()));
		invGroup.setCodCta(new BigDecimal(cuentasCu.getCodCta()));
		invGroup.setFIg(new Date());
		invGroup.setIgSize(new BigDecimal(ApplicationDefault.getInvGroupigSize()));
		invGroup.setDescIg(application.getSurname() + " " + application.getFirstName());
		invGroupRepository.save(invGroup);

	}

	private void saveToIopenApplication(boolean submit) throws Exception {

		iopenApplication = new IopenApplication();

		if (application.getCodApplication() != null) {
			iopenApplication = iopenApplicationRepository.findOne(application.getCodApplication());
		}

		iopenApplication.setClientUsername(clienteProfile != null && clienteProfile.getUsername() != null
				? clienteProfile.getUsername() : cliente.getEMail().split(";")[0]);
		iopenApplication.setCodCli(new BigDecimal(cliente.getCodCli()));
		iopenApplication.setComments(" ");
		iopenApplication.setContactName(application.getContactName());
		iopenApplication.setContactNumber(application.getContactNumber());
		iopenApplication.setCustomerContactPerson(application.getCustomerContactPerson());
		iopenApplication.setDistrict(application.getDistrict());
		iopenApplication.setEmailAddress(application.getEmailAddress());
		iopenApplication.setEstStatus(ApplicationDefault.getApplicationstatus());
		iopenApplication.setFActual(new Date());
		iopenApplication.setFirstName(application.getFirstName());
		iopenApplication.setHousePlot(application.getHousePlot() != null && !application.getHousePlot().trim().isEmpty()
				? application.getHousePlot().trim() : "1");
		iopenApplication.setIdNumber(application.getIdNumber());
		iopenApplication.setIdType(application.getDocumentType());
		iopenApplication.setMiddleName(application.getMiddleName());
		iopenApplication.setMobileNumber(application.getMobileNumber());
		iopenApplication.setOfficeNumber(application.getOfficeNumber());
		iopenApplication.setPrograma(ApplicationDefault.getProgram());
		iopenApplication.setStreet(application.getStreet().longValue());
		iopenApplication.setSurname(application.getSurname());
		iopenApplication.setTermsAgree(application.getAgreeTermsConditions());
		iopenApplication.setTinNumber(application.getTinNumber());
		iopenApplication.setUsuario(ApplicationDefault.getDatabaseUser());
		iopenApplication.setVillage(application.getVillage());
		// iopenApplication.setIopenApplicationDocs(iopenApplicationDoc);
		iopenApplication.setAgreeWayleaves(application.getAgreeWayleaves());
		iopenApplication.setApplicationType(application.getApplicationType().trim());
		iopenApplication
		.setDistrictDesc(application.getDistrictDesc() != null ? application.getDistrictDesc().trim() : " ");
		iopenApplication.setTownDesc(application.getTownDesc() != null ? application.getTownDesc().trim() : " ");
		iopenApplication.setCountyDesc(application.getCountyDesc() != null ? application.getCountyDesc().trim() : " ");
		iopenApplication
		.setSubCountyDesc(application.getSubCountyDesc() != null ? application.getSubCountyDesc().trim() : " ");
		iopenApplication.setStreetDesc(application.getStreetDesc() != null ? application.getStreetDesc().trim() : " ");
		iopenApplication
		.setVillageDesc(application.getVillageDesc() != null ? application.getVillageDesc().trim() : " ");
		iopenApplication.setDirectionsDesc(
				application.getDirectionsDesc() != null ? application.getDirectionsDesc().trim() : " ");
		iopenApplication.setLocality(application.getLocality());
		iopenApplication.setLandmark(application.getLandmark() != null ? application.getLandmark() : " ");

		if (submit) {
			// iopenApplication.setExpediente(expediente);
			// iopenApplication.setInspectionFee(costeExp.getCoste());

			iopenApplication.setInspectionFee(null);
			iopenApplication.setComplete(new BigDecimal(1));
		} else {
			iopenApplication.setExpediente(null);
			iopenApplication.setInspectionFee(null);

			iopenApplication.setComplete(new BigDecimal(0));
		}

		iopenApplicationRepository.save(iopenApplication);

	}

	private void saveToPresupuestosExped() {
		if (presupuestosExped == null || presupuestosExpedPK == null) {
			throw new NullPointerException("presupuestosExped or some part of it is null. ");
		}
		presupuestosExped.setPrograma(ApplicationDefault.getProgram());
		presupuestosExped.setUsuario(ApplicationDefault.getDatabaseUser());

		presupuestosExpedPK.setNumExp(expediente.getNumExp());

		presupuestosExpedPK.setPresupuestosSec(Long.valueOf(ApplicationDefault.getPresupestosExpedpresupuestosSec()));

		presupuestosExpedPK.setCodPresupuesto(Long.valueOf(ApplicationDefault.getPresupestosExpedcodPresupuesto()));

		presupuestosExped.setId(presupuestosExpedPK);
		presupuestosExped.setFechaEnvio(new Date());
		// TODO confirm value
		presupuestosExped.setDescCategoria(ApplicationDefault.getPresupestosExpeddescCategoria());
		presupuestosExped.setDescConceptoPres(ApplicationDefault.getPresupestosExpeddescCncepto_pres());

		presupuestosExped.setCantidad(new BigDecimal(ApplicationDefault.getPresupestosExpedcantidad()));
		presupuestosExped.setCoste(costeExp.getCoste());

		presupuestosExped.setTipMov(ApplicationDefault.getPresupestosExpedtipMov());
		presupuestosExped.setIndBg(new BigDecimal(ApplicationDefault.getPresupestosExpedindBg()));
		presupuestosExped.setEstado(ApplicationDefault.getPresupestosExpedestado());
		presupuestosExpedRepository.save(presupuestosExped);

	}

	private void saveToSumExp() {
		if (sumExp == null || sumExpPK == null) {
			throw new NullPointerException("sumExp or some part of it is null. ");
		}
		sumExp.setPrograma(ApplicationDefault.getProgram());
		sumExp.setUsuario(ApplicationDefault.getDatabaseUser());
		sumExpPK.setNumExp(expediente.getNumExp());
		sumExpPK.setNumSum(0);
		sumExp.setId(sumExpPK);
		sumExp.setCantSum(new BigDecimal(ApplicationDefault.getSumExpcantSum()));
		sumExp.setTipInstalacion(application.getApplicationType());
		sumExpRepository.save(sumExp);

	}

	@Override
	@Transactional(rollbackFor = { IllegalArgumentException.class, ParseException.class, HibernateException.class,
			NullPointerException.class, PersistenceException.class, Exception.class })
	public IopenApplication saveUnregisteredApplication(Application application) throws Exception {

		// initalize
		this.application = application;
		initialize();

		// get clieteProfile
		clienteProfile = clienteProfileRepository
				.findClienteProfileByUsername(SecurityUtil.getLoggedClientProfile().getUsername());

		// save to IOPEN_APPLICATIONS
		saveToIopenApplication(false);

		// save attached documents
		saveIopenApplicationDocs(application);

		if (application.getCodApplication() == null) {
			final MailApplication mailApplication = new MailApplication();
			mailApplication.setTrackingNumber(String.valueOf(iopenApplication.getCodApplication()));

			// will be set by the employee
			if (iopenApplication.getDistrictDesc() != null && !iopenApplication.getDistrictDesc().isEmpty()) {
				mailApplication.setDistrict(iopenApplication.getDistrictDesc());
			}

			// SMA 20160316 start
			String fullName = iopenApplication.getFirstName() + " " + iopenApplication.getMiddleName() + " "
					+ iopenApplication.getSurname();
			if (fullName == null || fullName.trim().isEmpty()) {
				fullName = clienteProfile.getFullName();
			}
			mailApplication.setCustomerName(fullName);
			// SMA 20160316 end

			mailApplication
			.setConnectionType(commonService.getApplicationTypesName(iopenApplication.getApplicationType()));

			mailService.sendIncompleteAppFirstSave(mailApplication.getCustomerName(),
					mailApplication.getConnectionType(), mailApplication.getDistrict(),
					mailApplication.getTrackingNumber(), env.getProperty("umeme.district.phone"),
					env.getProperty("umeme.callcenter"), env.getProperty("umeme.district.email"),
					clienteProfile.getUsername());
			// SMA 20160229 start
			String smsMessage = env.getProperty("application.sms.first.save");
			smsMessage = smsMessage.replace("#customerName", fullName);
			smsMessage = smsMessage.replace("#trackingNumber", String.valueOf(iopenApplication.getCodApplication()));
			smsMessage = smsMessage.replace("#connectionType",
					commonService.getApplicationTypesName(iopenApplication.getApplicationType()));
			if (iopenApplication.getDistrictDesc() != null && !iopenApplication.getDistrictDesc().trim().isEmpty()) {
				smsMessage = smsMessage.replace("#district", env.getProperty("application.message2.district.text") + " "
						+ iopenApplication.getDistrictDesc());
			} else {
				smsMessage = smsMessage.replace("#district", "");
			}
			phoneService.sendMessage(smsMessage, clienteProfile.getPhoneNumber());
			// SMA 20160301
			if (Boolean.valueOf(env.getProperty("laxcon.test"))) {
				mailService.sendLaxxconSMStestMessage(smsMessage, iopenApplication.getEmailAddress());
			}
			// SMA 20160229 end
		}

		return iopenApplication;
	}

	/*
	 * Client save or submit action handled by this method
	 *
	 * @2016/02/15. Only save
	 *
	 * @to the iopen_applications and iopen_application_docs table
	 */
	@Override
	@Transactional(rollbackFor = { IllegalArgumentException.class, ParseException.class, HibernateException.class,
			NullPointerException.class, PersistenceException.class, Exception.class })
	public IopenApplication submitApplication(Application application, Boolean complete) throws Exception {

		// initalize
		this.application = application;

		initialize();

		// get clieteProfile
		clienteProfile = clienteProfileRepository
				.findClienteProfileByUsername(SecurityUtil.getLoggedClientProfile().getUsername());

		// save to IOPEN_APPLICATIONS
		saveToIopenApplication(false);

		// save attached documents
		saveIopenApplicationDocs(application);
		// SMA 20160407
		if (!complete) {
			if (application.getCodApplication() == null) {
				sendFirstSaveMessages(iopenApplication);
			}
		}
		return iopenApplication;
	}

	// SMA 20160407 start
	@Override
	@Transactional(rollbackFor = { IllegalArgumentException.class, ParseException.class, HibernateException.class,
			NullPointerException.class, PersistenceException.class, Exception.class })
	public IopenApplication submitApplicationTaC(Application application, Boolean complete) throws Exception {

		// initalize
		// this.application = application;

		// initialize();

		// get clieteProfile
		clienteProfile = clienteProfileRepository
				.findClienteProfileByUsername(SecurityUtil.getLoggedClientProfile().getUsername());

		// // save to IOPEN_APPLICATIONS
		// saveToIopenApplication(complete);
		iopenApplication = iopenApplicationRepository.findOne(application.getCodApplication());
		iopenApplication.setTermsAgree("Y");
		iopenApplication.setComplete(new BigDecimal(1));
		iopenApplicationRepository.save(iopenApplication);
		// save attached documents
		saveIopenApplicationDocsTaC(application);

		// send email
		if (complete) {
			sendSubmitMessages(iopenApplication);
		}

		return iopenApplication;
	}
	// SMA 20160407 end

	private void sendSubmitMessages(IopenApplication iopenApplication) throws Exception {
		final MailApplication mailApplication = new MailApplication();
		mailApplication.setTrackingNumber(String.valueOf(iopenApplication.getCodApplication()));// SMA
		// 20160316
		// start
		String fullName = iopenApplication.getFirstName() + " " + iopenApplication.getMiddleName() + " "
				+ iopenApplication.getSurname();
		if (fullName == null || fullName.trim().isEmpty()) {
			fullName = clienteProfile.getFullName();
		}
		mailApplication.setCustomerName(fullName);
		// SMA 20160316 end

		// SMA 20160303
		mailApplication.setDistrict(iopenApplication.getDistrictDesc());
		mailApplication.setConnectionType(commonService.getApplicationTypesName(iopenApplication.getApplicationType()));

		mailService.sendRegistrationSuccess(mailApplication.getCustomerName(), mailApplication.getConnectionType(),
				mailApplication.getDistrict(), mailApplication.getTrackingNumber(), iopenApplication.getEmailAddress());

		// SMA 20160229 start
		String smsMessage = env.getProperty("application.sms.submit.application");
		smsMessage = smsMessage.replace("#customerName", fullName);
		// smsMessage = smsMessage.replace("#trackingNumber",
		// String.valueOf(iopenApplication.getCodApplication()));
		smsMessage = smsMessage.replace("#connectionType",
				commonService.getApplicationTypesName(iopenApplication.getApplicationType()));
		if (iopenApplication.getDistrictDesc() != null && !iopenApplication.getDistrictDesc().isEmpty()) {
			smsMessage = smsMessage.replace("#district",
					env.getProperty("application.message2.district.text") + " " + iopenApplication.getDistrictDesc());
		} else {
			smsMessage = smsMessage.replace("#district", "");
		}
		phoneService.sendMessage(smsMessage, clienteProfile.getPhoneNumber());
		// SMA 20160301
		if (Boolean.valueOf(env.getProperty("laxcon.test"))) {
			mailService.sendLaxxconSMStestMessage(smsMessage, iopenApplication.getEmailAddress());
		}
		// SMA 20160229 end
	}

	private void sendFirstSaveMessages(IopenApplication iopenApplication) throws Exception {
		final MailApplication mailApplication = new MailApplication();
		mailApplication.setTrackingNumber(String.valueOf(iopenApplication.getCodApplication()));

		// will be set by the employee
		if (iopenApplication.getDistrictDesc() != null && !iopenApplication.getDistrictDesc().isEmpty()) {
			mailApplication.setDistrict(iopenApplication.getDistrictDesc());
		}

		// SMA 20160316 start
		String fullName = iopenApplication.getFirstName() + " " + iopenApplication.getMiddleName() + " "
				+ iopenApplication.getSurname();
		if (fullName == null || fullName.trim().isEmpty()) {
			fullName = clienteProfile.getFullName();
		}
		mailApplication.setCustomerName(fullName);
		// SMA 20160316 end

		mailApplication.setConnectionType(commonService.getApplicationTypesName(iopenApplication.getApplicationType()));

		mailService.sendIncompleteAppFirstSave(mailApplication.getCustomerName(), mailApplication.getConnectionType(),
				mailApplication.getDistrict(), mailApplication.getTrackingNumber(),
				env.getProperty("umeme.district.phone"), env.getProperty("umeme.callcenter"),
				env.getProperty("umeme.district.email"), clienteProfile.getUsername());
		// SMA 20160229 start
		String smsMessage = env.getProperty("application.sms.first.save");
		smsMessage = smsMessage.replace("#customerName", fullName);
		smsMessage = smsMessage.replace("#trackingNumber", String.valueOf(iopenApplication.getCodApplication()));
		smsMessage = smsMessage.replace("#connectionType",
				commonService.getApplicationTypesName(iopenApplication.getApplicationType()));
		if (iopenApplication.getDistrictDesc() != null && !iopenApplication.getDistrictDesc().trim().isEmpty()) {
			smsMessage = smsMessage.replace("#district",
					env.getProperty("application.message2.district.text") + " " + iopenApplication.getDistrictDesc());
		} else {
			smsMessage = smsMessage.replace("#district", "");
		}
		phoneService.sendMessage(smsMessage, clienteProfile.getPhoneNumber());
		// SMA 20160301
		if (Boolean.valueOf(env.getProperty("laxcon.test"))) {
			mailService.sendLaxxconSMStestMessage(smsMessage, iopenApplication.getEmailAddress());
		}
		// SMA 20160229 end
	}

	@Override
	@Transactional(rollbackFor = { IllegalArgumentException.class, ParseException.class, HibernateException.class,
			NullPointerException.class, PersistenceException.class, Exception.class })
	public IopenApplication employeeApproveApplication(Application application, IopenApplication iopenApplication)
			throws Exception {
		// SMA 20160317
		// check if document type is list
		if (application.getDocumentType().trim().contains(",")) {
			application.setDocumentType(application.getDocumentType().trim().split(",")[0]);
		}
		// initalize
		this.application = application;
		initialize();

		// get clieteProfile
		clienteProfile = clienteProfileRepository
				.findClienteProfileByUsername(application.getIopenApplication().getClientUsername());
		long codCli = 0;
		if (clienteProfile != null) {
			codCli = clienteProfile.getCodCli();
		}

		if (codCli > 0) {
			cliente = clienteRepository.findById(codCli);
		}

		// saveToFincas
		saveToFincas(application);
		// save to PUNTOMED
		saveToPuntoMed();
		/*
		 * Save this entities only if the idType and idNumber of the client
		 * don't exist
		 */
		if (codCli <= 0) {
			// save Clientes
			saveToClientes();

			// save to CLIENTE_IDENTIFICADOR
			saveToClienteIdentificador();

			// save to CUENTAS_CU
			saveToCuentasCu();

			// save to DIRRECCION_CTA
			saveToDirreccionCta();

			// save to INV_GROUP
			saveToInvGroup();
		}

		// save to BDG_ACT_FOI_AUX

		// save to EXPEDIENTES
		saveToExpediente();

		// save to PRESUPUESTOS_EXPED
		saveToPresupuestosExped();

		// save to SUM_EXP
		saveToSumExp();

		// save to ACTIVIDADES
		saveToActividades();

		// save to FINCAS_EXP
		saveToFincasExp();

		// save to CLIENTE_PROFILE
		saveToClienteProfile();

		final String currency = env.getProperty("application.default.currency.value");
		final DecimalFormat currencyFormat = new DecimalFormat(currency + "###,###.00" + "/=");

		final MailApplication mailApplication = new MailApplication();
		mailApplication.setTrackingNumber(String.valueOf(iopenApplication.getCodApplication()));
		// SMA 20160316 start
		String fullName = iopenApplication.getFirstName() + " " + iopenApplication.getMiddleName() + " "
				+ iopenApplication.getSurname();
		if (fullName == null || fullName.trim().isEmpty()) {
			fullName = clienteProfile.getFullName();
		}
		mailApplication.setCustomerName(fullName);
		// SMA 20160316 end
		mailApplication.setDistrict(municipioRepository.findOne(iopenApplication.getDistrict()).getNomMunic());
		mailApplication.setConnectionType(commonService.getApplicationTypesName(iopenApplication.getApplicationType()));
		// approved
		iopenApplication.setClientUsername(clienteProfile.getUsername());
		iopenApplication.setCodCli(new BigDecimal(cliente.getCodCli()));
		iopenApplication.setExpediente(expediente);
		iopenApplication.setInspectionFee(costeExp.getCoste());
		final MailApplicationApproval mailApplicationApproval = new MailApplicationApproval(mailApplication);
		// SMA 20160303 use IopenUnicomContact instead of iopenDistrictContact
		IopenUnicomContact iopenUnicomContact = null;
		if (callejero != null) {
			iopenUnicomContact = iopenUnicomContactRepository.findOne(String.valueOf(callejero.getCodUnicom()));
			mailApplicationApproval.setDistrictPhoneNumber(iopenUnicomContact.getPhoneContact());
			mailApplicationApproval.setDistrictEmailAddress(iopenUnicomContact.getEmail());
		} // SMA 20160303 end
		mailApplicationApproval
		.setInspectionFee(String.valueOf(currencyFormat.format(iopenApplication.getInspectionFee())));
		mailApplicationApproval.setApplicationNumber(iopenApplication.getExpediente().getNumExp());
		mailApplicationApproval.setCallCentreNumber(env.getProperty("umeme.callcenter"));
		mailService.sendApplicationStatus(mailApplicationApproval, MailApplicationType.APPROVAL,
				iopenApplication.getEmailAddress());

		// SMA 20160229 start
		String smsMessage = env.getProperty("application.sms.approval");
		// SMA 20160316
		smsMessage = smsMessage.replace("#customerName", fullName);
		smsMessage = smsMessage.replace("#trackingNumber", String.valueOf(iopenApplication.getCodApplication()));
		smsMessage = smsMessage.replace("#connectionType",
				commonService.getApplicationTypesName(iopenApplication.getApplicationType()));
		if (iopenApplication.getDistrictDesc() != null && !iopenApplication.getDistrictDesc().isEmpty()) {
			smsMessage = smsMessage.replace("#district", env.getProperty("application.message.district.text") + " "
					+ municipioRepository.findOne(iopenApplication.getDistrict()).getNomMunic());
		} else {
			smsMessage = smsMessage.replace("#district", "");
		}
		phoneService.sendMessage(smsMessage, clienteProfile.getPhoneNumber());
		// SMA 20160301
		if (Boolean.valueOf(env.getProperty("laxcon.test"))) {
			mailService.sendLaxxconSMStestMessage(smsMessage, iopenApplication.getEmailAddress());
		}
		// SMA 20160229 end
		return iopenApplication;
	}

	@Override
	public IopenApplication findIopenApplicationByCodApplication(Long codApplication) {
		return iopenApplicationRepository.findOne(codApplication);
	}

	@Override
	@Transactional(rollbackFor = { IllegalArgumentException.class, ParseException.class, HibernateException.class,
			NullPointerException.class, PersistenceException.class, Exception.class })
	public void discardIncompleteApplication(Application application) throws Exception {
		if (application.getCodApplication() != null) {
			final IopenApplication iopenApplication = iopenApplicationRepository
					.findOne(application.getCodApplication());

			// Delete the files if uploaded
			for (final IopenApplicationDoc applicationDoc : iopenApplication.getIopenApplicationDocs()) {
				fileService.deleteFile(applicationDoc.getId().getCodApplication(), applicationDoc.getId().getTipDoc());
			}

			// Delete the Application
			iopenApplicationRepository.delete(iopenApplication);

			System.out.println("Application Deleted Successfully");
		}
	}

}
