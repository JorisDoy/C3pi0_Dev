package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PERFIL_OBJETO database table.
 * 
 */
@Embeddable
public class PerfilObjetoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String aplicacion;

	@Column(insertable=false, updatable=false)
	private String ventana;

	@Column(insertable=false, updatable=false)
	private String objeto;

	@Column(name="NOM_PERFIL", insertable=false, updatable=false)
	private String nomPerfil;

	public PerfilObjetoPK() {
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
	public String getNomPerfil() {
		return this.nomPerfil;
	}
	public void setNomPerfil(String nomPerfil) {
		this.nomPerfil = nomPerfil;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PerfilObjetoPK)) {
			return false;
		}
		PerfilObjetoPK castOther = (PerfilObjetoPK)other;
		return 
			this.aplicacion.equals(castOther.aplicacion)
			&& this.ventana.equals(castOther.ventana)
			&& this.objeto.equals(castOther.objeto)
			&& this.nomPerfil.equals(castOther.nomPerfil);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.aplicacion.hashCode();
		hash = hash * prime + this.ventana.hashCode();
		hash = hash * prime + this.objeto.hashCode();
		hash = hash * prime + this.nomPerfil.hashCode();
		
		return hash;
	}
}