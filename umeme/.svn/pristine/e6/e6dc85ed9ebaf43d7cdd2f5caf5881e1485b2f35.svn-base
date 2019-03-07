package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TIP_CLI_TIP_SOLIC_MAPPING database table.
 * 
 */
@Entity
@Table(name="TIP_CLI_TIP_SOLIC_MAPPING")
@NamedQuery(name="TipCliTipSolicMapping.findAll", query="SELECT t FROM TipCliTipSolicMapping t")
public class TipCliTipSolicMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TipCliTipSolicMappingPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	private String programa;

	private String usuario;

	public TipCliTipSolicMapping() {
	}

	public TipCliTipSolicMappingPK getId() {
		return this.id;
	}

	public void setId(TipCliTipSolicMappingPK id) {
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