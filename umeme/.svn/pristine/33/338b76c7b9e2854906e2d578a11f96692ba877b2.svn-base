package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EMP_UNICOM database table.
 * 
 */
@Embeddable
public class EmpUnicomPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="EMPRESA_ID", insertable=false, updatable=false)
	private long empresaId;

	@Column(name="COD_UNICOM")
	private long codUnicom;

	@Column(name="COD_ZONA", insertable=false, updatable=false)
	private long codZona;

	@Column(name="COD_EMP_AREA", insertable=false, updatable=false)
	private long codEmpArea;

	public EmpUnicomPK() {
	}
	public long getEmpresaId() {
		return this.empresaId;
	}
	public void setEmpresaId(long empresaId) {
		this.empresaId = empresaId;
	}
	public long getCodUnicom() {
		return this.codUnicom;
	}
	public void setCodUnicom(long codUnicom) {
		this.codUnicom = codUnicom;
	}
	public long getCodZona() {
		return this.codZona;
	}
	public void setCodZona(long codZona) {
		this.codZona = codZona;
	}
	public long getCodEmpArea() {
		return this.codEmpArea;
	}
	public void setCodEmpArea(long codEmpArea) {
		this.codEmpArea = codEmpArea;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmpUnicomPK)) {
			return false;
		}
		EmpUnicomPK castOther = (EmpUnicomPK)other;
		return 
			(this.empresaId == castOther.empresaId)
			&& (this.codUnicom == castOther.codUnicom)
			&& (this.codZona == castOther.codZona)
			&& (this.codEmpArea == castOther.codEmpArea);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.empresaId ^ (this.empresaId >>> 32)));
		hash = hash * prime + ((int) (this.codUnicom ^ (this.codUnicom >>> 32)));
		hash = hash * prime + ((int) (this.codZona ^ (this.codZona >>> 32)));
		hash = hash * prime + ((int) (this.codEmpArea ^ (this.codEmpArea >>> 32)));
		
		return hash;
	}
}