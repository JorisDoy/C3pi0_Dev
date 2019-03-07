package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SGD_RELACION_CENTRO database table.
 * 
 */
@Embeddable
public class SgdRelacionCentroPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CENTRO_RESP")
	private long centroResp;

	@Column(name="CENTRO_DEPEN")
	private long centroDepen;

	@Column(name="TIP_CENTRO")
	private long tipCentro;

	public SgdRelacionCentroPK() {
	}
	public long getCentroResp() {
		return this.centroResp;
	}
	public void setCentroResp(long centroResp) {
		this.centroResp = centroResp;
	}
	public long getCentroDepen() {
		return this.centroDepen;
	}
	public void setCentroDepen(long centroDepen) {
		this.centroDepen = centroDepen;
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
		if (!(other instanceof SgdRelacionCentroPK)) {
			return false;
		}
		SgdRelacionCentroPK castOther = (SgdRelacionCentroPK)other;
		return 
			(this.centroResp == castOther.centroResp)
			&& (this.centroDepen == castOther.centroDepen)
			&& (this.tipCentro == castOther.tipCentro);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.centroResp ^ (this.centroResp >>> 32)));
		hash = hash * prime + ((int) (this.centroDepen ^ (this.centroDepen >>> 32)));
		hash = hash * prime + ((int) (this.tipCentro ^ (this.tipCentro >>> 32)));
		
		return hash;
	}
}