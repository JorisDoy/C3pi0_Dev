package com.indra.iopen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the EXPEDIENTES database table.
 * 
 */
@Entity
@Table(name = "EXPEDIENTES")
@NamedQuery(name = "Expediente.findAll", query = "SELECT e FROM Expediente e")
public class Expediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@SequenceGenerator(name = "EXPEDIENTES_NUMEXP_GENERATOR", sequenceName = "NUM_EXP")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXPEDIENTES_NUMEXP_GENERATOR")
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "NUM_EXP")
	private String numExp;

	@Column(name = "ACCOUNT_NO")
	private String accountNo;

	private BigDecimal admd;

	@Column(name = "CANT_CUOTAS_AFR")
	private BigDecimal cantCuotasAfr;

	@Column(name = "COD_CENTRO_RESPONSABLE")
	private BigDecimal codCentroResponsable;

	@Column(name = "COD_CLI_S")
	private BigDecimal codCliS;

	@Column(name = "COD_IMS_INSTALACION")
	private String codImsInstalacion;

	@Column(name = "COD_OBRA")
	private String codObra;

	@Column(name = "COD_UNICOM_COMPET")
	private BigDecimal codUnicomCompet;

	private String comments;

	@Column(name = "CSMO_AFR")
	private BigDecimal csmoAfr;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_PAID")
	private Date datePaid;

	@Column(name = "DIAMETRO_AGUA")
	private BigDecimal diametroAgua;

	@Column(name = "DIAMETRO_DESAGUE")
	private BigDecimal diametroDesague;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_FACT")
	private Date fFact;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_MODIF")
	private Date fModif;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_SOL")
	private Date fSol;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_UCE")
	private Date fUce;

	@Column(name = "FAX_CLI")
	private String faxCli;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "ID_CO_NUMBER")
	private String idCoNumber;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "NIS_RAD")
	private BigDecimal nisRad;

	@Column(name = "NOM_IMS_INSTALATION")
	private String nomImsInstalation;

	@Column(name = "NUM_OS")
	private BigDecimal numOs;

	@Column(name = "NUM_SUM")
	private BigDecimal numSum;

	@Column(name = "OFFICE_TELE")
	private String officeTele;

	@Column(name = "POT_LLANO")
	private BigDecimal potLlano;

	@Column(name = "POT_PUNTA")
	private BigDecimal potPunta;

	@Column(name = "POT_TOT_LINE")
	private BigDecimal potTotLine;

	@Column(name = "POT_VALLE")
	private BigDecimal potValle;

	private String programa;

	private String solicitante;

	@Column(name = "SUBSTATION_NUMBER")
	private BigDecimal substationNumber;

	private String surname;

	@Column(name = "TFNO_CLI")
	private String tfnoCli;

	@Column(name = "TIP_CONEXION")
	private String tipConexion;

	@Column(name = "TIP_OBRA")
	private String tipObra;

	@Column(name = "TIP_SERV")
	private String tipServ;

	@Column(name = "TIP_SOLIC")
	private String tipSolic;

	private String usuario;

	public Expediente() {

		try {
			this.usuario = "IOPEN";
			this.programa = "IOPEN";
			this.accountNo = " ";
			this.admd = new BigDecimal(0);
			this.cantCuotasAfr = new BigDecimal(0);
			this.codCentroResponsable = new BigDecimal(0);

			this.codImsInstalacion = " ";
			this.codObra = " ";
			this.codUnicomCompet = new BigDecimal(1000);
			this.comments = " ";
			this.csmoAfr = new BigDecimal(0);
			this.datePaid = new SimpleDateFormat("yyyyMMdd").parse("29991231");
			
			this.fFact = new SimpleDateFormat("yyyyMMdd").parse("29991231");

			this.diametroAgua = new BigDecimal(0);
			this.diametroDesague = new BigDecimal(0);
			this.fActual = new Date();

			this.fUce = new Date();
			this.faxCli = " ";
			this.nisRad = new BigDecimal(0);
			this.nomImsInstalation = " ";
			this.numOs = new BigDecimal(0);
			this.numSum = new BigDecimal(0);
			this.officeTele = " ";
			this.potLlano = new BigDecimal(0);
			this.potPunta = new BigDecimal(0);
			this.potValle = new BigDecimal(0);
			this.substationNumber = new BigDecimal(0);
			this.tfnoCli = " ";
			// this.tipConexion =
			// this.env.getRequiredProperty("application.default.expedientes.tip_conexion.value");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getAccountNo() {
		return this.accountNo;
	}

	public BigDecimal getAdmd() {
		return this.admd;
	}

	public BigDecimal getCantCuotasAfr() {
		return this.cantCuotasAfr;
	}

	public BigDecimal getCodCentroResponsable() {
		return this.codCentroResponsable;
	}

	public BigDecimal getCodCliS() {
		return this.codCliS;
	}

	public String getCodImsInstalacion() {
		return this.codImsInstalacion;
	}

	public String getCodObra() {
		return this.codObra;
	}

	public BigDecimal getCodUnicomCompet() {
		return this.codUnicomCompet;
	}

	public String getComments() {
		return this.comments;
	}

	public BigDecimal getCsmoAfr() {
		return this.csmoAfr;
	}

	public Date getDatePaid() {
		return this.datePaid;
	}

	public BigDecimal getDiametroAgua() {
		return this.diametroAgua;
	}

	public BigDecimal getDiametroDesague() {
		return this.diametroDesague;
	}

	public String getEstado() {
		return this.estado;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public String getFaxCli() {
		return this.faxCli;
	}

	public Date getFFact() {
		return this.fFact;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public Date getFModif() {
		return this.fModif;
	}

	public Date getFSol() {
		return this.fSol;
	}

	public Date getFUce() {
		return this.fUce;
	}

	public String getIdCoNumber() {
		return this.idCoNumber;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public BigDecimal getNisRad() {
		return this.nisRad;
	}

	public String getNomImsInstalation() {
		return this.nomImsInstalation;
	}

	public String getNumExp() {
		return this.numExp;
	}

	public BigDecimal getNumOs() {
		return this.numOs;
	}

	public BigDecimal getNumSum() {
		return this.numSum;
	}

	public String getOfficeTele() {
		return this.officeTele;
	}

	public BigDecimal getPotLlano() {
		return this.potLlano;
	}

	public BigDecimal getPotPunta() {
		return this.potPunta;
	}

	public BigDecimal getPotTotLine() {
		return this.potTotLine;
	}

	public BigDecimal getPotValle() {
		return this.potValle;
	}

	public String getPrograma() {
		return this.programa;
	}

	public String getSolicitante() {
		return this.solicitante;
	}

	public BigDecimal getSubstationNumber() {
		return this.substationNumber;
	}

	public String getSurname() {
		return this.surname;
	}

	public String getTfnoCli() {
		return this.tfnoCli;
	}

	public String getTipConexion() {
		return this.tipConexion;
	}

	public String getTipObra() {
		return this.tipObra;
	}

	public String getTipServ() {
		return this.tipServ;
	}

	public String getTipSolic() {
		return this.tipSolic;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setAdmd(BigDecimal admd) {
		this.admd = admd;
	}

	public void setCantCuotasAfr(BigDecimal cantCuotasAfr) {
		this.cantCuotasAfr = cantCuotasAfr;
	}

	public void setCodCentroResponsable(BigDecimal codCentroResponsable) {
		this.codCentroResponsable = codCentroResponsable;
	}

	public void setCodCliS(BigDecimal codCliS) {
		this.codCliS = codCliS;
	}

	public void setCodImsInstalacion(String codImsInstalacion) {
		this.codImsInstalacion = codImsInstalacion;
	}

	public void setCodObra(String codObra) {
		this.codObra = codObra;
	}

	public void setCodUnicomCompet(BigDecimal codUnicomCompet) {
		this.codUnicomCompet = codUnicomCompet;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setCsmoAfr(BigDecimal csmoAfr) {
		this.csmoAfr = csmoAfr;
	}

	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}

	public void setDiametroAgua(BigDecimal diametroAgua) {
		this.diametroAgua = diametroAgua;
	}

	public void setDiametroDesague(BigDecimal diametroDesague) {
		this.diametroDesague = diametroDesague;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public void setFaxCli(String faxCli) {
		this.faxCli = faxCli;
	}

	public void setFFact(Date fFact) {
		this.fFact = fFact;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setFModif(Date fModif) {
		this.fModif = fModif;
	}

	public void setFSol(Date fSol) {
		this.fSol = fSol;
	}

	public void setFUce(Date fUce) {
		this.fUce = fUce;
	}

	public void setIdCoNumber(String idCoNumber) {
		this.idCoNumber = idCoNumber;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setNisRad(BigDecimal nisRad) {
		this.nisRad = nisRad;
	}

	public void setNomImsInstalation(String nomImsInstalation) {
		this.nomImsInstalation = nomImsInstalation;
	}

	public void setNumExp(String numExp) {
		this.numExp = numExp;
	}

	public void setNumOs(BigDecimal numOs) {
		this.numOs = numOs;
	}

	public void setNumSum(BigDecimal numSum) {
		this.numSum = numSum;
	}

	public void setOfficeTele(String officeTele) {
		this.officeTele = officeTele;
	}

	public void setPotLlano(BigDecimal potLlano) {
		this.potLlano = potLlano;
	}

	public void setPotPunta(BigDecimal potPunta) {
		this.potPunta = potPunta;
	}

	public void setPotTotLine(BigDecimal potTotLine) {
		this.potTotLine = potTotLine;
	}

	public void setPotValle(BigDecimal potValle) {
		this.potValle = potValle;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public void setSubstationNumber(BigDecimal substationNumber) {
		this.substationNumber = substationNumber;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setTfnoCli(String tfnoCli) {
		this.tfnoCli = tfnoCli;
	}

	public void setTipConexion(String tipConexion) {
		this.tipConexion = tipConexion;
	}

	public void setTipObra(String tipObra) {
		this.tipObra = tipObra;
	}

	public void setTipServ(String tipServ) {
		this.tipServ = tipServ;
	}

	public void setTipSolic(String tipSolic) {
		this.tipSolic = tipSolic;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}