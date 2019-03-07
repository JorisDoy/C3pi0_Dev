package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SGD_RELACION_CENTRO database table.
 * 
 */
@Entity
@Table(name="SGD_RELACION_CENTRO")
@NamedQuery(name="SgdRelacionCentro.findAll", query="SELECT s FROM SgdRelacionCentro s")
public class SgdRelacionCentro implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SgdRelacionCentroPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name="H_ACTUAL")
	private Date hActual;

	private String programa;

	private String usuario;

	public SgdRelacionCentro() {
	}

	public SgdRelacionCentroPK getId() {
		return this.id;
	}

	public void setId(SgdRelacionCentroPK id) {
		this.id = id;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getHActual() {
		return this.hActual;
	}

	public void setHActual(Date hActual) {
		this.hActual = hActual;
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