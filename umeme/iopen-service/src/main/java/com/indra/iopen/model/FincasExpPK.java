package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the FINCAS_EXP database table.
 * 
 */
@Embeddable
public class FincasExpPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "NUM_EXP")
	private String numExp;

	private long nif;

	@Column(name = "SEC_FINCA")
	private long secFinca;

	public FincasExpPK() {
		this.secFinca = 1;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FincasExpPK)) {
			return false;
		}
		FincasExpPK castOther = (FincasExpPK) other;
		return this.numExp.equals(castOther.numExp) && (this.nif == castOther.nif)
				&& (this.secFinca == castOther.secFinca);
	}

	public long getNif() {
		return this.nif;
	}

	public String getNumExp() {
		return this.numExp;
	}

	public long getSecFinca() {
		return this.secFinca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numExp.hashCode();
		hash = hash * prime + ((int) (this.nif ^ (this.nif >>> 32)));
		hash = hash * prime + ((int) (this.secFinca ^ (this.secFinca >>> 32)));

		return hash;
	}

	public void setNif(long nif) {
		this.nif = nif;
	}

	public void setNumExp(String numExp) {
		this.numExp = numExp;
	}

	public void setSecFinca(long secFinca) {
		this.secFinca = secFinca;
	}
}