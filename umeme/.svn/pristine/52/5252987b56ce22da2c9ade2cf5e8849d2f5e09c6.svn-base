package com.indra.iopen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the CLIENTES database table.
 * 
 */
@Entity
@Table(name = "CLIENTES")
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@SequenceGenerator(name = "CLIENTES_CODCLI_GENERATOR", sequenceName = "COD_CLI")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTES_CODCLI_GENERATOR")
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "COD_CLI", unique = true, nullable = false, precision = 10)

	private long codCli;

	@Column(name = "ALIAS_CLI", nullable = false, length = 30)
	private String aliasCli;

	@Column(name = "APE1_CLI", nullable = false, length = 30)
	private String ape1Cli;

	@Column(name = "APE2_CLI", nullable = false, length = 30)
	private String ape2Cli;

	@Column(name = "CANT_LETRAS_IMPAGAS", nullable = false, precision = 2)
	private BigDecimal cantLetrasImpagas;

	@Column(name = "CCR_CODE", nullable = false, length = 5)
	private String ccrCode;

	@Column(name = "CCR_EXT_RATING", nullable = false, precision = 5, scale = 2)
	private BigDecimal ccrExtRating;

	@Column(name = "CGV_CLI", nullable = false, length = 6)
	private String cgvCli;

	@Column(name = "CO_COND_FISCAL", nullable = false, length = 5)
	private String coCondFiscal;

	@Column(name = "CO_PAGO_CLIENTE", nullable = false, precision = 15, scale = 2)
	private BigDecimal coPagoCliente;

	@Column(name = "CO_PAIS", nullable = false, length = 5)
	private String coPais;

	@Column(name = "COD_CLI_DIREC1", nullable = false, precision = 9)
	private BigDecimal codCliDirec1;

	@Column(name = "COD_CLI_DIREC2", nullable = false, precision = 9)
	private BigDecimal codCliDirec2;

	@Column(name = "COD_CLI_DIREC3", nullable = false, precision = 9)
	private BigDecimal codCliDirec3;

	@Column(name = "COD_CLI_SOCIO1", nullable = false, precision = 9)
	private BigDecimal codCliSocio1;

	@Column(name = "COD_CLI_SOCIO2", nullable = false, precision = 9)
	private BigDecimal codCliSocio2;

	@Column(name = "COD_CLI_SOCIO3", nullable = false, precision = 9)
	private BigDecimal codCliSocio3;

	@Column(name = "COD_CNAE", nullable = false, length = 9)
	private String codCnae;

	@Column(name = "CUALIF_CLI", nullable = false, length = 10)
	private String cualifCli;

	@Column(name = "E_MAIL", nullable = false, length = 30)
	private String eMail;

	@Column(name = "EMPRESA_PADRE", nullable = false, length = 30)
	private String empresaPadre;

	@Column(name = "EXT_RATING_AGENCIA", nullable = false, precision = 6)
	private BigDecimal extRatingAgencia;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL", nullable = false)
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ALTA", nullable = false)
	private Date fAlta;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_BAJA", nullable = false)
	private Date fBaja;

	@Column(name = "FAX_CLI", nullable = false, length = 12)
	private String faxCli;

	@Column(name = "IND_BANCARROTA", nullable = false, precision = 1)
	private BigDecimal indBancarrota;

	@Column(name = "IND_EMPLE_UTILITY", nullable = false, precision = 1)
	private BigDecimal indEmpleUtility;

	@Column(name = "IND_EMPRESA", nullable = false, precision = 1)
	private BigDecimal indEmpresa;

	@Column(name = "IND_INGRESOS_MINIMOS", nullable = false, precision = 1)
	private BigDecimal indIngresosMinimos;

	@Column(name = "IND_PROSPECT", nullable = false, precision = 1)
	private BigDecimal indProspect;

	@Column(name = "IND_VENTA_SOCIAL", nullable = false, precision = 1)
	private BigDecimal indVentaSocial;

	@Column(nullable = false, precision = 9)
	private BigDecimal nif;

	@Column(name = "NOM_CLI", nullable = false, length = 30)
	private String nomCli;

	@Column(name = "NOMBRE_EMPRESA", nullable = false, length = 30)
	private String nombreEmpresa;

	@Column(name = "NOMBRE_MADRE", nullable = false, length = 30)
	private String nombreMadre;

	@Column(name = "NOMBRE_PADRE", nullable = false, length = 30)
	private String nombrePadre;

	@Column(nullable = false, precision = 3)
	private BigDecimal nrh;

	@Column(name = "NRH_FAV", nullable = false, precision = 3)
	private BigDecimal nrhFav;

	@Column(name = "NRH_PEN", nullable = false, precision = 3)
	private BigDecimal nrhPen;

	@Column(name = "NUM_DEV_CHEQ", nullable = false, precision = 2)
	private BigDecimal numDevCheq;

	@Column(name = "NUM_FISCAL", nullable = false, length = 14)
	private String numFiscal;

	@Column(nullable = false, length = 50)
	private String observaciones;

	@Column(name = "PERS_CONTACTO", nullable = false, length = 30)
	private String persContacto;

	@Column(name = "PERS_CONTACTO2", nullable = false, length = 30)
	private String persContacto2;

	@Column(nullable = false, length = 15)
	private String programa;

	@Column(name = "REF_DIR", nullable = false, length = 60)
	private String refDir;

	@Column(name = "SOUNDEX_ALIAS", nullable = false, length = 6)
	private String soundexAlias;

	@Column(name = "SOUNDEX_MADRE", nullable = false, length = 10)
	private String soundexMadre;

	@Column(name = "SOUNDEX_NOMBRE", nullable = false, length = 12)
	private String soundexNombre;

	@Column(name = "SOUNDEX_PADRE", nullable = false, length = 10)
	private String soundexPadre;

	@Column(name = "SUFFIX", nullable = false, length = 15)
	private String suffix;

	@Column(name = "TFNO1_CLI", nullable = false, length = 12)
	private String tfno1Cli;

	@Column(name = "TFNO2_CLI", nullable = false, length = 12)
	private String tfno2Cli;

	@Column(name = "TFNO3_CLI", nullable = false, length = 12)
	private String tfno3Cli;

	@Column(name = "TIP_CLI", nullable = false, length = 5)
	private String tipCli;

	@Temporal(TemporalType.DATE)
	@Column(name = "USR_DATETIME1", nullable = false)
	private Date usrDatetime1;

	@Temporal(TemporalType.DATE)
	@Column(name = "USR_DATETIME2", nullable = false)
	private Date usrDatetime2;

	@Column(name = "USR_NUMBER1", nullable = false, precision = 19, scale = 3)
	private BigDecimal usrNumber1;

	@Column(name = "USR_NUMBER2", nullable = false, precision = 19, scale = 3)
	private BigDecimal usrNumber2;

	@Column(name = "USR_NUMBER3", nullable = false, precision = 19, scale = 3)
	private BigDecimal usrNumber3;

	@Column(name = "USR_VARCHAR1", nullable = false, length = 255)
	private String usrVarchar1;

	@Column(name = "USR_VARCHAR2", nullable = false, length = 255)
	private String usrVarchar2;

	@Column(name = "USR_VARCHAR3", nullable = false, length = 255)
	private String usrVarchar3;

	@Column(nullable = false, length = 30)
	private String usuario;

	// bi-directional many-to-one association to ControlAccesoInternet
	@OneToMany(mappedBy = "cliente")
	private List<ControlAccesoInternet> controlAccesoInternets;

	// bi-directional many-to-one association to ImagenesHtml
	@OneToMany(mappedBy = "cliente")
	private List<ImagenesHtml> imagenesHtmls;

	// bi-directional many-to-one association to RemPayroll
	@OneToMany(mappedBy = "cliente")
	private List<RemPayroll> remPayrolls;

	public Cliente() {

		try {
			this.fActual = new Date();
			this.usuario = "IOPEN";
			this.programa = "IOPEN";
			this.aliasCli = " ";
			this.cantLetrasImpagas = new BigDecimal(0);
			this.ccrCode = " ";
			this.ccrExtRating = new BigDecimal(0);
			this.cgvCli = "1";
			this.coCondFiscal = "FC500";
			this.coPagoCliente = new BigDecimal(0);
			this.coPais = "PD001";
			this.codCliDirec1 = new BigDecimal(0);
			this.codCliDirec2 = new BigDecimal(0);
			this.codCliDirec3 = new BigDecimal(0);
			this.codCliSocio1 = new BigDecimal(0);
			this.codCliSocio2 = new BigDecimal(0);
			this.codCliSocio3 = new BigDecimal(0);
			this.codCnae = "148";
			this.cualifCli = " ";
			this.empresaPadre = " ";
			this.extRatingAgencia = new BigDecimal(100);
			this.fAlta = new Date();
			this.fBaja = new SimpleDateFormat("yyyyMMdd").parse("29991231");

			this.faxCli = " ";
			this.indBancarrota = new BigDecimal(2);
			this.indEmpleUtility = new BigDecimal(2);
			this.indEmpresa = new BigDecimal(2);
			this.indIngresosMinimos = new BigDecimal(2);
			this.indProspect = new BigDecimal(2);
			this.indVentaSocial = new BigDecimal(2);
			this.nombreEmpresa = " ";
			this.nombreMadre = " ";
			this.nombrePadre = " ";
			this.nrh = new BigDecimal(0);
			this.nrhFav = new BigDecimal(0);
			this.nrhPen = new BigDecimal(0);
			this.numDevCheq = new BigDecimal(0);
			this.numFiscal = " ";
			this.observaciones = " ";
			this.persContacto = " ";
			this.persContacto2 = " ";
			// this.refDir = refDir;
			this.soundexAlias = " ";
			this.soundexMadre = " ";
			this.soundexNombre = " ";
			this.soundexPadre = " ";
			this.suffix = " ";
			this.tfno2Cli = " ";
			this.usrDatetime1 = new SimpleDateFormat("yyyyMMdd").parse("29991231");
			this.usrDatetime2 = new SimpleDateFormat("yyyyMMdd").parse("29991231");
			this.usrNumber1 = new BigDecimal(2);
			this.usrNumber2 = new BigDecimal(0);
			this.usrNumber3 = new BigDecimal(2);
			this.usrVarchar1 = " ";
			this.usrVarchar2 = " ";
			this.usrVarchar3 = " ";
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public ControlAccesoInternet addControlAccesoInternet(ControlAccesoInternet controlAccesoInternet) {
		getControlAccesoInternets().add(controlAccesoInternet);
		controlAccesoInternet.setCliente(this);

		return controlAccesoInternet;
	}

	public ImagenesHtml addImagenesHtml(ImagenesHtml imagenesHtml) {
		getImagenesHtmls().add(imagenesHtml);
		imagenesHtml.setCliente(this);

		return imagenesHtml;
	}

	public RemPayroll addRemPayroll(RemPayroll remPayroll) {
		getRemPayrolls().add(remPayroll);
		remPayroll.setCliente(this);

		return remPayroll;
	}

	public String getAliasCli() {
		return this.aliasCli;
	}

	public String getApe1Cli() {
		return this.ape1Cli;
	}

	public String getApe2Cli() {
		return this.ape2Cli;
	}

	public BigDecimal getCantLetrasImpagas() {
		return this.cantLetrasImpagas;
	}

	public String getCcrCode() {
		return this.ccrCode;
	}

	public BigDecimal getCcrExtRating() {
		return this.ccrExtRating;
	}

	public String getCgvCli() {
		return this.cgvCli;
	}

	public String getCoCondFiscal() {
		return this.coCondFiscal;
	}

	public long getCodCli() {
		return this.codCli;
	}

	public BigDecimal getCodCliDirec1() {
		return this.codCliDirec1;
	}

	public BigDecimal getCodCliDirec2() {
		return this.codCliDirec2;
	}

	public BigDecimal getCodCliDirec3() {
		return this.codCliDirec3;
	}

	public BigDecimal getCodCliSocio1() {
		return this.codCliSocio1;
	}

	public BigDecimal getCodCliSocio2() {
		return this.codCliSocio2;
	}

	public BigDecimal getCodCliSocio3() {
		return this.codCliSocio3;
	}

	public String getCodCnae() {
		return this.codCnae;
	}

	public List<ControlAccesoInternet> getControlAccesoInternets() {
		return this.controlAccesoInternets;
	}

	public BigDecimal getCoPagoCliente() {
		return this.coPagoCliente;
	}

	public String getCoPais() {
		return this.coPais;
	}

	public String getCualifCli() {
		return this.cualifCli;
	}

	public String getEMail() {
		return this.eMail;
	}

	public String getEmpresaPadre() {
		return this.empresaPadre;
	}

	public BigDecimal getExtRatingAgencia() {
		return this.extRatingAgencia;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public Date getFAlta() {
		return this.fAlta;
	}

	public String getFaxCli() {
		return this.faxCli;
	}

	public Date getFBaja() {
		return this.fBaja;
	}

	public List<ImagenesHtml> getImagenesHtmls() {
		return this.imagenesHtmls;
	}

	public BigDecimal getIndBancarrota() {
		return this.indBancarrota;
	}

	public BigDecimal getIndEmpleUtility() {
		return this.indEmpleUtility;
	}

	public BigDecimal getIndEmpresa() {
		return this.indEmpresa;
	}

	public BigDecimal getIndIngresosMinimos() {
		return this.indIngresosMinimos;
	}

	public BigDecimal getIndProspect() {
		return this.indProspect;
	}

	public BigDecimal getIndVentaSocial() {
		return this.indVentaSocial;
	}

	public BigDecimal getNif() {
		return this.nif;
	}

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public String getNombreMadre() {
		return this.nombreMadre;
	}

	public String getNombrePadre() {
		return this.nombrePadre;
	}

	public String getNomCli() {
		return this.nomCli;
	}

	public BigDecimal getNrh() {
		return this.nrh;
	}

	public BigDecimal getNrhFav() {
		return this.nrhFav;
	}

	public BigDecimal getNrhPen() {
		return this.nrhPen;
	}

	public BigDecimal getNumDevCheq() {
		return this.numDevCheq;
	}

	public String getNumFiscal() {
		return this.numFiscal;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public String getPersContacto() {
		return this.persContacto;
	}

	public String getPersContacto2() {
		return this.persContacto2;
	}

	public String getPrograma() {
		return this.programa;
	}

	public String getRefDir() {
		return this.refDir;
	}

	public List<RemPayroll> getRemPayrolls() {
		return this.remPayrolls;
	}

	public String getSoundexAlias() {
		return this.soundexAlias;
	}

	public String getSoundexMadre() {
		return this.soundexMadre;
	}

	public String getSoundexNombre() {
		return this.soundexNombre;
	}

	public String getSoundexPadre() {
		return this.soundexPadre;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public String getTfno1Cli() {
		return this.tfno1Cli;
	}

	public String getTfno2Cli() {
		return this.tfno2Cli;
	}

	public String getTfno3Cli() {
		return this.tfno3Cli;
	}

	public String getTipCli() {
		return this.tipCli;
	}

	public Date getUsrDatetime1() {
		return this.usrDatetime1;
	}

	public Date getUsrDatetime2() {
		return this.usrDatetime2;
	}

	public BigDecimal getUsrNumber1() {
		return this.usrNumber1;
	}

	public BigDecimal getUsrNumber2() {
		return this.usrNumber2;
	}

	public BigDecimal getUsrNumber3() {
		return this.usrNumber3;
	}

	public String getUsrVarchar1() {
		return this.usrVarchar1;
	}

	public String getUsrVarchar2() {
		return this.usrVarchar2;
	}

	public String getUsrVarchar3() {
		return this.usrVarchar3;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public ControlAccesoInternet removeControlAccesoInternet(ControlAccesoInternet controlAccesoInternet) {
		getControlAccesoInternets().remove(controlAccesoInternet);
		controlAccesoInternet.setCliente(null);

		return controlAccesoInternet;
	}

	public ImagenesHtml removeImagenesHtml(ImagenesHtml imagenesHtml) {
		getImagenesHtmls().remove(imagenesHtml);
		imagenesHtml.setCliente(null);

		return imagenesHtml;
	}

	public RemPayroll removeRemPayroll(RemPayroll remPayroll) {
		getRemPayrolls().remove(remPayroll);
		remPayroll.setCliente(null);

		return remPayroll;
	}

	public void setAliasCli(String aliasCli) {
		this.aliasCli = aliasCli;
	}

	public void setApe1Cli(String ape1Cli) {
		this.ape1Cli = ape1Cli;
	}

	public void setApe2Cli(String ape2Cli) {
		this.ape2Cli = ape2Cli;
	}

	public void setCantLetrasImpagas(BigDecimal cantLetrasImpagas) {
		this.cantLetrasImpagas = cantLetrasImpagas;
	}

	public void setCcrCode(String ccrCode) {
		this.ccrCode = ccrCode;
	}

	public void setCcrExtRating(BigDecimal ccrExtRating) {
		this.ccrExtRating = ccrExtRating;
	}

	public void setCgvCli(String cgvCli) {
		this.cgvCli = cgvCli;
	}

	public void setCoCondFiscal(String coCondFiscal) {
		this.coCondFiscal = coCondFiscal;
	}

	public void setCodCli(long codCli) {
		this.codCli = codCli;
	}

	public void setCodCliDirec1(BigDecimal codCliDirec1) {
		this.codCliDirec1 = codCliDirec1;
	}

	public void setCodCliDirec2(BigDecimal codCliDirec2) {
		this.codCliDirec2 = codCliDirec2;
	}

	public void setCodCliDirec3(BigDecimal codCliDirec3) {
		this.codCliDirec3 = codCliDirec3;
	}

	public void setCodCliSocio1(BigDecimal codCliSocio1) {
		this.codCliSocio1 = codCliSocio1;
	}

	public void setCodCliSocio2(BigDecimal codCliSocio2) {
		this.codCliSocio2 = codCliSocio2;
	}

	public void setCodCliSocio3(BigDecimal codCliSocio3) {
		this.codCliSocio3 = codCliSocio3;
	}

	public void setCodCnae(String codCnae) {
		this.codCnae = codCnae;
	}

	public void setControlAccesoInternets(List<ControlAccesoInternet> controlAccesoInternets) {
		this.controlAccesoInternets = controlAccesoInternets;
	}

	public void setCoPagoCliente(BigDecimal coPagoCliente) {
		this.coPagoCliente = coPagoCliente;
	}

	public void setCoPais(String coPais) {
		this.coPais = coPais;
	}

	public void setCualifCli(String cualifCli) {
		this.cualifCli = cualifCli;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public void setEmpresaPadre(String empresaPadre) {
		this.empresaPadre = empresaPadre;
	}

	public void setExtRatingAgencia(BigDecimal extRatingAgencia) {
		this.extRatingAgencia = extRatingAgencia;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public void setFAlta(Date fAlta) {
		this.fAlta = fAlta;
	}

	public void setFaxCli(String faxCli) {
		this.faxCli = faxCli;
	}

	public void setFBaja(Date fBaja) {
		this.fBaja = fBaja;
	}

	public void setImagenesHtmls(List<ImagenesHtml> imagenesHtmls) {
		this.imagenesHtmls = imagenesHtmls;
	}

	public void setIndBancarrota(BigDecimal indBancarrota) {
		this.indBancarrota = indBancarrota;
	}

	public void setIndEmpleUtility(BigDecimal indEmpleUtility) {
		this.indEmpleUtility = indEmpleUtility;
	}

	public void setIndEmpresa(BigDecimal indEmpresa) {
		this.indEmpresa = indEmpresa;
	}

	public void setIndIngresosMinimos(BigDecimal indIngresosMinimos) {
		this.indIngresosMinimos = indIngresosMinimos;
	}

	public void setIndProspect(BigDecimal indProspect) {
		this.indProspect = indProspect;
	}

	public void setIndVentaSocial(BigDecimal indVentaSocial) {
		this.indVentaSocial = indVentaSocial;
	}

	public void setNif(BigDecimal nif) {
		this.nif = nif;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public void setNombreMadre(String nombreMadre) {
		this.nombreMadre = nombreMadre;
	}

	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}

	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}

	public void setNrh(BigDecimal nrh) {
		this.nrh = nrh;
	}

	public void setNrhFav(BigDecimal nrhFav) {
		this.nrhFav = nrhFav;
	}

	public void setNrhPen(BigDecimal nrhPen) {
		this.nrhPen = nrhPen;
	}

	public void setNumDevCheq(BigDecimal numDevCheq) {
		this.numDevCheq = numDevCheq;
	}

	public void setNumFiscal(String numFiscal) {
		this.numFiscal = numFiscal;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public void setPersContacto(String persContacto) {
		this.persContacto = persContacto;
	}

	public void setPersContacto2(String persContacto2) {
		this.persContacto2 = persContacto2;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public void setRefDir(String refDir) {
		this.refDir = refDir;
	}

	public void setRemPayrolls(List<RemPayroll> remPayrolls) {
		this.remPayrolls = remPayrolls;
	}

	public void setSoundexAlias(String soundexAlias) {
		this.soundexAlias = soundexAlias;
	}

	public void setSoundexMadre(String soundexMadre) {
		this.soundexMadre = soundexMadre;
	}

	public void setSoundexNombre(String soundexNombre) {
		this.soundexNombre = soundexNombre;
	}

	public void setSoundexPadre(String soundexPadre) {
		this.soundexPadre = soundexPadre;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setTfno1Cli(String tfno1Cli) {
		this.tfno1Cli = tfno1Cli;
	}

	public void setTfno2Cli(String tfno2Cli) {
		this.tfno2Cli = tfno2Cli;
	}

	public void setTfno3Cli(String tfno3Cli) {
		this.tfno3Cli = tfno3Cli;
	}

	public void setTipCli(String tipCli) {
		this.tipCli = tipCli;
	}

	public void setUsrDatetime1(Date usrDatetime1) {
		this.usrDatetime1 = usrDatetime1;
	}

	public void setUsrDatetime2(Date usrDatetime2) {
		this.usrDatetime2 = usrDatetime2;
	}

	public void setUsrNumber1(BigDecimal usrNumber1) {
		this.usrNumber1 = usrNumber1;
	}

	public void setUsrNumber2(BigDecimal usrNumber2) {
		this.usrNumber2 = usrNumber2;
	}

	public void setUsrNumber3(BigDecimal usrNumber3) {
		this.usrNumber3 = usrNumber3;
	}

	public void setUsrVarchar1(String usrVarchar1) {
		this.usrVarchar1 = usrVarchar1;
	}

	public void setUsrVarchar2(String usrVarchar2) {
		this.usrVarchar2 = usrVarchar2;
	}

	public void setUsrVarchar3(String usrVarchar3) {
		this.usrVarchar3 = usrVarchar3;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}