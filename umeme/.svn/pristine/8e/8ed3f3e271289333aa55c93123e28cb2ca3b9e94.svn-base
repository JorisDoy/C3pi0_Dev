package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LECT_NATUR database table.
 * 
 */
@Embeddable
public class LectNaturPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_UNICOM")
	private long codUnicom;

	@Column(name="TIP_NATUR")
	private String tipNatur;

	public LectNaturPK() {
	}
	public long getCodUnicom() {
		return this.codUnicom;
	}
	public void setCodUnicom(long codUnicom) {
		this.codUnicom = codUnicom;
	}
	public String getTipNatur() {
		return this.tipNatur;
	}
	public void setTipNatur(String tipNatur) {
		this.tipNatur = tipNatur;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LectNaturPK)) {
			return false;
		}
		LectNaturPK castOther = (LectNaturPK)other;
		return 
			(this.codUnicom == castOther.codUnicom)
			&& this.tipNatur.equals(castOther.tipNatur);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.codUnicom ^ (this.codUnicom >>> 32)));
		hash = hash * prime + this.tipNatur.hashCode();
		
		return hash;
	}
}