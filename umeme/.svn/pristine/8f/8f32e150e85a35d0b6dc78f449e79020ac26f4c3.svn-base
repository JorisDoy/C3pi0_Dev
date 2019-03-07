package com.indra.iopen.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the IOPEN_APPLICATION_DOCS database table.
 *
 */
@Entity
@Table(name = "IOPEN_APPLICATION_DOCS")
@NamedQuery(name = "IopenApplicationDoc.findAll", query = "SELECT i FROM IopenApplicationDoc i")
public class IopenApplicationDoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IopenApplicationDocPK id;

	@Column(name = "CONTENT_TYPE")
	private String contentType;

	@Lob
	private byte[] doc;

	@Column(name = "DOC_DESC")
	private String docDesc;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	private String programa;

	@Column(name = "CONTENT_CLASS")
	private String contentClass;

	private String usuario;
	private String tac = null;
	// bi-directional many-to-one association to IopenApplication
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_APPLICATION", insertable = false, updatable = false)
	private IopenApplication iopenApplication;

	public String getTac() {
		return tac;
	}

	public void setTac(String tac) {
		this.tac = tac;
	}

	public IopenApplicationDoc() {
	}

	public String getContentType() {
		return contentType;
	}

	public byte[] getDoc() {
		return doc;
	}

	public String getDocDesc() {
		return docDesc;
	}

	public Date getFActual() {
		return fActual;
	}

	public IopenApplicationDocPK getId() {
		return id;
	}

	public IopenApplication getIopenApplication() {
		return iopenApplication;
	}

	public String getPrograma() {
		return programa;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setDoc(byte[] doc) {
		this.doc = doc;
	}

	public void setDocDesc(String docDesc) {
		this.docDesc = docDesc;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public void setId(IopenApplicationDocPK id) {
		this.id = id;
	}

	public void setIopenApplication(IopenApplication iopenApplication) {
		this.iopenApplication = iopenApplication;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContentClass() {
		return contentClass;
	}

	public void setContentClass(String contentClass) {
		this.contentClass = contentClass;
	}

}