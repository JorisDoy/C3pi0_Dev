package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SGD_CENTRO database table.
 * 
 */
@Embeddable
public class SgdCentroPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NRO_CENTRO")
	private long nroCentro;

	@Column(name="TIP_CENTRO")
	private long tipCentro;

	public SgdCentroPK() {
	}
	public long getNroCentro() {
		return this.nroCentro;
	}
	public void setNroCentro(long nroCentro) {
		this.nroCentro = nroCentro;
	}
	public long getTipCentro() {
		return this.tipCentro;
	}
	public void setTipCentro(long tipCentro) {
		this.tipCentro = tipCentro;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SgdCentroPK)) {
			return false;
		}
		SgdCentroPK castOther = (SgdCentroPK)other;
		return 
			(this.nroCentro == castOther.nroCentro)
			&& (this.tipCentro == castOther.tipCentro);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.nroCentro ^ (this.nroCentro >>> 32)));
		hash = hash * prime + ((int) (this.tipCentro ^ (this.tipCentro >>> 32)));
		
		return hash;
	}
}