package com.indra.iopen.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the IOPEN_APPLICATION_STATUSES database table.
 *
 */
@Entity
@Table(name = "IOPEN_APPLICATION_STATUSES")
@NamedQuery(name = "IopenApplicationStatus.findAll", query = "SELECT i FROM IopenApplicationStatus i")
public class IopenApplicationStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "IOPEN_APPLICATION_STATUSES_CODAPPSTATECHANGES_GENERATOR", sequenceName = "COD_APPLICATION_STATUS")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IOPEN_APPLICATION_STATUSES_CODAPPSTATECHANGES_GENERATOR")
	// @GeneratedValue(
	// strategy = GenerationType.AUTO)
	@Column(name = "COD_APP_STATE_CHANGES")
	private long codAppStateChanges;

	@Column(name = "COD_APPLICATION")
	private String codApplication;

	@Column(name = "EST_STATUS")
	private String estStatus;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Column(name = "STATUS_BY")
	private String statusBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "STATUS_DATE")
	private Date statusDate;

	private String usuario;

	public IopenApplicationStatus() {
	}

	public long getCodAppStateChanges() {
		return this.codAppStateChanges;
	}

	public void setCodAppStateChanges(long codAppStateChanges) {
		this.codAppStateChanges = codAppStateChanges;
	}

	public String getCodApplication() {
		return this.codApplication;
	}

	public void setCodApplication(String codApplication) {
		this.codApplication = codApplication;
	}

	public String getEstStatus() {
		return this.estStatus;
	}

	public void setEstStatus(String estStatus) {
		this.estStatus = estStatus;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public String getStatusBy() {
		return this.statusBy;
	}

	public void setStatusBy(String statusBy) {
		this.statusBy = statusBy;
	}

	public Date getStatusDate() {
		return this.statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}