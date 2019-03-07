package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TIP_CLI_TIP_SOLIC_MAPPING database table.
 * 
 */
@Embeddable
public class TipCliTipSolicMappingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TIP_CLI")
	private String tipCli;

	@Column(name="TIP_SOLIC")
	private String tipSolic;

	public TipCliTipSolicMappingPK() {
	}
	public String getTipCli() {
		return this.tipCli;
	}
	public void setTipCli(String tipCli) {
		this.tipCli = tipCli;
	}
	public String getTipSolic() {
		return this.tipSolic;
	}
	public void setTipSolic(String tipSolic) {
		this.tipSolic = tipSolic;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TipCliTipSolicMappingPK)) {
			return false;
		}
		TipCliTipSolicMappingPK castOther = (TipCliTipSolicMappingPK)other;
		return 
			this.tipCli.equals(castOther.tipCli)
			&& this.tipSolic.equals(castOther.tipSolic);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tipCli.hashCode();
		hash = hash * prime + this.tipSolic.hashCode();
		
		return hash;
	}
}