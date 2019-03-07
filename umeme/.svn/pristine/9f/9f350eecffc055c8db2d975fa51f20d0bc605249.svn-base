package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the APARATOS database table.
 * 
 */
@Entity
@Table(name="APARATOS")
@NamedQuery(name="Aparato.findAll", query="SELECT a FROM Aparato a")
public class Aparato implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AparatoPK id;

	@Column(name="CO_MODELO")
	private String coModelo;

	@Column(name="CO_PROP_APA")
	private String coPropApa;

	@Column(name="COD_ALMACEN")
	private BigDecimal codAlmacen;

	@Column(name="EST_APA")
	private String estApa;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name="F_FABRIC")
	private Date fFabric;

	@Temporal(TemporalType.DATE)
	@Column(name="F_PROX_CALIBRACION")
	private Date fProxCalibracion;

	@Temporal(TemporalType.DATE)
	@Column(name="F_PROX_VERIFICACION")
	private Date fProxVerificacion;

	private String lugar;

	@Column(name="NIF_APA")
	private BigDecimal nifApa;

	@Column(name="NUM_APA_ORIG")
	private String numApaOrig;

	@Column(name="NUM_LOTE")
	private String numLote;

	@Column(name="NUM_PRECIN")
	private String numPrecin;

	@Column(name="NUM_SUM")
	private BigDecimal numSum;

	private String observaciones;

	private String programa;

	@Column(name="SEC_PM")
	private BigDecimal secPm;

	@Column(name="TIP_APA")
	private String tipApa;

	private String usuario;

	public Aparato() {
	}

	public AparatoPK getId() {
		return this.id;
	}

	public void setId(AparatoPK id) {
		this.id = id;
	}

	public String getCoModelo() {
		return this.coModelo;
	}

	public void setCoModelo(String coModelo) {
		this.coModelo = coModelo;
	}

	public String getCoPropApa() {
		return this.coPropApa;
	}

	public void setCoPropApa(String coPropApa) {
		this.coPropApa = coPropApa;
	}

	public BigDecimal getCodAlmacen() {
		return this.codAlmacen;
	}

	public void setCodAlmacen(BigDecimal codAlmacen) {
		this.codAlmacen = codAlmacen;
	}

	public String getEstApa() {
		return this.estApa;
	}

	public void setEstApa(String estApa) {
		this.estApa = estApa;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getFFabric() {
		return this.fFabric;
	}

	public void setFFabric(Date fFabric) {
		this.fFabric = fFabric;
	}

	public Date getFProxCalibracion() {
		return this.fProxCalibracion;
	}

	public void setFProxCalibracion(Date fProxCalibracion) {
		this.fProxCalibracion = fProxCalibracion;
	}

	public Date getFProxVerificacion() {
		return this.fProxVerificacion;
	}

	public void setFProxVerificacion(Date fProxVerificacion) {
		this.fProxVerificacion = fProxVerificacion;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public BigDecimal getNifApa() {
		return this.nifApa;
	}

	public void setNifApa(BigDecimal nifApa) {
		this.nifApa = nifApa;
	}

	public String getNumApaOrig() {
		return this.numApaOrig;
	}

	public void setNumApaOrig(String numApaOrig) {
		this.numApaOrig = numApaOrig;
	}

	public String getNumLote() {
		return this.numLote;
	}

	public void setNumLote(String numLote) {
		this.numLote = numLote;
	}

	public String getNumPrecin() {
		return this.numPrecin;
	}

	public void setNumPrecin(String numPrecin) {
		this.numPrecin = numPrecin;
	}

	public BigDecimal getNumSum() {
		return this.numSum;
	}

	public void setNumSum(BigDecimal numSum) {
		this.numSum = numSum;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public BigDecimal getSecPm() {
		return this.secPm;
	}

	public void setSecPm(BigDecimal secPm) {
		this.secPm = secPm;
	}

	public String getTipApa() {
		return this.tipApa;
	}

	public void setTipApa(String tipApa) {
		this.tipApa = tipApa;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}