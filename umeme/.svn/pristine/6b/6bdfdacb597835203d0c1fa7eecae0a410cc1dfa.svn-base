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
 * The persistent class for the DEPOSITOS database table.
 *
 */
@Entity
@Table(name = "DEPOSITOS")
@NamedQuery(name = "Deposito.findAll", query = "SELECT d FROM Deposito d")
public class Deposito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_DEPOSITO")
	private Long idDeposito;

	@Column(name = "EST_DEPOSITO")
	private String estDeposito;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_COBRO")
	private Date fCobro;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_DEFIN")
	private Date fDefin;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_PROC_INIC")
	private Date fProcInic;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_PROX_CALC_INT")
	private Date fProxCalcInt;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_PROX_REVIS")
	private Date fProxRevis;

	@Column(name = "ID_CARGVAR")
	private BigDecimal idCargvar;

	@Column(name = "IMP_DEPOSITO")
	private BigDecimal impDeposito;

	@Column(name = "NIS_RAD")
	private BigDecimal nisRad;

	private String programa;

	private String usuario;

	public Deposito() {
	}

	public long getIdDeposito() {
		return this.idDeposito;
	}

	public void setIdDeposito(long idDeposito) {
		this.idDeposito = idDeposito;
	}

	public String getEstDeposito() {
		return this.estDeposito;
	}

	public void setEstDeposito(String estDeposito) {
		this.estDeposito = estDeposito;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getFCobro() {
		return this.fCobro;
	}

	public void setFCobro(Date fCobro) {
		this.fCobro = fCobro;
	}

	public Date getFDefin() {
		return this.fDefin;
	}

	public void setFDefin(Date fDefin) {
		this.fDefin = fDefin;
	}

	public Date getFProcInic() {
		return this.fProcInic;
	}

	public void setFProcInic(Date fProcInic) {
		this.fProcInic = fProcInic;
	}

	public Date getFProxCalcInt() {
		return this.fProxCalcInt;
	}

	public void setFProxCalcInt(Date fProxCalcInt) {
		this.fProxCalcInt = fProxCalcInt;
	}

	public Date getFProxRevis() {
		return this.fProxRevis;
	}

	public void setFProxRevis(Date fProxRevis) {
		this.fProxRevis = fProxRevis;
	}

	public BigDecimal getIdCargvar() {
		return this.idCargvar;
	}

	public void setIdCargvar(BigDecimal idCargvar) {
		this.idCargvar = idCargvar;
	}

	public BigDecimal getImpDeposito() {
		return this.impDeposito;
	}

	public void setImpDeposito(BigDecimal impDeposito) {
		this.impDeposito = impDeposito;
	}

	public BigDecimal getNisRad() {
		return this.nisRad;
	}

	public void setNisRad(BigDecimal nisRad) {
		this.nisRad = nisRad;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}