package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the AN_TRABPEND_AF database table.
 *
 */
@Entity
@Table(name = "AN_TRABPEND_AF")
@NamedQuery(name = "AnTrabpendAf.findAll", query = "SELECT a FROM AnTrabpendAf a")
public class AnTrabpendAf implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AnTrabpendAfPK id;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Column(name = "NUM_OS")
	private Long numOs;

	private String programa;

	@Column(name = "TIP_OS")
	private String tipOs;

	private String usuario;

	public AnTrabpendAf() {
	}

	public AnTrabpendAfPK getId() {
		return id;
	}

	public void setId(AnTrabpendAfPK id) {
		this.id = id;
	}

	public Date getFActual() {
		return fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Long getNumOs() {
		return numOs;
	}

	public void setNumOs(Long numOs) {
		this.numOs = numOs;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getTipOs() {
		return tipOs;
	}

	public void setTipOs(String tipOs) {
		this.tipOs = tipOs;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}