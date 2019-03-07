package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the USUARIO_PERFIL_SEC database table.
 * 
 */
@Embeddable
public class UsuarioPerfilSecPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NOM_USR")
	private String nomUsr;

	@Column(name="NOM_PERFIL")
	private String nomPerfil;

	public UsuarioPerfilSecPK() {
	}
	public String getNomUsr() {
		return this.nomUsr;
	}
	public void setNomUsr(String nomUsr) {
		this.nomUsr = nomUsr;
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
		if (!(other instanceof UsuarioPerfilSecPK)) {
			return false;
		}
		UsuarioPerfilSecPK castOther = (UsuarioPerfilSecPK)other;
		return 
			this.nomUsr.equals(castOther.nomUsr)
			&& this.nomPerfil.equals(castOther.nomPerfil);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.nomUsr.hashCode();
		hash = hash * prime + this.nomPerfil.hashCode();
		
		return hash;
	}
}