package com.indra.iopen.service.impl;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.form.ApplicationInvoice;
import com.indra.iopen.form.ApplicationList;
import com.indra.iopen.form.ApplicationListFilter;
import com.indra.iopen.form.ApplicationPendingInvoiceInformation;
import com.indra.iopen.form.ApplicationStatusInformation;
import com.indra.iopen.form.IOpenFile;
import com.indra.iopen.form.Status;
import com.indra.iopen.model.Callejero;
import com.indra.iopen.model.Cliente;
import com.indra.iopen.model.ClienteIdentificador;
import com.indra.iopen.model.ClienteIdentificadorPK;
import com.indra.iopen.model.ClienteProfile;
import com.indra.iopen.model.Codigo;
import com.indra.iopen.model.CosteExp;
import com.indra.iopen.model.Estado;
import com.indra.iopen.model.Expediente;
import com.indra.iopen.model.Fincas;
import com.indra.iopen.model.FincasExp;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.IopenApplicationDoc;
import com.indra.iopen.model.IopenApplicationDocPK;
import com.indra.iopen.model.IopenApplicationStatus;
import com.indra.iopen.model.IopenUnicomContact;
import com.indra.iopen.model.Municipio;
import com.indra.iopen.model.PresupuestosExped;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.model.security.users.EmployeeUser;
import com.indra.iopen.pojo.MailApplication;
import com.indra.iopen.pojo.MailApplicationCancelOrReject;
import com.indra.iopen.repositories.model.CallejeroRepository;
import com.indra.iopen.repositories.model.ClienteIdentificadorRepository;
import com.indra.iopen.repositories.model.ClienteProfileRepository;
import com.indra.iopen.repositories.model.ClienteRepository;
import com.indra.iopen.repositories.model.CodigoRepository;
import com.indra.iopen.repositories.model.CosteExpRepository;
import com.indra.iopen.repositories.model.DistrictDeptoRepository;
import com.indra.iopen.repositories.model.EstadoRepository;
import com.indra.iopen.repositories.model.ExpedienteRepository;
import com.indra.iopen.repositories.model.FincasExpRepository;
import com.indra.iopen.repositories.model.FincasRepository;
import com.indra.iopen.repositories.model.IopenApplicationRepository;
import com.indra.iopen.repositories.model.IopenApplicationStageRepository;
import com.indra.iopen.repositories.model.IopenApplicationStatusRepository;
import com.indra.iopen.repositories.model.IopenUnicomContactRepository;
import com.indra.iopen.repositories.model.MunicipioRepository;
import com.indra.iopen.repositories.model.PresupuestosExpedRepository;
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
public class ApplicationListServiceImpl implements ApplicationListService {

	@Autowired
	private IopenApplicationRepository iopenApplicationRepository;
	@Autowired
	private PresupuestosExpedRepository presupuestosExpedRepository;
	@Autowired
	private ClienteProfileRepository clienteProfileRepository;
	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CodigoRepository codigoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ClienteIdentificadorRepository clienteIdentificadorRepository;
	@Autowired
	private DistrictDeptoRepository districtDeptoRepository;
	@Autowired
	private FincasRepository fincasRepository;
	@Autowired
	private FincasExpRepository fincasExpRepository;
	@Autowired
	private CallejeroRepository callejeroRepository;
	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private IopenApplicationStageRepository iopenApplicationStageRepository;
	// SMA 20160303
	@Autowired
	private IopenUnicomContactRepository iopenUnicomContactRepository;
	@Autowired
	private ApplicationService applicationService;
	/*
	 * @Autowired private IopenApplicationDocRepository
	 * iopenApplicationDocRepository;
	 */
	@Autowired
	private FileService fileService;
	@Autowired
	private ExpedienteRepository expedienteRepository;
	@Autowired
	private CosteExpRepository costeExpRepository;
	@Autowired
	private IopenApplicationStatusRepository iopenApplicationStatusRepository;

	@Autowired
	@Lazy
	private MailService mailService;

	@Autowired
	private Environment env;
	@Autowired
	private CommonService commonService;
	// SMA 20160229
	@Autowired
	private PhoneService phoneService;
	private Fincas fincas = null;

	// @Override
	// public List<ApplicationList> testApplicationList() {
	//
	//// return allApplicationList();
	//
	// ClienteProfile clienteProfile =
	// clienteProfileRepository.findClienteById(1700L, "test@gmail.com") ;
	//
	// retqurn clientApplicationList(clienteProfile);
	// }
	@Override
	public List<ApplicationList> searchApplicationByTrackingNumberOrApplicationNumber(final String trackingNumber,
			final String applicationNumber) throws Exception {
		final List<ApplicationList> applicationList = new ArrayList<ApplicationList>();
		final IopenApplication iopenApplication = iopenApplicationRepository
				.findIopenApplicationByCodApplicationOrExpedienteNumExp(Long.valueOf(trackingNumber),
						applicationNumber);
		final Expediente searchExpediente = iopenApplication.getExpediente();

		if (searchExpediente == null) {
			throw new DataIntegrityException("The application number does not exist");
		}

		final ApplicationList application = new ApplicationList();

		application.setApplicationNumber(searchExpediente.getNumExp());
		application.setApplicationType(tipoRepository.findById(searchExpediente.getTipSolic()).getDescTipo());
		application.setApplicationCurrentStage(estadoRepository.findById(searchExpediente.getEstado()).getDescEst());
		application.setApplicationDate(new SimpleDateFormat("dd-MM-yyyy").format(searchExpediente.getFActual()));

		application.setApplicationNextStage(" ");

		applicationList.add(application);

		return applicationList;
	}

	@Override
	public List<ApplicationList> searchApplicationByTrackingNumber(final String trackingNumber) throws Exception {
		final List<ApplicationList> applicationList = new ArrayList<ApplicationList>();
		final IopenApplication iopenApplication = iopenApplicationRepository.findOne(Long.valueOf(trackingNumber));
		final Expediente searchExpediente = iopenApplication.getExpediente();

		if (searchExpediente == null) {
			throw new DataIntegrityException("The application number does not exist");
		}

		final ApplicationList application = new ApplicationList();

		application.setApplicationNumber(searchExpediente.getNumExp());
		application.setApplicationType(tipoRepository.findById(searchExpediente.getTipSolic()).getDescTipo());
		application.setApplicationCurrentStage(estadoRepository.findById(searchExpediente.getEstado()).getDescEst());
		application.setApplicationDate(new SimpleDateFormat("dd-MM-yyyy").format(searchExpediente.getFActual()));

		application.setApplicationNextStage(" ");

		applicationList.add(application);

		return applicationList;
	}

	@Override
	public List<ApplicationList> searchApplicationByNumExp(final String numExp) throws Exception {
		final List<ApplicationList> applicationList = new ArrayList<ApplicationList>();
		final Expediente searchExpediente = expedienteRepository.findById(numExp.toUpperCase());

		if (searchExpediente == null) {
			throw new DataIntegrityException("The application number does not exist");
		}

		final ApplicationList application = new ApplicationList();

		application.setApplicationNumber(searchExpediente.getNumExp());
		application.setApplicationType(tipoRepository.findById(searchExpediente.getTipSolic()).getDescTipo());
		application.setApplicationCurrentStage(estadoRepository.findById(searchExpediente.getEstado()).getDescEst());
		application.setApplicationDate(new SimpleDateFormat("dd-MM-yyyy").format(searchExpediente.getFActual()));

		application.setApplicationNextStage(" ");

		applicationList.add(application);

		return applicationList;
	}

	@Override
	public List<ApplicationList> allApplicationList(boolean complete) {
		List<ApplicationList> applicationList = new ArrayList<ApplicationList>();

		final List<IopenApplication> iopenApplications = (List<IopenApplication>) iopenApplicationRepository.findAll();

		applicationList = prepareApplicationList(iopenApplications, complete);

		return applicationList;
	}

	@Override
	public void cancelApplication(final Long id) throws Exception {
		final IopenApplication oldIopenApplication = iopenApplicationRepository.findOne(id);
		oldIopenApplication.setEstStatus(ApplicationDefault.getApplicationIopenStatusCancel());
		// edit expediente
		saveToExpediente(oldIopenApplication);
		// edit iopen application
		iopenApplicationRepository.save(oldIopenApplication);
	}

	@Override
	public ApplicationList clientApplicationDetail(final long codApplication, final boolean complete) {
		ApplicationList applicationList = new ApplicationList();
		System.out.println("cod: " + codApplication);
		// List<IopenApplication> iopenApplications = new
		// ArrayList<IopenApplication>();
		// iopenApplications.add(iopenApplicationRepository.findById(codApplication));

		applicationList = prepareApplicationDetail(iopenApplicationRepository.findOne(codApplication), complete);

		return applicationList;
	}

	@Override
	public ApplicationStatusInformation clientApplicationStatusInformation(final long codApplication,
			final boolean complete) {
		ApplicationStatusInformation applicationStatusInformation = new ApplicationStatusInformation();

		applicationStatusInformation = prepareApplicationStatusInformation(
				iopenApplicationRepository.findOne(codApplication), complete);

		return applicationStatusInformation;
	}

	@Override
	public ApplicationPendingInvoiceInformation clientApplicationPendingInvoiceInformation(final long codApplication,
			final boolean complete) {
		ApplicationPendingInvoiceInformation applicationPendingInvoiceInformation = new ApplicationPendingInvoiceInformation();

		applicationPendingInvoiceInformation = prepareApplicationPendingInvoiceInformation(
				iopenApplicationRepository.findOne(codApplication), complete);

		return applicationPendingInvoiceInformation;
	}

	/*
	 * Generate application list for clients
	 *
	 */
	@Override
	public List<ApplicationList> clientApplicationList(final ClienteProfile clienteProfile, final boolean complete) {
		List<ApplicationList> applicationList = new ArrayList<ApplicationList>();

		final List<IopenApplication> iopenApplications = iopenApplicationRepository
				.findClientIopenApplications(clienteProfile.getUsername(), complete);
		// SMA 20160315
		if (iopenApplications != null && !iopenApplications.isEmpty()) {
			applicationList = prepareApplicationList(iopenApplications, complete);
		}
		return applicationList;
	}

	@Override
	public List<ApplicationList> clientApplicationListByStatus(final ClienteProfile clienteProfile, final String status,
			final boolean complete) {
		List<ApplicationList> applicationList = new ArrayList<ApplicationList>();
		List<IopenApplication> iopenApplications = null;
		iopenApplications = clientIopenApplicationsByStatus(clienteProfile, status, complete, iopenApplications);
		applicationList = prepareApplicationList(iopenApplications, true);

		return applicationList;
	}

	private List<IopenApplication> clientIopenApplicationsByStatus(ClienteProfile clienteProfile, String status,
			boolean complete, List<IopenApplication> iopenApplications) {
		if (status.equalsIgnoreCase("ALL")) {
			iopenApplications = iopenApplicationRepository.findClientIopenApplications(clienteProfile.getUsername(),
					complete);
		} else {
			// SMA 20160219 UMESCI-446 start
			iopenApplications = iopenApplicationRepository.findByStatus(status, clienteProfile.getUsername(),
					complete ? new BigDecimal(1) : new BigDecimal(0));
			// SMA 20160219 UMESCI-446 end
		}
		return iopenApplications;
	}

	@Override
	public List<ApplicationList> clientApplicationListUsername(final String username, final boolean complete) {

		return clientApplicationList(clienteProfileRepository.findClienteProfileByUsername(username), complete);
	}

	@Override
	public List<ApplicationList> clientIncompleteApplicationList(final ClienteProfile clienteProfile) {
		List<ApplicationList> applicationList = new ArrayList<ApplicationList>();

		final List<IopenApplication> iopenApplications = iopenApplicationRepository
				.findIncompleteClientIopenApplications(clienteProfile.getUsername());

		applicationList = prepareApplicationList(iopenApplications, false);

		return applicationList;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void deleteDoc(final String appId, final String docId) throws Exception {
		/*
		 * IopenApplicationDoc iopenApplicationDoc =
		 * iopenApplicationDocRepository .findById(new
		 * IopenApplicationDocPK(Long.valueOf(appId), docId));
		 * iopenApplicationDocRepository.delete(iopenApplicationDoc);
		 */
		fileService.deleteFile(Long.valueOf(appId), docId);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public ApplicationList edit(final ApplicationList applicationList) throws Exception {

		final IopenApplication iopenApplication = applicationList.getIopenApplication();

		System.out.println("list " + applicationList + "\n iopen " + iopenApplication);
		IopenApplication oldIopenApplication = iopenApplicationRepository.findOne(iopenApplication.getCodApplication());

		// SMA 20160303 notification email sent to umeme
		final String oldStatus = oldIopenApplication.getEstStatus();
		final Long district = oldIopenApplication.getDistrict();
		final Long street = oldIopenApplication.getStreet();
		final String prevApplicationType = oldIopenApplication.getApplicationType();
		
		List<IopenApplicationDoc> prevFiles=  oldIopenApplication.getIopenApplicationDocs();
		int count = 0;
		for(IopenApplicationDoc doc: prevFiles) {
			if(doc.getTac().equals("1")) {
				count += 1;			
			}
		}

		final int allFiles = applicationList.getFiles().size() + (prevFiles.size()-count);

		if (allFiles > Integer.parseInt(env.getProperty("file.application.input.max.files"))) {
			throw new DataIntegrityException("More than the required number of files uploaded");
		}

		// SMA 20160407
		// save added application
		oldIopenApplication.getIopenApplicationDocs()
		.addAll(saveIopenApplicationDocs(applicationList, iopenApplication));

		// edit iopenApplication
		oldIopenApplication = editIopenApplication(iopenApplication, oldIopenApplication);

		// should be saved from the customer profile
		// // edit cliente
		// editCliente(oldIopenApplication);
		// // edit clienteIdentificador
		// editClienteIdentificador(oldIopenApplication);

		// SMA 20160407
		applicationList.setIopenApplication(oldIopenApplication);
		/* Edit expedientes and presupuestosExped */
		if (!prevApplicationType.equals(oldIopenApplication.getApplicationType())
				&& oldIopenApplication.getExpediente() != null) {
			editExpediente(oldIopenApplication);
			editPresupuestosExped(oldIopenApplication);
		}
		// SMA 20160303 notification email sent to umeme
		if (oldIopenApplication.getStreet() != null && oldIopenApplication.getStreet() != 0
				&& oldStatus.equalsIgnoreCase(env.getProperty("application.iopenstatus.reject"))) {
			final Municipio municipio = municipioRepository.findOne(district);
			final Callejero callejero = callejeroRepository.findOne(street);
			final IopenUnicomContact iopenUnicomContact = iopenUnicomContactRepository
					.findOne(String.valueOf(callejero.getCodUnicom()));
			final boolean test = Boolean.getBoolean(env.getProperty("laxcon.test"));
			if (municipio != null && iopenUnicomContact != null) {
				if (test) {
					mailService.sendDistrictNotifyUpdatedApps(municipio.getNomMunic(),
							String.valueOf(iopenApplication.getCodApplication()),
							oldIopenApplication.getEmailAddress());
				} else {
					mailService.sendDistrictNotifyUpdatedApps(municipio.getNomMunic(),
							String.valueOf(iopenApplication.getCodApplication()), iopenUnicomContact.getEmail());
				}
			}
		}
		return applicationList;
	}

	private void editCliente(final IopenApplication iopenApplication) {

		final Cliente cliente = clienteRepository.findById(iopenApplication.getCodCli().longValue());
		cliente.setApe1Cli(iopenApplication.getSurname());
		cliente.setNomCli(iopenApplication.getFirstName());
		cliente.setApe2Cli(iopenApplication.getMiddleName());
		cliente.setTfno3Cli(iopenApplication.getMobileNumber());
		cliente.setTfno1Cli(iopenApplication.getOfficeNumber());
		cliente.setEMail(iopenApplication.getEmailAddress());
		cliente.setPersContacto(iopenApplication.getContactName());
		cliente.setNombrePadre(iopenApplication.getContactNumber());
		clienteRepository.edit(cliente);
	}

	private void editClienteIdentificador(final IopenApplication iopenApplication) {

		Municipio municipio = null;

		municipio = municipioRepository.findOne(iopenApplication.getDistrict());
		final ClienteIdentificador clienteIdentificador = clienteIdentificadorRepository
				.findById(new ClienteIdentificadorPK(iopenApplication.getCodCli().longValue(),
						Long.valueOf(ApplicationDefault.getClienteIdentificadorPKSecId())));
		clienteIdentificador.setDocId(iopenApplication.getIdNumber());
		clienteIdentificador.setTipDoc(iopenApplication.getIdType());
		clienteIdentificador.setPrograma(ApplicationDefault.getProgram());
		clienteIdentificador.setUsuario(ApplicationDefault.getDatabaseUser());
		clienteIdentificador.setCodProv(new BigDecimal(ApplicationDefault.getClienteIdentificadorCodProv()));
		clienteIdentificador.setCodDepto(municipio.getCodDepto());
		clienteIdentificadorRepository.edit(clienteIdentificador);

	}

	/* Edit expediente in case of change of application type */
	private void editExpediente(final IopenApplication iopenApplication) {
		final Expediente expediente = expedienteRepository.findById(iopenApplication.getExpediente().getNumExp());

		final Callejero callejero = callejeroRepository.findOne(iopenApplication.getStreet().longValue());

		expediente.setTipSolic(iopenApplication.getApplicationType());

		expediente.setCodUnicomCompet(callejero.getCodUnicom());

		expedienteRepository.edit(expediente);
	}

	private IopenApplication editIopenApplication(final IopenApplication iopenApplication,
			final IopenApplication oldIopenApplication) {
		// SMA 20160219 UMESC-444 start
		if (oldIopenApplication.getExpediente() != null
				&& !oldIopenApplication.getExpediente().getEstado()
				.equalsIgnoreCase(env.getProperty("application.stage.inspection.paid.value"))
				&& !oldIopenApplication.getExpediente().getEstado()
				.equalsIgnoreCase(env.getProperty("application.stage.reinspection.paid.value"))) {
			editFincas(oldIopenApplication);
			final CosteExp costeExp = costeExpRepository.findCoste(iopenApplication.getApplicationType(),
					ApplicationDefault.getPresupestosExpedtipMov());

			oldIopenApplication.setInspectionFee(costeExp.getCoste());
			oldIopenApplication.setApplicationType(iopenApplication.getApplicationType());// To
			// edit
			// applicationType
		}
		// Change status from rejected to pending review on editing details
		if (oldIopenApplication.getEstStatus().equals(ApplicationDefault.getApplicationIopenStatusReject())) {
			if (oldIopenApplication.getExpediente() != null && (oldIopenApplication.getExpediente().getEstado()
					.equalsIgnoreCase(env.getProperty("application.stage.inspection.paid.value"))
					|| oldIopenApplication.getExpediente().getEstado()
					.equalsIgnoreCase(env.getProperty("application.stage.reinspection.paid.value")))) {
				oldIopenApplication.setEstStatus(env.getProperty("application.iopenstatus.approved"));
			} else {
				oldIopenApplication.setEstStatus(ApplicationDefault.getApplicationstatus());
			}

			// audit trail
			final IopenApplicationStatus iopenApplicationStatus = new IopenApplicationStatus();
			iopenApplicationStatus.setCodApplication(String.valueOf(iopenApplication.getCodApplication()));
			iopenApplicationStatus.setEstStatus(oldIopenApplication.getEstStatus());
			iopenApplicationStatus.setFActual(new Date());
			iopenApplicationStatus.setStatusDate(new Date());
			iopenApplicationStatus.setStatusBy(
					((ClientUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
			iopenApplicationStatus.setUsuario(
					((ClientUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
			iopenApplicationStatusRepository.save(iopenApplicationStatus);
		}

		// oldIopenApplication.setSurname(iopenApplication.getSurname());
		// oldIopenApplication.setFirstName(iopenApplication.getFirstName());
		// oldIopenApplication.setMiddleName(iopenApplication.getMiddleName());
		// oldIopenApplication.setMobileNumber(iopenApplication.getMobileNumber());
		// oldIopenApplication.setOfficeNumber(iopenApplication.getOfficeNumber());
		// oldIopenApplication.setEmailAddress(iopenApplication.getEmailAddress());
		// oldIopenApplication.setContactName(iopenApplication.getContactName());
		// oldIopenApplication.setContactNumber(iopenApplication.getContactNumber());
		// oldIopenApplication.setIdNumber(iopenApplication.getIdNumber());
		// oldIopenApplication.setIdType(iopenApplication.getIdType());
		// SMA 20160219 UMESC-444 start
		oldIopenApplication.setStreetDesc(iopenApplication.getStreetDesc());
		oldIopenApplication.setCountyDesc(iopenApplication.getCountyDesc());
		oldIopenApplication.setDirectionsDesc(iopenApplication.getDirectionsDesc());
		oldIopenApplication.setDistrictDesc(iopenApplication.getDistrictDesc());
		oldIopenApplication.setStreetDesc(iopenApplication.getStreetDesc());
		oldIopenApplication.setSubCountyDesc(iopenApplication.getSubCountyDesc());
		oldIopenApplication.setTownDesc(iopenApplication.getTownDesc());
		oldIopenApplication.setVillageDesc(iopenApplication.getVillageDesc());
		// SMA 20160219 UMESC-444 end
		// oldIopenApplication.setDistrict((iopenApplication.getDistrict() ==
		// null) ? 0 : iopenApplication.getDistrict());
		// oldIopenApplication.setLocality((iopenApplication.getLocality() ==
		// null) ? 0 : iopenApplication.getLocality());
		// oldIopenApplication.setVillage((iopenApplication.getVillage() ==
		// null) ? 0 : iopenApplication.getVillage());
		// oldIopenApplication.setStreet((iopenApplication.getStreet() == null)
		// ? 0 : iopenApplication.getStreet());
		// oldIopenApplication
		// .setHousePlot((iopenApplication.getHousePlot() == null) ? " " :
		// iopenApplication.getHousePlot());

		// SMA 20160407
		oldIopenApplication.setComplete(iopenApplication.getComplete());
		oldIopenApplication.setTinNumber(iopenApplication.getTinNumber());
		// oldIopenApplication.setIopenApplicationDocs(iopenApplication.getIopenApplicationDocs());
		// SMA 20160407
		boolean intermediateSubmit = true;
		for (final IopenApplicationDoc doc : oldIopenApplication.getIopenApplicationDocs()) {
			if (doc.getTac().equalsIgnoreCase("1")) {
				intermediateSubmit = false;
			}
		}
		if (intermediateSubmit) {
			oldIopenApplication.setComplete(new BigDecimal(0));
		} else {
			oldIopenApplication.setComplete(new BigDecimal(1));
		}
		if (oldIopenApplication.getIopenApplicationDocs().size() < 4) {
			oldIopenApplication.setComplete(new BigDecimal(0));
		}
		// SMA 20160412 start : to remove rejection reason
		oldIopenApplication.setInspectionRejectCode(null);
		oldIopenApplication.setInspectionRejectBy(null);
		oldIopenApplication.setInspectionRejectComment(null);
		oldIopenApplication.setInspectionRejectDate(null);
		oldIopenApplication.setInspectionRejected(Boolean.FALSE);
		oldIopenApplication.setCoRejectReason(null);
		oldIopenApplication.setComments(null);
		// SMA 20160412 end

		iopenApplicationRepository.save(oldIopenApplication);
		return oldIopenApplication;

	}

	private void editFincas(IopenApplication oldIopenApplication) {
		// SMA 20160219 UMESC-444 start
		if (oldIopenApplication.getExpediente() != null) {
			final Callejero callejero = callejeroRepository.findOne(oldIopenApplication.getStreet().longValue());

			final FincasExp fincasExp = fincasExpRepository
					.findMaxSecIdByNumExp(oldIopenApplication.getExpediente().getNumExp());

			fincas = fincasRepository.findOne(fincasExp.getId().getNif());
			fincas.setCodCalle(new BigDecimal(oldIopenApplication.getStreet()));
			fincas.setRefDir(oldIopenApplication.getLandmark());
			// setrviceArea
			fincas.setCodArea(callejero.getCodArea());
			// reading area
			fincas.setAreaLect(callejero.getAreaLect());

			fincasRepository.save(fincas);
		}
		// SMA 20160219 UMESC-444 end

	}

	/* Edit inspection fee */
	private void editPresupuestosExped(final IopenApplication iopenApplication) {
		// SMA 20160219 UMESC-444 start
		if (iopenApplication.getExpediente() != null) {
			final List<PresupuestosExped> presupuestosExpeds = presupuestosExpedRepository
					.findPresupuestosExpedByIdNumExp(iopenApplication.getExpediente().getNumExp());

			final PresupuestosExped presupuestosExped = presupuestosExpeds.get(0);

			// CosteExp costeExp =
			// costeExpRepository.findCoste(iopenApplication.getApplicationType(),
			// ApplicationDefault.getPresupestosExpedtipMov());

			presupuestosExped.setCoste(iopenApplication.getInspectionFee());

			presupuestosExpedRepository.save(presupuestosExped);
		}
		// SMA 20160219 UMESC-444 end
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public ApplicationList editStatus(final ApplicationList applicationList) throws Exception {
		final IopenApplication iopenApplication = applicationList.getIopenApplication();
		final String status = iopenApplication.getEstStatus();
		final String comment = iopenApplication.getComments();
		final String rejectReason = iopenApplication.getCoRejectReason();
		if (status.equalsIgnoreCase("IA003") && (comment == null || comment.trim().isEmpty() || rejectReason == null
				|| rejectReason.trim().isEmpty())) {
			throw new DataIntegrityException("Ensure you have filled all of the approval status information");
		}

		IopenApplication iopenApplicationRepo = iopenApplicationRepository
				.findOne(iopenApplication.getCodApplication());
		iopenApplicationRepo.setEstStatus(status);
		iopenApplicationRepo.setComments(comment);
		iopenApplicationRepo.setCoRejectReason(rejectReason);
		// SMA 20162202 UMESCI-444 start
		iopenApplicationRepo.setVillage(iopenApplication.getVillage());
		iopenApplicationRepo.setLocality(iopenApplication.getLocality());
		iopenApplicationRepo.setDistrict(iopenApplication.getDistrict());
		iopenApplicationRepo.setStreet(iopenApplication.getStreet());
		// SMA 20162202 UMESCI-444 end
		// audit trail
		final IopenApplicationStatus iopenApplicationStatus = new IopenApplicationStatus();
		iopenApplicationStatus.setCodApplication(String.valueOf(iopenApplicationRepo.getCodApplication()));
		iopenApplicationStatus.setEstStatus(status);
		iopenApplicationStatus.setFActual(new Date());
		iopenApplicationStatus.setStatusDate(new Date());
		iopenApplicationStatus
		.setStatusBy(((EmployeeUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getEmployeeProfile().getNomUsr());
		iopenApplicationStatus
		.setUsuario(((EmployeeUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getEmployeeProfile().getNomUsr());
		iopenApplicationStatusRepository.save(iopenApplicationStatus);
		// edit iopenApplication
		// SMA 20160303
		Callejero callejero = null;
		if (status.equalsIgnoreCase("IA002")) {
			iopenApplicationRepo = applicationService.employeeApproveApplication(
					applicationService.mapIopenapplicationToApplication(iopenApplicationRepo), iopenApplicationRepo);
			// SMA 20160303
			callejero = callejeroRepository.findOne(iopenApplicationRepo.getStreet());
		}

		iopenApplicationRepository.save(iopenApplicationRepo);
		final Municipio municipio = municipioRepository.findOne(iopenApplicationRepo.getDistrict());
		// SMA 20160303 use IopenUnicomContact instead of iopenDistrictContact
		IopenUnicomContact iopenUnicomContact = null;
		if (callejero != null) {
			iopenUnicomContact = iopenUnicomContactRepository.findOne(String.valueOf(callejero.getCodUnicom()));
		}
		// SMA 20162202 UMESCI-444 end
		final MailApplication mailApplication = new MailApplication();
		mailApplication.setTrackingNumber(String.valueOf(iopenApplicationRepo.getCodApplication()));
		mailApplication.setCustomerName(iopenApplicationRepo.getFirstName() + " " + iopenApplicationRepo.getMiddleName()
		+ " " + iopenApplicationRepo.getSurname());
		// SMA 20162202 UMESCI-444 start
		if (iopenApplicationRepo.getDistrict() != null && iopenApplicationRepo.getDistrict() != 0) {
			mailApplication.setDistrict(municipio.getNomMunic());
		} else {
			if (iopenApplicationRepo.getDistrictDesc() != null
					&& !iopenApplicationRepo.getDistrictDesc().trim().isEmpty()) {
				mailApplication.setDistrict(iopenApplicationRepo.getDistrictDesc());
			}
		}
		// SMA 20162202 UMESCI-444 end
		mailApplication
		.setConnectionType(commonService.getApplicationTypesName(iopenApplicationRepo.getApplicationType()));

		if (!status.equalsIgnoreCase("IA002")) {
			final MailApplicationCancelOrReject mailApplicationCancelOrReject = new MailApplicationCancelOrReject(
					mailApplication);
			mailApplicationCancelOrReject.setCallCentreNumber(env.getProperty("umeme.callcenter"));
			// SMA 20160303 start
			if (iopenUnicomContact != null) {
				mailApplicationCancelOrReject.setDistrictEmailAddress(iopenUnicomContact.getEmail());
				mailApplicationCancelOrReject.setDistrictPhoneNumber(iopenUnicomContact.getPhoneContact());
			}
			// SMA 20160303 end
			mailApplicationCancelOrReject.setReasons(iopenApplicationRepo.getComments());

			if (status.equalsIgnoreCase(env.getProperty("application.iopenstatus.reject"))) {
				// rejected
				mailService.sendApplicationStatus(mailApplicationCancelOrReject, MailApplicationType.REJECTION,
						iopenApplication.getEmailAddress());

				// SMA 20160229 start
				String smsMessage = env.getProperty("application.sms.rejection");
				smsMessage = smsMessage.replace("#customerName", mailApplicationCancelOrReject.getCustomerName());
				smsMessage = smsMessage.replace("#trackingNumber", mailApplicationCancelOrReject.getTrackingNumber());
				phoneService.sendMessage(smsMessage, iopenApplicationRepo.getMobileNumber());
				// SMA 20160229 end
				// SMA 20160301
				if (Boolean.valueOf(env.getProperty("laxcon.test"))) {
					mailService.sendLaxxconSMStestMessage(smsMessage, iopenApplication.getEmailAddress());
				}
			} else if (status.equalsIgnoreCase(env.getProperty("application.iopenstatus.cancel"))) {
				// cancelled
				cancelApplication(iopenApplicationRepo.getCodApplication());
				mailService.sendApplicationStatus(mailApplicationCancelOrReject, MailApplicationType.CANCELATION,
						iopenApplication.getEmailAddress());
				// SMA 20160229 start
				String smsMessage = env.getProperty("application.sms.cancellation");
				smsMessage = smsMessage.replace("#customerName", mailApplicationCancelOrReject.getCustomerName());
				smsMessage = smsMessage.replace("#trackingNumber", mailApplicationCancelOrReject.getTrackingNumber());
				smsMessage = smsMessage.replace("#connectionType", mailApplicationCancelOrReject.getConnectionType());

				// SMA 20160303 added the check for getDistrict();
				if (iopenApplication.getDistrict() != null && iopenApplication.getDistrict() != 0) {
					smsMessage = smsMessage.replace("#district",
							env.getProperty("application.message.district.text") + " " + municipio.getNomMunic());
				} else {
					if (iopenApplication.getDistrictDesc() != null

							&& !iopenApplication.getDistrictDesc().trim().isEmpty()) {
						smsMessage = smsMessage.replace("#district",
								env.getProperty("application.message.district.text") + " "
										+ mailApplicationCancelOrReject.getDistrict());
					} else {
						smsMessage = smsMessage.replace("#district", "");
					}
				}
				phoneService.sendMessage(smsMessage, iopenApplicationRepo.getMobileNumber());
				// SMA 20160301
				if (Boolean.valueOf(env.getProperty("laxcon.test"))) {
					mailService.sendLaxxconSMStestMessage(smsMessage, iopenApplication.getEmailAddress());
				}
				// SMA 20160229 end
			} else if (status.equalsIgnoreCase(env.getProperty("application.default.status"))) {
				// pending
				System.out.println("ERROR: employee should not be able to do this");
			} else {
				System.out.println("ERROR: invalid input");
			}
		}

		return applicationList;
	}

	@Override
	public List<ApplicationList> filterApplicationListByDistrict(final List<ApplicationList> applicationList,
			final Long district) {

		/* Filtering using lambda expression */
		final List<ApplicationList> filtered = applicationList.stream()
				.filter(a -> a.getIopenApplication().getDistrict().equals(district)).collect(Collectors.toList());

		/* Filtering from db */

		return filtered;
	}

	@Override
	public List<ApplicationList> filterApplicationListById(final List<ApplicationList> applicationList,
			final String idType, final String idNumber) {

		final List<ApplicationList> filtered = applicationList.stream()
				.filter(a -> a.getIopenApplication().getIdType().equalsIgnoreCase(idType)
						&& a.getIopenApplication().getIdNumber().equalsIgnoreCase(idNumber))
				.collect(Collectors.toList());

		return filtered;
	}

	@Override
	public List<ApplicationList> filterApplicationListByStatus(final List<ApplicationList> applicationList,
			final String status) {

		final List<ApplicationList> filtered = applicationList.stream()
				.filter(a -> a.getApplicationStatus().equalsIgnoreCase(status)).collect(Collectors.toList());

		return filtered;
	}

	@Override
	public List<ApplicationList> clientFilteredApplicationList(ApplicationListFilter applicationListFilter) {
		final String status = applicationListFilter.getApplicationStatus();
		final String stage = applicationListFilter.getCurrentStage();
		final String applicationNumber = applicationListFilter.getApplicationNumber();
		final String trackingNumber = applicationListFilter.getTrackingNumber();
		final boolean complete = applicationListFilter.isComplete();
		final BigDecimal completeNumber = new BigDecimal(1);
		final BigDecimal inCompleteNumber = new BigDecimal(0);

		List<ApplicationList> applicationList = new ArrayList<ApplicationList>();
		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		try {
			List<IopenApplication> iopenApplications = new ArrayList<IopenApplication>();

			IopenApplication iopenApplication = null;
			if (applicationNumber != null && !applicationNumber.isEmpty()
					&& (trackingNumber == null || trackingNumber.isEmpty())) {
				// search by application number
				if (complete) {
					iopenApplication = iopenApplicationRepository
							.findIopenApplicationByExpedienteNumExpAndCodCliAndComplete(applicationNumber,
									new BigDecimal(clientUser.getClienteProfile().getCodCli()), completeNumber);
				} else {
					iopenApplication = iopenApplicationRepository
							.findIopenApplicationByExpedienteNumExpAndCodCliAndComplete(applicationNumber,
									new BigDecimal(clientUser.getClienteProfile().getCodCli()), inCompleteNumber);
				}
				iopenApplications.add(iopenApplication);
			} else if (trackingNumber != null && !trackingNumber.isEmpty()
					&& (applicationNumber == null || applicationNumber.isEmpty())) {
				// search by tracking number only
				if (complete) {
					iopenApplication = iopenApplicationRepository
							.findIopenApplicationByCodApplicationAndClientUsernameAndComplete(
									Long.valueOf(trackingNumber), clientUser.getClienteProfile().getUsername(),
									completeNumber);

				} else {
					iopenApplication = iopenApplicationRepository
							.findIopenApplicationByCodApplicationAndClientUsernameAndComplete(
									Long.valueOf(trackingNumber), clientUser.getClienteProfile().getUsername(),
									inCompleteNumber);

				}
				iopenApplications.add(iopenApplication);
			} else if (status != null && !status.isEmpty()) {
				iopenApplications = clientIopenApplicationsByStatus(clientUser.getClienteProfile(), status, complete,
						iopenApplications);
			} else if (stage != null && !stage.isEmpty()) {
				iopenApplications = iopenApplicationRepository.clientFindByCurrentStageApplicationNumberFilters(stage,
						new BigDecimal(clientUser.getClienteProfile().getCodCli()));
				if (complete) {
					iopenApplications = iopenApplications.stream()
							.filter(filter -> filter != null
							&& filter.getComplete().intValue() == completeNumber.intValue())
							.collect(Collectors.toList());
				} else {
					iopenApplications = iopenApplications.stream()
							.filter(filter -> filter != null
							&& filter.getComplete().intValue() == inCompleteNumber.intValue())
							.collect(Collectors.toList());
				}
			}
			// SMA 20160219 UMESCI-446 start
			if (complete) {
				iopenApplications = clientFilterIopenApplication(iopenApplications, stage, trackingNumber,
						applicationNumber, status, clientUser, completeNumber);
			} else {
				iopenApplications = clientFilterIopenApplication(iopenApplications, stage, trackingNumber,
						applicationNumber, status, clientUser, inCompleteNumber);
			}
			// SMA 20160219 UMESCI-446 end
			applicationList = prepareApplicationList(iopenApplications, complete);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return applicationList;
	}

	@Override
	public Long countFilteredApplicationList(ApplicationListFilter applicationListFilter) {
		final Long district = applicationListFilter.getDistrict();
		final String status = applicationListFilter.getApplicationStatus();
		final String idNumber = applicationListFilter.getIdNumber().toUpperCase();
		final String applicationNumber = applicationListFilter.getApplicationNumber().toUpperCase();
		final String trackingNumber = applicationListFilter.getTrackingNumber();
		long count = 1;
		final EmployeeUser employeeUser = (EmployeeUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if (null == idNumber || idNumber.isEmpty() || idNumber.equals("") || idNumber.equals(" ")) {
			if (trackingNumber == null
					|| trackingNumber.isEmpty() && (applicationNumber == null || applicationNumber.isEmpty())) {
				if (env.getProperty("application.restrict.employee.application.by.unicom").equals("true")) {

					count = iopenApplicationRepository.countDistrictStatusUnicomFilters(district, status, true,
							employeeUser.getEmployeeProfile().getCodUnicom());
					return BigDecimal
							.valueOf(Math
									.ceil(BigDecimal.valueOf(count).doubleValue() / applicationListFilter.getBatch()))
							.longValue();
				} else {
					count = iopenApplicationRepository.countDistrictStatusFilters(district, status, true);

					return BigDecimal
							.valueOf(Math
									.ceil(BigDecimal.valueOf(count).doubleValue() / applicationListFilter.getBatch()))
							.longValue();
				}
			} else {
				return count;
			}
		}
		return count;
	}

	@Override
	public List<ApplicationList> filteredApplicationList(ApplicationListFilter applicationListFilter) {
		final Long district = applicationListFilter.getDistrict();
		final String status = applicationListFilter.getApplicationStatus();
		final String idType = applicationListFilter.getDocumentType();
		final String idNumber = applicationListFilter.getIdNumber().toUpperCase();
		final String applicationNumber = applicationListFilter.getApplicationNumber().toUpperCase();
		final String trackingNumber = applicationListFilter.getTrackingNumber();

		List<ApplicationList> applicationList = new ArrayList<>();
		final EmployeeUser employeeUser = (EmployeeUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		try {
			List<IopenApplication> iopenApplications = new ArrayList<>();

			if (null == idNumber || idNumber.isEmpty() || idNumber.equals("") || idNumber.equals(" ")) {
				if (applicationNumber != null && !applicationNumber.isEmpty()
						&& (trackingNumber == null || trackingNumber.isEmpty())) {
					// search by application number
					final IopenApplication iopenApplication = iopenApplicationRepository
							.findIopenApplicationByExpedienteNumExp(applicationNumber);
					iopenApplications.add(iopenApplication);
				} else if (trackingNumber != null && !trackingNumber.isEmpty()
						&& (applicationNumber == null || applicationNumber.isEmpty())) {
					// search by tracking number only
					final IopenApplication iopenApplication = iopenApplicationRepository
							.findOne(Long.valueOf(trackingNumber));
					iopenApplications.add(iopenApplication);
				} else {
					// search by district
					if (env.getProperty("application.restrict.employee.application.by.unicom").equals("true")) {
						iopenApplications = iopenApplicationRepository.findByDistrictStatusUnicomFilters(district,
								status, true, employeeUser.getEmployeeProfile().getCodUnicom(),
								applicationListFilter.getBatch(), applicationListFilter.getPage());
					} else {
						iopenApplications = iopenApplicationRepository.findByDistrictStatusFilters(district, status,
								true, applicationListFilter.getBatch(), applicationListFilter.getPage());
					}

				}
				iopenApplications = filterIopenApplication(iopenApplications, district, trackingNumber,
						applicationNumber, status, employeeUser);

			} else {
				iopenApplications = iopenApplicationRepository.findByIdTypeAndIdNumber(idType, idNumber);

				iopenApplications = filterIopenApplication(iopenApplications, district, trackingNumber,
						applicationNumber, status, employeeUser);

			}
			applicationList = prepareApplicationList(iopenApplications, true);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return applicationList;
	}

	private List<IopenApplication> filterIopenApplication(List<IopenApplication> iopenApplications, Long district,
			String trackingNumber, String applicationNumber, String status, EmployeeUser employeeUser) {
		final BigDecimal completeNumber = new BigDecimal(1);
		final BigDecimal InCompleteNumber = new BigDecimal(0);
		if (applicationNumber != null && !applicationNumber.isEmpty()) {
			// search by application number
			iopenApplications = iopenApplications.parallelStream()
					.filter(filter -> filter != null && filter.getExpediente() != null
					&& filter.getExpediente().getNumExp().equalsIgnoreCase(applicationNumber))
					.collect(Collectors.toList());
		} else if (trackingNumber != null && !trackingNumber.isEmpty()) {
			// search by tracking number only
			iopenApplications = iopenApplications.parallelStream()
					.filter(filter -> filter != null && filter.getComplete().intValue() == completeNumber.intValue()
					&& String.valueOf(filter.getCodApplication()).equalsIgnoreCase(trackingNumber))
					.collect(Collectors.toList());
		}

		if (district != null && district != 0) {

			// search by district
			if (env.getProperty("application.restrict.employee.application.by.unicom").equals("true")) {
				if (district != 0 && !status.equalsIgnoreCase("ALL")) {
					iopenApplications = iopenApplications.parallelStream().filter(Objects::nonNull)
							.filter(filter -> filter.getExpediente() != null)
							.filter(filter -> filter.getExpediente().getCodUnicomCompet()
									.compareTo(employeeUser.getEmployeeProfile().getCodUnicom()) == 0)
							.collect(Collectors.toList());
				} else {
					iopenApplications = iopenApplications.stream().filter(Objects::nonNull)
							.filter(filter -> filter.getExpediente() != null)
							.filter(filter -> filter.getExpediente().getCodUnicomCompet()
									.compareTo(employeeUser.getEmployeeProfile().getCodUnicom()) == 0)
							.collect(Collectors.toList());
				}
			} else {
				if (district != 0 && !status.equalsIgnoreCase("ALL")) {
					iopenApplications = iopenApplications.parallelStream()
							.filter(filter -> filter != null && filter.getExpediente() != null
							&& filter.getExpediente().getCodUnicomCompet()
							.compareTo(employeeUser.getEmployeeProfile().getCodUnicom()) == 0
							&& filter.getDistrict().equals(district)
							&& filter.getEstStatus().equalsIgnoreCase(status))
							.collect(Collectors.toList());
				}
			}
		} else {
			if (!status.equalsIgnoreCase("ALL") && district != 0) {
				iopenApplications = iopenApplications.parallelStream().filter(filter -> filter != null
						&& filter.getDistrict().equals(district) && filter.getEstStatus().equalsIgnoreCase(status))
						.collect(Collectors.toList());
			}
		}
		return iopenApplications;
	}

	private List<IopenApplication> clientFilterIopenApplication(List<IopenApplication> iopenApplications, String stage,
			String trackingNumber, String applicationNumber, String status, ClientUser clientUser,
			BigDecimal completeNumber) {
		if (applicationNumber != null && !applicationNumber.isEmpty()) {
			// search by application number
			iopenApplications = iopenApplications.parallelStream()
					.filter(filter -> filter != null && filter.getExpediente() != null
					&& filter.getComplete().intValue() == completeNumber.intValue()
					&& filter.getExpediente().getNumExp().equalsIgnoreCase(applicationNumber))
					.collect(Collectors.toList());
		} else if (trackingNumber != null && !trackingNumber.isEmpty()) {
			// search by tracking number only

			iopenApplications = iopenApplications.parallelStream()
					.filter(filter -> filter != null
					&& String.valueOf(filter.getCodApplication()).equalsIgnoreCase(trackingNumber))
					.collect(Collectors.toList());

		}

		if (status != null && !status.isEmpty() && !status.equals("ALL")) {
			iopenApplications = iopenApplications.parallelStream()
					.filter(filter -> filter != null && filter.getEstStatus().equalsIgnoreCase(status))
					.collect(Collectors.toList());
		}

		if (stage != null && !stage.isEmpty() && !stage.equals("ALL")) {
			iopenApplications = iopenApplications.parallelStream().filter(filter -> filter != null
					&& filter.getExpediente() != null && filter.getExpediente().getEstado().equalsIgnoreCase(stage))
					.collect(Collectors.toList());
		}
		// SMA 20160219 UMESCI-446 start
		iopenApplications = iopenApplications.parallelStream()
				.filter(filter -> filter != null && filter.getComplete().intValue() == completeNumber.intValue())
				.collect(Collectors.toList());
		// SMA 20160219 UMESCI-446 end
		return iopenApplications;
	}

	@Override
	public List<ApplicationList> filterByCurrentStageApplicationNumberFilters(final String currentStage,
			final String applicationNumber) {
		List<ApplicationList> applicationList = new ArrayList<ApplicationList>();
		try {
			List<IopenApplication> iopenApplications = new ArrayList<IopenApplication>();
			iopenApplications = iopenApplicationRepository.findByCurrentStageApplicationNumberFilters(currentStage,
					applicationNumber);

			applicationList = prepareApplicationList(iopenApplications, true);

		} catch (final Exception e) {
			e.printStackTrace();
		}
		return applicationList;
	}

	@Override
	public List<Status> findApplicationStatuses() {
		final List<Status> statuses = new ArrayList<Status>();
		final List<Estado> estados = estadoRepository.findEstadoLike("IA");

		Status status = null;
		for (final Estado estado : estados) {
			status = new Status(estado.getEstado(), estado.getDescEst());
			statuses.add(status);
		}

		return statuses;
	}

	@Override
	public List<Codigo> findRejectionMessages() {
		final List<Codigo> codigos = codigoRepository.findCodigoLike("IR");
		return codigos;
	}

	@Override
	public IOpenFile findIopenApplicationDocById(final long codApplication, final String tipDoc)
			throws FileNotFoundException {
		/*
		 * IopenApplicationDoc iopenApplicationDoc =
		 * iopenApplicationDocRepository .findById(new
		 * IopenApplicationDocPK(codApplication, tipDoc));
		 */
		final IOpenFile iOpenFile = fileService.getFile(codApplication, tipDoc);

		return iOpenFile;
	}

	@Override
	public ApplicationList prepareApplicationDetail(final IopenApplication iopenApplication, final boolean complete) {
		final ApplicationList application = new ApplicationList();

		if (complete) {

			final List<ApplicationInvoice> invoices = new ArrayList<ApplicationInvoice>();
			if (iopenApplication.getExpediente() != null) {
				application.setApplicationNumber(iopenApplication.getExpediente().getNumExp());
				application.setApplicationType(
						tipoRepository.findById(iopenApplication.getExpediente().getTipSolic()).getDescTipo());
				application.setApplicationCurrentStage(
						estadoRepository.findById(iopenApplication.getExpediente().getEstado()).getDescEst());
				final List<PresupuestosExped> presupuestosExpeds = presupuestosExpedRepository
						.findPresupuestosExpedByIdNumExp(iopenApplication.getExpediente().getNumExp());
				for (final PresupuestosExped presupuestosExped : presupuestosExpeds) {
					final ApplicationInvoice invoice = new ApplicationInvoice();

					invoice.setInvoiceNumber(" ");
					invoice.setInvoiceAmount(Double.valueOf(presupuestosExped.getCoste().toPlainString()));
					invoice.setInvoiceDate(presupuestosExped.getFActual());
					invoice.setInvoiceType(
							presupuestosExpedRepository.findPresupuestosExpedInvoiceType(presupuestosExped.getTipMov())
							/*
							 * tipoRepository.findById(presupuestosExped.getTipMov()).
							 * getDescTipo()
							 */
							);
					invoice.setInvoiceStatus(estadoRepository.findById(presupuestosExped.getEstado()).getDescEst());

					/*
					 * If invoice is paid. To get from recibos
					 * if(presupuestosExped.getEstado().equalsIgnoreCase("")){
					 * invoice.setInvoiceNumber(""); invoice.setInvoiceDate(new
					 * Date()); }
					 */

					invoices.add(invoice);

				}

			}
			application.setApplicationStatus(estadoRepository.findById(iopenApplication.getEstStatus()).getDescEst());
			// SMA 20160222 UMESC-444 start added trim()
			application.setApplicationComment(
					iopenApplication.getComments() != null ? iopenApplication.getComments().trim() : "");

			application.setApplicationDate(new SimpleDateFormat("dd-MM-yyyy").format(iopenApplication.getFActual()));

			application.setApplicationNextStage(" ");// to find next status

			application.setInvoices(invoices);
		}

		application.setIopenApplication(iopenApplication);

		return application;
	}

	@Override
	public ApplicationStatusInformation prepareApplicationStatusInformation(final IopenApplication iopenApplication,
			final boolean complete) {
		final ApplicationStatusInformation applicationStatusInformation = new ApplicationStatusInformation();
		// SMA 20160219 UMESC-444 start
		if (complete && iopenApplication.getExpediente() != null) {
			applicationStatusInformation.setApplicationNumber(iopenApplication.getExpediente().getNumExp());
			applicationStatusInformation.setApplicationStage(
					estadoRepository.findById(iopenApplication.getExpediente().getEstado()).getDescEst());
			applicationStatusInformation.setApplicationDescription(iopenApplicationStageRepository
					.findOne(iopenApplication.getExpediente().getEstado()).getStageComments());
			applicationStatusInformation.setCodApplication(iopenApplication.getCodApplication());

		}
		// SMA 20160219 UMESC-444 end

		return applicationStatusInformation;
	}

	@Override
	public ApplicationPendingInvoiceInformation prepareApplicationPendingInvoiceInformation(
			final IopenApplication iopenApplication, final boolean complete) {
		final ApplicationPendingInvoiceInformation applicationPendingInvoiceInformation = new ApplicationPendingInvoiceInformation();
		// SMA 20160219 UMESC-444 start
		if (complete && iopenApplication != null && iopenApplication.getExpediente() != null) {

			final List<PresupuestosExped> presupuestosExpeds = presupuestosExpedRepository
					.findPresupuestosExpedByIdNumExpAndEstado(iopenApplication.getExpediente().getNumExp(),
							env.getProperty("application.default.presupestos_exped.estado.value"));

			final List<ApplicationInvoice> invoices = new ArrayList<ApplicationInvoice>();

			for (final PresupuestosExped presupuestosExped : presupuestosExpeds) {
				final ApplicationInvoice invoice = new ApplicationInvoice();

				invoice.setInvoiceNumber(" ");
				invoice.setInvoiceAmount(Double.valueOf(presupuestosExped.getCoste().toPlainString()));
				invoice.setInvoiceDate(presupuestosExped.getFActual());
				invoice.setInvoiceType(
						presupuestosExpedRepository.findPresupuestosExpedInvoiceType(presupuestosExped.getTipMov()));
				invoice.setInvoiceStatus(estadoRepository.findById(presupuestosExped.getEstado()).getDescEst());

				invoices.add(invoice);

			}

			applicationPendingInvoiceInformation.setInvoices(invoices);
		}
		// SMA 20160219 UMESC-444 end
		return applicationPendingInvoiceInformation;
	}

	@Override
	public List<ApplicationList> prepareApplicationList(final List<IopenApplication> iopenApplications,
			final boolean complete) {
		final List<ApplicationList> applicationList = new ArrayList<ApplicationList>();

		if (iopenApplications != null && !iopenApplications.isEmpty()) {
			for (final IopenApplication iopenApplication : iopenApplications) {
				final ApplicationList application = new ApplicationList();

				if (complete) {
					if (iopenApplication.getExpediente() != null) {
						application.setApplicationNumber(iopenApplication.getExpediente().getNumExp());
						application.setApplicationType(
								tipoRepository.findById(iopenApplication.getExpediente().getTipSolic()).getDescTipo());
						application.setApplicationCurrentStage(
								estadoRepository.findById(iopenApplication.getExpediente().getEstado()).getDescEst());
						application.setApplicationComment(iopenApplication.getComments());

					}
					application.setApplicationStatus(
							estadoRepository.findById(iopenApplication.getEstStatus()).getDescEst());
					application.setApplicationDate(
							new SimpleDateFormat("dd-MM-yyyy").format(iopenApplication.getFActual()));

					application.setApplicationNextStage(" "); // to find
					// next
					// status
				}

				application.setIopenApplication(iopenApplication);
				applicationList.add(application);

			}
		}

		return applicationList;
	}

	private List<IopenApplicationDoc> saveIopenApplicationDocs(final ApplicationList applicationList,
			final IopenApplication iopenApplication) throws Exception {
		final List<IopenApplicationDoc> iopenApplicationDocs = new ArrayList<IopenApplicationDoc>();
		// if (iopenApplication.getIopenApplicationDocs() == null) {
		// iopenApplicationDocs = new ArrayList<IopenApplicationDoc>();
		// } else {
		// iopenApplicationDocs = iopenApplication.getIopenApplicationDocs();
		// }

		for (final MultipartFile multipartFile : applicationList.getFiles()) {
			final IopenApplicationDoc iopenApplicationDoc = new IopenApplicationDoc();
			iopenApplicationDoc.setDoc(multipartFile.getBytes());
			iopenApplicationDoc.setDocDesc(multipartFile.getOriginalFilename());
			iopenApplicationDoc.setContentType(multipartFile.getContentType());
			iopenApplicationDoc.setFActual(new Date());
			iopenApplicationDoc.setId(new IopenApplicationDocPK());
			iopenApplicationDoc.getId().setCodApplication(applicationList.getIopenApplication().getCodApplication());
			// iopenApplicationDoc.getId().setTipDoc(multipartFile.getContentType());

			final Random rand = new Random();
			final int n = rand.nextInt(50) + 1;
			iopenApplicationDoc.getId().setTipDoc(String.valueOf(System.currentTimeMillis() + n));

			iopenApplicationDoc.setIopenApplication(applicationList.getIopenApplication());
			iopenApplicationDoc.setUsuario(ApplicationDefault.getDatabaseUser());
			iopenApplicationDoc.setPrograma(ApplicationDefault.getProgram());
			iopenApplicationDoc.setTac("0");
			/* iopenApplicationDocRepository.save(iopenApplicationDoc); */
			fileService.saveFile(iopenApplicationDoc);
			iopenApplicationDocs.add(iopenApplicationDoc);
		}
		// if (iopenApplication.getIopenApplicationDocs() == null
		// || iopenApplication.getIopenApplicationDocs().isEmpty()) {
		// iopenApplication.setIopenApplicationDocs(iopenApplicationDocs);
		// } else {
		// iopenApplication.getIopenApplicationDocs().addAll(iopenApplicationDocs);
		// }
		// return iopenApplication;
		return iopenApplicationDocs;
	}

	private void saveToExpediente(final IopenApplication oldIopenApplication) {
		// SMA 20160219 UMESC-444 start
		if (oldIopenApplication.getExpediente() != null) {
			final Expediente expediente = oldIopenApplication.getExpediente();
			expediente.setEstado(ApplicationDefault.getApplicationExpedienteCancel());
			// entityManager.merge(expediente);
			expedienteRepository.edit(expediente);
		}
		// SMA 20160219 UMESC-444 end
	}

}
