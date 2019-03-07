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
 * The persistent class for the MUNICIPIOS database table.
 *
 */
@Entity
@Table(name = "MUNICIPIOS")
@NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COD_MUNIC")
	private Long codMunic;

	@Column(name = "COD_DEPTO")
	private BigDecimal codDepto;

	@Column(name = "COD_PROV")
	private BigDecimal codProv;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Column(name = "NOM_MUNIC")
	private String nomMunic;

	private String programa;

	private String usuario;

	public Municipio() {
	}

	public long getCodMunic() {
		return this.codMunic;
	}

	public void setCodMunic(long codMunic) {
		this.codMunic = codMunic;
	}

	public BigDecimal getCodDepto() {
		return this.codDepto;
	}

	public void setCodDepto(BigDecimal codDepto) {
		this.codDepto = codDepto;
	}

	public BigDecimal getCodProv() {
		return this.codProv;
	}

	public void setCodProv(BigDecimal codProv) {
		this.codProv = codProv;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public String getNomMunic() {
		return this.nomMunic;
	}

	public void setNomMunic(String nomMunic) {
		this.nomMunic = nomMunic;
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