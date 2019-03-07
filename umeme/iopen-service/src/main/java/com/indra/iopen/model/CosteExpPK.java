package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the COSTE_EXP database table.
 * 
 */
@Embeddable
public class CosteExpPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TIP_MOV")
	private String tipMov;

	@Column(name="TIP_OBRA")
	private String tipObra;

	@Column(name="TIP_CONNEXION")
	private String tipConnexion;

	@Column(name="TIP_TARRIFF")
	private String tipTarriff;

	public CosteExpPK() {
	}
	public String getTipMov() {
		return this.tipMov;
	}
	public void setTipMov(String tipMov) {
		this.tipMov = tipMov;
	}
	public String getTipObra() {
		return this.tipObra;
	}
	public void setTipObra(String tipObra) {
		this.tipObra = tipObra;
	}
	public String getTipConnexion() {
		return this.tipConnexion;
	}
	public void setTipConnexion(String tipConnexion) {
		this.tipConnexion = tipConnexion;
	}
	public String getTipTarriff() {
		return this.tipTarriff;
	}
	public void setTipTarriff(String tipTarriff) {
		this.tipTarriff = tipTarriff;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CosteExpPK)) {
			return false;
		}
		CosteExpPK castOther = (CosteExpPK)other;
		return 
			this.tipMov.equals(castOther.tipMov)
			&& this.tipObra.equals(castOther.tipObra)
			&& this.tipConnexion.equals(castOther.tipConnexion)
			&& this.tipTarriff.equals(castOther.tipTarriff);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tipMov.hashCode();
		hash = hash * prime + this.tipObra.hashCode();
		hash = hash * prime + this.tipConnexion.hashCode();
		hash = hash * prime + this.tipTarriff.hashCode();
		
		return hash;
	}
}