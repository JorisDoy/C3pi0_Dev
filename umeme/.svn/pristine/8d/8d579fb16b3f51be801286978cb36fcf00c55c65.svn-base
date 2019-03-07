package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EMP_UNICOM database table.
 * 
 */
@Entity
@Table(name="EMP_UNICOM")
@NamedQuery(name="EmpUnicom.findAll", query="SELECT e FROM EmpUnicom e")
public class EmpUnicom implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmpUnicomPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	private String programa;

	private String usuario;

	public EmpUnicom() {
	}

	public EmpUnicomPK getId() {
		return this.id;
	}

	public void setId(EmpUnicomPK id) {
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