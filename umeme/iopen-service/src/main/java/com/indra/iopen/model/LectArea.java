package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the LECT_AREAS database table.
 * 
 */
@Entity
@Table(name="LECT_AREAS")
@NamedQuery(name="LectArea.findAll", query="SELECT l FROM LectArea l")
public class LectArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LectAreaPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	private String programa;

	private String usuario;

	public LectArea() {
	}

	public LectAreaPK getId() {
		return this.id;
	}

	public void setId(LectAreaPK id) {
		this.id = id;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
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