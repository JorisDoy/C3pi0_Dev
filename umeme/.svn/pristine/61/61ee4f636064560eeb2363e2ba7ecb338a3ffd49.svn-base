package com.indra.iopen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the BDG_ACT_OFI_AUX database table.
 * 
 */
@Entity
@IdClass(BdgActOfiAux.class)
@Table(name = "BDG_ACT_OFI_AUX")
@NamedQuery(name = "BdgActOfiAux.findAll", query = "SELECT b FROM BdgActOfiAux b")
public class BdgActOfiAux implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "COD_UNICOM")
	private BigDecimal codUnicom;

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Id
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Id
	private String programa;

	@Id
	@Column(name = "TIP_ACT_OF")
	private String tipActOf;

	@Id
	private String usuario;

	public BdgActOfiAux() {

	}

	public BigDecimal getCodUnicom() {
		return this.codUnicom;
	}

	public void setCodUnicom(BigDecimal codUnicom) {
		this.codUnicom = codUnicom;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getTipActOf() {
		return this.tipActOf;
	}

	public void setTipActOf(String tipActOf) {
		this.tipActOf = tipActOf;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codUnicom == null) ? 0 : codUnicom.hashCode());
		result = prime * result + ((fActual == null) ? 0 : fActual.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((programa == null) ? 0 : programa.hashCode());
		result = prime * result + ((tipActOf == null) ? 0 : tipActOf.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BdgActOfiAux other = (BdgActOfiAux) obj;
		if (codUnicom == null) {
			if (other.codUnicom != null)
				return false;
		} else if (!codUnicom.equals(other.codUnicom))
			return false;
		if (fActual == null) {
			if (other.fActual != null)
				return false;
		} else if (!fActual.equals(other.fActual))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (programa == null) {
			if (other.programa != null)
				return false;
		} else if (!programa.equals(other.programa))
			return false;
		if (tipActOf == null) {
			if (other.tipActOf != null)
				return false;
		} else if (!tipActOf.equals(other.tipActOf))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}