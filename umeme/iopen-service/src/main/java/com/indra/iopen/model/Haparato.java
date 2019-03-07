package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the HAPARATOS database table.
 * 
 */
@Entity
@Table(name="HAPARATOS")
@NamedQuery(name="Haparato.findAll", query="SELECT h FROM Haparato h")
public class Haparato implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HaparatoPK id;

	@Column(name="COD_ALMACEN")
	private BigDecimal codAlmacen;

	@Column(name="EST_APA")
	private String estApa;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="NIF_APA")
	private BigDecimal nifApa;

	@Column(name="NUM_LOTE")
	private String numLote;

	@Column(name="NUM_PRECIN")
	private String numPrecin;

	@Column(name="NUM_SUM")
	private BigDecimal numSum;

	private String programa;

	@Column(name="SEC_PM")
	private BigDecimal secPm;

	private String usuario;

	public Haparato() {
	}

	public HaparatoPK getId() {
		return this.id;
	}

	public void setId(HaparatoPK id) {
		this.id = id;
	}

	public BigDecimal getCodAlmacen() {
		return this.codAlmacen;
	}

	public void setCodAlmacen(BigDecimal codAlmacen) {
		this.codAlmacen = codAlmacen;
	}

	public String getEstApa() {
		return this.estApa;
	}

	public void setEstApa(String estApa) {
		this.estApa = estApa;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getNifApa() {
		return this.nifApa;
	}

	public void setNifApa(BigDecimal nifApa) {
		this.nifApa = nifApa;
	}

	public String getNumLote() {
		return this.numLote;
	}

	public void setNumLote(String numLote) {
		this.numLote = numLote;
	}

	public String getNumPrecin() {
		return this.numPrecin;
	}

	public void setNumPrecin(String numPrecin) {
		this.numPrecin = numPrecin;
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

	public BigDecimal getSecPm() {
		return this.secPm;
	}

	public void setSecPm(BigDecimal secPm) {
		this.secPm = secPm;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}