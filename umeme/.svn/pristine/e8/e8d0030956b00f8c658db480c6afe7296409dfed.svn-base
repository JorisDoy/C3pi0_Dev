package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SUM_EXP database table.
 * 
 */
@Embeddable
public class SumExpPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NUM_EXP")
	private String numExp;

	@Column(name="NUM_SUM")
	private long numSum;

	public SumExpPK() {
	}
	public String getNumExp() {
		return this.numExp;
	}
	public void setNumExp(String numExp) {
		this.numExp = numExp;
	}
	public long getNumSum() {
		return this.numSum;
	}
	public void setNumSum(long numSum) {
		this.numSum = numSum;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SumExpPK)) {
			return false;
		}
		SumExpPK castOther = (SumExpPK)other;
		return 
			this.numExp.equals(castOther.numExp)
			&& (this.numSum == castOther.numSum);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numExp.hashCode();
		hash = hash * prime + ((int) (this.numSum ^ (this.numSum >>> 32)));
		
		return hash;
	}
}