package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the FINCAS_PER_LECT database table.
 * 
 */
@Embeddable
public class FincasPerLectPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NUM_MRSP")
	private long numMrsp;

	private long nif;

	@Column(name="TIP_NATUR")
	private String tipNatur;

	@Column(name="TIP_PER_LECT")
	private String tipPerLect;

	public FincasPerLectPK() {
	}
	public long getNumMrsp() {
		return this.numMrsp;
	}
	public void setNumMrsp(long numMrsp) {
		this.numMrsp = numMrsp;
	}
	public long getNif() {
		return this.nif;
	}
	public void setNif(long nif) {
		this.nif = nif;
	}
	public String getTipNatur() {
		return this.tipNatur;
	}
	public void setTipNatur(String tipNatur) {
		this.tipNatur = tipNatur;
	}
	public String getTipPerLect() {
		return this.tipPerLect;
	}
	public void setTipPerLect(String tipPerLect) {
		this.tipPerLect = tipPerLect;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FincasPerLectPK)) {
			return false;
		}
		FincasPerLectPK castOther = (FincasPerLectPK)other;
		return 
			(this.numMrsp == castOther.numMrsp)
			&& (this.nif == castOther.nif)
			&& this.tipNatur.equals(castOther.tipNatur)
			&& this.tipPerLect.equals(castOther.tipPerLect);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.numMrsp ^ (this.numMrsp >>> 32)));
		hash = hash * prime + ((int) (this.nif ^ (this.nif >>> 32)));
		hash = hash * prime + this.tipNatur.hashCode();
		hash = hash * prime + this.tipPerLect.hashCode();
		
		return hash;
	}
}