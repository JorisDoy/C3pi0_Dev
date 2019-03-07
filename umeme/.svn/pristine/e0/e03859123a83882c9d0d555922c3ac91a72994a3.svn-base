package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the IMAGENES database table.
 * 
 */
@Entity
@Table(name="IMAGENES")
@NamedQuery(name="Imagene.findAll", query="SELECT i FROM Imagene i")
public class Imagene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="STATEMENT_ID")
	private long statementId;

	@Column(name="EST_IMAGEN")
	private String estImagen;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="ID_TIP_IMAGEN")
	private BigDecimal idTipImagen;

	@Column(name="IG_ID")
	private BigDecimal igId;

	private String programa;

	private String usuario;

	public Imagene() {
	}

	public long getStatementId() {
		return this.statementId;
	}

	public void setStatementId(long statementId) {
		this.statementId = statementId;
	}

	public String getEstImagen() {
		return this.estImagen;
	}

	public void setEstImagen(String estImagen) {
		this.estImagen = estImagen;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getIdTipImagen() {
		return this.idTipImagen;
	}

	public void setIdTipImagen(BigDecimal idTipImagen) {
		this.idTipImagen = idTipImagen;
	}

	public BigDecimal getIgId() {
		return this.igId;
	}

	public void setIgId(BigDecimal igId) {
		this.igId = igId;
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

}