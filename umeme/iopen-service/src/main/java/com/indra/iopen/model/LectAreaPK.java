package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LECT_AREAS database table.
 * 
 */
@Embeddable
public class LectAreaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_LECT_AREA", insertable=false, updatable=false)
	private long codLectArea;

	@Column(name="COD_UNICOM")
	private long codUnicom;

	public LectAreaPK() {
	}
	public long getCodLectArea() {
		return this.codLectArea;
	}
	public void setCodLectArea(long codLectArea) {
		this.codLectArea = codLectArea;
	}
	public long getCodUnicom() {
		return this.codUnicom;
	}
	public void setCodUnicom(long codUnicom) {
		this.codUnicom = codUnicom;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LectAreaPK)) {
			return false;
		}
		LectAreaPK castOther = (LectAreaPK)other;
		return 
			(this.codLectArea == castOther.codLectArea)
			&& (this.codUnicom == castOther.codUnicom);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.codLectArea ^ (this.codLectArea >>> 32)));
		hash = hash * prime + ((int) (this.codUnicom ^ (this.codUnicom >>> 32)));
		
		return hash;
	}
}