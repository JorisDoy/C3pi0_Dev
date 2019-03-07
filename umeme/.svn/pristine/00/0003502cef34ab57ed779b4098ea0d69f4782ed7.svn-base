package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the VISITA database table.
 * 
 */
@Entity
@NamedQuery(name="Visita.findAll", query="SELECT v FROM Visita v")
public class Visita implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VisitaPK id;

	@Column(name="COD_EMP")
	private BigDecimal codEmp;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="HORA_VIS_FIN")
	private BigDecimal horaVisFin;

	@Column(name="HORA_VIS_INI")
	private BigDecimal horaVisIni;

	private String observaciones;

	private String programa;

	private String usuario;

	public Visita() {
	}

	public VisitaPK getId() {
		return this.id;
	}

	public void setId(VisitaPK id) {
		this.id = id;
	}

	public BigDecimal getCodEmp() {
		return this.codEmp;
	}

	public void setCodEmp(BigDecimal codEmp) {
		this.codEmp = codEmp;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getHoraVisFin() {
		return this.horaVisFin;
	}

	public void setHoraVisFin(BigDecimal horaVisFin) {
		this.horaVisFin = horaVisFin;
	}

	public BigDecimal getHoraVisIni() {
		return this.horaVisIni;
	}

	public void setHoraVisIni(BigDecimal horaVisIni) {
		this.horaVisIni = horaVisIni;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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