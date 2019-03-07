package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the LECT_NATUR database table.
 * 
 */
@Entity
@Table(name="LECT_NATUR")
@NamedQuery(name="LectNatur.findAll", query="SELECT l FROM LectNatur l")
public class LectNatur implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LectNaturPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="IND_EN_RUTA")
	private BigDecimal indEnRuta;

	private String programa;

	private String usuario;

	public LectNatur() {
	}

	public LectNaturPK getId() {
		return this.id;
	}

	public void setId(LectNaturPK id) {
		this.id = id;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getIndEnRuta() {
		return this.indEnRuta;
	}

	public void setIndEnRuta(BigDecimal indEnRuta) {
		this.indEnRuta = indEnRuta;
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