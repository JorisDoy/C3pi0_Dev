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
 * The persistent class for the SUMCON_RETAIL_ACCESS database table.
 *
 */
@Entity
@Table(name = "SUMCON_RETAIL_ACCESS")
@NamedQuery(name = "SumconRetailAccess.findAll", query = "SELECT s FROM SumconRetailAccess s")
public class SumconRetailAccess implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SRA_ID")
	@SequenceGenerator(name = "SUMCON_RETAIL_ACCESS_SRAID_GENERATOR", sequenceName = "SRA_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUMCON_RETAIL_ACCESS_SRAID_GENERATOR")
	// @GeneratedValue(
	// strategy = GenerationType.AUTO)
	private Long sraId;

	@Column(name = "COD_EMPRESA_ESP")
	private BigDecimal codEmpresaEsp;

	@Column(name = "COD_EMPRESA_MDMA")
	private BigDecimal codEmpresaMdma;

	@Column(name = "COD_EMPRESA_MSP")
	private BigDecimal codEmpresaMsp;

	@Column(name = "COD_EMPRESA_UDC")
	private BigDecimal codEmpresaUdc;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_MOD")
	private Date fechaMod;

	@Column(name = "NIS_RAD")
	private BigDecimal nisRad;

	@Column(name = "NIS_RAD_CONSOL")
	private BigDecimal nisRadConsol;

	@Column(name = "NUM_SUM")
	private BigDecimal numSum;

	private String programa;

	@Column(name = "SEC_NIS")
	private BigDecimal secNis;

	@Column(name = "TIP_CONSOLID")
	private String tipConsolid;

	@Column(name = "TIP_REQUEST")
	private String tipRequest;

	private String usuario;

	public SumconRetailAccess() {
	}

	public Long getSraId() {
		return this.sraId;
	}

	public void setSraId(final Long sraId) {
		this.sraId = sraId;
	}

	public BigDecimal getCodEmpresaEsp() {
		return this.codEmpresaEsp;
	}

	public void setCodEmpresaEsp(final BigDecimal codEmpresaEsp) {
		this.codEmpresaEsp = codEmpresaEsp;
	}

	public BigDecimal getCodEmpresaMdma() {
		return this.codEmpresaMdma;
	}

	public void setCodEmpresaMdma(final BigDecimal codEmpresaMdma) {
		this.codEmpresaMdma = codEmpresaMdma;
	}

	public BigDecimal getCodEmpresaMsp() {
		return this.codEmpresaMsp;
	}

	public void setCodEmpresaMsp(final BigDecimal codEmpresaMsp) {
		this.codEmpresaMsp = codEmpresaMsp;
	}

	public BigDecimal getCodEmpresaUdc() {
		return this.codEmpresaUdc;
	}

	public void setCodEmpresaUdc(final BigDecimal codEmpresaUdc) {
		this.codEmpresaUdc = codEmpresaUdc;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(final Date fActual) {
		this.fActual = fActual;
	}

	public Date getFechaMod() {
		return this.fechaMod;
	}

	public void setFechaMod(final Date fechaMod) {
		this.fechaMod = fechaMod;
	}

	public BigDecimal getNisRad() {
		return this.nisRad;
	}

	public void setNisRad(final BigDecimal nisRad) {
		this.nisRad = nisRad;
	}

	public BigDecimal getNisRadConsol() {
		return this.nisRadConsol;
	}

	public void setNisRadConsol(final BigDecimal nisRadConsol) {
		this.nisRadConsol = nisRadConsol;
	}

	public BigDecimal getNumSum() {
		return this.numSum;
	}

	public void setNumSum(final BigDecimal numSum) {
		this.numSum = numSum;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(final String programa) {
		this.programa = programa;
	}

	public BigDecimal getSecNis() {
		return this.secNis;
	}

	public void setSecNis(final BigDecimal secNis) {
		this.secNis = secNis;
	}

	public String getTipConsolid() {
		return this.tipConsolid;
	}

	public void setTipConsolid(final String tipConsolid) {
		this.tipConsolid = tipConsolid;
	}

	public String getTipRequest() {
		return this.tipRequest;
	}

	public void setTipRequest(final String tipRequest) {
		this.tipRequest = tipRequest;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}

}