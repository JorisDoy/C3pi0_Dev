package com.indra.iopen.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the PRESUPUESTOS_EXPED database table.
 *
 */
@Embeddable
public class PresupuestosExpedPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "NUM_EXP")
	private String numExp;

	@Column(name = "PRESUPUESTOS_SEC")
	private long presupuestosSec;

	@Column(name = "COD_PRESUPUESTO")
	private long codPresupuesto;

	public PresupuestosExpedPK() {
	}

	public PresupuestosExpedPK(String numExp, long presupuestosSec, long codPresupuesto) {
		super();
		this.numExp = numExp;
		this.presupuestosSec = presupuestosSec;
		this.codPresupuesto = codPresupuesto;
	}

	public String getNumExp() {
		return this.numExp;
	}

	public void setNumExp(String numExp) {
		this.numExp = numExp;
	}

	public long getPresupuestosSec() {
		return this.presupuestosSec;
	}

	public void setPresupuestosSec(long presupuestosSec) {
		this.presupuestosSec = presupuestosSec;
	}

	public long getCodPresupuesto() {
		return this.codPresupuesto;
	}

	public void setCodPresupuesto(long codPresupuesto) {
		this.codPresupuesto = codPresupuesto;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PresupuestosExpedPK)) {
			return false;
		}
		PresupuestosExpedPK castOther = (PresupuestosExpedPK) other;
		return this.numExp.equals(castOther.numExp) && (this.presupuestosSec == castOther.presupuestosSec)
				&& (this.codPresupuesto == castOther.codPresupuesto);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numExp.hashCode();
		hash = hash * prime + ((int) (this.presupuestosSec ^ (this.presupuestosSec >>> 32)));
		hash = hash * prime + ((int) (this.codPresupuesto ^ (this.codPresupuesto >>> 32)));

		return hash;
	}
}