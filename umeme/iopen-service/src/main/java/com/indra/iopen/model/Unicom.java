package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the UNICOM database table.
 * 
 */
@Entity
@NamedQuery(name="Unicom.findAll", query="SELECT u FROM Unicom u")
public class Unicom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_UNICOM")
	private long codUnicom;

	@Column(name="CGV_UNICOM")
	private String cgvUnicom;

	@Column(name="COD_GR_UNICOM")
	private BigDecimal codGrUnicom;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="IND_DISTRICT")
	private BigDecimal indDistrict;

	@Column(name="IND_EXTERNO")
	private BigDecimal indExterno;

	@Column(name="NIF_UNICOM")
	private BigDecimal nifUnicom;

	@Column(name="NOM_UNICOM")
	private String nomUnicom;

	private String programa;

	@Column(name="TIP_UNICOM")
	private String tipUnicom;

	@Column(name="UNICOM_PADRE")
	private BigDecimal unicomPadre;

	private String usuario;

	public Unicom() {
	}

	public long getCodUnicom() {
		return this.codUnicom;
	}

	public void setCodUnicom(long codUnicom) {
		this.codUnicom = codUnicom;
	}

	public String getCgvUnicom() {
		return this.cgvUnicom;
	}

	public void setCgvUnicom(String cgvUnicom) {
		this.cgvUnicom = cgvUnicom;
	}

	public BigDecimal getCodGrUnicom() {
		return this.codGrUnicom;
	}

	public void setCodGrUnicom(BigDecimal codGrUnicom) {
		this.codGrUnicom = codGrUnicom;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getIndDistrict() {
		return this.indDistrict;
	}

	public void setIndDistrict(BigDecimal indDistrict) {
		this.indDistrict = indDistrict;
	}

	public BigDecimal getIndExterno() {
		return this.indExterno;
	}

	public void setIndExterno(BigDecimal indExterno) {
		this.indExterno = indExterno;
	}

	public BigDecimal getNifUnicom() {
		return this.nifUnicom;
	}

	public void setNifUnicom(BigDecimal nifUnicom) {
		this.nifUnicom = nifUnicom;
	}

	public String getNomUnicom() {
		return this.nomUnicom;
	}

	public void setNomUnicom(String nomUnicom) {
		this.nomUnicom = nomUnicom;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getTipUnicom() {
		return this.tipUnicom;
	}

	public void setTipUnicom(String tipUnicom) {
		this.tipUnicom = tipUnicom;
	}

	public BigDecimal getUnicomPadre() {
		return this.unicomPadre;
	}

	public void setUnicomPadre(BigDecimal unicomPadre) {
		this.unicomPadre = unicomPadre;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}