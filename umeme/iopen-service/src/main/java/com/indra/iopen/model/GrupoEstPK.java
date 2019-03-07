package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GRUPO_EST database table.
 * 
 */
@Embeddable
public class GrupoEstPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CO_GRUPO")
	private String coGrupo;

	@Column(name="EST_REC")
	private String estRec;

	public GrupoEstPK() {
	}
	public String getCoGrupo() {
		return this.coGrupo;
	}
	public void setCoGrupo(String coGrupo) {
		this.coGrupo = coGrupo;
	}
	public String getEstRec() {
		return this.estRec;
	}
	public void setEstRec(String estRec) {
		this.estRec = estRec;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GrupoEstPK)) {
			return false;
		}
		GrupoEstPK castOther = (GrupoEstPK)other;
		return 
			this.coGrupo.equals(castOther.coGrupo)
			&& this.estRec.equals(castOther.estRec);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.coGrupo.hashCode();
		hash = hash * prime + this.estRec.hashCode();
		
		return hash;
	}
}