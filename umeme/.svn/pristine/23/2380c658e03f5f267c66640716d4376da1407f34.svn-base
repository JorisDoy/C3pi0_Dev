package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TRABPEND_RE database table.
 * 
 */
@Entity
@Table(name="TRABPEND_RE")
@NamedQuery(name="TrabpendRe.findAll", query="SELECT t FROM TrabpendRe t")
public class TrabpendRe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUM_RE")
	private long numRe;

	@Column(name="CO_MED_RCM")
	private String coMedRcm;

	@Column(name="COD_CLI")
	private BigDecimal codCli;

	@Column(name="COD_UNICOM")
	private BigDecimal codUnicom;

	@Column(name="EST_RCM")
	private String estRcm;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name="F_IRE")
	private Date fIre;

	@Temporal(TemporalType.DATE)
	@Column(name="F_UCE")
	private Date fUce;

	@Column(name="IND_AP_LVDO")
	private BigDecimal indApLvdo;

	@Column(name="MOT_RCM")
	private String motRcm;

	@Column(name="NIS_RAD")
	private BigDecimal nisRad;

	@Column(name="NUM_ACT_GEN")
	private BigDecimal numActGen;

	@Column(name="NUM_OS")
	private BigDecimal numOs;

	@Column(name="NUM_REC_RCM")
	private BigDecimal numRecRcm;

	@Column(name="NUM_SUM")
	private BigDecimal numSum;

	@Column(name="POT_FACT")
	private BigDecimal potFact;

	private String programa;

	@Column(name="SEC_NIS")
	private BigDecimal secNis;

	@Column(name="TIP_RCM")
	private String tipRcm;

	private String usuario;

	//bi-directional many-to-one association to DatosAct
	@OneToMany(mappedBy="trabpendRe")
	private List<DatosAct> datosActs;

	//bi-directional one-to-one association to DatosRecl
	@OneToOne(mappedBy="trabpendRe")
	private DatosRecl datosRecl;

	public TrabpendRe() {
	}

	public long getNumRe() {
		return this.numRe;
	}

	public void setNumRe(long numRe) {
		this.numRe = numRe;
	}

	public String getCoMedRcm() {
		return this.coMedRcm;
	}

	public void setCoMedRcm(String coMedRcm) {
		this.coMedRcm = coMedRcm;
	}

	public BigDecimal getCodCli() {
		return this.codCli;
	}

	public void setCodCli(BigDecimal codCli) {
		this.codCli = codCli;
	}

	public BigDecimal getCodUnicom() {
		return this.codUnicom;
	}

	public void setCodUnicom(BigDecimal codUnicom) {
		this.codUnicom = codUnicom;
	}

	public String getEstRcm() {
		return this.estRcm;
	}

	public void setEstRcm(String estRcm) {
		this.estRcm = estRcm;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getFIre() {
		return this.fIre;
	}

	public void setFIre(Date fIre) {
		this.fIre = fIre;
	}

	public Date getFUce() {
		return this.fUce;
	}

	public void setFUce(Date fUce) {
		this.fUce = fUce;
	}

	public BigDecimal getIndApLvdo() {
		return this.indApLvdo;
	}

	public void setIndApLvdo(BigDecimal indApLvdo) {
		this.indApLvdo = indApLvdo;
	}

	public String getMotRcm() {
		return this.motRcm;
	}

	public void setMotRcm(String motRcm) {
		this.motRcm = motRcm;
	}

	public BigDecimal getNisRad() {
		return this.nisRad;
	}

	public void setNisRad(BigDecimal nisRad) {
		this.nisRad = nisRad;
	}

	public BigDecimal getNumActGen() {
		return this.numActGen;
	}

	public void setNumActGen(BigDecimal numActGen) {
		this.numActGen = numActGen;
	}

	public BigDecimal getNumOs() {
		return this.numOs;
	}

	public void setNumOs(BigDecimal numOs) {
		this.numOs = numOs;
	}

	public BigDecimal getNumRecRcm() {
		return this.numRecRcm;
	}

	public void setNumRecRcm(BigDecimal numRecRcm) {
		this.numRecRcm = numRecRcm;
	}

	public BigDecimal getNumSum() {
		return this.numSum;
	}

	public void setNumSum(BigDecimal numSum) {
		this.numSum = numSum;
	}

	public BigDecimal getPotFact() {
		return this.potFact;
	}

	public void setPotFact(BigDecimal potFact) {
		this.potFact = potFact;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public BigDecimal getSecNis() {
		return this.secNis;
	}

	public void setSecNis(BigDecimal secNis) {
		this.secNis = secNis;
	}

	public String getTipRcm() {
		return this.tipRcm;
	}

	public void setTipRcm(String tipRcm) {
		this.tipRcm = tipRcm;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<DatosAct> getDatosActs() {
		return this.datosActs;
	}

	public void setDatosActs(List<DatosAct> datosActs) {
		this.datosActs = datosActs;
	}

	public DatosAct addDatosAct(DatosAct datosAct) {
		getDatosActs().add(datosAct);
		datosAct.setTrabpendRe(this);

		return datosAct;
	}

	public DatosAct removeDatosAct(DatosAct datosAct) {
		getDatosActs().remove(datosAct);
		datosAct.setTrabpendRe(null);

		return datosAct;
	}

	public DatosRecl getDatosRecl() {
		return this.datosRecl;
	}

	public void setDatosRecl(DatosRecl datosRecl) {
		this.datosRecl = datosRecl;
	}

}