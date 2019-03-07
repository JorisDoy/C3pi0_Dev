package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CLIENTE_PROFILE database table.
 * 
 */
@Embeddable
public class EmployeeProfilePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_CLI")
	private long codCli;

	private String username;

	public EmployeeProfilePK() {
	}
	public long getCodCli() {
		return this.codCli;
	}
	public void setCodCli(long codCli) {
		this.codCli = codCli;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmployeeProfilePK)) {
			return false;
		}
		EmployeeProfilePK castOther = (EmployeeProfilePK)other;
		return 
			(this.codCli == castOther.codCli)
			&& this.username.equals(castOther.username);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.codCli ^ (this.codCli >>> 32)));
		hash = hash * prime + this.username.hashCode();
		
		return hash;
	}
}