package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the EXPED_COMM database table.
 * 
 */
@Entity
@Table(name="EXPED_COMM")
@NamedQuery(name="ExpedComm.findAll", query="SELECT e FROM ExpedComm e")
public class ExpedComm implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ExpedCommPK id;

	@Column(name="CGV_SUM")
	private String cgvSum;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="LECT_INI")
	private BigDecimal lectIni;

	@Column(name="NRO_ACO")
	private BigDecimal nroAco;

	@Column(name="NUM_RUE")
	private BigDecimal numRue;

	@Column(name="NUM_SUM")
	private BigDecimal numSum;

	private String programa;

	private String usuario;

	public ExpedComm() {
	}

	public ExpedCommPK getId() {
		return this.id;
	}

	public void setId(ExpedCommPK id) {
		this.id = id;
	}

	public String getCgvSum() {
		return this.cgvSum;
	}

	public void setCgvSum(String cgvSum) {
		this.cgvSum = cgvSum;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getLectIni() {
		return this.lectIni;
	}

	public void setLectIni(BigDecimal lectIni) {
		this.lectIni = lectIni;
	}

	public BigDecimal getNroAco() {
		return this.nroAco;
	}

	public void setNroAco(BigDecimal nroAco) {
		this.nroAco = nroAco;
	}

	public BigDecimal getNumRue() {
		return this.numRue;
	}

	public void setNumRue(BigDecimal numRue) {
		this.numRue = numRue;
	}

	public BigDecimal getNumSum() {
		return this.numSum;
	}

	public void setNumSum(BigDecimal numSum) {
		this.numSum = numSum;
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