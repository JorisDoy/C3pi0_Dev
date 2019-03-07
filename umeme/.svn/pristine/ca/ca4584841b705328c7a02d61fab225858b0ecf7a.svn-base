package com.indra.iopen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the ORDENES database table.
 *
 */
@Entity
@Table(name = "ORDENES")
@NamedQuery(name = "Ordene.findAll", query = "SELECT o FROM Ordene o")
public class Ordene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ORDENES_NUMOS_GENERATOR", sequenceName = "ORDENES_NUM_OS")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDENES_NUMOS_GENERATOR")
	@Column(name = "NUM_OS")
	private Long numOs;

	@Column(name = "CANT_MODIF")
	private String cantModif;

	private String cgv;

	@Column(name = "CO_CARGOS")
	private String coCargos;

	@Column(name = "CO_MARCA")
	private String coMarca;

	@Column(name = "CO_PRIOR_ORD")
	private String coPriorOrd;

	@Column(name = "CO_SISTANUL")
	private String coSistanul;

	@Column(name = "CO_SISTGEN")
	private String coSistgen;

	@Column(name = "COD_CALLE")
	private BigDecimal codCalle;

	@Column(name = "COD_CTRAT")
	private BigDecimal codCtrat;

	@Column(name = "COD_EMP_ASIG")
	private BigDecimal codEmpAsig;

	@Column(name = "COD_EMP_GEN")
	private BigDecimal codEmpGen;

	@Column(name = "COD_TAR")
	private String codTar;

	@Column(name = "COD_UNICOM")
	private BigDecimal codUnicom;

	@Column(name = "COD_UNICOM_GEN")
	private BigDecimal codUnicomGen;

	@Column(name = "COMMENT_OS")
	private String commentOs;

	private String duplicador;

	@Column(name = "EST_OS")
	private String estOs;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ESTM_REST")
	private Date fEstmRest;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_GEN")
	private Date fGen;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_MAX_PROGRAMA")
	private Date fMaxPrograma;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_UCE")
	private Date fUce;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_UREVIS")
	private Date fUrevis;

	@Column(name = "HORA_CITA")
	private BigDecimal horaCita;

	@Column(name = "ID_EMPRESA_ASIG")
	private BigDecimal idEmpresaAsig;

	@Column(name = "ID_EMPRESA_GEN")
	private BigDecimal idEmpresaGen;

	@Column(name = "IMP_CARGO")
	private BigDecimal impCargo;

	@Column(name = "IND_CITA")
	private BigDecimal indCita;

	@Column(name = "NIS_RAD")
	private BigDecimal nisRad;

	@Column(name = "NUM_APARATO")
	private String numAparato;

	// @Column(name = "NUM_BULK")
	// private BigDecimal numBulk;

	@Column(name = "NUM_CAMP")
	private BigDecimal numCamp;

	@Column(name = "NUM_OS_EXT")
	private String numOsExt;

	@Column(name = "NUM_PUERTA")
	private BigDecimal numPuerta;

	@Column(name = "NUM_REPROGRAMA")
	private BigDecimal numReprograma;

	@Column(name = "NUM_SUM")
	private BigDecimal numSum;

	@Column(name = "PESO_ORD")
	private BigDecimal pesoOrd;

	private String pot;

	private String programa;

	@Column(name = "REF_DIR")
	private String refDir;

	@Column(name = "SEC_NIS")
	private BigDecimal secNis;

	@Column(name = "TIP_OS")
	private String tipOs;

	@Column(name = "TIP_SERV")
	private String tipServ;

	private String usuario;

	public Ordene() {
	}

	public long getNumOs() {
		return this.numOs;
	}

	public void setNumOs(final long numOs) {
		this.numOs = numOs;
	}

	public String getCantModif() {
		return this.cantModif;
	}

	public void setCantModif(final String cantModif) {
		this.cantModif = cantModif;
	}

	public String getCgv() {
		return this.cgv;
	}

	public void setCgv(final String cgv) {
		this.cgv = cgv;
	}

	public String getCoCargos() {
		return this.coCargos;
	}

	public void setCoCargos(final String coCargos) {
		this.coCargos = coCargos;
	}

	public String getCoMarca() {
		return this.coMarca;
	}

	public void setCoMarca(final String coMarca) {
		this.coMarca = coMarca;
	}

	public String getCoPriorOrd() {
		return this.coPriorOrd;
	}

	public void setCoPriorOrd(final String coPriorOrd) {
		this.coPriorOrd = coPriorOrd;
	}

	public String getCoSistanul() {
		return this.coSistanul;
	}

	public void setCoSistanul(final String coSistanul) {
		this.coSistanul = coSistanul;
	}

	public String getCoSistgen() {
		return this.coSistgen;
	}

	public void setCoSistgen(final String coSistgen) {
		this.coSistgen = coSistgen;
	}

	public BigDecimal getCodCalle() {
		return this.codCalle;
	}

	public void setCodCalle(final BigDecimal codCalle) {
		this.codCalle = codCalle;
	}

	public BigDecimal getCodCtrat() {
		return this.codCtrat;
	}

	public void setCodCtrat(final BigDecimal codCtrat) {
		this.codCtrat = codCtrat;
	}

	public BigDecimal getCodEmpAsig() {
		return this.codEmpAsig;
	}

	public void setCodEmpAsig(final BigDecimal codEmpAsig) {
		this.codEmpAsig = codEmpAsig;
	}

	public BigDecimal getCodEmpGen() {
		return this.codEmpGen;
	}

	public void setCodEmpGen(final BigDecimal codEmpGen) {
		this.codEmpGen = codEmpGen;
	}

	public String getCodTar() {
		return this.codTar;
	}

	public void setCodTar(final String codTar) {
		this.codTar = codTar;
	}

	public BigDecimal getCodUnicom() {
		return this.codUnicom;
	}

	public void setCodUnicom(final BigDecimal codUnicom) {
		this.codUnicom = codUnicom;
	}

	public BigDecimal getCodUnicomGen() {
		return this.codUnicomGen;
	}

	public void setCodUnicomGen(final BigDecimal codUnicomGen) {
		this.codUnicomGen = codUnicomGen;
	}

	public String getCommentOs() {
		return this.commentOs;
	}

	public void setCommentOs(final String commentOs) {
		this.commentOs = commentOs;
	}

	public String getDuplicador() {
		return this.duplicador;
	}

	public void setDuplicador(final String duplicador) {
		this.duplicador = duplicador;
	}

	public String getEstOs() {
		return this.estOs;
	}

	public void setEstOs(final String estOs) {
		this.estOs = estOs;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(final Date fActual) {
		this.fActual = fActual;
	}

	public Date getFEstmRest() {
		return this.fEstmRest;
	}

	public void setFEstmRest(final Date fEstmRest) {
		this.fEstmRest = fEstmRest;
	}

	public Date getFGen() {
		return this.fGen;
	}

	public void setFGen(final Date fGen) {
		this.fGen = fGen;
	}

	public Date getFMaxPrograma() {
		return this.fMaxPrograma;
	}

	public void setFMaxPrograma(final Date fMaxPrograma) {
		this.fMaxPrograma = fMaxPrograma;
	}

	public Date getFUce() {
		return this.fUce;
	}

	public void setFUce(final Date fUce) {
		this.fUce = fUce;
	}

	public Date getFUrevis() {
		return this.fUrevis;
	}

	public void setFUrevis(final Date fUrevis) {
		this.fUrevis = fUrevis;
	}

	public BigDecimal getHoraCita() {
		return this.horaCita;
	}

	public void setHoraCita(final BigDecimal horaCita) {
		this.horaCita = horaCita;
	}

	public BigDecimal getIdEmpresaAsig() {
		return this.idEmpresaAsig;
	}

	public void setIdEmpresaAsig(final BigDecimal idEmpresaAsig) {
		this.idEmpresaAsig = idEmpresaAsig;
	}

	public BigDecimal getIdEmpresaGen() {
		return this.idEmpresaGen;
	}

	public void setIdEmpresaGen(final BigDecimal idEmpresaGen) {
		this.idEmpresaGen = idEmpresaGen;
	}

	public BigDecimal getImpCargo() {
		return this.impCargo;
	}

	public void setImpCargo(final BigDecimal impCargo) {
		this.impCargo = impCargo;
	}

	public BigDecimal getIndCita() {
		return this.indCita;
	}

	public void setIndCita(final BigDecimal indCita) {
		this.indCita = indCita;
	}

	public BigDecimal getNisRad() {
		return this.nisRad;
	}

	public void setNisRad(final BigDecimal nisRad) {
		this.nisRad = nisRad;
	}

	public String getNumAparato() {
		return this.numAparato;
	}

	public void setNumAparato(final String numAparato) {
		this.numAparato = numAparato;
	}

	// public BigDecimal getNumBulk() {
	// return this.numBulk;
	// }
	//
	// public void setNumBulk(BigDecimal numBulk) {
	// this.numBulk = numBulk;
	// }

	public BigDecimal getNumCamp() {
		return this.numCamp;
	}

	public void setNumCamp(final BigDecimal numCamp) {
		this.numCamp = numCamp;
	}

	public String getNumOsExt() {
		return this.numOsExt;
	}

	public void setNumOsExt(final String numOsExt) {
		this.numOsExt = numOsExt;
	}

	public BigDecimal getNumPuerta() {
		return this.numPuerta;
	}

	public void setNumPuerta(final BigDecimal numPuerta) {
		this.numPuerta = numPuerta;
	}

	public BigDecimal getNumReprograma() {
		return this.numReprograma;
	}

	public void setNumReprograma(final BigDecimal numReprograma) {
		this.numReprograma = numReprograma;
	}

	public BigDecimal getNumSum() {
		return this.numSum;
	}

	public void setNumSum(final BigDecimal numSum) {
		this.numSum = numSum;
	}

	public BigDecimal getPesoOrd() {
		return this.pesoOrd;
	}

	public void setPesoOrd(final BigDecimal pesoOrd) {
		this.pesoOrd = pesoOrd;
	}

	public String getPot() {
		return this.pot;
	}

	public void setPot(final String pot) {
		this.pot = pot;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(final String programa) {
		this.programa = programa;
	}

	public String getRefDir() {
		return this.refDir;
	}

	public void setRefDir(final String refDir) {
		this.refDir = refDir;
	}

	public BigDecimal getSecNis() {
		return this.secNis;
	}

	public void setSecNis(final BigDecimal secNis) {
		this.secNis = secNis;
	}

	public String getTipOs() {
		return this.tipOs;
	}

	public void setTipOs(final String tipOs) {
		this.tipOs = tipOs;
	}

	public String getTipServ() {
		return this.tipServ;
	}

	public void setTipServ(final String tipServ) {
		this.tipServ = tipServ;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}

}