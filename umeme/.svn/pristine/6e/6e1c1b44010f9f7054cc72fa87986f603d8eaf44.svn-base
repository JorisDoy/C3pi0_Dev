package com.indra.iopen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the APMEDIDA_CO database table.
 *
 */
@Entity
@Table(name = "APMEDIDA_CO")
@NamedQuery(name = "ApmedidaCo.findAll", query = "SELECT a FROM ApmedidaCo a")
public class ApmedidaCo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	// @SequenceGenerator(name = "APMEDIDA_CO_IDREG_GENERATOR", sequenceName =
	// "ID_AP_CO")
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "APMEDIDA_CO_IDREG_GENERATOR")
	@Column(name = "ID_REG")
	private Long idReg;

	@Column(name = "COEF_PER")
	private BigDecimal coefPer;

	private BigDecimal csmo;

	@Column(name = "CTE_APA")
	private BigDecimal cteApa;

	@Column(name = "CTE_CSMO")
	private BigDecimal cteCsmo;

	@Column(name = "DIF_LECT")
	private BigDecimal difLect;

	@Column(name = "EST_CSMO")
	private String estCsmo;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_CSMO_DESDE")
	private Date fCsmoDesde;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_LECT")
	private Date fLect;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_MOD_LECT")
	private Date fModLect;

	@Column(name = "GRUP_PER")
	private BigDecimal grupPer;

	@Column(name = "ID_APA")
	private BigDecimal idApa;

	@Column(name = "IND_LECT")
	private BigDecimal indLect;

	private BigDecimal lect;

	@Column(name = "NUM_RUE")
	private BigDecimal numRue;

	@Column(name = "NUM_SUM")
	private BigDecimal numSum;

	private String programa;

	@Column(name = "TIP_CSMO")
	private String tipCsmo;

	@Column(name = "TIP_LECT")
	private String tipLect;

	private String usuario;

	public ApmedidaCo() {
	}

	public long getIdReg() {
		return idReg;
	}

	public void setIdReg(long idReg) {
		this.idReg = idReg;
	}

	public BigDecimal getCoefPer() {
		return coefPer;
	}

	public void setCoefPer(BigDecimal coefPer) {
		this.coefPer = coefPer;
	}

	public BigDecimal getCsmo() {
		return csmo;
	}

	public void setCsmo(BigDecimal csmo) {
		this.csmo = csmo;
	}

	public BigDecimal getCteApa() {
		return cteApa;
	}

	public void setCteApa(BigDecimal cteApa) {
		this.cteApa = cteApa;
	}

	public BigDecimal getCteCsmo() {
		return cteCsmo;
	}

	public void setCteCsmo(BigDecimal cteCsmo) {
		this.cteCsmo = cteCsmo;
	}

	public BigDecimal getDifLect() {
		return difLect;
	}

	public void setDifLect(BigDecimal difLect) {
		this.difLect = difLect;
	}

	public String getEstCsmo() {
		return estCsmo;
	}

	public void setEstCsmo(String estCsmo) {
		this.estCsmo = estCsmo;
	}

	public Date getFActual() {
		return fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getFCsmoDesde() {
		return fCsmoDesde;
	}

	public void setFCsmoDesde(Date fCsmoDesde) {
		this.fCsmoDesde = fCsmoDesde;
	}

	public Date getFLect() {
		return fLect;
	}

	public void setFLect(Date fLect) {
		this.fLect = fLect;
	}

	public Date getFModLect() {
		return fModLect;
	}

	public void setFModLect(Date fModLect) {
		this.fModLect = fModLect;
	}

	public BigDecimal getGrupPer() {
		return grupPer;
	}

	public void setGrupPer(BigDecimal grupPer) {
		this.grupPer = grupPer;
	}

	public BigDecimal getIdApa() {
		return idApa;
	}

	public void setIdApa(BigDecimal idApa) {
		this.idApa = idApa;
	}

	public BigDecimal getIndLect() {
		return indLect;
	}

	public void setIndLect(BigDecimal indLect) {
		this.indLect = indLect;
	}

	public BigDecimal getLect() {
		return lect;
	}

	public void setLect(BigDecimal lect) {
		this.lect = lect;
	}

	public BigDecimal getNumRue() {
		return numRue;
	}

	public void setNumRue(BigDecimal numRue) {
		this.numRue = numRue;
	}

	public BigDecimal getNumSum() {
		return numSum;
	}

	public void setNumSum(BigDecimal numSum) {
		this.numSum = numSum;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getTipCsmo() {
		return tipCsmo;
	}

	public void setTipCsmo(String tipCsmo) {
		this.tipCsmo = tipCsmo;
	}

	public String getTipLect() {
		return tipLect;
	}

	public void setTipLect(String tipLect) {
		this.tipLect = tipLect;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}