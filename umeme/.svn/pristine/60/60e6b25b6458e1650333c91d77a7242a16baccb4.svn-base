package com.indra.iopen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the SUM_EXP database table.
 * 
 */
@Entity
@Table(name = "SUM_EXP")
@NamedQuery(name = "SumExp.findAll", query = "SELECT s FROM SumExp s")
public class SumExp implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SumExpPK id;

	@Column(name = "CANT_SUM")
	private BigDecimal cantSum;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Column(name = "POT_SOLIC")
	private BigDecimal potSolic;

	private String programa;

	@Column(name = "SEC_FINCA")
	private BigDecimal secFinca;

	@Column(name = "TIP_INSTALACION")
	private String tipInstalacion;

	private String usuario;

	public SumExp() {
		this.fActual = new Date();
		this.potSolic = new BigDecimal(0);
		this.secFinca = new BigDecimal(0);
		
		this.usuario = "IOPEN";
		this.programa = "IOPEN";
	}

	public BigDecimal getCantSum() {
		return this.cantSum;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public SumExpPK getId() {
		return this.id;
	}

	public BigDecimal getPotSolic() {
		return this.potSolic;
	}

	public String getPrograma() {
		return this.programa;
	}

	public BigDecimal getSecFinca() {
		return this.secFinca;
	}

	public String getTipInstalacion() {
		return this.tipInstalacion;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setCantSum(BigDecimal cantSum) {
		this.cantSum = cantSum;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public void setId(SumExpPK id) {
		this.id = id;
	}

	public void setPotSolic(BigDecimal potSolic) {
		this.potSolic = potSolic;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public void setSecFinca(BigDecimal secFinca) {
		this.secFinca = secFinca;
	}

	public void setTipInstalacion(String tipInstalacion) {
		this.tipInstalacion = tipInstalacion;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}