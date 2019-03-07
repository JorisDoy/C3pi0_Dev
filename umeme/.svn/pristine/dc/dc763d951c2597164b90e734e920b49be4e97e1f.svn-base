package com.indra.iopen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * The persistent class for the DIRECCION_CTA database table.
 *
 */
@Entity
@Table(name = "DIRECCION_CTA")
@NamedQuery(name = "DireccionCta.findAll", query = "SELECT d FROM DireccionCta d")
public class DireccionCta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DIRECCION_CTA_CODDIRECCION_GENERATOR", sequenceName = "COD_DIRECCION_CTA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIRECCION_CTA_CODDIRECCION_GENERATOR")
	// @GeneratedValue(
	// strategy = GenerationType.AUTO)
	@Column(name = "COD_DIRECCION")
	private long codDireccion;

	@Column(name = "CGV_CTA")
	private String cgvCta;

	@Column(name = "COD_CTA")
	private BigDecimal codCta;

	@Column(name = "CONDICION_VALOR")
	private String condicionValor;

	private String datos;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_FIN_VIGENCIA")
	private Date fFinVigencia;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_INICIO_VIGENCIA")
	private Date fInicioVigencia;

	@Column(name = "IND_ADDRESS_ACCOUNT_HOLDER")
	private BigDecimal indAddressAccountHolder;

	private BigDecimal nif;

	private BigDecimal prioridad;

	private String programa;

	@Column(name = "TIP_DIRECCION")
	private String tipDireccion;

	@Column(name = "TITULAR_DIRECCION")
	private String titularDireccion;

	private String usuario;

	public DireccionCta() {

		try {
			this.usuario = "IOPEN";
			this.programa = "IOPEN";
			this.cgvCta = " ";
			this.condicionValor = " ";
			this.fActual = new Date();
			this.fInicioVigencia = new SimpleDateFormat("yyyyMMdd").parse("20000101");
			this.fFinVigencia = new SimpleDateFormat("yyyyMMdd").parse("20001231");
			this.indAddressAccountHolder = new BigDecimal(0);
			this.titularDireccion = " ";
		} catch (final ParseException e) {

			e.printStackTrace();
		}
	}

	public long getCodDireccion() {
		return this.codDireccion;
	}

	public void setCodDireccion(final long codDireccion) {
		this.codDireccion = codDireccion;
	}

	public String getCgvCta() {
		return this.cgvCta;
	}

	public void setCgvCta(final String cgvCta) {
		this.cgvCta = cgvCta;
	}

	public BigDecimal getCodCta() {
		return this.codCta;
	}

	public void setCodCta(final BigDecimal codCta) {
		this.codCta = codCta;
	}

	public String getCondicionValor() {
		return this.condicionValor;
	}

	public void setCondicionValor(final String condicionValor) {
		this.condicionValor = condicionValor;
	}

	public String getDatos() {
		return this.datos;
	}

	public void setDatos(final String datos) {
		this.datos = datos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(final Date fActual) {
		this.fActual = fActual;
	}

	public Date getFFinVigencia() {
		return this.fFinVigencia;
	}

	public void setFFinVigencia(final Date fFinVigencia) {
		this.fFinVigencia = fFinVigencia;
	}

	public Date getFInicioVigencia() {
		return this.fInicioVigencia;
	}

	public void setFInicioVigencia(final Date fInicioVigencia) {
		this.fInicioVigencia = fInicioVigencia;
	}

	public BigDecimal getIndAddressAccountHolder() {
		return this.indAddressAccountHolder;
	}

	public void setIndAddressAccountHolder(final BigDecimal indAddressAccountHolder) {
		this.indAddressAccountHolder = indAddressAccountHolder;
	}

	public BigDecimal getNif() {
		return this.nif;
	}

	public void setNif(final BigDecimal nif) {
		this.nif = nif;
	}

	public BigDecimal getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(final BigDecimal prioridad) {
		this.prioridad = prioridad;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(final String programa) {
		this.programa = programa;
	}

	public String getTipDireccion() {
		return this.tipDireccion;
	}

	public void setTipDireccion(final String tipDireccion) {
		this.tipDireccion = tipDireccion;
	}

	public String getTitularDireccion() {
		return this.titularDireccion;
	}

	public void setTitularDireccion(final String titularDireccion) {
		this.titularDireccion = titularDireccion;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}

}