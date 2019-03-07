package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the COSTE_EXP database table.
 * 
 */
@Entity
@Table(name="COSTE_EXP")
@NamedQuery(name="CosteExp.findAll", query="SELECT c FROM CosteExp c")
public class CosteExp implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CosteExpPK id;

	private BigDecimal coste;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	private String programa;

	private String usuario;

	public CosteExp() {
	}

	public CosteExpPK getId() {
		return this.id;
	}

	public void setId(CosteExpPK id) {
		this.id = id;
	}

	public BigDecimal getCoste() {
		return this.coste;
	}

	public void setCoste(BigDecimal coste) {
		this.coste = coste;
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