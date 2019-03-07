package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CONSUMO_CONTRATADO database table.
 * 
 */
@Entity
@Table(name="CONSUMO_CONTRATADO")
@NamedQuery(name="ConsumoContratado.findAll", query="SELECT c FROM ConsumoContratado c")
public class ConsumoContratado implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConsumoContratadoPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	private String programa;

	@Column(name="TIP_CSMO")
	private String tipCsmo;

	private String usuario;

	public ConsumoContratado() {
	}

	public ConsumoContratadoPK getId() {
		return this.id;
	}

	public void setId(ConsumoContratadoPK id) {
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

	public String getTipCsmo() {
		return this.tipCsmo;
	}

	public void setTipCsmo(String tipCsmo) {
		this.tipCsmo = tipCsmo;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}