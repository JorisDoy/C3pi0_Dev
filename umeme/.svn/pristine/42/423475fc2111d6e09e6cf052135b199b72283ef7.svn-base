package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GRUPO_EST database table.
 * 
 */
@Entity
@Table(name="GRUPO_EST")
@NamedQuery(name="GrupoEst.findAll", query="SELECT g FROM GrupoEst g")
public class GrupoEst implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GrupoEstPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="ORDEN_GI")
	private BigDecimal ordenGi;

	private String programa;

	private String usuario;

	public GrupoEst() {
	}

	public GrupoEstPK getId() {
		return this.id;
	}

	public void setId(GrupoEstPK id) {
		this.id = id;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getOrdenGi() {
		return this.ordenGi;
	}

	public void setOrdenGi(BigDecimal ordenGi) {
		this.ordenGi = ordenGi;
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