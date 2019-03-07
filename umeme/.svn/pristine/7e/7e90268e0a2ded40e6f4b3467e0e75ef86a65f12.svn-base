package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the INSPECTION_RESULT_TIP_OBRA database table.
 * 
 */
@Entity
@Table(name="INSPECTION_RESULT_TIP_OBRA")
@NamedQuery(name="InspectionResultTipObra.findAll", query="SELECT i FROM InspectionResultTipObra i")
public class InspectionResultTipObra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TIP_OBRA")
	private String tipObra;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="MAX_NO_OF_METERS")
	private BigDecimal maxNoOfMeters;

	@Column(name="MAX_NO_OF_POLES")
	private BigDecimal maxNoOfPoles;

	@Column(name="MIN_NO_OF_METERS")
	private BigDecimal minNoOfMeters;

	@Column(name="MIN_NO_OF_POLES")
	private BigDecimal minNoOfPoles;

	@Column(name="PHASES_REQUESTED")
	private String phasesRequested;

	private String usuario;

	public InspectionResultTipObra() {
	}

	public String getTipObra() {
		return this.tipObra;
	}

	public void setTipObra(String tipObra) {
		this.tipObra = tipObra;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getMaxNoOfMeters() {
		return this.maxNoOfMeters;
	}

	public void setMaxNoOfMeters(BigDecimal maxNoOfMeters) {
		this.maxNoOfMeters = maxNoOfMeters;
	}

	public BigDecimal getMaxNoOfPoles() {
		return this.maxNoOfPoles;
	}

	public void setMaxNoOfPoles(BigDecimal maxNoOfPoles) {
		this.maxNoOfPoles = maxNoOfPoles;
	}

	public BigDecimal getMinNoOfMeters() {
		return this.minNoOfMeters;
	}

	public void setMinNoOfMeters(BigDecimal minNoOfMeters) {
		this.minNoOfMeters = minNoOfMeters;
	}

	public BigDecimal getMinNoOfPoles() {
		return this.minNoOfPoles;
	}

	public void setMinNoOfPoles(BigDecimal minNoOfPoles) {
		this.minNoOfPoles = minNoOfPoles;
	}

	public String getPhasesRequested() {
		return this.phasesRequested;
	}

	public void setPhasesRequested(String phasesRequested) {
		this.phasesRequested = phasesRequested;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}