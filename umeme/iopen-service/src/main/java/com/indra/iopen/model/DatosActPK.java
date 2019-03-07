package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DATOS_ACT database table.
 * 
 */
@Embeddable
public class DatosActPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NUM_RE", insertable=false, updatable=false)
	private long numRe;

	@Column(name="NUM_ACT")
	private long numAct;

	public DatosActPK() {
	}
	public long getNumRe() {
		return this.numRe;
	}
	public void setNumRe(long numRe) {
		this.numRe = numRe;
	}
	public long getNumAct() {
		return this.numAct;
	}
	public void setNumAct(long numAct) {
		this.numAct = numAct;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DatosActPK)) {
			return false;
		}
		DatosActPK castOther = (DatosActPK)other;
		return 
			(this.numRe == castOther.numRe)
			&& (this.numAct == castOther.numAct);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.numRe ^ (this.numRe >>> 32)));
		hash = hash * prime + ((int) (this.numAct ^ (this.numAct >>> 32)));
		
		return hash;
	}
}