package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ESTADOS database table.
 * 
 */
@Entity
@Table(name="ESTADOS")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String estado;

	@Column(name="DESC_EST")
	private String descEst;

	@Column(name="DESC_EST_DET")
	private String descEstDet;

	@Column(name="DESC_EST_SK")
	private String descEstSk;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="IND_IN_USE")
	private BigDecimal indInUse;

	private String programa;

	@Column(name="TIP_PRODUCTO")
	private String tipProducto;

	@Column(name="TIP_SERV")
	private String tipServ;

	private String usuario;

	public Estado() {
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescEst() {
		return this.descEst;
	}

	public void setDescEst(String descEst) {
		this.descEst = descEst;
	}

	public String getDescEstDet() {
		return this.descEstDet;
	}

	public void setDescEstDet(String descEstDet) {
		this.descEstDet = descEstDet;
	}

	public String getDescEstSk() {
		return this.descEstSk;
	}

	public void setDescEstSk(String descEstSk) {
		this.descEstSk = descEstSk;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getIndInUse() {
		return this.indInUse;
	}

	public void setIndInUse(BigDecimal indInUse) {
		this.indInUse = indInUse;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getTipProducto() {
		return this.tipProducto;
	}

	public void setTipProducto(String tipProducto) {
		this.tipProducto = tipProducto;
	}

	public String getTipServ() {
		return this.tipServ;
	}

	public void setTipServ(String tipServ) {
		this.tipServ = tipServ;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}