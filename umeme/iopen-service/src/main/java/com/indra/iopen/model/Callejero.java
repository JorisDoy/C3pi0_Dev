package com.indra.iopen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the CALLEJERO database table.
 *
 */
@Entity
@NamedQuery(name = "Callejero.findAll", query = "SELECT c FROM Callejero c")
public class Callejero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COD_CALLE")
	private Long codCalle;

	@Column(name = "AREA_LECT")
	private BigDecimal areaLect;

	@Column(name = "COD_AREA")
	private BigDecimal codArea;

	@Column(name = "COD_DEPTO")
	private BigDecimal codDepto;

	@Column(name = "COD_LOCAL")
	private BigDecimal codLocal;

	@Column(name = "COD_MUNIC")
	private BigDecimal codMunic;

	@Column(name = "COD_POST")
	private String codPost;

	@Column(name = "COD_POST_EXT")
	private String codPostExt;

	@Column(name = "COD_PROV")
	private BigDecimal codProv;

	@Column(name = "COD_UNICOM")
	private BigDecimal codUnicom;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Column(name = "IND_REV")
	private BigDecimal indRev;

	@Column(name = "NOM_CALLE")
	private String nomCalle;

	private String programa;

	@Column(name = "TIP_VIA")
	private String tipVia;

	private String usuario;

	public Callejero() {
	}

	public long getCodCalle() {
		return this.codCalle;
	}

	public void setCodCalle(long codCalle) {
		this.codCalle = codCalle;
	}

	public BigDecimal getAreaLect() {
		return this.areaLect;
	}

	public void setAreaLect(BigDecimal areaLect) {
		this.areaLect = areaLect;
	}

	public BigDecimal getCodArea() {
		return this.codArea;
	}

	public void setCodArea(BigDecimal codArea) {
		this.codArea = codArea;
	}

	public BigDecimal getCodDepto() {
		return this.codDepto;
	}

	public void setCodDepto(BigDecimal codDepto) {
		this.codDepto = codDepto;
	}

	public BigDecimal getCodLocal() {
		return this.codLocal;
	}

	public void setCodLocal(BigDecimal codLocal) {
		this.codLocal = codLocal;
	}

	public BigDecimal getCodMunic() {
		return this.codMunic;
	}

	public void setCodMunic(BigDecimal codMunic) {
		this.codMunic = codMunic;
	}

	public String getCodPost() {
		return this.codPost;
	}

	public void setCodPost(String codPost) {
		this.codPost = codPost;
	}

	public String getCodPostExt() {
		return this.codPostExt;
	}

	public void setCodPostExt(String codPostExt) {
		this.codPostExt = codPostExt;
	}

	public BigDecimal getCodProv() {
		return this.codProv;
	}

	public void setCodProv(BigDecimal codProv) {
		this.codProv = codProv;
	}

	public BigDecimal getCodUnicom() {
		return this.codUnicom;
	}

	public void setCodUnicom(BigDecimal codUnicom) {
		this.codUnicom = codUnicom;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getIndRev() {
		return this.indRev;
	}

	public void setIndRev(BigDecimal indRev) {
		this.indRev = indRev;
	}

	public String getNomCalle() {
		return this.nomCalle;
	}

	public void setNomCalle(String nomCalle) {
		this.nomCalle = nomCalle;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getTipVia() {
		return this.tipVia;
	}

	public void setTipVia(String tipVia) {
		this.tipVia = tipVia;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}