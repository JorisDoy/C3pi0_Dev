package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SGD_INSTALACION database table.
 * 
 */
@Embeddable
public class SgdInstalacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NRO_INSTALACION")
	private long nroInstalacion;

	@Column(name="BDI_JOB")
	private long bdiJob;

	public SgdInstalacionPK() {
	}
	public long getNroInstalacion() {
		return this.nroInstalacion;
	}
	public void setNroInstalacion(long nroInstalacion) {
		this.nroInstalacion = nroInstalacion;
	}
	public long getBdiJob() {
		return this.bdiJob;
	}
	public void setBdiJob(long bdiJob) {
		this.bdiJob = bdiJob;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SgdInstalacionPK)) {
			return false;
		}
		SgdInstalacionPK castOther = (SgdInstalacionPK)other;
		return 
			(this.nroInstalacion == castOther.nroInstalacion)
			&& (this.bdiJob == castOther.bdiJob);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.nroInstalacion ^ (this.nroInstalacion >>> 32)));
		hash = hash * prime + ((int) (this.bdiJob ^ (this.bdiJob >>> 32)));
		
		return hash;
	}
}