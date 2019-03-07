package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CONSUMO_CONTRATADO database table.
 * 
 */
@Embeddable
public class ConsumoContratadoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_GR_CONSUMO_CONTRATADO")
	private long idGrConsumoContratado;

	@Column(name="TIP_CSMO_BLOQUE")
	private String tipCsmoBloque;

	@Column(name="NUM_BLOQUE")
	private long numBloque;

	public ConsumoContratadoPK() {
	}
	public long getIdGrConsumoContratado() {
		return this.idGrConsumoContratado;
	}
	public void setIdGrConsumoContratado(long idGrConsumoContratado) {
		this.idGrConsumoContratado = idGrConsumoContratado;
	}
	public String getTipCsmoBloque() {
		return this.tipCsmoBloque;
	}
	public void setTipCsmoBloque(String tipCsmoBloque) {
		this.tipCsmoBloque = tipCsmoBloque;
	}
	public long getNumBloque() {
		return this.numBloque;
	}
	public void setNumBloque(long numBloque) {
		this.numBloque = numBloque;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConsumoContratadoPK)) {
			return false;
		}
		ConsumoContratadoPK castOther = (ConsumoContratadoPK)other;
		return 
			(this.idGrConsumoContratado == castOther.idGrConsumoContratado)
			&& this.tipCsmoBloque.equals(castOther.tipCsmoBloque)
			&& (this.numBloque == castOther.numBloque);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idGrConsumoContratado ^ (this.idGrConsumoContratado >>> 32)));
		hash = hash * prime + this.tipCsmoBloque.hashCode();
		hash = hash * prime + ((int) (this.numBloque ^ (this.numBloque >>> 32)));
		
		return hash;
	}
}