package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GI_OT database table.
 * 
 */
@Entity
@Table(name="GI_OT@IMS",schema="IMSPROD")
@NamedQuery(name="GiOt.findAll", query="SELECT g FROM GiOt g")
public class GiOt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NRO_OT")
	private long nroOt;

	private String descripcion;

	@Column(name="EST_OT")
	private BigDecimal estOt;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ALTA")
	private Date fAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="F_DESDE")
	private Date fDesde;

	@Temporal(TemporalType.DATE)
	@Column(name="F_HASTA")
	private Date fHasta;

	@Temporal(TemporalType.DATE)
	@Column(name="F_HASTA_ANULACION")
	private Date fHastaAnulacion;

	@Temporal(TemporalType.DATE)
	@Column(name="H_ACTUAL")
	private Date hActual;

	@Temporal(TemporalType.DATE)
	@Column(name="H_ALTA")
	private Date hAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="H_DESDE")
	private Date hDesde;

	@Temporal(TemporalType.DATE)
	@Column(name="H_HASTA")
	private Date hHasta;

	@Column(name="IND_AVISO")
	private String indAviso;

	@Column(name="IND_TRABAJO")
	private BigDecimal indTrabajo;

	@Column(name="NRO_AVISO")
	private BigDecimal nroAviso;

	@Column(name="NRO_CENTRO")
	private BigDecimal nroCentro;

	@Column(name="NRO_CMD")
	private BigDecimal nroCmd;

	@Column(name="NRO_INCIDENCIA")
	private BigDecimal nroIncidencia;

	@Column(name="NRO_INSTALACION")
	private BigDecimal nroInstalacion;

	@Column(name="NRO_MESA")
	private BigDecimal nroMesa;

	private String programa;

	@Column(name="TIP_BRIGADA")
	private BigDecimal tipBrigada;

	@Column(name="ULT_BRIGADA")
	private BigDecimal ultBrigada;

	private String usuario;

	public GiOt() {
	}

	public long getNroOt() {
		return this.nroOt;
	}

	public void setNroOt(long nroOt) {
		this.nroOt = nroOt;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getEstOt() {
		return this.estOt;
	}

	public void setEstOt(BigDecimal estOt) {
		this.estOt = estOt;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getFAlta() {
		return this.fAlta;
	}

	public void setFAlta(Date fAlta) {
		this.fAlta = fAlta;
	}

	public Date getFDesde() {
		return this.fDesde;
	}

	public void setFDesde(Date fDesde) {
		this.fDesde = fDesde;
	}

	public Date getFHasta() {
		return this.fHasta;
	}

	public void setFHasta(Date fHasta) {
		this.fHasta = fHasta;
	}

	public Date getFHastaAnulacion() {
		return this.fHastaAnulacion;
	}

	public void setFHastaAnulacion(Date fHastaAnulacion) {
		this.fHastaAnulacion = fHastaAnulacion;
	}

	public Date getHActual() {
		return this.hActual;
	}

	public void setHActual(Date hActual) {
		this.hActual = hActual;
	}

	public Date getHAlta() {
		return this.hAlta;
	}

	public void setHAlta(Date hAlta) {
		this.hAlta = hAlta;
	}

	public Date getHDesde() {
		return this.hDesde;
	}

	public void setHDesde(Date hDesde) {
		this.hDesde = hDesde;
	}

	public Date getHHasta() {
		return this.hHasta;
	}

	public void setHHasta(Date hHasta) {
		this.hHasta = hHasta;
	}

	public String getIndAviso() {
		return this.indAviso;
	}

	public void setIndAviso(String indAviso) {
		this.indAviso = indAviso;
	}

	public BigDecimal getIndTrabajo() {
		return this.indTrabajo;
	}

	public void setIndTrabajo(BigDecimal indTrabajo) {
		this.indTrabajo = indTrabajo;
	}

	public BigDecimal getNroAviso() {
		return this.nroAviso;
	}

	public void setNroAviso(BigDecimal nroAviso) {
		this.nroAviso = nroAviso;
	}

	public BigDecimal getNroCentro() {
		return this.nroCentro;
	}

	public void setNroCentro(BigDecimal nroCentro) {
		this.nroCentro = nroCentro;
	}

	public BigDecimal getNroCmd() {
		return this.nroCmd;
	}

	public void setNroCmd(BigDecimal nroCmd) {
		this.nroCmd = nroCmd;
	}

	public BigDecimal getNroIncidencia() {
		return this.nroIncidencia;
	}

	public void setNroIncidencia(BigDecimal nroIncidencia) {
		this.nroIncidencia = nroIncidencia;
	}

	public BigDecimal getNroInstalacion() {
		return this.nroInstalacion;
	}

	public void setNroInstalacion(BigDecimal nroInstalacion) {
		this.nroInstalacion = nroInstalacion;
	}

	public BigDecimal getNroMesa() {
		return this.nroMesa;
	}

	public void setNroMesa(BigDecimal nroMesa) {
		this.nroMesa = nroMesa;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public BigDecimal getTipBrigada() {
		return this.tipBrigada;
	}

	public void setTipBrigada(BigDecimal tipBrigada) {
		this.tipBrigada = tipBrigada;
	}

	public BigDecimal getUltBrigada() {
		return this.ultBrigada;
	}

	public void setUltBrigada(BigDecimal ultBrigada) {
		this.ultBrigada = ultBrigada;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}