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
 * The persistent class for the LOCALIDADES database table.
 *
 */
@Entity
@Table(name = "LOCALIDADES")
@NamedQuery(name = "Localidade.findAll", query = "SELECT l FROM Localidade l")
public class Localidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COD_LOCAL")
	private Long codLocal;

	@Column(name = "AREA_EJEC")
	private BigDecimal areaEjec;

	@Column(name = "COD_DEPTO")
	private BigDecimal codDepto;

	@Column(name = "COD_MUNIC")
	private BigDecimal codMunic;

	@Column(name = "COD_PROV")
	private BigDecimal codProv;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Column(name = "NOM_LOCAL")
	private String nomLocal;

	private String programa;

	@Temporal(TemporalType.DATE)
	@Column(name = "USR_DATETIME1")
	private Date usrDatetime1;

	@Temporal(TemporalType.DATE)
	@Column(name = "USR_DATETIME2")
	private Date usrDatetime2;

	@Column(name = "USR_NUMBER1")
	private BigDecimal usrNumber1;

	@Column(name = "USR_NUMBER2")
	private BigDecimal usrNumber2;

	@Column(name = "USR_NUMBER3")
	private BigDecimal usrNumber3;

	@Column(name = "USR_VARCHAR1")
	private String usrVarchar1;

	@Column(name = "USR_VARCHAR2")
	private String usrVarchar2;

	@Column(name = "USR_VARCHAR3")
	private String usrVarchar3;

	private String usuario;

	public Localidade() {
	}

	public long getCodLocal() {
		return this.codLocal;
	}

	public void setCodLocal(long codLocal) {
		this.codLocal = codLocal;
	}

	public BigDecimal getAreaEjec() {
		return this.areaEjec;
	}

	public void setAreaEjec(BigDecimal areaEjec) {
		this.areaEjec = areaEjec;
	}

	public BigDecimal getCodDepto() {
		return this.codDepto;
	}

	public void setCodDepto(BigDecimal codDepto) {
		this.codDepto = codDepto;
	}

	public BigDecimal getCodMunic() {
		return this.codMunic;
	}

	public void setCodMunic(BigDecimal codMunic) {
		this.codMunic = codMunic;
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

	public String getNomLocal() {
		return this.nomLocal;
	}

	public void setNomLocal(String nomLocal) {
		this.nomLocal = nomLocal;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public Date getUsrDatetime1() {
		return this.usrDatetime1;
	}

	public void setUsrDatetime1(Date usrDatetime1) {
		this.usrDatetime1 = usrDatetime1;
	}

	public Date getUsrDatetime2() {
		return this.usrDatetime2;
	}

	public void setUsrDatetime2(Date usrDatetime2) {
		this.usrDatetime2 = usrDatetime2;
	}

	public BigDecimal getUsrNumber1() {
		return this.usrNumber1;
	}

	public void setUsrNumber1(BigDecimal usrNumber1) {
		this.usrNumber1 = usrNumber1;
	}

	public BigDecimal getUsrNumber2() {
		return this.usrNumber2;
	}

	public void setUsrNumber2(BigDecimal usrNumber2) {
		this.usrNumber2 = usrNumber2;
	}

	public BigDecimal getUsrNumber3() {
		return this.usrNumber3;
	}

	public void setUsrNumber3(BigDecimal usrNumber3) {
		this.usrNumber3 = usrNumber3;
	}

	public String getUsrVarchar1() {
		return this.usrVarchar1;
	}

	public void setUsrVarchar1(String usrVarchar1) {
		this.usrVarchar1 = usrVarchar1;
	}

	public String getUsrVarchar2() {
		return this.usrVarchar2;
	}

	public void setUsrVarchar2(String usrVarchar2) {
		this.usrVarchar2 = usrVarchar2;
	}

	public String getUsrVarchar3() {
		return this.usrVarchar3;
	}

	public void setUsrVarchar3(String usrVarchar3) {
		this.usrVarchar3 = usrVarchar3;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}