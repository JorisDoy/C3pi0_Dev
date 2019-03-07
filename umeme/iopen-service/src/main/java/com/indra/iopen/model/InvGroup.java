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
 * The persistent class for the INV_GROUP database table.
 *
 */
@Entity
@Table(name = "INV_GROUP")
@NamedQuery(name = "InvGroup.findAll", query = "SELECT i FROM InvGroup i")
public class InvGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "INV_GROUP_IGID_GENERATOR", sequenceName = "IG_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INV_GROUP_IGID_GENERATOR")
	// @GeneratedValue(
	// strategy = GenerationType.AUTO)
	@Column(name = "IG_ID")
	private long igId;

	@Column(name = "COD_CTA")
	private BigDecimal codCta;

	@Column(name = "DESC_IG")
	private String descIg;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_IG")
	private Date fIg;

	@Column(name = "ID_TIP_IMAGEN")
	private BigDecimal idTipImagen;

	@Column(name = "IG_SIZE")
	private BigDecimal igSize;

	private String programa;

	private String usuario;

	public InvGroup() {
		this.fActual = new Date();
		this.usuario = "IOPEN";
		this.programa = "IOPEN";
	}

	public BigDecimal getCodCta() {
		return this.codCta;
	}

	public String getDescIg() {
		return this.descIg;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public Date getFIg() {
		return this.fIg;
	}

	public BigDecimal getIdTipImagen() {
		return this.idTipImagen;
	}

	public long getIgId() {
		return this.igId;
	}

	public BigDecimal getIgSize() {
		return this.igSize;
	}

	public String getPrograma() {
		return this.programa;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setCodCta(final BigDecimal codCta) {
		this.codCta = codCta;
	}

	public void setDescIg(final String descIg) {
		this.descIg = descIg;
	}

	public void setFActual(final Date fActual) {
		this.fActual = fActual;
	}

	public void setFIg(final Date fIg) {
		this.fIg = fIg;
	}

	public void setIdTipImagen(final BigDecimal idTipImagen) {
		this.idTipImagen = idTipImagen;
	}

	public void setIgId(final long igId) {
		this.igId = igId;
	}

	public void setIgSize(final BigDecimal igSize) {
		this.igSize = igSize;
	}

	public void setPrograma(final String programa) {
		this.programa = programa;
	}

	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}

}