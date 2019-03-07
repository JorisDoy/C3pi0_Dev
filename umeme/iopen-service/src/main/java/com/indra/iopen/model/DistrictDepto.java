package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the DISTRICT_DEPTOS database table.
 * 
 */
@Entity
@Table(name="DISTRICT_DEPTOS")
@NamedQuery(name="DistrictDepto.findAll", query="SELECT d FROM DistrictDepto d")
public class DistrictDepto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_DISTRICT")
	private long codDistrict;

	@Column(name="COD_DEPTO")
	private BigDecimal codDepto;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="NOM_DISTRICT")
	private String nomDistrict;

	private String programa;

	private String usuario;

	public DistrictDepto() {
	}

	public long getCodDistrict() {
		return this.codDistrict;
	}

	public void setCodDistrict(long codDistrict) {
		this.codDistrict = codDistrict;
	}

	public BigDecimal getCodDepto() {
		return this.codDepto;
	}

	public void setCodDepto(BigDecimal codDepto) {
		this.codDepto = codDepto;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public String getNomDistrict() {
		return this.nomDistrict;
	}

	public void setNomDistrict(String nomDistrict) {
		this.nomDistrict = nomDistrict;
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