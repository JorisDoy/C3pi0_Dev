package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the USUARIO_PERFIL database table.
 * 
 */
@Embeddable
public class UsuarioPerfilPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NOM_USR", insertable=false, updatable=false)
	private String nomUsr;

	@Column(name="NOM_PERFIL", insertable=false, updatable=false)
	private String nomPerfil;

	public UsuarioPerfilPK() {
		super();
	}
	
	public UsuarioPerfilPK(String nomUsr, String nomPerfil) {
		super();
		this.nomUsr = nomUsr;
		this.nomPerfil = nomPerfil;
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
		if (!(other instanceof UsuarioPerfilPK)) {
			return false;
		}
		UsuarioPerfilPK castOther = (UsuarioPerfilPK)other;
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