package com.indra.iopen.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the ACTIVIDADES database table.
 * 
 */
@Entity
@Table(name = "ACTIVIDADES")
@NamedQuery(name = "Actividade.findAll", query = "SELECT a FROM Actividade a")
public class Actividade implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ActividadePK id;

	@Column(name = "COMENT_ACT", nullable = false, length = 100)
	private String comentAct;

	@Column(name = "EST_ACT", nullable = false, length = 5)
	private String estAct;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACT", nullable = false)
	private Date fAct;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL", nullable = false)
	private Date fActual;

	@Column(nullable = false, length = 15)
	private String programa;

	@Column(nullable = false, length = 30)
	private String usuario;

	public Actividade() {
		this.comentAct = " ";
		this.fAct = new Date();
		this.fActual = new Date();
	}

	public String getComentAct() {
		return this.comentAct;
	}

	public String getEstAct() {
		return this.estAct;
	}

	public Date getFAct() {
		return this.fAct;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public ActividadePK getId() {
		return this.id;
	}

	public String getPrograma() {
		return this.programa;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setComentAct(String comentAct) {
		this.comentAct = comentAct;
	}

	public void setEstAct(String estAct) {
		this.estAct = estAct;
	}

	public void setFAct(Date fAct) {
		this.fAct = fAct;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public void setId(ActividadePK id) {
		this.id = id;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}