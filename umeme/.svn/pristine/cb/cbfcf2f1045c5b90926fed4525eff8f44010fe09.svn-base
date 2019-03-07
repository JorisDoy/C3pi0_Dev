package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the IOPEN_UNICOM_CONTACTS database table.
 * 
 */
@Entity
@Table(name="IOPEN_UNICOM_CONTACTS")
@NamedQuery(name="IopenUnicomContact.findAll", query="SELECT i FROM IopenUnicomContact i")
public class IopenUnicomContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_UNICOM")
	private String codUnicom;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="PHONE_CONTACT")
	private String phoneContact;

	@Column(name="PHONE_CONTACT2")
	private String phoneContact2;

	@Column(name="PHYSICAL_ADDRESS")
	private String physicalAddress;

	private String programa;

	private String usuario;

	public IopenUnicomContact() {
	}

	public String getCodUnicom() {
		return this.codUnicom;
	}

	public void setCodUnicom(String codUnicom) {
		this.codUnicom = codUnicom;
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

	public String getPhoneContact2() {
		return this.phoneContact2;
	}

	public void setPhoneContact2(String phoneContact2) {
		this.phoneContact2 = phoneContact2;
	}

	public String getPhysicalAddress() {
		return this.physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
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