package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the IOPEN_DISTRICT_CONTACTS database table.
 * 
 */
@Entity
@Table(name="IOPEN_DISTRICT_CONTACTS")
@NamedQuery(name="IopenDistrictContact.findAll", query="SELECT i FROM IopenDistrictContact i")
public class IopenDistrictContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_DEPTO")
	private String codDepto;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="PHONE_CONTACT")
	private String phoneContact;

	private String programa;

	private String usuario;

	public IopenDistrictContact() {
	}

	public String getCodDepto() {
		return this.codDepto;
	}

	public void setCodDepto(String codDepto) {
		this.codDepto = codDepto;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public String getPhoneContact() {
		return this.phoneContact;
	}

	public void setPhoneContact(String phoneContact) {
		this.phoneContact = phoneContact;
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