package com.indra.iopen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the PERSONAL database table.
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p"),
		@NamedQuery(name = "Personal.findCodUnicom", query = "SELECT p FROM Personal p WHERE p.codUnicom = :codUnicom") })
@Table(name = "PERSONAL")
public class Personal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COD_EMP")
	private Long codEmp;

	@Column(name = "APE1_EMP")
	private String ape1Emp;

	@Column(name = "APE2_EMP")
	private String ape2Emp;

	@Column(name = "COD_UNICOM")
	private BigDecimal codUnicom;

	@Column(name = "EST_EMP")
	private String estEmp;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ALTA")
	private Date fAlta;

	@Column(name = "NOM_EMP")
	private String nomEmp;

	@Column(name = "PESO_EMP")
	private BigDecimal pesoEmp;

	@Column(name = "PROGRAMA")
	private String programa;

	@Column(name = "TIP_EMP")
	private String tipEmp;

	@Column(name = "USUARIO")
	private String usuario;

	public Personal() {
	}

	public long getCodEmp() {
		return this.codEmp;
	}

	public void setCodEmp(long codEmp) {
		this.codEmp = codEmp;
	}

	public String getApe1Emp() {
		return this.ape1Emp;
	}

	public void setApe1Emp(String ape1Emp) {
		this.ape1Emp = ape1Emp;
	}

	public String getApe2Emp() {
		return this.ape2Emp;
	}

	public void setApe2Emp(String ape2Emp) {
		this.ape2Emp = ape2Emp;
	}

	public BigDecimal getCodUnicom() {
		return this.codUnicom;
	}

	public void setCodUnicom(BigDecimal codUnicom) {
		this.codUnicom = codUnicom;
	}

	public String getEstEmp() {
		return this.estEmp;
	}

	public void setEstEmp(String estEmp) {
		this.estEmp = estEmp;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getFAlta() {
		return this.fAlta;
	}

	public void setFAlta(Date fAlta) {
		this.fAlta = fAlta;
	}

	public String getNomEmp() {
		return this.nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public BigDecimal getPesoEmp() {
		return this.pesoEmp;
	}

	public void setPesoEmp(BigDecimal pesoEmp) {
		this.pesoEmp = pesoEmp;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getTipEmp() {
		return this.tipEmp;
	}

	public void setTipEmp(String tipEmp) {
		this.tipEmp = tipEmp;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}