package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PUNTOMED database table.
 *
 */
@Embeddable
public class PuntomedPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long nif;

	@Column(name = "SEC_PM")
	private long secPm;

	public PuntomedPK() {
		secPm = 1;
	}

	public long getNif() {
		return nif;
	}

	public void setNif(long nif) {
		this.nif = nif;
	}

	public long getSecPm() {
		return secPm;
	}

	public void setSecPm(long secPm) {
		this.secPm = secPm;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PuntomedPK)) {
			return false;
		}
		PuntomedPK castOther = (PuntomedPK) other;
		return (nif == castOther.nif) && (secPm == castOther.secPm);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (nif ^ (nif >>> 32)));
		hash = hash * prime + ((int) (secPm ^ (secPm >>> 32)));

		return hash;
	}
}