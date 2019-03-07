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
 * The persistent class for the APA_TIP_CARAC database table.
 *
 */
@Entity
@Table(name = "APA_TIP_CARAC")
@NamedQuery(name = "ApaTipCarac.findAll", query = "SELECT a FROM ApaTipCarac a")
public class ApaTipCarac implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ApaTipCaracPK id;

	@Column(name = "CTE_APA")
	private BigDecimal cteApa;

	private BigDecimal diametro;

	@Column(name = "DIMEN_CONEX")
	private BigDecimal dimenConex;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	private BigDecimal horas;

	@Column(name = "INT_PRIM")
	private String intPrim;

	@Column(name = "KVA_TRAN")
	private BigDecimal kvaTran;

	@Column(name = "MESES_CALIBRACION")
	private BigDecimal mesesCalibracion;

	@Column(name = "MESES_VERIFICACION")
	private BigDecimal mesesVerificacion;

	private BigDecimal pdida;

	private String programa;

	private Character[] propiedades;

	private String regulador;

	@Column(name = "TENS_TRAN")
	private BigDecimal tensTran;

	@Column(name = "TIP_FASE")
	private String tipFase;

	@Column(name = "TIP_INTENSIDAD")
	private String tipIntensidad;

	@Column(name = "TIP_MATERIAL")
	private String tipMaterial;

	@Column(name = "TIP_REL_TRAN")
	private String tipRelTran;

	@Column(name = "TIP_TENSION")
	private String tipTension;

	private String usuario;

	public ApaTipCarac() {
	}

	public ApaTipCaracPK getId() {
		return id;
	}

	public void setId(ApaTipCaracPK id) {
		this.id = id;
	}

	public BigDecimal getCteApa() {
		return cteApa;
	}

	public void setCteApa(BigDecimal cteApa) {
		this.cteApa = cteApa;
	}

	public BigDecimal getDiametro() {
		return diametro;
	}

	public void setDiametro(BigDecimal diametro) {
		this.diametro = diametro;
	}

	public BigDecimal getDimenConex() {
		return dimenConex;
	}

	public void setDimenConex(BigDecimal dimenConex) {
		this.dimenConex = dimenConex;
	}

	public Date getFActual() {
		return fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getHoras() {
		return horas;
	}

	public void setHoras(BigDecimal horas) {
		this.horas = horas;
	}

	public String getIntPrim() {
		return intPrim;
	}

	public void setIntPrim(String intPrim) {
		this.intPrim = intPrim;
	}

	public BigDecimal getKvaTran() {
		return kvaTran;
	}

	public void setKvaTran(BigDecimal kvaTran) {
		this.kvaTran = kvaTran;
	}

	public BigDecimal getMesesCalibracion() {
		return mesesCalibracion;
	}

	public void setMesesCalibracion(BigDecimal mesesCalibracion) {
		this.mesesCalibracion = mesesCalibracion;
	}

	public BigDecimal getMesesVerificacion() {
		return mesesVerificacion;
	}

	public void setMesesVerificacion(BigDecimal mesesVerificacion) {
		this.mesesVerificacion = mesesVerificacion;
	}

	public BigDecimal getPdida() {
		return pdida;
	}

	public void setPdida(BigDecimal pdida) {
		this.pdida = pdida;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public Character[] getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(Character[] propiedades) {
		this.propiedades = propiedades;
	}

	public String getRegulador() {
		return regulador;
	}

	public void setRegulador(String regulador) {
		this.regulador = regulador;
	}

	public BigDecimal getTensTran() {
		return tensTran;
	}

	public void setTensTran(BigDecimal tensTran) {
		this.tensTran = tensTran;
	}

	public String getTipFase() {
		return tipFase;
	}

	public void setTipFase(String tipFase) {
		this.tipFase = tipFase;
	}

	public String getTipIntensidad() {
		return tipIntensidad;
	}

	public void setTipIntensidad(String tipIntensidad) {
		this.tipIntensidad = tipIntensidad;
	}

	public String getTipMaterial() {
		return tipMaterial;
	}

	public void setTipMaterial(String tipMaterial) {
		this.tipMaterial = tipMaterial;
	}

	public String getTipRelTran() {
		return tipRelTran;
	}

	public void setTipRelTran(String tipRelTran) {
		this.tipRelTran = tipRelTran;
	}

	public String getTipTension() {
		return tipTension;
	}

	public void setTipTension(String tipTension) {
		this.tipTension = tipTension;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}