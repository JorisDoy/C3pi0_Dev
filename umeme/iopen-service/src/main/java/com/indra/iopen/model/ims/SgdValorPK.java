package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SGD_VALOR database table.
 * 
 */
@Embeddable
public class SgdValorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String codif;

	private String valor;

	public SgdValorPK() {
	}
	public String getCodif() {
		return this.codif;
	}
	public void setCodif(String codif) {
		this.codif = codif;
	}
	public String getValor() {
		return this.valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SgdValorPK)) {
			return false;
		}
		SgdValorPK castOther = (SgdValorPK)other;
		return 
			this.codif.equals(castOther.codif)
			&& this.valor.equals(castOther.valor);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codif.hashCode();
		hash = hash * prime + this.valor.hashCode();
		
		return hash;
	}
}