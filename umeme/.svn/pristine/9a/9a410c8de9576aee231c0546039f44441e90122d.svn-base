package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AN_TRABPEND_AF database table.
 * 
 */
@Embeddable
public class AnTrabpendAfPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NUM_AF")
	private long numAf;

	@Column(name="ID_APA")
	private long idApa;

	@Column(name="CO_AN")
	private String coAn;

	public AnTrabpendAfPK() {
	}
	public long getNumAf() {
		return this.numAf;
	}
	public void setNumAf(long numAf) {
		this.numAf = numAf;
	}
	public long getIdApa() {
		return this.idApa;
	}
	public void setIdApa(long idApa) {
		this.idApa = idApa;
	}
	public String getCoAn() {
		return this.coAn;
	}
	public void setCoAn(String coAn) {
		this.coAn = coAn;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AnTrabpendAfPK)) {
			return false;
		}
		AnTrabpendAfPK castOther = (AnTrabpendAfPK)other;
		return 
			(this.numAf == castOther.numAf)
			&& (this.idApa == castOther.idApa)
			&& this.coAn.equals(castOther.coAn);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.numAf ^ (this.numAf >>> 32)));
		hash = hash * prime + ((int) (this.idApa ^ (this.idApa >>> 32)));
		hash = hash * prime + this.coAn.hashCode();
		
		return hash;
	}
}