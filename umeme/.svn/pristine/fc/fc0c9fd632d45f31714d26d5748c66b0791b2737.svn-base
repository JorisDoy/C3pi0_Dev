package com.indra.iopen.model.ims;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The primary key class for the GI_T_ULTIMO database table.
 *
 */
@Embeddable
public class GiTUltimoPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String tabla;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	public GiTUltimoPK() {
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public java.util.Date getFecha() {
		return this.fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GiTUltimoPK)) {
			return false;
		}
		GiTUltimoPK castOther = (GiTUltimoPK) other;
		return this.tabla.equals(castOther.tabla) && this.fecha.equals(castOther.fecha);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tabla.hashCode();
		hash = hash * prime + this.fecha.hashCode();

		return hash;
	}
}