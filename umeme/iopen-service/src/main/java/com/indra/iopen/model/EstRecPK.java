package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EST_REC database table.
 * 
 */
@Embeddable
public class EstRecPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NUM_REC")
	private long numRec;

	@Column(name="SEC_EST_REC")
	private long secEstRec;

	public EstRecPK() {
	}
	public long getNumRec() {
		return this.numRec;
	}
	public void setNumRec(long numRec) {
		this.numRec = numRec;
	}
	public long getSecEstRec() {
		return this.secEstRec;
	}
	public void setSecEstRec(long secEstRec) {
		this.secEstRec = secEstRec;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EstRecPK)) {
			return false;
		}
		EstRecPK castOther = (EstRecPK)other;
		return 
			(this.numRec == castOther.numRec)
			&& (this.secEstRec == castOther.secEstRec);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.numRec ^ (this.numRec >>> 32)));
		hash = hash * prime + ((int) (this.secEstRec ^ (this.secEstRec >>> 32)));
		
		return hash;
	}
}