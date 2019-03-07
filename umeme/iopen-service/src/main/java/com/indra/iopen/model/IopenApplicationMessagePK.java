package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the IOPEN_APPLICATION_MESSAGES database table.
 * 
 */
@Embeddable
public class IopenApplicationMessagePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_APPLICATION")
	private long codApplication;

	@Column(name="SEC_ID")
	private long secId;

	public IopenApplicationMessagePK() {
	}
	public long getCodApplication() {
		return this.codApplication;
	}
	public void setCodApplication(long codApplication) {
		this.codApplication = codApplication;
	}
	public long getSecId() {
		return this.secId;
	}
	public void setSecId(long secId) {
		this.secId = secId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IopenApplicationMessagePK)) {
			return false;
		}
		IopenApplicationMessagePK castOther = (IopenApplicationMessagePK)other;
		return 
			(this.codApplication == castOther.codApplication)
			&& (this.secId == castOther.secId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.codApplication ^ (this.codApplication >>> 32)));
		hash = hash * prime + ((int) (this.secId ^ (this.secId >>> 32)));
		
		return hash;
	}
}