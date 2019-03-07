package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SUMINISTRO_TIP_CSMO database table.
 * 
 */
@Embeddable
public class SuministroTipCsmoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NUM_SUM")
	private long numSum;

	@Column(name="TIP_CSMO")
	private String tipCsmo;

	@Column(name="ID_APA")
	private long idApa;

	public SuministroTipCsmoPK() {
	}
	public long getNumSum() {
		return this.numSum;
	}
	public void setNumSum(long numSum) {
		this.numSum = numSum;
	}
	public String getTipCsmo() {
		return this.tipCsmo;
	}
	public void setTipCsmo(String tipCsmo) {
		this.tipCsmo = tipCsmo;
	}
	public long getIdApa() {
		return this.idApa;
	}
	public void setIdApa(long idApa) {
		this.idApa = idApa;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SuministroTipCsmoPK)) {
			return false;
		}
		SuministroTipCsmoPK castOther = (SuministroTipCsmoPK)other;
		return 
			(this.numSum == castOther.numSum)
			&& this.tipCsmo.equals(castOther.tipCsmo)
			&& (this.idApa == castOther.idApa);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.numSum ^ (this.numSum >>> 32)));
		hash = hash * prime + this.tipCsmo.hashCode();
		hash = hash * prime + ((int) (this.idApa ^ (this.idApa >>> 32)));
		
		return hash;
	}
}