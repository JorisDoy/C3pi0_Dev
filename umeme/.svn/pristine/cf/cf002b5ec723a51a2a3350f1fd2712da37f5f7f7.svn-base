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
 * The persistent class for the TRABPEND_AF database table.
 *
 */
@Entity
@Table(name = "TRABPEND_AF")
@NamedQuery(name = "TrabpendAf.findAll", query = "SELECT t FROM TrabpendAf t")
public class TrabpendAf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TRABPEND_AF_NUMAF_GENERATOR", sequenceName = "AN_GENERATED_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRABPEND_AF_NUMAF_GENERATOR")
	// @GeneratedValue(
	// strategy = GenerationType.AUTO)
	@Column(name = "NUM_AF")
	private Long numAf;

	@Column(name = "CO_NIV_ANOM")
	private String coNivAnom;

	@Column(name = "CSMO_FACT")
	private String csmoFact;

	@Column(name = "EST_AF")
	private String estAf;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_FACT")
	private Date fFact;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_GEN")
	private Date fGen;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_UCE")
	private Date fUce;

	@Column(name = "IMP_FACT")
	private BigDecimal impFact;

	@Column(name = "IND_GEN_OS")
	private BigDecimal indGenOs;

	@Column(name = "IND_SUMCON")
	private BigDecimal indSumcon;

	@Column(name = "NIS_RAD")
	private BigDecimal nisRad;

	@Column(name = "NUM_SUM")
	private BigDecimal numSum;

	@Column(name = "POT_FACT")
	private String potFact;

	private String programa;

	@Column(name = "SEC_NIS")
	private BigDecimal secNis;

	@Column(name = "TIP_FACT")
	private String tipFact;

	private String usuario;

	public TrabpendAf() {
	}

	public long getNumAf() {
		return this.numAf;
	}

	public void setNumAf(long numAf) {
		this.numAf = numAf;
	}

	public String getCoNivAnom() {
		return this.coNivAnom;
	}

	public void setCoNivAnom(String coNivAnom) {
		this.coNivAnom = coNivAnom;
	}

	public String getCsmoFact() {
		return this.csmoFact;
	}

	public void setCsmoFact(String csmoFact) {
		this.csmoFact = csmoFact;
	}

	public String getEstAf() {
		return this.estAf;
	}

	public void setEstAf(String estAf) {
		this.estAf = estAf;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getFFact() {
		return this.fFact;
	}

	public void setFFact(Date fFact) {
		this.fFact = fFact;
	}

	public Date getFGen() {
		return this.fGen;
	}

	public void setFGen(Date fGen) {
		this.fGen = fGen;
	}

	public Date getFUce() {
		return this.fUce;
	}

	public void setFUce(Date fUce) {
		this.fUce = fUce;
	}

	public BigDecimal getImpFact() {
		return this.impFact;
	}

	public void setImpFact(BigDecimal impFact) {
		this.impFact = impFact;
	}

	public BigDecimal getIndGenOs() {
		return this.indGenOs;
	}

	public void setIndGenOs(BigDecimal indGenOs) {
		this.indGenOs = indGenOs;
	}

	public BigDecimal getIndSumcon() {
		return this.indSumcon;
	}

	public void setIndSumcon(BigDecimal indSumcon) {
		this.indSumcon = indSumcon;
	}

	public BigDecimal getNisRad() {
		return this.nisRad;
	}

	public void setNisRad(BigDecimal nisRad) {
		this.nisRad = nisRad;
	}

	public BigDecimal getNumSum() {
		return this.numSum;
	}

	public void setNumSum(BigDecimal numSum) {
		this.numSum = numSum;
	}

	public String getPotFact() {
		return this.potFact;
	}

	public void setPotFact(String potFact) {
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

	public String getTipFact() {
		return this.tipFact;
	}

	public void setTipFact(String tipFact) {
		this.tipFact = tipFact;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}