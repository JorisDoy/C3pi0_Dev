package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MTARIFAS database table.
 * 
 */
@Entity
@Table(name="MTARIFAS")
@NamedQuery(name="Mtarifa.findAll", query="SELECT m FROM Mtarifa m")
public class Mtarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_TAR")
	private String codTar;

	@Column(name="COD_TAR_OFI")
	private String codTarOfi;

	private BigDecimal company;

	@Column(name="DESC_TAR")
	private String descTar;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="ID_ESTACIONALIDAD")
	private BigDecimal idEstacionalidad;

	private BigDecimal jurisdiction;

	@Column(name="NUM_ACMP")
	private BigDecimal numAcmp;

	private String programa;

	@Column(name="TIP_SERV")
	private String tipServ;

	@Column(name="TIP_UTIL")
	private String tipUtil;

	private String usrchar1;

	private BigDecimal usrnumb1;

	private String usuario;

	public Mtarifa() {
	}

	public String getCodTar() {
		return this.codTar;
	}

	public void setCodTar(String codTar) {
		this.codTar = codTar;
	}

	public String getCodTarOfi() {
		return this.codTarOfi;
	}

	public void setCodTarOfi(String codTarOfi) {
		this.codTarOfi = codTarOfi;
	}

	public BigDecimal getCompany() {
		return this.company;
	}

	public void setCompany(BigDecimal company) {
		this.company = company;
	}

	public String getDescTar() {
		return this.descTar;
	}

	public void setDescTar(String descTar) {
		this.descTar = descTar;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getIdEstacionalidad() {
		return this.idEstacionalidad;
	}

	public void setIdEstacionalidad(BigDecimal idEstacionalidad) {
		this.idEstacionalidad = idEstacionalidad;
	}

	public BigDecimal getJurisdiction() {
		return this.jurisdiction;
	}

	public void setJurisdiction(BigDecimal jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public BigDecimal getNumAcmp() {
		return this.numAcmp;
	}

	public void setNumAcmp(BigDecimal numAcmp) {
		this.numAcmp = numAcmp;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getTipServ() {
		return this.tipServ;
	}

	public void setTipServ(String tipServ) {
		this.tipServ = tipServ;
	}

	public String getTipUtil() {
		return this.tipUtil;
	}

	public void setTipUtil(String tipUtil) {
		this.tipUtil = tipUtil;
	}

	public String getUsrchar1() {
		return this.usrchar1;
	}

	public void setUsrchar1(String usrchar1) {
		this.usrchar1 = usrchar1;
	}

	public BigDecimal getUsrnumb1() {
		return this.usrnumb1;
	}

	public void setUsrnumb1(BigDecimal usrnumb1) {
		this.usrnumb1 = usrnumb1;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}