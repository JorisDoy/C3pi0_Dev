package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CLIENTE_IDENTIFICADOR database table.
 * 
 */
@Embeddable
public class ClienteIdentificadorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_CLI", unique=true, nullable=false, precision=9)
	private long codCli;

	@Column(name="SEC_ID", unique=true, nullable=false, precision=2)
	private long secId;

	public ClienteIdentificadorPK() {
	}
	
	
	public ClienteIdentificadorPK(long codCli, long secId) {
		super();
		this.codCli = codCli;
		this.secId = secId;
	}


	public long getCodCli() {
		return this.codCli;
	}
	public void setCodCli(long codCli) {
		this.codCli = codCli;
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
		if (!(other instanceof ClienteIdentificadorPK)) {
			return false;
		}
		ClienteIdentificadorPK castOther = (ClienteIdentificadorPK)other;
		return 
			(this.codCli == castOther.codCli)
			&& (this.secId == castOther.secId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.codCli ^ (this.codCli >>> 32)));
		hash = hash * prime + ((int) (this.secId ^ (this.secId >>> 32)));
		
		return hash;
	}
}