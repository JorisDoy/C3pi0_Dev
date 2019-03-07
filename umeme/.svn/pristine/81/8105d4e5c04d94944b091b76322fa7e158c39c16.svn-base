package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the DATOS_RECL database table.
 * 
 */
@Entity
@Table(name="DATOS_RECL")
@NamedQuery(name="DatosRecl.findAll", query="SELECT d FROM DatosRecl d")
public class DatosRecl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUM_RE")
	private long numRe;

	@Column(name="EST_REC")
	private String estRec;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="NIS_RAD")
	private BigDecimal nisRad;

	@Column(name="NUM_REC")
	private BigDecimal numRec;

	@Column(name="NUM_SUM")
	private BigDecimal numSum;

	private String programa;

	private String usuario;

	//bi-directional one-to-one association to TrabpendRe
	@OneToOne
	@JoinColumn(name="NUM_RE")
	private TrabpendRe trabpendRe;

	public DatosRecl() {
	}

	public long getNumRe() {
		return this.numRe;
	}

	public void setNumRe(long numRe) {
		this.numRe = numRe;
	}

	public String getEstRec() {
		return this.estRec;
	}

	public void setEstRec(String estRec) {
		this.estRec = estRec;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getNisRad() {
		return this.nisRad;
	}

	public void setNisRad(BigDecimal nisRad) {
		this.nisRad = nisRad;
	}

	public BigDecimal getNumRec() {
		return this.numRec;
	}

	public void setNumRec(BigDecimal numRec) {
		this.numRec = numRec;
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

	public TrabpendRe getTrabpendRe() {
		return this.trabpendRe;
	}

	public void setTrabpendRe(TrabpendRe trabpendRe) {
		this.trabpendRe = trabpendRe;
	}

}