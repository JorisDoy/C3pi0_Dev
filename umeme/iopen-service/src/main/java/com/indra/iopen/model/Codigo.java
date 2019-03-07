package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CODIGOS database table.
 * 
 */
@Entity
@Table(name="CODIGOS")
@NamedQuery(name="Codigo.findAll", query="SELECT c FROM Codigo c")
public class Codigo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cod;

	@Column(name="DESC_COD")
	private String descCod;

	@Column(name="DESC_COD_DET")
	private String descCodDet;

	@Column(name="DESC_COD_SK")
	private String descCodSk;

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

	public Codigo() {
	}

	public String getCod() {
		return this.cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getDescCod() {
		return this.descCod;
	}

	public void setDescCod(String descCod) {
		this.descCod = descCod;
	}

	public String getDescCodDet() {
		return this.descCodDet;
	}

	public void setDescCodDet(String descCodDet) {
		this.descCodDet = descCodDet;
	}

	public String getDescCodSk() {
		return this.descCodSk;
	}

	public void setDescCodSk(String descCodSk) {
		this.descCodSk = descCodSk;
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