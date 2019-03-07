package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the IOPEN_APPLICATION_MESSAGES database table.
 *
 */
@Entity
@Table(name = "IOPEN_APPLICATION_MESSAGES")
@NamedQuery(name = "IopenApplicationMessage.findAll", query = "SELECT i FROM IopenApplicationMessage i")
public class IopenApplicationMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IopenApplicationMessagePK id;

	@Column(name = "EXPEDIENTE_ESTADO")
	private String expedienteEstado;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Column(name = "MESSAGE_SENT")
	private Boolean messageSent;

	private String usuario;

	public IopenApplicationMessage() {
	}

	public IopenApplicationMessagePK getId() {
		return id;
	}

	public void setId(IopenApplicationMessagePK id) {
		this.id = id;
	}

	public String getExpedienteEstado() {
		return expedienteEstado;
	}

	public void setExpedienteEstado(String expedienteEstado) {
		this.expedienteEstado = expedienteEstado;
	}

	public Date getFActual() {
		return fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Boolean getMessageSent() {
		return messageSent;
	}

	public void setMessageSent(Boolean messageSent) {
		this.messageSent = messageSent;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}