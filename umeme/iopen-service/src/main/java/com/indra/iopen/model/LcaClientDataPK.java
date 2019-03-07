package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LCA_CLIENT_DATA database table.
 * 
 */
@Embeddable
public class LcaClientDataPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NIS_RAD")
	private long nisRad;

	@Column(name="TIP_MODIF")
	private String tipModif;

	@Column(name="ATTRIB_NAME")
	private String attribName;

	public LcaClientDataPK() {
	}
	public long getNisRad() {
		return this.nisRad;
	}
	public void setNisRad(long nisRad) {
		this.nisRad = nisRad;
	}
	public String getTipModif() {
		return this.tipModif;
	}
	public void setTipModif(String tipModif) {
		this.tipModif = tipModif;
	}
	public String getAttribName() {
		return this.attribName;
	}
	public void setAttribName(String attribName) {
		this.attribName = attribName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LcaClientDataPK)) {
			return false;
		}
		LcaClientDataPK castOther = (LcaClientDataPK)other;
		return 
			(this.nisRad == castOther.nisRad)
			&& this.tipModif.equals(castOther.tipModif)
			&& this.attribName.equals(castOther.attribName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.nisRad ^ (this.nisRad >>> 32)));
		hash = hash * prime + this.tipModif.hashCode();
		hash = hash * prime + this.attribName.hashCode();
		
		return hash;
	}
}