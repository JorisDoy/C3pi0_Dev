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
 * The persistent class for the PRESUPUESTOS_EXPED database table.
 * 
 */
@Entity
@Table(name = "PRESUPUESTOS_EXPED")
@NamedQuery(name = "PresupuestosExped.findAll", query = "SELECT p FROM PresupuestosExped p")
public class PresupuestosExped implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PresupuestosExpedPK id;

	private BigDecimal cantidad;

	private BigDecimal coste;

	@Column(name = "DESC_CATEGORIA")
	private String descCategoria;

	@Column(name = "DESC_CONCEPTO_PRES")
	private String descConceptoPres;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_ENVIO")
	private Date fechaEnvio;

	@Column(name = "IND_BG")
	private BigDecimal indBg;

	@Column(name = "MODELO_ECONOMICO")
	private String modeloEconomico;

	private String programa;

	@Column(name = "TIP_MOV")
	private String tipMov;

	private String usuario;

	public PresupuestosExped() {
		this.fActual = new Date();
		this.modeloEconomico = " ";
		this.usuario = "IOPEN";
		this.programa = "IOPEN";

	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public BigDecimal getCoste() {
		return this.coste;
	}

	public String getDescCategoria() {
		return this.descCategoria;
	}

	public String getDescConceptoPres() {
		return this.descConceptoPres;
	}

	public String getEstado() {
		return this.estado;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public Date getFechaEnvio() {
		return this.fechaEnvio;
	}

	public PresupuestosExpedPK getId() {
		return this.id;
	}

	public BigDecimal getIndBg() {
		return this.indBg;
	}

	public String getModeloEconomico() {
		return this.modeloEconomico;
	}

	public String getPrograma() {
		return this.programa;
	}

	public String getTipMov() {
		return this.tipMov;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public void setCoste(BigDecimal coste) {
		this.coste = coste;
	}

	public void setDescCategoria(String descCategoria) {
		this.descCategoria = descCategoria;
	}

	public void setDescConceptoPres(String descConceptoPres) {
		this.descConceptoPres = descConceptoPres;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public void setId(PresupuestosExpedPK id) {
		this.id = id;
	}

	public void setIndBg(BigDecimal indBg) {
		this.indBg = indBg;
	}

	public void setModeloEconomico(String modeloEconomico) {
		this.modeloEconomico = modeloEconomico;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public void setTipMov(String tipMov) {
		this.tipMov = tipMov;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PresupuestosExped other = (PresupuestosExped) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}