package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the IMAGENES_HTML database table.
 * 
 */
@Entity
@Table(name="IMAGENES_HTML")
@NamedQuery(name="ImagenesHtml.findAll", query="SELECT i FROM ImagenesHtml i")
public class ImagenesHtml implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_HTML")
	private long idHtml;

	@ManyToOne
	@JoinColumn(name="COD_CLI")
	private Cliente cliente;

	@Column(name="COD_DIRECCION")
	private BigDecimal codDireccion;

	@Column(name="EST_HTML")
	private String estHtml;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Lob
	@Column(name="HTML_DATA")
	private byte[] htmlData;

	@Column(name="IND_ORIGINAL")
	private BigDecimal indOriginal;

	private String programa;

	@Column(name="STATEMENT_ID")
	private BigDecimal statementId;

	private String usuario;

	public ImagenesHtml() {
	}

	public long getIdHtml() {
		return this.idHtml;
	}

	public void setIdHtml(long idHtml) {
		this.idHtml = idHtml;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getfActual() {
		return fActual;
	}

	public void setfActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getCodDireccion() {
		return this.codDireccion;
	}

	public void setCodDireccion(BigDecimal codDireccion) {
		this.codDireccion = codDireccion;
	}

	public String getEstHtml() {
		return this.estHtml;
	}

	public void setEstHtml(String estHtml) {
		this.estHtml = estHtml;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public byte[] getHtmlData() {
		return this.htmlData;
	}

	public void setHtmlData(byte[] htmlData) {
		this.htmlData = htmlData;
	}

	public BigDecimal getIndOriginal() {
		return this.indOriginal;
	}

	public void setIndOriginal(BigDecimal indOriginal) {
		this.indOriginal = indOriginal;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public BigDecimal getStatementId() {
		return this.statementId;
	}

	public void setStatementId(BigDecimal statementId) {
		this.statementId = statementId;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}