package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SUMINISTRO_TIP_CSMO database table.
 * 
 */
@Entity
@Table(name="SUMINISTRO_TIP_CSMO")
@NamedQuery(name="SuministroTipCsmo.findAll", query="SELECT s FROM SuministroTipCsmo s")
public class SuministroTipCsmo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SuministroTipCsmoPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ALTA")
	private Date fAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="F_BAJA")
	private Date fBaja;

	private String programa;

	private String usuario;

	public SuministroTipCsmo() {
	}

	public SuministroTipCsmoPK getId() {
		return this.id;
	}

	public void setId(SuministroTipCsmoPK id) {
		this.id = id;
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

	public Date getFBaja() {
		return this.fBaja;
	}

	public void setFBaja(Date fBaja) {
		this.fBaja = fBaja;
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