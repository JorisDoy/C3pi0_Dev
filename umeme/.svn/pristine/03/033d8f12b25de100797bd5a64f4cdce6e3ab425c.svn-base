package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SGD_ACOMETIDA database table.
 * 
 */
@Embeddable
public class SgdAcometidaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long codigo;

	@Column(name="BDI_JOB")
	private long bdiJob;

	public SgdAcometidaPK() {
	}
	public long getCodigo() {
		return this.codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
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
		if (!(other instanceof SgdAcometidaPK)) {
			return false;
		}
		SgdAcometidaPK castOther = (SgdAcometidaPK)other;
		return 
			(this.codigo == castOther.codigo)
			&& (this.bdiJob == castOther.bdiJob);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.codigo ^ (this.codigo >>> 32)));
		hash = hash * prime + ((int) (this.bdiJob ^ (this.bdiJob >>> 32)));
		
		return hash;
	}
}