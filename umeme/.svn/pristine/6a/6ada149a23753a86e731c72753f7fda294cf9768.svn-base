package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the OBJETOS database table.
 * 
 */
@Embeddable
public class ObjetoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="APLICACION")
	private String aplicacion;

	@Column(name="VENTANA")
	private String ventana;

	@Column(name="OBJETO")
	private String objeto;

	public ObjetoPK() {
	}
	public String getAplicacion() {
		return this.aplicacion;
	}
	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}
	public String getVentana() {
		return this.ventana;
	}
	public void setVentana(String ventana) {
		this.ventana = ventana;
	}
	public String getObjeto() {
		return this.objeto;
	}
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ObjetoPK)) {
			return false;
		}
		ObjetoPK castOther = (ObjetoPK)other;
		return 
			this.aplicacion.equals(castOther.aplicacion)
			&& this.ventana.equals(castOther.ventana)
			&& this.objeto.equals(castOther.objeto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.aplicacion.hashCode();
		hash = hash * prime + this.ventana.hashCode();
		hash = hash * prime + this.objeto.hashCode();
		
		return hash;
	}
}