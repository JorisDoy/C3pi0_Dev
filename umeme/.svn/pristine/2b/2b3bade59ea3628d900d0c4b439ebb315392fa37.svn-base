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
@Table(name="DEPTOS")
public class Depto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_DEPTO")
	private BigDecimal codDepto;
	
	@Column(name="COD_PROV")
	private BigDecimal codProv;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="NOM_DEPTO")
	private String nomDepto;

	private String programa;

	private String usuario;

	public Depto() {
		
	}

	public BigDecimal getCodDepto() {
		return codDepto;
	}

	public void setCodDepto(BigDecimal codDepto) {
		this.codDepto = codDepto;
	}

	public BigDecimal getCodProv() {
		return codProv;
	}

	public void setCodProv(BigDecimal codProv) {
		this.codProv = codProv;
	}

	public Date getfActual() {
		return fActual;
	}

	public void setfActual(Date fActual) {
		this.fActual = fActual;
	}

	public String getNomDepto() {
		return nomDepto;
	}

	public void setNomDepto(String nomDepto) {
		this.nomDepto = nomDepto;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	

}