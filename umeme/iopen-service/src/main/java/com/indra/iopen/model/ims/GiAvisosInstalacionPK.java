package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GI_AVISOS_INSTALACION database table.
 * 
 */
@Embeddable
public class GiAvisosInstalacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NRO_INSTALACION")
	private long nroInstalacion;

	@Column(name="NRO_AVISO")
	private long nroAviso;

	public GiAvisosInstalacionPK() {
	}
	public long getNroInstalacion() {
		return this.nroInstalacion;
	}
	public void setNroInstalacion(long nroInstalacion) {
		this.nroInstalacion = nroInstalacion;
	}
	public long getNroAviso() {
		return this.nroAviso;
	}
	public void setNroAviso(long nroAviso) {
		this.nroAviso = nroAviso;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GiAvisosInstalacionPK)) {
			return false;
		}
		GiAvisosInstalacionPK castOther = (GiAvisosInstalacionPK)other;
		return 
			(this.nroInstalacion == castOther.nroInstalacion)
			&& (this.nroAviso == castOther.nroAviso);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.nroInstalacion ^ (this.nroInstalacion >>> 32)));
		hash = hash * prime + ((int) (this.nroAviso ^ (this.nroAviso >>> 32)));
		
		return hash;
	}
}