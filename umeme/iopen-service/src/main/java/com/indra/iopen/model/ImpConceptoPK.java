package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the IMP_CONCEPTO database table.
 * 
 */
@Embeddable
public class ImpConceptoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NUM_REC")
	private long numRec;

	@Column(name="SEC_CONCEPTO")
	private long secConcepto;

	public ImpConceptoPK() {
	}
	public long getNumRec() {
		return this.numRec;
	}
	public void setNumRec(long numRec) {
		this.numRec = numRec;
	}
	public long getSecConcepto() {
		return this.secConcepto;
	}
	public void setSecConcepto(long secConcepto) {
		this.secConcepto = secConcepto;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ImpConceptoPK)) {
			return false;
		}
		ImpConceptoPK castOther = (ImpConceptoPK)other;
		return 
			(this.numRec == castOther.numRec)
			&& (this.secConcepto == castOther.secConcepto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.numRec ^ (this.numRec >>> 32)));
		hash = hash * prime + ((int) (this.secConcepto ^ (this.secConcepto >>> 32)));
		
		return hash;
	}
}