package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TIPOS database table.
 * 
 */
@Entity
@Table(name="TIPOS")
@NamedQuery(name="Tipo.findAll", query="SELECT t FROM Tipo t")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String tipo;

	@Column(name="DESC_TIPO")
	private String descTipo;

	@Column(name="DESC_TIPO_DET")
	private String descTipoDet;

	@Column(name="DESC_TIPO_SK")
	private String descTipoSk;

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

	public Tipo() {
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescTipo() {
		return this.descTipo;
	}

	public void setDescTipo(String descTipo) {
		this.descTipo = descTipo;
	}

	public String getDescTipoDet() {
		return this.descTipoDet;
	}

	public void setDescTipoDet(String descTipoDet) {
		this.descTipoDet = descTipoDet;
	}

	public String getDescTipoSk() {
		return this.descTipoSk;
	}

	public void setDescTipoSk(String descTipoSk) {
		this.descTipoSk = descTipoSk;
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