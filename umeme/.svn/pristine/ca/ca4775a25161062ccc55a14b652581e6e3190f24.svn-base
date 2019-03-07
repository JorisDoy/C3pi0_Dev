package com.indra.iopen.service.ims;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.iopen.exception.ObjectNotFound;
import com.indra.iopen.form.Contract;
import com.indra.iopen.form.CustomerProfile;
import com.indra.iopen.form.ims.ComplaintsForm;
import com.indra.iopen.model.ApmedidaAp;
import com.indra.iopen.model.BdgActOfiAux;
import com.indra.iopen.model.Callejero;
import com.indra.iopen.model.Cliente;
import com.indra.iopen.model.ClienteProfile;
import com.indra.iopen.model.DatosAct;
import com.indra.iopen.model.DatosActPK;
import com.indra.iopen.model.DatosRecl;
import com.indra.iopen.model.EstRec;
import com.indra.iopen.model.EstRecPK;
import com.indra.iopen.model.Estado;
import com.indra.iopen.model.Municipio;
import com.indra.iopen.model.Recibo;
import com.indra.iopen.model.Sumcon;
import com.indra.iopen.model.Tipo;
import com.indra.iopen.model.TrabpendRe;
import com.indra.iopen.model.ims.AcoSum;
import com.indra.iopen.model.ims.GiAviso;
import com.indra.iopen.model.ims.GiAvisosInstalacion;
import com.indra.iopen.model.ims.GiAvisosInstalacionPK;
import com.indra.iopen.model.ims.GiAvisosLlamada;
import com.indra.iopen.model.ims.GiCentroLoc;
import com.indra.iopen.model.ims.GiTTipAviso;
import com.indra.iopen.model.ims.SgdAcometida;
import com.indra.iopen.model.ims.SgdInstalacion;
import com.indra.iopen.model.ims.SgdSector;
import com.indra.iopen.model.ims.SgdValor;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.model.security.users.GenericUser;
import com.indra.iopen.pojo.ComplaintDetail;
import com.indra.iopen.pojo.ComplaintFilter;
import com.indra.iopen.pojo.PremiseInformation;
import com.indra.iopen.repositories.model.AcoSumRepository;
import com.indra.iopen.repositories.model.ApmedidaApRepository;
import com.indra.iopen.repositories.model.BdgActOfiAuxRepository;
import com.indra.iopen.repositories.model.CallejeroRepository;
import com.indra.iopen.repositories.model.ClienteRepository;
import com.indra.iopen.repositories.model.DatosActRepository;
import com.indra.iopen.repositories.model.DatosReclRepository;
import com.indra.iopen.repositories.model.DeptoRepository;
import com.indra.iopen.repositories.model.EstRecReposotory;
import com.indra.iopen.repositories.model.LocalidadeRepository;
import com.indra.iopen.repositories.model.MunicipioRepository;
import com.indra.iopen.repositories.model.ReciboRepository;
import com.indra.iopen.repositories.model.SgdInstalacionRepository;
import com.indra.iopen.repositories.model.SumconRepository;
import com.indra.iopen.repositories.model.TipoRepository;
import com.indra.iopen.repositories.model.TrabpendReRepository;
import com.indra.iopen.repositories.model.ims.GiAvisoRepository;
import com.indra.iopen.repositories.model.ims.GiAvisosInstalacionRepository;
import com.indra.iopen.repositories.model.ims.GiAvisosLlamadaRepository;
import com.indra.iopen.repositories.model.ims.GiCentroLocRepository;
import com.indra.iopen.repositories.model.ims.GiOtRepository;
import com.indra.iopen.repositories.model.ims.GiTTipAvisoRepository;
import com.indra.iopen.repositories.model.ims.ProvinciaRepository;
import com.indra.iopen.repositories.model.ims.SgdAcometidaRepository;
import com.indra.iopen.repositories.model.ims.SgdSectorRepository;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.ContractService;
import com.indra.iopen.service.CustomerProfileService;
import com.indra.iopen.util.ApplicationDefault;

@Service
public class ComplaintsServiceImpl implements ComplaintsService {
	@Autowired
	private GiAvisoRepository giAvisoRepository;
	@Autowired
	private Environment env;
	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private LocalidadeRepository localidadeRepository;
	@Autowired
	private DeptoRepository deptoRepository;
	@Autowired
	private ProvinciaRepository provinciaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private CallejeroRepository callejeroRepository;
	@Autowired
	private GiTTipAvisoRepository giTTipAvisoRepository;
	@Autowired
	private AcoSumRepository acoSumRepository;
	@Autowired
	private SgdAcometidaRepository sgdAcometidaRepository;
	@Autowired
	private ApmedidaApRepository apmedidaApRepository;
	@Autowired
	private SumconRepository sumconRepository;
	@Autowired
	private CustomerProfileService customerProfileService;
	@Autowired
	private SgdInstalacionRepository sgdInstalacionRepository;
	@Autowired
	private ContractService contractService;
	@Autowired
	private GiAvisosInstalacionRepository giAvisosInstalacionRepository;
	@Autowired
	private SgdSectorRepository sgdSectorRepository;
	@Autowired
	private GiOtRepository giOtRepository;
	@Autowired
	private GiCentroLocRepository giCentroLocRepository;
	@Autowired
	private TrabpendReRepository trabpendReRepository;
	@Autowired
	private ReciboRepository reciboRepository;
	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private DatosReclRepository datosReclRepository;
	@Autowired
	private EstRecReposotory estRecReposotory;
	@Autowired
	private DatosActRepository datosActRepository;
	@Autowired
	private BdgActOfiAuxRepository bdgActOfiAuxRepository;
	@Autowired
	private GiAvisosLlamadaRepository giAvisosLlamadaRepository;
	@Autowired
	private CommonService commonService;

	private ComplaintFilter complaintFilter;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void registerComplaint(ComplaintsForm complaintsForm, long nroAviso) throws Exception {
		/**
		 * for those maintainers coming after us so sorry we found the table
		 * like this and it could not be changed...Happy debugging
		 */

		//check if a complaint already exists for a meter number or
		// contract number
		// check via meter number
		long nisRad;
		boolean complaintExists = false;
		GiAviso giAvisoResolved = null;
		GiAviso giAviso = null;
		ClientUser clientUser = null;
		SgdInstalacion sgdInstalacion = null;
		final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof GenericUser) {
			clientUser = (ClientUser) principal;
		}
		if (clientUser != null && !new BigDecimal(complaintsForm.getComplaintDetail().getComplaintType())
				.equals(new BigDecimal(env.getProperty("application.sgdvalor.codif.complainttype.assistive.value")))) {
			if (complaintsForm.getComplaintDetail().getMeterNumber() != null
					&& !complaintsForm.getComplaintDetail().getMeterNumber().isEmpty()) {
				final ApmedidaAp apmedidaAp = apmedidaApRepository
						.findApmedidaApByNumApa(complaintsForm.getComplaintDetail().getMeterNumber());
				if (apmedidaAp == null) {
					throw new ObjectNotFound("there is no meter number like that");
				}
				final Sumcon sumcon = sumconRepository.findSumconByNumSum(apmedidaAp.getNumSum().longValue());
				if (sumcon == null) {
					throw new ObjectNotFound("there is no meter number like that");
				}
				nisRad = sumcon.getNisRad();
				giAvisoResolved = giAvisoRepository.findGiAvisoByNisRad(new BigDecimal(nisRad));
				if (giAvisoResolved == null) {
					throw new ObjectNotFound("there is no meter number like that");
				}
				if (giAvisoResolved.getEstAviso().intValue() == Integer
						.valueOf(env.getProperty("application.giaviso.resolved.value"))) {
					complaintExists = true;
				}
			}
			// check via contract number
			if (Long.valueOf(complaintsForm.getComplaintDetail().getContractNumber()) > 0) {
				final List<GiAviso> giAvisos = giAvisoRepository.findGiAvisoByNisRadAndEstAvisoNot(
						new BigDecimal(complaintsForm.getComplaintDetail().getContractNumber()),
						new BigDecimal(env.getProperty("application.giaviso.resolved.value")));
				if (giAvisos != null && !giAvisos.isEmpty()) {
					giAvisoResolved = giAvisos.get(0);
				} else {
					giAvisoResolved = null;
				}
				if (giAvisoResolved == null) {
					System.out.println("there is no unresolved compaint");
				} else {
					if (giAvisoResolved.getEstAviso().intValue() != Integer
							.valueOf(env.getProperty("application.giaviso.resolved.value"))) {
						complaintExists = true;
					}
				}
			}
		}
		//TEST FOR WHEN COMPLAINT EXISTS
		if (!complaintExists) {
			final Date then1900 = new SimpleDateFormat("yyyyMMdd").parse("19000101");
			final Date now = new Date();

			// long nroAviso =
			// giAvisoImpl.getGiAvisoId(env.getProperty("appliation.GiTUltimo.tablename"));
			giAviso = new GiAviso();
			if (clientUser != null && !new BigDecimal(complaintsForm.getComplaintDetail().getComplaintType()).equals(
					new BigDecimal(env.getProperty("application.sgdvalor.codif.complainttype.assistive.value")))) {
				final AcoSum acoSum = acoSumRepository
						.findOne(Long.valueOf(complaintsForm.getComplaintDetail().getContractNumber()));
				if (acoSum == null) {
					System.out.println("batch update not yet run");
					throw new ObjectNotFound("details not yet updated, please try again later");
				}
				final SgdAcometida sgdAcometida = sgdAcometidaRepository
						.findSgdAcometidaByNroAcoSum(acoSum.getNroAcometida());
				// get sgdinstalacion
				sgdInstalacion = sgdInstalacionRepository
						.findSgdInstalacionByIdNroInstalacion(sgdAcometida.getInstalacionOrigen().longValue());

				giAviso.setCodCalle(acoSum.getCodCalle());
				giAviso.setCodLoc(acoSum.getCodLoc());
				giAviso.setCodMunic(acoSum.getCodMunic());
				giAviso.setCodProv(acoSum.getCodProv());
				giAviso.setCodDepto(acoSum.getCodDepto());
				giAviso.setNroOt(new BigDecimal(0));
				giAviso.setEsquina(sgdAcometida.getDescripcion());
				giAviso.setCgvSum(acoSum.getCgvSum());
				final Callejero callejero = callejeroRepository.findOne(acoSum.getCodCalle().longValue());
				giAviso.setNomCalle(callejero.getNomCalle());
				giAviso.setNomProv(provinciaRepository.findOne(acoSum.getCodProv().longValue()).getNomProv());
				giAviso.setNomDepto(deptoRepository.findOne(acoSum.getCodDepto()).getNomDepto());
				giAviso.setNomMunic(municipioRepository.findOne(acoSum.getCodMunic().longValue()).getNomMunic());
				giAviso.setNomLoc(localidadeRepository.findOne(acoSum.getCodLoc().longValue()).getNomLocal());
				giAviso.setNroCentro(sgdAcometida.getNroCentro());
				giAviso.setNroInstalacion(new BigDecimal(sgdAcometida.getId().getCodigo()));
				giAviso.setNroCmd(sgdAcometida.getNroCmd());
				giAviso.setNroMesa(sgdAcometida.getNroMesa());
				giAviso.setRefDir(sgdAcometida.getRefDir());
				giAviso.setTipoVia(callejero.getTipVia());
				giAviso.setNisRad(new BigDecimal(complaintsForm.getComplaintDetail().getContractNumber()));
			} else {
				giAviso.setNisRad(new BigDecimal(0));
				final Municipio municipio = municipioRepository
						.findOne(complaintsForm.getCustomerProfile().getPremiseInformation().getDistrict());
				sgdInstalacion = sgdInstalacionRepository.findSgdInstalacionByIdNroInstalacion(Long.valueOf(
						Long.valueOf(env.getProperty("application.givavisoinstalacion.nroinstalacion.value"))));
				final GiCentroLoc giCentroLoc = giCentroLocRepository.findGiCentroLocByIdCodLoc(
						complaintsForm.getCustomerProfile().getPremiseInformation().getLocality());
				final SgdSector sgdSector = sgdSectorRepository.findOne(giCentroLoc.getId().getNroPuesto());
				giAviso.setCodCalle(
						new BigDecimal(complaintsForm.getCustomerProfile().getPremiseInformation().getStreet()));
				giAviso.setCodLoc(
						new BigDecimal(complaintsForm.getCustomerProfile().getPremiseInformation().getLocality()));
				giAviso.setCodMunic(new BigDecimal(municipio.getCodMunic()));
				giAviso.setCodProv(new BigDecimal(env.getProperty("application.codprov.uganda.value")));
				giAviso.setCodDepto(municipio.getCodDepto());
				giAviso.setNroOt(new BigDecimal(0));
				giAviso.setEsquina(complaintsForm.getCustomerProfile().getPremiseInformation().getLandmark());
				giAviso.setCgvSum(" ");
				final Callejero callejero = callejeroRepository
						.findOne(complaintsForm.getCustomerProfile().getPremiseInformation().getStreet());
				giAviso.setNomCalle(callejero.getNomCalle());
				giAviso.setNomProv(provinciaRepository.findOne(callejero.getCodProv().longValue()).getNomProv());
				giAviso.setNomDepto(deptoRepository.findOne(municipio.getCodDepto()).getNomDepto());
				giAviso.setNomMunic(municipio.getNomMunic());
				giAviso.setNomLoc(localidadeRepository
						.findOne(complaintsForm.getCustomerProfile().getPremiseInformation().getLocality())
						.getNomLocal());
				giAviso.setNroCentro(giCentroLoc.getNroCentro());
				giAviso.setNroInstalacion(
						new BigDecimal(env.getProperty("application.givavisoinstalacion.nroinstalacion.value")));
				giAviso.setNroCmd(sgdSector.getCodCmd());
				giAviso.setNroMesa(new BigDecimal(sgdSector.getCodSector()));
				giAviso.setRefDir(" ");
				giAviso.setTipoVia(callejero.getTipVia());
			}
			giAviso.setNroAviso(nroAviso);
			giAviso.setUsuario(ApplicationDefault.getDatabaseUser());
			giAviso.setFActual(now);
			giAviso.setHActual(now);
			giAviso.setPrograma(ApplicationDefault.getProgram());

			giAviso.setNombre(complaintsForm.getCustomerProfile().getFirstName() + " "
					+ complaintsForm.getCustomerProfile().getMiddleName());
			giAviso.setApe1(complaintsForm.getCustomerProfile().getSurname());
			giAviso.setApe2(complaintsForm.getCustomerProfile().getMiddleName());
			giAviso.setDocId(complaintsForm.getCustomerProfile().getIdNumber());
			giAviso.setTipDoc(complaintsForm.getCustomerProfile().getIdType());
			giAviso.setCoPais(env.getProperty("application.codigos.country.uganda.code"));
			giAviso.setCoAlcance(new BigDecimal(complaintsForm.getComplaintDetail().getScope()));
			giAviso.setTipAviso(new BigDecimal(complaintsForm.getComplaintDetail().getComplaintNature()));
			final GiTTipAviso giTTipAviso = giTTipAvisoRepository.findOne(giAviso.getTipAviso().longValue());
			// put 11 if it is danger 21 otherwise
			if (giTTipAviso.getIndPeligro().intValue() == 1) {
				giAviso.setPrioridad(new BigDecimal(11));
			} else {
				giAviso.setPrioridad(new BigDecimal(21));
			}
			giAviso.setIndPeligro(giTTipAviso.getIndPeligro());
			giAviso.setFAlta(now);
			giAviso.setHAlta(then1900);
			if (complaintsForm.getCustomerProfile().getOfficeNumber() != null) {
				giAviso.setTfnoCli(complaintsForm.getCustomerProfile().getOfficeNumber());
			} else {
				giAviso.setTfnoCli(" ");
			}
			if (complaintsForm.getComplaintDetail().getComments() != null) {
				giAviso.setObsTelegestiones(complaintsForm.getComplaintDetail().getComments());
			} else {
				giAviso.setObsTelegestiones(" ");
			}
			giAviso.setObsCmd(" ");
			giAviso.setIndAyuda(new BigDecimal(0));
			giAviso.setDuplicador(" ");
			giAviso.setNumPuerta(new BigDecimal(9999));
			giAviso.setNroIncidencia(new BigDecimal(0));
			giAviso.setIndImprocedente(new BigDecimal(0));
			giAviso.setIndCliImp(new BigDecimal(0));
			// from call center the one who entered the complaint
			giAviso.setNroTelefonista(" ");
			giAviso.setFechaRes(null);
			giAviso.setHoraRes(then1900);
			giAviso.setEb4005(new BigDecimal(0));
			giAviso.setFechaBatch(then1900);
			// used for shifts (1-4)
			final int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			final int codHorario = hour / 8 + 1;
			giAviso.setCodHorario(new BigDecimal(codHorario));
			giAviso.setIndIncAsoc(new BigDecimal(0));
			giAviso.setNroLlamadas(new BigDecimal(0));
			giAviso.setObsImproc(null);
			giAviso.setIndIncManual(new BigDecimal(0));
			giAviso.setIndCalidad(new BigDecimal(complaintsForm.getComplaintDetail().getComplaintType()));
			giAviso.setClaseAviso(new BigDecimal(complaintsForm.getComplaintDetail().getComplaintType()));
			giAviso.setIndBloqueo(new BigDecimal(0));
			giAviso.setNroIncTrigger(null);
			giAviso.setFResolTrigger(null);
			giAviso.setUsuarioBloqueo(null);
			giAviso.setInstalacionConInt(null);
			giAviso.setFechaProblema(
					new SimpleDateFormat("dd/MM/yyyy").parse(complaintsForm.getComplaintDetail().getDetectionDate()));
			giAviso.setFechaResAnulacion(null);
			giAviso.setIncidenciaAnulacion(null);
			giAviso.setOrdenAgrupacion(null);
			giAviso.setAreaRep(new BigDecimal(0));
			giAviso.setPoblacion(null);
			giAviso.setEstWireless("N");
			giAviso.setIndAviso("M");
			giAviso.setIndSupply(complaintsForm.getComplaintDetail().getPowerOutage());
			giAviso.setEstAviso(new BigDecimal(1));
			giAviso.setNroTelegestiones(new BigDecimal(0));
		} else {
			// change previous calls
			final BigDecimal previousCall = giAvisoResolved.getNroLlamadas();
			giAvisoResolved.setNroLlamadas(previousCall.add(new BigDecimal(1)));
			giAviso = giAvisoResolved;
		}
		giAvisoRepository.save(giAviso);
		if (!complaintExists) {
			final GiAvisosLlamada giAvisosLlamada = prepareGiAvisoIllamada(giAviso);
			giAvisosLlamadaRepository.insertIntoGiAvisosLlamada(giAvisosLlamada);
			if (clientUser != null && !new BigDecimal(complaintsForm.getComplaintDetail().getComplaintType()).equals(
					new BigDecimal(env.getProperty("application.sgdvalor.codif.complainttype.assistive.value")))) {
				// store info to gi_avisos_instalacion
				final SgdInstalacion originalSgdInstalacion = sgdInstalacion;
				for (final int count = sgdInstalacion.getNroInstPadre().intValue(); sgdInstalacion.getNroInstPadre()
						.intValue() >= 0;) {
					final GiAvisosInstalacion giAvisosInstalacion = prepareGiAvisosInstalacion(sgdInstalacion, giAviso,
							originalSgdInstalacion);

					giAvisosInstalacionRepository.save(giAvisosInstalacion);

					sgdInstalacion = sgdInstalacionRepository
							.findSgdInstalacionByIdNroInstalacion(sgdInstalacion.getNroInstPadre().longValue());
					if (count == 0 || sgdInstalacion == null) {
						break;
					}
				}
			} else {
				final GiAvisosInstalacion giAvisosInstalacion = prepareGiAvisosInstalacionAnonymous(giAviso);
				giAvisosInstalacionRepository.save(giAvisosInstalacion);
			}
		}

	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void registerBillComplaint(ComplaintsForm complaintsForm) {
		final TrabpendRe trabpendRe = prepareTrapendRe(complaintsForm);
		trabpendReRepository.save(trabpendRe);
		final Cliente cliente = prepareCliente();
		clienteRepository.save(cliente);
		final DatosRecl datosRecl = prepareDatosRecl(trabpendRe);
		datosReclRepository.save(datosRecl);
		final Recibo recibo = prepareRecibos(trabpendRe);
		reciboRepository.save(recibo);
		final EstRec estrec = prepareEstRec(trabpendRe);
		estRecReposotory.save(estrec);
		final DatosAct datosAct = prepareDatosAct(trabpendRe);
		datosActRepository.save(datosAct);
		final BdgActOfiAux bdgActOfiAux = prepareBdgActOfiAux(trabpendRe);
		bdgActOfiAuxRepository.insertIntoBdgActOfiAux(bdgActOfiAux);// .save(bdgActOfiAux);

	}

	private BdgActOfiAux prepareBdgActOfiAux(TrabpendRe trabpendRe) {
		final BdgActOfiAux bdgActOfiAux = new BdgActOfiAux();
		final Date now = new Date();
		bdgActOfiAux.setUsuario(ApplicationDefault.getDatabaseUser());
		bdgActOfiAux.setPrograma(ApplicationDefault.getProgram());
		bdgActOfiAux.setFActual(now);
		bdgActOfiAux.setFecha(now);
		bdgActOfiAux.setTipActOf(env.getProperty("applicastion.tipos.tipo.registrationofcomplaints.value"));
		bdgActOfiAux.setCodUnicom(trabpendRe.getCodUnicom());
		return bdgActOfiAux;
	}

	private EstRec prepareEstRec(TrabpendRe trabpendRe) {
		final Date now = new Date();
		final EstRec estRec = new EstRec();
		final EstRecPK estRecPK = new EstRecPK();
		estRecPK.setNumRec(trabpendRe.getNumRecRcm().longValue());
		Long secEstRec = estRecReposotory.findMaxSecEstRec(trabpendRe.getNumRecRcm().longValue());
		if (secEstRec == null) {
			secEstRec = 0l;
		}
		estRecPK.setSecEstRec(secEstRec);
		estRec.setId(estRecPK);
		estRec.setUsuario(ApplicationDefault.getDatabaseUser());
		estRec.setFActual(now);
		estRec.setPrograma(ApplicationDefault.getProgram());
		estRec.setEstRec(env.getProperty("application.estados.estado.undercomplaint.value"));
		estRec.setFIncEst(now);
		return estRec;
	}

	private Recibo prepareRecibos(TrabpendRe trabpendRe) {
		// bill
		final Recibo recibo = reciboRepository.findOne(trabpendRe.getNumRecRcm().longValue());
		recibo.setEstAct(env.getProperty("application.estados.estado.undercomplaint.value"));
		recibo.setUsuario(ApplicationDefault.getDatabaseUser());
		recibo.setFActual(new Date());
		recibo.setPrograma(ApplicationDefault.getProgram());
		return recibo;
	}

	private DatosRecl prepareDatosRecl(TrabpendRe trabpendRe) {
		final DatosRecl datosRecl = new DatosRecl();
		datosRecl.setUsuario(ApplicationDefault.getDatabaseUser());
		datosRecl.setFActual(new Date());
		datosRecl.setPrograma(ApplicationDefault.getProgram());
		datosRecl.setNumRe(trabpendRe.getNumRe());
		datosRecl.setNumSum(trabpendRe.getNumSum());
		datosRecl.setNisRad(trabpendRe.getNisRad());
		datosRecl.setNumRec(trabpendRe.getNumRecRcm());
		datosRecl.setEstRec(env.getProperty("application.estados.estado.undercomplaint.value"));
		return datosRecl;
	}

	private DatosAct prepareDatosAct(TrabpendRe trabpendRe) {
		final Date now = new Date();
		final DatosAct datosAct = new DatosAct();
		final DatosActPK datosActPK = new DatosActPK();
		datosActPK.setNumAct(0);
		datosActPK.setNumRe(trabpendRe.getNumRe());
		datosAct.setId(datosActPK);
		datosAct.setUsuario(ApplicationDefault.getDatabaseUser());
		datosAct.setFActual(now);
		datosAct.setFAct(now);
		datosAct.setPrograma(ApplicationDefault.getProgram());
		datosAct.setTrabpendRe(trabpendRe);
		final Tipo tipAct = tipoRepository.findById(env.getProperty("application.tipos.tipo.complaintscreation.value"));
		datosAct.setTipAct(tipAct.getTipo());
		datosAct.setDescAct(tipAct.getDescTipo());

		return datosAct;
	}

	private Cliente prepareCliente() {
		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		final long codCli = clientUser.getClienteProfile().getCodCli();
		final Cliente cliente = clienteRepository.findById(codCli);
		cliente.setFActual(new Date());
		final BigDecimal nrh = cliente.getNrh();
		cliente.setNrh(nrh.add(new BigDecimal(1)));
		final BigDecimal nrhPen = cliente.getNrhPen();
		cliente.setNrhPen(nrhPen.add(new BigDecimal(1)));
		cliente.setUsuario(ApplicationDefault.getDatabaseUser());
		cliente.setPrograma(ApplicationDefault.getProgram());
		return cliente;
	}

	private TrabpendRe prepareTrapendRe(ComplaintsForm complaintsForm) {
		// bill
		final Recibo recibo = reciboRepository.findOne(complaintsForm.getComplaintDetail().getBillNumber());
		// contract
		final Sumcon sumcon = sumconRepository.findOne(Long.valueOf(complaintsForm.getComplaintDetail().getContractNumber()));
		final Date now = new Date();
		final Long numRe = trabpendReRepository.getNextIdNumRe();
		final TrabpendRe trabpendRe = new TrabpendRe();
		trabpendRe.setUsuario(ApplicationDefault.getDatabaseUser());
		trabpendRe.setFActual(now);
		trabpendRe.setPrograma(ApplicationDefault.getProgram());
		trabpendRe.setNumRe(numRe);
		trabpendRe.setNisRad(new BigDecimal(sumcon.getNisRad()));
		trabpendRe.setSecNis(recibo.getSecNis());
		trabpendRe.setNumSum(sumcon.getNumSum());
		trabpendRe.setCodUnicom(recibo.getCodUnicom());
		trabpendRe.setFIre(now);
		trabpendRe.setNumOs(new BigDecimal(0));
		trabpendRe.setTipRcm(String.valueOf(complaintsForm.getComplaintDetail().getComplaintType()));
		trabpendRe.setCoMedRcm(env.getProperty("application.codigos.codigo.source.internet.value"));
		trabpendRe.setMotRcm(complaintsForm.getComplaintDetail().getComments());
		trabpendRe.setEstRcm(env.getProperty("application.estados.estado.pending.value"));
		trabpendRe.setNumRecRcm(new BigDecimal(complaintsForm.getComplaintDetail().getBillNumber()));
		trabpendRe.setNumActGen(new BigDecimal(0));
		trabpendRe.setFUce(now);
		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		final long codCli = clientUser.getClienteProfile().getCodCli();
		trabpendRe.setCodCli(new BigDecimal(codCli));
		trabpendRe.setPotFact(new BigDecimal(0));
		trabpendRe.setIndApLvdo(new BigDecimal(0));

		return trabpendRe;
	}

	@Override
	public List<ComplaintsForm> getBillComplaints(ComplaintFilter complaintFilter) {
		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		int page = complaintFilter.getPage();
		if (page > 0) {
			page -= 1;
			// complaintFilter.setPage(page - 1);
		}
		final int batch = complaintFilter.getBatch();
		if (batch == 0) {
			complaintFilter.setBatch(Integer.valueOf(env.getProperty("application.default.batch.size")));
		}
		final List<ComplaintsForm> complaintDetails = new ArrayList<>();
		final ClienteProfile clientProfile = clientUser.getClienteProfile();
		if (clientProfile != null && clientProfile.getFActual() != null) {
			final long codCli = clientProfile.getCodCli();
			List<Sumcon> sumcons = new ArrayList<>();
			final List<Estado> estados = commonService.getEstados("ZQ");
			final Map<String, String> estadosMap = estados.parallelStream().filter((filter) -> filter != null)
					.collect(Collectors.toMap(Estado::getEstado, Estado::getDescEst));
			final List<Tipo> tipos = commonService.getTipos("ZO");
			final Map<String, String> tiposMap = tipos.parallelStream()
					.collect(Collectors.toMap(Tipo::getTipo, Tipo::getDescTipo));
			List<TrabpendRe> trabpendRes = new ArrayList<>();
			final List<TrabpendRe> trabpendResAll = new ArrayList<>();
			long totalPageCount = 0;
			final List<BigDecimal> nisRads = new ArrayList<>();
			if (complaintFilter.getContractNumber() == null || complaintFilter.getContractNumber() == 0) {
				sumcons = sumconRepository.findSumconByCodCliOrderByNisRadAsc(new BigDecimal(codCli));

				nisRads.addAll(sumcons.parallelStream().filter((filter) -> filter != null)
						.map((map) -> new BigDecimal(map.getNisRad())).collect(Collectors.toList()));
				if (complaintFilter.getComplaintType() != null && !complaintFilter.getComplaintType().isEmpty()) {
					final List<TrabpendRe> resAlls = trabpendReRepository.findTrabpendReByNisRadInAndCodCliAndTipRcm(nisRads,
							new BigDecimal(codCli), complaintFilter.getComplaintType(),
							new PageRequest(page, complaintFilter.getBatch(), Direction.DESC, "fActual"));
					long pages = 0;
					final long currentPages = complaintFilter.getNumberOfPages();

					pages += trabpendReRepository.findCountTrabpendReByNisRadInAndCodCliAndTipRcm(nisRads,
							new BigDecimal(codCli), complaintFilter.getComplaintType());
					complaintFilter.setNumberOfPages((int) (currentPages + pages));
					if (resAlls != null) {
						trabpendResAll.addAll(resAlls);

					}
				} else {
					final List<TrabpendRe> resAlls = trabpendReRepository.findTrabpendReByNisRadInAndCodCli(nisRads,
							new BigDecimal(codCli),
							new PageRequest(page, complaintFilter.getBatch(), Direction.DESC, "fActual"));
					// long pages = 0;
					// long currentPages = complaintFilter.getNumberOfPages();
					totalPageCount += trabpendReRepository.findCountTrabpendReByNisRadInAndCodCli(nisRads,
							new BigDecimal(codCli));
					// complaintFilter.setNumberOfPages((int) (currentPages +
					// pages));
					if (resAlls != null) {
						trabpendResAll.addAll(resAlls);
					}
				}

				trabpendRes = trabpendResAll;
			} else {
				nisRads.add(new BigDecimal(complaintFilter.getContractNumber()));
				if (complaintFilter.getComplaintType() != null) {

					final List<TrabpendRe> resAlls = trabpendReRepository.findTrabpendReByNisRadInAndCodCliAndTipRcm(nisRads,
							new BigDecimal(codCli), complaintFilter.getComplaintType(), new PageRequest(
									complaintFilter.getPage(), complaintFilter.getBatch(), Direction.DESC, "fActual"));
					totalPageCount += trabpendReRepository.findCountTrabpendReByNisRadInAndCodCliAndTipRcm(nisRads,
							new BigDecimal(codCli), complaintFilter.getComplaintType());

					if (resAlls != null) {
						trabpendResAll.addAll(resAlls);
					}
				} else {

					final List<TrabpendRe> resAlls = trabpendReRepository.findTrabpendReByNisRadInAndCodCli(nisRads,
							new BigDecimal(codCli), new PageRequest(complaintFilter.getPage(),
									complaintFilter.getBatch(), Direction.DESC, "fActual"));

					totalPageCount += trabpendReRepository.findCountTrabpendReByNisRadInAndCodCli(nisRads,
							new BigDecimal(codCli));
					if (resAlls != null) {
						trabpendResAll.addAll(resAlls);
					}
				}
				trabpendRes = trabpendResAll;
			}

			if (trabpendRes != null && !trabpendRes.isEmpty()) {
				trabpendRes.parallelStream().filter((filter) -> filter != null).forEach((trabpendRe) -> {
					final ComplaintDetail complaintDetail = new ComplaintDetail();
					complaintDetail.setBillNumber(trabpendRe.getNumRecRcm().longValue());
					complaintDetail.setComments(trabpendRe.getMotRcm());
					complaintDetail.setComplaintType(String.valueOf(trabpendRe.getTipRcm()));
					complaintDetail.setComplaintTypeDescription(tiposMap.get(trabpendRe.getTipRcm()));
					complaintDetail.setContractNumber(String.valueOf(trabpendRe.getNisRad().longValue()));
					complaintDetail.setStatus(estadosMap.get(trabpendRe.getEstRcm()));
					complaintDetail
					.setDetectionDate(new SimpleDateFormat("dd/MM/yyyy").format(trabpendRe.getFActual()));
					complaintDetail.setComplaintSource(
							Integer.valueOf(env.getProperty("application.complaint.source.bill.value")));
					complaintDetail.setComplaintNumber(trabpendRe.getNumRe());
					final ComplaintsForm complaintsForm = new ComplaintsForm();
					complaintsForm.setComplaintDetail(complaintDetail);
					complaintDetails.add(complaintsForm);
				});
			}
			if (complaintFilter.getNumberOfPages() == 0) {
				complaintFilter
				.setNumberOfPages((int) Math.ceil((double) (int) totalPageCount / complaintFilter.getBatch()));
			}
			this.complaintFilter = complaintFilter;
		}
		return complaintDetails;
	}

	@Override
	public ComplaintsForm getBillComplaint(Long numRe, ClientUser clientUser) throws Exception {
		final List<Estado> estados = commonService.getEstados("ZQ");
		final Map<String, String> estadosMap = estados.parallelStream().filter((filter) -> filter != null)
				.collect(Collectors.toMap(Estado::getEstado, Estado::getDescEst));
		final List<Tipo> tipos = commonService.getTipos("ZO");
		final Map<String, String> tiposMap = tipos.parallelStream()
				.collect(Collectors.toMap(Tipo::getTipo, Tipo::getDescTipo));
		final TrabpendRe trabpendRe = trabpendReRepository.findOne(numRe);
		final ComplaintDetail complaintDetail = new ComplaintDetail();
		if (trabpendRe == null) {
			System.out.println("Object not found");
			return new ComplaintsForm();
		}
		complaintDetail.setBillNumber(trabpendRe.getNumRecRcm().longValue());
		complaintDetail.setComments(trabpendRe.getMotRcm());
		complaintDetail.setComplaintType(String.valueOf(trabpendRe.getTipRcm()));
		complaintDetail.setComplaintTypeDescription(tiposMap.get(trabpendRe.getTipRcm()));
		complaintDetail.setContractNumber(String.valueOf(trabpendRe.getNisRad().longValue()));
		complaintDetail.setStatus(estadosMap.get(trabpendRe.getEstRcm()));
		complaintDetail.setDetectionDate(new SimpleDateFormat("dd/MM/yyyy").format(trabpendRe.getFActual()));
		complaintDetail.setComplaintSource(Integer.valueOf(env.getProperty("application.complaint.source.bill.value")));
		complaintDetail.setComplaintNumber(trabpendRe.getNumRe());
		final ComplaintsForm complaintsForm = new ComplaintsForm();
		complaintsForm.setComplaintDetail(complaintDetail);
		return complaintsForm;
	}

	private GiAvisosLlamada prepareGiAvisoIllamada(GiAviso giAviso) {
		final GiAvisosLlamada giAvisosLlamada = new GiAvisosLlamada();
		giAvisosLlamada.setComentario(" ");
		giAvisosLlamada.setFLlamada(giAviso.getFActual());
		giAvisosLlamada.setIndAviso(" ");
		giAvisosLlamada.setNomOperador(ApplicationDefault.getDatabaseUser());
		giAvisosLlamada.setNroAviso(new BigDecimal(giAviso.getNroAviso()));
		return giAvisosLlamada;
	}

	private GiAvisosInstalacion prepareGiAvisosInstalacion(SgdInstalacion sgdInstalacion, GiAviso giAviso,
			SgdInstalacion originalSgdInstalacion) {
		// List<GiAvisosInstalacion> giAvisosInstalacions = new ArrayList<>();
		GiAvisosInstalacion giAvisosInstalacion = null;
		GiAvisosInstalacionPK giAvisosInstalacionPK = null;
		final SgdSector sgdSector = sgdSectorRepository.findOne(originalSgdInstalacion.getNroMesa().longValue());
		final BigDecimal nroCmd = originalSgdInstalacion.getNroCmd();
		final BigDecimal nroMesa = originalSgdInstalacion.getNroMesa();
		// do {
		giAvisosInstalacion = new GiAvisosInstalacion();
		giAvisosInstalacionPK = new GiAvisosInstalacionPK();
		final Date now = new Date();
		giAvisosInstalacion.setFActual(now);
		giAvisosInstalacion.setUsuario(ApplicationDefault.getDatabaseUser());
		giAvisosInstalacion.setPrograma(ApplicationDefault.getProgram());
		giAvisosInstalacion.setTipoInstalacion(sgdInstalacion.getTipoInstalacion());
		giAvisosInstalacionPK.setNroAviso(giAviso.getNroAviso());
		giAvisosInstalacionPK.setNroInstalacion(sgdInstalacion.getId().getNroInstalacion());
		giAvisosInstalacion.setId(giAvisosInstalacionPK);
		giAvisosInstalacion.setNroInstPadre(sgdInstalacion.getNroInstPadre());
		giAvisosInstalacion.setEstAviso(new BigDecimal(0));
		giAvisosInstalacion.setTipoAviso(giAviso.getTipAviso());

		giAvisosInstalacion.setNroZona(sgdSector.getCodZona());
		giAvisosInstalacion.setNroCmd(nroCmd);
		giAvisosInstalacion.setNroSector(nroMesa);
		giAvisosInstalacion.setFAlta(now);
		giAvisosInstalacion.setIndRed(new BigDecimal(env.getProperty("application.givavisoinstalacion.indred.value")));
		giAvisosInstalacion.setFase(env.getProperty("application.givavisoinstalacion.fase.value"));
		giAvisosInstalacion.setClaseAviso(giAviso.getClaseAviso());
		giAvisosInstalacion.setNomInstalacion(sgdInstalacion.getNomInstalacion());
		giAvisosInstalacion.setIndIncidencia(giAviso.getIndAyuda());
		Long nroOt = giOtRepository.findMinGiOtByEstOtAndNroIncidenciaAndNroInstalacion(
				new BigDecimal(env.getProperty("application.giot.estot.value")),
				new BigDecimal(env.getProperty("application.giot.nroincidencia.value")), giAviso.getNroInstalacion());
		if (nroOt == null) {
			nroOt = Long.valueOf(0);
		}
		giAvisosInstalacion.setNroOt(new BigDecimal(nroOt));
		giAvisosInstalacion.setIndOtrasSmt(null);
		giAvisosInstalacion.setInstalacionConInt(new BigDecimal(0));
		giAvisosInstalacion.setTipoCt(sgdInstalacion.getTipoCt());
		giAvisosInstalacion.setTension(sgdInstalacion.getTension());
		giAvisosInstalacion.setAvisoAt(new BigDecimal(0));
		// giAvisosInstalacions.add(giAvisosInstalacion);
		// sgdInstalacion = sgdInstalacionRepository
		// .findSgdInstalacionByIdNroInstalacion(sgdInstalacion.getNroInstPadre().longValue());
		// } while (!sgdInstalacion.getNroInstPadre().equals(new
		// BigDecimal(0)));
		return giAvisosInstalacion;
	}

	private GiAvisosInstalacion prepareGiAvisosInstalacionAnonymous(GiAviso giAviso) {
		final SgdInstalacion sgdInstalacion = sgdInstalacionRepository.findSgdInstalacionByIdNroInstalacion(
				Long.valueOf(Long.valueOf(env.getProperty("application.givavisoinstalacion.nroinstalacion.value"))));
		final Date now = new Date();
		final GiAvisosInstalacion giAvisosInstalacion = new GiAvisosInstalacion();
		giAvisosInstalacion.setFActual(now);
		giAvisosInstalacion.setUsuario(ApplicationDefault.getDatabaseUser());
		giAvisosInstalacion.setPrograma(ApplicationDefault.getProgram());
		giAvisosInstalacion.setTipoInstalacion(new BigDecimal(0));
		final GiAvisosInstalacionPK giAvisosInstalacionPK = new GiAvisosInstalacionPK();
		giAvisosInstalacionPK.setNroAviso(giAviso.getNroAviso());
		giAvisosInstalacionPK.setNroInstalacion(
				Long.valueOf(env.getProperty("application.givavisoinstalacion.nroinstalacion.value")));
		giAvisosInstalacion.setId(giAvisosInstalacionPK);
		giAvisosInstalacion.setNroInstPadre(new BigDecimal(0));
		giAvisosInstalacion.setEstAviso(new BigDecimal(1));
		giAvisosInstalacion.setTipoAviso(new BigDecimal(1));
		final GiCentroLoc giCentroLoc = giCentroLocRepository.findGiCentroLocByIdCodLoc(giAviso.getCodLoc().longValue());
		final SgdSector sgdSector = sgdSectorRepository.findOne(giCentroLoc.getId().getNroPuesto());
		giAvisosInstalacion.setNroZona(sgdSector.getCodZona());
		giAvisosInstalacion.setNroCmd(sgdInstalacion.getNroCmd());
		giAvisosInstalacion.setNroSector(sgdInstalacion.getNroMesa());
		giAvisosInstalacion.setFAlta(now);
		giAvisosInstalacion.setIndRed(new BigDecimal(env.getProperty("application.givavisoinstalacion.indred.value")));
		giAvisosInstalacion.setFase(env.getProperty("application.givavisoinstalacion.fase.value"));
		giAvisosInstalacion.setClaseAviso(giAviso.getClaseAviso());
		giAvisosInstalacion
		.setNomInstalacion(env.getProperty("application.giavisosinstalacion.assistance.nominstalacion.value"));
		giAvisosInstalacion.setIndIncidencia(new BigDecimal(0));
		Long nroOt = giOtRepository.findMinGiOtByEstOtAndNroIncidenciaAndNroInstalacion(
				new BigDecimal(env.getProperty("application.giot.estot.value")),
				new BigDecimal(env.getProperty("application.giot.nroincidencia.value")), giAviso.getNroInstalacion());
		if (nroOt == null) {
			nroOt = Long.valueOf(0);
		}
		giAvisosInstalacion.setNroOt(new BigDecimal(nroOt));
		giAvisosInstalacion.setIndOtrasSmt(null);
		giAvisosInstalacion.setInstalacionConInt(new BigDecimal(0));
		giAvisosInstalacion.setTipoCt(sgdInstalacion.getTipoCt());
		giAvisosInstalacion.setTension(sgdInstalacion.getTension());
		giAvisosInstalacion.setAvisoAt(new BigDecimal(0));
		return giAvisosInstalacion;

	}

	@Override
	public List<ComplaintsForm> getComplaints(ComplaintFilter complaintFilter, ClientUser clientUser) throws Exception {
		final long codCli = clientUser.getClienteProfile().getCodCli();
		final List<ComplaintsForm> complaintsForms = new ArrayList<>();
		final List<GiAviso> giAvisos = new ArrayList<>();
		int page = complaintFilter.getPage();
		if (page > 0) {
			page -= 1;
			// complaintFilter.setPage(page - 1);
		}
		final int batch = complaintFilter.getBatch();
		if (batch == 0) {
			complaintFilter.setBatch(Integer.valueOf(env.getProperty("application.default.batch.size")));
		}
		long totalPages = 0;
		final List<SgdValor> sgdValors = commonService
				.getSgdValors(env.getProperty("application.sgdvalor.codif.complaint.status.value"));
		final Map<BigDecimal, String> sgdValorsMap = sgdValors.parallelStream().filter((filter) -> filter != null)
				.collect(Collectors.toMap(SgdValor::getCodigo, SgdValor::getDescripcion));
		final List<SgdValor> sgdValorComplaintTypes = commonService.getComplaintTypes();
		final Map<BigDecimal, String> sgdValorComplaintTypesMap = sgdValorComplaintTypes.parallelStream()
				.filter((filter) -> filter != null)
				.collect(Collectors.toMap(SgdValor::getCodigo, SgdValor::getDescripcion));
		final List<BigDecimal> nisRads = new ArrayList<>();
		if (complaintFilter.getContractNumber() != null && complaintFilter.getContractNumber() > 0) {

			nisRads.add(new BigDecimal(complaintFilter.getContractNumber()));
			if (complaintFilter.getComplaintType() != null) {
				final List<GiAviso> giAvisosList = giAvisoRepository.findGiAvisoByIndCalidadAndNisRadInAndEstAvisoNot(
						new BigDecimal(complaintFilter.getComplaintType()), nisRads,
						new BigDecimal(env.getProperty("application.giaviso.resolved.value")),
						new PageRequest(page, complaintFilter.getBatch(), Direction.DESC, "nroAviso"));
				// long pages = 0;
				// long currentPages = complaintFilter.getNumberOfPages();
				totalPages += giAvisoRepository.findCountGiAvisoByIndCalidadAndNisRadInAndEstAvisoNot(
						new BigDecimal(complaintFilter.getComplaintType()), nisRads,
						new BigDecimal(env.getProperty("application.giaviso.resolved.value")));
				// complaintFilter.setNumberOfPages((int) (currentPages +
				// pages));
				if (giAvisosList != null) {
					giAvisos.addAll(giAvisosList);
				}
			} else {
				final List<GiAviso> giAvisosList = giAvisoRepository.findGiAvisoByNisRadInAndEstAvisoNot(nisRads,
						new BigDecimal(env.getProperty("application.giaviso.resolved.value")),
						new PageRequest(page, complaintFilter.getBatch(), Direction.DESC, "nroAviso"));
				// long pages = 0;
				// long currentPages = complaintFilter.getNumberOfPages();
				totalPages += giAvisoRepository.findCountGiAvisoByNisRadInAndEstAvisoNot(nisRads,
						new BigDecimal(env.getProperty("application.giaviso.resolved.value")));
				// complaintFilter.setNumberOfPages((int) (currentPages +
				// pages));
				if (giAvisosList != null) {
					giAvisos.addAll(giAvisosList);
				}
			}

			if (giAvisos != null && !giAvisos.isEmpty()) {

				giAvisos.parallelStream().filter((filter) -> filter != null).forEach((giAviso) -> {

					final ComplaintDetail complaintDetail = new ComplaintDetail();

					complaintDetail.setComplaintTypeDescription(sgdValorComplaintTypesMap.get(giAviso.getClaseAviso()));
					if (giAviso.getObsTelegestiones() != null) {
						complaintDetail.setComments(giAviso.getObsTelegestiones());
					} else {
						complaintDetail.setComments(" ");
					}
					complaintDetail.setComplaintNumber(giAviso.getNroAviso());
					complaintDetail.setComplaintType(String.valueOf(giAviso.getClaseAviso()));
					if (giAviso.getFechaProblema() != null) {
						complaintDetail.setDetectionDate(
								new SimpleDateFormat("dd/MM/yyyy").format(giAviso.getFechaProblema()));
					} else {
						complaintDetail.setDetectionDate(null);
					}
					complaintDetail.setStatus(sgdValorsMap.get(giAviso.getEstAviso()));
					complaintDetail.setComplaintNature(giAviso.getTipAviso().longValue());
					complaintDetail.setPowerOutage(giAviso.getIndSupply());
					complaintDetail.setComplaintNumber(giAviso.getNroAviso());
					complaintDetail.setPreviousCalls(giAviso.getNroLlamadas());
					complaintDetail.setComplaintSource(
							Integer.valueOf(env.getProperty("application.complaint.source.poweroutage.value")));
					final ComplaintsForm complaintsForm = new ComplaintsForm();
					complaintsForm.setComplaintDetail(complaintDetail);
					complaintsForms.add(complaintsForm);

				});

			}

		} else {
			nisRads.addAll(
					contractService.getClientContracts(codCli).parallelStream().filter((filter) -> filter != null)
					.map((map) -> new BigDecimal(map.getContractNumber())).collect(Collectors.toList()));
			if (complaintFilter.getComplaintType() != null && !complaintFilter.getComplaintType().isEmpty()) {
				giAvisos.addAll(giAvisoRepository.findGiAvisoByIndCalidadAndNisRadInAndEstAvisoNot(
						new BigDecimal(complaintFilter.getComplaintType()), nisRads,
						new BigDecimal(env.getProperty("application.giaviso.resolved.value")),
						new PageRequest(page, complaintFilter.getBatch(), Direction.DESC, "nroAviso")));
				totalPages += giAvisoRepository.findCountGiAvisoByIndCalidadAndNisRadInAndEstAvisoNot(
						new BigDecimal(complaintFilter.getComplaintType()), nisRads,
						new BigDecimal(env.getProperty("application.giaviso.resolved.value")));
			} else {
				giAvisos.addAll(giAvisoRepository.findGiAvisoByNisRadInAndEstAvisoNot(nisRads,
						new BigDecimal(env.getProperty("application.giaviso.resolved.value")),
						new PageRequest(page, complaintFilter.getBatch(), Direction.DESC, "nroAviso")));
				totalPages += giAvisoRepository.findCountGiAvisoByNisRadInAndEstAvisoNot(nisRads,
						new BigDecimal(env.getProperty("application.giaviso.resolved.value")));
			}

			if (giAvisos != null && !giAvisos.isEmpty()) {
				giAvisos.parallelStream().filter((filter) -> filter != null).forEach((giAviso) -> {

					final ComplaintDetail complaintDetail = new ComplaintDetail();
					if (giAviso.getObsTelegestiones() != null) {
						complaintDetail.setComments(giAviso.getObsTelegestiones());
					} else {
						complaintDetail.setComments(" ");
					}
					complaintDetail.setComplaintNumber(giAviso.getNroAviso());
					complaintDetail.setComplaintType(String.valueOf(giAviso.getClaseAviso()));
					if (giAviso.getFechaProblema() != null) {
						complaintDetail.setDetectionDate(
								new SimpleDateFormat("dd/MM/yyyy").format(giAviso.getFechaProblema()));
					} else {
						complaintDetail.setDetectionDate(null);
					}
					complaintDetail.setStatus(sgdValorsMap.get(giAviso.getEstAviso()));
					complaintDetail.setComplaintNature(giAviso.getTipAviso().longValue());
					complaintDetail.setComplaintTypeDescription(sgdValorComplaintTypesMap.get(giAviso.getClaseAviso()));
					complaintDetail.setPowerOutage(giAviso.getIndSupply());
					complaintDetail.setComplaintNumber(giAviso.getNroAviso());
					complaintDetail.setComplaintSource(
							Integer.valueOf(env.getProperty("application.complaint.source.poweroutage.value")));
					complaintDetail.setPreviousCalls(giAviso.getNroLlamadas());
					final ComplaintsForm complaintsForm = new ComplaintsForm();
					complaintsForm.setComplaintDetail(complaintDetail);
					complaintsForms.add(complaintsForm);

				});

			}

		}
		if (complaintFilter.getNumberOfPages() == 0) {
			complaintFilter.setNumberOfPages((int) Math.ceil((double) (int) totalPages / complaintFilter.getBatch()));
		}
		this.complaintFilter = complaintFilter;
		return complaintsForms;
	}

	@Override
	public ComplaintFilter getComplaintFilter() {
		return complaintFilter;
	}

	@Override
	public ComplaintsForm getComplaint(Long nroAviso, ClientUser clientUser) throws Exception {
		final GiAviso giAviso = giAvisoRepository.findOne(nroAviso);
		if (giAviso == null) {
			System.out.println("Object not found");
			return new ComplaintsForm();
		}
		final ComplaintDetail complaintDetail = new ComplaintDetail();
		if (giAviso.getObsTelegestiones() != null) {
			complaintDetail.setComments(giAviso.getObsTelegestiones());
		} else {

			complaintDetail.setComments(" ");
		}
		if (giAviso.getFechaProblema() != null) {
			complaintDetail.setDetectionDate(new SimpleDateFormat("dd/MM/yyyy").format(giAviso.getFechaProblema()));
		} else {
			complaintDetail.setDetectionDate(" ");
		}
		final List<SgdValor> sgdValors = commonService
				.getSgdValors(env.getProperty("application.sgdvalor.codif.complaint.status.value"));
		final Map<BigDecimal, String> sgdValorsMap = sgdValors.parallelStream().filter((filter) -> filter != null)
				.collect(Collectors.toMap(SgdValor::getCodigo, SgdValor::getDescripcion));
		final List<SgdValor> sgdValorComplaintTypes = commonService.getComplaintTypes();
		final Map<BigDecimal, String> sgdValorComplaintTypesMap = sgdValorComplaintTypes.parallelStream()
				.filter((filter) -> filter != null)
				.collect(Collectors.toMap(SgdValor::getCodigo, SgdValor::getDescripcion));

		complaintDetail.setComplaintTypeDescription(sgdValorComplaintTypesMap.get(giAviso.getClaseAviso()));
		complaintDetail.setComplaintNumber(giAviso.getNroAviso());
		complaintDetail.setContractNumber(String.valueOf(giAviso.getNisRad().longValue()));
		complaintDetail.setComplaintType(String.valueOf(giAviso.getClaseAviso().longValue()));
		complaintDetail.setStatus(sgdValorsMap.get(giAviso.getEstAviso()));
		complaintDetail.setComplaintNature(giAviso.getTipAviso().longValue());
		complaintDetail.setPowerOutage(giAviso.getIndSupply());
		complaintDetail.setPreviousCalls(giAviso.getNroLlamadas());
		final ComplaintsForm complaintsForm = new ComplaintsForm();
		complaintsForm.setComplaintDetail(complaintDetail);
		final CustomerProfile customerProfile = customerProfileService.getCustomerProfile(clientUser);
		final AcoSum acoSum = acoSumRepository.findOne(Long.valueOf(complaintsForm.getComplaintDetail().getContractNumber()));
		final PremiseInformation premiseInformation = new PremiseInformation();
		premiseInformation.setDistrict(acoSum.getCodMunic().longValue());
		premiseInformation.setProvince(acoSum.getCodProv().longValue());
		premiseInformation.setStreet(acoSum.getCodCalle().longValue());
		premiseInformation.setVillage(acoSum.getCodMunic().longValue());
		customerProfile.setPremiseInformation(premiseInformation);
		complaintsForm.setCustomerProfile(customerProfile);

		return complaintsForm;
	}

	@Override
	public List<String> getContracts() {
		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		// client contracts
		final List<Contract> contracts = contractService.getClientContracts(clientUser.getClienteProfile().getCodCli());
		List<String> contractList = new ArrayList<>();
		contractList = contracts.parallelStream().map(Contract::getContractNumber).collect(Collectors.toList());
		return contractList;
	}

	@Override
	public List<ComplaintsForm> getComplaintByContractNumber(Long contractNumber, ClientUser clientUser)
			throws Exception {
		List<GiAviso> giAvisos = null;
		// check via contract number
		giAvisos = giAvisoRepository.findGiAvisoByNisRadAndEstAvisoNot(new BigDecimal(contractNumber),
				new BigDecimal(env.getProperty("application.giaviso.resolved.value")));
		final List<ComplaintsForm> complaintsForms = new ArrayList<>();
		final ComplaintsForm complaintsForm = new ComplaintsForm();
		final ComplaintDetail complaintDetail = new ComplaintDetail();
		complaintDetail.setDetectionDate(" ");
		final List<SgdValor> sgdValors = commonService
				.getSgdValors(env.getProperty("application.sgdvalor.codif.complaint.status.value"));
		final Map<BigDecimal, String> sgdValorsMap = sgdValors.parallelStream().filter((filter) -> filter != null)
				.collect(Collectors.toMap(SgdValor::getCodigo, SgdValor::getDescripcion));
		final List<SgdValor> sgdValorComplaintTypes = commonService.getComplaintTypes();
		final Map<BigDecimal, String> sgdValorComplaintTypesMap = sgdValorComplaintTypes.parallelStream()
				.filter((filter) -> filter != null)
				.collect(Collectors.toMap(SgdValor::getCodigo, SgdValor::getDescripcion));

		if (giAvisos != null && !giAvisos.isEmpty()) {
			giAvisos.parallelStream().filter((filter) -> filter != null).forEach((giAvisoResolved) -> {
				if (giAvisoResolved == null) {
					System.out.println("there is no contract number like that");
				} else {
					if (giAvisoResolved.getObsTelegestiones() != null) {
						complaintDetail.setComments(giAvisoResolved.getObsTelegestiones());
					} else {

						complaintDetail.setComments(" ");
					}
					complaintDetail.setComplaintTypeDescription(
							sgdValorComplaintTypesMap.get(giAvisoResolved.getClaseAviso()));
					complaintDetail.setComplaintNumber(giAvisoResolved.getNroAviso());
					complaintDetail.setContractNumber(String.valueOf(giAvisoResolved.getNisRad().longValue()));
					complaintDetail.setComplaintType(String.valueOf(giAvisoResolved.getClaseAviso().longValue()));
					if (giAvisoResolved.getFechaProblema() != null) {
						complaintDetail.setDetectionDate(
								new SimpleDateFormat("dd/MM/yyyy").format(giAvisoResolved.getFechaProblema()));
					} else {
						complaintDetail.setDetectionDate(" ");
					}
					complaintDetail.setStatus(sgdValorsMap.get(giAvisoResolved.getEstAviso()));
					complaintDetail.setComplaintNature(giAvisoResolved.getTipAviso().longValue());
					complaintDetail.setPowerOutage(giAvisoResolved.getIndSupply());
					complaintDetail.setPreviousCalls(giAvisoResolved.getNroLlamadas());
					complaintsForm.setComplaintDetail(complaintDetail);
				}
				final Contract contract = contractService.getContractByContractNumber(contractNumber);
				if (contract != null) {
					CustomerProfile customerProfile;
					try {
						customerProfile = customerProfileService.getCustomerProfile(clientUser);
						customerProfile.setPremiseInformation(contract.getPremiseInformation());
						complaintsForm.setCustomerProfile(customerProfile);
						complaintsForms.add(complaintsForm);
					} catch (final Exception e) {
						e.printStackTrace();
					}

				}

			});
		}
		return complaintsForms;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public List<GiTTipAviso> getGiTTipAvisoByIndNormal() {
		final List<GiTTipAviso> giTTipAvisos = giTTipAvisoRepository.findGiTTipAvisoByIndNormal(new BigDecimal(1));
		return giTTipAvisos;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public List<GiTTipAviso> getGiTTipAvisoByIndQuality() {
		final List<GiTTipAviso> giTTipAvisos = giTTipAvisoRepository.findGiTTipAvisoByIndQuality(new BigDecimal(1));
		return giTTipAvisos;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public List<GiTTipAviso> getGiTTipAvisoByIndAssistance() {
		final List<GiTTipAviso> giTTipAvisos = giTTipAvisoRepository.findGiTTipAvisoByIndAssistance(new BigDecimal(1));
		return giTTipAvisos;
	}

}
