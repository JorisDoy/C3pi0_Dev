package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the HAPARATOS database table.
 * 
 */
@Embeddable
public class HaparatoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NUM_APA")
	private String numApa;

	@Column(name="CO_MARCA")
	private String coMarca;

	@Temporal(TemporalType.DATE)
	@Column(name="F_CAMBIO")
	private java.util.Date fCambio;

	public HaparatoPK() {
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
	public java.util.Date getFCambio() {
		return this.fCambio;
	}
	public void setFCambio(java.util.Date fCambio) {
		this.fCambio = fCambio;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HaparatoPK)) {
			return false;
		}
		HaparatoPK castOther = (HaparatoPK)other;
		return 
			this.numApa.equals(castOther.numApa)
			&& this.coMarca.equals(castOther.coMarca)
			&& this.fCambio.equals(castOther.fCambio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numApa.hashCode();
		hash = hash * prime + this.coMarca.hashCode();
		hash = hash * prime + this.fCambio.hashCode();
		
		return hash;
	}
}