package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ACO_SUM database table.
 * 
 */
@Entity
@Table(name="ACO_SUM")
@NamedQuery(name="AcoSum.findAll", query="SELECT a FROM AcoSum a")
public class AcoSum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NIS_RAD")
	private long nisRad;

	@Column(name="CGV_SUM")
	private String cgvSum;

	@Column(name="COD_CALLE")
	private BigDecimal codCalle;

	@Column(name="COD_DEPTO")
	private BigDecimal codDepto;

	@Column(name="COD_LOC")
	private BigDecimal codLoc;

	@Column(name="COD_MUNIC")
	private BigDecimal codMunic;

	@Column(name="COD_PROV")
	private BigDecimal codProv;

	private String duplicador;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name="H_ACTUAL")
	private Date hActual;

	private BigDecimal kwh;

	@Column(name="KWH_FACT")
	private BigDecimal kwhFact;

	private BigDecimal nif;

	@Column(name="NRO_ACOMETIDA")
	private BigDecimal nroAcometida;

	@Column(name="NUM_PUERTA")
	private BigDecimal numPuerta;

	@Column(name="POT_CONTRATADA")
	private BigDecimal potContratada;

	private String programa;

	@Column(name="REF_DIR")
	private String refDir;

	@Column(name="TIP_CLIENTE")
	private String tipCliente;

	private String usuario;

	public AcoSum() {
	}

	public long getNisRad() {
		return this.nisRad;
	}

	public void setNisRad(long nisRad) {
		this.nisRad = nisRad;
	}

	public String getCgvSum() {
		return this.cgvSum;
	}

	public void setCgvSum(String cgvSum) {
		this.cgvSum = cgvSum;
	}

	public BigDecimal getCodCalle() {
		return this.codCalle;
	}

	public void setCodCalle(BigDecimal codCalle) {
		this.codCalle = codCalle;
	}

	public BigDecimal getCodDepto() {
		return this.codDepto;
	}

	public void setCodDepto(BigDecimal codDepto) {
		this.codDepto = codDepto;
	}

	public BigDecimal getCodLoc() {
		return this.codLoc;
	}

	public void setCodLoc(BigDecimal codLoc) {
		this.codLoc = codLoc;
	}

	public BigDecimal getCodMunic() {
		return this.codMunic;
	}

	public void setCodMunic(BigDecimal codMunic) {
		this.codMunic = codMunic;
	}

	public BigDecimal getCodProv() {
		return this.codProv;
	}

	public void setCodProv(BigDecimal codProv) {
		this.codProv = codProv;
	}

	public String getDuplicador() {
		return this.duplicador;
	}

	public void setDuplicador(String duplicador) {
		this.duplicador = duplicador;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getHActual() {
		return this.hActual;
	}

	public void setHActual(Date hActual) {
		this.hActual = hActual;
	}

	public BigDecimal getKwh() {
		return this.kwh;
	}

	public void setKwh(BigDecimal kwh) {
		this.kwh = kwh;
	}

	public BigDecimal getKwhFact() {
		return this.kwhFact;
	}

	public void setKwhFact(BigDecimal kwhFact) {
		this.kwhFact = kwhFact;
	}

	public BigDecimal getNif() {
		return this.nif;
	}

	public void setNif(BigDecimal nif) {
		this.nif = nif;
	}

	public BigDecimal getNroAcometida() {
		return this.nroAcometida;
	}

	public void setNroAcometida(BigDecimal nroAcometida) {
		this.nroAcometida = nroAcometida;
	}

	public BigDecimal getNumPuerta() {
		return this.numPuerta;
	}

	public void setNumPuerta(BigDecimal numPuerta) {
		this.numPuerta = numPuerta;
	}

	public BigDecimal getPotContratada() {
		return this.potContratada;
	}

	public void setPotContratada(BigDecimal potContratada) {
		this.potContratada = potContratada;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getRefDir() {
		return this.refDir;
	}

	public void setRefDir(String refDir) {
		this.refDir = refDir;
	}

	public String getTipCliente() {
		return this.tipCliente;
	}

	public void setTipCliente(String tipCliente) {
		this.tipCliente = tipCliente;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}