package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the BILL_DISPATCH database table.
 * 
 */
@Embeddable
public class BillDispatchPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NIS_RAD")
	private long nisRad;

	@Column(name="TIP_DISPATCH")
	private String tipDispatch;

	public BillDispatchPK() {
	}
	public long getNisRad() {
		return this.nisRad;
	}
	public void setNisRad(long nisRad) {
		this.nisRad = nisRad;
	}
	public String getTipDispatch() {
		return this.tipDispatch;
	}
	public void setTipDispatch(String tipDispatch) {
		this.tipDispatch = tipDispatch;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BillDispatchPK)) {
			return false;
		}
		BillDispatchPK castOther = (BillDispatchPK)other;
		return 
			(this.nisRad == castOther.nisRad)
			&& this.tipDispatch.equals(castOther.tipDispatch);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.nisRad ^ (this.nisRad >>> 32)));
		hash = hash * prime + this.tipDispatch.hashCode();
		
		return hash;
	}
}