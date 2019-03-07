package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the VISITA database table.
 * 
 */
@Embeddable
public class VisitaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NUM_OS")
	private long numOs;

	@Temporal(TemporalType.DATE)
	@Column(name="F_VIS")
	private java.util.Date fVis;

	@Column(name="CO_ACCEJE")
	private String coAcceje;

	public VisitaPK() {
	}
	public long getNumOs() {
		return this.numOs;
	}
	public void setNumOs(long numOs) {
		this.numOs = numOs;
	}
	public java.util.Date getFVis() {
		return this.fVis;
	}
	public void setFVis(java.util.Date fVis) {
		this.fVis = fVis;
	}
	public String getCoAcceje() {
		return this.coAcceje;
	}
	public void setCoAcceje(String coAcceje) {
		this.coAcceje = coAcceje;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VisitaPK)) {
			return false;
		}
		VisitaPK castOther = (VisitaPK)other;
		return 
			(this.numOs == castOther.numOs)
			&& this.fVis.equals(castOther.fVis)
			&& this.coAcceje.equals(castOther.coAcceje);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.numOs ^ (this.numOs >>> 32)));
		hash = hash * prime + this.fVis.hashCode();
		hash = hash * prime + this.coAcceje.hashCode();
		
		return hash;
	}
}