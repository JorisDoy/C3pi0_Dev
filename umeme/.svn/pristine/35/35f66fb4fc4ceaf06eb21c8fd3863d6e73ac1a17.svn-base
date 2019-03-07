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
 * The persistent class for the GR_CONSUMO_CONTRATADO database table.
 *
 */
@Entity
@Table(name = "GR_CONSUMO_CONTRATADO")
@NamedQuery(name = "GrConsumoContratado.findAll", query = "SELECT g FROM GrConsumoContratado g")
public class GrConsumoContratado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_GR_CONSUMO_CONTRATADO")
	@SequenceGenerator(name = "GR_CONSUMO_CONTRATADO_IDGRCONSUMOCONTRATADO_GENERATOR", sequenceName = "ID_GR_CONSUMO_CONTRATADO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GR_CONSUMO_CONTRATADO_IDGRCONSUMOCONTRATADO_GENERATOR")
	// @GeneratedValue(
	// strategy = GenerationType.AUTO)
	private Long idGrConsumoContratado;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ALTA")
	private Date fAlta;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ALTA_REAL")
	private Date fAltaReal;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_BAJA")
	private Date fBaja;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_BAJA_REAL")
	private Date fBajaReal;

	@Column(name = "ID_ESTACIONALIDAD")
	private BigDecimal idEstacionalidad;

	@Column(name = "ID_LOADSHAPE")
	private BigDecimal idLoadshape;

	@Column(name = "NIS_RAD")
	private BigDecimal nisRad;

	@Column(name = "NUM_SUM")
	private BigDecimal numSum;

	private String programa;

	private String usuario;

	public GrConsumoContratado() {
	}

	public Long getIdGrConsumoContratado() {
		return idGrConsumoContratado;
	}

	public void setIdGrConsumoContratado(final Long idGrConsumoContratado) {
		this.idGrConsumoContratado = idGrConsumoContratado;
	}

	public Date getFActual() {
		return fActual;
	}

	public void setFActual(final Date fActual) {
		this.fActual = fActual;
	}

	public Date getFAlta() {
		return fAlta;
	}

	public void setFAlta(final Date fAlta) {
		this.fAlta = fAlta;
	}

	public Date getFAltaReal() {
		return fAltaReal;
	}

	public void setFAltaReal(final Date fAltaReal) {
		this.fAltaReal = fAltaReal;
	}

	public Date getFBaja() {
		return fBaja;
	}

	public void setFBaja(final Date fBaja) {
		this.fBaja = fBaja;
	}

	public Date getFBajaReal() {
		return fBajaReal;
	}

	public void setFBajaReal(final Date fBajaReal) {
		this.fBajaReal = fBajaReal;
	}

	public BigDecimal getIdEstacionalidad() {
		return idEstacionalidad;
	}

	public void setIdEstacionalidad(final BigDecimal idEstacionalidad) {
		this.idEstacionalidad = idEstacionalidad;
	}

	public BigDecimal getIdLoadshape() {
		return idLoadshape;
	}

	public void setIdLoadshape(final BigDecimal idLoadshape) {
		this.idLoadshape = idLoadshape;
	}

	public BigDecimal getNisRad() {
		return nisRad;
	}

	public void setNisRad(final BigDecimal nisRad) {
		this.nisRad = nisRad;
	}

	public BigDecimal getNumSum() {
		return numSum;
	}

	public void setNumSum(final BigDecimal numSum) {
		this.numSum = numSum;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(final String programa) {
		this.programa = programa;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}

}