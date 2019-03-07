package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the APA_TIP_CARAC database table.
 * 
 */
@Embeddable
public class ApaTipCaracPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TIP_APA")
	private String tipApa;

	@Column(name="CO_MARCA")
	private String coMarca;

	@Column(name="CO_MODELO")
	private String coModelo;

	public ApaTipCaracPK() {
	}
	public String getTipApa() {
		return this.tipApa;
	}
	public void setTipApa(String tipApa) {
		this.tipApa = tipApa;
	}
	public String getCoMarca() {
		return this.coMarca;
	}
	public void setCoMarca(String coMarca) {
		this.coMarca = coMarca;
	}
	public String getCoModelo() {
		return this.coModelo;
	}
	public void setCoModelo(String coModelo) {
		this.coModelo = coModelo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ApaTipCaracPK)) {
			return false;
		}
		ApaTipCaracPK castOther = (ApaTipCaracPK)other;
		return 
			this.tipApa.equals(castOther.tipApa)
			&& this.coMarca.equals(castOther.coMarca)
			&& this.coModelo.equals(castOther.coModelo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tipApa.hashCode();
		hash = hash * prime + this.coMarca.hashCode();
		hash = hash * prime + this.coModelo.hashCode();
		
		return hash;
	}
}