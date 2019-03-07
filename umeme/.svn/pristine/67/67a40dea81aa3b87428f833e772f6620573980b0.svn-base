package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FINCAS_PER_LECT database table.
 * 
 */
@Entity
@Table(name="FINCAS_PER_LECT")
@NamedQuery(name="FincasPerLect.findAll", query="SELECT f FROM FincasPerLect f")
public class FincasPerLect implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FincasPerLectPK id;

	@Column(name="AOL_FIN")
	private BigDecimal aolFin;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="NUM_ITIN")
	private BigDecimal numItin;

	private String programa;

	private String usuario;

	public FincasPerLect() {
	}

	public FincasPerLectPK getId() {
		return this.id;
	}

	public void setId(FincasPerLectPK id) {
		this.id = id;
	}

	public BigDecimal getAolFin() {
		return this.aolFin;
	}

	public void setAolFin(BigDecimal aolFin) {
		this.aolFin = aolFin;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getNumItin() {
		return this.numItin;
	}

	public void setNumItin(BigDecimal numItin) {
		this.numItin = numItin;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}