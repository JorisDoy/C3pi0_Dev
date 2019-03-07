package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the APARATOS database table.
 * 
 */
@Embeddable
public class AparatoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NUM_APA")
	private String numApa;

	@Column(name="CO_MARCA")
	private String coMarca;

	public AparatoPK() {
	}
	public String getNumApa() {
		return this.numApa;
	}
	public void setNumApa(String numApa) {
		this.numApa = numApa;
	}
	public String getCoMarca() {
		return this.coMarca;
	}
	public void setCoMarca(String coMarca) {
		this.coMarca = coMarca;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AparatoPK)) {
			return false;
		}
		AparatoPK castOther = (AparatoPK)other;
		return 
			this.numApa.equals(castOther.numApa)
			&& this.coMarca.equals(castOther.coMarca);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numApa.hashCode();
		hash = hash * prime + this.coMarca.hashCode();
		
		return hash;
	}
}