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
 * The persistent class for the PAYING_ACCOUNT database table.
 *
 */
@Entity
@Table(name = "PAYING_ACCOUNT")
@NamedQuery(name = "PayingAccount.findAll", query = "SELECT p FROM PayingAccount p")
public class PayingAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ACC_PAY_ID")
	@SequenceGenerator(name = "PAYING_ACCOUNT_ACCPAYID_GENERATOR", sequenceName = "ACC_PAY_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAYING_ACCOUNT_ACCPAYID_GENERATOR")
	private Long accPayId;

	@Column(name = "COD_CTA")
	private BigDecimal codCta;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_PAYING_DESDE")
	private Date fPayingDesde;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_PAYING_HASTA")
	private Date fPayingHasta;

	@Column(name = "IG_ID")
	private BigDecimal igId;

	@Column(name = "IND_EXEMPT")
	private BigDecimal indExempt;

	@Column(name = "IND_PRINC")
	private BigDecimal indPrinc;

	@Column(name = "NIS_RAD")
	private BigDecimal nisRad;

	private String programa;

	@Column(name = "SH_LIMIT")
	private BigDecimal shLimit;

	@Column(name = "SH_PERC")
	private BigDecimal shPerc;

	private String usuario;

	public PayingAccount() {
	}

	public Long getAccPayId() {
		return this.accPayId;
	}

	public void setAccPayId(final Long accPayId) {
		this.accPayId = accPayId;
	}

	public BigDecimal getCodCta() {
		return this.codCta;
	}

	public void setCodCta(final BigDecimal codCta) {
		this.codCta = codCta;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(final Date fActual) {
		this.fActual = fActual;
	}

	public Date getFPayingDesde() {
		return this.fPayingDesde;
	}

	public void setFPayingDesde(final Date fPayingDesde) {
		this.fPayingDesde = fPayingDesde;
	}

	public Date getFPayingHasta() {
		return this.fPayingHasta;
	}

	public void setFPayingHasta(final Date fPayingHasta) {
		this.fPayingHasta = fPayingHasta;
	}

	public BigDecimal getIgId() {
		return this.igId;
	}

	public void setIgId(final BigDecimal igId) {
		this.igId = igId;
	}

	public BigDecimal getIndExempt() {
		return this.indExempt;
	}

	public void setIndExempt(final BigDecimal indExempt) {
		this.indExempt = indExempt;
	}

	public BigDecimal getIndPrinc() {
		return this.indPrinc;
	}

	public void setIndPrinc(final BigDecimal indPrinc) {
		this.indPrinc = indPrinc;
	}

	public BigDecimal getNisRad() {
		return this.nisRad;
	}

	public void setNisRad(final BigDecimal nisRad) {
		this.nisRad = nisRad;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(final String programa) {
		this.programa = programa;
	}

	public BigDecimal getShLimit() {
		return this.shLimit;
	}

	public void setShLimit(final BigDecimal shLimit) {
		this.shLimit = shLimit;
	}

	public BigDecimal getShPerc() {
		return this.shPerc;
	}

	public void setShPerc(final BigDecimal shPerc) {
		this.shPerc = shPerc;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}

}