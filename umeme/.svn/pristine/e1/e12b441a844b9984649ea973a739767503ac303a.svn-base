package com.indra.iopen.model.ims;

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
 * The persistent class for the GI_T_TIP_AVISO database table.
 *
 */
@Entity
@Table(name = "GI_T_TIP_AVISO")
@NamedQuery(name = "GiTTipAviso.findAll", query = "SELECT g FROM GiTTipAviso g")
public class GiTTipAviso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TIP_AVISO")
	private long tipAviso;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "H_ACTUAL")
	private Date hActual;

	@Column(name = "IND_ASSISTANCE")
	private BigDecimal indAssistance;

	@Column(name = "IND_NORMAL")
	private BigDecimal indNormal;

	@Column(name = "IND_PELIGRO")
	private BigDecimal indPeligro;

	@Column(name = "IND_QUALITY")
	private BigDecimal indQuality;

	private String programa;

	private String usuario;

	public GiTTipAviso() {
	}

	public long getTipAviso() {
		return this.tipAviso;
	}

	public void setTipAviso(long tipAviso) {
		this.tipAviso = tipAviso;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getHActual() {
		return this.hActual;
	}

	public void setHActual(Date hActual) {
		this.hActual = hActual;
	}

	public BigDecimal getIndAssistance() {
		return this.indAssistance;
	}

	public void setIndAssistance(BigDecimal indAssistance) {
		this.indAssistance = indAssistance;
	}

	public BigDecimal getIndNormal() {
		return this.indNormal;
	}

	public void setIndNormal(BigDecimal indNormal) {
		this.indNormal = indNormal;
	}

	public BigDecimal getIndPeligro() {
		return this.indPeligro;
	}

	public void setIndPeligro(BigDecimal indPeligro) {
		this.indPeligro = indPeligro;
	}

	public BigDecimal getIndQuality() {
		return this.indQuality;
	}

	public void setIndQuality(BigDecimal indQuality) {
		this.indQuality = indQuality;
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