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
 * The persistent class for the CLIENTE_IDENTIFICADOR database table.
 * 
 */
@Entity
@Table(name = "CLIENTE_IDENTIFICADOR")
@NamedQuery(name = "ClienteIdentificador.findAll", query = "SELECT c FROM ClienteIdentificador c")
public class ClienteIdentificador implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClienteIdentificadorPK id;

	@Column(name = "COD_DEPTO", nullable = false, precision = 3)
	private BigDecimal codDepto;

	@Column(name = "COD_PROV", nullable = false, precision = 3)
	private BigDecimal codProv;

	@Column(name = "DOC_ID", nullable = false, length = 24)
	private String docId;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL", nullable = false)
	private Date fActual;

	@Column(name = "IND_PRIMARIO", nullable = false, precision = 2)
	private BigDecimal indPrimario;

	@Column(nullable = false, length = 15)
	private String programa;

	@Column(name = "TIP_DOC", nullable = false, length = 5)
	private String tipDoc;

	@Column(nullable = false, length = 30)
	private String usuario;

	public ClienteIdentificador() {
		this.fActual = new Date();
		this.usuario = "IOPEN";
		this.programa = "IOPEN";

	}

	public BigDecimal getCodDepto() {
		return this.codDepto;
	}

	public BigDecimal getCodProv() {
		return this.codProv;
	}

	public String getDocId() {
		return this.docId;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public ClienteIdentificadorPK getId() {
		return this.id;
	}

	public BigDecimal getIndPrimario() {
		return this.indPrimario;
	}

	public String getPrograma() {
		return this.programa;
	}

	public String getTipDoc() {
		return this.tipDoc;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setCodDepto(BigDecimal codDepto) {
		this.codDepto = codDepto;
	}

	public void setCodProv(BigDecimal codProv) {
		this.codProv = codProv;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public void setId(ClienteIdentificadorPK id) {
		this.id = id;
	}

	public void setIndPrimario(BigDecimal indPrimario) {
		this.indPrimario = indPrimario;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public void setTipDoc(String tipDoc) {
		this.tipDoc = tipDoc;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}