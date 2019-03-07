package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GI_CENTRO_LOC database table.
 * 
 */
@Embeddable
public class GiCentroLocPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NRO_PUESTO")
	private long nroPuesto;

	@Column(name="COD_LOC")
	private long codLoc;

	public GiCentroLocPK() {
	}
	public long getNroPuesto() {
		return this.nroPuesto;
	}
	public void setNroPuesto(long nroPuesto) {
		this.nroPuesto = nroPuesto;
	}
	public long getCodLoc() {
		return this.codLoc;
	}
	public void setCodLoc(long codLoc) {
		this.codLoc = codLoc;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GiCentroLocPK)) {
			return false;
		}
		GiCentroLocPK castOther = (GiCentroLocPK)other;
		return 
			(this.nroPuesto == castOther.nroPuesto)
			&& (this.codLoc == castOther.codLoc);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.nroPuesto ^ (this.nroPuesto >>> 32)));
		hash = hash * prime + ((int) (this.codLoc ^ (this.codLoc >>> 32)));
		
		return hash;
	}
}